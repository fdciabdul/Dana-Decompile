package id.dana.familyaccount.mapper;

import id.dana.domain.familyaccount.model.DashboardFamilyAccountResult;
import id.dana.domain.familyaccount.model.FamilyAccountMemberInfoResult;
import id.dana.domain.familyaccount.model.FamilyTopUpConsult;
import id.dana.domain.familyaccount.model.LimitInfoResult;
import id.dana.domain.familyaccount.model.MemberInfoResult;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.familyaccount.model.DashboardModel;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.familyaccount.model.MemberInfoModel;
import id.dana.familyaccount.model.TopUpUserConsultModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import id.dana.statement.model.UserStatementModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;", "Lid/dana/familyaccount/model/DashboardModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/familyaccount/model/DashboardFamilyAccountResult;)Lid/dana/familyaccount/model/DashboardModel;", "Lid/dana/domain/familyaccount/model/FamilyTopUpConsult;", "Lid/dana/familyaccount/model/TopUpUserConsultModel;", "PlaceComponentResult", "(Lid/dana/domain/familyaccount/model/FamilyTopUpConsult;)Lid/dana/familyaccount/model/TopUpUserConsultModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DashboardFamilyAccountResultMapperKt {
    public static final DashboardModel KClassImpl$Data$declaredNonStaticMembers$2(DashboardFamilyAccountResult dashboardFamilyAccountResult) {
        Intrinsics.checkNotNullParameter(dashboardFamilyAccountResult, "");
        String status = dashboardFamilyAccountResult.getStatus();
        MoneyViewModel authRequestContext = MoneyViewModelKt.getAuthRequestContext(dashboardFamilyAccountResult.getBalance());
        List<FamilyAccountMemberInfoResult> sharedAccountMemberInfoList = dashboardFamilyAccountResult.getSharedAccountMemberInfoList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sharedAccountMemberInfoList, 10));
        for (FamilyAccountMemberInfoResult familyAccountMemberInfoResult : sharedAccountMemberInfoList) {
            Intrinsics.checkNotNullParameter(familyAccountMemberInfoResult, "");
            String organizerUserId = familyAccountMemberInfoResult.getOrganizerUserId();
            MemberInfoResult member = familyAccountMemberInfoResult.getMember();
            MemberInfoModel memberInfoModel = new MemberInfoModel(member.getUserId(), member.getNickname(), member.getCertName(), member.getCertifyLevel(), member.getAvatarUrl(), member.getGender(), member.getPhoneNumber());
            String invitationStatus = familyAccountMemberInfoResult.getInvitationStatus();
            String invitationId = familyAccountMemberInfoResult.getInvitationId();
            LimitInfoResult limitInfo = familyAccountMemberInfoResult.getLimitInfo();
            arrayList.add(new FamilyMemberInfoModel(organizerUserId, memberInfoModel, invitationStatus, invitationId, new LimitInfoModel(limitInfo.getUseCases(), MoneyViewModelKt.getAuthRequestContext(limitInfo.getAmount()))));
        }
        return new DashboardModel(status, authRequestContext, arrayList);
    }

    public static final TopUpUserConsultModel PlaceComponentResult(FamilyTopUpConsult familyTopUpConsult) {
        Intrinsics.checkNotNullParameter(familyTopUpConsult, "");
        MoneyView minAmount = familyTopUpConsult.getTopUpUserConsultResult().getMinAmount();
        MoneyViewModel authRequestContext = minAmount != null ? MoneyViewModelKt.getAuthRequestContext(minAmount) : null;
        MoneyView maxAmount = familyTopUpConsult.getTopUpUserConsultResult().getMaxAmount();
        MoneyViewModel authRequestContext2 = maxAmount != null ? MoneyViewModelKt.getAuthRequestContext(maxAmount) : null;
        List<PayMethodView> payMethodView = familyTopUpConsult.getTopUpUserConsultResult().getPayMethodView();
        MoneyView maxBalanceAmount = familyTopUpConsult.getTopUpUserConsultResult().getMaxBalanceAmount();
        MoneyViewModel authRequestContext3 = maxBalanceAmount != null ? MoneyViewModelKt.getAuthRequestContext(maxBalanceAmount) : null;
        MoneyView maxMonthFundInAmount = familyTopUpConsult.getTopUpUserConsultResult().getMaxMonthFundInAmount();
        return new TopUpUserConsultModel(authRequestContext, authRequestContext2, payMethodView, authRequestContext3, maxMonthFundInAmount != null ? MoneyViewModelKt.getAuthRequestContext(maxMonthFundInAmount) : null, UserStatementModelKt.PlaceComponentResult(familyTopUpConsult.getBalance()));
    }
}
