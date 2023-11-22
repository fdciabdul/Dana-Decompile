package id.dana.core.ui.glide;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.core.ui.R;
import id.dana.core.ui.glide.BaseImageAttacher;
import id.dana.core.ui.util.ShimmeringUtil;

/* loaded from: classes4.dex */
public abstract class ShimmerAttacher<T> extends UrlImageAttacher {
    private final RequestListener<T> BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    SkeletonScreen PlaceComponentResult;

    abstract void PlaceComponentResult(Context context, ImageView imageView);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShimmerAttacher(String str) {
        this(str, (byte) 0);
    }

    private ShimmerAttacher(String str, byte b) {
        super(str, null);
        this.BuiltInFictitiousFunctionClassFactory = new RequestListener<T>() { // from class: id.dana.core.ui.glide.ShimmerAttacher.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<T> target, boolean z) {
                SkeletonScreen skeletonScreen = ShimmerAttacher.this.PlaceComponentResult;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                    return false;
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(T t, Object obj, Target<T> target, DataSource dataSource, boolean z) {
                SkeletonScreen skeletonScreen;
                if (z && dataSource.equals(DataSource.MEMORY_CACHE) && (skeletonScreen = ShimmerAttacher.this.PlaceComponentResult) != null) {
                    skeletonScreen.PlaceComponentResult();
                    return false;
                }
                return false;
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShimmerAttacher(String str, int i, BaseImageAttacher.AdditionalData additionalData) {
        super(str, additionalData);
        this.BuiltInFictitiousFunctionClassFactory = new RequestListener<T>() { // from class: id.dana.core.ui.glide.ShimmerAttacher.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<T> target, boolean z) {
                SkeletonScreen skeletonScreen = ShimmerAttacher.this.PlaceComponentResult;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                    return false;
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(T t, Object obj, Target<T> target, DataSource dataSource, boolean z) {
                SkeletonScreen skeletonScreen;
                if (z && dataSource.equals(DataSource.MEMORY_CACHE) && (skeletonScreen = ShimmerAttacher.this.PlaceComponentResult) != null) {
                    skeletonScreen.PlaceComponentResult();
                    return false;
                }
                return false;
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RequestListener<T> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.glide.ImageAttacherStrategy
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ImageView imageView) {
        ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i <= 0) {
            i = R.layout.view_image_skeleton;
        }
        this.PlaceComponentResult = ShimmeringUtil.getAuthRequestContext(imageView, i);
        PlaceComponentResult(context, imageView);
    }
}
