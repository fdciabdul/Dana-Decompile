package id.dana.riskChallenges.data.danaprotection.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.riskChallenges.data.danaprotection.source.DanaProtectionEntityData;
import id.dana.riskChallenges.data.danaprotection.source.network.request.RiskChallengeStatusRequest;
import id.dana.riskChallenges.data.danaprotection.source.network.result.RiskChallengeStatusResult;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RiskChallengesScope
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\u0011\u0012\u0006\u0010\n\u001a\u00020\u0012\u0012\u0006\u0010\u000b\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/data/danaprotection/source/network/NetworkDanaProtectionEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/riskChallenges/data/danaprotection/source/network/DanaProtectionApi;", "Lid/dana/riskChallenges/data/danaprotection/source/DanaProtectionEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "p1", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/danaprotection/source/network/result/RiskChallengeStatusResult;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkDanaProtectionEntityData extends SecureBaseNetwork<DanaProtectionApi> implements DanaProtectionEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<DanaProtectionApi> getFacadeClass() {
        return DanaProtectionApi.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDanaProtectionEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.riskChallenges.data.danaprotection.source.DanaProtectionEntityData
    public final Observable<RiskChallengeStatusResult> getAuthRequestContext(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable<RiskChallengeStatusResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.danaprotection.source.network.NetworkDanaProtectionEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkDanaProtectionEntityData.BuiltInFictitiousFunctionClassFactory(p0, p1, p2, p3, this, (DanaProtectionApi) obj);
            }
        }, RiskChallengeStatusResult.class).onErrorResumeNext(new Function() { // from class: id.dana.riskChallenges.data.danaprotection.source.network.NetworkDanaProtectionEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkDanaProtectionEntityData.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    public static /* synthetic */ RiskChallengeStatusResult BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4, NetworkDanaProtectionEntityData networkDanaProtectionEntityData, DanaProtectionApi danaProtectionApi) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(networkDanaProtectionEntityData, "");
        RiskChallengeStatusRequest riskChallengeStatusRequest = new RiskChallengeStatusRequest(str, str2, str3, str4);
        riskChallengeStatusRequest.envInfo = networkDanaProtectionEntityData.generateMobileEnvInfo();
        return danaProtectionApi.getRiskChallengeStatus(riskChallengeStatusRequest);
    }
}
