package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.social.core.SingleUseCase;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.activation.FeedInitRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/InitSocialFeed;", "Lid/dana/domain/social/core/SingleUseCase;", "", "Lid/dana/domain/social/model/InitFeed;", "p0", "Lid/dana/domain/social/Result;", "PlaceComponentResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "getAuthRequestContext", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InitSocialFeed extends SingleUseCase<Unit, InitFeed> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedInitRepository getAuthRequestContext;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        return PlaceComponentResult(continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public InitSocialFeed(id.dana.feeds.domain.activation.FeedInitRepository r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.activation.interactor.InitSocialFeed.<init>(id.dana.feeds.domain.activation.FeedInitRepository):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object PlaceComponentResult(kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.social.model.InitFeed>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.domain.activation.interactor.InitSocialFeed$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.domain.activation.interactor.InitSocialFeed$buildUseCase$1 r0 = (id.dana.feeds.domain.activation.interactor.InitSocialFeed$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.domain.activation.interactor.InitSocialFeed$buildUseCase$1 r0 = new id.dana.feeds.domain.activation.interactor.InitSocialFeed$buildUseCase$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            id.dana.feeds.domain.activation.FeedInitRepository r5 = r4.getAuthRequestContext
            r5.PlaceComponentResult(r3)
            id.dana.feeds.domain.activation.FeedInitRepository r5 = r4.getAuthRequestContext
            r0.label = r3
            java.lang.Object r5 = r5.MyBillsEntityDataFactory(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            id.dana.domain.social.Result$Success r0 = new id.dana.domain.social.Result$Success
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.activation.interactor.InitSocialFeed.PlaceComponentResult(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
