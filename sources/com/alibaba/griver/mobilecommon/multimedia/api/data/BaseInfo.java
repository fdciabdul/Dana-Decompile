package com.alibaba.griver.mobilecommon.multimedia.api.data;

import android.text.TextUtils;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes6.dex */
public class BaseInfo {
    public static final int PRIORITY_HIGH = 10;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MID = 5;
    private String bizType;
    public String businessId;
    public Map<String, String> extInfo;
    private String md5;
    private Integer priority = 5;
    private boolean bHttps = false;
    private int mTimeout = -1;
    private long expiredTime = LongCompanionObject.MAX_VALUE;
    private boolean allowDownloadBackgroud = true;

    public int getPriority() {
        return this.priority.intValue();
    }

    public void setPriority(int i) {
        if (i <= 0 || i > 10) {
            return;
        }
        this.priority = Integer.valueOf(i);
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public boolean isHttps() {
        return this.bHttps;
    }

    public void setHttps(boolean z) {
        this.bHttps = z;
    }

    public String getBizType() {
        if (TextUtils.isEmpty(this.bizType)) {
            this.bizType = this.businessId;
        }
        return this.bizType;
    }

    public BaseInfo setBizType(String str) {
        this.bizType = str;
        return this;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public BaseInfo setBusinessId(String str) {
        this.businessId = str;
        return this;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public void setTimeout(int i) {
        this.mTimeout = i;
    }

    public void setAllowDownloadBackgroud(boolean z) {
        this.allowDownloadBackgroud = z;
    }

    public boolean isAllowDownloadBackgroud() {
        return this.allowDownloadBackgroud;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseInfo{md5='");
        sb.append(this.md5);
        sb.append('\'');
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(", bHttps=");
        sb.append(this.bHttps);
        sb.append(", bizType='");
        sb.append(this.bizType);
        sb.append('\'');
        sb.append(", businessId='");
        sb.append(this.businessId);
        sb.append('\'');
        sb.append(", extInfo='");
        sb.append(this.extInfo);
        sb.append('\'');
        sb.append(", expiredTime='");
        sb.append(this.expiredTime);
        sb.append('\'');
        sb.append("，mTimeout=");
        sb.append(this.mTimeout);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
