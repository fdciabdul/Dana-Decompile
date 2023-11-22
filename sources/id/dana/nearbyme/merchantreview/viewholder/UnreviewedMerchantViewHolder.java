package id.dana.nearbyme.merchantreview.viewholder;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.component.utils.SizeUtil;
import id.dana.databinding.ItemPendingMerchantReviewBinding;
import id.dana.mybills.ui.customview.BodySinglePayView;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.DateTimeUtil;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/UnreviewedMerchantViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "Lid/dana/databinding/ItemPendingMerchantReviewBinding;", "Lkotlin/Function2;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function2;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnreviewedMerchantViewHolder extends ViewBindingRecyclerViewHolder<MerchantConsultReviewViewHolderModel, ItemPendingMerchantReviewBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function2<MerchantConsultReviewModel, Integer, Unit> MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        ShopModel shopModel;
        Locale locale;
        final MerchantConsultReviewViewHolderModel merchantConsultReviewViewHolderModel = (MerchantConsultReviewViewHolderModel) obj;
        if (merchantConsultReviewViewHolderModel != null) {
            MerchantConsultReviewModel merchantConsultReviewModel = merchantConsultReviewViewHolderModel.PlaceComponentResult;
            if (merchantConsultReviewModel != null && (shopModel = merchantConsultReviewModel.MyBillsEntityDataFactory) != null) {
                TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory;
                String str = shopModel.newProxyInstance;
                if (str == null) {
                    str = "";
                }
                textView.setText(str);
                getBinding().PlaceComponentResult.setStarSelected(merchantConsultReviewViewHolderModel.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
                String str2 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (str2 == null) {
                    str2 = "";
                }
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(str2).BuiltInFictitiousFunctionClassFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory(R.drawable.ic_merchant_logo_placeholder).BuiltInFictitiousFunctionClassFactory(R.drawable.ic_merchant_logo_placeholder).MyBillsEntityDataFactory((Transformation<Bitmap>) new RoundedCorners(SizeUtil.PlaceComponentResult(4))).MyBillsEntityDataFactory(getBinding().MyBillsEntityDataFactory);
                Long l = shopModel.VerifyPinStateManager$executeRiskChallenge$2$2;
                TextView textView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(l, "");
                Date date = new Date(l.longValue());
                locale = Locale.getDefault();
                textView2.setText(DateTimeUtil.MyBillsEntityDataFactory(date, BodySinglePayView.DATE_FORMAT_DD_MMMM_YYYY, locale));
                getBinding().PlaceComponentResult.setOnStarClickListener(new ViewRatingStarBar.ClickListener() { // from class: id.dana.nearbyme.merchantreview.viewholder.UnreviewedMerchantViewHolder$bindData$1$3
                    @Override // id.dana.nearbyme.merchantreview.ViewRatingStarBar.ClickListener
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                        Function2 function2;
                        function2 = UnreviewedMerchantViewHolder.this.MyBillsEntityDataFactory;
                        MerchantConsultReviewModel merchantConsultReviewModel2 = merchantConsultReviewViewHolderModel.PlaceComponentResult;
                        merchantConsultReviewModel2.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                        function2.invoke(merchantConsultReviewModel2, Integer.valueOf(UnreviewedMerchantViewHolder.this.getAbsoluteAdapterPosition()));
                    }
                });
            }
            View view = getBinding().getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(merchantConsultReviewViewHolderModel.MyBillsEntityDataFactory == 3 ? 8 : 0);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemPendingMerchantReviewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemPendingMerchantReviewBinding MyBillsEntityDataFactory = ItemPendingMerchantReviewBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UnreviewedMerchantViewHolder(android.view.ViewGroup r3, kotlin.jvm.functions.Function2<? super id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel, ? super java.lang.Integer, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559215(0x7f0d032f, float:1.8743768E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.viewholder.UnreviewedMerchantViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function2):void");
    }
}
