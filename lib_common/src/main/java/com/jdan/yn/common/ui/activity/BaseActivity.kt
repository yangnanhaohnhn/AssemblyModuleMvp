package com.jdan.yn.common.ui.activity

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


import com.jdan.yn.common.presenter.BasePresenter
import com.jdan.yn.common.utils.ToastUtils
import com.orhanobut.logger.Logger

import java.util.HashMap


/**
 * Created by Nan&Cxx on 2017/7/13.
 */
abstract class BaseActivity<P : BasePresenter> : AppCompatActivity(), View.OnClickListener {

    protected var mvpPresenter: P? = null
    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            handleMsg(msg)
        }
    }

    val activityContext: Activity
        get() = this

    protected abstract val viewId: Int

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewId)
        mvpPresenter = createPresenter()
        setStatusBarVisible(true)
        initData(savedInstanceState)
    }

    /**
     * 显示和隐藏状态栏
     *
     * @param show
     */
    fun setStatusBarVisible(show: Boolean) {
        if (show) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    fun isHide(view: View, hide: Boolean) {
        if (hide)
            view.visibility = View.GONE
        else
            view.visibility = View.VISIBLE
    }

    fun showLoading() {
        loading()
    }

    fun hideLoading() {
        dismissLoading()
    }

    /**
     * loading...
     */
    fun loading() {
        Logger.e("loading...")
    }


    /**
     * 关闭loading...
     */
    fun dismissLoading() {
        Logger.e("dismissLoading...")
    }

    fun toastShow(msg: String) {
        ToastUtils.show(this, msg)
    }

    fun toastShow(msg: Int) {
        toastShow(getString(msg))
    }

    override fun onClick(v: View) {}

    fun setText(view: View, title: String) {
        if (view is TextView) {
            view.text = title
        } else if (view is Button) {
            view.text = title
        } else if (view is EditText) {
            view.setText(title)
        }
    }

    fun setText(view: View, title: Int) {
        setText(view,getString(title))
    }

    fun handleMsg(msg: Message) {}

    fun onBackPress() {
        finish()
    }

    override fun getResources(): Resources {
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }

    protected abstract fun createPresenter(): P

    protected abstract fun initData(savedInstanceState: Bundle?)


    override fun onDestroy() {
        if (mvpPresenter != null) {
            mvpPresenter!!.detachView()
        }
        super.onDestroy()
    }
}
