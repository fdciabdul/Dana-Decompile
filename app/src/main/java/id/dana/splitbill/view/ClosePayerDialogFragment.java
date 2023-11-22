package id.dana.splitbill.view;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.richview.LogoProgressView;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.view.ClosePayerView;
import java.util.List;

/* loaded from: classes5.dex */
public class ClosePayerDialogFragment extends BaseBottomSheetDialogFragment {
    int KClassImpl$Data$declaredNonStaticMembers$2;
    @BindView(R.id.btn_submit_close_payer)
    Button btnSubmitClosePayer;
    @BindView(R.id.f3981layout_coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.cpv_close_payer)
    ClosePayerView cvpClosePayer;
    String getErrorConfigVersion;
    OnSubmitButtonClickListener lookAheadTest;
    @BindView(R.id.f4081progress_view)
    LogoProgressView lpvClosePayer;
    List<PayerModel> moveToNextValue;

    /* loaded from: classes5.dex */
    public interface OnSubmitButtonClickListener {
        void PlaceComponentResult(List<String> list);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public float getDimAmount() {
        return 0.0f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public int getLayout() {
        return R.layout.view_coordinator_close_payer;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public int getResizeHeight() {
        return 56;
    }

    public ClosePayerDialogFragment(OnSubmitButtonClickListener onSubmitButtonClickListener) {
        this.lookAheadTest = onSubmitButtonClickListener;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void initBottomSheet(int i, int i2) {
        this.bottomSheetBehavior.setHideable(true);
        super.initBottomSheet(i, i2);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void init() {
        super.init();
        this.cvpClosePayer.setRemainingBill(this.getErrorConfigVersion);
        this.cvpClosePayer.setUnpaidBillCount(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.cvpClosePayer.setItems(this.moveToNextValue);
        this.cvpClosePayer.setOnDataChangedListener(new ClosePayerView.OnDataChangedListener() { // from class: id.dana.splitbill.view.ClosePayerDialogFragment$$ExternalSyntheticLambda0
            @Override // id.dana.splitbill.view.ClosePayerView.OnDataChangedListener
            public final void getAuthRequestContext(boolean z) {
                ClosePayerDialogFragment.this.btnSubmitClosePayer.setEnabled(!z);
            }
        });
        this.btnSubmitClosePayer.setOnClickListener(new View.OnClickListener() { // from class: id.dana.splitbill.view.ClosePayerDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClosePayerDialogFragment closePayerDialogFragment = ClosePayerDialogFragment.this;
                closePayerDialogFragment.lookAheadTest.PlaceComponentResult(closePayerDialogFragment.cvpClosePayer.getClosedPayers());
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        initMatchParentDialog(dialog);
        initTransparentDialogDim(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ((SplitBillSummaryActivity) getActivity()).disableDimView();
        super.onDestroy();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public /* synthetic */ View getBottomSheet() {
        return (FrameLayout) this.coordinatorLayout.findViewById(R.id.bs_close_payer);
    }
}
