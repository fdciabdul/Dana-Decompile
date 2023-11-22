package id.dana.data.statement.repository.source.mock;

import com.alipay.ap.mobileprod.service.facade.uniresultpage.model.MoneyView;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.statement.repository.source.UserStatementEntityData;
import id.dana.data.statement.repository.source.network.response.StatementDetailResult;
import id.dana.data.statement.repository.source.network.response.UserAccumulateDetail;
import id.dana.data.statement.repository.source.network.response.UserAccumulateQuerySummaryResult;
import id.dana.data.util.RandomMatchers;
import io.reactivex.Observable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/statement/repository/source/mock/MockUserStatementEntityData;", "Lid/dana/data/statement/repository/source/UserStatementEntityData;", "", "p0", "p1", "", "p2", "Lio/reactivex/Observable;", "Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(JJLjava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "MyBillsEntityDataFactory", "()Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MockUserStatementEntityData implements UserStatementEntityData {
    @Override // id.dana.data.statement.repository.source.UserStatementEntityData
    public final Observable<UserAccumulateQuerySummaryResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<UserAccumulateQuerySummaryResult> just = Observable.just(new UserAccumulateQuerySummaryResult(new MoneyView(), new ArrayList()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.statement.repository.source.UserStatementEntityData
    public final Observable<StatementDetailResult> KClassImpl$Data$declaredNonStaticMembers$2(long p0, long p1, String p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UserAccumulateDetail(1588266000000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588352400000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588438800000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588525200000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588611600000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588698000000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588784400000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588870800000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1588957200000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1589043600000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1589130000000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1589216400000L, MyBillsEntityDataFactory()));
        arrayList.add(new UserAccumulateDetail(1589302800000L, MyBillsEntityDataFactory()));
        Observable<StatementDetailResult> just = Observable.just(new StatementDetailResult(arrayList));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private static MoneyView MyBillsEntityDataFactory() {
        MoneyView moneyView = new MoneyView();
        moneyView.currency = "Rp";
        moneyView.currencyCode = GlobalNetworkConstants.IDR_CURRENCY;
        moneyView.amount = String.valueOf(RandomMatchers.randomInt(5000));
        return moneyView;
    }
}
