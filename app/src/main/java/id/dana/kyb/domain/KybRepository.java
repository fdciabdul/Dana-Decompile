package id.dana.kyb.domain;

import id.dana.domain.promotion.Space;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.KybRequestPayment;
import id.dana.kyb.domain.model.KybService;
import id.dana.kyb.domain.model.KybStartupConfig;
import id.dana.kyb.domain.model.KybUrlsConfig;
import id.dana.kyb.domain.model.PaymentOrderCpm;
import id.dana.kyb.domain.model.QueryLatestOrder;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0006\u001a\u00020\u000fH&¢\u0006\u0004\b\u0003\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\bH&¢\u0006\u0004\b\u0013\u0010\u000eJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0006\u001a\u00020\u000fH&¢\u0006\u0004\b\r\u0010\u0011J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\bH&¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\bH&¢\u0006\u0004\b\u0018\u0010\u000eJ\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\bH&¢\u0006\u0004\b\u0019\u0010\u000eJ%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\u0018\u0010\u001bJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\u001c\u0010\u000eJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\bH&¢\u0006\u0004\b\u001e\u0010\u000eJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH&¢\u0006\u0004\b\u001f\u0010\u000eJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\bH&¢\u0006\u0004\b!\u0010\u000eJ\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\bH&¢\u0006\u0004\b#\u0010\u000eJ\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH&¢\u0006\u0004\b$\u0010\u000eJ\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010%ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/domain/KybRepository;", "", "Lio/reactivex/Completable;", "MyBillsEntityDataFactory", "()Lio/reactivex/Completable;", "", "p0", "p1", "Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/PaymentOrderCpm;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "", "Lid/dana/domain/promotion/Space;", "(Z)Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "PlaceComponentResult", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "Lid/dana/kyb/domain/model/KybService;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybStartupConfig;", "getAuthRequestContext", "getErrorConfigVersion", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "(ZLjava/lang/String;)Lio/reactivex/Observable;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/kyb/domain/model/KybRequestPayment;", "scheduleImpl", "lookAheadTest", "Lid/dana/kyb/domain/model/QueryLatestOrder;", "moveToNextValue", "Lid/dana/kyb/domain/model/KybUrlsConfig;", "GetContactSyncConfig", "DatabaseTableConfigUtil", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KybRepository {
    Observable<Space> BuiltInFictitiousFunctionClassFactory();

    Observable<PaymentOrderCpm> BuiltInFictitiousFunctionClassFactory(String p0, String p1);

    Observable<Boolean> DatabaseTableConfigUtil();

    Observable<KybUrlsConfig> GetContactSyncConfig();

    Completable KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1);

    Observable<List<String>> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<KybMerchantInfo> KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

    Completable MyBillsEntityDataFactory();

    Observable<KybService> MyBillsEntityDataFactory(String p0);

    Observable<Space> MyBillsEntityDataFactory(boolean p0);

    Observable<String> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<KybCompressQrConfig> PlaceComponentResult();

    Observable<KybStartupConfig> getAuthRequestContext();

    Observable<Boolean> getAuthRequestContext(String p0);

    Observable<TransactionListQueryInfo> getAuthRequestContext(boolean p0, String p1);

    Observable<List<String>> getErrorConfigVersion();

    Observable<Boolean> lookAheadTest();

    Observable<QueryLatestOrder> moveToNextValue();

    Observable<KybRequestPayment> scheduleImpl();
}
