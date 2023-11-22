package com.alipay.mobile.apmap;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.CameraUpdateFactory;

/* loaded from: classes6.dex */
public class AdapterCameraUpdateFactory {
    public static AdapterCameraUpdate changeBearing(DynamicSDKContext dynamicSDKContext, float f) {
        return null;
    }

    public static AdapterCameraUpdate changeTilt(DynamicSDKContext dynamicSDKContext, float f) {
        return null;
    }

    public static AdapterCameraUpdate newCameraPosition(AdapterCameraPosition adapterCameraPosition) {
        return null;
    }

    public static AdapterCameraUpdate newLatLngZoom(AdapterLatLng adapterLatLng, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("newLatLngZoom zoom = ");
        sb.append(f);
        RVLogger.d("AdapterCameraUpdateFactory", sb.toString());
        if (adapterLatLng == null) {
            RVLogger.d("AdapterCameraUpdateFactory", "newLatLngZoom latLng = null");
            return null;
        } else if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterCameraUpdate(CameraUpdateFactory.newLatLngZoom(adapterLatLng.getGoogleMapLatLng(), f));
        } else {
            return null;
        }
    }

    public static AdapterCameraUpdate newLatLngBoundsRect(AdapterLatLngBounds adapterLatLngBounds, int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("newLatLngBoundsRect var3 = ");
        sb.append(i3);
        RVLogger.d("AdapterCameraUpdateFactory", sb.toString());
        if (adapterLatLngBounds == null) {
            RVLogger.d("AdapterCameraUpdateFactory", "newLatLngBoundsRect var0 = null");
            return null;
        } else if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterCameraUpdate(CameraUpdateFactory.newLatLngBounds(adapterLatLngBounds.getGoogleMapLatLngBounds(), i3));
        } else {
            return null;
        }
    }

    public static AdapterCameraUpdate zoomTo(DynamicSDKContext dynamicSDKContext, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("zoomTo zoom = ");
        sb.append(f);
        RVLogger.d("AdapterCameraUpdateFactory", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterCameraUpdate(CameraUpdateFactory.zoomTo(f));
        }
        return null;
    }

    public static AdapterCameraUpdate newLatLngBounds(AdapterLatLngBounds adapterLatLngBounds, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("newLatLngBounds var1 = ");
        sb.append(i);
        RVLogger.d("AdapterCameraUpdateFactory", sb.toString());
        if (adapterLatLngBounds == null) {
            RVLogger.d("AdapterCameraUpdateFactory", "newLatLngBounds latLngBounds = null");
            return null;
        } else if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterCameraUpdate(CameraUpdateFactory.newLatLngBounds(adapterLatLngBounds.getGoogleMapLatLngBounds(), i));
        } else {
            return null;
        }
    }

    public static AdapterCameraUpdate changeLatLng(AdapterLatLng adapterLatLng) {
        RVLogger.d("AdapterCameraUpdateFactory", "changeLatLng");
        if (adapterLatLng == null) {
            RVLogger.d("AdapterCameraUpdateFactory", "changeLatLng latLng = null");
            return null;
        } else if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterCameraUpdate(CameraUpdateFactory.newLatLng(adapterLatLng.getGoogleMapLatLng()));
        } else {
            return null;
        }
    }

    public static AdapterCameraUpdate newLatLng(AdapterLatLng adapterLatLng) {
        RVLogger.d("AdapterCameraUpdateFactory", "newLatLng");
        if (adapterLatLng == null) {
            RVLogger.d("AdapterCameraUpdateFactory", "newLatLng latLng = null");
            return null;
        } else if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterCameraUpdate(CameraUpdateFactory.newLatLng(adapterLatLng.getGoogleMapLatLng()));
        } else {
            return null;
        }
    }
}
