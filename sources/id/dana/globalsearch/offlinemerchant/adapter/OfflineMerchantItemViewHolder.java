package id.dana.globalsearch.offlinemerchant.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.ContextExtKt;
import id.dana.globalsearch.mapper.ConvertMapToPojoKt;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.offlinemerchant.model.OfflineOnlineMerchantInfoModel;
import id.dana.richview.imageview.ImageWithHorizontalDescriptionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalsearch/offlinemerchant/adapter/OfflineMerchantItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OfflineMerchantItemViewHolder extends BaseRecyclerViewHolder<PaySearchInfoModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PaySearchInfoModel paySearchInfoModel) {
        ImageWithHorizontalDescriptionView imageWithHorizontalDescriptionView;
        PaySearchInfoModel paySearchInfoModel2 = paySearchInfoModel;
        if (paySearchInfoModel2 == null || (imageWithHorizontalDescriptionView = (ImageWithHorizontalDescriptionView) this.itemView.findViewById(R.id.res_0x7f0a0c78_callerimpl_method_jvmstaticinobject)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(imageWithHorizontalDescriptionView, "");
        String MyBillsEntityDataFactory = paySearchInfoModel2.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = "";
        }
        imageWithHorizontalDescriptionView.showImage(MyBillsEntityDataFactory, R.drawable.ic_merchant_logo_placeholder);
        imageWithHorizontalDescriptionView.setTitleText(paySearchInfoModel2.GetContactSyncConfig);
        OfflineOnlineMerchantInfoModel offlineOnlineMerchantInfoModel = (OfflineOnlineMerchantInfoModel) ConvertMapToPojoKt.KClassImpl$Data$declaredNonStaticMembers$2(paySearchInfoModel2.getErrorConfigVersion, OfflineOnlineMerchantInfoModel.class);
        if (offlineOnlineMerchantInfoModel.getBuiltInFictitiousFunctionClassFactory()) {
            Context context = imageWithHorizontalDescriptionView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            Drawable PlaceComponentResult = ContextExtKt.PlaceComponentResult(context, (int) R.drawable.ic_verify_blue);
            Intrinsics.checkNotNull(PlaceComponentResult);
            imageWithHorizontalDescriptionView.setTitleBadge(PlaceComponentResult);
        } else if (offlineOnlineMerchantInfoModel.getGetAuthRequestContext()) {
            Context context2 = imageWithHorizontalDescriptionView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            Drawable PlaceComponentResult2 = ContextExtKt.PlaceComponentResult(context2, (int) R.drawable.ic_dana_bisnis_blue);
            Intrinsics.checkNotNull(PlaceComponentResult2);
            imageWithHorizontalDescriptionView.setTitleBadgeWithVector(PlaceComponentResult2);
        } else {
            imageWithHorizontalDescriptionView.setFirstLineBadgeGone();
        }
        imageWithHorizontalDescriptionView.setBottomLineFirstText(paySearchInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda2);
        imageWithHorizontalDescriptionView.setDistanceText(paySearchInfoModel2.MyBillsEntityDataFactory);
        String string = imageWithHorizontalDescriptionView.getContext().getString(R.string.btnShop);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = imageWithHorizontalDescriptionView.getContext().getString(R.string.lblShopName);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        ImageWithHorizontalDescriptionView.setItemContentDescription$default(imageWithHorizontalDescriptionView, string, string2, null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineMerchantItemViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_search_result, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
