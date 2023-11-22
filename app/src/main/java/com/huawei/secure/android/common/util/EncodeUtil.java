package com.huawei.secure.android.common.util;

/* loaded from: classes8.dex */
public class EncodeUtil {
    private static final char[] KClassImpl$Data$declaredNonStaticMembers$2 = {',', '.', '-'};
    private static final String[] getAuthRequestContext = new String[256];

    static {
        for (char c = 0; c < 255; c = (char) (c + 1)) {
            if ((c >= '0' && c <= '9') || ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                getAuthRequestContext[c] = null;
            } else {
                getAuthRequestContext[c] = Integer.toHexString(c).intern();
            }
        }
    }
}
