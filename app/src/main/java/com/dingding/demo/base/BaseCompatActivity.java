package com.dingding.demo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseCompatActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
	protected P mPresenter;
	protected final String TAG = this.getClass().getSimpleName();

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		mPresenter = createPresenter();
		this.init();
		this.initView();
		this.initData();
		this.initListener();
	}

	/**
	 * 初始化presenter
	 * @return
	 */
	protected abstract P createPresenter();

	/**
	 * 获取布局ID
	 *
	 * @return
	 */
	protected abstract int getLayoutId();

	/**
	 * 初始化
	 */
	protected abstract void init();

	/**
	 * 初始化View控件
	 */
	protected abstract void initView();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	/**
	 * 初始化监听器
	 */
	protected abstract void initListener();
}