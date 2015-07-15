package easemob.liaoliao.activity;

import android.content.Intent;
import android.view.View;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;

import easemob.liaoliao.R;

/**
 * Created by benson on 15/7/12.
 */
public class MatchActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_match;
    }

    @Override
    public void initViewId() {

    }

    @Override
    public void setUpView() {
       EMChatManager.getInstance().login("mm8", "123", new EMCallBack() {
           @Override
           public void onSuccess() {
               startActivity(new Intent(MatchActivity.this, ChatActivity.class).putExtra("userId","mm1"));
           }

           @Override
           public void onError(int i, String s) {

           }

           @Override
           public void onProgress(int i, String s) {

           }
       });

    }

    @Override
    public void onClick(View v) {

    }
}
