package com.alibaba.griver.bluetooth.altbeacon.beacon.logging;

/* loaded from: classes6.dex */
abstract class AbstractAndroidLogger implements Logger {
    /* JADX INFO: Access modifiers changed from: protected */
    public String formatString(String str, Object... objArr) {
        return objArr.length != 0 ? String.format(str, objArr) : str;
    }
}
