package id.dana.domain.social.model;

import id.dana.domain.social.InitStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\f\b\u0002\u0010\u0011\u001a\u00060\bj\u0002`\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\f\b\u0002\u0010\u0011\u001a\u00060\bj\u0002`\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000eJ\r\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u000eJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0011\u001a\u00060\bj\u0002`\t8\u0007¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u000bR\"\u0010\u0012\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010&R\u001a\u0010\u0010\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\u0004"}, d2 = {"Lid/dana/domain/social/model/InitFeed;", "", "Lid/dana/domain/social/InitStatus;", "component1", "()Lid/dana/domain/social/InitStatus;", "", "component2", "()I", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component3", "()Ljava/lang/Exception;", "", "component4", "()Z", "status", "initProgress", "error", "hasRestrictedContact", "copy", "(Lid/dana/domain/social/InitStatus;ILjava/lang/Exception;Z)Lid/dana/domain/social/model/InitFeed;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "isError", "isFinished", "Lid/dana/domain/social/model/FeedInit;", "toFeedInit", "()Lid/dana/domain/social/model/FeedInit;", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Exception;", "getError", "Z", "getHasRestrictedContact", "setHasRestrictedContact", "(Z)V", "I", "getInitProgress", "Lid/dana/domain/social/InitStatus;", "getStatus", "<init>", "(Lid/dana/domain/social/InitStatus;ILjava/lang/Exception;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InitFeed {
    private final Exception error;
    private boolean hasRestrictedContact;
    private final int initProgress;
    private final InitStatus status;

    public static /* synthetic */ InitFeed copy$default(InitFeed initFeed, InitStatus initStatus, int i, Exception exc, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            initStatus = initFeed.status;
        }
        if ((i2 & 2) != 0) {
            i = initFeed.initProgress;
        }
        if ((i2 & 4) != 0) {
            exc = initFeed.error;
        }
        if ((i2 & 8) != 0) {
            z = initFeed.hasRestrictedContact;
        }
        return initFeed.copy(initStatus, i, exc, z);
    }

    /* renamed from: component1  reason: from getter */
    public final InitStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final int getInitProgress() {
        return this.initProgress;
    }

    /* renamed from: component3  reason: from getter */
    public final Exception getError() {
        return this.error;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getHasRestrictedContact() {
        return this.hasRestrictedContact;
    }

    public final InitFeed copy(InitStatus status, int initProgress, Exception error, boolean hasRestrictedContact) {
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(error, "");
        return new InitFeed(status, initProgress, error, hasRestrictedContact);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.status.hashCode();
        int i = this.initProgress;
        int hashCode2 = this.error.hashCode();
        boolean z = this.hasRestrictedContact;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((((hashCode * 31) + i) * 31) + hashCode2) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InitFeed(status=");
        sb.append(this.status);
        sb.append(", initProgress=");
        sb.append(this.initProgress);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", hasRestrictedContact=");
        sb.append(this.hasRestrictedContact);
        sb.append(')');
        return sb.toString();
    }

    public InitFeed(InitStatus initStatus, int i, Exception exc, boolean z) {
        Intrinsics.checkNotNullParameter(initStatus, "");
        Intrinsics.checkNotNullParameter(exc, "");
        this.status = initStatus;
        this.initProgress = i;
        this.error = exc;
        this.hasRestrictedContact = z;
    }

    @JvmName(name = "getStatus")
    public final InitStatus getStatus() {
        return this.status;
    }

    @JvmName(name = "getInitProgress")
    public final int getInitProgress() {
        return this.initProgress;
    }

    public /* synthetic */ InitFeed(InitStatus initStatus, int i, Exception exc, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(initStatus, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? new Exception() : exc, (i2 & 8) != 0 ? false : z);
    }

    @JvmName(name = "getError")
    public final Exception getError() {
        return this.error;
    }

    @JvmName(name = "getHasRestrictedContact")
    public final boolean getHasRestrictedContact() {
        return this.hasRestrictedContact;
    }

    @JvmName(name = "setHasRestrictedContact")
    public final void setHasRestrictedContact(boolean z) {
        this.hasRestrictedContact = z;
    }

    public final boolean equals(Object other) {
        if (other instanceof InitFeed) {
            InitFeed initFeed = (InitFeed) other;
            return this.status == initFeed.status && this.initProgress == initFeed.initProgress;
        }
        return false;
    }

    public final boolean isFinished() {
        return this.status == InitStatus.FINISH;
    }

    public final FeedInit toFeedInit() {
        return new FeedInit(this.initProgress, this.status);
    }

    public final boolean isError() {
        return this.status == InitStatus.ERROR;
    }
}
