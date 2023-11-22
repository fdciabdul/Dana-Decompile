package id.dana.domain.twilio.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/model/TwilioVerify;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", BioUtilityBridge.SECURITY_ID, CashierKeyParams.VERIFICATION_METHOD, "validateData", "sendOtpStrategy", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/model/TwilioVerify;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSecurityId", "getSendOtpStrategy", "getValidateData", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TwilioVerify {
    private final String securityId;
    private final String sendOtpStrategy;
    private final String validateData;
    private final String verificationMethod;

    public TwilioVerify() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TwilioVerify copy$default(TwilioVerify twilioVerify, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = twilioVerify.securityId;
        }
        if ((i & 2) != 0) {
            str2 = twilioVerify.verificationMethod;
        }
        if ((i & 4) != 0) {
            str3 = twilioVerify.validateData;
        }
        if ((i & 8) != 0) {
            str4 = twilioVerify.sendOtpStrategy;
        }
        return twilioVerify.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSendOtpStrategy() {
        return this.sendOtpStrategy;
    }

    public final TwilioVerify copy(String securityId, String verificationMethod, String validateData, String sendOtpStrategy) {
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(validateData, "");
        Intrinsics.checkNotNullParameter(sendOtpStrategy, "");
        return new TwilioVerify(securityId, verificationMethod, validateData, sendOtpStrategy);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TwilioVerify) {
            TwilioVerify twilioVerify = (TwilioVerify) other;
            return Intrinsics.areEqual(this.securityId, twilioVerify.securityId) && Intrinsics.areEqual(this.verificationMethod, twilioVerify.verificationMethod) && Intrinsics.areEqual(this.validateData, twilioVerify.validateData) && Intrinsics.areEqual(this.sendOtpStrategy, twilioVerify.sendOtpStrategy);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.securityId.hashCode() * 31) + this.verificationMethod.hashCode()) * 31) + this.validateData.hashCode()) * 31) + this.sendOtpStrategy.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwilioVerify(securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", sendOtpStrategy=");
        sb.append(this.sendOtpStrategy);
        sb.append(')');
        return sb.toString();
    }

    public TwilioVerify(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.securityId = str;
        this.verificationMethod = str2;
        this.validateData = str3;
        this.sendOtpStrategy = str4;
    }

    public /* synthetic */ TwilioVerify(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getSendOtpStrategy")
    public final String getSendOtpStrategy() {
        return this.sendOtpStrategy;
    }
}
