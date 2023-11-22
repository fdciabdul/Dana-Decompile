package id.dana.nearbyme.merchantdetail.merchantphoto;

import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotosPresenter;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$Presenter;", "", "onDestroy", "()V", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/interactor/GetMerchantImage;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;", "p0", "p1", "<init>", "(Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantImage;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotosPresenter implements MerchantPhotoContract.Presenter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final MerchantPhotoContract.View MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final GetMerchantImage PlaceComponentResult;

    @Inject
    public MerchantPhotosPresenter(MerchantPhotoContract.View view, GetMerchantImage getMerchantImage) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantImage, "");
        this.MyBillsEntityDataFactory = view;
        this.PlaceComponentResult = getMerchantImage;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }
}
