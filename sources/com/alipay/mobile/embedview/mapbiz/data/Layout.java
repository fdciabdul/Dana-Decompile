package com.alipay.mobile.embedview.mapbiz.data;

import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class Layout {
    public String data;
    public JSONObject params;
    public String src;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Layout)) {
            return false;
        }
        Layout layout = (Layout) obj;
        String str = this.src;
        if (str == null ? layout.src == null : str.equals(layout.src)) {
            JSONObject jSONObject = this.params;
            if (jSONObject == null ? layout.params == null : jSONObject.equals(layout.params)) {
                String str2 = this.data;
                String str3 = layout.data;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.data;
        if (str != null) {
            return str.hashCode();
        }
        String str2 = this.src;
        if (str2 != null) {
            return str2.hashCode();
        }
        return super.hashCode();
    }

    public String toURL() {
        if (this.data == null && this.src != null) {
            JSONObject jSONObject = this.params;
            if (jSONObject == null || jSONObject.isEmpty()) {
                return this.src;
            }
            StringBuilder sb = new StringBuilder(this.src);
            sb.append('?');
            boolean z = true;
            for (Map.Entry<String, Object> entry : this.params.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(Typography.amp);
                    }
                    sb.append(entry.getKey());
                    sb.append('=');
                    sb.append(value.toString());
                }
            }
            return sb.toString();
        }
        return null;
    }
}
