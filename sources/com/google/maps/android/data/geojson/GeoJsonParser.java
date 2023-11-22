package com.google.maps.android.data.geojson;

import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class GeoJsonParser {
    private static final String BOUNDING_BOX = "bbox";
    private static final String FEATURE = "Feature";
    private static final String FEATURE_COLLECTION = "FeatureCollection";
    private static final String FEATURE_COLLECTION_ARRAY = "features";
    private static final String FEATURE_GEOMETRY = "geometry";
    private static final String FEATURE_ID = "id";
    private static final String GEOMETRY_COLLECTION = "GeometryCollection";
    private static final String GEOMETRY_COLLECTION_ARRAY = "geometries";
    private static final String GEOMETRY_COORDINATES_ARRAY = "coordinates";
    private static final String LINESTRING = "LineString";
    private static final String LOG_TAG = "GeoJsonParser";
    private static final String MULTILINESTRING = "MultiLineString";
    private static final String MULTIPOINT = "MultiPoint";
    private static final String MULTIPOLYGON = "MultiPolygon";
    private static final String POINT = "Point";
    private static final String POLYGON = "Polygon";
    private static final String PROPERTIES = "properties";
    private final JSONObject mGeoJsonFile;
    private final ArrayList<GeoJsonFeature> mGeoJsonFeatures = new ArrayList<>();
    private LatLngBounds mBoundingBox = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class LatLngAlt {
        public final Double altitude;
        public final LatLng latLng;

        LatLngAlt(LatLng latLng, Double d) {
            this.latLng = latLng;
            this.altitude = d;
        }
    }

    public GeoJsonParser(JSONObject jSONObject) {
        this.mGeoJsonFile = jSONObject;
        parseGeoJson();
    }

    private static boolean isGeometry(String str) {
        return str.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection");
    }

    private static GeoJsonFeature parseFeature(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String string = jSONObject.has("id") ? jSONObject.getString("id") : null;
            LatLngBounds parseBoundingBox = jSONObject.has(BOUNDING_BOX) ? parseBoundingBox(jSONObject.getJSONArray(BOUNDING_BOX)) : null;
            Geometry parseGeometry = (!jSONObject.has(FEATURE_GEOMETRY) || jSONObject.isNull(FEATURE_GEOMETRY)) ? null : parseGeometry(jSONObject.getJSONObject(FEATURE_GEOMETRY));
            if (jSONObject.has("properties") && !jSONObject.isNull("properties")) {
                hashMap = parseProperties(jSONObject.getJSONObject("properties"));
            }
            return new GeoJsonFeature(parseGeometry, string, hashMap, parseBoundingBox);
        } catch (JSONException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Feature could not be successfully parsed ");
            sb.append(jSONObject.toString());
            InstrumentInjector.log_w(LOG_TAG, sb.toString());
            return null;
        }
    }

    private static LatLngBounds parseBoundingBox(JSONArray jSONArray) throws JSONException {
        return new LatLngBounds(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), new LatLng(jSONArray.getDouble(3), jSONArray.getDouble(2)));
    }

    public static Geometry parseGeometry(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String string = jSONObject.getString("type");
            if (string.equals(GEOMETRY_COLLECTION)) {
                jSONArray = jSONObject.getJSONArray(GEOMETRY_COLLECTION_ARRAY);
            } else if (!isGeometry(string)) {
                return null;
            } else {
                jSONArray = jSONObject.getJSONArray(GEOMETRY_COORDINATES_ARRAY);
            }
            return createGeometry(string, jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static GeoJsonFeature parseGeometryToFeature(JSONObject jSONObject) {
        Geometry parseGeometry = parseGeometry(jSONObject);
        if (parseGeometry != null) {
            return new GeoJsonFeature(parseGeometry, null, new HashMap(), null);
        }
        InstrumentInjector.log_w(LOG_TAG, "Geometry could not be parsed");
        return null;
    }

    private static HashMap<String, String> parseProperties(JSONObject jSONObject) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.getString(next));
        }
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Geometry createGeometry(String str, JSONArray jSONArray) throws JSONException {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -2116761119:
                if (str.equals(MULTIPOLYGON)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1065891849:
                if (str.equals(MULTIPOINT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -627102946:
                if (str.equals(MULTILINESTRING)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 77292912:
                if (str.equals(POINT)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1267133722:
                if (str.equals("Polygon")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1806700869:
                if (str.equals(LINESTRING)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1950410960:
                if (str.equals(GEOMETRY_COLLECTION)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return createMultiPolygon(jSONArray);
            case 1:
                return createMultiPoint(jSONArray);
            case 2:
                return createMultiLineString(jSONArray);
            case 3:
                return createPoint(jSONArray);
            case 4:
                return createPolygon(jSONArray);
            case 5:
                return createLineString(jSONArray);
            case 6:
                return createGeometryCollection(jSONArray);
            default:
                return null;
        }
    }

    private static GeoJsonPoint createPoint(JSONArray jSONArray) throws JSONException {
        LatLngAlt parseCoordinate = parseCoordinate(jSONArray);
        return new GeoJsonPoint(parseCoordinate.latLng, parseCoordinate.altitude);
    }

    private static GeoJsonMultiPoint createMultiPoint(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createPoint(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiPoint(arrayList);
    }

    private static GeoJsonLineString createLineString(JSONArray jSONArray) throws JSONException {
        ArrayList<LatLngAlt> parseCoordinatesArray = parseCoordinatesArray(jSONArray);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<LatLngAlt> it = parseCoordinatesArray.iterator();
        while (it.hasNext()) {
            LatLngAlt next = it.next();
            arrayList.add(next.latLng);
            if (next.altitude != null) {
                arrayList2.add(next.altitude);
            }
        }
        return new GeoJsonLineString(arrayList, arrayList2);
    }

    private static GeoJsonMultiLineString createMultiLineString(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createLineString(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiLineString(arrayList);
    }

    private static GeoJsonPolygon createPolygon(JSONArray jSONArray) throws JSONException {
        return new GeoJsonPolygon(parseCoordinatesArrays(jSONArray));
    }

    private static GeoJsonMultiPolygon createMultiPolygon(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(createPolygon(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiPolygon(arrayList);
    }

    private static GeoJsonGeometryCollection createGeometryCollection(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Geometry parseGeometry = parseGeometry(jSONArray.getJSONObject(i));
            if (parseGeometry != null) {
                arrayList.add(parseGeometry);
            }
        }
        return new GeoJsonGeometryCollection(arrayList);
    }

    private static LatLngAlt parseCoordinate(JSONArray jSONArray) throws JSONException {
        return new LatLngAlt(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), jSONArray.length() < 3 ? null : Double.valueOf(jSONArray.getDouble(2)));
    }

    private static ArrayList<LatLngAlt> parseCoordinatesArray(JSONArray jSONArray) throws JSONException {
        ArrayList<LatLngAlt> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(parseCoordinate(jSONArray.getJSONArray(i)));
        }
        return arrayList;
    }

    private static ArrayList<ArrayList<LatLng>> parseCoordinatesArrays(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            ArrayList<LatLngAlt> parseCoordinatesArray = parseCoordinatesArray(jSONArray.getJSONArray(i));
            ArrayList<LatLng> arrayList2 = new ArrayList<>();
            Iterator<LatLngAlt> it = parseCoordinatesArray.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().latLng);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private void parseGeoJson() {
        try {
            String string = this.mGeoJsonFile.getString("type");
            if (string.equals("Feature")) {
                GeoJsonFeature parseFeature = parseFeature(this.mGeoJsonFile);
                if (parseFeature != null) {
                    this.mGeoJsonFeatures.add(parseFeature);
                }
            } else if (string.equals(FEATURE_COLLECTION)) {
                this.mGeoJsonFeatures.addAll(parseFeatureCollection(this.mGeoJsonFile));
            } else if (isGeometry(string)) {
                GeoJsonFeature parseGeometryToFeature = parseGeometryToFeature(this.mGeoJsonFile);
                if (parseGeometryToFeature != null) {
                    this.mGeoJsonFeatures.add(parseGeometryToFeature);
                }
            } else {
                InstrumentInjector.log_w(LOG_TAG, "GeoJSON file could not be parsed.");
            }
        } catch (JSONException unused) {
            InstrumentInjector.log_w(LOG_TAG, "GeoJSON file could not be parsed.");
        }
    }

    private ArrayList<GeoJsonFeature> parseFeatureCollection(JSONObject jSONObject) {
        ArrayList<GeoJsonFeature> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(FEATURE_COLLECTION_ARRAY);
            if (jSONObject.has(BOUNDING_BOX)) {
                this.mBoundingBox = parseBoundingBox(jSONObject.getJSONArray(BOUNDING_BOX));
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.getString("type").equals("Feature")) {
                        GeoJsonFeature parseFeature = parseFeature(jSONObject2);
                        if (parseFeature != null) {
                            arrayList.add(parseFeature);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Index of Feature in Feature Collection that could not be created: ");
                            sb.append(i);
                            InstrumentInjector.log_w(LOG_TAG, sb.toString());
                        }
                    }
                } catch (JSONException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Index of Feature in Feature Collection that could not be created: ");
                    sb2.append(i);
                    InstrumentInjector.log_w(LOG_TAG, sb2.toString());
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            InstrumentInjector.log_w(LOG_TAG, "Feature Collection could not be created.");
            return arrayList;
        }
    }

    public ArrayList<GeoJsonFeature> getFeatures() {
        return this.mGeoJsonFeatures;
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }
}
