package com.xiaomi.push;

import java.net.InetSocketAddress;

/* loaded from: classes8.dex */
public final class ai {
    int MyBillsEntityDataFactory;
    String getAuthRequestContext;

    private ai(String str, int i) {
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = i;
    }

    public static ai PlaceComponentResult(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new ai(str, i);
    }

    public final String toString() {
        if (this.MyBillsEntityDataFactory > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getAuthRequestContext);
            sb.append(":");
            sb.append(this.MyBillsEntityDataFactory);
            return sb.toString();
        }
        return this.getAuthRequestContext;
    }

    public static InetSocketAddress MyBillsEntityDataFactory(String str, int i) {
        ai PlaceComponentResult = PlaceComponentResult(str, i);
        return new InetSocketAddress(PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.MyBillsEntityDataFactory);
    }
}
