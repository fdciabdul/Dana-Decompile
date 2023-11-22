package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

/* loaded from: classes3.dex */
public class PackageManagerHelper {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static void PlaceComponentResult(Context context, Class<?> cls, boolean z) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger authRequestContext = Logger.getAuthRequestContext();
            String str = getAuthRequestContext;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z ? "enabled" : "disabled";
            authRequestContext.PlaceComponentResult(str, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e) {
            Logger authRequestContext2 = Logger.getAuthRequestContext();
            String str2 = getAuthRequestContext;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            objArr2[1] = z ? "enabled" : "disabled";
            authRequestContext2.PlaceComponentResult(str2, String.format("%s could not be %s", objArr2), e);
        }
    }
}
