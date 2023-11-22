package id.dana.nearbyme.merchantreview.viewholder;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.svg.SvgLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewPhotosViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Landroid/net/Uri;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "getAuthRequestContext", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewPhotosViewHolder extends BaseRecyclerViewHolder<Uri> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Uri uri) {
        Uri uri2 = uri;
        if (uri2 != null) {
            byte b = 0;
            if (SvgLoader.getAuthRequestContext(uri2.getPath())) {
                SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = uri2.getPath();
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ImageView) this.itemView.findViewById(R.id.f3432checkReadInterstitialBanner$lambda3$lambda2);
                new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                return;
            }
            GlideRequest<Drawable> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory(uri2).getErrorConfigVersion((int) R.drawable.square_rounded_skeleton).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.getAuthRequestContext(new CenterCrop(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 1, RoundedCornersTransformation.CornerType.ALL));
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) requestOptions).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.f3432checkReadInterstitialBanner$lambda3$lambda2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewPhotosViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_photo_rating, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = viewGroup;
    }
}
