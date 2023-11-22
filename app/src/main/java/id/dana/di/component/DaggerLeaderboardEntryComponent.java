package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.di.modules.LeaderboardEntryModule;
import id.dana.di.modules.LeaderboardEntryModule_ProvidePresenterFactory;
import id.dana.di.modules.LeaderboardEntryModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckLeaderboardEntryFeature;
import id.dana.domain.promotion.interactor.GetLeaderboardEntryBanner;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.mapper.LeaderboardMapper;
import id.dana.richview.leaderboardentry.LeaderboardEntryPresenter;
import id.dana.richview.leaderboardentry.LeaderboardEntryView;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes8.dex */
public final class DaggerLeaderboardEntryComponent {
    private DaggerLeaderboardEntryComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public LeaderboardEntryModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class LeaderboardEntryComponentImpl implements LeaderboardEntryComponent {
        private final LeaderboardEntryModule BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final LeaderboardEntryComponentImpl MyBillsEntityDataFactory;

        public /* synthetic */ LeaderboardEntryComponentImpl(LeaderboardEntryModule leaderboardEntryModule, ApplicationComponent applicationComponent, byte b) {
            this(leaderboardEntryModule, applicationComponent);
        }

        private LeaderboardEntryComponentImpl(LeaderboardEntryModule leaderboardEntryModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.BuiltInFictitiousFunctionClassFactory = leaderboardEntryModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
        }

        @Override // id.dana.di.component.LeaderboardEntryComponent
        public final void MyBillsEntityDataFactory(LeaderboardEntryView leaderboardEntryView) {
            leaderboardEntryView.presenter = LeaderboardEntryModule_ProvidePresenterFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, new LeaderboardEntryPresenter((Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()), LeaderboardEntryModule_ProvideViewFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), new GetLeaderboardEntryBanner((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (PromotionRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.a())), new CheckLeaderboardEntryFeature((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5())), new LeaderboardMapper()));
        }
    }
}
