package id.dana.promocenter.viewholders;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.promocenter.model.PromoModel;
import id.dana.utils.ImageResize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/promocenter/viewholders/PromoSpecialAdsViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "Landroid/content/Context;", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PromoSpecialAdsViewHolder extends BaseRecyclerViewHolder<PromoModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(PromoModel promoModel) {
        PromoModel promoModel2 = promoModel;
        if (promoModel2 != null) {
            String str = promoModel2.getErrorConfigVersion;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte b = 0;
            if (SvgLoader.getAuthRequestContext(str)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(str, "");
                SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(context);
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_no_image;
                KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CenterCrop();
                if (context == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                }
                KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) context, 8), 0, RoundedCornersTransformation.CornerType.ALL);
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ImageView) this.itemView.findViewById(R.id.iv_promo_merchant_special);
                new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                return;
            }
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (context2 != null) {
                GlideApp.getAuthRequestContext(context2).PlaceComponentResult(str).PlaceComponentResult(new CenterCrop(), new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) context2, 8), 0, RoundedCornersTransformation.CornerType.ALL)).getErrorConfigVersion((int) R.drawable.bg_rounded_8dp_grey30).PlaceComponentResult((int) R.drawable.ic_no_image).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_promo_merchant_special));
            }
        }
    }

    public PromoSpecialAdsViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.view_promo_merchant_special, viewGroup);
    }
}
