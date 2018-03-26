package com.jdan.yn.common.presenter.impl

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


import com.jdan.yn.common.model.BaseModel
import com.jdan.yn.common.presenter.BasePresenter
import com.jdan.yn.common.view.BaseView
import com.jdan.yn.common.widget.callback.ApiCallback
import com.jdan.yn.common.widget.callback.SubscriberCallBack
import com.jdan.yn.common.widget.retrofit.ApiStores
import com.jdan.yn.common.widget.retrofit.AppClient

import java.util.ArrayList
import java.util.HashMap

import okhttp3.MediaType
import okhttp3.RequestBody
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription


/**
 * 公共的BasePresenterImpl
 * Created by Nan&Cxx on 2017/7/13.
 */
open class BasePresenterImpl<V : BaseView, M : BaseModel> : BasePresenter {
    protected var mvpView: V? = null
    protected var mvpModel: M? = null


    override fun attachView(view: BaseView, model: BaseModel) {
        mvpView = view as V
        mvpModel = model as M
    }

    override fun detachView() {
        this.mvpView = null
        mvpModel!!.detachObservable()
    }

    //
}
