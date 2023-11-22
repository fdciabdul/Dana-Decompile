package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.RequestMoneyInfoResult;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class RequestMoneyInfoResultMapper extends BaseMapper<RequestMoneyInfoResult, RequestMoneyInfo> {
    @Inject
    public RequestMoneyInfoResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public RequestMoneyInfo map(RequestMoneyInfoResult requestMoneyInfoResult) {
        if (requestMoneyInfoResult != null) {
            RequestMoneyInfo requestMoneyInfo = new RequestMoneyInfo();
            requestMoneyInfo.setMinAmount(requestMoneyInfoResult.getMinAmount());
            requestMoneyInfo.setMaxAmount(requestMoneyInfoResult.getMaxAmount());
            return requestMoneyInfo;
        }
        return null;
    }
}
