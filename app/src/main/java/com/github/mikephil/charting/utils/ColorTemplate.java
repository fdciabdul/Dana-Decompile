package com.github.mikephil.charting.utils;

import android.graphics.Color;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.flexbox.FlexItem;

/* loaded from: classes7.dex */
public class ColorTemplate {
    public static final int[] BuiltInFictitiousFunctionClassFactory = {Color.rgb(207, 248, 246), Color.rgb(148, (int) SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE, (int) SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE), Color.rgb(136, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, 130)};
    public static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {Color.rgb((int) com.alibaba.griver.image.framework.utils.FileUtils.JPEG_MARKER_EOI, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)};
    public static final int[] PlaceComponentResult = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb((int) com.alibaba.griver.image.framework.utils.FileUtils.JPEG_MARKER_EOI, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};
    public static final int[] MyBillsEntityDataFactory = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, (int) SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};
    public static final int[] moveToNextValue = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};
    public static final int[] getAuthRequestContext = {PlaceComponentResult("#2ecc71"), PlaceComponentResult("#f1c40f"), PlaceComponentResult("#e74c3c"), PlaceComponentResult("#3498db")};

    public static int MyBillsEntityDataFactory(int i, int i2) {
        return (i & FlexItem.MAX_SIZE) | ((i2 & 255) << 24);
    }

    private static int PlaceComponentResult(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, (parseLong >> 0) & 255);
    }
}
