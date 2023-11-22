package id.dana.kyb.data.repository.source.mock;

import android.content.Context;
import com.zoloz.rpc.encryption.EncryptionProxyInvocationHandler;
import id.dana.data.R;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import id.dana.kyb.data.KybEntityData;
import id.dana.kyb.data.repository.source.network.result.KybMerchantInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult;
import id.dana.kyb.data.repository.source.network.result.PaymentOrderCpmResult;
import id.dana.kyb.data.repository.source.network.result.QueryLatestOrderResult;
import id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0018"}, d2 = {"Lid/dana/kyb/data/repository/source/mock/MockKybEntityData;", "Lid/dana/kyb/data/KybEntityData;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "p0", "", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/PaymentOrderCpmResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/domain/model/KybMerchantInfo;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "MyBillsEntityDataFactory", "()Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "getAuthRequestContext", "Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "PlaceComponentResult", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockKybEntityData implements KybEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context getAuthRequestContext;
    public final Serializer MyBillsEntityDataFactory;

    @Inject
    public MockKybEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = serializer;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<KybMerchantInfoResult> MyBillsEntityDataFactory() {
        Observable<KybMerchantInfoResult> just = Observable.just(this.MyBillsEntityDataFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.res_0x7f120020_kclassimpl_data_declarednonstaticmembers_2), KybMerchantInfoResult.class));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<QueryLatestOrderResult> PlaceComponentResult() {
        Observable<QueryLatestOrderResult> just = Observable.just(new QueryLatestOrderResult(null, "2022-01-11 10:53:18", "SUCCESS"));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<TransactionListQueryResult> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<TransactionListQueryResult> just = Observable.just(this.MyBillsEntityDataFactory.deserialize(RawUtils.jsonRawToString(this.getAuthRequestContext, R.raw.BuiltInFictitiousFunctionClassFactory_res_0x7f120021), TransactionListQueryResult.class));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<KybRequestPaymentResult> getAuthRequestContext() {
        Observable<KybRequestPaymentResult> just = Observable.just(new KybRequestPaymentResult(true, new MoneyViewEntity(EncryptionProxyInvocationHandler.SUCCESS_RET_CODE, "Rp", null, 4, null)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.kyb.data.KybEntityData
    public final Observable<PaymentOrderCpmResult> KClassImpl$Data$declaredNonStaticMembers$2(KybMerchantInfo p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }
}
