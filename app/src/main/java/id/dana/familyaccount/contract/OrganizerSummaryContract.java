package id.dana.familyaccount.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.familyaccount.model.ApproveSendMoneyRequest;
import id.dana.domain.familyaccount.model.ApproveSendMoneyResult;
import id.dana.domain.familyaccount.model.RejectSendMoneyRequest;
import id.dana.familyaccount.constants.StatusInformationType;
import id.dana.familyaccount.model.SummaryModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/OrganizerSummaryContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OrganizerSummaryContract {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH&¢\u0006\u0004\b\u0005\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/OrganizerSummaryContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/familyaccount/model/ApproveSendMoneyRequest;)V", "getAuthRequestContext", "()V", "Lid/dana/familyaccount/model/SummaryModel;", "(Lid/dana/familyaccount/model/SummaryModel;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;", "(Lid/dana/domain/familyaccount/model/RejectSendMoneyRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(ApproveSendMoneyRequest p0);

        void BuiltInFictitiousFunctionClassFactory(RejectSendMoneyRequest p0);

        void MyBillsEntityDataFactory(String p0);

        void getAuthRequestContext();

        void getAuthRequestContext(SummaryModel p0);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/OrganizerSummaryContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onCustomErrorMessage", "", "errType", "", "onErrorApproveSendMoney", "errMessage", "onErrorRejectSendMoney", "onErrorState", "informationType", "onHideShimmeringProgress", "onShowSimmeringProgress", "onSuccessApproveSendMoney", "approveSendMoneyResult", "Lid/dana/domain/familyaccount/model/ApproveSendMoneyResult;", "onSuccessCheckCashierFeature", "isCashierNativeActive", "", "onSuccessGetBankFreeTransfer", "organizerSummaryModel", "Lid/dana/familyaccount/model/SummaryModel;", "totalBankFreeTransfer", "", "onSuccessOrganizerSummary", "onSuccessRejectSendMoney", "onTransactionHistoryDetail", "fundOrderId", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory(SummaryModel summaryModel, int i);

        void MyBillsEntityDataFactory(String str);

        void PlaceComponentResult();

        void PlaceComponentResult(ApproveSendMoneyResult approveSendMoneyResult);

        void PlaceComponentResult(@StatusInformationType String str);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext(SummaryModel summaryModel);

        void getAuthRequestContext(String str);
    }
}
