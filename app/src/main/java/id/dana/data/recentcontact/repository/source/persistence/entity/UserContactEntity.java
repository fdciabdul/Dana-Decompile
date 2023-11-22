package id.dana.data.recentcontact.repository.source.persistence.entity;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007Jj\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\u0007R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b(\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b)\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b,\u0010\u000b"}, d2 = {"Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;", "", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "()Ljava/lang/Long;", "component6", "", "component7", "()Ljava/lang/Boolean;", "component8", "uid", "phoneNumber", "rawPhoneNumber", "name", "updatedAt", "createdAt", "isDanaUser", "displayPhoto", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Long;", "getCreatedAt", "Ljava/lang/String;", "getDisplayPhoto", "Ljava/lang/Boolean;", "getName", "getPhoneNumber", "getRawPhoneNumber", "J", "getUid", "getUpdatedAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserContactEntity {
    private final Long createdAt;
    private final String displayPhoto;
    private final Boolean isDanaUser;
    private final String name;
    private final String phoneNumber;
    private final String rawPhoneNumber;
    private final long uid;
    private final Long updatedAt;

    /* renamed from: component1  reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRawPhoneNumber() {
        return this.rawPhoneNumber;
    }

    /* renamed from: component4  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5  reason: from getter */
    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component6  reason: from getter */
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getIsDanaUser() {
        return this.isDanaUser;
    }

    /* renamed from: component8  reason: from getter */
    public final String getDisplayPhoto() {
        return this.displayPhoto;
    }

    public final UserContactEntity copy(long uid, String phoneNumber, String rawPhoneNumber, String name, Long updatedAt, Long createdAt, Boolean isDanaUser, String displayPhoto) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(rawPhoneNumber, "");
        return new UserContactEntity(uid, phoneNumber, rawPhoneNumber, name, updatedAt, createdAt, isDanaUser, displayPhoto);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserContactEntity) {
            UserContactEntity userContactEntity = (UserContactEntity) other;
            return this.uid == userContactEntity.uid && Intrinsics.areEqual(this.phoneNumber, userContactEntity.phoneNumber) && Intrinsics.areEqual(this.rawPhoneNumber, userContactEntity.rawPhoneNumber) && Intrinsics.areEqual(this.name, userContactEntity.name) && Intrinsics.areEqual(this.updatedAt, userContactEntity.updatedAt) && Intrinsics.areEqual(this.createdAt, userContactEntity.createdAt) && Intrinsics.areEqual(this.isDanaUser, userContactEntity.isDanaUser) && Intrinsics.areEqual(this.displayPhoto, userContactEntity.displayPhoto);
        }
        return false;
    }

    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.uid);
        int hashCode = this.phoneNumber.hashCode();
        int hashCode2 = this.rawPhoneNumber.hashCode();
        String str = this.name;
        int hashCode3 = str == null ? 0 : str.hashCode();
        Long l = this.updatedAt;
        int hashCode4 = l == null ? 0 : l.hashCode();
        Long l2 = this.createdAt;
        int hashCode5 = l2 == null ? 0 : l2.hashCode();
        Boolean bool = this.isDanaUser;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        String str2 = this.displayPhoto;
        return (((((((((((((m * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserContactEntity(uid=");
        sb.append(this.uid);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", rawPhoneNumber=");
        sb.append(this.rawPhoneNumber);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", isDanaUser=");
        sb.append(this.isDanaUser);
        sb.append(", displayPhoto=");
        sb.append(this.displayPhoto);
        sb.append(')');
        return sb.toString();
    }

    public UserContactEntity(long j, String str, String str2, String str3, Long l, Long l2, Boolean bool, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.uid = j;
        this.phoneNumber = str;
        this.rawPhoneNumber = str2;
        this.name = str3;
        this.updatedAt = l;
        this.createdAt = l2;
        this.isDanaUser = bool;
        this.displayPhoto = str4;
    }

    @JvmName(name = "getUid")
    public final long getUid() {
        return this.uid;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getRawPhoneNumber")
    public final String getRawPhoneNumber() {
        return this.rawPhoneNumber;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getUpdatedAt")
    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    @JvmName(name = "getCreatedAt")
    public final Long getCreatedAt() {
        return this.createdAt;
    }

    @JvmName(name = "isDanaUser")
    public final Boolean isDanaUser() {
        return this.isDanaUser;
    }

    @JvmName(name = "getDisplayPhoto")
    public final String getDisplayPhoto() {
        return this.displayPhoto;
    }
}
