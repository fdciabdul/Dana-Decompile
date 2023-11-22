package id.dana.sendmoney.summary.state.model;

import id.dana.sendmoney.model.ConfirmationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\n\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/sendmoney/summary/state/model/SummaryConfirmationModel;", "", "Lid/dana/sendmoney/model/ConfirmationModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/model/ConfirmationModel;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/summary/state/model/UnitSymbolModel;", "Lid/dana/sendmoney/summary/state/model/UnitSymbolModel;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/sendmoney/model/ConfirmationModel;Lid/dana/sendmoney/summary/state/model/UnitSymbolModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryConfirmationModel {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public UnitSymbolModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ConfirmationModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    public SummaryConfirmationModel(ConfirmationModel confirmationModel, UnitSymbolModel unitSymbolModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(confirmationModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = confirmationModel;
        this.getAuthRequestContext = unitSymbolModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
    }
}
