package id.dana.data.pushverify.source.network;

import android.content.Context;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.pushverify.source.PushVerifyEntityData;
import id.dana.data.pushverify.source.model.PushVerificationListRequest;
import id.dana.data.pushverify.source.model.PushVerificationListResult;
import id.dana.data.pushverify.source.model.PushVerifyChallengeRequest;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.data.pushverify.source.model.VerifyPushChallengeRequest;
import id.dana.data.pushverify.source.model.VerifyPushChallengeResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/data/pushverify/source/network/NetworkPushVerifyEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/pushverify/source/network/PushVerifyFacade;", "Lid/dana/data/pushverify/source/PushVerifyEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "", "verificationStatusList", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/PushVerificationListResult;", "getPushVerificationList", "(Ljava/util/List;II)Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;", "pushVerifyChallengeRequest", "Lid/dana/data/pushverify/source/model/PushVerifyChallengeResult;", "getPushVerifyChallenge", "(Lid/dana/data/pushverify/source/model/PushVerifyChallengeRequest;)Lio/reactivex/Observable;", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "verifyPushChallengeRequest", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "verifyPushChallenge", "(Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkPushVerifyEntityData extends SecureBaseNetwork<PushVerifyFacade> implements PushVerifyEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<PushVerifyFacade> getFacadeClass() {
        return PushVerifyFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkPushVerifyEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.pushverify.source.PushVerifyEntityData
    public final Observable<PushVerificationListResult> getPushVerificationList(List<String> verificationStatusList, int pageNum, int pageSize) {
        Intrinsics.checkNotNullParameter(verificationStatusList, "");
        final PushVerificationListRequest pushVerificationListRequest = new PushVerificationListRequest(verificationStatusList, pageNum, pageSize);
        pushVerificationListRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.pushverify.source.network.NetworkPushVerifyEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PushVerificationListResult m1686getPushVerificationList$lambda1;
                m1686getPushVerificationList$lambda1 = NetworkPushVerifyEntityData.m1686getPushVerificationList$lambda1(PushVerificationListRequest.this, (PushVerifyFacade) obj);
                return m1686getPushVerificationList$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPushVerificationList$lambda-1  reason: not valid java name */
    public static final PushVerificationListResult m1686getPushVerificationList$lambda1(PushVerificationListRequest pushVerificationListRequest, PushVerifyFacade pushVerifyFacade) {
        Intrinsics.checkNotNullParameter(pushVerificationListRequest, "");
        return pushVerifyFacade.queryListPushChallenge(pushVerificationListRequest);
    }

    @Override // id.dana.data.pushverify.source.PushVerifyEntityData
    public final Observable<PushVerifyChallengeResult> getPushVerifyChallenge(final PushVerifyChallengeRequest pushVerifyChallengeRequest) {
        Intrinsics.checkNotNullParameter(pushVerifyChallengeRequest, "");
        pushVerifyChallengeRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.pushverify.source.network.NetworkPushVerifyEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                PushVerifyChallengeResult m1687getPushVerifyChallenge$lambda3;
                m1687getPushVerifyChallenge$lambda3 = NetworkPushVerifyEntityData.m1687getPushVerifyChallenge$lambda3(PushVerifyChallengeRequest.this, (PushVerifyFacade) obj);
                return m1687getPushVerifyChallenge$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPushVerifyChallenge$lambda-3  reason: not valid java name */
    public static final PushVerifyChallengeResult m1687getPushVerifyChallenge$lambda3(PushVerifyChallengeRequest pushVerifyChallengeRequest, PushVerifyFacade pushVerifyFacade) {
        Intrinsics.checkNotNullParameter(pushVerifyChallengeRequest, "");
        return pushVerifyFacade.queryDetailPushChallenge(pushVerifyChallengeRequest);
    }

    @Override // id.dana.data.pushverify.source.PushVerifyEntityData
    public final Observable<VerifyPushChallengeResult> verifyPushChallenge(final VerifyPushChallengeRequest verifyPushChallengeRequest) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeRequest, "");
        verifyPushChallengeRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.pushverify.source.network.NetworkPushVerifyEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                VerifyPushChallengeResult m1688verifyPushChallenge$lambda5;
                m1688verifyPushChallenge$lambda5 = NetworkPushVerifyEntityData.m1688verifyPushChallenge$lambda5(VerifyPushChallengeRequest.this, (PushVerifyFacade) obj);
                return m1688verifyPushChallenge$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyPushChallenge$lambda-5  reason: not valid java name */
    public static final VerifyPushChallengeResult m1688verifyPushChallenge$lambda5(VerifyPushChallengeRequest verifyPushChallengeRequest, PushVerifyFacade pushVerifyFacade) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeRequest, "");
        return pushVerifyFacade.verifyPushChallenge(verifyPushChallengeRequest);
    }
}
