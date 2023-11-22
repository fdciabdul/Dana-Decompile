package id.dana.requestmoney.bank;

import id.dana.base.AbstractContractKt;
import id.dana.requestmoney.model.QrUserBankModel;
import id.dana.requestmoney.model.UserBankModel;
import id.dana.sendmoney.Amount;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/requestmoney/bank/UserBankQrContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface UserBankQrContract {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/requestmoney/bank/UserBankQrContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/requestmoney/model/UserBankModel;", "p0", "Lid/dana/sendmoney/Amount;", "p1", "", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/requestmoney/model/UserBankModel;Lid/dana/sendmoney/Amount;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(UserBankModel p0, Amount p1, String p2);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bJ9\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/requestmoney/bank/UserBankQrContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "Lid/dana/requestmoney/model/QrUserBankModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/requestmoney/model/QrUserBankModel;)V", "", "(Ljava/lang/String;)V", "", "getAuthRequestContext", "(J)V", "PlaceComponentResult", "p1", "p2", "p3", "p4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void MyBillsEntityDataFactory(QrUserBankModel p0);

        void MyBillsEntityDataFactory(String p0);

        void PlaceComponentResult(long p0);

        void PlaceComponentResult(String p0, String p1, String p2, String p3, String p4);

        void getAuthRequestContext(long p0);
    }
}
