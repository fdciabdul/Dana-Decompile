package id.dana.cashier.topupandpay.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.databinding.ItemTopUpAndPayBankTransferBinding;
import id.dana.extension.view.ViewExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/topupandpay/viewholder/TopUpAndPayBankTransferViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemTopUpAndPayBankTransferBinding;", "Lkotlin/Function1;", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayBankTransferViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemTopUpAndPayBankTransferBinding> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<CashierPayMethodModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        final CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        if (cashierPayMethodModel != null) {
            View view = this.itemView;
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(view.getContext()).getAuthRequestContext(cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda1()).getAuthRequestContext(new RequestListener<Drawable>() { // from class: id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankTransferViewHolder$bindData$1$1$1
                @Override // com.bumptech.glide.request.RequestListener
                public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj2, Target<Drawable> target, DataSource dataSource, boolean z) {
                    return BuiltInFictitiousFunctionClassFactory();
                }

                @Override // com.bumptech.glide.request.RequestListener
                public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
                    AppCompatTextView appCompatTextView = TopUpAndPayBankTransferViewHolder.this.getBinding().getAuthRequestContext;
                    appCompatTextView.setText(cashierPayMethodModel.getMyBillsEntityDataFactory());
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(0);
                    return false;
                }

                private boolean BuiltInFictitiousFunctionClassFactory() {
                    AppCompatTextView appCompatTextView = TopUpAndPayBankTransferViewHolder.this.getBinding().getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(8);
                    return false;
                }
            }).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) getBinding().MyBillsEntityDataFactory);
            boolean authRequestContext = cashierPayMethodModel.getAuthRequestContext();
            view.setClickable(authRequestContext);
            view.setEnabled(authRequestContext);
            if (!authRequestContext) {
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ContextCompat.PlaceComponentResult(view.getContext(), (int) R.color.f23942131099989));
            }
            AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView, !cashierPayMethodModel.getAuthRequestContext());
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(view.getContext().getString(R.string.btn_topup_source, cashierPayMethodModel.lookAheadTest()));
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankTransferViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TopUpAndPayBankTransferViewHolder.getAuthRequestContext(TopUpAndPayBankTransferViewHolder.this, cashierPayMethodModel);
                }
            });
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemTopUpAndPayBankTransferBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemTopUpAndPayBankTransferBinding MyBillsEntityDataFactory = ItemTopUpAndPayBankTransferBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TopUpAndPayBankTransferViewHolder(kotlin.jvm.functions.Function1<? super id.dana.cashier.model.CashierPayMethodModel, kotlin.Unit> r3, android.view.ViewGroup r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559284(0x7f0d0374, float:1.8743908E38)
            r2.<init>(r1, r0, r4)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.topupandpay.viewholder.TopUpAndPayBankTransferViewHolder.<init>(kotlin.jvm.functions.Function1, android.view.ViewGroup):void");
    }

    public static /* synthetic */ void getAuthRequestContext(TopUpAndPayBankTransferViewHolder topUpAndPayBankTransferViewHolder, CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(topUpAndPayBankTransferViewHolder, "");
        topUpAndPayBankTransferViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke(cashierPayMethodModel);
    }
}
