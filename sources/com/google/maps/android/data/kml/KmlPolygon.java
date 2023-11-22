package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.DataPolygon;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class KmlPolygon implements DataPolygon<ArrayList<ArrayList<LatLng>>> {
    public static final String GEOMETRY_TYPE = "Polygon";
    private final List<List<LatLng>> mInnerBoundaryCoordinates;
    private final List<LatLng> mOuterBoundaryCoordinates;

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public KmlPolygon(List<LatLng> list, List<List<LatLng>> list2) {
        if (list == null) {
            throw new IllegalArgumentException("Outer boundary coordinates cannot be null");
        }
        this.mOuterBoundaryCoordinates = list;
        this.mInnerBoundaryCoordinates = list2;
    }

    @Override // com.google.maps.android.data.Geometry
    public List<List<LatLng>> getGeometryObject() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mOuterBoundaryCoordinates);
        List<List<LatLng>> list = this.mInnerBoundaryCoordinates;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public List<LatLng> getOuterBoundaryCoordinates() {
        return this.mOuterBoundaryCoordinates;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public List<List<LatLng>> getInnerBoundaryCoordinates() {
        return this.mInnerBoundaryCoordinates;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE);
        sb.append("{");
        sb.append("\n outer coordinates=");
        sb.append(this.mOuterBoundaryCoordinates);
        sb.append(",\n inner coordinates=");
        sb.append(this.mInnerBoundaryCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }
}
