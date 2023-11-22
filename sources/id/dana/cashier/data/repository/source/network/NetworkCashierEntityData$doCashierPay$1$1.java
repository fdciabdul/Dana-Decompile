package id.dana.cashier.data.repository.source.network;

import com.alibaba.ariver.engine.api.common.log.IgnoreLogUtils;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest;
import id.dana.cashier.data.repository.source.network.result.CashierPayInfoResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", IgnoreLogUtils.TYPE_API, "Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/BaseCashierResponse;", "Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", BridgeDSL.INVOKE, "(Lid/dana/cashier/data/repository/source/network/CashierSecureApi;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class NetworkCashierEntityData$doCashierPay$1$1 extends Lambda implements Function1<CashierSecureApi, Observable<BaseCashierResponse<CashierPayInfoResult>>> {
    final /* synthetic */ CashierPayEntityRequest $$cashierPayEntityRequest;
    final /* synthetic */ Map<String, String> $$headers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkCashierEntityData$doCashierPay$1$1(Map<String, String> map, CashierPayEntityRequest cashierPayEntityRequest) {
        super(1);
        this.$$headers = map;
        this.$$cashierPayEntityRequest = cashierPayEntityRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Observable<BaseCashierResponse<CashierPayInfoResult>> invoke(CashierSecureApi cashierSecureApi) {
        Intrinsics.checkNotNullParameter(cashierSecureApi, "");
        Observable map = cashierSecureApi.cashierPay(this.$$headers, this.$$cashierPayEntityRequest).map(new Function() { // from class: id.dana.cashier.data.repository.source.network.NetworkCashierEntityData$doCashierPay$1$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BaseCashierResponse m564invoke$lambda1;
                m564invoke$lambda1 = NetworkCashierEntityData$doCashierPay$1$1.m564invoke$lambda1((BaseCashierResponse) obj);
                return m564invoke$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: invoke$lambda-1 */
    public static final BaseCashierResponse m564invoke$lambda1(BaseCashierResponse baseCashierResponse) {
        Intrinsics.checkNotNullParameter(baseCashierResponse, "");
        ((CashierPayInfoResult) baseCashierResponse.result).setConfig(baseCashierResponse.config);
        return baseCashierResponse;
    }
}
