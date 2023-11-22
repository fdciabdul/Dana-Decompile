package id.dana.explore.data.sku.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.explore.data.sku.repository.source.ProductInfoEntityData;
import id.dana.explore.data.sku.repository.source.network.request.CreateProductOrderRequest;
import id.dana.explore.data.sku.repository.source.network.response.BizDestinationInquiryResult;
import id.dana.explore.data.sku.repository.source.network.response.CreateProductOrderResult;
import id.dana.explore.data.sku.repository.source.network.response.QueryLastSuccessfulTransactionResponse;
import id.dana.network.base.ResultResponse;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/NetworkProductInfoEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/explore/data/sku/repository/source/network/ProductInfoFacade;", "Lid/dana/explore/data/sku/repository/source/ProductInfoEntityData;", "Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/explore/data/sku/repository/source/network/response/CreateProductOrderResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/explore/data/sku/repository/source/network/ProductInfoFacade;", "getAuthRequestContext", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "p4", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/explore/data/sku/repository/source/network/ProductInfoFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkProductInfoEntityData extends SecureBaseNetwork<ProductInfoFacade> implements ProductInfoEntityData {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ProductInfoFacade getAuthRequestContext;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<ProductInfoFacade> getFacadeClass() {
        return ProductInfoFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkProductInfoEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, ProductInfoFacade productInfoFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(productInfoFacade, "");
        this.getAuthRequestContext = productInfoFacade;
    }

    public final Observable<CreateProductOrderResult> BuiltInFictitiousFunctionClassFactory(CreateProductOrderRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.getAuthRequestContext.PlaceComponentResult(CookieUtil.getAuthRequestContext().toString(), p0).map(new Function() { // from class: id.dana.explore.data.sku.repository.source.network.NetworkProductInfoEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkProductInfoEntityData.BuiltInFictitiousFunctionClassFactory((ResultResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ CreateProductOrderResult BuiltInFictitiousFunctionClassFactory(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (CreateProductOrderResult) resultResponse.getResult();
    }

    public static /* synthetic */ BizDestinationInquiryResult PlaceComponentResult(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (BizDestinationInquiryResult) resultResponse.getResult();
    }

    public static /* synthetic */ QueryLastSuccessfulTransactionResponse getAuthRequestContext(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (QueryLastSuccessfulTransactionResponse) resultResponse.getResult();
    }
}
