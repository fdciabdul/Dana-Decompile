package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes7.dex */
public class Point implements Geometry {
    private static final String GEOMETRY_TYPE = "Point";
    private final LatLng mCoordinates;

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public Point(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.mCoordinates = latLng;
    }

    @Override // com.google.maps.android.data.Geometry
    public LatLng getGeometryObject() {
        return this.mCoordinates;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE);
        sb.append("{");
        sb.append("\n coordinates=");
        sb.append(this.mCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }
}
