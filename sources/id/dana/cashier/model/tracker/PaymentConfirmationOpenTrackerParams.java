package id.dana.cashier.model.tracker;

import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u0015X\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0015X\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016"}, d2 = {"Lid/dana/cashier/model/tracker/PaymentConfirmationOpenTrackerParams;", "", "Lid/dana/cashier/model/AddOnTrackingModel;", "MyBillsEntityDataFactory", "Lid/dana/cashier/model/AddOnTrackingModel;", "PlaceComponentResult", "Lid/dana/cashier/model/CashierCheckoutModel;", "Lid/dana/cashier/model/CashierCheckoutModel;", "BuiltInFictitiousFunctionClassFactory", "", "J", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "getAuthRequestContext", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "", "getErrorConfigVersion", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "scheduleImpl", "", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/cashier/model/CashierCheckoutModel;Ljava/lang/String;ZLjava/lang/String;JLid/dana/cashier/model/AddOnTrackingModel;ZLid/dana/cashier/model/featureTime/FeatureTimeModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaymentConfirmationOpenTrackerParams {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final long MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final AddOnTrackingModel PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CashierCheckoutModel BuiltInFictitiousFunctionClassFactory;
    public final FeatureTimeModel getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final boolean scheduleImpl;

    public PaymentConfirmationOpenTrackerParams(CashierCheckoutModel cashierCheckoutModel, String str, boolean z, String str2, long j, AddOnTrackingModel addOnTrackingModel, boolean z2, FeatureTimeModel featureTimeModel) {
        Intrinsics.checkNotNullParameter(cashierCheckoutModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = cashierCheckoutModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.scheduleImpl = z;
        this.getErrorConfigVersion = str2;
        this.MyBillsEntityDataFactory = j;
        this.PlaceComponentResult = addOnTrackingModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        this.getAuthRequestContext = featureTimeModel;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
