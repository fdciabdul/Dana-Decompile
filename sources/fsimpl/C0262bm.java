package fsimpl;

import android.view.View;
import com.fullstory.instrumentation.frameworks.compose.FSComposeAndroidComposeView;

/* renamed from: fsimpl.bm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0262bm {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f7892a;

    static {
        f7892a = C0256bg.a() ? eV.a("androidx.compose.ui.platform.AndroidComposeView") : null;
    }

    public static boolean a(View view) {
        return (view instanceof FSComposeAndroidComposeView) && C0263bn.a(view, f7892a);
    }
}
