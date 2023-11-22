package id.dana.domain.featureconfig.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\f\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00052\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\n"}, d2 = {"Lid/dana/domain/featureconfig/model/ContactInjectionConfig;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/List;", "contactInjection", "contactName", "phone", "copy", "(ZLjava/lang/String;Ljava/util/List;)Lid/dana/domain/featureconfig/model/ContactInjectionConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getContactInjection", "Ljava/lang/String;", "getContactName", "Ljava/util/List;", "getPhone", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ContactInjectionConfig {
    @SerializedName("contact_injection")
    private final boolean contactInjection;
    @SerializedName("contact_name")
    private final String contactName;
    @SerializedName("phone")
    private final List<String> phone;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactInjectionConfig copy$default(ContactInjectionConfig contactInjectionConfig, boolean z, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = contactInjectionConfig.contactInjection;
        }
        if ((i & 2) != 0) {
            str = contactInjectionConfig.contactName;
        }
        if ((i & 4) != 0) {
            list = contactInjectionConfig.phone;
        }
        return contactInjectionConfig.copy(z, str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getContactInjection() {
        return this.contactInjection;
    }

    /* renamed from: component2  reason: from getter */
    public final String getContactName() {
        return this.contactName;
    }

    public final List<String> component3() {
        return this.phone;
    }

    public final ContactInjectionConfig copy(@JSONField(name = "contact_injection") boolean contactInjection, @JSONField(name = "contact_name") String contactName, @JSONField(name = "phone") List<String> phone) {
        Intrinsics.checkNotNullParameter(contactName, "");
        Intrinsics.checkNotNullParameter(phone, "");
        return new ContactInjectionConfig(contactInjection, contactName, phone);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ContactInjectionConfig) {
            ContactInjectionConfig contactInjectionConfig = (ContactInjectionConfig) other;
            return this.contactInjection == contactInjectionConfig.contactInjection && Intrinsics.areEqual(this.contactName, contactInjectionConfig.contactName) && Intrinsics.areEqual(this.phone, contactInjectionConfig.phone);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.contactInjection;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.contactName.hashCode()) * 31) + this.phone.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactInjectionConfig(contactInjection=");
        sb.append(this.contactInjection);
        sb.append(", contactName=");
        sb.append(this.contactName);
        sb.append(", phone=");
        sb.append(this.phone);
        sb.append(')');
        return sb.toString();
    }

    public ContactInjectionConfig(@JSONField(name = "contact_injection") boolean z, @JSONField(name = "contact_name") String str, @JSONField(name = "phone") List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.contactInjection = z;
        this.contactName = str;
        this.phone = list;
    }

    @JvmName(name = "getContactInjection")
    public final boolean getContactInjection() {
        return this.contactInjection;
    }

    @JvmName(name = "getContactName")
    public final String getContactName() {
        return this.contactName;
    }

    @JvmName(name = "getPhone")
    public final List<String> getPhone() {
        return this.phone;
    }
}
