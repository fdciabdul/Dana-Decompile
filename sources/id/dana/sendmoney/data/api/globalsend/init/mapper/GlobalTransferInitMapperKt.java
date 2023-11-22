package id.dana.sendmoney.data.api.globalsend.init.mapper;

import id.dana.data.model.CurrencyAmountResult;
import id.dana.domain.user.CurrencyAmount;
import id.dana.sendmoney.data.api.globalsend.init.model.CurrencyRateEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.SubTransferMethodInfoEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.TransferUserInfoEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.request.GlobalTransferInitRequestEntity;
import id.dana.sendmoney.data.api.globalsend.init.model.response.GlobalTransferInitResultEntity;
import id.dana.sendmoney.domain.globalsend.model.init.CurrencyRate;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitRequest;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult;
import id.dana.sendmoney.domain.globalsend.model.init.SubTransferMethodInfo;
import id.dana.sendmoney.domain.globalsend.model.init.TransferUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\b*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000f\u001a\u00020\u000e*\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0018\u001a\u00020\u0017*\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001c\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0010"}, d2 = {"Lid/dana/data/model/CurrencyAmountResult;", "Lid/dana/domain/user/CurrencyAmount;", "getAmount", "(Lid/dana/data/model/CurrencyAmountResult;)Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;", "Lid/dana/sendmoney/domain/globalsend/model/init/CurrencyRate;", "getCurrencyRate", "(Lid/dana/sendmoney/data/api/globalsend/init/model/CurrencyRateEntity;)Lid/dana/sendmoney/domain/globalsend/model/init/CurrencyRate;", "", "Lid/dana/sendmoney/data/api/globalsend/init/model/SubTransferMethodInfoEntity;", "Lid/dana/sendmoney/domain/globalsend/model/init/SubTransferMethodInfo;", "getSubTransferMethodInfo", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;", "Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;", "getTransferUserInfo", "(Lid/dana/sendmoney/data/api/globalsend/init/model/TransferUserInfoEntity;)Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;", "toCurrencyRate", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;", "toGlobalTransferInitRequestEntity", "(Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;)Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;", "toGlobalTransferInitResult", "(Lid/dana/sendmoney/data/api/globalsend/init/model/response/GlobalTransferInitResultEntity;)Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;", "toSubTransferMethodInfo", "(Lid/dana/sendmoney/data/api/globalsend/init/model/SubTransferMethodInfoEntity;)Lid/dana/sendmoney/domain/globalsend/model/init/SubTransferMethodInfo;", "toTransferUserInfo"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitMapperKt {
    public static final GlobalTransferInitResult toGlobalTransferInitResult(GlobalTransferInitResultEntity globalTransferInitResultEntity) {
        Intrinsics.checkNotNullParameter(globalTransferInitResultEntity, "");
        return new GlobalTransferInitResult(getAmount(globalTransferInitResultEntity.getMinAmount()), getAmount(globalTransferInitResultEntity.getMaxAmount()), getAmount(globalTransferInitResultEntity.getFeeAmount()), getSubTransferMethodInfo(globalTransferInitResultEntity.getSubTransferMethodInfos()), getTransferUserInfo(globalTransferInitResultEntity.getPayerUserInfo()), getTransferUserInfo(globalTransferInitResultEntity.getPayeeUserInfo()));
    }

    private static final SubTransferMethodInfo toSubTransferMethodInfo(SubTransferMethodInfoEntity subTransferMethodInfoEntity) {
        CurrencyRate currencyRate = getCurrencyRate(subTransferMethodInfoEntity.getRateAmount());
        String subTransferMethodType = subTransferMethodInfoEntity.getSubTransferMethodType();
        String str = subTransferMethodType == null ? "" : subTransferMethodType;
        String payChannelApi = subTransferMethodInfoEntity.getPayChannelApi();
        String str2 = payChannelApi == null ? "" : payChannelApi;
        String instId = subTransferMethodInfoEntity.getInstId();
        String str3 = instId == null ? "" : instId;
        String instLocalName = subTransferMethodInfoEntity.getInstLocalName();
        String str4 = instLocalName == null ? "" : instLocalName;
        String payMethod = subTransferMethodInfoEntity.getPayMethod();
        String str5 = payMethod == null ? "" : payMethod;
        String payOption = subTransferMethodInfoEntity.getPayOption();
        String str6 = payOption == null ? "" : payOption;
        CurrencyAmount amount = getAmount(subTransferMethodInfoEntity.getPayerMinAmount());
        CurrencyAmount amount2 = getAmount(subTransferMethodInfoEntity.getPayerMaxAmount());
        Boolean maintenance = subTransferMethodInfoEntity.getMaintenance();
        return new SubTransferMethodInfo(currencyRate, str, str2, str3, str4, str5, str6, amount, amount2, maintenance != null ? maintenance.booleanValue() : false);
    }

    private static final CurrencyRate getCurrencyRate(CurrencyRateEntity currencyRateEntity) {
        CurrencyRate currencyRate;
        return (currencyRateEntity == null || (currencyRate = toCurrencyRate(currencyRateEntity)) == null) ? new CurrencyRate(null, null, null, null, 15, null) : currencyRate;
    }

    private static final CurrencyRate toCurrencyRate(CurrencyRateEntity currencyRateEntity) {
        CurrencyAmount amount = getAmount(currencyRateEntity.getSourceAmount());
        CurrencyAmount amount2 = getAmount(currencyRateEntity.getDestinationAmount());
        String destinationAmountCent = currencyRateEntity.getDestinationAmountCent();
        if (destinationAmountCent == null) {
            destinationAmountCent = "";
        }
        String sourceAmountCent = currencyRateEntity.getSourceAmountCent();
        return new CurrencyRate(amount, amount2, destinationAmountCent, sourceAmountCent != null ? sourceAmountCent : "");
    }

    private static final TransferUserInfo getTransferUserInfo(TransferUserInfoEntity transferUserInfoEntity) {
        TransferUserInfo transferUserInfo;
        return (transferUserInfoEntity == null || (transferUserInfo = toTransferUserInfo(transferUserInfoEntity)) == null) ? new TransferUserInfo(null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, false, false, 524287, null) : transferUserInfo;
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
        CurrencyAmount amount = getAmount(transferUserInfoEntity.getBalanceAmount());
        CurrencyAmount amount2 = getAmount(transferUserInfoEntity.getMaxBalanceAmount());
        CurrencyAmount amount3 = getAmount(transferUserInfoEntity.getMonthFundInConsumedAmount());
        CurrencyAmount amount4 = getAmount(transferUserInfoEntity.getMaxMonthFundInAmount());
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
        return new TransferUserInfo(str, str2, str3, str4, str5, str6, booleanValue, amount, amount2, amount3, amount4, str7, str8, str9, str10, str11, str12, booleanValue2, accountFrozen != null ? accountFrozen.booleanValue() : false);
    }

    private static final List<SubTransferMethodInfo> getSubTransferMethodInfo(List<SubTransferMethodInfoEntity> list) {
        if (list != null) {
            List<SubTransferMethodInfoEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toSubTransferMethodInfo((SubTransferMethodInfoEntity) it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private static final CurrencyAmount getAmount(CurrencyAmountResult currencyAmountResult) {
        CurrencyAmount currencyAmount = currencyAmountResult != null ? currencyAmountResult.toCurrencyAmount() : null;
        return currencyAmount == null ? new CurrencyAmount("", "") : currencyAmount;
    }

    public static final GlobalTransferInitRequestEntity toGlobalTransferInitRequestEntity(GlobalTransferInitRequest globalTransferInitRequest) {
        Intrinsics.checkNotNullParameter(globalTransferInitRequest, "");
        return new GlobalTransferInitRequestEntity(globalTransferInitRequest.PlaceComponentResult, globalTransferInitRequest.BuiltInFictitiousFunctionClassFactory, globalTransferInitRequest.getKClassImpl$Data$declaredNonStaticMembers$2(), null, null, null, null, 120, null);
    }
}
