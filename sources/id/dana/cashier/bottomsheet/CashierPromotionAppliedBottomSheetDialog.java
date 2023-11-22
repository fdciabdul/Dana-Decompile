package id.dana.cashier.bottomsheet;

import android.view.View;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\n"}, d2 = {"Lid/dana/cashier/bottomsheet/CashierPromotionAppliedBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onShow", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPromotionAppliedBottomSheetDialog extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    private View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
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
        return R.layout.fragment_cashier_promotion_applied_bottom_sheet_dialog;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) MyBillsEntityDataFactory(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.bottomsheet.CashierPromotionAppliedBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierPromotionAppliedBottomSheetDialog.getAuthRequestContext(CashierPromotionAppliedBottomSheetDialog.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    public static /* synthetic */ void getAuthRequestContext(CashierPromotionAppliedBottomSheetDialog cashierPromotionAppliedBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(cashierPromotionAppliedBottomSheetDialog, "");
        cashierPromotionAppliedBottomSheetDialog.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* synthetic */ View getBottomSheet() {
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.MediaCodec$OutputFrame);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
