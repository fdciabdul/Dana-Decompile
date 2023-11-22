package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.embedview.mapbiz.data.MapData;
import com.alipay.mobile.embedview.mapbiz.data.SkewAnim;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class SkewController extends H5MapController {
    public SkewController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public boolean updateComponentsForSkew(float f) {
        if (f >= 0.0f) {
            try {
                AdapterAMap map = this.mMapContainer.getMap();
                if (map == null || map.is2dMapSdk()) {
                    return false;
                }
                map.moveCamera(AdapterCameraUpdateFactory.changeTilt(map, f));
                return true;
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
            }
        }
        return false;
    }

    public boolean updateComponentsForSkewAnim(SkewAnim skewAnim) {
        AdapterAMap map;
        if (skewAnim == null) {
            return false;
        }
        try {
            float valueOfSkew = MapData.valueOfSkew(skewAnim.skew);
            if (valueOfSkew < 0.0f || (map = this.mMapContainer.getMap()) == null || map.is2dMapSdk()) {
                return false;
            }
            long j = skewAnim.duration > 0 ? skewAnim.duration : RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            map.animateCamera(AdapterCameraUpdateFactory.changeTilt(map, valueOfSkew), j, new AdapterAMap.AdapterCancelableCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.SkewController.1
                {
                    SkewController.this = this;
                }

                @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterCancelableCallback
                public void onFinish() {
                    if (atomicBoolean.get()) {
                        return;
                    }
                    atomicBoolean.set(true);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("skewChangeType", (Object) "finish");
                        jSONObject2.put("skew", (Object) Float.valueOf(SkewController.this.mMapContainer.getMap().getCameraPosition().tilt));
                        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) SkewController.this.mMapContainer.getElementId());
                        jSONObject.put("data", (Object) jSONObject2);
                        if (SkewController.this.mMapContainer.getExtraJsCallback() != null) {
                            SkewController.this.mMapContainer.getExtraJsCallback().sendToWeb(SkewController.this.mMapContainer.isCubeContainer() ? "skewChange" : "nbcomponent.map.bindskewchange", jSONObject);
                        }
                        RVLogger.d(H5MapContainer.TAG, "SkewController: onFinish");
                    } catch (Throwable th) {
                        RVLogger.e(H5MapContainer.TAG, th);
                    }
                }

                @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterCancelableCallback
                public void onCancel() {
                    if (atomicBoolean.get()) {
                        return;
                    }
                    atomicBoolean.set(true);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("skewChangeType", (Object) "cancel");
                        jSONObject2.put("skew", (Object) Float.valueOf(SkewController.this.mMapContainer.getMap().getCameraPosition().tilt));
                        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) SkewController.this.mMapContainer.getElementId());
                        jSONObject.put("data", (Object) jSONObject2);
                        if (SkewController.this.mMapContainer.getExtraJsCallback() != null) {
                            SkewController.this.mMapContainer.getExtraJsCallback().sendToWeb(SkewController.this.mMapContainer.isCubeContainer() ? "skewChange" : "nbcomponent.map.bindskewchange", jSONObject);
                        }
                        RVLogger.d(H5MapContainer.TAG, "SkewController: onCancel");
                    } catch (Throwable th) {
                        RVLogger.e(H5MapContainer.TAG, th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
        }
        return false;
    }
}
