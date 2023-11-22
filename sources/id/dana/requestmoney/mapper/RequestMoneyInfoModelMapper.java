package id.dana.requestmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RequestMoneyInfoModelMapper extends BaseMapper<RequestMoneyInfo, RequestMoneyInfoModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ RequestMoneyInfoModel map(RequestMoneyInfo requestMoneyInfo) {
        RequestMoneyInfo requestMoneyInfo2 = requestMoneyInfo;
        if (requestMoneyInfo2 != null) {
            RequestMoneyInfoModel requestMoneyInfoModel = new RequestMoneyInfoModel();
            requestMoneyInfoModel.BuiltInFictitiousFunctionClassFactory = requestMoneyInfo2.getMinAmount();
            requestMoneyInfoModel.MyBillsEntityDataFactory = requestMoneyInfo2.getMaxAmount();
            return requestMoneyInfoModel;
        }
        return null;
    }

    @Inject
    public RequestMoneyInfoModelMapper() {
    }
}
