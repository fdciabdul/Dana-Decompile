package com.alibaba.griver.bluetooth;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class BluetoothManifest implements RVManifest {
    private static final String BUNDLE_NAME = "com-alibaba-griver-bluetooth";
    private static final BluetoothManifest INSTANCE = new BluetoothManifest();

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        return null;
    }

    public static RVManifest getInstance() {
        return INSTANCE;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.bluetooth.jsapi.BLEBridgeExtension", (List<String>) Arrays.asList("closeBluetoothAdapter", "connectBLEDevice", "disconnectBLEDevice", "getBLEDeviceCharacteristics", "getBLEDeviceServices", "getBluetoothAdapterState", "getBluetoothDevices", "getConnectedBluetoothDevices", "notifyBLECharacteristicValueChange", "openBluetoothAdapter", "readBLECharacteristicValue", "startBluetoothDevicesDiscovery", "stopBluetoothDevicesDiscovery", "writeBLECharacteristicValue", "disableBluetooth", "enableBluetooth"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw(BUNDLE_NAME, "com.alibaba.griver.bluetooth.jsapi.IBeaconBridgeExtension", (List<String>) Arrays.asList("getBeacons", "startBeaconDiscovery", "stopBeaconDiscovery"), (Class<? extends Scope>) App.class));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo(BUNDLE_NAME, BLEBridgeExtension.class.getName(), Collections.singletonList(PageDestroyPoint.class.getName())));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return new ArrayList();
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        return new ArrayList();
    }
}
