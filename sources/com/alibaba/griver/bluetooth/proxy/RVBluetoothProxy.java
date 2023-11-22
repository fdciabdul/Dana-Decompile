package com.alibaba.griver.bluetooth.proxy;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.commonability.bluetooth.proxy.DefaultBlueToothProxy")
/* loaded from: classes2.dex */
public interface RVBluetoothProxy extends Proxiable {
    int getBLEConnectMaxTimeout();

    IBLETraceMonitor getBLETraceMonitor();
}
