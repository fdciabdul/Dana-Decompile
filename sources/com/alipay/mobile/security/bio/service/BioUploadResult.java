package com.alipay.mobile.security.bio.service;

import com.alipay.mobile.security.bio.utils.StringUtil;
import java.util.Map;

/* loaded from: classes7.dex */
public class BioUploadResult {
    public Map<String, String> extParams;
    public String nextProtocol;
    public int validationRetCode;
    public int productRetCode = 3001;
    public String subCode = "";
    public String subMsg = "";
    public boolean hasNext = false;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BioUploadResult{productRetCode=");
        sb.append(this.productRetCode);
        sb.append(", validationRetCode=");
        sb.append(this.validationRetCode);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(", subCode=");
        sb.append(this.subCode);
        sb.append(", subMsg=");
        sb.append(this.subMsg);
        sb.append(", nextProtocol='");
        sb.append(this.nextProtocol);
        sb.append('\'');
        sb.append(", extParams=");
        Map<String, String> map = this.extParams;
        sb.append(map == null ? "null" : StringUtil.collection2String(map.keySet()));
        sb.append('}');
        return sb.toString();
    }
}
