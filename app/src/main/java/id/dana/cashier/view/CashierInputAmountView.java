package id.dana.cashier.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.StringExtKt;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.databinding.ViewCashierInputAmountBinding;
import id.dana.extension.view.InputExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.OSUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002EFB'\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AB+\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010B\u001a\u00020>\u0012\u0006\u0010C\u001a\u00020>¢\u0006\u0004\b@\u0010DJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0015J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u001e\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u0015J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005J\u0017\u0010#\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\u0015J\u0017\u0010%\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u0007¢\u0006\u0004\b%\u0010\u0015R\u0018\u0010(\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R*\u0010.\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00078\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u0015R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u0010+R\"\u00104\u001a\u00020\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0012R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00100R\u0016\u0010&\u001a\u0002068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u00100"}, d2 = {"Lid/dana/cashier/view/CashierInputAmountView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewCashierInputAmountBinding;", "", "clear", "()V", "disableSoftKeyboard", "", "getAmount", "()Ljava/lang/String;", "Lid/dana/core/ui/richview/CurrencyEditText;", "getEditTextAmount", "()Lid/dana/core/ui/richview/CurrencyEditText;", "inflateViewBinding", "()Lid/dana/databinding/ViewCashierInputAmountBinding;", "", "overrideListener", "overrideAmountListener", "(Z)V", "defaultHelperMessage", "setDefaultHelperMessage", "(Ljava/lang/String;)V", "inputTitle", "setInputTitle", "Lid/dana/cashier/view/CashierInputAmountView$OnAmountChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/cashier/view/CashierInputAmountView$OnAmountChangeListener;)V", "", "amountValue", "setPrefixedAmount", "(J)V", "amount", "setup", "errorMessage", "showErrorMessage", "helperMessage", "showHelperMessage", "PlaceComponentResult", "Lid/dana/cashier/view/CashierInputAmountView$OnAmountChangeListener;", "MyBillsEntityDataFactory", "value", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getCurrency", "setCurrency", FirebaseAnalytics.Param.CURRENCY, "getAuthRequestContext", "Z", "getDisableClearIcon", "()Z", "setDisableClearIcon", "disableClearIcon", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "moveToNextValue", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "lookAheadTest", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnAmountChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierInputAmountView extends BaseViewBindingRichView<ViewCashierInputAmountBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String currency;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean disableClearIcon;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private OnAmountChangeListener MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;
    private String getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private MoneyViewModel PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/view/CashierInputAmountView$OnAmountChangeListener;", "", "", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZD)V", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnAmountChangeListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, double p1);

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierInputAmountView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierInputAmountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierInputAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.currency = "Rp";
        this.PlaceComponentResult = new MoneyViewModel("10000000", this.currency, null, 4, null);
        Context context2 = getContext();
        String string = context2 != null ? context2.getString(R.string.input_amount_note) : null;
        this.getAuthRequestContext = string != null ? string : "";
    }

    public /* synthetic */ CashierInputAmountView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierInputAmountView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.currency = "Rp";
        this.PlaceComponentResult = new MoneyViewModel("10000000", this.currency, null, 4, null);
        Context context2 = getContext();
        String string = context2 != null ? context2.getString(R.string.input_amount_note) : null;
        this.getAuthRequestContext = string != null ? string : "";
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "setCurrency")
    public final void setCurrency(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.currency = str;
        TextView textView = getBinding().getAuthRequestContext;
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, StringExtKt.MyBillsEntityDataFactory(this.currency) ? R.style.f49672132017413 : R.style.f49602132017405);
        textView.setText(this.currency);
    }

    @JvmName(name = "getDisableClearIcon")
    public final boolean getDisableClearIcon() {
        return this.disableClearIcon;
    }

    @JvmName(name = "setDisableClearIcon")
    public final void setDisableClearIcon(boolean z) {
        this.disableClearIcon = z;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCashierInputAmountBinding inflateViewBinding() {
        ViewCashierInputAmountBinding BuiltInFictitiousFunctionClassFactory = ViewCashierInputAmountBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setPrefixedAmount(long amountValue) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setPrefixedAmount(amountValue);
    }

    public final void setPrefixedAmount(String amount) {
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(amount, "");
        String str = amount;
        boolean z = false;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setDecimalPointEnabled(StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null));
        boolean z2 = StringsKt.endsWith$default(amount, ".0", false, 2, (Object) null) || StringsKt.endsWith$default(amount, ".00", false, 2, (Object) null);
        if (StringsKt.last(str) == '.') {
            doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.substringBeforeLast$default(amount, ".", (String) null, 2, (Object) null));
            z = true;
        } else {
            doubleOrNull = StringsKt.toDoubleOrNull(amount);
        }
        if (doubleOrNull != null) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setPrefixedAmount(doubleOrNull.doubleValue());
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append((Object) getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText());
                sb.append(',');
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(sb.toString());
            }
            if (z2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((Object) getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText());
                sb2.append(',');
                sb2.append(StringsKt.substringAfter$default(amount, ".", (String) null, 2, (Object) null));
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(sb2.toString());
            }
        }
    }

    public final String getAmount() {
        String amount = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getAmount();
        return amount == null ? "" : amount;
    }

    public final CurrencyEditText getEditTextAmount() {
        CurrencyEditText currencyEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        return currencyEditText;
    }

    public final void overrideAmountListener(boolean overrideListener) {
        this.BuiltInFictitiousFunctionClassFactory = overrideListener;
    }

    public final void setDefaultHelperMessage(String defaultHelperMessage) {
        Intrinsics.checkNotNullParameter(defaultHelperMessage, "");
        this.getAuthRequestContext = defaultHelperMessage;
    }

    public final void setListener(OnAmountChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.MyBillsEntityDataFactory = listener;
    }

    public final void clear() {
        CurrencyEditText currencyEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        InputExtKt.MyBillsEntityDataFactory(currencyEditText);
    }

    public final void disableSoftKeyboard() {
        if (OSUtil.scheduleImpl()) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setShowSoftInputOnFocus(false);
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setTextIsSelectable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(CurrencyEditText currencyEditText, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(currencyEditText, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        if (currencyEditText.getCompoundDrawables()[2] != null && motionEvent.getRawX() >= currencyEditText.getRight() - currencyEditText.getCompoundDrawables()[2].getBounds().width() && currencyEditText.getText() != null) {
            InputExtKt.MyBillsEntityDataFactory(currencyEditText);
            return true;
        }
        currencyEditText.performClick();
        return false;
    }

    public final void setInputTitle(String inputTitle) {
        Intrinsics.checkNotNullParameter(inputTitle, "");
        getBinding().PlaceComponentResult.setText(inputTitle);
    }

    public static /* synthetic */ void showErrorMessage$default(CashierInputAmountView cashierInputAmountView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        cashierInputAmountView.showErrorMessage(str);
    }

    public final void showErrorMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "");
        TextView textView = getBinding().scheduleImpl;
        String str = errorMessage;
        if (str.length() == 0) {
            Context context = textView.getContext();
            str = context != null ? context.getString(R.string.input_amount_exceed_maximum_limit) : null;
        }
        textView.setText(str);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f49812132017435);
        TextViewCompat.MyBillsEntityDataFactory(textView, 0, 0, (int) R.drawable.ic_warning_16, 0);
    }

    public static /* synthetic */ void showHelperMessage$default(CashierInputAmountView cashierInputAmountView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        cashierInputAmountView.showHelperMessage(str);
    }

    public final void showHelperMessage(String helperMessage) {
        Intrinsics.checkNotNullParameter(helperMessage, "");
        TextView textView = getBinding().scheduleImpl;
        String str = helperMessage;
        if (str.length() == 0) {
            str = this.getAuthRequestContext;
        }
        textView.setText(str);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f49862132017440);
        TextViewCompat.MyBillsEntityDataFactory(textView, 0, 0, (int) R.drawable.ic_info_grey_40, 0);
    }

    public static final /* synthetic */ void access$setClearTextIcon(CashierInputAmountView cashierInputAmountView, CurrencyEditText currencyEditText, String str) {
        if (cashierInputAmountView.disableClearIcon) {
            return;
        }
        currencyEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, (!(str.length() > 0) || str.contentEquals("0")) ? 0 : R.drawable.ic_close_filled_grey, 0);
    }

    public static final /* synthetic */ void access$setFieldStateActive(CashierInputAmountView cashierInputAmountView) {
        TextView textView = cashierInputAmountView.getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f54032132017897);
        Drawable background = cashierInputAmountView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getBackground();
        if (background != null) {
            background.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(cashierInputAmountView.getContext(), R.color.getErrorConfigVersion_res_0x7f060305), PorterDuff.Mode.SRC_IN);
        }
    }

    public static final /* synthetic */ void access$setFieldStateInactive(CashierInputAmountView cashierInputAmountView) {
        TextView textView = cashierInputAmountView.getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f54072132017901);
        Drawable background = cashierInputAmountView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getBackground();
        if (background != null) {
            background.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(cashierInputAmountView.getContext(), R.color.f23962131099992), PorterDuff.Mode.SRC_IN);
        }
    }

    public static final /* synthetic */ void access$validateAmount(CashierInputAmountView cashierInputAmountView, MoneyViewModel moneyViewModel) {
        OnAmountChangeListener onAmountChangeListener;
        OnAmountChangeListener onAmountChangeListener2;
        if (cashierInputAmountView.BuiltInFictitiousFunctionClassFactory) {
            OnAmountChangeListener onAmountChangeListener3 = cashierInputAmountView.MyBillsEntityDataFactory;
            if (onAmountChangeListener3 != null) {
                onAmountChangeListener3.KClassImpl$Data$declaredNonStaticMembers$2(true, moneyViewModel.MyBillsEntityDataFactory());
            }
        } else if (moneyViewModel.MyBillsEntityDataFactory() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            showHelperMessage$default(cashierInputAmountView, null, 1, null);
            OnAmountChangeListener onAmountChangeListener4 = cashierInputAmountView.MyBillsEntityDataFactory;
            if (onAmountChangeListener4 != null) {
                onAmountChangeListener4.KClassImpl$Data$declaredNonStaticMembers$2(false, moneyViewModel.MyBillsEntityDataFactory());
            }
            cashierInputAmountView.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        } else if (moneyViewModel.MyBillsEntityDataFactory() > cashierInputAmountView.PlaceComponentResult.MyBillsEntityDataFactory()) {
            showErrorMessage$default(cashierInputAmountView, null, 1, null);
            if (cashierInputAmountView.KClassImpl$Data$declaredNonStaticMembers$2 && (onAmountChangeListener2 = cashierInputAmountView.MyBillsEntityDataFactory) != null) {
                onAmountChangeListener2.KClassImpl$Data$declaredNonStaticMembers$2(false, moneyViewModel.MyBillsEntityDataFactory());
            }
            cashierInputAmountView.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        } else {
            showHelperMessage$default(cashierInputAmountView, null, 1, null);
            if (!cashierInputAmountView.KClassImpl$Data$declaredNonStaticMembers$2 && (onAmountChangeListener = cashierInputAmountView.MyBillsEntityDataFactory) != null) {
                onAmountChangeListener.KClassImpl$Data$declaredNonStaticMembers$2(true, moneyViewModel.MyBillsEntityDataFactory());
            }
            cashierInputAmountView.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        KeyboardHelper.PlaceComponentResult(getBinding().MyBillsEntityDataFactory, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.cashier.view.CashierInputAmountView$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                CashierInputAmountView.access$setFieldStateActive(CashierInputAmountView.this);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                CashierInputAmountView.access$setFieldStateInactive(CashierInputAmountView.this);
            }
        });
        final CurrencyEditText currencyEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        currencyEditText.setUsePrefix(false);
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(currencyEditText, (int) R.style.f54412132017956);
        currencyEditText.setListener(new CurrencyEditText.Listener() { // from class: id.dana.cashier.view.CashierInputAmountView$setupViews$1$1
            @Override // id.dana.core.ui.richview.CurrencyEditText.Listener
            public final void PlaceComponentResult() {
                CurrencyEditText.this.clearFocus();
            }
        });
        currencyEditText.setTextHint("0");
        currencyEditText.setTextHintColor(R.color.f25492131100161);
        currencyEditText.setAllowEmpty(true);
        currencyEditText.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.cashier.view.CashierInputAmountView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean PlaceComponentResult;
                PlaceComponentResult = CashierInputAmountView.PlaceComponentResult(CurrencyEditText.this, motionEvent);
                return PlaceComponentResult;
            }
        });
        final CurrencyEditText currencyEditText2 = currencyEditText;
        if (ViewCompat.C(currencyEditText2)) {
            LifecycleOwner PlaceComponentResult = C0207ViewKt.PlaceComponentResult(currencyEditText2);
            if (PlaceComponentResult != null) {
                FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new CashierInputAmountView$setupViews$1$2$1$1(this, currencyEditText, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult));
                return;
            }
            return;
        }
        currencyEditText2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: id.dana.cashier.view.CashierInputAmountView$setupViews$lambda-3$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                currencyEditText2.removeOnAttachStateChangeListener(this);
                Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(currencyEditText);
                if (PlaceComponentResult2 != null) {
                    FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new CashierInputAmountView$setupViews$1$2$1$1(this, currencyEditText, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2));
                }
            }
        });
    }
}
