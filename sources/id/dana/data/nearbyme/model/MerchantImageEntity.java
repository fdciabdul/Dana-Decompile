package id.dana.data.nearbyme.model;

import com.alibaba.griver.core.GriverParams;
import id.dana.domain.nearbyme.model.MerchantImage;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J>\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/nearbyme/model/MerchantImageEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "userId", "userName", "avatar", GriverParams.ShareParams.IMAGE_URL, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/nearbyme/model/MerchantImageEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/domain/nearbyme/model/MerchantImage;", "toMerchantImage", "()Lid/dana/domain/nearbyme/model/MerchantImage;", "toString", "Ljava/lang/String;", "getAvatar", "getImageUrl", "getUserId", "getUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MerchantImageEntity {
    private final String avatar;
    private final String imageUrl;
    private final String userId;
    private final String userName;

    public MerchantImageEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MerchantImageEntity copy$default(MerchantImageEntity merchantImageEntity, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = merchantImageEntity.userId;
        }
        if ((i & 2) != 0) {
            str2 = merchantImageEntity.userName;
        }
        if ((i & 4) != 0) {
            str3 = merchantImageEntity.avatar;
        }
        if ((i & 8) != 0) {
            str4 = merchantImageEntity.imageUrl;
        }
        return merchantImageEntity.copy(str, str2, str3, str4);
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

    public final MerchantImageEntity copy(String userId, String userName, String avatar, String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "");
        return new MerchantImageEntity(userId, userName, avatar, imageUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MerchantImageEntity) {
            MerchantImageEntity merchantImageEntity = (MerchantImageEntity) other;
            return Intrinsics.areEqual(this.userId, merchantImageEntity.userId) && Intrinsics.areEqual(this.userName, merchantImageEntity.userName) && Intrinsics.areEqual(this.avatar, merchantImageEntity.avatar) && Intrinsics.areEqual(this.imageUrl, merchantImageEntity.imageUrl);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.userName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.avatar;
        return (((((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.imageUrl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantImageEntity(userId=");
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

    public MerchantImageEntity(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str4, "");
        this.userId = str;
        this.userName = str2;
        this.avatar = str3;
        this.imageUrl = str4;
    }

    public /* synthetic */ MerchantImageEntity(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
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

    public final MerchantImage toMerchantImage() {
        String str = this.userId;
        if (str == null) {
            str = "";
        }
        String str2 = this.userName;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.avatar;
        return new MerchantImage(str, str2, str3 != null ? str3 : "", this.imageUrl);
    }
}
