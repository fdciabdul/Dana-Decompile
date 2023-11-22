package com.alipay.zoloz.hardware.camera.utils;

import android.os.Build;
import com.alipay.mobile.security.faceauth.circle.protocol.DeviceSetting;

/* loaded from: classes7.dex */
public class DeviceSettingUtil {
    public static DeviceSetting getPropertyDeviceSetting(DeviceSetting[] deviceSettingArr) {
        DeviceSetting deviceSetting;
        if (deviceSettingArr != null) {
            int parseInt = Integer.parseInt(Build.VERSION.SDK);
            int length = deviceSettingArr.length;
            for (int i = 0; i < length; i++) {
                deviceSetting = deviceSettingArr[i];
                if (parseInt >= deviceSetting.getMinApiLevel() && parseInt <= deviceSetting.getMaxApiLevel()) {
                    break;
                }
            }
        }
        deviceSetting = null;
        return deviceSetting == null ? new DeviceSetting() : deviceSetting;
    }
}
