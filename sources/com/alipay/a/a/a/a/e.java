package com.alipay.a.a.a.a;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* loaded from: classes3.dex */
public final class e extends a {
    public static final byte[] MyBillsEntityDataFactory = {96, 83, 72, -80, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 106;
    private c g;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.a.a.a.a.e.MyBillsEntityDataFactory
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r8 = r8 * 12
            int r8 = 15 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L3a
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L3a:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.a.a.a.a.e.h(short, byte, int, java.lang.Object[]):void");
    }

    public e(c cVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.g = cVar;
    }

    @Override // com.alipay.a.a.a.a.q
    public final Object a() {
        j jVar = new j(this.g.a());
        jVar.b = this.b;
        jVar.c = this.e;
        jVar.e = this.f;
        jVar.a("id", String.valueOf(this.d));
        jVar.a("operationType", this.c);
        jVar.a(HeaderConstant.HEADER_VALUE_CONTENT_ENCODING_GZIP, String.valueOf(this.g.d()));
        jVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> list = this.g.c().b;
        if (list != null && !list.isEmpty()) {
            Iterator<Header> it = list.iterator();
            while (it.hasNext()) {
                jVar.a(it.next());
            }
        }
        StringBuilder sb = new StringBuilder("threadid = ");
        try {
            int i = 15;
            byte b = (byte) (-MyBillsEntityDataFactory[15]);
            byte b2 = b;
            Object[] objArr = new Object[1];
            h(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[15] + 1);
            Object[] objArr2 = new Object[1];
            h(b3, b3, (byte) (-MyBillsEntityDataFactory[15]), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            sb.append("; ");
            sb.append(jVar.toString());
            InstrumentInjector.log_i("HttpCaller", sb.toString());
            try {
                p pVar = this.g.b().a(jVar).get();
                if (pVar == null) {
                    throw new s(9, "response is null");
                }
                return pVar.a();
            } catch (InterruptedException e) {
                throw new s(13, "", e);
            } catch (CancellationException e2) {
                throw new s(13, "", e2);
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause != null && (cause instanceof g)) {
                    g gVar = (g) cause;
                    int i2 = gVar.f6830a;
                    switch (i2) {
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 3;
                            break;
                        case 3:
                            i = 4;
                            break;
                        case 4:
                            i = 5;
                            break;
                        case 5:
                            i = 6;
                            break;
                        case 6:
                            i = 7;
                            break;
                        case 7:
                            i = 8;
                            break;
                        case 8:
                            break;
                        case 9:
                            i = 16;
                            break;
                        default:
                            i = i2;
                            break;
                    }
                    throw new s(Integer.valueOf(i), gVar.b);
                }
                throw new s(9, "", e3);
            }
        } catch (Throwable th) {
            Throwable cause2 = th.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th;
        }
    }
}
