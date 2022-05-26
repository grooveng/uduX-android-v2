package ng.groove.mediaplayer

import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ng.groove.mediaplayer.data.entities.Song
import ng.groove.mediaplayer.databinding.FragmentMediaPlayerBinding
import ng.groove.mediaplayer.exoplayer.isPlaying
import ng.groove.mediaplayer.exoplayer.toSong
import ng.groove.mediaplayer.utils.InjectorUtils
import ng.groove.mediaplayer.utils.Status
import java.lang.System.load
import java.text.SimpleDateFormat
import java.util.*


class MediaPlayerFragment : Fragment() {

    private var _binding: FragmentMediaPlayerBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel by activityViewModels<MediaPlayerMainViewModel> {
        InjectorUtils.provideMainActivityViewModel(requireContext())
    }
    private val songViewModel by viewModels<SongViewModel> {
        InjectorUtils.provideSongViewModel(requireContext())
    }
    private var curPlayingSong: Song? = null
    private var playbackState: PlaybackStateCompat? = null
    private var shouldUpdateSeekbar = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMediaPlayerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
        binding.addButton.setOnClickListener {
            (activity as MediaPlayerMainActivity).addFragment(AddToPlaylistFragment(), null)
        }
        binding.moreButton.setOnClickListener {
            (activity as MediaPlayerMainActivity).addFragment(MediaPlayerMoreFragment(), null)
        }
        binding.playPauseButton.setOnClickListener {
            curPlayingSong?.let {
                mainViewModel.playOrToggleSong(it, true)
            }
        }

        binding.seekBarPlayback.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) {
                    setCurPlayerTimeToTextView(progress.toLong())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                shouldUpdateSeekbar = false
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.let {
                    mainViewModel.seekTo(it.progress.toLong())
                    shouldUpdateSeekbar = true
                }
            }
        })

        binding.previousButton.setOnClickListener {
            mainViewModel.skipToPreviousSong()
        }

        binding.nextButton.setOnClickListener {
            mainViewModel.skipToNextSong()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun updateTitleAndSongImage(song: Song) {
        binding.textViewTrackTitle.text = song.title
        binding.textViewArtist.text = song.subtitle
        Glide.with(requireContext()).load(song.imageUrl).into(binding.imageViewTrackCover)
    }

    private fun subscribeToObservers() {
        mainViewModel.mediaItems.observe(viewLifecycleOwner) {
            it?.let { result ->
                when(result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { songs ->
                            if(curPlayingSong == null && songs.isNotEmpty()) {
                                curPlayingSong = songs[0]
                                updateTitleAndSongImage(songs[0])
                            }
                        }
                    }
                    else -> Unit
                }
            }
        }
        mainViewModel.curPlayingSong.observe(viewLifecycleOwner) {
            if(it == null) return@observe
            curPlayingSong = it.toSong()
            updateTitleAndSongImage(curPlayingSong!!)
        }
        mainViewModel.playbackState.observe(viewLifecycleOwner) {
            playbackState = it
            binding.playPauseButton.setImageResource(
                if(playbackState?.isPlaying == true) R.drawable.icon_pause else R.drawable.icon_play
            )
            binding.seekBarPlayback.progress = it?.position?.toInt() ?: 0
        }
        songViewModel.curPlayerPosition.observe(viewLifecycleOwner) {
            if(shouldUpdateSeekbar) {
                binding.seekBarPlayback.progress = it.toInt()
                setCurPlayerTimeToTextView(it)
            }
        }
        songViewModel.curSongDuration.observe(viewLifecycleOwner) {
            binding.seekBarPlayback.max = it.toInt()
            val dateFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
            val duration: String = dateFormat.format(it).toString()
            binding.textViewDuration.text = duration

        }
    }

    private fun setCurPlayerTimeToTextView(ms: Long) {
        val dateFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
        binding.textViewCurrentTime.text = dateFormat.format(ms)
    }

}