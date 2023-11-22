package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterAMapUtils;
import com.alipay.mobile.apmap.AdapterProjection;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.core.H5MapMarker;
import com.alipay.mobile.embedview.mapbiz.data.Layout;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.MarkerCluster;
import com.alipay.mobile.embedview.mapbiz.data.Range;
import com.alipay.mobile.embedview.mapbiz.marker.grid.Cell;
import com.alipay.mobile.embedview.mapbiz.marker.grid.CellTarget;
import com.alipay.mobile.embedview.mapbiz.marker.grid.GridDistance;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MarkerClusterController extends H5MapController {
    protected ConcurrentHashMap<String, H5MapMarker> mClusterRootMarkers;
    protected ConcurrentHashMap<String, H5MapMarker> mClusteredMarkers;
    protected int mLastClusterAllCount;
    protected long mLastClusterCost;
    protected int mLastClusterRootCount;
    protected boolean mWatchCamera;

    public MarkerClusterController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.mClusteredMarkers = new ConcurrentHashMap<>();
        this.mClusterRootMarkers = new ConcurrentHashMap<>();
    }

    public H5MapMarker findRootH5MapMarkerById(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mClusterRootMarkers.get(str);
    }

    public void onMarkersChanged() {
        this.mWatchCamera = false;
        if (this.mMapContainer.markerController.h5MapMarkers.size() != 0) {
            Iterator<Map.Entry<String, H5MapMarker>> it = this.mMapContainer.markerController.h5MapMarkers.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getValue().isWatchCamera()) {
                    this.mWatchCamera = true;
                    break;
                }
            }
        }
        if (this.mWatchCamera) {
            return;
        }
        clearClusterRootMarkers();
    }

    public void clearClusterRootMarkers() {
        Iterator<Map.Entry<String, H5MapMarker>> it = this.mClusterRootMarkers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().markerContext.remove();
        }
        this.mClusterRootMarkers.clear();
        this.mClusteredMarkers.clear();
    }

    public boolean isWatchCamera() {
        return this.mWatchCamera;
    }

    public void onCameraChanging(AdapterCameraPosition adapterCameraPosition) {
        if (this.mWatchCamera && this.mMapContainer.configController.isMapDoClusterEnabled()) {
            if (!this.mMapContainer.smoothMoveMarkerController.isMoving() || this.mMapContainer.configController.isDoClusterOnMoveMarker()) {
                Iterator<Map.Entry<String, H5MapMarker>> it = this.mMapContainer.markerController.h5MapMarkers.entrySet().iterator();
                while (it.hasNext()) {
                    H5MapMarker value = it.next().getValue();
                    value.onCameraChanged(adapterCameraPosition);
                    value.onClusterStateChanged();
                }
            }
        }
    }

    public void onCameraChanged(AdapterCameraPosition adapterCameraPosition, boolean z) {
        AdapterAMap map;
        AdapterProjection projection;
        if (this.mWatchCamera && this.mMapContainer.configController.isMapDoClusterEnabled()) {
            if (!this.mMapContainer.smoothMoveMarkerController.isMoving() || this.mMapContainer.configController.isDoClusterOnMoveMarker()) {
                long currentTimeMillis = System.currentTimeMillis();
                MarkerCluster markerCluster = this.mMapContainer.renderController.getMarkerCluster();
                boolean z2 = true;
                boolean z3 = (markerCluster == null || markerCluster.clusterRanges == null || markerCluster.clusterRanges.size() == 0 || !Range.canDisplay(adapterCameraPosition.zoom, markerCluster.clusterRanges)) ? false : true;
                try {
                    map = this.mMapContainer.getMap();
                    projection = map.getProjection();
                    for (Map.Entry<String, H5MapMarker> entry : this.mMapContainer.markerController.h5MapMarkers.entrySet()) {
                        H5MapMarker value = entry.getValue();
                        value.onCameraChanged(adapterCameraPosition);
                        if (z3 && value.canBeClustered()) {
                            value.screenLocation = projection.toScreenLocation(value.getPosition());
                        } else {
                            value.screenLocation = null;
                            if (this.mClusteredMarkers.containsKey(entry.getKey())) {
                                value.setClusteredRoot(null);
                            }
                            value.onClusterStateChanged();
                        }
                    }
                } catch (Throwable th) {
                    RVLogger.e(H5MapContainer.TAG, th);
                    this.mMapContainer.reportController.reportException("MarkerClusterController#onCameraChanged", th.getMessage());
                }
                if (!z3) {
                    clearClusterRootMarkers();
                    return;
                }
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                Iterator<Map.Entry<String, H5MapMarker>> it = this.mClusterRootMarkers.entrySet().iterator();
                while (it.hasNext()) {
                    H5MapMarker value2 = it.next().getValue();
                    if (value2.getClusterChildren() != null) {
                        value2.getClusterChildren().clear();
                    }
                }
                Map<String, H5MapMarker> a2 = a(map, projection);
                for (Map.Entry<String, H5MapMarker> entry2 : this.mMapContainer.markerController.h5MapMarkers.entrySet()) {
                    String key = entry2.getKey();
                    H5MapMarker value3 = entry2.getValue();
                    if (a2.containsKey(key)) {
                        if (!this.mClusteredMarkers.containsKey(key)) {
                            hashMap.put(key, value3);
                        }
                    } else {
                        if (this.mClusteredMarkers.containsKey(key)) {
                            hashMap2.put(key, value3);
                            value3.setClusteredRoot(null);
                        }
                        value3.onClusterStateChanged();
                    }
                }
                this.mClusteredMarkers.clear();
                this.mClusteredMarkers.putAll(a2);
                if (hashMap.size() != 0 || hashMap2.size() != 0) {
                    if (!z || !this.mMapContainer.configController.isUseAnimationForClusteredMarkers()) {
                        z2 = false;
                    }
                    if (z2) {
                        a(hashMap, hashMap2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("add cluster ");
                        sb.append(hashMap.size());
                        sb.append(" markers and delete cluster ");
                        sb.append(hashMap2.size());
                        sb.append(" markers with animation");
                        RVLogger.d("MarkerClusterController", sb.toString());
                    }
                }
                this.mLastClusterRootCount = b();
                this.mLastClusterAllCount = H5MapUtils.sizeOf(this.mMapContainer.renderController.getMapData().markers);
                this.mLastClusterCost = System.currentTimeMillis() - currentTimeMillis;
            }
        }
    }

    private void a(Map<String, H5MapMarker> map, Map<String, H5MapMarker> map2) {
        Iterator<Map.Entry<String, H5MapMarker>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().doAnimationOnClusterStateChanged(0);
        }
        Iterator<Map.Entry<String, H5MapMarker>> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().doAnimationOnClusterStateChanged(1);
        }
    }

    private Map<String, H5MapMarker> a(AdapterAMap adapterAMap, AdapterProjection adapterProjection) {
        Context context;
        HashMap hashMap = new HashMap();
        MarkerCluster markerCluster = this.mMapContainer.renderController.getMarkerCluster();
        if (markerCluster == null || (context = this.mMapContainer.getContext()) == null) {
            return hashMap;
        }
        if (this.mMapContainer.configController.isGridDistanceCluster()) {
            a(context, adapterAMap, markerCluster, adapterProjection, hashMap);
            return hashMap;
        }
        b(context, adapterAMap, markerCluster, adapterProjection, hashMap);
        return hashMap;
    }

    private void a(Context context, AdapterAMap adapterAMap, MarkerCluster markerCluster, AdapterProjection adapterProjection, Map<String, H5MapMarker> map) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, H5MapMarker>> it = this.mMapContainer.markerController.h5MapMarkers.entrySet().iterator();
        while (it.hasNext()) {
            H5MapMarker value = it.next().getValue();
            if (!value.isVisible() || !value.canBeClustered()) {
                if (value.isClustered()) {
                    value.setClusteredRoot(null);
                }
            } else {
                arrayList.add(new Cell(value));
            }
        }
        Collections.sort(arrayList, new Comparator<Cell>() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerClusterController.1
            {
                MarkerClusterController.this = this;
            }

            @Override // java.util.Comparator
            public int compare(Cell cell, Cell cell2) {
                if ((cell.target instanceof H5MapMarker) && (cell2.target instanceof H5MapMarker)) {
                    H5MapMarker h5MapMarker = (H5MapMarker) cell.target;
                    H5MapMarker h5MapMarker2 = (H5MapMarker) cell2.target;
                    if (h5MapMarker.f7140id == null || h5MapMarker2.f7140id == null) {
                        return 0;
                    }
                    return h5MapMarker.f7140id.compareTo(h5MapMarker2.f7140id);
                }
                return 0;
            }
        });
        for (Cell cell : GridDistance.cluster(arrayList, (int) this.mMapContainer.metricsController.convertDp(markerCluster.clusterDistance))) {
            T t = cell.target;
            if (!(t instanceof H5MapMarker)) {
                if (cell.refer != null && (cell.refer.target instanceof H5MapMarker)) {
                    H5MapMarker h5MapMarker = (H5MapMarker) cell.refer.target;
                    AdapterLatLng fromScreenLocation = adapterProjection.fromScreenLocation(t.toPoint());
                    StringBuilder sb = new StringBuilder("cluster");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Cell<? extends CellTarget>> it2 = cell.children.iterator();
                    while (it2.hasNext()) {
                        Cell<? extends CellTarget> next = it2.next();
                        if (next.target instanceof H5MapMarker) {
                            H5MapMarker h5MapMarker2 = (H5MapMarker) next.target;
                            sb.append('#');
                            sb.append(h5MapMarker2.f7140id);
                            arrayList2.add(h5MapMarker2);
                        } else {
                            RVLogger.w(H5MapContainer.TAG, "cell child target is not marker");
                        }
                    }
                    a(context, adapterAMap, markerCluster, sb.toString(), fromScreenLocation, h5MapMarker, arrayList2, map);
                } else {
                    RVLogger.w(H5MapContainer.TAG, "cell refer is not marker");
                }
            }
        }
    }

    private void b(Context context, AdapterAMap adapterAMap, MarkerCluster markerCluster, AdapterProjection adapterProjection, Map<String, H5MapMarker> map) {
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        int width = mapView.getWidth();
        int height = mapView.getHeight();
        if (width == 0 || height == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("cluster markers error: ");
            sb.append(width);
            sb.append(",");
            sb.append(height);
            RVLogger.w(H5MapContainer.TAG, sb.toString());
        }
        int convertDp = (int) this.mMapContainer.metricsController.convertDp(markerCluster.clusterWidth);
        Rect a2 = a();
        int i = a2.left < 0 ? a2.left % convertDp : a2.left;
        int i2 = a2.top < 0 ? a2.top % convertDp : a2.top;
        while (i < width + convertDp && i < a2.right + convertDp) {
            int i3 = i2;
            while (i3 < height + convertDp && i3 < a2.bottom + convertDp) {
                int i4 = i3 + convertDp;
                a(map, context, markerCluster, adapterAMap, adapterProjection, i, i3, i + convertDp, i4);
                i3 = i4;
                i = i;
            }
            i += convertDp;
        }
    }

    private Rect a() {
        Iterator<Map.Entry<String, H5MapMarker>> it = this.mMapContainer.markerController.h5MapMarkers.entrySet().iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            H5MapMarker value = it.next().getValue();
            if (value.screenLocation != null) {
                if (i5 == 0 || i > value.screenLocation.x) {
                    i = value.screenLocation.x;
                }
                if (i5 == 0 || i2 > value.screenLocation.y) {
                    i2 = value.screenLocation.y;
                }
                if (i5 == 0 || i3 < value.screenLocation.x) {
                    i3 = value.screenLocation.x;
                }
                if (i5 == 0 || i4 < value.screenLocation.y) {
                    i4 = value.screenLocation.y;
                }
                i5++;
            }
        }
        return new Rect(i, i2, i3, i4);
    }

    private void a(Map<String, H5MapMarker> map, Context context, MarkerCluster markerCluster, AdapterAMap adapterAMap, AdapterProjection adapterProjection, int i, int i2, int i3, int i4) {
        Iterator<Map.Entry<String, H5MapMarker>> it;
        AdapterLatLng fromScreenLocation = adapterProjection.fromScreenLocation(new Point(((i3 - i) / 2) + i, ((i4 - i2) / 2) + i2));
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("cluster");
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        H5MapMarker h5MapMarker = null;
        double d = -1.0d;
        for (Iterator<Map.Entry<String, H5MapMarker>> it2 = this.mMapContainer.markerController.h5MapMarkers.entrySet().iterator(); it2.hasNext(); it2 = it) {
            Map.Entry<String, H5MapMarker> next = it2.next();
            String key = next.getKey();
            if (map.containsKey(key)) {
                it = it2;
            } else {
                it = it2;
                H5MapMarker value = next.getValue();
                if (value.screenLocation == null || !value.isVisible() || !value.canBeClustered()) {
                    if (value.isClustered()) {
                        value.setClusteredRoot(null);
                    }
                } else {
                    AdapterLatLng position = value.getPosition();
                    if (value.screenLocation.x >= i && value.screenLocation.y >= i2 && value.screenLocation.x < i3 && value.screenLocation.y < i4) {
                        arrayList.add(value);
                        sb.append("#");
                        sb.append(key);
                        double calculateLineDistance = AdapterAMapUtils.calculateLineDistance(position, fromScreenLocation);
                        if (d == -1.0d || calculateLineDistance < d) {
                            h5MapMarker = value;
                            d = calculateLineDistance;
                        }
                        if (i9 == 0 || i5 > value.screenLocation.x) {
                            i5 = value.screenLocation.x;
                        }
                        if (i9 == 0 || i8 > value.screenLocation.y) {
                            i8 = value.screenLocation.y;
                        }
                        if (i9 == 0 || i7 < value.screenLocation.x) {
                            i7 = value.screenLocation.x;
                        }
                        if (i9 == 0 || i6 < value.screenLocation.y) {
                            i6 = value.screenLocation.y;
                        }
                        i9++;
                    }
                }
            }
        }
        a(context, adapterAMap, markerCluster, sb.toString(), adapterProjection.fromScreenLocation(new Point(i5 + ((i7 - i5) / 2), i8 + ((i6 - i8) / 2))), h5MapMarker, arrayList, map);
    }

    private void a(Context context, AdapterAMap adapterAMap, MarkerCluster markerCluster, String str, AdapterLatLng adapterLatLng, H5MapMarker h5MapMarker, List<H5MapMarker> list, Map<String, H5MapMarker> map) {
        String obj;
        H5MapMarker h5MapMarker2 = this.mClusterRootMarkers.get(str);
        if (list.size() < 2) {
            if (h5MapMarker2 != null) {
                h5MapMarker2.markerContext.setVisible(false);
            }
        } else if (h5MapMarker == null) {
            RVLogger.e(H5MapContainer.TAG, "can not find nearby marker to center");
        } else {
            String str2 = markerCluster.desc;
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(markerCluster.replaceCount)) {
                StringBuilder sb = new StringBuilder();
                sb.append(list.size());
                obj = sb.toString();
            } else {
                String str3 = markerCluster.replaceCount;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(list.size());
                obj = str2.replace(str3, sb2.toString());
            }
            boolean z = h5MapMarker2 == null;
            Marker marker = z ? new Marker() : h5MapMarker2.marker;
            if (z) {
                marker.f7175id = str;
                marker.displayRanges = markerCluster.clusterRanges;
                marker.clusterEnabled = false;
            }
            marker.latitude = adapterLatLng.getLatitude();
            marker.longitude = adapterLatLng.getLongitude();
            marker.iconPath = h5MapMarker.marker.iconPath;
            marker.width = h5MapMarker.marker.width;
            marker.height = h5MapMarker.marker.height;
            marker.alpha = h5MapMarker.marker.alpha;
            marker.anchorX = h5MapMarker.marker.anchorX;
            marker.anchorY = h5MapMarker.marker.anchorY;
            if (h5MapMarker.marker.iconLayout != null) {
                if (marker.iconLayout == null) {
                    marker.iconLayout = new Layout();
                }
                marker.iconLayout.src = h5MapMarker.marker.iconLayout.src;
                marker.iconLayout.data = h5MapMarker.marker.iconLayout.data;
                if (marker.iconLayout.params == null) {
                    marker.iconLayout.params = new JSONObject();
                }
                if (h5MapMarker.marker.iconLayout.params != null && h5MapMarker.marker.iconLayout.params.size() != 0) {
                    marker.iconLayout.params.putAll(h5MapMarker.marker.iconLayout.params);
                }
                if (!TextUtils.isEmpty(markerCluster.referenceParam)) {
                    marker.iconLayout.params.put(markerCluster.referenceParam, (Object) obj);
                }
            } else if (h5MapMarker.marker.style != null) {
                marker.iconLayout = null;
                if (marker.style == null) {
                    marker.style = new JSONObject();
                    marker.style.putAll(h5MapMarker.marker.style);
                }
                marker.style.put("text", (Object) obj);
                marker.style.put("text1", (Object) obj);
            } else {
                marker.iconLayout = null;
                marker.style = null;
                marker.iconAppendStrColor = "#33B276";
                marker.iconAppendStr = obj;
            }
            if (z) {
                this.mMapContainer.markerController.setMarker(context, adapterAMap, marker);
                h5MapMarker2 = this.mMapContainer.markerController.h5MapMarkers.remove(str);
                this.mClusterRootMarkers.put(str, h5MapMarker2);
            } else {
                this.mMapContainer.markerController.updateMarker(h5MapMarker2);
            }
            AdapterLatLng position = h5MapMarker2.getPosition();
            AdapterLatLng adapterLatLng2 = new AdapterLatLng(position, position.getLatitude(), position.getLongitude());
            for (H5MapMarker h5MapMarker3 : list) {
                if (!TextUtils.isEmpty(h5MapMarker3.f7140id)) {
                    map.put(h5MapMarker3.f7140id, h5MapMarker3);
                }
                h5MapMarker3.clusterRootPosition = adapterLatLng2;
                h5MapMarker3.setClusteredRoot(h5MapMarker2);
                h5MapMarker3.onClusterStateChanged();
            }
        }
    }

    private int b() {
        int i = 0;
        for (Map.Entry<String, H5MapMarker> entry : this.mClusterRootMarkers.entrySet()) {
            H5MapMarker value = entry.getValue();
            if (value.checkClusterChildren()) {
                i++;
            } else {
                value.markerContext.remove();
                value.onRemove();
                this.mClusterRootMarkers.remove(entry.getKey());
            }
        }
        return i;
    }

    public void onPause() {
        if (this.mLastClusterCost > 0) {
            this.mMapContainer.reportController.reportClusterTime(this.mLastClusterCost, this.mLastClusterAllCount, this.mLastClusterRootCount);
        }
    }
}
