package id.dana.merchantmanagement;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.merchantmanagement.model.LinkedMerchantModel;
import id.dana.merchantmanagement.model.UnbindMerchantModel;
import id.dana.model.CdpContentModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/merchantmanagement/MerchantManagementContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MerchantManagementContract {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/merchantmanagement/MerchantManagementContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "dismissShimmerItem", "()V", "onErrorCheckUnbindEligibility", "onErrorGetMerchantList", "onErrorGetMoreMerchantList", "onErrorUnbindConsult", "onLinkedMerchantEmpty", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "linkedMerchantModel", "", "unbindEligibilityCheckId", "onSuccessCheckUnbindEligibility", "(Lid/dana/merchantmanagement/model/LinkedMerchantModel;Ljava/lang/String;)V", "", "Lid/dana/model/CdpContentModel;", "list", "onSuccessGetBannerList", "(Ljava/util/List;)V", "linkedMerchants", "", "totalPageNumber", "onSuccessGetMerchantList", "(Ljava/util/List;I)V", "onSuccessGetMoreMerchantList", "Lid/dana/merchantmanagement/model/UnbindMerchantModel;", "unbindMerchantModel", "onSuccessUnbindConsult", "(Lid/dana/merchantmanagement/model/UnbindMerchantModel;)V", "showShimmerItem"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void dismissShimmerItem();

        void onErrorCheckUnbindEligibility();

        void onErrorGetMerchantList();

        void onErrorGetMoreMerchantList();

        void onErrorUnbindConsult();

        void onLinkedMerchantEmpty();

        void onSuccessCheckUnbindEligibility(LinkedMerchantModel linkedMerchantModel, String unbindEligibilityCheckId);

        void onSuccessGetBannerList(List<? extends CdpContentModel> list);

        void onSuccessGetMerchantList(List<LinkedMerchantModel> linkedMerchants, int totalPageNumber);

        void onSuccessGetMoreMerchantList(List<LinkedMerchantModel> linkedMerchants, int totalPageNumber);

        void onSuccessUnbindConsult(UnbindMerchantModel unbindMerchantModel);

        void showShimmerItem();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lid/dana/merchantmanagement/MerchantManagementContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "checkUnbindEligibility", "", "linkedMerchantModel", "Lid/dana/merchantmanagement/model/LinkedMerchantModel;", "doUnbindConsult", "unbindEligibilityCheckId", "", "getHomeShoppingBanner", "getLinkedMerchants", ZdocRecordService.PAGE_NUMBER, "", "getMoreLinkedMerchants", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i);

        void KClassImpl$Data$declaredNonStaticMembers$2(LinkedMerchantModel linkedMerchantModel, String str);

        void MyBillsEntityDataFactory(LinkedMerchantModel linkedMerchantModel);

        void PlaceComponentResult();

        void PlaceComponentResult(int i);

        /* renamed from: id.dana.merchantmanagement.MerchantManagementContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }
}
