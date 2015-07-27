package easemob.liaoliao.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import easemob.liaoliao.R;

/**
 * 开屏页
 */
public class SplashActivity extends BaseActivity {
    private Button btnTouristsLanding;
    private Button btnSignUp;
    private Button btnSignIn;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initViewId() {
        btnTouristsLanding = (Button) findViewById(R.id.btn_tourists_landing);
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
    }

    @Override
    public void setUpView() {
        btnTouristsLanding.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tourists_landing:
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                break;

            case R.id.btn_sign_up:
                startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                break;

            case R.id.btn_sign_in:
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                break;
        }
    }
}
