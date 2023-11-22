package id.dana.feeds.data.activation.source.network.request;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/feeds/data/activation/source/network/request/FeedsStatusConfig;", "Ljava/io/Serializable;", "", "feedStatus", "Ljava/lang/Boolean;", "getFeedStatus", "()Ljava/lang/Boolean;", "setFeedStatus", "(Ljava/lang/Boolean;)V", "", "initStatus", "Ljava/lang/String;", "getInitStatus", "()Ljava/lang/String;", "setInitStatus", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsStatusConfig implements Serializable {
    private Boolean feedStatus;
    private String initStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsStatusConfig() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.source.network.request.FeedsStatusConfig.<init>():void");
    }

    public FeedsStatusConfig(String str, Boolean bool) {
        this.initStatus = str;
        this.feedStatus = bool;
    }

    @JvmName(name = "getInitStatus")
    public final String getInitStatus() {
        return this.initStatus;
    }

    @JvmName(name = "setInitStatus")
    public final void setInitStatus(String str) {
        this.initStatus = str;
    }

    public /* synthetic */ FeedsStatusConfig(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getFeedStatus")
    public final Boolean getFeedStatus() {
        return this.feedStatus;
    }

    @JvmName(name = "setFeedStatus")
    public final void setFeedStatus(Boolean bool) {
        this.feedStatus = bool;
    }
}
