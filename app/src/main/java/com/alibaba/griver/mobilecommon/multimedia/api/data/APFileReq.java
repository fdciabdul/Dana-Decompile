package com.alibaba.griver.mobilecommon.multimedia.api.data;

import android.os.Bundle;

/* loaded from: classes6.dex */
public class APFileReq extends BaseInfo {
    public static final String FILE_TYPE_COMPRESS_IMAGE = "compress_image";
    public static final String FILE_TYPE_IMAGE = "image";
    public static final String KEY_FILE_KEY = "filekey";
    public static final String KEY_REFID = "refid";
    public static final String KEY_SSID = "ssid";
    String aliasFileName;
    Bundle bundle;
    String cacheId;
    String cloudId;
    boolean isSync;
    APRequestParam requestParam;
    String savePath;
    Boolean setPublic;
    String type;
    byte[] uploadData;
    private String uploadIdentifier;
    @Deprecated
    String url;
    boolean isForceUrl = false;
    boolean isNeedCache = true;
    boolean cacheWhileError = false;
    int callGroup = 1000;
    int priority = 5;
    boolean encrypt = false;
    boolean decrypt = false;
    boolean sendExtras = false;
    private Boolean needCookie = null;
    private boolean needNetHeaders = false;

    public void enableCookies(boolean z) {
        this.needCookie = Boolean.valueOf(z);
    }

    public Boolean isEnableCookies() {
        return this.needCookie;
    }

    public boolean userSetCookiesProp() {
        return this.needCookie != null;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public APRequestParam getRequestParam() {
        return this.requestParam;
    }

    public void setRequestParam(APRequestParam aPRequestParam) {
        this.requestParam = aPRequestParam;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public void setCacheId(String str) {
        this.cacheId = str;
    }

    public String getCloudId() {
        return this.cloudId;
    }

    public void setCloudId(String str) {
        this.cloudId = str;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public void setUploadIdentifier(String str) {
        this.uploadIdentifier = str;
    }

    public String getUploadIdentifier() {
        return this.uploadIdentifier;
    }

    public void setForceUrl(boolean z) {
        this.isForceUrl = z;
    }

    public boolean getForceUrl() {
        return this.isForceUrl;
    }

    public void setNeedNetHeaders(boolean z) {
        this.needNetHeaders = z;
    }

    public boolean needNetHeaders() {
        return this.needNetHeaders;
    }

    @Deprecated
    public String getUrl() {
        return this.url;
    }

    @Deprecated
    public void setUrl(String str) {
        this.url = str;
        setCloudId(str);
    }

    public boolean isSync() {
        return this.isSync;
    }

    public void setSync(boolean z) {
        this.isSync = z;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setIsNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public String getAliasFileName() {
        return this.aliasFileName;
    }

    public void setAliasFileName(String str) {
        this.aliasFileName = str;
    }

    public int getCallGroup() {
        return this.callGroup;
    }

    public void setCallGroup(int i) {
        this.callGroup = i;
        if (this.isNeedCache) {
            this.isNeedCache = i == 1000;
        }
    }

    public boolean isCacheWhileError() {
        return this.cacheWhileError;
    }

    public void setCacheWhileError(boolean z) {
        this.cacheWhileError = z;
    }

    @Override // com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo
    public void setPriority(int i) {
        if (i <= 0 || i > 10) {
            return;
        }
        this.priority = i;
    }

    @Override // com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo
    public int getPriority() {
        return this.priority;
    }

    public Boolean getPublic() {
        return this.setPublic;
    }

    public APFileReq setPublic(Boolean bool) {
        this.setPublic = bool;
        return this;
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public void setUploadData(byte[] bArr) {
        this.uploadData = bArr;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public boolean isSendExtras() {
        return this.sendExtras;
    }

    public void setSendExtras(boolean z) {
        this.sendExtras = z;
    }

    @Override // com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APFileReq{requestParam=");
        sb.append(this.requestParam);
        sb.append(", cacheId='");
        sb.append(this.cacheId);
        sb.append('\'');
        sb.append(", cloudId='");
        sb.append(this.cloudId);
        sb.append('\'');
        sb.append(", savePath='");
        sb.append(this.savePath);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", isSync=");
        sb.append(this.isSync);
        sb.append(", type='");
        sb.append(this.type);
        sb.append('\'');
        sb.append(", isNeedCache=");
        sb.append(this.isNeedCache);
        sb.append(", cacheWhileError=");
        sb.append(this.cacheWhileError);
        sb.append(", aliasFileName='");
        sb.append(this.aliasFileName);
        sb.append('\'');
        sb.append(", callGroup=");
        sb.append(this.callGroup);
        sb.append(", businessId='");
        sb.append(this.businessId);
        sb.append('\'');
        sb.append(", priority='");
        sb.append(this.priority);
        sb.append('\'');
        sb.append(", uploadIdentifier='");
        sb.append(this.uploadIdentifier);
        sb.append('\'');
        sb.append(", setPublic='");
        sb.append(this.setPublic);
        sb.append('\'');
        sb.append(", uploadData='");
        sb.append(this.uploadData);
        sb.append('\'');
        sb.append(", encrypt=");
        sb.append(this.encrypt);
        sb.append('\'');
        sb.append(", super=");
        sb.append(super.toString());
        sb.append(",bundleArgs=");
        sb.append(printBundle());
        sb.append('}');
        return sb.toString();
    }

    private String printBundle() {
        Bundle bundle = this.bundle;
        return (bundle == null || bundle.isEmpty()) ? "" : this.bundle.toString();
    }
}
