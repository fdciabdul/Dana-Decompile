package id.dana.data.familyaccount.mapper;

import id.dana.data.familyaccount.model.result.DashboardFamilyAccountEntity;
import id.dana.data.familyaccount.model.result.FamilyAccountMemberInfoEntity;
import id.dana.data.familyaccount.model.result.LimitInfoEntity;
import id.dana.data.familyaccount.model.result.MemberInfoEntity;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.familyaccount.model.DashboardFamilyAccountResult;
import id.dana.domain.familyaccount.model.FamilyAccountMemberInfoResult;
import id.dana.domain.familyaccount.model.LimitInfoResult;
import id.dana.domain.familyaccount.model.MemberInfoResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\f*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u0011\u001a\u00020\u0010*\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;", "toDashboardFamilyAccountResult", "(Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;)Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;", "Lid/dana/data/familyaccount/model/result/FamilyAccountMemberInfoEntity;", "Lid/dana/domain/familyaccount/model/FamilyAccountMemberInfoResult;", "toFamilyAccountMemberInfoResult", "(Lid/dana/data/familyaccount/model/result/FamilyAccountMemberInfoEntity;)Lid/dana/domain/familyaccount/model/FamilyAccountMemberInfoResult;", "Lid/dana/data/familyaccount/model/result/LimitInfoEntity;", "Lid/dana/domain/familyaccount/model/LimitInfoResult;", "toLimitInfoResult", "(Lid/dana/data/familyaccount/model/result/LimitInfoEntity;)Lid/dana/domain/familyaccount/model/LimitInfoResult;", "", "toListFamilyAccountMemberInfoResult", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/familyaccount/model/result/MemberInfoEntity;", "Lid/dana/domain/familyaccount/model/MemberInfoResult;", "toMemberInfoResult", "(Lid/dana/data/familyaccount/model/result/MemberInfoEntity;)Lid/dana/domain/familyaccount/model/MemberInfoResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DashboardFamilyAccountEntityMapperKt {
    public static final DashboardFamilyAccountResult toDashboardFamilyAccountResult(DashboardFamilyAccountEntity dashboardFamilyAccountEntity) {
        Intrinsics.checkNotNullParameter(dashboardFamilyAccountEntity, "");
        String status = dashboardFamilyAccountEntity.getStatus();
        return new DashboardFamilyAccountResult(status != null ? status : "", MoneyViewEntityMapperKt.toMoneyView(dashboardFamilyAccountEntity.getBalance()), toListFamilyAccountMemberInfoResult(dashboardFamilyAccountEntity.getSharedAccountMemberInfoList()));
    }

    private static final List<FamilyAccountMemberInfoResult> toListFamilyAccountMemberInfoResult(List<FamilyAccountMemberInfoEntity> list) {
        if (list != null) {
            List<FamilyAccountMemberInfoEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toFamilyAccountMemberInfoResult((FamilyAccountMemberInfoEntity) it.next()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private static final FamilyAccountMemberInfoResult toFamilyAccountMemberInfoResult(FamilyAccountMemberInfoEntity familyAccountMemberInfoEntity) {
        String organizerUserId = familyAccountMemberInfoEntity.getOrganizerUserId();
        String str = organizerUserId == null ? "" : organizerUserId;
        MemberInfoResult memberInfoResult = toMemberInfoResult(familyAccountMemberInfoEntity.getMember());
        String invitationStatus = familyAccountMemberInfoEntity.getInvitationStatus();
        String str2 = invitationStatus == null ? "" : invitationStatus;
        String invitationId = familyAccountMemberInfoEntity.getInvitationId();
        return new FamilyAccountMemberInfoResult(str, memberInfoResult, str2, invitationId == null ? "" : invitationId, toLimitInfoResult(familyAccountMemberInfoEntity.getLimitInfo()));
    }

    private static final MemberInfoResult toMemberInfoResult(MemberInfoEntity memberInfoEntity) {
        if (memberInfoEntity != null) {
            String userId = memberInfoEntity.getUserId();
            String str = userId == null ? "" : userId;
            String nickname = memberInfoEntity.getNickname();
            String str2 = nickname == null ? "" : nickname;
            String certName = memberInfoEntity.getCertName();
            String str3 = certName == null ? "" : certName;
            String certifyLevel = memberInfoEntity.getCertifyLevel();
            String str4 = certifyLevel == null ? "" : certifyLevel;
            String avatarUrl = memberInfoEntity.getAvatarUrl();
            String str5 = avatarUrl == null ? "" : avatarUrl;
            String gender = memberInfoEntity.getGender();
            String str6 = gender == null ? "" : gender;
            String phoneNumber = memberInfoEntity.getPhoneNumber();
            return new MemberInfoResult(str, str2, str3, str4, str5, str6, phoneNumber == null ? "" : phoneNumber);
        }
        return new MemberInfoResult(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, id.dana.domain.nearbyme.model.MoneyView, kotlin.jvm.internal.DefaultConstructorMarker] */
    private static final LimitInfoResult toLimitInfoResult(LimitInfoEntity limitInfoEntity) {
        if (limitInfoEntity != null) {
            List<String> useCases = limitInfoEntity.getUseCases();
            if (useCases == null) {
                useCases = CollectionsKt.emptyList();
            }
            return new LimitInfoResult(useCases, MoneyViewEntityMapperKt.toMoneyView(limitInfoEntity.getAmount()));
        }
        ?? r0 = 0;
        return new LimitInfoResult(r0, r0, 3, r0);
    }
}
