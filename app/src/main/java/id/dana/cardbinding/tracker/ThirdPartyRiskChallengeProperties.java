package id.dana.cardbinding.tracker;

import id.dana.cashier.model.QueryCardPolicyInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0013\u0010\n\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\t"}, d2 = {"Lid/dana/cardbinding/tracker/ThirdPartyRiskChallengeProperties;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Lid/dana/cashier/model/QueryCardPolicyInfoModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThirdPartyRiskChallengeProperties {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final QueryCardPolicyInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String PlaceComponentResult;

    private ThirdPartyRiskChallengeProperties(String str, QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = queryCardPolicyInfoModel;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.PlaceComponentResult = str3;
    }

    public /* synthetic */ ThirdPartyRiskChallengeProperties(String str, QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, queryCardPolicyInfoModel, (i & 4) != 0 ? "Manual Input" : str2, (i & 8) != 0 ? "Manual Input" : str3);
    }
}
