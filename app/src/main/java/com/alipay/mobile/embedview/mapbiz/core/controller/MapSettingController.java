package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alipay.mobile.embedview.mapbiz.data.LogoPos;
import com.alipay.mobile.embedview.mapbiz.data.MapSetting;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class MapSettingController extends H5MapController {
    public final MapSetting setting;

    public MapSettingController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.setting = new MapSetting();
    }

    public void compareAndSet(MapSetting mapSetting) {
        if (mapSetting.gestureEnable != -1) {
            setGestureEnable(mapSetting.gestureEnable == 1);
        }
        if (mapSetting.showCompass != -1) {
            setShowCompass(mapSetting.showCompass == 1);
        }
        if (mapSetting.showScale != -1) {
            setShowScale(mapSetting.showScale == 1);
        }
        if (mapSetting.tiltGesturesEnabled != -1) {
            setTiltGesturesEnable(mapSetting.tiltGesturesEnabled == 1);
        }
        if (mapSetting.showMapText != -1) {
            setShowMapText(mapSetting.showMapText == 1);
        }
        if (mapSetting.trafficEnabled != -1) {
            setTrafficEnable(mapSetting.trafficEnabled == 1);
        }
        if (mapSetting.logoPosition != null) {
            a(mapSetting.logoPosition);
        }
    }

    private void a(LogoPos logoPos) {
        this.setting.logoPosition = logoPos;
        try {
            int dip2px = DensityUtil.dip2px(this.mMapContainer.getContext(), logoPos.centerX);
            int dip2px2 = DensityUtil.dip2px(this.mMapContainer.getContext(), logoPos.centerY);
            StringBuilder sb = new StringBuilder();
            sb.append("x = ");
            sb.append(dip2px);
            sb.append(" y = ");
            sb.append(dip2px2);
            sb.append(" logoPosition.x =");
            sb.append(logoPos.centerX);
            sb.append(" logoPosition.y");
            sb.append(logoPos.centerY);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
            this.mMapContainer.getMap().getUiSettings().setLogoCenter(dip2px, dip2px2);
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            this.mMapContainer.reportController.reportException("MapSettingController#setLogoPosition", th.getMessage());
        }
    }

    public void setTiltGesturesEnable(boolean z) {
        this.setting.tiltGesturesEnabled = z ? 1 : 0;
        this.mMapContainer.getMap().getUiSettings().setTiltGesturesEnabled(z);
        this.mMapContainer.getMap().getUiSettings().setRotateGesturesEnabled(z);
    }

    public void setShowMapText(boolean z) {
        this.setting.showMapText = z ? 1 : 0;
        this.mMapContainer.getMap().showMapText(z);
    }

    public void setShowScale(boolean z) {
        this.setting.showScale = z ? 1 : 0;
        this.mMapContainer.getMap().getUiSettings().setScaleControlsEnabled(z);
    }

    public void setShowCompass(boolean z) {
        this.setting.showCompass = z ? 1 : 0;
        this.mMapContainer.getMap().getUiSettings().setCompassEnabled(z);
    }

    public void setGestureEnable(boolean z) {
        this.setting.gestureEnable = z ? 1 : 0;
        this.mMapContainer.getMap().getUiSettings().setAllGesturesEnabled(z);
    }

    public void setTrafficEnable(boolean z) {
        this.setting.trafficEnabled = z ? 1 : 0;
        this.mMapContainer.getMap().setTrafficEnabled(z);
    }
}
