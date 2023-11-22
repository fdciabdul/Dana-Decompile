package id.dana.data.notificationcenter.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.notificationcenter.repository.source.network.request.BindAppRequest;
import id.dana.data.notificationcenter.repository.source.network.request.ReportDeviceRequest;
import id.dana.data.notificationcenter.repository.source.network.request.UnbindAppRequest;
import id.dana.data.notificationcenter.repository.source.network.result.BindAppResult;
import id.dana.data.notificationcenter.repository.source.network.result.ReportDeviceResult;
import id.dana.data.notificationcenter.repository.source.network.result.UnbindAppResult;

/* loaded from: classes4.dex */
public interface PushNotificationFacade {
    @OperationType("alipay.client.yunpushcore.bind")
    @SignCheck
    BindAppResult bindApp(BindAppRequest bindAppRequest);

    @OperationType("alipay.client.yunpushcore.device.report")
    @SignCheck
    ReportDeviceResult reportDevice(ReportDeviceRequest reportDeviceRequest);

    @OperationType("alipay.client.yunpushcore.unbind")
    @SignCheck
    UnbindAppResult unBindApp(UnbindAppRequest unbindAppRequest);
}
