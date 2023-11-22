package id.dana.network.response.authface;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001b"}, d2 = {"Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "priority", CashierKeyParams.VERIFICATION_METHOD, "verificationMethodCode", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getPriority", "setPriority", "(I)V", "Ljava/lang/String;", "getVerificationMethod", "setVerificationMethod", "(Ljava/lang/String;)V", "getVerificationMethodCode", "setVerificationMethodCode", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VerificationMethodInfoEntity {
    private int priority;
    private String verificationMethod;
    private String verificationMethodCode;

    public VerificationMethodInfoEntity() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ VerificationMethodInfoEntity copy$default(VerificationMethodInfoEntity verificationMethodInfoEntity, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = verificationMethodInfoEntity.priority;
        }
        if ((i2 & 2) != 0) {
            str = verificationMethodInfoEntity.verificationMethod;
        }
        if ((i2 & 4) != 0) {
            str2 = verificationMethodInfoEntity.verificationMethodCode;
        }
        return verificationMethodInfoEntity.copy(i, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVerificationMethodCode() {
        return this.verificationMethodCode;
    }

    public final VerificationMethodInfoEntity copy(int priority, String verificationMethod, String verificationMethodCode) {
        return new VerificationMethodInfoEntity(priority, verificationMethod, verificationMethodCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerificationMethodInfoEntity) {
            VerificationMethodInfoEntity verificationMethodInfoEntity = (VerificationMethodInfoEntity) other;
            return this.priority == verificationMethodInfoEntity.priority && Intrinsics.areEqual(this.verificationMethod, verificationMethodInfoEntity.verificationMethod) && Intrinsics.areEqual(this.verificationMethodCode, verificationMethodInfoEntity.verificationMethodCode);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.priority;
        String str = this.verificationMethod;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.verificationMethodCode;
        return (((i * 31) + hashCode) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerificationMethodInfoEntity(priority=");
        sb.append(this.priority);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", verificationMethodCode=");
        sb.append(this.verificationMethodCode);
        sb.append(')');
        return sb.toString();
    }

    public VerificationMethodInfoEntity(int i, String str, String str2) {
        this.priority = i;
        this.verificationMethod = str;
        this.verificationMethodCode = str2;
    }

    public /* synthetic */ VerificationMethodInfoEntity(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    @JvmName(name = "getPriority")
    public final int getPriority() {
        return this.priority;
    }

    @JvmName(name = "setPriority")
    public final void setPriority(int i) {
        this.priority = i;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getVerificationMethodCode")
    public final String getVerificationMethodCode() {
        return this.verificationMethodCode;
    }

    @JvmName(name = "setVerificationMethodCode")
    public final void setVerificationMethodCode(String str) {
        this.verificationMethodCode = str;
    }
}
