package id.dana.domain.homeinfo.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B%\b\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/domain/homeinfo/interactor/GetUserConfig;", "Lid/dana/domain/UseCase;", "", "", "void", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lkotlin/Unit;)Lio/reactivex/Observable;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "getRecentRecipient", "()Lio/reactivex/Observable;", "recentRecipients", "queryCardIndexNo", "(Ljava/util/List;)Lio/reactivex/Observable;", "saveSecureUserConfig", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "recentRecipientRepository", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserConfig extends UseCase<Boolean, Unit> {
    private final RecentRecipientRepository recentRecipientRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GetUserConfig(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RecentRecipientRepository recentRecipientRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.recentRecipientRepository = recentRecipientRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<Boolean> buildUseCaseObservable(Unit r2) {
        return getRecentRecipient().flatMap(new Function() { // from class: id.dana.domain.homeinfo.interactor.GetUserConfig$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2353buildUseCaseObservable$lambda0;
                m2353buildUseCaseObservable$lambda0 = GetUserConfig.m2353buildUseCaseObservable$lambda0(GetUserConfig.this, (List) obj);
                return m2353buildUseCaseObservable$lambda0;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.homeinfo.interactor.GetUserConfig$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2354buildUseCaseObservable$lambda1;
                m2354buildUseCaseObservable$lambda1 = GetUserConfig.m2354buildUseCaseObservable$lambda1(GetUserConfig.this, (List) obj);
                return m2354buildUseCaseObservable$lambda1;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.homeinfo.interactor.GetUserConfig$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2355buildUseCaseObservable$lambda2;
                m2355buildUseCaseObservable$lambda2 = GetUserConfig.m2355buildUseCaseObservable$lambda2(GetUserConfig.this, (Boolean) obj);
                return m2355buildUseCaseObservable$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCaseObservable$lambda-0  reason: not valid java name */
    public static final ObservableSource m2353buildUseCaseObservable$lambda0(GetUserConfig getUserConfig, List list) {
        Intrinsics.checkNotNullParameter(getUserConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        return getUserConfig.queryCardIndexNo(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCaseObservable$lambda-1  reason: not valid java name */
    public static final ObservableSource m2354buildUseCaseObservable$lambda1(GetUserConfig getUserConfig, List list) {
        Observable<Boolean> saveSecureUserConfig;
        Intrinsics.checkNotNullParameter(getUserConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            saveSecureUserConfig = Observable.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(saveSecureUserConfig, "");
        } else {
            saveSecureUserConfig = getUserConfig.saveSecureUserConfig(list);
        }
        return saveSecureUserConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCaseObservable$lambda-2  reason: not valid java name */
    public static final ObservableSource m2355buildUseCaseObservable$lambda2(GetUserConfig getUserConfig, Boolean bool) {
        Intrinsics.checkNotNullParameter(getUserConfig, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue() ? getUserConfig.recentRecipientRepository.storeUserConfig(CollectionsKt.emptyList()) : Observable.just(Boolean.FALSE);
    }

    private final Observable<List<RecentRecipient>> getRecentRecipient() {
        Observable<List<RecentRecipient>> recentRecipientAll = this.recentRecipientRepository.getRecentRecipientAll();
        Intrinsics.checkNotNullExpressionValue(recentRecipientAll, "");
        return recentRecipientAll;
    }

    private final Observable<List<RecentRecipient>> queryCardIndexNo(List<? extends RecentRecipient> recentRecipients) {
        Observable<List<RecentRecipient>> BuiltInFictitiousFunctionClassFactory;
        Single list = Observable.fromIterable(recentRecipients).concatMap(new Function() { // from class: id.dana.domain.homeinfo.interactor.GetUserConfig$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2356queryCardIndexNo$lambda3;
                m2356queryCardIndexNo$lambda3 = GetUserConfig.m2356queryCardIndexNo$lambda3(GetUserConfig.this, (RecentRecipient) obj);
                return m2356queryCardIndexNo$lambda3;
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryCardIndexNo$lambda-3  reason: not valid java name */
    public static final ObservableSource m2356queryCardIndexNo$lambda3(GetUserConfig getUserConfig, RecentRecipient recentRecipient) {
        Observable<RecentRecipient> just;
        Intrinsics.checkNotNullParameter(getUserConfig, "");
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        if (recentRecipient.getType() == 1) {
            just = getUserConfig.recentRecipientRepository.convertCardIndexNo(recentRecipient);
        } else {
            just = Observable.just(recentRecipient);
        }
        return just;
    }

    private final Observable<Boolean> saveSecureUserConfig(final List<? extends RecentRecipient> recentRecipients) {
        Observable flatMap = this.recentRecipientRepository.storeLocalSecureUserConfig(recentRecipients).flatMap(new Function() { // from class: id.dana.domain.homeinfo.interactor.GetUserConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2357saveSecureUserConfig$lambda4;
                m2357saveSecureUserConfig$lambda4 = GetUserConfig.m2357saveSecureUserConfig$lambda4(GetUserConfig.this, recentRecipients, (Boolean) obj);
                return m2357saveSecureUserConfig$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveSecureUserConfig$lambda-4  reason: not valid java name */
    public static final ObservableSource m2357saveSecureUserConfig$lambda4(GetUserConfig getUserConfig, List list, Boolean bool) {
        Intrinsics.checkNotNullParameter(getUserConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return getUserConfig.recentRecipientRepository.storeSecureUserConfig(list);
    }
}
