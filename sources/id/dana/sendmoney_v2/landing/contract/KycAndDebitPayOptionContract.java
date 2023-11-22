package id.dana.sendmoney_v2.landing.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.model.SendMoneyScenarioModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface KycAndDebitPayOptionContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "PlaceComponentResult", "()V", "Lid/dana/model/SendMoneyScenarioModel;", "p0", "getAuthRequestContext", "(Lid/dana/model/SendMoneyScenarioModel;)V", "", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void PlaceComponentResult();

        void getAuthRequestContext(SendMoneyScenarioModel p0);

        void getAuthRequestContext(Object p0);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\b\u0010\u000bJ!\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\rJ/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Lid/dana/domain/sendmoney/model/TransferInit;", "getAuthRequestContext", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "", "()V", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(Throwable p0, String p1, String p2, String p3);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void PlaceComponentResult(Object p0);

        void getAuthRequestContext();

        void getAuthRequestContext(TransferInit p0);

        void getAuthRequestContext(String p0, String p1);
    }
}
