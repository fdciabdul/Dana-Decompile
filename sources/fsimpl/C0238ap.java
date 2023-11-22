package fsimpl;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.fullstory.instrumentation.frameworks.compose.FSComposeAndroidComposeView;
import com.fullstory.instrumentation.frameworks.compose.FSComposeAnnotatedString;
import com.fullstory.instrumentation.frameworks.compose.FSComposeCanvas;
import com.fullstory.instrumentation.frameworks.compose.FSComposeDraw;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutCoordinates;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;
import com.fullstory.instrumentation.frameworks.compose.FSComposeModifier;
import com.fullstory.instrumentation.frameworks.compose.FSComposeNodeCoordinator;
import com.fullstory.instrumentation.frameworks.compose.FSComposeRect;
import com.fullstory.instrumentation.frameworks.compose.FSComposeRenderNodeLayer;
import com.fullstory.instrumentation.frameworks.compose.FSComposeSemanticsConfiguration;
import com.fullstory.instrumentation.frameworks.compose.FSComposeSemanticsModifier;
import com.google.common.base.Ascii;
import java.util.Iterator;
import java.util.List;

/* renamed from: fsimpl.ap  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0238ap {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {12, -73, 84, 57, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 196;

    private static int a(C0235am c0235am, FSComposeAndroidComposeView fSComposeAndroidComposeView, FSComposeLayoutNode fSComposeLayoutNode, FSComposeLayoutNode fSComposeLayoutNode2, boolean z, boolean z2, C0370t c0370t, int i, int i2, int i3, RectF rectF, int i4) {
        c0235am.a("scanLayoutNode");
        if (c0235am.a(fSComposeAndroidComposeView, fSComposeLayoutNode, fSComposeLayoutNode2)) {
            c0235am.i();
            C0248az a2 = c0235am.e().a((Object) fSComposeLayoutNode2);
            fi d = c0235am.d();
            aP h = c0235am.h();
            int a3 = c0235am.a(a2);
            cO.a(d);
            cO.k(d, a3);
            FSComposeNodeCoordinator _fsGetOuterCoordinator = fSComposeLayoutNode2._fsGetOuterCoordinator();
            if (!(_fsGetOuterCoordinator == null ? false : _fsGetOuterCoordinator._fsIsTransparent())) {
                cO.b(d, (byte) -1);
            }
            cO.a(d, cC.a(d, (int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (z) {
                C0237ao.a(c0235am.b(), (View) fSComposeAndroidComposeView, (int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            }
            cO.c(d, h.a(fSComposeLayoutNode2.getClass().getName()));
            a(d, fSComposeLayoutNode2, z, c0370t, a2, h, i4);
            C0237ao.a(d, fSComposeLayoutNode2, z, z2, a2.c(), c0370t);
            int b = cO.b(d);
            cK.a(d);
            try {
                Object[] objArr = {fSComposeLayoutNode2};
                byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                byte b3 = (byte) (b2 - 1);
                Object[] objArr2 = new Object[1];
                c(b2, b3, b3, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
                byte b5 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
                Object[] objArr3 = new Object[1];
                c(b4, b5, (byte) (b5 - 1), objArr3);
                cK.a(d, ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
                cK.c(d, i);
                cK.b(d, b);
                cK.d(d, i2);
                cK.e(d, i3);
                return cK.b(d);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return i3;
    }

    public static RectF a(FSComposeLayoutNode fSComposeLayoutNode) {
        FSComposeRect _fsGetBoundsInParent;
        FSComposeLayoutCoordinates _fsGetCoordinates = fSComposeLayoutNode._fsGetCoordinates();
        if (_fsGetCoordinates == null || (_fsGetBoundsInParent = _fsGetCoordinates._fsGetBoundsInParent()) == null) {
            return null;
        }
        float _fsGetLeft = _fsGetBoundsInParent._fsGetLeft();
        float _fsGetTop = _fsGetBoundsInParent._fsGetTop();
        return new RectF(_fsGetLeft, _fsGetTop, _fsGetBoundsInParent._fsGetWidth() + _fsGetLeft, _fsGetBoundsInParent._fsGetHeight() + _fsGetTop);
    }

    private static CharSequence a(final FSComposeLayoutNode fSComposeLayoutNode, final boolean z) {
        final StringBuilder[] sbArr = new StringBuilder[1];
        C0264bo.a(fSComposeLayoutNode._fsGetModifier(), new InterfaceC0265bp() { // from class: fsimpl.-$$Lambda$ap$536-pJSrEuY6umNK4g3oo2CMzvQ
            @Override // fsimpl.InterfaceC0265bp
            public final void accept(FSComposeModifier fSComposeModifier) {
                C0238ap.a(FSComposeLayoutNode.this, z, sbArr, fSComposeModifier);
            }
        });
        return sbArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FSComposeLayoutNode fSComposeLayoutNode, boolean z, StringBuilder[] sbArr, FSComposeModifier fSComposeModifier) {
        FSComposeSemanticsConfiguration _fsGetSemanticsConfiguration;
        if (!(fSComposeModifier instanceof FSComposeSemanticsModifier) || (_fsGetSemanticsConfiguration = fSComposeLayoutNode._fsGetSemanticsConfiguration((FSComposeSemanticsModifier) fSComposeModifier)) == null) {
            return;
        }
        if (z) {
            a(sbArr, _fsGetSemanticsConfiguration._fsGetEditableText());
            return;
        }
        List _fsGetText = _fsGetSemanticsConfiguration._fsGetText();
        if (_fsGetText != null) {
            Iterator it = _fsGetText.iterator();
            while (it.hasNext()) {
                a(sbArr, (FSComposeAnnotatedString) it.next());
            }
        }
    }

    public static void a(FSComposeRenderNodeLayer fSComposeRenderNodeLayer, Object obj) {
        boolean _fsIsDirty = fSComposeRenderNodeLayer._fsIsDirty();
        fSComposeRenderNodeLayer._fsDrawLayer(obj);
        if (!_fsIsDirty || fSComposeRenderNodeLayer._fsIsDirty()) {
            return;
        }
        fSComposeRenderNodeLayer._fsSetDirty(true);
    }

    public static void a(C0235am c0235am, FSComposeAndroidComposeView fSComposeAndroidComposeView, int i, C0236an c0236an) {
        c0235am.a("scanLayoutNodeAndChildren");
        FSComposeLayoutNode _fsGetRoot = fSComposeAndroidComposeView._fsGetRoot();
        a(c0235am, fSComposeAndroidComposeView, _fsGetRoot._fsWrapCanvas(c0235am.g()), (FSComposeLayoutNode) null, _fsGetRoot, 0, 0, i, c0236an);
    }

    private static void a(final C0235am c0235am, final FSComposeAndroidComposeView fSComposeAndroidComposeView, final FSComposeCanvas fSComposeCanvas, final FSComposeLayoutNode fSComposeLayoutNode, final FSComposeLayoutNode fSComposeLayoutNode2, final int i, final int i2, final int i3, final C0236an c0236an) {
        List list;
        List list2;
        int i4;
        final int[] iArr;
        c0235am.a("scanLayoutNodeAndChildren");
        if (fSComposeLayoutNode2 == null || fSComposeCanvas == null) {
            c0236an.f7858a = i;
        } else if (!(fSComposeLayoutNode2 instanceof FSComposeDraw)) {
            c0236an.f7858a = i;
        } else if (!c0235am.a(fSComposeAndroidComposeView, fSComposeLayoutNode, fSComposeLayoutNode2)) {
            c0236an.f7858a = i;
        } else {
            C0367q c = c0235am.c();
            if (c.a(fSComposeLayoutNode2)) {
                c0236an.f7858a = i;
                return;
            }
            final RectF a2 = a(fSComposeLayoutNode2);
            if (a2 == null) {
                c0236an.f7858a = i;
                return;
            }
            int[] iArr2 = new int[1];
            final boolean b = c.b(fSComposeLayoutNode2);
            final boolean d = c.d(fSComposeLayoutNode2);
            final C0370t e = c.e(fSComposeLayoutNode2);
            if (b) {
                list = null;
                list2 = null;
                i4 = 0;
            } else {
                C0234al f = c0235am.f();
                C0223aa g = c0235am.g();
                int a3 = f.a((FSComposeDraw) fSComposeLayoutNode2, c, fSComposeCanvas, g, a2);
                List b2 = g.b();
                list2 = g.c();
                i4 = a3;
                list = b2;
            }
            eO a4 = c0235am.a();
            List list3 = list;
            List list4 = list2;
            final int[] iArr3 = iArr2;
            final int i5 = i4;
            a4.a(new Runnable() { // from class: fsimpl.-$$Lambda$ap$U-aJsgpD32xirox-kBjUkfZFGA0
                @Override // java.lang.Runnable
                public final void run() {
                    C0238ap.a(C0236an.this, c0235am, fSComposeAndroidComposeView, fSComposeLayoutNode, fSComposeLayoutNode2, b, d, e, i5, iArr3, i, a2, i3);
                }
            });
            if (list4 != null) {
                int size = list4.size() - 1;
                while (size >= 0) {
                    List list5 = list4;
                    Object obj = list5.get(size);
                    if (obj instanceof FSComposeLayoutNode) {
                        final C0236an c0236an2 = new C0236an();
                        final FSComposeLayoutNode fSComposeLayoutNode3 = (FSComposeLayoutNode) obj;
                        final int[] iArr4 = iArr3;
                        Runnable runnable = new Runnable() { // from class: fsimpl.-$$Lambda$ap$PtM3nCW67pdhhPZ9XrZcmM-FV74
                            @Override // java.lang.Runnable
                            public final void run() {
                                C0238ap.a(C0235am.this, fSComposeAndroidComposeView, fSComposeCanvas, fSComposeLayoutNode2, fSComposeLayoutNode3, iArr4, i2, i3, c0236an2);
                            }
                        };
                        iArr = iArr3;
                        a4.a(new Runnable() { // from class: fsimpl.-$$Lambda$ap$IDBxJYBbFTiO8yhh3GZFCs52osc
                            @Override // java.lang.Runnable
                            public final void run() {
                                C0238ap.b(iArr, c0236an2);
                            }
                        });
                        a4.a(runnable);
                    } else {
                        iArr = iArr3;
                    }
                    size--;
                    iArr3 = iArr;
                    list4 = list5;
                }
            }
            final int[] iArr5 = iArr3;
            if (list3 != null) {
                for (int size2 = list3.size() - 1; size2 >= 0; size2--) {
                    final View view = (View) list3.get(size2);
                    final Rect rect = new Rect((int) a2.left, (int) a2.top, (int) a2.right, (int) a2.bottom);
                    final C0236an c0236an3 = new C0236an();
                    Runnable runnable2 = new Runnable() { // from class: fsimpl.-$$Lambda$ap$FjPtt7fbI5Mwl33DO9ncPd9uyqo
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0238ap.a(C0235am.this, fSComposeLayoutNode2, view, iArr5, rect, c0236an3);
                        }
                    };
                    a4.a(new Runnable() { // from class: fsimpl.-$$Lambda$ap$JeRW_ZcAubMPDJcBnNlBcF6A0mE
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0238ap.a(iArr5, c0236an3);
                        }
                    });
                    a4.a(runnable2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(C0235am c0235am, FSComposeAndroidComposeView fSComposeAndroidComposeView, FSComposeCanvas fSComposeCanvas, FSComposeLayoutNode fSComposeLayoutNode, FSComposeLayoutNode fSComposeLayoutNode2, int[] iArr, int i, int i2, C0236an c0236an) {
        a(c0235am, fSComposeAndroidComposeView, fSComposeCanvas, fSComposeLayoutNode, fSComposeLayoutNode2, iArr[0], i + 1, i2, c0236an);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(C0235am c0235am, FSComposeLayoutNode fSComposeLayoutNode, View view, int[] iArr, Rect rect, C0236an c0236an) {
        c0235am.a(fSComposeLayoutNode, view, iArr[0], rect, c0236an);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(C0236an c0236an, C0235am c0235am, FSComposeAndroidComposeView fSComposeAndroidComposeView, FSComposeLayoutNode fSComposeLayoutNode, FSComposeLayoutNode fSComposeLayoutNode2, boolean z, boolean z2, C0370t c0370t, int i, int[] iArr, int i2, RectF rectF, int i3) {
        c0236an.f7858a = a(c0235am, fSComposeAndroidComposeView, fSComposeLayoutNode, fSComposeLayoutNode2, z, z2, c0370t, i, iArr[0], i2, rectF, i3);
    }

    private static void a(fi fiVar, FSComposeLayoutNode fSComposeLayoutNode, boolean z, C0370t c0370t, C0248az c0248az, aP aPVar, int i) {
        if (i >= 3) {
            if (c0248az.g != 0) {
                CharSequence a2 = c0248az.g == 4 ? null : a(fSComposeLayoutNode, c0248az.d());
                C0237ao.a(fiVar, 1, c0248az.g);
                if (z || a2 == null) {
                    return;
                }
                cO.m(fiVar, aPVar.a(c0370t.b() ? a2.toString() : eH.a(fSComposeLayoutNode, a2.toString())));
            }
        }
    }

    public static void a(Object obj, View view, C0223aa c0223aa) {
        c0223aa.b(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int[] iArr, C0236an c0236an) {
        iArr[0] = c0236an.f7858a;
    }

    private static void a(StringBuilder[] sbArr, FSComposeAnnotatedString fSComposeAnnotatedString) {
        String _fsGetText;
        if (fSComposeAnnotatedString == null || (_fsGetText = fSComposeAnnotatedString._fsGetText()) == null) {
            return;
        }
        StringBuilder sb = sbArr[0];
        if (sb == null) {
            sb = new StringBuilder();
            sbArr[0] = sb;
        } else if (sb.length() > 0 && !Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.append(" ");
        }
        sb.append(_fsGetText);
    }

    public static boolean a(Object obj, C0223aa c0223aa) {
        c0223aa.a(obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int[] iArr, C0236an c0236an) {
        iArr[0] = c0236an.f7858a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = fsimpl.C0238ap.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 * 3
            int r9 = r9 + 16
            int r7 = r7 + 105
            int r8 = r8 * 15
            int r8 = 19 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2f
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2f:
            int r8 = r8 + 1
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0238ap.c(int, short, short, java.lang.Object[]):void");
    }
}
