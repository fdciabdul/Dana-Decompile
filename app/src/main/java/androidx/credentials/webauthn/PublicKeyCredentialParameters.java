package androidx.credentials.webauthn;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialParameters;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "type", "alg", "copy", "(Ljava/lang/String;J)Landroidx/credentials/webauthn/PublicKeyCredentialParameters;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "J", "getAlg", "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;J)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PublicKeyCredentialParameters {
    private final long alg;
    private final String type;

    public static /* synthetic */ PublicKeyCredentialParameters copy$default(PublicKeyCredentialParameters publicKeyCredentialParameters, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publicKeyCredentialParameters.type;
        }
        if ((i & 2) != 0) {
            j = publicKeyCredentialParameters.alg;
        }
        return publicKeyCredentialParameters.copy(str, j);
    }

    /* renamed from: component1  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final long getAlg() {
        return this.alg;
    }

    public final PublicKeyCredentialParameters copy(String type, long alg) {
        Intrinsics.checkNotNullParameter(type, "");
        return new PublicKeyCredentialParameters(type, alg);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PublicKeyCredentialParameters) {
            PublicKeyCredentialParameters publicKeyCredentialParameters = (PublicKeyCredentialParameters) other;
            return Intrinsics.areEqual(this.type, publicKeyCredentialParameters.type) && this.alg == publicKeyCredentialParameters.alg;
        }
        return false;
    }

    public final int hashCode() {
        return (this.type.hashCode() * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.alg);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublicKeyCredentialParameters(type=");
        sb.append(this.type);
        sb.append(", alg=");
        sb.append(this.alg);
        sb.append(')');
        return sb.toString();
    }

    public PublicKeyCredentialParameters(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        this.type = str;
        this.alg = j;
    }

    @JvmName(name = "getAlg")
    public final long getAlg() {
        return this.alg;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }
}
