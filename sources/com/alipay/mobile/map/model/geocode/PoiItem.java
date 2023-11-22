package com.alipay.mobile.map.model.geocode;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.map.model.LatLonPoint;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class PoiItem implements Serializable, Cloneable {
    private static final String TAG = "PoiItem";
    private static final long serialVersionUID = 3080733171310299683L;
    private String adCode;
    private String adName;
    private String cityCode;
    private String cityName;
    private String country;
    private String direction;
    private int distance;
    private String dtLogMonitor;
    private String email;
    private LatLonPoint enter;
    private LatLonPoint exit;
    private boolean isChina;
    private boolean isMainland;
    private LatLonPoint latLonPoint;
    private boolean municipality;
    private String poiId;
    private String postcode;
    private String provinceCode;
    private String provinceName;
    private String shopID;
    private String snippet;
    private String state;
    private String tel;
    private String title;
    private String typeDes;
    private String website;

    public String getAdCode() {
        return this.adCode;
    }

    public void setAdCode(String str) {
        this.adCode = str;
    }

    public String getAdName() {
        return this.adName;
    }

    public void setAdName(String str) {
        this.adName = str;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public LatLonPoint getEnter() {
        return this.enter;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.enter = latLonPoint;
    }

    public LatLonPoint getExit() {
        return this.exit;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.exit = latLonPoint;
    }

    public LatLonPoint getLatLonPoint() {
        return this.latLonPoint;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.latLonPoint = latLonPoint;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String str) {
        this.postcode = str;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(String str) {
        this.provinceName = str;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public void setSnippet(String str) {
        this.snippet = str;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String str) {
        this.tel = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTypeDes() {
        return this.typeDes;
    }

    public void setTypeDes(String str) {
        this.typeDes = str;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String str) {
        this.website = str;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(String str) {
        this.provinceCode = str;
    }

    public String getShopID() {
        return this.shopID;
    }

    public void setShopID(String str) {
        this.shopID = str;
    }

    public String getDtLogMonitor() {
        return this.dtLogMonitor;
    }

    public void setDtLogMonitor(String str) {
        this.dtLogMonitor = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public boolean isChina() {
        return this.isChina;
    }

    public void setChina(boolean z) {
        this.isChina = z;
    }

    public boolean isMainland() {
        return this.isMainland;
    }

    public void setMainland(boolean z) {
        this.isMainland = z;
    }

    public boolean isMunicipality() {
        return this.municipality;
    }

    public void setMunicipality(boolean z) {
        this.municipality = z;
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public PoiItem m83clone() {
        PoiItem poiItem;
        Exception e;
        LatLonPoint latLonPoint = null;
        try {
            poiItem = (PoiItem) super.clone();
        } catch (Exception e2) {
            poiItem = null;
            e = e2;
        }
        try {
            poiItem.setEnter(getEnter() == null ? null : getEnter().m81clone());
            poiItem.setExit(getExit() == null ? null : getExit().m81clone());
            if (getLatLonPoint() != null) {
                latLonPoint = getLatLonPoint().m81clone();
            }
            poiItem.setLatLonPoint(latLonPoint);
        } catch (Exception e3) {
            e = e3;
            StringBuilder sb = new StringBuilder();
            sb.append("clone exceptin, msg=");
            sb.append(e);
            RVLogger.e(TAG, sb.toString());
            return poiItem;
        }
        return poiItem;
    }
}
