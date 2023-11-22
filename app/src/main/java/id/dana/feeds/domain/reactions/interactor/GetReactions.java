package id.dana.feeds.domain.reactions.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import id.dana.feeds.domain.reactions.model.Reaction;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/feeds/domain/reactions/interactor/GetReactions;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/feeds/domain/reactions/model/Reaction;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/feeds/domain/reactions/FeedsReactionRepository;", "getAuthRequestContext", "Lid/dana/feeds/domain/reactions/FeedsReactionRepository;", "p0", "<init>", "(Lid/dana/feeds/domain/reactions/FeedsReactionRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetReactions extends BaseUseCase<List<? extends Reaction>, NoParams> {
    public final FeedsReactionRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends Reaction>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Inject
    public GetReactions(FeedsReactionRepository feedsReactionRepository) {
        Intrinsics.checkNotNullParameter(feedsReactionRepository, "");
        this.getAuthRequestContext = feedsReactionRepository;
    }
}
