package id.dana.cardbinding.tracker;

import id.dana.cashier.model.QueryCardPolicyInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/cardbinding/tracker/AddCardExecutionProperties;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "getAuthRequestContext", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Lid/dana/cashier/model/QueryCardPolicyInfoModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddCardExecutionProperties {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final QueryCardPolicyInfoModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String MyBillsEntityDataFactory;
    final String getAuthRequestContext;

    private AddCardExecutionProperties(String str, QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = queryCardPolicyInfoModel;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
    }

    public /* synthetic */ AddCardExecutionProperties(String str, QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, queryCardPolicyInfoModel, (i & 4) != 0 ? "Manual Input" : str2, (i & 8) != 0 ? "Manual Input" : str3);
    }
}
