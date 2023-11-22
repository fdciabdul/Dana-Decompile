package com.alipay.mobile.apmap;

import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.android.SphericalUtil;

/* loaded from: classes6.dex */
public class AdapterAMapUtils {
    public static double calculateLineDistance(AdapterLatLng adapterLatLng, AdapterLatLng adapterLatLng2) {
        return (adapterLatLng == null || adapterLatLng2 == null || adapterLatLng.is2dMapSdk() != adapterLatLng2.is2dMapSdk() || !AdapterUtil.isGoogleMapSdk()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : SphericalUtil.computeDistanceBetween(new LatLng(adapterLatLng.getLatitude(), adapterLatLng.getLongitude()), new LatLng(adapterLatLng2.getLatitude(), adapterLatLng2.getLongitude()));
    }
}
