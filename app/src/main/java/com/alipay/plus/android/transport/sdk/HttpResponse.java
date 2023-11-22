package com.alipay.plus.android.transport.sdk;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class HttpResponse implements Serializable {
    public final byte[] data;
    public final Map<String, List<String>> headers;
    public final int statusCode;
    public final String statusMessage;

    public HttpResponse(int i, String str, byte[] bArr, Map<String, List<String>> map) {
        this.statusCode = i;
        this.statusMessage = str;
        this.data = bArr;
        this.headers = map;
    }

    private String getDataString() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr);
        } catch (Exception unused) {
            return Arrays.toString(this.data);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"statusCode\": ");
        sb.append(this.statusCode);
        sb.append(",\"statusMessage\": \"");
        sb.append(this.statusMessage);
        sb.append("\",\"data\": ");
        sb.append(getDataString());
        sb.append(",\"headers\": ");
        sb.append(JSON.toJSONString(this.headers));
        sb.append("}");
        return sb.toString();
    }
}
