package id.dana.sendmoney.external;

import id.dana.base.AbstractContractKt;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SendMoneyExternalContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0005\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "", "p0", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult();

        void PlaceComponentResult(boolean p0);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fH&¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fH&¢\u0006\u0004\b\u0003\u0010\rJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eH&¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H&¢\u0006\u0004\b\u000b\u0010\u0011J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H&¢\u0006\u0004\b\u0003\u0010\u0011J/\u0010\u0017\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "p0", "getAuthRequestContext", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "Lid/dana/domain/sendmoney/model/TransferInit;", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "Lid/dana/domain/sendmoney/model/WithdrawChannelInfoData;", "(Lid/dana/domain/sendmoney/model/WithdrawChannelInfoData;)V", "", "(Z)V", "", "p1", "p2", "", "p3", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(TransferInit p0);

        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(WithdrawChannelInfoData p0);

        void MyBillsEntityDataFactory(List<ExternalWithdrawChannelModel> p0);

        void MyBillsEntityDataFactory(boolean p0);

        void PlaceComponentResult();

        void PlaceComponentResult(String p0, String p1, String p2, Throwable p3);

        void getAuthRequestContext();

        void getAuthRequestContext(TransferInit p0);

        void getAuthRequestContext(List<ExternalWithdrawChannelModel> p0);
    }
}
