package id.dana.savings.contract;

import id.dana.base.AbstractContractKt;
import id.dana.savings.model.SavingDetailModel;
import id.dana.savings.model.TopUpModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/SavingTopUpHistoryContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface SavingTopUpHistoryContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8'X¦\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "p1", "p2", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "PlaceComponentResult", "", "()I", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        @JvmName(name = "MyBillsEntityDataFactory")
        int MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult(String str);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/SavingTopUpHistoryContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "getAuthRequestContext", "()V", "Lid/dana/savings/model/SavingDetailModel;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/savings/model/SavingDetailModel;)V", "", "Lid/dana/savings/model/TopUpModel;", "PlaceComponentResult", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(SavingDetailModel p0);

        void PlaceComponentResult(List<TopUpModel> p0);

        void getAuthRequestContext();
    }
}
