package id.dana.sendmoney.data.api.core.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.sendmoney.data.api.core.model.TransferParticipantEntity;
import id.dana.sendmoney.data.api.core.model.TransferUserInfoEntity;
import id.dana.sendmoney.data.api.core.model.request.TransferInitRequestEntity;
import id.dana.sendmoney.data.api.core.model.response.TransferInitResultEntity;
import id.dana.sendmoney.domain.core.model.init.TransferInitRequest;
import id.dana.sendmoney.domain.core.model.init.TransferInitResult;
import id.dana.sendmoney.domain.core.model.init.TransferParticipant;
import id.dana.sendmoney.domain.core.model.init.TransferUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;", "Lid/dana/sendmoney/data/api/core/model/request/TransferInitRequestEntity;", "toTransferInitRequestEntity", "(Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;)Lid/dana/sendmoney/data/api/core/model/request/TransferInitRequestEntity;", "Lid/dana/sendmoney/data/api/core/model/response/TransferInitResultEntity;", "Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "toTransferInitResult", "(Lid/dana/sendmoney/data/api/core/model/response/TransferInitResultEntity;)Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "Lid/dana/sendmoney/domain/core/model/init/TransferParticipant;", "Lid/dana/sendmoney/data/api/core/model/TransferParticipantEntity;", "toTransferParticipantEntity", "(Lid/dana/sendmoney/domain/core/model/init/TransferParticipant;)Lid/dana/sendmoney/data/api/core/model/TransferParticipantEntity;", "Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;", "Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;", "toTransferUserInfo", "(Lid/dana/sendmoney/data/api/core/model/TransferUserInfoEntity;)Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferInitEntityMapperKt {
    public static final TransferInitResult toTransferInitResult(TransferInitResultEntity transferInitResultEntity) {
        TransferUserInfo transferUserInfo;
        TransferUserInfo transferUserInfo2;
        Intrinsics.checkNotNullParameter(transferInitResultEntity, "");
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(transferInitResultEntity.getMinAmount());
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(transferInitResultEntity.getMaxAmount());
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(transferInitResultEntity.getFeeAmount());
        TransferUserInfoEntity payerUserInfo = transferInitResultEntity.getPayerUserInfo();
        TransferUserInfo transferUserInfo3 = (payerUserInfo == null || (transferUserInfo2 = toTransferUserInfo(payerUserInfo)) == null) ? new TransferUserInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null) : transferUserInfo2;
        TransferUserInfoEntity payeeUserInfo = transferInitResultEntity.getPayeeUserInfo();
        return new TransferInitResult(moneyView, moneyView2, moneyView3, transferUserInfo3, (payeeUserInfo == null || (transferUserInfo = toTransferUserInfo(payeeUserInfo)) == null) ? new TransferUserInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null) : transferUserInfo);
    }

    private static final TransferUserInfo toTransferUserInfo(TransferUserInfoEntity transferUserInfoEntity) {
        String userId = transferUserInfoEntity.getUserId();
        String str = userId == null ? "" : userId;
        String maskedLoginId = transferUserInfoEntity.getMaskedLoginId();
        String str2 = maskedLoginId == null ? "" : maskedLoginId;
        String maskedNickName = transferUserInfoEntity.getMaskedNickName();
        String str3 = maskedNickName == null ? "" : maskedNickName;
        String nickName = transferUserInfoEntity.getNickName();
        String str4 = nickName == null ? "" : nickName;
        String kycLevel = transferUserInfoEntity.getKycLevel();
        String str5 = kycLevel == null ? "" : kycLevel;
        String internalKycLevel = transferUserInfoEntity.getInternalKycLevel();
        String str6 = internalKycLevel == null ? "" : internalKycLevel;
        Boolean certified = transferUserInfoEntity.getCertified();
        boolean booleanValue = certified != null ? certified.booleanValue() : false;
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(transferUserInfoEntity.getBalanceAmount());
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(transferUserInfoEntity.getMaxBalanceAmount());
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(transferUserInfoEntity.getMonthFundInConsumedAmount());
        MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(transferUserInfoEntity.getMaxMonthFundInAmount());
        String avatar = transferUserInfoEntity.getAvatar();
        String str7 = avatar == null ? "" : avatar;
        String name = transferUserInfoEntity.getName();
        String str8 = name == null ? "" : name;
        String phoneNumber = transferUserInfoEntity.getPhoneNumber();
        String str9 = phoneNumber == null ? "" : phoneNumber;
        String instId = transferUserInfoEntity.getInstId();
        String str10 = instId == null ? "" : instId;
        String instName = transferUserInfoEntity.getInstName();
        String str11 = instName == null ? "" : instName;
        String maskedAccountNo = transferUserInfoEntity.getMaskedAccountNo();
        String str12 = maskedAccountNo == null ? "" : maskedAccountNo;
        Boolean userFrozen = transferUserInfoEntity.getUserFrozen();
        boolean booleanValue2 = userFrozen != null ? userFrozen.booleanValue() : false;
        Boolean accountFrozen = transferUserInfoEntity.getAccountFrozen();
        boolean booleanValue3 = accountFrozen != null ? accountFrozen.booleanValue() : false;
        String accountSuspiciousScore = transferUserInfoEntity.getAccountSuspiciousScore();
        String str13 = accountSuspiciousScore == null ? "" : accountSuspiciousScore;
        Boolean accountBlackListed = transferUserInfoEntity.getAccountBlackListed();
        return new TransferUserInfo(str, str2, str3, str4, str5, str6, Boolean.valueOf(booleanValue), moneyView, moneyView2, moneyView3, moneyView4, str7, str8, str9, str10, str11, str12, Boolean.valueOf(booleanValue2), Boolean.valueOf(booleanValue3), str13, Boolean.valueOf(accountBlackListed != null ? accountBlackListed.booleanValue() : false), MoneyViewEntityMapperKt.toMoneyView(transferUserInfoEntity.getMaxTrxAmount()));
    }

    public static final TransferInitRequestEntity toTransferInitRequestEntity(TransferInitRequest transferInitRequest) {
        Intrinsics.checkNotNullParameter(transferInitRequest, "");
        String str = transferInitRequest.MyBillsEntityDataFactory;
        String str2 = transferInitRequest.BuiltInFictitiousFunctionClassFactory;
        Boolean bool = transferInitRequest.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = transferInitRequest.moveToNextValue;
        String str4 = transferInitRequest.scheduleImpl;
        String str5 = transferInitRequest.PlaceComponentResult;
        TransferParticipant transferParticipant = transferInitRequest.getAuthRequestContext;
        return new TransferInitRequestEntity(str, str2, bool, str3, str4, str5, transferParticipant != null ? toTransferParticipantEntity(transferParticipant) : null);
    }

    public static final TransferParticipantEntity toTransferParticipantEntity(TransferParticipant transferParticipant) {
        Intrinsics.checkNotNullParameter(transferParticipant, "");
        return new TransferParticipantEntity(transferParticipant.moveToNextValue, transferParticipant.BuiltInFictitiousFunctionClassFactory, transferParticipant.getErrorConfigVersion, transferParticipant.MyBillsEntityDataFactory, transferParticipant.PlaceComponentResult, transferParticipant.lookAheadTest, transferParticipant.scheduleImpl, transferParticipant.KClassImpl$Data$declaredNonStaticMembers$2, transferParticipant.getAuthRequestContext);
    }
}
