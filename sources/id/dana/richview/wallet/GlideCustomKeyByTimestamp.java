package id.dana.richview.wallet;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/richview/wallet/GlideCustomKeyByTimestamp;", "Lcom/bumptech/glide/load/Key;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/security/MessageDigest;", "", "getAuthRequestContext", "(Ljava/security/MessageDigest;)V", "", "PlaceComponentResult", "J", "<init>", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlideCustomKeyByTimestamp implements Key {
    private final long PlaceComponentResult;

    public GlideCustomKeyByTimestamp(long j) {
        this.PlaceComponentResult = j;
    }

    @Override // com.bumptech.glide.load.Key
    public final void getAuthRequestContext(MessageDigest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.update(ByteBuffer.allocate(8).putLong(this.PlaceComponentResult).array());
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return (p0 instanceof GlideCustomKeyByTimestamp) && this.PlaceComponentResult != ((GlideCustomKeyByTimestamp) p0).PlaceComponentResult;
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        return Cbor$Arg$$ExternalSyntheticBackport0.m(this.PlaceComponentResult);
    }
}
