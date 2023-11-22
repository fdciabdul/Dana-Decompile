package com.huawei.hms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f7483a;
    public static final Object b = new Object();

    public static boolean a(Context context) {
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (RuntimeException e) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e);
            }
        }
        HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    public static boolean b(Context context) {
        if (context == null) {
            HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (RuntimeException e) {
                HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e);
            }
        }
        HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    public static boolean c(Context context) {
        synchronized (b) {
            if (f7483a == 0) {
                if (context == null) {
                    return true;
                }
                if (a(context)) {
                    HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                    f7483a = 1;
                } else if (b(context)) {
                    HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                    f7483a = 2;
                } else if ("CN".equalsIgnoreCase(GrsApp.getInstance().getIssueCountryCode(context))) {
                    f7483a = 1;
                } else {
                    HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");
                    try {
                        int i = Settings.Secure.getInt(context.getContentResolver(), "hw_app_analytics_state");
                        StringBuilder sb = new StringBuilder();
                        sb.append("hw_app_analytics_state value is ");
                        sb.append(i);
                        HMSLog.i("AnalyticsSwitchHolder", sb.toString());
                        if (i == 1) {
                            f7483a = 1;
                        } else {
                            f7483a = 2;
                        }
                    } catch (Settings.SettingNotFoundException unused) {
                        HMSLog.i("AnalyticsSwitchHolder", "Get OOBE failed");
                        f7483a = 2;
                    }
                }
            }
            return f7483a != 1;
        }
    }
}
