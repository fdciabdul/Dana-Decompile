package com.alipay.android.phone.mobilesdk.socketcraft.integrated.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.DefaultMonitorPrinter;
import com.alipay.mobile.common.logging.api.LogCategory;
import com.alipay.mobile.common.logging.api.LoggerFactory;
import com.alipay.mobile.common.logging.api.monitor.DataflowID;
import com.alipay.mobile.common.logging.api.monitor.DataflowModel;
import com.alipay.mobile.common.logging.api.monitor.Performance;
import com.alipay.mobile.common.transport.utils.MiscUtils;
import com.alipay.mobile.common.transport.utils.TransportEnvUtil;
import com.alipay.mobile.monitor.api.MonitorFactory;
import java.util.Map;

/* loaded from: classes6.dex */
public class MPaaSMonitorPrinter extends DefaultMonitorPrinter {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.DefaultMonitorPrinter, com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinter
    public void print(MonitorModel monitorModel) {
        try {
            if (monitorModel.itemMap.isEmpty()) {
                SCLogCatUtil.info("MonitorPrinter", "itemMap is empty!");
                return;
            }
            Performance performance = new Performance();
            performance.setSubType(MonitorItemConstants.MONITOR_SUB_TYPE);
            performance.setParam1(MonitorItemConstants.PARTITION_NAME);
            performance.setParam2(MonitorItemConstants.LEVEL_INFO);
            performance.setParam3(monitorModel.logTitle);
            monitorModel.itemMap.entrySet();
            for (Map.Entry<String, String> entry : monitorModel.itemMap.entrySet()) {
                performance.getExtPramas().put(entry.getKey(), entry.getValue());
            }
            LoggerFactory.getMonitorLogger().performance(LogCategory.CATEGORY_NETWORK, performance);
            StringBuilder sb = new StringBuilder();
            sb.append(performance.getSubType());
            sb.append("_PERF");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(toPerformanceString(performance));
            sb2.append("\n");
            SCLogCatUtil.debug(obj, sb2.toString());
        } catch (Throwable th) {
            SCLogCatUtil.error("MonitorPrinter", "monitorLog exception. ", th);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.DefaultMonitorPrinter, com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinter
    public void noteTraficConsume(DataflowMonitorModel dataflowMonitorModel) {
        try {
            if (dataflowMonitorModel == null) {
                SCLogCatUtil.warn("MonitorPrinter", "[noteTraficConsume] dataflowMonitorModel is null");
                return;
            }
            if (dataflowMonitorModel.methodName != null && dataflowMonitorModel.methodName.trim().length() > 0) {
                DataflowModel obtain = DataflowModel.obtain(DataflowID.WEB_SOCKET, dataflowMonitorModel.url, dataflowMonitorModel.sendSize, dataflowMonitorModel.receiveSize, dataflowMonitorModel.methodName);
                obtain.appId = dataflowMonitorModel.ownerId;
                if (DataflowMonitorModel.METHOD_NAME_SEND.equals(dataflowMonitorModel.methodName)) {
                    obtain.isUpload = true;
                }
                MonitorFactory.getMonitorContext().noteTraficConsume(obtain);
                if (MiscUtils.isDebugger(TransportEnvUtil.getContext())) {
                    StringBuilder sb = new StringBuilder("[noteTraficConsume]  dataflowMonitorModel: ");
                    sb.append(dataflowMonitorModel.toString());
                    SCLogCatUtil.info("MonitorPrinter", sb.toString());
                    return;
                }
                return;
            }
            SCLogCatUtil.warn("MonitorPrinter", "[noteTraficConsume] methodName is empty.");
        } catch (Throwable th) {
            SCLogCatUtil.error("MonitorPrinter", "[noteTraficConsume] exception. ", th);
        }
    }

    public String toPerformanceString(Performance performance) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(performance.getSubType());
        stringBuffer.append(",");
        stringBuffer.append(performance.getParam1());
        stringBuffer.append(",");
        stringBuffer.append(performance.getParam2());
        stringBuffer.append(",");
        stringBuffer.append(performance.getParam3());
        stringBuffer.append(",");
        for (String str : performance.getExtPramas().keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("=");
            sb.append((String) performance.getExtPramas().get(str));
            sb.append("^");
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
