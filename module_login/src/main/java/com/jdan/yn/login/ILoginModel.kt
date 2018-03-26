package com.jdan.yn.login

import com.jdan.yn.common.domain.bean.BaseBean
import com.jdan.yn.common.model.BaseModel
import com.jdan.yn.common.widget.callback.ApiCallback

/**
 * Created by Cxx on 2018/3/23.
 */

interface ILoginModel : BaseModel {
    fun login(userName: String, passWord: String, apiCallback: ApiCallback<BaseBean>)
}
