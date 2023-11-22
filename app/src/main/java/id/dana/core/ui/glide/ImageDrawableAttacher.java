package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.core.ui.glide.BaseImageAttacher;
import id.dana.core.ui.util.ContextUtil;

/* loaded from: classes4.dex */
public class ImageDrawableAttacher extends BaseImageAttacher {
    private final int BuiltInFictitiousFunctionClassFactory;

    public ImageDrawableAttacher(int i, BaseImageAttacher.AdditionalData additionalData) {
        super(additionalData);
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Override // id.dana.core.ui.glide.ImageAttacherStrategy
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ImageView imageView) {
        ContextUtil contextUtil = ContextUtil.INSTANCE;
        if (ContextUtil.getAuthRequestContext(context)) {
            GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(context).PlaceComponentResult(Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(PlaceComponentResult()).PlaceComponentResult(PlaceComponentResult());
            if (getAuthRequestContext() != null) {
                PlaceComponentResult.MyBillsEntityDataFactory((BaseRequestOptions<?>) getAuthRequestContext());
            }
            PlaceComponentResult.MyBillsEntityDataFactory(imageView);
        }
    }
}
