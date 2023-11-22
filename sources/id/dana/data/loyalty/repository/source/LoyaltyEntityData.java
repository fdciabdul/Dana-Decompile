package id.dana.data.loyalty.repository.source;

import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import id.dana.data.loyalty.repository.source.network.request.SubmitReceiptRequest;
import id.dana.data.loyalty.repository.source.network.response.SubmitReceiptResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/data/loyalty/repository/source/LoyaltyEntityData;", "", "deleteReceiptDataByUserLoyaltyId", "Lio/reactivex/Observable;", "", "userLoyaltyId", "", "getReceiptDataByUserLoyaltyId", "Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "saveReceiptData", "", "loyaltyReceiptEntity", "submitReceipt", "Lio/reactivex/Single;", "Lid/dana/data/loyalty/repository/source/network/response/SubmitReceiptResponse;", "submitReceiptRequest", "Lid/dana/data/loyalty/repository/source/network/request/SubmitReceiptRequest;", "token", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LoyaltyEntityData {
    Observable<Integer> deleteReceiptDataByUserLoyaltyId(String userLoyaltyId);

    Observable<LoyaltyReceiptEntity> getReceiptDataByUserLoyaltyId(String userLoyaltyId);

    Observable<Long> saveReceiptData(LoyaltyReceiptEntity loyaltyReceiptEntity);

    Single<SubmitReceiptResponse> submitReceipt(SubmitReceiptRequest submitReceiptRequest, String token);

    /* renamed from: id.dana.data.loyalty.repository.source.LoyaltyEntityData$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static Single $default$submitReceipt(LoyaltyEntityData loyaltyEntityData, SubmitReceiptRequest submitReceiptRequest, String str) {
            Intrinsics.checkNotNullParameter(submitReceiptRequest, "");
            Intrinsics.checkNotNullParameter(str, "");
            Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory((Object) null);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return MyBillsEntityDataFactory;
        }

        public static Observable $default$saveReceiptData(LoyaltyEntityData loyaltyEntityData, LoyaltyReceiptEntity loyaltyReceiptEntity) {
            Intrinsics.checkNotNullParameter(loyaltyReceiptEntity, "");
            Observable just = Observable.just(null);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }

        public static Observable $default$getReceiptDataByUserLoyaltyId(LoyaltyEntityData loyaltyEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            Observable just = Observable.just(null);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }

        public static Observable $default$deleteReceiptDataByUserLoyaltyId(LoyaltyEntityData loyaltyEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            Observable just = Observable.just(null);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
    }
}
