package com.jdan.yn.common.widget.retrofit;


import com.jdan.yn.common.domain.bean.BaseBean;
import com.jdan.yn.common.domain.constants.UrlFactory;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Nan&Cxx on 2017/7/13.
 */
public interface ApiStores {
    @GET(UrlFactory.LOGIN_URL)
    Observable<BaseBean> loginReq(@Query("username") String username,
                                               @Query("password") String pwd,
                                               @Query("uniqueReq") String uniqueReq);

}
