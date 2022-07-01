package com.leoleo2.flexboxkotlinsample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.leoleo2.flexboxkotlinsample.R
import com.leoleo2.flexboxkotlinsample.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        val flexboxLayoutManager = FlexboxLayoutManager(requireContext()).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }
        binding.recyclerview.apply {
            layoutManager = flexboxLayoutManager
            adapter = MyAdapter(imageIds)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    internal class MyAdapter(private val data: List<Int>) : RecyclerView.Adapter<VH>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val rootView =
                LayoutInflater.from(parent.context).inflate(R.layout.viewholder, parent, false)
            return VH(rootView)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.bindTo(data[position])
        }
    }

    internal class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(@DrawableRes drawableRes: Int) {
            val imageview = itemView.findViewById<ImageView>(R.id.imageview)
            imageview.setImageResource(drawableRes)
            val lp = imageview.layoutParams
            if (lp is FlexboxLayoutManager.LayoutParams) {
                lp.flexGrow = 1f
            }
        }
    }

    private val imageIds = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5,
        R.drawable.cat_6,
        R.drawable.cat_7,
        R.drawable.cat_8,
        R.drawable.cat_9,
        R.drawable.cat_10,
        R.drawable.cat_11,
        R.drawable.cat_12,
        R.drawable.cat_13,
        R.drawable.cat_14,
        R.drawable.cat_15,
        R.drawable.cat_16,
        R.drawable.cat_17,
        R.drawable.cat_18,
        R.drawable.cat_19
    )
}