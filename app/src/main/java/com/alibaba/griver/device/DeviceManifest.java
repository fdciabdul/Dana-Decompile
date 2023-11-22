package com.alibaba.griver.device;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.biz.SnapshotPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.permission.api.extension.PermissionGuildePoint;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.device.adapter.GriverCommonAbilityProxyImpl;
import com.alibaba.griver.device.jsapi.auth.AuthGuideExtension;
import com.alibaba.griver.device.jsapi.auth.GriverDefaultOpenSettingExtension;
import com.alibaba.griver.device.jsapi.phone.contact.ContactActivityResultPoint;
import com.alibaba.griver.device.jsapi.screen.SnapshotExtension;
import com.alibaba.griver.device.proxy.GriverOpenSettingExtension;
import com.alibaba.griver.device.proxy.RVCommonAbilityProxy;
import com.iap.ac.android.acs.plugin.utils.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class DeviceManifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final DeviceManifest f6502a = new DeviceManifest();

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
        return f6502a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RVManifest.LazyProxyManifest(RVCommonAbilityProxy.class, new RVProxy.LazyGetter<RVCommonAbilityProxy>() { // from class: com.alibaba.griver.device.DeviceManifest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public RVCommonAbilityProxy get() {
                return new GriverCommonAbilityProxyImpl();
            }
        }));
        arrayList.add(new RVManifest.LazyProxyManifest(GriverOpenSettingExtension.class, new RVProxy.LazyGetter<GriverOpenSettingExtension>() { // from class: com.alibaba.griver.device.DeviceManifest.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.common.RVProxy.LazyGetter
            public GriverOpenSettingExtension get() {
                return new GriverDefaultOpenSettingExtension();
            }
        }));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.system.SystemRootStatusBridgeExtension", (List<String>) Arrays.asList("isSystemRoot"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.system.DeviceInfoBridgeExtension", (List<String>) Arrays.asList("getDeviceInfo", "getDeviceID")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.contact.AddPhoneContactBridgeExtension", (List<String>) Arrays.asList("addPhoneContact"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.phone.TelephonyInfoBridgeExtension", (List<String>) Arrays.asList("getCarrierName"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.phone.MakePhoneCallBridgeExtension", (List<String>) Arrays.asList("makePhoneCall"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.phone.ChoosePhoneContactBridgeExtension", (List<String>) Arrays.asList("contact"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.system.GetBatteryInfoBridgeExtension", (List<String>) Arrays.asList("getBatteryInfo"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.vibrate.VibrateBridgeExtension", (List<String>) Arrays.asList("vibrate", "vibrateLong", "vibrateShort"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.wifi.SendUPDMessageExtension", (List<String>) Arrays.asList("getSSID", "sendUdpMessage"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.wifi.WifiInfoExtension", (List<String>) Arrays.asList("getWifiInfo"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.wifi.WifiManagerBridgeExtension", (List<String>) Arrays.asList("connectWifi", "getConnectedWifi", "getWifiList", "startWifi", "stopWifi"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.nfc.HCEBridgeExtension", (List<String>) Arrays.asList("startHCE", "stopHCE", "sendHCEMessage", "getHCEState")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.screen.ScreenBrightnessBridgeExtension", (List<String>) Arrays.asList("getScreenBrightness", "setScreenBrightness", "setScreenAutolock"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.sensor.SensorBridgeExtension", (List<String>) Arrays.asList("watchShake"), (Class<? extends Scope>) Page.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.sensor.DeviceOrientationBridgeExtension", (List<String>) Arrays.asList("startDeviceMotionListening", "stopDeviceMotionListening"), (Class<? extends Scope>) App.class));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.screen.SnapshotBridgeExtension", (List<String>) Arrays.asList("snapshot", "addScreenshotListener")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.auth.ShowAuthGuideBridgeExtension", (List<String>) Arrays.asList("showAuthGuide")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.system.MemoryWarningBridgeExtension", (List<String>) Arrays.asList("startMonitorMemoryWarning", "stopMonitorMemoryWarning")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.auth.OpenUserIdBridgeExtension", (List<String>) Arrays.asList("getOpenUserData")));
        arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("com-alibaba-griver-commonability", "com.alibaba.griver.device.jsapi.auth.ProgramSettingExtension", (List<String>) Arrays.asList(Constants.JS_API_GET_SETTING, "openSetting")));
        return arrayList;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExtensionMetaInfo("com-alibaba-griver-commonability", AuthGuideExtension.class.getName(), Collections.singletonList(PermissionGuildePoint.class.getName()), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-griver-commonability", SnapshotExtension.class.getName(), Arrays.asList(SnapshotPoint.class.getName(), PageResumePoint.class.getName(), PagePausePoint.class.getName(), PageExitPoint.class.getName(), AppDestroyPoint.class.getName()), App.class));
        arrayList.add(new ExtensionMetaInfo("com-alibaba-griver-commonability", ContactActivityResultPoint.class.getName(), Arrays.asList(ActivityResultPoint.class.getName())));
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
