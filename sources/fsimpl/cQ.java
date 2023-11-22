package fsimpl;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class cQ {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f7901a;
    private int b;

    public cQ(ByteBuffer byteBuffer) {
        this.f7901a = byteBuffer;
        a();
    }

    private void a(byte b) {
        cR.a(b, (byte) 1);
        b(b);
    }

    private void a(byte b, float f) {
        if (f == 0.0f) {
            return;
        }
        cR.a(b, (byte) 6);
        b(b);
        e(f);
    }

    private void a(byte b, int i) {
        cR.a(b, (byte) 0);
        b(b);
        u(i);
    }

    private void a(byte b, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        cR.a(b, (byte) 9);
        b(b);
        v(i);
        v(i2);
    }

    private void a(byte b, int i, int i2, int i3, int i4) {
        cR.a(b, (byte) 8);
        b(b);
        v(i);
        v(i2);
        v(i3);
        v(i4);
    }

    private void b(byte b) {
        if (this.f7901a.position() != 0) {
            c(cR.a(b));
        } else if (b != 0) {
            throw new IllegalStateException("First token written must be OP");
        }
    }

    private void b(byte b, int i) {
        if (i == 0) {
            return;
        }
        cR.a(b, (byte) 5);
        b(b);
        t(i);
    }

    private void c(byte b) {
        this.f7901a.put(b);
    }

    private void c(byte b, int i) {
        if (i == 0) {
            return;
        }
        cR.a(b, (byte) 2);
        b(b);
        u(i);
    }

    private void d(byte b, int i) {
        if (i == 0) {
            return;
        }
        cR.a(b, (byte) 3);
        b(b);
        v(i);
    }

    private void d(float f) {
        byte b;
        int floatToIntBits = Float.floatToIntBits(f);
        if (floatToIntBits == 0) {
            b = Byte.MAX_VALUE;
        } else if (floatToIntBits == 1065353216) {
            b = -1;
        } else if (floatToIntBits == -1082130432) {
            b = -2;
        } else {
            if ((65535 & floatToIntBits) == 0) {
                c((byte) 126);
                c((byte) (floatToIntBits >> 24));
                floatToIntBits >>= 16;
            } else {
                c((byte) (floatToIntBits >> 24));
                c((byte) (floatToIntBits >> 16));
                c((byte) (floatToIntBits >> 8));
            }
            b = (byte) floatToIntBits;
        }
        c(b);
    }

    private void e(byte b, int i) {
        byte b2;
        byte b3;
        if (i == 0) {
            return;
        }
        cR.a(b, (byte) 4);
        b(b);
        boolean z = false;
        if (i == this.b) {
            c((byte) 0);
        } else if (i == -16777216) {
            c((byte) 1);
        } else {
            if (i == -1) {
                b3 = 2;
            } else {
                int i2 = (i >> 24) & 255;
                int i3 = (i >> 16) & 255;
                int i4 = (i >> 8) & 255;
                int i5 = i & 255;
                if (i3 == i4 && i4 == i5) {
                    z = true;
                }
                this.b = i;
                if (i2 == 255) {
                    if (z) {
                        b2 = 3;
                        c(b2);
                        b3 = (byte) i3;
                    } else {
                        c((byte) 4);
                        c((byte) i3);
                        c((byte) i4);
                        b3 = (byte) i5;
                    }
                } else if (!z) {
                    if (i2 <= 7) {
                        c((byte) 7);
                    }
                    c((byte) i2);
                    c((byte) i3);
                    c((byte) i4);
                    b3 = (byte) i5;
                } else if (i3 == 0) {
                    c((byte) 5);
                    b3 = (byte) i2;
                } else {
                    c((byte) 6);
                    b2 = (byte) i2;
                    c(b2);
                    b3 = (byte) i3;
                }
            }
            c(b3);
        }
    }

    private void e(float f) {
        v((int) (f * 256.0f));
    }

    private static int s(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private void t(int i) {
        c((byte) (i & 255));
        int i2 = i >> 8;
        c((byte) (i2 & 255));
        int i3 = i2 >> 8;
        c((byte) (i3 & 255));
        c((byte) ((i3 >> 8) & 255));
    }

    private void u(int i) {
        while ((i & (-128)) != 0) {
            c((byte) ((i & 127) | 128));
            i >>>= 7;
        }
        c((byte) i);
    }

    private void v(int i) {
        u(s(i));
    }

    public void a() {
        this.f7901a.clear();
        this.b = -1728053248;
    }

    public void a(byte b, float[] fArr) {
        cR.a(b, (byte) 11);
        b(b);
        for (float f : fArr) {
            d(f);
        }
    }

    public void a(float f) {
        a(Ascii.NAK, f);
    }

    public void a(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        b((byte) 15);
        d(f);
        d(f2);
    }

    public void a(float f, float f2, float f3, float f4) {
        a((int) f, (int) f2, (int) f3, (int) f4);
    }

    public void a(int i) {
        c(Ascii.DC4, i);
    }

    public void a(int i, int i2) {
        a((byte) 14, i, i2);
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i == 0 && i2 == 0) {
            a((byte) 7, i5, i6);
        } else {
            a((byte) 6, i, i2, i5, i6);
        }
    }

    public void a(short s) {
        a((byte) 0, (int) s);
    }

    public void a(float[] fArr) {
        a((byte) 87, fArr);
    }

    public ByteBuffer b() {
        return this.f7901a;
    }

    public void b(float f) {
        a((byte) 88, f);
    }

    public void b(float f, float f2, float f3, float f4) {
        b((int) f, (int) f2, (int) f3, (int) f4);
    }

    public void b(int i) {
        c((byte) 13, i);
    }

    public void b(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i == 0 && i2 == 0) {
            a((byte) 5, i5, i6);
        } else {
            a((byte) 4, i, i2, i5, i6);
        }
    }

    public void c() {
        ByteBuffer byteBuffer = this.f7901a;
        byteBuffer.limit(byteBuffer.position());
        this.f7901a.position(0);
    }

    public void c(float f) {
        a((byte) 93, f);
    }

    public void c(int i) {
        c(Ascii.ESC, i);
    }

    public void c(int i, int i2, int i3, int i4) {
        a((byte) 91, i3 - i, i4 - i2);
    }

    public void d() {
        a((byte) 82);
    }

    public void d(int i) {
        d((byte) 2, i);
    }

    public void e() {
        a((byte) 92);
    }

    public void e(int i) {
        c((byte) 8, i);
    }

    public void f(int i) {
        b((byte) 22, i);
    }

    public boolean f() {
        return this.f7901a.remaining() < 256;
    }

    public void g(int i) {
        e((byte) 81, i);
    }

    public void h(int i) {
        c((byte) 89, i);
    }

    public void i(int i) {
        c((byte) 80, i);
    }

    public void j(int i) {
        c((byte) 86, i);
    }

    public void k(int i) {
        e((byte) 83, i);
    }

    public void l(int i) {
        c((byte) 84, i);
    }

    public void m(int i) {
        c((byte) 94, i);
    }

    public void n(int i) {
        c((byte) 90, i);
    }

    public void o(int i) {
        c((byte) 85, i);
    }

    public void p(int i) {
        c((byte) 95, i);
    }

    public void q(int i) {
        c((byte) 96, i);
    }

    public void r(int i) {
        c((byte) 97, i);
    }
}
