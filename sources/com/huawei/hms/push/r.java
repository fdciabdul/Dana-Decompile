package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class r {
    public static int BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(".R$");
                sb.append(str);
                Field field = Class.forName(sb.toString()).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error-resourceType=");
                    sb2.append(str);
                    sb2.append("--resourceName=");
                    sb2.append(str2);
                    sb2.append("--resourceId =");
                    sb2.append(identifier);
                    HMSLog.i("ResourceLoader", sb2.toString());
                }
            }
            return identifier;
        } catch (ClassNotFoundException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("!!!! ResourceLoader: ClassNotFoundException-resourceType=");
            sb3.append(str);
            sb3.append("--resourceName=");
            sb3.append(str2);
            HMSLog.e("ResourceLoader", sb3.toString(), e);
            return 0;
        } catch (IllegalAccessException e2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("!!!! ResourceLoader: IllegalAccessException-resourceType=");
            sb4.append(str);
            sb4.append("--resourceName=");
            sb4.append(str2);
            HMSLog.e("ResourceLoader", sb4.toString(), e2);
            return 0;
        } catch (NoSuchFieldException e3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("!!!! ResourceLoader: NoSuchFieldException-resourceType=");
            sb5.append(str);
            sb5.append("--resourceName=");
            sb5.append(str2);
            HMSLog.e("ResourceLoader", sb5.toString(), e3);
            return 0;
        } catch (NumberFormatException e4) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("!!!! ResourceLoader: NumberFormatException-resourceType=");
            sb6.append(str);
            sb6.append("--resourceName=");
            sb6.append(str2);
            HMSLog.e("ResourceLoader", sb6.toString(), e4);
            return 0;
        } catch (IllegalArgumentException e5) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("!!!! ResourceLoader: IllegalArgumentException-resourceType=");
            sb7.append(str);
            sb7.append("--resourceName=");
            sb7.append(str2);
            HMSLog.e("ResourceLoader", sb7.toString(), e5);
            return 0;
        }
    }

    public static int PlaceComponentResult(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.w("ResourceLoader", "load meta data resource failed.");
            return 0;
        }
    }
}
