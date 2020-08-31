package com.dingding.demo.mvp.presenter;

import android.content.Intent;

import com.dingding.demo.base.BasePresenter;
import com.dingding.demo.mvp.view.WeatherView;
import com.dingding.demo.mvp.entity.Weather;
import com.dingding.demo.mvp.manger.DataManager;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class WeatherPresenter extends BasePresenter<WeatherView> {

	private DataManager manager;
	private CompositeSubscription mCompositeSubscription;
	private Weather mWeather;

	public WeatherPresenter(WeatherView view) {
		super(view);
		onCreate();
	}

	@Override
	public void onCreate() {
		manager = new DataManager();
		mCompositeSubscription = new CompositeSubscription();
	}

	@Override
	public void onStop() {
		if (mCompositeSubscription.hasSubscriptions()) {
			mCompositeSubscription.unsubscribe();
		}
	}

	@Override
	public void attachIncomingIntent(Intent intent) {

	}

	public void getWeather(String city, String key) {
		mCompositeSubscription.add(manager.getWeather(city, key)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<Weather>() {
					@Override
					public void onCompleted() {
						if (mWeather != null) {
							view.onSuccess(mWeather);
						}
					}

					@Override
					public void onError(Throwable e) {
						e.printStackTrace();
						view.onError("请求失败！！");
					}

					@Override
					public void onNext(Weather weather) {
						mWeather = weather;
					}
				})
		);
	}
}
