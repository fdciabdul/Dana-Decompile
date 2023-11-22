package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.notificationcenter.model.HasNewResponse;
import id.dana.model.HasNewModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class HasNewModelMapper extends BaseMapper<HasNewResponse, HasNewModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ HasNewModel map(HasNewResponse hasNewResponse) {
        HasNewResponse hasNewResponse2 = hasNewResponse;
        if (hasNewResponse2 != null) {
            HasNewModel hasNewModel = new HasNewModel();
            hasNewModel.KClassImpl$Data$declaredNonStaticMembers$2 = hasNewResponse2.isHasNew();
            hasNewModel.MyBillsEntityDataFactory = hasNewResponse2.isUpdated();
            return hasNewModel;
        }
        return null;
    }

    @Inject
    public HasNewModelMapper() {
    }
}
