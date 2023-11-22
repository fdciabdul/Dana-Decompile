package id.dana.nearbyme.merchantdetail.model;

import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.nearbyme.model.ContactAddressModel;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0017\u0012\u0006\u0010,\u001a\u00020\u0017\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0017\u0012\b\u00100\u001a\u0004\u0018\u00010\u0017\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d\u0012\u0006\u00102\u001a\u00020\u000f¢\u0006\u0004\b3\u00104J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u0017X\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u0017X\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0019\u0010\u000eR\u0011\u0010\u001c\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dX\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0007¢\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0013\u0010!\u001a\u0004\u0018\u00010\u0017X\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0013\u0010#\u001a\u0004\u0018\u00010\u0017X\u0007¢\u0006\u0006\n\u0004\b\"\u0010 R\u0013\u0010$\u001a\u0004\u0018\u00010\u0006X\u0007¢\u0006\u0006\n\u0004\b#\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b$\u0010\u000eR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0006X\u0007¢\u0006\u0006\n\u0004\b!\u0010\u000e"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "hashCode", "()I", "toString", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lid/dana/nearbyme/model/ContactAddressModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/model/ContactAddressModel;", "MyBillsEntityDataFactory", "GetContactSyncConfig", "Z", "PlaceComponentResult", "()Z", "", SummaryActivity.DAYS, "lookAheadTest", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "", "Ljava/util/List;", "getErrorConfigVersion", "Ljava/lang/Double;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZDDLjava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Lid/dana/nearbyme/model/ContactAddressModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantInfoModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ContactAddressModel MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String initRecordTimeStamp;
    public final double PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final double lookAheadTest;
    public final String getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final Double NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final Double NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final List<String> NetworkUserEntityData$$ExternalSyntheticLambda0;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantInfoModel) {
            MerchantInfoModel merchantInfoModel = (MerchantInfoModel) p0;
            return Intrinsics.areEqual(this.moveToNextValue, merchantInfoModel.moveToNextValue) && Intrinsics.areEqual(this.GetContactSyncConfig, merchantInfoModel.GetContactSyncConfig) && Intrinsics.areEqual(this.scheduleImpl, merchantInfoModel.scheduleImpl) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, merchantInfoModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, merchantInfoModel.initRecordTimeStamp) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantInfoModel.BuiltInFictitiousFunctionClassFactory) && this.getAuthRequestContext == merchantInfoModel.getAuthRequestContext && Intrinsics.areEqual((Object) Double.valueOf(this.PlaceComponentResult), (Object) Double.valueOf(merchantInfoModel.PlaceComponentResult)) && Intrinsics.areEqual((Object) Double.valueOf(this.lookAheadTest), (Object) Double.valueOf(merchantInfoModel.lookAheadTest)) && Intrinsics.areEqual(this.getErrorConfigVersion, merchantInfoModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, merchantInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda2, (Object) merchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda1, (Object) merchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, merchantInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, merchantInfoModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.moveToNextValue.hashCode();
        int hashCode2 = this.GetContactSyncConfig.hashCode();
        int hashCode3 = this.scheduleImpl.hashCode();
        String str = this.DatabaseTableConfigUtil;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.initRecordTimeStamp;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        boolean z = this.getAuthRequestContext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
        int KClassImpl$Data$declaredNonStaticMembers$22 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
        String str4 = this.getErrorConfigVersion;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        Double d = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode9 = d == null ? 0 : d.hashCode();
        Double d2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + KClassImpl$Data$declaredNonStaticMembers$22) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (d2 != null ? d2.hashCode() : 0)) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantInfoModel(moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public MerchantInfoModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z, double d, double d2, String str7, String str8, Double d3, Double d4, List<String> list, ContactAddressModel contactAddressModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(contactAddressModel, "");
        this.moveToNextValue = str;
        this.GetContactSyncConfig = str2;
        this.scheduleImpl = str3;
        this.DatabaseTableConfigUtil = str4;
        this.initRecordTimeStamp = str5;
        this.BuiltInFictitiousFunctionClassFactory = str6;
        this.getAuthRequestContext = z;
        this.PlaceComponentResult = d;
        this.lookAheadTest = d2;
        this.getErrorConfigVersion = str7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = d3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = d4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = list;
        this.MyBillsEntityDataFactory = contactAddressModel;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public final String getAuthRequestContext() {
        Object obj;
        Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if ((!StringsKt.isBlank((String) obj)) != false) {
                break;
            }
        }
        String str = (String) obj;
        return str == null ? "" : str;
    }
}
