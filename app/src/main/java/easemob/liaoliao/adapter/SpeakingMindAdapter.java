package easemob.liaoliao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import easemob.liaoliao.R;
import easemob.liaoliao.domain.MessageBean;

/**
 * Created by benson on 15/7/11.
 */
public class SpeakingMindAdapter extends BaseAdapter {
    private List<MessageBean> messagesList;
    private Context context;

    public SpeakingMindAdapter(Context context, List<MessageBean> messagesList) {
        this.context = context;
        this.messagesList = messagesList;
    }

    @Override
    public int getCount() {
        return messagesList.size();
    }

    @Override
    public Object getItem(int position) {
        return messagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.message_item,null);
            holder.nick = (TextView)convertView.findViewById(R.id.txt_nick);
            holder.content = (TextView)convertView.findViewById(R.id.txt_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nick.setText(messagesList.get(position).getNick());
        holder.content.setText(messagesList.get(position).getContent());
        return convertView;
    }

    private class ViewHolder {
        TextView content;
        TextView nick;
    }
}
