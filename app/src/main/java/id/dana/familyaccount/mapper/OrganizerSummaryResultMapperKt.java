package id.dana.familyaccount.mapper;

import id.dana.domain.familyaccount.model.PayeeUserInfo;
import id.dana.domain.familyaccount.model.PayerUserInfo;
import id.dana.domain.familyaccount.model.SummaryResult;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.familyaccount.model.PayeeUserInfoModel;
import id.dana.familyaccount.model.PayerUserInfoModel;
import id.dana.familyaccount.model.SummaryModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/familyaccount/model/SummaryResult;", "Lid/dana/familyaccount/model/SummaryModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/familyaccount/model/SummaryResult;)Lid/dana/familyaccount/model/SummaryModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerSummaryResultMapperKt {
    public static final SummaryModel BuiltInFictitiousFunctionClassFactory(SummaryResult summaryResult) {
        PayerUserInfoModel payerUserInfoModel;
        PayeeUserInfoModel payeeUserInfoModel;
        Intrinsics.checkNotNullParameter(summaryResult, "");
        MoneyView fundAmount = summaryResult.getFundAmount();
        MoneyViewModel authRequestContext = fundAmount != null ? MoneyViewModelKt.getAuthRequestContext(fundAmount) : null;
        Long completedTime = summaryResult.getCompletedTime();
        Boolean enableToClaim = summaryResult.getEnableToClaim();
        Long paidTime = summaryResult.getPaidTime();
        PayerUserInfo payerUserInfo = summaryResult.getPayerUserInfo();
        if (payerUserInfo != null) {
            Intrinsics.checkNotNullParameter(payerUserInfo, "");
            payerUserInfoModel = new PayerUserInfoModel(payerUserInfo.getKycLevel(), payerUserInfo.getPhoneNumber(), payerUserInfo.getNickName(), payerUserInfo.getCertified(), payerUserInfo.getAvatar(), payerUserInfo.getUserId());
        } else {
            payerUserInfoModel = null;
        }
        String token = summaryResult.getToken();
        String fundType = summaryResult.getFundType();
        MoneyView balanceFamily = summaryResult.getBalanceFamily();
        MoneyViewModel authRequestContext2 = balanceFamily != null ? MoneyViewModelKt.getAuthRequestContext(balanceFamily) : null;
        Long createdTime = summaryResult.getCreatedTime();
        String status = summaryResult.getStatus();
        String shareLink = summaryResult.getShareLink();
        PayeeUserInfo payeeUserInfo = summaryResult.getPayeeUserInfo();
        if (payeeUserInfo != null) {
            Intrinsics.checkNotNullParameter(payeeUserInfo, "");
            payeeUserInfoModel = new PayeeUserInfoModel(payeeUserInfo.getKycLevel(), payeeUserInfo.getPhoneNumber(), payeeUserInfo.getNickName(), payeeUserInfo.getCertified(), payeeUserInfo.getAvatar(), payeeUserInfo.getUserId(), payeeUserInfo.getInstId(), payeeUserInfo.getInstName(), payeeUserInfo.getMaskedNickName(), payeeUserInfo.getMaskedAccountNo());
        } else {
            payeeUserInfoModel = null;
        }
        MoneyView chargeAmount = summaryResult.getChargeAmount();
        MoneyViewModel authRequestContext3 = chargeAmount != null ? MoneyViewModelKt.getAuthRequestContext(chargeAmount) : null;
        String remarks = summaryResult.getRemarks();
        MoneyView paidTotalAmount = summaryResult.getPaidTotalAmount();
        return new SummaryModel(authRequestContext, completedTime, enableToClaim, paidTime, payerUserInfoModel, token, fundType, authRequestContext2, createdTime, status, shareLink, payeeUserInfoModel, authRequestContext3, remarks, paidTotalAmount != null ? MoneyViewModelKt.getAuthRequestContext(paidTotalAmount) : null);
    }
}
