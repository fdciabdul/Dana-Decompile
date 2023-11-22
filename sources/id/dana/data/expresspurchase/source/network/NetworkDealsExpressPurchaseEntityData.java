package id.dana.data.expresspurchase.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.expresspurchase.source.DealsExpressPurchaseData;
import id.dana.data.expresspurchase.source.network.pojo.request.DealsQueryShopRequest;
import id.dana.data.expresspurchase.source.network.pojo.response.DealsQueryShopResponse;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/expresspurchase/source/network/NetworkDealsExpressPurchaseEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/expresspurchase/source/network/DealsExpressPurchaseFacade;", "Lid/dana/data/expresspurchase/source/DealsExpressPurchaseData;", "", "goodsId", "latitude", "longitude", "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/response/DealsQueryShopResponse;", "dealsQueryShopLocation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkDealsExpressPurchaseEntityData extends SecureBaseNetwork<DealsExpressPurchaseFacade> implements DealsExpressPurchaseData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<DealsExpressPurchaseFacade> getFacadeClass() {
        return DealsExpressPurchaseFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDealsExpressPurchaseEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.expresspurchase.source.DealsExpressPurchaseData
    public final Observable<DealsQueryShopResponse> dealsQueryShopLocation(final String goodsId, final String latitude, final String longitude) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.expresspurchase.source.network.NetworkDealsExpressPurchaseEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                DealsQueryShopResponse m1247dealsQueryShopLocation$lambda1;
                m1247dealsQueryShopLocation$lambda1 = NetworkDealsExpressPurchaseEntityData.m1247dealsQueryShopLocation$lambda1(goodsId, latitude, longitude, this, (DealsExpressPurchaseFacade) obj);
                return m1247dealsQueryShopLocation$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dealsQueryShopLocation$lambda-1  reason: not valid java name */
    public static final DealsQueryShopResponse m1247dealsQueryShopLocation$lambda1(String str, String str2, String str3, NetworkDealsExpressPurchaseEntityData networkDealsExpressPurchaseEntityData, DealsExpressPurchaseFacade dealsExpressPurchaseFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkDealsExpressPurchaseEntityData, "");
        DealsQueryShopRequest dealsQueryShopRequest = new DealsQueryShopRequest(str, str2, str3, 0, 0, 24, null);
        dealsQueryShopRequest.envInfo = networkDealsExpressPurchaseEntityData.generateMobileEnvInfo();
        return dealsExpressPurchaseFacade.dealsQueryShopLocation(dealsQueryShopRequest);
    }
}
