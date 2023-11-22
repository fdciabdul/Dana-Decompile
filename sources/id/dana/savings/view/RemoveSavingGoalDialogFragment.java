package id.dana.savings.view;

import android.view.View;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/savings/view/RemoveSavingGoalDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "Lkotlin/Function0;", "lookAheadTest", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "p0", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoveSavingGoalDialogFragment extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Function0<Unit> getAuthRequestContext;

    private View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_coordinator_remove_saving_goal;
    }

    public RemoveSavingGoalDialogFragment(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.getAuthRequestContext = function0;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) MyBillsEntityDataFactory(R.id.getCardNumberOCR);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.RemoveSavingGoalDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RemoveSavingGoalDialogFragment.getAuthRequestContext(RemoveSavingGoalDialogFragment.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.y);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.RemoveSavingGoalDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RemoveSavingGoalDialogFragment.MyBillsEntityDataFactory(RemoveSavingGoalDialogFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RemoveSavingGoalDialogFragment removeSavingGoalDialogFragment) {
        Intrinsics.checkNotNullParameter(removeSavingGoalDialogFragment, "");
        removeSavingGoalDialogFragment.getAuthRequestContext.invoke();
        removeSavingGoalDialogFragment.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(RemoveSavingGoalDialogFragment removeSavingGoalDialogFragment) {
        Intrinsics.checkNotNullParameter(removeSavingGoalDialogFragment, "");
        removeSavingGoalDialogFragment.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a0115_networkuserentitydata_externalsyntheticlambda8);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
