package ng.groove.mediaplayer

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import ng.groove.mediaplayer.databinding.FragmentMediaPlayerMoreBinding
import ng.groove.mediaplayer.databinding.FragmentSecondBinding
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
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = FragmentSortDialogBinding.inflate(inflater, container, false)
        binding.cancelTextView.setOnClickListener {
            (activity as MainActivity).removeFragment(
                SortDialogFragment(),
                null
            )
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // in here you can do logic when backPress is clicked
                    (activity as MainActivity).removeFragment(
                        SortDialogFragment(),
                        null
                    )
                }
            })

        return binding.root
    }


}