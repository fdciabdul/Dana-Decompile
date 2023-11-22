package fsimpl;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.flexbox.FlexItem;

/* renamed from: fsimpl.ao  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C0237ao {
    private static int a(View view, int i) {
        if (view.isClickable()) {
            i |= 1;
        }
        if (view.isEnabled()) {
            i |= 2;
        }
        if (view.isFocusable()) {
            i |= 4;
        }
        if (view.isFocused()) {
            i |= 8;
        }
        if (view.isPressed()) {
            i |= 16;
        }
        if (view.isSelected()) {
            i |= 32;
        }
        if (view.isActivated()) {
            i |= 64;
        }
        if (view.isHovered()) {
            i |= 128;
        }
        if (view.isOpaque()) {
            i |= 512;
        }
        if (view.isHardwareAccelerated()) {
            i |= 1024;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getClipChildren()) {
                i |= 2048;
            }
            if (viewGroup.getClipToPadding()) {
                i |= 4096;
            }
        }
        return view instanceof WebView ? i | 8192 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(fi fiVar, int i, int i2) {
        cO.g(fiVar, (i & FlexItem.MAX_SIZE) | (i2 << 24));
    }

    private static void a(fi fiVar, Object obj, boolean z, C0370t c0370t) {
        int i = z ? 256 : 0;
        if (c0370t != null && c0370t.a()) {
            i |= 32768;
        }
        if (obj instanceof View) {
            i = a((View) obj, i);
        }
        cO.h(fiVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(fi fiVar, Object obj, boolean z, boolean z2, boolean z3, C0370t c0370t) {
        a(fiVar, obj, z, c0370t);
        a(fiVar, z2, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(fsimpl.fi r0, boolean r1, boolean r2) {
        /*
            if (r2 == 0) goto L4
            r1 = r1 | 2
        L4:
            fsimpl.cO.r(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0237ao.a(fsimpl.fi, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(C0366p c0366p, View view, int i, int i2, int i3, int i4) {
        Matrix matrix = new Matrix();
        view.transformMatrixToGlobal(matrix);
        c0366p.a(matrix, i, i2, i3, i4);
    }
}
