package com.dingding.demo.mvp.manger;

import com.dingding.demo.mvp.RetrofitHelper;
import com.dingding.demo.mvp.RetrofitService;
import com.dingding.demo.mvp.entity.Weather;

import rx.Observable;

public class DataManager {
	private RetrofitService mRetrofitService;

	public DataManager() {
		this.mRetrofitService = RetrofitHelper.getInstance().getServer();
	}

	public Observable<Weather> getWeather(String city, String key) {
		return mRetrofitService.getWeather2(city, key);
	}
}
