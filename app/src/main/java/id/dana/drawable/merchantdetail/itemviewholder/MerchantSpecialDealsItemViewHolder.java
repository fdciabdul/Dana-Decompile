package id.dana.drawable.merchantdetail.itemviewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.model.NearbySpecialDealsItemWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/itemviewholder/MerchantSpecialDealsItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSpecialDealsItemViewHolder extends BaseRecyclerViewHolder<NearbySpecialDealsItemWrapper> {
    private Function1<? super MerchantProductInfoModel, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(NearbySpecialDealsItemWrapper nearbySpecialDealsItemWrapper) {
        final MerchantProductInfoModel merchantProductInfoModel;
        NearbySpecialDealsItemWrapper nearbySpecialDealsItemWrapper2 = nearbySpecialDealsItemWrapper;
        super.bindData(nearbySpecialDealsItemWrapper2);
        if (nearbySpecialDealsItemWrapper2 == null || (merchantProductInfoModel = nearbySpecialDealsItemWrapper2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        String str = merchantProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion;
        if (SvgLoader.getAuthRequestContext(str)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (AppCompatImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter);
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        } else {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.SendMoneyHomePresenter)));
        }
        ((AppCompatTextView) this.itemView.findViewById(R.id.tv_voucher_value)).setText(merchantProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext.getAuthRequestContext());
        ((AppCompatTextView) this.itemView.findViewById(R.id.DoubleExponentialHistogramBuckets)).setText(merchantProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1.lookAheadTest);
        ((AppCompatTextView) this.itemView.findViewById(R.id.tv_voucher_price)).setText(merchantProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_voucher_old_price);
        MoneyViewModel moneyViewModel = merchantProductInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory;
        appCompatTextView.setText(moneyViewModel != null ? moneyViewModel.getAuthRequestContext() : null);
        ((AppCompatTextView) this.itemView.findViewById(R.id.tv_voucher_old_price)).setPaintFlags(((AppCompatTextView) this.itemView.findViewById(R.id.tv_voucher_old_price)).getPaintFlags() | 16);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.itemviewholder.MerchantSpecialDealsItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantSpecialDealsItemViewHolder.BuiltInFictitiousFunctionClassFactory(MerchantSpecialDealsItemViewHolder.this, merchantProductInfoModel);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantSpecialDealsItemViewHolder(ViewGroup viewGroup, Function1<? super MerchantProductInfoModel, Unit> function1) {
        super(viewGroup.getContext(), R.layout.deals_item_view_holder_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantSpecialDealsItemViewHolder merchantSpecialDealsItemViewHolder, MerchantProductInfoModel merchantProductInfoModel) {
        Intrinsics.checkNotNullParameter(merchantSpecialDealsItemViewHolder, "");
        Intrinsics.checkNotNullParameter(merchantProductInfoModel, "");
        merchantSpecialDealsItemViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(merchantProductInfoModel);
    }
}
