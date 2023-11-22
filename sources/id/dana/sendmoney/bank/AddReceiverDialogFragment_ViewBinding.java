package id.dana.sendmoney.bank;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.CustomEditText;
import id.dana.richview.LogoListView;

/* loaded from: classes9.dex */
public class AddReceiverDialogFragment_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private AddReceiverDialogFragment KClassImpl$Data$declaredNonStaticMembers$2;

    public AddReceiverDialogFragment_ViewBinding(final AddReceiverDialogFragment addReceiverDialogFragment, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addReceiverDialogFragment;
        addReceiverDialogFragment.coordinatorLayout = (CoordinatorLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f3981layout_coordinator, "field 'coordinatorLayout'", CoordinatorLayout.class);
        addReceiverDialogFragment.clReceiverInputField = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_receiver_input_field, "field 'clReceiverInputField'", ConstraintLayout.class);
        addReceiverDialogFragment.cetReceiverName = (CustomEditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cet_receiver_name, "field 'cetReceiverName'", CustomEditText.class);
        addReceiverDialogFragment.cetReceivePhoneNumber = (CustomEditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cet_receiver_phone_number, "field 'cetReceivePhoneNumber'", CustomEditText.class);
        addReceiverDialogFragment.cetReceiverDateOfBirth = (CustomEditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cet_receiver_date_of_birth, "field 'cetReceiverDateOfBirth'", CustomEditText.class);
        addReceiverDialogFragment.llvTransferAgents = (LogoListView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.llv_transfer_agents, "field 'llvTransferAgents'", LogoListView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_add_receiver_info, "field 'btnAddReceiverInfo' and method 'onAddreceiverInfoClicked'");
        addReceiverDialogFragment.btnAddReceiverInfo = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.btn_add_receiver_info, "field 'btnAddReceiverInfo'", Button.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                addReceiverDialogFragment.onAddreceiverInfoClicked();
            }
        });
        addReceiverDialogFragment.nsContent = (NestedScrollView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ns_content, "field 'nsContent'", NestedScrollView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        AddReceiverDialogFragment addReceiverDialogFragment = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (addReceiverDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        addReceiverDialogFragment.coordinatorLayout = null;
        addReceiverDialogFragment.clReceiverInputField = null;
        addReceiverDialogFragment.cetReceiverName = null;
        addReceiverDialogFragment.cetReceivePhoneNumber = null;
        addReceiverDialogFragment.cetReceiverDateOfBirth = null;
        addReceiverDialogFragment.llvTransferAgents = null;
        addReceiverDialogFragment.btnAddReceiverInfo = null;
        addReceiverDialogFragment.nsContent = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
