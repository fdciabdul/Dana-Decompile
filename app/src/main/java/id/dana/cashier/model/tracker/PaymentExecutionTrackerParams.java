package id.dana.cashier.model.tracker;

import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0011\u0010\u0007\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\b"}, d2 = {"Lid/dana/cashier/model/tracker/PaymentExecutionTrackerParams;", "", "Lid/dana/cashier/model/AddOnTrackingModel;", "PlaceComponentResult", "Lid/dana/cashier/model/AddOnTrackingModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "lookAheadTest", "Ljava/util/List;", "getErrorConfigVersion", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/util/List;Lid/dana/cashier/model/AddOnTrackingModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/model/featureTime/FeatureTimeModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentExecutionTrackerParams {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CashierPayMethodModel MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final AddOnTrackingModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final FeatureTimeModel PlaceComponentResult;
    public final List<String> lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public PaymentExecutionTrackerParams(String str, CashierPayMethodModel cashierPayMethodModel, List<String> list, AddOnTrackingModel addOnTrackingModel, String str2, String str3, String str4, FeatureTimeModel featureTimeModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = cashierPayMethodModel;
        this.lookAheadTest = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = addOnTrackingModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
        this.getErrorConfigVersion = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.PlaceComponentResult = featureTimeModel;
    }

    public /* synthetic */ PaymentExecutionTrackerParams(String str, CashierPayMethodModel cashierPayMethodModel, List list, AddOnTrackingModel addOnTrackingModel, String str2, String str3, String str4, FeatureTimeModel featureTimeModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cashierPayMethodModel, list, addOnTrackingModel, (i & 16) != 0 ? "" : str2, str3, (i & 64) != 0 ? null : str4, featureTimeModel);
    }
}
