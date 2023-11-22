package id.dana.globalsearch.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bø\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\n0%\u0012\b\b\u0002\u00106\u001a\u00020\n\u0012\b\b\u0002\u00107\u001a\u00020\n\u0012\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n04\u0012\b\b\u0002\u00109\u001a\u00020\n\u0012\b\b\u0002\u0010:\u001a\u00020\n\u0012\b\b\u0002\u0010;\u001a\u00020\n\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010=\u001a\u00020-\u0012\b\b\u0002\u0010>\u001a\u00020\n\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010@\u001a\u00020\n\u0012\u001b\b\u0002\u0010A\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019¢\u0006\u0002\b\u001a\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010C\u001a\u00020\n\u0012\b\b\u0002\u0010D\u001a\u00020\u0007\u0012\b\b\u0002\u0010E\u001a\u00020\u0007\u0012\b\b\u0002\u0010F\u001a\u00020\u0007¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000f\u0010\fJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R$\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019¢\u0006\u0002\b\u001aX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0017\u0010!R\u0013\u0010#\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010\u001f\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0%X\u0007¢\u0006\u0006\n\u0004\b&\u0010'R\u0012\u0010*\u001a\u00020\nX\u0087\u0002¢\u0006\u0006\n\u0004\b)\u0010\u0016R\u0011\u0010&\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b*\u0010\u0016R\u001a\u0010,\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b\u0015\u0010!R\u0011\u0010)\u001a\u00020-X\u0007¢\u0006\u0006\n\u0004\b(\u0010.R\u0011\u00100\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b,\u0010/R\u0011\u00102\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b1\u0010\u0016R\u0011\u00103\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b3\u0010\u0016R\u001a\u00101\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b2\u0010 \u001a\u0004\b\u0018\u0010!R\u001e\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n04X\u0087\u0002¢\u0006\u0006\n\u0004\b0\u0010\u001c"}, d2 = {"Lid/dana/globalsearch/model/PaySearchInfoModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "PlaceComponentResult", "hashCode", "toString", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lkotlinx/android/parcel/RawValue;", "lookAheadTest", "Ljava/util/Map;", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "Z", "()Z", "Lid/dana/domain/globalsearch/model/LatLng;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/globalsearch/model/LatLng;", "", "GetContactSyncConfig", "Ljava/util/List;", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", SummaryActivity.DAYS, "I", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IDLjava/lang/String;Lid/dana/domain/globalsearch/model/LatLng;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaySearchInfoModel implements Parcelable {
    public static final Parcelable.Creator<PaySearchInfoModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final double initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final List<String> DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final LatLng NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final int isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Map<String, Object> getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public boolean lookAheadTest;
    public final String newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String moveToNextValue;

    public PaySearchInfoModel() {
        this(null, null, null, null, null, null, null, null, null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, false, false, 1048575, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PaySearchInfoModel) {
            PaySearchInfoModel paySearchInfoModel = (PaySearchInfoModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, paySearchInfoModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.GetContactSyncConfig, paySearchInfoModel.GetContactSyncConfig) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, paySearchInfoModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.getAuthRequestContext, paySearchInfoModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.moveToNextValue, paySearchInfoModel.moveToNextValue) && Intrinsics.areEqual(this.newProxyInstance, paySearchInfoModel.newProxyInstance) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, paySearchInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && this.isLayoutRequested == paySearchInfoModel.isLayoutRequested && Intrinsics.areEqual((Object) Double.valueOf(this.initRecordTimeStamp), (Object) Double.valueOf(paySearchInfoModel.initRecordTimeStamp)) && Intrinsics.areEqual(this.PlaceComponentResult, paySearchInfoModel.PlaceComponentResult) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.scheduleImpl, paySearchInfoModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, paySearchInfoModel.getErrorConfigVersion) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, paySearchInfoModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && this.lookAheadTest == paySearchInfoModel.lookAheadTest && this.PrepareContext == paySearchInfoModel.PrepareContext && this.NetworkUserEntityData$$ExternalSyntheticLambda1 == paySearchInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode2 = this.GetContactSyncConfig.hashCode();
        int hashCode3 = this.DatabaseTableConfigUtil.hashCode();
        int hashCode4 = this.getAuthRequestContext.hashCode();
        int hashCode5 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
        int hashCode6 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.hashCode();
        int hashCode7 = this.moveToNextValue.hashCode();
        int hashCode8 = this.newProxyInstance.hashCode();
        int hashCode9 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int i = this.isLayoutRequested;
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp);
        int hashCode10 = this.PlaceComponentResult.hashCode();
        LatLng latLng = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode11 = latLng == null ? 0 : latLng.hashCode();
        int hashCode12 = this.scheduleImpl.hashCode();
        int hashCode13 = this.getErrorConfigVersion.hashCode();
        String str = this.MyBillsEntityDataFactory;
        int hashCode14 = str != null ? str.hashCode() : 0;
        int hashCode15 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode();
        boolean z = this.lookAheadTest;
        int i2 = z ? 1 : z ? 1 : 0;
        boolean z2 = this.PrepareContext;
        int i3 = z2 ? 1 : z2 ? 1 : 0;
        boolean z3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i2) * 31) + i3) * 31) + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaySearchInfoModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.GetContactSyncConfig);
        p0.writeStringList(this.DatabaseTableConfigUtil);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        Map<String, String> map = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        p0.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            p0.writeString(entry.getKey());
            p0.writeString(entry.getValue());
        }
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.newProxyInstance);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.isLayoutRequested);
        p0.writeDouble(this.initRecordTimeStamp);
        p0.writeString(this.PlaceComponentResult);
        p0.writeParcelable(this.NetworkUserEntityData$$ExternalSyntheticLambda0, p1);
        p0.writeString(this.scheduleImpl);
        Map<String, Object> map2 = this.getErrorConfigVersion;
        p0.writeInt(map2.size());
        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
            p0.writeString(entry2.getKey());
            p0.writeValue(entry2.getValue());
        }
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeInt(this.lookAheadTest ? 1 : 0);
        p0.writeInt(this.PrepareContext ? 1 : 0);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? 1 : 0);
    }

    public PaySearchInfoModel(String str, String str2, List<String> list, String str3, String str4, Map<String, String> map, String str5, String str6, String str7, int i, double d, String str8, LatLng latLng, String str9, Map<String, ? extends Object> map2, String str10, String str11, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(map2, "");
        Intrinsics.checkNotNullParameter(str11, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.GetContactSyncConfig = str2;
        this.DatabaseTableConfigUtil = list;
        this.getAuthRequestContext = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = map;
        this.moveToNextValue = str5;
        this.newProxyInstance = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str7;
        this.isLayoutRequested = i;
        this.initRecordTimeStamp = d;
        this.PlaceComponentResult = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = latLng;
        this.scheduleImpl = str9;
        this.getErrorConfigVersion = map2;
        this.MyBillsEntityDataFactory = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str11;
        this.lookAheadTest = z;
        this.PrepareContext = z2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z3;
    }

    public /* synthetic */ PaySearchInfoModel(String str, String str2, List list, String str3, String str4, Map map, String str5, String str6, String str7, int i, double d, String str8, LatLng latLng, String str9, Map map2, String str10, String str11, boolean z, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? new ArrayList() : list, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? new LinkedHashMap() : map, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? 0 : i, (i2 & 1024) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, (i2 & 2048) != 0 ? "" : str8, (i2 & 4096) != 0 ? null : latLng, (i2 & 8192) != 0 ? "" : str9, (i2 & 16384) != 0 ? new LinkedHashMap() : map2, (i2 & 32768) == 0 ? str10 : null, (i2 & 65536) != 0 ? "" : str11, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? true : z, (i2 & 262144) != 0 ? false : z2, (i2 & 524288) != 0 ? false : z3);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getLookAheadTest() {
        return this.lookAheadTest;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getPrepareContext() {
        return this.PrepareContext;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r0.equals("DF") != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r0.equals("ONLINE_MERCHANT") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if (r0.equals("SERVICE") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return id.dana.globalsearch.mapper.ConvertMapToPojoKt.getAuthRequestContext(r2.getErrorConfigVersion).PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return r2.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r0.equals("DF_SKU") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0.equals("OFFLINE_MERCHANT") == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String PlaceComponentResult() {
        /*
            r2 = this;
            java.lang.String r0 = r2.getAuthRequestContext
            int r1 = r0.hashCode()
            switch(r1) {
                case -1592831339: goto L36;
                case -667013580: goto L2d;
                case 2178: goto L1c;
                case 1016896708: goto L13;
                case 2014341056: goto La;
                default: goto L9;
            }
        L9:
            goto L41
        La:
            java.lang.String r1 = "DF_SKU"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L24
            goto L41
        L13:
            java.lang.String r1 = "OFFLINE_MERCHANT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3e
            goto L41
        L1c:
            java.lang.String r1 = "DF"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L41
        L24:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r2.getErrorConfigVersion
            id.dana.globalsearch.dfrestaurant.model.RestaurantInfoModel r0 = id.dana.globalsearch.mapper.ConvertMapToPojoKt.getAuthRequestContext(r0)
            java.lang.String r0 = r0.PlaceComponentResult
            goto L42
        L2d:
            java.lang.String r1 = "ONLINE_MERCHANT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3e
            goto L41
        L36:
            java.lang.String r1 = "SERVICE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L41
        L3e:
            java.lang.String r0 = r2.GetContactSyncConfig
            goto L42
        L41:
            r0 = 0
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.globalsearch.model.PaySearchInfoModel.PlaceComponentResult():java.lang.String");
    }

    public final String MyBillsEntityDataFactory() {
        if (Intrinsics.areEqual(this.getAuthRequestContext, "OFFLINE_MERCHANT")) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda7.get("gSearchMerchantLogoUrl");
        }
        return this.moveToNextValue;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<PaySearchInfoModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PaySearchInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            int readInt2 = parcel.readInt();
            double readDouble = parcel.readDouble();
            String readString8 = parcel.readString();
            LatLng latLng = (LatLng) parcel.readParcelable(PaySearchInfoModel.class.getClassLoader());
            String readString9 = parcel.readString();
            int readInt3 = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt3);
            int i2 = 0;
            while (i2 != readInt3) {
                linkedHashMap3.put(parcel.readString(), parcel.readValue(PaySearchInfoModel.class.getClassLoader()));
                i2++;
                readInt3 = readInt3;
                readDouble = readDouble;
            }
            return new PaySearchInfoModel(readString, readString2, createStringArrayList, readString3, readString4, linkedHashMap2, readString5, readString6, readString7, readInt2, readDouble, readString8, latLng, readString9, linkedHashMap3, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PaySearchInfoModel[] newArray(int i) {
            return new PaySearchInfoModel[i];
        }
    }
}
