package com.alibaba.exthub.manifest;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.exthub.ExtHubBridgeExtensionManifest;
import com.alibaba.exthub.manifest.base.IExtHubManifest;
import com.alibaba.griver.core.worker.JSApiCachePoint;
import com.alibaba.griver.map.jsapi.CalculateRouteExtension;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import com.iap.ac.android.acs.plugin.utils.Constants;
import com.iap.ac.android.container.js.plugin.ACContainerJSPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class ExtHubMainfest implements IExtHubManifest {
    @Override // com.alibaba.exthub.manifest.base.IExtHubManifest
    public List<ExtHubBridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alipay.mobile.nebulax.integration.wallet.extensions.WalletConfigBridgeExtension", Arrays.asList("configService.getConfig", "getClientConfig", "getConfig4Appx")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-aompfilemanager", "com.alipay.mobile.aompfilemanager.h5plugin.TinyAppStorageBridgeExtension", Arrays.asList("setTinyLocalStorage", JSApiCachePoint.GET_LOCAL_STORAGE, "removeTinyLocalStorage", "clearTinyLocalStorage", "getTinyLocalStorageInfo")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("downgrade-build", "com.alipay.mobile.downgrade.js.DowngradeExtension", Arrays.asList("getDowngradeResult", "downgradeFinished")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("ucdp-build", "com.alipay.android.phone.businesscommon.ucdp.api.UCDPBridgeExtension", Arrays.asList("ucdpFeedbackForServer")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-businesscommon-commonbiz", "com.alipay.mobile.h5plugin.H5LocationExtension", Arrays.asList("getCurrentLocation"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("jsruntime-build", "com.alipay.mobile.jsruntime.extension.RegisterRunScriptExtension", Arrays.asList("exitBackgroundRunScript", "runRegisteredScript")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("jsruntime-build", "com.alipay.mobile.jsruntime.extension.AppStatusExtension", Arrays.asList("getTinyAppStatus")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-beecitypicker", "com.alipay.mobile.beehive.cityselect.impl.H5PickCityExtension", Arrays.asList("getCities"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-beecitypicker", "com.alipay.mobile.beehive.cityselect.impl.H5PickCityExtension", Arrays.asList("setLocatedCity"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-beecitypicker", "com.alipay.mobile.beehive.cityselect.impl.H5ChooseDistrictExtension", Arrays.asList("chooseDistrict"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.DatePickerBridgeExtension", Arrays.asList("datePicker"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-beelocationpicker", "com.alipay.mobile.location.openlocation.H5OpenLocationExtension", Arrays.asList("openLocation")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-mobilesdk-iot-security", "com.alipay.android.iot.security.framework.SecurityExtension", Arrays.asList("iotSecurity")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.bluetooth.jsapi.BLEBridgeExtension", Arrays.asList("closeBluetoothAdapter", "getBluetoothAdapterState", "getBLEDeviceServices", "getBLEDeviceRSSI", "getBLEMTU", "setBLEMTU", "getBLEDeviceCharacteristics", "openBluetoothAdapter", "startBluetoothDevicesDiscovery", "stopBluetoothDevicesDiscovery", "getBluetoothDevices", "getConnectedBluetoothDevices", "connectBLEDevice", "disconnectBLEDevice", "writeBLECharacteristicValue", "enableBluetooth", "disableBluetooth", "cancelBluetoothPair", "notifyBLECharacteristicValueChange", "readBLECharacteristicValue", "createBluetoothSocket", "writeBluetoothSocketValue", "closeBluetoothSocket", "connectBluetoothSocket", "makeBluetoothPair", "cancelBluetoothPair", "getBluetoothPairs")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-apble", "com.alipay.android.phone.bluetoothsdk.BLEPeripheralBridgeExtension", Arrays.asList("openBLEPeripheral", "closeBLEPeripheral", "removePeripheralService", "addPeripheralService", "updateCharacteristic", "startBeaconDiscoveryTest", "getBeaconList", "startBLEAdvertising", "stopBLEAdvertising")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension", Arrays.asList(JSApiCachePoint.GET_SYSTEM_INFO)));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.clipboard.ClipboardBridgeExtension", Arrays.asList("setClipboard", "getClipboard"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.nfc.HCEBridgeExtension", Arrays.asList("startHCE"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.phone.ChoosePhoneContactBridgeExtension", Arrays.asList("contact"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.screen.ScreenBrightnessBridgeExtension", Arrays.asList("getScreenBrightness", "setScreenBrightness", "setScreenAutolock"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.vibrate.VibrateBridgeExtension", Arrays.asList("vibrate", "vibrateLong", "vibrateShort"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension", Arrays.asList("connectWifi", "getConnectedWifi", "getWifiList", "startWifi", "stopWifi"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.wifi.WifiInfoExtension", Arrays.asList("getWifiInfo"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.actionsheet.ActionSheetBridgeExtension", Arrays.asList("actionSheet"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.security.OpenAuthExtension", Arrays.asList("showAuthGuide"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension", Arrays.asList(ApiDowngradeConstant.ActionType.ALERT, "confirm", "prompt", "agreementConfirm"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.engine.EngineBridgeExtension", Arrays.asList("measureText", "checkJSAPI"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.toast.ToastBridgeExtension", Arrays.asList(ApiDowngradeConstant.ActionType.TOAST, "hideToast"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.websocket.WebSocketBridgeExtension", Arrays.asList("connectSocket", "sendSocketMessage", "closeSocket"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.engine.InputBridgeExtension", Arrays.asList("toggleSoftInput", "showSoftInput"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.engine.OrientationBridgeExtension", Arrays.asList("getScreenOrientation", "setScreenOrientation"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.network.NetworkBridgeExtension", Arrays.asList("getNetworkType"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-ariver", "com.alibaba.ariver.jsapi.NotificationBridgeExtension", Arrays.asList("addNotifyListener", "removeNotifyListener", "postNotification"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alibaba.ariver.jsapi.WalletGetClientInfoBridgeExtension", Arrays.asList("getClientInfo"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alipay.mobile.nebulax.integration.wallet.extensions.APDataStorageBridgeExtension", Arrays.asList("setAPDataStorage", "getAPDataStorage", "removeAPDataStorage", "clearAPDataStorage", "switchControl", "getSwitchControlStatus"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alipay.mobile.nebulax.integration.wallet.extensions.CommonInfoBridgeExtension", Arrays.asList("getLoginToken", "getProcessInfo", "getAppType"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alipay.mobile.nebulax.integration.wallet.extensions.WalletUserInfoExtension", Arrays.asList("getUserInfo"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alibaba.ariver.jsapi.WalletResourceBridgeExtension", Arrays.asList("checkApp"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulawallet", "com.alipay.mobile.nebulax.integration.wallet.extensions", Arrays.asList("getAppInfo"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.CookieBridgeExtension", Arrays.asList("getMtopToken"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.AppManagerBridgeExtension", Arrays.asList("preloadApp"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.CommonBridgeExtensionForEdge", Arrays.asList("setSourceTracingInfo"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.H5JSInjectDebugBridgeExtension", Arrays.asList("switchWebView"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.RecordSecureBridgeExtension", Arrays.asList("setRecordSecure"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.ServerTimeBridgeExtension", Arrays.asList(Constants.JS_API_GET_SERVER_TIME), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.SessionExtension", Arrays.asList("getSessionData", "setSessionData"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("mobile-nebulaintegration", "com.alipay.mobile.nebulax.integration.base.jsapi.ShowNetWorkCheckActivityBridgeExtension", Arrays.asList(ACContainerJSPlugin.SHOW_NETWORK_CHECK_ACTIVITY), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-paladin", "com.alipay.mobile.paladin.nebulaxadapter.extension.KeyboardBridgeExtension", Arrays.asList("updateKeyboard", "showKeyboard", "hideKeyboard")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.phone.MakePhoneCallBridgeExtension", Arrays.asList("makePhoneCall")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.phone.TelephonyInfoBridgeExtension", Arrays.asList("getCarrierName")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.contact.AddPhoneContactBridgeExtension", Arrays.asList("addPhoneContact")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.wifi.SendUDPMessageExtension", Arrays.asList("getSSID", "sendUdpMessage"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.system.SystemRootStatusBridgeExtension", Arrays.asList("isSystemRoot")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.wifi.WifiInfoExtension", Arrays.asList("getWifiInfo"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.sensor.SensorBridgeExtension", Arrays.asList("watchShake")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.sensor.ShakeMonitorBridgeExtension", Arrays.asList("startDeviceShakeListener", "stopDeviceShakeListener"), Page.class));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.file.jsapi.FSManageExtension", Arrays.asList("fsManage")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.file.jsapi.FileBridgeExtension", Arrays.asList("getFileInfo", "getSavedFileInfo", "getSavedFileList", "removeSavedFile", "saveFile")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.bluetooth.jsapi.IBeaconBridgeExtension", Arrays.asList("getBeacons", "startBeaconDiscovery", "stopBeaconDiscovery")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.sensor.DeviceOrientationBridgeExtension", Arrays.asList("startDeviceMotionListening", "stopDeviceMotionListening")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.file.jsapi.SharedFileExtension", Arrays.asList("createSharedBiz")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.mdns.jsapi.MultiCastDNSBridgeExtension", Arrays.asList("startLocalServiceDiscovery", "stopLocalServiceDiscovery")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.map.jsapi.GetMapInfoBridgeExtension", Arrays.asList("getMapInfo")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.map.jsapi.AuthMapLocationBridgeExtension", Arrays.asList("authMapLocation")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.map.jsapi.CalculateRouteExtension", Arrays.asList(CalculateRouteExtension.ACTION_CALCULATE_ROUTE)));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.nfc.jsapi.NFCBridgeExtension", Arrays.asList("getNFCAdapter", "enableNFC", "startNFCDiscovery", "stopNFCDiscovery", "connectNFC", "closeNFC", "setNFCTimeout", "transceiveNFC", "getNFCMaxTransceiveLength", "getIsoDepHistoricalBytes", "getNFCTag", "writeNdefMessage", "getNfcASak", "getNfcAAtqa")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.navigator.NavigatorBridgeExtension", Arrays.asList("navigateToSetting")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.calendar.jsapi.CalendarBridgeExtension", Arrays.asList("addEventCalendar", "addEventCal")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("com-alibaba-ariver-commonability", "com.alibaba.ariver.commonability.device.jsapi.system.GetBatteryInfoBridgeExtension", Arrays.asList("getBatteryInfo")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-blessingcard", "com.alipay.mobile.blessingcard.data.CardReceiveExtension", Arrays.asList("AlipayNewYearNebulaPlugin.showFuCard", "AlipayNewYearNebulaPlugin.fuCardTasks", "AlipayNewYearNebulaPlugin.addFuCard", "AlipayNewYearNebulaPlugin.removeFuCard", "AlipayNewYearNebulaPlugin.zodiacAwardStr")));
        arrayList.add(ExtHubBridgeExtensionManifest.makeRaw("android-phone-wallet-blessingcard", "com.alipay.mobile.blessingcard.h5bridge.PldJSBridgeExtension", Arrays.asList("startPaladinComponent", "stopPaladinComponent")));
        return arrayList;
    }
}