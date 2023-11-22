package id.dana.richview.promoclaim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPromoClaimComponent;
import id.dana.di.modules.PromoClaimModule;
import id.dana.richview.promoclaim.PromoClaimContract;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class PromoClaimView extends BaseRichView implements PromoClaimContract.View {
    private SkeletonScreen MyBillsEntityDataFactory;
    @BindView(R.id.cl_container_leaderboard_entry)
    ConstraintLayout clContainer;
    @BindView(R.id.iv_leaderboard_entry)
    ImageView imageView;
    @Inject
    PromoClaimContract.Presenter presenter;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_leadeboard_entry;
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    public PromoClaimView(Context context) {
        super(context);
    }

    public PromoClaimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PromoClaimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PromoClaimView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        DaggerPromoClaimComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPromoClaimComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (PromoClaimModule) Preconditions.getAuthRequestContext(new PromoClaimModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, PromoClaimModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerPromoClaimComponent.PromoClaimComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.clContainer);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_leaderboard_entry_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.MyBillsEntityDataFactory = viewSkeletonScreen;
            return;
        }
        skeletonScreen.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.presenter.PlaceComponentResult();
    }

    @Override // id.dana.richview.promoclaim.PromoClaimContract.View
    public void onLoadBanner(String str) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).BuiltInFictitiousFunctionClassFactory(new RequestListener<Drawable>() { // from class: id.dana.richview.promoclaim.PromoClaimView.1
            @Override // com.bumptech.glide.request.RequestListener
            public /* bridge */ /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                PromoClaimView.this.enableBanner(false);
                return false;
            }
        }).MyBillsEntityDataFactory(this.imageView);
    }

    @Override // id.dana.richview.promoclaim.PromoClaimContract.View
    public void enableBanner(boolean z) {
        this.clContainer.setVisibility(z ? 0 : 8);
        if (z) {
            return;
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.cl_container_leaderboard_entry})
    public void onClick() {
        this.presenter.MyBillsEntityDataFactory();
    }
}
