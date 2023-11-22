package id.dana.explore.adapter.viewholder;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.explore.model.ExplorePromoWrapper;
import id.dana.utils.ImageResize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/adapter/viewholder/ExplorePromoViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExplorePromoWrapper;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExplorePromoViewHolder extends BaseRecyclerViewHolder<ExplorePromoWrapper> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ExplorePromoWrapper explorePromoWrapper) {
        ExplorePromoWrapper explorePromoWrapper2 = explorePromoWrapper;
        if (explorePromoWrapper2 != null) {
            String str = explorePromoWrapper2.MyBillsEntityDataFactory.getErrorConfigVersion;
            String str2 = str;
            byte b = 0;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            if (SvgLoader.getAuthRequestContext(str)) {
                Intrinsics.checkNotNullExpressionValue(str, "");
                Context context = getContext();
                if (context != null) {
                    SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(context);
                    KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.bg_rounded_8dp_grey30;
                    KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new CenterCrop();
                    KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) context, 8), 0, RoundedCornersTransformation.CornerType.ALL);
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ImageView) this.itemView.findViewById(R.id.iv_explore_promo);
                    new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullExpressionValue(str, "");
            Context context2 = getContext();
            if (context2 != null) {
                GlideApp.getAuthRequestContext(context2).PlaceComponentResult(str).PlaceComponentResult(new CenterCrop(), new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) context2, 8), 0, RoundedCornersTransformation.CornerType.ALL)).getErrorConfigVersion((int) R.drawable.bg_rounded_8dp_grey30).PlaceComponentResult((int) R.drawable.bg_rounded_8dp_grey30).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_explore_promo));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExplorePromoViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_explore_promo, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
