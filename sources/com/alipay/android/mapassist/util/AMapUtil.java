package com.alipay.android.mapassist.util;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.LatLonPointEx;
import com.alipay.mobile.map.model.geocode.PoiItem;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: classes6.dex */
public class AMapUtil {
    public static final String HtmlBlack = "#000000";
    public static final String HtmlGray = "#808080";
    public static final String HtmlOrange = "#eb4416";

    public static boolean checkReady(Context context, AdapterAMap adapterAMap) {
        return adapterAMap != null;
    }

    public static String makeHtmlNewLine() {
        return "<br />";
    }

    public static Spanned stringToSpan(String str) {
        if (str == null) {
            return null;
        }
        return Html.fromHtml(str.replace("\n", "<br />"));
    }

    public static String colorFont(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font color=");
        stringBuffer.append(str2);
        stringBuffer.append(SimpleComparison.GREATER_THAN_OPERATION);
        stringBuffer.append(str);
        stringBuffer.append("</font>");
        return stringBuffer.toString();
    }

    public static String boldFont(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("<b>");
        sb.append(str);
        sb.append("</b>");
        return sb.toString();
    }

    public static String makeHtmlSpace(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("&nbsp;");
        }
        return sb.toString();
    }

    public static String getFriendlyLength(int i) {
        if (i > 10000) {
            StringBuilder sb = new StringBuilder();
            sb.append(i / 1000);
            sb.append(ChString.Kilometer);
            return sb.toString();
        } else if (i > 1000) {
            String format = new DecimalFormat("##0.0").format(i / 1000.0f);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(format);
            sb2.append(ChString.Kilometer);
            return sb2.toString();
        } else if (i > 100) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append((i / 50) * 50);
            sb3.append(ChString.Meter);
            return sb3.toString();
        } else {
            int i2 = (i / 10) * 10;
            int i3 = i2 != 0 ? i2 : 10;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i3);
            sb4.append(ChString.Meter);
            return sb4.toString();
        }
    }

    public static boolean IsEmptyOrNullString(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static LatLonPoint convertToLatLonPoint(AdapterLatLng adapterLatLng) {
        return new LatLonPoint(adapterLatLng.getLatitude(), adapterLatLng.getLongitude());
    }

    public static LatLonPoint convertToMyLatLonPoint(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return null;
        }
        return new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    public static LatLonPoint convertToMyLatLonPointFromCloud(LatLonPoint latLonPoint) {
        return new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    public static AdapterLatLng convertToLatLng(DynamicSDKContext dynamicSDKContext, LatLonPointEx latLonPointEx) {
        return new AdapterLatLng(dynamicSDKContext, latLonPointEx.getLatitude(), latLonPointEx.getLongitude());
    }

    public static PoiItem convertToMyPoiItem(PoiItem poiItem) {
        PoiItem poiItem2 = new PoiItem();
        poiItem2.setAdCode(poiItem.getAdCode());
        poiItem2.setAdName(poiItem.getAdName());
        poiItem2.setCityCode(poiItem.getCityCode());
        poiItem2.setCityName(poiItem.getCityName());
        poiItem2.setDirection(poiItem.getDirection());
        poiItem2.setDistance(poiItem.getDistance());
        poiItem2.setEmail(poiItem.getEmail());
        poiItem2.setEnter(convertToMyLatLonPoint(poiItem.getEnter()));
        poiItem2.setExit(convertToMyLatLonPoint(poiItem.getExit()));
        poiItem2.setLatLonPoint(convertToMyLatLonPoint(poiItem.getLatLonPoint()));
        poiItem2.setPoiId(poiItem.getPoiId());
        poiItem2.setPostcode(poiItem.getPostcode());
        poiItem2.setProvinceCode(poiItem.getProvinceCode());
        poiItem2.setProvinceName(poiItem.getProvinceName());
        poiItem2.setSnippet(poiItem.getSnippet());
        poiItem2.setTel(poiItem.getTel());
        poiItem2.setTitle(poiItem.getTitle());
        poiItem2.setTypeDes(poiItem.getTypeDes());
        poiItem2.setWebsite(poiItem.getWebsite());
        poiItem2.setShopID(poiItem.getShopID());
        return poiItem2;
    }

    public static AdapterLatLngBounds getLatLngBounds(DynamicSDKContext dynamicSDKContext, List<PoiItem> list) {
        AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(dynamicSDKContext);
        for (int i = 0; i < list.size(); i++) {
            adapterLatLngBounds.include(new AdapterLatLng(dynamicSDKContext, list.get(i).getLatLonPoint().getLatitude(), list.get(i).getLatLonPoint().getLongitude()));
        }
        return adapterLatLngBounds.build();
    }

    public static String convertToTime(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }
}
