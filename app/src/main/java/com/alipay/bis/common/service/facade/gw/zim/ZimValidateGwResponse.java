package com.alipay.bis.common.service.facade.gw.zim;

import com.alipay.mobile.security.bio.utils.StringUtil;
import java.util.Map;

/* loaded from: classes6.dex */
public class ZimValidateGwResponse {
    public Map<String, String> extParams;
    public String nextProtocol;
    public String retCodeSub;
    public String retMessageSub;
    public int validationRetCode = 0;
    public int productRetCode = 0;
    public boolean hasNext = false;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZimValidateGwResponse{validationRetCode=");
        sb.append(this.validationRetCode);
        sb.append(", productRetCode=");
        sb.append(this.productRetCode);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(", nextProtocol='");
        sb.append(this.nextProtocol);
        sb.append('\'');
        sb.append(", extParams=");
        Map<String, String> map = this.extParams;
        sb.append(map == null ? "null" : StringUtil.collection2String(map.keySet()));
        sb.append(", retCodeSub='");
        sb.append(this.retCodeSub);
        sb.append('\'');
        sb.append(", retMessageSub='");
        sb.append(this.retMessageSub);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
