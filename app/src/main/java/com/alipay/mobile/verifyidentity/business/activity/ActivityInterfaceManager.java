package com.alipay.mobile.verifyidentity.business.activity;

/* loaded from: classes7.dex */
public class ActivityInterfaceManager {
    private static ActivityInterface otp = new DefaultActivityInterface();
    private static ActivityInterface pin = new DefaultActivityInterface();
    private static ActivityInterface common = new DefaultActivityInterface();

    public static void injectOtpActivityInterface(ActivityInterface activityInterface) {
        if (activityInterface == null) {
            return;
        }
        otp = activityInterface;
    }

    public static void injectPinActivityInterface(ActivityInterface activityInterface) {
        if (activityInterface == null) {
            return;
        }
        pin = activityInterface;
    }

    public static void injectCommonActivityInterface(ActivityInterface activityInterface) {
        if (activityInterface == null) {
            return;
        }
        common = activityInterface;
    }

    public static ActivityInterface getOtpActivityInterface() {
        return otp;
    }

    public static ActivityInterface getPinActivityInterface() {
        return pin;
    }

    public static ActivityInterface getCommonActivityInterface() {
        return common;
    }
}
