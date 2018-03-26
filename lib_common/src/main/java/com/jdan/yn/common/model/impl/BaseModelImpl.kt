package com.jdan.yn.common.model.impl

import com.jdan.yn.common.model.BaseModel
import com.jdan.yn.common.widget.callback.ApiCallback
import com.jdan.yn.common.widget.callback.SubscriberCallBack
import com.jdan.yn.common.widget.retrofit.ApiStores
import com.jdan.yn.common.widget.retrofit.AppClient

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by Cxx on 2018/3/23.
 */

open class BaseModelImpl : BaseModel {
    private var mCompositeSubscription: CompositeSubscription? = null
    protected var apiStores = AppClient.retrofit()!!.create(ApiStores::class.java)

    override fun detachObservable() {
        unSubscribe()
    }

    /**
     * RxJava取消注册,以避免内存泄漏
     */
    private fun unSubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription!!.hasSubscriptions()) {
            mCompositeSubscription!!.unsubscribe()
        }
    }

    /**
     * 添加subscription
     *
     * @param observable
     * @param apiCallback
     */
    fun addSubscription(observable: Observable<*>, apiCallback: ApiCallback<*>) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = CompositeSubscription()
        }
        mCompositeSubscription!!.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(SubscriberCallBack<Any>(apiCallback as ApiCallback<Any>)))
    }
}
