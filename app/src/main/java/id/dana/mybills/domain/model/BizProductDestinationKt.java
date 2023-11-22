package id.dana.mybills.domain.model;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a#\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u0007\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lid/dana/mybills/domain/model/BizProductDestination;", "", "billId", "findBizProductDestination", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/mybills/domain/model/BizProductDestination;", "defaultAmount", "findItemAndReturnAmount", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizProductDestinationKt {
    public static final String findItemAndReturnAmount(List<BizProductDestination> list, String str, String str2) {
        Object obj;
        MoneyView totalAmount;
        String amount;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((BizProductDestination) obj).getBillId(), str)) {
                break;
            }
        }
        BizProductDestination bizProductDestination = (BizProductDestination) obj;
        return (bizProductDestination == null || (totalAmount = bizProductDestination.getTotalAmount()) == null || (amount = totalAmount.getAmount()) == null) ? str2 : amount;
    }

    public static final BizProductDestination findBizProductDestination(List<BizProductDestination> list, String str) {
        Object obj;
        BizProductDestination copy;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((BizProductDestination) obj).getBillId(), str)) {
                break;
            }
        }
        BizProductDestination bizProductDestination = (BizProductDestination) obj;
        if (bizProductDestination != null) {
            copy = bizProductDestination.copy((r77 & 1) != 0 ? bizProductDestination.billId : null, (r77 & 2) != 0 ? bizProductDestination.totalAmount : null, (r77 & 4) != 0 ? bizProductDestination.adminFee : null, (r77 & 8) != 0 ? bizProductDestination.baseAmount : null, (r77 & 16) != 0 ? bizProductDestination.fineAmount : null, (r77 & 32) != 0 ? bizProductDestination.billCycle : null, (r77 & 64) != 0 ? bizProductDestination.customerName : null, (r77 & 128) != 0 ? bizProductDestination.customerType : null, (r77 & 256) != 0 ? bizProductDestination.dateTime : null, (r77 & 512) != 0 ? bizProductDestination.description : null, (r77 & 1024) != 0 ? bizProductDestination.dueDate : null, (r77 & 2048) != 0 ? bizProductDestination.paymentCount : null, (r77 & 4096) != 0 ? bizProductDestination.payPartialSupport : null, (r77 & 8192) != 0 ? bizProductDestination.familyNumber : null, (r77 & 16384) != 0 ? bizProductDestination.familyCount : null, (r77 & 32768) != 0 ? bizProductDestination.policeNumber : null, (r77 & 65536) != 0 ? bizProductDestination.address : null, (r77 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? bizProductDestination.standMeter : null, (r77 & 262144) != 0 ? bizProductDestination.load : null, (r77 & 524288) != 0 ? bizProductDestination.tagNonAir : null, (r77 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? bizProductDestination.amount : null, (r77 & 2097152) != 0 ? bizProductDestination.meterNumber : null, (r77 & 4194304) != 0 ? bizProductDestination.fare : null, (r77 & 8388608) != 0 ? bizProductDestination.totalEnergy : null, (r77 & 16777216) != 0 ? bizProductDestination.type : null, (r77 & 33554432) != 0 ? bizProductDestination.startDate : null, (r77 & 67108864) != 0 ? bizProductDestination.endDate : null, (r77 & 134217728) != 0 ? bizProductDestination.customerIdNumber : null, (r77 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? bizProductDestination.owned : null, (r77 & 536870912) != 0 ? bizProductDestination.brand : null, (r77 & 1073741824) != 0 ? bizProductDestination.model : null, (r77 & Integer.MIN_VALUE) != 0 ? bizProductDestination.machineNumber : null, (r78 & 1) != 0 ? bizProductDestination.frameNumber : null, (r78 & 2) != 0 ? bizProductDestination.yearOfProduction : null, (r78 & 4) != 0 ? bizProductDestination.newTaxExpirationDate : null, (r78 & 8) != 0 ? bizProductDestination.paymentReference : null, (r78 & 16) != 0 ? bizProductDestination.period : null, (r78 & 32) != 0 ? bizProductDestination.providerName : null, (r78 & 64) != 0 ? bizProductDestination.standBegin : null, (r78 & 128) != 0 ? bizProductDestination.standFinal : null, (r78 & 256) != 0 ? bizProductDestination.totalPeriod : null, (r78 & 512) != 0 ? bizProductDestination.usage : null, (r78 & 1024) != 0 ? bizProductDestination.extendInfo : null, (r78 & 2048) != 0 ? bizProductDestination.debtAmount : null, (r78 & 4096) != 0 ? bizProductDestination.currentNeedRepayAmount : null, (r78 & 8192) != 0 ? bizProductDestination.issueDate : null, (r78 & 16384) != 0 ? bizProductDestination.overdueDay : null, (r78 & 32768) != 0 ? bizProductDestination.repaymentDate : null, (r78 & 65536) != 0 ? bizProductDestination.repaymentMonth : null, (r78 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? bizProductDestination.repaidAmount : null, (r78 & 262144) != 0 ? bizProductDestination.inquiryStatus : null, (r78 & 524288) != 0 ? bizProductDestination.inquiryMessage : null, (r78 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? bizProductDestination.inquiryCode : null);
            return copy;
        }
        return null;
    }
}
