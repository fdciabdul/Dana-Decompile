package id.dana.feeds.domain.activation;

import id.dana.domain.social.model.FeedInit;
import id.dana.domain.social.model.FeedStatus;
import id.dana.domain.social.model.InitFeed;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H&¢\u0006\u0004\b\u0012\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u0013\u0010\t\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0013J\u0013\u0010\u0004\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\u0015\u0010\u0005R\u001c\u0010\u0004\u001a\u00020\b8'@'X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0014\u0010\u0017ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/activation/FeedInitRepository;", "", "Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "Lid/dana/domain/social/model/FeedStatus;", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/Job;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/Job;", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/domain/social/model/InitFeed;", "moveToNextValue", "()Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/domain/social/model/FeedInit;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlaceComponentResult", "scheduleImpl", "()Z", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedInitRepository {
    Observable<Unit> BuiltInFictitiousFunctionClassFactory();

    Object BuiltInFictitiousFunctionClassFactory(Continuation<? super InitFeed> continuation);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    Job getNetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<Boolean> MyBillsEntityDataFactory();

    Object MyBillsEntityDataFactory(Continuation<? super InitFeed> continuation);

    Observable<FeedInit> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Object PlaceComponentResult(Continuation<? super Boolean> continuation);

    @JvmName(name = "PlaceComponentResult")
    void PlaceComponentResult(boolean z);

    @JvmName(name = "PlaceComponentResult")
    boolean PlaceComponentResult();

    Observable<FeedStatus> getAuthRequestContext();

    Object getAuthRequestContext(Continuation<? super InitFeed> continuation);

    BehaviorSubject<InitFeed> moveToNextValue();

    Observable<Boolean> scheduleImpl();
}
