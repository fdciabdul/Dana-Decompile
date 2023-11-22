package id.dana.domain.homeinfo.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.homeinfo.repository.HomeOmniRepository;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/homeinfo/interactor/GetSurveyInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/wallet_v3/model/SurveyInfoModel;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/homeinfo/repository/HomeOmniRepository;", "homeOmniRepository", "Lid/dana/domain/homeinfo/repository/HomeOmniRepository;", "<init>", "(Lid/dana/domain/homeinfo/repository/HomeOmniRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetSurveyInfo extends BaseUseCase<SurveyInfoModel, NoParams> {
    private final HomeOmniRepository homeOmniRepository;

    @Inject
    public GetSurveyInfo(HomeOmniRepository homeOmniRepository) {
        Intrinsics.checkNotNullParameter(homeOmniRepository, "");
        this.homeOmniRepository = homeOmniRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SurveyInfoModel> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.homeOmniRepository.getSurveyInfo();
    }
}
