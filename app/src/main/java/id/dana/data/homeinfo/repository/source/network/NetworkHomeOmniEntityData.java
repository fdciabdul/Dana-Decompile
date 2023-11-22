package id.dana.data.homeinfo.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.homeinfo.repository.source.HomeOmniEntityData;
import id.dana.data.homeinfo.repository.source.network.result.PaylaterChannelResult;
import id.dana.data.homeinfo.repository.source.network.result.ProcessingTransactionResultWrapper;
import id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResultWrapper;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\n"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/NetworkHomeOmniEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/homeinfo/repository/source/network/HomeInfoOmniFacade;", "Lid/dana/data/homeinfo/repository/source/HomeOmniEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lio/reactivex/Observable;", "Lid/dana/data/homeinfo/repository/source/network/result/PaylaterChannelResult;", "getPaylaterChannel", "()Lio/reactivex/Observable;", "Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResultWrapper;", "getProcessingTransaction", "Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;", "getSurveyInfo", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkHomeOmniEntityData extends SecureBaseNetwork<HomeInfoOmniFacade> implements HomeOmniEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<HomeInfoOmniFacade> getFacadeClass() {
        return HomeInfoOmniFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkHomeOmniEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.homeinfo.repository.source.HomeOmniEntityData
    public final Observable<PaylaterChannelResult> getPaylaterChannel() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.homeinfo.repository.source.network.NetworkHomeOmniEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PaylaterChannelResult m1374getPaylaterChannel$lambda1;
                m1374getPaylaterChannel$lambda1 = NetworkHomeOmniEntityData.m1374getPaylaterChannel$lambda1(NetworkHomeOmniEntityData.this, (HomeInfoOmniFacade) obj);
                return m1374getPaylaterChannel$lambda1;
            }
        }, PaylaterChannelResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaylaterChannel$lambda-1  reason: not valid java name */
    public static final PaylaterChannelResult m1374getPaylaterChannel$lambda1(NetworkHomeOmniEntityData networkHomeOmniEntityData, HomeInfoOmniFacade homeInfoOmniFacade) {
        Intrinsics.checkNotNullParameter(networkHomeOmniEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkHomeOmniEntityData.generateMobileEnvInfo();
        return homeInfoOmniFacade.getPaylaterChannel(baseRpcRequest);
    }

    @Override // id.dana.data.homeinfo.repository.source.HomeOmniEntityData
    public final Observable<SurveyInfoResultWrapper> getSurveyInfo() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.homeinfo.repository.source.network.NetworkHomeOmniEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                SurveyInfoResultWrapper m1376getSurveyInfo$lambda3;
                m1376getSurveyInfo$lambda3 = NetworkHomeOmniEntityData.m1376getSurveyInfo$lambda3(NetworkHomeOmniEntityData.this, (HomeInfoOmniFacade) obj);
                return m1376getSurveyInfo$lambda3;
            }
        }, SurveyInfoResultWrapper.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSurveyInfo$lambda-3  reason: not valid java name */
    public static final SurveyInfoResultWrapper m1376getSurveyInfo$lambda3(NetworkHomeOmniEntityData networkHomeOmniEntityData, HomeInfoOmniFacade homeInfoOmniFacade) {
        Intrinsics.checkNotNullParameter(networkHomeOmniEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkHomeOmniEntityData.generateMobileEnvInfo();
        return homeInfoOmniFacade.getSurveyInfo(baseRpcRequest);
    }

    @Override // id.dana.data.homeinfo.repository.source.HomeOmniEntityData
    public final Observable<ProcessingTransactionResultWrapper> getProcessingTransaction() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.homeinfo.repository.source.network.NetworkHomeOmniEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ProcessingTransactionResultWrapper m1375getProcessingTransaction$lambda5;
                m1375getProcessingTransaction$lambda5 = NetworkHomeOmniEntityData.m1375getProcessingTransaction$lambda5(NetworkHomeOmniEntityData.this, (HomeInfoOmniFacade) obj);
                return m1375getProcessingTransaction$lambda5;
            }
        }, ProcessingTransactionResultWrapper.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getProcessingTransaction$lambda-5  reason: not valid java name */
    public static final ProcessingTransactionResultWrapper m1375getProcessingTransaction$lambda5(NetworkHomeOmniEntityData networkHomeOmniEntityData, HomeInfoOmniFacade homeInfoOmniFacade) {
        Intrinsics.checkNotNullParameter(networkHomeOmniEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkHomeOmniEntityData.generateMobileEnvInfo();
        return homeInfoOmniFacade.getProcessingTransaction(baseRpcRequest);
    }
}
