package id.dana.pay;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class PayCardInfo implements Parcelable {
    public static final Parcelable.Creator<PayCardInfo> CREATOR = new Parcelable.Creator<PayCardInfo>() { // from class: id.dana.pay.PayCardInfo.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayCardInfo createFromParcel(Parcel parcel) {
            return new PayCardInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayCardInfo[] newArray(int i) {
            return new PayCardInfo[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String DatabaseTableConfigUtil;
    String GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    boolean initRecordTimeStamp;
    public String lookAheadTest;
    String moveToNextValue;
    public String scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PayCardInfo() {
    }

    protected PayCardInfo(Parcel parcel) {
        this.PlaceComponentResult = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readInt();
        this.getAuthRequestContext = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.GetContactSyncConfig = parcel.readString();
        this.initRecordTimeStamp = parcel.readByte() != 0;
        this.moveToNextValue = parcel.readString();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.initRecordTimeStamp;
    }

    public final boolean MyBillsEntityDataFactory() {
        return "DIRECT_DEBIT_CREDIT_CARD".equals(this.DatabaseTableConfigUtil) || "DIRECT_DEBIT_DEBIT_CARD".equals(this.DatabaseTableConfigUtil);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.MyBillsEntityDataFactory);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.GetContactSyncConfig);
        parcel.writeByte(this.initRecordTimeStamp ? (byte) 1 : (byte) 0);
        parcel.writeString(this.moveToNextValue);
    }
}
