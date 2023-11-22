package androidx.credentials.webauthn;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "authenticatorAttachment", "residentKey", "requireResidentKey", "userVerification", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroidx/credentials/webauthn/AuthenticatorSelectionCriteria;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAuthenticatorAttachment", "Z", "getRequireResidentKey", "getResidentKey", "getUserVerification", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class AuthenticatorSelectionCriteria {
    private final String authenticatorAttachment;
    private final boolean requireResidentKey;
    private final String residentKey;
    private final String userVerification;

    public static /* synthetic */ AuthenticatorSelectionCriteria copy$default(AuthenticatorSelectionCriteria authenticatorSelectionCriteria, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticatorSelectionCriteria.authenticatorAttachment;
        }
        if ((i & 2) != 0) {
            str2 = authenticatorSelectionCriteria.residentKey;
        }
        if ((i & 4) != 0) {
            z = authenticatorSelectionCriteria.requireResidentKey;
        }
        if ((i & 8) != 0) {
            str3 = authenticatorSelectionCriteria.userVerification;
        }
        return authenticatorSelectionCriteria.copy(str, str2, z, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    /* renamed from: component2  reason: from getter */
    public final String getResidentKey() {
        return this.residentKey;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getRequireResidentKey() {
        return this.requireResidentKey;
    }

    /* renamed from: component4  reason: from getter */
    public final String getUserVerification() {
        return this.userVerification;
    }

    public final AuthenticatorSelectionCriteria copy(String authenticatorAttachment, String residentKey, boolean requireResidentKey, String userVerification) {
        Intrinsics.checkNotNullParameter(authenticatorAttachment, "");
        Intrinsics.checkNotNullParameter(residentKey, "");
        Intrinsics.checkNotNullParameter(userVerification, "");
        return new AuthenticatorSelectionCriteria(authenticatorAttachment, residentKey, requireResidentKey, userVerification);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AuthenticatorSelectionCriteria) {
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) other;
            return Intrinsics.areEqual(this.authenticatorAttachment, authenticatorSelectionCriteria.authenticatorAttachment) && Intrinsics.areEqual(this.residentKey, authenticatorSelectionCriteria.residentKey) && this.requireResidentKey == authenticatorSelectionCriteria.requireResidentKey && Intrinsics.areEqual(this.userVerification, authenticatorSelectionCriteria.userVerification);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.authenticatorAttachment.hashCode();
        int hashCode2 = this.residentKey.hashCode();
        boolean z = this.requireResidentKey;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.userVerification.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthenticatorSelectionCriteria(authenticatorAttachment=");
        sb.append(this.authenticatorAttachment);
        sb.append(", residentKey=");
        sb.append(this.residentKey);
        sb.append(", requireResidentKey=");
        sb.append(this.requireResidentKey);
        sb.append(", userVerification=");
        sb.append(this.userVerification);
        sb.append(')');
        return sb.toString();
    }

    public AuthenticatorSelectionCriteria(String str, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.authenticatorAttachment = str;
        this.residentKey = str2;
        this.requireResidentKey = z;
        this.userVerification = str3;
    }

    public /* synthetic */ AuthenticatorSelectionCriteria(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "preferred" : str3);
    }

    @JvmName(name = "getAuthenticatorAttachment")
    public final String getAuthenticatorAttachment() {
        return this.authenticatorAttachment;
    }

    @JvmName(name = "getResidentKey")
    public final String getResidentKey() {
        return this.residentKey;
    }

    @JvmName(name = "getRequireResidentKey")
    public final boolean getRequireResidentKey() {
        return this.requireResidentKey;
    }

    @JvmName(name = "getUserVerification")
    public final String getUserVerification() {
        return this.userVerification;
    }
}
