package com.alibaba.griver.bluetooth.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alibaba.griver.bluetooth.ble.model.BleDevice;
import com.alibaba.griver.bluetooth.ble.model.BleGattCharacteristic;
import com.alibaba.griver.bluetooth.ble.model.BleGattService;
import com.alibaba.griver.bluetooth.ble.model.BleResult;
import com.alibaba.griver.bluetooth.ble.model.ScanRecord;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothHelper;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothLeUtils;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes6.dex */
public class BLEManager {
    private static final String DEFAULT_DESCRIPTOR_UUID = "00002902-0000-1000-8000-00805f9b34fb";
    private static final String KEY_ENABLE_CLOSE_ON_DISCONNECT = "ble_close_on_disconnect";
    private static final String KEY_LOCATION_PERMISSION_CHECK = "ble_location_permission_check";
    private static final int MIN_SCAN_INTERVAL_TIME = 100;
    private static final String TAG = "BLEManager";
    private BetterBleListener betterBleListener;
    private BluetoothManager bluetoothManager;
    private BroadcastReceiver bluetoothReceiver;
    private byte[] bytes;
    private boolean connectedCallbackCalled;
    private Context context;
    private boolean isOpened;
    private int mBufferOffset;
    private int scanInterval;
    public static final byte[] PlaceComponentResult = {18, 119, 36, -59, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int getAuthRequestContext = 181;
    private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.1
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (BLEManager.this.deviceMap == null || BLEManager.this.deviceMap.isEmpty()) {
                BLETraceMonitor.getInstance().onFirstScanTime(0L);
            }
            if (BLEManager.this.deviceMap.containsKey(bluetoothDevice.getAddress())) {
                if (BLEManager.this.allowDuplicatesKey) {
                    ScanRecord parseFromBytes = ScanRecord.parseFromBytes(bArr);
                    BleDevice bleDevice = (BleDevice) BLEManager.this.deviceMap.get(bluetoothDevice.getAddress());
                    bleDevice.manufacturerData = BluetoothHelper.getManufacturerData(bArr);
                    bleDevice.advertisData = bleDevice.manufacturerData;
                    bleDevice.advertisServiceUUIDs = parseFromBytes.getServiceUuids();
                    bleDevice.serviceData = parseFromBytes.getServiceData();
                    bleDevice.RSSI = i;
                    if (BLEManager.this.scanInterval == 0) {
                        if (BLEManager.this.betterBleListener != null) {
                            BLEManager.this.foundedDeviceList.clear();
                            BLEManager.this.foundedDeviceList.add(bleDevice);
                            BLEManager.this.betterBleListener.onBluetoothDeviceFound(BLEManager.this.foundedDeviceList);
                            return;
                        }
                        return;
                    } else if (BLEManager.this.foundedDeviceList.contains(bleDevice)) {
                        return;
                    } else {
                        BLEManager.this.foundedDeviceList.add(bleDevice);
                        return;
                    }
                }
                return;
            }
            ScanRecord parseFromBytes2 = ScanRecord.parseFromBytes(bArr);
            BleDevice createBleDevice = BleDevice.createBleDevice(bluetoothDevice);
            createBleDevice.RSSI = i;
            createBleDevice.manufacturerData = BluetoothHelper.getManufacturerData(bArr);
            createBleDevice.advertisData = createBleDevice.manufacturerData;
            createBleDevice.advertisServiceUUIDs = parseFromBytes2.getServiceUuids();
            createBleDevice.serviceData = parseFromBytes2.getServiceData();
            BLEManager.this.deviceMap.put(bluetoothDevice.getAddress(), createBleDevice);
            if (BLEManager.this.scanInterval == 0) {
                if (BLEManager.this.betterBleListener != null) {
                    BLEManager.this.foundedDeviceList.clear();
                    BLEManager.this.foundedDeviceList.add(createBleDevice);
                    BLEManager.this.betterBleListener.onBluetoothDeviceFound(BLEManager.this.foundedDeviceList);
                }
            } else if (BLEManager.this.foundedDeviceList.contains(createBleDevice)) {
            } else {
                BLEManager.this.foundedDeviceList.add(createBleDevice);
            }
        }
    };
    private BluetoothGattCallback bluetoothGattCallback = new BluetoothGattCallback() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(final BluetoothGatt bluetoothGatt, final int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if (i2 == 2) {
                if (!BLEManager.this.currentConnectedDeviceMap.containsKey(bluetoothGatt.getDevice().getAddress())) {
                    if (bluetoothGatt.discoverServices()) {
                        BLEManager.this.connectHandler.postDelayed(new Runnable() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BLEManager.this.triggerConnectedCallback(bluetoothGatt);
                                BLETraceMonitor.getInstance().onConnectedSuccessful(bluetoothGatt.getDevice().getAddress(), 0L, i);
                            }
                        }, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
                    }
                    BleDevice createConnectedBleDevice = BleDevice.createConnectedBleDevice(bluetoothGatt.getDevice(), bluetoothGatt);
                    BLEManager.this.currentConnectedDeviceMap.put(bluetoothGatt.getDevice().getAddress(), createConnectedBleDevice);
                    if (!BLEManager.this.allConnectedDeviceMap.containsKey(bluetoothGatt.getDevice().getAddress())) {
                        BLEManager.this.allConnectedDeviceMap.put(bluetoothGatt.getDevice().getAddress(), createConnectedBleDevice);
                    }
                }
            } else if (i2 == 0) {
                if (BLEManager.this.enableCloseOnDisconnect || BLEManager.this.closeDevice) {
                    BLEManager.this.handler.post(new Runnable() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BLEManager.this.closeDevice = false;
                            BLEManager.this.close((BleDevice) BLEManager.this.allConnectedDeviceMap.get(bluetoothGatt.getDevice().getAddress()));
                        }
                    });
                }
                BLEManager.this.currentConnectedDeviceMap.remove(bluetoothGatt.getDevice().getAddress());
                BLETraceMonitor.getInstance().onDisconnectBLE(bluetoothGatt.getDevice().getAddress(), 0L, i);
            }
            if (BLEManager.this.betterBleListener == null || i2 == 2) {
                return;
            }
            BLEManager.this.connectHandler.removeCallbacksAndMessages(null);
            BLEManager.this.betterBleListener.onBluetoothConnectionStateChange(bluetoothGatt.getDevice().getAddress(), false);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(final BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            bluetoothGatt.getServices();
            BLEManager.this.connectHandler.post(new Runnable() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.2.3
                @Override // java.lang.Runnable
                public void run() {
                    BLEManager.this.triggerConnectedCallback(bluetoothGatt);
                }
            });
            BLETraceMonitor.getInstance().onServicesDiscovered(0L, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            String bytesToHexString = BluetoothHelper.bytesToHexString(bluetoothGattCharacteristic.getValue());
            if (BLEManager.this.betterBleListener != null) {
                BLEManager.this.betterBleListener.onBluetoothCharacteristicRead(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString(), bluetoothGattCharacteristic.getUuid().toString(), bytesToHexString);
                BLEManager.this.betterBleListener.onBluetoothCharacteristicValueChange(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString(), bluetoothGattCharacteristic.getUuid().toString(), bytesToHexString);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (BLEManager.this.mBufferOffset < BLEManager.this.bytes.length) {
                int min = Math.min(BLEManager.this.bytes.length - BLEManager.this.mBufferOffset, 20);
                byte[] bArr = new byte[min];
                System.arraycopy(BLEManager.this.bytes, BLEManager.this.mBufferOffset, bArr, 0, min);
                BLEManager.this.mBufferOffset += min;
                bluetoothGattCharacteristic.setValue(bArr);
                bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
            if (BLEManager.this.betterBleListener != null) {
                BLEManager.this.betterBleListener.onBluetoothCharacteristicWrite(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString(), bluetoothGattCharacteristic.getUuid().toString());
            }
            BLETraceMonitor.getInstance().onCharacteristicWrite(0);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            String bytesToHexString = BluetoothHelper.bytesToHexString(bluetoothGattCharacteristic.getValue());
            if (BLEManager.this.betterBleListener != null) {
                BLEManager.this.betterBleListener.onBluetoothCharacteristicValueChange(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getService().getUuid().toString(), bluetoothGattCharacteristic.getUuid().toString(), bytesToHexString);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            if (bluetoothGattDescriptor == null || bluetoothGattDescriptor.getCharacteristic() == null || BLEManager.this.betterBleListener == null) {
                return;
            }
            BLEManager.this.betterBleListener.onBluetoothDescriptorWrite(bluetoothGatt.getDevice().getAddress(), bluetoothGattDescriptor.getCharacteristic().getService().getUuid().toString(), bluetoothGattDescriptor.getCharacteristic().getUuid().toString(), bluetoothGattDescriptor.getUuid().toString());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        }
    };
    private Map<String, BleDevice> deviceMap = new HashMap();
    private Map<String, BleDevice> currentConnectedDeviceMap = new HashMap();
    private Map<String, BleDevice> allConnectedDeviceMap = new HashMap();
    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private boolean isDiscovering = false;
    private boolean closeDevice = false;
    private boolean allowDuplicatesKey = false;
    private List<BleDevice> foundedDeviceList = new ArrayList();
    private Handler handler = new Handler(Looper.getMainLooper());
    private Handler connectHandler = new Handler(Looper.getMainLooper());
    private ScanHandler scanHandler = new ScanHandler(Looper.getMainLooper());
    private boolean enableCloseOnDisconnect = true;

    public BLEManager(Context context) {
        this.context = context;
        this.bluetoothManager = (BluetoothManager) context.getSystemService(TinyAppActionState.ACTION_BLUE_TOOTH);
    }

    public void setBetterBleListener(BetterBleListener betterBleListener) {
        this.betterBleListener = betterBleListener;
    }

    public void reset() {
        unregisterReceiver();
        stopBleScan(false);
    }

    public void registerBLEState() {
        registerReceiver();
    }

    public boolean enableBluetooth() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        String config = rVConfigService != null ? rVConfigService.getConfig("ta_ble_enable_forcibly", "YES") : null;
        if (this.bluetoothAdapter == null || !TextUtils.equals(config, "YES")) {
            return false;
        }
        if (!this.bluetoothAdapter.isEnabled()) {
            return this.bluetoothAdapter.enable();
        }
        return this.bluetoothAdapter.isEnabled();
    }

    public boolean disableBluetooth() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        if (bluetoothAdapter == null) {
            return false;
        }
        if (bluetoothAdapter.isEnabled()) {
            return this.bluetoothAdapter.disable();
        }
        return this.bluetoothAdapter.isEnabled();
    }

    public void openBluetoothAdapter() {
        reset();
        registerReceiver();
        BLETraceMonitor.getInstance().onOpenBluetoothAdapter();
        this.isOpened = true;
    }

    public void closeBluetoothAdapter() {
        unregisterReceiver();
        stopBleScan(false);
        disconnectAndClose();
        this.foundedDeviceList.clear();
        BLETraceMonitor.getInstance().onCloseBluetoothAdapter(0L);
        this.isOpened = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerConnectedCallback(BluetoothGatt bluetoothGatt) {
        BetterBleListener betterBleListener = this.betterBleListener;
        if (betterBleListener == null || this.connectedCallbackCalled) {
            return;
        }
        betterBleListener.onBluetoothConnectionStateChange(bluetoothGatt.getDevice().getAddress(), true);
        this.connectedCallbackCalled = true;
    }

    private void registerReceiver() {
        if (this.bluetoothReceiver != null) {
            return;
        }
        this.bluetoothReceiver = new BroadcastReceiver() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                if (intExtra != 10) {
                    if (intExtra != 12 || BLEManager.this.betterBleListener == null) {
                        return;
                    }
                    BLEManager.this.betterBleListener.onBluetoothAdapterStateChange(true, BLEManager.this.isDiscovering);
                } else if (BLEManager.this.betterBleListener != null) {
                    BLEManager.this.betterBleListener.onBluetoothAdapterStateChange(false, BLEManager.this.isDiscovering);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.context.registerReceiver(this.bluetoothReceiver, intentFilter);
    }

    private void unregisterReceiver() {
        BroadcastReceiver broadcastReceiver = this.bluetoothReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
        }
        this.bluetoothReceiver = null;
    }

    public boolean isDiscovering() {
        return this.isDiscovering;
    }

    public boolean isOpened() {
        return this.isOpened;
    }

    public BleResult startBleScan(String[] strArr, boolean z, int i) {
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        }
        if (this.isDiscovering) {
            return new BleResult(true, true);
        }
        this.allowDuplicatesKey = z;
        this.scanInterval = i >= 100 ? i : 0;
        this.deviceMap.clear();
        this.foundedDeviceList.clear();
        int i2 = this.scanInterval;
        if (i2 > 0) {
            this.scanHandler.sendEmptyMessageDelayed(0, i2);
        }
        if (this.bluetoothAdapter == null) {
            return new BleResult(false, true);
        }
        BLETraceMonitor.getInstance().onStartBleScan(strArr, z, i);
        if (strArr != null && strArr.length > 0) {
            UUID[] uuidArr = new UUID[strArr.length];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                UUID uUIDFromString = BluetoothHelper.getUUIDFromString(strArr[i3]);
                if (uUIDFromString != null) {
                    uuidArr[i3] = uUIDFromString;
                } else {
                    return new BleResult(false, true, ErrorConstants.ERROR_SCAN_INVALID_UUID);
                }
            }
            boolean startLeScan = this.bluetoothAdapter.startLeScan(uuidArr, this.leScanCallback);
            this.isDiscovering = startLeScan;
            return new BleResult(startLeScan, true);
        }
        boolean startLeScan2 = this.bluetoothAdapter.startLeScan(this.leScanCallback);
        this.isDiscovering = startLeScan2;
        return new BleResult(startLeScan2, true);
    }

    public void stopBleScan(boolean z) {
        if (BluetoothHelper.isSupportBLE(this.context)) {
            if (z) {
                BLETraceMonitor.getInstance().onStopBleScan();
            }
            this.isDiscovering = false;
            this.foundedDeviceList.clear();
            this.scanHandler.removeCallbacksAndMessages(null);
            BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.stopLeScan(this.leScanCallback);
            }
        }
    }

    public List<BleDevice> getBluetoothDevices() {
        Map<String, BleDevice> map = this.deviceMap;
        if (map != null && !map.isEmpty()) {
            BLETraceMonitor.getInstance().onGetBluetoothDevices(this.deviceMap.keySet().toString());
        }
        return new ArrayList(this.deviceMap.values());
    }

    public List<BleDevice> getConnectedBluetoothDevices() {
        List<BluetoothDevice> connectedDevices = this.bluetoothManager.getConnectedDevices(7);
        if (connectedDevices != null && !connectedDevices.isEmpty()) {
            ArrayList arrayList = new ArrayList(connectedDevices.size());
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                arrayList.add(BleDevice.createBleDevice(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4 A[Catch: Exception -> 0x00fa, TRY_LEAVE, TryCatch #2 {Exception -> 0x00fa, blocks: (B:32:0x009e, B:34:0x00a4), top: B:61:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00eb -> B:42:0x00f2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.griver.bluetooth.ble.model.BleResult connect(java.lang.String r20, int r21) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.ble.BLEManager.connect(java.lang.String, int):com.alibaba.griver.bluetooth.ble.model.BleResult");
    }

    public BleResult disconnect(String str) {
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        }
        if (this.bluetoothAdapter == null) {
            return new BleResult(false, true, ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED);
        }
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICEID_INVALID);
        }
        BleDevice bleDevice = this.allConnectedDeviceMap.get(str);
        if (bleDevice != null && bleDevice.gatt != null) {
            bleDevice.gatt.disconnect();
            BLETraceMonitor.getInstance().onDisconnect(str);
            return new BleResult(true, false);
        }
        return new BleResult(true, true);
    }

    public Collection<BleDevice> disconnectAllDevices() {
        if (BluetoothHelper.isSupportBLE(this.context) && this.bluetoothAdapter != null) {
            ArrayList<BleDevice> arrayList = new ArrayList(this.allConnectedDeviceMap.values());
            for (BleDevice bleDevice : arrayList) {
                if (bleDevice.gatt != null) {
                    bleDevice.gatt.disconnect();
                }
            }
            return arrayList;
        }
        return null;
    }

    public void close(BleDevice bleDevice) {
        if (BluetoothHelper.isSupportBLE(this.context) && bleDevice != null) {
            bleDevice.gatt.close();
            this.currentConnectedDeviceMap.remove(bleDevice.deviceId);
            this.allConnectedDeviceMap.remove(bleDevice.deviceId);
        }
    }

    public void closeAll(Collection<BleDevice> collection) {
        if (BluetoothHelper.isSupportBLE(this.context)) {
            if (collection != null) {
                for (BleDevice bleDevice : collection) {
                    if (bleDevice.gatt != null) {
                        bleDevice.gatt.close();
                    }
                }
            }
            this.currentConnectedDeviceMap.clear();
            this.allConnectedDeviceMap.clear();
            this.deviceMap.clear();
        }
    }

    public BleResult disconnectAndClose(String str) {
        if (this.allConnectedDeviceMap.containsKey(str)) {
            this.closeDevice = true;
        }
        return disconnect(str);
    }

    public void disconnectAndClose() {
        final Collection<BleDevice> disconnectAllDevices = disconnectAllDevices();
        this.handler.postDelayed(new Runnable() { // from class: com.alibaba.griver.bluetooth.ble.BLEManager.4
            @Override // java.lang.Runnable
            public void run() {
                BLEManager.this.closeAll(disconnectAllDevices);
            }
        }, 200L);
    }

    public BleResult getBluetoothServices(String str) {
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        }
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICEID_INVALID);
        }
        if (!this.currentConnectedDeviceMap.containsKey(str)) {
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICE_NOT_FOUND);
        }
        BleResult bleResult = new BleResult();
        ArrayList arrayList = new ArrayList();
        List<BluetoothGattService> services = this.currentConnectedDeviceMap.get(str).gatt.getServices();
        if (services != null) {
            for (BluetoothGattService bluetoothGattService : services) {
                BleGattService bleGattService = new BleGattService();
                bleGattService.serviceId = bluetoothGattService.getUuid().toString();
                bleGattService.isPrimary = bluetoothGattService.getType() == 0;
                arrayList.add(bleGattService);
            }
        }
        bleResult.success = true;
        bleResult.syncReturn = true;
        bleResult.obj = arrayList;
        return bleResult;
    }

    public BleResult getBluetoothCharacteristics(String str, String str2) {
        List<BluetoothGattCharacteristic> characteristics;
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_UNSUPPORT_BLE[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICEID_INVALID[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICEID_INVALID);
        } else if (!this.currentConnectedDeviceMap.containsKey(str)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICE_NOT_FOUND[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICE_NOT_FOUND);
        } else {
            UUID uUIDFromString = BluetoothHelper.getUUIDFromString(str2);
            if (uUIDFromString == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_SERVICEID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_SERVICEID_INVALID);
            }
            BLETraceMonitor.getInstance().onGetBluetoothCharacteristics(str, str2);
            BleResult bleResult = new BleResult();
            ArrayList arrayList = new ArrayList();
            BluetoothGattService service = this.currentConnectedDeviceMap.get(str).gatt.getService(uUIDFromString);
            if (service != null && (characteristics = service.getCharacteristics()) != null) {
                Iterator<BluetoothGattCharacteristic> it = characteristics.iterator();
                while (it.hasNext()) {
                    arrayList.add(BleGattCharacteristic.createCharacteristic(it.next()));
                }
            }
            bleResult.success = true;
            bleResult.syncReturn = true;
            bleResult.obj = arrayList;
            return bleResult;
        }
    }

    public BleResult readData(String str, String str2, String str3) {
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_UNSUPPORT_BLE[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICEID_INVALID[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICEID_INVALID);
        } else {
            BleDevice bleDevice = this.currentConnectedDeviceMap.get(str);
            if (bleDevice == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICE_NOT_FOUND[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_DEVICE_NOT_FOUND);
            }
            UUID uUIDFromString = BluetoothHelper.getUUIDFromString(str2);
            if (uUIDFromString == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_SERVICEID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_SERVICEID_INVALID);
            }
            UUID uUIDFromString2 = BluetoothHelper.getUUIDFromString(str3);
            if (uUIDFromString2 == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_CHARACTERISTICID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_CHARACTERISTICID_INVALID);
            }
            BluetoothGattService service = bleDevice.gatt.getService(uUIDFromString);
            BleResult bleResult = new BleResult(false, true);
            if (service != null) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(uUIDFromString2);
                BLETraceMonitor.getInstance().onReadData(str, str2, str3);
                if (characteristic != null) {
                    if ((characteristic.getProperties() & 2) == 0) {
                        bleResult.error = ErrorConstants.ERROR_CHARACTERISTIC_OPERATION_NOT_SUPPORT;
                        return bleResult;
                    }
                    boolean readCharacteristic = bleDevice.gatt.readCharacteristic(characteristic);
                    bleResult.success = readCharacteristic;
                    bleResult.syncReturn = !readCharacteristic;
                    if (readCharacteristic) {
                        bleResult.obj = BleGattCharacteristic.createCharacteristic(characteristic);
                        return bleResult;
                    }
                    bleResult.error = ErrorConstants.ERROR_READ_CHARACTERISTIC_FAIL;
                    return bleResult;
                }
                bleResult.error = ErrorConstants.ERROR_CHARACTERISTIC_NOT_FOUND;
            } else {
                bleResult.error = ErrorConstants.ERROR_SERVICE_NOT_FOUND;
            }
            return bleResult;
        }
    }

    public BleResult sendData(String str, String str2, String str3, String str4) {
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_UNSUPPORT_BLE[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICEID_INVALID[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICEID_INVALID);
        } else {
            UUID uUIDFromString = BluetoothHelper.getUUIDFromString(str2);
            if (uUIDFromString == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_SERVICEID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_SERVICEID_INVALID);
            }
            UUID uUIDFromString2 = BluetoothHelper.getUUIDFromString(str3);
            if (uUIDFromString2 == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_CHARACTERISTICID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_CHARACTERISTICID_INVALID);
            }
            BleDevice bleDevice = this.currentConnectedDeviceMap.get(str);
            if (bleDevice == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICE_NOT_FOUND[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_DEVICE_NOT_FOUND);
            }
            BluetoothGattService service = bleDevice.gatt.getService(uUIDFromString);
            BleResult bleResult = new BleResult(false, true);
            if (service != null) {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(uUIDFromString2);
                if (characteristic != null) {
                    if ((characteristic.getProperties() & 4) > 0) {
                        characteristic.setWriteType(1);
                    }
                    BLETraceMonitor.getInstance().onSendData(str, str2, str3, str4);
                    boolean writeValue = writeValue(bleDevice.gatt, characteristic, str4);
                    bleResult.success = writeValue;
                    bleResult.syncReturn = !writeValue;
                    if (!writeValue) {
                        bleResult.error = ErrorConstants.ERROR_WRITE_CHARACTERISTIC_FAIL;
                    }
                    return bleResult;
                }
                bleResult.error = ErrorConstants.ERROR_CHARACTERISTIC_NOT_FOUND;
            } else {
                bleResult.error = ErrorConstants.ERROR_SERVICE_NOT_FOUND;
            }
            return bleResult;
        }
    }

    private boolean writeValue(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
        this.mBufferOffset = 0;
        if (str != null && (str.startsWith("0X") || str.startsWith("0x"))) {
            str = str.substring(2);
        }
        if (str.length() % 2 == 0) {
            this.bytes = new byte[str.length() / 2];
            int i = 0;
            while (true) {
                byte[] bArr = this.bytes;
                if (i < bArr.length) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (BluetoothLeUtils.safeParseInt(str.substring(i2, i2 + 2), 16) & 255);
                    i++;
                } else {
                    int min = Math.min(bArr.length, 20);
                    this.mBufferOffset += min;
                    byte[] bArr2 = new byte[min];
                    System.arraycopy(this.bytes, 0, bArr2, 0, min);
                    bluetoothGattCharacteristic.setValue(bArr2);
                    try {
                        BLETraceMonitor.getInstance().onWriteValue(0L);
                        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return false;
    }

    public BleResult notifyCharacteristicValue(String str, String str2, String str3, String str4, boolean z) {
        List<BluetoothGattDescriptor> descriptors;
        List<BluetoothGattDescriptor> descriptors2;
        if (!BluetoothHelper.isSupportBLE(this.context)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_UNSUPPORT_BLE[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_UNSUPPORT_BLE);
        } else if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICEID_INVALID[1]);
            return new BleResult(false, true, ErrorConstants.ERROR_DEVICEID_INVALID);
        } else {
            BleDevice bleDevice = this.currentConnectedDeviceMap.get(str);
            if (bleDevice == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_DEVICE_NOT_FOUND[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_DEVICE_NOT_FOUND);
            }
            UUID uUIDFromString = BluetoothHelper.getUUIDFromString(str2);
            if (uUIDFromString == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_SERVICEID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_SERVICEID_INVALID);
            }
            UUID uUIDFromString2 = BluetoothHelper.getUUIDFromString(str3);
            if (uUIDFromString2 == null) {
                BLETraceMonitor.getInstance().onError(ErrorConstants.ERROR_CHARACTERISTICID_INVALID[1]);
                return new BleResult(false, true, ErrorConstants.ERROR_CHARACTERISTICID_INVALID);
            }
            BluetoothGatt bluetoothGatt = bleDevice.gatt;
            BluetoothGattService service = bluetoothGatt.getService(uUIDFromString);
            BLETraceMonitor.getInstance().onNotifyCharacteristicValue(str, str2, str3, str4, z);
            BleResult bleResult = new BleResult(false, true);
            if (service != null) {
                if (!TextUtils.isEmpty(str3)) {
                    BluetoothGattCharacteristic characteristic = service.getCharacteristic(uUIDFromString2);
                    if (characteristic != null) {
                        int properties = characteristic.getProperties();
                        String str5 = DEFAULT_DESCRIPTOR_UUID;
                        if ((properties & 16) != 0) {
                            bluetoothGatt.setCharacteristicNotification(characteristic, z);
                            if (!TextUtils.isEmpty(str4)) {
                                str5 = str4;
                            }
                            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(BluetoothHelper.getUUIDFromString(str5));
                            if (descriptor == null && (descriptors2 = characteristic.getDescriptors()) != null && descriptors2.size() > 0) {
                                descriptor = descriptors2.get(0);
                            }
                            if (descriptor != null) {
                                descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                                bluetoothGatt.writeDescriptor(descriptor);
                            }
                            bleResult.success = true;
                            bleResult.syncReturn = false;
                        } else if ((properties & 32) != 0) {
                            bluetoothGatt.setCharacteristicNotification(characteristic, z);
                            if (!TextUtils.isEmpty(str4)) {
                                str5 = str4;
                            }
                            BluetoothGattDescriptor descriptor2 = characteristic.getDescriptor(BluetoothHelper.getUUIDFromString(str5));
                            if (descriptor2 == null && (descriptors = characteristic.getDescriptors()) != null && descriptors.size() > 0) {
                                descriptor2 = descriptors.get(0);
                            }
                            if (descriptor2 != null) {
                                descriptor2.setValue(z ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                                bluetoothGatt.writeDescriptor(descriptor2);
                            }
                            bleResult.success = true;
                            bleResult.syncReturn = false;
                        } else {
                            bleResult.error = ErrorConstants.ERROR_CHARACTERISTIC_OPERATION_NOT_SUPPORT;
                        }
                    } else {
                        bleResult.error = ErrorConstants.ERROR_CHARACTERISTIC_NOT_FOUND;
                    }
                }
            } else {
                bleResult.error = ErrorConstants.ERROR_SERVICE_NOT_FOUND;
            }
            return bleResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ScanHandler extends Handler {
        public ScanHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (BLEManager.this.betterBleListener != null && !BLEManager.this.foundedDeviceList.isEmpty()) {
                BLEManager.this.betterBleListener.onBluetoothDeviceFound(BLEManager.this.foundedDeviceList);
            }
            BLEManager.this.foundedDeviceList.clear();
            sendEmptyMessageDelayed(0, BLEManager.this.scanInterval);
        }
    }
}
