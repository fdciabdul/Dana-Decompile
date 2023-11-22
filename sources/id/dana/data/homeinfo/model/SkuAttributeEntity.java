package id.dana.data.homeinfo.model;

import id.dana.danah5.DanaH5;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b.\u0010/J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u008e\u0001\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\"\u0010\tR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\tR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b%\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b&\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b'\u0010\tR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u0005R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b*\u0010\u0005R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b+\u0010\u0005R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b,\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b-\u0010\t"}, d2 = {"Lid/dana/data/homeinfo/model/SkuAttributeEntity;", "Ljava/io/Serializable;", "", "", "component1", "()Ljava/util/List;", "component2", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "component8", "component9", DanaH5.SERVICE_KEY, "prepaidKey", "postpaidKey", "backgroundColor", "title", "icon", "buttonDescription", "serviceName", "link", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/homeinfo/model/SkuAttributeEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBackgroundColor", "getButtonDescription", "getIcon", "getLink", "Ljava/util/List;", "getPostpaidKey", "getPrepaidKey", "getServiceKey", "getServiceName", "getTitle", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SkuAttributeEntity implements Serializable {
    public String backgroundColor;
    public String buttonDescription;
    public String icon;
    public String link;
    public List<String> postpaidKey;
    public List<String> prepaidKey;
    public List<String> serviceKey;
    public String serviceName;
    public String title;

    public SkuAttributeEntity() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final List<String> component1() {
        return this.serviceKey;
    }

    public final List<String> component2() {
        return this.prepaidKey;
    }

    public final List<String> component3() {
        return this.postpaidKey;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component7  reason: from getter */
    public final String getButtonDescription() {
        return this.buttonDescription;
    }

    /* renamed from: component8  reason: from getter */
    public final String getServiceName() {
        return this.serviceName;
    }

    /* renamed from: component9  reason: from getter */
    public final String getLink() {
        return this.link;
    }

    public final SkuAttributeEntity copy(List<String> serviceKey, List<String> prepaidKey, List<String> postpaidKey, String backgroundColor, String title, String icon, String buttonDescription, String serviceName, String link) {
        return new SkuAttributeEntity(serviceKey, prepaidKey, postpaidKey, backgroundColor, title, icon, buttonDescription, serviceName, link);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SkuAttributeEntity) {
            SkuAttributeEntity skuAttributeEntity = (SkuAttributeEntity) other;
            return Intrinsics.areEqual(this.serviceKey, skuAttributeEntity.serviceKey) && Intrinsics.areEqual(this.prepaidKey, skuAttributeEntity.prepaidKey) && Intrinsics.areEqual(this.postpaidKey, skuAttributeEntity.postpaidKey) && Intrinsics.areEqual(this.backgroundColor, skuAttributeEntity.backgroundColor) && Intrinsics.areEqual(this.title, skuAttributeEntity.title) && Intrinsics.areEqual(this.icon, skuAttributeEntity.icon) && Intrinsics.areEqual(this.buttonDescription, skuAttributeEntity.buttonDescription) && Intrinsics.areEqual(this.serviceName, skuAttributeEntity.serviceName) && Intrinsics.areEqual(this.link, skuAttributeEntity.link);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.serviceKey;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.prepaidKey;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        List<String> list3 = this.postpaidKey;
        int hashCode3 = list3 == null ? 0 : list3.hashCode();
        String str = this.backgroundColor;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.title;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.icon;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.buttonDescription;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.serviceName;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.link;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SkuAttributeEntity(serviceKey=");
        sb.append(this.serviceKey);
        sb.append(", prepaidKey=");
        sb.append(this.prepaidKey);
        sb.append(", postpaidKey=");
        sb.append(this.postpaidKey);
        sb.append(", backgroundColor=");
        sb.append(this.backgroundColor);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", buttonDescription=");
        sb.append(this.buttonDescription);
        sb.append(", serviceName=");
        sb.append(this.serviceName);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(')');
        return sb.toString();
    }

    public SkuAttributeEntity(List<String> list, List<String> list2, List<String> list3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.serviceKey = list;
        this.prepaidKey = list2;
        this.postpaidKey = list3;
        this.backgroundColor = str;
        this.title = str2;
        this.icon = str3;
        this.buttonDescription = str4;
        this.serviceName = str5;
        this.link = str6;
    }

    public /* synthetic */ SkuAttributeEntity(List list, List list2, List list3, String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) == 0 ? str6 : null);
    }

    @JvmName(name = "getServiceKey")
    public final List<String> getServiceKey() {
        return this.serviceKey;
    }

    @JvmName(name = "getPrepaidKey")
    public final List<String> getPrepaidKey() {
        return this.prepaidKey;
    }

    @JvmName(name = "getPostpaidKey")
    public final List<String> getPostpaidKey() {
        return this.postpaidKey;
    }

    @JvmName(name = "getBackgroundColor")
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getButtonDescription")
    public final String getButtonDescription() {
        return this.buttonDescription;
    }

    @JvmName(name = "getServiceName")
    public final String getServiceName() {
        return this.serviceName;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }
}
