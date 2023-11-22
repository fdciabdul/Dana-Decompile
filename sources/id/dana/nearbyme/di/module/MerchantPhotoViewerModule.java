package id.dana.nearbyme.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerPresenter;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0007¢\u0006\u0004\b\u0006\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/di/module/MerchantPhotoViewerModule;", "", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerPresenter;", "p0", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoViewerPresenter;)Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;", "<init>", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class MerchantPhotoViewerModule {
    public final MediaViewerContract.View<MerchantImageModel> PlaceComponentResult;

    public MerchantPhotoViewerModule(MediaViewerContract.View<MerchantImageModel> view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    public final MediaViewerContract.View<MerchantImageModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerActivity
    public final MediaViewerContract.Presenter<MerchantImageModel> KClassImpl$Data$declaredNonStaticMembers$2(MerchantPhotoViewerPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
