package id.dana.data.statement.repository.source.network.response;

import com.alipay.ap.mobileprod.service.facade.uniresultpage.model.MoneyView;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/statement/repository/source/network/response/UserAccumulateDetail;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "amount", "Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "getAmount", "()Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "", MaintenanceBroadcastResult.KEY_DATE, "J", "getDate", "()J", "<init>", "(JLcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAccumulateDetail extends BaseRpcResult {
    private final MoneyView amount;
    private final long date;

    @JvmName(name = "getDate")
    public final long getDate() {
        return this.date;
    }

    @JvmName(name = "getAmount")
    public final MoneyView getAmount() {
        return this.amount;
    }

    public UserAccumulateDetail(long j, MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        this.date = j;
        this.amount = moneyView;
    }
}
