package com.huawei.secure.android.common.ssl.util;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public class g {
    public static void PlaceComponentResult() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityComp10105310: ");
        sb.append(str);
        InstrumentInjector.log_e(sb.toString(), str2, th);
    }

    public static void getAuthRequestContext(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityComp10105310: ");
        sb.append(str);
        InstrumentInjector.log_e(sb.toString(), str2);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityComp10105310: ");
        sb.append(str);
        InstrumentInjector.log_i(sb.toString(), str2);
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityComp10105310: ");
        sb.append(str);
        InstrumentInjector.log_w(sb.toString(), str2);
    }
}
