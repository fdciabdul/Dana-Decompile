package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/share/interactor/CheckPendingShareFeedDialog;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/share/model/ShareFeedActivity;", "", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckPendingShareFeedDialog extends BaseUseCase<ShareFeedActivity, Unit> {
    private final FeedsShareRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<ShareFeedActivity> buildUseCase(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "");
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
    }

    @Inject
    public CheckPendingShareFeedDialog(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.MyBillsEntityDataFactory = feedsShareRepository;
    }
}
