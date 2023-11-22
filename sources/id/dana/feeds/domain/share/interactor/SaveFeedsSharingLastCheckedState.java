package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/share/interactor/SaveFeedsSharingLastCheckedState;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SaveFeedsSharingLastCheckedState extends BaseUseCase<Boolean, Boolean> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedsShareRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Boolean bool) {
        return this.PlaceComponentResult.getAuthRequestContext(bool.booleanValue());
    }

    @Inject
    public SaveFeedsSharingLastCheckedState(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.PlaceComponentResult = feedsShareRepository;
    }
}
