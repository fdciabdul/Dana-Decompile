package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory implements Factory<PhotoGalleryContract.Presenter> {
    private final Provider<PhotoGalleryPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PhotoGalleryModule MyBillsEntityDataFactory;

    private PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory(PhotoGalleryModule photoGalleryModule, Provider<PhotoGalleryPresenter> provider) {
        this.MyBillsEntityDataFactory = photoGalleryModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory getAuthRequestContext(PhotoGalleryModule photoGalleryModule, Provider<PhotoGalleryPresenter> provider) {
        return new PhotoGalleryModule_ProvidePhotoGalleryPresenterFactory(photoGalleryModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PhotoGalleryContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
