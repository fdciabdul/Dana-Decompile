package id.dana.animation.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
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

/* loaded from: classes8.dex */
public class SimplePromotionView extends BaseSimpleView {
    private CdpContentModel BuiltInFictitiousFunctionClassFactory;
    private SkeletonScreen DatabaseTableConfigUtil;
    private String GetContactSyncConfig;
    private MultiTransformation<Bitmap> MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private MultiTransformation<Bitmap> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String getAuthRequestContext;
    private final boolean getErrorConfigVersion;
    private final boolean initRecordTimeStamp;
    private final RequestListener<Bitmap> lookAheadTest = new RequestListener<Bitmap>() { // from class: id.dana.home.banner.SimplePromotionView.1
        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public /* synthetic */ boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
            return PlaceComponentResult(bitmap, dataSource);
        }

        private boolean PlaceComponentResult(Bitmap bitmap, DataSource dataSource) {
            if (SimplePromotionView.this.DatabaseTableConfigUtil != null) {
                SimplePromotionView.this.DatabaseTableConfigUtil.PlaceComponentResult();
            }
            SimplePromotionView.this.shimmerView.setVisibility(8);
            if (DataSource.REMOTE == dataSource) {
                Context context = SimplePromotionView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    context = null;
                }
                BannerUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, bitmap, SimplePromotionView.this.BuiltInFictitiousFunctionClassFactory, SimplePromotionView.this.GetContactSyncConfig);
                return false;
            }
            return false;
        }
    };
    private int moveToNextValue;
    @BindView(R.id.promotion_image)
    ImageView promotionImage;
    @BindView(R.id.shimmer_view)
    ImageView shimmerView;

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public SimplePromotionView(CdpContentModel cdpContentModel, boolean z, boolean z2, int i, int i2, String str) {
        this.GetContactSyncConfig = "";
        this.BuiltInFictitiousFunctionClassFactory = cdpContentModel;
        this.getErrorConfigVersion = z;
        this.initRecordTimeStamp = z2;
        this.moveToNextValue = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i2;
        this.GetContactSyncConfig = str;
        this.getAuthRequestContext = cdpContentModel.GetContactSyncConfig;
    }

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0 ? R.layout.view_simple_promo : R.layout.view_simple_promo_murotal_aspect_ratio;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.moveToNextValue != -1) {
            this.shimmerView.getLayoutParams().height = this.moveToNextValue;
            this.promotionImage.getLayoutParams().height = this.moveToNextValue;
            this.shimmerView.requestLayout();
            this.promotionImage.requestLayout();
        }
        this.shimmerView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.promotionImage.setScaleType(ImageView.ScaleType.FIT_XY);
        if (this.DatabaseTableConfigUtil == null) {
            this.shimmerView.setVisibility(0);
            this.DatabaseTableConfigUtil = ShimmeringUtil.PlaceComponentResult(this.shimmerView, R.layout.view_banner_item_skeleton);
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
        this.MyBillsEntityDataFactory = new MultiTransformation<>(transformationArr);
        Transformation[] transformationArr2 = new Transformation[1];
        Context context3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context3 != null) {
            context2 = context3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        float dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.f28142131165293);
        transformationArr2[0] = new GranularRoundedCorners(dimensionPixelSize, dimensionPixelSize, 0.0f);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new MultiTransformation<>(transformationArr2);
        if (TextUtils.isEmpty(this.getAuthRequestContext)) {
            return;
        }
        String str = this.getAuthRequestContext;
        if (this.DatabaseTableConfigUtil != null) {
            this.shimmerView.setVisibility(0);
            this.DatabaseTableConfigUtil.MyBillsEntityDataFactory();
        } else {
            this.shimmerView.setVisibility(0);
            this.DatabaseTableConfigUtil = ShimmeringUtil.PlaceComponentResult(this.shimmerView, R.layout.view_banner_item_skeleton);
        }
        MixPanelTracker.getAuthRequestContext(TrackerKey.Event.PROMOTION_BANNER_DOWNLOAD_FINISH);
        RequestBuilder MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(m_()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).MyBillsEntityDataFactory(DiskCacheStrategy.KClassImpl$Data$declaredNonStaticMembers$2);
        if (this.getErrorConfigVersion) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory((Transformation<Bitmap>) this.MyBillsEntityDataFactory);
        } else if (this.initRecordTimeStamp) {
            MyBillsEntityDataFactory = MyBillsEntityDataFactory.MyBillsEntityDataFactory((Transformation<Bitmap>) this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest).MyBillsEntityDataFactory(this.promotionImage);
    }
}
