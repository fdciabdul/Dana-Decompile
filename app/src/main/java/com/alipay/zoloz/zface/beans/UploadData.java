package com.alipay.zoloz.zface.beans;

import com.alibaba.fastjson.JSON;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import java.util.Map;

/* loaded from: classes7.dex */
public class UploadData {
    private Map<String, String> extParams;
    private BioUploadResult mBioUploadResult;
    private String mOriginalData;

    public UploadData(BioUploadResult bioUploadResult) {
        this.mBioUploadResult = bioUploadResult;
        this.extParams = bioUploadResult.extParams;
        this.mOriginalData = JSON.toJSONString(this.mBioUploadResult);
    }

    public String getOriginalData() {
        return this.mOriginalData;
    }

    public BioUploadResult getBioUploadResult() {
        return this.mBioUploadResult;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UploadData{, extParams=");
        sb.append(this.extParams);
        sb.append('}');
        return sb.toString();
    }
}
