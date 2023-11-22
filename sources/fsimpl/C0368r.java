package fsimpl;

import android.view.View;

/* renamed from: fsimpl.r  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
class C0368r {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f8000a = eV.a("androidx.compose.ui.platform.AndroidComposeView");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj) {
        return (obj instanceof View) && f8000a != null && obj.getClass() == f8000a;
    }
}
