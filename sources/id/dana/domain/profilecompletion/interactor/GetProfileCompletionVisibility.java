package id.dana.domain.profilecompletion.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.profilecompletion.model.ProfileCompletionVisibility;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionVisibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/profilecompletion/model/ProfileCompletionVisibility;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigEntityRepo", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetProfileCompletionVisibility extends BaseUseCase<ProfileCompletionVisibility, NoParams> {
    private final FeatureConfigRepository featureConfigEntityRepo;

    @Inject
    public GetProfileCompletionVisibility(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigEntityRepo = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ProfileCompletionVisibility> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.featureConfigEntityRepo.isProfileCompletionWidgetEnable().map(new Function() { // from class: id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ProfileCompletionVisibility m2417buildUseCase$lambda0;
                m2417buildUseCase$lambda0 = GetProfileCompletionVisibility.m2417buildUseCase$lambda0((Boolean) obj);
                return m2417buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ProfileCompletionVisibility m2417buildUseCase$lambda0(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return new ProfileCompletionVisibility(bool.booleanValue());
    }
}
