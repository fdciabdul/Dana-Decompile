package com.alibaba.griver.bluetooth.ble;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.bluetooth.ble.model.BleDevice;
import com.alibaba.griver.bluetooth.proxy.DefaultBLETraceMonitor;
import com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor;
import com.alibaba.griver.bluetooth.proxy.RVBluetoothProxy;
import java.util.List;

/* loaded from: classes6.dex */
public class BLETraceMonitor implements IBLETraceMonitor {
    private static BLETraceMonitor sInstance;
    private long connectedTime;
    private long discoverTime;
    private IBLETraceMonitor mTraceMonitorImpl;
    private long openBluetoothAdapterTime;
    private long startBluetoothDiscoveryTime;
    private long startConnectTime;
    private long writeTime;

    @Deprecated
    private BLETraceMonitor() {
        IBLETraceMonitor bLETraceMonitor = ((RVBluetoothProxy) RVProxy.get(RVBluetoothProxy.class)).getBLETraceMonitor();
        this.mTraceMonitorImpl = bLETraceMonitor;
        if (bLETraceMonitor == null) {
            this.mTraceMonitorImpl = new DefaultBLETraceMonitor();
        }
    }

    public static BLETraceMonitor getInstance() {
        if (sInstance == null) {
            synchronized (BLETraceMonitor.class) {
                sInstance = new BLETraceMonitor();
            }
        }
        return sInstance;
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onStateChanged(boolean z, boolean z2) {
        this.mTraceMonitorImpl.onStateChanged(z, z2);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDeviceFound(List<BleDevice> list) {
        this.mTraceMonitorImpl.onDeviceFound(list);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onFirstScanTime(long j) {
        this.mTraceMonitorImpl.onFirstScanTime(System.currentTimeMillis() - this.startBluetoothDiscoveryTime);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onError(String str) {
        this.mTraceMonitorImpl.onError(str);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onConnectedSuccessful(String str, long j, int i) {
        this.connectedTime = System.currentTimeMillis();
        this.mTraceMonitorImpl.onConnectedSuccessful(str, System.currentTimeMillis() - this.startConnectTime, i);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onConnect(String str, int i) {
        this.startConnectTime = System.currentTimeMillis();
        this.mTraceMonitorImpl.onConnect(str, i);
        this.discoverTime = System.currentTimeMillis();
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDisconnectBLE(String str, long j, int i) {
        this.mTraceMonitorImpl.onDisconnectBLE(str, System.currentTimeMillis() - this.connectedTime, i);
        this.connectedTime = 0L;
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onServicesDiscovered(long j, int i) {
        this.mTraceMonitorImpl.onServicesDiscovered(System.currentTimeMillis() - this.discoverTime, i);
        this.discoverTime = 0L;
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCharacteristicRead(String str, int i) {
        this.mTraceMonitorImpl.onCharacteristicRead(str, i);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCharacteristicWrite(int i) {
        this.mTraceMonitorImpl.onCharacteristicWrite(i);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCharacteristicWriteCompleted(long j) {
        this.mTraceMonitorImpl.onCharacteristicWriteCompleted(j);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onStartBleScan(String[] strArr, boolean z, int i) {
        this.startBluetoothDiscoveryTime = System.currentTimeMillis();
        this.mTraceMonitorImpl.onStartBleScan(strArr, z, i);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onStopBleScan() {
        this.mTraceMonitorImpl.onStopBleScan();
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onGetBluetoothDevices(String str) {
        this.mTraceMonitorImpl.onGetBluetoothDevices(str);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDisconnect(String str) {
        this.mTraceMonitorImpl.onDisconnect(str);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onDisconnectAllDevices() {
        this.mTraceMonitorImpl.onDisconnectAllDevices();
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onGetBluetoothServices(String str) {
        this.mTraceMonitorImpl.onGetBluetoothServices(str);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onGetBluetoothCharacteristics(String str, String str2) {
        this.mTraceMonitorImpl.onGetBluetoothCharacteristics(str, str2);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onReadData(String str, String str2, String str3) {
        this.mTraceMonitorImpl.onReadData(str, str2, str3);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onSendData(String str, String str2, String str3, String str4) {
        this.writeTime = System.currentTimeMillis();
        this.mTraceMonitorImpl.onSendData(str, str2, str3, str4);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onWriteValue(long j) {
        this.mTraceMonitorImpl.onWriteValue(System.currentTimeMillis() - this.writeTime);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onNotifyCharacteristicValue(String str, String str2, String str3, String str4, boolean z) {
        this.mTraceMonitorImpl.onNotifyCharacteristicValue(str, str2, str3, str4, z);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onOpenBluetoothAdapter() {
        this.openBluetoothAdapterTime = System.currentTimeMillis();
        this.mTraceMonitorImpl.onOpenBluetoothAdapter();
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onTimeout(String str) {
        this.mTraceMonitorImpl.onTimeout(str);
    }

    @Override // com.alibaba.griver.bluetooth.proxy.IBLETraceMonitor
    public void onCloseBluetoothAdapter(long j) {
        this.mTraceMonitorImpl.onCloseBluetoothAdapter(System.currentTimeMillis() - this.openBluetoothAdapterTime);
    }
}
