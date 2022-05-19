package ng.groove.mediaplayer

import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.RequestManager
import com.google.android.material.snackbar.Snackbar
import ng.groove.mediaplayer.adapters.SwipeSongAdapter
import ng.groove.mediaplayer.data.entities.Song
import ng.groove.mediaplayer.databinding.ActivityMainBinding
import ng.groove.mediaplayer.exoplayer.isPlaying
import ng.groove.mediaplayer.exoplayer.toSong
import ng.groove.mediaplayer.utils.InjectorUtils
import ng.groove.mediaplayer.utils.Status
import org.koin.android.ext.android.inject


class MediaPlayerMainActivity : AppCompatActivity() {

    private val mainViewModel: MediaPlayerMainViewModel by viewModels<MediaPlayerMainViewModel> {
        InjectorUtils.provideMainActivityViewModel(this)
    }


     val swipeSongAdapter: SwipeSongAdapter = SwipeSongAdapter()


    //lateinit var glide: RequestManager

    private var curPlayingSong: Song? = null

    private var playbackState: PlaybackStateCompat? = null


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeToObservers()

        binding.vpSong.adapter = swipeSongAdapter

        binding.vpSong.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(playbackState?.isPlaying == true) {
                    mainViewModel.playOrToggleSong(swipeSongAdapter.songs[position])
                } else {
                    curPlayingSong = swipeSongAdapter.songs[position]
                }
            }
        })

        binding.imageViewPlayPause.setOnClickListener {
            curPlayingSong?.let {
                mainViewModel.playOrToggleSong(it, true)
            }
        }

////clicking mini player to got to main player
//        swipeSongAdapter.setItemClickListener {
//            navHostFragment.findNavController().navigate(
//                R.id.globalActionToSongFragment
//            )
//        }


//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun addFragment(fragment: Fragment, bundle: Bundle?) {
        val fragmentManager: FragmentManager =
            this@MediaPlayerMainActivity.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (bundle != null) {
            fragment.arguments = bundle
        }
        fragmentTransaction.add(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack("")
        fragmentTransaction.commit()
    }
    fun removeFragment(fragment: Fragment, bundle: Bundle?) {
        supportFragmentManager.apply {
            beginTransaction().remove(fragment).commit()
            popBackStack()
        //clear all items added to backstack//  popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
    private fun switchViewPagerToCurrentSong(song: Song) {
        val newItemIndex = swipeSongAdapter.songs.indexOf(song)
        if (newItemIndex != -1) {
            binding.vpSong.currentItem = newItemIndex
            curPlayingSong = song
        }
    }
    private fun subscribeToObservers() {
        mainViewModel.mediaItems.observe(this) {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { songs ->
                            swipeSongAdapter.songs = songs
                            if (songs.isNotEmpty()) {
//                                glide.load((curPlayingSong ?: songs[0]).imageUrl)
//                                    .into(trackCover)
                            }
                            switchViewPagerToCurrentSong(curPlayingSong ?: return@observe)
                        }
                    }
                    Status.ERROR -> Unit
                    Status.LOADING -> Unit
                }
            }
        }
        mainViewModel.curPlayingSong.observe(this) {
            if (it == null) return@observe

            curPlayingSong = it.toSong()
//            glide.load(curPlayingSong?.imageUrl).into(binding.trackCover)
            switchViewPagerToCurrentSong(curPlayingSong ?: return@observe)
        }
        mainViewModel.playbackState.observe(this) {
            playbackState = it
            binding.imageViewPlayPause.setImageResource(
                if (playbackState?.isPlaying == true) R.drawable.icon_pause else R.drawable.icon_play
            )
        }
        mainViewModel.isConnected.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.ERROR -> Snackbar.make(
                        binding.imageViewPlayPause,
                        result.message ?: "An unknown error occured",
                        Snackbar.LENGTH_LONG
                    ).show()
                    else -> Unit
                }
            }
        }
        mainViewModel.networkError.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.ERROR -> Snackbar.make(
                        binding.imageViewPlayPause,
                        result.message ?: "An unknown error occured",
                        Snackbar.LENGTH_LONG
                    ).show()
                    else -> Unit
                }
            }
        }
    }
}