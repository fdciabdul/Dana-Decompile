package id.dana.danapoly.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012"}, d2 = {"Lid/dana/danapoly/ui/model/PopupModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "isNotNull", "()Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "prizeEn", "Ljava/lang/String;", "getPrizeEn", "()Ljava/lang/String;", "prizeId", "getPrizeId", "typeEn", "getTypeEn", "typeId", "getTypeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PopupModel implements Parcelable {
    public static final Parcelable.Creator<PopupModel> CREATOR = new Creator();
    private final String prizeEn;
    private final String prizeId;
    private final String typeEn;
    private final String typeId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Creator implements Parcelable.Creator<PopupModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PopupModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new PopupModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PopupModel[] newArray(int i) {
            return new PopupModel[i];
        }
    }

    public PopupModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.prizeEn);
        parcel.writeString(this.prizeId);
        parcel.writeString(this.typeEn);
        parcel.writeString(this.typeId);
    }

    public PopupModel(String str, String str2, String str3, String str4) {
        this.prizeEn = str;
        this.prizeId = str2;
        this.typeEn = str3;
        this.typeId = str4;
    }

    public /* synthetic */ PopupModel(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    @JvmName(name = "getPrizeEn")
    public final String getPrizeEn() {
        return this.prizeEn;
    }

    @JvmName(name = "getPrizeId")
    public final String getPrizeId() {
        return this.prizeId;
    }

    @JvmName(name = "getTypeEn")
    public final String getTypeEn() {
        return this.typeEn;
    }

    @JvmName(name = "getTypeId")
    public final String getTypeId() {
        return this.typeId;
    }

    public final boolean isNotNull() {
        return (this.prizeEn == null || this.prizeId == null || this.typeEn == null || this.typeId == null) ? false : true;
    }
}
