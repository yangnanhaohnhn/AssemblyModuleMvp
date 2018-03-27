package com.jdan.yn.common.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.jdan.yn.common.presenter.BasePresenter
import com.jdan.yn.common.utils.ToastUtils
import com.orhanobut.logger.Logger

/**
 * Created by Cxx on 2018/3/26.
 */
abstract class BaseFragment<FP : BasePresenter> : Fragment(), View.OnClickListener {
    protected var mvpPresenter: FP? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpPresenter = createFPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(viewId, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData(savedInstanceState)
    }

    protected abstract fun createFPresenter(): FP

    protected abstract val viewId: Int

    protected abstract fun initData(savedInstanceState: Bundle?)
    fun hideLoading() {
        dismissLoading()
    }

    fun isHide(view: View, hide: Boolean) {
        if (hide)
            view.visibility = View.GONE
        else
            view.visibility = View.VISIBLE
    }

    val activityContext: Activity
        get() = activity

    fun showLoading() {
        loading()
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
        ToastUtils.show(activityContext, msg)
    }

    fun toastShow(msg: Int) {
        toastShow(getString(msg))
    }

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
        setText(view, getString(title))
    }

    override fun onClick(v: View?) {
    }

    override fun onDestroy() {
        if (mvpPresenter != null) {
            mvpPresenter!!.detachView()
        }
        super.onDestroy()
    }
}