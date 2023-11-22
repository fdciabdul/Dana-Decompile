package id.dana.domain.social.model;

import id.dana.domain.social.InitStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/social/model/FeedStatus;", "", "", "isInitStatusInitOrFinish", "()Z", "feedStatus", "Z", "getFeedStatus", "", "initStatus", "Ljava/lang/String;", "getInitStatus", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeedStatus {
    private final boolean feedStatus;
    private final String initStatus;

    public FeedStatus(String str, boolean z) {
        this.initStatus = str;
        this.feedStatus = z;
    }

    @JvmName(name = "getFeedStatus")
    public final boolean getFeedStatus() {
        return this.feedStatus;
    }

    @JvmName(name = "getInitStatus")
    public final String getInitStatus() {
        return this.initStatus;
    }

    public final boolean isInitStatusInitOrFinish() {
        return Intrinsics.areEqual(this.initStatus, InitStatus.INIT.getStatus()) || Intrinsics.areEqual(this.initStatus, InitStatus.FINISH.getStatus());
    }
}
