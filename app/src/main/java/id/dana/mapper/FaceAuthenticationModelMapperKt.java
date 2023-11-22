package id.dana.mapper;

import id.dana.domain.model.VerificationTreeNode;
import id.dana.domain.model.rpc.response.Trust2RiskLoginResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;", "", "MyBillsEntityDataFactory", "(Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;)Z"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaceAuthenticationModelMapperKt {
    public static final boolean MyBillsEntityDataFactory(Trust2RiskLoginResponse trust2RiskLoginResponse) {
        List<VerificationTreeNode> children;
        Intrinsics.checkNotNullParameter(trust2RiskLoginResponse, "");
        VerificationTreeNode challenges = trust2RiskLoginResponse.getChallenges();
        return challenges != null && (children = challenges.getChildren()) != null && children.size() == 1 && Intrinsics.areEqual("MIC_FACE", ((VerificationTreeNode) CollectionsKt.first((List) children)).getValue());
    }
}
