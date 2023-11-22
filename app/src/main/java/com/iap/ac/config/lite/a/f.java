package com.iap.ac.config.lite.a;

import java.security.SecureRandom;
import java.util.Random;

/* loaded from: classes3.dex */
public class f implements Cloneable {
    private static final Random d = new SecureRandom();

    /* renamed from: a  reason: collision with root package name */
    private int f7619a;
    private int b;
    private int[] c;

    public f(int i) {
        this();
        e(i);
    }

    private static void g(int i) {
        if (h(i)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("invalid flag bit ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static boolean h(int i) {
        return i >= 0 && i <= 15 && d.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        cVar.a(a());
        cVar.a(this.b);
        for (int i : this.c) {
            cVar.a(i);
        }
    }

    public boolean b(int i) {
        g(i);
        return ((1 << (15 - i)) & this.b) != 0;
    }

    public int c() {
        return this.b & 15;
    }

    public void d(int i) {
        g(i);
        this.b = a(this.b, i);
    }

    public void e(int i) {
        if (i >= 0 && i <= 65535) {
            this.f7619a = i;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DNS message ID ");
        sb.append(i);
        sb.append(" is out of range");
        throw new IllegalArgumentException(sb.toString());
    }

    public void f(int i) {
        if (i >= 0 && i <= 15) {
            this.b = (i << 11) | (this.b & 34815);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DNS Opcode ");
        sb.append(i);
        sb.append("is out of range");
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        int[] iArr = this.c;
        int i2 = iArr[i];
        if (i2 != 65535) {
            iArr[i] = i2 + 1;
            return;
        }
        throw new IllegalStateException("DNS section count cannot be incremented");
    }

    public f() {
        this.c = new int[4];
        this.b = 0;
        this.f7619a = -1;
    }

    public int b() {
        return (this.b >> 11) & 15;
    }

    static int a(int i, int i2) {
        g(i2);
        return i | (1 << (15 - i2));
    }

    public int a() {
        int i;
        Random random = d;
        synchronized (random) {
            if (this.f7619a < 0) {
                this.f7619a = random.nextInt(65535);
            }
            i = this.f7619a;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) throws Exception {
        this(bVar.d());
        this.b = bVar.d();
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = bVar.d();
            i++;
        }
    }

    public int a(int i) {
        return this.c[i];
    }
}
