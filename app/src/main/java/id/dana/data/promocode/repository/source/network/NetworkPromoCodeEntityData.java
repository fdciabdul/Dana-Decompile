package id.dana.data.promocode.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promocode.PromoAndReferralCodeUtilKt;
import id.dana.data.promocode.repository.source.PromoCodeEntityData;
import id.dana.data.promocode.repository.source.network.request.PromoCodeRequest;
import id.dana.data.promocode.repository.source.network.result.PromoCodeResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/promocode/repository/source/network/NetworkPromoCodeEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/promocode/repository/source/network/PromoCodeFacade;", "Lid/dana/data/promocode/repository/source/PromoCodeEntityData;", "", "cityName", "", "extendInfo", "", "addCityNameToExtendInfo", "(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "promoCode", "Lio/reactivex/Observable;", "Lid/dana/data/promocode/repository/source/network/result/PromoCodeResult;", "applyPromoCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkPromoCodeEntityData extends SecureBaseNetwork<PromoCodeFacade> implements PromoCodeEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<PromoCodeFacade> getFacadeClass() {
        return PromoCodeFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkPromoCodeEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.promocode.repository.source.PromoCodeEntityData
    public final Observable<PromoCodeResult> applyPromoCode(final String promoCode, final String cityName) {
        Intrinsics.checkNotNullParameter(promoCode, "");
        Intrinsics.checkNotNullParameter(cityName, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.promocode.repository.source.network.NetworkPromoCodeEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PromoCodeResult m1634applyPromoCode$lambda2;
                m1634applyPromoCode$lambda2 = NetworkPromoCodeEntityData.m1634applyPromoCode$lambda2(promoCode, this, cityName, (PromoCodeFacade) obj);
                return m1634applyPromoCode$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: applyPromoCode$lambda-2 */
    public static final PromoCodeResult m1634applyPromoCode$lambda2(String str, NetworkPromoCodeEntityData networkPromoCodeEntityData, String str2, PromoCodeFacade promoCodeFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkPromoCodeEntityData, "");
        Intrinsics.checkNotNullParameter(str2, "");
        PromoCodeRequest promoCodeRequest = new PromoCodeRequest(str);
        promoCodeRequest.envInfo = networkPromoCodeEntityData.generateMobileEnvInfo();
        Map<String, String> map = promoCodeRequest.envInfo.extendInfo;
        networkPromoCodeEntityData.addCityNameToExtendInfo(str2, promoCodeRequest.envInfo.extendInfo);
        return promoCodeFacade.applyPromoCode(promoCodeRequest);
    }

    private final Map<String, String> addCityNameToExtendInfo(String cityName, Map<String, String> extendInfo) {
        if (extendInfo != null) {
            PromoAndReferralCodeUtilKt.setUserCity(extendInfo, cityName);
            return extendInfo;
        }
        HashMap hashMap = new HashMap();
        PromoAndReferralCodeUtilKt.setUserCity(hashMap, cityName);
        return hashMap;
    }
}
