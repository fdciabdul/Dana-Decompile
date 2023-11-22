package com.alipay.mobile.rome.syncsdk.util;

/* loaded from: classes3.dex */
public final class AppStatusUtils {
    private static AppStatus b = AppStatus.BACKGROUND;

    /* renamed from: a  reason: collision with root package name */
    public static ScreenStatus f7262a = ScreenStatus.SCREEN_ON;

    /* loaded from: classes3.dex */
    public enum ScreenStatus {
        SCREEN_ON,
        SCREEN_OFF
    }

    /* loaded from: classes3.dex */
    public enum AppStatus {
        BACKGROUND("b"),
        FOREGROUND(com.alipay.mobile.rome.syncsdk.transport.connection.f.f7258a);

        private String value;

        AppStatus(String str) {
            this.value = str;
        }

        public static String getValue(AppStatus appStatus) {
            for (AppStatus appStatus2 : values()) {
                if (appStatus2 == appStatus) {
                    return appStatus.value;
                }
            }
            return null;
        }
    }

    public static void a(AppStatus appStatus) {
        b = appStatus;
    }

    public static AppStatus a() {
        return b;
    }
}
