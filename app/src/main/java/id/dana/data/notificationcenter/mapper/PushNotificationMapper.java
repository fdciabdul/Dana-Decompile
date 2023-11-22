package id.dana.data.notificationcenter.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.notificationcenter.repository.source.network.result.BindAppResult;
import id.dana.data.notificationcenter.repository.source.network.result.ReportDeviceResult;
import id.dana.data.notificationcenter.repository.source.network.result.UnbindAppResult;
import id.dana.domain.notificationcenter.model.BindAppResponse;
import id.dana.domain.notificationcenter.model.ReportDeviceResponse;
import id.dana.domain.notificationcenter.model.UnBindAppResponse;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PushNotificationMapper {
    @Inject
    public PushNotificationMapper() {
    }

    public ReportDeviceResponse transform(ReportDeviceResult reportDeviceResult) {
        if (reportDeviceResult != null) {
            ReportDeviceResponse reportDeviceResponse = new ReportDeviceResponse();
            BaseMapper.transform(reportDeviceResponse, reportDeviceResult);
            reportDeviceResponse.setCode(reportDeviceResult.getCode());
            reportDeviceResponse.setMessage(reportDeviceResult.getMessage());
            reportDeviceResponse.setSuccess(reportDeviceResult.isSuccess());
            return reportDeviceResponse;
        }
        return null;
    }

    public BindAppResponse transform(BindAppResult bindAppResult) {
        if (bindAppResult != null) {
            BindAppResponse bindAppResponse = new BindAppResponse();
            BaseMapper.transform(bindAppResponse, bindAppResult);
            bindAppResponse.setCode(bindAppResult.getCode());
            bindAppResponse.setMessage(bindAppResult.getMessage());
            bindAppResponse.setSuccess(bindAppResult.isSuccess());
            return bindAppResponse;
        }
        return null;
    }

    public UnBindAppResponse transform(UnbindAppResult unbindAppResult) {
        if (unbindAppResult != null) {
            UnBindAppResponse unBindAppResponse = new UnBindAppResponse();
            unBindAppResponse.setCode(unbindAppResult.getCode());
            unBindAppResponse.setMessage(unbindAppResult.getMessage());
            unBindAppResponse.setSuccess(unbindAppResult.isSuccess());
            BaseMapper.transform(unBindAppResponse, unbindAppResult);
            return unBindAppResponse;
        }
        return null;
    }
}
