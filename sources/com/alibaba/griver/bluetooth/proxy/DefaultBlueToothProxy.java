package com.alibaba.griver.bluetooth.proxy;

/* loaded from: classes6.dex */
public class DefaultBlueToothProxy implements RVBluetoothProxy {
    @Override // com.alibaba.griver.bluetooth.proxy.RVBluetoothProxy
    public int getBLEConnectMaxTimeout() {
        return 20000;
    }

    @Override // com.alibaba.griver.bluetooth.proxy.RVBluetoothProxy
    public IBLETraceMonitor getBLETraceMonitor() {
        return null;
    }
}
