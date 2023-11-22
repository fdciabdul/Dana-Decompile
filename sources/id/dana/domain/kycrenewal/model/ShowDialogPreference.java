package id.dana.domain.kycrenewal.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/domain/kycrenewal/model/ShowDialogPreference;", "", "", "component1", "()Z", "", "component2", "()J", ContainerUIProvider.KEY_SHOW, LogConstants.KEY_TIME_STAPM, "copy", "(ZJ)Lid/dana/domain/kycrenewal/model/ShowDialogPreference;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getShow", "J", "getTimeStamp", "<init>", "(ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ShowDialogPreference {
    private final boolean show;
    private final long timeStamp;

    public static /* synthetic */ ShowDialogPreference copy$default(ShowDialogPreference showDialogPreference, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = showDialogPreference.show;
        }
        if ((i & 2) != 0) {
            j = showDialogPreference.timeStamp;
        }
        return showDialogPreference.copy(z, j);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* renamed from: component2  reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final ShowDialogPreference copy(boolean show, long timeStamp) {
        return new ShowDialogPreference(show, timeStamp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ShowDialogPreference) {
            ShowDialogPreference showDialogPreference = (ShowDialogPreference) other;
            return this.show == showDialogPreference.show && this.timeStamp == showDialogPreference.timeStamp;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.show;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.timeStamp);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShowDialogPreference(show=");
        sb.append(this.show);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(')');
        return sb.toString();
    }

    public ShowDialogPreference(boolean z, long j) {
        this.show = z;
        this.timeStamp = j;
    }

    @JvmName(name = "getShow")
    public final boolean getShow() {
        return this.show;
    }

    @JvmName(name = "getTimeStamp")
    public final long getTimeStamp() {
        return this.timeStamp;
    }
}
