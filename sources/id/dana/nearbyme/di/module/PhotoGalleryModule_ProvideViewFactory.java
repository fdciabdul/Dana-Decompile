package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;

/* loaded from: classes5.dex */
public final class PhotoGalleryModule_ProvideViewFactory implements Factory<PhotoGalleryContract.View> {
    private final PhotoGalleryModule KClassImpl$Data$declaredNonStaticMembers$2;

    private PhotoGalleryModule_ProvideViewFactory(PhotoGalleryModule photoGalleryModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = photoGalleryModule;
    }

    public static PhotoGalleryModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(PhotoGalleryModule photoGalleryModule) {
        return new PhotoGalleryModule_ProvideViewFactory(photoGalleryModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PhotoGalleryContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getBuiltInFictitiousFunctionClassFactory());
    }
}
