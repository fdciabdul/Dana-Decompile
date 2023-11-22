package id.dana.data.userconsent.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.userconsent.repository.source.model.ConsultAgreementResult;
import id.dana.data.userconsent.repository.source.model.FetchScopesResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/userconsent/repository/source/network/UserConsentFacade;", "", "Lid/dana/data/userconsent/repository/source/network/ConsultAgreementRequest;", "request", "Lid/dana/data/userconsent/repository/source/model/ConsultAgreementResult;", "consultAgreement", "(Lid/dana/data/userconsent/repository/source/network/ConsultAgreementRequest;)Lid/dana/data/userconsent/repository/source/model/ConsultAgreementResult;", "Lid/dana/data/userconsent/repository/source/network/FetchScopesRequest;", "Lid/dana/data/userconsent/repository/source/model/FetchScopesResult;", "fetchScopes", "(Lid/dana/data/userconsent/repository/source/network/FetchScopesRequest;)Lid/dana/data/userconsent/repository/source/model/FetchScopesResult;", "Lid/dana/data/userconsent/repository/source/network/RecordAgreementRequest;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "recordAgreement", "(Lid/dana/data/userconsent/repository/source/network/RecordAgreementRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserConsentFacade {
    @OperationType("dana.mobilewallet.agreementcenter.consult")
    ConsultAgreementResult consultAgreement(ConsultAgreementRequest request);

    @OperationType("alipayplus.mobilewallet.user.oauth.clientscope.query")
    FetchScopesResult fetchScopes(FetchScopesRequest request);

    @OperationType("dana.mobilewallet.agreementcenter.record")
    BaseRpcResult recordAgreement(RecordAgreementRequest request);
}
