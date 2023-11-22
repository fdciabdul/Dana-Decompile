package id.dana.domain.miniprogram.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.griver.api.constants.GriverEvents;
import com.google.firebase.perf.util.Constants;
import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\"R\"\u0010\u0013\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b\u0013\u0010\n\"\u0004\b&\u0010'R\"\u0010\u0014\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b\u0014\u0010\n\"\u0004\b(\u0010'R\"\u0010\u0015\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010,R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010\"R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010\""}, d2 = {"Lid/dana/domain/miniprogram/model/MiniProgram;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Z", "component6", "", "component7", "()J", "appId", "title", "description", "logo", Constants.ENABLE_DISABLE, TrackerKey.SendMoneyProperties.IS_FAVORITE, "lastOpen", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJ)Lid/dana/domain/miniprogram/model/MiniProgram;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAppId", "setAppId", "(Ljava/lang/String;)V", "getDescription", "setDescription", "Z", "setEnabled", "(Z)V", "setFavorite", "J", "getLastOpen", "setLastOpen", "(J)V", "getLogo", "setLogo", "getTitle", GriverEvents.EVENT_SET_TITLE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MiniProgram {
    private String appId;
    private String description;
    private boolean isEnabled;
    private boolean isFavorite;
    private long lastOpen;
    private String logo;
    private String title;

    public MiniProgram() {
        this(null, null, null, null, false, false, 0L, 127, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component7  reason: from getter */
    public final long getLastOpen() {
        return this.lastOpen;
    }

    public final MiniProgram copy(String appId, String title, String description, String logo, boolean isEnabled, boolean isFavorite, long lastOpen) {
        Intrinsics.checkNotNullParameter(appId, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(logo, "");
        return new MiniProgram(appId, title, description, logo, isEnabled, isFavorite, lastOpen);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MiniProgram) {
            MiniProgram miniProgram = (MiniProgram) other;
            return Intrinsics.areEqual(this.appId, miniProgram.appId) && Intrinsics.areEqual(this.title, miniProgram.title) && Intrinsics.areEqual(this.description, miniProgram.description) && Intrinsics.areEqual(this.logo, miniProgram.logo) && this.isEnabled == miniProgram.isEnabled && this.isFavorite == miniProgram.isFavorite && this.lastOpen == miniProgram.lastOpen;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.appId.hashCode();
        int hashCode2 = this.title.hashCode();
        int hashCode3 = this.description.hashCode();
        int hashCode4 = this.logo.hashCode();
        boolean z = this.isEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        boolean z2 = this.isFavorite;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.lastOpen);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniProgram(appId=");
        sb.append(this.appId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", logo=");
        sb.append(this.logo);
        sb.append(", isEnabled=");
        sb.append(this.isEnabled);
        sb.append(", isFavorite=");
        sb.append(this.isFavorite);
        sb.append(", lastOpen=");
        sb.append(this.lastOpen);
        sb.append(')');
        return sb.toString();
    }

    public MiniProgram(String str, String str2, String str3, String str4, boolean z, boolean z2, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.appId = str;
        this.title = str2;
        this.description = str3;
        this.logo = str4;
        this.isEnabled = z;
        this.isFavorite = z2;
        this.lastOpen = j;
    }

    public /* synthetic */ MiniProgram(String str, String str2, String str3, String str4, boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? 0L : j);
    }

    @JvmName(name = "getAppId")
    public final String getAppId() {
        return this.appId;
    }

    @JvmName(name = "setAppId")
    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.appId = str;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.title = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.description = str;
    }

    @JvmName(name = "getLogo")
    public final String getLogo() {
        return this.logo;
    }

    @JvmName(name = "setLogo")
    public final void setLogo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.logo = str;
    }

    @JvmName(name = Constants.ENABLE_DISABLE)
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @JvmName(name = "setEnabled")
    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    @JvmName(name = TrackerKey.SendMoneyProperties.IS_FAVORITE)
    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @JvmName(name = "setFavorite")
    public final void setFavorite(boolean z) {
        this.isFavorite = z;
    }

    @JvmName(name = "getLastOpen")
    public final long getLastOpen() {
        return this.lastOpen;
    }

    @JvmName(name = "setLastOpen")
    public final void setLastOpen(long j) {
        this.lastOpen = j;
    }
}
