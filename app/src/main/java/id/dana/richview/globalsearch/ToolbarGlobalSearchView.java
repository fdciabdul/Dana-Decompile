package id.dana.richview.globalsearch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.util.ViewUtil;
import id.dana.databinding.ViewToolbarGlobalSearchBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.KeyboardHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002DEB'\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010?\u001a\u00020\u000b¢\u0006\u0004\b@\u0010AB+\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010?\u001a\u00020\u000b\u0012\u0006\u0010B\u001a\u00020\u000b¢\u0006\u0004\b@\u0010CJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J#\u0010$\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0005¢\u0006\u0004\b.\u0010\tJ\r\u0010/\u001a\u00020\u0005¢\u0006\u0004\b/\u0010\tJ\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\tJ\u0015\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u001d¢\u0006\u0004\b2\u0010 R\u0018\u00105\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00106\u001a\u00020!8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b$\u00107R*\u00108\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001d8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010 R\u0018\u00109\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u0010>"}, d2 = {"Lid/dana/richview/globalsearch/ToolbarGlobalSearchView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewToolbarGlobalSearchBinding;", "Landroid/text/TextWatcher;", "textWatcher", "", "addTextChangedListener", "(Landroid/text/TextWatcher;)V", "clearPointerFocus", "()V", "clearSearch", "", "getLayout", "()I", "hideClearSearchButton", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewToolbarGlobalSearchBinding;", "", "text", "onSearchToolbarTextChanged", "(Ljava/lang/CharSequence;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "customColor", "setBackgroundColor", "(Ljava/lang/String;)V", "", "p0", "p1", "PlaceComponentResult", "(ZLjava/lang/String;)V", "Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$HomeSearchListener;", "homeSearchListener", "setHomeSearchListener", "(Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$HomeSearchListener;)V", "Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$Listener;)V", "setMenuButtonListener", "setPointerFocus", "setup", "keywordString", "showKeyword", "MyBillsEntityDataFactory", "Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$HomeSearchListener;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Z", "keyword", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getKeyword", "()Ljava/lang/String;", "setKeyword", "Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$Listener;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "HomeSearchListener", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ToolbarGlobalSearchView extends ViewBindingRichView<ViewToolbarGlobalSearchBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String keyword;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private HomeSearchListener getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Listener KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$HomeSearchListener;", "", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface HomeSearchListener {
        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u0006\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/globalsearch/ToolbarGlobalSearchView$Listener;", "", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "", "p0", "(Ljava/lang/String;)V", "", "(Ljava/lang/CharSequence;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(CharSequence p0);

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolbarGlobalSearchView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToolbarGlobalSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
        return R.layout.view_toolbar_global_search;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarGlobalSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = true;
        this.keyword = "";
    }

    public /* synthetic */ ToolbarGlobalSearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarGlobalSearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = true;
        this.keyword = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewToolbarGlobalSearchBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewToolbarGlobalSearchBinding BuiltInFictitiousFunctionClassFactory = ViewToolbarGlobalSearchBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            setStyledAttributes(context, attrs, R.styleable.$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY);
            try {
                int i = 0;
                boolean z = getStyledAttributes().getBoolean(0, false);
                this.PlaceComponentResult = z;
                PlaceComponentResult$default(this, z, null, 2, null);
                boolean z2 = getStyledAttributes().getBoolean(1, false);
                this.BuiltInFictitiousFunctionClassFactory = z2;
                AppCompatImageView appCompatImageView = getBinding().BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                AppCompatImageView appCompatImageView2 = appCompatImageView;
                if (!z2) {
                    i = 8;
                }
                appCompatImageView2.setVisibility(i);
                if (z2) {
                    LinearLayout linearLayout = getBinding().scheduleImpl;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                    ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(linearLayout, Float.valueOf(44.0f), null, Float.valueOf(12.0f), null, 10);
                }
            } finally {
                TypedArray styledAttributes = getStyledAttributes();
                if (styledAttributes != null) {
                    styledAttributes.recycle();
                }
            }
        }
    }

    static /* synthetic */ void PlaceComponentResult$default(ToolbarGlobalSearchView toolbarGlobalSearchView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        toolbarGlobalSearchView.PlaceComponentResult(z, str);
    }

    private final void PlaceComponentResult(boolean p0, String p1) {
        int argb;
        TextView textView = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(p0 ? 4 : 0);
        if (p0) {
            LinearLayout linearLayout = getBinding().scheduleImpl;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(4.0f);
            try {
                int parseColor = Color.parseColor(p1);
                argb = Color.argb((int) ((Color.alpha(parseColor) * 0.84000003f) + (Color.alpha(-16777216) * 0.16f)), (int) ((Color.red(parseColor) * 0.84000003f) + (Color.red(-16777216) * 0.16f)), (int) ((Color.green(parseColor) * 0.84000003f) + (Color.green(-16777216) * 0.16f)), (int) ((Color.blue(parseColor) * 0.84000003f) + (Color.blue(-16777216) * 0.16f)));
                gradientDrawable.setColor(argb);
            } catch (Exception unused) {
                gradientDrawable.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22922131099754));
            }
            linearLayout.setBackground(gradientDrawable);
            LinearLayout linearLayout2 = getBinding().scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(linearLayout2, Float.valueOf(12.0f), null, Float.valueOf(12.0f), null, 10);
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.ic_search_white);
        }
        final EditText editText = getBinding().MyBillsEntityDataFactory;
        if (p0) {
            editText.setHintTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(editText.getContext(), R.color.f27072131100488));
            editText.setKeyListener(null);
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(false);
            editText.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolbarGlobalSearchView.$r8$lambda$rSH6oNr1bd1LTkwAfzDtvxou2LA(ToolbarGlobalSearchView.this, view);
                }
            });
            return;
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ToolbarGlobalSearchView.m2838$r8$lambda$7x7QmXH_o4ffr2Il8W8kn5Pgk(editText, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(ToolbarGlobalSearchView toolbarGlobalSearchView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(toolbarGlobalSearchView, "");
        if (i == 66 && keyEvent.getAction() == 1 && toolbarGlobalSearchView.keyword.length() >= 3) {
            Listener listener = toolbarGlobalSearchView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (listener != null) {
                listener.BuiltInFictitiousFunctionClassFactory(toolbarGlobalSearchView.getBinding().MyBillsEntityDataFactory.getText().toString());
            }
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(toolbarGlobalSearchView.getBinding().MyBillsEntityDataFactory);
            Listener listener2 = toolbarGlobalSearchView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (listener2 != null) {
                listener2.BuiltInFictitiousFunctionClassFactory();
                return false;
            }
            return false;
        }
        return false;
    }

    public final void setMenuButtonListener() {
        getBinding().getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolbarGlobalSearchView.$r8$lambda$iGfnG_iZvTOgaFIaV5O76UZYR2M(ToolbarGlobalSearchView.this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolbarGlobalSearchView.$r8$lambda$S6hWpYtwPn8e9Tx3b_wMNNxKgt0(ToolbarGlobalSearchView.this, view);
            }
        });
    }

    @JvmName(name = "getKeyword")
    public final String getKeyword() {
        return this.keyword;
    }

    @JvmName(name = "setKeyword")
    public final void setKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.keyword = str;
        if (str.length() == 0) {
            hideClearSearchButton();
        } else {
            getBinding().getAuthRequestContext.setVisibility(0);
        }
    }

    public final void setListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = listener;
    }

    public final void setHomeSearchListener(HomeSearchListener homeSearchListener) {
        Intrinsics.checkNotNullParameter(homeSearchListener, "");
        this.getAuthRequestContext = homeSearchListener;
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "");
        getBinding().MyBillsEntityDataFactory.addTextChangedListener(textWatcher);
    }

    public final void onSearchToolbarTextChanged(CharSequence text) {
        Listener listener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (listener != null) {
            listener.MyBillsEntityDataFactory(text);
        }
    }

    public final void hideClearSearchButton() {
        getBinding().getAuthRequestContext.setVisibility(8);
    }

    public final void clearSearch() {
        Editable text = getBinding().MyBillsEntityDataFactory.getText();
        if (text != null) {
            text.clear();
        }
    }

    public final void showKeyword(String keywordString) {
        Intrinsics.checkNotNullParameter(keywordString, "");
        setKeyword(keywordString);
        getBinding().MyBillsEntityDataFactory.setText(keywordString);
        getBinding().MyBillsEntityDataFactory.setSelection(keywordString.length());
        getBinding().MyBillsEntityDataFactory.clearFocus();
    }

    public final void clearPointerFocus() {
        getBinding().MyBillsEntityDataFactory.clearFocus();
    }

    public final void setPointerFocus() {
        getBinding().MyBillsEntityDataFactory.requestFocus();
    }

    public final void setBackgroundColor(String customColor) {
        ViewUtil viewUtil = ViewUtil.INSTANCE;
        ViewUtil.BuiltInFictitiousFunctionClassFactory(getBinding().lookAheadTest, customColor);
        ViewUtil viewUtil2 = ViewUtil.INSTANCE;
        ViewUtil.BuiltInFictitiousFunctionClassFactory(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0, customColor);
        PlaceComponentResult(true, customColor);
    }

    /* renamed from: $r8$lambda$7x7Qm-XH_o4ffr2Il8W-8kn5Pgk  reason: not valid java name */
    public static /* synthetic */ void m2838$r8$lambda$7x7QmXH_o4ffr2Il8W8kn5Pgk(EditText editText, View view, boolean z) {
        String string;
        Intrinsics.checkNotNullParameter(editText, "");
        if (!z) {
            string = editText.getContext().getString(R.string.text_looking_for_anything_in_DANA);
        }
        editText.setHint(string);
    }

    public static /* synthetic */ void $r8$lambda$QspRWKeVbV_pRaJ0KlylkQR9ioE(ToolbarGlobalSearchView toolbarGlobalSearchView, View view) {
        Intrinsics.checkNotNullParameter(toolbarGlobalSearchView, "");
        String obj = toolbarGlobalSearchView.getBinding().MyBillsEntityDataFactory.getText().toString();
        Listener listener = toolbarGlobalSearchView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (listener != null) {
            listener.BuiltInFictitiousFunctionClassFactory(obj);
        }
    }

    public static /* synthetic */ void $r8$lambda$S6hWpYtwPn8e9Tx3b_wMNNxKgt0(ToolbarGlobalSearchView toolbarGlobalSearchView, View view) {
        Intrinsics.checkNotNullParameter(toolbarGlobalSearchView, "");
        Listener listener = toolbarGlobalSearchView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (listener != null) {
            listener.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$iGfnG_iZvTOgaFIaV5O76UZYR2M(ToolbarGlobalSearchView toolbarGlobalSearchView, View view) {
        Intrinsics.checkNotNullParameter(toolbarGlobalSearchView, "");
        toolbarGlobalSearchView.clearSearch();
        Listener listener = toolbarGlobalSearchView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (listener != null) {
            listener.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$rSH6oNr1bd1LTkwAfzDtvxou2LA(ToolbarGlobalSearchView toolbarGlobalSearchView, View view) {
        Intrinsics.checkNotNullParameter(toolbarGlobalSearchView, "");
        HomeSearchListener homeSearchListener = toolbarGlobalSearchView.getAuthRequestContext;
        if (homeSearchListener != null) {
            homeSearchListener.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$x_ZPpXfUh9TJ33Y6o8Jhz_PhpKw(ToolbarGlobalSearchView toolbarGlobalSearchView, View view) {
        Intrinsics.checkNotNullParameter(toolbarGlobalSearchView, "");
        toolbarGlobalSearchView.clearSearch();
        Listener listener = toolbarGlobalSearchView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (listener != null) {
            listener.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolbarGlobalSearchView.$r8$lambda$x_ZPpXfUh9TJ33Y6o8Jhz_PhpKw(ToolbarGlobalSearchView.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolbarGlobalSearchView.$r8$lambda$QspRWKeVbV_pRaJ0KlylkQR9ioE(ToolbarGlobalSearchView.this, view);
            }
        });
        RxTextView.textChangeEvents(getBinding().MyBillsEntityDataFactory).debounce(2L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DisposableObserver<TextViewTextChangeEvent>() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$getSearchObserver$1
            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ViewToolbarGlobalSearchBinding binding;
                TextViewTextChangeEvent textViewTextChangeEvent = (TextViewTextChangeEvent) obj;
                Intrinsics.checkNotNullParameter(textViewTextChangeEvent, "");
                binding = ToolbarGlobalSearchView.this.getBinding();
                if (binding.MyBillsEntityDataFactory.isFocused()) {
                    ToolbarGlobalSearchView.this.onSearchToolbarTextChanged(textViewTextChangeEvent.text().toString());
                }
            }
        });
        EditText editText = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$setup$$inlined$onTextAfterChanged$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                String obj = p0 != null ? p0.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                ToolbarGlobalSearchView.this.setKeyword(obj);
            }
        });
        getBinding().MyBillsEntityDataFactory.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.richview.globalsearch.ToolbarGlobalSearchView$$ExternalSyntheticLambda6
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = ToolbarGlobalSearchView.BuiltInFictitiousFunctionClassFactory(ToolbarGlobalSearchView.this, i, keyEvent);
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
    }
}
