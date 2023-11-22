package id.dana.cashier.viewholder;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.databinding.ItemCashierPromoSelectionBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.CurrencyAmountModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import java.text.NumberFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/CashierPromoSelectionViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/VoucherCashierModel;", "Lid/dana/databinding/ItemCashierPromoSelectionBinding;", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPromoSelectionViewHolder extends ViewBindingRecyclerViewHolder<VoucherCashierModel, ItemCashierPromoSelectionBinding> {
    private final Function1<VoucherCashierModel, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<VoucherCashierModel, Unit> getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String str;
        String str2;
        Comparable valueOf;
        int i;
        String format;
        final VoucherCashierModel voucherCashierModel = (VoucherCashierModel) obj;
        ItemCashierPromoSelectionBinding binding = getBinding();
        if (voucherCashierModel != null) {
            binding.getErrorConfigVersion.setText(voucherCashierModel.scheduleImpl);
            AppCompatTextView appCompatTextView = binding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(appCompatTextView, voucherCashierModel.getNetworkUserEntityData$$ExternalSyntheticLambda1() ? R.style.f54122132017908 : R.style.f54132132017909);
            Long l = voucherCashierModel.initRecordTimeStamp;
            binding.GetContactSyncConfig.setText(DateTimeUtil.MyBillsEntityDataFactory(new Date(l != null ? l.longValue() : 0L), "d MMM yyyy", LocaleUtil.getAuthRequestContext()));
            MoneyViewModel moneyViewModel = voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (moneyViewModel != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(id.dana.core.ui.util.LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb.append(format);
                str = sb.toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            CurrencyAmountModel BuiltInFictitiousFunctionClassFactory = VoucherCashierModel.BuiltInFictitiousFunctionClassFactory(voucherCashierModel, null, false, null, 7);
            String authRequestContext = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() : null;
            if (authRequestContext == null) {
                authRequestContext = "";
            }
            AppCompatTextView appCompatTextView2 = getBinding().scheduleImpl;
            if (voucherCashierModel.getNetworkUserEntityData$$ExternalSyntheticLambda1() || Intrinsics.areEqual(voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0, Boolean.TRUE)) {
                str2 = authRequestContext;
            } else {
                str2 = str;
            }
            appCompatTextView2.setText(str2);
            if (!Intrinsics.areEqual(voucherCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda0, Boolean.TRUE)) {
                valueOf = Integer.valueOf((int) R.drawable.ic_cashier_voucher);
            } else {
                valueOf = voucherCashierModel.GetContactSyncConfig;
            }
            AppCompatImageView appCompatImageView = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            Glide.getAuthRequestContext(this.itemView).getAuthRequestContext(valueOf).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_cashier_promo).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            AppCompatImageView appCompatImageView2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            AppCompatImageView appCompatImageView3 = appCompatImageView2;
            if (voucherCashierModel.getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
                ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView3);
            } else {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView3);
            }
            if (voucherCashierModel.getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
                i = voucherCashierModel.getDatabaseTableConfigUtil() ? R.drawable.ic_check_orange_filled_circle : R.drawable.ic_outline_circle_grey_20;
            } else {
                i = R.drawable.ic_circle_grey;
            }
            Integer valueOf2 = Integer.valueOf(i);
            AppCompatImageView appCompatImageView4 = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView4, "");
            Glide.getAuthRequestContext(this.itemView).getAuthRequestContext((Object) valueOf2).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_cashier_promo).MyBillsEntityDataFactory((ImageView) appCompatImageView4);
            getBinding().getAuthRequestContext.setBackground(ContextCompat.PlaceComponentResult(getContext(), (voucherCashierModel.getDatabaseTableConfigUtil() && voucherCashierModel.getNetworkUserEntityData$$ExternalSyntheticLambda1()) ? R.drawable.bg_rounded_8dp_yellow50 : R.drawable.bg_rounded_8dp_border_grey30));
            binding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.viewholder.CashierPromoSelectionViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierPromoSelectionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(VoucherCashierModel.this, this);
                }
            });
            String str3 = voucherCashierModel.newProxyInstance;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            AppCompatTextView appCompatTextView3 = binding.lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
            appCompatTextView3.setVisibility(0);
            appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.viewholder.CashierPromoSelectionViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierPromoSelectionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(CashierPromoSelectionViewHolder.this, voucherCashierModel);
                }
            });
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierPromoSelectionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierPromoSelectionBinding BuiltInFictitiousFunctionClassFactory = ItemCashierPromoSelectionBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CashierPromoSelectionViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function1<? super id.dana.cashier.model.VoucherCashierModel, kotlin.Unit> r4, kotlin.jvm.functions.Function1<? super id.dana.cashier.model.VoucherCashierModel, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559072(0x7f0d02a0, float:1.8743478E38)
            r2.<init>(r1, r0, r3)
            r2.getAuthRequestContext = r4
            r2.BuiltInFictitiousFunctionClassFactory = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.CashierPromoSelectionViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(VoucherCashierModel voucherCashierModel, CashierPromoSelectionViewHolder cashierPromoSelectionViewHolder) {
        Intrinsics.checkNotNullParameter(voucherCashierModel, "");
        Intrinsics.checkNotNullParameter(cashierPromoSelectionViewHolder, "");
        if (voucherCashierModel.getNetworkUserEntityData$$ExternalSyntheticLambda1()) {
            cashierPromoSelectionViewHolder.getAuthRequestContext.invoke(voucherCashierModel);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierPromoSelectionViewHolder cashierPromoSelectionViewHolder, VoucherCashierModel voucherCashierModel) {
        Intrinsics.checkNotNullParameter(cashierPromoSelectionViewHolder, "");
        Intrinsics.checkNotNullParameter(voucherCashierModel, "");
        cashierPromoSelectionViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(voucherCashierModel);
    }
}
