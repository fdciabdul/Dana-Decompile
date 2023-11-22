package id.dana.notification;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class NotificationData implements Parcelable {
    public static final Parcelable.Creator<NotificationData> CREATOR = new Parcelable.Creator<NotificationData>() { // from class: id.dana.notification.NotificationData.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ NotificationData createFromParcel(Parcel parcel) {
            return new NotificationData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotificationData[] newArray(int i) {
            return new NotificationData[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String DatabaseTableConfigUtil;
    public String GetContactSyncConfig;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public HashMap<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;
    String PlaceComponentResult;
    String getAuthRequestContext;
    public String getErrorConfigVersion;
    String initRecordTimeStamp;
    String lookAheadTest;
    public String moveToNextValue;
    String scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NotificationData() {
    }

    protected NotificationData(Parcel parcel) {
        this.scheduleImpl = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.moveToNextValue = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.initRecordTimeStamp = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readString();
        this.GetContactSyncConfig = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.moveToNextValue);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.GetContactSyncConfig);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeMap(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public final boolean MyBillsEntityDataFactory() {
        return !TextUtils.isEmpty(this.DatabaseTableConfigUtil) && this.DatabaseTableConfigUtil.equals("lazada");
    }
}
