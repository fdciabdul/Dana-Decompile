package id.dana.domain.nearbyme.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.core.GriverParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\"\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/model/MerchantImage;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "userId", "userName", "avatar", GriverParams.ShareParams.IMAGE_URL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/MerchantImage;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAvatar", "getImageUrl", "getUserId", "getUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantImage implements Parcelable {
    public static final Parcelable.Creator<MerchantImage> CREATOR = new Creator();
    private final String avatar;
    private final String imageUrl;
    private final String userId;
    private final String userName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<MerchantImage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MerchantImage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new MerchantImage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MerchantImage[] newArray(int i) {
            return new MerchantImage[i];
        }
    }

    public static /* synthetic */ MerchantImage copy$default(MerchantImage merchantImage, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantImage.userId;
        }
        if ((i & 2) != 0) {
            str2 = merchantImage.userName;
        }
        if ((i & 4) != 0) {
            str3 = merchantImage.avatar;
        }
        if ((i & 8) != 0) {
            str4 = merchantImage.imageUrl;
        }
        return merchantImage.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final MerchantImage copy(String userId, String userName, String avatar, String imageUrl) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(userName, "");
        Intrinsics.checkNotNullParameter(avatar, "");
        Intrinsics.checkNotNullParameter(imageUrl, "");
        return new MerchantImage(userId, userName, avatar, imageUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantImage) {
            MerchantImage merchantImage = (MerchantImage) other;
            return Intrinsics.areEqual(this.userId, merchantImage.userId) && Intrinsics.areEqual(this.userName, merchantImage.userName) && Intrinsics.areEqual(this.avatar, merchantImage.avatar) && Intrinsics.areEqual(this.imageUrl, merchantImage.imageUrl);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.imageUrl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantImage(userId=");
        sb.append(this.userId);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.userId);
        parcel.writeString(this.userName);
        parcel.writeString(this.avatar);
        parcel.writeString(this.imageUrl);
    }

    public MerchantImage(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.userId = str;
        this.userName = str2;
        this.avatar = str3;
        this.imageUrl = str4;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getUserName")
    public final String getUserName() {
        return this.userName;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }
}
