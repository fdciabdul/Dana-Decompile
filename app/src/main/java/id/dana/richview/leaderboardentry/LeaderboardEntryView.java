package id.dana.richview.leaderboardentry;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.OnClick;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerLeaderboardEntryComponent;
import id.dana.di.component.LeaderboardEntryComponent;
import id.dana.di.modules.LeaderboardEntryModule;
import id.dana.model.CdpContentModel;
import id.dana.richview.leaderboardentry.LeaderboardEntryContract;
import id.dana.utils.ContextUtil;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class LeaderboardEntryView extends BaseRichView implements LeaderboardEntryContract.View {
    private SkeletonScreen MyBillsEntityDataFactory;
    private LeaderboardEntryComponent PlaceComponentResult;
    ConstraintLayout clContainerLeaderboardEntry;
    private String getAuthRequestContext;
    ImageView ivLeaderboardEntry;
    @Inject
    LeaderboardEntryContract.Presenter presenter;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_leadeboard_entry;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    public LeaderboardEntryView(Context context) {
        super(context);
    }

    public LeaderboardEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LeaderboardEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LeaderboardEntryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.PlaceComponentResult == null) {
            DaggerLeaderboardEntryComponent.Builder MyBillsEntityDataFactory = DaggerLeaderboardEntryComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            MyBillsEntityDataFactory.PlaceComponentResult = (LeaderboardEntryModule) Preconditions.getAuthRequestContext(new LeaderboardEntryModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, LeaderboardEntryModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.PlaceComponentResult = new DaggerLeaderboardEntryComponent.LeaderboardEntryComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.MyBillsEntityDataFactory, b);
        }
        this.PlaceComponentResult.MyBillsEntityDataFactory(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean z) {
        if (z) {
            this.presenter.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.ivLeaderboardEntry = (ImageView) findViewById(R.id.iv_leaderboard_entry);
        this.clContainerLeaderboardEntry = (ConstraintLayout) findViewById(R.id.cl_container_leaderboard_entry);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.ivLeaderboardEntry);
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

    @Override // id.dana.richview.leaderboardentry.LeaderboardEntryContract.View
    public void onGetLeaderBoardSuccess(CdpContentModel cdpContentModel) {
        if (cdpContentModel == null || !ContextUtil.BuiltInFictitiousFunctionClassFactory(getContext())) {
            return;
        }
        this.clContainerLeaderboardEntry.setVisibility(0);
        this.getAuthRequestContext = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.presenter.PlaceComponentResult();
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(cdpContentModel.GetContactSyncConfig).BuiltInFictitiousFunctionClassFactory(new RequestListener<Drawable>() { // from class: id.dana.richview.leaderboardentry.LeaderboardEntryView.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public /* bridge */ /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return false;
            }
        }).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory(this.ivLeaderboardEntry);
    }

    @Override // id.dana.richview.leaderboardentry.LeaderboardEntryContract.View
    public void onCheckLeaderBoardFeatureSuccess(boolean z) {
        if (z) {
            this.presenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @OnClick({R.id.iv_leaderboard_entry})
    public void onClickEntry() {
        DanaH5.startContainerFullUrl(this.getAuthRequestContext);
    }
}
