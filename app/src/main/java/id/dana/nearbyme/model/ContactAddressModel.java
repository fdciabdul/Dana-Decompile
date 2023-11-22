package id.dana.nearbyme.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class ContactAddressModel implements Parcelable {
    public static final Parcelable.Creator<ContactAddressModel> CREATOR = new Parcelable.Creator<ContactAddressModel>() { // from class: id.dana.nearbyme.model.ContactAddressModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ContactAddressModel createFromParcel(Parcel parcel) {
            return new ContactAddressModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactAddressModel[] newArray(int i) {
            return new ContactAddressModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String initRecordTimeStamp;
    public boolean lookAheadTest;
    public String moveToNextValue;
    public String scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContactAddressModel() {
    }

    protected ContactAddressModel(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.lookAheadTest = parcel.readByte() != 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.moveToNextValue = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readByte() != 0;
        this.initRecordTimeStamp = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.scheduleImpl);
        parcel.writeByte(this.lookAheadTest ? (byte) 1 : (byte) 0);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.moveToNextValue);
        parcel.writeByte(this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.initRecordTimeStamp);
    }
}
