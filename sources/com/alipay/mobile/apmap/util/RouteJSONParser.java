package com.alipay.mobile.apmap.util;

import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.RouteResult;
import com.google.android.gms.maps.model.LatLng;
import id.dana.analytics.tracker.TrackerKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class RouteJSONParser {
    public static RouteResult parseRoute(JSONObject jSONObject) {
        JSONArray jSONArray;
        String str = "distance";
        String str2 = "duration";
        String str3 = "value";
        RouteResult routeResult = new RouteResult();
        try {
            routeResult.setStatus(jSONObject.optString("status"));
            routeResult.setErrorMessage(jSONObject.optString(TrackerKey.Property.ERROR_MESSAGE_FIREBASE));
            ArrayList arrayList = new ArrayList();
            routeResult.setPaths(arrayList);
            JSONArray jSONArray2 = jSONObject.getJSONArray("routes");
            int i = 0;
            while (i < jSONArray2.length()) {
                RouteResult.Path path = new RouteResult.Path();
                arrayList.add(path);
                ArrayList arrayList2 = new ArrayList();
                path.setSteps(arrayList2);
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i).getJSONArray("legs");
                long j = 0;
                long j2 = 0;
                int i2 = 0;
                while (true) {
                    jSONArray = jSONArray2;
                    if (i2 >= jSONArray3.length()) {
                        break;
                    }
                    j += jSONArray3.getJSONObject(i2).getJSONObject(str2).getLong(str3);
                    long j3 = jSONArray3.getJSONObject(i2).getJSONObject(str).getLong(str3);
                    JSONArray jSONArray4 = jSONArray3.getJSONObject(i2).getJSONArray("steps");
                    ArrayList arrayList3 = arrayList;
                    int i3 = 0;
                    while (i3 < jSONArray4.length()) {
                        JSONArray jSONArray5 = jSONArray3;
                        long j4 = j;
                        long j5 = jSONArray4.getJSONObject(i3).getJSONObject(str).getLong(str3);
                        String str4 = str;
                        String str5 = str2;
                        long j6 = jSONArray4.getJSONObject(i3).getJSONObject(str2).getLong(str3);
                        ArrayList arrayList4 = new ArrayList();
                        JSONArray jSONArray6 = jSONArray4;
                        String str6 = str3;
                        int i4 = 0;
                        for (List<LatLng> decodePointsToLatLngList = decodePointsToLatLngList(jSONArray4.getJSONObject(i3).getJSONObject("polyline").getString("points")); i4 < decodePointsToLatLngList.size(); decodePointsToLatLngList = decodePointsToLatLngList) {
                            arrayList4.add(new LatLonPoint(decodePointsToLatLngList.get(i4).latitude, decodePointsToLatLngList.get(i4).longitude));
                            i4++;
                            i = i;
                            path = path;
                            j2 = j2;
                            i2 = i2;
                        }
                        GriverLogger.d("RouteJSONParser", String.format("parseRoute, distance = %s, duration = %s, points  = %s.", Long.valueOf(j5), Long.valueOf(j6), arrayList4));
                        RouteResult.Step step = new RouteResult.Step();
                        step.setPoints(arrayList4);
                        step.setDistance(j5);
                        step.setDuration(j6);
                        arrayList2.add(step);
                        i3++;
                        i = i;
                        jSONArray3 = jSONArray5;
                        j = j4;
                        str = str4;
                        str2 = str5;
                        jSONArray4 = jSONArray6;
                        str3 = str6;
                        path = path;
                        j2 = j2;
                        i2 = i2;
                    }
                    i2++;
                    jSONArray2 = jSONArray;
                    arrayList = arrayList3;
                    j2 += j3;
                    str = str;
                    str2 = str2;
                }
                String str7 = str;
                String str8 = str2;
                String str9 = str3;
                ArrayList arrayList5 = arrayList;
                RouteResult.Path path2 = path;
                long j7 = j2;
                int i5 = i;
                GriverLogger.d("RouteJSONParser", String.format("parseRoute, totalDistance = %s,  totalDuration = %s.", Long.valueOf(j7), Long.valueOf(j)));
                path2.setDistance(j7);
                path2.setDuration(j);
                i = i5 + 1;
                jSONArray2 = jSONArray;
                arrayList = arrayList5;
                str = str7;
                str2 = str8;
                str3 = str9;
            }
        } catch (Throwable th) {
            GriverLogger.e("RouteJSONParser", String.format("parseRoute, error = %s.", th));
        }
        return routeResult;
    }

    public static List<LatLng> decodePointsToLatLngList(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = 1;
            int i7 = 0;
            while (true) {
                i = i3 + 1;
                int charAt = (str.charAt(i3) - '?') - 1;
                i6 += charAt << i7;
                i7 += 5;
                if (charAt < 31) {
                    break;
                }
                i3 = i;
            }
            int i8 = ((i6 & 1) != 0 ? (i6 >> 1) ^ (-1) : i6 >> 1) + i4;
            int i9 = 1;
            int i10 = 0;
            while (true) {
                i2 = i + 1;
                int charAt2 = (str.charAt(i) - '?') - 1;
                i9 += charAt2 << i10;
                i10 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i = i2;
            }
            int i11 = i9 >> 1;
            if ((i9 & 1) != 0) {
                i11 ^= -1;
            }
            i5 += i11;
            double d = i8;
            double d2 = i5;
            Double.isNaN(d);
            Double.isNaN(d2);
            arrayList.add(new LatLng(d * 1.0E-5d, d2 * 1.0E-5d));
            i4 = i8;
            i3 = i2;
        }
        return arrayList;
    }
}
