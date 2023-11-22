package id.dana.sendmoney.ui.globalsend.form.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.cashier.view.InputCardNumberView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b*\u0018\u0000 G2\u00020\u0001:\u0001GBß\u0001\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0006\u00101\u001a\u00020\u0005\u0012\u0006\u00102\u001a\u00020\u0005\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0005\u0012\u0006\u00106\u001a\u00020\u0005\u0012\u0006\u00107\u001a\u00020\u0005\u0012\u0006\u00108\u001a\u00020\u0005\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0005\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0005\u0012\u0006\u0010=\u001a\u00020\u0005\u0012\u0006\u0010>\u001a\u00020\u0005\u0012\u0006\u0010?\u001a\u00020\u0005\u0012\u0006\u0010@\u001a\u00020\u0005\u0012\u0006\u0010A\u001a\u00020\u001d\u0012\u0006\u0010B\u001a\u00020\u001d\u0012\u0006\u0010C\u001a\u00020\u0005\u0012\u0006\u0010D\u001a\u00020\u0005¢\u0006\u0004\bE\u0010FJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u001dX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR\u0011\u0010\u0018\u001a\u00020\u001dX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0011\u0010 \u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b \u0010\u000fR\u0011\u0010\"\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b!\u0010\u000fR\u0011\u0010#\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u000fR\u0011\u0010!\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b#\u0010\u000fR\u0011\u0010%\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b$\u0010\u000fR\u0011\u0010&\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b&\u0010\u000fR\u0011\u0010'\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b'\u0010\u000fR\u0011\u0010(\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b%\u0010\u000fR\u0011\u0010$\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b(\u0010\u000fR\u0011\u0010*\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b)\u0010\u000fR\u0011\u0010)\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b+\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getAuthRequestContext", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "GetContactSyncConfig", "", "J", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda6", "getCallingPid", "whenAvailable", "readMicros", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeneficiaryInfoModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final long DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String initRecordTimeStamp;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda3;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public final String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final String isLayoutRequested;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String PrepareContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    public final String whenAvailable;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final long NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public final String newProxyInstance;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;
    public final String moveToNextValue;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: readMicros  reason: from kotlin metadata */
    public final String getCallingPid;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final Parcelable.Creator<BeneficiaryInfoModel> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.newProxyInstance);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.getCallingPid);
        p0.writeString(this.moveToNextValue);
        p0.writeLong(this.DatabaseTableConfigUtil);
        p0.writeLong(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.whenAvailable);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
    }

    public BeneficiaryInfoModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, long j, long j2, String str24, String str25) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        Intrinsics.checkNotNullParameter(str18, "");
        Intrinsics.checkNotNullParameter(str19, "");
        Intrinsics.checkNotNullParameter(str20, "");
        Intrinsics.checkNotNullParameter(str21, "");
        Intrinsics.checkNotNullParameter(str22, "");
        Intrinsics.checkNotNullParameter(str23, "");
        Intrinsics.checkNotNullParameter(str24, "");
        Intrinsics.checkNotNullParameter(str25, "");
        this.MyBillsEntityDataFactory = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str3;
        this.scheduleImpl = str4;
        this.PlaceComponentResult = str5;
        this.lookAheadTest = str6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str7;
        this.getErrorConfigVersion = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str9;
        this.FragmentBottomSheetPaymentSettingBinding = str10;
        this.BuiltInFictitiousFunctionClassFactory = str11;
        this.getAuthRequestContext = str12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str14;
        this.GetContactSyncConfig = str15;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str17;
        this.initRecordTimeStamp = str18;
        this.isLayoutRequested = str19;
        this.newProxyInstance = str20;
        this.PrepareContext = str21;
        this.getCallingPid = str22;
        this.moveToNextValue = str23;
        this.DatabaseTableConfigUtil = j;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = j2;
        this.whenAvailable = str24;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str25;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        return sb.toString();
    }

    public final String MyBillsEntityDataFactory() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str.length() == 0) {
            str = "VISA";
        }
        return str;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<BeneficiaryInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BeneficiaryInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new BeneficiaryInfoModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BeneficiaryInfoModel[] newArray(int i) {
            return new BeneficiaryInfoModel[i];
        }
    }
}
