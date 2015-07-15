package easemob.liaoliao.application;

import android.app.Application;
import android.content.Context;

import com.easemob.EMCallBack;

import java.util.Map;

import easemob.liaoliao.domain.User;

/**
 * Created by benson on 15/7/12.
 */
public class LiaoApplication extends Application {

    public static Context applicationContext;
    private static LiaoApplication instance;
    // login user name
    public final String PREF_USERNAME = "username";

    public static LiaoHXSDKHelper hxSDKHelper = new LiaoHXSDKHelper();

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
        hxSDKHelper.onInit(applicationContext);
    }

    public static LiaoApplication getInstance() {
        return instance;
    }

    /**
     * 获取内存中好友user list
     *
     * @return
     */
    public Map<String, User> getContactList() {
        return hxSDKHelper.getContactList();
    }

    /**
     * 设置好友user list到内存中
     *
     * @param contactList
     */
    public void setContactList(Map<String, User> contactList) {
        hxSDKHelper.setContactList(contactList);
    }

    /**
     * 获取当前登陆用户名
     *
     * @return
     */
    public String getUserName() {
        return hxSDKHelper.getHXId();
    }

    /**
     * 获取密码
     *
     * @return
     */
    public String getPassword() {
        return hxSDKHelper.getPassword();
    }

    /**
     * 设置用户名
     *
     * @param user
     */
    public void setUserName(String username) {
        hxSDKHelper.setHXId(username);
    }

    /**
     * 设置密码 下面的实例代码 只是demo，实际的应用中需要加password 加密后存入 preference 环信sdk
     * 内部的自动登录需要的密码，已经加密存储了
     *
     * @param pwd
     */
    public void setPassword(String pwd) {
        hxSDKHelper.setPassword(pwd);
    }

    /**
     * 退出登录,清空数据
     */
    public void logout(final EMCallBack emCallBack) {
        // 先调用sdk logout，在清理app中自己的数据
        hxSDKHelper.logout(emCallBack);
    }
}
