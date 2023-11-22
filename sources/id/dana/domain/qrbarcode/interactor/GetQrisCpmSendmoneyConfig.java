package id.dana.domain.qrbarcode.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.qrbarcode.model.CpmToSendMoneyConfig;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetQrisCpmSendmoneyConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/qrbarcode/model/CpmToSendMoneyConfig;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/usereducation/repository/UserEducationRepository;", "userEducationRepository", "Lid/dana/domain/usereducation/repository/UserEducationRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/domain/usereducation/repository/UserEducationRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQrisCpmSendmoneyConfig extends BaseUseCase<CpmToSendMoneyConfig, NoParams> {
    public static final String DEFAULT_PREFIX = "hQVDUFY";
    private final FeatureConfigRepository featureConfigRepository;
    private final UserEducationRepository userEducationRepository;

    @Inject
    public GetQrisCpmSendmoneyConfig(FeatureConfigRepository featureConfigRepository, UserEducationRepository userEducationRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(userEducationRepository, "");
        this.featureConfigRepository = featureConfigRepository;
        this.userEducationRepository = userEducationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CpmToSendMoneyConfig> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.userEducationRepository.isNeedToShowDialog("cpm_to_sendmoney").flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetQrisCpmSendmoneyConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2425buildUseCase$lambda1;
                m2425buildUseCase$lambda1 = GetQrisCpmSendmoneyConfig.m2425buildUseCase$lambda1(GetQrisCpmSendmoneyConfig.this, (Boolean) obj);
                return m2425buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final ObservableSource m2425buildUseCase$lambda1(GetQrisCpmSendmoneyConfig getQrisCpmSendmoneyConfig, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(getQrisCpmSendmoneyConfig, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            just = getQrisCpmSendmoneyConfig.featureConfigRepository.getQrisCpmPrefixes().flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.GetQrisCpmSendmoneyConfig$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2426buildUseCase$lambda1$lambda0;
                    m2426buildUseCase$lambda1$lambda0 = GetQrisCpmSendmoneyConfig.m2426buildUseCase$lambda1$lambda0((List) obj);
                    return m2426buildUseCase$lambda1$lambda0;
                }
            });
        } else {
            ?? r1 = 0;
            just = Observable.just(new CpmToSendMoneyConfig(false, r1, 3, r1));
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1$lambda-0  reason: not valid java name */
    public static final ObservableSource m2426buildUseCase$lambda1$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return Observable.just(new CpmToSendMoneyConfig(true, list));
    }
}
