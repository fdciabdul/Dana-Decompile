package id.dana.data.auth.face.repository.source.network;

import android.content.Context;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData;
import id.dana.data.auth.face.repository.source.request.FaceAuthenticationEntityRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.response.authface.FaceAuthenticationEntityResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.riskChallenges.ui.missedCallOtp.PhoneStateReceiver;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001eB)\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/auth/face/repository/source/network/NetworkFaceAuthenticationEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/auth/face/repository/source/network/FaceAuthenticationFacade;", "Lid/dana/data/auth/face/repository/source/FaceAuthenticationEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "faceAuthNew", "", BioUtilityBridge.SECURITY_ID, NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lio/reactivex/Observable;", "Lid/dana/network/response/authface/FaceAuthenticationEntityResult;", "switch", "(ZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "pin", RecordError.KEY_PUB_KEY, PhoneStateReceiver.VERIFY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkFaceAuthenticationEntityData extends SecureBaseNetwork<FaceAuthenticationFacade> implements FaceAuthenticationEntityData {
    public static final String PAGE_SOURCE = "pageSource";
    public static final String PASSWORD = "PASSWORD";

    @Override // id.dana.network.base.BaseNetwork
    public final Class<FaceAuthenticationFacade> getFacadeClass() {
        return FaceAuthenticationFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFaceAuthenticationEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData
    /* renamed from: switch */
    public final Observable<FaceAuthenticationEntityResult> mo786switch(boolean faceAuthNew, String securityId, String pageSource) {
        final FaceAuthenticationEntityRequest faceAuthenticationEntityRequest = new FaceAuthenticationEntityRequest(false, null, null, null, 15, null);
        faceAuthenticationEntityRequest.envInfo = generateMobileEnvInfo();
        faceAuthenticationEntityRequest.setFaceAuthNew(faceAuthNew);
        faceAuthenticationEntityRequest.setSecurityId(securityId);
        if (pageSource != null) {
            Map<String, String> map = faceAuthenticationEntityRequest.extParams;
            Intrinsics.checkNotNullExpressionValue(map, "");
            map.put(PAGE_SOURCE, pageSource);
        }
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                FaceAuthenticationEntityResult m794switch$lambda3;
                m794switch$lambda3 = NetworkFaceAuthenticationEntityData.m794switch$lambda3(FaceAuthenticationEntityRequest.this, (FaceAuthenticationFacade) obj);
                return m794switch$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: switch$lambda-3  reason: not valid java name */
    public static final FaceAuthenticationEntityResult m794switch$lambda3(FaceAuthenticationEntityRequest faceAuthenticationEntityRequest, FaceAuthenticationFacade faceAuthenticationFacade) {
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityRequest, "");
        return faceAuthenticationFacade.m793switch(faceAuthenticationEntityRequest);
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData
    public final Observable<FaceAuthenticationEntityResult> verify(boolean faceAuthNew, String securityId, String pin, String pubKey) {
        final FaceAuthenticationEntityRequest faceAuthenticationEntityRequest = new FaceAuthenticationEntityRequest(false, null, null, null, 15, null);
        faceAuthenticationEntityRequest.envInfo = generateMobileEnvInfo();
        faceAuthenticationEntityRequest.setFaceAuthNew(faceAuthNew);
        faceAuthenticationEntityRequest.setSecurityId(securityId);
        faceAuthenticationEntityRequest.setVerificationMethod("PASSWORD");
        faceAuthenticationEntityRequest.setValidateData(RSAHelper.encrypt(pin, pubKey));
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                FaceAuthenticationEntityResult m795verify$lambda5;
                m795verify$lambda5 = NetworkFaceAuthenticationEntityData.m795verify$lambda5(FaceAuthenticationEntityRequest.this, (FaceAuthenticationFacade) obj);
                return m795verify$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verify$lambda-5  reason: not valid java name */
    public static final FaceAuthenticationEntityResult m795verify$lambda5(FaceAuthenticationEntityRequest faceAuthenticationEntityRequest, FaceAuthenticationFacade faceAuthenticationFacade) {
        Intrinsics.checkNotNullParameter(faceAuthenticationEntityRequest, "");
        return faceAuthenticationFacade.m793switch(faceAuthenticationEntityRequest);
    }
}
