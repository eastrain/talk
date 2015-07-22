/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package easemob.liaoliao.activity;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.EMError;
import com.easemob.chat.EMChatManager;
import com.easemob.exceptions.EaseMobException;

import easemob.liaoliao.R;
import easemob.liaoliao.application.LiaoApplication;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * 注册页
 *
 */
public class RegisterActivity extends BaseActivity {
    private EditText userNameEditText;
    private EditText passwordEditText;
    private EditText confirmPwdEditText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initViewId() {
        userNameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        confirmPwdEditText = (EditText) findViewById(R.id.confirm_password);
    }

    @Override
    public void setUpView() {

    }

    /**
     * 注册
     *
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
            {
                String st1 = getResources().getString(R.string.User_name_cannot_be_empty);
                String st2 = getResources().getString(R.string.Password_cannot_be_empty);
                String st3 = getResources().getString(R.string.Confirm_password_cannot_be_empty);
                String st4 = getResources().getString(R.string.Two_input_password);
                String st5 = getResources().getString(R.string.Is_the_registered);
                final String st6 = getResources().getString(R.string.Registered_successfully);
                final String username = userNameEditText.getText().toString().trim();
                final String pwd = passwordEditText.getText().toString().trim();
                String confirm_pwd = confirmPwdEditText.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(this, st1, LENGTH_SHORT).show();
                    userNameEditText.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, st2, LENGTH_SHORT).show();
                    passwordEditText.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(confirm_pwd)) {
                    Toast.makeText(this, st3, LENGTH_SHORT).show();
                    confirmPwdEditText.requestFocus();
                    return;
                } else if (!pwd.equals(confirm_pwd)) {
                    Toast.makeText(this, st4, LENGTH_SHORT).show();
                    return;
                }

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)) {
                    final ProgressDialog pd = new ProgressDialog(this);
                    pd.setMessage(st5);
                    pd.show();
                    final String st7 = getResources().getString(R.string.network_anomalies);
                    final String st8 = getResources().getString(R.string.User_already_exists);
                    final String st9 = getResources().getString(R.string.registration_failed_without_permission);
                    final String st10 = getResources().getString(R.string.Registration_failed);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                // 调用sdk注册方法
                                EMChatManager.getInstance().createAccountOnServer(username, pwd);
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        if (!RegisterActivity.this.isFinishing())
                                            pd.dismiss();
                                        // 保存用户名
                                        LiaoApplication.getInstance().setUserName(username);
                                        Toast.makeText(getApplicationContext(), st6, LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                            } catch (final EaseMobException e) {
                                runOnUiThread(new Runnable() {
                                    public void run() {
                                        if (!RegisterActivity.this.isFinishing())
                                            pd.dismiss();
                                        int errorCode=e.getErrorCode();
                                        if(errorCode==EMError.NONETWORK_ERROR){
                                            Toast.makeText(getApplicationContext(), st7, Toast.LENGTH_SHORT).show();
                                        }else if(errorCode==EMError.USER_ALREADY_EXISTS){
                                            Toast.makeText(getApplicationContext(), st8, Toast.LENGTH_SHORT).show();
                                        }else if(errorCode==EMError.UNAUTHORIZED){
                                            Toast.makeText(getApplicationContext(), st9, Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(getApplicationContext(), st10 + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    }).start();

                }
            }
                break;
        }
    }
}
