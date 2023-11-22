package id.dana.feeds.domain.share.interactor;

import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "Lid/dana/domain/social/core/SingleUseCase;", "", "", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetShareFeedConsent extends SingleUseCase<Unit, Boolean> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsShareRepository getAuthRequestContext;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        return new Result.Success(Boxing.boxBoolean(this.getAuthRequestContext.PlaceComponentResult()));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetShareFeedConsent(id.dana.feeds.domain.share.FeedsShareRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.getAuthRequestContext = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.share.interactor.GetShareFeedConsent.<init>(id.dana.feeds.domain.share.FeedsShareRepository):void");
    }
}
