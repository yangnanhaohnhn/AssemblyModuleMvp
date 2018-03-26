package com.jdan.yn.common.presenter


import com.jdan.yn.common.model.BaseModel
import com.jdan.yn.common.view.BaseView

/**
 * 公共的Presenter
 * Created by Nan&Cxx on 2017/7/13.
 */
interface BasePresenter {
    fun attachView(view: BaseView, model: BaseModel)

    fun detachView()

}
