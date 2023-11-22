package id.dana.kyb.model;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e¢\u0006\u0004\b)\u0010*J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0011\u0010\u0016\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\rR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\r"}, d2 = {"Lid/dana/kyb/model/KybServiceRedirectValueModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lcom/alibaba/fastjson/JSONObject;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/alibaba/fastjson/JSONObject;", "moveToNextValue", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "Z", "Lid/dana/kyb/model/KybServiceRuleModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceRedirectValueModel {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final List<String> PlaceComponentResult;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<KybServiceRuleModel> scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final boolean moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String lookAheadTest;

    public KybServiceRedirectValueModel() {
        this(null, null, null, null, null, false, null, null, null, null, null, 2047, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybServiceRedirectValueModel) {
            KybServiceRedirectValueModel kybServiceRedirectValueModel = (KybServiceRedirectValueModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, kybServiceRedirectValueModel.PlaceComponentResult) && Intrinsics.areEqual(this.getErrorConfigVersion, kybServiceRedirectValueModel.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybServiceRedirectValueModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && this.moveToNextValue == kybServiceRedirectValueModel.moveToNextValue && Intrinsics.areEqual(this.MyBillsEntityDataFactory, kybServiceRedirectValueModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.lookAheadTest, kybServiceRedirectValueModel.lookAheadTest) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, kybServiceRedirectValueModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, kybServiceRedirectValueModel.getAuthRequestContext) && Intrinsics.areEqual(this.scheduleImpl, kybServiceRedirectValueModel.scheduleImpl);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        List<String> list = this.PlaceComponentResult;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.getErrorConfigVersion;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        boolean z = this.moveToNextValue;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str5 = this.MyBillsEntityDataFactory;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.lookAheadTest;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        JSONObject jSONObject = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode8 = jSONObject == null ? 0 : jSONObject.hashCode();
        String str7 = this.getAuthRequestContext;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + (str7 != null ? str7.hashCode() : 0)) * 31) + this.scheduleImpl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceRedirectValueModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceRedirectValueModel(List<String> list, String str, String str2, String str3, String str4, boolean z, String str5, String str6, JSONObject jSONObject, String str7, List<KybServiceRuleModel> list2) {
        Intrinsics.checkNotNullParameter(list2, "");
        this.PlaceComponentResult = list;
        this.getErrorConfigVersion = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str4;
        this.moveToNextValue = z;
        this.MyBillsEntityDataFactory = str5;
        this.lookAheadTest = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject;
        this.getAuthRequestContext = str7;
        this.scheduleImpl = list2;
    }

    public /* synthetic */ KybServiceRedirectValueModel(List list, String str, String str2, String str3, String str4, boolean z, String str5, String str6, JSONObject jSONObject, String str7, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : jSONObject, (i & 512) == 0 ? str7 : null, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
