package com.akamai.botman;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public final class r {
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Application application) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Settings.Secure.getString(application.getContentResolver(), "android_id");
        }
        SharedPreferences sharedPreferences = application.getSharedPreferences("com.akamai.botman.preferences", 0);
        String string = sharedPreferences.getString("ifv", "-1");
        if (string == "-1") {
            String obj = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("ifv", obj);
            edit.commit();
            return obj;
        }
        return string;
    }

    public static String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder("Akamai BMPSDK/3.3.0 (Android; ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Build.MANUFACTURER);
        sb.append("; ");
        sb.append(Build.MODEL);
        sb.append("; ");
        sb.append(Locale.getDefault().getLanguage());
        sb.append(")");
        return sb.toString();
    }
}
