package id.dana.statement;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.base.AbstractContractKt;
import id.dana.statement.model.StatementSummaryInit;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementDetailModel;
import id.dana.statement.model.UserStatementModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/statement/UserStatementContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface UserStatementContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/statement/UserStatementContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "getAuthRequestContext", "()V", "", "p0", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(JJ)V", "Lid/dana/statement/model/StatementSummaryInit;", "(Lid/dana/statement/model/StatementSummaryInit;)V", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(long p0, long p1);

        void KClassImpl$Data$declaredNonStaticMembers$2(StatementSummaryInit p0);

        void PlaceComponentResult();

        void PlaceComponentResult(StatementSummaryInit p0);

        void getAuthRequestContext();

        void getAuthRequestContext(StatementSummaryInit p0);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0015H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H&J4\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lid/dana/statement/UserStatementContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onCheckFeatureDownloadStatementEnable", "", "downloadStatementEnable", "", "onGetAllStatementSummary", "viewModels", "", "Lid/dana/statement/model/StatementViewModel;", "onGetDetailError", "onGetStatementDetailExpense", "userStatementDetailModelExpense", "Lid/dana/statement/model/UserStatementDetailModel;", "onGetStatementDetailIncome", "userStatementDetailModelIncome", "onGetStatementDisableDetail", "bizTypeDisableDetails", "", "onGetStatementSummaryExpense", "userStatementModelExpense", "Lid/dana/statement/model/UserStatementModel;", "onGetStatementSummaryIncome", "userStatementModelIncome", "onGetTotalStatementExpense", "amount", FirebaseAnalytics.Param.CURRENCY, "onGetTotalStatementIncome", "onTrackDisplayedError", "operationType", "displayedMessage", "errorMessage", "errorCode", "traceId", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.statement.UserStatementContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }

        void BuiltInFictitiousFunctionClassFactory(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2(UserStatementModel userStatementModel);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<StatementViewModel> list);

        void MyBillsEntityDataFactory(UserStatementDetailModel userStatementDetailModel);

        void MyBillsEntityDataFactory(UserStatementModel userStatementModel);

        void MyBillsEntityDataFactory(List<String> list);

        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult();

        void getAuthRequestContext(UserStatementDetailModel userStatementDetailModel);
    }
}
