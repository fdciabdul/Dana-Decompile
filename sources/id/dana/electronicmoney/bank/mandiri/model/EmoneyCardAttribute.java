package id.dana.electronicmoney.bank.mandiri.model;

import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ3\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\nR \u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0012\u0010\u0012\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\n"}, d2 = {"Lid/dana/electronicmoney/bank/mandiri/model/EmoneyCardAttribute;", "", "", "p0", "p1", "p2", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Ljava/util/Map;", "lookAheadTest", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmoneyCardAttribute {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public Map<String, String> lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String moveToNextValue;

    public EmoneyCardAttribute() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    private EmoneyCardAttribute(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.scheduleImpl = str2;
        this.PlaceComponentResult = str3;
        this.MyBillsEntityDataFactory = str4;
        this.getAuthRequestContext = str5;
        this.BuiltInFictitiousFunctionClassFactory = str6;
        this.moveToNextValue = str7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str8;
        this.getErrorConfigVersion = str9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str10;
        this.lookAheadTest = map;
    }

    public /* synthetic */ EmoneyCardAttribute(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "MANDIRI" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) == 0 ? str10 : "", (i & 1024) != 0 ? new LinkedHashMap() : map);
    }

    public final Map<String, String> getAuthRequestContext(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        return MapsKt.mapOf(TuplesKt.to(TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID, p0), TuplesKt.to("cardAttribute", this.getAuthRequestContext), TuplesKt.to("lastBalance", this.moveToNextValue), TuplesKt.to("cardInfo", this.KClassImpl$Data$declaredNonStaticMembers$2), TuplesKt.to("cardNumber", this.BuiltInFictitiousFunctionClassFactory), TuplesKt.to("cardUUID", this.getErrorConfigVersion), TuplesKt.to("approvalCode", p1), TuplesKt.to("dataToSam", this.NetworkUserEntityData$$ExternalSyntheticLambda0), TuplesKt.to("amount", p2), TuplesKt.to("session", this.scheduleImpl));
    }
}
