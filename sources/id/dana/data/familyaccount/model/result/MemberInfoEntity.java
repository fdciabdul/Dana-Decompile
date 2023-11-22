package id.dana.data.familyaccount.model.result;

import com.alipay.mobile.security.zim.api.ZIMFacade;
import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b \u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b#\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/MemberInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "userId", "nickname", ZIMFacade.KEY_CERT_NAME, "certifyLevel", AccountEntityRepository.UpdateType.AVATAR, "gender", "phoneNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/familyaccount/model/result/MemberInfoEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAvatarUrl", "getCertName", "getCertifyLevel", "getGender", "getNickname", "getPhoneNumber", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MemberInfoEntity {
    private final String avatarUrl;
    private final String certName;
    private final String certifyLevel;
    private final String gender;
    private final String nickname;
    private final String phoneNumber;
    private final String userId;

    public static /* synthetic */ MemberInfoEntity copy$default(MemberInfoEntity memberInfoEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberInfoEntity.userId;
        }
        if ((i & 2) != 0) {
            str2 = memberInfoEntity.nickname;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = memberInfoEntity.certName;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = memberInfoEntity.certifyLevel;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = memberInfoEntity.avatarUrl;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = memberInfoEntity.gender;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = memberInfoEntity.phoneNumber;
        }
        return memberInfoEntity.copy(str, str8, str9, str10, str11, str12, str7);
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

    public final MemberInfoEntity copy(String userId, String nickname, String certName, String certifyLevel, String avatarUrl, String gender, String phoneNumber) {
        return new MemberInfoEntity(userId, nickname, certName, certifyLevel, avatarUrl, gender, phoneNumber);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MemberInfoEntity) {
            MemberInfoEntity memberInfoEntity = (MemberInfoEntity) other;
            return Intrinsics.areEqual(this.userId, memberInfoEntity.userId) && Intrinsics.areEqual(this.nickname, memberInfoEntity.nickname) && Intrinsics.areEqual(this.certName, memberInfoEntity.certName) && Intrinsics.areEqual(this.certifyLevel, memberInfoEntity.certifyLevel) && Intrinsics.areEqual(this.avatarUrl, memberInfoEntity.avatarUrl) && Intrinsics.areEqual(this.gender, memberInfoEntity.gender) && Intrinsics.areEqual(this.phoneNumber, memberInfoEntity.phoneNumber);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.nickname;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.certName;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.certifyLevel;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.avatarUrl;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.gender;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.phoneNumber;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemberInfoEntity(userId=");
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

    public MemberInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.userId = str;
        this.nickname = str2;
        this.certName = str3;
        this.certifyLevel = str4;
        this.avatarUrl = str5;
        this.gender = str6;
        this.phoneNumber = str7;
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
