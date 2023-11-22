package id.dana.kyb.domain.model;

import id.dana.data.constant.DanaUrl;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004Jt\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b+\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b,\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/KybUrlsConfig;", "", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "kyb", "kyc", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "home", DanaLogConstants.BizType.WITHDRAW, "withdrawWithBank", "withdrawWithBalance", "registration", "registrationReject", "registrationRevoke", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/domain/model/KybUrlsConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getHome", "getKyb", "getKyc", "getRegistration", "getRegistrationReject", "getRegistrationRevoke", "getTransaction", "getWithdraw", "getWithdrawWithBalance", "getWithdrawWithBank", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybUrlsConfig {
    private final String home;
    private final String kyb;
    private final String kyc;
    private final String registration;
    private final String registrationReject;
    private final String registrationRevoke;
    private final String transaction;
    private final String withdraw;
    private final String withdrawWithBalance;
    private final String withdrawWithBank;

    public KybUrlsConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKyb() {
        return this.kyb;
    }

    /* renamed from: component10  reason: from getter */
    public final String getRegistrationRevoke() {
        return this.registrationRevoke;
    }

    /* renamed from: component2  reason: from getter */
    public final String getKyc() {
        return this.kyc;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTransaction() {
        return this.transaction;
    }

    /* renamed from: component4  reason: from getter */
    public final String getHome() {
        return this.home;
    }

    /* renamed from: component5  reason: from getter */
    public final String getWithdraw() {
        return this.withdraw;
    }

    /* renamed from: component6  reason: from getter */
    public final String getWithdrawWithBank() {
        return this.withdrawWithBank;
    }

    /* renamed from: component7  reason: from getter */
    public final String getWithdrawWithBalance() {
        return this.withdrawWithBalance;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRegistration() {
        return this.registration;
    }

    /* renamed from: component9  reason: from getter */
    public final String getRegistrationReject() {
        return this.registrationReject;
    }

    public final KybUrlsConfig copy(String kyb, String kyc, String transaction, String home, String withdraw, String withdrawWithBank, String withdrawWithBalance, String registration, String registrationReject, String registrationRevoke) {
        Intrinsics.checkNotNullParameter(kyb, "");
        Intrinsics.checkNotNullParameter(kyc, "");
        Intrinsics.checkNotNullParameter(transaction, "");
        Intrinsics.checkNotNullParameter(home, "");
        Intrinsics.checkNotNullParameter(withdraw, "");
        Intrinsics.checkNotNullParameter(withdrawWithBank, "");
        Intrinsics.checkNotNullParameter(withdrawWithBalance, "");
        Intrinsics.checkNotNullParameter(registration, "");
        Intrinsics.checkNotNullParameter(registrationReject, "");
        Intrinsics.checkNotNullParameter(registrationRevoke, "");
        return new KybUrlsConfig(kyb, kyc, transaction, home, withdraw, withdrawWithBank, withdrawWithBalance, registration, registrationReject, registrationRevoke);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybUrlsConfig) {
            KybUrlsConfig kybUrlsConfig = (KybUrlsConfig) other;
            return Intrinsics.areEqual(this.kyb, kybUrlsConfig.kyb) && Intrinsics.areEqual(this.kyc, kybUrlsConfig.kyc) && Intrinsics.areEqual(this.transaction, kybUrlsConfig.transaction) && Intrinsics.areEqual(this.home, kybUrlsConfig.home) && Intrinsics.areEqual(this.withdraw, kybUrlsConfig.withdraw) && Intrinsics.areEqual(this.withdrawWithBank, kybUrlsConfig.withdrawWithBank) && Intrinsics.areEqual(this.withdrawWithBalance, kybUrlsConfig.withdrawWithBalance) && Intrinsics.areEqual(this.registration, kybUrlsConfig.registration) && Intrinsics.areEqual(this.registrationReject, kybUrlsConfig.registrationReject) && Intrinsics.areEqual(this.registrationRevoke, kybUrlsConfig.registrationRevoke);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((this.kyb.hashCode() * 31) + this.kyc.hashCode()) * 31) + this.transaction.hashCode()) * 31) + this.home.hashCode()) * 31) + this.withdraw.hashCode()) * 31) + this.withdrawWithBank.hashCode()) * 31) + this.withdrawWithBalance.hashCode()) * 31) + this.registration.hashCode()) * 31) + this.registrationReject.hashCode()) * 31) + this.registrationRevoke.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybUrlsConfig(kyb=");
        sb.append(this.kyb);
        sb.append(", kyc=");
        sb.append(this.kyc);
        sb.append(", transaction=");
        sb.append(this.transaction);
        sb.append(", home=");
        sb.append(this.home);
        sb.append(", withdraw=");
        sb.append(this.withdraw);
        sb.append(", withdrawWithBank=");
        sb.append(this.withdrawWithBank);
        sb.append(", withdrawWithBalance=");
        sb.append(this.withdrawWithBalance);
        sb.append(", registration=");
        sb.append(this.registration);
        sb.append(", registrationReject=");
        sb.append(this.registrationReject);
        sb.append(", registrationRevoke=");
        sb.append(this.registrationRevoke);
        sb.append(')');
        return sb.toString();
    }

    public KybUrlsConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        this.kyb = str;
        this.kyc = str2;
        this.transaction = str3;
        this.home = str4;
        this.withdraw = str5;
        this.withdrawWithBank = str6;
        this.withdrawWithBalance = str7;
        this.registration = str8;
        this.registrationReject = str9;
        this.registrationRevoke = str10;
    }

    public /* synthetic */ KybUrlsConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/n/kyb" : str, (i & 2) != 0 ? "/i/kyc" : str2, (i & 4) != 0 ? DanaUrl.KYB_LANDING_PAGE : str3, (i & 8) != 0 ? "/m" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) == 0 ? str10 : "");
    }

    @JvmName(name = "getKyb")
    public final String getKyb() {
        return this.kyb;
    }

    @JvmName(name = "getKyc")
    public final String getKyc() {
        return this.kyc;
    }

    @JvmName(name = "getTransaction")
    public final String getTransaction() {
        return this.transaction;
    }

    @JvmName(name = "getHome")
    public final String getHome() {
        return this.home;
    }

    @JvmName(name = "getWithdraw")
    public final String getWithdraw() {
        return this.withdraw;
    }

    @JvmName(name = "getWithdrawWithBank")
    public final String getWithdrawWithBank() {
        return this.withdrawWithBank;
    }

    @JvmName(name = "getWithdrawWithBalance")
    public final String getWithdrawWithBalance() {
        return this.withdrawWithBalance;
    }

    @JvmName(name = "getRegistration")
    public final String getRegistration() {
        return this.registration;
    }

    @JvmName(name = "getRegistrationReject")
    public final String getRegistrationReject() {
        return this.registrationReject;
    }

    @JvmName(name = "getRegistrationRevoke")
    public final String getRegistrationRevoke() {
        return this.registrationRevoke;
    }
}
