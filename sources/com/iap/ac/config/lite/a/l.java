package com.iap.ac.config.lite.a;

import com.fullstory.instrumentation.InstrumentInjector;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class l {
    private static final String c = com.iap.ac.config.lite.d.e.b("Resolver");
    private static final ExecutorService d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingDeque(100), new ThreadPoolExecutor.AbortPolicy());

    /* renamed from: a  reason: collision with root package name */
    private InetSocketAddress f7624a;
    private long b = 10000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Callable<h> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f7625a;

        a(h hVar) {
            this.f7625a = hVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public h call() throws Exception {
            int a2 = this.f7625a.a().a();
            byte[] a3 = j.a(l.this.f7624a, this.f7625a.c(), l.this.b);
            if (a3 != null && a3.length >= 12) {
                int i = ((a3[0] & 255) << 8) + (a3[1] & 255);
                if (i == a2) {
                    h hVar = new h(a3);
                    if (this.f7625a.b().a() == hVar.b().a() && this.f7625a.b().b() == hVar.b().b()) {
                        return hVar;
                    }
                    throw new com.iap.ac.config.lite.a.a("invalid message");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("invalid message id: expected ");
                sb.append(a2);
                sb.append("; got id ");
                sb.append(i);
                throw new com.iap.ac.config.lite.a.a(sb.toString());
            }
            throw new com.iap.ac.config.lite.a.a("invalid DNS header - too short");
        }
    }

    public l(String str) throws UnknownHostException {
        if (str == null) {
            str = String.format(Locale.US, "ns%d.alipay.com.", Integer.valueOf(((int) (Math.random() * 4.0d)) + 1));
            String str2 = c;
            StringBuilder sb = new StringBuilder();
            sb.append("Resolver: chosen dns server is ");
            sb.append(str);
            InstrumentInjector.log_d(str2, sb.toString());
        }
        this.f7624a = new InetSocketAddress(InetAddress.getByName(str), 53);
    }

    public long a() {
        return this.b;
    }

    public Future<h> b(h hVar) {
        return d.submit(new a(hVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(h hVar) throws Exception {
        return b(hVar).get(a(), TimeUnit.MILLISECONDS);
    }
}
