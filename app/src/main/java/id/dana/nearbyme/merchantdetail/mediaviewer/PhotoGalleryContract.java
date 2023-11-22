package id.dana.nearbyme.merchantdetail.mediaviewer;

import id.dana.base.AbstractContractKt;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract;", "", "<init>", "()V", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhotoGalleryContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8'X¦\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/nearbyme/model/ShopModel;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/model/ShopModel;)V", "", "getAuthRequestContext", "()I", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(ShopModel p0);

        void MyBillsEntityDataFactory();

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        int getBuiltInFictitiousFunctionClassFactory();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001e\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onMerchantImageLoaded", "", "merchantImages", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "onMerchantPreviewImageLoaded", "shopModel", "Lid/dana/nearbyme/model/ShopModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void MyBillsEntityDataFactory(List list, ShopModel shopModel) {
                Intrinsics.checkNotNullParameter(list, "");
                Intrinsics.checkNotNullParameter(shopModel, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory(List<MerchantImageModel> list, ShopModel shopModel);

        void MyBillsEntityDataFactory(List<MerchantImageModel> list);
    }
}
