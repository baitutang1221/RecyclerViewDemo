package com.example.administrator.recyclerviewdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private MyRecyclerView mRecyclerView;
	private GalleryAdapter mAdapter;
	private List<Integer> mDatas;
	private ImageView mImg ; 

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		mImg = (ImageView) findViewById(R.id.id_content);

		mDatas = new ArrayList<Integer>(Arrays.asList(R.mipmap.a,
				R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e,
				R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.l));

		mRecyclerView = (MyRecyclerView) findViewById(R.id.id_recyclerview_horizontal);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  //设置排列方向

		mRecyclerView.setLayoutManager(linearLayoutManager);
		mAdapter = new GalleryAdapter(this, mDatas);
		mRecyclerView.setAdapter(mAdapter);

		mRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener(){
			@Override
			public void onChange(View view, int position){
				mImg.setImageResource(mDatas.get(position));
			}
		});
		
		mAdapter.setOnItemClickLitener(new GalleryAdapter.OnItemClickLitener(){
			@Override
			public void onItemClick(View view, int position){
				mImg.setImageResource(mDatas.get(position));
			}
		});

	}

}
