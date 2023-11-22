package com.iap.ac.config.lite.a;

import java.text.DecimalFormat;

/* loaded from: classes3.dex */
public abstract class k {
    private static final DecimalFormat d;

    /* renamed from: a  reason: collision with root package name */
    protected i f7623a;
    protected int b;
    protected int c;

    static {
        com.iap.ac.config.lite.d.e.b("Record");
        DecimalFormat decimalFormat = new DecimalFormat();
        d = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    private static k a(i iVar, int i, int i2, long j, boolean z) {
        k eVar;
        if (z && i == 16) {
            eVar = new m();
        } else {
            eVar = new e();
        }
        eVar.f7623a = iVar;
        eVar.b = i;
        eVar.c = i2;
        return eVar;
    }

    abstract void a(b bVar) throws Exception;

    public int b() {
        return this.b;
    }

    private static k a(i iVar, int i, int i2, long j, int i3, b bVar) throws Exception {
        k a2 = a(iVar, i, i2, j, bVar != null);
        if (bVar != null) {
            if (bVar.g() >= i3) {
                bVar.c(i3);
                a2.a(bVar);
                if (bVar.g() <= 0) {
                    bVar.a();
                } else {
                    throw new a("invalid record length");
                }
            } else {
                throw new a("truncated record");
            }
        }
        return a2;
    }

    public static k a(i iVar, int i, int i2, long j) throws Exception {
        if (iVar.isAbsolute()) {
            d.a(j);
            return a(iVar, i, i2, j, false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("'");
        sb.append(iVar);
        sb.append("' is not an absolute name");
        throw new a(sb.toString());
    }

    public static k a(i iVar, int i, int i2) throws Exception {
        return a(iVar, i, i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(b bVar, int i, boolean z) throws Exception {
        i iVar = new i(bVar);
        int d2 = bVar.d();
        int d3 = bVar.d();
        if (i == 0) {
            return a(iVar, d2, d3);
        }
        long e = bVar.e();
        int d4 = bVar.d();
        if (d4 == 0 && z && (i == 1 || i == 2)) {
            return a(iVar, d2, d3, e);
        }
        return a(iVar, d2, d3, e, d4, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f7623a.toWire(cVar);
        cVar.a(this.b);
        cVar.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 32 || i >= 127) {
                sb.append('\\');
                sb.append(d.format(i));
            } else if (i != 34 && i != 92) {
                sb.append((char) i);
            } else {
                sb.append('\\');
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    public int a() {
        return this.c;
    }
}
