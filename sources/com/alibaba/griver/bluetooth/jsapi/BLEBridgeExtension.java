package com.alibaba.griver.bluetooth.jsapi;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.PermissionUtils;
import com.alibaba.griver.bluetooth.ble.BLEOperation;
import com.alibaba.griver.bluetooth.ble.BLETraceMonitor;
import com.alibaba.griver.bluetooth.ble.BetterBleListener;
import com.alibaba.griver.bluetooth.ble.BetterBleService;
import com.alibaba.griver.bluetooth.ble.BetterBleServiceImpl;
import com.alibaba.griver.bluetooth.ble.ErrorConstants;
import com.alibaba.griver.bluetooth.ble.model.BleDevice;
import com.alibaba.griver.bluetooth.ble.model.BleGattCharacteristic;
import com.alibaba.griver.bluetooth.ble.model.BleResult;
import com.alibaba.griver.bluetooth.ble.model.BluetoothState;
import com.alibaba.griver.bluetooth.ble.model.TimeOutContext;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothLeUtils;
import com.alibaba.griver.bluetooth.proxy.RVBluetoothProxy;
import com.alibaba.griver.bluetooth.workflow.BLEServiceUnit;
import com.alibaba.griver.bluetooth.workflow.BLEStateUnit;
import com.alibaba.griver.bluetooth.workflow.SimpleWorkflowUnit;
import com.alibaba.griver.bluetooth.workflow.Workflow;
import id.dana.utils.permission.ManifestPermission;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class BLEBridgeExtension implements BridgeExtension, PageDestroyPoint, NodeAware<App> {
    private static final String CONFIG_KEY_BLE_CONNECT_MAX_TIMEOUT = "BLE_CONNECT_MAXTIMEOUT";
    private static final String EVENT_BLE_CHARACTERISTIC_VALUE_CHANGE = "BLECharacteristicValueChange";
    private static final String EVENT_BLE_CONNECTION_STATE_CHANGE = "BLEConnectionStateChanged";
    private static final String EVENT_BLUETOOTH_ADAPTER_STATE_CHANGE = "bluetoothAdapterStateChange";
    private static final String EVENT_BLUETOOTH_DEVICE_FOUND = "bluetoothDeviceFound";
    private static final String FUNC_CONNECT_BLE_DEVICE = "connectBLEDevice";
    private static final String FUNC_DISCONNECT_BLE_DEVICE = "disconnectBLEDevice";
    private static final String FUNC_NOTIFY_BLE_CHARACTERISTIC_VALUE_CHANGE = "notifyBLECharacteristicValueChange";
    private static final String FUNC_READ_BLE_CHARACTERISTIC_VALUE = "readBLECharacteristicValue";
    private static final String FUNC_WRITE_BLE_CHARACTERISTIC_VALUE = "writeBLECharacteristicValue";
    private static final int INVALID_TIMEOUT = -1;
    private static final String KEY_ALLOWDUPLICATESKEY = "allowDuplicatesKey";
    private static final String KEY_AUTO_CLOSE_ON_PAGE_OFF = "autoClose";
    private static final String KEY_AVAILABLE = "available";
    private static final String KEY_CHARACTERISTIC = "characteristic";
    private static final String KEY_CHARACTERISTICS = "characteristics";
    private static final String KEY_CHARACTERISTIC_ID = "characteristicId";
    private static final String KEY_CONNECTED = "connected";
    private static final String KEY_DATA = "data";
    private static final String KEY_DESCRIPTOR_ID = "descriptorId";
    private static final String KEY_DEVICES = "devices";
    private static final String KEY_DEVICE_ID = "deviceId";
    private static final String KEY_DISCOVERING = "discovering";
    private static final String KEY_ERROR = "error";
    private static final String KEY_ERROR_MESSAGE = "errorMessage";
    private static final String KEY_INTERVAL = "interval";
    private static final String KEY_IS_SUPPORT_BLE = "isSupportBLE";
    private static final String KEY_SERVICES = "services";
    private static final String KEY_SERVICE_ID = "serviceId";
    private static final String KEY_STATE = "state";
    private static final String KEY_TIMEOUT = "timeout";
    private static final String KEY_TRANSPORT = "transport";
    private static final String KEY_VALUE = "value";
    private static final int MSG_CALLBACK_CONNECT_BLE_DEVICE = 101;
    private static final int MSG_CALLBACK_DISCONNECT_BLE_DEVICE = 102;
    private static final int MSG_CALLBACK_NOTIFY_BLE_CHARACTERISTIC = 105;
    private static final int MSG_CALLBACK_READ_BLE_CHARACTERISTIC = 104;
    private static final int MSG_CALLBACK_WRITE_BLE_CHARACTERISTIC = 103;
    private static final int MSG_DELAY_TIME = 10000;
    private static final int MSG_DELAY_TIME_FOR_NOTIFY = 10000;
    private static final int MSG_OPERATION_HANDLED = 0;
    private static final int MSG_SHIFT = 100;
    private static final int MSG_TIMEOUT_CONNECT_BLE_DEVICE = 1;
    private static final int MSG_TIMEOUT_DISCONNECT_BLE_DEVICE = 2;
    private static final int MSG_TIMEOUT_NOTIFY_BLE_CHARACTERISTIC = 5;
    private static final int MSG_TIMEOUT_READ_BLE_CHARACTERISTIC = 4;
    private static final int MSG_TIMEOUT_WRITE_BLE_CHARACTERISTIC = 3;
    private static final Object TAG = "BLEBridgeExtension";
    private BetterBleService bleService;
    private Map<String, List<BridgeCallback>> h5BridgeContextMap;
    private boolean mAutoClose;
    private App mCurrentApp;
    private List<BLEOperation> operationList;
    private List<BleGattCharacteristic> readCharacteristicList;
    private int mMaxTimeout = 15000;
    private TaskHandler handler = new TaskHandler(Looper.getMainLooper());
    private BetterBleListener betterBleListener = new BetterBleListener() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.1
        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothAdapterStateChange(boolean z, boolean z2) {
            Page activePage;
            JSONObject jSONObject = new JSONObject();
            if (BluetoothLeUtils.rollbackFixBoolean()) {
                jSONObject.put(BLEBridgeExtension.KEY_AVAILABLE, (Object) String.valueOf(z));
            } else {
                jSONObject.put(BLEBridgeExtension.KEY_AVAILABLE, (Object) Boolean.valueOf(z));
            }
            jSONObject.put(BLEBridgeExtension.KEY_DISCOVERING, (Object) Boolean.valueOf(z2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (BLEBridgeExtension.this.mCurrentApp == null || (activePage = BLEBridgeExtension.this.mCurrentApp.getActivePage()) == null) {
                return;
            }
            EngineUtils.sendToRender(activePage.getRender(), BLEBridgeExtension.EVENT_BLUETOOTH_ADAPTER_STATE_CHANGE, jSONObject2, null);
        }

        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothDeviceFound(List<BleDevice> list) {
            Page activePage;
            if (list == null) {
                list = new ArrayList<>();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BLEBridgeExtension.KEY_DEVICES, JSON.toJSON(list));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (BLEBridgeExtension.this.mCurrentApp == null || (activePage = BLEBridgeExtension.this.mCurrentApp.getActivePage()) == null) {
                return;
            }
            EngineUtils.sendToRender(activePage.getRender(), BLEBridgeExtension.EVENT_BLUETOOTH_DEVICE_FOUND, jSONObject2, null);
        }

        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothConnectionStateChange(String str, boolean z) {
            Page activePage;
            if (z) {
                BLEBridgeExtension.this.handler.sendEmptyMessage(101);
            } else {
                BLEBridgeExtension.this.handler.sendEmptyMessage(102);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", (Object) str);
            jSONObject.put(BLEBridgeExtension.KEY_CONNECTED, (Object) Boolean.valueOf(z));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (BLEBridgeExtension.this.mCurrentApp == null || (activePage = BLEBridgeExtension.this.mCurrentApp.getActivePage()) == null) {
                return;
            }
            EngineUtils.sendToRender(activePage.getRender(), BLEBridgeExtension.EVENT_BLE_CONNECTION_STATE_CHANGE, jSONObject2, null);
        }

        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothCharacteristicValueChange(String str, String str2, String str3, String str4) {
            Page activePage;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", (Object) str);
            jSONObject.put(BLEBridgeExtension.KEY_SERVICE_ID, (Object) str2);
            jSONObject.put(BLEBridgeExtension.KEY_CHARACTERISTIC_ID, (Object) str3);
            jSONObject.put("value", (Object) str4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (BLEBridgeExtension.this.mCurrentApp == null || (activePage = BLEBridgeExtension.this.mCurrentApp.getActivePage()) == null) {
                return;
            }
            EngineUtils.sendToRender(activePage.getRender(), BLEBridgeExtension.EVENT_BLE_CHARACTERISTIC_VALUE_CHANGE, jSONObject2, null);
        }

        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothCharacteristicRead(String str, String str2, String str3, String str4) {
            BLEBridgeExtension.this.handler.sendMessage(BLEBridgeExtension.this.handler.obtainMessage(104, BleGattCharacteristic.createCharacteristic(str2, str3, str4)));
        }

        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothCharacteristicWrite(String str, String str2, String str3) {
            BLEBridgeExtension.this.handler.sendEmptyMessage(103);
        }

        @Override // com.alibaba.griver.bluetooth.ble.BetterBleListener
        public void onBluetoothDescriptorWrite(String str, String str2, String str3, String str4) {
            BLEBridgeExtension.this.handler.sendEmptyMessage(105);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Callback {
        void hasPermission();

        void noPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getActionFromMessage(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return FUNC_NOTIFY_BLE_CHARACTERISTIC_VALUE_CHANGE;
                    }
                    return FUNC_READ_BLE_CHARACTERISTIC_VALUE;
                }
                return FUNC_WRITE_BLE_CHARACTERISTIC_VALUE;
            }
            return FUNC_DISCONNECT_BLE_DEVICE;
        }
        return FUNC_CONNECT_BLE_DEVICE;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setErrorInfo(JSONObject jSONObject, String[] strArr) {
        jSONObject.put("error", (Object) strArr[0]);
        jSONObject.put("errorMessage", (Object) strArr[1]);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void closeBluetoothAdapter(@BindingCallback final BridgeCallback bridgeCallback) {
        if (this.bleService != null) {
            requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.2
                @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
                public void hasPermission() {
                    BLEBridgeExtension.this.bleService.closeBluetoothAdapter();
                    JSONObject jSONObject = new JSONObject();
                    BLEBridgeExtension.this.clearOperations();
                    bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
                }

                @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
                public void noPermission() {
                    bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
                }
            });
            return;
        }
        clearOperations();
        bridgeCallback.sendBridgeResponse(createErrorBridgeResult(false));
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void enableBluetooth(@BindingCallback final BridgeCallback bridgeCallback) {
        clearOperations();
        if (this.bleService == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.3
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                if (BLEBridgeExtension.this.bleService.enableBluetooth()) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                } else {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                }
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void disableBluetooth(@BindingCallback final BridgeCallback bridgeCallback) {
        clearOperations();
        if (this.bleService == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.4
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                if (BLEBridgeExtension.this.bleService.disableBluetooth()) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                } else {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                }
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBluetoothAdapterState(@BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.5
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.5.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        jSONObject.put(BLEBridgeExtension.KEY_DISCOVERING, (Object) Boolean.valueOf(BLEBridgeExtension.this.bleService.isDiscovering()));
                        jSONObject.put(BLEBridgeExtension.KEY_AVAILABLE, (Object) Boolean.TRUE);
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBLEDeviceServices(@BindingCallback final BridgeCallback bridgeCallback, @BindingParam({"deviceId"}) final String str) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.6
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.6.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        if (TextUtils.isEmpty(str)) {
                            BLEBridgeExtension.setErrorInfo(jSONObject, ErrorConstants.ERROR_PARAM_LACK);
                            bridgeCallback2.sendJSONResponse(jSONObject);
                            return;
                        }
                        BleResult bluetoothServices = BLEBridgeExtension.this.bleService.getBluetoothServices(str);
                        if (bluetoothServices.success) {
                            jSONObject.put("services", JSON.toJSON((List) bluetoothServices.obj));
                            bridgeCallback2.sendJSONResponse(jSONObject);
                            return;
                        }
                        if (bluetoothServices.error != null && bluetoothServices.error.length > 1) {
                            jSONObject.put("error", (Object) bluetoothServices.getErrorCode());
                            jSONObject.put("errorMessage", (Object) bluetoothServices.getErrorMessage());
                        } else {
                            jSONObject.put("error", "12");
                        }
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBLEDeviceCharacteristics(@BindingCallback final BridgeCallback bridgeCallback, @BindingParam({"deviceId"}) final String str, @BindingParam({"serviceId"}) final String str2) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.7
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.7.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                            BLEBridgeExtension.setErrorInfo(jSONObject, ErrorConstants.ERROR_PARAM_LACK);
                            bridgeCallback2.sendJSONResponse(jSONObject);
                            return;
                        }
                        BleResult bluetoothCharacteristics = BLEBridgeExtension.this.bleService.getBluetoothCharacteristics(str, str2);
                        if (bluetoothCharacteristics.success) {
                            jSONObject.put(BLEBridgeExtension.KEY_CHARACTERISTICS, JSON.toJSON((List) bluetoothCharacteristics.obj));
                            bridgeCallback2.sendJSONResponse(jSONObject);
                            return;
                        }
                        if (bluetoothCharacteristics.error != null && bluetoothCharacteristics.error.length > 1) {
                            jSONObject.put("error", (Object) bluetoothCharacteristics.getErrorCode());
                            jSONObject.put("errorMessage", (Object) bluetoothCharacteristics.getErrorMessage());
                        } else {
                            jSONObject.put("error", "12");
                        }
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void openBluetoothAdapter(@BindingParam(booleanDefault = true, value = {"autoClose"}) final boolean z, @BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.8
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                BLEBridgeExtension.this.bleService.registerBLEState();
                BLEBridgeExtension.this.mAutoClose = z;
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.openBluetoothAdapterInner());
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BridgeResponse openBluetoothAdapterInner() {
        clearOperations();
        BetterBleService betterBleService = this.bleService;
        if (betterBleService != null) {
            boolean isSupportBLE = betterBleService.isSupportBLE();
            int bluetoothState = this.bleService.getBluetoothState();
            JSONObject jSONObject = new JSONObject();
            if (bluetoothState == BluetoothState.OFF.ordinal()) {
                int i = bluetoothState - 1;
                jSONObject.put("error", (Object) ErrorConstants.ERROR_CODE_ARRAY[i]);
                jSONObject.put("errorMessage", (Object) ErrorConstants.BLUETOOTH_STATE_STR[i]);
            } else {
                jSONObject.put(KEY_IS_SUPPORT_BLE, (Object) Boolean.valueOf(isSupportBLE));
            }
            if (isSupportBLE && bluetoothState == BluetoothState.ON.ordinal()) {
                this.bleService.openBluetoothAdapter();
            }
            return new BridgeResponse(jSONObject);
        }
        return createErrorBridgeResult(false);
    }

    private BridgeResponse createErrorBridgeResult(boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) "12");
        return new BridgeResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BridgeResponse createNoPermissionErrorResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) ErrorConstants.ERROR_CODE_NO_PERMISSON);
        jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_CODE_NO_PERMISSON_MESSAGE);
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void startBluetoothDevicesDiscovery(@BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback, @BindingParam({"services"}) final String str, @BindingParam({"allowDuplicatesKey"}) final boolean z, @BindingParam({"interval"}) final int i) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.9
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.9.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        String[] strArr;
                        if (TextUtils.isEmpty(str)) {
                            strArr = null;
                        } else {
                            List parseArray = JSON.parseArray(str, String.class);
                            if (parseArray != null) {
                                strArr = new String[parseArray.size()];
                                parseArray.toArray(strArr);
                            } else {
                                jSONObject.put("error", (Object) ErrorConstants.ERROR_SERVICEID_INVALID[0]);
                                jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_SERVICEID_INVALID[1]);
                                bridgeCallback2.sendJSONResponse(jSONObject);
                                return;
                            }
                        }
                        BleResult startBluetoothDevicesDiscovery = BLEBridgeExtension.this.bleService.startBluetoothDevicesDiscovery(strArr, z, i);
                        if (!startBluetoothDevicesDiscovery.success) {
                            if (startBluetoothDevicesDiscovery.error != null && startBluetoothDevicesDiscovery.error.length > 1) {
                                jSONObject.put("error", (Object) startBluetoothDevicesDiscovery.getErrorCode());
                                jSONObject.put("errorMessage", (Object) startBluetoothDevicesDiscovery.getErrorMessage());
                            } else {
                                jSONObject.put("error", "12");
                            }
                        }
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    private BridgeResponse sendBridgeResult(BleResult bleResult, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (!bleResult.success) {
            if (bleResult.error != null && bleResult.error.length > 1) {
                jSONObject.put("error", (Object) bleResult.getErrorCode());
                jSONObject.put("errorMessage", (Object) bleResult.getErrorMessage());
            } else {
                jSONObject.put("error", (Object) "12");
            }
        }
        if (z) {
            this.handler.sendEmptyMessage(0);
        }
        return new BridgeResponse(jSONObject);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void stopBluetoothDevicesDiscovery(@BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.10
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.10.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        BLEBridgeExtension.this.bleService.stopBluetoothDevicesDiscovery();
                        bridgeCallback2.sendBridgeResponse(BridgeResponse.SUCCESS);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBluetoothDevices(@BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.11
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.11.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        List<BleDevice> bluetoothDevices = BLEBridgeExtension.this.bleService.getBluetoothDevices();
                        if (bluetoothDevices != null) {
                            jSONObject.put(BLEBridgeExtension.KEY_DEVICES, JSON.toJSON(bluetoothDevices));
                        }
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getConnectedBluetoothDevices(@BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.12
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(BLEBridgeExtension.this.bleService)).addUnit(BLEStateUnit.create(BLEBridgeExtension.this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.12.1
                    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
                    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback2) {
                        List<BleDevice> connectedBluetoothDevices = BLEBridgeExtension.this.bleService.getConnectedBluetoothDevices();
                        if (connectedBluetoothDevices != null) {
                            jSONObject.put(BLEBridgeExtension.KEY_DEVICES, JSON.toJSON(connectedBluetoothDevices));
                        }
                        bridgeCallback2.sendJSONResponse(jSONObject);
                    }
                }).onTrigger();
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void connectBLEDevice(@BindingRequest final JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.13
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                BLEBridgeExtension.this.addToOperationList(BLEBridgeExtension.FUNC_CONNECT_BLE_DEVICE, jSONObject, bridgeCallback);
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    private void connectBleDeviceInner(final String str, final JSONObject jSONObject, BridgeCallback bridgeCallback) {
        Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(this.bleService)).addUnit(BLEStateUnit.create(this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.15
            @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
            public void onProcess(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                int castInt;
                if (!jSONObject.containsKey("deviceId")) {
                    BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_PARAM_LACK);
                    bridgeCallback2.sendJSONResponse(jSONObject2);
                    BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                    return;
                }
                if (jSONObject.get("timeout") != null) {
                    try {
                        castInt = BLEBridgeExtension.this.castInt(jSONObject.get("timeout"));
                    } catch (JSONException unused) {
                        BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_MESSAGE_INVALID_PARAM);
                        bridgeCallback2.sendJSONResponse(jSONObject2);
                        BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                        return;
                    }
                } else {
                    castInt = 0;
                }
                if (castInt < 0) {
                    BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_MESSAGE_INVALID_PARAM);
                    bridgeCallback2.sendJSONResponse(jSONObject2);
                    BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                    return;
                }
                BleResult connectBluetoothDevice = BLEBridgeExtension.this.bleService.connectBluetoothDevice(jSONObject.getString("deviceId"), jSONObject.getIntValue(BLEBridgeExtension.KEY_TRANSPORT));
                if (!connectBluetoothDevice.syncReturn) {
                    BLEBridgeExtension.this.handleConnection(str, bridgeCallback2, jSONObject.getString("deviceId"), castInt);
                    return;
                }
                if (!connectBluetoothDevice.success) {
                    if (connectBluetoothDevice.error != null && connectBluetoothDevice.error.length > 1) {
                        jSONObject2.put("error", (Object) connectBluetoothDevice.getErrorCode());
                        jSONObject2.put("errorMessage", (Object) connectBluetoothDevice.getErrorMessage());
                    } else {
                        jSONObject2.put("error", "12");
                    }
                }
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                bridgeCallback2.sendJSONResponse(jSONObject2);
            }
        }).setOnErrorListener(new Workflow.OnErrorListener() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.14
            @Override // com.alibaba.griver.bluetooth.workflow.Workflow.OnErrorListener
            public void onError(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
            }
        }).onTrigger();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void disconnectBLEDevice(@BindingRequest final JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.16
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                BLEBridgeExtension.this.addToOperationList(BLEBridgeExtension.FUNC_DISCONNECT_BLE_DEVICE, jSONObject, bridgeCallback);
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    private void disconnectBleDeviceInner(final String str, final JSONObject jSONObject, BridgeCallback bridgeCallback) {
        Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(this.bleService)).addUnit(BLEStateUnit.create(this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.18
            @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
            public void onProcess(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                if (!jSONObject.containsKey("deviceId")) {
                    BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_PARAM_LACK);
                    BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                    bridgeCallback2.sendJSONResponse(jSONObject2);
                    return;
                }
                BleResult disconnectBluetoothDevice = BLEBridgeExtension.this.bleService.disconnectBluetoothDevice(jSONObject.getString("deviceId"));
                if (!disconnectBluetoothDevice.syncReturn) {
                    BLEBridgeExtension.this.handleH5Bridge(str, bridgeCallback2);
                    return;
                }
                if (!disconnectBluetoothDevice.success) {
                    if (disconnectBluetoothDevice.error != null && disconnectBluetoothDevice.error.length > 1) {
                        jSONObject2.put("error", (Object) disconnectBluetoothDevice.getErrorCode());
                        jSONObject2.put("errorMessage", (Object) disconnectBluetoothDevice.getErrorMessage());
                    } else {
                        jSONObject2.put("error", "12");
                    }
                }
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                bridgeCallback2.sendJSONResponse(jSONObject2);
            }
        }).setOnErrorListener(new Workflow.OnErrorListener() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.17
            @Override // com.alibaba.griver.bluetooth.workflow.Workflow.OnErrorListener
            public void onError(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
            }
        }).onTrigger();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void writeBLECharacteristicValue(@BindingRequest final JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.19
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                BLEBridgeExtension.this.addToOperationList(BLEBridgeExtension.FUNC_WRITE_BLE_CHARACTERISTIC_VALUE, jSONObject, bridgeCallback);
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    private void writeBleCharacteristicValueInner(final String str, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(this.bleService)).addUnit(BLEStateUnit.create(this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.21
            @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
            public void onProcess(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                if (!jSONObject.containsKey("deviceId") || !jSONObject.containsKey(BLEBridgeExtension.KEY_SERVICE_ID) || !jSONObject.containsKey(BLEBridgeExtension.KEY_CHARACTERISTIC_ID) || !jSONObject.containsKey("value")) {
                    BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_PARAM_LACK);
                    BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
                BleResult sendData = BLEBridgeExtension.this.bleService.sendData(jSONObject.getString("deviceId"), jSONObject.getString(BLEBridgeExtension.KEY_SERVICE_ID), jSONObject.getString(BLEBridgeExtension.KEY_CHARACTERISTIC_ID), jSONObject.getString("value"));
                if (!sendData.syncReturn) {
                    BLEBridgeExtension.this.handleH5Bridge(str, bridgeCallback);
                    return;
                }
                if (!sendData.success) {
                    if (sendData.error != null && sendData.error.length > 1) {
                        jSONObject2.put("error", (Object) sendData.getErrorCode());
                        jSONObject2.put("errorMessage", (Object) sendData.getErrorMessage());
                    } else {
                        jSONObject2.put("error", "12");
                    }
                }
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                bridgeCallback2.sendJSONResponse(jSONObject2);
            }
        }).setOnErrorListener(new Workflow.OnErrorListener() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.20
            @Override // com.alibaba.griver.bluetooth.workflow.Workflow.OnErrorListener
            public void onError(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
            }
        }).onTrigger();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void notifyBLECharacteristicValueChange(@BindingRequest final JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.22
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                BLEBridgeExtension.this.addToOperationList(BLEBridgeExtension.FUNC_NOTIFY_BLE_CHARACTERISTIC_VALUE_CHANGE, jSONObject, bridgeCallback);
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    private void notifyBleCharacteristicValueChangeInner(final String str, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(this.bleService)).addUnit(BLEStateUnit.create(this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.24
            @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
            public void onProcess(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                if (!jSONObject.containsKey("deviceId") || !jSONObject.containsKey(BLEBridgeExtension.KEY_SERVICE_ID) || !jSONObject.containsKey(BLEBridgeExtension.KEY_CHARACTERISTIC_ID)) {
                    BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_PARAM_LACK);
                    BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
                BleResult notifyCharacteristicValueChange = BLEBridgeExtension.this.bleService.notifyCharacteristicValueChange(jSONObject.getString("deviceId"), jSONObject.getString(BLEBridgeExtension.KEY_SERVICE_ID), jSONObject.getString(BLEBridgeExtension.KEY_CHARACTERISTIC_ID), jSONObject.getString(BLEBridgeExtension.KEY_DESCRIPTOR_ID), jSONObject.containsKey("state") ? jSONObject.getBoolean("state").booleanValue() : true);
                if (!notifyCharacteristicValueChange.syncReturn) {
                    BLEBridgeExtension.this.handleH5Bridge(str, bridgeCallback);
                    return;
                }
                if (!notifyCharacteristicValueChange.success) {
                    if (notifyCharacteristicValueChange.error != null && notifyCharacteristicValueChange.error.length > 1) {
                        jSONObject2.put("error", (Object) notifyCharacteristicValueChange.getErrorCode());
                        jSONObject2.put("errorMessage", (Object) notifyCharacteristicValueChange.getErrorMessage());
                    } else {
                        jSONObject2.put("error", "12");
                    }
                }
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                bridgeCallback.sendJSONResponse(jSONObject2);
            }
        }).setOnErrorListener(new Workflow.OnErrorListener() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.23
            @Override // com.alibaba.griver.bluetooth.workflow.Workflow.OnErrorListener
            public void onError(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
            }
        }).onTrigger();
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void readBLECharacteristicValue(@BindingRequest final JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        requestBlePermission(new Callback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.25
            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void hasPermission() {
                BLEBridgeExtension.this.addToOperationList(BLEBridgeExtension.FUNC_READ_BLE_CHARACTERISTIC_VALUE, jSONObject, bridgeCallback);
            }

            @Override // com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.Callback
            public void noPermission() {
                bridgeCallback.sendBridgeResponse(BLEBridgeExtension.this.createNoPermissionErrorResult());
            }
        });
    }

    private void readBleCharacteristicValueInner(final String str, final JSONObject jSONObject, BridgeCallback bridgeCallback) {
        Workflow.create(bridgeCallback).addUnit(BLEServiceUnit.create(this.bleService)).addUnit(BLEStateUnit.create(this.bleService)).addUnit(new SimpleWorkflowUnit() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.27
            @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
            public void onProcess(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                if (!jSONObject.containsKey("deviceId") || !jSONObject.containsKey(BLEBridgeExtension.KEY_SERVICE_ID) || !jSONObject.containsKey(BLEBridgeExtension.KEY_CHARACTERISTIC_ID)) {
                    BLEBridgeExtension.setErrorInfo(jSONObject2, ErrorConstants.ERROR_PARAM_LACK);
                    BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                    bridgeCallback2.sendJSONResponse(jSONObject2);
                    return;
                }
                BleResult readData = BLEBridgeExtension.this.bleService.readData(jSONObject.getString("deviceId"), jSONObject.getString(BLEBridgeExtension.KEY_SERVICE_ID), jSONObject.getString(BLEBridgeExtension.KEY_CHARACTERISTIC_ID));
                if (!readData.syncReturn && readData.obj != null) {
                    BLEBridgeExtension.this.readCharacteristicList.add((BleGattCharacteristic) readData.obj);
                    BLEBridgeExtension.this.handleH5Bridge(str, bridgeCallback2);
                    return;
                }
                if (!readData.success) {
                    if (readData.error != null && readData.error.length > 1) {
                        jSONObject2.put("error", (Object) readData.getErrorCode());
                        jSONObject2.put("errorMessage", (Object) readData.getErrorMessage());
                    } else {
                        jSONObject2.put("error", "12");
                    }
                }
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
                bridgeCallback2.sendJSONResponse(jSONObject2);
            }
        }).setOnErrorListener(new Workflow.OnErrorListener() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.26
            @Override // com.alibaba.griver.bluetooth.workflow.Workflow.OnErrorListener
            public void onError(JSONObject jSONObject2, BridgeCallback bridgeCallback2) {
                BLEBridgeExtension.this.handler.sendEmptyMessage(0);
            }
        }).onTrigger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleH5Bridge(String str, BridgeCallback bridgeCallback) {
        int messageWhatFromAction = getMessageWhatFromAction(str);
        setH5BridgeContext(str, bridgeCallback);
        Message obtainMessage = this.handler.obtainMessage(messageWhatFromAction, bridgeCallback);
        if (FUNC_NOTIFY_BLE_CHARACTERISTIC_VALUE_CHANGE.equals(str)) {
            this.handler.sendMessageDelayed(obtainMessage, 10000L);
        } else {
            this.handler.sendMessageDelayed(obtainMessage, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnection(String str, BridgeCallback bridgeCallback, String str2, int i) {
        int messageWhatFromAction = getMessageWhatFromAction(str);
        setH5BridgeContext(str, bridgeCallback);
        Message obtainMessage = this.handler.obtainMessage(messageWhatFromAction, new TimeOutContext(bridgeCallback, str2));
        if (i <= 0) {
            i = 10000;
        } else {
            int i2 = this.mMaxTimeout;
            if (i > i2) {
                i = i2;
            }
        }
        this.handler.sendMessageDelayed(obtainMessage, i);
    }

    private void setH5BridgeContext(String str, BridgeCallback bridgeCallback) {
        if (!this.h5BridgeContextMap.containsKey(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bridgeCallback);
            this.h5BridgeContextMap.put(str, arrayList);
            return;
        }
        List<BridgeCallback> list = this.h5BridgeContextMap.get(str);
        if (list != null) {
            list.add(bridgeCallback);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(bridgeCallback);
        this.h5BridgeContextMap.put(str, arrayList2);
    }

    private int getMessageWhatFromAction(String str) {
        if (FUNC_CONNECT_BLE_DEVICE.equals(str)) {
            return 1;
        }
        if (FUNC_DISCONNECT_BLE_DEVICE.equals(str)) {
            return 2;
        }
        if (FUNC_WRITE_BLE_CHARACTERISTIC_VALUE.equals(str)) {
            return 3;
        }
        if (FUNC_READ_BLE_CHARACTERISTIC_VALUE.equals(str)) {
            return 4;
        }
        return FUNC_NOTIFY_BLE_CHARACTERISTIC_VALUE_CHANGE.equals(str) ? 5 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int castInt(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() > 0) {
                return num.intValue();
            }
            return -1;
        } else if (obj instanceof Number) {
            return ((Number) obj).intValue();
        } else {
            return -1;
        }
    }

    private BridgeResponse sendParamLackingBridgeResult(boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) ErrorConstants.ERROR_PARAM_LACK[0]);
        jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_PARAM_LACK[1]);
        if (z) {
            this.handler.sendEmptyMessage(0);
        }
        return new BridgeResponse(jSONObject);
    }

    private BridgeResponse sendBluetoothNotInitializedResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED[0]);
        jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_BLUETOOTHADAPTER_NOT_INITIALIZED[1]);
        return new BridgeResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperations() {
        Map<String, List<BridgeCallback>> map = this.h5BridgeContextMap;
        if (map != null) {
            map.clear();
        }
        List<BleGattCharacteristic> list = this.readCharacteristicList;
        if (list != null) {
            list.clear();
        }
        if (this.readCharacteristicList != null) {
            this.operationList.clear();
        }
        TaskHandler taskHandler = this.handler;
        if (taskHandler != null) {
            taskHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.h5BridgeContextMap = new HashMap();
        this.readCharacteristicList = new ArrayList();
        this.operationList = new ArrayList();
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            return;
        }
        BetterBleServiceImpl betterBleServiceImpl = new BetterBleServiceImpl();
        this.bleService = betterBleServiceImpl;
        betterBleServiceImpl.onCreate(rVEnvironmentService.getApplicationContext());
        this.bleService.setBetterBleListener(this.betterBleListener);
        RVBluetoothProxy rVBluetoothProxy = (RVBluetoothProxy) RVProxy.get(RVBluetoothProxy.class);
        if (rVBluetoothProxy == null || rVBluetoothProxy.getBLEConnectMaxTimeout() == 0) {
            return;
        }
        this.mMaxTimeout = rVBluetoothProxy.getBLEConnectMaxTimeout();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        BetterBleService betterBleService = this.bleService;
        if (betterBleService != null) {
            betterBleService.onDestroy();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        if (weakReference.get() == null) {
            return;
        }
        this.mCurrentApp = weakReference.get();
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageDestroyPoint
    public void onPageDestroy(Page page) {
        if (this.mAutoClose) {
            this.bleService.closeBluetoothAdapter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToOperationList(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        List<BLEOperation> list = this.operationList;
        if (list != null) {
            list.add(new BLEOperation(str, jSONObject, bridgeCallback));
            if (this.operationList.size() == 1) {
                handleSynchronizedOperation(this.operationList.get(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFirstOperationFromList() {
        List<BLEOperation> list = this.operationList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.operationList.remove(0);
        if (this.operationList.size() > 0) {
            handleSynchronizedOperation(this.operationList.get(0));
        }
    }

    private void handleSynchronizedOperation(BLEOperation bLEOperation) {
        JSONObject jSONObject = bLEOperation.param;
        BridgeCallback bridgeCallback = bLEOperation.bridgeCallback;
        String str = bLEOperation.action;
        if (FUNC_CONNECT_BLE_DEVICE.equals(str)) {
            connectBleDeviceInner(str, jSONObject, bridgeCallback);
        } else if (FUNC_DISCONNECT_BLE_DEVICE.equals(str)) {
            disconnectBleDeviceInner(str, jSONObject, bridgeCallback);
        } else if (FUNC_WRITE_BLE_CHARACTERISTIC_VALUE.equals(str)) {
            writeBleCharacteristicValueInner(str, jSONObject, bridgeCallback);
        } else if (FUNC_READ_BLE_CHARACTERISTIC_VALUE.equals(str)) {
            readBleCharacteristicValueInner(str, jSONObject, bridgeCallback);
        } else if (FUNC_NOTIFY_BLE_CHARACTERISTIC_VALUE_CHANGE.equals(str)) {
            notifyBleCharacteristicValueChangeInner(str, jSONObject, bridgeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class TaskHandler extends Handler {
        public TaskHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            List list;
            String str;
            List list2;
            List list3;
            super.handleMessage(message);
            String actionFromMessage = BLEBridgeExtension.this.getActionFromMessage(message.what);
            int i = message.what;
            if (i != 1) {
                if (i == 2 || i == 3 || i == 4) {
                    if (message.obj != null) {
                        BridgeCallback bridgeCallback = (BridgeCallback) message.obj;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("error", (Object) ErrorConstants.ERROR_TIMEOUT[0]);
                        jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_TIMEOUT[1]);
                        if (message.what == 4 && BLEBridgeExtension.this.readCharacteristicList != null && BLEBridgeExtension.this.readCharacteristicList.size() > 0) {
                            jSONObject.put(BLEBridgeExtension.KEY_CHARACTERISTIC, JSON.toJSON(BLEBridgeExtension.this.readCharacteristicList.get(0)));
                            BLEBridgeExtension.this.readCharacteristicList.remove(0);
                        }
                        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
                        if (!TextUtils.isEmpty(actionFromMessage) && BLEBridgeExtension.this.h5BridgeContextMap != null && (list2 = (List) BLEBridgeExtension.this.h5BridgeContextMap.get(actionFromMessage)) != null) {
                            list2.remove(bridgeCallback);
                        }
                        if (message.what == 2) {
                            str = "disconnectBLE";
                        } else if (message.what == 3) {
                            str = "writeBLE";
                        } else {
                            str = message.what == 4 ? "readBLE" : "unknown";
                        }
                        BLETraceMonitor.getInstance().onTimeout(str);
                    }
                } else if (i != 5) {
                    switch (i) {
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                            if (BLEBridgeExtension.this.h5BridgeContextMap != null) {
                                List list4 = (List) BLEBridgeExtension.this.h5BridgeContextMap.get(BLEBridgeExtension.this.getActionFromMessage(message.what - 100));
                                if (list4 != null && list4.size() > 0) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    if (message.what == 104) {
                                        jSONObject2.put(BLEBridgeExtension.KEY_CHARACTERISTIC, JSON.toJSON(message.obj));
                                        if (BLEBridgeExtension.this.readCharacteristicList != null && BLEBridgeExtension.this.readCharacteristicList.size() > 0) {
                                            BLEBridgeExtension.this.readCharacteristicList.remove(0);
                                        }
                                    }
                                    BridgeCallback bridgeCallback2 = (BridgeCallback) list4.get(0);
                                    bridgeCallback2.sendBridgeResponse(new BridgeResponse(jSONObject2));
                                    list4.remove(0);
                                    BLEBridgeExtension.this.handler.removeMessages(message.what - 100, bridgeCallback2);
                                    break;
                                }
                            }
                            break;
                    }
                } else {
                    if (message.obj != null) {
                        BridgeCallback bridgeCallback3 = (BridgeCallback) message.obj;
                        bridgeCallback3.sendBridgeResponse(new BridgeResponse(new JSONObject()));
                        if (!TextUtils.isEmpty(actionFromMessage) && BLEBridgeExtension.this.h5BridgeContextMap != null && (list3 = (List) BLEBridgeExtension.this.h5BridgeContextMap.get(actionFromMessage)) != null) {
                            list3.remove(bridgeCallback3);
                        }
                    }
                    BLETraceMonitor.getInstance().onTimeout("notifyBLE");
                }
            } else if (message.obj != null) {
                BridgeCallback bridgeCallback4 = ((TimeOutContext) message.obj).bridgeCallback;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("error", (Object) ErrorConstants.ERROR_TIMEOUT[0]);
                jSONObject3.put("errorMessage", (Object) ErrorConstants.ERROR_TIMEOUT[1]);
                bridgeCallback4.sendBridgeResponse(new BridgeResponse(jSONObject3));
                if (!TextUtils.isEmpty(actionFromMessage) && BLEBridgeExtension.this.h5BridgeContextMap != null && (list = (List) BLEBridgeExtension.this.h5BridgeContextMap.get(actionFromMessage)) != null) {
                    list.remove(bridgeCallback4);
                }
                BLETraceMonitor.getInstance().onTimeout("connectBLE");
            }
            BLEBridgeExtension.this.removeFirstOperationFromList();
        }
    }

    private void requestBlePermission(final Callback callback) {
        if (Build.VERSION.SDK_INT >= 31) {
            String[] strArr = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"};
            if (!PermissionUtils.hasPermissions(strArr)) {
                PermissionUtils.requestPermissions(strArr, 1000, new IPermissionRequestCallback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.28
                    @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                    public void onRequestPermissionResult(int i, String[] strArr2, int[] iArr) {
                        if (PermissionUtils.positivePermissionResult(iArr)) {
                            callback.hasPermission();
                        } else {
                            callback.noPermission();
                        }
                    }
                });
                return;
            } else {
                callback.hasPermission();
                return;
            }
        }
        String[] strArr2 = {ManifestPermission.ACCESS_COARSE_LOCATION, "android.permission.ACCESS_FINE_LOCATION"};
        if (!PermissionUtils.hasPermissions(strArr2)) {
            PermissionUtils.requestPermissions(strArr2, 1000, new IPermissionRequestCallback() { // from class: com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension.29
                @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                public void onRequestPermissionResult(int i, String[] strArr3, int[] iArr) {
                    if (PermissionUtils.positivePermissionResult(iArr)) {
                        callback.hasPermission();
                    } else {
                        callback.noPermission();
                    }
                }
            });
        } else {
            callback.hasPermission();
        }
    }
}
