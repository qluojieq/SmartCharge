package com.smartchina.smartcharge.acticity;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.githang.viewpagerindicator.IconTabPageIndicator;
import com.viewpagerindicator.IconPagerAdapter;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends FragmentActivity
{
	private SlidingMenu mMenu;
	private ViewPager mViewPager;
	private IconTabPageIndicator mIndicator;
	private Button testNovagtor;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}
	private void initViews() {
		testNovagtor =(Button)findViewById(R.id.btn_now	);
		testNovagtor.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this, Activitytest.class);
				startActivity(intent);

			}
		});
		mMenu = (SlidingMenu) findViewById(R.id.id_menu);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mIndicator = (IconTabPageIndicator) findViewById(R.id.indicator);
		List<BaseFragment> fragments = initFragments();
		FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
		mViewPager.setAdapter(adapter);
		mIndicator.setViewPager(mViewPager);


	}
	private List<BaseFragment> initFragments() {
		List<BaseFragment> fragments = new ArrayList<BaseFragment>();

		HomeMap homemap = new HomeMap();
		homemap.setTitle("用户");
		homemap.setIconId(R.drawable.tab_user_selector);
		fragments.add(homemap);

		BaseFragment noteFragment = new BaseFragment();
		noteFragment.setTitle("记事本");
		noteFragment.setIconId(R.drawable.tab_record_selector);
		fragments.add(noteFragment);

		BaseFragment contactFragment = new BaseFragment();
		contactFragment.setTitle("联系人");
		contactFragment.setIconId(R.drawable.tab_user_selector);
		fragments.add(contactFragment);

		BaseFragment recordFragment = new BaseFragment();
		recordFragment.setTitle("记录");
		recordFragment.setIconId(R.drawable.tab_record_selector);
		fragments.add(recordFragment);

		return fragments;
	}

	class FragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
		private List<BaseFragment> mFragments;

		public FragmentAdapter(List<BaseFragment> fragments, FragmentManager fm) {
			super(fm);
			mFragments = fragments;
		}

		@Override
		public Fragment getItem(int i) {
			return mFragments.get(i);
		}

		@Override
		public int getIconResId(int index) {
			return mFragments.get(index).getIconId();
		}

		@Override
		public int getCount() {
			return mFragments.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragments.get(position).getTitle();
		}
	}
	public void toggleMenu(View view)
	{
		mMenu.toggle();
	}
}
