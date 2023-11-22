package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.services.interactor.GetFavoriteServices;
import id.dana.domain.services.interactor.SaveFavoriteServices;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.richview.servicescard.mapper.ServiceCategoryMapper;
import id.dana.service.favorites.FavoriteServicesModule;
import id.dana.service.favorites.FavoriteServicesModule_GetPresenterFactory;
import id.dana.service.favorites.FavoriteServicesModule_GetViewFactory;
import id.dana.service.favorites.FavoriteServicesPresenter;
import id.dana.service.favorites.FavoriteServicesView;
import id.dana.service.favorites.FavoriteServicesView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes4.dex */
public final class DaggerFavoriteServicesComponent {
    private DaggerFavoriteServicesComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public FavoriteServicesModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class FavoriteServicesComponentImpl implements FavoriteServicesComponent {
        private final FavoriteServicesModule KClassImpl$Data$declaredNonStaticMembers$2;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private final FavoriteServicesComponentImpl getAuthRequestContext;

        public /* synthetic */ FavoriteServicesComponentImpl(FavoriteServicesModule favoriteServicesModule, ApplicationComponent applicationComponent, byte b) {
            this(favoriteServicesModule, applicationComponent);
        }

        private FavoriteServicesComponentImpl(FavoriteServicesModule favoriteServicesModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = favoriteServicesModule;
            this.MyBillsEntityDataFactory = applicationComponent;
        }

        @Override // id.dana.di.component.FavoriteServicesComponent
        public final void KClassImpl$Data$declaredNonStaticMembers$2(FavoriteServicesView favoriteServicesView) {
            FavoriteServicesView_MembersInjector.MyBillsEntityDataFactory(favoriteServicesView, FavoriteServicesModule_GetPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, new FavoriteServicesPresenter(FavoriteServicesModule_GetViewFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), new GetFavoriteServices((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1())), new SaveFavoriteServices((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (ServicesRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.SecuritySettingsActivity$createPinLauncher$2$1())), new ThirdPartyServicesMapper(new ServiceCategoryMapper((Context) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.moveToNextValue()))))));
        }
    }
}
