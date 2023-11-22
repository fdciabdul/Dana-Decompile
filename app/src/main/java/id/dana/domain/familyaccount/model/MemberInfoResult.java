package id.dana.domain.familyaccount.model;

import com.alipay.mobile.security.zim.api.ZIMFacade;
import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b \u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b#\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/MemberInfoResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "userId", "nickname", ZIMFacade.KEY_CERT_NAME, "certifyLevel", AccountEntityRepository.UpdateType.AVATAR, "gender", "phoneNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/MemberInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAvatarUrl", "getCertName", "getCertifyLevel", "getGender", "getNickname", "getPhoneNumber", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MemberInfoResult {
    private final String avatarUrl;
    private final String certName;
    private final String certifyLevel;
    private final String gender;
    private final String nickname;
    private final String phoneNumber;
    private final String userId;

    public MemberInfoResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MemberInfoResult copy$default(MemberInfoResult memberInfoResult, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberInfoResult.userId;
        }
        if ((i & 2) != 0) {
            str2 = memberInfoResult.nickname;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = memberInfoResult.certName;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = memberInfoResult.certifyLevel;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = memberInfoResult.avatarUrl;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = memberInfoResult.gender;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = memberInfoResult.phoneNumber;
        }
        return memberInfoResult.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCertName() {
        return this.certName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCertifyLevel() {
        return this.certifyLevel;
    }

    /* renamed from: component5  reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component7  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final MemberInfoResult copy(String userId, String nickname, String certName, String certifyLevel, String avatarUrl, String gender, String phoneNumber) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(nickname, "");
        Intrinsics.checkNotNullParameter(certName, "");
        Intrinsics.checkNotNullParameter(certifyLevel, "");
        Intrinsics.checkNotNullParameter(avatarUrl, "");
        Intrinsics.checkNotNullParameter(gender, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        return new MemberInfoResult(userId, nickname, certName, certifyLevel, avatarUrl, gender, phoneNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MemberInfoResult) {
            MemberInfoResult memberInfoResult = (MemberInfoResult) other;
            return Intrinsics.areEqual(this.userId, memberInfoResult.userId) && Intrinsics.areEqual(this.nickname, memberInfoResult.nickname) && Intrinsics.areEqual(this.certName, memberInfoResult.certName) && Intrinsics.areEqual(this.certifyLevel, memberInfoResult.certifyLevel) && Intrinsics.areEqual(this.avatarUrl, memberInfoResult.avatarUrl) && Intrinsics.areEqual(this.gender, memberInfoResult.gender) && Intrinsics.areEqual(this.phoneNumber, memberInfoResult.phoneNumber);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.userId.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.certName.hashCode()) * 31) + this.certifyLevel.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.phoneNumber.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemberInfoResult(userId=");
        sb.append(this.userId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", certName=");
        sb.append(this.certName);
        sb.append(", certifyLevel=");
        sb.append(this.certifyLevel);
        sb.append(", avatarUrl=");
        sb.append(this.avatarUrl);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(')');
        return sb.toString();
    }

    public MemberInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.userId = str;
        this.nickname = str2;
        this.certName = str3;
        this.certifyLevel = str4;
        this.avatarUrl = str5;
        this.gender = str6;
        this.phoneNumber = str7;
    }

    public /* synthetic */ MemberInfoResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "getCertName")
    public final String getCertName() {
        return this.certName;
    }

    @JvmName(name = "getCertifyLevel")
    public final String getCertifyLevel() {
        return this.certifyLevel;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "getGender")
    public final String getGender() {
        return this.gender;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }
}
