package com.jdan.yn.login

import com.jdan.yn.common.presenter.BasePresenter

/**
 * Created by Cxx on 2018/3/23.
 */

interface ILoginPresenter : BasePresenter {
    fun login()
    fun cleanData()
}
