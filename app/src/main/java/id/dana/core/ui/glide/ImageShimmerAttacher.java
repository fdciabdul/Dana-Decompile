package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.core.ui.R;
import id.dana.core.ui.glide.BaseImageAttacher;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class ImageShimmerAttacher extends ShimmerAttacher<Drawable> {
    public ImageShimmerAttacher(String str, int i, BaseImageAttacher.AdditionalData additionalData) {
        super(str, i, additionalData);
    }

    @Override // id.dana.core.ui.glide.ShimmerAttacher
    protected final void PlaceComponentResult(Context context, final ImageView imageView) {
        Executor executor;
        GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(context).PlaceComponentResult(MyBillsEntityDataFactory()).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(R.drawable.square_rounded_skeleton).PlaceComponentResult(PlaceComponentResult());
        if (KClassImpl$Data$declaredNonStaticMembers$2() != null) {
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2());
        }
        CustomTarget<Drawable> customTarget = new CustomTarget<Drawable>() { // from class: id.dana.core.ui.glide.ImageShimmerAttacher.1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }

            {
                ImageShimmerAttacher.this = this;
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                imageView.setImageDrawable((Drawable) obj);
                imageView.buildDrawingCache();
                SkeletonScreen skeletonScreen = ((ShimmerAttacher) ImageShimmerAttacher.this).PlaceComponentResult;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
            }
        };
        executor = Executors.PlaceComponentResult;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(customTarget, null, PlaceComponentResult, executor);
    }
}
