package com.alipay.android.phone.mobilesdk.socketcraft.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.api.DefaultWebSocketClient;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinterFactory;
import com.alipay.android.phone.mobilesdk.socketcraft.util.StringUtils;

/* loaded from: classes6.dex */
public class MonitorHelper {

    /* renamed from: a  reason: collision with root package name */
    private DefaultWebSocketClient f6909a;
    private SimpleStatistical b;

    public MonitorHelper(DefaultWebSocketClient defaultWebSocketClient) {
        this.f6909a = defaultWebSocketClient;
    }

    public void printConnMonitorLog() {
        getSimpleStatistical().endConnAllTime = System.currentTimeMillis();
        MonitorModel createMonitorModel = createMonitorModel(MonitorItemConstants.WS_MONITOR_TITLE_CONN);
        createMonitorModel.appendDnsTime(String.valueOf(getSimpleStatistical().dnsTime));
        createMonitorModel.appendTcpTime(String.valueOf(getSimpleStatistical().tcpTime));
        createMonitorModel.appendSSLTime(String.valueOf(getSimpleStatistical().sslTime));
        createMonitorModel.appendWsHsTime(String.valueOf(getSimpleStatistical().wsHsTime));
        createMonitorModel.appendTargetHost(getSimpleStatistical().targetHost);
        createMonitorModel.appendAllTime(String.valueOf(getSimpleStatistical().getConnAllTime()));
        createMonitorModel.appendResult(true);
        MonitorPrinterFactory.getInstance().print(createMonitorModel);
    }

    public void printDisconnMonitorLog() {
        getSimpleStatistical().disconnectedTime = System.currentTimeMillis();
        MonitorModel createMonitorModel = createMonitorModel(MonitorItemConstants.WS_MONITOR_TITLE_DISCONN);
        createMonitorModel.appendDownMsgCount(String.valueOf(getSimpleStatistical().recvMsgCount));
        createMonitorModel.appendDownMsgLens(String.valueOf(getSimpleStatistical().recvMsgLenArray));
        createMonitorModel.appendUpMsgCount(String.valueOf(getSimpleStatistical().sendMsgCount));
        createMonitorModel.appendUpMsgLens(String.valueOf(getSimpleStatistical().sendMsgLenArray));
        createMonitorModel.appendLiveTime(String.valueOf(getSimpleStatistical().getLinkLiveTime()));
        MonitorPrinterFactory.getInstance().print(createMonitorModel);
        this.b = null;
    }

    public void printErrorMonitorLog(String str, String str2) {
        MonitorModel createMonitorModel = createMonitorModel("error");
        createMonitorModel.appendCode(str);
        createMonitorModel.appendErrMsg(str2);
        MonitorPrinterFactory.getInstance().print(createMonitorModel);
    }

    public MonitorModel createMonitorModel(String str) {
        MonitorModel monitorModel = new MonitorModel();
        monitorModel.logTitle = str;
        monitorModel.appendAppId(this.f6909a.getBizUniqId());
        monitorModel.appendUrl(this.f6909a.getUrl());
        return monitorModel;
    }

    public void recordMonitorOfRecvMsg(int i) {
        SimpleStatistical simpleStatistical = getSimpleStatistical();
        simpleStatistical.recvMsgCount++;
        if (simpleStatistical.recvMsgLenArray == null || simpleStatistical.recvMsgLenArray.length() <= 0) {
            simpleStatistical.recvMsgLenArray = String.valueOf(i);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(simpleStatistical.recvMsgLenArray);
        sb.append("_");
        sb.append(i);
        simpleStatistical.recvMsgLenArray = sb.toString();
    }

    public void recordMonitorOfSndMsg(int i) {
        SimpleStatistical simpleStatistical = getSimpleStatistical();
        simpleStatistical.sendMsgCount++;
        if (simpleStatistical.sendMsgLenArray == null || simpleStatistical.sendMsgLenArray.length() <= 0) {
            simpleStatistical.sendMsgLenArray = String.valueOf(i);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(simpleStatistical.sendMsgLenArray);
        sb.append("_");
        sb.append(i);
        simpleStatistical.sendMsgLenArray = sb.toString();
    }

    public SimpleStatistical getSimpleStatistical() {
        SimpleStatistical simpleStatistical = this.b;
        if (simpleStatistical != null) {
            return simpleStatistical;
        }
        SimpleStatistical simpleStatistical2 = new SimpleStatistical();
        this.b = simpleStatistical2;
        return simpleStatistical2;
    }

    public void recordStartConnAllTime() {
        getSimpleStatistical().startConnAllTime = System.currentTimeMillis();
    }

    public void recordConnectedTime() {
        getSimpleStatistical().connectedTime = System.currentTimeMillis();
    }

    public void recordDnsTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().dnsTime = j;
    }

    public void recordTargetHost(String str) {
        if (StringUtils.isEmpty(str) || "null".equals(str)) {
            return;
        }
        getSimpleStatistical().targetHost = str;
    }

    public void recordTcpTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().tcpTime = j;
    }

    public void recordSSLTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().sslTime = j;
    }

    public void recordWsHsTime(long j) {
        if (j <= 0) {
            return;
        }
        getSimpleStatistical().wsHsTime = j;
    }

    public final void noteTraficConsume(DataflowMonitorModel dataflowMonitorModel) {
        MonitorPrinterFactory.getInstance().noteTraficConsume(dataflowMonitorModel);
    }
}
