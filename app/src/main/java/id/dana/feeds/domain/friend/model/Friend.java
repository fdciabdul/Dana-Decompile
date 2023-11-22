package id.dana.feeds.domain.friend.model;

import id.dana.danah5.constant.BridgeName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/friend/model/Friend;", "", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "", "defaultUsername", "Z", "getDefaultUsername", "()Z", "isRequester", "kycName", "getKycName", "", "requestDate", "J", "getRequestDate", "()J", "status", "getStatus", "userId", "getUserId", "username", BridgeName.GET_USERNAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Friend {
    private final String avatar;
    private final boolean defaultUsername;
    private final boolean isRequester;
    private final String kycName;
    private final long requestDate;
    private final String status;
    private final String userId;
    private final String username;

    public Friend() {
        this(null, null, null, null, null, false, 0L, false, 255, null);
    }

    public Friend(String str, String str2, String str3, String str4, String str5, boolean z, long j, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.avatar = str;
        this.userId = str2;
        this.username = str3;
        this.kycName = str4;
        this.status = str5;
        this.defaultUsername = z;
        this.requestDate = j;
        this.isRequester = z2;
    }

    public /* synthetic */ Friend(String str, String str2, String str3, String str4, String str5, boolean z, long j, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? false : z, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? z2 : false);
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "getKycName")
    public final String getKycName() {
        return this.kycName;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getDefaultUsername")
    public final boolean getDefaultUsername() {
        return this.defaultUsername;
    }

    @JvmName(name = "getRequestDate")
    public final long getRequestDate() {
        return this.requestDate;
    }

    @JvmName(name = "isRequester")
    /* renamed from: isRequester  reason: from getter */
    public final boolean getIsRequester() {
        return this.isRequester;
    }
}
