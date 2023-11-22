package id.dana.kyb.data;

import id.dana.kyb.data.repository.source.network.result.KybMerchantInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult;
import id.dana.kyb.data.repository.source.network.result.PaymentOrderCpmResult;
import id.dana.kyb.data.repository.source.network.result.QueryLatestOrderResult;
import id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult;
import id.dana.kyb.domain.model.KybMerchantInfo;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0003\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H&¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H&¢\u0006\u0004\b\u0013\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/data/KybEntityData;", "", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "p0", "", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/domain/model/KybMerchantInfo;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "getAuthRequestContext", "Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KybEntityData {
    Observable<PaymentOrderCpmResult> KClassImpl$Data$declaredNonStaticMembers$2(KybMerchantInfo p0, String p1, String p2);

    Observable<KybMerchantInfoResult> MyBillsEntityDataFactory();

    Observable<TransactionListQueryResult> MyBillsEntityDataFactory(String p0);

    Observable<QueryLatestOrderResult> PlaceComponentResult();

    Observable<KybRequestPaymentResult> getAuthRequestContext();
}
