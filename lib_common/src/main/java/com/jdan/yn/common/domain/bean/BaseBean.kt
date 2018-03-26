package com.jdan.yn.common.domain.bean

import java.io.Serializable

/**
 * Created by Cxx on 2018/3/23.
 */

class BaseBean : Serializable {

    /**
     * 0:代表成功  有数据
     * 2:代表没有数据
     */
    var status: Int = 0

    override fun toString(): String {
        return "StatesBean [status=$status]"
    }
}
