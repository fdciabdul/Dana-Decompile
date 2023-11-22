package com.google.maps.android.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class MultiGeometry implements Geometry {
    private String geometryType = "MultiGeometry";
    private List<Geometry> mGeometries;

    public MultiGeometry(List<? extends Geometry> list) {
        if (list == null) {
            throw new IllegalArgumentException("Geometries cannot be null");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Geometry> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.mGeometries = arrayList;
    }

    @Override // com.google.maps.android.data.Geometry
    public String getGeometryType() {
        return this.geometryType;
    }

    @Override // com.google.maps.android.data.Geometry
    public List<Geometry> getGeometryObject() {
        return this.mGeometries;
    }

    public void setGeometryType(String str) {
        this.geometryType = str;
    }

    public String toString() {
        String str = this.geometryType.equals("MultiPoint") ? "LineStrings=" : "Geometries=";
        if (this.geometryType.equals("MultiLineString")) {
            str = "points=";
        }
        if (this.geometryType.equals("MultiPolygon")) {
            str = "Polygons=";
        }
        StringBuilder sb = new StringBuilder(getGeometryType());
        sb.append("{");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n ");
        sb2.append(str);
        sb.append(sb2.toString());
        sb.append(getGeometryObject());
        sb.append("\n}\n");
        return sb.toString();
    }
}
