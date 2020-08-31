package com.dingding.demo.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dingding.demo.R;
import com.dingding.demo.base.BaseCompatActivity;
import com.dingding.demo.mvp.view.WeatherView;
import com.dingding.demo.mvp.entity.Weather;
import com.dingding.demo.mvp.presenter.WeatherPresenter;

public class MainActivity extends BaseCompatActivity<WeatherPresenter> implements WeatherView {

	private TextView textView;
	private Button button;
	private WeatherPresenter mWeatherPresenter = new WeatherPresenter(this);

	@Override
	protected WeatherPresenter createPresenter() {
		return mWeatherPresenter;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void init() {

	}

	@Override
	protected void initView() {
		textView = findViewById(R.id.tv_weather);
		button = findViewById(R.id.button);
		String key = "3e7a52bbc6b43b6cc2fff9569909437d";
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mWeatherPresenter.getWeather("潍坊", "3e7a52bbc6b43b6cc2fff9569909437d");
			}
		});
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initListener() {

	}

	@Override
	public void onSuccess(Weather data) {
		textView.setText(data.toString());
	}

	@Override
	public void onError(String result) {
		Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mWeatherPresenter.onStop();
	}


//	/**
//	 * RxJava
//	 */
//	private void Test2() {
//		Retrofit retrofit = new Retrofit.Builder()
//				.baseUrl("https://apis.juhe.cn/")
//				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
//				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//				.build();
//		RetrofitService service = retrofit.create(RetrofitService.class);
//		Observable<Weather> observable = service.getWeather2("潍坊", "3e7a52bbc6b43b6cc2fff9569909437d");
//		observable.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Observer<Weather>() {
//					@Override
//					public void onCompleted() {
//
//					}
//
//					@Override
//					public void onError(Throwable e) {
//						e.printStackTrace();
//					}
//
//					@Override
//					public void onNext(Weather weather) {
//						textView.setText(weather.toString());
//					}
//				});
//	}
//
//	/**
//	 * 单独使用 Retrofit
//	 */
//	private void Test1() {
//		Retrofit retrofit = new Retrofit.Builder()
//				.baseUrl("https://apis.juhe.cn/")
//				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
//				.build();
//		RetrofitService service = retrofit.create(RetrofitService.class);
//		Call<Weather> call = service.getWeather("潍坊", "3e7a52bbc6b43b6cc2fff9569909437d");
//		call.enqueue(new Callback<Weather>() {
//			@Override
//			public void onResponse(Call<Weather> call, Response<Weather> response) {
//				textView.setText(response.body() + "");
//				Log.d("TAG", response.body() + "");
//			}
//
//			@Override
//			public void onFailure(Call<Weather> call, Throwable t) {
//
//			}
//		});
//	}
}