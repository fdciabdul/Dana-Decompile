package id.dana.data.qrbarcode.repository.source.network.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/result/QrDetail;", "", "", "expireDateTimestamp", "J", "getExpireDateTimestamp", "()J", "setExpireDateTimestamp", "(J)V", "expireTimeInSeconds", "getExpireTimeInSeconds", "setExpireTimeInSeconds", "", "qrCode", "Ljava/lang/String;", "getQrCode", "()Ljava/lang/String;", "setQrCode", "(Ljava/lang/String;)V", "", "qris", "Z", "getQris", "()Z", "setQris", "(Z)V", "<init>", "(Ljava/lang/String;JJZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrDetail {
    private long expireDateTimestamp;
    private long expireTimeInSeconds;
    private String qrCode;
    private boolean qris;

    public QrDetail(String str, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.qrCode = str;
        this.expireDateTimestamp = j;
        this.expireTimeInSeconds = j2;
        this.qris = z;
    }

    public /* synthetic */ QrDetail(String str, long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? j2 : 0L, (i & 8) != 0 ? false : z);
    }

    @JvmName(name = "getQrCode")
    public final String getQrCode() {
        return this.qrCode;
    }

    @JvmName(name = "setQrCode")
    public final void setQrCode(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.qrCode = str;
    }

    @JvmName(name = "getExpireDateTimestamp")
    public final long getExpireDateTimestamp() {
        return this.expireDateTimestamp;
    }

    @JvmName(name = "setExpireDateTimestamp")
    public final void setExpireDateTimestamp(long j) {
        this.expireDateTimestamp = j;
    }

    @JvmName(name = "getExpireTimeInSeconds")
    public final long getExpireTimeInSeconds() {
        return this.expireTimeInSeconds;
    }

    @JvmName(name = "setExpireTimeInSeconds")
    public final void setExpireTimeInSeconds(long j) {
        this.expireTimeInSeconds = j;
    }

    @JvmName(name = "getQris")
    public final boolean getQris() {
        return this.qris;
    }

    @JvmName(name = "setQris")
    public final void setQris(boolean z) {
        this.qris = z;
    }
}
