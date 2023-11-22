package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class KmlGroundOverlay {
    private final GroundOverlayOptions mGroundOverlayOptions;
    private String mImageUrl;
    private LatLngBounds mLatLngBox;
    private final Map<String, String> mProperties;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KmlGroundOverlay(String str, LatLngBounds latLngBounds, float f, int i, HashMap<String, String> hashMap, float f2) {
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        this.mGroundOverlayOptions = groundOverlayOptions;
        this.mImageUrl = str;
        this.mProperties = hashMap;
        if (latLngBounds == null) {
            throw new IllegalArgumentException("No LatLonBox given");
        }
        this.mLatLngBox = latLngBounds;
        groundOverlayOptions.positionFromBounds(latLngBounds);
        groundOverlayOptions.bearing(f2);
        groundOverlayOptions.zIndex(f);
        groundOverlayOptions.visible(i != 0);
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public LatLngBounds getLatLngBox() {
        return this.mLatLngBox;
    }

    public Iterable<String> getProperties() {
        return this.mProperties.keySet();
    }

    public String getProperty(String str) {
        return this.mProperties.get(str);
    }

    public boolean hasProperty(String str) {
        return this.mProperties.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlayOptions getGroundOverlayOptions() {
        return this.mGroundOverlayOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroundOverlay");
        sb.append("{");
        sb.append("\n properties=");
        sb.append(this.mProperties);
        sb.append(",\n image url=");
        sb.append(this.mImageUrl);
        sb.append(",\n LatLngBox=");
        sb.append(this.mLatLngBox);
        sb.append("\n}\n");
        return sb.toString();
    }
}
