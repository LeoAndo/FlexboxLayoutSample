package com.leoleo2.flexboxkotlinsample.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.flexbox.FlexboxLayout
import com.leoleo2.flexboxkotlinsample.R
import com.leoleo2.flexboxkotlinsample.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)
        val childView = binding.flexboxLayout.getChildAt(0)
        val lp = childView.layoutParams as FlexboxLayout.LayoutParams
        lp.order = -1
        lp.flexGrow = 2f
        childView.layoutParams = lp
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}