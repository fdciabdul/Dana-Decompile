package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.Constructor;

/* loaded from: classes7.dex */
public class PushPreferences {
    public SharedPreferences getAuthRequestContext;

    public PushPreferences(Context context, String str) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
                if (!sharedPreferences.getBoolean(str, false)) {
                    if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean(str, true);
                        edit.apply();
                    }
                }
                context = createDeviceProtectedStorageContext;
            }
            SharedPreferences PlaceComponentResult = PlaceComponentResult(context, str);
            this.getAuthRequestContext = PlaceComponentResult;
            if (PlaceComponentResult == null) {
                HMSLog.w("PushPreferences", "get new sharedPreferences failed,start to get from context. ");
                this.getAuthRequestContext = context.getSharedPreferences(str, 0);
                return;
            }
            return;
        }
        throw new NullPointerException("context is null!");
    }

    private static SharedPreferences PlaceComponentResult(Context context, String str) {
        File authRequestContext = getAuthRequestContext(context, str);
        if (authRequestContext == null) {
            return null;
        }
        try {
            Constructor<?> declaredConstructor = Class.forName("android.app.SharedPreferencesImpl").getDeclaredConstructor(File.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return (SharedPreferences) declaredConstructor.newInstance(authRequestContext, 0);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get SharedPreferences error.");
            sb.append(e.getMessage());
            HMSLog.e("PushPreferences", sb.toString());
            return null;
        }
    }

    private static File getAuthRequestContext(Context context, String str) {
        File file;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getDataDir());
                sb.append("/shared_prefs");
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".xml");
                file = new File(obj, sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context.getFilesDir().getParent());
                sb3.append("/shared_prefs");
                String obj2 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(".xml");
                file = new File(obj2, sb4.toString());
            }
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("get failed error.");
            sb5.append(e.getMessage());
            HMSLog.e("PushPreferences", sb5.toString());
            return null;
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        SharedPreferences sharedPreferences = this.getAuthRequestContext;
        return sharedPreferences != null && sharedPreferences.getBoolean(str, false);
    }

    public final boolean MyBillsEntityDataFactory(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.getAuthRequestContext;
        if (sharedPreferences == null || !sharedPreferences.contains(str) || (edit = this.getAuthRequestContext.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }

    public final boolean MyBillsEntityDataFactory(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.getAuthRequestContext;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public final boolean getAuthRequestContext(String str) {
        SharedPreferences sharedPreferences = this.getAuthRequestContext;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }
}
