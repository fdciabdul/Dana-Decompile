package id.dana.domain.sendmoney.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006"}, d2 = {"Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "", "", "accountFreeze", "Z", "getAccountFreeze", "()Z", "blackListAccount", "getBlackListAccount", "notBankListRecent", "getNotBankListRecent", "notContactListRecent", "getNotContactListRecent", "reachLimit", "getReachLimit", "suspiciousAccount", "getSuspiciousAccount", "<init>", "(ZZZZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SmartFrictionConfig {
    public boolean accountFreeze;
    public boolean blackListAccount;
    public boolean notBankListRecent;
    public boolean notContactListRecent;
    public boolean reachLimit;
    public boolean suspiciousAccount;

    public /* synthetic */ SmartFrictionConfig() {
    }

    public SmartFrictionConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.notContactListRecent = z;
        this.notBankListRecent = z2;
        this.accountFreeze = z3;
        this.reachLimit = z4;
        this.suspiciousAccount = z5;
        this.blackListAccount = z6;
    }

    @JvmName(name = "getNotContactListRecent")
    public final boolean getNotContactListRecent() {
        return this.notContactListRecent;
    }

    @JvmName(name = "getNotBankListRecent")
    public final boolean getNotBankListRecent() {
        return this.notBankListRecent;
    }

    @JvmName(name = "getAccountFreeze")
    public final boolean getAccountFreeze() {
        return this.accountFreeze;
    }

    @JvmName(name = "getReachLimit")
    public final boolean getReachLimit() {
        return this.reachLimit;
    }

    @JvmName(name = "getSuspiciousAccount")
    public final boolean getSuspiciousAccount() {
        return this.suspiciousAccount;
    }

    @JvmName(name = "getBlackListAccount")
    public final boolean getBlackListAccount() {
        return this.blackListAccount;
    }
}
