package com.alipay.alipaysecuritysdk.rds.v2.b;

import android.content.Context;
import com.alipay.alipaysecuritysdk.rds.v2.face.RDSClient;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.lang.Thread;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class h extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6887a = {SecurityConstants.KEY_TEXT, "data"};
    private Map<String, Object> b;
    private String c;
    private LinkedList<a> d;
    private Thread e;

    static /* synthetic */ Thread c(h hVar) {
        hVar.e = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        String f6890a = "";
        private Context c;

        public a(Context context) {
            this.c = context;
        }
    }

    public h() {
        this((byte) 0);
    }

    private h(byte b) {
        this.c = "";
        this.d = new LinkedList<>();
        this.b = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        this.b.put("data", this.c);
        for (String str : f6887a) {
            Object obj = this.b.get(str);
            if (obj != null && (obj instanceof String)) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException e) {
                    com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-rds", e);
                }
            } else if (obj != null && (obj instanceof b)) {
                try {
                    jSONObject.put(str, ((b) obj).a());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }

    public final void a(Context context) {
        synchronized (this) {
            this.b.put(SecurityConstants.KEY_TEXT, String.valueOf(System.currentTimeMillis()));
            this.b.put("data", this.c);
            if (this.d.isEmpty()) {
                this.d.addLast(new a(context));
                if (this.e == null) {
                    Thread thread = new Thread(new Runnable() { // from class: com.alipay.alipaysecuritysdk.rds.v2.b.h.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            while (!h.this.d.isEmpty()) {
                                try {
                                    a aVar = (a) h.this.d.pollFirst();
                                    if (aVar != null) {
                                        h.this.c = aVar.f6890a;
                                        if (RDSClient.isDebug()) {
                                            String unused = h.this.c;
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                            h.c(h.this);
                        }
                    });
                    this.e = thread;
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.alipay.alipaysecuritysdk.rds.v2.b.h.2
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public final void uncaughtException(Thread thread2, Throwable th) {
                        }
                    });
                    this.e.start();
                }
            }
        }
    }
}
