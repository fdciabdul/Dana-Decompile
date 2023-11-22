package androidx.view.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.transition.TransitionManager;
import androidx.view.NavController;
import androidx.view.NavDestination;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\t\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014"}, d2 = {"Landroidx/navigation/ui/CollapsingToolbarOnDestinationChangedListener;", "Landroidx/navigation/ui/AbstractAppBarOnDestinationChangedListener;", "Landroidx/navigation/NavController;", "p0", "Landroidx/navigation/NavDestination;", "p1", "Landroid/os/Bundle;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "Landroid/graphics/drawable/Drawable;", "", "getAuthRequestContext", "(Landroid/graphics/drawable/Drawable;I)V", "", "(Ljava/lang/CharSequence;)V", "Ljava/lang/ref/WeakReference;", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/widget/Toolbar;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CollapsingToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final WeakReference<CollapsingToolbarLayout> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final WeakReference<Toolbar> PlaceComponentResult;

    @Override // androidx.view.ui.AbstractAppBarOnDestinationChangedListener, androidx.navigation.NavController.OnDestinationChangedListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NavController p0, NavDestination p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        CollapsingToolbarLayout collapsingToolbarLayout = this.BuiltInFictitiousFunctionClassFactory.get();
        Toolbar toolbar = this.PlaceComponentResult.get();
        if (collapsingToolbarLayout == null || toolbar == null) {
            CollapsingToolbarOnDestinationChangedListener collapsingToolbarOnDestinationChangedListener = this;
            Intrinsics.checkNotNullParameter(collapsingToolbarOnDestinationChangedListener, "");
            p0.newProxyInstance.remove(collapsingToolbarOnDestinationChangedListener);
            return;
        }
        super.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2);
    }

    @Override // androidx.view.ui.AbstractAppBarOnDestinationChangedListener
    protected final void KClassImpl$Data$declaredNonStaticMembers$2(CharSequence p0) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.BuiltInFictitiousFunctionClassFactory.get();
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(p0);
        }
    }

    @Override // androidx.view.ui.AbstractAppBarOnDestinationChangedListener
    protected final void getAuthRequestContext(Drawable p0, int p1) {
        Toolbar toolbar = this.PlaceComponentResult.get();
        if (toolbar != null) {
            boolean z = p0 == null && toolbar.getNavigationIcon() != null;
            toolbar.setNavigationIcon(p0);
            toolbar.setNavigationContentDescription(p1);
            if (z) {
                TransitionManager.getAuthRequestContext(toolbar, null);
            }
        }
    }
}
