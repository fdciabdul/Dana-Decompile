package id.dana.data.globalnetwork.source.network.facade;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.globalnetwork.model.GnConsultRequest;
import id.dana.data.globalnetwork.model.GnConsultResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/globalnetwork/source/network/facade/GlobalNetworkFacade;", "", "Lid/dana/data/globalnetwork/model/GnConsultRequest;", "gnConsultRequest", "Lid/dana/data/globalnetwork/model/GnConsultResult;", "gnConsult", "(Lid/dana/data/globalnetwork/model/GnConsultRequest;)Lid/dana/data/globalnetwork/model/GnConsultResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GlobalNetworkFacade {
    @OperationType("dana.mobilewallet.gn.consult")
    @SignCheck
    GnConsultResult gnConsult(GnConsultRequest gnConsultRequest);
}