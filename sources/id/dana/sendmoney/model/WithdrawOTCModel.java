package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class WithdrawOTCModel implements Parcelable {
    public static final Parcelable.Creator<WithdrawOTCModel> CREATOR = new Parcelable.Creator<WithdrawOTCModel>() { // from class: id.dana.sendmoney.model.WithdrawOTCModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ WithdrawOTCModel createFromParcel(Parcel parcel) {
            return new WithdrawOTCModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WithdrawOTCModel[] newArray(int i) {
            return new WithdrawOTCModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String lookAheadTest;
    public String scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ WithdrawOTCModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public WithdrawOTCModel() {
    }

    private WithdrawOTCModel(Parcel parcel) {
        this.MyBillsEntityDataFactory = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
