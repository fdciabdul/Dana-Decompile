package id.dana.mybills.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewMyBillsFooterMonthlyBinding;
import id.dana.mybills.utils.MyBillsMoneyUtils;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0003¢\u0006\u0004\b&\u0010'B+\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0004\b&\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0019\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001e"}, d2 = {"Lid/dana/mybills/view/FooterMonthlyView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewMyBillsFooterMonthlyBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewMyBillsFooterMonthlyBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "balance", "", "setBalance", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "getAuthRequestContext", "()V", "Lkotlin/Function0;", "onClick", "setButtonPayOnClick", "(Lkotlin/jvm/functions/Function0;)V", "setButtonTopUpOnCLick", "totalItems", "totalPrice", "setTotalItems", "(ILid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FooterMonthlyView extends ViewBindingRichView<ViewMyBillsFooterMonthlyBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private MoneyViewModel MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    private MoneyViewModel getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FooterMonthlyView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FooterMonthlyView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_my_bills_footer_monthly;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterMonthlyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        String str = null;
        String str2 = null;
        int i2 = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MoneyViewModel("0", str, str2, i2, defaultConstructorMarker);
        this.getAuthRequestContext = new MoneyViewModel("0", null, null, 6, null);
        this.MyBillsEntityDataFactory = new MoneyViewModel("0", str, str2, i2, defaultConstructorMarker);
    }

    public /* synthetic */ FooterMonthlyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterMonthlyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        String str = null;
        String str2 = null;
        int i3 = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MoneyViewModel("0", str, str2, i3, defaultConstructorMarker);
        this.getAuthRequestContext = new MoneyViewModel("0", null, null, 6, null);
        this.MyBillsEntityDataFactory = new MoneyViewModel("0", str, str2, i3, defaultConstructorMarker);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewMyBillsFooterMonthlyBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewMyBillsFooterMonthlyBinding PlaceComponentResult = ViewMyBillsFooterMonthlyBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void setTotalItems(int totalItems, MoneyViewModel totalPrice) {
        String string;
        String format;
        Intrinsics.checkNotNullParameter(totalPrice, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = totalPrice;
        this.BuiltInFictitiousFunctionClassFactory = totalItems;
        ViewMyBillsFooterMonthlyBinding binding = getBinding();
        TextView textView = binding.lookAheadTest;
        if (MyBillsEntityDataFactory()) {
            string = getContext().getString(R.string.my_bills_total_selected_items, Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory));
        } else {
            string = getContext().getString(R.string.my_bills_total_no_selected_items);
        }
        textView.setText(string);
        TextView textView2 = binding.getErrorConfigVersion;
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
        if (format == null) {
            format = "";
        }
        sb.append(format);
        textView2.setText(sb.toString());
        CurrentBalanceMyBillsView currentBalanceMyBillsView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(currentBalanceMyBillsView, "");
        currentBalanceMyBillsView.setVisibility(MyBillsEntityDataFactory() ? 0 : 8);
        AppCompatImageView appCompatImageView = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(MyBillsEntityDataFactory() ? 0 : 8);
        getAuthRequestContext();
    }

    public final void setBalance(MoneyViewModel balance) {
        Intrinsics.checkNotNullParameter(balance, "");
        this.getAuthRequestContext = balance;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBalance(this.getAuthRequestContext);
        if (!BuiltInFictitiousFunctionClassFactory()) {
            MyBillsMoneyUtils myBillsMoneyUtils = MyBillsMoneyUtils.INSTANCE;
            this.MyBillsEntityDataFactory = MyBillsMoneyUtils.MyBillsEntityDataFactory(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        String format;
        ViewMyBillsFooterMonthlyBinding binding = getBinding();
        DanaButtonSecondaryView danaButtonSecondaryView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(!BuiltInFictitiousFunctionClassFactory() && this.BuiltInFictitiousFunctionClassFactory > 0 ? 0 : 8);
        if (!MyBillsEntityDataFactory()) {
            TextView textView = binding.moveToNextValue;
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), R.color.f23982131099995));
            textView.setText(textView.getContext().getString(R.string.res_0x7f130f5d_summaryvoucherview_externalsyntheticlambda2));
            binding.PlaceComponentResult.setDisabled(getContext().getString(R.string.my_bills_pay_bills_button));
            CurrentBalanceMyBillsView currentBalanceMyBillsView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(currentBalanceMyBillsView, "");
            currentBalanceMyBillsView.setVisibility(8);
            AppCompatImageView appCompatImageView = binding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(8);
        } else if (!BuiltInFictitiousFunctionClassFactory()) {
            TextView textView2 = binding.moveToNextValue;
            textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView2.getContext(), R.color.f27152131100507));
            Context context = textView2.getContext();
            Object[] objArr = new Object[1];
            MoneyViewModel moneyViewModel = this.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
            sb.append(format != null ? format : "");
            objArr[0] = sb.toString();
            textView2.setText(context.getString(R.string.my_bills_label_dana_balance_insufficient, objArr));
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.scheduleImpl, R.drawable.ic_warning_yellow);
            binding.PlaceComponentResult.setDisabled(getContext().getString(R.string.my_bills_pay_bills_button));
        } else {
            TextView textView3 = binding.moveToNextValue;
            textView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView3.getContext(), R.color.f22912131099753));
            binding.moveToNextValue.setText(textView3.getContext().getString(R.string.my_bills_label_dana_balance_sufficient));
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.scheduleImpl, R.drawable.ic_check_selected);
        }
    }

    public final void setButtonTopUpOnCLick(final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.view.FooterMonthlyView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FooterMonthlyView.$r8$lambda$Uw81Tb2g95Zr9rWXzPsToud0ffk(Function0.this, view);
            }
        });
    }

    public final void setButtonPayOnClick(final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.view.FooterMonthlyView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FooterMonthlyView.$r8$lambda$tmEEjN2_NGukDAfsRHKBwi9MCzM(Function0.this, view);
            }
        });
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        String cleanAll = NumberUtils.getCleanAll(this.getAuthRequestContext.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        String cleanAll2 = NumberUtils.getCleanAll(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        Long longOrNull2 = StringsKt.toLongOrNull(cleanAll2 != null ? cleanAll2 : "0");
        return longValue >= (longOrNull2 != null ? longOrNull2.longValue() : 0L);
    }

    private final boolean MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory > 0;
    }

    public static /* synthetic */ void $r8$lambda$Uw81Tb2g95Zr9rWXzPsToud0ffk(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void $r8$lambda$tmEEjN2_NGukDAfsRHKBwi9MCzM(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
