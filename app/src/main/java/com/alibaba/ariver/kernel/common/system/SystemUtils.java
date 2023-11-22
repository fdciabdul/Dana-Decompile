package com.alibaba.ariver.kernel.common.system;

/* loaded from: classes6.dex */
public class SystemUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f6158a;
    private static String b;

    public static String getManufacturer() {
        if (f6158a == null) {
            f6158a = SystemPropertiesCompat.get("ro.product.manufacturer");
        }
        return f6158a;
    }

    public static String getPhoneModel() {
        if (b == null) {
            b = SystemPropertiesCompat.get("ro.product.model");
        }
        return b;
    }

    public static boolean isXiaoPeng() {
        return "XiaoPeng".equals(getManufacturer());
    }

    public static boolean isGenie() {
        String phoneModel = getPhoneModel();
        return phoneModel != null && (phoneModel.contains("AILABS") || phoneModel.contains("ailabs"));
    }
}
