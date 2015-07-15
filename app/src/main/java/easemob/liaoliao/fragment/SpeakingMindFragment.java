package easemob.liaoliao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import easemob.liaoliao.R;
import easemob.liaoliao.adapter.SpeakingMindAdapter;
import easemob.liaoliao.domain.MessageBean;

/**
 * Created by benson on 15/7/11.
 */
public class SpeakingMindFragment extends BaseFragment {

    private ListView listView;
    private SpeakingMindAdapter adapter;
    private List<MessageBean> messagesList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_speaking_mind;
    }

    @Override
    public void onCreateChild(Bundle savedInstanceState) {
        listView = (ListView) layoutView.findViewById(R.id.listview);

        messagesList = new ArrayList<>();
        MessageBean messageBean = new MessageBean();
        messageBean.setNick("flower");
        messageBean.setContent("what a nice day it is today");
        MessageBean messageBean1 = new MessageBean();
        messageBean1.setNick("grass");
        messageBean1.setContent("yes.it is a nice day");
        messagesList.add(messageBean);
        messagesList.add(messageBean1);

        adapter = new SpeakingMindAdapter(getActivity(), messagesList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
