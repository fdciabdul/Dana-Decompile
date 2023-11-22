package com.alipay.android.mapassist.ui;

import android.graphics.Bitmap;
import android.location.Location;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.android.mapassist.util.AMapUtil;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterAMapUtils;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptor;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.LatLonPointEx;
import com.alipay.mobile.map.model.geocode.PoiItem;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class PoiOverlay {

    /* renamed from: a */
    private final AdapterAMap f6894a;
    private List<AdapterMarker> b = new ArrayList();
    private boolean c = true;
    private boolean d = true;
    private PoiMarkerComparator e = new PoiMarkerComparator();
    private final PoiMarkerComparatorEx f = new PoiMarkerComparatorEx();

    /* loaded from: classes6.dex */
    public class PoiItemComparator implements Comparator<PoiItem> {
        public PoiItemComparator() {
            PoiOverlay.this = r1;
        }

        @Override // java.util.Comparator
        public int compare(PoiItem poiItem, PoiItem poiItem2) {
            return Math.round(poiItem.getDistance() - poiItem2.getDistance());
        }
    }

    /* loaded from: classes6.dex */
    public class PoiMarkerComparator implements Comparator<AdapterMarker> {
        public PoiMarkerComparator() {
            PoiOverlay.this = r1;
        }

        @Override // java.util.Comparator
        public int compare(AdapterMarker adapterMarker, AdapterMarker adapterMarker2) {
            return Math.round(Float.valueOf(String.valueOf(adapterMarker.getObject())).floatValue() - Float.valueOf(String.valueOf(adapterMarker2.getObject())).floatValue());
        }
    }

    /* loaded from: classes6.dex */
    public class PoiMarkerComparatorEx implements Comparator<AdapterMarker> {
        public PoiMarkerComparatorEx() {
            PoiOverlay.this = r1;
        }

        @Override // java.util.Comparator
        public int compare(AdapterMarker adapterMarker, AdapterMarker adapterMarker2) {
            return (int) Math.round(((MarkerInfo) adapterMarker.getObject()).distance.doubleValue() - ((MarkerInfo) adapterMarker2.getObject()).distance.doubleValue());
        }
    }

    public PoiOverlay(AdapterAMap adapterAMap) {
        this.f6894a = adapterAMap;
    }

    public void setNeedSortByDistance(boolean z) {
        this.d = z;
    }

    public void onDraw(Bitmap bitmap, List<PoiItem> list, Location location) {
        RVLogger.d("PoiOverlay", "onDraw start");
        AdapterLatLng adapterLatLng = location != null ? new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()) : null;
        AdapterBitmapDescriptor fromBitmap = AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, bitmap);
        if (list != null) {
            for (PoiItem poiItem : list) {
                AdapterAMap adapterAMap = this.f6894a;
                AdapterMarker addMarker = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f6894a, poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude())).title(poiItem.getTitle()).snippet(poiItem.getSnippet()).icon(fromBitmap));
                addMarker.setObject(Double.valueOf(adapterLatLng != null ? AdapterAMapUtils.calculateLineDistance(new AdapterLatLng(this.f6894a, poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude()), adapterLatLng) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                this.b.add(addMarker);
            }
        }
        if (this.c && this.d) {
            Collections.sort(this.b, this.e);
        }
        AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(this.f6894a);
        for (int i = 0; i < this.b.size(); i++) {
            AdapterMarker adapterMarker = this.b.get(i);
            if (i == 0 && this.c) {
                adapterMarker.showInfoWindow();
            }
            if (i >= 5) {
                break;
            }
            adapterLatLngBounds.include(adapterMarker.getPosition());
        }
        if (this.c && this.b.size() > 0) {
            this.f6894a.moveCamera(AdapterCameraUpdateFactory.changeLatLng(this.b.get(0).getPosition()));
        } else {
            this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(adapterLatLngBounds.build(), 5));
        }
        this.c = false;
    }

    public void onDrawSingle(Bitmap bitmap, LatLonPoint latLonPoint, int i) {
        RVLogger.d("PoiOverlay", "onDrawSingle start");
        AdapterBitmapDescriptor fromBitmap = AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, bitmap);
        AdapterLatLng adapterLatLng = new AdapterLatLng(this.f6894a, latLonPoint.getLatitude(), latLonPoint.getLongitude());
        AdapterAMap adapterAMap = this.f6894a;
        this.b.add(adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(adapterLatLng).icon(fromBitmap)));
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLng(adapterLatLng));
        AdapterAMap adapterAMap2 = this.f6894a;
        adapterAMap2.moveCamera(AdapterCameraUpdateFactory.zoomTo(adapterAMap2, i));
    }

    public void onDrawSingle(Bitmap bitmap, LatLonPoint latLonPoint, Location location) {
        RVLogger.d("PoiOverlay", "onDrawSingle curlocation start");
        AdapterAMap adapterAMap = this.f6894a;
        AdapterMarker addMarker = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f6894a, latLonPoint.getLatitude(), latLonPoint.getLongitude())).icon(AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, bitmap)));
        this.b.add(addMarker);
        AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(this.f6894a);
        adapterLatLngBounds.include(addMarker.getPosition());
        if (location != null) {
            adapterLatLngBounds.include(new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()));
        }
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(adapterLatLngBounds.build(), 5));
    }

    public void onDrawList(Bitmap bitmap, List<LatLonPoint> list, Location location) {
        RVLogger.d("PoiOverlay", "onDrawList start");
        AdapterLatLng adapterLatLng = location != null ? new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()) : null;
        Iterator<LatLonPoint> it = list.iterator();
        while (it.hasNext()) {
            a(bitmap, it.next(), adapterLatLng);
        }
        if (adapterLatLng != null && this.d) {
            Collections.sort(this.b, this.e);
        }
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(a(adapterLatLng), 5));
    }

    private void a(Bitmap bitmap, LatLonPoint latLonPoint, AdapterLatLng adapterLatLng) {
        AdapterAMap adapterAMap = this.f6894a;
        AdapterMarker addMarker = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f6894a, latLonPoint.getLatitude(), latLonPoint.getLongitude())).icon(AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, bitmap)));
        addMarker.setObject(Integer.valueOf(adapterLatLng != null ? (int) AdapterAMapUtils.calculateLineDistance(new AdapterLatLng(this.f6894a, latLonPoint.getLatitude(), latLonPoint.getLatitude()), adapterLatLng) : 0));
        this.b.add(addMarker);
    }

    public void onDrawSingleEx(LatLonPointEx latLonPointEx, int i, boolean z) {
        RVLogger.d("PoiOverlay", "onDrawSingleEx start");
        a(latLonPointEx, null);
        if (z && (!TextUtils.isEmpty(latLonPointEx.getTitle()) || !TextUtils.isEmpty(latLonPointEx.getSnippet()))) {
            a(this.b.get(0));
        }
        if (this.b.size() > 0 && this.b.get(0) != null) {
            this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLng(this.b.get(0).getPosition()));
        }
        AdapterAMap adapterAMap = this.f6894a;
        adapterAMap.moveCamera(AdapterCameraUpdateFactory.zoomTo(adapterAMap, i));
    }

    public void onDrawSingleEx(LatLonPointEx latLonPointEx, Location location, boolean z) {
        RVLogger.d("PoiOverlay", "onDrawSingleEx curlocation start");
        AdapterLatLng adapterLatLng = location != null ? new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()) : null;
        a(latLonPointEx, adapterLatLng);
        if (z) {
            a(this.b.get(0));
        }
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(a(adapterLatLng), 5));
    }

    public void onDrawListEx(List<LatLonPointEx> list, Location location, boolean z) {
        RVLogger.d("PoiOverlay", "onDrawListEx start");
        AdapterLatLng adapterLatLng = location != null ? new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()) : null;
        Iterator<LatLonPointEx> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), adapterLatLng);
        }
        if (adapterLatLng != null && this.d) {
            Collections.sort(this.b, this.f);
        }
        if (z) {
            a(this.b.get(0));
        }
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(a(adapterLatLng), 5));
    }

    private void a(LatLonPointEx latLonPointEx, AdapterLatLng adapterLatLng) {
        AdapterAMap adapterAMap = this.f6894a;
        AdapterMarker addMarker = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f6894a, latLonPointEx.getLatitude(), latLonPointEx.getLongitude())).title(latLonPointEx.getTitle()).snippet(latLonPointEx.getSnippet()).icon(AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, latLonPointEx.getIcon())));
        double calculateLineDistance = adapterLatLng != null ? AdapterAMapUtils.calculateLineDistance(AMapUtil.convertToLatLng(this.f6894a, latLonPointEx), adapterLatLng) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        MarkerInfo markerInfo = new MarkerInfo();
        markerInfo.icon = latLonPointEx.getClickIcon();
        markerInfo.distance = Double.valueOf(calculateLineDistance);
        markerInfo.pointEx = latLonPointEx;
        addMarker.setObject(markerInfo);
        this.b.add(addMarker);
    }

    private void a(AdapterMarker adapterMarker) {
        if (adapterMarker == null) {
            return;
        }
        adapterMarker.showInfoWindow();
        MarkerInfo markerInfo = (MarkerInfo) adapterMarker.getObject();
        if (markerInfo == null) {
            return;
        }
        adapterMarker.setIcon(AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, markerInfo.pointEx.getClickIcon()));
        markerInfo.icon = markerInfo.pointEx.getClickIcon();
    }

    public void onDrawMyPoiList(Bitmap bitmap, List<PoiItem> list, Location location, boolean z, boolean z2) {
        RVLogger.d("PoiOverlay", "onDrawMyPoiList start");
        AdapterLatLng adapterLatLng = location != null ? new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()) : null;
        AdapterBitmapDescriptor fromBitmap = AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, bitmap);
        if (list != null) {
            for (PoiItem poiItem : list) {
                AdapterAMap adapterAMap = this.f6894a;
                AdapterMarker addMarker = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f6894a, poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude())).title(poiItem.getTitle()).snippet(poiItem.getSnippet()).draggable(z2).icon(fromBitmap));
                addMarker.setObject(Double.valueOf(adapterLatLng != null ? AdapterAMapUtils.calculateLineDistance(new AdapterLatLng(this.f6894a, poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude()), adapterLatLng) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                this.b.add(addMarker);
            }
        }
        if (adapterLatLng != null && this.d) {
            Collections.sort(this.b, this.e);
        }
        if (z) {
            this.b.get(0).showInfoWindow();
        }
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(a(adapterLatLng), 5));
    }

    public void onDrawPoiList(Bitmap bitmap, List<PoiItem> list, Location location, boolean z) {
        RVLogger.d("PoiOverlay", "onDrawPoiList start");
        AdapterLatLng adapterLatLng = location != null ? new AdapterLatLng(this.f6894a, location.getLatitude(), location.getLongitude()) : null;
        a(bitmap, list, adapterLatLng);
        if (adapterLatLng != null && this.d) {
            Collections.sort(this.b, this.e);
        }
        if (z) {
            this.b.get(0).showInfoWindow();
        }
        this.f6894a.moveCamera(AdapterCameraUpdateFactory.newLatLngBounds(a(adapterLatLng), 5));
    }

    private void a(Bitmap bitmap, List<PoiItem> list, AdapterLatLng adapterLatLng) {
        AdapterBitmapDescriptor fromBitmap = AdapterBitmapDescriptorFactory.fromBitmap(this.f6894a, bitmap);
        if (list != null) {
            for (PoiItem poiItem : list) {
                AdapterAMap adapterAMap = this.f6894a;
                AdapterMarker addMarker = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f6894a, poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude())).title(poiItem.getTitle()).snippet(poiItem.getSnippet()).icon(fromBitmap));
                addMarker.setObject(Double.valueOf(adapterLatLng != null ? AdapterAMapUtils.calculateLineDistance(new AdapterLatLng(this.f6894a, poiItem.getLatLonPoint().getLatitude(), poiItem.getLatLonPoint().getLongitude()), adapterLatLng) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                this.b.add(addMarker);
            }
        }
    }

    private AdapterLatLngBounds a(AdapterLatLng adapterLatLng) {
        AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(this.f6894a);
        for (int i = 0; i < this.b.size(); i++) {
            AdapterMarker adapterMarker = this.b.get(i);
            if (i >= 5) {
                break;
            }
            adapterLatLngBounds.include(adapterMarker.getPosition());
        }
        if (adapterLatLng != null) {
            adapterLatLngBounds.include(adapterLatLng);
        }
        return adapterLatLngBounds.build();
    }

    public void removeFormMap() {
        for (AdapterMarker adapterMarker : this.b) {
            if (adapterMarker != null) {
                if (adapterMarker.isInfoWindowShown()) {
                    adapterMarker.hideInfoWindow();
                }
                adapterMarker.remove();
            }
        }
    }

    public List<AdapterMarker> getMarkerList() {
        return this.b;
    }
}
