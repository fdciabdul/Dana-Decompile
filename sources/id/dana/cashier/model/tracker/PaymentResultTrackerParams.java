package id.dana.cashier.model.tracker;

import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/cashier/model/tracker/PaymentResultTrackerParams;", "", "Lid/dana/cashier/model/AddOnTrackingModel;", "PlaceComponentResult", "Lid/dana/cashier/model/AddOnTrackingModel;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "getAuthRequestContext", "", "BuiltInFictitiousFunctionClassFactory", "I", "Lid/dana/cashier/model/PayResultModel;", "Lid/dana/cashier/model/PayResultModel;", "", "Ljava/lang/String;", "getErrorConfigVersion", "lookAheadTest", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/cashier/model/PayResultModel;Lid/dana/cashier/model/AddOnTrackingModel;Ljava/lang/String;Ljava/lang/String;ILid/dana/cashier/model/featureTime/FeatureTimeModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentResultTrackerParams {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final FeatureTimeModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final PayResultModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final AddOnTrackingModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;

    public PaymentResultTrackerParams(PayResultModel payResultModel, AddOnTrackingModel addOnTrackingModel, String str, String str2, int i, FeatureTimeModel featureTimeModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = payResultModel;
        this.MyBillsEntityDataFactory = addOnTrackingModel;
        this.lookAheadTest = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = featureTimeModel;
    }
}
