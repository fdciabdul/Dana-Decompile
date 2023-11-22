package com.google.maps.android.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alipay.mobile.zebra.data.ZebraData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.R;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlMultiGeometry;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;
import com.google.maps.android.data.kml.KmlStyle;
import com.google.maps.android.data.kml.KmlUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class Renderer {
    private static final Object FEATURE_NOT_ON_MAP = null;
    private static final int MARKER_ICON_SIZE = 32;
    private static final DecimalFormat sScaleFormat = new DecimalFormat("#.####");
    private final BiMultiMap<Feature> mContainerFeatures;
    private ArrayList<KmlContainer> mContainers;
    private Context mContext;
    private final GeoJsonLineStringStyle mDefaultLineStringStyle;
    private final GeoJsonPointStyle mDefaultPointStyle;
    private final GeoJsonPolygonStyle mDefaultPolygonStyle;
    private final BiMultiMap<Feature> mFeatures;
    private HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlayMap;
    private final GroundOverlayManager.Collection mGroundOverlays;
    private ImagesCache mImagesCache;
    private boolean mLayerOnMap;
    private GoogleMap mMap;
    private final Set<String> mMarkerIconUrls;
    private final MarkerManager.Collection mMarkers;
    private int mNumActiveDownloads;
    private final PolygonManager.Collection mPolygons;
    private final PolylineManager.Collection mPolylines;
    private HashMap<String, String> mStyleMaps;
    private HashMap<String, KmlStyle> mStyles;
    private HashMap<String, KmlStyle> mStylesRenderer;

    /* loaded from: classes7.dex */
    public static final class ImagesCache {
        final Map<String, Map<String, BitmapDescriptor>> markerImagesCache = new HashMap();
        final Map<String, BitmapDescriptor> groundOverlayImagesCache = new HashMap();
        final Map<String, Bitmap> bitmapCache = new HashMap();
    }

    public Renderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, ImagesCache imagesCache) {
        this(googleMap, new HashSet(), null, null, null, new BiMultiMap(), markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mContext = context;
        this.mStylesRenderer = new HashMap<>();
        this.mImagesCache = imagesCache == null ? new ImagesCache() : imagesCache;
    }

    public Renderer(GoogleMap googleMap, HashMap<? extends Feature, Object> hashMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this(googleMap, null, new GeoJsonPointStyle(), new GeoJsonLineStringStyle(), new GeoJsonPolygonStyle(), null, markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mFeatures.putAll(hashMap);
        this.mImagesCache = null;
    }

    private Renderer(GoogleMap googleMap, Set<String> set, GeoJsonPointStyle geoJsonPointStyle, GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonPolygonStyle geoJsonPolygonStyle, BiMultiMap<Feature> biMultiMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this.mFeatures = new BiMultiMap<>();
        this.mNumActiveDownloads = 0;
        this.mMap = googleMap;
        this.mLayerOnMap = false;
        this.mMarkerIconUrls = set;
        this.mDefaultPointStyle = geoJsonPointStyle;
        this.mDefaultLineStringStyle = geoJsonLineStringStyle;
        this.mDefaultPolygonStyle = geoJsonPolygonStyle;
        this.mContainerFeatures = biMultiMap;
        if (googleMap != null) {
            this.mMarkers = (markerManager == null ? new MarkerManager(googleMap) : markerManager).newCollection();
            this.mPolygons = (polygonManager == null ? new PolygonManager(googleMap) : polygonManager).newCollection();
            this.mPolylines = (polylineManager == null ? new PolylineManager(googleMap) : polylineManager).newCollection();
            this.mGroundOverlays = (groundOverlayManager == null ? new GroundOverlayManager(googleMap) : groundOverlayManager).newCollection();
            return;
        }
        this.mMarkers = null;
        this.mPolygons = null;
        this.mPolylines = null;
        this.mGroundOverlays = null;
    }

    public boolean isLayerOnMap() {
        return this.mLayerOnMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerVisibility(boolean z) {
        this.mLayerOnMap = z;
    }

    public GoogleMap getMap() {
        return this.mMap;
    }

    public void setMap(GoogleMap googleMap) {
        this.mMap = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putContainerFeature(Object obj, Feature feature) {
        this.mContainerFeatures.put((BiMultiMap<Feature>) feature, (Feature) obj);
    }

    public Set<Feature> getFeatures() {
        return this.mFeatures.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Feature getFeature(Object obj) {
        return this.mFeatures.getKey(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Feature getContainerFeature(Object obj) {
        BiMultiMap<Feature> biMultiMap = this.mContainerFeatures;
        if (biMultiMap != null) {
            return biMultiMap.getKey(obj);
        }
        return null;
    }

    public Collection<Object> getValues() {
        return this.mFeatures.values();
    }

    public HashMap<? extends Feature, Object> getAllFeatures() {
        return this.mFeatures;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<String> getMarkerIconUrls() {
        return this.mMarkerIconUrls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, KmlStyle> getStylesRenderer() {
        return this.mStylesRenderer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> getStyleMaps() {
        return this.mStyleMaps;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getCachedMarkerImage(String str, double d) {
        Bitmap bitmap;
        String format = sScaleFormat.format(d);
        Map<String, BitmapDescriptor> map = this.mImagesCache.markerImagesCache.get(str);
        BitmapDescriptor bitmapDescriptor = map != null ? map.get(format) : null;
        if (bitmapDescriptor != null || (bitmap = this.mImagesCache.bitmapCache.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor scaleIcon = scaleIcon(bitmap, d);
        putMarkerImagesCache(str, format, scaleIcon);
        return scaleIcon;
    }

    private BitmapDescriptor scaleIcon(Bitmap bitmap, double d) {
        int i;
        double d2 = this.mContext.getResources().getDisplayMetrics().density * 32.0f;
        Double.isNaN(d2);
        int i2 = (int) (d2 * d);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < height) {
            i = (int) ((height * i2) / width);
        } else if (width > height) {
            int i3 = (int) ((width * i2) / height);
            i = i2;
            i2 = i3;
        } else {
            i = i2;
        }
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, i2, i, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getCachedGroundOverlayImage(String str) {
        Bitmap bitmap;
        BitmapDescriptor bitmapDescriptor = this.mImagesCache.groundOverlayImagesCache.get(str);
        if (bitmapDescriptor != null || (bitmap = this.mImagesCache.bitmapCache.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
        this.mImagesCache.groundOverlayImagesCache.put(str, fromBitmap);
        return fromBitmap;
    }

    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayMap() {
        return this.mGroundOverlayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<KmlContainer> getContainerList() {
        return this.mContainers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KmlStyle getPlacemarkStyle(String str) {
        return this.mStylesRenderer.get(str) != null ? this.mStylesRenderer.get(str) : this.mStylesRenderer.get(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.mDefaultPointStyle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mDefaultLineStringStyle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mDefaultPolygonStyle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putFeatures(Feature feature, Object obj) {
        this.mFeatures.put((BiMultiMap<Feature>) feature, (Feature) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putStyles() {
        this.mStylesRenderer.putAll(this.mStyles);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putStyles(HashMap<String, KmlStyle> hashMap) {
        this.mStylesRenderer.putAll(hashMap);
    }

    private void putMarkerImagesCache(String str, String str2, BitmapDescriptor bitmapDescriptor) {
        Map<String, BitmapDescriptor> map = this.mImagesCache.markerImagesCache.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.mImagesCache.markerImagesCache.put(str, map);
        }
        map.put(str2, bitmapDescriptor);
    }

    public void cacheBitmap(String str, Bitmap bitmap) {
        this.mImagesCache.bitmapCache.put(str, bitmap);
    }

    public void downloadStarted() {
        this.mNumActiveDownloads++;
    }

    public void downloadFinished() {
        this.mNumActiveDownloads--;
        checkClearBitmapCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkClearBitmapCache() {
        ImagesCache imagesCache;
        if (this.mNumActiveDownloads != 0 || (imagesCache = this.mImagesCache) == null || imagesCache.bitmapCache.isEmpty()) {
            return;
        }
        this.mImagesCache.bitmapCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasFeatures() {
        return this.mFeatures.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeFeatures(HashMap<? extends Feature, Object> hashMap) {
        removeFeatures(hashMap.values());
    }

    private void removeFeatures(Collection collection) {
        for (Object obj : collection) {
            if (obj instanceof Collection) {
                removeFeatures((Collection) obj);
            } else if (obj instanceof Marker) {
                this.mMarkers.remove((Marker) obj);
            } else if (obj instanceof Polyline) {
                this.mPolylines.remove((Polyline) obj);
            } else if (obj instanceof Polygon) {
                this.mPolygons.remove((Polygon) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (GroundOverlay groundOverlay : hashMap.values()) {
            if (groundOverlay != null) {
                this.mGroundOverlays.remove(groundOverlay);
            }
        }
    }

    public void removeFeature(Feature feature) {
        if (this.mFeatures.containsKey(feature)) {
            removeFromMap(this.mFeatures.remove(feature));
        }
    }

    private void setFeatureDefaultStyles(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature.getPointStyle() == null) {
            geoJsonFeature.setPointStyle(this.mDefaultPointStyle);
        }
        if (geoJsonFeature.getLineStringStyle() == null) {
            geoJsonFeature.setLineStringStyle(this.mDefaultLineStringStyle);
        }
        if (geoJsonFeature.getPolygonStyle() == null) {
            geoJsonFeature.setPolygonStyle(this.mDefaultPolygonStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearStylesRenderer() {
        this.mStylesRenderer.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void storeData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        this.mStyles = hashMap;
        this.mStyleMaps = hashMap2;
        this.mFeatures.putAll(hashMap3);
        this.mContainers = arrayList;
        this.mGroundOverlayMap = hashMap4;
    }

    public void addFeature(Feature feature) {
        Object obj = FEATURE_NOT_ON_MAP;
        if (feature instanceof GeoJsonFeature) {
            setFeatureDefaultStyles((GeoJsonFeature) feature);
        }
        if (this.mLayerOnMap) {
            if (this.mFeatures.containsKey(feature)) {
                removeFromMap(this.mFeatures.get(feature));
            }
            if (feature.hasGeometry()) {
                if (feature instanceof KmlPlacemark) {
                    KmlPlacemark kmlPlacemark = (KmlPlacemark) feature;
                    obj = addKmlPlacemarkToMap(kmlPlacemark, feature.getGeometry(), getPlacemarkStyle(feature.getId()), kmlPlacemark.getInlineStyle(), getPlacemarkVisibility(feature));
                } else {
                    obj = addGeoJsonFeatureToMap(feature, feature.getGeometry());
                }
            }
        }
        this.mFeatures.put((BiMultiMap<Feature>) feature, (Feature) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeFromMap(Object obj) {
        if (obj instanceof Marker) {
            this.mMarkers.remove((Marker) obj);
        } else if (obj instanceof Polyline) {
            this.mPolylines.remove((Polyline) obj);
        } else if (obj instanceof Polygon) {
            this.mPolygons.remove((Polygon) obj);
        } else if (obj instanceof GroundOverlay) {
            this.mGroundOverlays.remove((GroundOverlay) obj);
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                removeFromMap(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object addGeoJsonFeatureToMap(Feature feature, Geometry geometry) {
        char c;
        String geometryType = geometry.getGeometryType();
        geometryType.hashCode();
        switch (geometryType.hashCode()) {
            case -2116761119:
                if (geometryType.equals("MultiPolygon")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1065891849:
                if (geometryType.equals("MultiPoint")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -627102946:
                if (geometryType.equals("MultiLineString")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 77292912:
                if (geometryType.equals("Point")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1267133722:
                if (geometryType.equals(KmlPolygon.GEOMETRY_TYPE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1806700869:
                if (geometryType.equals("LineString")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1950410960:
                if (geometryType.equals("GeometryCollection")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        MarkerOptions markerOptions = null;
        PolylineOptions polylineOptions = null;
        PolygonOptions polygonOptions = null;
        switch (c) {
            case 0:
                return addMultiPolygonToMap(((GeoJsonFeature) feature).getPolygonStyle(), (GeoJsonMultiPolygon) geometry);
            case 1:
                return addMultiPointToMap(((GeoJsonFeature) feature).getPointStyle(), (GeoJsonMultiPoint) geometry);
            case 2:
                return addMultiLineStringToMap(((GeoJsonFeature) feature).getLineStringStyle(), (GeoJsonMultiLineString) geometry);
            case 3:
                if (feature instanceof GeoJsonFeature) {
                    markerOptions = ((GeoJsonFeature) feature).getMarkerOptions();
                } else if (feature instanceof KmlPlacemark) {
                    markerOptions = ((KmlPlacemark) feature).getMarkerOptions();
                }
                return addPointToMap(markerOptions, (GeoJsonPoint) geometry);
            case 4:
                if (feature instanceof GeoJsonFeature) {
                    polygonOptions = ((GeoJsonFeature) feature).getPolygonOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polygonOptions = ((KmlPlacemark) feature).getPolygonOptions();
                }
                return addPolygonToMap(polygonOptions, (DataPolygon) geometry);
            case 5:
                if (feature instanceof GeoJsonFeature) {
                    polylineOptions = ((GeoJsonFeature) feature).getPolylineOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polylineOptions = ((KmlPlacemark) feature).getPolylineOptions();
                }
                return addLineStringToMap(polylineOptions, (GeoJsonLineString) geometry);
            case 6:
                return addGeometryCollectionToMap((GeoJsonFeature) feature, ((GeoJsonGeometryCollection) geometry).getGeometries());
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if (r0.equals("Point") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark r11, com.google.maps.android.data.Geometry r12, com.google.maps.android.data.kml.KmlStyle r13, com.google.maps.android.data.kml.KmlStyle r14, boolean r15) {
        /*
            r10 = this;
            java.lang.String r0 = r12.getGeometryType()
            java.lang.String r1 = "drawOrder"
            boolean r2 = r11.hasProperty(r1)
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L18
            java.lang.String r1 = r11.getProperty(r1)     // Catch: java.lang.NumberFormatException -> L17
            float r3 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L17
            goto L18
        L17:
            r2 = 0
        L18:
            r0.hashCode()
            int r1 = r0.hashCode()
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r1) {
                case 77292912: goto L44;
                case 89139371: goto L3a;
                case 1267133722: goto L30;
                case 1806700869: goto L26;
                default: goto L25;
            }
        L25:
            goto L4d
        L26:
            java.lang.String r1 = "LineString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4d
            r4 = 3
            goto L4e
        L30:
            java.lang.String r1 = "Polygon"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4d
            r4 = 2
            goto L4e
        L3a:
            java.lang.String r1 = "MultiGeometry"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4d
            r4 = 1
            goto L4e
        L44:
            java.lang.String r1 = "Point"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4d
            goto L4e
        L4d:
            r4 = -1
        L4e:
            if (r4 == 0) goto Lb9
            if (r4 == r7) goto Lac
            if (r4 == r6) goto L82
            if (r4 == r5) goto L58
            r11 = 0
            return r11
        L58:
            com.google.android.gms.maps.model.PolylineOptions r11 = r13.getPolylineOptions()
            if (r14 == 0) goto L62
            r10.setInlineLineStringStyle(r11, r14)
            goto L73
        L62:
            boolean r13 = r13.isLineRandomColorMode()
            if (r13 == 0) goto L73
            int r13 = r11.getColor()
            int r13 = com.google.maps.android.data.kml.KmlStyle.computeRandomColor(r13)
            r11.color(r13)
        L73:
            com.google.maps.android.data.LineString r12 = (com.google.maps.android.data.LineString) r12
            com.google.android.gms.maps.model.Polyline r11 = r10.addLineStringToMap(r11, r12)
            r11.setVisible(r15)
            if (r2 == 0) goto L81
            r11.setZIndex(r3)
        L81:
            return r11
        L82:
            com.google.android.gms.maps.model.PolygonOptions r11 = r13.getPolygonOptions()
            if (r14 == 0) goto L8c
            r10.setInlinePolygonStyle(r11, r14)
            goto L9d
        L8c:
            boolean r13 = r13.isPolyRandomColorMode()
            if (r13 == 0) goto L9d
            int r13 = r11.getFillColor()
            int r13 = com.google.maps.android.data.kml.KmlStyle.computeRandomColor(r13)
            r11.fillColor(r13)
        L9d:
            com.google.maps.android.data.DataPolygon r12 = (com.google.maps.android.data.DataPolygon) r12
            com.google.android.gms.maps.model.Polygon r11 = r10.addPolygonToMap(r11, r12)
            r11.setVisible(r15)
            if (r2 == 0) goto Lab
            r11.setZIndex(r3)
        Lab:
            return r11
        Lac:
            r6 = r12
            com.google.maps.android.data.kml.KmlMultiGeometry r6 = (com.google.maps.android.data.kml.KmlMultiGeometry) r6
            r4 = r10
            r5 = r11
            r7 = r13
            r8 = r14
            r9 = r15
            java.util.ArrayList r11 = r4.addMultiGeometryToMap(r5, r6, r7, r8, r9)
            return r11
        Lb9:
            com.google.android.gms.maps.model.MarkerOptions r0 = r13.getMarkerOptions()
            if (r14 == 0) goto Lc3
            r10.setInlinePointStyle(r0, r14, r13)
            goto Ld4
        Lc3:
            java.lang.String r14 = r13.getIconUrl()
            if (r14 == 0) goto Ld4
            java.lang.String r14 = r13.getIconUrl()
            double r4 = r13.getIconScale()
            r10.addMarkerIcons(r14, r4, r0)
        Ld4:
            com.google.maps.android.data.kml.KmlPoint r12 = (com.google.maps.android.data.kml.KmlPoint) r12
            com.google.android.gms.maps.model.Marker r12 = r10.addPointToMap(r0, r12)
            r12.setVisible(r15)
            r10.setMarkerInfoWindow(r13, r12, r11)
            if (r2 == 0) goto Le5
            r12.setZIndex(r3)
        Le5:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.Renderer.addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark, com.google.maps.android.data.Geometry, com.google.maps.android.data.kml.KmlStyle, com.google.maps.android.data.kml.KmlStyle, boolean):java.lang.Object");
    }

    private Marker addPointToMap(MarkerOptions markerOptions, Point point) {
        markerOptions.position(point.getGeometryObject());
        return this.mMarkers.addMarker(markerOptions);
    }

    private void setInlinePointStyle(MarkerOptions markerOptions, KmlStyle kmlStyle, KmlStyle kmlStyle2) {
        double iconScale;
        MarkerOptions markerOptions2 = kmlStyle.getMarkerOptions();
        if (kmlStyle.isStyleSet("heading")) {
            markerOptions.rotation(markerOptions2.getRotation());
        }
        if (kmlStyle.isStyleSet("hotSpot")) {
            markerOptions.anchor(markerOptions2.getAnchorU(), markerOptions2.getAnchorV());
        }
        if (kmlStyle.isStyleSet("markerColor")) {
            markerOptions.icon(markerOptions2.getIcon());
        }
        if (kmlStyle.isStyleSet("iconScale")) {
            iconScale = kmlStyle.getIconScale();
        } else {
            iconScale = kmlStyle2.isStyleSet("iconScale") ? kmlStyle2.getIconScale() : 1.0d;
        }
        if (kmlStyle.isStyleSet("iconUrl")) {
            addMarkerIcons(kmlStyle.getIconUrl(), iconScale, markerOptions);
        } else if (kmlStyle2.getIconUrl() != null) {
            addMarkerIcons(kmlStyle2.getIconUrl(), iconScale, markerOptions);
        }
    }

    private Polyline addLineStringToMap(PolylineOptions polylineOptions, LineString lineString) {
        polylineOptions.addAll(lineString.getGeometryObject());
        Polyline addPolyline = this.mPolylines.addPolyline(polylineOptions);
        addPolyline.setClickable(polylineOptions.isClickable());
        return addPolyline;
    }

    private void setInlineLineStringStyle(PolylineOptions polylineOptions, KmlStyle kmlStyle) {
        PolylineOptions polylineOptions2 = kmlStyle.getPolylineOptions();
        if (kmlStyle.isStyleSet("outlineColor")) {
            polylineOptions.color(polylineOptions2.getColor());
        }
        if (kmlStyle.isStyleSet(ZebraData.ATTR_WIDTH)) {
            polylineOptions.width(polylineOptions2.getWidth());
        }
        if (kmlStyle.isLineRandomColorMode()) {
            polylineOptions.color(KmlStyle.computeRandomColor(polylineOptions2.getColor()));
        }
    }

    private Polygon addPolygonToMap(PolygonOptions polygonOptions, DataPolygon dataPolygon) {
        polygonOptions.addAll(dataPolygon.getOuterBoundaryCoordinates());
        Iterator<List<LatLng>> it = dataPolygon.getInnerBoundaryCoordinates().iterator();
        while (it.hasNext()) {
            polygonOptions.addHole(it.next());
        }
        Polygon addPolygon = this.mPolygons.addPolygon(polygonOptions);
        addPolygon.setClickable(polygonOptions.isClickable());
        return addPolygon;
    }

    private void setInlinePolygonStyle(PolygonOptions polygonOptions, KmlStyle kmlStyle) {
        PolygonOptions polygonOptions2 = kmlStyle.getPolygonOptions();
        if (kmlStyle.hasFill() && kmlStyle.isStyleSet("fillColor")) {
            polygonOptions.fillColor(polygonOptions2.getFillColor());
        }
        if (kmlStyle.hasOutline()) {
            if (kmlStyle.isStyleSet("outlineColor")) {
                polygonOptions.strokeColor(polygonOptions2.getStrokeColor());
            }
            if (kmlStyle.isStyleSet(ZebraData.ATTR_WIDTH)) {
                polygonOptions.strokeWidth(polygonOptions2.getStrokeWidth());
            }
        }
        if (kmlStyle.isPolyRandomColorMode()) {
            polygonOptions.fillColor(KmlStyle.computeRandomColor(polygonOptions2.getFillColor()));
        }
    }

    private ArrayList<Object> addGeometryCollectionToMap(GeoJsonFeature geoJsonFeature, List<Geometry> list) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<Geometry> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(addGeoJsonFeatureToMap(geoJsonFeature, it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getPlacemarkVisibility(Feature feature) {
        return (feature.hasProperty("visibility") && Integer.parseInt(feature.getProperty("visibility")) == 0) ? false : true;
    }

    public void assignStyleMap(HashMap<String, String> hashMap, HashMap<String, KmlStyle> hashMap2) {
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (hashMap2.containsKey(str2)) {
                hashMap2.put(str, hashMap2.get(str2));
            }
        }
    }

    private ArrayList<Object> addMultiGeometryToMap(KmlPlacemark kmlPlacemark, KmlMultiGeometry kmlMultiGeometry, KmlStyle kmlStyle, KmlStyle kmlStyle2, boolean z) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<Geometry> it = kmlMultiGeometry.getGeometryObject().iterator();
        while (it.hasNext()) {
            arrayList.add(addKmlPlacemarkToMap(kmlPlacemark, it.next(), kmlStyle, kmlStyle2, z));
        }
        return arrayList;
    }

    private ArrayList<Marker> addMultiPointToMap(GeoJsonPointStyle geoJsonPointStyle, GeoJsonMultiPoint geoJsonMultiPoint) {
        ArrayList<Marker> arrayList = new ArrayList<>();
        Iterator<GeoJsonPoint> it = geoJsonMultiPoint.getPoints().iterator();
        while (it.hasNext()) {
            arrayList.add(addPointToMap(geoJsonPointStyle.toMarkerOptions(), it.next()));
        }
        return arrayList;
    }

    private ArrayList<Polyline> addMultiLineStringToMap(GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonMultiLineString geoJsonMultiLineString) {
        ArrayList<Polyline> arrayList = new ArrayList<>();
        Iterator<GeoJsonLineString> it = geoJsonMultiLineString.getLineStrings().iterator();
        while (it.hasNext()) {
            arrayList.add(addLineStringToMap(geoJsonLineStringStyle.toPolylineOptions(), it.next()));
        }
        return arrayList;
    }

    private ArrayList<Polygon> addMultiPolygonToMap(GeoJsonPolygonStyle geoJsonPolygonStyle, GeoJsonMultiPolygon geoJsonMultiPolygon) {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        Iterator<GeoJsonPolygon> it = geoJsonMultiPolygon.getPolygons().iterator();
        while (it.hasNext()) {
            arrayList.add(addPolygonToMap(geoJsonPolygonStyle.toPolygonOptions(), it.next()));
        }
        return arrayList;
    }

    private void addMarkerIcons(String str, double d, MarkerOptions markerOptions) {
        BitmapDescriptor cachedMarkerImage = getCachedMarkerImage(str, d);
        if (cachedMarkerImage != null) {
            markerOptions.icon(cachedMarkerImage);
        } else {
            this.mMarkerIconUrls.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GroundOverlay attachGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.mGroundOverlays.addGroundOverlay(groundOverlayOptions);
    }

    private void setMarkerInfoWindow(KmlStyle kmlStyle, Marker marker, KmlPlacemark kmlPlacemark) {
        boolean hasProperty = kmlPlacemark.hasProperty("name");
        boolean hasProperty2 = kmlPlacemark.hasProperty("description");
        boolean hasBalloonStyle = kmlStyle.hasBalloonStyle();
        boolean containsKey = kmlStyle.getBalloonOptions().containsKey("text");
        if (hasBalloonStyle && containsKey) {
            marker.setTitle(KmlUtil.substituteProperties(kmlStyle.getBalloonOptions().get("text"), kmlPlacemark));
            createInfoWindow();
        } else if (hasBalloonStyle && hasProperty) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            createInfoWindow();
        } else if (hasProperty && hasProperty2) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            marker.setSnippet(kmlPlacemark.getProperty("description"));
            createInfoWindow();
        } else if (hasProperty2) {
            marker.setTitle(kmlPlacemark.getProperty("description"));
            createInfoWindow();
        } else if (hasProperty) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            createInfoWindow();
        }
    }

    private void createInfoWindow() {
        this.mMarkers.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
            public View getInfoContents(Marker marker) {
                View inflate = LayoutInflater.from(Renderer.this.mContext).inflate(R.layout.amu_info_window, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.window);
                if (marker.getSnippet() != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(marker.getTitle());
                    sb.append("<br>");
                    sb.append(marker.getSnippet());
                    textView.setText(Html.fromHtml(sb.toString()));
                } else {
                    textView.setText(Html.fromHtml(marker.getTitle()));
                }
                return inflate;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnFeatureClickListener(final Layer.OnFeatureClickListener onFeatureClickListener) {
        this.mPolygons.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() { // from class: com.google.maps.android.data.Renderer$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public final void onPolygonClick(Polygon polygon) {
                Renderer.this.m220x2cc520ac(onFeatureClickListener, polygon);
            }
        });
        this.mMarkers.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.data.Renderer$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                return Renderer.this.m221xf5c617ed(onFeatureClickListener, marker);
            }
        });
        this.mPolylines.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() { // from class: com.google.maps.android.data.Renderer$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public final void onPolylineClick(Polyline polyline) {
                Renderer.this.m222xbec70f2e(onFeatureClickListener, polyline);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$0$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ void m220x2cc520ac(Layer.OnFeatureClickListener onFeatureClickListener, Polygon polygon) {
        if (getFeature(polygon) != null) {
            onFeatureClickListener.onFeatureClick(getFeature(polygon));
        } else if (getContainerFeature(polygon) != null) {
            onFeatureClickListener.onFeatureClick(getContainerFeature(polygon));
        } else {
            onFeatureClickListener.onFeatureClick(getFeature(multiObjectHandler(polygon)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$1$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ boolean m221xf5c617ed(Layer.OnFeatureClickListener onFeatureClickListener, Marker marker) {
        if (getFeature(marker) != null) {
            onFeatureClickListener.onFeatureClick(getFeature(marker));
            return false;
        } else if (getContainerFeature(marker) != null) {
            onFeatureClickListener.onFeatureClick(getContainerFeature(marker));
            return false;
        } else {
            onFeatureClickListener.onFeatureClick(getFeature(multiObjectHandler(marker)));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$2$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ void m222xbec70f2e(Layer.OnFeatureClickListener onFeatureClickListener, Polyline polyline) {
        if (getFeature(polyline) != null) {
            onFeatureClickListener.onFeatureClick(getFeature(polyline));
        } else if (getContainerFeature(polyline) != null) {
            onFeatureClickListener.onFeatureClick(getContainerFeature(polyline));
        } else {
            onFeatureClickListener.onFeatureClick(getFeature(multiObjectHandler(polyline)));
        }
    }

    private ArrayList<?> multiObjectHandler(Object obj) {
        for (Object obj2 : getValues()) {
            if (obj2.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<?> arrayList = (ArrayList) obj2;
                if (arrayList.contains(obj)) {
                    return arrayList;
                }
            }
        }
        return null;
    }
}
