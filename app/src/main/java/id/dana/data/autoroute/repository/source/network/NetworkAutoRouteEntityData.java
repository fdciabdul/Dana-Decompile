package id.dana.data.autoroute.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.autoroute.mapper.AutoRouteMapperKt;
import id.dana.data.autoroute.model.AutoRouteInitResult;
import id.dana.data.autoroute.model.UserAutoRouteConfigStoreRequest;
import id.dana.data.autoroute.model.UserAutorouteInitRequest;
import id.dana.data.autoroute.repository.AutoRouteEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/autoroute/repository/source/network/NetworkAutoRouteEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/autoroute/repository/source/network/AutoRouteFacade;", "Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "needAssetCheck", "Lio/reactivex/Observable;", "Lid/dana/data/autoroute/model/AutoRouteInitResult;", "getInitialSetting", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "userAutoRouteConfigStoreRequest", "isFromCashierFlow", "Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "switchConfig", "(Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkAutoRouteEntityData extends SecureBaseNetwork<AutoRouteFacade> implements AutoRouteEntityData {
    private static final String CASHIER_API_SOURCE = "alipayplus.mobilewallet.cashier.pay";
    private static final String PAGE_SOURCE = "pageSource";

    @Override // id.dana.network.base.BaseNetwork
    public final Class<AutoRouteFacade> getFacadeClass() {
        return AutoRouteFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkAutoRouteEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.autoroute.repository.AutoRouteEntityData
    public final Observable<AutoRouteInitResult> getInitialSetting(boolean needAssetCheck) {
        final UserAutorouteInitRequest userAutorouteInitRequest = new UserAutorouteInitRequest(needAssetCheck);
        userAutorouteInitRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.autoroute.repository.source.network.NetworkAutoRouteEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AutoRouteInitResult m805getInitialSetting$lambda1;
                m805getInitialSetting$lambda1 = NetworkAutoRouteEntityData.m805getInitialSetting$lambda1(UserAutorouteInitRequest.this, (AutoRouteFacade) obj);
                return m805getInitialSetting$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getInitialSetting$lambda-1  reason: not valid java name */
    public static final AutoRouteInitResult m805getInitialSetting$lambda1(UserAutorouteInitRequest userAutorouteInitRequest, AutoRouteFacade autoRouteFacade) {
        Intrinsics.checkNotNullParameter(userAutorouteInitRequest, "");
        return autoRouteFacade.init(userAutorouteInitRequest);
    }

    @Override // id.dana.data.autoroute.repository.AutoRouteEntityData
    public final Observable<UserAutoRouteConfigSwitchResult> switchConfig(final UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest, Boolean isFromCashierFlow) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigStoreRequest, "");
        userAutoRouteConfigStoreRequest.envInfo = generateMobileEnvInfo();
        if (Intrinsics.areEqual(isFromCashierFlow, Boolean.TRUE)) {
            AutoRouteMapperKt.addExtParams(userAutoRouteConfigStoreRequest, "pageSource", CASHIER_API_SOURCE);
        }
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.autoroute.repository.source.network.NetworkAutoRouteEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UserAutoRouteConfigSwitchResult m806switchConfig$lambda3;
                m806switchConfig$lambda3 = NetworkAutoRouteEntityData.m806switchConfig$lambda3(UserAutoRouteConfigStoreRequest.this, (AutoRouteFacade) obj);
                return m806switchConfig$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: switchConfig$lambda-3  reason: not valid java name */
    public static final UserAutoRouteConfigSwitchResult m806switchConfig$lambda3(UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest, AutoRouteFacade autoRouteFacade) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigStoreRequest, "");
        return autoRouteFacade.m803switch(userAutoRouteConfigStoreRequest);
    }
}
