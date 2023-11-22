package id.dana.data.loyalty.repository.source.local;

import dagger.Lazy;
import id.dana.data.base.BasePersistence;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.loyalty.repository.source.LoyaltyEntityData;
import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import id.dana.data.loyalty.repository.source.network.request.SubmitReceiptRequest;
import io.reactivex.Observable;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/loyalty/repository/source/local/LocalLoyaltyEntityData;", "Lid/dana/data/base/BasePersistence;", "Lid/dana/data/loyalty/repository/source/LoyaltyEntityData;", "", "userLoyaltyId", "Lio/reactivex/Observable;", "", "deleteReceiptDataByUserLoyaltyId", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "getReceiptDataByUserLoyaltyId", "loyaltyReceiptEntity", "", "saveReceiptData", "(Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/base/BasePersistenceDao;", "persistenceDao", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalLoyaltyEntityData extends BasePersistence implements LoyaltyEntityData {
    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final /* synthetic */ Single submitReceipt(SubmitReceiptRequest submitReceiptRequest, String str) {
        return LoyaltyEntityData.CC.$default$submitReceipt(this, submitReceiptRequest, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LocalLoyaltyEntityData(Lazy<BasePersistenceDao> lazy) {
        super(lazy);
        Intrinsics.checkNotNullParameter(lazy, "");
    }

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final Observable<Long> saveReceiptData(LoyaltyReceiptEntity loyaltyReceiptEntity) {
        Intrinsics.checkNotNullParameter(loyaltyReceiptEntity, "");
        Observable<Long> just = Observable.just(Long.valueOf(getDb().loyaltyReceiptDao().insertReceipt(loyaltyReceiptEntity)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final Observable<LoyaltyReceiptEntity> getReceiptDataByUserLoyaltyId(String userLoyaltyId) {
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Observable<LoyaltyReceiptEntity> just = Observable.just(getDb().loyaltyReceiptDao().getReceiptByUserLoyaltyId(userLoyaltyId));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final Observable<Integer> deleteReceiptDataByUserLoyaltyId(String userLoyaltyId) {
        Intrinsics.checkNotNullParameter(userLoyaltyId, "");
        Observable<Integer> just = Observable.just(Integer.valueOf(getDb().loyaltyReceiptDao().deleteReceipt(userLoyaltyId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
