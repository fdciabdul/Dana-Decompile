package com.alibaba.griver.core.jsapi.device.location;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.map.GriverGoogleLocationCallBack;
import com.alibaba.griver.api.common.map.GriverGoogleLocationService;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.core.R;
import com.google.common.base.Ascii;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import id.dana.utils.permission.ManifestPermission;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class LocationBridgeExtension implements BridgeExtension {
    protected static final int DEFAULT_TIME_OUT = 10;
    public static final String LOCATION_BRIDGE = "LOCATION_BRIDGE";
    private static final int REQUEST_COMMON_LOCATION_PERMISSION_CODE = 1001;
    private static final String TAG = "LocationBridge";
    private static Location lastLocation;
    private static long lastLocationTime;
    public static final byte[] PlaceComponentResult = {45, -79, -67, -1, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int MyBillsEntityDataFactory = 141;
    protected static String[] sRequirePermissions = {ManifestPermission.ACCESS_COARSE_LOCATION, "android.permission.ACCESS_FINE_LOCATION"};
    private static int ERROR_CODE_PERMISSION_NOT_ALLOWED = 11;
    private static int ERROR_CODE_NETWORK_ERROR = 12;
    private static int ERROR_CODE_LOCATION_ERROR = 13;
    private static int ERROR_CODE_LOCATION_TIME_OUT = 14;
    private static int ERROR_CODE_SERVICE_CLOSED = 15;
    protected static boolean sPermissionChecked = false;
    public static String locationProvider = null;
    protected static long timeCost = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 5
            int r8 = r8 + 18
            int r6 = r6 * 6
            int r6 = r6 + 97
            byte[] r0 = com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.PlaceComponentResult
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.a(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    protected void postEvent(int i) {
    }

    private void sendStartMsg(Context context) {
        Intent intent = new Intent();
        intent.setAction("location_broadcast_start");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    private void sendEndMsg(Context context) {
        Intent intent = new Intent();
        intent.setAction("location_broadcast_end");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getLocation(final Context context, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        GriverLogger.d(TAG, "getLocation begin");
        if (context == null) {
            GriverLogger.w(TAG, "get location but context is null, return directly");
            return;
        }
        sendStartMsg(context);
        if (isUesCacheLocation(jSONObject)) {
            GriverLogger.d(LOCATION_BRIDGE, "use last system location");
            sendLocation(jSONObject, context, lastLocation, bridgeCallback, ERROR_CODE_LOCATION_ERROR);
            return;
        }
        GriverGoogleLocationService griverGoogleLocationService = null;
        try {
            griverGoogleLocationService = (GriverGoogleLocationService) RVProxy.get(GriverGoogleLocationService.class, true);
        } catch (Exception e) {
            GriverLogger.e(TAG, "locationService get fail ", e);
        }
        if (griverGoogleLocationService != null) {
            GriverLogger.d(TAG, "locationService begin");
            griverGoogleLocationService.getLocation(context, jSONObject, new GriverGoogleLocationCallBack() { // from class: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.1
                @Override // com.alibaba.griver.api.common.map.GriverGoogleLocationCallBack
                public void fail(int i) {
                    GriverLogger.d(LocationBridgeExtension.TAG, "use system location.");
                    if (i == 10) {
                        MonitorMap.Builder builder = new MonitorMap.Builder();
                        builder.message("Google location failed because of unknown reason.");
                        GriverMonitor.error(GriverMonitorConstants.ERROR_GOOGLE_LOCATION_EXCEPTION, "GriverAppContainer", builder.build());
                    }
                    LocationBridgeExtension.this.getSystemLocation(context, jSONObject, bridgeCallback);
                }

                @Override // com.alibaba.griver.api.common.map.GriverGoogleLocationCallBack
                public void success(Location location) {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null && jSONObject2.containsKey("beginRequestTime") && jSONObject.getLong("beginRequestTime") != null) {
                        LocationBridgeExtension.timeCost = System.currentTimeMillis() - jSONObject.getLong("beginRequestTime").longValue();
                    }
                    if (location == null) {
                        GriverLogger.e(LocationBridgeExtension.LOCATION_BRIDGE, "Google location failed because of locationResult is null");
                        LocationBridgeExtension.this.sendLocation(jSONObject, context, null, bridgeCallback, LocationBridgeExtension.ERROR_CODE_LOCATION_ERROR);
                        MonitorMap.Builder builder = new MonitorMap.Builder();
                        builder.message("Google location failed because of locationResult is null");
                        GriverMonitor.error(GriverMonitorConstants.ERROR_GOOGLE_LOCATION_EXCEPTION, "GriverAppContainer", builder.build());
                    } else if (location != null) {
                        LocationBridgeExtension.this.sendLocation(jSONObject, context, location, bridgeCallback, LocationBridgeExtension.ERROR_CODE_LOCATION_ERROR);
                        GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, "Google location success");
                        Location unused = LocationBridgeExtension.lastLocation = location;
                        long unused2 = LocationBridgeExtension.lastLocationTime = System.currentTimeMillis();
                    }
                }
            });
            return;
        }
        GriverLogger.d(TAG, "use system location.");
        getSystemLocation(context, jSONObject, bridgeCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLocationProvider(LocationManager locationManager) {
        if (locationManager.getProviders(true).contains("network")) {
            locationProvider = "network";
        } else {
            locationProvider = "gps";
        }
        return locationProvider;
    }

    protected void getSystemLocation(final Context context, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            GriverLogger.w(TAG, "location manager is null, can not get location, return");
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_CODE_LOCATION_ERROR, context.getString(R.string.griver_core_location_failed)));
                postEvent(ERROR_CODE_LOCATION_ERROR);
                return;
            }
            return;
        }
        GriverLogger.d(LOCATION_BRIDGE, "use system location");
        locationProvider = getLocationProvider(locationManager);
        final Handler handler = new Handler(Looper.getMainLooper());
        final LocationListener locationListener = new LocationListener() { // from class: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.2
            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                GriverLogger.d(LocationBridgeExtension.LOCATION_BRIDGE, "use system location end");
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null && jSONObject2.containsKey("beginRequestTime") && jSONObject.getLong("beginRequestTime") != null) {
                    LocationBridgeExtension.timeCost = System.currentTimeMillis() - jSONObject.getLong("beginRequestTime").longValue();
                }
                Handler handler2 = handler;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages(null);
                }
                if (location != null) {
                    Location unused = LocationBridgeExtension.lastLocation = location;
                    long unused2 = LocationBridgeExtension.lastLocationTime = System.currentTimeMillis();
                }
                LocationBridgeExtension.this.sendLocation(jSONObject, context, location, bridgeCallback, LocationBridgeExtension.ERROR_CODE_LOCATION_ERROR);
            }
        };
        handler.postDelayed(new Runnable() { // from class: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.3
            @Override // java.lang.Runnable
            public void run() {
                LocationListener locationListener2;
                LocationBridgeExtension.this.sendLocation(jSONObject, context, null, bridgeCallback, LocationBridgeExtension.ERROR_CODE_LOCATION_TIME_OUT);
                LocationManager locationManager2 = locationManager;
                if (locationManager2 == null || (locationListener2 = locationListener) == null) {
                    return;
                }
                locationManager2.removeUpdates(locationListener2);
            }
        }, jSONObject.getInteger(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT).intValue() * 1000);
        try {
            locationManager.requestSingleUpdate(locationProvider, locationListener, (Looper) null);
        } catch (Exception e) {
            GriverLogger.e(TAG, "request location update failed", e);
            handler.removeCallbacksAndMessages(null);
            if (locationManager != null) {
                locationManager.removeUpdates(locationListener);
            }
            sendLocation(jSONObject, context, null, bridgeCallback, ERROR_CODE_LOCATION_ERROR);
        }
    }

    private boolean isUesCacheLocation(JSONObject jSONObject) {
        synchronized (this) {
            if (lastLocation == null) {
                return false;
            }
            return (System.currentTimeMillis() - lastLocationTime) - ((long) (jSONObject.getInteger("cacheTimeout").intValue() * 1000)) < 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendLocation(JSONObject jSONObject, Context context, Location location, BridgeCallback bridgeCallback, int i) {
        synchronized (this) {
            if (bridgeCallback == null) {
                GriverLogger.w(TAG, "get location callback is null, return directly");
                sendEndMsg(context);
                return;
            }
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", (Object) Double.valueOf(location.getLatitude()));
                jSONObject2.put("longitude", (Object) Double.valueOf(location.getLongitude()));
                jSONObject2.put("accuracy", (Object) Float.valueOf(location.getAccuracy()));
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject2));
            } else {
                int i2 = ERROR_CODE_LOCATION_TIME_OUT;
                if (i == i2) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(i2, context.getString(R.string.griver_core_location_timeout)));
                } else {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(ERROR_CODE_LOCATION_ERROR, context.getString(R.string.griver_core_location_failed)));
                }
            }
            sendEndMsg(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060 A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:2:0x0000, B:4:0x0038, B:7:0x0043, B:10:0x0060, B:11:0x006c, B:15:0x007d, B:17:0x0086, B:19:0x008a, B:14:0x0075, B:8:0x004c), top: B:24:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075 A[Catch: Exception -> 0x008e, TRY_ENTER, TryCatch #0 {Exception -> 0x008e, blocks: (B:2:0x0000, B:4:0x0038, B:7:0x0043, B:10:0x0060, B:11:0x006c, B:15:0x007d, B:17:0x0086, B:19:0x008a, B:14:0x0075, B:8:0x004c), top: B:24:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:2:0x0000, B:4:0x0038, B:7:0x0043, B:10:0x0060, B:11:0x006c, B:15:0x007d, B:17:0x0086, B:19:0x008a, B:14:0x0075, B:8:0x004c), top: B:24:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[Catch: Exception -> 0x008e, TRY_LEAVE, TryCatch #0 {Exception -> 0x008e, blocks: (B:2:0x0000, B:4:0x0038, B:7:0x0043, B:10:0x0060, B:11:0x006c, B:15:0x007d, B:17:0x0086, B:19:0x008a, B:14:0x0075, B:8:0x004c), top: B:24:0x0000 }] */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.UI)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getCurrentLocation(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(intDefault = 30, value = {"cacheTimeout"}) int r3, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(intDefault = 0, value = {"requestType"}) int r4, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam(intDefault = 10, value = {"timeout"}) int r5, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"bizType"}) java.lang.String r6, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode(com.alibaba.ariver.app.api.Page.class) com.alibaba.ariver.app.api.Page r7, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r8) {
        /*
            r2 = this;
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject     // Catch: java.lang.Exception -> L8e
            r0.<init>()     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "cacheTimeout"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L8e
            r0.put(r1, r3)     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = "requestType"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> L8e
            r0.put(r3, r4)     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = "timeout"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L8e
            r0.put(r3, r4)     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = "bizType"
            r0.put(r3, r6)     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = "beginRequestTime"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L8e
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Exception -> L8e
            r0.put(r3, r4)     // Catch: java.lang.Exception -> L8e
            com.alibaba.ariver.app.api.PageContext r3 = r7.getPageContext()     // Catch: java.lang.Exception -> L8e
            if (r3 == 0) goto L4c
            com.alibaba.ariver.app.api.PageContext r3 = r7.getPageContext()     // Catch: java.lang.Exception -> L8e
            android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L8e
            if (r3 != 0) goto L43
            goto L4c
        L43:
            com.alibaba.ariver.app.api.PageContext r3 = r7.getPageContext()     // Catch: java.lang.Exception -> L8e
            android.app.Activity r3 = r3.getActivity()     // Catch: java.lang.Exception -> L8e
            goto L5e
        L4c:
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVEnvironmentService> r3 = com.alibaba.ariver.kernel.common.service.RVEnvironmentService.class
            java.lang.Object r3 = com.alibaba.ariver.kernel.common.RVProxy.get(r3)     // Catch: java.lang.Exception -> L8e
            com.alibaba.ariver.kernel.common.service.RVEnvironmentService r3 = (com.alibaba.ariver.kernel.common.service.RVEnvironmentService) r3     // Catch: java.lang.Exception -> L8e
            java.lang.ref.WeakReference r3 = r3.getTopActivity()     // Catch: java.lang.Exception -> L8e
            java.lang.Object r3 = r3.get()     // Catch: java.lang.Exception -> L8e
            android.content.Context r3 = (android.content.Context) r3     // Catch: java.lang.Exception -> L8e
        L5e:
            if (r3 != 0) goto L6c
            java.lang.Class<com.alibaba.ariver.kernel.common.service.RVEnvironmentService> r3 = com.alibaba.ariver.kernel.common.service.RVEnvironmentService.class
            java.lang.Object r3 = com.alibaba.ariver.kernel.common.RVProxy.get(r3)     // Catch: java.lang.Exception -> L8e
            com.alibaba.ariver.kernel.common.service.RVEnvironmentService r3 = (com.alibaba.ariver.kernel.common.service.RVEnvironmentService) r3     // Catch: java.lang.Exception -> L8e
            android.app.Application r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L8e
        L6c:
            com.alibaba.ariver.app.api.App r4 = r7.getApp()     // Catch: java.lang.Exception -> L8e
            if (r4 != 0) goto L75
            java.lang.String r4 = ""
            goto L7d
        L75:
            com.alibaba.ariver.app.api.App r4 = r7.getApp()     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = r4.getAppId()     // Catch: java.lang.Exception -> L8e
        L7d:
            java.lang.String r5 = "appId"
            r0.put(r5, r4)     // Catch: java.lang.Exception -> L8e
            boolean r4 = com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.sPermissionChecked     // Catch: java.lang.Exception -> L8e
            if (r4 == 0) goto L8a
            r2.getLocation(r3, r0, r8)     // Catch: java.lang.Exception -> L8e
            return
        L8a:
            r2.checkPermission(r3, r0, r8)     // Catch: java.lang.Exception -> L8e
            return
        L8e:
            r3 = move-exception
            java.lang.String r4 = "LocationBridge"
            java.lang.String r5 = "getCurrentLocation exception:"
            com.alibaba.griver.base.common.logger.GriverLogger.e(r4, r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.getCurrentLocation(int, int, int, java.lang.String, com.alibaba.ariver.app.api.Page, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }

    private void checkPermission(final Context context, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    byte b = PlaceComponentResult[41];
                    byte b2 = PlaceComponentResult[3];
                    Object[] objArr = new Object[1];
                    a(b, b2, (byte) (-b2), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    Object[] objArr2 = new Object[1];
                    a((byte) (-PlaceComponentResult[3]), (byte) (-PlaceComponentResult[4]), PlaceComponentResult[41], objArr2);
                    if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion >= 23) {
                        if (sPermissionChecked) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 28) {
                            LocationManager locationManager = (LocationManager) context.getSystemService("location");
                            if (locationManager != null && !locationManager.isLocationEnabled()) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("error", (Object) Integer.valueOf(ERROR_CODE_SERVICE_CLOSED));
                                jSONObject2.put("errorMessage", (Object) context.getString(R.string.griver_core_service_closed));
                                bridgeCallback.sendJSONResponse(jSONObject2);
                                postEvent(ERROR_CODE_SERVICE_CLOSED);
                                return;
                            }
                        } else if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) == 0) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("error", (Object) Integer.valueOf(ERROR_CODE_SERVICE_CLOSED));
                            jSONObject3.put("errorMessage", (Object) context.getString(R.string.griver_core_service_closed));
                            bridgeCallback.sendJSONResponse(jSONObject3);
                            postEvent(ERROR_CODE_SERVICE_CLOSED);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (String str : sRequirePermissions) {
                            if (context.checkSelfPermission(str) != 0) {
                                arrayList.add(str);
                            }
                        }
                        if (arrayList.size() > 0) {
                            GriverEnv.getTopActivity().get().requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1001);
                            RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
                            if (rVNativePermissionRequestProxy != null) {
                                rVNativePermissionRequestProxy.addPermRequstCallback(1001, new IPermissionRequestCallback() { // from class: com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtension.4
                                    @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                                    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                                        if (i == 1001) {
                                            if (iArr.length > 0 && iArr[0] == 0) {
                                                LocationBridgeExtension.sPermissionChecked = true;
                                                LocationBridgeExtension.this.getLocation(context, jSONObject, bridgeCallback);
                                                return;
                                            }
                                            a();
                                        }
                                    }

                                    private void a() {
                                        JSONObject jSONObject4 = new JSONObject();
                                        jSONObject4.put("error", (Object) Integer.valueOf(LocationBridgeExtension.ERROR_CODE_PERMISSION_NOT_ALLOWED));
                                        jSONObject4.put("errorMessage", (Object) context.getString(R.string.griver_core_no_location_permission));
                                        bridgeCallback.sendJSONResponse(jSONObject4);
                                        LocationBridgeExtension.this.postEvent(LocationBridgeExtension.ERROR_CODE_PERMISSION_NOT_ALLOWED);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        sPermissionChecked = true;
                        getLocation(context, jSONObject, bridgeCallback);
                        return;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            sPermissionChecked = true;
            getLocation(context, jSONObject, bridgeCallback);
        } catch (Exception e) {
            GriverLogger.e(TAG, "checkPermission e:", e);
        }
    }
}
