package id.dana.data.registration.mapper;

import id.dana.data.registration.source.network.result.Trust2RiskLoginResult;
import id.dana.data.registration.source.network.result.VerificationMethodTrees;
import id.dana.domain.model.VerificationTreeNode;
import id.dana.domain.model.rpc.response.Trust2RiskLoginResponse;
import id.dana.domain.user.UserInfoResponseConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/model/VerificationTreeNode;", "parent", "", "Lid/dana/data/registration/source/network/result/VerificationMethodTrees;", "list", "", "addVerificationMethodTreeNode", "(Lid/dana/domain/model/VerificationTreeNode;Ljava/util/List;)V", "Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;", "Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;", "toTrust2RiskLoginResponse", "(Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;)Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;", "toVerificationMethodTreeNode", "(Ljava/util/List;)Lid/dana/domain/model/VerificationTreeNode;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Trust2RiskLoginMapperKt {
    public static final Trust2RiskLoginResponse toTrust2RiskLoginResponse(Trust2RiskLoginResult trust2RiskLoginResult) {
        Intrinsics.checkNotNullParameter(trust2RiskLoginResult, "");
        String userId = trust2RiskLoginResult.getUserId();
        String sessionId = trust2RiskLoginResult.getSessionId();
        String securityId = trust2RiskLoginResult.getSecurityId();
        List<VerificationMethodTrees> verificationMethodTrees = trust2RiskLoginResult.getVerificationMethodTrees();
        return new Trust2RiskLoginResponse(userId, sessionId, securityId, verificationMethodTrees != null ? toVerificationMethodTreeNode(verificationMethodTrees) : null, trust2RiskLoginResult.getPhoneNumber(), trust2RiskLoginResult.getRiskPhoneNumber(), trust2RiskLoginResult.getAvatarUrl(), trust2RiskLoginResult.getLoginTokenId(), trust2RiskLoginResult.getFailedCount(), trust2RiskLoginResult.getMaxFailedCount(), trust2RiskLoginResult.getLockedExpireSeconds(), trust2RiskLoginResult.getLeftTimes(), trust2RiskLoginResult.getTrustedDeviceEnrolled());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final VerificationTreeNode toVerificationMethodTreeNode(List<VerificationMethodTrees> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ?? r1 = 0;
        VerificationTreeNode verificationTreeNode = new VerificationTreeNode(UserInfoResponseConstant.LoginStatus.INITIAL, r1, 2, r1);
        addVerificationMethodTreeNode(verificationTreeNode, list);
        return verificationTreeNode;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    private static final void addVerificationMethodTreeNode(VerificationTreeNode verificationTreeNode, List<VerificationMethodTrees> list) {
        for (VerificationMethodTrees verificationMethodTrees : list) {
            String verificationMethod = verificationMethodTrees.getVerificationMethod();
            if (verificationMethod != null) {
                ?? r4 = 0;
                VerificationTreeNode verificationTreeNode2 = new VerificationTreeNode(verificationMethod, r4, 2, r4);
                verificationTreeNode.addChild(verificationTreeNode2);
                List<VerificationMethodTrees> fallback = verificationMethodTrees.getFallback();
                if (!(fallback == null || fallback.isEmpty())) {
                    addVerificationMethodTreeNode(verificationTreeNode, verificationMethodTrees.getFallback());
                }
                verificationTreeNode = verificationTreeNode2;
            }
        }
    }
}
