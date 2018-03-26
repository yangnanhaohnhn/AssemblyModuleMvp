package com.jdan.yn.common.widget.callback


/**
 *
 * @param <M>
</M> */
interface ApiCallback<M> {

    fun onSuccess(model: M)

    fun onFailure(code: Int, msg: String)

    fun onCompleted()

}
