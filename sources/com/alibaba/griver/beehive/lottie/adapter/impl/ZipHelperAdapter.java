package com.alibaba.griver.beehive.lottie.adapter.impl;

import java.io.InputStream;

/* loaded from: classes6.dex */
public class ZipHelperAdapter {
    public static boolean unZip(InputStream inputStream, String str) {
        return ZipHelper.unZip(inputStream, str);
    }

    public static boolean unZip(String str, String str2) {
        return ZipHelper.unZip(str, str2);
    }
}
