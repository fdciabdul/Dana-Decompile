package id.dana.cashier.topupandpay.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.databinding.ItemTopUpAndPayAgentBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/topupandpay/viewholder/TopUpAndPayAgentViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemTopUpAndPayAgentBinding;", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayAgentViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemTopUpAndPayAgentBinding> {
    private final Function1<CashierPayMethodModel, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        final CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        if (cashierPayMethodModel != null) {
            View view = this.itemView;
            getBinding().PlaceComponentResult.removeAllViews();
            int authRequestContext = cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda2().size() > 1 ? SizeUtil.getAuthRequestContext(12) : SizeUtil.getAuthRequestContext(24);
            for (String str : cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
                AppCompatImageView appCompatImageView = new AppCompatImageView(view.getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, authRequestContext);
                layoutParams.setMargins(0, 0, SizeUtil.getAuthRequestContext(8), 0);
                appCompatImageView.setLayoutParams(layoutParams);
                AppCompatImageView appCompatImageView2 = appCompatImageView;
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(view.getContext()).getAuthRequestContext(str).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
                LinearLayout linearLayout = getBinding().PlaceComponentResult;
                if (linearLayout != null) {
                    linearLayout.addView(appCompatImageView);
                }
                boolean authRequestContext2 = cashierPayMethodModel.getAuthRequestContext();
                view.setClickable(authRequestContext2);
                view.setEnabled(authRequestContext2);
                if (!authRequestContext2) {
                    getBinding().PlaceComponentResult.setBackground(ContextCompat.PlaceComponentResult(view.getContext(), (int) R.color.f23942131099989));
                }
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView2, !cashierPayMethodModel.getAuthRequestContext());
            }
            getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.topupandpay.viewholder.TopUpAndPayAgentViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TopUpAndPayAgentViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayAgentViewHolder.this, cashierPayMethodModel);
                }
            });
            getBinding().PlaceComponentResult.setContentDescription(view.getContext().getString(R.string.btn_topup_source, cashierPayMethodModel.lookAheadTest()));
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemTopUpAndPayAgentBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemTopUpAndPayAgentBinding MyBillsEntityDataFactory = ItemTopUpAndPayAgentBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TopUpAndPayAgentViewHolder(kotlin.jvm.functions.Function1<? super id.dana.cashier.model.CashierPayMethodModel, kotlin.Unit> r3, android.view.ViewGroup r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559282(0x7f0d0372, float:1.8743904E38)
            r2.<init>(r1, r0, r4)
            r2.BuiltInFictitiousFunctionClassFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.topupandpay.viewholder.TopUpAndPayAgentViewHolder.<init>(kotlin.jvm.functions.Function1, android.view.ViewGroup):void");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TopUpAndPayAgentViewHolder topUpAndPayAgentViewHolder, CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(topUpAndPayAgentViewHolder, "");
        topUpAndPayAgentViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(cashierPayMethodModel);
    }
}
