package com.dingding.demo.mvp;

import com.dingding.demo.mvp.entity.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitService {

	@GET("simpleWeather/query")
	Call<Weather> getWeather(@Query("city") String city,
							 @Query("key") String key);

	@GET("simpleWeather/query")
	Observable<Weather> getWeather2(@Query("city") String city,
									@Query("key") String key);


}
