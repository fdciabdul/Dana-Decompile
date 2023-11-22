package id.dana.domain.sendmoney.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/domain/sendmoney/model/UserContact;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "contactPhone", "contactName", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/sendmoney/model/UserContact;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContactName", "getContactPhone", "Ljava/util/Map;", "getExtendInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserContact {
    private final String contactName;
    private final String contactPhone;
    private final Map<String, String> extendInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserContact copy$default(UserContact userContact, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userContact.contactPhone;
        }
        if ((i & 2) != 0) {
            str2 = userContact.contactName;
        }
        if ((i & 4) != 0) {
            map = userContact.extendInfo;
        }
        return userContact.copy(str, str2, map);
    }

    /* renamed from: component1  reason: from getter */
    public final String getContactPhone() {
        return this.contactPhone;
    }

    /* renamed from: component2  reason: from getter */
    public final String getContactName() {
        return this.contactName;
    }

    public final Map<String, String> component3() {
        return this.extendInfo;
    }

    public final UserContact copy(String contactPhone, String contactName, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(contactPhone, "");
        Intrinsics.checkNotNullParameter(contactName, "");
        return new UserContact(contactPhone, contactName, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserContact) {
            UserContact userContact = (UserContact) other;
            return Intrinsics.areEqual(this.contactPhone, userContact.contactPhone) && Intrinsics.areEqual(this.contactName, userContact.contactName) && Intrinsics.areEqual(this.extendInfo, userContact.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.contactPhone.hashCode();
        int hashCode2 = this.contactName.hashCode();
        Map<String, String> map = this.extendInfo;
        return (((hashCode * 31) + hashCode2) * 31) + (map == null ? 0 : map.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserContact(contactPhone=");
        sb.append(this.contactPhone);
        sb.append(", contactName=");
        sb.append(this.contactName);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public UserContact(String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.contactPhone = str;
        this.contactName = str2;
        this.extendInfo = map;
    }

    public /* synthetic */ UserContact(String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : map);
    }

    @JvmName(name = "getContactPhone")
    public final String getContactPhone() {
        return this.contactPhone;
    }

    @JvmName(name = "getContactName")
    public final String getContactName() {
        return this.contactName;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
