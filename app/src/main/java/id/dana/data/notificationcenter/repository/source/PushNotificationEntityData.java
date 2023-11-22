package id.dana.data.notificationcenter.repository.source;

import id.dana.data.notificationcenter.repository.source.network.result.BindAppResult;
import id.dana.data.notificationcenter.repository.source.network.result.ReportDeviceResult;
import id.dana.data.notificationcenter.repository.source.network.result.UnbindAppResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PushNotificationEntityData {
    Observable<BindAppResult> bindApp(String str);

    Observable<ReportDeviceResult> reportDevice(String str, String str2, String str3, String str4);

    Observable<UnbindAppResult> unBindApp(String str);
}
