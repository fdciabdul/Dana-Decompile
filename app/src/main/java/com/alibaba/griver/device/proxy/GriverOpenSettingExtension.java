package com.alibaba.griver.device.proxy;

import android.app.Activity;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.util.Map;

/* loaded from: classes2.dex */
public interface GriverOpenSettingExtension extends Proxiable {

    /* loaded from: classes6.dex */
    public interface SettingChangeCallback {
        void onSettingChange(Map<String, Boolean> map);
    }

    void showOpenSettingView(Activity activity, Map<String, Boolean> map, AppModel appModel, SettingChangeCallback settingChangeCallback);
}
