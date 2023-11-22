package id.dana.sendmoney.ui.globalsend.form.view;

import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.BottomSheetGlobalSendConfirmationBinding;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetShimmerExt;", "", "", "PlaceComponentResult", "()V", "Lid/dana/sendmoney/databinding/BottomSheetGlobalSendConfirmationBinding;", "p0", "(Lid/dana/sendmoney/databinding/BottomSheetGlobalSendConfirmationBinding;)V", "", "Lcom/ethanhua/skeleton/SkeletonScreen;", "MyBillsEntityDataFactory", "Ljava/util/List;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ConfirmationBottomSheetShimmerExt {
    public static final ConfirmationBottomSheetShimmerExt INSTANCE = new ConfirmationBottomSheetShimmerExt();
    private static List<? extends SkeletonScreen> MyBillsEntityDataFactory;

    private ConfirmationBottomSheetShimmerExt() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult() {
        ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
        ShimmeringUtil.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory);
        MyBillsEntityDataFactory = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(BottomSheetGlobalSendConfirmationBinding p0) {
        if (MyBillsEntityDataFactory == null) {
            HashMap hashMapOf = MapsKt.hashMapOf(new Pair(p0.MyBillsEntityDataFactory, Integer.valueOf(R.layout.view_skeleton_icon_bank)), new Pair(p0.NetworkUserEntityData$$ExternalSyntheticLambda2, Integer.valueOf(R.layout.view_title_confirmation_skeleton)), new Pair(p0.DatabaseTableConfigUtil, Integer.valueOf(R.layout.view_subtitle_confirmation_skeleton)), new Pair(p0.getAuthRequestContext, Integer.valueOf(R.layout.view_email_confirmation_skeleton)), new Pair(p0.moveToNextValue, Integer.valueOf(R.layout.view_user_data_skeleton)), new Pair(p0.scheduleImpl, Integer.valueOf(R.layout.view_user_data_skeleton)), new Pair(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, Integer.valueOf(R.layout.view_user_data_skeleton)));
            ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
            MyBillsEntityDataFactory = ShimmeringUtil.MyBillsEntityDataFactory(hashMapOf, R.color.PlaceComponentResult);
            ShimmeringUtil shimmeringUtil2 = ShimmeringUtil.INSTANCE;
            ShimmeringUtil.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
            return;
        }
        ShimmeringUtil shimmeringUtil3 = ShimmeringUtil.INSTANCE;
        ShimmeringUtil.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
    }
}
