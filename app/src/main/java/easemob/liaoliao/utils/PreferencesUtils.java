package easemob.liaoliao.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by benson on 15/7/11.
 */
public class PreferencesUtils {


    /**
     * 保存Preference的name
     */
    public static final String PREFERENCE_NAME = "saveInfo";
    private static SharedPreferences sharedPreferences;
    private static PreferencesUtils preferencesUtils;
    private static SharedPreferences.Editor editor;

    private String SHARED_KEY_SETTING_NOTIFICATION = "shared_key_setting_notification";
    private String SHARED_KEY_SETTING_SOUND = "shared_key_setting_sound";
    private String SHARED_KEY_SETTING_VIBRATE = "shared_key_setting_vibrate";
    private String SHARED_KEY_SETTING_SPEAKER = "shared_key_setting_speaker";

    private static String SHARED_KEY_SETTING_CHATROOM_OWNER_LEAVE = "shared_key_setting_chatroom_owner_leave";

    /**
     * 单例模式，获取instance实例
     *
     * @param context
     * @return
     */
    public static PreferencesUtils getInstance(Context context) {
        if(preferencesUtils == null){
            preferencesUtils = new PreferencesUtils(context);
        }

        return preferencesUtils;
    }

    private PreferencesUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void setSettingMsgNotification(boolean paramBoolean) {
        editor.putBoolean(SHARED_KEY_SETTING_NOTIFICATION, paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgNotification() {
        return sharedPreferences.getBoolean(SHARED_KEY_SETTING_NOTIFICATION, true);
    }

    public void setSettingMsgSound(boolean paramBoolean) {
        editor.putBoolean(SHARED_KEY_SETTING_SOUND, paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgSound() {

        return sharedPreferences.getBoolean(SHARED_KEY_SETTING_SOUND, true);
    }

    public void setSettingMsgVibrate(boolean paramBoolean) {
        editor.putBoolean(SHARED_KEY_SETTING_VIBRATE, paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgVibrate() {
        return sharedPreferences.getBoolean(SHARED_KEY_SETTING_VIBRATE, true);
    }

    public void setSettingMsgSpeaker(boolean paramBoolean) {
        editor.putBoolean(SHARED_KEY_SETTING_SPEAKER, paramBoolean);
        editor.commit();
    }

    public boolean getSettingMsgSpeaker() {
        return sharedPreferences.getBoolean(SHARED_KEY_SETTING_SPEAKER, true);
    }

    public void setSettingAllowChatroomOwnerLeave(boolean value) {
        editor.putBoolean(SHARED_KEY_SETTING_CHATROOM_OWNER_LEAVE, value);
        editor.commit();
    }

    public boolean getSettingAllowChatroomOwnerLeave() {
        return sharedPreferences.getBoolean(SHARED_KEY_SETTING_CHATROOM_OWNER_LEAVE, true);
    }

}
