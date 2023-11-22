package id.dana.data.citcall.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.citcall.source.CitCallEntityData;
import id.dana.data.citcall.source.network.request.MiscallRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.response.citcall.MiscallResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/citcall/source/network/NetworkCitCallEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/citcall/source/network/CitCallFacade;", "Lid/dana/data/citcall/source/CitCallEntityData;", "Lid/dana/data/citcall/source/network/request/MiscallRequest;", "miscallRequest", "Lio/reactivex/Observable;", "Lid/dana/network/response/citcall/MiscallResult;", "createToken", "(Lid/dana/data/citcall/source/network/request/MiscallRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkCitCallEntityData extends SecureBaseNetwork<CitCallFacade> implements CitCallEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<CitCallFacade> getFacadeClass() {
        return CitCallFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCitCallEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.citcall.source.CitCallEntityData
    public final Observable<MiscallResult> createToken(final MiscallRequest miscallRequest) {
        Intrinsics.checkNotNullParameter(miscallRequest, "");
        Observable<MiscallResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.citcall.source.network.NetworkCitCallEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                MiscallResult m831createToken$lambda1;
                m831createToken$lambda1 = NetworkCitCallEntityData.m831createToken$lambda1(MiscallRequest.this, this, (CitCallFacade) obj);
                return m831createToken$lambda1;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.citcall.source.network.NetworkCitCallEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m832createToken$lambda2;
                m832createToken$lambda2 = NetworkCitCallEntityData.m832createToken$lambda2((Throwable) obj);
                return m832createToken$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createToken$lambda-1  reason: not valid java name */
    public static final MiscallResult m831createToken$lambda1(MiscallRequest miscallRequest, NetworkCitCallEntityData networkCitCallEntityData, CitCallFacade citCallFacade) {
        Intrinsics.checkNotNullParameter(miscallRequest, "");
        Intrinsics.checkNotNullParameter(networkCitCallEntityData, "");
        miscallRequest.envInfo = networkCitCallEntityData.generateMobileEnvInfo();
        return citCallFacade.createToken(miscallRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createToken$lambda-2  reason: not valid java name */
    public static final ObservableSource m832createToken$lambda2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }
}
