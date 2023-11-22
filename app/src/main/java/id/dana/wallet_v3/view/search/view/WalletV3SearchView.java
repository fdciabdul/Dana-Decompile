package id.dana.wallet_v3.view.search.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewWalletV3SearchBinding;
import id.dana.utils.KeyboardHelper;
import id.dana.wallet_v3.listener.WalletV3SearchViewListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010'\u001a\u00020\t¢\u0006\u0004\b(\u0010)B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010'\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020\t¢\u0006\u0004\b(\u0010+J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\r\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J#\u0010\u0016\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\u0005J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b#\u0010 J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0005R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010&"}, d2 = {"Lid/dana/wallet_v3/view/search/view/WalletV3SearchView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewWalletV3SearchBinding;", "", "clearSearchButtonClick", "()V", "clearTextAndEnableEditText", "disableEditText", "enableEditText", "", "getLayout", "()I", "hideClearSearchButton", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewWalletV3SearchBinding;", "onSearchToolbarTextChanged", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setEditTextFocus", "Lid/dana/wallet_v3/listener/WalletV3SearchViewListener;", "walletV3SearchViewListener", "setListener", "(Lid/dana/wallet_v3/listener/WalletV3SearchViewListener;)V", "", "searchBarHint", "setSearchBarHint", "(Ljava/lang/String;)V", "setSearchViewFocus", "text", "setTextAndDisableEditText", "setup", "showClearSearchButton", "Lid/dana/wallet_v3/listener/WalletV3SearchViewListener;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletV3SearchView extends ViewBindingRichView<ViewWalletV3SearchBinding> {
    public Map<Integer, View> _$_findViewCache;
    private WalletV3SearchViewListener walletV3SearchViewListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletV3SearchView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletV3SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_wallet_v3_search;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletV3SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ WalletV3SearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletV3SearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewWalletV3SearchBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewWalletV3SearchBinding MyBillsEntityDataFactory = ViewWalletV3SearchBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        onSearchToolbarTextChanged();
        clearSearchButtonClick();
        setSearchViewFocus();
    }

    public final void setTextAndDisableEditText(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        if (editText.hasFocus()) {
            editText.clearFocus();
        }
        editText.setHint(text);
        disableEditText();
        showClearSearchButton();
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r3, AttributeSet attrs) {
        super.parseAttrs(r3, attrs);
        if (attrs != null) {
            String str = null;
            TypedArray obtainStyledAttributes = r3 != null ? r3.obtainStyledAttributes(attrs, R.styleable.Code128Reader) : null;
            if (obtainStyledAttributes != null) {
                try {
                    str = obtainStyledAttributes.getString(0);
                } finally {
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                }
            }
            setSearchBarHint(str);
        }
    }

    public final void setListener(WalletV3SearchViewListener walletV3SearchViewListener) {
        this.walletV3SearchViewListener = walletV3SearchViewListener;
    }

    public final void clearTextAndEnableEditText() {
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        editText.getText().clear();
        editText.setHint(editText.getContext().getString(R.string.wallet_search_bar_hint_v3));
        enableEditText();
        hideClearSearchButton();
    }

    public final void disableEditText() {
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
    }

    public final void enableEditText() {
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
    }

    public final void setSearchBarHint(String searchBarHint) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setHint(searchBarHint);
    }

    public final void setEditTextFocus() {
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        editText.requestFocus();
        Context context = editText.getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).showSoftInput(editText, 0);
    }

    private final void onSearchToolbarTextChanged() {
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.wallet_v3.view.search.view.WalletV3SearchView$onSearchToolbarTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence text, int start, int before, int count) {
                WalletV3SearchViewListener walletV3SearchViewListener;
                walletV3SearchViewListener = WalletV3SearchView.this.walletV3SearchViewListener;
                if (walletV3SearchViewListener != null) {
                    walletV3SearchViewListener.onSearchTextChanged(text == null ? "" : text);
                }
                if (!TextUtils.isEmpty(text)) {
                    WalletV3SearchView.this.showClearSearchButton();
                } else {
                    WalletV3SearchView.this.hideClearSearchButton();
                }
            }
        });
    }

    public final void showClearSearchButton() {
        AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
    }

    public final void hideClearSearchButton() {
        AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
    }

    private final void clearSearchButtonClick() {
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.search.view.WalletV3SearchView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletV3SearchView.m3109clearSearchButtonClick$lambda8(WalletV3SearchView.this, view);
            }
        });
    }

    /* renamed from: clearSearchButtonClick$lambda-8 */
    public static final void m3109clearSearchButtonClick$lambda8(WalletV3SearchView walletV3SearchView, View view) {
        Intrinsics.checkNotNullParameter(walletV3SearchView, "");
        walletV3SearchView.clearTextAndEnableEditText();
        WalletV3SearchViewListener walletV3SearchViewListener = walletV3SearchView.walletV3SearchViewListener;
        if (walletV3SearchViewListener != null) {
            walletV3SearchViewListener.onClickClearText();
        }
    }

    private final void setSearchViewFocus() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.wallet_v3.view.search.view.WalletV3SearchView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                WalletV3SearchView.m3110setSearchViewFocus$lambda9(WalletV3SearchView.this, view, z);
            }
        });
    }

    /* renamed from: setSearchViewFocus$lambda-9 */
    public static final void m3110setSearchViewFocus$lambda9(WalletV3SearchView walletV3SearchView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(walletV3SearchView, "");
        if (z) {
            walletV3SearchView.getBinding().PlaceComponentResult.setBackground(ContextCompat.PlaceComponentResult(walletV3SearchView.getContext(), (int) R.drawable.bg_wallet_search_view));
            return;
        }
        walletV3SearchView.getBinding().PlaceComponentResult.setBackground(ContextCompat.PlaceComponentResult(walletV3SearchView.getContext(), (int) R.drawable.bg_rounded_8dp_border_grey20));
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(walletV3SearchView);
    }
}
