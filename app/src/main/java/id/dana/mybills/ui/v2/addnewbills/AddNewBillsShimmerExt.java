package id.dana.mybills.ui.v2.addnewbills;

import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.mybills.R;
import id.dana.mybills.databinding.FragmentAddNewBillsBinding;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsShimmerExt;", "", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/mybills/databinding/FragmentAddNewBillsBinding;", "p0", "getAuthRequestContext", "(Lid/dana/mybills/databinding/FragmentAddNewBillsBinding;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddNewBillsShimmerExt {
    public static final AddNewBillsShimmerExt INSTANCE = new AddNewBillsShimmerExt();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static SkeletonScreen getAuthRequestContext;

    private AddNewBillsShimmerExt() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory() {
        SkeletonScreen skeletonScreen = getAuthRequestContext;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        getAuthRequestContext = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(FragmentAddNewBillsBinding p0) {
        SkeletonScreen skeletonScreen = getAuthRequestContext;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(p0.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_skeleton_recent_transaction;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.PrepareContext);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 3;
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        getAuthRequestContext = recyclerViewSkeletonScreen;
    }
}
