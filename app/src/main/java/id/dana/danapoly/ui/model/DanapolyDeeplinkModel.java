package id.dana.danapoly.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013"}, d2 = {"Lid/dana/danapoly/ui/model/DanapolyDeeplinkModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "isDareNotification", "()Z", "isWinnerNotification", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "lastEventId", "Ljava/lang/String;", "getLastEventId", "()Ljava/lang/String;", "prizeEn", "getPrizeEn", "prizeId", "getPrizeId", "redirection", "getRedirection", "typeEn", "getTypeEn", "typeId", "getTypeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyDeeplinkModel implements Parcelable {
    public static final Parcelable.Creator<DanapolyDeeplinkModel> CREATOR = new Creator();
    private final String lastEventId;
    private final String prizeEn;
    private final String prizeId;
    private final String redirection;
    private final String typeEn;
    private final String typeId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<DanapolyDeeplinkModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DanapolyDeeplinkModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new DanapolyDeeplinkModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DanapolyDeeplinkModel[] newArray(int i) {
            return new DanapolyDeeplinkModel[i];
        }
    }

    public DanapolyDeeplinkModel() {
        this(null, null, null, null, null, null, 63, null);
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
        parcel.writeString(this.lastEventId);
        parcel.writeString(this.redirection);
    }

    public DanapolyDeeplinkModel(String str, String str2, String str3, String str4, String str5, String str6) {
        this.prizeEn = str;
        this.prizeId = str2;
        this.typeEn = str3;
        this.typeId = str4;
        this.lastEventId = str5;
        this.redirection = str6;
    }

    public /* synthetic */ DanapolyDeeplinkModel(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
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

    @JvmName(name = "getLastEventId")
    public final String getLastEventId() {
        return this.lastEventId;
    }

    @JvmName(name = "getRedirection")
    public final String getRedirection() {
        return this.redirection;
    }

    public final boolean isDareNotification() {
        return (this.prizeEn == null || this.prizeId == null || this.typeEn == null || this.typeId == null) ? false : true;
    }

    public final boolean isWinnerNotification() {
        if (Intrinsics.areEqual(this.redirection, "leaderboard")) {
            String str = this.lastEventId;
            return !(str == null || str.length() == 0);
        }
        return false;
    }
}
