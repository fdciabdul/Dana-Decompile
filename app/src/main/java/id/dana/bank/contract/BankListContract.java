package id.dana.bank.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.model.BankModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/bank/contract/BankListContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BankListContract {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u0005\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/bank/contract/BankListContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/domain/sendmoney/model/TransferInit;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "MyBillsEntityDataFactory", "()V", "", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(TransferInit p0);

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\f\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/bank/contract/BankListContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "", "Lid/dana/sendmoney/model/BankModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(List<? extends BankModel> p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory(List<? extends BankModel> p0);

        void PlaceComponentResult(List<? extends BankModel> p0);
    }
}
