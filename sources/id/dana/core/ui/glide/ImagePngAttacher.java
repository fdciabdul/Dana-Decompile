package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.core.ui.glide.BaseImageAttacher;

/* loaded from: classes4.dex */
public class ImagePngAttacher extends UrlImageAttacher {
    public ImagePngAttacher(String str, BaseImageAttacher.AdditionalData additionalData) {
        super(str, additionalData);
    }

    @Override // id.dana.core.ui.glide.ImageAttacherStrategy
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ImageView imageView) {
        GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(context).PlaceComponentResult(MyBillsEntityDataFactory()).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(PlaceComponentResult()).PlaceComponentResult(PlaceComponentResult());
        if (getAuthRequestContext() != null) {
            PlaceComponentResult.MyBillsEntityDataFactory((BaseRequestOptions<?>) getAuthRequestContext());
        }
        PlaceComponentResult.MyBillsEntityDataFactory(imageView);
    }
}
