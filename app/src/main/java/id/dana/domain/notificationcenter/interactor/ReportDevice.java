package id.dana.domain.notificationcenter.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.notificationcenter.model.ReportDeviceResponse;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ReportDevice extends UseCase<ReportDeviceResponse, Params> {
    private PushNotificationRepository pushNotificationRepository;

    private String formatConnectionType(int i) {
        return i != 0 ? i != 1 ? i != 6 ? i != 7 ? i != 9 ? i != 17 ? ConnectionType.OTHERS : ConnectionType.TYPE_VPN : ConnectionType.TYPE_ETHERNET : ConnectionType.BLUETOOTH : ConnectionType.TYPE_WIMAX : ConnectionType.TYPE_WIFI : ConnectionType.TYPE_MOBILE;
    }

    @Inject
    public ReportDevice(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, PushNotificationRepository pushNotificationRepository) {
        super(threadExecutor, postExecutionThread);
        this.pushNotificationRepository = pushNotificationRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<ReportDeviceResponse> buildUseCaseObservable(Params params) {
        return this.pushNotificationRepository.reportDevice(params.token, params.imsi, params.imei, formatConnectionType(params.connectType));
    }

    /* loaded from: classes4.dex */
    public static class Params {
        private int connectType;
        private String imei;
        private String imsi;
        private String token;

        private Params(String str, String str2, String str3, int i) {
            this.token = str;
            this.imei = str2;
            this.imsi = str3;
            this.connectType = i;
        }

        public static Params forReportDevice(String str, String str2, String str3, int i) {
            return new Params(str, str2, str3, i);
        }
    }
}
