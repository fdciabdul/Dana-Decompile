package id.dana.kyb.data.model;

import com.google.gson.annotations.SerializedName;
import id.dana.data.constant.DanaUrl;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0080\u0001\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b,\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/KybUrlsConfigResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "kyb", "kyc", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "home", DanaLogConstants.BizType.WITHDRAW, "withdrawWithBalance", "withdrawWithBank", "registration", "registrationReject", "registrationRevoke", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/kyb/data/model/KybUrlsConfigResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getHome", "getKyb", "getKyc", "getRegistration", "getRegistrationReject", "getRegistrationRevoke", "getTransaction", "getWithdraw", "getWithdrawWithBalance", "getWithdrawWithBank", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybUrlsConfigResult {
    @SerializedName("dana-home")
    private final String home;
    @SerializedName("dana-kyb")
    private final String kyb;
    @SerializedName("dana-kyc")
    private final String kyc;
    @SerializedName("dana-registration")
    private final String registration;
    @SerializedName("dana-registration-reject")
    private final String registrationReject;
    @SerializedName("dana-registration-revoke")
    private final String registrationRevoke;
    @SerializedName("dana-transaction")
    private final String transaction;
    @SerializedName("dana-withdraw")
    private final String withdraw;
    @SerializedName("dana-withdraw-balance")
    private final String withdrawWithBalance;
    @SerializedName("dana-withdraw-bank")
    private final String withdrawWithBank;

    public KybUrlsConfigResult() {
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
    public final String getWithdrawWithBalance() {
        return this.withdrawWithBalance;
    }

    /* renamed from: component7  reason: from getter */
    public final String getWithdrawWithBank() {
        return this.withdrawWithBank;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRegistration() {
        return this.registration;
    }

    /* renamed from: component9  reason: from getter */
    public final String getRegistrationReject() {
        return this.registrationReject;
    }

    public final KybUrlsConfigResult copy(String kyb, String kyc, String transaction, String home, String withdraw, String withdrawWithBalance, String withdrawWithBank, String registration, String registrationReject, String registrationRevoke) {
        Intrinsics.checkNotNullParameter(kyb, "");
        Intrinsics.checkNotNullParameter(kyc, "");
        Intrinsics.checkNotNullParameter(transaction, "");
        Intrinsics.checkNotNullParameter(home, "");
        return new KybUrlsConfigResult(kyb, kyc, transaction, home, withdraw, withdrawWithBalance, withdrawWithBank, registration, registrationReject, registrationRevoke);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybUrlsConfigResult) {
            KybUrlsConfigResult kybUrlsConfigResult = (KybUrlsConfigResult) other;
            return Intrinsics.areEqual(this.kyb, kybUrlsConfigResult.kyb) && Intrinsics.areEqual(this.kyc, kybUrlsConfigResult.kyc) && Intrinsics.areEqual(this.transaction, kybUrlsConfigResult.transaction) && Intrinsics.areEqual(this.home, kybUrlsConfigResult.home) && Intrinsics.areEqual(this.withdraw, kybUrlsConfigResult.withdraw) && Intrinsics.areEqual(this.withdrawWithBalance, kybUrlsConfigResult.withdrawWithBalance) && Intrinsics.areEqual(this.withdrawWithBank, kybUrlsConfigResult.withdrawWithBank) && Intrinsics.areEqual(this.registration, kybUrlsConfigResult.registration) && Intrinsics.areEqual(this.registrationReject, kybUrlsConfigResult.registrationReject) && Intrinsics.areEqual(this.registrationRevoke, kybUrlsConfigResult.registrationRevoke);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.kyb.hashCode();
        int hashCode2 = this.kyc.hashCode();
        int hashCode3 = this.transaction.hashCode();
        int hashCode4 = this.home.hashCode();
        String str = this.withdraw;
        int hashCode5 = str == null ? 0 : str.hashCode();
        String str2 = this.withdrawWithBalance;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.withdrawWithBank;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.registration;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.registrationReject;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.registrationRevoke;
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybUrlsConfigResult(kyb=");
        sb.append(this.kyb);
        sb.append(", kyc=");
        sb.append(this.kyc);
        sb.append(", transaction=");
        sb.append(this.transaction);
        sb.append(", home=");
        sb.append(this.home);
        sb.append(", withdraw=");
        sb.append(this.withdraw);
        sb.append(", withdrawWithBalance=");
        sb.append(this.withdrawWithBalance);
        sb.append(", withdrawWithBank=");
        sb.append(this.withdrawWithBank);
        sb.append(", registration=");
        sb.append(this.registration);
        sb.append(", registrationReject=");
        sb.append(this.registrationReject);
        sb.append(", registrationRevoke=");
        sb.append(this.registrationRevoke);
        sb.append(')');
        return sb.toString();
    }

    public KybUrlsConfigResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.kyb = str;
        this.kyc = str2;
        this.transaction = str3;
        this.home = str4;
        this.withdraw = str5;
        this.withdrawWithBalance = str6;
        this.withdrawWithBank = str7;
        this.registration = str8;
        this.registrationReject = str9;
        this.registrationRevoke = str10;
    }

    public /* synthetic */ KybUrlsConfigResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/n/kyb" : str, (i & 2) != 0 ? "/i/kyc" : str2, (i & 4) != 0 ? DanaUrl.KYB_LANDING_PAGE : str3, (i & 8) != 0 ? "/m" : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) == 0 ? str10 : null);
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

    @JvmName(name = "getWithdrawWithBalance")
    public final String getWithdrawWithBalance() {
        return this.withdrawWithBalance;
    }

    @JvmName(name = "getWithdrawWithBank")
    public final String getWithdrawWithBank() {
        return this.withdrawWithBank;
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
