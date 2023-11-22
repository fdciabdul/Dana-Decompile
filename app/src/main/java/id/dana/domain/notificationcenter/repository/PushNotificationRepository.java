package id.dana.domain.notificationcenter.repository;

import id.dana.domain.notificationcenter.model.BindAppResponse;
import id.dana.domain.notificationcenter.model.ReportDeviceResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PushNotificationRepository {
    Observable<BindAppResponse> bindApp();

    Observable<BindAppResponse> bindAppSession();

    Observable<ReportDeviceResponse> reportDevice(String str, String str2, String str3, String str4);
}
