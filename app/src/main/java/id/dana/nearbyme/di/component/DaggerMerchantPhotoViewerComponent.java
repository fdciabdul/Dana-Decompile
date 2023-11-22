package id.dana.nearbyme.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.interactor.GetMerchantImage_Factory;
import id.dana.nearbyme.di.module.MerchantPhotoViewerModule;
import id.dana.nearbyme.di.module.MerchantPhotoViewerModule_ProvideMerchantPhotoViewerPresenterFactory;
import id.dana.nearbyme.di.module.MerchantPhotoViewerModule_ProvideViewFactory;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog_MembersInjector;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerPresenter;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerPresenter_Factory;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes5.dex */
public final class DaggerMerchantPhotoViewerComponent {
    private DaggerMerchantPhotoViewerComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public MerchantPhotoViewerModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class MerchantPhotoViewerComponentImpl implements MerchantPhotoViewerComponent {
        private Provider<MerchantPhotoViewerPresenter> BuiltInFictitiousFunctionClassFactory;
        private Provider<MerchantInfoRepository> KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<GetMerchantImage> MyBillsEntityDataFactory;
        private Provider<MediaViewerContract.View<MerchantImageModel>> NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final MerchantPhotoViewerComponentImpl PlaceComponentResult;
        private Provider<CoroutineDispatcher> getAuthRequestContext;
        private Provider<MediaViewerContract.Presenter<MerchantImageModel>> lookAheadTest;

        public /* synthetic */ MerchantPhotoViewerComponentImpl(MerchantPhotoViewerModule merchantPhotoViewerModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantPhotoViewerModule, applicationComponent);
        }

        private MerchantPhotoViewerComponentImpl(MerchantPhotoViewerModule merchantPhotoViewerModule, ApplicationComponent applicationComponent) {
            this.PlaceComponentResult = this;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantInfoRepositoryProvider(applicationComponent);
            DefaultDispatcherProvider defaultDispatcherProvider = new DefaultDispatcherProvider(applicationComponent);
            this.getAuthRequestContext = defaultDispatcherProvider;
            this.MyBillsEntityDataFactory = GetMerchantImage_Factory.create(this.KClassImpl$Data$declaredNonStaticMembers$2, defaultDispatcherProvider);
            Provider<MediaViewerContract.View<MerchantImageModel>> authRequestContext = DoubleCheck.getAuthRequestContext(MerchantPhotoViewerModule_ProvideViewFactory.MyBillsEntityDataFactory(merchantPhotoViewerModule));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext;
            MerchantPhotoViewerPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2 = MerchantPhotoViewerPresenter_Factory.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, authRequestContext);
            this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
            this.lookAheadTest = DoubleCheck.getAuthRequestContext(MerchantPhotoViewerModule_ProvideMerchantPhotoViewerPresenterFactory.PlaceComponentResult(merchantPhotoViewerModule, KClassImpl$Data$declaredNonStaticMembers$2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class MerchantInfoRepositoryProvider implements Provider<MerchantInfoRepository> {
            private final ApplicationComponent PlaceComponentResult;

            MerchantInfoRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ MerchantInfoRepository get() {
                return (MerchantInfoRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.M());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class DefaultDispatcherProvider implements Provider<CoroutineDispatcher> {
            private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;

            DefaultDispatcherProvider(ApplicationComponent applicationComponent) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ CoroutineDispatcher get() {
                return (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig());
            }
        }

        @Override // id.dana.nearbyme.di.component.MerchantPhotoViewerComponent
        public final void BuiltInFictitiousFunctionClassFactory(MerchantPhotoViewerDialog merchantPhotoViewerDialog) {
            MerchantPhotoViewerDialog_MembersInjector.BuiltInFictitiousFunctionClassFactory(merchantPhotoViewerDialog, this.lookAheadTest.get());
        }
    }
}
