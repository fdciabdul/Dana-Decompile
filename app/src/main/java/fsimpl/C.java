package fsimpl;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class C {
    private final C0367q b;
    private final C0360j c;
    private final RustInterface d;
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private final Set g = new HashSet();
    public static final byte[] getAuthRequestContext = {11, -83, -14, 91, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 200;

    /* renamed from: a  reason: collision with root package name */
    private static final String f7800a = new String();

    public C(C0360j c0360j, RustInterface rustInterface, C0367q c0367q) {
        this.c = c0360j;
        this.d = rustInterface;
        this.b = c0367q;
    }

    private static String a(C0367q c0367q, View view) {
        String a2;
        CharSequence text;
        if (view instanceof TextView) {
            return (!c0367q.e(view).b() || (text = ((TextView) view).getText()) == null) ? f7800a : text.toString();
        } else if ((view instanceof ViewGroup) && C0256bg.d(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!c0367q.b(childAt) && (a2 = a(c0367q, childAt)) != null) {
                    return a2;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r6 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r6, fsimpl.E r7) {
        /*
            r5 = this;
        L0:
            boolean r0 = r6 instanceof android.view.ViewGroup
            r1 = 0
            if (r0 == 0) goto L24
            r0 = r6
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r2 = 0
        L9:
            int r3 = r0.getChildCount()
            if (r2 >= r3) goto L24
            android.view.View r3 = r0.getChildAt(r2)
            boolean r4 = r3.isPressed()
            if (r4 == 0) goto L21
            int r4 = r3.getVisibility()
            if (r4 != 0) goto L21
            r6 = r3
            goto L0
        L21:
            int r2 = r2 + 1
            goto L9
        L24:
            r5.a(r6, r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C.a(android.view.View, fsimpl.E):void");
    }

    private void a(View view, E e, short s) {
        if (view != null) {
            a((Object) view, e, s);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpectedly captured a null view in ");
        sb.append(e);
        Log.e(sb.toString());
    }

    private void a(View view, List list, List list2) {
        if (view == null) {
            return;
        }
        this.c.b(view);
        if (view.isPressed()) {
            list.add(view);
        } else {
            list2.add(view);
        }
        if (view instanceof ViewGroup) {
            a((ViewGroup) view, list, list2);
        }
    }

    private void a(ViewGroup viewGroup, List list, List list2) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            a(viewGroup.getChildAt(i), list, list2);
        }
    }

    private void a(FSComposeLayoutNode fSComposeLayoutNode, E e) {
        a((Object) fSComposeLayoutNode, e, (short) 2);
    }

    private void a(Object obj, E e, short s) {
        try {
            byte b = (byte) (-getAuthRequestContext[5]);
            Object[] objArr = new Object[1];
            h(b, (byte) (b - 1), (byte) (-getAuthRequestContext[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext[5] + 1);
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            h(b2, b3, b3, objArr2);
            int intValue = ((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, obj)).intValue();
            if (!this.b.b(obj)) {
                this.d.a(s, intValue, obj instanceof View ? e((View) obj) : null);
                boolean z = s == 2 || s == 3 || s == 4 || s == 5;
                if (this.b.c(obj) && z) {
                    this.d.a((short) 1, intValue);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Omitting ");
            sb.append(e);
            sb.append(" event of blocked ");
            sb.append(Integer.toHexString(intValue));
            sb.append(" (");
            sb.append(obj.getClass());
            sb.append(")");
            Log.d(sb.toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private boolean a(MotionEvent motionEvent, I i, Window.Callback callback, Window window) {
        if (callback != null) {
            int i2 = D.f7801a[i.ordinal()];
            if (i2 == 1) {
                return callback.dispatchGenericMotionEvent(motionEvent);
            }
            if (i2 == 2) {
                return callback.dispatchTouchEvent(motionEvent);
            }
            if (i2 == 3) {
                return callback.dispatchTrackballEvent(motionEvent);
            }
        } else {
            int i3 = D.f7801a[i.ordinal()];
            if (i3 == 1) {
                return window.superDispatchGenericMotionEvent(motionEvent);
            }
            if (i3 == 2) {
                return window.superDispatchTouchEvent(motionEvent);
            }
            if (i3 == 3) {
                return window.superDispatchTrackballEvent(motionEvent);
            }
        }
        return false;
    }

    private void b(View view, E e) {
        a(view, e, (short) 1);
    }

    private boolean b(MotionEvent motionEvent, I i, Window window, Window.Callback callback, int i2) {
        boolean z = i2 == 0 || i2 == 5;
        boolean z2 = i2 == 1 || i2 == 6;
        if (!z && !z2) {
            this.c.a(window.peekDecorView());
            return a(motionEvent, i, callback, window);
        }
        a(window.peekDecorView(), this.e, this.f);
        boolean a2 = a(motionEvent, i, callback, window);
        if (z) {
            for (View view : this.f) {
                if (view.isPressed()) {
                    a(view, E.DOWN);
                    return a2;
                }
            }
        }
        if (z2) {
            for (View view2 : this.e) {
                if (!view2.isPressed()) {
                    this.g.add(view2.getParent());
                }
            }
            for (View view3 : this.e) {
                if (!view3.isPressed() && !this.g.contains(view3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Detected up touch: ");
                    sb.append(view3);
                    Log.d(sb.toString());
                    b(view3, E.UP);
                    return a2;
                }
            }
            Iterator it = this.f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View view4 = (View) it.next();
                if (view4.isPressed()) {
                    a(view4, E.UP);
                    b(view4, E.UP);
                    break;
                }
            }
        }
        return a2;
    }

    private void c(View view, E e) {
        a(view, e, (short) 2);
    }

    private void d(View view, E e) {
        a(view, e, (short) 4);
    }

    private String e(View view) {
        String a2 = a(this.b, view);
        if (a2 == f7800a) {
            return null;
        }
        return a2;
    }

    private void e(View view, E e) {
        a(view, e, (short) 3);
    }

    private void f(View view, E e) {
        a(view, e, (short) 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 105
            byte[] r0 = fsimpl.C.getAuthRequestContext
            int r8 = r8 * 4
            int r8 = r8 + 16
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r4 = 0
            r9 = r8
            r8 = r7
            goto L2c
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2c:
            int r7 = r7 + r3
            int r7 = r7 + 2
            int r8 = r8 + 1
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C.h(short, byte, int, java.lang.Object[]):void");
    }

    public void a() {
        this.c.a(this);
    }

    public void a(View view) {
        c(view, E.TIMER);
    }

    public void a(FSComposeLayoutNode fSComposeLayoutNode) {
        a(fSComposeLayoutNode, E.TIMER);
    }

    public boolean a(MotionEvent motionEvent, I i, Window window, Window.Callback callback, int i2) {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        boolean b = b(motionEvent, i, window, callback, i2);
        this.e.clear();
        this.f.clear();
        this.g.clear();
        return b;
    }

    public void b() {
        this.c.a((C) null);
    }

    public void b(View view) {
        d(view, E.TIMER);
    }

    public void c(View view) {
        e(view, E.TIMER);
    }

    public void d(View view) {
        f(view, E.TIMER);
    }
}
