package id.dana.data.homeinfo.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.homeinfo.repository.source.network.result.PaylaterChannelResult;
import id.dana.data.homeinfo.repository.source.network.result.ProcessingTransactionResultWrapper;
import id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResultWrapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/HomeInfoOmniFacade;", "", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "params", "Lid/dana/data/homeinfo/repository/source/network/result/PaylaterChannelResult;", "getPaylaterChannel", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/homeinfo/repository/source/network/result/PaylaterChannelResult;", "Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResultWrapper;", "getProcessingTransaction", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/homeinfo/repository/source/network/result/ProcessingTransactionResultWrapper;", "Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;", "getSurveyInfo", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface HomeInfoOmniFacade {
    @OperationType("id.dana.mobilebizpaylaterprod.getPaylaterChannel")
    @SignCheck
    PaylaterChannelResult getPaylaterChannel(BaseRpcRequest params);

    @OperationType("id.dana.thengine.user.transaction.inProgressCount")
    @SignCheck
    ProcessingTransactionResultWrapper getProcessingTransaction(BaseRpcRequest params);

    @OperationType("alipayplus.mobileprod.survey.info")
    @SignCheck
    SurveyInfoResultWrapper getSurveyInfo(BaseRpcRequest params);
}
