package com.jdan.yn.common.view

import android.app.Activity

/**
 * 公共的view
 * Created by Nan&Cxx on 2017/7/13.
 */
interface BaseView {
    val activityContext: Activity

    fun showLoading()

    fun hideLoading()

    fun toastShow(msg: String)

    fun toastShow(msg: Int)

    /**
     * 返回
     */
    fun onBackPress()
}
