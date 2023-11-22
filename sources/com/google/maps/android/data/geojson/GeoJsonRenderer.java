package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Renderer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes7.dex */
public class GeoJsonRenderer extends Renderer implements Observer {
    private static final Object FEATURE_NOT_ON_MAP = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonRenderer(GoogleMap googleMap, HashMap<GeoJsonFeature, Object> hashMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        super(googleMap, hashMap, markerManager, polygonManager, polylineManager, groundOverlayManager);
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap googleMap) {
        super.setMap(googleMap);
        Iterator<Feature> it = super.getFeatures().iterator();
        while (it.hasNext()) {
            redrawFeatureToMap((GeoJsonFeature) it.next(), googleMap);
        }
    }

    public void addLayerToMap() {
        if (isLayerOnMap()) {
            return;
        }
        setLayerVisibility(true);
        Iterator<Feature> it = super.getFeatures().iterator();
        while (it.hasNext()) {
            addFeature((GeoJsonFeature) it.next());
        }
    }

    public void addFeature(GeoJsonFeature geoJsonFeature) {
        super.addFeature((Feature) geoJsonFeature);
        if (isLayerOnMap()) {
            geoJsonFeature.addObserver(this);
        }
    }

    public void removeLayerFromMap() {
        if (isLayerOnMap()) {
            for (Feature feature : super.getFeatures()) {
                removeFromMap(super.getAllFeatures().get(feature));
                feature.deleteObserver(this);
            }
            setLayerVisibility(false);
        }
    }

    public void removeFeature(GeoJsonFeature geoJsonFeature) {
        super.removeFeature((Feature) geoJsonFeature);
        if (super.getFeatures().contains(geoJsonFeature)) {
            geoJsonFeature.deleteObserver(this);
        }
    }

    private void redrawFeatureToMap(GeoJsonFeature geoJsonFeature) {
        redrawFeatureToMap(geoJsonFeature, getMap());
    }

    private void redrawFeatureToMap(GeoJsonFeature geoJsonFeature, GoogleMap googleMap) {
        removeFromMap(getAllFeatures().get(geoJsonFeature));
        putFeatures(geoJsonFeature, FEATURE_NOT_ON_MAP);
        if (googleMap == null || !geoJsonFeature.hasGeometry()) {
            return;
        }
        putFeatures(geoJsonFeature, addGeoJsonFeatureToMap(geoJsonFeature, geoJsonFeature.getGeometry()));
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable instanceof GeoJsonFeature) {
            GeoJsonFeature geoJsonFeature = (GeoJsonFeature) observable;
            Object obj2 = getAllFeatures().get(geoJsonFeature);
            Object obj3 = FEATURE_NOT_ON_MAP;
            boolean z = obj2 != obj3;
            if (z && geoJsonFeature.hasGeometry()) {
                redrawFeatureToMap(geoJsonFeature);
            } else if (z && !geoJsonFeature.hasGeometry()) {
                removeFromMap(getAllFeatures().get(geoJsonFeature));
                putFeatures(geoJsonFeature, obj3);
            } else if (z || !geoJsonFeature.hasGeometry()) {
            } else {
                addFeature(geoJsonFeature);
            }
        }
    }
}
