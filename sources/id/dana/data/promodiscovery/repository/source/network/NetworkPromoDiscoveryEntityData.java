package id.dana.data.promodiscovery.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.network.request.PromoDanaDealsRequest;
import id.dana.data.promodiscovery.repository.source.network.request.PromoFourKingsRequest;
import id.dana.data.promodiscovery.repository.source.network.response.ProductInfoResponse;
import id.dana.data.promodiscovery.repository.source.network.response.PromoFourKingsResponse;
import id.dana.data.promodiscovery.repository.source.split.model.PromoDiscoveryEntity;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/network/NetworkPromoDiscoveryEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/promodiscovery/repository/source/network/PromoDiscoveryFacade;", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "userId", "Lio/reactivex/Observable;", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "getFourKingsLocal", "(Ljava/lang/String;)Lio/reactivex/Observable;", "fourKingsTypes", "Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "getFourKingsPromo", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "searchCriteriaMap", "Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoResponse;", "getPromoDanaDeals", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "getPromoDiscoveryConfig", "()Lio/reactivex/Observable;", "fourKingsPromo", "", "setFourKingsLocal", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkPromoDiscoveryEntityData extends SecureBaseNetwork<PromoDiscoveryFacade> implements PromoDiscoveryEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<PromoDiscoveryFacade> getFacadeClass() {
        return PromoDiscoveryFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkPromoDiscoveryEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<PromoDiscoveryEntity> getPromoDiscoveryConfig() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<ProductInfoResponse> getPromoDanaDeals(final Map<String, String> searchCriteriaMap) {
        Intrinsics.checkNotNullParameter(searchCriteriaMap, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promodiscovery.repository.source.network.NetworkPromoDiscoveryEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ProductInfoResponse m1642getPromoDanaDeals$lambda0;
                m1642getPromoDanaDeals$lambda0 = NetworkPromoDiscoveryEntityData.m1642getPromoDanaDeals$lambda0(searchCriteriaMap, (PromoDiscoveryFacade) obj);
                return m1642getPromoDanaDeals$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: getPromoDanaDeals$lambda-0 */
    public static final ProductInfoResponse m1642getPromoDanaDeals$lambda0(Map map, PromoDiscoveryFacade promoDiscoveryFacade) {
        Intrinsics.checkNotNullParameter(map, "");
        return promoDiscoveryFacade.getPromoDanaDeals(new PromoDanaDealsRequest(map));
    }

    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<PromoFourKingsResponse> getFourKingsPromo(final List<String> fourKingsTypes) {
        Intrinsics.checkNotNullParameter(fourKingsTypes, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promodiscovery.repository.source.network.NetworkPromoDiscoveryEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PromoFourKingsResponse m1641getFourKingsPromo$lambda1;
                m1641getFourKingsPromo$lambda1 = NetworkPromoDiscoveryEntityData.m1641getFourKingsPromo$lambda1(fourKingsTypes, (PromoDiscoveryFacade) obj);
                return m1641getFourKingsPromo$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: getFourKingsPromo$lambda-1 */
    public static final PromoFourKingsResponse m1641getFourKingsPromo$lambda1(List list, PromoDiscoveryFacade promoDiscoveryFacade) {
        Intrinsics.checkNotNullParameter(list, "");
        return promoDiscoveryFacade.getPromoCenterPillarByTypeList(new PromoFourKingsRequest(list));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<List<FourKingsPromoModel>> getFourKingsLocal(String userId) {
        Intrinsics.checkNotNullParameter(userId, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<Unit> setFourKingsLocal(String userId, List<FourKingsPromoModel> fourKingsPromo) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(fourKingsPromo, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }
}
