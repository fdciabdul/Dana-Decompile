package com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;

/* loaded from: classes6.dex */
public class MonitorPrinterFactory {

    /* renamed from: a  reason: collision with root package name */
    private static MonitorPrinter f6912a;

    public static final MonitorPrinter getInstance() {
        MonitorPrinter monitorPrinter = f6912a;
        if (monitorPrinter != null) {
            return monitorPrinter;
        }
        synchronized (MonitorPrinterFactory.class) {
            MonitorPrinter monitorPrinter2 = f6912a;
            if (monitorPrinter2 != null) {
                return monitorPrinter2;
            }
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                f6912a = PlatformUtil.createMPaaSMonitorPrinter();
            } else {
                f6912a = new DefaultMonitorPrinter();
            }
            return f6912a;
        }
    }

    public static void setMonitorPrinter(MonitorPrinter monitorPrinter) {
        f6912a = monitorPrinter;
    }
}
