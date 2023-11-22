package id.dana.sendmoney.ui.groupsend.recipient.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b%\b\u0016\u0018\u00002\u00020\u0001:\u00019B×\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0014¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u00148\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0010\u0010\u001bR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0014\u0010 \u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\u000fR\u0014\u0010!\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010\u000fR\u0014\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0012\u0010$\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010#R\u0011\u0010&\u001a\u00020\u0002X\u0017¢\u0006\u0006\n\u0004\b%\u0010#"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/model/BankModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getAuthRequestContext", "", "Z", "moveToNextValue", "getErrorConfigVersion", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "PrepareContext", "()Z", "scheduleImpl", "DatabaseTableConfigUtil", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda8", "I", "isLayoutRequested", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public class BankModel implements Parcelable {
    public static final Parcelable.Creator<BankModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public int isLayoutRequested;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;
    public String initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public final int NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/model/BankModel$Builder;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getAuthRequestContext", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "moveToNextValue", "lookAheadTest", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "GetContactSyncConfig", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private String PlaceComponentResult = "";
        private String KClassImpl$Data$declaredNonStaticMembers$2 = "";

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private String MyBillsEntityDataFactory = "";
        private String getAuthRequestContext = "";

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        private String GetContactSyncConfig = "";

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private String BuiltInFictitiousFunctionClassFactory = "";

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        private String moveToNextValue = "";

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private String getErrorConfigVersion = "";

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private String scheduleImpl = "";

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        private String lookAheadTest = "";

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        private String NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
    }

    public BankModel() {
        this(0, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, false, 262143, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.getAuthRequestContext ? 1 : 0);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.DatabaseTableConfigUtil);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeInt(this.isLayoutRequested);
        p0.writeInt(this.scheduleImpl ? 1 : 0);
    }

    public BankModel(int i, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, boolean z2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.getAuthRequestContext = z;
        this.getErrorConfigVersion = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.moveToNextValue = str6;
        this.lookAheadTest = str7;
        this.DatabaseTableConfigUtil = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str10;
        this.initRecordTimeStamp = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str12;
        this.BuiltInFictitiousFunctionClassFactory = str13;
        this.GetContactSyncConfig = str14;
        this.isLayoutRequested = i2;
        this.scheduleImpl = z2;
    }

    public /* synthetic */ BankModel(int i, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? "" : str4, (i3 & 64) != 0 ? "" : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? "" : str7, (i3 & 512) != 0 ? "" : str8, (i3 & 1024) != 0 ? "" : str9, (i3 & 2048) != 0 ? "" : str10, (i3 & 4096) != 0 ? "" : str11, (i3 & 8192) != 0 ? "" : str12, (i3 & 16384) != 0 ? "" : str13, (i3 & 32768) != 0 ? "" : str14, (i3 & 65536) != 0 ? 0 : i2, (i3 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z2);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankModel{instId='");
        sb.append(this.getErrorConfigVersion);
        sb.append("', instName='");
        sb.append(this.moveToNextValue);
        sb.append("', bankNumber='");
        sb.append(this.PlaceComponentResult);
        sb.append("', recipientName='");
        sb.append(this.initRecordTimeStamp);
        sb.append("'}");
        return sb.toString();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<BankModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BankModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new BankModel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BankModel[] newArray(int i) {
            return new BankModel[i];
        }
    }
}
