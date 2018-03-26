package com.jdan.yn.login

import com.jdan.yn.common.domain.bean.BaseBean
import com.jdan.yn.common.presenter.impl.BasePresenterImpl
import com.jdan.yn.common.utils.StringUtils
import com.jdan.yn.common.widget.callback.ApiCallback
import com.orhanobut.logger.Logger


/**
 * Created by Cxx on 2018/3/23.
 */

internal class LoginPresenterImpl(view: ILoginView) : BasePresenterImpl<ILoginView, ILoginModel>(), ILoginPresenter {
    init {
        attachView(view, LoginModelImpl())
    }

    override fun login() {
        val userName = mvpView!!.userName
        val passWord = mvpView!!.passWord
        if (StringUtils.isEmpty(userName)) {
            mvpView!!.toastShow("不能为空!")
            return
        }
        if (StringUtils.isEmpty(passWord)) {
            mvpView!!.toastShow("不能为空!")
            return
        }
        mvpView!!.showLoading()
        mvpModel!!.login(userName, passWord, object : ApiCallback<BaseBean> {
            override fun onSuccess(model: BaseBean) {
                Logger.e(model.status.toString() + "!")
            }

            override fun onFailure(code: Int, msg: String) {
                Logger.e("失败:" + msg)
            }

            override fun onCompleted() {
                mvpView!!.hideLoading()
            }
        })
    }

    /**
     * 清理数据
     */
    override fun cleanData(){
        mvpView!!.clean()
    }
}
