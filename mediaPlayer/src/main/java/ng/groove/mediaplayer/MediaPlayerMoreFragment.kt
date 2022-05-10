package ng.groove.mediaplayer

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import ng.groove.mediaplayer.databinding.FragmentMediaPlayerMoreBinding
import ng.groove.mediaplayer.databinding.FragmentSecondBinding


class MediaPlayerMoreFragment : Fragment() {

    private var _binding: FragmentMediaPlayerMoreBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        container?.rootView?.setBackgroundColor(Color.TRANSPARENT)
        _binding = FragmentMediaPlayerMoreBinding.inflate(inflater, container, false)

        binding.mediaPlayerMoreLayout.background.alpha = 200
        binding.backButton.setOnClickListener {
            (activity as MainActivity).removeFragment(
                MediaPlayerMoreFragment(),
                null
            )
        }
        binding.cancelTextView.setOnClickListener {
            (activity as MainActivity).removeFragment(
                MediaPlayerMoreFragment(),
                null
            )
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // in here you can do logic when backPress is clicked
                    (activity as MainActivity).removeFragment(
                        MediaPlayerMoreFragment(),
                        null
                    )
                }
            })

        return binding.root
    }

}