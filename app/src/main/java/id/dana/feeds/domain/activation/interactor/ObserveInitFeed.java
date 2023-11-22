package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\b8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/ObserveInitFeed;", "Lid/dana/domain/social/core/SingleUseCase;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/social/model/InitFeed;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "", "PlaceComponentResult", "Z", "getAuthRequestContext", "()Z", "Lid/dana/domain/PostExecutionThread;", "Lid/dana/domain/PostExecutionThread;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/utils/concurrent/ThreadExecutor;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ObserveInitFeed extends SingleUseCase<Unit, Observable<InitFeed>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ThreadExecutor BuiltInFictitiousFunctionClassFactory;
    private final FeedInitRepository MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PostExecutionThread KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        this.getAuthRequestContext = true;
        BehaviorSubject<InitFeed> moveToNextValue = this.MyBillsEntityDataFactory.moveToNextValue();
        moveToNextValue.onNext(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().blockingSingle().toInitFeed());
        return new Result.Success(moveToNextValue.distinctUntilChanged().subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory)).observeOn(this.KClassImpl$Data$declaredNonStaticMembers$2.getScheduler()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ObserveInitFeed(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, FeedInitRepository feedInitRepository) {
        super(coroutineDispatcher, coroutineDispatcher2);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = threadExecutor;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = postExecutionThread;
        this.MyBillsEntityDataFactory = feedInitRepository;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
