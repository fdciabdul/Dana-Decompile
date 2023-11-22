package id.dana.data.risk.riskevent.repository;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.risk.riskevent.SendRiskEventEntityData;
import id.dana.data.risk.riskevent.SendRiskEventEntityDataFactory;
import id.dana.data.risk.riskevent.config.RiskServicesConfigEntityDataFactory;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SendRiskEventEntityRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final RiskServicesConfigEntityDataFactory riskServicesConfigEntityDataFactory;
    private final SendRiskEventEntityDataFactory sendRiskEventEntityDataFactory;

    @Inject
    public SendRiskEventEntityRepository(SendRiskEventEntityDataFactory sendRiskEventEntityDataFactory, RiskServicesConfigEntityDataFactory riskServicesConfigEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.sendRiskEventEntityDataFactory = sendRiskEventEntityDataFactory;
        this.riskServicesConfigEntityDataFactory = riskServicesConfigEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    public Observable<Boolean> sendRiskEvent(final String str, final String str2, final String str3) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createNetworkConfigData().isEnableSendRiskLuckyMoney().flatMap(new Function() { // from class: id.dana.data.risk.riskevent.repository.SendRiskEventEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SendRiskEventEntityRepository.this.m1841xfd4061e6(str, str2, str3, (Boolean) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendRiskEvent$1$id-dana-data-risk-riskevent-repository-SendRiskEventEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1841xfd4061e6(String str, String str2, String str3, Boolean bool) throws Exception {
        if (bool == null || !bool.booleanValue()) {
            return Observable.just(Boolean.FALSE);
        }
        return createNetworkData().sendRiskEvent(str, str2, str3).map(new Function() { // from class: id.dana.data.risk.riskevent.repository.SendRiskEventEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r0 != null);
                return valueOf;
            }
        });
    }

    private SendRiskEventEntityData createNetworkData() {
        return this.sendRiskEventEntityDataFactory.createData2("network");
    }

    private ConfigEntityData createNetworkConfigData() {
        return this.riskServicesConfigEntityDataFactory.createData2("network");
    }
}
