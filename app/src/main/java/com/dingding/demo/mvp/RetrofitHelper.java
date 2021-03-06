package com.dingding.demo.mvp;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit的初始化
 */
public class RetrofitHelper {

	OkHttpClient client = new OkHttpClient();
	GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
	private static RetrofitHelper instance = null;
	private Retrofit mRetrofit = null;

	public static RetrofitHelper getInstance(){
		if (instance == null){
			instance = new RetrofitHelper();
		}
		return instance;
	}

	private RetrofitHelper(){
		init();
	}

	private void init() {
		resetApp();
	}

	private void resetApp() {
		mRetrofit = new Retrofit.Builder()
				.baseUrl("https://apis.juhe.cn/")
				.client(client)
				.addConverterFactory(factory)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
	}

	public RetrofitService getServer(){
		return mRetrofit.create(RetrofitService.class);
	}
}
