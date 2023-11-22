package id.dana.richview.splitbill;

import android.view.View;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.SearchView;
import id.dana.richview.contactselector.ContactSelectorView;

/* loaded from: classes9.dex */
public class BillPayerView_ViewBinding implements Unbinder {
    private BillPayerView KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public BillPayerView_ViewBinding(final BillPayerView billPayerView, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = billPayerView;
        billPayerView.cvPayerSelection = (CardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cv_payer_selection, "field 'cvPayerSelection'", CardView.class);
        billPayerView.contactSelectorView = (ContactSelectorView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_contact_selector, "field 'contactSelectorView'", ContactSelectorView.class);
        billPayerView.selectedPayerView = (SelectedPayerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_selected_payer, "field 'selectedPayerView'", SelectedPayerView.class);
        billPayerView.searchView = (SearchView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4595res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6, "field 'searchView'", SearchView.class);
        billPayerView.llBtnContainer = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_btn_container, "field 'llBtnContainer'", LinearLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_cancel, "method 'onCancel'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.splitbill.BillPayerView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                billPayerView.onCancel();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_done, "method 'onFinished'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.splitbill.BillPayerView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                billPayerView.onFinished();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        BillPayerView billPayerView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (billPayerView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        billPayerView.cvPayerSelection = null;
        billPayerView.contactSelectorView = null;
        billPayerView.selectedPayerView = null;
        billPayerView.searchView = null;
        billPayerView.llBtnContainer = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
