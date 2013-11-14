package com.k.verticalvp;

import java.util.Random;

import com.k.verticalvp.VerticalViewPager.OnPageChangeListener;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {
	VerticalViewPager mViewPager;
	String tag="MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        mViewPager = (VerticalViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				Log.i(tag, "onPageSelected");
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub
				Log.i(tag, "onPageScrolled");
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				Log.i(tag, "onPageScrollState:"+state);
				
			}
		});
	}


	private class MyPagerAdapter extends PagerAdapter {

        private static final String TAG = "PagerAdapter";
        private Random mRandom = new Random();

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d(TAG, "instantiateItem:" + position);
            TextView tv = new TextView(MainActivity.this);
            tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(30);
            tv.setBackgroundColor(Color.rgb(mRandom.nextInt(255),
                    mRandom.nextInt(255), mRandom.nextInt(255)));
            tv.setTextColor(Color.WHITE);
            tv.setText("Pager: " + position);
            container.addView(tv);

            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d(TAG, "destroyItem:" + position);
            container.removeView((View) object);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
