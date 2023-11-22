package id.dana.mybills.domain.model;

import id.dana.danah5.bioutility.BioUtilityBridge;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ:\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/mybills/domain/model/CreateSubscription;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "subscriptionId", BioUtilityBridge.SECURITY_ID, "verificationMethods", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/mybills/domain/model/CreateSubscription;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSecurityId", "getSubscriptionId", "Ljava/util/List;", "getVerificationMethods", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateSubscription {
    private final String securityId;
    private final String subscriptionId;
    private final List<String> verificationMethods;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateSubscription copy$default(CreateSubscription createSubscription, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createSubscription.subscriptionId;
        }
        if ((i & 2) != 0) {
            str2 = createSubscription.securityId;
        }
        if ((i & 4) != 0) {
            list = createSubscription.verificationMethods;
        }
        return createSubscription.copy(str, str2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<String> component3() {
        return this.verificationMethods;
    }

    public final CreateSubscription copy(String subscriptionId, String securityId, List<String> verificationMethods) {
        return new CreateSubscription(subscriptionId, securityId, verificationMethods);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateSubscription) {
            CreateSubscription createSubscription = (CreateSubscription) other;
            return Intrinsics.areEqual(this.subscriptionId, createSubscription.subscriptionId) && Intrinsics.areEqual(this.securityId, createSubscription.securityId) && Intrinsics.areEqual(this.verificationMethods, createSubscription.verificationMethods);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.subscriptionId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        List<String> list = this.verificationMethods;
        return (((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateSubscription(subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(')');
        return sb.toString();
    }

    public CreateSubscription(String str, String str2, List<String> list) {
        this.subscriptionId = str;
        this.securityId = str2;
        this.verificationMethods = list;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getVerificationMethods")
    public final List<String> getVerificationMethods() {
        return this.verificationMethods;
    }
}
