package com.alipay.bis.common.service.facade.gw.zim;

import com.alipay.mobile.security.bio.utils.StringUtil;
import java.util.Map;

/* loaded from: classes6.dex */
public class ZimInitGwResponse {
    public Map<String, String> extParams;
    public String message;
    public String protocol;
    public int retCode = 0;
    public String retCodeSub;
    public String retMessageSub;
    public String zimId;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZimInitGwResponse{retCode=");
        sb.append(this.retCode);
        sb.append(", message='");
        sb.append(this.message);
        sb.append('\'');
        sb.append(", zimId='");
        sb.append(this.zimId);
        sb.append('\'');
        sb.append(", protocol='");
        sb.append(this.protocol);
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
