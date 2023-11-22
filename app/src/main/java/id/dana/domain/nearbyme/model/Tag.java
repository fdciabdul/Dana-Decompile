package id.dana.domain.nearbyme.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J:\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\"\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/Tag;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "id", "description", "iconUrl", "tagCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/Tag;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "getIconUrl", "getId", "getTagCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Tag implements Parcelable {
    public static final Parcelable.Creator<Tag> CREATOR = new Creator();
    private final String description;
    private final String iconUrl;
    private final String id;
    private final String tagCode;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<Tag> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Tag createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new Tag(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Tag[] newArray(int i) {
            return new Tag[i];
        }
    }

    public Tag() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tag.id;
        }
        if ((i & 2) != 0) {
            str2 = tag.description;
        }
        if ((i & 4) != 0) {
            str3 = tag.iconUrl;
        }
        if ((i & 8) != 0) {
            str4 = tag.tagCode;
        }
        return tag.copy(str, str2, str3, str4);
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

    public final Tag copy(String id2, String description, String iconUrl, String tagCode) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(tagCode, "");
        return new Tag(id2, description, iconUrl, tagCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Tag) {
            Tag tag = (Tag) other;
            return Intrinsics.areEqual(this.id, tag.id) && Intrinsics.areEqual(this.description, tag.description) && Intrinsics.areEqual(this.iconUrl, tag.iconUrl) && Intrinsics.areEqual(this.tagCode, tag.tagCode);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.id.hashCode();
        int hashCode2 = this.description.hashCode();
        String str = this.iconUrl;
        return (((((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.tagCode.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tag(id=");
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

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.tagCode);
    }

    public Tag(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.id = str;
        this.description = str2;
        this.iconUrl = str3;
        this.tagCode = str4;
    }

    public /* synthetic */ Tag(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
}
