package id.dana.nearbyme.merchantdetail.merchantphoto;

import id.dana.base.AbstractContract;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantPhotoContract {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "p0", "", "PlaceComponentResult", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void PlaceComponentResult(List<MerchantImageModel> p0);
    }
}
