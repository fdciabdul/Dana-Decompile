package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterExceptionLogger;
import com.alipay.mobile.apmap.AdapterMapsInitializer;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.RuntimeConstants;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;

/* loaded from: classes6.dex */
public class GlobalMapsController extends H5MapController {

    /* renamed from: a */
    private static int f7151a;
    boolean mAbroadLogged;
    boolean mGlobalTokenExpired;

    public GlobalMapsController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.mGlobalTokenExpired = true;
    }

    public void onCameraChangeFinish(AdapterCameraPosition adapterCameraPosition) {
        if (!adapterCameraPosition.isAbroad || this.mAbroadLogged) {
            return;
        }
        this.mAbroadLogged = true;
        this.mMapContainer.reportController.reportJsApiCall("renderAbroad", this.mMapContainer.configController.isMapAbroadEnabled() ? 1 : 0);
    }

    public void onAttached() {
        if (this.mGlobalTokenExpired) {
            AdapterMapsInitializer.loadWorldGridMap(this.mMapContainer.getMapView(), this.mMapContainer.configController.isMapAbroadEnabled());
            try {
                AdapterMapsInitializer.disableCachedMapDataUpdate(this.mMapContainer.getMapView(), !this.mMapContainer.configController.isCachedMapDataUpdateEnabled());
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
            }
            this.mGlobalTokenExpired = false;
        }
        try {
            if (this.mMapContainer.configController.isNotifyMapLoadingErrorEnabled()) {
                AdapterMapsInitializer.setExceptionLogger(this.mMapContainer.getMapView(), new AdapterExceptionLogger() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.GlobalMapsController.1
                    {
                        GlobalMapsController.this = this;
                    }

                    @Override // com.alipay.mobile.apmap.AdapterExceptionLogger
                    public void onDownloaderException(int i, int i2) {
                        if (i != GlobalMapsController.f7151a) {
                            GlobalMapsController.this.a(i, i2);
                        }
                    }
                });
            }
        } catch (Exception e) {
            RVLogger.e(H5MapContainer.TAG, e);
        }
    }

    public void onDetached() {
        if (RuntimeConstants.INSTANCE.isMainProcess()) {
            this.mGlobalTokenExpired = true;
        }
        if (this.mMapContainer.configController.isNotifyMapLoadingErrorEnabled()) {
            try {
                AdapterMapsInitializer.setExceptionLogger(this.mMapContainer.getMapView(), null);
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
            }
        }
    }

    public void a(int i, int i2) {
        try {
            if (this.mMapContainer.getH5Page() != null) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errorCode", (Object) Integer.valueOf(i));
                jSONObject2.put(ZimMessageChannel.K_RPC_RES_CODE, (Object) Integer.valueOf(i2));
                jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
                jSONObject.put("data", (Object) jSONObject2);
                if (this.mMapContainer.getExtraJsCallback() != null) {
                    this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "mapLoadingError" : "nbcomponent.map.bindmaploadingerror", jSONObject);
                }
            }
            this.mMapContainer.reportController.reportLoadMapError(i, i2);
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("GlobalMapsController#notifyMapLoadingError", th.getMessage());
        }
    }
}
