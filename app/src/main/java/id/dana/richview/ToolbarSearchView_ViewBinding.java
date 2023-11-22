package id.dana.richview;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ToolbarSearchView_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private TextWatcher KClassImpl$Data$declaredNonStaticMembers$2;
    private ToolbarSearchView MyBillsEntityDataFactory;
    private View getAuthRequestContext;
    private View getErrorConfigVersion;
    private View lookAheadTest;

    public ToolbarSearchView_ViewBinding(final ToolbarSearchView toolbarSearchView, View view) {
        this.MyBillsEntityDataFactory = toolbarSearchView;
        toolbarSearchView.rlToolbarSearchView = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rl_toolbar_search_view, "field 'rlToolbarSearchView'", RelativeLayout.class);
        toolbarSearchView.clSearchToolbar = (ConstraintLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cl_search_toolbar, "field 'clSearchToolbar'", ConstraintLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.et_search_toolbar, "field 'etSearchToolbar', method 'searchEditorAction', method 'onSearchEditorFocusChange', and method 'onSearchToolbarTextChanged'");
        toolbarSearchView.etSearchToolbar = (EditText) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.et_search_toolbar, "field 'etSearchToolbar'", EditText.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        TextView textView = (TextView) BuiltInFictitiousFunctionClassFactory;
        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.richview.ToolbarSearchView_ViewBinding.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return toolbarSearchView.searchEditorAction(i);
            }
        });
        BuiltInFictitiousFunctionClassFactory.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.richview.ToolbarSearchView_ViewBinding.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                toolbarSearchView.onSearchEditorFocusChange(z);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: id.dana.richview.ToolbarSearchView_ViewBinding.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                toolbarSearchView.onSearchToolbarTextChanged(charSequence);
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textWatcher;
        textView.addTextChangedListener(textWatcher);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_clear_toolbar_search, "field 'ivClearToolbarSearch' and method 'onClickClearToolbarSearch'");
        toolbarSearchView.ivClearToolbarSearch = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.iv_clear_toolbar_search, "field 'ivClearToolbarSearch'", ImageView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.ToolbarSearchView_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                toolbarSearchView.onClickClearToolbarSearch();
            }
        });
        toolbarSearchView.tbSearchView = (Toolbar) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tb_search_view, "field 'tbSearchView'", Toolbar.class);
        toolbarSearchView.leftButtonSearchView = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.left_button_search_view, "field 'leftButtonSearchView'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.right_button_search_view, "field 'rightButtonSearchView' and method 'onRightButtonSearchViewClicked'");
        toolbarSearchView.rightButtonSearchView = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3, R.id.right_button_search_view, "field 'rightButtonSearchView'", TextView.class);
        this.lookAheadTest = BuiltInFictitiousFunctionClassFactory3;
        BuiltInFictitiousFunctionClassFactory3.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.ToolbarSearchView_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                toolbarSearchView.onRightButtonSearchViewClicked();
            }
        });
        toolbarSearchView.tvSearchViewTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_search_view_title, "field 'tvSearchViewTitle'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory4 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_close_search, "field 'tvCloseSearch' and method 'OnClickCloseSearch'");
        toolbarSearchView.tvCloseSearch = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory4, R.id.tv_close_search, "field 'tvCloseSearch'", TextView.class);
        this.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory4;
        BuiltInFictitiousFunctionClassFactory4.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.ToolbarSearchView_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                toolbarSearchView.OnClickCloseSearch();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ToolbarSearchView toolbarSearchView = this.MyBillsEntityDataFactory;
        if (toolbarSearchView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        toolbarSearchView.rlToolbarSearchView = null;
        toolbarSearchView.clSearchToolbar = null;
        toolbarSearchView.etSearchToolbar = null;
        toolbarSearchView.ivClearToolbarSearch = null;
        toolbarSearchView.tbSearchView = null;
        toolbarSearchView.leftButtonSearchView = null;
        toolbarSearchView.rightButtonSearchView = null;
        toolbarSearchView.tvSearchViewTitle = null;
        toolbarSearchView.tvCloseSearch = null;
        ((TextView) this.getAuthRequestContext).setOnEditorActionListener(null);
        this.getAuthRequestContext.setOnFocusChangeListener(null);
        ((TextView) this.getAuthRequestContext).removeTextChangedListener(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.lookAheadTest.setOnClickListener(null);
        this.lookAheadTest = null;
        this.getErrorConfigVersion.setOnClickListener(null);
        this.getErrorConfigVersion = null;
    }
}
