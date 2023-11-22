package id.dana.animation.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.core.ui.glide.GlideApp;
import id.dana.model.CdpContentModel;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.ShimmeringUtil;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class NewSimplePromotionView extends BaseSimpleView {
    private MultiTransformation<Bitmap> BuiltInFictitiousFunctionClassFactory;
    private final boolean GetContactSyncConfig;
    private String MyBillsEntityDataFactory;
    private final RequestListener<Bitmap> NetworkUserEntityData$$ExternalSyntheticLambda0 = new RequestListener<Bitmap>() { // from class: id.dana.home.banner.NewSimplePromotionView.1
        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public /* synthetic */ boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
            return PlaceComponentResult(bitmap, dataSource);
        }

        private boolean PlaceComponentResult(Bitmap bitmap, DataSource dataSource) {
            NewSimplePromotionView.this.shimmerView.setVisibility(8);
            NewSimplePromotionView.this.promotionImage.setVisibility(0);
            if (NewSimplePromotionView.this.lookAheadTest != null) {
                NewSimplePromotionView.this.lookAheadTest.PlaceComponentResult();
            }
            if (DataSource.REMOTE == dataSource) {
                Context context = NewSimplePromotionView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    context = null;
                }
                BannerUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, bitmap, NewSimplePromotionView.this.getAuthRequestContext, NewSimplePromotionView.this.initRecordTimeStamp);
            }
            return false;
        }
    };
    private MultiTransformation<Bitmap> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private CdpContentModel getAuthRequestContext;
    private final boolean getErrorConfigVersion;
    private String initRecordTimeStamp;
    private SkeletonScreen lookAheadTest;
    private View.OnTouchListener moveToNextValue;
    @BindView(R.id.promotion_image)
    ImageView promotionImage;
    @BindView(R.id.shimmer_view)
    ImageView shimmerView;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_simple_promo_murotal_aspect_ratio;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NewSimplePromotionView(View.OnTouchListener onTouchListener, CdpContentModel cdpContentModel, boolean z, boolean z2, String str) {
        this.initRecordTimeStamp = "";
        this.getAuthRequestContext = cdpContentModel;
        this.getErrorConfigVersion = z;
        this.moveToNextValue = onTouchListener;
        this.GetContactSyncConfig = z2;
        this.initRecordTimeStamp = str;
        this.MyBillsEntityDataFactory = cdpContentModel.GetContactSyncConfig;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.shimmerView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.promotionImage.setScaleType(ImageView.ScaleType.FIT_XY);
        if (this.lookAheadTest == null) {
            this.shimmerView.setVisibility(0);
            this.promotionImage.setVisibility(8);
            this.lookAheadTest = ShimmeringUtil.PlaceComponentResult(this.shimmerView, R.layout.view_banner_item_skeleton);
        }
        Transformation[] transformationArr = new Transformation[2];
        transformationArr[0] = new CenterCrop();
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        transformationArr[1] = new RoundedCorners(context.getResources().getDimensionPixelSize(R.dimen.f28142131165293));
        this.BuiltInFictitiousFunctionClassFactory = new MultiTransformation<>(transformationArr);
        Transformation[] transformationArr2 = new Transformation[1];
        Context context3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context3 != null) {
            context2 = context3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        float dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.f28152131165294);
        transformationArr2[0] = new GranularRoundedCorners(dimensionPixelSize, dimensionPixelSize, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new MultiTransformation<>(transformationArr2);
        if (!TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
            String str = this.MyBillsEntityDataFactory;
            if (this.lookAheadTest != null) {
                this.shimmerView.setVisibility(0);
                this.promotionImage.setVisibility(8);
                this.lookAheadTest.MyBillsEntityDataFactory();
            } else {
                this.shimmerView.setVisibility(0);
                this.promotionImage.setVisibility(8);
                this.lookAheadTest = ShimmeringUtil.PlaceComponentResult(this.shimmerView, R.layout.view_banner_item_skeleton);
            }
            MixPanelTracker.getAuthRequestContext(TrackerKey.Event.PROMOTION_BANNER_DOWNLOAD_FINISH);
            RequestBuilder MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(m_()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).MyBillsEntityDataFactory(DiskCacheStrategy.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.getErrorConfigVersion) {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory((Transformation<Bitmap>) this.BuiltInFictitiousFunctionClassFactory);
            } else if (this.GetContactSyncConfig) {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory((Transformation<Bitmap>) this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(this.promotionImage);
        }
        m_().setOnTouchListener(this.moveToNextValue);
    }
}
