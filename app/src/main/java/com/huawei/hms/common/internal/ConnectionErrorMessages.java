package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: classes7.dex */
public class ConnectionErrorMessages {
    public static String getErrorDialogButtonMessage(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        return ResourceLoaderUtil.getString("hms_confirm");
    }

    public static String getErrorMessage(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1 || i == 2) {
            return activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), NotInstalledHmsDialogHelper.getAppName(activity));
        }
        return null;
    }

    public static String getErrorTitle(Activity activity, int i) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i == 1 || i == 2) {
            return null;
        }
        if (i != 3) {
            if (i != 9) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected error code ");
                sb.append(i);
                HMSLog.e("HuaweiApiAvailability", sb.toString());
                return null;
            }
            HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
            return null;
        }
        return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
    }
}
