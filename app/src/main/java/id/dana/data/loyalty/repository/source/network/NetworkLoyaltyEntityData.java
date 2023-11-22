package id.dana.data.loyalty.repository.source.network;

import id.dana.data.loyalty.repository.source.LoyaltyEntityData;
import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import id.dana.data.loyalty.repository.source.network.request.BaseLoyaltyRequest;
import id.dana.data.loyalty.repository.source.network.request.SubmitReceiptRequest;
import id.dana.data.loyalty.repository.source.network.response.BaseLoyaltyResponse;
import id.dana.data.loyalty.repository.source.network.response.LoyaltyResultInfo;
import id.dana.data.loyalty.repository.source.network.response.SubmitReceiptResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/loyalty/repository/source/network/NetworkLoyaltyEntityData;", "Lid/dana/data/loyalty/repository/source/LoyaltyEntityData;", "Lid/dana/data/loyalty/repository/source/network/request/SubmitReceiptRequest;", "submitReceiptRequest", "", "token", "Lio/reactivex/Single;", "Lid/dana/data/loyalty/repository/source/network/response/SubmitReceiptResponse;", "submitReceipt", "(Lid/dana/data/loyalty/repository/source/network/request/SubmitReceiptRequest;Ljava/lang/String;)Lio/reactivex/Single;", "Lid/dana/data/loyalty/repository/source/network/LoyaltyApi;", "loyaltyApi", "Lid/dana/data/loyalty/repository/source/network/LoyaltyApi;", "<init>", "(Lid/dana/data/loyalty/repository/source/network/LoyaltyApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkLoyaltyEntityData implements LoyaltyEntityData {
    private final LoyaltyApi loyaltyApi;

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final /* synthetic */ Observable deleteReceiptDataByUserLoyaltyId(String str) {
        return LoyaltyEntityData.CC.$default$deleteReceiptDataByUserLoyaltyId(this, str);
    }

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final /* synthetic */ Observable getReceiptDataByUserLoyaltyId(String str) {
        return LoyaltyEntityData.CC.$default$getReceiptDataByUserLoyaltyId(this, str);
    }

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final /* synthetic */ Observable saveReceiptData(LoyaltyReceiptEntity loyaltyReceiptEntity) {
        return LoyaltyEntityData.CC.$default$saveReceiptData(this, loyaltyReceiptEntity);
    }

    @Inject
    public NetworkLoyaltyEntityData(LoyaltyApi loyaltyApi) {
        Intrinsics.checkNotNullParameter(loyaltyApi, "");
        this.loyaltyApi = loyaltyApi;
    }

    @Override // id.dana.data.loyalty.repository.source.LoyaltyEntityData
    public final Single<SubmitReceiptResponse> submitReceipt(SubmitReceiptRequest submitReceiptRequest, String token) {
        Intrinsics.checkNotNullParameter(submitReceiptRequest, "");
        Intrinsics.checkNotNullParameter(token, "");
        LoyaltyApi loyaltyApi = this.loyaltyApi;
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(token);
        Single<BaseLoyaltyResponse<SubmitReceiptResponse>> submitReceipt = loyaltyApi.submitReceipt(sb.toString(), new BaseLoyaltyRequest<>(submitReceiptRequest));
        Function function = new Function() { // from class: id.dana.data.loyalty.repository.source.network.NetworkLoyaltyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource m1459submitReceipt$lambda3;
                m1459submitReceipt$lambda3 = NetworkLoyaltyEntityData.m1459submitReceipt$lambda3(NetworkLoyaltyEntityData.this, (BaseLoyaltyResponse) obj);
                return m1459submitReceipt$lambda3;
            }
        };
        ObjectHelper.PlaceComponentResult(function, "mapper is null");
        Single<SubmitReceiptResponse> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(submitReceipt, function));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitReceipt$lambda-3  reason: not valid java name */
    public static final SingleSource m1459submitReceipt$lambda3(NetworkLoyaltyEntityData networkLoyaltyEntityData, BaseLoyaltyResponse baseLoyaltyResponse) {
        String str;
        String status;
        Intrinsics.checkNotNullParameter(networkLoyaltyEntityData, "");
        Intrinsics.checkNotNullParameter(baseLoyaltyResponse, "");
        LoyaltyResultInfo resultInfo = baseLoyaltyResponse.getResultInfo();
        BaseLoyaltyResponse baseLoyaltyResponse2 = (resultInfo == null || (status = resultInfo.getStatus()) == null) ? false : status.equals("SUCCESS") ? baseLoyaltyResponse : null;
        if (baseLoyaltyResponse2 != null) {
            return Single.MyBillsEntityDataFactory(baseLoyaltyResponse2.getBody());
        }
        LoyaltyResultInfo resultInfo2 = baseLoyaltyResponse.getResultInfo();
        if (resultInfo2 == null || (str = resultInfo2.getMessage()) == null) {
            str = "Error Result";
        }
        return Single.getAuthRequestContext(new Throwable(str));
    }
}
