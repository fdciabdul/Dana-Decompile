package fsimpl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* renamed from: fsimpl.be  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0254be implements InterfaceC0253bd {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7885a;
    private static final byte[] b = {0, 1, 2, 4, 5, 0, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static final byte[] c = {32, 104, 116, 112};
    private static final C0255bf d;
    private static final C0255bf e;
    private static final C0255bf[] f;
    private static final byte[] g;
    private static final byte[] h;
    private static final byte[] i;
    private static boolean x;
    private static final Paint y;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private int f7886o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private Picture u;
    private ByteArrayOutputStream v = new ByteArrayOutputStream();
    private RectF w = new RectF();

    static {
        byte[] bArr = {0, 1, 2, 4, 5, 0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        f7885a = bArr;
        d = new C0255bf(false, true, bArr);
        C0255bf c0255bf = new C0255bf(true, true, b);
        e = c0255bf;
        f = new C0255bf[]{d, c0255bf};
        g = new byte[]{Ascii.FS, 0, 0, 0};
        h = new byte[]{Ascii.US, 0, 0, 0};
        i = new byte[]{0, 0, Byte.MIN_VALUE, 63, 0, 0, 0, SignedBytes.MAX_POWER_OF_TWO, 0, 0, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 0, 0, Byte.MIN_VALUE, SignedBytes.MAX_POWER_OF_TWO};
        x = true;
        Paint paint = new Paint();
        y = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0254be() {
        c(a(b()));
    }

    private byte a(byte b2) {
        return (this.q || b2 < 3) ? b2 : (byte) (b2 + 1);
    }

    private static int a(int i2, int i3) {
        return i2 == -1 ? i3 == -1 ? -1 : 1 : (i3 != -1 && i2 >= i3) ? 1 : 0;
    }

    private static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private int a(byte[] bArr, fi fiVar) {
        int i2 = this.j;
        byte b2 = bArr[i2];
        byte[] bArr2 = c;
        int i3 = 0;
        if (b2 != bArr2[0] || bArr[i2 + 1] != bArr2[1] || bArr[i2 + 2] != bArr2[2] || bArr[i2 + 3] != bArr2[3]) {
            Log.i("Path failed sanity check");
            d(bArr);
            return 0;
        }
        int a2 = a(bArr, this.k);
        int a3 = a(bArr, this.l);
        int i4 = this.m;
        int a4 = i4 != -1 ? a(bArr, i4) : 0;
        if (a2 < 0 || a3 < 0 || a4 < 0) {
            Log.i(String.format("Path failed sanity check: points=%d verbs=%d", Integer.valueOf(a2), Integer.valueOf(a3)));
            d(bArr);
            return 0;
        } else if (a2 > 200 || a3 > 200 || a4 > 50) {
            Log.i(String.format("Path failed sanity check: points=%d verbs=%d", Integer.valueOf(a2), Integer.valueOf(a3)));
            d(bArr);
            return 0;
        } else {
            int i5 = this.n;
            int i6 = this.f7886o;
            int i7 = this.p;
            if (this.s) {
                i6 += a2 * 8;
            } else {
                i5 += a3 * 1;
            }
            if (i7 != -1) {
                i7 += (a2 * 8) + (a3 * 1);
            }
            int i8 = a2 * 2;
            C0297cu.d(fiVar, i8);
            for (int i9 = i8 - 1; i9 >= 0; i9--) {
                fiVar.b(b(bArr, (i9 * 4) + i5));
            }
            int b3 = fiVar.b();
            C0297cu.b(fiVar, a3);
            if (this.r) {
                for (int i10 = 0; i10 < a3; i10++) {
                    byte a5 = a(bArr[i6 + i10]);
                    if (a5 < 0 || a5 > 6) {
                        Log.i(String.format("Path failed sanity check: verb=%d", Byte.valueOf(a5)));
                        d(bArr);
                        fiVar.b();
                        return 0;
                    }
                    fiVar.b(a5);
                }
            } else {
                for (int i11 = a3 - 1; i11 >= 0; i11--) {
                    byte a6 = a(bArr[i6 + i11]);
                    if (a6 < 0 || a6 > 6) {
                        Log.i(String.format("Path failed sanity check: verb=%d", Byte.valueOf(a6)));
                        d(bArr);
                        fiVar.b();
                        return 0;
                    }
                    fiVar.b(a6);
                }
            }
            int b4 = fiVar.b();
            if (a4 > 0 && i7 != -1) {
                C0297cu.f(fiVar, a4);
                for (int i12 = a4 - 1; i12 >= 0; i12--) {
                    fiVar.b(b(bArr, (i12 * 4) + i7));
                }
                i3 = fiVar.b();
            }
            return C0297cu.a(fiVar, b4, b3, i3);
        }
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        r7 = r7 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(byte[] r5, byte[] r6, int r7) {
        /*
            int r0 = r6.length
            int r1 = r5.length
            r2 = -1
            if (r0 >= r1) goto L6
            return r2
        L6:
            int r0 = r5.length
            int r0 = r0 + (-1)
            int r7 = r7 + r0
        La:
            int r1 = r6.length
            if (r7 >= r1) goto L21
            r1 = r0
        Le:
            if (r1 < 0) goto L1f
            int r3 = r7 - r0
            int r3 = r3 + r1
            r3 = r6[r3]
            r4 = r5[r1]
            if (r3 == r4) goto L1c
            int r7 = r7 + 1
            goto La
        L1c:
            int r1 = r1 + (-1)
            goto Le
        L1f:
            int r7 = r7 - r0
            return r7
        L21:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0254be.a(byte[], byte[], int):int");
    }

    private byte[] a(Path path) {
        if (this.u == null) {
            this.u = new Picture();
        }
        Canvas beginRecording = this.u.beginRecording(128, 128);
        beginRecording.drawPath(path, y);
        beginRecording.saveLayer(0.0f, 0.0f, 0.0f, 0.0f, null, 31);
        this.u.endRecording();
        this.u.writeToStream(this.v);
        byte[] byteArray = this.v.toByteArray();
        this.v.reset();
        return byteArray;
    }

    private static float b(byte[] bArr, int i2) {
        return Float.intBitsToFloat(a(bArr, i2));
    }

    static Path b() {
        Path path = new Path();
        path.moveTo(1.0f, 2.0f);
        path.lineTo(3.0f, 4.0f);
        path.quadTo(5.0f, 6.0f, 7.0f, 8.0f);
        path.cubicTo(9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f);
        path.close();
        path.arcTo(15.0f, 16.0f, 17.0f, 18.0f, 0.0f, 90.0f, false);
        for (int i2 = 0; i2 < 20; i2++) {
            float f2 = i2;
            path.lineTo(f2, f2);
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i2 = 0; length > i2; i2++) {
            byte b2 = bArr[length];
            bArr[length] = bArr[i2];
            bArr[i2] = b2;
            length--;
        }
    }

    private void c(byte[] bArr) {
        String str;
        this.t = false;
        int a2 = a(c, bArr);
        this.j = a2;
        if (a2 == -1) {
            str = "Unable to locate path marker";
        } else {
            byte[] bArr2 = h;
            byte[] bArr3 = g;
            this.k = a(bArr2, bArr, a2 + 4);
            int a3 = a(bArr3, bArr, this.j + 4);
            this.l = a3;
            int i2 = this.k;
            if (i2 == -1 || a3 == -1) {
                str = "Unable to locate point/verb counts";
            } else {
                int max = Math.max(i2, a3) + 4;
                this.m = max;
                char c2 = 1;
                if (a(bArr, max) != 1) {
                    this.m = -1;
                }
                int max2 = Math.max(this.k, this.l) + 4;
                int a4 = a(i, bArr, max2);
                this.n = a4;
                if (a4 == -1) {
                    str = "Unable to locate points";
                } else {
                    this.f7886o = -1;
                    C0255bf[] c0255bfArr = f;
                    int length = c0255bfArr.length;
                    int i3 = 0;
                    while (i3 < length) {
                        C0255bf c0255bf = c0255bfArr[i3];
                        byte[][] bArr4 = new byte[2];
                        bArr4[0] = c0255bf.c;
                        bArr4[c2] = c0255bf.d;
                        int i4 = 0;
                        for (int i5 = 2; i4 < i5; i5 = 2) {
                            byte[] bArr5 = bArr4[i4];
                            int a5 = a(bArr5, bArr, max2);
                            if (a(a5, this.f7886o) == 0) {
                                this.f7886o = a5;
                                this.q = c0255bf.b;
                                this.r = bArr5 == c0255bf.d;
                            }
                            i4++;
                        }
                        i3++;
                        c2 = 1;
                    }
                    int i6 = this.f7886o;
                    if (i6 != -1) {
                        byte b2 = bArr2[0];
                        byte b3 = bArr3[0];
                        int i7 = this.n;
                        if (i6 > i7) {
                            this.s = true;
                            this.f7886o = i6 - (b2 * 8);
                        } else {
                            this.s = false;
                            this.n = i7 - (b3 * 1);
                        }
                        if (this.m != -1) {
                            int i8 = this.s ? this.f7886o : this.n;
                            this.p = i8;
                            if (Math.abs(b(bArr, (i8 + (b2 * 8)) + (b3 * 1)) - 0.707f) > 0.001f) {
                                this.m = -1;
                                this.p = -1;
                            }
                        }
                        this.t = true;
                        return;
                    }
                    str = "Unable to locate verbs";
                }
            }
        }
        Log.e(str);
    }

    private void d(byte[] bArr) {
        if (x) {
            x = false;
            StringBuilder sb = new StringBuilder();
            sb.append("data was: ");
            sb.append(Arrays.toString(bArr));
            Log.d(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("identity was: ");
            sb2.append(Arrays.toString(a(b())));
            Log.d(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("computed: pto=");
            sb3.append(this.j);
            sb3.append(" po=");
            sb3.append(this.n);
            sb3.append(" vo=");
            sb3.append(this.f7886o);
            sb3.append(" pc=");
            sb3.append(this.k);
            sb3.append(" vc=");
            sb3.append(this.l);
            Log.d(sb3.toString());
        }
    }

    int a(Path path, fi fiVar) {
        if (!a()) {
            Log.i("Unable to serialize path because we are not in a valid state");
            return 0;
        } else if (path == null || path.isEmpty()) {
            return 0;
        } else {
            return path.isRect(this.w) ? C0297cu.a(fiVar, C0297cu.a(fiVar, new byte[]{0, 1, 1, 1, 5}), C0297cu.a(fiVar, new float[]{this.w.left, this.w.top, this.w.right, this.w.top, this.w.right, this.w.bottom, this.w.left, this.w.bottom}), 0) : a(a(path), fiVar);
        }
    }

    @Override // fsimpl.InterfaceC0253bd
    public int a(fi fiVar, Path path, int i2) {
        return C0294cr.a(fiVar, i2, 0, a(path, fiVar));
    }

    @Override // fsimpl.InterfaceC0253bd
    public boolean a() {
        return this.t && Build.VERSION.SDK_INT <= 27;
    }
}
