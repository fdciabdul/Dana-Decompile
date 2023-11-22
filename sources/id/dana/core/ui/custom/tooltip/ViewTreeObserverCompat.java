package id.dana.core.ui.custom.tooltip;

import android.os.Build;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/core/ui/custom/tooltip/ViewTreeObserverCompat;", "", "Landroid/view/ViewTreeObserver;", "p0", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "p1", "", "getAuthRequestContext", "(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "Lid/dana/core/ui/custom/tooltip/ViewTreeObserverCompat$ViewTreeObserverCompatBaseImpl;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/custom/tooltip/ViewTreeObserverCompat$ViewTreeObserverCompatBaseImpl;", "<init>", "()V", "ViewTreeObserverCompatApi16Impl", "ViewTreeObserverCompatBaseImpl"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ViewTreeObserverCompat {
    private static ViewTreeObserverCompatBaseImpl BuiltInFictitiousFunctionClassFactory;
    public static final ViewTreeObserverCompat INSTANCE = new ViewTreeObserverCompat();

    private ViewTreeObserverCompat() {
    }

    static {
        ViewTreeObserverCompatApi16Impl viewTreeObserverCompatBaseImpl;
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserverCompatBaseImpl = new ViewTreeObserverCompatApi16Impl();
        } else {
            viewTreeObserverCompatBaseImpl = new ViewTreeObserverCompatBaseImpl();
        }
        BuiltInFictitiousFunctionClassFactory = viewTreeObserverCompatBaseImpl;
    }

    public static void getAuthRequestContext(ViewTreeObserver p0, ViewTreeObserver.OnGlobalLayoutListener p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/core/ui/custom/tooltip/ViewTreeObserverCompat$ViewTreeObserverCompatBaseImpl;", "", "Landroid/view/ViewTreeObserver;", "p0", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static class ViewTreeObserverCompatBaseImpl {
        public void KClassImpl$Data$declaredNonStaticMembers$2(ViewTreeObserver p0, ViewTreeObserver.OnGlobalLayoutListener p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.removeGlobalOnLayoutListener(p1);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/core/ui/custom/tooltip/ViewTreeObserverCompat$ViewTreeObserverCompatApi16Impl;", "Lid/dana/core/ui/custom/tooltip/ViewTreeObserverCompat$ViewTreeObserverCompatBaseImpl;", "Landroid/view/ViewTreeObserver;", "p0", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/ViewTreeObserver;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class ViewTreeObserverCompatApi16Impl extends ViewTreeObserverCompatBaseImpl {
        @Override // id.dana.core.ui.custom.tooltip.ViewTreeObserverCompat.ViewTreeObserverCompatBaseImpl
        public final void KClassImpl$Data$declaredNonStaticMembers$2(ViewTreeObserver p0, ViewTreeObserver.OnGlobalLayoutListener p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.removeOnGlobalLayoutListener(p1);
        }
    }
}
