package id.dana.feeds.domain.profile.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/feeds/domain/profile/interactor/GetProfileCta;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/feeds/domain/config/FeedsConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetProfileCta extends BaseUseCase<List<? extends ProfileCtaConfig>, NoParams> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsConfigRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends ProfileCtaConfig>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Inject
    public GetProfileCta(FeedsConfigRepository feedsConfigRepository) {
        Intrinsics.checkNotNullParameter(feedsConfigRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsConfigRepository;
    }
}
