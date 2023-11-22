package com.alibaba.griver.bluetooth.ble;

import android.content.Context;
import com.alibaba.griver.bluetooth.ble.model.BleDevice;
import com.alibaba.griver.bluetooth.ble.model.BleResult;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothHelper;
import java.util.List;

/* loaded from: classes2.dex */
public class BetterBleServiceImpl implements BetterBleService {
    private static final String TAG = "BetterBleServiceImpl";
    private BLEManager bleManager;
    private Context mContext;

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void onDestroy() {
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void onCreate(Context context) {
        this.mContext = context;
        this.bleManager = new BLEManager(context);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public boolean isSupportBLE() {
        return BluetoothHelper.isSupportBLE(this.mContext);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void registerBLEState() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            bLEManager.registerBLEState();
            return;
        }
        BLEManager bLEManager2 = new BLEManager(this.mContext);
        this.bleManager = bLEManager2;
        bLEManager2.registerBLEState();
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public boolean enableBluetooth() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.enableBluetooth();
        }
        BLEManager bLEManager2 = new BLEManager(this.mContext);
        this.bleManager = bLEManager2;
        return bLEManager2.enableBluetooth();
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public boolean disableBluetooth() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.disableBluetooth();
        }
        BLEManager bLEManager2 = new BLEManager(this.mContext);
        this.bleManager = bLEManager2;
        return bLEManager2.disableBluetooth();
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public int getBluetoothState() {
        return BluetoothHelper.getBluetoothState().ordinal();
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void openBluetoothAdapter() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            bLEManager.openBluetoothAdapter();
            return;
        }
        BLEManager bLEManager2 = new BLEManager(this.mContext);
        this.bleManager = bLEManager2;
        bLEManager2.openBluetoothAdapter();
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void closeBluetoothAdapter() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            bLEManager.closeBluetoothAdapter();
        }
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public boolean isDiscovering() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.isDiscovering();
        }
        return false;
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public boolean isOpened() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.isOpened();
        }
        return false;
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult startBluetoothDevicesDiscovery(String[] strArr, boolean z, int i) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.startBleScan(strArr, z, i);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void stopBluetoothDevicesDiscovery() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            bLEManager.stopBleScan(true);
        }
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public List<BleDevice> getBluetoothDevices() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.getBluetoothDevices();
        }
        return null;
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public List<BleDevice> getConnectedBluetoothDevices() {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.getConnectedBluetoothDevices();
        }
        return null;
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult connectBluetoothDevice(String str, int i) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.connect(str, i);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult disconnectBluetoothDevice(String str) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.disconnectAndClose(str);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public void setBetterBleListener(BetterBleListener betterBleListener) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            bLEManager.setBetterBleListener(betterBleListener);
        }
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult getBluetoothServices(String str) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.getBluetoothServices(str);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult getBluetoothCharacteristics(String str, String str2) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.getBluetoothCharacteristics(str, str2);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult sendData(String str, String str2, String str3, String str4) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.sendData(str, str2, str3, str4);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult readData(String str, String str2, String str3) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.readData(str, str2, str3);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }

    @Override // com.alibaba.griver.bluetooth.ble.BetterBleService
    public BleResult notifyCharacteristicValueChange(String str, String str2, String str3, String str4, boolean z) {
        BLEManager bLEManager = this.bleManager;
        if (bLEManager != null) {
            return bLEManager.notifyCharacteristicValue(str, str2, str3, str4, z);
        }
        return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
    }
}
