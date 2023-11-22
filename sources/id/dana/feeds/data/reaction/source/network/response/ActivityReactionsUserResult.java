package id.dana.feeds.data.reaction.source.network.response;

import id.dana.danah5.constant.BridgeName;
import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.reactions.model.ActivityReactionsUser;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b7\u00108J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010'R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010(\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010'R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010(\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010'R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010(\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010'R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010(\u001a\u0004\b1\u0010\u0004\"\u0004\b2\u0010'R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010(\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010'R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010(\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u0010'"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;", "Lid/dana/data/social/repository/source/persistence/entity/PhoneNumberToContactNameMappable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "phoneNumber", "id", "nickName", "kycStatus", ExtendInfoUtilKt.PROFILE_AVATAR_KEY, "username", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getActorUserId", "getActorUsername", "getContactPhoneNumber", "getNickname", "", "hashCode", "()I", "Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "toActivityReactiosUser", "()Lid/dana/feeds/domain/reactions/model/ActivityReactionsUser;", "toString", "deviceContactNickName", "", "updateNickName", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getDisplayName", "setDisplayName", "getId", "setId", "getKycStatus", "setKycStatus", "getNickName", "setNickName", "getPhoneNumber", "setPhoneNumber", "getProfilePictureUrl", "setProfilePictureUrl", BridgeName.GET_USERNAME, "setUsername", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActivityReactionsUserResult implements PhoneNumberToContactNameMappable {
    private String displayName;
    private String id;
    private String kycStatus;
    private String nickName;
    private String phoneNumber;
    private String profilePictureUrl;
    private String username;

    public ActivityReactionsUserResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ActivityReactionsUserResult copy$default(ActivityReactionsUserResult activityReactionsUserResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityReactionsUserResult.displayName;
        }
        if ((i & 2) != 0) {
            str2 = activityReactionsUserResult.phoneNumber;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = activityReactionsUserResult.id;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = activityReactionsUserResult.nickName;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = activityReactionsUserResult.kycStatus;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = activityReactionsUserResult.profilePictureUrl;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = activityReactionsUserResult.username;
        }
        return activityReactionsUserResult.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4  reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getKycStatus() {
        return this.kycStatus;
    }

    /* renamed from: component6  reason: from getter */
    public final String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final ActivityReactionsUserResult copy(String displayName, String phoneNumber, String id2, String nickName, String kycStatus, String profilePictureUrl, String username) {
        return new ActivityReactionsUserResult(displayName, phoneNumber, id2, nickName, kycStatus, profilePictureUrl, username);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ActivityReactionsUserResult) {
            ActivityReactionsUserResult activityReactionsUserResult = (ActivityReactionsUserResult) other;
            return Intrinsics.areEqual(this.displayName, activityReactionsUserResult.displayName) && Intrinsics.areEqual(this.phoneNumber, activityReactionsUserResult.phoneNumber) && Intrinsics.areEqual(this.id, activityReactionsUserResult.id) && Intrinsics.areEqual(this.nickName, activityReactionsUserResult.nickName) && Intrinsics.areEqual(this.kycStatus, activityReactionsUserResult.kycStatus) && Intrinsics.areEqual(this.profilePictureUrl, activityReactionsUserResult.profilePictureUrl) && Intrinsics.areEqual(this.username, activityReactionsUserResult.username);
        }
        return false;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final /* synthetic */ String getHeaderName() {
        return PhoneNumberToContactNameMappable.CC.$default$getHeaderName(this);
    }

    public final int hashCode() {
        String str = this.displayName;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.phoneNumber;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.id;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.nickName;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.kycStatus;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.profilePictureUrl;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.username;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityReactionsUserResult(displayName=");
        sb.append(this.displayName);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", nickName=");
        sb.append(this.nickName);
        sb.append(", kycStatus=");
        sb.append(this.kycStatus);
        sb.append(", profilePictureUrl=");
        sb.append(this.profilePictureUrl);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(')');
        return sb.toString();
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final /* synthetic */ void updateHeaderName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
    }

    public ActivityReactionsUserResult(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.displayName = str;
        this.phoneNumber = str2;
        this.id = str3;
        this.nickName = str4;
        this.kycStatus = str5;
        this.profilePictureUrl = str6;
        this.username = str7;
    }

    public /* synthetic */ ActivityReactionsUserResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        return this.displayName;
    }

    @JvmName(name = "setDisplayName")
    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "setNickName")
    public final void setNickName(String str) {
        this.nickName = str;
    }

    @JvmName(name = "getKycStatus")
    public final String getKycStatus() {
        return this.kycStatus;
    }

    @JvmName(name = "setKycStatus")
    public final void setKycStatus(String str) {
        this.kycStatus = str;
    }

    @JvmName(name = "getProfilePictureUrl")
    public final String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }

    @JvmName(name = "setProfilePictureUrl")
    public final void setProfilePictureUrl(String str) {
        this.profilePictureUrl = str;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "setUsername")
    public final void setUsername(String str) {
        this.username = str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final String getNickname() {
        String str = this.nickName;
        return str == null ? "" : str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getContactPhoneNumber */
    public final String getLoginId() {
        String str = this.phoneNumber;
        return str == null ? "" : str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final void updateNickName(String deviceContactNickName) {
        Intrinsics.checkNotNullParameter(deviceContactNickName, "");
        this.nickName = deviceContactNickName;
        this.displayName = deviceContactNickName;
    }

    public final ActivityReactionsUser toActivityReactiosUser() {
        String str = this.displayName;
        if (str == null) {
            str = "";
        }
        return new ActivityReactionsUser(str, this.phoneNumber, this.id, this.nickName, this.kycStatus, this.profilePictureUrl, this.username);
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUsername */
    public final String getUsername() {
        String str = this.username;
        return str == null ? "" : str;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUserId */
    public final String getUserId() {
        String str = this.id;
        return str == null ? "" : str;
    }
}
