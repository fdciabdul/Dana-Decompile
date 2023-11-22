package com.huawei.hms.framework.common;

import com.huawei.android.os.BuildEx;

/* loaded from: classes7.dex */
public class EmuiUtil {
    public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
    public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
    private static int PlaceComponentResult = -1;

    public static boolean isEMUI() {
        return -1 != PlaceComponentResult;
    }

    public static int getEMUIVersionCode() {
        int intValue;
        Object staticFieldObj = ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
        if (staticFieldObj != null) {
            try {
                intValue = ((Integer) staticFieldObj).intValue();
            } catch (ClassCastException e) {
                Logger.e("KPMS_Util_Emui", "getEMUIVersionCode ClassCastException:", e);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("the emui version code is::");
            sb.append(intValue);
            Logger.d("KPMS_Util_Emui", sb.toString());
            return intValue;
        }
        intValue = 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("the emui version code is::");
        sb2.append(intValue);
        Logger.d("KPMS_Util_Emui", sb2.toString());
        return intValue;
    }

    public static boolean isUpPVersion() {
        if (ReflectionUtils.checkCompatible("com.huawei.android.os.BuildEx")) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.huawei.android.os.BuildEx.VERSION.EMUI_SDK_INT: ");
            sb.append(BuildEx.VERSION.EMUI_SDK_INT);
            Logger.d("KPMS_Util_Emui", sb.toString());
            return BuildEx.VERSION.EMUI_SDK_INT >= 17;
        }
        Logger.w("KPMS_Util_Emui", "com.huawei.android.os.BuildEx : false");
        return false;
    }

    static {
        int eMUIVersionCode = getEMUIVersionCode();
        StringBuilder sb = new StringBuilder();
        sb.append("getEmuiType emuiVersionCode=");
        sb.append(eMUIVersionCode);
        Logger.d("KPMS_Util_Emui", sb.toString());
        if (eMUIVersionCode >= 17) {
            PlaceComponentResult = 90;
        } else if (eMUIVersionCode >= 15) {
            PlaceComponentResult = 81;
        } else if (eMUIVersionCode >= 14) {
            PlaceComponentResult = 60;
        } else if (eMUIVersionCode >= 11) {
            PlaceComponentResult = 50;
        } else if (eMUIVersionCode >= 10) {
            PlaceComponentResult = 41;
        } else if (eMUIVersionCode >= 9) {
            PlaceComponentResult = 40;
        } else if (eMUIVersionCode >= 8) {
            PlaceComponentResult = 31;
        } else if (eMUIVersionCode >= 7) {
            PlaceComponentResult = 30;
        }
        if (PlaceComponentResult == -1) {
            Logger.i("KPMS_Util_Emui", "emuiType is unkown");
        }
    }
}
