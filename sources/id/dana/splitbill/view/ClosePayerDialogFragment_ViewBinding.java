package id.dana.splitbill.view;

import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes9.dex */
public class ClosePayerDialogFragment_ViewBinding implements Unbinder {
    private ClosePayerDialogFragment BuiltInFictitiousFunctionClassFactory;

    public ClosePayerDialogFragment_ViewBinding(ClosePayerDialogFragment closePayerDialogFragment, View view) {
        this.BuiltInFictitiousFunctionClassFactory = closePayerDialogFragment;
        closePayerDialogFragment.coordinatorLayout = (CoordinatorLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3981layout_coordinator, "field 'coordinatorLayout'", CoordinatorLayout.class);
        closePayerDialogFragment.cvpClosePayer = (ClosePayerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cpv_close_payer, "field 'cvpClosePayer'", ClosePayerView.class);
        closePayerDialogFragment.btnSubmitClosePayer = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_submit_close_payer, "field 'btnSubmitClosePayer'", Button.class);
        closePayerDialogFragment.lpvClosePayer = (LogoProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4081progress_view, "field 'lpvClosePayer'", LogoProgressView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ClosePayerDialogFragment closePayerDialogFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (closePayerDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        closePayerDialogFragment.coordinatorLayout = null;
        closePayerDialogFragment.cvpClosePayer = null;
        closePayerDialogFragment.btnSubmitClosePayer = null;
        closePayerDialogFragment.lpvClosePayer = null;
    }
}
