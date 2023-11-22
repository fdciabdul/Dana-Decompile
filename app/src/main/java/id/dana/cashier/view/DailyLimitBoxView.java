package id.dana.cashier.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.cashier.addCard.model.DailyLimitCardVerifyElementModel;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.util.BalanceUtil;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.core.ui.util.NumberUtil;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewDailyLimitBoxViewBinding;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005R.\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R4\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/cashier/view/DailyLimitBoxView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewDailyLimitBoxViewBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "inflateViewBinding", "()Lid/dana/databinding/ViewDailyLimitBoxViewBinding;", "setup", "Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "value", "MyBillsEntityDataFactory", "Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "getDailyLimit", "()Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "setDailyLimit", "(Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;)V", "dailyLimit", "Lkotlin/Function2;", "", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function2;", "getInputDailyLimitListener", "()Lkotlin/jvm/functions/Function2;", "setInputDailyLimitListener", "(Lkotlin/jvm/functions/Function2;)V", "inputDailyLimitListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyLimitBoxView extends BaseViewBindingRichView<ViewDailyLimitBoxViewBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private DailyLimitCardVerifyElementModel dailyLimit;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function2<? super String, ? super Boolean, Unit> inputDailyLimitListener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyLimitBoxView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyLimitBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyLimitBoxView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
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
    public DailyLimitBoxView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.inputDailyLimitListener = new Function2<String, Boolean, Unit>() { // from class: id.dana.cashier.view.DailyLimitBoxView$inputDailyLimitListener$1
            public final void invoke(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
    }

    public /* synthetic */ DailyLimitBoxView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getDailyLimit")
    public final DailyLimitCardVerifyElementModel getDailyLimit() {
        return this.dailyLimit;
    }

    @JvmName(name = "setDailyLimit")
    public final void setDailyLimit(DailyLimitCardVerifyElementModel dailyLimitCardVerifyElementModel) {
        DailyLimitAmountConfModel dailyLimitAmountConfModel;
        Integer num;
        if (dailyLimitCardVerifyElementModel != null) {
            this.dailyLimit = dailyLimitCardVerifyElementModel;
            if (dailyLimitCardVerifyElementModel == null || (dailyLimitAmountConfModel = dailyLimitCardVerifyElementModel.MyBillsEntityDataFactory) == null || (num = dailyLimitAmountConfModel.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            getBinding().MyBillsEntityDataFactory.setText(NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), num.intValue()));
        }
    }

    @JvmName(name = "getInputDailyLimitListener")
    public final Function2<String, Boolean, Unit> getInputDailyLimitListener() {
        return this.inputDailyLimitListener;
    }

    @JvmName(name = "setInputDailyLimitListener")
    public final void setInputDailyLimitListener(Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.inputDailyLimitListener = function2;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDailyLimitBoxViewBinding inflateViewBinding() {
        ViewDailyLimitBoxViewBinding MyBillsEntityDataFactory = ViewDailyLimitBoxViewBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Editable text;
        String obj;
        TextInputLayout textInputLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        EditText editText = textInputLayout.getEditText();
        boolean z = false;
        if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
            if (obj.length() > 0) {
                z = true;
            }
        }
        textInputLayout.setPrefixText(z ? "Rp" : "");
    }

    /* renamed from: $r8$lambda$L9D8MpfZFMbVf6ytJ-0J0CrLW5s  reason: not valid java name */
    public static /* synthetic */ void m595$r8$lambda$L9D8MpfZFMbVf6ytJ0J0CrLW5s(DailyLimitBoxView dailyLimitBoxView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(dailyLimitBoxView, "");
        if (z) {
            dailyLimitBoxView.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void access$showErrorMessage(DailyLimitBoxView dailyLimitBoxView, String str) {
        TextView textView = dailyLimitBoxView.getBinding().getAuthRequestContext;
        textView.setText(str);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f49812132017435);
    }

    public static final /* synthetic */ void access$showHelperMessage(DailyLimitBoxView dailyLimitBoxView, String str) {
        TextView textView = dailyLimitBoxView.getBinding().getAuthRequestContext;
        textView.setText(str);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f49862132017440);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final DanaTextBoxView danaTextBoxView = getBinding().MyBillsEntityDataFactory;
        danaTextBoxView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.cashier.view.DailyLimitBoxView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                DailyLimitBoxView.m595$r8$lambda$L9D8MpfZFMbVf6ytJ0J0CrLW5s(DailyLimitBoxView.this, view, z);
            }
        });
        danaTextBoxView.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.view.DailyLimitBoxView$listenDailyLimitAmountChange$1$2

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            public int PlaceComponentResult;

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            public int KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = DanaTextBoxView.this.getSelectionStart();
                this.PlaceComponentResult = String.valueOf(DanaTextBoxView.this.getText()).length() - this.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                DailyLimitAmountConfModel dailyLimitAmountConfModel;
                this.KClassImpl$Data$declaredNonStaticMembers$2();
                Editable text = DanaTextBoxView.this.getText();
                if (!(text == null || text.length() == 0)) {
                    DailyLimitBoxView$listenDailyLimitAmountChange$1$2 dailyLimitBoxView$listenDailyLimitAmountChange$1$2 = this;
                    DanaTextBoxView.this.removeTextChangedListener(dailyLimitBoxView$listenDailyLimitAmountChange$1$2);
                    NumberUtil numberUtil = NumberUtil.INSTANCE;
                    String valueOf = String.valueOf(DanaTextBoxView.this.getText());
                    Intrinsics.checkNotNullParameter(valueOf, "");
                    String BuiltInFictitiousFunctionClassFactory = NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), NumberExtKt.toSafeLong$default(NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(NumberUtil.PlaceComponentResult(valueOf)), 0L, 1, (Object) null));
                    String replace = BuiltInFictitiousFunctionClassFactory != null ? new Regex("Rp").replace(BuiltInFictitiousFunctionClassFactory, "") : null;
                    int length = replace != null ? replace.length() : 0;
                    DanaTextBoxView.this.setText(replace);
                    DanaTextBoxView danaTextBoxView2 = DanaTextBoxView.this;
                    int i = length - this.PlaceComponentResult;
                    if (i < 0) {
                        i = 0;
                    }
                    danaTextBoxView2.setSelection(i);
                    DanaTextBoxView.this.addTextChangedListener(dailyLimitBoxView$listenDailyLimitAmountChange$1$2);
                }
                String cleanDot = NumberUtils.getCleanDot(new Regex("Rp").replace(String.valueOf(DanaTextBoxView.this.getText()), ""));
                Intrinsics.checkNotNullExpressionValue(cleanDot, "");
                if (cleanDot.length() > 0) {
                    DailyLimitCardVerifyElementModel dailyLimit = this.getDailyLimit();
                    if (dailyLimit != null && (dailyLimitAmountConfModel = dailyLimit.MyBillsEntityDataFactory) != null) {
                        Ref.BooleanRef booleanRef2 = booleanRef;
                        DailyLimitBoxView dailyLimitBoxView = this;
                        DanaTextBoxView danaTextBoxView3 = DanaTextBoxView.this;
                        if (dailyLimitAmountConfModel.MyBillsEntityDataFactory != null) {
                            BigInteger bigInteger = new BigInteger(cleanDot);
                            BigInteger valueOf2 = BigInteger.valueOf(dailyLimitAmountConfModel.MyBillsEntityDataFactory.intValue());
                            Intrinsics.checkNotNullExpressionValue(valueOf2, "");
                            if (bigInteger.compareTo(valueOf2) > 0) {
                                booleanRef2.element = false;
                                Context context = danaTextBoxView3.getContext();
                                BalanceUtil balanceUtil = BalanceUtil.INSTANCE;
                                String obj = dailyLimitAmountConfModel.MyBillsEntityDataFactory.toString();
                                Intrinsics.checkNotNullParameter(obj, "");
                                Intrinsics.checkNotNullParameter(obj, "");
                                CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(obj, null, false, 6, null);
                                currencyAmountModel.setCurrency(GlobalNetworkConstants.IDR_CURRENCY);
                                String string = context.getString(R.string.daily_limit_maximum_error_message, BalanceUtil.getAuthRequestContext(currencyAmountModel));
                                Intrinsics.checkNotNullExpressionValue(string, "");
                                DailyLimitBoxView.access$showErrorMessage(dailyLimitBoxView, string);
                            }
                        }
                        if (dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                            BigInteger bigInteger2 = new BigInteger(cleanDot);
                            BigInteger valueOf3 = BigInteger.valueOf(dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2.intValue());
                            Intrinsics.checkNotNullExpressionValue(valueOf3, "");
                            if (bigInteger2.compareTo(valueOf3) < 0) {
                                booleanRef2.element = false;
                                Context context2 = danaTextBoxView3.getContext();
                                BalanceUtil balanceUtil2 = BalanceUtil.INSTANCE;
                                String obj2 = dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2.toString();
                                Intrinsics.checkNotNullParameter(obj2, "");
                                Intrinsics.checkNotNullParameter(obj2, "");
                                CurrencyAmountModel currencyAmountModel2 = new CurrencyAmountModel(obj2, null, false, 6, null);
                                currencyAmountModel2.setCurrency(GlobalNetworkConstants.IDR_CURRENCY);
                                String string2 = context2.getString(R.string.daily_limit_minimum_error_message, BalanceUtil.getAuthRequestContext(currencyAmountModel2));
                                Intrinsics.checkNotNullExpressionValue(string2, "");
                                DailyLimitBoxView.access$showErrorMessage(dailyLimitBoxView, string2);
                            }
                        }
                        booleanRef2.element = true;
                        String string3 = danaTextBoxView3.getContext().getString(R.string.daily_limit_description_helper);
                        Intrinsics.checkNotNullExpressionValue(string3, "");
                        DailyLimitBoxView.access$showHelperMessage(dailyLimitBoxView, string3);
                    }
                } else {
                    booleanRef.element = false;
                    DailyLimitBoxView dailyLimitBoxView2 = this;
                    String string4 = DanaTextBoxView.this.getContext().getString(R.string.daily_limit_description_helper);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    DailyLimitBoxView.access$showHelperMessage(dailyLimitBoxView2, string4);
                }
                this.getInputDailyLimitListener().invoke(cleanDot, Boolean.valueOf(booleanRef.element));
            }
        });
    }
}
