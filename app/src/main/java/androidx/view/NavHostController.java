package androidx.view;

import android.content.Context;
import androidx.view.LifecycleOwner;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000e"}, d2 = {"Landroidx/navigation/NavHostController;", "Landroidx/navigation/NavController;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Landroidx/lifecycle/LifecycleOwner;", "getAuthRequestContext", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/activity/OnBackPressedDispatcher;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/activity/OnBackPressedDispatcher;)V", "Landroidx/lifecycle/ViewModelStore;", "(Landroidx/lifecycle/ViewModelStore;)V", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavHostController extends NavController {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // androidx.view.NavController
    public final void getAuthRequestContext(LifecycleOwner p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.getAuthRequestContext(p0);
    }

    @Override // androidx.view.NavController
    public final void KClassImpl$Data$declaredNonStaticMembers$2(OnBackPressedDispatcher p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // androidx.view.NavController
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        super.BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // androidx.view.NavController
    public final void KClassImpl$Data$declaredNonStaticMembers$2(ViewModelStore p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }
}
