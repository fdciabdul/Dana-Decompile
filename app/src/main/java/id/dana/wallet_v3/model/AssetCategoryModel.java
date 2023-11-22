package id.dana.wallet_v3.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010!"}, d2 = {"Lid/dana/wallet_v3/model/AssetCategoryModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "category", "order", "copy", "(Ljava/lang/String;I)Lid/dana/wallet_v3/model/AssetCategoryModel;", "describeContents", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCategory", "setCategory", "(Ljava/lang/String;)V", "I", "getOrder", "setOrder", "(I)V", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AssetCategoryModel implements Parcelable {
    public static final Parcelable.Creator<AssetCategoryModel> CREATOR = new Creator();
    private String category;
    private int order;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<AssetCategoryModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AssetCategoryModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new AssetCategoryModel(parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AssetCategoryModel[] newArray(int i) {
            return new AssetCategoryModel[i];
        }
    }

    public static /* synthetic */ AssetCategoryModel copy$default(AssetCategoryModel assetCategoryModel, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = assetCategoryModel.category;
        }
        if ((i2 & 2) != 0) {
            i = assetCategoryModel.order;
        }
        return assetCategoryModel.copy(str, i);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component2  reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    public final AssetCategoryModel copy(String category, int order) {
        Intrinsics.checkNotNullParameter(category, "");
        return new AssetCategoryModel(category, order);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AssetCategoryModel) {
            AssetCategoryModel assetCategoryModel = (AssetCategoryModel) other;
            return Intrinsics.areEqual(this.category, assetCategoryModel.category) && this.order == assetCategoryModel.order;
        }
        return false;
    }

    public final int hashCode() {
        return (this.category.hashCode() * 31) + this.order;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetCategoryModel(category=");
        sb.append(this.category);
        sb.append(", order=");
        sb.append(this.order);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.category);
        parcel.writeInt(this.order);
    }

    public AssetCategoryModel(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        this.category = str;
        this.order = i;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "setCategory")
    public final void setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.category = str;
    }

    @JvmName(name = "getOrder")
    public final int getOrder() {
        return this.order;
    }

    @JvmName(name = "setOrder")
    public final void setOrder(int i) {
        this.order = i;
    }
}
