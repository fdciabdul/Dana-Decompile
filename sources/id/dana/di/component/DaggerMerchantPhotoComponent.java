package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosPresenter;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosView;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosView_MembersInjector;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes4.dex */
public final class DaggerMerchantPhotoComponent {
    private DaggerMerchantPhotoComponent() {
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public MerchantPhotoModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class MerchantPhotoComponentImpl implements MerchantPhotoComponent {
        private final MerchantPhotoComponentImpl BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private Provider<MerchantPhotoContract.View> PlaceComponentResult;

        public /* synthetic */ MerchantPhotoComponentImpl(MerchantPhotoModule merchantPhotoModule, ApplicationComponent applicationComponent, byte b) {
            this(merchantPhotoModule, applicationComponent);
        }

        private MerchantPhotoComponentImpl(MerchantPhotoModule merchantPhotoModule, ApplicationComponent applicationComponent) {
            this.BuiltInFictitiousFunctionClassFactory = this;
            this.MyBillsEntityDataFactory = applicationComponent;
            this.PlaceComponentResult = DoubleCheck.getAuthRequestContext(MerchantPhotoModule_ProvideMerchantPhotoViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(merchantPhotoModule));
        }

        @Override // id.dana.di.component.MerchantPhotoComponent
        public final void PlaceComponentResult(MerchantPhotosView merchantPhotosView) {
            MerchantPhotosView_MembersInjector.PlaceComponentResult(merchantPhotosView, new MerchantPhotosPresenter(this.PlaceComponentResult.get(), new GetMerchantImage((MerchantInfoRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.M()), (CoroutineDispatcher) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.GetContactSyncConfig()))));
        }
    }
}
