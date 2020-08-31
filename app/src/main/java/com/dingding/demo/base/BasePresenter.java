package com.dingding.demo.base;

import android.content.Intent;

public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {

	protected V view;


	public BasePresenter(V view) {
		attachView(view);
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void onStop() {

	}

	@Override
	public void attachView(V o) {
		this.view = o;
	}

	@Override
	public void attachIncomingIntent(Intent intent) {

	}
}
