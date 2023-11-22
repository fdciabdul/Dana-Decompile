package id.dana.richview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.core.ui.glide.GlideApp;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.utils.ImageResize;
import java.security.MessageDigest;

/* loaded from: classes9.dex */
public class SimpleBannerView extends BaseSimpleView {
    private Activity BuiltInFictitiousFunctionClassFactory;
    private String MyBillsEntityDataFactory;
    @BindView(R.id.imagePromotion)
    ImageView imagePromotion;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_simple_promotion;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return null;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        GlideApp.getAuthRequestContext(m_()).PlaceComponentResult(this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new BitmapTransformation() { // from class: id.dana.richview.SimpleBannerView.1
            @Override // com.bumptech.glide.load.Key
            public final void getAuthRequestContext(MessageDigest messageDigest) {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
            public final Bitmap getAuthRequestContext(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
                return ImageResize.getAuthRequestContext(bitmap, ImageResize.PlaceComponentResult(SimpleBannerView.this.BuiltInFictitiousFunctionClassFactory, 80));
            }
        }).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) RequestOptions.getAuthRequestContext(new RoundedCornersTransformation(8, 6))).MyBillsEntityDataFactory(this.imagePromotion);
    }
}
