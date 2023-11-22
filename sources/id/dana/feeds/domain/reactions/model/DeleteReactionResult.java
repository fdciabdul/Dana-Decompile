package id.dana.feeds.domain.reactions.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/reactions/model/DeleteReactionResult;", "", "", "component1", "()Ljava/lang/String;", "msg", "copy", "(Ljava/lang/String;)Lid/dana/feeds/domain/reactions/model/DeleteReactionResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMsg", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeleteReactionResult {
    private final String msg;

    public static /* synthetic */ DeleteReactionResult copy$default(DeleteReactionResult deleteReactionResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteReactionResult.msg;
        }
        return deleteReactionResult.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final DeleteReactionResult copy(String msg) {
        Intrinsics.checkNotNullParameter(msg, "");
        return new DeleteReactionResult(msg);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeleteReactionResult) && Intrinsics.areEqual(this.msg, ((DeleteReactionResult) other).msg);
    }

    public final int hashCode() {
        return this.msg.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeleteReactionResult(msg=");
        sb.append(this.msg);
        sb.append(')');
        return sb.toString();
    }

    public DeleteReactionResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.msg = str;
    }

    @JvmName(name = "getMsg")
    public final String getMsg() {
        return this.msg;
    }
}
