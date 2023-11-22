package id.dana.data.social.repository.source.persistence.entity;

import id.dana.danah5.constant.BridgeName;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u000bR\"\u0010\u001c\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u000bR\"\u0010\u001f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u000bR\"\u0010\"\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\u000bR\u001a\u0010%\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/data/social/repository/source/persistence/entity/FollowerItemEntity;", "Lid/dana/data/social/repository/source/persistence/entity/PhoneNumberToContactNameMappable;", "", "getActorUserId", "()Ljava/lang/String;", "getActorUsername", "getContactPhoneNumber", "getNickname", "deviceContactNickName", "", "updateNickName", "(Ljava/lang/String;)V", "avatar", "Ljava/lang/String;", "getAvatar", "", "gmtCreate", "J", "getGmtCreate", "()J", "setGmtCreate", "(J)V", "gmtModified", "getGmtModified", "setGmtModified", BranchLinkConstant.Params.LOGIN_ID, "getLoginId", "setLoginId", "nickName", "getNickName", "setNickName", "status", "getStatus", "setStatus", "userId", "getUserId", "setUserId", "username", BridgeName.GET_USERNAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FollowerItemEntity implements PhoneNumberToContactNameMappable {
    private final String avatar;
    private long gmtCreate;
    private long gmtModified;
    private String loginId;
    private String nickName;
    private String status;
    private String userId;
    private final String username;

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final /* synthetic */ String getHeaderName() {
        return PhoneNumberToContactNameMappable.CC.$default$getHeaderName(this);
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final /* synthetic */ void updateHeaderName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
    }

    public FollowerItemEntity(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.userId = str;
        this.loginId = str2;
        this.nickName = str3;
        this.status = str4;
        this.gmtCreate = j;
        this.gmtModified = j2;
        this.avatar = str5;
        this.username = str6;
    }

    public /* synthetic */ FollowerItemEntity(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, j, j2, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "setLoginId")
    public final void setLoginId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.loginId = str;
    }

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "setNickName")
    public final void setNickName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.nickName = str;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }

    @JvmName(name = "getGmtCreate")
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "setGmtCreate")
    public final void setGmtCreate(long j) {
        this.gmtCreate = j;
    }

    @JvmName(name = "getGmtModified")
    public final long getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "setGmtModified")
    public final void setGmtModified(long j) {
        this.gmtModified = j;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final String getNickname() {
        return this.nickName;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getContactPhoneNumber  reason: from getter */
    public final String getLoginId() {
        return this.loginId;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    public final void updateNickName(String deviceContactNickName) {
        Intrinsics.checkNotNullParameter(deviceContactNickName, "");
        this.nickName = deviceContactNickName;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUsername  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    @Override // id.dana.data.social.repository.source.persistence.entity.PhoneNumberToContactNameMappable
    /* renamed from: getActorUserId  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }
}
