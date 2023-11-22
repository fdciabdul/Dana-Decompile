package com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes6.dex */
public interface CycledLeScanCallback {
    void onCycleEnd();

    void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
}
