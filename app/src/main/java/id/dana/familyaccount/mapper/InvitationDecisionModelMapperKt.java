package id.dana.familyaccount.mapper;

import id.dana.domain.familyaccount.model.InvitationDecisionRequestInfo;
import id.dana.familyaccount.model.InvitationDecisionRequestModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/model/InvitationDecisionRequestModel;", "Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;", "MyBillsEntityDataFactory", "(Lid/dana/familyaccount/model/InvitationDecisionRequestModel;)Lid/dana/domain/familyaccount/model/InvitationDecisionRequestInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvitationDecisionModelMapperKt {
    public static final InvitationDecisionRequestInfo MyBillsEntityDataFactory(InvitationDecisionRequestModel invitationDecisionRequestModel) {
        Intrinsics.checkNotNullParameter(invitationDecisionRequestModel, "");
        return new InvitationDecisionRequestInfo(invitationDecisionRequestModel.PlaceComponentResult, invitationDecisionRequestModel.getAuthRequestContext);
    }
}
