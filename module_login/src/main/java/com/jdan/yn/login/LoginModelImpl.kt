package com.jdan.yn.login

import com.jdan.yn.common.domain.bean.BaseBean
import com.jdan.yn.common.model.impl.BaseModelImpl
import com.jdan.yn.common.utils.StringUtils
import com.jdan.yn.common.widget.callback.ApiCallback

/**
 * Created by Cxx on 2018/3/23.
 */

class LoginModelImpl : BaseModelImpl(), ILoginModel {
    override fun login(userName: String, passWord: String, apiCallback: ApiCallback<BaseBean>) {
//        addSubscription(apiStores.loginReq("1","2","123"),object : ApiCallback<BaseBean>{
//            override fun onSuccess(model: BaseBean) {
//            }
//
//            override fun onFailure(code: Int, msg: String) {
//            }
//
//            override fun onCompleted() {
//
//            }
//        })
        if (StringUtils.isEquals(userName, "1") && StringUtils.isEquals(passWord, "123")) {
            val baseBean = BaseBean()
            baseBean.status = 0
            apiCallback.onSuccess(baseBean)
        } else {
            apiCallback.onFailure(1, "请求错误")
        }
        apiCallback.onCompleted()
    }
}
