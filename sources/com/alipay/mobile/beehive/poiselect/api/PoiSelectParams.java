package com.alipay.mobile.beehive.poiselect.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.android.mapassist.util.Constants;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import com.alipay.mobile.map.model.LatLonPoint;

/* loaded from: classes6.dex */
public class PoiSelectParams implements Parcelable {
    public static final String APP_ID = "appId";
    public static final String BIZ_ID = "biz_id";
    public static final String CHINA_COUNTRYCODE = "156";
    public static final Parcelable.Creator<PoiSelectParams> CREATOR = new Parcelable.Creator<PoiSelectParams>() { // from class: com.alipay.mobile.beehive.poiselect.api.PoiSelectParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PoiSelectParams createFromParcel(Parcel parcel) {
            return new PoiSelectParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PoiSelectParams[] newArray(int i) {
            return new PoiSelectParams[i];
        }
    };
    public static final boolean DEFAULT_SHOW_HIDE_LOCATION = true;
    public static final boolean DEFAULT_SHOW_LOCATED_CITY = true;
    public static final String HIDE_LOCATION_NAME = "hide_location";
    public static final double INVALID_LATITUDE_LONGITUDE = -999999.0d;
    public static final String KEYWORD = "keyword";
    public static final String KEY_JS_API_START_TIME = "JSAPI.startTime";
    public static final String KEY_JS_API_TAG = "JSAPI.tag";
    public static final String KEY_MODE = "mode";
    public static final String KEY_NEEDREGEOCODE = "needReGeocode";
    public static final String LATITUDE = "latitude";
    public static final String LOCATION_ADDRESS = "current_location_addr";
    public static final String LOCATION_NAME = "current_location_name";
    public static final String LONGITUDE = "longitude";
    public static final String MODE_SEARCH_LOCATION = "searchLocation";
    public static final String POI_APPKEY = "appKey";
    public static final String POI_CITY = "city";
    public static final String POI_ID = "poi_id";
    public static final String POI_TITLE = "title";
    public static final String PREPOI_LAT = "prePOILat";
    public static final String PREPOI_LON = "prePOILon";
    public static final String SEARCH_HINT = "searchHint";
    public static final String SHOP_ID = "shop_id";
    public static final String SHOW_HIDE_LOCATION = "show_hide_location";
    public static final String SHOW_LOCATED_CITY = "show_located_city";
    public static final String START_BY_SERVICE = "start_by_service";
    public String addr;
    public String appId;
    public String appKey;
    public String bizId;
    public String city;
    public boolean fullMap;
    public boolean hideSearch;
    public boolean isNeedScreenShot;
    public boolean isShowConfirmSelectBtn;
    public long jsApiStartTime;
    public String jsApiTag;
    public String keyword;
    public double latitude;
    public PoiItemExt locatePOI;
    public double longitude;
    public String markerTitle;
    public String mode;
    public String name;
    public boolean needReGeocode;
    public String poiId;
    public String poiType;
    public double prePOILat;
    public double prePOILon;
    public int radius;
    public float scale;
    public String searchHint;
    public String sendBtnText;
    public String shopId;
    public boolean showHideLocation;
    public boolean showLocatedCity;
    public boolean showPoiActions;
    public boolean showPoiDistance;
    public String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PoiSelectParams() {
        this.longitude = -999999.0d;
        this.latitude = -999999.0d;
        this.showHideLocation = true;
        this.showLocatedCity = true;
        this.scale = 15.0f;
        this.appId = "";
    }

    public PoiSelectParams(Bundle bundle) {
        this.longitude = -999999.0d;
        this.latitude = -999999.0d;
        this.showHideLocation = true;
        this.showLocatedCity = true;
        this.scale = 15.0f;
        this.appId = "";
        this.appId = bundle.getString("appId", "");
        if (bundle.containsKey("presetPOI")) {
            try {
                String string = bundle.getString("presetPOI");
                if (!TextUtils.isEmpty(string)) {
                    PoiItemExt poiItemExt = (PoiItemExt) JSON.parseObject(string, PoiItemExt.class);
                    this.name = poiItemExt.getTitle();
                    this.addr = poiItemExt.getSnippet();
                    this.poiId = poiItemExt.getPoiId();
                    this.shopId = poiItemExt.getShopID();
                    LatLonPoint latLonPoint = poiItemExt.getLatLonPoint();
                    if (latLonPoint != null) {
                        this.prePOILat = latLonPoint.getLatitude();
                        this.prePOILon = latLonPoint.getLongitude();
                    }
                }
            } catch (Throwable th) {
                GriverLogger.w(Constants.BASE_TAG, th.toString());
            }
        } else {
            this.name = bundle.getString(LOCATION_NAME);
            this.addr = bundle.getString(LOCATION_ADDRESS);
            this.poiId = bundle.getString(POI_ID);
            this.shopId = bundle.getString(SHOP_ID);
            this.prePOILat = bundle.getDouble(PREPOI_LAT, -999999.0d);
            this.prePOILon = bundle.getDouble(PREPOI_LON, -999999.0d);
        }
        if (bundle.containsKey("locatePOI")) {
            this.locatePOI = (PoiItemExt) JSON.parseObject(bundle.getString("locatePOI"), PoiItemExt.class);
        }
        this.title = bundle.getString("title");
        this.city = bundle.getString("city");
        this.appKey = bundle.getString("appKey");
        this.keyword = bundle.getString("keyword");
        this.longitude = bundle.getDouble("longitude", -999999.0d);
        this.latitude = bundle.getDouble("latitude", -999999.0d);
        this.showHideLocation = bundle.getBoolean(SHOW_HIDE_LOCATION, true);
        this.showLocatedCity = bundle.getBoolean(SHOW_LOCATED_CITY, true);
        this.needReGeocode = bundle.getBoolean(KEY_NEEDREGEOCODE, true);
        this.isShowConfirmSelectBtn = bundle.getBoolean("isShowConfirmSelectBtn", false);
        this.isNeedScreenShot = bundle.getBoolean("isNeedScreenShot", false);
        this.showPoiDistance = bundle.getBoolean("showPoiDistance", false);
        this.showPoiActions = bundle.getBoolean("showPoiActions", false);
        this.poiType = bundle.getString("poiType");
        this.radius = bundle.getInt("radius");
        this.bizId = bundle.getString(BIZ_ID);
        this.searchHint = bundle.getString(SEARCH_HINT);
        this.mode = bundle.getString("mode");
        this.sendBtnText = bundle.getString("sendBtnText");
        this.fullMap = bundle.getBoolean("fullMap", false);
        float f = bundle.getFloat(H5MapRenderOptimizer.KEY_SCALE, 16.0f);
        if (f > 0.0f) {
            this.scale = f;
        }
        this.markerTitle = bundle.getString("markerTitle");
        this.hideSearch = bundle.getBoolean("hideSearch", false);
        this.jsApiTag = bundle.getString(KEY_JS_API_TAG);
        this.jsApiStartTime = bundle.getLong(KEY_JS_API_START_TIME);
    }

    protected PoiSelectParams(Parcel parcel) {
        this.longitude = -999999.0d;
        this.latitude = -999999.0d;
        this.showHideLocation = true;
        this.showLocatedCity = true;
        this.scale = 15.0f;
        this.appId = "";
        this.name = parcel.readString();
        this.addr = parcel.readString();
        this.poiId = parcel.readString();
        this.title = parcel.readString();
        this.appKey = parcel.readString();
        this.city = parcel.readString();
        this.keyword = parcel.readString();
        this.shopId = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.showHideLocation = parcel.readInt() != 0;
        this.showLocatedCity = parcel.readInt() != 0;
        this.bizId = parcel.readString();
        this.searchHint = parcel.readString();
        this.needReGeocode = parcel.readInt() != 0;
        this.prePOILat = parcel.readDouble();
        this.prePOILon = parcel.readDouble();
        this.mode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.addr);
        parcel.writeString(this.poiId);
        parcel.writeString(this.title);
        parcel.writeString(this.appKey);
        parcel.writeString(this.city);
        parcel.writeString(this.keyword);
        parcel.writeString(this.shopId);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeInt(this.showHideLocation ? 1 : 0);
        parcel.writeInt(this.showLocatedCity ? 1 : 0);
        parcel.writeString(this.bizId);
        parcel.writeString(this.searchHint);
        parcel.writeInt(this.needReGeocode ? 1 : 0);
        parcel.writeDouble(this.prePOILat);
        parcel.writeDouble(this.prePOILon);
        parcel.writeString(this.mode);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiSelectParams{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", addr='");
        sb.append(this.addr);
        sb.append('\'');
        sb.append(", poiId='");
        sb.append(this.poiId);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", poiId='");
        sb.append(this.poiId);
        sb.append('\'');
        sb.append(", appKey='");
        sb.append(this.appKey);
        sb.append('\'');
        sb.append(", city='");
        sb.append(this.city);
        sb.append('\'');
        sb.append(", keyword='");
        sb.append(this.keyword);
        sb.append('\'');
        sb.append(", longitude=");
        sb.append(this.longitude);
        sb.append(", latitude=");
        sb.append(this.latitude);
        sb.append(", showHideLocation=");
        sb.append(this.showHideLocation);
        sb.append(", showLocatedCity=");
        sb.append(this.showLocatedCity);
        sb.append(", needReGeocode=");
        sb.append(this.needReGeocode);
        sb.append(", bizId='");
        sb.append(this.bizId);
        sb.append('\'');
        sb.append(", searchHint='");
        sb.append(this.searchHint);
        sb.append('\'');
        sb.append(", prePOILon=");
        sb.append(this.prePOILon);
        sb.append(", prePOILat=");
        sb.append(this.prePOILat);
        sb.append(", mode=");
        sb.append(this.mode);
        sb.append('}');
        return sb.toString();
    }
}
