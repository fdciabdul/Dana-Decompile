package id.dana.richview;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SearchView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private TextWatcher MyBillsEntityDataFactory;
    private SearchView getAuthRequestContext;

    public SearchView_ViewBinding(final SearchView searchView, View view) {
        this.getAuthRequestContext = searchView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.et_search_contact, "field 'etSearchContact' and method 'afterBankNumberChange'");
        searchView.etSearchContact = (EditText) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.et_search_contact, "field 'etSearchContact'", EditText.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        TextWatcher textWatcher = new TextWatcher() { // from class: id.dana.richview.SearchView_ViewBinding.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                searchView.afterBankNumberChange(editable);
            }
        };
        this.MyBillsEntityDataFactory = textWatcher;
        ((TextView) BuiltInFictitiousFunctionClassFactory).addTextChangedListener(textWatcher);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear, "field 'ivClear' and method 'clearKeyword'");
        searchView.ivClear = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.iv_clear, "field 'ivClear'", ImageView.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.SearchView_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                searchView.clearKeyword();
            }
        });
        searchView.ivRightIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_right_icon, "field 'ivRightIcon'", ImageView.class);
        searchView.pbLoading = (ProgressBar) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pb_loading, "field 'pbLoading'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SearchView searchView = this.getAuthRequestContext;
        if (searchView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        searchView.etSearchContact = null;
        searchView.ivClear = null;
        searchView.ivRightIcon = null;
        searchView.pbLoading = null;
        ((TextView) this.BuiltInFictitiousFunctionClassFactory).removeTextChangedListener(this.MyBillsEntityDataFactory);
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
