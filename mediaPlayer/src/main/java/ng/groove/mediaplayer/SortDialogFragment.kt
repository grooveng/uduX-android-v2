package ng.groove.mediaplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import ng.groove.mediaplayer.databinding.FragmentSortDialogBinding


class SortDialogFragment : Fragment() {
    private var _binding: FragmentSortDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSortDialogBinding.inflate(inflater, container, false)
        binding.cancelTextView.setOnClickListener {
            (activity as MediaPlayerMainActivity).removeFragment(
                SortDialogFragment(),
                null
            )
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // in here you can do logic when backPress is clicked
                    (activity as MediaPlayerMainActivity).removeFragment(
                        SortDialogFragment(),
                        null
                    )
                }
            })

        return binding.root
    }


}