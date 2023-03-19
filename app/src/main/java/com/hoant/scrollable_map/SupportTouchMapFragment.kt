package com.hoant.scrollable_map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment

class SupportTouchMapFragment: SupportMapFragment() {
    private lateinit var touchView: TouchableWrapper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout: View = super.onCreateView(inflater, container, savedInstanceState)
        touchView = TouchableWrapper(requireActivity())
        touchView.addView(layout)
        return touchView
    }

    fun setTouchCallback(touchCallback: TouchableWrapper.TouchCallback?) {
        touchView.touchCallback = touchCallback
    }
}