package fsimpl;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.VideoView;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.frameworks.compose.FSComposeAndroidComposeView;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;
import com.fullstory.instrumentation.webview.WebViewTracker;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: fsimpl.am  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0235am {
    public static final byte[] MyBillsEntityDataFactory = {4, -20, -33, -123, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 207;
    private final C0275bz b;
    private final C0240ar c;
    private int f;
    private fi g;
    private C0223aa h;
    private final C0366p i;
    private final C0367q j;
    private final C0224ab k;
    private final WebViewTracker l;
    private final C0311dh m;
    private final boolean n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7857o;
    private boolean p;
    private aP q;
    private C0234al u;
    private final eO v;
    private final int w;
    private final AbstractC0258bi x;
    private View y;
    private float[] d = new float[9];
    private final Matrix e = new Matrix();
    private final ArrayList r = new ArrayList();
    private O s = new O();
    private final ByteArrayOutputStream t = new ByteArrayOutputStream();
    private RectF z = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: a  reason: collision with root package name */
    List f7856a = new ArrayList();

    public C0235am(C0275bz c0275bz, C0240ar c0240ar, WebViewTracker webViewTracker, C0366p c0366p, C0367q c0367q, C0224ab c0224ab, C0311dh c0311dh, boolean z, int i, AbstractC0258bi abstractC0258bi) {
        this.b = c0275bz;
        this.c = c0240ar;
        this.l = webViewTracker;
        this.i = c0366p;
        this.j = c0367q;
        this.k = c0224ab;
        this.m = c0311dh;
        this.n = z;
        this.v = new eO(2000000L, z);
        this.w = i;
        this.x = abstractC0258bi;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void A(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = fsimpl.C0235am.MyBillsEntityDataFactory
            int r6 = 106 - r6
            int r8 = r8 * 3
            int r8 = r8 + 16
            int r7 = r7 * 15
            int r7 = 19 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r7 = r7 + r6
            int r6 = r7 + 2
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0235am.A(short, byte, short, java.lang.Object[]):void");
    }

    private int a(View view, Object obj, int i, int i2, int i3, boolean z, C0248az c0248az) {
        int left;
        int top;
        int right;
        int i4;
        RectF a2;
        int i5;
        int i6;
        int i7;
        int i8;
        a("scanView");
        i();
        C0370t e = z ? null : this.j.e(view);
        boolean d = this.j.d(view);
        int a3 = a(c0248az);
        int a4 = a(this.g, view, z);
        cO.a(this.g);
        cO.k(this.g, a3);
        cO.n(this.g, a4);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.getValues(this.d);
            fi fiVar = this.g;
            float[] fArr = this.d;
            cO.d(fiVar, C0298cv.a(fiVar, fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8]));
        }
        int id2 = view.getId();
        if (id2 == 16908290) {
            cO.a(this.g, (byte) 1);
        } else if (id2 == 16908335) {
            cO.a(this.g, (byte) 2);
        } else if (id2 == 16908336) {
            cO.a(this.g, (byte) 3);
        }
        float alpha = view.getAlpha();
        Animation animation = view.getAnimation();
        if (animation != null && (animation instanceof AlphaAnimation) && animation.hasEnded() && animation.getFillAfter()) {
            alpha = C0357g.a(animation);
        }
        cO.b(this.g, alpha >= 1.0f ? (byte) -1 : alpha <= 0.0f ? (byte) 0 : (byte) (alpha * 255.0f));
        if (obj == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            left = iArr[0];
            top = iArr[1];
            right = iArr[0] + view.getWidth();
            i4 = iArr[1] + view.getHeight();
        } else {
            left = view.getLeft();
            top = view.getTop();
            right = view.getRight();
            int bottom = view.getBottom();
            if ((obj instanceof FSComposeLayoutNode) && (a2 = C0238ap.a((FSComposeLayoutNode) obj)) != null) {
                left -= (int) a2.left;
                top -= (int) a2.top;
            }
            i4 = bottom;
        }
        int i9 = left;
        int i10 = right;
        int i11 = top;
        fi fiVar2 = this.g;
        cO.a(fiVar2, cC.a(fiVar2, i9, i11, i10, i4));
        if (z) {
            i5 = i10;
            i6 = i11;
            i7 = i9;
            i8 = i4;
            C0237ao.a(this.i, view, 0, 0, i10 - i9, i4 - i11);
        } else {
            i5 = i10;
            i6 = i11;
            i7 = i9;
            i8 = i4;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams) {
            cO.e(this.g, ((WindowManager.LayoutParams) layoutParams).type);
            cO.a(this.g, r2.flags);
        }
        int e2 = AbstractC0329e.e(view);
        int c = AbstractC0329e.c(view);
        int a5 = AbstractC0329e.a(view);
        int f = AbstractC0329e.f(view);
        int d2 = AbstractC0329e.d(view);
        int b = AbstractC0329e.b(view);
        if (c != 0 || d2 != 0) {
            fi fiVar3 = this.g;
            cO.o(fiVar3, C0301cy.a(fiVar3, c, d2));
            fi fiVar4 = this.g;
            cO.p(fiVar4, C0301cy.a(fiVar4, e2, f));
            fi fiVar5 = this.g;
            cO.q(fiVar5, C0301cy.a(fiVar5, a5, b));
        }
        if (e2 != 0 && f != 0 && (c != 0 || d2 != 0)) {
            fi fiVar6 = this.g;
            cO.b(fiVar6, C0300cx.a(fiVar6, c / e2, d2 / f));
        }
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        if (scrollX != 0 || scrollY != 0) {
            if (scrollX < 0 || scrollX > 65535 || scrollY < 0 || scrollY > 65535) {
                fi fiVar7 = this.g;
                cO.j(fiVar7, C0301cy.a(fiVar7, scrollX, scrollY));
            } else {
                fi fiVar8 = this.g;
                cO.l(fiVar8, C0302cz.a(fiVar8, scrollX, scrollY));
            }
        }
        cO.c(this.g, this.q.a(view.getClass().getName()));
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            C0237ao.a(this.g, textView.getInputType(), c0248az.g);
            if (!z) {
                if (c0248az.f != null) {
                    cO.f(this.g, this.q.a(c0248az.f));
                }
                String charSequence = textView.getText().toString();
                if (e == null || e.a()) {
                    charSequence = eH.a(view, charSequence);
                }
                cO.m(this.g, this.q.a(charSequence));
            }
        }
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            this.l.c(webView);
            cO.i(this.g, this.l.a(webView));
        }
        List a6 = this.x.a();
        try {
            Object[] objArr = {view};
            byte b2 = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            A(b2, b3, b3, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b4 = (byte) (-MyBillsEntityDataFactory[5]);
            byte b5 = b4;
            Object[] objArr3 = new Object[1];
            A(b4, b5, (byte) (b5 - 1), objArr3);
            if (a6.contains(Integer.valueOf(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()))) {
                RectF rectF = new RectF(i7, i6, i5, i8);
                if (rectF.width() * rectF.height() > this.z.width() * this.z.height()) {
                    this.z = rectF;
                    this.y = view;
                }
            }
            C0237ao.a(this.g, view, z, d, c0248az.c(), e);
            int b6 = cO.b(this.g);
            cK.a(this.g);
            fi fiVar9 = this.g;
            try {
                Object[] objArr4 = {view};
                byte b7 = (byte) (MyBillsEntityDataFactory[5] + 1);
                byte b8 = b7;
                Object[] objArr5 = new Object[1];
                A(b7, b8, b8, objArr5);
                Class<?> cls2 = Class.forName((String) objArr5[0]);
                byte b9 = (byte) (-MyBillsEntityDataFactory[5]);
                byte b10 = b9;
                Object[] objArr6 = new Object[1];
                A(b9, b10, (byte) (b10 - 1), objArr6);
                cK.a(fiVar9, ((Integer) cls2.getMethod((String) objArr6[0], Object.class).invoke(null, objArr4)).intValue());
                cK.c(this.g, i3);
                cK.b(this.g, b6);
                cK.d(this.g, i);
                cK.e(this.g, i2);
                return cK.b(this.g);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    private int a(View view, Object obj, int i, RectF rectF) {
        a("scanClippedView");
        if (this.f7857o) {
            C0290cn.a(this.g);
            fi fiVar = this.g;
            try {
                Object[] objArr = {obj};
                byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                A(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
                byte b4 = b3;
                A(b3, b4, (byte) (b4 - 1), new Object[1]);
                C0290cn.b(fiVar, ((Integer) cls.getMethod((String) r9[0], Object.class).invoke(null, objArr)).intValue());
                fi fiVar2 = this.g;
                try {
                    Object[] objArr3 = {view};
                    byte b5 = (byte) (MyBillsEntityDataFactory[5] + 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    A(b5, b6, b6, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    byte b7 = (byte) (-MyBillsEntityDataFactory[5]);
                    byte b8 = b7;
                    A(b7, b8, (byte) (b8 - 1), new Object[1]);
                    C0290cn.a(fiVar2, ((Integer) cls2.getMethod((String) r9[0], Object.class).invoke(null, objArr3)).intValue());
                    C0290cn.a(this.g, (byte) 1);
                    fi fiVar3 = this.g;
                    C0290cn.a(fiVar3, cC.a(fiVar3, (int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
                    this.r.add(Integer.valueOf(C0290cn.b(this.g)));
                    return a(view, obj, 0, i, 0, this.j.b(view), this.m.a((Object) view));
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        return i;
    }

    private int a(fi fiVar, View view, boolean z) {
        this.f7856a.clear();
        if (view instanceof VideoView) {
            cJ.a(fiVar);
            cJ.a(fiVar, ((VideoView) view).isPlaying());
            this.f7856a.add(Integer.valueOf(cN.a(fiVar, (byte) 2, cJ.b(fiVar))));
        }
        if (!z) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                int selectionStart = textView.getSelectionStart();
                int selectionEnd = textView.getSelectionEnd();
                if (selectionStart >= 0 && selectionEnd >= 0 && (selectionEnd > selectionStart || (textView.onCheckIsTextEditor() && textView.isCursorVisible() && textView.isFocused()))) {
                    cP.a(fiVar);
                    cP.a(fiVar, selectionStart);
                    cP.b(fiVar, selectionEnd);
                    this.f7856a.add(Integer.valueOf(cN.a(fiVar, (byte) 3, cP.b(fiVar))));
                }
                cI.a(fiVar);
                cI.a(fiVar, textView.onCheckIsTextEditor());
                this.f7856a.add(Integer.valueOf(cN.a(fiVar, (byte) 4, cI.b(fiVar))));
            }
            if (view instanceof CompoundButton) {
                cH.a(fiVar);
                cH.a(fiVar, ((CompoundButton) view).isChecked());
                this.f7856a.add(Integer.valueOf(cN.a(fiVar, (byte) 1, cH.b(fiVar))));
            }
        }
        return a(this.f7856a, fiVar);
    }

    private static int a(List list, fi fiVar) {
        if (list.size() > 0) {
            int[] iArr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                iArr[i] = ((Integer) list.get(i)).intValue();
            }
            return cO.a(fiVar, iArr);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public void b(final int i, final int i2, final C0236an c0236an) {
        final C0236an c0236an2 = new C0236an();
        Runnable runnable = new Runnable() { // from class: fsimpl.-$$Lambda$am$T4kbAm8aPJhcd5_2n-uVXTiayns
            @Override // java.lang.Runnable
            public final void run() {
                C0235am.this.b(c0236an2);
            }
        };
        this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$Iy7ylo6YQdbpSzIEZOi9F50UbeQ
            @Override // java.lang.Runnable
            public final void run() {
                C0235am.this.a(c0236an2, i, i2, c0236an);
            }
        });
        this.v.a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Pair pair, ViewGroup viewGroup, int[] iArr, RectF rectF, C0236an c0236an) {
        a((View) pair.first, viewGroup, iArr[0], (Rect) pair.second, rectF, c0236an);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, C0236an c0236an) {
        C0238ap.a(this, (FSComposeAndroidComposeView) view, this.w, c0236an);
    }

    private void a(final View view, final Object obj, final int i, Rect rect, RectF rectF, final C0236an c0236an) {
        final RectF rectF2;
        final RectF rectF3;
        a("scanChild");
        if (!a(obj, view)) {
            c0236an.f7858a = i;
            return;
        }
        boolean z = false;
        RectF rectF4 = null;
        if (a(view)) {
            RectF rectF5 = new RectF(rect);
            float f = -view.getLeft();
            float f2 = -view.getTop();
            rectF5.offset(f, f2);
            Matrix matrix = view.getMatrix();
            if (matrix.invert(matrix)) {
                matrix.mapRect(rectF5);
            }
            if (rectF != null) {
                if (matrix.rectStaysRect()) {
                    rectF4 = new RectF(rectF);
                    rectF4.offset(f, f2);
                    matrix.mapRect(rectF4);
                }
                rectF = rectF4;
            }
            if (this.p) {
                boolean intersects = rectF5.intersects(0.0f, 0.0f, view.getWidth() + 0.0f, view.getHeight() + 0.0f);
                rectF2 = rectF;
                rectF3 = rectF5;
                z = rectF != null ? (!rectF.contains(0.0f, 0.0f, r13, r1)) & intersects : intersects;
            } else {
                rectF2 = rectF;
                rectF3 = rectF5;
                z = true;
            }
        } else {
            rectF2 = rectF;
            rectF3 = null;
        }
        if (rectF3 != null) {
            if (z) {
                this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$2ABZsO7m2f16yRuffStKCaKNX0Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0235am.this.b(view, obj, i, rectF3, rectF2, c0236an);
                    }
                });
                return;
            }
            i = a(view, obj, i, rectF3);
        }
        c0236an.f7858a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public void b(final View view, final Object obj, final int i, final RectF rectF, final RectF rectF2, final C0236an c0236an) {
        a("scanViewAndChildren");
        if (!a(obj, view)) {
            c0236an.f7858a = i;
        } else if (this.j.a(view)) {
            c0236an.f7858a = i;
        } else {
            final C0248az a2 = this.m.a((Object) view);
            final boolean b = this.j.b(view);
            final int[] iArr = new int[1];
            final int[] iArr2 = new int[1];
            this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$-4VzHG4xfhVIlmPq13KyE97PeSQ
                @Override // java.lang.Runnable
                public final void run() {
                    C0235am.this.a(b, obj, view, rectF, c0236an, iArr, i, iArr2, a2);
                }
            });
            if (b) {
                return;
            }
            iArr2[0] = this.u.a(view, rectF, this.j, this.h, this.s, this.b);
            if (C0262bm.a(view)) {
                final C0236an c0236an2 = new C0236an();
                Runnable runnable = new Runnable() { // from class: fsimpl.-$$Lambda$am$VEmeBOktAKtMkXo76m8bF9Jlk5g
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0235am.this.a(view, c0236an2);
                    }
                };
                this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$P3ON1yAcwVMAMsG4GltwmTrVsi8
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0235am.b(iArr, c0236an2);
                    }
                });
                this.v.a(runnable);
            } else if (view instanceof ViewGroup) {
                ArrayList arrayList = new ArrayList();
                final ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup instanceof FSDispatchDraw) {
                    LinkedHashMap a3 = this.h.a();
                    if (a3 != null) {
                        for (Map.Entry entry : a3.entrySet()) {
                            View view2 = (View) entry.getKey();
                            Rect rect = (Rect) entry.getValue();
                            if (rect != null) {
                                arrayList.add(new Pair(view2, rect));
                            }
                        }
                    }
                } else {
                    Rect i2 = this.h.i();
                    List a4 = fe.a(viewGroup);
                    if (a4 != null) {
                        try {
                            Iterator it = a4.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new Pair((View) it.next(), i2));
                            }
                        } finally {
                            a4.clear();
                        }
                    } else {
                        boolean b2 = fe.b(viewGroup);
                        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                            arrayList.add(new Pair(viewGroup.getChildAt(b2 ? fe.a(viewGroup, viewGroup.getChildCount(), i3) : i3), i2));
                        }
                    }
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    final Pair pair = (Pair) arrayList.get(size);
                    final C0236an c0236an3 = new C0236an();
                    Runnable runnable2 = new Runnable() { // from class: fsimpl.-$$Lambda$am$9exAxpyaekq75IheaI2TShKGwtA
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0235am.this.a(pair, viewGroup, iArr, rectF2, c0236an3);
                        }
                    };
                    this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$sriZqAXJ1QC9qx9e5pL6jDZlvBU
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0235am.a(iArr, c0236an3);
                        }
                    });
                    this.v.a(runnable2);
                }
                arrayList.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, int[] iArr, RectF rectF, RectF[] rectFArr, C0236an c0236an) {
        b(view, (Object) null, iArr[0], rectF, rectFArr[0], c0236an);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public void b(C0230ah c0230ah, final fi fiVar, aP aPVar, final Context context, boolean z, boolean z2, boolean z3, final int i, final C0236an c0236an) {
        a("scanImpl");
        final DisplayMetrics a2 = eD.a();
        final int i2 = a2.widthPixels;
        final int i3 = a2.heightPixels;
        this.i.a();
        this.u = new C0234al(aPVar, c0230ah);
        this.s.a(z3);
        this.y = null;
        this.z = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        final long currentTimeMillis = System.currentTimeMillis();
        final long nanoTime = System.nanoTime();
        this.f = 0;
        this.g = fiVar;
        this.q = aPVar;
        this.h = this.k.a(aPVar, c0230ah);
        this.f7857o = z;
        this.p = z2;
        final C0236an c0236an2 = new C0236an();
        Runnable runnable = new Runnable() { // from class: fsimpl.-$$Lambda$am$UTGJm3_OzhULKj3PgZ2Dt6w7RZM
            @Override // java.lang.Runnable
            public final void run() {
                C0235am.this.b(i2, i3, c0236an2);
            }
        };
        this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$K4jAucM_0g-Zr6Sq82ujj7JOwPY
            @Override // java.lang.Runnable
            public final void run() {
                C0235am.this.a(c0236an2, fiVar, currentTimeMillis, a2, context, i, i3, nanoTime, c0236an);
            }
        });
        this.v.a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public void b(final C0236an c0236an) {
        boolean z;
        List list;
        final int[] iArr = new int[1];
        final RectF[] rectFArr = new RectF[1];
        List a2 = this.c.a();
        int size = a2.size();
        int i = 0;
        while (true) {
            if (i < size) {
                View findFocus = ((View) a2.get(i)).findFocus();
                if (findFocus != null && this.j.b(findFocus)) {
                    z = true;
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        this.h.e();
        this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$vlOgLEsONeB3_dk4UZuRkbKvE9k
            @Override // java.lang.Runnable
            public final void run() {
                C0235am.a(C0236an.this, iArr);
            }
        });
        int i2 = 0;
        while (i2 < size) {
            final View view = (View) a2.get(i2);
            if (a(view) && !(z && bI.a(view))) {
                final RectF rectF = new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                final C0236an c0236an2 = new C0236an();
                list = a2;
                Runnable runnable = new Runnable() { // from class: fsimpl.-$$Lambda$am$rNZ75oMp9Ldw-LNWqOCQQ9wjNAo
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0235am.this.a(view, iArr, rectF, rectFArr, c0236an2);
                    }
                };
                this.v.a(new Runnable() { // from class: fsimpl.-$$Lambda$am$m9C-RYO_4XDIx4DmabWeGKJ-t3w
                    @Override // java.lang.Runnable
                    public final void run() {
                        C0235am.this.a(iArr, c0236an2, view, rectF, rectFArr);
                    }
                });
                this.v.a(runnable);
            } else {
                list = a2;
            }
            i2++;
            a2 = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C0236an c0236an, int i, int i2, C0236an c0236an2) {
        int i3 = c0236an.f7858a;
        cO.a(this.g);
        cO.a(this.g, true);
        fi fiVar = this.g;
        cO.a(fiVar, cC.a(fiVar, 0, 0, i, i2));
        int b = cO.b(this.g);
        if (this.f7857o) {
            C0290cn.a(this.g);
            C0290cn.a(this.g, 0L);
            C0290cn.b(this.g, 0L);
            fi fiVar2 = this.g;
            C0290cn.b(fiVar2, fiVar2.a());
            C0290cn.c(this.g, this.f);
            this.r.add(Integer.valueOf(C0290cn.b(this.g)));
        }
        cK.a(this.g);
        cK.b(this.g, b);
        cK.d(this.g, i3);
        c0236an2.f7858a = cK.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C0236an c0236an, fi fiVar, long j, DisplayMetrics displayMetrics, Context context, int i, int i2, long j2, C0236an c0236an2) {
        try {
            int i3 = c0236an.f7858a;
            cL.a(fiVar);
            cL.a(fiVar, j);
            cL.b(fiVar, displayMetrics.densityDpi);
            cL.d(fiVar, i3);
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            int i4 = displayMetrics2.widthPixels;
            if (i != 0) {
                i2 = displayMetrics2.heightPixels - i;
            }
            cL.c(fiVar, cC.a(fiVar, 0, 0, i4, i2));
            cL.a(fiVar, (int) (System.nanoTime() - j2));
            this.g = null;
            this.q = null;
            this.u = null;
            this.k.a(this.h);
            this.h = null;
            this.s.a();
            this.l.b();
            c0236an2.f7858a = cL.b(fiVar);
        } catch (Throwable th) {
            this.g = null;
            this.q = null;
            this.u = null;
            this.k.a(this.h);
            this.h = null;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(C0236an c0236an, int[] iArr) {
        c0236an.f7858a = iArr[0];
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, int i) {
        while ((i & (-128)) != 0) {
            byteArrayOutputStream.write((byte) ((i & 127) | 128));
            i >>>= 7;
        }
        byteArrayOutputStream.write((byte) i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, Object obj, View view, RectF rectF, C0236an c0236an, int[] iArr, int i, int[] iArr2, C0248az c0248az) {
        if (!z && this.f7857o) {
            C0290cn.a(this.g);
            fi fiVar = this.g;
            try {
                Object[] objArr = {obj};
                byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                A(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
                byte b4 = b3;
                A(b3, b4, (byte) (b4 - 1), new Object[1]);
                C0290cn.b(fiVar, ((Integer) cls.getMethod((String) r11[0], Object.class).invoke(null, objArr)).intValue());
                fi fiVar2 = this.g;
                try {
                    Object[] objArr3 = {view};
                    byte b5 = (byte) (MyBillsEntityDataFactory[5] + 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    A(b5, b6, b6, objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    byte b7 = (byte) (-MyBillsEntityDataFactory[5]);
                    byte b8 = b7;
                    A(b7, b8, (byte) (b8 - 1), new Object[1]);
                    C0290cn.a(fiVar2, ((Integer) cls2.getMethod((String) r11[0], Object.class).invoke(null, objArr3)).intValue());
                    C0290cn.a(this.g, Byte.MIN_VALUE);
                    fi fiVar3 = this.g;
                    C0290cn.a(fiVar3, cC.a(fiVar3, (int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
                    this.r.add(Integer.valueOf(C0290cn.b(this.g)));
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        c0236an.f7858a = a(view, obj, iArr[0], i, iArr2[0], z, c0248az);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int[] iArr, C0236an c0236an) {
        iArr[0] = c0236an.f7858a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int[] iArr, C0236an c0236an, View view, RectF rectF, RectF[] rectFArr) {
        iArr[0] = c0236an.f7858a;
        view.getLocationOnScreen(new int[2]);
        rectF.offset(r3[0], r3[1]);
        Window a2 = this.c.a(view);
        if (a2 == null || !a2.isFloating()) {
            return;
        }
        if (rectFArr[0] == null) {
            rectFArr[0] = rectF;
        } else if (rectF.contains(rectFArr[0])) {
            rectFArr[0].union(rectF);
        }
    }

    private boolean a(View view) {
        return (view.getVisibility() == 0) && (view.getWidth() > 0 && view.getHeight() > 0) && !C0256bg.c(view);
    }

    private boolean a(Object obj, View view) {
        if (this.n) {
            if (view.isAttachedToWindow()) {
                return !(obj instanceof View) || view.getParent() == obj;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int[] iArr, C0236an c0236an) {
        iArr[0] = c0236an.f7858a;
    }

    public int a(final C0230ah c0230ah, final fi fiVar, final aP aPVar, final Context context, final boolean z, final boolean z2, final boolean z3, final int i, Throwable[] thArr, long[] jArr) {
        C0350eu.b("'scan' MUST NOT be run on the UI thread.", new Object[0]);
        final C0236an c0236an = new C0236an();
        eR b = this.v.b(new Runnable() { // from class: fsimpl.-$$Lambda$am$r_KNG_zPHsJwPcU8P-c3OlorC9Q
            @Override // java.lang.Runnable
            public final void run() {
                C0235am.this.b(c0230ah, fiVar, aPVar, context, z, z2, z3, i, c0236an);
            }
        });
        jArr[0] = b.b;
        if (b.f7960a != null) {
            Log.e("Unexpected exception in scan", b.f7960a);
            thArr[0] = b.f7960a;
            c0236an.f7858a = -1;
        }
        return c0236an.f7858a;
    }

    public int a(C0248az c0248az) {
        this.t.reset();
        int a2 = this.q.a(c0248az.b);
        if (a2 != 0) {
            a(this.t, this.q.a("id"));
            a(this.t, a2);
        }
        int a3 = this.q.a(c0248az.f7865a);
        if (a3 != 0) {
            a(this.t, this.q.a("tagName"));
            a(this.t, a3);
        }
        List<String> list = c0248az.c;
        if (list != null && !list.isEmpty()) {
            int a4 = this.q.a("className");
            for (String str : list) {
                a(this.t, a4);
                a(this.t, this.q.a(str));
            }
        }
        Map map = c0248az.d;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                a(this.t, this.q.a((String) entry.getKey()));
                a(this.t, this.q.a((String) entry.getValue()));
            }
        }
        if (this.t.size() > 0) {
            return cO.a(this.g, this.t.toByteArray());
        }
        return 0;
    }

    public int a(fi fiVar) {
        if (this.r.size() == 0) {
            return 0;
        }
        cD.f(fiVar, this.r.size());
        for (int i = 0; i < this.r.size(); i++) {
            fiVar.d(((Integer) this.r.get(i)).intValue());
        }
        int b = fiVar.b();
        this.r.clear();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public eO a() {
        return this.v;
    }

    public void a(FSComposeLayoutNode fSComposeLayoutNode, View view, int i, Rect rect, C0236an c0236an) {
        a(view, fSComposeLayoutNode, i, rect, (RectF) null, c0236an);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (C0350eu.f7977a) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            sb.append(str);
            sb.append("' MUST be run on the UI thread.");
            C0350eu.a(sb.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(FSComposeAndroidComposeView fSComposeAndroidComposeView, FSComposeLayoutNode fSComposeLayoutNode, FSComposeLayoutNode fSComposeLayoutNode2) {
        if (this.n) {
            if (fSComposeLayoutNode2._fsIsAttached() && fSComposeLayoutNode2._fsGetParent() == fSComposeLayoutNode) {
                return fSComposeLayoutNode != null || fSComposeLayoutNode2._fsGetOwner() == fSComposeAndroidComposeView;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0366p b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0367q c() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0311dh e() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0234al f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0223aa g() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aP h() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.f++;
    }

    public int j() {
        View view = this.y;
        if (view == null) {
            return 0;
        }
        try {
            Object[] objArr = {view};
            byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            A(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            A(b3, b4, (byte) (b4 - 1), objArr3);
            return ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
