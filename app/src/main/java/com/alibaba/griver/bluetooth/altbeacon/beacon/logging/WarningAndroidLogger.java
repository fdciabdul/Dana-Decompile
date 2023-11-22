package com.alibaba.griver.bluetooth.altbeacon.beacon.logging;

import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
final class WarningAndroidLogger extends AbstractAndroidLogger {
    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void d(String str, String str2, Object... objArr) {
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void d(Throwable th, String str, String str2, Object... objArr) {
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void i(String str, String str2, Object... objArr) {
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void i(Throwable th, String str, String str2, Object... objArr) {
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void v(String str, String str2, Object... objArr) {
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void v(Throwable th, String str, String str2, Object... objArr) {
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void w(String str, String str2, Object... objArr) {
        RVLogger.w(str, formatString(str2, objArr));
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void w(Throwable th, String str, String str2, Object... objArr) {
        RVLogger.w(str, formatString(str2, objArr), th);
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void e(String str, String str2, Object... objArr) {
        RVLogger.e(str, formatString(str2, objArr));
    }

    @Override // com.alibaba.griver.bluetooth.altbeacon.beacon.logging.Logger
    public final void e(Throwable th, String str, String str2, Object... objArr) {
        RVLogger.e(str, formatString(str2, objArr), th);
    }
}
