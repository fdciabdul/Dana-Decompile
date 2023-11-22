package id.dana.sendmoney.data.api.globalsend.validate.mapper;

import id.dana.sendmoney.data.api.globalsend.validate.model.BeneficiaryInfoEntity;
import id.dana.sendmoney.domain.globalsend.model.validate.BeneficiaryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "toBeneficiaryInfo", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;)Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "toBeneficiaryInfoEntity", "(Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;)Lid/dana/sendmoney/data/api/globalsend/validate/model/BeneficiaryInfoEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeneficiaryInfoEntityMapperKt {
    public static final BeneficiaryInfo toBeneficiaryInfo(BeneficiaryInfoEntity beneficiaryInfoEntity) {
        Intrinsics.checkNotNullParameter(beneficiaryInfoEntity, "");
        String beneficiaryId = beneficiaryInfoEntity.getBeneficiaryId();
        String str = beneficiaryId == null ? "" : beneficiaryId;
        String firstName = beneficiaryInfoEntity.getFirstName();
        String str2 = firstName == null ? "" : firstName;
        String lastName = beneficiaryInfoEntity.getLastName();
        String str3 = lastName == null ? "" : lastName;
        String emailAddress = beneficiaryInfoEntity.getEmailAddress();
        String str4 = emailAddress == null ? "" : emailAddress;
        String address = beneficiaryInfoEntity.getAddress();
        String str5 = address == null ? "" : address;
        String country = beneficiaryInfoEntity.getCountry();
        String str6 = country == null ? "" : country;
        String state = beneficiaryInfoEntity.getState();
        String str7 = state == null ? "" : state;
        String city = beneficiaryInfoEntity.getCity();
        String str8 = city == null ? "" : city;
        String postalCode = beneficiaryInfoEntity.getPostalCode();
        String str9 = postalCode == null ? "" : postalCode;
        String phoneNumber = beneficiaryInfoEntity.getPhoneNumber();
        String str10 = phoneNumber == null ? "" : phoneNumber;
        String bankName = beneficiaryInfoEntity.getBankName();
        String str11 = bankName == null ? "" : bankName;
        String bankCode = beneficiaryInfoEntity.getBankCode();
        String str12 = bankCode == null ? "" : bankCode;
        String cardIndexNo = beneficiaryInfoEntity.getCardIndexNo();
        String str13 = cardIndexNo == null ? "" : cardIndexNo;
        String maskedCardNo = beneficiaryInfoEntity.getMaskedCardNo();
        String str14 = maskedCardNo == null ? "" : maskedCardNo;
        String formattedHolderName = beneficiaryInfoEntity.getFormattedHolderName();
        String str15 = formattedHolderName == null ? "" : formattedHolderName;
        String accountType = beneficiaryInfoEntity.getAccountType();
        String str16 = accountType == null ? "" : accountType;
        String routingNo = beneficiaryInfoEntity.getRoutingNo();
        String str17 = routingNo == null ? "" : routingNo;
        String externalSystemId = beneficiaryInfoEntity.getExternalSystemId();
        String str18 = externalSystemId == null ? "" : externalSystemId;
        String payMethod = beneficiaryInfoEntity.getPayMethod();
        String str19 = payMethod == null ? "" : payMethod;
        String payOption = beneficiaryInfoEntity.getPayOption();
        String str20 = payOption == null ? "" : payOption;
        String instLocalName = beneficiaryInfoEntity.getInstLocalName();
        String str21 = instLocalName == null ? "" : instLocalName;
        String withdrawInstId = beneficiaryInfoEntity.getWithdrawInstId();
        String str22 = withdrawInstId == null ? "" : withdrawInstId;
        String currency = beneficiaryInfoEntity.getCurrency();
        String str23 = currency == null ? "" : currency;
        Long gmtCreated = beneficiaryInfoEntity.getGmtCreated();
        long longValue = gmtCreated != null ? gmtCreated.longValue() : 0L;
        Long gmtModified = beneficiaryInfoEntity.getGmtModified();
        long longValue2 = gmtModified != null ? gmtModified.longValue() : 0L;
        String transferMethod = beneficiaryInfoEntity.getTransferMethod();
        if (transferMethod == null) {
            transferMethod = "";
        }
        String subTransferMethod = beneficiaryInfoEntity.getSubTransferMethod();
        return new BeneficiaryInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, longValue, longValue2, transferMethod, subTransferMethod != null ? subTransferMethod : "");
    }

    public static final BeneficiaryInfoEntity toBeneficiaryInfoEntity(BeneficiaryInfo beneficiaryInfo) {
        Intrinsics.checkNotNullParameter(beneficiaryInfo, "");
        String str = beneficiaryInfo.BuiltInFictitiousFunctionClassFactory;
        if (str.length() == 0) {
            str = null;
        }
        String str2 = str;
        String str3 = beneficiaryInfo.initRecordTimeStamp;
        if (str3.length() == 0) {
            str3 = null;
        }
        String str4 = str3;
        String str5 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (str5.length() == 0) {
            str5 = null;
        }
        String str6 = str5;
        String str7 = beneficiaryInfo.lookAheadTest;
        if (str7.length() == 0) {
            str7 = null;
        }
        String str8 = str7;
        String str9 = beneficiaryInfo.MyBillsEntityDataFactory;
        if (str9.length() == 0) {
            str9 = null;
        }
        String str10 = str9;
        String str11 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str11.length() == 0) {
            str11 = null;
        }
        String str12 = str11;
        String str13 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (str13.length() == 0) {
            str13 = null;
        }
        String str14 = str13;
        String str15 = beneficiaryInfo.moveToNextValue;
        if (str15.length() == 0) {
            str15 = null;
        }
        String str16 = str15;
        String str17 = beneficiaryInfo.FragmentBottomSheetPaymentSettingBinding;
        if (str17.length() == 0) {
            str17 = null;
        }
        String str18 = str17;
        String str19 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (str19.length() == 0) {
            str19 = null;
        }
        String str20 = str19;
        String str21 = beneficiaryInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str21.length() == 0) {
            str21 = null;
        }
        String str22 = str21;
        String str23 = beneficiaryInfo.getAuthRequestContext;
        if (str23.length() == 0) {
            str23 = null;
        }
        String str24 = str23;
        String str25 = beneficiaryInfo.scheduleImpl;
        if (str25.length() == 0) {
            str25 = null;
        }
        String str26 = str25;
        String str27 = beneficiaryInfo.newProxyInstance;
        if (str27.length() == 0) {
            str27 = null;
        }
        String str28 = str27;
        String str29 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (str29.length() == 0) {
            str29 = null;
        }
        String str30 = str29;
        String str31 = beneficiaryInfo.PlaceComponentResult;
        if (str31.length() == 0) {
            str31 = null;
        }
        String str32 = str31;
        String str33 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (str33.length() == 0) {
            str33 = null;
        }
        String str34 = str33;
        String str35 = beneficiaryInfo.GetContactSyncConfig;
        if (str35.length() == 0) {
            str35 = null;
        }
        String str36 = str35;
        String str37 = beneficiaryInfo.isLayoutRequested;
        if (str37.length() == 0) {
            str37 = null;
        }
        String str38 = str37;
        String str39 = beneficiaryInfo.PrepareContext;
        if (str39.length() == 0) {
            str39 = null;
        }
        String str40 = str39;
        String str41 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (str41.length() == 0) {
            str41 = null;
        }
        String str42 = str41;
        String str43 = beneficiaryInfo.getCallingPid;
        if (str43.length() == 0) {
            str43 = null;
        }
        String str44 = str43;
        String str45 = beneficiaryInfo.getErrorConfigVersion;
        if (str45.length() == 0) {
            str45 = null;
        }
        String str46 = str45;
        String str47 = beneficiaryInfo.readMicros;
        if (str47.length() == 0) {
            str47 = null;
        }
        String str48 = str47;
        String str49 = beneficiaryInfo.NetworkUserEntityData$$ExternalSyntheticLambda5;
        return new BeneficiaryInfoEntity(str2, str4, str6, str8, str10, str12, str14, str16, str18, str20, str22, str24, str26, str28, str30, str32, str34, str36, str38, str40, str42, str44, str46, null, null, str48, str49.length() == 0 ? null : str49);
    }
}
