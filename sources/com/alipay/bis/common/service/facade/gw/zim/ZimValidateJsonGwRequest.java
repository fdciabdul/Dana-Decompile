package com.alipay.bis.common.service.facade.gw.zim;

import com.alipay.mobile.security.bio.utils.StringUtil;
import java.util.Map;

/* loaded from: classes6.dex */
public class ZimValidateJsonGwRequest {
    public Map<String, String> bizData;
    public String zimData;
    public String zimId;

    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder();
        sb.append("ZimValidateJsonGwRequest{zimId='");
        sb.append(this.zimId);
        sb.append("', data='");
        if (this.zimData == null) {
            obj = "null";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[length=");
            sb2.append(this.zimData.length());
            sb2.append("]");
            obj = sb2.toString();
        }
        sb.append(obj);
        sb.append("', bizData='");
        sb.append(StringUtil.map2String(this.bizData));
        sb.append("'");
        sb.append('}');
        return sb.toString();
    }
}
