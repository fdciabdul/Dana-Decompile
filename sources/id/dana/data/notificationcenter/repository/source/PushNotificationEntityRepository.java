package id.dana.data.notificationcenter.repository.source;

import com.google.firebase.installations.FirebaseInstallations;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.notificationcenter.mapper.PushNotificationMapper;
import id.dana.data.notificationcenter.repository.source.network.result.ReportDeviceResult;
import id.dana.data.storage.GeneralPreferencesData;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.domain.notificationcenter.model.BindAppResponse;
import id.dana.domain.notificationcenter.model.ReportDeviceResponse;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PushNotificationEntityRepository implements PushNotificationRepository {
    private final PushNotificationEntityDataFactory factory;
    private final GeneralPreferencesDataFactory generalPreferencesDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final PushNotificationMapper pushNotificationMapper;
    private final SecurityGuardFacade securityGuardFacade;

    @Inject
    public PushNotificationEntityRepository(GeneralPreferencesDataFactory generalPreferencesDataFactory, PushNotificationEntityDataFactory pushNotificationEntityDataFactory, PushNotificationMapper pushNotificationMapper, SecurityGuardFacade securityGuardFacade, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.factory = pushNotificationEntityDataFactory;
        this.pushNotificationMapper = pushNotificationMapper;
        this.generalPreferencesDataFactory = generalPreferencesDataFactory;
        this.securityGuardFacade = securityGuardFacade;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.notificationcenter.repository.PushNotificationRepository
    public Observable<ReportDeviceResponse> reportDevice(String str, String str2, String str3, String str4) {
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNotificationData().reportDevice(str, str2, str3, str4));
        final PushNotificationMapper pushNotificationMapper = this.pushNotificationMapper;
        Objects.requireNonNull(pushNotificationMapper);
        return authenticatedRequest.map(new Function() { // from class: id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PushNotificationMapper.this.transform((ReportDeviceResult) obj);
            }
        }).doOnError(new Consumer() { // from class: id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PushNotificationEntityRepository.this.m1543xecc94a47((Throwable) obj);
            }
        }).map(new Function() { // from class: id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PushNotificationEntityRepository.this.m1544x34c8a8a6((ReportDeviceResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$reportDevice$0$id-dana-data-notificationcenter-repository-source-PushNotificationEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1543xecc94a47(Throwable th) throws Exception {
        createGeneralPreferences().saveTokenRegistrationStatus(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$reportDevice$1$id-dana-data-notificationcenter-repository-source-PushNotificationEntityRepository  reason: not valid java name */
    public /* synthetic */ ReportDeviceResponse m1544x34c8a8a6(ReportDeviceResponse reportDeviceResponse) throws Exception {
        createGeneralPreferences().saveTokenRegistrationStatus(true);
        return reportDeviceResponse;
    }

    private PushNotificationEntityData createNotificationData() {
        return this.factory.createData2("network");
    }

    private GeneralPreferencesData createGeneralPreferences() {
        return this.generalPreferencesDataFactory.createData2("local");
    }

    @Override // id.dana.domain.notificationcenter.repository.PushNotificationRepository
    public Observable<BindAppResponse> bindApp() {
        return createGeneralPreferences().getRegistrationTokenStatus().flatMap(new Function() { // from class: id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PushNotificationEntityRepository.this.m1541x80ff18a5((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bindApp$2$id-dana-data-notificationcenter-repository-source-PushNotificationEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1541x80ff18a5(Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            FirebaseInstallations.getInstance().delete();
        }
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNotificationData().bindApp(CommonUtil.MyBillsEntityDataFactory(this.securityGuardFacade, "")));
        PushNotificationMapper pushNotificationMapper = this.pushNotificationMapper;
        Objects.requireNonNull(pushNotificationMapper);
        return authenticatedRequest.map(new PushNotificationEntityRepository$$ExternalSyntheticLambda0(pushNotificationMapper));
    }

    @Override // id.dana.domain.notificationcenter.repository.PushNotificationRepository
    public Observable<BindAppResponse> bindAppSession() {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createGeneralPreferences().getRegistrationTokenStatus().flatMap(new Function() { // from class: id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PushNotificationEntityRepository.this.m1542x9585f8fc((Boolean) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$bindAppSession$3$id-dana-data-notificationcenter-repository-source-PushNotificationEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m1542x9585f8fc(Boolean bool) throws Exception {
        if (!bool.booleanValue()) {
            FirebaseInstallations.getInstance().delete();
        }
        Observable authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(createNotificationData().bindApp(CommonUtil.MyBillsEntityDataFactory(this.securityGuardFacade, "")));
        PushNotificationMapper pushNotificationMapper = this.pushNotificationMapper;
        Objects.requireNonNull(pushNotificationMapper);
        return authenticatedRequest.map(new PushNotificationEntityRepository$$ExternalSyntheticLambda0(pushNotificationMapper));
    }
}
