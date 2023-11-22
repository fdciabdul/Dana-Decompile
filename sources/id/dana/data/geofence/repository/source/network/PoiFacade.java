package id.dana.data.geofence.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.geofence.repository.source.network.request.PoiFetchRequest;
import id.dana.data.geofence.repository.source.network.request.PoiNotificationRequest;
import id.dana.data.geofence.repository.source.network.result.PoiFetchResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/geofence/repository/source/network/PoiFacade;", "", "Lid/dana/data/geofence/repository/source/network/request/PoiFetchRequest;", "poiFetchRequest", "Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "getPois", "(Lid/dana/data/geofence/repository/source/network/request/PoiFetchRequest;)Lid/dana/data/geofence/repository/source/network/result/PoiFetchResult;", "Lid/dana/data/geofence/repository/source/network/request/PoiNotificationRequest;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "notify", "(Lid/dana/data/geofence/repository/source/network/request/PoiNotificationRequest;)Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PoiFacade {
    @OperationType("alipayplus.mobilewallet.poi.fetch")
    @SignCheck
    PoiFetchResult getPois(PoiFetchRequest poiFetchRequest);

    @OperationType("alipayplus.mobilewallet.poi.notification")
    @SignCheck
    BaseRpcResult notify(PoiNotificationRequest poiFetchRequest);
}
