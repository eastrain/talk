package easemob.liaoliao.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by benson on 15/7/11.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        setContentView(getLayoutId());
        initViewId();
        setUpView();

    }

    public View getLayoutView(int layoutId){
        if(inflater == null){
            return null;
        }
        View view = inflater.inflate(layoutId,null);
        return view;
    }

    public abstract int getLayoutId();

    public abstract void initViewId();

    public abstract void setUpView();
}
