package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes8.dex */
public class h {
    private static final String PlaceComponentResult = "h";

    public static String PlaceComponentResult(String str) {
        Context PlaceComponentResult2 = c.PlaceComponentResult();
        if (PlaceComponentResult2 == null) {
            return "";
        }
        try {
            return PlaceComponentResult2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("getVersion NameNotFoundException : ");
            sb.append(e.getMessage());
            g.getAuthRequestContext(str2, sb.toString());
            return "";
        } catch (Exception e2) {
            String str3 = PlaceComponentResult;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getVersion: ");
            sb2.append(e2.getMessage());
            g.getAuthRequestContext(str3, sb2.toString());
            return "";
        } catch (Throwable unused) {
            g.getAuthRequestContext(PlaceComponentResult, "throwable");
            return "";
        }
    }
}
