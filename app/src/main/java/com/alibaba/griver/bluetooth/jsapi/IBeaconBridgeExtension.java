package com.alibaba.griver.bluetooth.jsapi;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.bluetooth.ble.ErrorConstants;
import com.alibaba.griver.bluetooth.ble.utils.BluetoothLeUtils;
import com.alibaba.griver.bluetooth.ibeacon.BeaconResult;
import com.alibaba.griver.bluetooth.ibeacon.MyBeacon;
import com.alibaba.griver.bluetooth.ibeacon.MyBeaconListener;
import com.alibaba.griver.bluetooth.ibeacon.MyBeaconService;
import com.alibaba.griver.bluetooth.ibeacon.MyBeaconServiceImpl;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class IBeaconBridgeExtension implements BridgeExtension, NodeAware<App> {
    private static final String EVENT_BEACON_SERVICE_CHANGE = "beaconServiceChange";
    private static final String EVENT_BEACON_UPDATE = "beaconUpdate";
    private static final String KEY_AVAILABLE = "available";
    private static final String KEY_BEACONS = "beacons";
    private static final String KEY_DATA = "data";
    private static final String KEY_DISCOVERING = "discovering";
    private static final String KEY_ERROR = "error";
    private static final String KEY_ERROR_MESSAGE = "errorMessage";
    private static final String KEY_UUIDS = "uuids";
    private App mCurrentApp;
    private MyBeaconService mIBeaconService;
    private MyBeaconListener myBeaconListener = new MyBeaconListener() { // from class: com.alibaba.griver.bluetooth.jsapi.IBeaconBridgeExtension.1
        @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconListener
        public void onBeaconUpdate(List<MyBeacon> list) {
            Page activePage;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IBeaconBridgeExtension.KEY_BEACONS, JSON.toJSON(list));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (IBeaconBridgeExtension.this.mCurrentApp == null || (activePage = IBeaconBridgeExtension.this.mCurrentApp.getActivePage()) == null) {
                return;
            }
            EngineUtils.sendToRender(activePage.getRender(), IBeaconBridgeExtension.EVENT_BEACON_UPDATE, jSONObject2, null);
        }

        @Override // com.alibaba.griver.bluetooth.ibeacon.MyBeaconListener
        public void onBeaconServiceChange(boolean z, boolean z2) {
            Page activePage;
            JSONObject jSONObject = new JSONObject();
            if (BluetoothLeUtils.rollbackFixBoolean()) {
                jSONObject.put(IBeaconBridgeExtension.KEY_AVAILABLE, (Object) String.valueOf(z));
            } else {
                jSONObject.put(IBeaconBridgeExtension.KEY_AVAILABLE, (Object) Boolean.valueOf(z));
            }
            jSONObject.put(IBeaconBridgeExtension.KEY_DISCOVERING, (Object) Boolean.valueOf(z2));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (IBeaconBridgeExtension.this.mCurrentApp == null || (activePage = IBeaconBridgeExtension.this.mCurrentApp.getActivePage()) == null) {
                return;
            }
            EngineUtils.sendToRender(activePage.getRender(), IBeaconBridgeExtension.EVENT_BEACON_SERVICE_CHANGE, jSONObject2, null);
        }
    };

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void startBeaconDiscovery(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        List list;
        if (this.mIBeaconService != null) {
            if (jSONObject != null && jSONObject.containsKey(KEY_UUIDS)) {
                if (!typeOfArray(jSONObject.getString(KEY_UUIDS))) {
                    JSONObject jSONObject2 = new JSONObject();
                    setErrorInfo(jSONObject2, ErrorConstants.ERROR_BEACON_INVALID_UUID);
                    bridgeCallback.sendJSONResponse(jSONObject2);
                    return;
                }
                try {
                    list = JSON.parseArray(jSONObject.getString(KEY_UUIDS), String.class);
                } catch (Exception unused) {
                    list = null;
                }
                if (list == null || list.isEmpty()) {
                    sendUUIDEmptyErrorBidgeResult(bridgeCallback);
                    return;
                }
                String[] strArr = new String[list.size()];
                list.toArray(strArr);
                sendBridgeResult(bridgeCallback, this.mIBeaconService.startBeaconDiscovery(strArr));
                return;
            }
            sendUUIDEmptyErrorBidgeResult(bridgeCallback);
            return;
        }
        sendDefaultErrorBridgeResult(bridgeCallback);
    }

    private boolean typeOfArray(String str) {
        return JSON.parse(str) instanceof JSONArray;
    }

    private void setErrorInfo(JSONObject jSONObject, String[] strArr) {
        jSONObject.put("error", (Object) strArr[0]);
        jSONObject.put("errorMessage", (Object) strArr[1]);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void stopBeaconDiscovery(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        MyBeaconService myBeaconService = this.mIBeaconService;
        if (myBeaconService != null) {
            sendBridgeResult(bridgeCallback, myBeaconService.stopBeaconDiscovery());
        } else {
            sendDefaultErrorBridgeResult(bridgeCallback);
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getBeacons(@BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        MyBeaconService myBeaconService = this.mIBeaconService;
        if (myBeaconService != null) {
            BeaconResult beacons = myBeaconService.getBeacons();
            if (beacons.success) {
                Set set = (Set) beacons.obj;
                JSONObject jSONObject2 = new JSONObject();
                if (set != null) {
                    jSONObject2.put(KEY_BEACONS, JSON.toJSON(set.toArray()));
                }
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
                return;
            }
            sendBridgeResult(bridgeCallback, beacons);
            return;
        }
        sendDefaultErrorBridgeResult(bridgeCallback);
    }

    private void sendBridgeResult(BridgeCallback bridgeCallback, BeaconResult beaconResult) {
        JSONObject jSONObject = new JSONObject();
        if (!beaconResult.success) {
            jSONObject.put("error", (Object) beaconResult.getErrorCode());
            jSONObject.put("errorMessage", (Object) beaconResult.getErrorMessage());
        }
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
    }

    private void sendUUIDEmptyErrorBidgeResult(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) ErrorConstants.ERROR_BEACON_UUID_EMPTY[0]);
        jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_BEACON_UUID_EMPTY[1]);
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
    }

    private void sendDefaultErrorBridgeResult(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) ErrorConstants.ERROR_BEACON_SYSTEM_ERROR[0]);
        jSONObject.put("errorMessage", (Object) ErrorConstants.ERROR_BEACON_SYSTEM_ERROR[1]);
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        MyBeaconServiceImpl myBeaconServiceImpl = new MyBeaconServiceImpl();
        this.mIBeaconService = myBeaconServiceImpl;
        myBeaconServiceImpl.onCreate();
        this.mIBeaconService.setMyBeaconListener(this.myBeaconListener);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.mCurrentApp = null;
        this.mIBeaconService.onDestroy();
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
}
