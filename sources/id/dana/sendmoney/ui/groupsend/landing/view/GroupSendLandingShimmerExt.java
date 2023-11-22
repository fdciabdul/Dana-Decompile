package id.dana.sendmoney.ui.groupsend.landing.view;

import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ActivityGroupSendLandingBinding;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/view/GroupSendLandingShimmerExt;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/sendmoney/databinding/ActivityGroupSendLandingBinding;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/databinding/ActivityGroupSendLandingBinding;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendLandingShimmerExt {
    public static final GroupSendLandingShimmerExt INSTANCE = new GroupSendLandingShimmerExt();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static SkeletonScreen PlaceComponentResult;

    private GroupSendLandingShimmerExt() {
    }

    public static void BuiltInFictitiousFunctionClassFactory() {
        SkeletonScreen skeletonScreen = PlaceComponentResult;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        PlaceComponentResult = null;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ActivityGroupSendLandingBinding p0) {
        SkeletonScreen skeletonScreen = PlaceComponentResult;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(p0.PlaceComponentResult);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_group_send_landing;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.GetContactSyncConfig);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        PlaceComponentResult = viewSkeletonScreen;
    }
}
