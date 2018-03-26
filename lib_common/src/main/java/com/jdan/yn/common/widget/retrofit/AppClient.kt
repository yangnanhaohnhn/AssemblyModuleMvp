package com.jdan.yn.common.widget.retrofit


import com.jdan.yn.common.domain.constants.UrlFactory

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * AppClient
 */
object AppClient {
    private var mRetrofit: Retrofit? = null

    fun retrofit(): Retrofit? {
        if (mRetrofit == null) {
            //https请求
            //OkHttpClient.Builder builder = new OkHttpClient.Builder().sslSocketFactory(DataUtils.setCert(new Buffer().writeUtf8(Config.CERT).inputStream())).hostnameVerifier(new DataUtils.TrustAllHostnameVerifier());
            val builder = OkHttpClient.Builder()

            if (true) {
                // Log信息拦截器
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                //设置 Debug Log 模式
                builder.addInterceptor(loggingInterceptor)
            }
            val okHttpClient = builder.build()
            mRetrofit = Retrofit.Builder()
                    .baseUrl(UrlFactory.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
        }
        return mRetrofit
    }

}
