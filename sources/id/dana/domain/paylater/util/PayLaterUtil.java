package id.dana.domain.paylater.util;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.util.DateTimeUtils;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/domain/paylater/util/PayLaterUtil;", "", "", "currentTimestamp", "billDue", "", "calculateRemainingDueDays", "(JJ)I", "thresholdDueBillTimestamp", "", "checkBillDueTime", "(JJJ)Ljava/lang/String;", "Lid/dana/domain/paylater/model/LoanInfo;", "loanInfo", "thresholdDueDay", "getLoanServiceState", "(Lid/dana/domain/paylater/model/LoanInfo;JJ)Ljava/lang/String;", "loanStateService", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "service", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "getLoanStatusWhitelist", "(Ljava/lang/String;Lid/dana/domain/paylater/model/LoanInfo;JLid/dana/domain/homeinfo/ThirdPartyServiceResponse;)Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "Lid/dana/domain/paylater/model/LoanWhitelist;", "loanWhitelist", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "payLaterCicilConfig", "cachedStartRotationDelayTime", "rotationDelayTime", "", "isCacheExpire", "(Lid/dana/domain/paylater/model/LoanWhitelist;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;JI)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayLaterUtil {
    public static final PayLaterUtil INSTANCE = new PayLaterUtil();

    private final String checkBillDueTime(long billDue, long currentTimestamp, long thresholdDueBillTimestamp) {
        if (billDue > 0) {
            if (currentTimestamp > billDue && currentTimestamp - billDue > 86400000) {
                return "overdue";
            }
            if (billDue - currentTimestamp <= thresholdDueBillTimestamp) {
                return "due";
            }
        }
        return "active";
    }

    private PayLaterUtil() {
    }

    public final String getLoanServiceState(LoanInfo loanInfo, long currentTimestamp, long thresholdDueDay) {
        Intrinsics.checkNotNullParameter(loanInfo, "");
        if (!loanInfo.isUserWLUnknown()) {
            if (loanInfo.isUserWLUnregistered()) {
                return "unregistered";
            }
            if (!loanInfo.isUserWLRegistered()) {
                return "off";
            }
            Long billDueDate = loanInfo.getBillDueDate();
            if (billDueDate != null) {
                String checkBillDueTime = INSTANCE.checkBillDueTime(billDueDate.longValue(), currentTimestamp, thresholdDueDay);
                if (checkBillDueTime != null) {
                    return checkBillDueTime;
                }
            }
        }
        return "active";
    }

    public static /* synthetic */ boolean isCacheExpire$default(PayLaterUtil payLaterUtil, LoanWhitelist loanWhitelist, PaylaterCicilMethodConfig paylaterCicilMethodConfig, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loanWhitelist = null;
        }
        if ((i2 & 2) != 0) {
            paylaterCicilMethodConfig = null;
        }
        if ((i2 & 4) != 0) {
            j = 0;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return payLaterUtil.isCacheExpire(loanWhitelist, paylaterCicilMethodConfig, j, i);
    }

    public final boolean isCacheExpire(LoanWhitelist loanWhitelist, PaylaterCicilMethodConfig payLaterCicilConfig, long cachedStartRotationDelayTime, int rotationDelayTime) {
        long timeInMillis;
        timeInMillis = Calendar.getInstance().getTimeInMillis();
        Calendar calendar = Calendar.getInstance();
        if (loanWhitelist != null) {
            cachedStartRotationDelayTime = loanWhitelist.getLastFetchTime();
        }
        calendar.setTimeInMillis(cachedStartRotationDelayTime);
        if (loanWhitelist != null) {
            calendar.add(10, payLaterCicilConfig != null ? payLaterCicilConfig.getCacheTime() : 0);
        } else {
            calendar.add(5, rotationDelayTime);
        }
        return timeInMillis > calendar.getTimeInMillis();
    }

    public final LoanStatusWhitelist getLoanStatusWhitelist(String loanStateService, LoanInfo loanInfo, long currentTimestamp, ThirdPartyServiceResponse service) {
        Intrinsics.checkNotNullParameter(loanStateService, "");
        Intrinsics.checkNotNullParameter(loanInfo, "");
        Intrinsics.checkNotNullParameter(service, "");
        Integer num = null;
        if (Intrinsics.areEqual(loanStateService, "due")) {
            Long billDueDate = loanInfo.getBillDueDate();
            if (billDueDate != null) {
                num = Integer.valueOf(INSTANCE.calculateRemainingDueDays(currentTimestamp, billDueDate.longValue()));
            }
            String type = loanInfo.getType();
            StringBuilder sb = new StringBuilder();
            sb.append("due-");
            sb.append(num);
            return new LoanStatusWhitelist(type, sb.toString(), num, service.getAlwaysConsult());
        }
        return new LoanStatusWhitelist(loanInfo.getType(), loanStateService, null, service.getAlwaysConsult());
    }

    private final int calculateRemainingDueDays(long currentTimestamp, long billDue) {
        return DateTimeUtils.INSTANCE.calculateDaysBetween(DateTimeUtils.INSTANCE.convertToCalendar(currentTimestamp), DateTimeUtils.INSTANCE.convertToCalendar(billDue));
    }
}
