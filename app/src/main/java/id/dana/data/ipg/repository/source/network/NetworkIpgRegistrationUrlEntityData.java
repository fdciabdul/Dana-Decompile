package id.dana.data.ipg.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.ipg.repository.source.IpgRegistrationUrlEntityData;
import id.dana.data.ipg.repository.source.network.request.IpgRegistrationUrlRequest;
import id.dana.data.ipg.repository.source.network.response.IpgRegistrationUrlResult;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/ipg/repository/source/network/NetworkIpgRegistrationUrlEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/ipg/repository/source/network/IpgRegistrationUrlApi;", "Lid/dana/data/ipg/repository/source/IpgRegistrationUrlEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "deviceId", "bizType", "Lio/reactivex/Observable;", "Lid/dana/data/ipg/repository/source/network/response/IpgRegistrationUrlResult;", "getIpgRegistrationUrl", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkIpgRegistrationUrlEntityData extends SecureBaseNetwork<IpgRegistrationUrlApi> implements IpgRegistrationUrlEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<IpgRegistrationUrlApi> getFacadeClass() {
        return IpgRegistrationUrlApi.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkIpgRegistrationUrlEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.ipg.repository.source.IpgRegistrationUrlEntityData
    public final Observable<IpgRegistrationUrlResult> getIpgRegistrationUrl(String deviceId, String bizType) {
        Intrinsics.checkNotNullParameter(deviceId, "");
        Intrinsics.checkNotNullParameter(bizType, "");
        ?? r2 = 0;
        final IpgRegistrationUrlRequest ipgRegistrationUrlRequest = new IpgRegistrationUrlRequest(r2, r2, 3, r2);
        ipgRegistrationUrlRequest.setBizType(bizType);
        ipgRegistrationUrlRequest.setDeviceId(deviceId);
        ipgRegistrationUrlRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.ipg.repository.source.network.NetworkIpgRegistrationUrlEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                IpgRegistrationUrlResult m1379getIpgRegistrationUrl$lambda1;
                m1379getIpgRegistrationUrl$lambda1 = NetworkIpgRegistrationUrlEntityData.m1379getIpgRegistrationUrl$lambda1(IpgRegistrationUrlRequest.this, (IpgRegistrationUrlApi) obj);
                return m1379getIpgRegistrationUrl$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIpgRegistrationUrl$lambda-1  reason: not valid java name */
    public static final IpgRegistrationUrlResult m1379getIpgRegistrationUrl$lambda1(IpgRegistrationUrlRequest ipgRegistrationUrlRequest, IpgRegistrationUrlApi ipgRegistrationUrlApi) {
        Intrinsics.checkNotNullParameter(ipgRegistrationUrlRequest, "");
        return ipgRegistrationUrlApi.getRegistrationUrl(ipgRegistrationUrlRequest);
    }
}
