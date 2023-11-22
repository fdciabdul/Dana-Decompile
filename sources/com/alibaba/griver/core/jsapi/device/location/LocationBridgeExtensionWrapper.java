package com.alibaba.griver.core.jsapi.device.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.json.JsonUtils;
import id.dana.data.Source;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class LocationBridgeExtensionWrapper extends LocationBridgeExtension {
    private static final String TAG = "LocationBridgeExtensionWrapper";
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {114, -79, -70, 22, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE;
    private static List<Pair<BridgeCallback, Long>> mBridgeCallbackList = Collections.synchronizedList(new ArrayList());

    private static void b(short s, int i, byte b, Object[] objArr) {
        int i2 = 26 - (s * 22);
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        int i3 = 23 - (b * 5);
        int i4 = (i * 6) + 97;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4 = (i6 + (-i4)) - 8;
            i2++;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i6;
            i4 = (i4 + (-bArr[i2])) - 8;
            i2++;
            i6 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    private static JSONObject getPreLocationConfig() {
        String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_GET_LOCATION_PRE_CONFIG, GriverConfigConstants.DEFAULT_GET_LOCATION_PRE_CONFIG);
        if (TextUtils.isEmpty(config)) {
            return null;
        }
        return JSONUtils.parseObject(config);
    }

    private static String getAndroidSystemLocationModel() {
        return GriverInnerConfig.getConfig(GriverConfigConstants.KEY_ANDROID_USE_SYSTEM_LOCATION_MODEL, "");
    }

    public static boolean enableWhiteList(String str) {
        JSONArray jSONArray;
        try {
            JSONObject preLocationConfig = getPreLocationConfig();
            if (preLocationConfig != null && preLocationConfig.getBoolean("enable") == Boolean.TRUE && (jSONArray = preLocationConfig.getJSONArray("appList")) != null) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    if (jSONArray.getString(i).equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            GriverLogger.e(TAG, "enableWhiteList", e);
        }
        return false;
    }

    protected boolean checkSystemPermission(Context context) {
        try {
        } catch (Exception e) {
            GriverLogger.e(TAG, "checkSystemPermission e:", e);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
                byte b2 = BuiltInFictitiousFunctionClassFactory[41];
                Object[] objArr = new Object[1];
                b(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[41];
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                b(b3, b4, b4, objArr2);
                if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion >= 23) {
                    if (!sPermissionChecked) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            LocationManager locationManager = (LocationManager) context.getSystemService("location");
                            if (locationManager != null && !locationManager.isLocationEnabled()) {
                                return false;
                            }
                        } else if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) == 0) {
                            return false;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (String str : sRequirePermissions) {
                            if (context.checkSelfPermission(str) != 0) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > 0) {
                            return false;
                        }
                        sPermissionChecked = true;
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        sPermissionChecked = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension
    public String getLocationProvider(LocationManager locationManager) {
        String androidSystemLocationModel = getAndroidSystemLocationModel();
        if (!TextUtils.isEmpty(androidSystemLocationModel) && locationManager.getProviders(true).contains(androidSystemLocationModel)) {
            locationProvider = androidSystemLocationModel;
            return androidSystemLocationModel;
        }
        return super.getLocationProvider(locationManager);
    }

    public void preGetLocation(Context context, String str) {
        GriverLogger.d(TAG, "preGetLocation");
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (LocationBridgeExtensionWrapper.class) {
            mBridgeCallbackList.clear();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preGetLocation,clear:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, sb.toString());
        if (checkSystemPermission(context)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cacheTimeout", (Object) 30);
            jSONObject.put(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT, (Object) 10);
            jSONObject.put("beginRequestTime", (Object) Long.valueOf(System.currentTimeMillis()));
            jSONObject.put("appId", (Object) str);
            getLocation(context, jSONObject, new BridgeCallback() { // from class: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtensionWrapper.1
                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                public void sendBridgeResponse(BridgeResponse bridgeResponse) {
                }

                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                public void sendJSONResponse(JSONObject jSONObject2) {
                }

                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                public void sendJSONResponse(JSONObject jSONObject2, boolean z) {
                }
            });
        }
    }

    @Override // com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getCurrentLocation(@BindingParam(intDefault = 30, value = {"cacheTimeout"}) int i, @BindingParam(intDefault = 0, value = {"requestType"}) int i2, @BindingParam(intDefault = 10, value = {"timeout"}) int i3, @BindingParam({"bizType"}) String str, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        boolean z;
        GriverFullLinkStageMonitor griverFullLinkStageMonitor;
        GriverLogger.d(TAG, "getCurrentLocation");
        App app = page.getApp();
        if (app != null) {
            z = enableWhiteList(app.getAppId());
            griverFullLinkStageMonitor = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app));
        } else {
            z = false;
            griverFullLinkStageMonitor = null;
        }
        if (griverFullLinkStageMonitor != null) {
            griverFullLinkStageMonitor.addParam("location_preload_enable", Boolean.valueOf(z));
        }
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (LocationBridgeExtensionWrapper.class) {
                mBridgeCallbackList.add(new Pair<>(bridgeCallback, Long.valueOf(System.currentTimeMillis())));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("list add :");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, sb.toString());
        }
        super.getCurrentLocation(i, i2, i3, str, page, bridgeCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension
    public void sendLocation(JSONObject jSONObject, Context context, Location location, BridgeCallback bridgeCallback, int i) {
        synchronized (this) {
            String string = jSONObject != null ? jSONObject.getString("appId") : "";
            GriverLogger.d(TAG, "sendLocation");
            long currentTimeMillis = System.currentTimeMillis();
            if (enableWhiteList(string)) {
                if (mBridgeCallbackList.size() > 0) {
                    synchronized (LocationBridgeExtensionWrapper.class) {
                        if (mBridgeCallbackList.size() > 0) {
                            for (Pair<BridgeCallback, Long> pair : mBridgeCallbackList) {
                                if (pair != null && pair.first != null) {
                                    super.sendLocation(jSONObject, context, location, (BridgeCallback) pair.first, i);
                                    Map<String, String> build = new MapBuilder.Builder().map("jsapiWaitCost", String.valueOf(System.currentTimeMillis() - ((Long) pair.second).longValue())).map("resultCode", String.valueOf(location == null ? i : 0)).map("timeCost", String.valueOf(timeCost)).map("androidSystemLocationModel", TextUtils.isEmpty(locationProvider) ? Source.GOOGLE : locationProvider).build();
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("event: ");
                                    sb.append(JsonUtils.toJson(build));
                                    GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, sb.toString());
                                    GriverMonitor.event(GriverMonitorConstants.EVENT_PRELOAD_LOCATION, "GriverAppContainer", build);
                                }
                            }
                            mBridgeCallbackList.clear();
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("location notify:");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, sb2.toString());
            } else {
                super.sendLocation(jSONObject, context, location, bridgeCallback, i);
            }
        }
    }

    @Override // com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension
    protected void postEvent(int i) {
        if (mBridgeCallbackList.size() > 0) {
            synchronized (LocationBridgeExtensionWrapper.class) {
                mBridgeCallbackList.clear();
                MapBuilder.Builder map = new MapBuilder.Builder().map("jsapiWaitCost", "");
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                Map<String, String> build = map.map("resultCode", sb.toString()).map("timeCost", String.valueOf(timeCost)).map("androidSystemLocationModel", TextUtils.isEmpty(locationProvider) ? Source.GOOGLE : locationProvider).build();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("event: ");
                sb2.append(JsonUtils.toJson(build));
                GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, sb2.toString());
                GriverMonitor.event(GriverMonitorConstants.EVENT_PRELOAD_LOCATION, "GriverAppContainer", build);
            }
        }
    }
}
