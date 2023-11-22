package com.alibaba.griver.map.jsapi;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.permission.IPermissionRequestCallback;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.MetaDataUtils;
import com.alibaba.griver.map.R;
import com.alibaba.griver.map.activity.GriverMapActivity;
import com.alipay.android.mapassist.util.Constants;
import com.alipay.mobile.beehive.poiselect.api.OnMapPoiSelectedListener;
import com.alipay.mobile.beehive.poiselect.api.PoiItemExt;
import com.alipay.mobile.beehive.poiselect.api.PoiSelectParams;
import com.alipay.mobile.beehive.poiselect.service.PoiSelectService;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import id.dana.utils.permission.ManifestPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class MapBridgeExtension implements BridgeExtension {
    private static final int REQUEST_COMMON_LOCATION_PERMISSION_CODE = 1001;
    private static final String TAG = "MapBridgeExtension";
    protected static String[] sRequirePermissions = {ManifestPermission.ACCESS_COARSE_LOCATION, "android.permission.ACCESS_FINE_LOCATION"};
    private static int ERROR_CODE_PERMISSION_NOT_ALLOWED = 11;
    private static int ERROR_CODE_NETWORK_ERROR = 12;
    private static int ERROR_CODE_LOCATION_ERROR = 13;
    private static int ERROR_CODE_LOCATION_TIME_OUT = 14;
    private static boolean sPermissionChecked = false;

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

    @ActionFilter
    public void openLocation(@BindingParam({"latitude"}) String str, @BindingParam({"longitude"}) String str2, @BindingParam({"name"}) String str3, @BindingParam({"address"}) String str4, @BindingParam({"scale"}) int i, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(MetaDataUtils.getMetaData(Constants.GOOGLE_MAP_KEY))) {
            GriverLogger.e(TAG, "please set google maps key first!");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                Intent intent = new Intent();
                intent.putExtra("latitude", Double.valueOf(str));
                intent.putExtra("longitude", Double.valueOf(str2));
                intent.putExtra(H5MapRenderOptimizer.KEY_SCALE, i);
                intent.putExtra("name", str3);
                intent.putExtra("address", str4);
                intent.setClass(page.getPageContext().getActivity(), GriverMapActivity.class);
                page.getPageContext().getActivity().startActivity(intent);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("latitude=");
            sb.append(str);
            sb.append(",longitude=");
            sb.append(str2);
            sb.append(",address=");
            sb.append(str4);
            sb.append(",name=");
            sb.append(str3);
            RVLogger.d(TAG, sb.toString());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", (Object) 2);
            jSONObject.put("errorMessage", "Missing required parameters(latitude and longitude, name and description)");
            if (bridgeCallback != null) {
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        } catch (Exception e) {
            RVLogger.e(TAG, "openLocation exception.", e);
        }
    }

    @ActionFilter("beehiveGetPOI")
    public void beehiveGetPOI(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(MetaDataUtils.getMetaData(Constants.GOOGLE_MAP_KEY))) {
            GriverLogger.e(TAG, "please set google maps key first!");
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        } else if (jSONObject == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
        } else if (sPermissionChecked) {
            chooseLocation(page, jSONObject, bridgeCallback);
        } else {
            checkPermission(page, jSONObject, bridgeCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseLocation(Page page, JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        String str;
        if (page != null) {
            str = BundleUtils.getString(page.getStartParams(), "appId");
            if (TextUtils.isEmpty(str)) {
                str = BundleUtils.getString(page.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
                if (TextUtils.isEmpty(str)) {
                    str = BundleUtils.getString(page.getStartParams(), RVConstants.EXTRA_PARENT_APP_ID);
                }
            }
        } else {
            str = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putString(PoiSelectParams.KEY_JS_API_TAG, "chooseLocation");
        bundle.putLong(PoiSelectParams.KEY_JS_API_START_TIME, System.currentTimeMillis());
        Iterator<Map.Entry<String, Object>> it = jSONObject.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            key.hashCode();
            char c = 65535;
            switch (key.hashCode()) {
                case -2003908843:
                    if (key.equals(PoiSelectParams.KEY_NEEDREGEOCODE)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1696469856:
                    if (key.equals("showLocatedCity")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1439978388:
                    if (key.equals("latitude")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1411093378:
                    if (key.equals("appKey")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1197339240:
                    if (key.equals("locatePOI")) {
                        c = 4;
                        break;
                    }
                    break;
                case -938578798:
                    if (key.equals("radius")) {
                        c = 5;
                        break;
                    }
                    break;
                case -921799957:
                    if (key.equals("presetPOI")) {
                        c = 6;
                        break;
                    }
                    break;
                case -814408215:
                    if (key.equals("keyword")) {
                        c = 7;
                        break;
                    }
                    break;
                case -714326457:
                    if (key.equals("isShowConfirmSelectBtn")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -710826929:
                    if (key.equals(PoiSelectParams.SEARCH_HINT)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -511259571:
                    if (key.equals("fullMap")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -401375068:
                    if (key.equals("poiType")) {
                        c = 11;
                        break;
                    }
                    break;
                case 3053931:
                    if (key.equals("city")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 3357091:
                    if (key.equals("mode")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 109250890:
                    if (key.equals(H5MapRenderOptimizer.KEY_SCALE)) {
                        c = 14;
                        break;
                    }
                    break;
                case 110371416:
                    if (key.equals("title")) {
                        c = 15;
                        break;
                    }
                    break;
                case 137365935:
                    if (key.equals("longitude")) {
                        c = 16;
                        break;
                    }
                    break;
                case 217723454:
                    if (key.equals("markerTitle")) {
                        c = 17;
                        break;
                    }
                    break;
                case 336704906:
                    if (key.equals("hideSearch")) {
                        c = 18;
                        break;
                    }
                    break;
                case 1079646900:
                    if (key.equals("showHideLocation")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1109771824:
                    if (key.equals("showPoiActions")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1577493126:
                    if (key.equals("isNeedScreenShot")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1987818786:
                    if (key.equals("showPoiDistance")) {
                        c = 22;
                        break;
                    }
                    break;
                case 2067279704:
                    if (key.equals("showTab")) {
                        c = 23;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case '\b':
                case '\n':
                case 18:
                case 20:
                case 21:
                case 22:
                case 23:
                    bundle.putBoolean(key, jSONObject.getBooleanValue(key));
                    break;
                case 1:
                    bundle.putBoolean(PoiSelectParams.SHOW_LOCATED_CITY, jSONObject.getBooleanValue(key));
                    break;
                case 2:
                case 16:
                    Double d = jSONObject.getDouble(key);
                    if (d == null) {
                        break;
                    } else {
                        bundle.putDouble(key, d.doubleValue());
                        break;
                    }
                case 3:
                case 4:
                case 6:
                case 7:
                case '\t':
                case 11:
                case '\f':
                case '\r':
                case 15:
                case 17:
                    bundle.putString(key, jSONObject.getString(key));
                    break;
                case 5:
                    Integer integer = jSONObject.getInteger(key);
                    if (integer == null) {
                        break;
                    } else {
                        bundle.putInt(key, integer.intValue());
                        break;
                    }
                case 14:
                    Float f = jSONObject.getFloat(key);
                    if (f == null) {
                        break;
                    } else {
                        bundle.putFloat(key, f.floatValue());
                        break;
                    }
                case 19:
                    bundle.putBoolean(PoiSelectParams.SHOW_HIDE_LOCATION, jSONObject.getBooleanValue(key));
                    break;
            }
        }
        String string = jSONObject.containsKey("mode") ? jSONObject.getString("mode") : "default";
        bundle.putString("sendBtnText", "Select");
        PoiSelectService poiSelectService = (PoiSelectService) RVProxy.get(PoiSelectService.class);
        OnMapPoiSelectedListener onMapPoiSelectedListener = new OnMapPoiSelectedListener() { // from class: com.alibaba.griver.map.jsapi.MapBridgeExtension.1
            @Override // com.alipay.mobile.beehive.poiselect.api.OnPoiSelectedListener
            public void onPoiSelected(PoiItemExt poiItemExt) {
                if (poiItemExt == null) {
                    return;
                }
                bridgeCallback.sendJSONResponse(poiItemExt.toJSONObject());
            }

            @Override // com.alipay.mobile.beehive.poiselect.api.OnMapPoiSelectedListener
            public void onPoiSelectCancel() {
                bridgeCallback.sendBridgeResponse(BridgeResponse.newError(11, "User canceled operation"));
            }

            @Override // com.alipay.mobile.beehive.poiselect.api.OnMapPoiSelectedListener, com.alipay.mobile.beehive.poiselect.api.OnPoiSelectedListener
            public void onHideLocationSelected() {
                bridgeCallback.sendJSONResponse(new JSONObject());
            }
        };
        if ("default".equals(string)) {
            poiSelectService.startMapPoiSelect(bundle, onMapPoiSelectedListener);
        } else {
            poiSelectService.startPoiSelect(bundle, onMapPoiSelectedListener);
        }
    }

    private void checkPermission(final Page page, final JSONObject jSONObject, final BridgeCallback bridgeCallback) {
        try {
            if (Build.VERSION.SDK_INT >= 23 && GriverEnv.getApplicationContext().getApplicationInfo().targetSdkVersion >= 23) {
                if (sPermissionChecked) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    LocationManager locationManager = (LocationManager) GriverEnv.getApplicationContext().getSystemService("location");
                    if (!((Boolean) locationManager.getClass().getDeclaredMethod("isLocationEnabled", new Class[0]).invoke(locationManager, new Object[0])).booleanValue()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("error", (Object) Integer.valueOf(ERROR_CODE_PERMISSION_NOT_ALLOWED));
                        jSONObject2.put("errorMessage", (Object) GriverEnv.getApplicationContext().getString(R.string.griver_map_no_location_permission));
                        bridgeCallback.sendJSONResponse(jSONObject2);
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (String str : sRequirePermissions) {
                    if (((Integer) GriverEnv.getApplicationContext().getClass().getMethod("checkSelfPermission", String.class).invoke(GriverEnv.getApplicationContext(), str)).intValue() != 0) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    GriverEnv.getTopActivity().get().requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1001);
                    RVNativePermissionRequestProxy rVNativePermissionRequestProxy = (RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class);
                    if (rVNativePermissionRequestProxy != null) {
                        rVNativePermissionRequestProxy.addPermRequstCallback(1001, new IPermissionRequestCallback() { // from class: com.alibaba.griver.map.jsapi.MapBridgeExtension.2
                            @Override // com.alibaba.ariver.app.api.permission.IPermissionRequestCallback
                            public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
                                if (i == 1001) {
                                    if (iArr.length > 0 && iArr[0] == 0) {
                                        boolean unused = MapBridgeExtension.sPermissionChecked = true;
                                        MapBridgeExtension.this.chooseLocation(page, jSONObject, bridgeCallback);
                                        return;
                                    }
                                    a();
                                }
                            }

                            private void a() {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("error", (Object) Integer.valueOf(MapBridgeExtension.ERROR_CODE_PERMISSION_NOT_ALLOWED));
                                jSONObject3.put("errorMessage", (Object) GriverEnv.getApplicationContext().getString(R.string.griver_map_no_location_permission));
                                bridgeCallback.sendJSONResponse(jSONObject3);
                            }
                        });
                        return;
                    }
                    return;
                }
                sPermissionChecked = true;
                chooseLocation(page, jSONObject, bridgeCallback);
                return;
            }
            sPermissionChecked = true;
            chooseLocation(page, jSONObject, bridgeCallback);
        } catch (Exception e) {
            GriverLogger.e(TAG, "checkPermission e:", e);
        }
    }
}
