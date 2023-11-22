package id.dana.data.statement.repository.source.network.response;

import com.alipay.ap.mobileprod.service.facade.uniresultpage.model.MoneyView;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b"}, d2 = {"Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "component1", "()Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "", "Lid/dana/data/statement/repository/source/network/response/UserAccumulateSummary;", "component2", "()Ljava/util/List;", "accumulateAmount", "userAccumulateSummaries", "copy", "(Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;Ljava/util/List;)Lid/dana/data/statement/repository/source/network/response/UserAccumulateQuerySummaryResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "getAccumulateAmount", "Ljava/util/List;", "getUserAccumulateSummaries", "<init>", "(Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAccumulateQuerySummaryResult extends BaseRpcResult {
    private final MoneyView accumulateAmount;
    private final List<UserAccumulateSummary> userAccumulateSummaries;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserAccumulateQuerySummaryResult copy$default(UserAccumulateQuerySummaryResult userAccumulateQuerySummaryResult, MoneyView moneyView, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            moneyView = userAccumulateQuerySummaryResult.accumulateAmount;
        }
        if ((i & 2) != 0) {
            list = userAccumulateQuerySummaryResult.userAccumulateSummaries;
        }
        return userAccumulateQuerySummaryResult.copy(moneyView, list);
    }

    /* renamed from: component1  reason: from getter */
    public final MoneyView getAccumulateAmount() {
        return this.accumulateAmount;
    }

    public final List<UserAccumulateSummary> component2() {
        return this.userAccumulateSummaries;
    }

    public final UserAccumulateQuerySummaryResult copy(MoneyView accumulateAmount, List<UserAccumulateSummary> userAccumulateSummaries) {
        Intrinsics.checkNotNullParameter(accumulateAmount, "");
        Intrinsics.checkNotNullParameter(userAccumulateSummaries, "");
        return new UserAccumulateQuerySummaryResult(accumulateAmount, userAccumulateSummaries);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAccumulateQuerySummaryResult) {
            UserAccumulateQuerySummaryResult userAccumulateQuerySummaryResult = (UserAccumulateQuerySummaryResult) other;
            return Intrinsics.areEqual(this.accumulateAmount, userAccumulateQuerySummaryResult.accumulateAmount) && Intrinsics.areEqual(this.userAccumulateSummaries, userAccumulateQuerySummaryResult.userAccumulateSummaries);
        }
        return false;
    }

    public final int hashCode() {
        return (this.accumulateAmount.hashCode() * 31) + this.userAccumulateSummaries.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAccumulateQuerySummaryResult(accumulateAmount=");
        sb.append(this.accumulateAmount);
        sb.append(", userAccumulateSummaries=");
        sb.append(this.userAccumulateSummaries);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAccumulateAmount")
    public final MoneyView getAccumulateAmount() {
        return this.accumulateAmount;
    }

    @JvmName(name = "getUserAccumulateSummaries")
    public final List<UserAccumulateSummary> getUserAccumulateSummaries() {
        return this.userAccumulateSummaries;
    }

    public UserAccumulateQuerySummaryResult(MoneyView moneyView, List<UserAccumulateSummary> list) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.accumulateAmount = moneyView;
        this.userAccumulateSummaries = list;
    }
}
