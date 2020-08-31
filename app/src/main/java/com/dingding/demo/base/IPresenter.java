package com.dingding.demo.base;

import android.content.Intent;

public interface IPresenter<T> {
	void onCreate();

	void onStop();

	void attachView(T t);

	void attachIncomingIntent(Intent intent);//暂时没用到
}
