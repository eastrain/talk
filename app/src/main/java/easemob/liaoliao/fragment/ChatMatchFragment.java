package easemob.liaoliao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import easemob.liaoliao.R;
import easemob.liaoliao.activity.MatchActivity;

/**
 * Created by benson on 15/7/11.
 */
public class ChatMatchFragment extends BaseFragment {

    private Button btnTxtChat;
    private Button btnVoiceChat;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chat_match;
    }

    @Override
    public void onCreateChild(Bundle savedInstanceState) {
        btnTxtChat = (Button) layoutView.findViewById(R.id.btn_match_txt);
        btnVoiceChat = (Button) layoutView.findViewById(R.id.btn_match_voice);
        btnTxtChat.setOnClickListener(this);
        btnVoiceChat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_match_txt:
                startActivity(new Intent(getActivity(), MatchActivity.class));
                break;
            case R.id.btn_match_voice:
                startActivity(new Intent(getActivity(), MatchActivity.class));

                break;
        }
    }
}
