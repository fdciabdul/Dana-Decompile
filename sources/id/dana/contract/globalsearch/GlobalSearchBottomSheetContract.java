package id.dana.contract.globalsearch;

import id.dana.base.AbstractContract;
import id.dana.nearbyme.merchantdetail.model.MerchantInfoModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GlobalSearchBottomSheetContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(String p0, String p1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/globalsearch/GlobalSearchBottomSheetContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void getAuthRequestContext(MerchantInfoModel p0);
    }
}
