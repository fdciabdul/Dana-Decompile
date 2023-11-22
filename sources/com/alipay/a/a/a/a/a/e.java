package com.alipay.a.a.a.a.a;

import com.alipay.a.a.a.a.s;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.here.HereOauthManager;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes3.dex */
public final class e extends b {
    private int c;
    private Object d;

    public e(int i, String str, Object obj) {
        super(str, obj);
        this.c = i;
    }

    @Override // com.alipay.a.a.a.a.a.f
    public final void a(Object obj) {
        this.d = obj;
    }

    @Override // com.alipay.a.a.a.a.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.b.a.f.a(this.d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f6819a));
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            arrayList.add(new BasicNameValuePair("id", sb.toString()));
            StringBuilder sb2 = new StringBuilder("mParams is:");
            sb2.append(this.b);
            InstrumentInjector.log_d("JsonSerializer", sb2.toString());
            arrayList.add(new BasicNameValuePair("requestData", this.b == null ? "[]" : com.alipay.b.a.f.a(this.b)));
            String format = URLEncodedUtils.format(arrayList, HereOauthManager.ENC);
            StringBuilder sb3 = new StringBuilder("request = ");
            sb3.append(format);
            InstrumentInjector.log_i("JsonSerializer", sb3.toString());
            return format.getBytes();
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder("request  =");
            sb4.append(this.b);
            sb4.append(":");
            sb4.append(e);
            throw new s(9, sb4.toString() == null ? "" : e.getMessage(), e);
        }
    }
}
