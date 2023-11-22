package id.dana.feeds.data.friend.source.network.response;

import id.dana.danah5.constant.BridgeName;
import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006"}, d2 = {"Lid/dana/feeds/data/friend/source/network/response/FriendResponse;", "", "", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "getAvatarUrl", "()Ljava/lang/String;", "", "defaultUsername", "Ljava/lang/Boolean;", "getDefaultUsername", "()Ljava/lang/Boolean;", "", "requestDate", "Ljava/lang/Long;", "getRequestDate", "()Ljava/lang/Long;", "requesterUserId", "getRequesterUserId", "status", "getStatus", "userId", "getUserId", "userKYCName", "getUserKYCName", "username", BridgeName.GET_USERNAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendResponse {
    private final String avatarUrl;
    private final Boolean defaultUsername;
    private final Long requestDate;
    private final String requesterUserId;
    private final String status;
    private final String userId;
    private final String userKYCName;
    private final String username;

    public FriendResponse() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public FriendResponse(String str, String str2, String str3, String str4, String str5, Boolean bool, Long l, String str6) {
        this.avatarUrl = str;
        this.userId = str2;
        this.username = str3;
        this.userKYCName = str4;
        this.status = str5;
        this.defaultUsername = bool;
        this.requestDate = l;
        this.requesterUserId = str6;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "getUserKYCName")
    public final String getUserKYCName() {
        return this.userKYCName;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    public /* synthetic */ FriendResponse(String str, String str2, String str3, String str4, String str5, Boolean bool, Long l, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? Boolean.FALSE : bool, (i & 64) != 0 ? 0L : l, (i & 128) == 0 ? str6 : "");
    }

    @JvmName(name = "getDefaultUsername")
    public final Boolean getDefaultUsername() {
        return this.defaultUsername;
    }

    @JvmName(name = "getRequestDate")
    public final Long getRequestDate() {
        return this.requestDate;
    }

    @JvmName(name = "getRequesterUserId")
    public final String getRequesterUserId() {
        return this.requesterUserId;
    }
}
