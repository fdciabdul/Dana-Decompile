package com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;

/* loaded from: classes6.dex */
public class DefaultMonitorPrinter implements MonitorPrinter {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinter
    public void print(MonitorModel monitorModel) {
        SCLogCatUtil.info("WS_PERF", monitorModel.toString());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinter
    public void noteTraficConsume(DataflowMonitorModel dataflowMonitorModel) {
        SCLogCatUtil.info("WS_PERF", dataflowMonitorModel.toString());
    }
}
