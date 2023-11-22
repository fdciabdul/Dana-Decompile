package id.dana.data.pocket.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/pocket/model/ShareableRpcInfoEntity;", "", "", "receiverInfo", "Ljava/lang/String;", "getReceiverInfo", "()Ljava/lang/String;", "receiverUserId", "getReceiverUserId", "", "sharedDate", "J", "getSharedDate", "()J", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareableRpcInfoEntity {
    private final String receiverInfo;
    private final String receiverUserId;
    private final long sharedDate;

    public ShareableRpcInfoEntity(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.receiverInfo = str;
        this.receiverUserId = str2;
        this.sharedDate = j;
    }

    @JvmName(name = "getReceiverInfo")
    public final String getReceiverInfo() {
        return this.receiverInfo;
    }

    @JvmName(name = "getReceiverUserId")
    public final String getReceiverUserId() {
        return this.receiverUserId;
    }

    @JvmName(name = "getSharedDate")
    public final long getSharedDate() {
        return this.sharedDate;
    }
}
