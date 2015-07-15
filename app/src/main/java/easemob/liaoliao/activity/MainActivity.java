package easemob.liaoliao.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import easemob.liaoliao.R;

public class MainActivity extends BaseActivity {

    private List<View> dotsList;
    private List<Integer> imagesList;
    private int oldPosition;
    private Button enter;
    private ViewPager viewPager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViewId() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        enter = (Button) findViewById(R.id.btn_enter);

    }

    @Override
    public void setUpView() {
        imagesList = new ArrayList<>();
        imagesList.add(R.mipmap.image1);
        imagesList.add(R.mipmap.image2);
        imagesList.add(R.mipmap.image3);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new PageChangeListener());
        initDots();
        enter.setOnClickListener(this);
    }


    private void initDots() {
        dotsList = new ArrayList<>();
        dotsList.add(findViewById(R.id.dot1));
        dotsList.add(findViewById(R.id.dot2));
        dotsList.add(findViewById(R.id.dot3));
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,PortalActivity.class));
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            dotsList.get(position).setBackgroundResource(R.drawable.dot_focused);
            dotsList.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            oldPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }


    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imagesList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(imagesList.get(position));
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(imagesList.get(position));
            container.removeView(imageView);
        }
    }

}
