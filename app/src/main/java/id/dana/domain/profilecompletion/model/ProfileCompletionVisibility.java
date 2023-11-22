package id.dana.domain.profilecompletion.model;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012"}, d2 = {"Lid/dana/domain/profilecompletion/model/ProfileCompletionVisibility;", "", "", "component1", "()Z", MaintenanceBroadcastResult.KEY_VISIBLE, "copy", "(Z)Lid/dana/domain/profilecompletion/model/ProfileCompletionVisibility;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isVisible", "", "toString", "()Ljava/lang/String;", "Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ProfileCompletionVisibility {
    private final boolean visible;

    public ProfileCompletionVisibility() {
        this(false, 1, null);
    }

    /* renamed from: component1  reason: from getter */
    private final boolean getVisible() {
        return this.visible;
    }

    public static /* synthetic */ ProfileCompletionVisibility copy$default(ProfileCompletionVisibility profileCompletionVisibility, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = profileCompletionVisibility.visible;
        }
        return profileCompletionVisibility.copy(z);
    }

    public final ProfileCompletionVisibility copy(boolean visible) {
        return new ProfileCompletionVisibility(visible);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProfileCompletionVisibility) && this.visible == ((ProfileCompletionVisibility) other).visible;
    }

    public final int hashCode() {
        boolean z = this.visible;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProfileCompletionVisibility(visible=");
        sb.append(this.visible);
        sb.append(')');
        return sb.toString();
    }

    public ProfileCompletionVisibility(boolean z) {
        this.visible = z;
    }

    public /* synthetic */ ProfileCompletionVisibility(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean isVisible() {
        return this.visible;
    }
}
