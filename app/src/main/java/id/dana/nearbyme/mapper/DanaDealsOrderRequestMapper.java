package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.DanaDealsOrderRequest;
import id.dana.nearbyme.model.DanaDealsOrderRequestModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/mapper/DanaDealsOrderRequestMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/nearbyme/model/DanaDealsOrderRequestModel;", "Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaDealsOrderRequestMapper extends BaseMapper<DanaDealsOrderRequestModel, DanaDealsOrderRequest> {
    @Inject
    public DanaDealsOrderRequestMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ DanaDealsOrderRequest map(DanaDealsOrderRequestModel danaDealsOrderRequestModel) {
        DanaDealsOrderRequestModel danaDealsOrderRequestModel2 = danaDealsOrderRequestModel;
        Intrinsics.checkNotNullParameter(danaDealsOrderRequestModel2, "");
        return new DanaDealsOrderRequest(danaDealsOrderRequestModel2.getAuthRequestContext, danaDealsOrderRequestModel2.BuiltInFictitiousFunctionClassFactory, danaDealsOrderRequestModel2.MyBillsEntityDataFactory, danaDealsOrderRequestModel2.scheduleImpl, danaDealsOrderRequestModel2.NetworkUserEntityData$$ExternalSyntheticLambda0, danaDealsOrderRequestModel2.PlaceComponentResult, danaDealsOrderRequestModel2.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
