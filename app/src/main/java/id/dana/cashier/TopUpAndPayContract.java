package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.FaceAuthModel;
import id.dana.cashier.model.TopUpConsultModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.TopUpSubmitRequestModel;
import id.dana.cashier.model.TopUpVerifyRequestModel;
import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/TopUpAndPayContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface TopUpAndPayContract {

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\b\u0010\u000eJ#\u0010\u0010\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0011H&¢\u0006\u0004\b\u0006\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\u0007J'\u0010\u0006\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0017H&¢\u0006\u0004\b\u0006\u0010\u0018J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0019H&¢\u0006\u0004\b\u0013\u0010\u001aJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u001bH&¢\u0006\u0004\b\u000b\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/TopUpAndPayContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "", "getAuthRequestContext", "()V", "scheduleImpl", "Lid/dana/cashier/helper/CashierErrorState;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/helper/CashierErrorState;)V", "", "(Ljava/lang/String;)V", "p1", "lookAheadTest", "Lid/dana/cashier/model/TopUpPayModel;", "(Lid/dana/cashier/model/TopUpPayModel;)V", "MyBillsEntityDataFactory", "getErrorConfigVersion", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/TopUpConsultModel;", "(Ljava/util/List;Lid/dana/cashier/model/TopUpConsultModel;)V", "Lid/dana/cashier/model/CashierPayModel;", "(Lid/dana/cashier/model/CashierPayModel;)V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0);

        void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel);

        boolean KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(CashierPayModel p0);

        void MyBillsEntityDataFactory(TopUpPayModel p0);

        void getAuthRequestContext();

        void getAuthRequestContext(TopUpPayModel p0);

        void getAuthRequestContext(List<? extends CashierPayMethodModel> p0, TopUpConsultModel p1);

        void getErrorConfigVersion();

        void lookAheadTest(CashierErrorState p0);

        void lookAheadTest(String str);

        void scheduleImpl();

        void scheduleImpl(String p0);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J6\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001c\u001a\u00020\fH&J6\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lid/dana/cashier/TopUpAndPayContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "doFaceAuth", "", "faceAuthModel", "Lid/dana/cashier/model/FaceAuthModel;", "doTopUpPayCashier", "cashierPayRequest", "Lid/dana/cashier/domain/model/CashierPayRequest;", "viewType", "", "isNeedShowLoading", "", "doTopUpSubmit", "topUpSubmitRequestModel", "Lid/dana/cashier/model/TopUpSubmitRequestModel;", "doTopUpVerify", CashierKeyParams.TOP_UP_VERIFY_REQUEST_MODEL, "Lid/dana/cashier/model/TopUpVerifyRequestModel;", "getTopUpAgentOrBankVa", "getTopUpConsult", "payMethodFilter", "", CashierKeyParams.CASHIER_ORDER_ID, "payQueryCashier", CashierKeyParams.TOP_UP_ORDER_ID, "query3dsParams", "bizOrderId", "isNeedToPassBizOrderId", "payQueryCashierWithRisk", "validateData", CashierKeyParams.VERIFICATION_METHOD, "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(CashierPayRequest cashierPayRequest, int i, boolean z);

        void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4, String str5);

        void KClassImpl$Data$declaredNonStaticMembers$2(TopUpVerifyRequestModel topUpVerifyRequestModel);

        void PlaceComponentResult(TopUpSubmitRequestModel topUpSubmitRequestModel);

        void PlaceComponentResult(String str, String str2, String str3, String str4);

        void getAuthRequestContext(FaceAuthModel faceAuthModel);

        /* renamed from: id.dana.cashier.TopUpAndPayContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
        }
    }
}
