package com.alipay.mobile.security.bio.service;

import android.os.Bundle;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BioAppDescription implements Serializable {
    public static final int APP_TYPE_ACTIVITY = 0;
    public static final int APP_TYPE_BROADCAST_RECIEVER = 3;
    public static final int APP_TYPE_CONTENT_PROVIDER = 4;
    public static final int APP_TYPE_SERVICE = 1;
    private static final long serialVersionUID = 1;
    private String appInterfaceName;
    private String appName;
    private int bioAction;
    private int bioType;
    private String bistoken;
    private Bundle bundle;
    private String cfg;
    private String headImageDir;
    private JSONObject mFcSpecialData;
    private String remoteURL;
    private String tag;
    private int appType = 0;
    private boolean signed = true;
    protected Map<String, String> extProperty = new HashMap();
    protected Map<String, String> extMetaInfo = new HashMap();
    private long productID = -1;
    private boolean autoClose = true;

    public int getAppType() {
        return this.appType;
    }

    public void setAppType(int i) {
        this.appType = i;
    }

    public String getRemoteURL() {
        return this.remoteURL;
    }

    public void setRemoteURL(String str) {
        this.remoteURL = str;
    }

    public String getHeadImageURL() {
        return this.headImageDir;
    }

    public void setHeadImageURL(String str) {
        this.headImageDir = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getAppInterfaceName() {
        return this.appInterfaceName;
    }

    public void setAppInterfaceName(String str) {
        this.appInterfaceName = str;
    }

    public int getBioType() {
        return this.bioType;
    }

    public void setBioType(int i) {
        this.bioType = i;
    }

    public int getBioAction() {
        return this.bioAction;
    }

    public void setBioAction(int i) {
        this.bioAction = i;
    }

    public String getCfg() {
        return this.cfg;
    }

    public void setCfg(String str) {
        this.cfg = str;
    }

    public Map<String, String> getExtProperty() {
        return this.extProperty;
    }

    public void addExtProperty(String str, String str2) {
        this.extProperty.put(str, str2);
    }

    public boolean isSigned() {
        return this.signed;
    }

    public void setSigned(boolean z) {
        this.signed = z;
    }

    public String getBistoken() {
        return this.bistoken;
    }

    public void setBistoken(String str) {
        this.bistoken = str;
    }

    public JSONObject getFcSpecialData() {
        return this.mFcSpecialData;
    }

    public void setFcSpecialData(JSONObject jSONObject) {
        this.mFcSpecialData = jSONObject;
    }

    public boolean isAutoClose() {
        return this.autoClose;
    }

    public void setAutoClose(boolean z) {
        this.autoClose = z;
    }

    public long getProductID() {
        return this.productID;
    }

    public void setProductID(long j) {
        this.productID = j;
    }

    public Map<String, String> getExtMetaInfo() {
        return this.extMetaInfo;
    }

    public void setExtMetaInfo(Map<String, String> map) {
        this.extMetaInfo = map;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" appType:");
        sb2.append(this.appType);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" bioType:");
        sb3.append(this.bioType);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" bioAction:");
        sb4.append(this.bioAction);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" appName:");
        sb5.append(this.appName);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(" cfg:");
        sb6.append(this.cfg);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(" signed:");
        sb7.append(this.signed);
        sb.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(" bistoken:");
        sb8.append(this.bistoken);
        sb.append(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append(" autoClose:");
        sb9.append(this.autoClose);
        sb.append(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append(" appInterfaceName:");
        sb10.append(this.appInterfaceName);
        sb.append(sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append(" productID:");
        sb11.append(this.productID);
        sb.append(sb11.toString());
        return sb.toString();
    }
}
