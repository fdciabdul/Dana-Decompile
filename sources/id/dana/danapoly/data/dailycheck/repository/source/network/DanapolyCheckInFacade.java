package id.dana.danapoly.data.dailycheck.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danapoly.data.dailycheck.model.request.CheckInRequest;
import id.dana.danapoly.data.dailycheck.model.response.CampaignInfoResponse;
import id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/source/network/DanapolyCheckInFacade;", "", "Lid/dana/danapoly/data/dailycheck/model/request/CheckInRequest;", "request", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "doCheckIn", "(Lid/dana/danapoly/data/dailycheck/model/request/CheckInRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/danapoly/data/dailycheck/model/response/CampaignInfoResponse;", "getCampaignInfo", "(Lid/dana/danapoly/data/dailycheck/model/request/CheckInRequest;)Lid/dana/danapoly/data/dailycheck/model/response/CampaignInfoResponse;", "Lid/dana/danapoly/data/dailycheck/model/response/CheckInInfoResponse;", "getUserCheckInInfo", "(Lid/dana/danapoly/data/dailycheck/model/request/CheckInRequest;)Lid/dana/danapoly/data/dailycheck/model/response/CheckInInfoResponse;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyCheckInFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;

    @OperationType("id.dana.discovery.checkIn.checkIn")
    @SignCheck
    BaseRpcResult doCheckIn(CheckInRequest request);

    @OperationType("id.dana.discovery.checkIn.getCampaignInfo")
    @SignCheck
    CampaignInfoResponse getCampaignInfo(CheckInRequest request);

    @OperationType("id.dana.discovery.checkIn.getUserCheckInInfo")
    @SignCheck
    CheckInInfoResponse getUserCheckInInfo(CheckInRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/source/network/DanapolyCheckInFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
