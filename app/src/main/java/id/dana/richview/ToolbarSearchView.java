package id.dana.richview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.KeyboardHelper;

/* loaded from: classes3.dex */
public class ToolbarSearchView extends BaseRichView {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult;
    @BindView(R.id.cl_search_toolbar)
    ConstraintLayout clSearchToolbar;
    @BindView(R.id.et_search_toolbar)
    EditText etSearchToolbar;
    private Listener getAuthRequestContext;
    @BindView(R.id.iv_clear_toolbar_search)
    ImageView ivClearToolbarSearch;
    @BindView(R.id.left_button_search_view)
    TextView leftButtonSearchView;
    @BindView(R.id.right_button_search_view)
    TextView rightButtonSearchView;
    @BindView(R.id.rl_toolbar_search_view)
    RelativeLayout rlToolbarSearchView;
    @BindView(R.id.tb_search_view)
    Toolbar tbSearchView;
    @BindView(R.id.tv_close_search)
    TextView tvCloseSearch;
    @BindView(R.id.tv_search_view_title)
    TextView tvSearchViewTitle;

    /* loaded from: classes3.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(CharSequence charSequence);

        void PlaceComponentResult(CharSequence charSequence);

        void getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_toolbar_search;
    }

    public ToolbarSearchView(Context context) {
        super(context);
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult = false;
    }

    public ToolbarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult = false;
    }

    public ToolbarSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.PlaceComponentResult = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateSearchTouchDelegate$0$id-dana-richview-ToolbarSearchView  reason: not valid java name */
    public /* synthetic */ void m2825x7e205b09(View view) {
        Rect rect = new Rect();
        this.rightButtonSearchView.getHitRect(rect);
        rect.top -= 5;
        rect.left -= 10;
        rect.bottom += 5;
        rect.right += 10;
        view.setTouchDelegate(new TouchDelegate(rect, this.rightButtonSearchView));
    }

    public void setListener(Listener listener) {
        this.getAuthRequestContext = listener;
    }

    @OnEditorAction({R.id.et_search_toolbar})
    public boolean searchEditorAction(int i) {
        if (i == 3) {
            hideClearSearchButton();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this.etSearchToolbar);
            if (this.BuiltInFictitiousFunctionClassFactory) {
                this.getAuthRequestContext.MyBillsEntityDataFactory(this.etSearchToolbar.getText());
                return false;
            }
            return false;
        }
        return false;
    }

    @OnFocusChange({R.id.et_search_toolbar})
    public void onSearchEditorFocusChange(boolean z) {
        if (z && !TextUtils.isEmpty(this.etSearchToolbar.getText())) {
            showClearSearchButton();
        }
        if (!this.BuiltInFictitiousFunctionClassFactory || z) {
            return;
        }
        hideKeyboard();
        if (this.PlaceComponentResult) {
            hideSearchView();
        }
    }

    @OnClick({R.id.tv_close_search})
    public void OnClickCloseSearch() {
        hideSearchView();
    }

    public boolean getSearchStatus() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void hideSearchView() {
        KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.clSearchToolbar.setVisibility(8);
        this.rlToolbarSearchView.setVisibility(0);
        this.etSearchToolbar.getText().clear();
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this.etSearchToolbar);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        if (z) {
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @OnTextChanged({R.id.et_search_toolbar})
    public void onSearchToolbarTextChanged(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            showClearSearchButton();
        } else {
            hideClearSearchButton();
            this.PlaceComponentResult = true;
        }
        this.getAuthRequestContext.PlaceComponentResult(charSequence);
    }

    @OnClick({R.id.iv_clear_toolbar_search})
    public void onClickClearToolbarSearch() {
        clearSearch();
    }

    @OnClick({R.id.right_button_search_view})
    public void onRightButtonSearchViewClicked() {
        showSearchBar();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public void showSearchBar() {
        this.clSearchToolbar.setVisibility(0);
        this.rlToolbarSearchView.setVisibility(8);
        EditText editText = this.etSearchToolbar;
        if (editText != null) {
            editText.requestFocus();
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(editText);
        }
    }

    public void setMenuLeftButton(int i) {
        Toolbar toolbar = this.tbSearchView;
        if (toolbar == null || i == 0) {
            return;
        }
        toolbar.setNavigationIcon(i);
        this.tbSearchView.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.ToolbarSearchView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolbarSearchView.this.m2824lambda$setMenuLeftButton$1$iddanarichviewToolbarSearchView(view);
            }
        });
        this.leftButtonSearchView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setMenuLeftButton$1$id-dana-richview-ToolbarSearchView  reason: not valid java name */
    public /* synthetic */ void m2824lambda$setMenuLeftButton$1$iddanarichviewToolbarSearchView(View view) {
        this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    public void setMenuLeftButtonContentDescription(String str) {
        TextView textView = this.leftButtonSearchView;
        if (textView == null || str == null) {
            return;
        }
        textView.setContentDescription(str);
    }

    public void setMenuRightButton(int i) {
        TextView textView = this.rightButtonSearchView;
        if (textView == null || i == 0) {
            return;
        }
        textView.setBackground(getDrawableFromRes(i));
        this.rightButtonSearchView.setVisibility(0);
    }

    public void setMenuRightButtonContentDescription(String str) {
        TextView textView = this.rightButtonSearchView;
        if (textView == null || str == null) {
            return;
        }
        textView.setContentDescription(str);
    }

    public void setTitle(String str) {
        this.tvSearchViewTitle.setText(str);
    }

    public void setTitleContentDescription(String str) {
        this.tvSearchViewTitle.setContentDescription(str);
    }

    public void showClearSearchButton() {
        this.ivClearToolbarSearch.setVisibility(0);
    }

    public void hideClearSearchButton() {
        this.ivClearToolbarSearch.setVisibility(8);
    }

    public Drawable getDrawableFromRes(int i) {
        return ContextCompat.PlaceComponentResult(getContext(), i);
    }

    public void clearSearch() {
        this.etSearchToolbar.getText().clear();
        EditText editText = this.etSearchToolbar;
        if (editText != null) {
            editText.requestFocus();
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(editText);
        }
        this.getAuthRequestContext.getAuthRequestContext();
    }

    public void hideKeyboard() {
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this.etSearchToolbar);
    }

    public void setSearchIconVisibility(int i) {
        TextView textView = this.rightButtonSearchView;
        if (textView != null) {
            textView.setVisibility(i);
        }
        if (i == 8 || i == 4) {
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }

    public void setMaxChar(int i) {
        this.etSearchToolbar.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    public void setIsMerchantOnline(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    public void setIsDismissHideSearchbar(boolean z) {
        this.PlaceComponentResult = z;
    }

    public void setCloseButtonText(String str) {
        this.tvCloseSearch.setText(str);
    }

    public boolean getIsDismissHideSearchBar() {
        return this.PlaceComponentResult;
    }

    public void setClearToolbarSearchContentDescription(String str) {
        this.ivClearToolbarSearch.setContentDescription(str);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        final View view = (View) this.rightButtonSearchView.getParent();
        view.post(new Runnable() { // from class: id.dana.richview.ToolbarSearchView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ToolbarSearchView.this.m2825x7e205b09(view);
            }
        });
    }
}
