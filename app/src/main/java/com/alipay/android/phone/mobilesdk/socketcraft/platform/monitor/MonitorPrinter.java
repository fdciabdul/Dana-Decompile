package com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorModel;

/* loaded from: classes6.dex */
public interface MonitorPrinter {
    void noteTraficConsume(DataflowMonitorModel dataflowMonitorModel);

    void print(MonitorModel monitorModel);
}
