package id.dana.mybills.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.component.buttoncomponent.BaseDanaButton;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.StringExtKt;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewFooterDashboardBinding;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.utils.MyBillsMoneyUtilsV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0018¢\u0006\u0004\b&\u0010'B+\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0018\u0012\u0006\u0010(\u001a\u00020\u0018¢\u0006\u0004\b&\u0010)J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010\t\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001e"}, d2 = {"Lid/dana/mybills/ui/customview/FooterDashboardView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewFooterDashboardBinding;", "Lid/dana/component/buttoncomponent/BaseDanaButton;", "getPayButton", "()Lid/dana/component/buttoncomponent/BaseDanaButton;", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewFooterDashboardBinding;", "", "getAuthRequestContext", "()Z", "PlaceComponentResult", "Lid/dana/mybills/ui/model/MoneyViewModel;", "balance", "", "setBalance", "(Lid/dana/mybills/ui/model/MoneyViewModel;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "Lkotlin/Function0;", "onClick", "setButtonPayOnClick", "(Lkotlin/jvm/functions/Function0;)V", "setButtonTopUpOnClick", "", "totalItems", "totalPrice", "setTotalItems", "(ILid/dana/mybills/ui/model/MoneyViewModel;)V", "MyBillsEntityDataFactory", "Lid/dana/mybills/ui/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FooterDashboardView extends BaseViewBindingRichView<ViewFooterDashboardBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MoneyViewModel BuiltInFictitiousFunctionClassFactory;
    private MoneyViewModel getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FooterDashboardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FooterDashboardView(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ FooterDashboardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterDashboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        String str = null;
        String str2 = null;
        int i2 = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.BuiltInFictitiousFunctionClassFactory = new MoneyViewModel("0", str, str2, i2, defaultConstructorMarker);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MoneyViewModel("0", null, null, 6, null);
        this.getAuthRequestContext = new MoneyViewModel("0", str, str2, i2, defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterDashboardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        String str = null;
        String str2 = null;
        int i3 = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.BuiltInFictitiousFunctionClassFactory = new MoneyViewModel("0", str, str2, i3, defaultConstructorMarker);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MoneyViewModel("0", null, null, 6, null);
        this.getAuthRequestContext = new MoneyViewModel("0", str, str2, i3, defaultConstructorMarker);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewFooterDashboardBinding inflateViewBinding() {
        ViewFooterDashboardBinding BuiltInFictitiousFunctionClassFactory = ViewFooterDashboardBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setTotalItems(int totalItems, MoneyViewModel totalPrice) {
        String string;
        Intrinsics.checkNotNullParameter(totalPrice, "");
        this.BuiltInFictitiousFunctionClassFactory = totalPrice;
        this.PlaceComponentResult = totalItems;
        ViewFooterDashboardBinding binding = getBinding();
        TextView textView = binding.scheduleImpl;
        if (PlaceComponentResult()) {
            string = getContext().getString(R.string.my_bills_total_selected_items, Integer.valueOf(this.PlaceComponentResult));
        } else {
            string = getContext().getString(R.string.my_bills_total_no_selected_items);
        }
        textView.setText(string);
        binding.getErrorConfigVersion.setText(NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), this.BuiltInFictitiousFunctionClassFactory.getAmountLong(), GlobalNetworkConstants.IDR_CURRENCY));
        CurrentBalanceMyBillsViewV2 currentBalanceMyBillsViewV2 = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(currentBalanceMyBillsViewV2, "");
        currentBalanceMyBillsViewV2.setVisibility(PlaceComponentResult() ? 0 : 8);
        AppCompatImageView appCompatImageView = binding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(PlaceComponentResult() ? 0 : 8);
        BuiltInFictitiousFunctionClassFactory();
    }

    public final void setBalance(MoneyViewModel balance) {
        Intrinsics.checkNotNullParameter(balance, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = balance;
        getBinding().MyBillsEntityDataFactory.setBalance(this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (!getAuthRequestContext()) {
            MyBillsMoneyUtilsV2 myBillsMoneyUtilsV2 = MyBillsMoneyUtilsV2.INSTANCE;
            this.getAuthRequestContext = MyBillsMoneyUtilsV2.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        String PlaceComponentResult;
        ViewFooterDashboardBinding binding = getBinding();
        DanaButtonSecondaryView danaButtonSecondaryView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(!getAuthRequestContext() && this.PlaceComponentResult > 0 ? 0 : 8);
        if (!PlaceComponentResult()) {
            TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), R.color.NetworkUserEntityData$$ExternalSyntheticLambda0));
            textView.setText(textView.getContext().getString(R.string.res_0x7f130f5d_summaryvoucherview_externalsyntheticlambda2));
            binding.getAuthRequestContext.setDisabled(getContext().getString(R.string.my_bills_pay_bills_button));
            binding.getAuthRequestContext.setEnabled(false);
            AppCompatImageView appCompatImageView = binding.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(8);
        } else if (!getAuthRequestContext()) {
            TextView textView2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView2.getContext(), R.color.newProxyInstance));
            Context context = textView2.getContext();
            int i = R.string.my_bills_label_dana_balance_insufficient;
            MyBillsMoneyUtilsV2 myBillsMoneyUtilsV2 = MyBillsMoneyUtilsV2.INSTANCE;
            PlaceComponentResult = StringExtKt.PlaceComponentResult(MyBillsMoneyUtilsV2.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory).getCleanAmount(), "Rp", "0");
            textView2.setText(context.getString(i, PlaceComponentResult));
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.moveToNextValue, R.drawable.FragmentBottomSheetPaymentSettingBinding);
            binding.getAuthRequestContext.setDisabled(getContext().getString(R.string.my_bills_pay_bills_button));
            binding.getAuthRequestContext.setEnabled(false);
        } else {
            TextView textView3 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            textView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView3.getContext(), R.color.getAuthRequestContext));
            textView3.setText(textView3.getContext().getString(R.string.my_bills_label_dana_balance_sufficient));
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.moveToNextValue, R.drawable.res_0x7f080b7b_networkuserentitydata_externalsyntheticlambda4);
            binding.getAuthRequestContext.setActiveButton(getContext().getString(R.string.my_bills_pay_bills_button), null);
            binding.getAuthRequestContext.setEnabled(true);
        }
    }

    public final void setButtonTopUpOnClick(final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.FooterDashboardView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FooterDashboardView.$r8$lambda$bRWB8MLc3yClvyU8vfyLeS1CWiU(Function0.this, view);
            }
        });
    }

    public final void setButtonPayOnClick(final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        if (getBinding().getAuthRequestContext.isEnabled()) {
            getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.FooterDashboardView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FooterDashboardView.$r8$lambda$vr2GwStNvHkx6Lb6XeYEzwcqi_Y(Function0.this, view);
                }
            });
        }
    }

    public final BaseDanaButton getPayButton() {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        return danaButtonPrimaryView;
    }

    private final boolean getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAmountLong() >= this.BuiltInFictitiousFunctionClassFactory.getAmountLong();
    }

    private final boolean PlaceComponentResult() {
        return this.PlaceComponentResult > 0;
    }

    public static /* synthetic */ void $r8$lambda$bRWB8MLc3yClvyU8vfyLeS1CWiU(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void $r8$lambda$vr2GwStNvHkx6Lb6XeYEzwcqi_Y(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
