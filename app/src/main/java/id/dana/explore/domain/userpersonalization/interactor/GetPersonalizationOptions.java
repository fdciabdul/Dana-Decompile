package id.dana.explore.domain.userpersonalization.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/explore/domain/userpersonalization/interactor/GetPersonalizationOptions;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "PlaceComponentResult", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetPersonalizationOptions extends BaseUseCase<List<? extends UserPersonalizationModel>, NoParams> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final UserPersonalizationRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends UserPersonalizationModel>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Inject
    public GetPersonalizationOptions(UserPersonalizationRepository userPersonalizationRepository) {
        Intrinsics.checkNotNullParameter(userPersonalizationRepository, "");
        this.getAuthRequestContext = userPersonalizationRepository;
    }
}
