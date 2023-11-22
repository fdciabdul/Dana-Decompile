package com.alibaba.griver.device.jsapi.auth;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.device.model.SerializableMap;
import com.alibaba.griver.device.proxy.GriverOpenSettingExtension;
import com.alibaba.griver.device.ui.GriverOpenSettingActivity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverDefaultOpenSettingExtension implements GriverOpenSettingExtension {

    /* renamed from: a  reason: collision with root package name */
    private SettingChangeReceiver f6507a;

    @Override // com.alibaba.griver.device.proxy.GriverOpenSettingExtension
    public void showOpenSettingView(Activity activity, Map<String, Boolean> map, AppModel appModel, GriverOpenSettingExtension.SettingChangeCallback settingChangeCallback) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, GriverOpenSettingActivity.class);
        intent.putExtra("data", new SerializableMap(map));
        intent.putExtra("appInfo", (Parcelable) appModel);
        activity.startActivity(intent);
        this.f6507a = new SettingChangeReceiver(settingChangeCallback);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("griver_setting_changes");
        GriverEnv.getApplicationContext().registerReceiver(this.f6507a, intentFilter);
    }

    /* loaded from: classes6.dex */
    class SettingChangeReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private GriverOpenSettingExtension.SettingChangeCallback f6508a;

        public SettingChangeReceiver(GriverOpenSettingExtension.SettingChangeCallback settingChangeCallback) {
            this.f6508a = settingChangeCallback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SerializableMap serializableMap = (SerializableMap) intent.getSerializableExtra("data");
            Map<String, Boolean> hashMap = new HashMap<>();
            if (serializableMap != null) {
                hashMap = serializableMap.getMap();
            }
            GriverOpenSettingExtension.SettingChangeCallback settingChangeCallback = this.f6508a;
            if (settingChangeCallback != null) {
                settingChangeCallback.onSettingChange(hashMap);
                GriverEnv.getApplicationContext().unregisterReceiver(GriverDefaultOpenSettingExtension.this.f6507a);
            }
            GriverDefaultOpenSettingExtension.this.f6507a = null;
        }
    }
}
