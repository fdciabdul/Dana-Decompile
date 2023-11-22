package id.dana.data.notificationcenter.repository.source.network;

import android.content.Context;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.notificationcenter.repository.source.PushNotificationEntityData;
import id.dana.data.notificationcenter.repository.source.network.request.BindAppRequest;
import id.dana.data.notificationcenter.repository.source.network.request.ReportDeviceRequest;
import id.dana.data.notificationcenter.repository.source.network.request.UnbindAppRequest;
import id.dana.data.notificationcenter.repository.source.network.result.BindAppResult;
import id.dana.data.notificationcenter.repository.source.network.result.ReportDeviceResult;
import id.dana.data.notificationcenter.repository.source.network.result.UnbindAppResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkPushNotificationEntityData extends SecureBaseNetwork<PushNotificationFacade> implements PushNotificationEntityData {
    private final DeviceInformationProvider deviceInformationProvider;

    @Inject
    public NetworkPushNotificationEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, DeviceInformationProvider deviceInformationProvider) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<PushNotificationFacade> getFacadeClass() {
        return PushNotificationFacade.class;
    }

    @Override // id.dana.data.notificationcenter.repository.source.PushNotificationEntityData
    public Observable<ReportDeviceResult> reportDevice(String str, String str2, String str3, String str4) {
        final ReportDeviceRequest reportDeviceRequest = new ReportDeviceRequest();
        reportDeviceRequest.setDeliveryToken(this.deviceInformationProvider.getDeviceUtdId());
        reportDeviceRequest.setImei(str3);
        reportDeviceRequest.setImsi(str2);
        reportDeviceRequest.setConnectType(str4);
        reportDeviceRequest.setThirdChannelDeviceToken(str);
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.notificationcenter.repository.source.network.NetworkPushNotificationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ReportDeviceResult reportDevice;
                reportDevice = ((PushNotificationFacade) obj).reportDevice(ReportDeviceRequest.this);
                return reportDevice;
            }
        });
    }

    @Override // id.dana.data.notificationcenter.repository.source.PushNotificationEntityData
    public Observable<BindAppResult> bindApp(String str) {
        BindAppRequest bindAppRequest = new BindAppRequest();
        bindAppRequest.setDeliveryToken(this.deviceInformationProvider.getDeviceUtdId());
        bindAppRequest.setUserId(str);
        return Observable.just(getCastedFacade().bindApp(bindAppRequest));
    }

    @Override // id.dana.data.notificationcenter.repository.source.PushNotificationEntityData
    public Observable<UnbindAppResult> unBindApp(String str) {
        UnbindAppRequest unbindAppRequest = new UnbindAppRequest();
        unbindAppRequest.setDeliveryToken(this.deviceInformationProvider.getDeviceUtdId());
        unbindAppRequest.setUserId(str);
        return Observable.just(getCastedFacade().unBindApp(unbindAppRequest));
    }
}
