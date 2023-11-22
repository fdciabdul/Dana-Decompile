package id.dana.richview.bank;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.textfield.TextInputEditText;
import id.dana.R;

/* loaded from: classes9.dex */
public class AutoCompleteBankView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private AutoCompleteBankView getAuthRequestContext;

    public AutoCompleteBankView_ViewBinding(final AutoCompleteBankView autoCompleteBankView, View view) {
        this.getAuthRequestContext = autoCompleteBankView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.et_bank_name, "field 'bankName' and method 'editTextFocusChange'");
        autoCompleteBankView.bankName = (TextInputEditText) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.et_bank_name, "field 'bankName'", TextInputEditText.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.richview.bank.AutoCompleteBankView_ViewBinding.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                autoCompleteBankView.editTextFocusChange(view2, z);
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear_bank_name, "field 'ivClearInput' and method 'clearBankNameClick'");
        autoCompleteBankView.ivClearInput = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.iv_clear_bank_name, "field 'ivClearInput'", ImageView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.bank.AutoCompleteBankView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                autoCompleteBankView.clearBankNameClick();
            }
        });
        autoCompleteBankView.rvBankList = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rv_bank_list, "field 'rvBankList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        AutoCompleteBankView autoCompleteBankView = this.getAuthRequestContext;
        if (autoCompleteBankView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        autoCompleteBankView.bankName = null;
        autoCompleteBankView.ivClearInput = null;
        autoCompleteBankView.rvBankList = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnFocusChangeListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
