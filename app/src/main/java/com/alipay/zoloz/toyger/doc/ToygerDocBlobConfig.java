package com.alipay.zoloz.toyger.doc;

import com.alibaba.fastjson.JSON;
import com.alipay.zoloz.toyger.algorithm.ToygerBlobConfig;

/* loaded from: classes7.dex */
public class ToygerDocBlobConfig extends ToygerBlobConfig {
    public String docType;
    public int pageNo;
    public float ratio;
    public String subType;

    public ToygerDocBlobConfig() {
    }

    public ToygerDocBlobConfig(float f, String str) {
        this.ratio = f;
        this.pubkey = str;
    }

    @Override // com.alipay.zoloz.toyger.algorithm.ToygerBlobConfig
    public float getCompressRate() {
        return this.ratio;
    }

    @Override // com.alipay.zoloz.toyger.algorithm.ToygerBlobConfig
    public Integer getDesiredWidth() {
        return 1080;
    }

    public static ToygerDocBlobConfig from(String str, String str2) {
        ToygerDocBlobConfig toygerDocBlobConfig = (ToygerDocBlobConfig) JSON.parseObject(str, ToygerDocBlobConfig.class);
        toygerDocBlobConfig.pubkey = str2;
        return toygerDocBlobConfig;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToygerDocBlobConfig{ratio=");
        sb.append(this.ratio);
        sb.append('}');
        return sb.toString();
    }
}
