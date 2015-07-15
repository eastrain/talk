package easemob.liaoliao.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import easemob.liaoliao.R;
import easemob.liaoliao.fragment.ChatMatchFragment;
import easemob.liaoliao.fragment.SpeakingMindFragment;

/**
 * Created by benson on 15/7/11.
 */
public class PortalActivity extends BaseActivity {

    private ChatMatchFragment cmf;
    private SpeakingMindFragment smf;
    private ViewPager viewPager;
    private Fragment[] fragments;
    private Button btnChat;
    private Button btnSpeakingMind;

    @Override
    public int getLayoutId() {
        return R.layout.activity_portal;
    }

    @Override
    public void initViewId() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        btnChat = (Button)findViewById(R.id.btn_chat);
        btnSpeakingMind = (Button)findViewById(R.id.btn_speaking_mind);
    }

    @Override
    public void setUpView() {
        cmf = new ChatMatchFragment();
        smf = new SpeakingMindFragment();
        fragments = new Fragment[]{cmf, smf};
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        btnChat.setOnClickListener(this);
        btnSpeakingMind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_chat:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_speaking_mind:
                viewPager.setCurrentItem(1);
                break;
        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
