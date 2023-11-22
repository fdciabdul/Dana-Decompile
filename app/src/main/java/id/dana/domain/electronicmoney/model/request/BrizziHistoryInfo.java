package id.dana.domain.electronicmoney.model.request;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006"}, d2 = {"Lid/dana/domain/electronicmoney/model/request/BrizziHistoryInfo;", "", "", "balanceAfter", "Ljava/lang/String;", "getBalanceAfter", "()Ljava/lang/String;", "balanceBefore", "getBalanceBefore", "merchatId", "getMerchatId", "terminalId", "getTerminalId", "trxAmount", "getTrxAmount", "trxDate", "getTrxDate", "trxTime", "getTrxTime", "trxType", "getTrxType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BrizziHistoryInfo {
    private final String balanceAfter;
    private final String balanceBefore;
    private final String merchatId;
    private final String terminalId;
    private final String trxAmount;
    private final String trxDate;
    private final String trxTime;
    private final String trxType;

    public BrizziHistoryInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        this.merchatId = str;
        this.terminalId = str2;
        this.trxDate = str3;
        this.trxTime = str4;
        this.trxType = str5;
        this.trxAmount = str6;
        this.balanceBefore = str7;
        this.balanceAfter = str8;
    }

    @JvmName(name = "getMerchatId")
    public final String getMerchatId() {
        return this.merchatId;
    }

    @JvmName(name = "getTerminalId")
    public final String getTerminalId() {
        return this.terminalId;
    }

    @JvmName(name = "getTrxDate")
    public final String getTrxDate() {
        return this.trxDate;
    }

    @JvmName(name = "getTrxTime")
    public final String getTrxTime() {
        return this.trxTime;
    }

    @JvmName(name = "getTrxType")
    public final String getTrxType() {
        return this.trxType;
    }

    @JvmName(name = "getTrxAmount")
    public final String getTrxAmount() {
        return this.trxAmount;
    }

    @JvmName(name = "getBalanceBefore")
    public final String getBalanceBefore() {
        return this.balanceBefore;
    }

    @JvmName(name = "getBalanceAfter")
    public final String getBalanceAfter() {
        return this.balanceAfter;
    }
}
