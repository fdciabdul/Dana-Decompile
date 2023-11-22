package com.alibaba.ariver.ariverexthub.api.manifest;

import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerProcess;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerScope;
import com.alibaba.ariver.ariverexthub.api.model.RVEHandlerSource;
import com.alibaba.griver.map.jsapi.CalculateRouteExtension;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class RVEExthubManifest {
    public static HashMap<List<String>, RVEApiInfo> getExthubHandlers() {
        HashMap<List<String>, RVEApiInfo> hashMap = new HashMap<>();
        hashMap.put(Arrays.asList("vibrate", "vibrateLong"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.vibrate.RVEVibrateHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("getNetworkType"), RVEApiInfo.makeApi("com.alibaba.ariver.jsapi.network.RVEGetNetworkTypeHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("setScreenBrightness", "getScreenBrightness", "setScreenAutolock"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.screen.RVEScreenBrightnessHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("makePhoneCall"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.phone.RVEMakePhoneCallHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("removeSavedFile", "getSavedFileList", "getSavedFileInfo", "getFileInfo"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.file.jsapi.RVEFileHandler", RVEHandlerScope.Service, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("saveFile"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.file.jsapi.RVEFileHandler", RVEHandlerScope.Service, RVEHandlerProcess.Remote));
        hashMap.put(Arrays.asList("fsManage"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.file.jsapi.RVEFsManageHandler", RVEHandlerScope.Service, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("createSharedBiz"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.file.jsapi.RVESharedFileHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("postNotification", "addNotifyListener", "removeNotifyListener"), RVEApiInfo.makeApi("com.alibaba.ariver.jsapi.RVENotificationHandler", RVEHandlerScope.App, RVEHandlerProcess.Remote, RVEHandlerSource.AriverExcept));
        hashMap.put(Arrays.asList("navigateToSetting"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.navigator.RVENavigatorHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("setClipboard", "getClipboard"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.clipboard.RVEClipboardHandler", RVEHandlerScope.App, RVEHandlerProcess.Remote));
        hashMap.put(Arrays.asList("getCarrierName"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.phone.RVETelephonyInfoHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("isSystemRoot"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.system.RVESystemRootStatusHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("sendUdpMessage", "getSSID"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.wifi.RVESendUDPMessageHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("addPhoneContact"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.contact.RVEAddPhoneContactHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("contact"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.phone.RVEChoosePhoneContactHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("startHCE", "stopHCE", "sendHCEMessage", "getHCEState"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.nfc.RVEHCEHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("startDeviceMotionListening", "stopDeviceMotionListening"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.sensor.RVEDeviceOrientationHandler", RVEHandlerScope.App, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("getWifiInfo"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.wifi.RVEWifiInfoHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal, RVEHandlerSource.AriverExcept));
        hashMap.put(Arrays.asList("startWifi", "stopWifi", "getWifiList", "connectWifi", "getConnectedWifi"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.device.jsapi.wifi.RVEWifiManagerHandler", RVEHandlerScope.App, RVEHandlerProcess.Normal, RVEHandlerSource.AriverExcept));
        hashMap.put(Arrays.asList("authMapLocation", CalculateRouteExtension.ACTION_CALCULATE_ROUTE, "getMapInfo"), RVEApiInfo.makeApi("com.alibaba.ariver.commonability.map.jsapi.RVEMapApiHandler", RVEHandlerScope.App, RVEHandlerProcess.Normal));
        hashMap.put(Arrays.asList("getClientInfo"), RVEApiInfo.makeApi("com.alibaba.ariver.jsapi.RVEGetClientInfoHandler", RVEHandlerScope.Singal, RVEHandlerProcess.Normal, RVEHandlerSource.AriverExcept));
        return hashMap;
    }
}
