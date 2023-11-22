package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() { // from class: android.support.v4.media.session.ParcelableVolumeInfo.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };
    public int BuiltInFictitiousFunctionClassFactory;
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public int PlaceComponentResult;
    public int getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(int i, int i2, int i3, int i4, int i5) {
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = i2;
        this.MyBillsEntityDataFactory = i3;
        this.BuiltInFictitiousFunctionClassFactory = i4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.PlaceComponentResult = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readInt();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
        this.getAuthRequestContext = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeInt(this.MyBillsEntityDataFactory);
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeInt(this.getAuthRequestContext);
    }
}
