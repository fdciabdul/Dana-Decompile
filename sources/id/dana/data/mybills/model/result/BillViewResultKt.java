package id.dana.data.mybills.model.result;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.mybills.model.MyBillView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/mybills/model/result/BillViewResult;", "Lid/dana/domain/mybills/model/MyBillView;", "getAuthRequestContext", "(Lid/dana/data/mybills/model/result/BillViewResult;)Lid/dana/domain/mybills/model/MyBillView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BillViewResultKt {
    public static final MyBillView getAuthRequestContext(BillViewResult billViewResult) {
        Intrinsics.checkNotNullParameter(billViewResult, "");
        return new MyBillView(billViewResult.MyBillsEntityDataFactory, MoneyViewEntityMapperKt.toMoneyView(billViewResult.BuiltInFictitiousFunctionClassFactory), billViewResult.getAuthRequestContext, billViewResult.getErrorConfigVersion, billViewResult.moveToNextValue, billViewResult.NetworkUserEntityData$$ExternalSyntheticLambda0, billViewResult.scheduleImpl, MoneyViewEntityMapperKt.toMoneyView(billViewResult.lookAheadTest), billViewResult.NetworkUserEntityData$$ExternalSyntheticLambda1, billViewResult.getKClassImpl$Data$declaredNonStaticMembers$2(), billViewResult.PlaceComponentResult.get("billerServiceIcon"));
    }
}
