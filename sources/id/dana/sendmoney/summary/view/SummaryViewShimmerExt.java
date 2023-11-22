package id.dana.sendmoney.summary.view;

import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\b"}, d2 = {"Lid/dana/sendmoney/summary/view/SummaryViewShimmerExt;", "", "Lid/dana/sendmoney/summary/view/SummaryView;", "", "getAuthRequestContext", "(Lid/dana/sendmoney/summary/view/SummaryView;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryViewShimmerExt {
    public static final SummaryViewShimmerExt INSTANCE = new SummaryViewShimmerExt();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static SkeletonScreen BuiltInFictitiousFunctionClassFactory;

    private SummaryViewShimmerExt() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        SkeletonScreen skeletonScreen = BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory2 = Skeleton.BuiltInFictitiousFunctionClassFactory(summaryView._$_findCachedViewById(R.id.SplitReferralConfigEntityData_Factory_res_0x7f0a03ce));
        BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext = R.layout.view_skeleton_sender;
        BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = 20;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory2, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        BuiltInFictitiousFunctionClassFactory = viewSkeletonScreen;
    }

    public static void getAuthRequestContext(SummaryView summaryView) {
        Intrinsics.checkNotNullParameter(summaryView, "");
        SkeletonScreen skeletonScreen = BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        BuiltInFictitiousFunctionClassFactory = null;
    }
}
