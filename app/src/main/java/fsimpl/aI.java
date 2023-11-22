package fsimpl;

import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import com.fullstory.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class aI {
    private static final Field A;
    private static final Field i;
    private static final Field j;
    private static final Field k;
    private static final Field l;
    private static final Field m;
    private static final Field n;

    /* renamed from: o  reason: collision with root package name */
    private static final Field f7826o;
    private static final Field p;
    private static final Field q;
    private static final Field r;
    private static final Field s;
    private static final Field t;
    private static final Field u;
    private static final Field v;
    private static final Field w;
    private static final boolean x;
    private static final Field y;
    private static final Field z;

    /* renamed from: a  reason: collision with root package name */
    private static final Field f7825a = eV.a(-1, 31, LinearGradient.class, "mX0");
    private static final Field b = eV.a(-1, 31, LinearGradient.class, "mY0");
    private static final Field c = eV.a(-1, 31, LinearGradient.class, "mX1");
    private static final Field d = eV.a(-1, 31, LinearGradient.class, "mY1");
    private static final Field h = eV.a(-1, 31, LinearGradient.class, "mPositions");
    private static final Field e = eV.a(LinearGradient.class, "mColors");
    private static final Field f = eV.a(LinearGradient.class, "mColor0");
    private static final Field g = eV.a(-1, 31, LinearGradient.class, "mColor1");

    static {
        boolean z2;
        Field a2 = eV.a(-1, 31, LinearGradient.class, "mTileMode");
        i = a2;
        boolean z3 = true;
        if (f7825a == null || b == null || c == null || d == null || h == null || e == null || f == null || g == null || a2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to locate LinearGradient bits: linearGradientX0=");
            sb.append(f7825a);
            sb.append("; linearGradientY0=");
            sb.append(b);
            sb.append("; linearGradientX1=");
            sb.append(c);
            sb.append("; linearGradientY1=");
            sb.append(d);
            sb.append("; linearGradientPositions=");
            sb.append(h);
            sb.append("; linearGradientColors=");
            sb.append(e);
            sb.append("; linearGradientColor0=");
            sb.append(f);
            sb.append("; linearGradientColor1=");
            sb.append(g);
            sb.append("; linearGradientTileMode=");
            sb.append(i);
            Log.e(sb.toString());
            z2 = true;
        } else {
            z2 = false;
        }
        j = eV.a(-1, 31, RadialGradient.class, "mX");
        k = eV.a(-1, 31, RadialGradient.class, "mY");
        l = eV.a(-1, 31, RadialGradient.class, "mRadius");
        p = eV.a(-1, 31, RadialGradient.class, "mPositions");
        m = eV.a(-1, 31, RadialGradient.class, "mColors");
        n = eV.a(-1, 31, RadialGradient.class, "mCenterColor");
        f7826o = eV.a(-1, 31, RadialGradient.class, "mEdgeColor");
        Field a3 = eV.a(-1, 31, RadialGradient.class, "mTileMode");
        q = a3;
        if (j == null || k == null || l == null || p == null || m == null || n == null || f7826o == null || a3 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to locate RadialGradient bits: radialGradientX=");
            sb2.append(j);
            sb2.append("; radialGradientY=");
            sb2.append(k);
            sb2.append("; radialGradientR=");
            sb2.append(l);
            sb2.append("; radialGradientPositions=");
            sb2.append(p);
            sb2.append("; radialGradientColors=");
            sb2.append(m);
            sb2.append("; radialGradientColor0=");
            sb2.append(n);
            sb2.append("; radialGradientColor1=");
            sb2.append(f7826o);
            sb2.append("; radialGradientTileMode=");
            sb2.append(q);
            Log.e(sb2.toString());
            z2 = true;
        }
        r = eV.a(-1, 31, SweepGradient.class, "mCx");
        s = eV.a(-1, 31, SweepGradient.class, "mCy");
        w = eV.a(-1, 31, SweepGradient.class, "mPositions");
        t = eV.a(-1, 31, SweepGradient.class, "mColors");
        u = eV.a(-1, 31, SweepGradient.class, "mColor0");
        Field a4 = eV.a(-1, 31, SweepGradient.class, "mColor1");
        v = a4;
        if (r == null || s == null || w == null || t == null || u == null || a4 == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to locate SweepGradient bits: sweepGradientX=");
            sb3.append(r);
            sb3.append("; sweepGradientY=");
            sb3.append(s);
            sb3.append("; sweepGradientPositions=");
            sb3.append(w);
            sb3.append("; sweepGradientColors=");
            sb3.append(t);
            sb3.append("; sweepGradientColor0=");
            sb3.append(u);
            sb3.append("; sweepGradientColor1=");
            sb3.append(v);
            Log.e(sb3.toString());
            z2 = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Field a5 = eV.a(30, LinearGradient.class, "mColorLongs");
            y = a5;
            if (a5 == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to locate LinearGradient bits: linearGradientColorLongs=");
                sb4.append(y);
                Log.e(sb4.toString());
                z2 = true;
            }
            Field a6 = eV.a(30, RadialGradient.class, "mColorLongs");
            z = a6;
            if (a6 == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Failed to locate RadialGradient bits: radialGradientColorLongs=");
                sb5.append(z);
                Log.e(sb5.toString());
                z2 = true;
            }
            Field a7 = eV.a(30, SweepGradient.class, "mColorLongs");
            A = a7;
            if (a7 == null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Failed to locate SweepGradient bits: sweepGradientColorLongs=");
                sb6.append(A);
                Log.e(sb6.toString());
                x = z3;
            }
        } else {
            y = null;
            z = null;
            A = null;
        }
        z3 = z2;
        x = z3;
    }

    private void a(fi fiVar, int[] iArr, int i2, int i3, float[] fArr) {
        int a2;
        if (iArr == null) {
            cG.d(fiVar, 2);
            fiVar.c(i3);
            fiVar.c(i2);
            a2 = fiVar.b();
        } else {
            a2 = cG.a(fiVar, iArr);
        }
        int a3 = fArr != null ? cG.a(fiVar, fArr) : 0;
        cG.a(fiVar);
        cG.c(fiVar, a2);
        cG.e(fiVar, a3);
    }

    private static int[] a(Shader shader, Field field, Field field2) {
        return field2 != null ? eA.a((long[]) field2.get(shader)) : (int[]) field.get(shader);
    }

    private int b(fi fiVar, Shader shader) {
        try {
        } catch (Throwable th) {
            cS.a("Failed to read gradients", th);
        }
        if (shader instanceof LinearGradient) {
            float f2 = f7825a.getFloat(shader);
            float f3 = b.getFloat(shader);
            float f4 = c.getFloat(shader);
            float f5 = d.getFloat(shader);
            int[] a2 = a(shader, e, y);
            int i2 = f.getInt(shader);
            int i3 = g.getInt(shader);
            float[] fArr = (float[]) h.get(shader);
            Shader.TileMode tileMode = (Shader.TileMode) i.get(shader);
            a(fiVar, a2, i2, i3, fArr);
            cG.a(fiVar, (byte) 0);
            cG.a(fiVar, C0300cx.a(fiVar, f2, f3));
            cG.b(fiVar, C0300cx.a(fiVar, f4, f5));
            cG.b(fiVar, aR.a(tileMode));
            return cG.b(fiVar);
        } else if (!(shader instanceof RadialGradient)) {
            if (shader instanceof SweepGradient) {
                float f6 = r.getFloat(shader);
                float f7 = s.getFloat(shader);
                a(fiVar, a(shader, t, A), u.getInt(shader), v.getInt(shader), (float[]) w.get(shader));
                cG.a(fiVar, (byte) 2);
                cG.a(fiVar, C0300cx.a(fiVar, f6, f7));
                return cG.b(fiVar);
            }
            return 0;
        } else {
            float f8 = j.getFloat(shader);
            float f9 = k.getFloat(shader);
            float f10 = l.getFloat(shader);
            int[] a3 = a(shader, m, z);
            int i4 = n.getInt(shader);
            int i5 = f7826o.getInt(shader);
            float[] fArr2 = (float[]) p.get(shader);
            Shader.TileMode tileMode2 = (Shader.TileMode) q.get(shader);
            a(fiVar, a3, i4, i5, fArr2);
            cG.a(fiVar, (byte) 1);
            cG.a(fiVar, C0300cx.a(fiVar, f8, f9));
            cG.a(fiVar, f10);
            cG.b(fiVar, aR.a(tileMode2));
            return cG.b(fiVar);
        }
    }

    public int a(fi fiVar, Shader shader) {
        if (x) {
            return 0;
        }
        return b(fiVar, shader);
    }
}
