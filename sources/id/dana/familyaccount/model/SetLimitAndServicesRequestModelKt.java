package id.dana.familyaccount.model;

import id.dana.domain.familyaccount.model.SetLimitAndServicesRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/model/SetLimitAndServicesRequestModel;", "Lid/dana/domain/familyaccount/model/SetLimitAndServicesRequest;", "PlaceComponentResult", "(Lid/dana/familyaccount/model/SetLimitAndServicesRequestModel;)Lid/dana/domain/familyaccount/model/SetLimitAndServicesRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SetLimitAndServicesRequestModelKt {
    public static final SetLimitAndServicesRequest PlaceComponentResult(SetLimitAndServicesRequestModel setLimitAndServicesRequestModel) {
        Intrinsics.checkNotNullParameter(setLimitAndServicesRequestModel, "");
        return new SetLimitAndServicesRequest(setLimitAndServicesRequestModel.getAuthRequestContext, setLimitAndServicesRequestModel.PlaceComponentResult, setLimitAndServicesRequestModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
