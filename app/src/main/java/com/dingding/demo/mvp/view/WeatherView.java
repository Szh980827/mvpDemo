package com.dingding.demo.mvp.view;

import com.dingding.demo.base.IBaseView;
import com.dingding.demo.mvp.entity.Weather;

public interface WeatherView extends IBaseView {
	void onSuccess(Weather data);
	void onError(String result);
}
