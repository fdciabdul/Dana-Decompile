package id.dana.oauth.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u001b\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0001ABý\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010&\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b?\u0010@J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010%\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u001a\u0010)\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010&X\u0086\u0002¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010'\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b+\u0010\u0017R\u0014\u0010,\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0014\u0010+\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b,\u0010\u0017"}, d2 = {"Lid/dana/oauth/model/OauthParamsModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "hashCode", "BuiltInFictitiousFunctionClassFactory", "()Z", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "lookAheadTest", "moveToNextValue", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/util/List;", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "newProxyInstance", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class OauthParamsModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;
    public String DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String GetContactSyncConfig;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public List<String> isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public String newProxyInstance;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Boolean PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public Boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public Boolean getErrorConfigVersion;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public String PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String lookAheadTest;
    public static final Parcelable.Creator<OauthParamsModel> CREATOR = new Creator();

    public OauthParamsModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof OauthParamsModel) {
            OauthParamsModel oauthParamsModel = (OauthParamsModel) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, oauthParamsModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.GetContactSyncConfig, oauthParamsModel.GetContactSyncConfig) && Intrinsics.areEqual(this.isLayoutRequested, oauthParamsModel.isLayoutRequested) && Intrinsics.areEqual(this.newProxyInstance, oauthParamsModel.newProxyInstance) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, oauthParamsModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, oauthParamsModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.getErrorConfigVersion, oauthParamsModel.getErrorConfigVersion) && Intrinsics.areEqual(this.getAuthRequestContext, oauthParamsModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, oauthParamsModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.lookAheadTest, oauthParamsModel.lookAheadTest) && Intrinsics.areEqual(this.scheduleImpl, oauthParamsModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.PrepareContext, oauthParamsModel.PrepareContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.moveToNextValue, oauthParamsModel.moveToNextValue) && Intrinsics.areEqual(this.initRecordTimeStamp, oauthParamsModel.initRecordTimeStamp) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.PlaceComponentResult, oauthParamsModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.GetContactSyncConfig;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        List<String> list = this.isLayoutRequested;
        int hashCode4 = list == null ? 0 : list.hashCode();
        String str4 = this.newProxyInstance;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.MyBillsEntityDataFactory;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.DatabaseTableConfigUtil;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        Boolean bool = this.getErrorConfigVersion;
        int hashCode8 = bool == null ? 0 : bool.hashCode();
        String str7 = this.getAuthRequestContext;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.lookAheadTest;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.scheduleImpl;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode14 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.PrepareContext;
        int hashCode15 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode16 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.moveToNextValue;
        int hashCode17 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.initRecordTimeStamp;
        int hashCode18 = str16 == null ? 0 : str16.hashCode();
        Boolean bool2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode19 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.PlaceComponentResult;
        return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OauthParamsModel(NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeStringList(this.isLayoutRequested);
        p0.writeString(this.newProxyInstance);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.DatabaseTableConfigUtil);
        Boolean bool = this.getErrorConfigVersion;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.initRecordTimeStamp);
        Boolean bool2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.PlaceComponentResult;
        if (bool3 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(bool3.booleanValue() ? 1 : 0);
    }

    public OauthParamsModel(String str, String str2, String str3, List<String> list, String str4, String str5, String str6, Boolean bool, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Boolean bool2, Boolean bool3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.GetContactSyncConfig = str3;
        this.isLayoutRequested = list;
        this.newProxyInstance = str4;
        this.MyBillsEntityDataFactory = str5;
        this.DatabaseTableConfigUtil = str6;
        this.getErrorConfigVersion = bool;
        this.getAuthRequestContext = str7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str9;
        this.lookAheadTest = str10;
        this.scheduleImpl = str11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str12;
        this.PrepareContext = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = str14;
        this.moveToNextValue = str15;
        this.initRecordTimeStamp = str16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = bool2;
        this.PlaceComponentResult = bool3;
    }

    public /* synthetic */ OauthParamsModel(String str, String str2, String str3, List list, String str4, String str5, String str6, Boolean bool, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Boolean bool2, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? new ArrayList() : list, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? Boolean.FALSE : bool, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? "" : str8, (i & 1024) != 0 ? "" : str9, (i & 2048) != 0 ? "" : str10, (i & 4096) != 0 ? "" : str11, (i & 8192) != 0 ? "" : str12, (i & 16384) != 0 ? "" : str13, (i & 32768) != 0 ? "" : str14, (i & 65536) != 0 ? "" : str15, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str16, (i & 262144) != 0 ? Boolean.FALSE : bool2, (i & 524288) != 0 ? Boolean.FALSE : bool3);
    }

    public final String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("://authorize");
        return sb.toString();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, "2188400000001035");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<OauthParamsModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OauthParamsModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new OauthParamsModel(readString, readString2, readString3, createStringArrayList, readString4, readString5, readString6, valueOf, readString7, readString8, readString9, readString10, readString11, readString12, readString13, readString14, readString15, readString16, valueOf2, valueOf3);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OauthParamsModel[] newArray(int i) {
            return new OauthParamsModel[i];
        }
    }
}
