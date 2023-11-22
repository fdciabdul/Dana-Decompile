package id.dana.data.nearbyme.model;

import id.dana.domain.nearbyme.model.Tag;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/model/TagEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "id", "description", "iconUrl", "tagCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/model/TagEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/domain/nearbyme/model/Tag;", "toTag", "()Lid/dana/domain/nearbyme/model/Tag;", "Ljava/lang/String;", "getDescription", "getIconUrl", "getId", "getTagCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TagEntity {
    private final String description;
    private final String iconUrl;
    private final String id;
    private final String tagCode;

    public TagEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TagEntity copy$default(TagEntity tagEntity, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagEntity.id;
        }
        if ((i & 2) != 0) {
            str2 = tagEntity.description;
        }
        if ((i & 4) != 0) {
            str3 = tagEntity.iconUrl;
        }
        if ((i & 8) != 0) {
            str4 = tagEntity.tagCode;
        }
        return tagEntity.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getTagCode() {
        return this.tagCode;
    }

    public final TagEntity copy(String id2, String description, String iconUrl, String tagCode) {
        return new TagEntity(id2, description, iconUrl, tagCode);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TagEntity) {
            TagEntity tagEntity = (TagEntity) other;
            return Intrinsics.areEqual(this.id, tagEntity.id) && Intrinsics.areEqual(this.description, tagEntity.description) && Intrinsics.areEqual(this.iconUrl, tagEntity.iconUrl) && Intrinsics.areEqual(this.tagCode, tagEntity.tagCode);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.description;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.iconUrl;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.tagCode;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TagEntity(id=");
        sb.append(this.id);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", tagCode=");
        sb.append(this.tagCode);
        sb.append(')');
        return sb.toString();
    }

    public TagEntity(String str, String str2, String str3, String str4) {
        this.id = str;
        this.description = str2;
        this.iconUrl = str3;
        this.tagCode = str4;
    }

    public /* synthetic */ TagEntity(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getTagCode")
    public final String getTagCode() {
        return this.tagCode;
    }

    public final Tag toTag() {
        String str = this.id;
        if (str == null) {
            str = "";
        }
        String str2 = this.description;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.iconUrl;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.tagCode;
        return new Tag(str, str2, str3, str4 != null ? str4 : "");
    }
}
