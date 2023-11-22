package com.alipay.plus.security.lite.b;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.plus.security.lite.SecureLiteSignatureDefine;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7406a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(SecureLiteSignatureDefine.TAG);
        sb.append("a");
        f7406a = sb.toString();
    }

    public static String a(Context context, String str, String str2) {
        String str3;
        try {
            String b = b.b(context, SecureLiteSignatureDefine.FULL_KEY_SECURITY_LITE_CONFIG);
            if (b != null) {
                JSONObject jSONObject = new JSONObject(b);
                StringBuilder sb = new StringBuilder();
                sb.append("apiKey_");
                sb.append(str);
                str3 = jSONObject.optString(sb.toString(), "");
            } else {
                str3 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(SecureLiteSignatureDefine.API_KEY);
                sb2.append(str);
                return c.a(context, sb2.toString(), "");
            }
            return str3;
        } catch (Throwable th) {
            d.a(f7406a, th.getMessage());
            return str2;
        }
    }
}
