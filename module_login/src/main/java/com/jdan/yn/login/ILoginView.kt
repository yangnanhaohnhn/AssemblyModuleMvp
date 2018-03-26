package com.jdan.yn.login

import com.jdan.yn.common.view.BaseView

/**
 * Created by Cxx on 2018/3/23.
 */

interface ILoginView : BaseView {
    val userName: String
    val passWord: String
}
