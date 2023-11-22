package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.cashier.addCard.model.DailyLimitCardVerifyElementModel;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.util.BalanceUtil;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewDailyLimitCashierBinding;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010$\u001a\u00020\u001f¢\u0006\u0004\b!\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R.\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR4\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/cashier/view/DailyLimitCashierView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewDailyLimitCashierBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewDailyLimitCashierBinding;", "", "setup", "()V", "Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "value", "PlaceComponentResult", "Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "getDailyLimit", "()Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;", "setDailyLimit", "(Lid/dana/cashier/addCard/model/DailyLimitCardVerifyElementModel;)V", "dailyLimit", "Lkotlin/Function2;", "", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function2;", "getInputDailyLimitListener", "()Lkotlin/jvm/functions/Function2;", "setInputDailyLimitListener", "(Lkotlin/jvm/functions/Function2;)V", "inputDailyLimitListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyLimitCashierView extends BaseViewBindingRichView<ViewDailyLimitCashierBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function2<? super String, ? super Boolean, Unit> inputDailyLimitListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private DailyLimitCardVerifyElementModel dailyLimit;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyLimitCashierView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyLimitCashierView(Context context, AttributeSet attributeSet) {
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
    public DailyLimitCashierView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.inputDailyLimitListener = DailyLimitCashierView$inputDailyLimitListener$1.INSTANCE;
    }

    public /* synthetic */ DailyLimitCashierView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyLimitCashierView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.inputDailyLimitListener = DailyLimitCashierView$inputDailyLimitListener$1.INSTANCE;
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
            getBinding().getAuthRequestContext.setPrefixedAmount(num.intValue());
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
    public final ViewDailyLimitCashierBinding inflateViewBinding() {
        ViewDailyLimitCashierBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewDailyLimitCashierBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static final /* synthetic */ void access$showErrorMessage(DailyLimitCashierView dailyLimitCashierView, String str) {
        TextView textView = dailyLimitCashierView.getBinding().MyBillsEntityDataFactory;
        textView.setText(str);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(dailyLimitCashierView.getBinding().MyBillsEntityDataFactory, (int) R.style.f49812132017435);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ViewDailyLimitCashierBinding binding = getBinding();
        MDUtil mDUtil = MDUtil.INSTANCE;
        CurrencyEditText currencyEditText = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        mDUtil.textChanged(currencyEditText, new Function1<CharSequence, Unit>() { // from class: id.dana.cashier.view.DailyLimitCashierView$listenDailyLimitAmountChange$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence charSequence) {
                DailyLimitAmountConfModel dailyLimitAmountConfModel;
                Unit unit;
                Intrinsics.checkNotNullParameter(charSequence, "");
                String cleanDot = NumberUtils.getCleanDot(new Regex("Rp").replace(charSequence.toString(), ""));
                Intrinsics.checkNotNullExpressionValue(cleanDot, "");
                if (cleanDot.length() > 0) {
                    DailyLimitCardVerifyElementModel dailyLimit = DailyLimitCashierView.this.getDailyLimit();
                    if (dailyLimit != null && (dailyLimitAmountConfModel = dailyLimit.MyBillsEntityDataFactory) != null) {
                        Ref.BooleanRef booleanRef2 = booleanRef;
                        DailyLimitCashierView dailyLimitCashierView = DailyLimitCashierView.this;
                        ViewDailyLimitCashierBinding viewDailyLimitCashierBinding = binding;
                        BigInteger bigIntegerOrNull = StringsKt.toBigIntegerOrNull(cleanDot);
                        if (bigIntegerOrNull != null) {
                            if (dailyLimitAmountConfModel.MyBillsEntityDataFactory != null) {
                                BigInteger valueOf = BigInteger.valueOf(dailyLimitAmountConfModel.MyBillsEntityDataFactory.intValue());
                                Intrinsics.checkNotNullExpressionValue(valueOf, "");
                                if (bigIntegerOrNull.compareTo(valueOf) > 0) {
                                    booleanRef2.element = false;
                                    Context context = dailyLimitCashierView.getContext();
                                    BalanceUtil balanceUtil = BalanceUtil.INSTANCE;
                                    String obj = dailyLimitAmountConfModel.MyBillsEntityDataFactory.toString();
                                    Intrinsics.checkNotNullParameter(obj, "");
                                    Intrinsics.checkNotNullParameter(obj, "");
                                    CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(obj, null, false, 6, null);
                                    currencyAmountModel.setCurrency(GlobalNetworkConstants.IDR_CURRENCY);
                                    String string = context.getString(R.string.daily_limit_maximum_error_message, BalanceUtil.getAuthRequestContext(currencyAmountModel));
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                    DailyLimitCashierView.access$showErrorMessage(dailyLimitCashierView, string);
                                    unit = Unit.INSTANCE;
                                }
                            }
                            if (dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                                BigInteger valueOf2 = BigInteger.valueOf(dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2.intValue());
                                Intrinsics.checkNotNullExpressionValue(valueOf2, "");
                                if (bigIntegerOrNull.compareTo(valueOf2) < 0) {
                                    booleanRef2.element = false;
                                    Context context2 = dailyLimitCashierView.getContext();
                                    BalanceUtil balanceUtil2 = BalanceUtil.INSTANCE;
                                    String obj2 = dailyLimitAmountConfModel.KClassImpl$Data$declaredNonStaticMembers$2.toString();
                                    Intrinsics.checkNotNullParameter(obj2, "");
                                    Intrinsics.checkNotNullParameter(obj2, "");
                                    CurrencyAmountModel currencyAmountModel2 = new CurrencyAmountModel(obj2, null, false, 6, null);
                                    currencyAmountModel2.setCurrency(GlobalNetworkConstants.IDR_CURRENCY);
                                    String string2 = context2.getString(R.string.daily_limit_minimum_error_message, BalanceUtil.getAuthRequestContext(currencyAmountModel2));
                                    Intrinsics.checkNotNullExpressionValue(string2, "");
                                    DailyLimitCashierView.access$showErrorMessage(dailyLimitCashierView, string2);
                                    unit = Unit.INSTANCE;
                                }
                            }
                            booleanRef2.element = true;
                            TextView textView = viewDailyLimitCashierBinding.MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(textView, "");
                            textView.setVisibility(8);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            booleanRef2.element = true;
                            TextView textView2 = viewDailyLimitCashierBinding.MyBillsEntityDataFactory;
                            Intrinsics.checkNotNullExpressionValue(textView2, "");
                            textView2.setVisibility(8);
                        }
                    }
                    DailyLimitCashierView.this.getInputDailyLimitListener().invoke(cleanDot, Boolean.valueOf(booleanRef.element));
                }
            }
        });
    }
}
