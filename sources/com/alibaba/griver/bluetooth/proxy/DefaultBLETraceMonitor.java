package com.alibaba.griver.bluetooth.proxy;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.bluetooth.ble.model.BleDevice;
import java.util.List;

/* loaded from: classes6.dex */
public class DefaultBLETraceMonitor implements IBLETraceMonitor {
    private static String TAG = "DefaultBLETraceMonitor";

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onStateChanged(boolean z, boolean z2) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onStateChanged:available-");
        sb.append(z);
        sb.append(",discovering-");
        sb.append(z2);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDeviceFound(List<BleDevice> list) {
        RVLogger.e(TAG, "onDeviceFound");
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onFirstScanTime(long j) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onFirstScanTime:");
        sb.append(j);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onError(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onError:");
        sb.append(str);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onConnectedSuccessful(String str, long j, int i) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectedSuccessful:");
        sb.append(str);
        sb.append(",connectTime-");
        sb.append(j);
        sb.append(",status");
        sb.append(i);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onConnect(String str, int i) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onConnect: address-");
        sb.append(str);
        sb.append(",transport-");
        sb.append(i);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDisconnectBLE(String str, long j, int i) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onDisconnectBLE: address-");
        sb.append(str);
        sb.append(",keepConnectedTime-");
        sb.append(j);
        sb.append(",status:");
        sb.append(i);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onServicesDiscovered(long j, int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onDisconnectBLE: discoverCostTime-");
        sb.append(j);
        sb.append(",status:");
        sb.append(i);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCharacteristicRead(String str, int i) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onDisconnectBLE: receivedData-");
        sb.append(str);
        sb.append(",status:");
        sb.append(i);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCharacteristicWrite(int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onCharacteristicWrite: :status:");
        sb.append(i);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCharacteristicWriteCompleted(long j) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onCharacteristicWriteCompleted: :completedTime:");
        sb.append(j);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCloseBluetoothAdapter(long j) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onCloseBluetoothAdapter: :sessionTime:");
        sb.append(j);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onStartBleScan(String[] strArr, boolean z, int i) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onCloseBluetoothAdapter: :serviceUUIDs-:");
        sb.append(strArr);
        sb.append(",allowDuplicatesKey-");
        sb.append(z);
        sb.append(",interval-");
        sb.append(i);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onStopBleScan() {
        RVLogger.e(TAG, "onStopBleScan");
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onGetBluetoothDevices(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetBluetoothDevices");
        sb.append(str);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDisconnect(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onDisconnect");
        sb.append(str);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDisconnectAllDevices() {
        RVLogger.e(TAG, "onDisconnectAllDevices");
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onGetBluetoothServices(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetBluetoothServices");
        sb.append(str);
        RVLogger.e(str2, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onGetBluetoothCharacteristics(String str, String str2) {
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetBluetoothCharacteristics: address-");
        sb.append(str);
        sb.append("serviceId-");
        sb.append(str2);
        RVLogger.e(str3, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onReadData(String str, String str2, String str3) {
        String str4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetBluetoothCharacteristics: address-");
        sb.append(str);
        sb.append("serviceId-");
        sb.append(str2);
        sb.append(",characteristicId:");
        sb.append(str3);
        RVLogger.e(str4, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onSendData(String str, String str2, String str3, String str4) {
        String str5 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onSendData: address-");
        sb.append(str);
        sb.append("serviceId-");
        sb.append(str2);
        sb.append(",characteristicId:");
        sb.append(str3);
        sb.append(",data:");
        sb.append(str4);
        RVLogger.e(str5, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onWriteValue(long j) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onWriteValue");
        sb.append(j);
        RVLogger.e(str, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onNotifyCharacteristicValue(String str, String str2, String str3, String str4, boolean z) {
        String str5 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onNotifyCharacteristicValue:");
        sb.append(str);
        sb.append(",serviceId:");
        sb.append(str2);
        sb.append(",characteristicId:");
        sb.append(str3);
        sb.append(",descriptorUUID:");
        sb.append(str4);
        sb.append(",enable:");
        sb.append(z);
        RVLogger.e(str5, sb.toString());
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onOpenBluetoothAdapter() {
        RVLogger.e(TAG, "onOpenBluetoothAdapter");
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onTimeout(String str) {
        RVLogger.e(TAG, str);
    }
}
