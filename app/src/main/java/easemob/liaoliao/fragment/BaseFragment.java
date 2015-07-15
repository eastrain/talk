package easemob.liaoliao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import easemob.liaoliao.activity.BaseActivity;

/**
 * Created by benson on 15/7/11.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    public BaseActivity baseActivity;
    public View layoutView;
    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getActivity() == null){
            return;
        }
        baseActivity = (BaseActivity) getActivity();
        layoutView = baseActivity.getLayoutView(getLayoutId());
        if (layoutView == null){
            return;
        }
        onCreateChild(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView == null){
            rootView = layoutView;
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    public abstract int getLayoutId();

    public abstract void onCreateChild(Bundle savedInstanceState);
}
