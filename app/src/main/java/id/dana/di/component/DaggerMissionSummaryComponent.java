package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.quest.MissionSummaryContract;
import id.dana.contract.promoquest.quest.MissionSummaryPresenter;
import id.dana.contract.promoquest.quest.MissionSummaryPresenter_Factory;
import id.dana.di.modules.MissionSummaryModule;
import id.dana.di.modules.MissionSummaryModule_ProvideMissionSummaryPresenterFactory;
import id.dana.di.modules.MissionSummaryModule_ProvideMissionSummaryViewFactory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.CheckPromoQuestFeature;
import id.dana.domain.featureconfig.interactor.CheckPromoQuestFeature_Factory;
import id.dana.domain.promoquest.interactor.GetMissions;
import id.dana.domain.promoquest.interactor.GetMissions_Factory;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.promoquest.mapper.PromoQuestMapper_Factory;
import id.dana.promoquest.views.MissionSummaryView;
import id.dana.promoquest.views.MissionSummaryView_MembersInjector;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DaggerMissionSummaryComponent {
    private DaggerMissionSummaryComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public MissionSummaryModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class MissionSummaryComponentImpl implements MissionSummaryComponent {
        private Provider<CheckPromoQuestFeature> BuiltInFictitiousFunctionClassFactory;
        private final MissionSummaryComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMissions> MyBillsEntityDataFactory;
        private Provider<PromoQuestRepository> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Provider<MissionSummaryPresenter> PlaceComponentResult;
        private Provider<FeatureConfigRepository> getAuthRequestContext;
        private Provider<MissionSummaryContract.Presenter> lookAheadTest;
        private Provider<MissionSummaryContract.View> moveToNextValue;

        public /* synthetic */ MissionSummaryComponentImpl(MissionSummaryModule missionSummaryModule, ApplicationComponent applicationComponent, byte b) {
            this(missionSummaryModule, applicationComponent);
        }

        private MissionSummaryComponentImpl(MissionSummaryModule missionSummaryModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.getAuthRequestContext = featureConfigRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = CheckPromoQuestFeature_Factory.create(featureConfigRepositoryProvider);
            PromoQuestRepositoryProvider promoQuestRepositoryProvider = new PromoQuestRepositoryProvider(applicationComponent);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoQuestRepositoryProvider;
            this.MyBillsEntityDataFactory = GetMissions_Factory.create(promoQuestRepositoryProvider);
            this.moveToNextValue = DoubleCheck.getAuthRequestContext(MissionSummaryModule_ProvideMissionSummaryViewFactory.getAuthRequestContext(missionSummaryModule));
            MissionSummaryPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MissionSummaryPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, PromoQuestMapper_Factory.MyBillsEntityDataFactory(), this.moveToNextValue);
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(MissionSummaryModule_ProvideMissionSummaryPresenterFactory.MyBillsEntityDataFactory(missionSummaryModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public static final class PromoQuestRepositoryProvider implements Provider<PromoQuestRepository> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            PromoQuestRepositoryProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ PromoQuestRepository get() {
                return (PromoQuestRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.QrExpiredActivity());
            }
        }

        @Override // id.dana.di.component.MissionSummaryComponent
        public final void getAuthRequestContext(MissionSummaryView missionSummaryView) {
            MissionSummaryView_MembersInjector.PlaceComponentResult(missionSummaryView, this.lookAheadTest.get());
        }
    }
}
