package com.alibaba.griver.bluetooth.altbeacon.beacon.service.scanner;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes6.dex */
public interface NonBeaconLeScanCallback {
    void onNonBeaconLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
}
