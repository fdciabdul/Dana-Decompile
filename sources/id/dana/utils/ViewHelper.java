package id.dana.utils;

import android.view.View;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/ViewHelper;", "", "Landroid/view/View;", "p0", "Ljava/lang/Runnable;", "p1", "", "getAuthRequestContext", "(Landroid/view/View;Ljava/lang/Runnable;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewHelper {
    public static final ViewHelper INSTANCE = new ViewHelper();

    private ViewHelper() {
    }

    @JvmStatic
    public static final void getAuthRequestContext(View p0, final Runnable p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0 == null) {
            return;
        }
        FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
        FirstDrawListener.Companion.MyBillsEntityDataFactory(p0, new FirstDrawListener.OnFirstDrawCallback() { // from class: id.dana.utils.ViewHelper$thenUIReady$1
            @Override // id.dana.utils.measureloadscreen.FirstDrawListener.OnFirstDrawCallback
            public final void BuiltInFictitiousFunctionClassFactory() {
            }

            @Override // id.dana.utils.measureloadscreen.FirstDrawListener.OnFirstDrawCallback
            public final void getAuthRequestContext() {
                p1.run();
            }
        });
    }
}
