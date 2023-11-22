package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import com.google.maps.android.data.Renderer;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class KmlRenderer extends Renderer {
    private static final String LOG_TAG = "KmlRenderer";
    private ArrayList<KmlContainer> mContainers;
    private boolean mGroundOverlayImagesDownloaded;
    private final Set<String> mGroundOverlayUrls;
    private boolean mMarkerIconsDownloaded;

    public KmlRenderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) {
        super(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
        this.mGroundOverlayUrls = new HashSet();
        this.mMarkerIconsDownloaded = false;
        this.mGroundOverlayImagesDownloaded = false;
    }

    private void removePlacemarks(HashMap<? extends Feature, Object> hashMap) {
        removeFeatures(hashMap);
    }

    static boolean getContainerVisibility(KmlContainer kmlContainer, boolean z) {
        return z && (!kmlContainer.hasProperty("visibility") || Integer.parseInt(kmlContainer.getProperty("visibility")) != 0);
    }

    private void removeContainers(Iterable<KmlContainer> iterable) {
        for (KmlContainer kmlContainer : iterable) {
            removePlacemarks(kmlContainer.getPlacemarksHashMap());
            removeGroundOverlays(kmlContainer.getGroundOverlayHashMap());
            removeContainers(kmlContainer.getContainers());
        }
    }

    public void addLayerToMap() {
        setLayerVisibility(true);
        this.mContainers = getContainerList();
        putStyles();
        assignStyleMap(getStyleMaps(), getStylesRenderer());
        addGroundOverlays(getGroundOverlayMap(), this.mContainers);
        addContainerGroupToMap(this.mContainers, true);
        addPlacemarksToMap(getAllFeatures());
        if (!this.mGroundOverlayImagesDownloaded) {
            downloadGroundOverlays();
        }
        if (!this.mMarkerIconsDownloaded) {
            downloadMarkerIcons();
        }
        checkClearBitmapCache();
    }

    public void storeKmlData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        storeData(hashMap, hashMap2, hashMap3, arrayList, hashMap4);
    }

    public void storeKmzData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4, HashMap<String, Bitmap> hashMap5) {
        storeData(hashMap, hashMap2, hashMap3, arrayList, hashMap4);
        for (Map.Entry<String, Bitmap> entry : hashMap5.entrySet()) {
            cacheBitmap(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap googleMap) {
        removeLayerFromMap();
        super.setMap(googleMap);
        addLayerToMap();
    }

    boolean hasKmlPlacemarks() {
        return hasFeatures();
    }

    Iterable<? extends Feature> getKmlPlacemarks() {
        return getFeatures();
    }

    public boolean hasNestedContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlContainer> getNestedContainers() {
        return this.mContainers;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return getGroundOverlayMap().keySet();
    }

    public void removeLayerFromMap() {
        removePlacemarks(getAllFeatures());
        removeGroundOverlays(getGroundOverlayMap());
        if (hasNestedContainers()) {
            removeContainers(getNestedContainers());
        }
        setLayerVisibility(false);
        clearStylesRenderer();
    }

    private void addPlacemarksToMap(HashMap<? extends Feature, Object> hashMap) {
        Iterator<? extends Feature> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            addFeature(it.next());
        }
    }

    private void addContainerGroupToMap(Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer kmlContainer : iterable) {
            boolean containerVisibility = getContainerVisibility(kmlContainer, z);
            if (kmlContainer.getStyles() != null) {
                putStyles(kmlContainer.getStyles());
            }
            if (kmlContainer.getStyleMap() != null) {
                super.assignStyleMap(kmlContainer.getStyleMap(), getStylesRenderer());
            }
            addContainerObjectToMap(kmlContainer, containerVisibility);
            if (kmlContainer.hasContainers()) {
                addContainerGroupToMap(kmlContainer.getContainers(), containerVisibility);
            }
        }
    }

    private void addContainerObjectToMap(KmlContainer kmlContainer, boolean z) {
        for (KmlPlacemark kmlPlacemark : kmlContainer.getPlacemarks()) {
            boolean z2 = z && getPlacemarkVisibility(kmlPlacemark);
            if (kmlPlacemark.getGeometry() != null) {
                String id2 = kmlPlacemark.getId();
                Geometry geometry = kmlPlacemark.getGeometry();
                KmlStyle placemarkStyle = getPlacemarkStyle(id2);
                KmlPlacemark kmlPlacemark2 = kmlPlacemark;
                Object addKmlPlacemarkToMap = addKmlPlacemarkToMap(kmlPlacemark2, geometry, placemarkStyle, kmlPlacemark2.getInlineStyle(), z2);
                kmlContainer.setPlacemark(kmlPlacemark2, addKmlPlacemarkToMap);
                putContainerFeature(addKmlPlacemarkToMap, kmlPlacemark);
            }
        }
    }

    private void downloadMarkerIcons() {
        this.mMarkerIconsDownloaded = true;
        Iterator<String> it = getMarkerIconUrls().iterator();
        while (it.hasNext()) {
            new MarkerIconImageDownload(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    public void addIconToMarkers(String str, HashMap<KmlPlacemark, Object> hashMap) {
        for (KmlPlacemark kmlPlacemark : hashMap.keySet()) {
            addIconToGeometry(str, getStylesRenderer().get(kmlPlacemark.getId()), kmlPlacemark.getInlineStyle(), kmlPlacemark.getGeometry(), hashMap.get(kmlPlacemark));
        }
    }

    private void addIconToGeometry(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Geometry geometry, Object obj) {
        if (geometry == null) {
            return;
        }
        if ("Point".equals(geometry.getGeometryType())) {
            addIconToMarker(str, kmlStyle, kmlStyle2, (Marker) obj);
        } else if ("MultiGeometry".equals(geometry.getGeometryType())) {
            addIconToMultiGeometry(str, kmlStyle, kmlStyle2, (MultiGeometry) geometry, (List) obj);
        }
    }

    private void addIconToMultiGeometry(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, MultiGeometry multiGeometry, List<Object> list) {
        Iterator<Geometry> it = multiGeometry.getGeometryObject().iterator();
        Iterator<Object> it2 = list.iterator();
        while (it.hasNext() && it2.hasNext()) {
            addIconToGeometry(str, kmlStyle, kmlStyle2, it.next(), it2.next());
        }
    }

    private void addIconToMarker(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Marker marker) {
        boolean z = false;
        boolean z2 = kmlStyle2 != null && str.equals(kmlStyle2.getIconUrl());
        if (kmlStyle != null && str.equals(kmlStyle.getIconUrl())) {
            z = true;
        }
        if (z2) {
            scaleBitmap(kmlStyle2, marker);
        } else if (z) {
            scaleBitmap(kmlStyle, marker);
        }
    }

    private void scaleBitmap(KmlStyle kmlStyle, Marker marker) {
        marker.setIcon(getCachedMarkerImage(kmlStyle.getIconUrl(), kmlStyle.getIconScale()));
    }

    public void addContainerGroupIconsToMarkers(String str, Iterable<KmlContainer> iterable) {
        for (KmlContainer kmlContainer : iterable) {
            addIconToMarkers(str, kmlContainer.getPlacemarksHashMap());
            if (kmlContainer.hasContainers()) {
                addContainerGroupIconsToMarkers(str, kmlContainer.getContainers());
            }
        }
    }

    private void addGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap, Iterable<KmlContainer> iterable) {
        addGroundOverlays(hashMap);
        for (KmlContainer kmlContainer : iterable) {
            addGroundOverlays(kmlContainer.getGroundOverlayHashMap(), kmlContainer.getContainers());
        }
    }

    private void addGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (KmlGroundOverlay kmlGroundOverlay : hashMap.keySet()) {
            String imageUrl = kmlGroundOverlay.getImageUrl();
            if (imageUrl != null && kmlGroundOverlay.getLatLngBox() != null) {
                if (getCachedGroundOverlayImage(imageUrl) != null) {
                    addGroundOverlayToMap(imageUrl, hashMap, true);
                } else {
                    this.mGroundOverlayUrls.add(imageUrl);
                }
            }
        }
    }

    private void downloadGroundOverlays() {
        this.mGroundOverlayImagesDownloaded = true;
        Iterator<String> it = this.mGroundOverlayUrls.iterator();
        while (it.hasNext()) {
            new GroundOverlayImageDownload(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    public void addGroundOverlayToMap(String str, HashMap<KmlGroundOverlay, GroundOverlay> hashMap, boolean z) {
        BitmapDescriptor cachedGroundOverlayImage = getCachedGroundOverlayImage(str);
        for (KmlGroundOverlay kmlGroundOverlay : hashMap.keySet()) {
            if (kmlGroundOverlay.getImageUrl().equals(str)) {
                GroundOverlay attachGroundOverlay = attachGroundOverlay(kmlGroundOverlay.getGroundOverlayOptions().image(cachedGroundOverlayImage));
                if (!z) {
                    attachGroundOverlay.setVisible(false);
                }
                hashMap.put(kmlGroundOverlay, attachGroundOverlay);
            }
        }
    }

    public void addGroundOverlayInContainerGroups(String str, Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer kmlContainer : iterable) {
            boolean containerVisibility = getContainerVisibility(kmlContainer, z);
            addGroundOverlayToMap(str, kmlContainer.getGroundOverlayHashMap(), containerVisibility);
            if (kmlContainer.hasContainers()) {
                addGroundOverlayInContainerGroups(str, kmlContainer.getContainers(), containerVisibility);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class MarkerIconImageDownload extends AsyncTask<String, Void, Bitmap> {
        private final String mIconUrl;

        public MarkerIconImageDownload(String str) {
            KmlRenderer.this = r1;
            this.mIconUrl = str;
            r1.downloadStarted();
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mIconUrl);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.mIconUrl);
            } catch (IOException unused2) {
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                KmlRenderer.this.cacheBitmap(this.mIconUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addIconToMarkers(this.mIconUrl, kmlRenderer.getAllFeatures());
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addContainerGroupIconsToMarkers(this.mIconUrl, kmlRenderer2.mContainers);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Image at this URL could not be found ");
                sb.append(this.mIconUrl);
                InstrumentInjector.log_e(KmlRenderer.LOG_TAG, sb.toString());
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    /* loaded from: classes7.dex */
    public class GroundOverlayImageDownload extends AsyncTask<String, Void, Bitmap> {
        private final String mGroundOverlayUrl;

        public GroundOverlayImageDownload(String str) {
            KmlRenderer.this = r1;
            this.mGroundOverlayUrl = str;
            r1.downloadStarted();
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... strArr) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mGroundOverlayUrl);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.mGroundOverlayUrl);
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Image [");
                sb.append(this.mGroundOverlayUrl);
                sb.append("] download issue");
                InstrumentInjector.log_e(KmlRenderer.LOG_TAG, sb.toString(), e);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                KmlRenderer.this.cacheBitmap(this.mGroundOverlayUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addGroundOverlayToMap(this.mGroundOverlayUrl, kmlRenderer.getGroundOverlayMap(), true);
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addGroundOverlayInContainerGroups(this.mGroundOverlayUrl, kmlRenderer2.mContainers, true);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Image at this URL could not be found ");
                sb.append(this.mGroundOverlayUrl);
                InstrumentInjector.log_e(KmlRenderer.LOG_TAG, sb.toString());
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    public Bitmap getBitmapFromUrl(String str) throws IOException {
        return BitmapFactory.decodeStream(openConnectionCheckRedirects((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection()))));
    }

    private InputStream openConnectionCheckRedirects(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        boolean z;
        HttpURLConnection httpURLConnection;
        int responseCode;
        int i = 0;
        do {
            boolean z2 = uRLConnection instanceof HttpURLConnection;
            if (z2) {
                ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
            }
            inputStream = uRLConnection.getInputStream();
            if (!z2 || (responseCode = (httpURLConnection = (HttpURLConnection) uRLConnection).getResponseCode()) < 300 || responseCode > 307 || responseCode == 306 || responseCode == 304) {
                z = false;
            } else {
                URL url = httpURLConnection.getURL();
                String headerField = httpURLConnection.getHeaderField("Location");
                URL url2 = headerField != null ? new URL(url, headerField) : null;
                httpURLConnection.disconnect();
                if (url2 == null || ((!url2.getProtocol().equals(SemanticAttributes.FaasTriggerValues.HTTP) && !url2.getProtocol().equals("https")) || i >= 5)) {
                    throw new SecurityException("illegal URL redirect");
                }
                uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(url2.openConnection()));
                i++;
                z = true;
            }
        } while (z);
        return inputStream;
    }
}
