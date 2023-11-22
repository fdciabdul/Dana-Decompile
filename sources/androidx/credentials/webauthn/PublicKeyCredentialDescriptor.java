package androidx.credentials.webauthn;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialDescriptor;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "", "component3", "()Ljava/util/List;", "type", "id", "transports", "copy", "(Ljava/lang/String;[BLjava/util/List;)Landroidx/credentials/webauthn/PublicKeyCredentialDescriptor;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "[B", "getId", "Ljava/util/List;", "getTransports", "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;[BLjava/util/List;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PublicKeyCredentialDescriptor {
    private final byte[] id;
    private final List<String> transports;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublicKeyCredentialDescriptor copy$default(PublicKeyCredentialDescriptor publicKeyCredentialDescriptor, String str, byte[] bArr, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publicKeyCredentialDescriptor.type;
        }
        if ((i & 2) != 0) {
            bArr = publicKeyCredentialDescriptor.id;
        }
        if ((i & 4) != 0) {
            list = publicKeyCredentialDescriptor.transports;
        }
        return publicKeyCredentialDescriptor.copy(str, bArr, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2  reason: from getter */
    public final byte[] getId() {
        return this.id;
    }

    public final List<String> component3() {
        return this.transports;
    }

    public final PublicKeyCredentialDescriptor copy(String type, byte[] id2, List<String> transports) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(transports, "");
        return new PublicKeyCredentialDescriptor(type, id2, transports);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PublicKeyCredentialDescriptor) {
            PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) other;
            return Intrinsics.areEqual(this.type, publicKeyCredentialDescriptor.type) && Intrinsics.areEqual(this.id, publicKeyCredentialDescriptor.id) && Intrinsics.areEqual(this.transports, publicKeyCredentialDescriptor.transports);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.type.hashCode() * 31) + Arrays.hashCode(this.id)) * 31) + this.transports.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublicKeyCredentialDescriptor(type=");
        sb.append(this.type);
        sb.append(", id=");
        sb.append(Arrays.toString(this.id));
        sb.append(", transports=");
        sb.append(this.transports);
        sb.append(')');
        return sb.toString();
    }

    public PublicKeyCredentialDescriptor(String str, byte[] bArr, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.type = str;
        this.id = bArr;
        this.transports = list;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getId")
    public final byte[] getId() {
        return this.id;
    }

    @JvmName(name = "getTransports")
    public final List<String> getTransports() {
        return this.transports;
    }
}
