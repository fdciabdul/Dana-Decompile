package com.xiaomi.channel.commonutils.android;

import android.text.TextUtils;
import java.util.Collection;

/* loaded from: classes8.dex */
public class k {

    /* loaded from: classes8.dex */
    public static class a {
        private final String BuiltInFictitiousFunctionClassFactory;
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final StringBuilder PlaceComponentResult;

        public a() {
            this(":", ",");
        }

        public a(String str, String str2) {
            this.PlaceComponentResult = new StringBuilder();
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        }

        public final a KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                if (this.PlaceComponentResult.length() > 0) {
                    this.PlaceComponentResult.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                StringBuilder sb = this.PlaceComponentResult;
                sb.append(str);
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append(obj);
            }
            return this;
        }

        public String toString() {
            return this.PlaceComponentResult.toString();
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int getAuthRequestContext(String str, int i) {
        return !TextUtils.isEmpty(str) ? ((str.hashCode() / 10) * 10) + i : i;
    }
}
