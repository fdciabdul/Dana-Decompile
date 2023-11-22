package id.dana.familyaccount.model;

import id.dana.domain.familyaccount.model.InviteMemberRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/model/InviteMemberModel;", "Lid/dana/domain/familyaccount/model/InviteMemberRequest;", "PlaceComponentResult", "(Lid/dana/familyaccount/model/InviteMemberModel;)Lid/dana/domain/familyaccount/model/InviteMemberRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InviteMemberModelKt {
    public static final InviteMemberRequest PlaceComponentResult(InviteMemberModel inviteMemberModel) {
        Intrinsics.checkNotNullParameter(inviteMemberModel, "");
        return new InviteMemberRequest(inviteMemberModel.getPlaceComponentResult(), inviteMemberModel.getKClassImpl$Data$declaredNonStaticMembers$2(), inviteMemberModel.getAuthRequestContext, inviteMemberModel.MyBillsEntityDataFactory, inviteMemberModel.BuiltInFictitiousFunctionClassFactory, inviteMemberModel.moveToNextValue, inviteMemberModel.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }
}
