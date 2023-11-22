package com.alibaba.griver.beehive.lottie.adapter.impl;

import java.io.File;

/* loaded from: classes6.dex */
public class NumberFontUtilAdapter {
    public static final String AMOUNT_NUM_FILE_NAME = "AlipayNumber";
    public static final String DIN_PRO_FILE_NAME = "DINPro";
    public static final String ICONFONT_FILE_SUFFIX = ".ttf";
    public static final String RES_BUNDLE = "antui_res";
    public static final String TAG = "antui";

    @Deprecated
    public static String getDINProTtfPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(RES_BUNDLE);
        sb.append(File.separator);
        sb.append(DIN_PRO_FILE_NAME);
        sb.append(".ttf");
        return sb.toString();
    }

    public static String getAlipayNumberTtfPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(RES_BUNDLE);
        sb.append(File.separator);
        sb.append(AMOUNT_NUM_FILE_NAME);
        sb.append(".ttf");
        return sb.toString();
    }
}
