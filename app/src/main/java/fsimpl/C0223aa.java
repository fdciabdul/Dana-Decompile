package fsimpl;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsSeekBar;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fullstory.instrumentation.frameworks.compose.FSComposeDraw;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* renamed from: fsimpl.aa  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0223aa extends Canvas {

    /* renamed from: a  reason: collision with root package name */
    private static short f7841a = -1;
    private boolean A;
    private final boolean B;
    private final boolean C;
    private final boolean[] D;
    private boolean c;
    private final bG d;
    private final cQ e;
    private final aD f;
    private final aO g;
    private final C0232aj h;
    private final bA i;
    private final aP j;
    private Matrix k;
    private float[] l;
    private Rect m;
    private LinkedHashMap n;

    /* renamed from: o  reason: collision with root package name */
    private List f7842o;
    private List p;
    private short q;
    private Bitmap r;
    private View s;
    private FSComposeDraw t;
    private C0370t u;
    private boolean v;
    private float w;
    private float x;
    private int y;
    private String z;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {93, 18, 67, -65, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 236;
    private static Set b = new HashSet();

    public C0223aa(bG bGVar, Bitmap bitmap, cQ cQVar, aP aPVar, aD aDVar, C0232aj c0232aj, aO aOVar, bA bAVar, boolean z, boolean z2) {
        super(bitmap);
        this.k = new Matrix();
        this.l = new float[9];
        this.m = new Rect();
        this.q = f7841a;
        this.D = r1;
        this.d = bGVar;
        this.r = bitmap;
        this.e = cQVar;
        this.j = aPVar;
        this.f = aDVar;
        this.h = c0232aj;
        this.g = aOVar;
        this.i = bAVar;
        this.B = z;
        this.C = z2;
        boolean[] zArr = {false};
        super.save();
        this.y = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void E(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            int r6 = r6 * 15
            int r6 = 18 - r6
            int r7 = r7 * 2
            int r7 = 16 - r7
            byte[] r0 = fsimpl.C0223aa.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0223aa.E(byte, short, byte, java.lang.Object[]):void");
    }

    private int a(Bitmap bitmap) {
        return c(bitmap) ? this.j.b(bitmap) : this.j.a(bitmap);
    }

    private void a(ColorFilter colorFilter) {
        if (colorFilter instanceof PorterDuffColorFilter) {
            this.g.a((PorterDuffColorFilter) colorFilter, this.e);
        } else if (colorFilter != null) {
            if (C0355ez.g != null && C0355ez.g.isInstance(colorFilter)) {
                this.g.a(colorFilter, this.e);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unhandled color filter: ");
            sb.append(colorFilter.getClass());
            c(sb.toString());
        }
    }

    private void a(Matrix matrix) {
        if (matrix != null) {
            matrix.getValues(this.l);
            this.e.a((byte) 10, this.l);
        }
    }

    private void a(Paint paint) {
        a(paint, true);
    }

    private void a(Paint paint, String str) {
        Integer b2;
        Typeface typeface = paint.getTypeface();
        if (l()) {
            paint.getTextBounds("X", 0, 1, this.m);
        } else {
            paint.getTextBounds(str, 0, str.length(), this.m);
        }
        float measureText = paint.measureText(str, 0, str.length());
        this.e.g(paint.getColor());
        this.e.c(paint.getTextSize());
        int style = typeface == null ? 0 : typeface.getStyle();
        if (paint.isFakeBoldText()) {
            style |= 1;
        }
        if ((paint.getFlags() & 8) != 0) {
            style |= 4;
        }
        this.e.m(style);
        this.e.n(paint.getTextAlign().ordinal());
        this.e.c(0, this.m.top, (int) measureText, this.m.bottom);
        if (typeface == null || (b2 = this.h.b(typeface)) == null) {
            return;
        }
        this.e.r(b2.intValue());
    }

    private void a(Paint paint, boolean z) {
        if (paint == null) {
            this.e.d();
            return;
        }
        this.e.g(paint.getColor());
        this.e.h(paint.getStyle().ordinal());
        this.e.b(paint.getStrokeWidth());
        a(paint.getColorFilter());
        if (paint.getXfermode() instanceof PorterDuffXfermode) {
            this.g.a((PorterDuffXfermode) paint.getXfermode(), this.e);
        } else if (paint.getXfermode() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("unhandled xfer mode: ");
            sb.append(paint.getXfermode().getClass());
            c(sb.toString());
        }
        if (paint.getMaskFilter() != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unhandled mask filter: ");
            sb2.append(paint.getMaskFilter().getClass());
            c(sb2.toString());
        }
        if (paint.getPathEffect() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("unhandled path effect: ");
            sb3.append(paint.getPathEffect().getClass());
            c(sb3.toString());
        }
        if (z) {
            Shader shader = paint.getShader();
            if (!(shader instanceof BitmapShader)) {
                if (shader != null) {
                    this.e.j(this.j.a(shader));
                    return;
                }
                return;
            }
            BitmapShader bitmapShader = (BitmapShader) shader;
            if (C0222a.a()) {
                this.e.i(a(C0222a.a(bitmapShader)));
            } else {
                Log.i("Unable to record the bitmap from the BitmapShader instance");
            }
            this.f.a(this.e, bitmapShader);
            if (bitmapShader.getLocalMatrix(this.k)) {
                this.k.getValues(this.l);
                this.e.a(this.l);
            }
        }
    }

    private void a(Path path) {
        this.e.b(this.j.a(path));
        this.e.c(path.getFillType().ordinal());
    }

    private void a(Drawable drawable) {
        if (!fd.a(drawable)) {
            Log.e("Only VectorDrawables and AnimatedVectorDrawables are allowed in fsDrawVectorDrawable");
        } else if (a((short) 5)) {
            this.e.d(b(drawable));
            drawable.copyBounds(this.m);
            this.e.b(this.m.left, this.m.top, this.m.right, this.m.bottom);
            Paint paint = null;
            if (!fd.b(drawable)) {
                paint = new Paint(0);
                paint.setColorFilter(drawable.getColorFilter() != null ? drawable.getColorFilter() : fd.c(drawable));
            }
            a(paint, false);
            k();
        }
    }

    private void a(AbsSeekBar absSeekBar) {
        Drawable tickMark = absSeekBar.getTickMark();
        if (tickMark != null) {
            int max = absSeekBar.getMax() - absSeekBar.getMin();
            if (max > 1) {
                int intrinsicWidth = tickMark.getIntrinsicWidth();
                int intrinsicHeight = tickMark.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                int width = absSeekBar.getWidth();
                int height = absSeekBar.getHeight();
                int paddingLeft = absSeekBar.getPaddingLeft();
                int paddingRight = absSeekBar.getPaddingRight();
                tickMark.setBounds(-i, -i2, i, i2);
                float f = ((width - paddingLeft) - paddingRight) / max;
                int save = save();
                translate(paddingLeft, height / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    tickMark.draw(this);
                    translate(f, 0.0f);
                }
                restoreToCount(save);
            }
        }
    }

    private void a(ProgressBar progressBar) {
        Drawable a2 = AbstractC0359i.a(progressBar);
        boolean b2 = AbstractC0359i.b(progressBar);
        if (a2 != null) {
            int save = save();
            boolean isLayoutRtl = progressBar.isLayoutRtl();
            int width = progressBar.getWidth();
            int paddingRight = progressBar.getPaddingRight();
            int paddingRight2 = progressBar.getPaddingRight();
            int paddingTop = progressBar.getPaddingTop();
            Drawable current = a2.getCurrent();
            if (isLayoutRtl && b2) {
                translate(width - paddingRight2, paddingTop);
                scale(-1.0f, 1.0f);
            } else {
                translate(paddingRight, paddingTop);
            }
            if (fd.a(current)) {
                a(current);
            } else {
                a2.draw(this);
            }
            restoreToCount(save);
        }
    }

    private void a(String str, float f, float f2, Paint paint) {
        this.e.a(this.j.a(b(str)));
        this.e.a(f, f2);
        a(paint, str);
    }

    private void a(String str, int i, int i2, Paint paint) {
        this.e.a(this.j.a(b(str)));
        this.e.a(i, i2);
        a(paint, str);
    }

    private boolean a(float f, float f2, float f3, float f4) {
        return ((int) f3) - ((int) f) == 0 || ((int) f4) - ((int) f2) == 0;
    }

    private boolean a(Rect rect) {
        return rect.right - rect.left == 0 || rect.bottom - rect.top == 0;
    }

    private boolean a(RectF rectF) {
        return ((int) rectF.right) - ((int) rectF.left) == 0 || ((int) rectF.bottom) - ((int) rectF.top) == 0;
    }

    private boolean a(short s) {
        if (this.q != f7841a) {
            return false;
        }
        this.A = true;
        this.q = s;
        if (this.c && !this.e.f() && j()) {
            this.e.a(s);
            return true;
        }
        return false;
    }

    private boolean a(boolean z) {
        C0370t c0370t = this.u;
        if (c0370t == null) {
            return true;
        }
        if (c0370t.a()) {
            return !z || this.C || this.d.d();
        }
        return false;
    }

    private int b(Bitmap bitmap) {
        return c((Bitmap) null) ? this.j.d(bitmap) : this.j.c(bitmap);
    }

    private int b(Drawable drawable) {
        return c(drawable) ? this.j.b(drawable) : this.j.a(drawable);
    }

    private String b(String str) {
        if (l()) {
            String a2 = eH.a(this.s, str);
            this.e.e();
            return a2;
        }
        return str;
    }

    private void b(Rect rect) {
        if (rect != null) {
            this.e.a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    private void b(RectF rectF) {
        if (rectF != null) {
            this.e.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    private void b(AbsSeekBar absSeekBar) {
        Drawable thumb = absSeekBar.getThumb();
        if (thumb != null) {
            Drawable current = thumb.getCurrent();
            int save = save();
            translate(absSeekBar.getPaddingLeft() - absSeekBar.getThumbOffset(), absSeekBar.getPaddingTop());
            if (fd.a(current)) {
                a(current);
            } else {
                absSeekBar.getThumb().draw(this);
            }
            restoreToCount(save);
        }
    }

    private void c(Rect rect) {
        if (rect != null) {
            this.e.b(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    private void c(RectF rectF) {
        if (rectF != null) {
            this.e.b(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    private void c(AbsSeekBar absSeekBar) {
        Drawable thumb = absSeekBar.getThumb();
        if (thumb == null || !absSeekBar.getSplitTrack()) {
            a((ProgressBar) absSeekBar);
            a(absSeekBar);
            return;
        }
        Insets opticalInsets = thumb.getOpticalInsets();
        Rect rect = new Rect();
        thumb.copyBounds(rect);
        rect.offset(absSeekBar.getPaddingLeft() - absSeekBar.getThumbOffset(), absSeekBar.getPaddingTop());
        rect.left += opticalInsets.left;
        rect.right -= opticalInsets.right;
        int save = save();
        clipRect(rect, Region.Op.DIFFERENCE);
        a((ProgressBar) absSeekBar);
        a(absSeekBar);
        restoreToCount(save);
    }

    private void c(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported operation: ");
        sb.append(str);
        a(sb.toString());
    }

    private boolean c(Bitmap bitmap) {
        if (this.B) {
            return true;
        }
        return a(d(bitmap));
    }

    private boolean c(Drawable drawable) {
        if (this.B) {
            return true;
        }
        return a(d(drawable));
    }

    private void d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid operation: ");
        sb.append(str);
        a(sb.toString());
    }

    private boolean d(Bitmap bitmap) {
        bA bAVar;
        if (bitmap == null || (bAVar = this.i) == null) {
            return false;
        }
        return bAVar.a(bitmap, this.D);
    }

    private boolean d(Drawable drawable) {
        return true;
    }

    private boolean j() {
        if (this.v) {
            if (Math.abs(this.w) > 0.001f || Math.abs(this.x) > 0.001f) {
                this.e.a((short) 21);
                this.e.a(this.w, this.x);
                k();
            }
            this.w = 0.0f;
            this.x = 0.0f;
            this.v = false;
            return true;
        }
        return true;
    }

    private void k() {
        this.q = f7841a;
        String str = this.z;
        if (str != null) {
            a(str);
            this.z = null;
        }
    }

    private boolean l() {
        return m();
    }

    private boolean m() {
        C0370t c0370t = this.u;
        if (c0370t == null) {
            return true;
        }
        return c0370t.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(int i, float f, float f2, float f3, float f4) {
        if (a((short) 3)) {
            this.e.d(i);
            this.e.b((int) f, (int) f2, (int) f3, (int) f4);
            k();
            return i;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        if (bitmap == null || bitmap.isRecycled() || !a((short) 3)) {
            return 0;
        }
        int b2 = b(bitmap);
        this.e.d(b2);
        this.e.b((int) f, (int) f2, (int) f3, (int) f4);
        k();
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedHashMap a() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Drawable drawable, View view, boolean z) {
        if (drawable == null || view == null) {
            return;
        }
        if (!fd.a(drawable)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Only VectorDrawables and AnimatedVectorDrawables are allowed. Got: ");
            sb.append(drawable.getClass().getName());
            Log.e(sb.toString());
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if ((view instanceof ImageView) && !z) {
            ImageView imageView = (ImageView) view;
            Matrix imageMatrix = imageView.getImageMatrix();
            int paddingTop = imageView.getPaddingTop();
            int paddingTop2 = imageView.getPaddingTop();
            if (imageMatrix != null || paddingTop2 != 0 || paddingTop != 0) {
                save();
                if (imageView.getCropToPadding()) {
                    int scrollX = view.getScrollX();
                    int scrollY = view.getScrollY();
                    clipRect(scrollX + paddingTop2, scrollY + paddingTop, (scrollX + width) - view.getPaddingRight(), (scrollY + height) - view.getPaddingBottom());
                }
                translate(paddingTop2, paddingTop);
                if (imageMatrix != null) {
                    concat(imageMatrix);
                }
                a(drawable);
                restore();
                return;
            }
        }
        a(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view) {
        if (this.n == null) {
            this.n = new LinkedHashMap();
        }
        this.n.put(view, i());
        if (a((short) 26)) {
            cQ cQVar = this.e;
            try {
                Object[] objArr = {view};
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                E(b2, b3, b3, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                Object[] objArr3 = new Object[1];
                E(b4, (byte) (b4 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr3);
                cQVar.f(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
                k();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(View view, RectF rectF, C0370t c0370t) {
        f();
        this.s = view;
        this.t = null;
        this.u = c0370t;
        this.c = true;
        this.A = false;
        this.v = false;
        this.n = null;
        this.f7842o = null;
        this.p = null;
        this.e.a();
        int width = view.getWidth();
        int height = view.getHeight();
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        super.restoreToCount(1);
        super.save();
        this.y = 1;
        super.scale(super.getWidth() / width, super.getHeight() / height);
        super.clipRect(rectF, Region.Op.INTERSECT);
        if (scrollX == 0 && scrollY == 0) {
            return;
        }
        translate(-scrollX, -scrollY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(ViewGroup viewGroup) {
        if (C0262bm.a(viewGroup)) {
            return;
        }
        List a2 = fe.a(viewGroup);
        if (a2 != null) {
            try {
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    AbstractC0329e.a(viewGroup, this, (View) it.next(), 0L);
                }
                return;
            } finally {
                a2.clear();
            }
        }
        boolean b2 = fe.b(viewGroup);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            AbstractC0329e.a(viewGroup, this, viewGroup.getChildAt(b2 ? fe.a(viewGroup, viewGroup.getChildCount(), i) : i), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(FSComposeDraw fSComposeDraw, float f, float f2, C0370t c0370t) {
        f();
        this.s = null;
        this.t = fSComposeDraw;
        this.u = c0370t;
        this.c = true;
        this.A = false;
        this.v = false;
        this.n = null;
        this.f7842o = null;
        this.p = null;
        this.e.a();
        super.restoreToCount(1);
        super.save();
        this.y = 1;
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        translate(-f, -f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Object obj) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(obj);
        if (a((short) 26)) {
            cQ cQVar = this.e;
            try {
                Object[] objArr = {obj};
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                E(b2, b3, b3, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                Object[] objArr3 = new Object[1];
                E(b4, (byte) (b4 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr3);
                cQVar.f(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
                k();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        if (b.add(str)) {
            if (this.q != f7841a) {
                this.z = str;
                return;
            }
            this.e.a((short) 27);
            this.e.a(this.j.a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List b() {
        return this.f7842o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(View view) {
        if (this.f7842o == null) {
            this.f7842o = new ArrayList();
        }
        this.f7842o.add(view);
        if (a((short) 26)) {
            cQ cQVar = this.e;
            try {
                Object[] objArr = {view};
                byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                E(b2, b3, b3, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
                Object[] objArr3 = new Object[1];
                E(b4, (byte) (b4 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr3);
                cQVar.f(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
                k();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List c() {
        return this.p;
    }

    @Override // android.graphics.Canvas
    public final boolean clipPath(Path path) {
        boolean clipPath = super.clipPath(path);
        if (a((short) 28)) {
            a(path);
            k();
        }
        return clipPath;
    }

    @Override // android.graphics.Canvas
    public final boolean clipPath(Path path, Region.Op op) {
        boolean clipPath = super.clipPath(path, op);
        if (a((short) 28)) {
            a(path);
            this.e.e(op.nativeInt);
            k();
        }
        return clipPath;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(float f, float f2, float f3, float f4) {
        boolean clipRect = super.clipRect(f, f2, f3, f4);
        if (a((short) 0)) {
            this.e.a(f, f2, f3, f4);
            this.e.e(EnumC0303d.INTERSECT.g);
            k();
        }
        return clipRect;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        boolean clipRect = super.clipRect(f, f2, f3, f4, op);
        if (a((short) 0)) {
            this.e.a(f, f2, f3, f4);
            this.e.e(op.nativeInt);
            k();
        }
        return clipRect;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(int i, int i2, int i3, int i4) {
        boolean clipRect = super.clipRect(i, i2, i3, i4);
        if (a((short) 0)) {
            this.e.a(i, i2, i3, i4);
            this.e.e(EnumC0303d.INTERSECT.g);
            k();
        }
        return clipRect;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(Rect rect) {
        boolean clipRect = super.clipRect(rect);
        if (a((short) 0)) {
            b(rect);
            this.e.e(EnumC0303d.INTERSECT.g);
            k();
        }
        return clipRect;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(Rect rect, Region.Op op) {
        boolean clipRect = super.clipRect(rect, op);
        if (a((short) 0)) {
            b(rect);
            this.e.e(op.nativeInt);
            k();
        }
        return clipRect;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(RectF rectF) {
        boolean clipRect = super.clipRect(rectF);
        if (a((short) 0)) {
            b(rectF);
            this.e.e(EnumC0303d.INTERSECT.g);
            k();
        }
        return clipRect;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(RectF rectF, Region.Op op) {
        boolean clipRect = super.clipRect(rectF, op);
        if (a((short) 0)) {
            b(rectF);
            this.e.e(op.nativeInt);
            k();
        }
        return clipRect;
    }

    public final boolean clipRegion(Region region) {
        c("clipRegion(Region region)");
        return super.clipRegion(region);
    }

    public final boolean clipRegion(Region region, Region.Op op) {
        c("clipRegion(Region region, Op op)");
        return super.clipRegion(region, op);
    }

    @Override // android.graphics.Canvas
    public final void concat(Matrix matrix) {
        if (matrix.isIdentity()) {
            return;
        }
        super.concat(matrix);
        if (a((short) 24)) {
            a(matrix);
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bitmap d() {
        return this.r;
    }

    @Override // android.graphics.Canvas
    public final void drawARGB(int i, int i2, int i3, int i4) {
        int argb = Color.argb(i, i2, i3, i4);
        if (argb != 0 && a((short) 1)) {
            this.e.g(argb);
            this.e.e(aN.a(PorterDuff.Mode.SRC_OVER));
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        if (a((short) 14)) {
            this.e.b(f, f2, f3, f4);
            this.e.a(f5, f6);
            this.e.e(z ? 1 : 0);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawArc(RectF rectF, float f, float f2, boolean z, Paint paint) {
        if (a((short) 14)) {
            c(rectF);
            this.e.a(f, f2);
            this.e.e(z ? 1 : 0);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        if (!bitmap.isRecycled() && a((short) 4)) {
            boolean z = bitmap.getConfig() == Bitmap.Config.ALPHA_8;
            if (z) {
                this.e.e(1);
            }
            this.e.d(a(bitmap));
            this.e.a((int) f, (int) f2);
            a(paint, z);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        if (!bitmap.isRecycled() && a((short) 4)) {
            boolean z = bitmap.getConfig() == Bitmap.Config.ALPHA_8;
            if (z) {
                this.e.e(1);
            }
            this.e.d(a(bitmap));
            a(matrix);
            a(paint, z);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        if (!bitmap.isRecycled() && a((short) 5)) {
            boolean z = bitmap.getConfig() == Bitmap.Config.ALPHA_8;
            if (z) {
                this.e.e(1);
            }
            this.e.d(a(bitmap));
            b(rect);
            c(rect2);
            a(paint, z);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        if (!bitmap.isRecycled() && a((short) 5)) {
            boolean z = bitmap.getConfig() == Bitmap.Config.ALPHA_8;
            if (z) {
                this.e.e(1);
            }
            this.e.d(a(bitmap));
            b(rect);
            c(rectF);
            a(paint, z);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, Paint paint) {
        c("drawBitmap(int[] colors, int offset, int stride, float x, float y, int width, int height, boolean hasAlpha, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        c("drawBitmap(int[] colors, int offset, int stride, int x, int y, int width, int height, boolean hasAlpha, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, Paint paint) {
        c("drawBitmapMesh(...)");
    }

    @Override // android.graphics.Canvas
    public final void drawCircle(float f, float f2, float f3, Paint paint) {
        if (a((short) 12)) {
            this.e.a((int) f, (int) f2);
            this.e.a(f3);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int i) {
        if (i != 0 && a((short) 1)) {
            this.e.g(i);
            this.e.e(aN.a(PorterDuff.Mode.SRC_OVER));
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int i, PorterDuff.Mode mode) {
        if (a((short) 1)) {
            this.e.g(i);
            this.e.e(aN.a(mode));
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        if (a((short) 11)) {
            this.e.b(f, f2, f3, f4);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] fArr, int i, int i2, Paint paint) {
        c("drawLines(float[] pts, int offset, int count, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] fArr, Paint paint) {
        c("drawLines(float[] pts, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        if (!a(f, f2, f3, f4) && a((short) 13)) {
            this.e.b(f, f2, f3, f4);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawOval(RectF rectF, Paint paint) {
        if (!a(rectF) && a((short) 13)) {
            c(rectF);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPaint(Paint paint) {
        if (a((short) 2)) {
            a(paint);
            k();
        }
    }

    public final void drawPatch(Bitmap bitmap, byte[] bArr, Rect rect, Paint paint) {
        if (!bitmap.isRecycled() && a((short) 6)) {
            this.e.d(a(bitmap));
            c(rect);
            a(paint);
            k();
        }
    }

    public final void drawPatch(Bitmap bitmap, byte[] bArr, RectF rectF, Paint paint) {
        if (!bitmap.isRecycled() && a((short) 6)) {
            this.e.d(a(bitmap));
            c(rectF);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        if (!ninePatch.getBitmap().isRecycled() && a((short) 6)) {
            this.e.d(a(ninePatch.getBitmap()));
            c(rect);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        if (!ninePatch.getBitmap().isRecycled() && a((short) 6)) {
            this.e.d(a(ninePatch.getBitmap()));
            c(rectF);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPath(Path path, Paint paint) {
        if (a((short) 8)) {
            a(path);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture) {
        c("drawPicture(Picture picture)");
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture, Rect rect) {
        c("drawPicture(Picture picture, Rect dst)");
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture, RectF rectF) {
        c("drawPicture(Picture picture, RectF dst)");
    }

    @Override // android.graphics.Canvas
    public final void drawPoint(float f, float f2, Paint paint) {
        c("drawPoint(float x, float y, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        c("drawPoints(float[] pts, int offset, int count, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] fArr, Paint paint) {
        c("drawPoints(float[] pts, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(String str, float[] fArr, Paint paint) {
        c("drawPosText(String text, float[] pos, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(char[] cArr, int i, int i2, float[] fArr, Paint paint) {
        c("drawPosText(char[] text, int index, int count, float[] pos, Paint paint)");
    }

    @Override // android.graphics.Canvas
    public final void drawRGB(int i, int i2, int i3) {
        int rgb = Color.rgb(i, i2, i3);
        if (a((short) 1)) {
            this.e.g(rgb);
            this.e.e(aN.a(PorterDuff.Mode.SRC_OVER));
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        if (!a(f, f2, f3, f4) && a((short) 9)) {
            this.e.b(f, f2, f3, f4);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(Rect rect, Paint paint) {
        if (!a(rect) && a((short) 9)) {
            c(rect);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(RectF rectF, Paint paint) {
        if (!a(rectF) && a((short) 9)) {
            c(rectF);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        if (!a(f, f2, f3, f4) && a((short) 10)) {
            this.e.b(f, f2, f3, f4);
            this.e.a(f5, f6);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(RectF rectF, float f, float f2, Paint paint) {
        if (!a(rectF) && a((short) 10)) {
            c(rectF);
            this.e.a(f, f2);
            a(paint);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        if (charSequence == null || i == i2 || !a((short) 7)) {
            return;
        }
        a(charSequence.subSequence(i, i2).toString(), (int) f, (int) f2, paint);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawText(String str, float f, float f2, Paint paint) {
        if (str == null || str.length() == 0 || !a((short) 7)) {
            return;
        }
        a(str, (int) f, (int) f2, paint);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawText(String str, int i, int i2, float f, float f2, Paint paint) {
        if (str == null || i == i2 || !a((short) 7)) {
            return;
        }
        a(str.substring(i, i2), (int) f, (int) f2, paint);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawText(char[] cArr, int i, int i2, float f, float f2, Paint paint) {
        if (cArr == null || cArr.length == 0 || !a((short) 7)) {
            return;
        }
        a(new String(cArr, i, i2), (int) f, (int) f2, paint);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(String str, Path path, float f, float f2, Paint paint) {
        if (str == null || str.length() == 0 || !a((short) 7)) {
            return;
        }
        a(str, f, f2, paint);
        a(path);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(char[] cArr, int i, int i2, Path path, float f, float f2, Paint paint) {
        if (cArr == null || i2 == 0 || !a((short) 7)) {
            return;
        }
        a(new String(cArr, i, i2), f, f2, paint);
        a(path);
        k();
    }

    public final void drawTextRun(CharSequence charSequence, int i, int i2, int i3, int i4, float f, float f2, int i5, Paint paint) {
        drawTextRun(charSequence, i, i2, i3, i4, f, f2, i5 == 1, paint);
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(CharSequence charSequence, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        if (charSequence == null || i == i2 || !a((short) 7)) {
            return;
        }
        a(charSequence.subSequence(i, i2).toString(), (int) f, (int) f2, paint);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        if (cArr == null || i2 == 0 || !a((short) 7)) {
            return;
        }
        a(new String(cArr, i, i2), (int) f, (int) f2, paint);
        k();
    }

    @Override // android.graphics.Canvas
    public final void drawVertices(Canvas.VertexMode vertexMode, int i, float[] fArr, int i2, float[] fArr2, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, Paint paint) {
        c("drawVertices(...)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.D[0] = false;
    }

    final void f() {
    }

    public final void fsDrawCompoundVectorDrawable(Drawable drawable, TextView textView, int i) {
        int paddingLeft;
        float f;
        int height;
        int right = textView.getRight();
        int left = textView.getLeft();
        int bottom = textView.getBottom();
        int top = textView.getTop();
        int compoundPaddingBottom = textView.getCompoundPaddingBottom();
        int compoundPaddingTop = textView.getCompoundPaddingTop();
        int compoundPaddingRight = ((right - left) - textView.getCompoundPaddingRight()) - textView.getCompoundPaddingLeft();
        int scrollX = textView.getScrollX();
        int scrollY = textView.getScrollY();
        int compoundPaddingTop2 = textView.getCompoundPaddingTop();
        int compoundPaddingLeft = textView.getCompoundPaddingLeft();
        int paddingTop = textView.getPaddingTop();
        int paddingBottom = textView.getPaddingBottom();
        Rect rect = new Rect();
        drawable.copyBounds(rect);
        if (i != 0) {
            if (i == 1) {
                save();
                f = scrollX + compoundPaddingLeft + ((compoundPaddingRight - rect.width()) / 2);
                height = scrollY + paddingTop;
            } else if (i == 2) {
                save();
                paddingLeft = (((scrollX + right) - left) - textView.getPaddingRight()) - rect.width();
            } else if (i != 3) {
                return;
            } else {
                save();
                f = scrollX + compoundPaddingLeft + ((compoundPaddingRight - rect.width()) / 2);
                height = (((scrollY + bottom) - top) - paddingBottom) - rect.height();
            }
            translate(f, height);
            a(drawable);
            restore();
        }
        save();
        paddingLeft = scrollX + textView.getPaddingLeft();
        f = paddingLeft + 0;
        height = scrollY + compoundPaddingTop2 + (((((bottom - top) - compoundPaddingBottom) - compoundPaddingTop) - rect.height()) / 2);
        translate(f, height);
        a(drawable);
        restore();
    }

    public final void fsDrawProgressBar(ProgressBar progressBar) {
        if (!(progressBar instanceof AbsSeekBar)) {
            a(progressBar);
            return;
        }
        AbsSeekBar absSeekBar = (AbsSeekBar) progressBar;
        c(absSeekBar);
        b(absSeekBar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer g() {
        return h();
    }

    @Override // android.graphics.Canvas
    public final boolean getClipBounds(Rect rect) {
        return super.getClipBounds(rect);
    }

    @Override // android.graphics.Canvas
    public final int getDensity() {
        return super.getDensity();
    }

    @Override // android.graphics.Canvas
    public final DrawFilter getDrawFilter() {
        return super.getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public final int getHeight() {
        View view = this.s;
        return view == null ? super.getHeight() : view.getHeight();
    }

    @Override // android.graphics.Canvas
    public final void getMatrix(Matrix matrix) {
        super.getMatrix(matrix);
    }

    @Override // android.graphics.Canvas
    public final int getMaximumBitmapHeight() {
        return super.getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public final int getMaximumBitmapWidth() {
        return super.getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public final int getSaveCount() {
        return this.y;
    }

    @Override // android.graphics.Canvas
    public final int getWidth() {
        View view = this.s;
        return view == null ? super.getWidth() : view.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteBuffer h() {
        j();
        this.e.c();
        this.s = null;
        this.t = null;
        this.u = null;
        return this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Rect i() {
        return super.getClipBounds();
    }

    public final boolean isEmpty() {
        return !this.A;
    }

    @Override // android.graphics.Canvas
    public final boolean isHardwareAccelerated() {
        return false;
    }

    @Override // android.graphics.Canvas
    public final boolean isOpaque() {
        return super.isOpaque();
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(float f, float f2, float f3, float f4, Canvas.EdgeType edgeType) {
        return super.quickReject(f, f2, f3, f4, edgeType);
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        return super.quickReject(path, edgeType);
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        return super.quickReject(rectF, edgeType);
    }

    public final void release() {
        d("Attempted to call release() during onDraw");
    }

    @Override // android.graphics.Canvas
    public final void restore() {
        if (this.y == 1) {
            d("Attempted to restore more times than saved");
            return;
        }
        super.restore();
        this.y--;
        if (a((short) 18)) {
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void restoreToCount(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (i >= this.y) {
            d("Attempted to restore to an invalid index");
            return;
        }
        this.y = i;
        super.restoreToCount(i + 1);
        if (a((short) 19)) {
            this.e.e(i);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void rotate(float f) {
        if (f == 0.0f) {
            return;
        }
        super.rotate(f);
        if (a((short) 23)) {
            this.e.a(f);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final int save() {
        this.y++;
        super.save();
        if (a((short) 15)) {
            this.e.e(3);
            k();
        }
        return this.y - 1;
    }

    public final int save(int i) {
        if (i != 31) {
            c("Save flags other than ALL_SAVE_FLAG are deprecated");
        }
        this.y++;
        super.save(i);
        if (a((short) 15)) {
            this.e.e(i);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        this.y++;
        super.saveLayer(f, f2, f3, f4, paint, 31);
        if (a((short) 16)) {
            this.e.a(f, f2, f3, f4);
            a(paint);
            this.e.e(31);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        if (i != 31) {
            c("Save flags other than ALL_SAVE_FLAG are deprecated");
        }
        this.y++;
        super.saveLayer(f, f2, f3, f4, paint, i);
        if (a((short) 16)) {
            this.e.a(f, f2, f3, f4);
            a(paint);
            this.e.e(i);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(RectF rectF, Paint paint) {
        this.y++;
        super.saveLayer(rectF, paint, 31);
        if (a((short) 16)) {
            b(rectF);
            a(paint);
            this.e.e(31);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(RectF rectF, Paint paint, int i) {
        if (i != 31) {
            c("Save flags other than ALL_SAVE_FLAG are deprecated");
        }
        this.y++;
        super.saveLayer(rectF, paint, i);
        if (a((short) 16)) {
            b(rectF);
            a(paint);
            this.e.e(i);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(float f, float f2, float f3, float f4, int i) {
        this.y++;
        super.saveLayerAlpha(f, f2, f3, f4, i, 31);
        if (a((short) 17)) {
            this.e.a(f, f2, f3, f4);
            this.e.e(i | 7936);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(float f, float f2, float f3, float f4, int i, int i2) {
        if (i2 != 31) {
            c("Save flags other than ALL_SAVE_FLAG are deprecated");
        }
        this.y++;
        super.saveLayerAlpha(f, f2, f3, f4, i, i2);
        if (a((short) 17)) {
            this.e.a(f, f2, f3, f4);
            this.e.e((i2 << 8) | i);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(RectF rectF, int i) {
        this.y++;
        super.saveLayerAlpha(rectF, i, 31);
        if (a((short) 17)) {
            b(rectF);
            this.e.e(i | 7936);
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(RectF rectF, int i, int i2) {
        if (i2 != 31) {
            c("Save flags other than ALL_SAVE_FLAG are deprecated");
        }
        this.y++;
        super.saveLayerAlpha(rectF, i, i2);
        if (a((short) 17)) {
            b(rectF);
            this.e.e(i | (i2 << 8));
            k();
        }
        return this.y - 1;
    }

    @Override // android.graphics.Canvas
    public final void scale(float f, float f2) {
        if (f == 1.0f && f2 == 1.0f) {
            return;
        }
        super.scale(f, f2);
        if (a((short) 20)) {
            this.e.a(f, f2);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void setBitmap(Bitmap bitmap) {
        d("Attempted to call setBitmap during onDraw");
    }

    @Override // android.graphics.Canvas
    public final void setDensity(int i) {
        c("setDensity(int density)");
        super.setDensity(i);
    }

    @Override // android.graphics.Canvas
    public final void setDrawFilter(DrawFilter drawFilter) {
        c("setDrawFilter(DrawFilter filter)");
        super.setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas
    public final void setMatrix(Matrix matrix) {
        super.setMatrix(matrix);
        if (a((short) 25)) {
            a(matrix);
            k();
        }
    }

    public final void setScreenDensity(int i) {
        c("setScreenDensity(int density)");
        super.setScreenDensity(i);
    }

    @Override // android.graphics.Canvas
    public final void skew(float f, float f2) {
        super.skew(f, f2);
        if (a((short) 22)) {
            this.e.a(f, f2);
            k();
        }
    }

    @Override // android.graphics.Canvas
    public final void translate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.v = true;
        this.w += f;
        this.x += f2;
        super.translate(f, f2);
    }
}
