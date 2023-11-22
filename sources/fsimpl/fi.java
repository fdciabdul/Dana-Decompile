package fsimpl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class fi {

    /* renamed from: o  reason: collision with root package name */
    static final /* synthetic */ boolean f7988o = !fi.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    ByteBuffer f7989a;
    int b;
    int c;
    int[] d;
    int e;
    boolean f;
    boolean g;
    int h;
    int[] i;
    int j;
    int k;
    boolean l;
    fj m;
    final fo n;

    public fi() {
        this(1024);
    }

    public fi(int i) {
        this(i, fk.f7990a, null, fo.a());
    }

    public fi(int i, fj fjVar, ByteBuffer byteBuffer, fo foVar) {
        this.c = 1;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.i = new int[16];
        this.j = 0;
        this.k = 0;
        this.l = false;
        i = i <= 0 ? 1024 : i;
        this.m = fjVar;
        if (byteBuffer != null) {
            this.f7989a = byteBuffer;
            byteBuffer.clear();
            this.f7989a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f7989a = fjVar.a(i);
        }
        this.n = foVar;
        this.b = this.f7989a.capacity();
    }

    public fi(ByteBuffer byteBuffer) {
        this(byteBuffer, new fk());
    }

    public fi(ByteBuffer byteBuffer, fj fjVar) {
        this(byteBuffer.capacity(), fjVar, byteBuffer, fo.a());
    }

    static ByteBuffer a(ByteBuffer byteBuffer, fj fjVar) {
        int capacity = byteBuffer.capacity();
        int i = 2147483639;
        if (capacity == 0) {
            i = 1024;
        } else if (capacity == 2147483639) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        } else {
            if (((-1073741824) & capacity) == 0) {
                i = capacity << 1;
            }
        }
        byteBuffer.position(0);
        ByteBuffer a2 = fjVar.a(i);
        a2.position(a2.clear().capacity() - capacity);
        a2.put(byteBuffer);
        return a2;
    }

    public int a() {
        return this.f7989a.capacity() - this.b;
    }

    public int a(CharSequence charSequence) {
        int a2 = this.n.a(charSequence);
        b((byte) 0);
        a(1, a2, 1);
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - a2;
        this.b = i;
        byteBuffer.position(i);
        this.n.a(charSequence, this.f7989a);
        return b();
    }

    public int a(byte[] bArr) {
        int length = bArr.length;
        a(1, length, 1);
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - length;
        this.b = i;
        byteBuffer.position(i);
        this.f7989a.put(bArr);
        return b();
    }

    public void a(byte b) {
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, b);
    }

    public void a(double d) {
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putDouble(i, d);
    }

    public void a(float f) {
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - 4;
        this.b = i;
        byteBuffer.putFloat(i, f);
    }

    public void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.f7989a;
            int i3 = this.b - 1;
            this.b = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    public void a(int i, byte b, int i2) {
        if (this.l || b != i2) {
            b(b);
            g(i);
        }
    }

    public void a(int i, double d, double d2) {
        if (this.l || d != d2) {
            b(d);
            g(i);
        }
    }

    public void a(int i, float f, double d) {
        if (this.l || f != d) {
            b(f);
            g(i);
        }
    }

    public void a(int i, int i2) {
        if (i > this.c) {
            this.c = i;
        }
        int capacity = ((((this.f7989a.capacity() - this.b) + i2) ^ (-1)) + 1) & (i - 1);
        while (this.b < capacity + i + i2) {
            int capacity2 = this.f7989a.capacity();
            ByteBuffer byteBuffer = this.f7989a;
            ByteBuffer a2 = a(byteBuffer, this.m);
            this.f7989a = a2;
            if (byteBuffer != a2) {
                this.m.a(byteBuffer);
            }
            this.b += this.f7989a.capacity() - capacity2;
        }
        a(capacity);
    }

    public void a(int i, int i2, int i3) {
        c();
        this.k = i2;
        int i4 = i * i2;
        a(4, i4);
        a(i3, i4);
        this.f = true;
    }

    public void a(int i, long j, long j2) {
        if (this.l || j != j2) {
            b(j);
            g(i);
        }
    }

    public void a(int i, short s, int i2) {
        if (this.l || s != i2) {
            b(s);
            g(i);
        }
    }

    protected void a(int i, boolean z) {
        a(this.c, (z ? 4 : 0) + 4);
        d(i);
        if (z) {
            c(this.f7989a.capacity() - this.b);
        }
        this.f7989a.position(this.b);
        this.g = true;
    }

    public void a(int i, boolean z, boolean z2) {
        if (this.l || z != z2) {
            b(z);
            g(i);
        }
    }

    public void a(long j) {
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putLong(i, j);
    }

    public void a(short s) {
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s);
    }

    public void a(boolean z) {
        ByteBuffer byteBuffer = this.f7989a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
    }

    public int b() {
        if (this.f) {
            this.f = false;
            b(this.k);
            return a();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public void b(byte b) {
        a(1, 0);
        a(b);
    }

    public void b(double d) {
        a(8, 0);
        a(d);
    }

    public void b(float f) {
        a(4, 0);
        a(f);
    }

    public void b(int i) {
        ByteBuffer byteBuffer = this.f7989a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
    }

    public void b(int i, int i2, int i3) {
        if (this.l || i2 != i3) {
            c(i2);
            g(i);
        }
    }

    public void b(long j) {
        a(8, 0);
        a(j);
    }

    public void b(short s) {
        a(2, 0);
        a(s);
    }

    public void b(boolean z) {
        a(1, 0);
        a(z);
    }

    public fi c(boolean z) {
        this.l = z;
        return this;
    }

    public void c() {
        if (this.f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public void c(int i) {
        a(4, 0);
        b(i);
    }

    public void c(int i, int i2, int i3) {
        if (this.l || i2 != i3) {
            d(i2);
            g(i);
        }
    }

    public int d() {
        int i;
        int i2;
        if (this.d == null || !this.f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        c(0);
        int a2 = a();
        int i3 = this.e - 1;
        while (i3 >= 0 && this.d[i3] == 0) {
            i3--;
        }
        for (int i4 = i3; i4 >= 0; i4--) {
            int[] iArr = this.d;
            b((short) (iArr[i4] != 0 ? a2 - iArr[i4] : 0));
        }
        b((short) (a2 - this.h));
        b((short) ((i3 + 1 + 2) * 2));
        int i5 = 0;
        loop2: while (true) {
            if (i5 >= this.j) {
                i = 0;
                break;
            }
            int capacity = this.f7989a.capacity() - this.i[i5];
            int i6 = this.b;
            short s = this.f7989a.getShort(capacity);
            if (s == this.f7989a.getShort(i6)) {
                while (i2 < s) {
                    i2 = this.f7989a.getShort(capacity + i2) == this.f7989a.getShort(i6 + i2) ? i2 + 2 : 2;
                }
                i = this.i[i5];
                break loop2;
            }
            i5++;
        }
        if (i != 0) {
            int capacity2 = this.f7989a.capacity() - a2;
            this.b = capacity2;
            this.f7989a.putInt(capacity2, i - a2);
        } else {
            int i7 = this.j;
            int[] iArr2 = this.i;
            if (i7 == iArr2.length) {
                this.i = Arrays.copyOf(iArr2, i7 * 2);
            }
            int[] iArr3 = this.i;
            int i8 = this.j;
            this.j = i8 + 1;
            iArr3[i8] = a();
            ByteBuffer byteBuffer = this.f7989a;
            byteBuffer.putInt(byteBuffer.capacity() - a2, a() - a2);
        }
        this.f = false;
        return a2;
    }

    public void d(int i) {
        a(4, 0);
        if (!f7988o && i > a()) {
            throw new AssertionError();
        }
        b((a() - i) + 4);
    }

    public void d(int i, int i2, int i3) {
        if (i2 != i3) {
            e(i2);
            g(i);
        }
    }

    public void e(int i) {
        if (i != a()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void f(int i) {
        c();
        int[] iArr = this.d;
        if (iArr == null || iArr.length < i) {
            this.d = new int[i];
        }
        this.e = i;
        Arrays.fill(this.d, 0, i, 0);
        this.f = true;
        this.h = a();
    }

    public void g(int i) {
        this.d[i] = a();
    }

    public void h(int i) {
        a(i, false);
    }
}
