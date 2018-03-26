package com.jdan.yn.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

import com.jdan.yn.common.ui.activity.BaseActivity

/**
 * Created by Cxx on 2018/3/23.
 */

class LoginActivity : BaseActivity<ILoginPresenter>(), ILoginView {

    private var usernameEt: EditText? = null
    private var passwordEt: EditText? = null

    override val viewId: Int
        get() = R.layout.activity_login

    override fun createPresenter(): ILoginPresenter {
        return LoginPresenterImpl(this)
    }

    override fun onClick(v: View) {
        super.onClick(v)
        if (v.id == R.id.login_btn) {
            mvpPresenter!!.login()
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        usernameEt = findViewById(R.id.username_et)
        passwordEt = findViewById(R.id.password_et)
        findViewById<View>(R.id.login_btn).setOnClickListener(this)

    }

    override val userName: String
        get() = usernameEt!!.text.toString().trim()

    override val passWord: String
        get() = passwordEt!!.text.toString().trim()
}
