package com.hoant.scrollable_map

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout


class TouchableWrapper: FrameLayout  {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    var touchCallback: TouchCallback? = null

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                touchCallback?.onTouch(ev)
            }
            MotionEvent.ACTION_CANCEL,
            MotionEvent.ACTION_UP -> {
                touchCallback?.onTouch(ev)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    interface TouchCallback {
        fun onTouch(e: MotionEvent?)
    }
}