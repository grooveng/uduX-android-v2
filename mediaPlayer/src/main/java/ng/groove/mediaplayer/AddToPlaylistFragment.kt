package ng.groove.mediaplayer

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ng.groove.mediaplayer.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddToPlaylistFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val dialog = dialog as BottomSheetDialog
//        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.RED))
        container?.rootView?.setBackgroundColor(Color.TRANSPARENT)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        val recyclerItems = binding.recyclerViewPlaylistItems
        val recyclerAdapter = PlaylistItemAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerItems.layoutManager = layoutManager
        recyclerItems.adapter = recyclerAdapter
        binding.AddPlaylistMainLayout.background.alpha = 200
        binding.backButton.setOnClickListener {
            (activity as MainActivity).removeFragment(
                AddToPlaylistFragment(),
                null
            )
        }
        binding.sortLinearLayout.setOnClickListener {
            (activity as MainActivity).addFragment(SortDialogFragment(), null)
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // in here you can do logic when backPress is clicked
                    (activity as MainActivity).removeFragment(
                        AddToPlaylistFragment(),
                        null
                    )
                }
            })
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val sheetContainer = requireView().parent as? ViewGroup ?: return
        sheetContainer.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
   }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}