package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.social.core.SingleUseCase;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/InitFeedWithoutContact;", "Lid/dana/domain/social/core/SingleUseCase;", "", "Lid/dana/domain/social/model/InitFeed;", "p0", "Lid/dana/domain/social/Result;", "getAuthRequestContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InitFeedWithoutContact extends SingleUseCase<Unit, InitFeed> {
    private final FeedsShareRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedInitRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        return getAuthRequestContext(continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public InitFeedWithoutContact(id.dana.feeds.domain.activation.FeedInitRepository r3, id.dana.feeds.domain.share.FeedsShareRepository r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.MyBillsEntityDataFactory = r3
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact.<init>(id.dana.feeds.domain.activation.FeedInitRepository, id.dana.feeds.domain.share.FeedsShareRepository):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.social.model.InitFeed>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r8
            id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact$buildUseCase$1 r0 = (id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 + r2
            r0.label = r8
            goto L19
        L14:
            id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact$buildUseCase$1 r0 = new id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact$buildUseCase$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L48
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            id.dana.feeds.domain.share.FeedsShareRepository r8 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r8 = r8.PlaceComponentResult()
            if (r8 == 0) goto L4b
            id.dana.feeds.domain.activation.FeedInitRepository r8 = r7.MyBillsEntityDataFactory
            r0.label = r3
            java.lang.Object r8 = r8.BuiltInFictitiousFunctionClassFactory(r0)
            if (r8 != r1) goto L48
            return r1
        L48:
            id.dana.domain.social.model.InitFeed r8 = (id.dana.domain.social.model.InitFeed) r8
            goto L59
        L4b:
            id.dana.domain.social.model.InitFeed r8 = new id.dana.domain.social.model.InitFeed
            id.dana.domain.social.InitStatus r1 = id.dana.domain.social.InitStatus.FINISH
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r6 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L59:
            id.dana.domain.social.Result$Success r0 = new id.dana.domain.social.Result$Success
            r0.<init>(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.activation.interactor.InitFeedWithoutContact.getAuthRequestContext(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
