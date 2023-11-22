package id.dana.nearbyme.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000b\u001a\u00020\rX\u0007¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\rX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010"}, d2 = {"Lid/dana/nearbyme/di/module/PhotoGalleryModule;", "", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryModel;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryPresenter;", "p0", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryPresenter;)Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;", "", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class PhotoGalleryModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final PhotoGalleryContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    public PhotoGalleryModule(String str, String str2, PhotoGalleryContract.View view) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final PhotoGalleryContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    public final MerchantPhotoGalleryModel KClassImpl$Data$declaredNonStaticMembers$2() {
        return new MerchantPhotoGalleryModel(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Provides
    @PerActivity
    public final PhotoGalleryContract.Presenter getAuthRequestContext(PhotoGalleryPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
