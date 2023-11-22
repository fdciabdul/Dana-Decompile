package id.dana.nearbyme.merchantdetail.mediaviewer;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoGalleryViewHolder extends BaseRecyclerViewHolder<MerchantImageModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantImageModel merchantImageModel) {
        Context context;
        MerchantImageModel merchantImageModel2 = merchantImageModel;
        if (merchantImageModel2 == null || (context = getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "");
        GlideRequest<Drawable> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(context).PlaceComponentResult(merchantImageModel2.BuiltInFictitiousFunctionClassFactory).PlaceComponentResult((int) R.drawable.image_broken).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.getAuthRequestContext(new CenterCrop(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 1, RoundedCornersTransformation.CornerType.ALL));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) requestOptions).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_photo_gallery));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoGalleryViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_photo_gallery, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
