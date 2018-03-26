package com.jdan.yn.common.widget.callback


import retrofit2.adapter.rxjava.HttpException
import rx.Subscriber

/**
 * 回调
 * @param <M>
</M> */
class SubscriberCallBack<M>(val apiCallback: ApiCallback<M>) : Subscriber<M>() {

    override fun onCompleted() {
        apiCallback.onCompleted()
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is HttpException) {
//httpException.response().errorBody().string()
            val code = e.code()
            var msg = e.message
            if (code == 504) {
                msg = "网络不给力"
            }
            apiCallback.onFailure(code, msg!!)
        } else {
            apiCallback.onFailure(0, e.message!!)
        }
        apiCallback.onCompleted()
    }

    override fun onNext(m: M) {
        apiCallback.onSuccess(m)
    }
}
