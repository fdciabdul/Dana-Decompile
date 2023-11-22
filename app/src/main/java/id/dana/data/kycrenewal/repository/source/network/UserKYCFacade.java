package id.dana.data.kycrenewal.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCRenewalStatusResult;
import id.dana.data.kycrenewal.repository.source.network.result.QueryKYCUserDataResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/UserKYCFacade;", "", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "request", "Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;", "queryKYCRenewalStatus", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCRenewalStatusResult;", "Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;", "queryKYCUserData", "(Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;)Lid/dana/data/kycrenewal/repository/source/network/result/QueryKYCUserDataResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserKYCFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

    @OperationType("alipayplus.mobilewallet.user.kyc.queryKYCRenewalStatus")
    @SignCheck
    QueryKYCRenewalStatusResult queryKYCRenewalStatus(BaseRpcRequest request);

    @OperationType("alipayplus.mobilewallet.user.kyc.queryKYCUserData")
    @SignCheck
    QueryKYCUserDataResult queryKYCUserData(BaseRpcRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/kycrenewal/repository/source/network/UserKYCFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
