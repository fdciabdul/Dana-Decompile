package id.dana.data.auth.face.mapper;

import id.dana.domain.auth.face.result.FaceAuthenticationResult;
import id.dana.domain.auth.face.result.SecurityContext;
import id.dana.domain.auth.face.result.VerificationMethodInfo;
import id.dana.network.response.authface.FaceAuthenticationEntityResult;
import id.dana.network.response.authface.SecurityContextEntity;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\nJ'\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0005\u0010\u000f"}, d2 = {"Lid/dana/data/auth/face/mapper/FaceAuthenticationEntityMapper;", "", "Lid/dana/network/response/authface/FaceAuthenticationEntityResult;", "result", "Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "transform", "(Lid/dana/network/response/authface/FaceAuthenticationEntityResult;)Lid/dana/domain/auth/face/result/FaceAuthenticationResult;", "Lid/dana/network/response/authface/SecurityContextEntity;", "securityContext", "Lid/dana/domain/auth/face/result/SecurityContext;", "(Lid/dana/network/response/authface/SecurityContextEntity;)Lid/dana/domain/auth/face/result/SecurityContext;", "", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "verificationMethods", "Lid/dana/domain/auth/face/result/VerificationMethodInfo;", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FaceAuthenticationEntityMapper {
    @Inject
    public FaceAuthenticationEntityMapper() {
    }

    public final FaceAuthenticationResult transform(FaceAuthenticationEntityResult result) {
        Intrinsics.checkNotNullParameter(result, "");
        FaceAuthenticationResult faceAuthenticationResult = new FaceAuthenticationResult();
        faceAuthenticationResult.setSuccess(result.success);
        faceAuthenticationResult.setSecurityId(result.getSecurityId());
        faceAuthenticationResult.setRiskResult(result.getRiskResult());
        faceAuthenticationResult.setAction(result.getAction());
        faceAuthenticationResult.setVerificationMethods(transform(result.getVerificationMethods()));
        faceAuthenticationResult.setSecurityContext(transform(result.getSecurityContext()));
        return faceAuthenticationResult;
    }

    private final List<VerificationMethodInfo> transform(List<VerificationMethodInfoEntity> verificationMethods) {
        if (verificationMethods != null) {
            ArrayList arrayList = new ArrayList();
            for (VerificationMethodInfoEntity verificationMethodInfoEntity : verificationMethods) {
                VerificationMethodInfo verificationMethodInfo = new VerificationMethodInfo();
                verificationMethodInfo.setPriority(Integer.valueOf(verificationMethodInfoEntity.getPriority()));
                verificationMethodInfo.setVerificationMethod(verificationMethodInfoEntity.getVerificationMethod());
                verificationMethodInfo.setVerificationMethodCode(verificationMethodInfoEntity.getVerificationMethodCode());
                arrayList.add(verificationMethodInfo);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private final SecurityContext transform(SecurityContextEntity securityContext) {
        SecurityContext securityContext2 = new SecurityContext(r1, 1, r1);
        securityContext2.setPubKey(securityContext != null ? securityContext.getPubKey() : 0);
        return securityContext2;
    }
}
