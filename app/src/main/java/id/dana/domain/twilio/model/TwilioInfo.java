package id.dana.domain.twilio.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\bR\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b"}, d2 = {"Lid/dana/domain/twilio/model/TwilioInfo;", "", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "", "component4", "()Ljava/util/List;", "registered", "registerAllowed", BioUtilityBridge.SECURITY_ID, "verificationMethodInfos", "copy", "(ZZLjava/lang/String;Ljava/util/List;)Lid/dana/domain/twilio/model/TwilioInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getRegisterAllowed", "getRegistered", "Ljava/lang/String;", "getSecurityId", "Ljava/util/List;", "getVerificationMethodInfos", "<init>", "(ZZLjava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TwilioInfo {
    private final boolean registerAllowed;
    private final boolean registered;
    private final String securityId;
    private final List<String> verificationMethodInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TwilioInfo copy$default(TwilioInfo twilioInfo, boolean z, boolean z2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = twilioInfo.registered;
        }
        if ((i & 2) != 0) {
            z2 = twilioInfo.registerAllowed;
        }
        if ((i & 4) != 0) {
            str = twilioInfo.securityId;
        }
        if ((i & 8) != 0) {
            list = twilioInfo.verificationMethodInfos;
        }
        return twilioInfo.copy(z, z2, str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getRegistered() {
        return this.registered;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getRegisterAllowed() {
        return this.registerAllowed;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<String> component4() {
        return this.verificationMethodInfos;
    }

    public final TwilioInfo copy(boolean registered, boolean registerAllowed, String securityId, List<String> verificationMethodInfos) {
        return new TwilioInfo(registered, registerAllowed, securityId, verificationMethodInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TwilioInfo) {
            TwilioInfo twilioInfo = (TwilioInfo) other;
            return this.registered == twilioInfo.registered && this.registerAllowed == twilioInfo.registerAllowed && Intrinsics.areEqual(this.securityId, twilioInfo.securityId) && Intrinsics.areEqual(this.verificationMethodInfos, twilioInfo.verificationMethodInfos);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.registered;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.registerAllowed;
        int i = z2 ? 1 : z2 ? 1 : 0;
        String str = this.securityId;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.verificationMethodInfos;
        return (((((r0 * 31) + i) * 31) + hashCode) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwilioInfo(registered=");
        sb.append(this.registered);
        sb.append(", registerAllowed=");
        sb.append(this.registerAllowed);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethodInfos=");
        sb.append(this.verificationMethodInfos);
        sb.append(')');
        return sb.toString();
    }

    public TwilioInfo(boolean z, boolean z2, String str, List<String> list) {
        this.registered = z;
        this.registerAllowed = z2;
        this.securityId = str;
        this.verificationMethodInfos = list;
    }

    @JvmName(name = "getRegistered")
    public final boolean getRegistered() {
        return this.registered;
    }

    @JvmName(name = "getRegisterAllowed")
    public final boolean getRegisterAllowed() {
        return this.registerAllowed;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    public /* synthetic */ TwilioInfo(boolean z, boolean z2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getVerificationMethodInfos")
    public final List<String> getVerificationMethodInfos() {
        return this.verificationMethodInfos;
    }
}
