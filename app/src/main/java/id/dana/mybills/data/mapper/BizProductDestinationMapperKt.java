package id.dana.mybills.data.mapper;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.data.model.response.BizCenterResultInfo;
import id.dana.mybills.data.model.response.DigitalDestinationInquiryInfo;
import id.dana.mybills.data.model.response.InquiryBizDestinationResult;
import id.dana.mybills.data.model.response.InquiryStatus;
import id.dana.mybills.data.model.response.MultiCurrencyMoney;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0003*\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/mybills/data/model/response/DigitalDestinationInquiryInfo;", "Lid/dana/mybills/data/model/response/BizCenterResultInfo;", "p0", "Lid/dana/mybills/domain/model/BizProductDestination;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/response/DigitalDestinationInquiryInfo;Lid/dana/mybills/data/model/response/BizCenterResultInfo;)Lid/dana/mybills/domain/model/BizProductDestination;", "Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;)Lid/dana/mybills/domain/model/BizProductDestination;", "Lid/dana/mybills/data/model/response/MultiCurrencyMoney;", "Lid/dana/domain/nearbyme/model/MoneyView;", "PlaceComponentResult", "(Lid/dana/mybills/data/model/response/MultiCurrencyMoney;)Lid/dana/domain/nearbyme/model/MoneyView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductDestinationMapperKt {
    public static final BizProductDestination BuiltInFictitiousFunctionClassFactory(InquiryBizDestinationResult inquiryBizDestinationResult) {
        BizProductDestination copy;
        Intrinsics.checkNotNullParameter(inquiryBizDestinationResult, "");
        List<DigitalDestinationInquiryInfo> destinationInquiryDetails = inquiryBizDestinationResult.getDestinationInquiryDetails();
        DigitalDestinationInquiryInfo digitalDestinationInquiryInfo = destinationInquiryDetails != null ? (DigitalDestinationInquiryInfo) CollectionsKt.firstOrNull((List) destinationInquiryDetails) : null;
        List<DigitalDestinationInquiryInfo> digitalDestinationInquiryInfos = inquiryBizDestinationResult.getDigitalDestinationInquiryInfos();
        DigitalDestinationInquiryInfo digitalDestinationInquiryInfo2 = digitalDestinationInquiryInfos != null ? (DigitalDestinationInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos) : null;
        if (digitalDestinationInquiryInfo == null) {
            if (digitalDestinationInquiryInfo2 != null) {
                return MyBillsEntityDataFactory(digitalDestinationInquiryInfo2, inquiryBizDestinationResult.getBizCenterResultInfo());
            }
            return new BizProductDestination(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2097151, null);
        }
        BizProductDestination MyBillsEntityDataFactory = MyBillsEntityDataFactory(digitalDestinationInquiryInfo, inquiryBizDestinationResult.getBizCenterResultInfo());
        String inquiryStatus = MyBillsEntityDataFactory.getInquiryStatus();
        if (inquiryStatus == null || StringsKt.isBlank(inquiryStatus)) {
            copy = MyBillsEntityDataFactory.copy((r77 & 1) != 0 ? MyBillsEntityDataFactory.billId : null, (r77 & 2) != 0 ? MyBillsEntityDataFactory.totalAmount : null, (r77 & 4) != 0 ? MyBillsEntityDataFactory.adminFee : null, (r77 & 8) != 0 ? MyBillsEntityDataFactory.baseAmount : null, (r77 & 16) != 0 ? MyBillsEntityDataFactory.fineAmount : null, (r77 & 32) != 0 ? MyBillsEntityDataFactory.billCycle : null, (r77 & 64) != 0 ? MyBillsEntityDataFactory.customerName : null, (r77 & 128) != 0 ? MyBillsEntityDataFactory.customerType : null, (r77 & 256) != 0 ? MyBillsEntityDataFactory.dateTime : null, (r77 & 512) != 0 ? MyBillsEntityDataFactory.description : null, (r77 & 1024) != 0 ? MyBillsEntityDataFactory.dueDate : null, (r77 & 2048) != 0 ? MyBillsEntityDataFactory.paymentCount : null, (r77 & 4096) != 0 ? MyBillsEntityDataFactory.payPartialSupport : null, (r77 & 8192) != 0 ? MyBillsEntityDataFactory.familyNumber : null, (r77 & 16384) != 0 ? MyBillsEntityDataFactory.familyCount : null, (r77 & 32768) != 0 ? MyBillsEntityDataFactory.policeNumber : null, (r77 & 65536) != 0 ? MyBillsEntityDataFactory.address : null, (r77 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? MyBillsEntityDataFactory.standMeter : null, (r77 & 262144) != 0 ? MyBillsEntityDataFactory.load : null, (r77 & 524288) != 0 ? MyBillsEntityDataFactory.tagNonAir : null, (r77 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? MyBillsEntityDataFactory.amount : null, (r77 & 2097152) != 0 ? MyBillsEntityDataFactory.meterNumber : null, (r77 & 4194304) != 0 ? MyBillsEntityDataFactory.fare : null, (r77 & 8388608) != 0 ? MyBillsEntityDataFactory.totalEnergy : null, (r77 & 16777216) != 0 ? MyBillsEntityDataFactory.type : null, (r77 & 33554432) != 0 ? MyBillsEntityDataFactory.startDate : null, (r77 & 67108864) != 0 ? MyBillsEntityDataFactory.endDate : null, (r77 & 134217728) != 0 ? MyBillsEntityDataFactory.customerIdNumber : null, (r77 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? MyBillsEntityDataFactory.owned : null, (r77 & 536870912) != 0 ? MyBillsEntityDataFactory.brand : null, (r77 & 1073741824) != 0 ? MyBillsEntityDataFactory.model : null, (r77 & Integer.MIN_VALUE) != 0 ? MyBillsEntityDataFactory.machineNumber : null, (r78 & 1) != 0 ? MyBillsEntityDataFactory.frameNumber : null, (r78 & 2) != 0 ? MyBillsEntityDataFactory.yearOfProduction : null, (r78 & 4) != 0 ? MyBillsEntityDataFactory.newTaxExpirationDate : null, (r78 & 8) != 0 ? MyBillsEntityDataFactory.paymentReference : null, (r78 & 16) != 0 ? MyBillsEntityDataFactory.period : null, (r78 & 32) != 0 ? MyBillsEntityDataFactory.providerName : null, (r78 & 64) != 0 ? MyBillsEntityDataFactory.standBegin : null, (r78 & 128) != 0 ? MyBillsEntityDataFactory.standFinal : null, (r78 & 256) != 0 ? MyBillsEntityDataFactory.totalPeriod : null, (r78 & 512) != 0 ? MyBillsEntityDataFactory.usage : null, (r78 & 1024) != 0 ? MyBillsEntityDataFactory.extendInfo : null, (r78 & 2048) != 0 ? MyBillsEntityDataFactory.debtAmount : null, (r78 & 4096) != 0 ? MyBillsEntityDataFactory.currentNeedRepayAmount : null, (r78 & 8192) != 0 ? MyBillsEntityDataFactory.issueDate : null, (r78 & 16384) != 0 ? MyBillsEntityDataFactory.overdueDay : null, (r78 & 32768) != 0 ? MyBillsEntityDataFactory.repaymentDate : null, (r78 & 65536) != 0 ? MyBillsEntityDataFactory.repaymentMonth : null, (r78 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? MyBillsEntityDataFactory.repaidAmount : null, (r78 & 262144) != 0 ? MyBillsEntityDataFactory.inquiryStatus : "SUCCESS", (r78 & 524288) != 0 ? MyBillsEntityDataFactory.inquiryMessage : null, (r78 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? MyBillsEntityDataFactory.inquiryCode : "10");
            return copy;
        }
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final BizProductDestination MyBillsEntityDataFactory(DigitalDestinationInquiryInfo digitalDestinationInquiryInfo, BizCenterResultInfo bizCenterResultInfo) {
        MoneyView PlaceComponentResult;
        MoneyView PlaceComponentResult2;
        MoneyView PlaceComponentResult3;
        BizProductDestination copy;
        String str;
        BizProductDestination copy2;
        Object obj;
        MoneyViewEntity displayTotalAmount = digitalDestinationInquiryInfo.getDisplayTotalAmount();
        String amount = displayTotalAmount != null ? displayTotalAmount.getAmount() : null;
        MoneyView moneyView = !(amount == null || amount.length() == 0) ? MoneyViewEntityMapperKt.toMoneyView(digitalDestinationInquiryInfo.getDisplayTotalAmount()) : PlaceComponentResult(digitalDestinationInquiryInfo.getTotalAmount());
        MoneyViewEntity displayAdminFee = digitalDestinationInquiryInfo.getDisplayAdminFee();
        MultiCurrencyMoney adminFee = digitalDestinationInquiryInfo.getAdminFee();
        if (displayAdminFee == null || (PlaceComponentResult = MoneyViewEntityMapperKt.toMoneyView(displayAdminFee)) == null) {
            PlaceComponentResult = PlaceComponentResult(adminFee);
        }
        MoneyView moneyView2 = PlaceComponentResult;
        MoneyViewEntity displayBaseAmount = digitalDestinationInquiryInfo.getDisplayBaseAmount();
        MultiCurrencyMoney baseAmount = digitalDestinationInquiryInfo.getBaseAmount();
        if (displayBaseAmount == null || (PlaceComponentResult2 = MoneyViewEntityMapperKt.toMoneyView(displayBaseAmount)) == null) {
            PlaceComponentResult2 = PlaceComponentResult(baseAmount);
        }
        MoneyView moneyView3 = PlaceComponentResult2;
        MoneyViewEntity displayFineAmount = digitalDestinationInquiryInfo.getDisplayFineAmount();
        MultiCurrencyMoney fineAmount = digitalDestinationInquiryInfo.getFineAmount();
        if (displayFineAmount == null || (PlaceComponentResult3 = MoneyViewEntityMapperKt.toMoneyView(displayFineAmount)) == null) {
            PlaceComponentResult3 = PlaceComponentResult(fineAmount);
        }
        MoneyView moneyView4 = PlaceComponentResult3;
        String billCycle = digitalDestinationInquiryInfo.getBillCycle();
        String customerName = digitalDestinationInquiryInfo.getCustomerName();
        String customerType = digitalDestinationInquiryInfo.getCustomerType();
        String dateTime = digitalDestinationInquiryInfo.getDateTime();
        String description = digitalDestinationInquiryInfo.getDescription();
        Long dueDate = digitalDestinationInquiryInfo.getDueDate();
        Integer paymentCount = digitalDestinationInquiryInfo.getPaymentCount();
        Boolean payPartialSupport = digitalDestinationInquiryInfo.getPayPartialSupport();
        String familyNumber = digitalDestinationInquiryInfo.getFamilyNumber();
        String familyCount = digitalDestinationInquiryInfo.getFamilyCount();
        String policeNumber = digitalDestinationInquiryInfo.getPoliceNumber();
        String address = digitalDestinationInquiryInfo.getAddress();
        String standMeter = digitalDestinationInquiryInfo.getStandMeter();
        String load = digitalDestinationInquiryInfo.getLoad();
        MoneyViewEntity tagNonAir = digitalDestinationInquiryInfo.getTagNonAir();
        BizProductDestination bizProductDestination = new BizProductDestination("", moneyView, moneyView2, moneyView3, moneyView4, billCycle, customerName, customerType, dateTime, description, dueDate, paymentCount, payPartialSupport, familyNumber, familyCount, policeNumber, address, standMeter, load, tagNonAir != null ? MoneyViewEntityMapperKt.toMoneyView(tagNonAir) : null, digitalDestinationInquiryInfo.getAmount(), digitalDestinationInquiryInfo.getMeterNumber(), digitalDestinationInquiryInfo.getFare(), digitalDestinationInquiryInfo.getTotalEnergy(), digitalDestinationInquiryInfo.getType(), digitalDestinationInquiryInfo.getStartDate(), digitalDestinationInquiryInfo.getEndDate(), digitalDestinationInquiryInfo.getCustomerIdNumber(), digitalDestinationInquiryInfo.getOwned(), digitalDestinationInquiryInfo.getBrand(), digitalDestinationInquiryInfo.getModel(), digitalDestinationInquiryInfo.getMachineNumber(), digitalDestinationInquiryInfo.getFrameNumber(), digitalDestinationInquiryInfo.getYearOfProduction(), digitalDestinationInquiryInfo.getNewTaxExpirationDate(), null, digitalDestinationInquiryInfo.getPeriod(), digitalDestinationInquiryInfo.getProviderName(), null, null, null, digitalDestinationInquiryInfo.getUsage(), digitalDestinationInquiryInfo.getExtendInfo(), null, null, null, null, null, null, null, null, null, null, 0, 2095560, null);
        if (bizCenterResultInfo != null) {
            String resultMsg = bizCenterResultInfo.getResultMsg();
            try {
                Result.Companion companion = Result.INSTANCE;
                Map<String, Object> extendInfo = bizCenterResultInfo.getExtendInfo();
                obj = extendInfo != null ? extendInfo.get("message") : null;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                str = Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
            if (obj != null) {
                str = Result.m3179constructorimpl((String) obj);
                copy2 = bizProductDestination.copy((r77 & 1) != 0 ? bizProductDestination.billId : null, (r77 & 2) != 0 ? bizProductDestination.totalAmount : null, (r77 & 4) != 0 ? bizProductDestination.adminFee : null, (r77 & 8) != 0 ? bizProductDestination.baseAmount : null, (r77 & 16) != 0 ? bizProductDestination.fineAmount : null, (r77 & 32) != 0 ? bizProductDestination.billCycle : null, (r77 & 64) != 0 ? bizProductDestination.customerName : null, (r77 & 128) != 0 ? bizProductDestination.customerType : null, (r77 & 256) != 0 ? bizProductDestination.dateTime : null, (r77 & 512) != 0 ? bizProductDestination.description : null, (r77 & 1024) != 0 ? bizProductDestination.dueDate : null, (r77 & 2048) != 0 ? bizProductDestination.paymentCount : null, (r77 & 4096) != 0 ? bizProductDestination.payPartialSupport : null, (r77 & 8192) != 0 ? bizProductDestination.familyNumber : null, (r77 & 16384) != 0 ? bizProductDestination.familyCount : null, (r77 & 32768) != 0 ? bizProductDestination.policeNumber : null, (r77 & 65536) != 0 ? bizProductDestination.address : null, (r77 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? bizProductDestination.standMeter : null, (r77 & 262144) != 0 ? bizProductDestination.load : null, (r77 & 524288) != 0 ? bizProductDestination.tagNonAir : null, (r77 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? bizProductDestination.amount : null, (r77 & 2097152) != 0 ? bizProductDestination.meterNumber : null, (r77 & 4194304) != 0 ? bizProductDestination.fare : null, (r77 & 8388608) != 0 ? bizProductDestination.totalEnergy : null, (r77 & 16777216) != 0 ? bizProductDestination.type : null, (r77 & 33554432) != 0 ? bizProductDestination.startDate : null, (r77 & 67108864) != 0 ? bizProductDestination.endDate : null, (r77 & 134217728) != 0 ? bizProductDestination.customerIdNumber : null, (r77 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? bizProductDestination.owned : null, (r77 & 536870912) != 0 ? bizProductDestination.brand : null, (r77 & 1073741824) != 0 ? bizProductDestination.model : null, (r77 & Integer.MIN_VALUE) != 0 ? bizProductDestination.machineNumber : null, (r78 & 1) != 0 ? bizProductDestination.frameNumber : null, (r78 & 2) != 0 ? bizProductDestination.yearOfProduction : null, (r78 & 4) != 0 ? bizProductDestination.newTaxExpirationDate : null, (r78 & 8) != 0 ? bizProductDestination.paymentReference : null, (r78 & 16) != 0 ? bizProductDestination.period : null, (r78 & 32) != 0 ? bizProductDestination.providerName : null, (r78 & 64) != 0 ? bizProductDestination.standBegin : null, (r78 & 128) != 0 ? bizProductDestination.standFinal : null, (r78 & 256) != 0 ? bizProductDestination.totalPeriod : null, (r78 & 512) != 0 ? bizProductDestination.usage : null, (r78 & 1024) != 0 ? bizProductDestination.extendInfo : null, (r78 & 2048) != 0 ? bizProductDestination.debtAmount : null, (r78 & 4096) != 0 ? bizProductDestination.currentNeedRepayAmount : null, (r78 & 8192) != 0 ? bizProductDestination.issueDate : null, (r78 & 16384) != 0 ? bizProductDestination.overdueDay : null, (r78 & 32768) != 0 ? bizProductDestination.repaymentDate : null, (r78 & 65536) != 0 ? bizProductDestination.repaymentMonth : null, (r78 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? bizProductDestination.repaidAmount : null, (r78 & 262144) != 0 ? bizProductDestination.inquiryStatus : resultMsg, (r78 & 524288) != 0 ? bizProductDestination.inquiryMessage : Result.m3185isFailureimpl(str) ? null : str, (r78 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? bizProductDestination.inquiryCode : bizCenterResultInfo.getResultCode());
                return copy2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        InquiryStatus inquiryStatus = digitalDestinationInquiryInfo.getInquiryStatus();
        String status = inquiryStatus != null ? inquiryStatus.getStatus() : null;
        InquiryStatus inquiryStatus2 = digitalDestinationInquiryInfo.getInquiryStatus();
        String message = inquiryStatus2 != null ? inquiryStatus2.getMessage() : null;
        InquiryStatus inquiryStatus3 = digitalDestinationInquiryInfo.getInquiryStatus();
        copy = bizProductDestination.copy((r77 & 1) != 0 ? bizProductDestination.billId : null, (r77 & 2) != 0 ? bizProductDestination.totalAmount : null, (r77 & 4) != 0 ? bizProductDestination.adminFee : null, (r77 & 8) != 0 ? bizProductDestination.baseAmount : null, (r77 & 16) != 0 ? bizProductDestination.fineAmount : null, (r77 & 32) != 0 ? bizProductDestination.billCycle : null, (r77 & 64) != 0 ? bizProductDestination.customerName : null, (r77 & 128) != 0 ? bizProductDestination.customerType : null, (r77 & 256) != 0 ? bizProductDestination.dateTime : null, (r77 & 512) != 0 ? bizProductDestination.description : null, (r77 & 1024) != 0 ? bizProductDestination.dueDate : null, (r77 & 2048) != 0 ? bizProductDestination.paymentCount : null, (r77 & 4096) != 0 ? bizProductDestination.payPartialSupport : null, (r77 & 8192) != 0 ? bizProductDestination.familyNumber : null, (r77 & 16384) != 0 ? bizProductDestination.familyCount : null, (r77 & 32768) != 0 ? bizProductDestination.policeNumber : null, (r77 & 65536) != 0 ? bizProductDestination.address : null, (r77 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? bizProductDestination.standMeter : null, (r77 & 262144) != 0 ? bizProductDestination.load : null, (r77 & 524288) != 0 ? bizProductDestination.tagNonAir : null, (r77 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? bizProductDestination.amount : null, (r77 & 2097152) != 0 ? bizProductDestination.meterNumber : null, (r77 & 4194304) != 0 ? bizProductDestination.fare : null, (r77 & 8388608) != 0 ? bizProductDestination.totalEnergy : null, (r77 & 16777216) != 0 ? bizProductDestination.type : null, (r77 & 33554432) != 0 ? bizProductDestination.startDate : null, (r77 & 67108864) != 0 ? bizProductDestination.endDate : null, (r77 & 134217728) != 0 ? bizProductDestination.customerIdNumber : null, (r77 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? bizProductDestination.owned : null, (r77 & 536870912) != 0 ? bizProductDestination.brand : null, (r77 & 1073741824) != 0 ? bizProductDestination.model : null, (r77 & Integer.MIN_VALUE) != 0 ? bizProductDestination.machineNumber : null, (r78 & 1) != 0 ? bizProductDestination.frameNumber : null, (r78 & 2) != 0 ? bizProductDestination.yearOfProduction : null, (r78 & 4) != 0 ? bizProductDestination.newTaxExpirationDate : null, (r78 & 8) != 0 ? bizProductDestination.paymentReference : null, (r78 & 16) != 0 ? bizProductDestination.period : null, (r78 & 32) != 0 ? bizProductDestination.providerName : null, (r78 & 64) != 0 ? bizProductDestination.standBegin : null, (r78 & 128) != 0 ? bizProductDestination.standFinal : null, (r78 & 256) != 0 ? bizProductDestination.totalPeriod : null, (r78 & 512) != 0 ? bizProductDestination.usage : null, (r78 & 1024) != 0 ? bizProductDestination.extendInfo : null, (r78 & 2048) != 0 ? bizProductDestination.debtAmount : null, (r78 & 4096) != 0 ? bizProductDestination.currentNeedRepayAmount : null, (r78 & 8192) != 0 ? bizProductDestination.issueDate : null, (r78 & 16384) != 0 ? bizProductDestination.overdueDay : null, (r78 & 32768) != 0 ? bizProductDestination.repaymentDate : null, (r78 & 65536) != 0 ? bizProductDestination.repaymentMonth : null, (r78 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? bizProductDestination.repaidAmount : null, (r78 & 262144) != 0 ? bizProductDestination.inquiryStatus : status, (r78 & 524288) != 0 ? bizProductDestination.inquiryMessage : message, (r78 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? bizProductDestination.inquiryCode : inquiryStatus3 != null ? inquiryStatus3.getCode() : null);
        return copy;
    }

    private static MoneyView PlaceComponentResult(MultiCurrencyMoney multiCurrencyMoney) {
        if (multiCurrencyMoney == null) {
            return new MoneyView(null, null, null, 7, null);
        }
        String amount = multiCurrencyMoney.getAmount();
        String str = amount == null ? "" : amount;
        String currency = multiCurrencyMoney.getCurrency();
        return new MoneyView(str, currency == null ? "" : currency, null, 4, null);
    }
}
