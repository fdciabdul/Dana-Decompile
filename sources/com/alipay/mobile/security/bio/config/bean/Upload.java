package com.alipay.mobile.security.bio.config.bean;

import com.alipay.mobile.security.bio.common.record.MetaRecord;
import com.alipay.mobile.security.bio.utils.StringUtil;

/* loaded from: classes7.dex */
public class Upload {
    private String[] collection;
    private int minquality = 10;
    private String mode = "2.0";
    private float upload_compress_rate = 0.8f;
    private String log_classifier = MetaRecord.DEFAULT_LOG_CLASSIFIERS;

    public String getLog_classifier() {
        return this.log_classifier;
    }

    public void setLog_classifier(String str) {
        this.log_classifier = str;
    }

    public String[] getCollection() {
        return this.collection;
    }

    public void setCollection(String[] strArr) {
        this.collection = strArr;
    }

    public int getMinquality() {
        return this.minquality;
    }

    public void setMinquality(int i) {
        this.minquality = i;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public float getUpload_compress_rate() {
        return this.upload_compress_rate;
    }

    public void setUpload_compress_rate(float f) {
        this.upload_compress_rate = f;
    }

    public String getLogClassifier() {
        return this.log_classifier;
    }

    public void setLogClassifier(String str) {
        this.log_classifier = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Upload{minquality=");
        sb.append(this.minquality);
        sb.append(", mode='");
        sb.append(this.mode);
        sb.append('\'');
        sb.append(", upload_compress_rate=");
        sb.append(this.upload_compress_rate);
        sb.append(", log_classifier='");
        sb.append(this.log_classifier);
        sb.append('\'');
        sb.append(", collection='");
        sb.append(StringUtil.array2String(this.collection));
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
