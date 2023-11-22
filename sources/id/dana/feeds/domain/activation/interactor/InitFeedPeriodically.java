package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\b\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/InitFeedPeriodically;", "Lid/dana/domain/social/core/SingleUseCase;", "", "", "p0", "Lid/dana/domain/social/Result;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthRequestContext", "()Z", "Lkotlinx/coroutines/CoroutineDispatcher;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "p1", "p2", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class InitFeedPeriodically extends SingleUseCase<Unit, Boolean> {
    private final CoroutineDispatcher BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CoroutineDispatcher MyBillsEntityDataFactory;
    private final FeedInitRepository getAuthRequestContext;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        return KClassImpl$Data$declaredNonStaticMembers$2(continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public InitFeedPeriodically(FeedInitRepository feedInitRepository, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2) {
        super(coroutineDispatcher, coroutineDispatcher2);
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        this.getAuthRequestContext = feedInitRepository;
        this.BuiltInFictitiousFunctionClassFactory = coroutineDispatcher;
        this.MyBillsEntityDataFactory = coroutineDispatcher2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<java.lang.Boolean>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.domain.activation.interactor.InitFeedPeriodically$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.domain.activation.interactor.InitFeedPeriodically$buildUseCase$1 r0 = (id.dana.feeds.domain.activation.interactor.InitFeedPeriodically$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.domain.activation.interactor.InitFeedPeriodically$buildUseCase$1 r0 = new id.dana.feeds.domain.activation.interactor.InitFeedPeriodically$buildUseCase$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L54
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            boolean r5 = r4.getAuthRequestContext()
            if (r5 == 0) goto L46
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            r5.<init>(r0)
            return r5
        L46:
            id.dana.feeds.domain.activation.FeedInitRepository r5 = r4.getAuthRequestContext
            r5.PlaceComponentResult(r3)
            r0.label = r3
            java.lang.Object r5 = r5.PlaceComponentResult(r0)
            if (r5 != r1) goto L54
            return r1
        L54:
            id.dana.domain.social.Result$Success r0 = new id.dana.domain.social.Result$Success
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.activation.interactor.InitFeedPeriodically.KClassImpl$Data$declaredNonStaticMembers$2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean getAuthRequestContext() {
        Job networkUserEntityData$$ExternalSyntheticLambda0 = this.getAuthRequestContext.getNetworkUserEntityData$$ExternalSyntheticLambda0();
        if (networkUserEntityData$$ExternalSyntheticLambda0 != null) {
            return networkUserEntityData$$ExternalSyntheticLambda0.isActive();
        }
        return false;
    }
}
