package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.map.GoogleMapKeyUtils;
import com.alibaba.griver.map.R;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.apmap.model.AdapterPolyline;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.core.controller.GoogleMapRouteSearch;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.data.Polyline;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.RouteResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class RouteSearchHelper extends H5MapController {

    /* renamed from: a */
    private AdapterAMap f7168a;
    private AdapterMarker b;
    private AdapterMarker c;
    private AdapterMarker d;
    private AdapterMarker e;
    private LatLonPoint f;
    private LatLonPoint g;
    private JSONObject h;
    private Context i;
    private H5JsCallback j;
    private final List<AdapterPolyline> k;
    private final List<Polyline> l;
    private final List<LatLonPoint> m;
    private final Map<LatLonPoint, Pair<String, String>> n;

    /* renamed from: o */
    private final List<AdapterMarker> f7169o;
    private final List<AdapterMarker> p;

    private String e() {
        return "#537edc";
    }

    public RouteSearchHelper(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.k = new ArrayList(1);
        this.l = new ArrayList(1);
        this.m = new ArrayList(1);
        this.n = new HashMap(1);
        this.f7169o = new ArrayList();
        this.p = new ArrayList();
    }

    public void setEnv(Context context, AdapterAMap adapterAMap, JSONObject jSONObject, H5JsCallback h5JsCallback) {
        if (adapterAMap != null) {
            this.f7168a = adapterAMap;
        }
        if (jSONObject != null) {
            this.h = jSONObject;
            this.f = a(jSONObject);
            this.g = b(jSONObject);
        }
        if (context != null) {
            this.i = context;
        }
        if (h5JsCallback != null) {
            this.j = h5JsCallback;
        }
    }

    public void clearRoute() {
        Iterator<AdapterPolyline> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        this.k.clear();
        this.m.clear();
        this.n.clear();
        this.l.clear();
        AdapterMarker adapterMarker = this.b;
        if (adapterMarker != null) {
            adapterMarker.remove();
            this.b = null;
        }
        AdapterMarker adapterMarker2 = this.c;
        if (adapterMarker2 != null) {
            adapterMarker2.remove();
            this.c = null;
        }
        AdapterMarker adapterMarker3 = this.d;
        if (adapterMarker3 != null) {
            adapterMarker3.remove();
            this.d = null;
        }
        AdapterMarker adapterMarker4 = this.e;
        if (adapterMarker4 != null) {
            adapterMarker4.remove();
            this.e = null;
        }
        Iterator<AdapterMarker> it2 = this.f7169o.iterator();
        while (it2.hasNext()) {
            it2.next().remove();
        }
        this.f7169o.clear();
        Iterator<AdapterMarker> it3 = this.p.iterator();
        while (it3.hasNext()) {
            it3.next().remove();
        }
        this.p.clear();
    }

    public void restoreRoute() {
        if (!this.l.isEmpty()) {
            this.k.clear();
            this.k.addAll(this.mMapContainer.polylineController.toAdapterPolylines(this.mMapContainer.polylineController.addPolyline(this.f7168a, this.l, true)));
        }
        c();
        d();
    }

    public void showRoute(String str) {
        if (!AdapterUtil.isGoogleMapSdk()) {
            GriverLogger.e("RouteSearchHelper", "showRoute# google map sdk not available.");
            this.j.sendBridgeResult(BridgeResponse.UNKNOWN_ERROR.get());
            return;
        }
        JSONObject jSONObject = this.h;
        if (jSONObject == null) {
            this.j.sendBridgeResult(BridgeResponse.INVALID_PARAM.get());
        } else if (this.f == null || this.g == null) {
            this.j.sendBridgeResult(BridgeResponse.INVALID_PARAM.get());
        } else {
            final String googleMapApiKey = GoogleMapKeyUtils.getGoogleMapApiKey(str, H5MapUtils.getStringValue(jSONObject, GoogleMapKeyUtils.G_API_KEY, ""));
            if (TextUtils.isEmpty(googleMapApiKey)) {
                GriverLogger.e("RouteSearchHelper", "please set google maps key first!");
                this.j.sendBridgeResult(BridgeResponse.INVALID_PARAM.get());
                return;
            }
            final String string = this.h.getString("searchType");
            if (TextUtils.isEmpty(string)) {
                string = "walk";
            }
            final GoogleMapRouteSearch googleMapRouteSearch = new GoogleMapRouteSearch(new GoogleMapRouteSearch.OnRouteSearchListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchHelper.1
                {
                    RouteSearchHelper.this = this;
                }

                @Override // com.alipay.mobile.embedview.mapbiz.core.controller.GoogleMapRouteSearch.OnRouteSearchListener
                public void onRouteSearchFinish(final RouteResult routeResult) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchHelper.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            RouteSearchHelper.this.a(routeResult);
                        }
                    });
                }
            });
            GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchHelper.2
                {
                    RouteSearchHelper.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    GoogleMapRouteSearch googleMapRouteSearch2 = googleMapRouteSearch;
                    String str2 = string;
                    LatLonPoint latLonPoint = RouteSearchHelper.this.f;
                    LatLonPoint latLonPoint2 = RouteSearchHelper.this.g;
                    RouteSearchHelper routeSearchHelper = RouteSearchHelper.this;
                    googleMapRouteSearch2.calculateRouteAsync(str2, latLonPoint, latLonPoint2, routeSearchHelper.c(routeSearchHelper.h), googleMapApiKey);
                }
            });
        }
    }

    private LatLonPoint a(JSONObject jSONObject) {
        return new LatLonPoint(H5MapUtils.getDoubleValue(jSONObject, "startLat"), H5MapUtils.getDoubleValue(jSONObject, "startLng"));
    }

    private LatLonPoint b(JSONObject jSONObject) {
        return new LatLonPoint(H5MapUtils.getDoubleValue(jSONObject, "endLat"), H5MapUtils.getDoubleValue(jSONObject, "endLng"));
    }

    public List<LatLonPoint> c(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("throughPoints");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.size() > 0) {
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new LatLonPoint(H5MapUtils.getDoubleValue(jSONObject2, "lat"), H5MapUtils.getDoubleValue(jSONObject2, "lng")));
            }
        }
        return arrayList;
    }

    private Point a(LatLonPoint latLonPoint) {
        return new Point(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    private void a(List<Point> list, List<LatLonPoint> list2) {
        if (list2 != null) {
            Iterator<LatLonPoint> it = list2.iterator();
            while (it.hasNext()) {
                list.add(a(it.next()));
            }
        }
    }

    private Polyline a() {
        Polyline polyline = new Polyline();
        polyline.color = this.h.getString("routeColor");
        polyline.color = TextUtils.isEmpty(polyline.color) ? e() : polyline.color;
        polyline.zIndex = this.h.containsKey("zIndex") ? H5MapUtils.getIntValue(this.h, "zIndex") : -1;
        polyline.width = H5MapUtils.getFloatValue(this.h, "routeWidth", 8.0f);
        polyline.iconWidth = H5MapUtils.getFloatValue(this.h, "iconWidth", 8.0f);
        polyline.iconPath = this.h.getString("iconPath");
        polyline.points = new ArrayList();
        polyline.colorList = new ArrayList();
        return polyline;
    }

    private void b() {
        AdapterAMap adapterAMap;
        if (this.f == null || this.g == null || (adapterAMap = this.f7168a) == null) {
            return;
        }
        try {
            AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(adapterAMap);
            adapterLatLngBounds.include(new AdapterLatLng(this.f7168a, this.f.getLatitude(), this.f.getLongitude()));
            adapterLatLngBounds.include(new AdapterLatLng(this.f7168a, this.g.getLatitude(), this.g.getLongitude()));
            Iterator<AdapterPolyline> it = this.k.iterator();
            while (it.hasNext()) {
                Iterator<AdapterLatLng> it2 = it.next().getPoints().iterator();
                while (it2.hasNext()) {
                    adapterLatLngBounds.include(it2.next());
                }
            }
            this.f7168a.animateCamera(AdapterCameraUpdateFactory.newLatLngBoundsRect(adapterLatLngBounds.build(), 50, 50, 150, 50));
        } catch (Throwable th) {
            GriverLogger.e("RouteSearchHelper", "zoomToSpan#process error", th);
        }
    }

    private void c() {
        if (this.f == null || this.g == null) {
            GriverLogger.d("RouteSearchHelper", "addStartAndEndMarker start point or end point is null");
            return;
        }
        AdapterAMap adapterAMap = this.f7168a;
        this.b = adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f7168a, this.f.getLatitude(), this.f.getLongitude())).icon(AdapterBitmapDescriptorFactory.fromResource(this.f7168a, R.drawable.griver_map_route_start)));
        AdapterAMap adapterAMap2 = this.f7168a;
        this.c = adapterAMap2.addMarker(new AdapterMarkerOptions(adapterAMap2).position(new AdapterLatLng(this.f7168a, this.g.getLatitude(), this.g.getLongitude())).icon(AdapterBitmapDescriptorFactory.fromResource(this.f7168a, R.drawable.griver_map_route_end)));
    }

    private void d() {
        List<LatLonPoint> list = this.m;
        if (list.size() > 0) {
            this.p.clear();
            for (int i = 0; i < list.size(); i++) {
                LatLonPoint latLonPoint = list.get(i);
                if (latLonPoint != null) {
                    boolean containsKey = this.n.containsKey(latLonPoint);
                    String str = containsKey ? (String) this.n.get(latLonPoint).first : "Transfer Location";
                    String str2 = containsKey ? (String) this.n.get(latLonPoint).second : "";
                    List<AdapterMarker> list2 = this.p;
                    AdapterAMap adapterAMap = this.f7168a;
                    list2.add(adapterAMap.addMarker(new AdapterMarkerOptions(adapterAMap).position(new AdapterLatLng(this.f7168a, latLonPoint.getLatitude(), latLonPoint.getLongitude())).icon(AdapterBitmapDescriptorFactory.fromResource(this.f7168a, R.drawable.griver_map_amap_switch)).title(str).snippet(str2)));
                }
            }
        }
    }

    private void a(boolean z, float f, float f2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            jSONObject.put("success", (Object) Boolean.TRUE);
            jSONObject.put("distance", (Object) Float.valueOf(f));
            jSONObject.put("duration", (Object) Float.valueOf(f2));
            StringBuilder sb = new StringBuilder();
            sb.append("success, distance = ");
            sb.append(f);
            sb.append(" duration");
            sb.append(f2);
            GriverLogger.d("RouteSearchHelper", sb.toString());
        } else {
            jSONObject.put("success", (Object) Boolean.FALSE);
            jSONObject.put("status", (Object) str);
            jSONObject.put("errorMessage", (Object) str2);
            jSONObject.put("errorCode", (Object) Float.valueOf(1900.0f));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("failed, status = ");
            sb2.append(str2);
            sb2.append(" errorMessage");
            sb2.append(str2);
            GriverLogger.d("RouteSearchHelper", sb2.toString());
        }
        H5JsCallback h5JsCallback = this.j;
        if (h5JsCallback != null) {
            h5JsCallback.sendBridgeResult(jSONObject);
        }
    }

    public void a(RouteResult routeResult) {
        String str;
        float f;
        boolean z;
        float f2;
        String str2;
        float f3;
        String str3;
        float f4;
        float f5;
        StringBuilder sb = new StringBuilder();
        sb.append("driveRouteSearched result = ");
        sb.append(routeResult);
        GriverLogger.d("RouteSearchHelper", sb.toString());
        boolean z2 = false;
        String str4 = null;
        float f6 = 0.0f;
        if (routeResult != null) {
            try {
                str = routeResult.getStatus();
            } catch (Throwable th) {
                th = th;
                str = null;
            }
            try {
                str4 = routeResult.getErrorMessage();
            } catch (Throwable th2) {
                th = th2;
                f = 0.0f;
                GriverLogger.e("RouteSearchHelper", "routeSearched#process error", th);
                z = z2;
                f2 = f;
                str2 = str4;
                f3 = f6;
                a(z, f2, f3, str, str2);
            }
            if (routeResult.getPaths() != null && routeResult.getPaths().size() > 0 && routeResult.getPaths().get(0) != null) {
                RouteResult.Path path = routeResult.getPaths().get(0);
                try {
                    f4 = (float) path.getDistance();
                } catch (Throwable th3) {
                    th = th3;
                    f4 = 0.0f;
                }
                try {
                    f6 = (float) path.getDuration();
                    ArrayList arrayList = new ArrayList(1);
                    Polyline a2 = a();
                    arrayList.add(a2);
                    ArrayList arrayList2 = new ArrayList();
                    List<RouteResult.Step> steps = path.getSteps();
                    ArrayList arrayList3 = new ArrayList();
                    if (steps != null) {
                        Iterator<RouteResult.Step> it = steps.iterator();
                        while (it.hasNext()) {
                            arrayList3.addAll(it.next().getPoints());
                        }
                        arrayList2.add(a(this.f));
                        a(arrayList2, arrayList3);
                        arrayList2.add(a(this.g));
                        a2.points.addAll(arrayList2);
                    }
                    if (this.mMapContainer != null && this.f7168a != null) {
                        clearRoute();
                        this.k.addAll(this.mMapContainer.polylineController.toAdapterPolylines(this.mMapContainer.polylineController.addPolyline(this.f7168a, arrayList, true)));
                        this.l.clear();
                        this.l.addAll(arrayList);
                        c();
                        b();
                    }
                    f5 = f6;
                    f6 = f4;
                    z2 = true;
                    f3 = f5;
                    z = z2;
                    str2 = str4;
                    f2 = f6;
                } catch (Throwable th4) {
                    th = th4;
                    f = f4;
                    z2 = true;
                    GriverLogger.e("RouteSearchHelper", "routeSearched#process error", th);
                    z = z2;
                    f2 = f;
                    str2 = str4;
                    f3 = f6;
                    a(z, f2, f3, str, str2);
                }
                a(z, f2, f3, str, str2);
            }
            str3 = str4;
            str4 = str;
        } else {
            str3 = null;
        }
        str = str4;
        str4 = str3;
        f5 = 0.0f;
        f3 = f5;
        z = z2;
        str2 = str4;
        f2 = f6;
        a(z, f2, f3, str, str2);
    }
}
