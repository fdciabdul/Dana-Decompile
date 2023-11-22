package id.dana.wallet_v3.view.sort.presenter;

import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface BottomSheetSortAssetContract {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", HomeTabActivity.WALLET_SECTION, "", "getSortOrder", "(Ljava/lang/String;)V", "", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "orders", "getVoucherAndTicketOrder", "(Ljava/util/List;)V", "order", "saveVoucherTicketOrder"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void getSortOrder(String section);

        void getVoucherAndTicketOrder(List<SortCategoryModel> orders);

        void saveVoucherTicketOrder(String order);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onErrorGetOrderCategory", "()V", "onErrorGetVoucherAndTicketOrder", "", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "order", "onSuccessGetOrderCategory", "(Ljava/util/List;)V", "", "position", "", "savedOrder", "onSuccessGetVoucherAndTicketOrder", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onErrorGetOrderCategory();

        void onErrorGetVoucherAndTicketOrder();

        void onSuccessGetOrderCategory(List<SortCategoryModel> order);

        void onSuccessGetVoucherAndTicketOrder(int position, String savedOrder);
    }
}
