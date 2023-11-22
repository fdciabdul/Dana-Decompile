package id.dana.explore.domain.userpersonalization.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/explore/domain/userpersonalization/interactor/SaveUserPersonalizationShown;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SaveUserPersonalizationShown extends CompletableUseCase<NoParams> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final UserPersonalizationRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final /* synthetic */ Completable buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Completable ignoreElements = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult().ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Inject
    public SaveUserPersonalizationShown(UserPersonalizationRepository userPersonalizationRepository) {
        Intrinsics.checkNotNullParameter(userPersonalizationRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = userPersonalizationRepository;
    }
}
