package androidx.credentials.webauthn;

import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()[B", "component3", "name", "id", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "copy", "(Ljava/lang/String;[BLjava/lang/String;)Landroidx/credentials/webauthn/PublicKeyCredentialUserEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDisplayName", "[B", "getId", "getName", "<init>", "(Ljava/lang/String;[BLjava/lang/String;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PublicKeyCredentialUserEntity {
    private final String displayName;
    private final byte[] id;
    private final String name;

    public static /* synthetic */ PublicKeyCredentialUserEntity copy$default(PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, String str, byte[] bArr, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publicKeyCredentialUserEntity.name;
        }
        if ((i & 2) != 0) {
            bArr = publicKeyCredentialUserEntity.id;
        }
        if ((i & 4) != 0) {
            str2 = publicKeyCredentialUserEntity.displayName;
        }
        return publicKeyCredentialUserEntity.copy(str, bArr, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2  reason: from getter */
    public final byte[] getId() {
        return this.id;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final PublicKeyCredentialUserEntity copy(String name, byte[] id2, String displayName) {
        Intrinsics.checkNotNullParameter(name, "");
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(displayName, "");
        return new PublicKeyCredentialUserEntity(name, id2, displayName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PublicKeyCredentialUserEntity) {
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) other;
            return Intrinsics.areEqual(this.name, publicKeyCredentialUserEntity.name) && Intrinsics.areEqual(this.id, publicKeyCredentialUserEntity.id) && Intrinsics.areEqual(this.displayName, publicKeyCredentialUserEntity.displayName);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.name.hashCode() * 31) + Arrays.hashCode(this.id)) * 31) + this.displayName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PublicKeyCredentialUserEntity(name=");
        sb.append(this.name);
        sb.append(", id=");
        sb.append(Arrays.toString(this.id));
        sb.append(", displayName=");
        sb.append(this.displayName);
        sb.append(')');
        return sb.toString();
    }

    public PublicKeyCredentialUserEntity(String str, byte[] bArr, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.name = str;
        this.id = bArr;
        this.displayName = str2;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getId")
    public final byte[] getId() {
        return this.id;
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        return this.displayName;
    }
}
