package id.dana.kyb.data;

import id.dana.domain.promotion.Space;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&¢\u0006\u0004\b\f\u0010\bJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0007\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H&¢\u0006\u0004\b\u0003\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH&¢\u0006\u0004\b\u0007\u0010\u0013J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH&¢\u0006\u0004\b\u0003\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/data/KybPreferenceEntityData;", "", "", "MyBillsEntityDataFactory", "()V", "Lio/reactivex/Observable;", "Lid/dana/domain/promotion/Space;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "PlaceComponentResult", "", "p0", "(Ljava/lang/String;)Lio/reactivex/Observable;", "(Lid/dana/domain/promotion/Space;)V", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/kyb/domain/model/KybMerchantInfo;)V", "(Lid/dana/kyb/domain/model/TransactionListQueryInfo;)V", "p1", "", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KybPreferenceEntityData {
    void BuiltInFictitiousFunctionClassFactory(KybMerchantInfo p0);

    Observable<KybMerchantInfo> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Boolean> MyBillsEntityDataFactory(String p0, String p1);

    void MyBillsEntityDataFactory();

    void MyBillsEntityDataFactory(Space p0);

    Observable<TransactionListQueryInfo> PlaceComponentResult();

    Observable<Space> getAuthRequestContext();

    Observable<String> getAuthRequestContext(String p0);

    void getAuthRequestContext(TransactionListQueryInfo p0);
}
