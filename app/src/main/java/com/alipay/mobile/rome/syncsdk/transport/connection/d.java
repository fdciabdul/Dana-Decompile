package com.alipay.mobile.rome.syncsdk.transport.connection;

import com.alipay.mobile.rome.syncsdk.util.SyncThreadManager;
import com.alipay.mobile.rome.syncsdk.util.j;
import java.io.DataInputStream;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7256a = "d";
    public Thread b;
    public volatile boolean c = false;
    private DataInputStream d;
    private a e;

    public d(a aVar) {
        this.e = aVar;
        this.d = aVar.c;
        e eVar = new e(this);
        this.b = eVar;
        eVar.setName("longLink Packet Reader");
        this.b.setDaemon(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(d dVar) {
        com.alipay.mobile.rome.syncsdk.util.c.b(f7256a, "parsePackets: reader ");
        while (!dVar.c) {
            try {
                byte[] bArr = new byte[com.alipay.mobile.rome.syncsdk.transport.b.b.c];
                dVar.d.readFully(bArr, 0, com.alipay.mobile.rome.syncsdk.transport.b.b.c);
                com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(dVar.e.f);
                a2.c(bArr);
                int c = a2.c();
                String str = f7256a;
                StringBuilder sb = new StringBuilder("parsePackets: reader dataLen:");
                sb.append(c);
                com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
                if (c < 0 || c > 10485760) {
                    StringBuilder sb2 = new StringBuilder("parsePackets dataLen exception [ dataLen=");
                    sb2.append(c);
                    sb2.append(" ][");
                    sb2.append(a2.f());
                    sb2.append("]");
                    throw new Exception(sb2.toString());
                }
                byte[] bArr2 = new byte[c];
                dVar.d.readFully(bArr2, 0, c);
                if (a2.d() == 1) {
                    a2.b(bArr2);
                } else {
                    a2.a(bArr2);
                }
                com.alipay.mobile.rome.syncsdk.util.c.a(str, "recvPacket: reader  ");
                if (!com.alipay.mobile.rome.syncsdk.transport.b.a.a(a2)) {
                    com.alipay.mobile.rome.syncsdk.util.c.d(str, "recvPacket: it's unsupported packet!");
                } else {
                    a aVar = dVar.e;
                    if (aVar.f7253a != null && aVar.f7253a.b(a2)) {
                        j.f7269a.a(SyncThreadManager.ThreadType.SYNC_RECEIVE, new b(aVar, a2));
                    }
                }
            } catch (Throwable th) {
                String str2 = f7256a;
                StringBuilder sb3 = new StringBuilder("parsePackets: [ link is disconnected ][ Exception=");
                sb3.append(th);
                sb3.append(" ][ isDone=");
                sb3.append(dVar.c);
                sb3.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb3.toString());
                if (dVar.c) {
                    return;
                }
                dVar.c = true;
                dVar.e.a(th);
                return;
            }
        }
    }
}
