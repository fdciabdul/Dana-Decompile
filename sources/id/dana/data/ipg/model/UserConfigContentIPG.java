package id.dana.data.ipg.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/ipg/model/UserConfigContentIPG;", "", "", "component1", "()Z", "userConsent", "copy", "(Z)Lid/dana/data/ipg/model/UserConfigContentIPG;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getUserConsent", "setUserConsent", "(Z)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserConfigContentIPG {
    @SerializedName("user_consent")
    private boolean userConsent;

    public UserConfigContentIPG() {
        this(false, 1, null);
    }

    public static /* synthetic */ UserConfigContentIPG copy$default(UserConfigContentIPG userConfigContentIPG, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = userConfigContentIPG.userConsent;
        }
        return userConfigContentIPG.copy(z);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getUserConsent() {
        return this.userConsent;
    }

    public final UserConfigContentIPG copy(boolean userConsent) {
        return new UserConfigContentIPG(userConsent);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UserConfigContentIPG) && this.userConsent == ((UserConfigContentIPG) other).userConsent;
    }

    public final int hashCode() {
        boolean z = this.userConsent;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserConfigContentIPG(userConsent=");
        sb.append(this.userConsent);
        sb.append(')');
        return sb.toString();
    }

    public UserConfigContentIPG(boolean z) {
        this.userConsent = z;
    }

    public /* synthetic */ UserConfigContentIPG(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @JvmName(name = "getUserConsent")
    public final boolean getUserConsent() {
        return this.userConsent;
    }

    @JvmName(name = "setUserConsent")
    public final void setUserConsent(boolean z) {
        this.userConsent = z;
    }
}
