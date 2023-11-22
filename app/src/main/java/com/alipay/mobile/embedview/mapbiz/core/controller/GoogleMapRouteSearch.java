package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.apmap.util.RouteJSONParser;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.RouteResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class GoogleMapRouteSearch {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f7152a = new HashMap();
    private OnRouteSearchListener b;

    /* loaded from: classes6.dex */
    public interface OnRouteSearchListener {
        void onRouteSearchFinish(RouteResult routeResult);
    }

    public GoogleMapRouteSearch(OnRouteSearchListener onRouteSearchListener) {
        Map<String, String> map = f7152a;
        map.put("walk", "walking");
        map.put("ride", "bicycling");
        map.put("drive", "driving");
        map.put("bus", DanaLogConstants.BizType.TRANSIT);
        this.b = onRouteSearchListener;
    }

    public void calculateRouteAsync(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, List<LatLonPoint> list, String str2) {
        try {
            RouteResult parseRoute = RouteJSONParser.parseRoute(new JSONObject(GoogleMapRouteSearchUtil.requestRouteSearchGet(f7152a.get(str), latLonPoint, latLonPoint2, a(list), str2)));
            OnRouteSearchListener onRouteSearchListener = this.b;
            if (onRouteSearchListener != null) {
                onRouteSearchListener.onRouteSearchFinish(parseRoute);
            }
        } catch (Throwable th) {
            GriverLogger.e("GoogleMapRouteSearch", "calculateRouteAsync#request route error.", th);
            if (this.b != null) {
                RouteResult routeResult = new RouteResult();
                routeResult.setErrorMessage("request route error.");
                this.b.onRouteSearchFinish(routeResult);
            }
        }
    }

    private String a(List<LatLonPoint> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
        }
        return sb.toString();
    }
}
