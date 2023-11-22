package id.dana.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.home.model.PromoBannerAnnouncementModel;
import id.dana.domain.home.model.PromoBannerContentModel;
import id.dana.utils.LocaleUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CdpContentModel implements Parcelable {
    public static final Parcelable.Creator<CdpContentModel> CREATOR = new Parcelable.Creator<CdpContentModel>() { // from class: id.dana.model.CdpContentModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CdpContentModel createFromParcel(Parcel parcel) {
            return new CdpContentModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CdpContentModel[] newArray(int i) {
            return new CdpContentModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String DatabaseTableConfigUtil;
    public String FragmentBottomSheetPaymentSettingBinding;
    public String GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public int NetworkUserEntityData$$ExternalSyntheticLambda3;
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public String NetworkUserEntityData$$ExternalSyntheticLambda5;
    public Date NetworkUserEntityData$$ExternalSyntheticLambda6;
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    public Date NetworkUserEntityData$$ExternalSyntheticLambda8;
    public List<CdpContentModel> PlaceComponentResult;
    public Date PrepareContext;
    public String getAuthRequestContext;
    public String getCallingPid;
    public String getErrorConfigVersion;
    public String initRecordTimeStamp;
    public Date isLayoutRequested;
    public String lookAheadTest;
    public String moveToNextValue;
    public String newProxyInstance;
    public String readMicros;
    public String scheduleImpl;
    public String whenAvailable;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeString(this.DatabaseTableConfigUtil);
        parcel.writeString(this.GetContactSyncConfig);
        Date date = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        Date date2 = this.PrepareContext;
        parcel.writeLong(date2 != null ? date2.getTime() : -1L);
        Date date3 = this.isLayoutRequested;
        parcel.writeLong(date3 != null ? date3.getTime() : -1L);
        Date date4 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        parcel.writeLong(date4 != null ? date4.getTime() : -1L);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        parcel.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeString(this.whenAvailable);
        parcel.writeString(this.getCallingPid);
        parcel.writeString(this.readMicros);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.scheduleImpl);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.moveToNextValue);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeTypedList(this.PlaceComponentResult);
        parcel.writeString(this.newProxyInstance);
    }

    public CdpContentModel() {
    }

    protected CdpContentModel(Parcel parcel) {
        this.initRecordTimeStamp = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readString();
        this.GetContactSyncConfig = parcel.readString();
        long readLong = parcel.readLong();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = readLong == -1 ? null : new Date(readLong);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = parcel.readString();
        long readLong2 = parcel.readLong();
        this.PrepareContext = readLong2 == -1 ? null : new Date(readLong2);
        long readLong3 = parcel.readLong();
        this.isLayoutRequested = readLong3 == -1 ? null : new Date(readLong3);
        long readLong4 = parcel.readLong();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = readLong4 != -1 ? new Date(readLong4) : null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = parcel.readString();
        this.FragmentBottomSheetPaymentSettingBinding = parcel.readString();
        this.whenAvailable = parcel.readString();
        this.getCallingPid = parcel.readString();
        this.readMicros = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.scheduleImpl = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.moveToNextValue = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.PlaceComponentResult = parcel.createTypedArrayList(CREATOR);
        this.newProxyInstance = parcel.readString();
    }

    public static List<PromoBannerContentModel> KClassImpl$Data$declaredNonStaticMembers$2(List<CdpContentModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (CdpContentModel cdpContentModel : list) {
            String str = cdpContentModel.initRecordTimeStamp;
            String str2 = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            String str3 = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str4 = cdpContentModel.DatabaseTableConfigUtil;
            String str5 = cdpContentModel.GetContactSyncConfig;
            Date date = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda8;
            String format = date != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LocaleUtil.KClassImpl$Data$declaredNonStaticMembers$2()).format(date) : null;
            String str6 = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
            Date date2 = cdpContentModel.PrepareContext;
            String format2 = date2 != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LocaleUtil.KClassImpl$Data$declaredNonStaticMembers$2()).format(date2) : null;
            Date date3 = cdpContentModel.isLayoutRequested;
            String format3 = date3 != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LocaleUtil.KClassImpl$Data$declaredNonStaticMembers$2()).format(date3) : null;
            Date date4 = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda6;
            arrayList.add(new PromoBannerContentModel(str, str2, str3, str4, str5, format, str6, format2, format3, date4 != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LocaleUtil.KClassImpl$Data$declaredNonStaticMembers$2()).format(date4) : null, cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda5, Integer.valueOf(cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda3), cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4, cdpContentModel.FragmentBottomSheetPaymentSettingBinding, cdpContentModel.whenAvailable, cdpContentModel.getCallingPid, cdpContentModel.readMicros, cdpContentModel.newProxyInstance));
        }
        return arrayList;
    }

    public static List<PromoBannerAnnouncementModel> MyBillsEntityDataFactory(List<CdpContentModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (Iterator<CdpContentModel> it = list.iterator(); it.hasNext(); it = it) {
            CdpContentModel next = it.next();
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new PromoBannerAnnouncementModel(next.NetworkUserEntityData$$ExternalSyntheticLambda2, next.NetworkUserEntityData$$ExternalSyntheticLambda1, next.DatabaseTableConfigUtil, next.GetContactSyncConfig, next.NetworkUserEntityData$$ExternalSyntheticLambda4, next.NetworkUserEntityData$$ExternalSyntheticLambda0, next.scheduleImpl, next.getErrorConfigVersion, next.getAuthRequestContext, next.KClassImpl$Data$declaredNonStaticMembers$2, next.moveToNextValue, next.MyBillsEntityDataFactory, next.lookAheadTest, next.BuiltInFictitiousFunctionClassFactory));
            arrayList = arrayList2;
        }
        return arrayList;
    }
}
