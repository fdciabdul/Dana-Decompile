package id.dana.utils.handpick;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/handpick/FragmentFacade;", "Lid/dana/utils/handpick/ContextFacade;", "Landroid/content/Context;", "PlaceComponentResult", "()Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/Fragment;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "p0", "<init>", "(Landroidx/fragment/app/Fragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FragmentFacade implements ContextFacade {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Fragment MyBillsEntityDataFactory;

    public FragmentFacade(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        this.MyBillsEntityDataFactory = fragment;
    }

    @Override // id.dana.utils.handpick.ContextFacade
    @JvmName(name = "PlaceComponentResult")
    public final Context PlaceComponentResult() {
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        return requireContext;
    }
}
