package id.dana.sync_engine.domain.interactor;

import id.dana.analytics.firebase.Crashlytics;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.UseCaseSchedulers;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.engine.DefaultSyncContactEngine;
import id.dana.sync_engine.domain.engine.SyncContactEngine;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.sync_engine.domain.model.ContactResult;
import id.dana.sync_engine.domain.model.SyncContactAction;
import id.dana.sync_engine.domain.model.SyncContactEngineState;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.sync_engine.domain.model.SyncType;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.sync_engine.domain.model.UserType;
import id.dana.sync_engine.exception.SyncEngineException;
import id.dana.utils.diffalgorithm.MyersDiff;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteException;

@Singleton
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00040123B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020$\u0012\u0006\u0010\u0006\u001a\u00020,¢\u0006\u0004\b.\u0010/J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000fJO\u0010\r\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\r\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\f2\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u001cH\u0002¢\u0006\u0004\b\n\u0010\u001eJ%\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0002¢\u0006\u0004\b\r\u0010\u001fJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010 J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010!J=\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0002¢\u0006\u0004\b\r\u0010#R\u0014\u0010\u0019\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\r\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0)X\u0000¢\u0006\u0006\n\u0004\b\n\u0010+R\u0014\u0010%\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010-"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/sync_engine/domain/model/ContactResult;", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;", "", "p0", "p1", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(IILid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;)V", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;)Lio/reactivex/Observable;", "(Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;Lid/dana/sync_engine/domain/model/ContactResult;)V", "", "Lid/dana/sync_engine/domain/model/UserContact;", "Lkotlin/Triple;", "(Ljava/util/List;Ljava/util/List;)Lkotlin/Triple;", "Lid/dana/sync_engine/domain/model/UserType;", "", "MyBillsEntityDataFactory", "(Lid/dana/sync_engine/domain/model/UserType;Lid/dana/sync_engine/domain/model/UserContact;)Z", "p3", "PlaceComponentResult", "(Lid/dana/sync_engine/domain/model/UserType;III)Lio/reactivex/Observable;", "Lkotlin/Function0;", "Lkotlin/Function1;", "", "(IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "(Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;Lkotlin/jvm/functions/Function0;)V", "(Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;)V", "(IIILid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;)V", "p4", "(IIILid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;Lkotlin/jvm/functions/Function0;)V", "Lid/dana/sync_engine/domain/ContactRepository;", "getAuthRequestContext", "Lid/dana/sync_engine/domain/ContactRepository;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$GCState;", "Ljava/util/Map;", "Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;", "Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;", "<init>", "(Lid/dana/sync_engine/domain/ContactRepository;Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;)V", "Companion", "GCState", "Params", "SubscriptionKey"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetContactsUseCase extends BaseUseCase<ContactResult, Params> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Map<SubscriptionKey, GCState> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ReentrantLock KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DefaultSyncContactEngine getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ContactRepository PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[UserType.values().length];
            iArr[UserType.All.ordinal()] = 1;
            iArr[UserType.Dana.ordinal()] = 2;
            iArr[UserType.NonDana.ordinal()] = 3;
            MyBillsEntityDataFactory = iArr;
        }
    }

    @JvmStatic
    public static final Params BuiltInFictitiousFunctionClassFactory() {
        return Companion.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public GetContactsUseCase(ContactRepository contactRepository, DefaultSyncContactEngine defaultSyncContactEngine) {
        Intrinsics.checkNotNullParameter(contactRepository, "");
        Intrinsics.checkNotNullParameter(defaultSyncContactEngine, "");
        this.PlaceComponentResult = contactRepository;
        this.getAuthRequestContext = defaultSyncContactEngine;
        this.MyBillsEntityDataFactory = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ReentrantLock();
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final Observable<ContactResult> buildUseCase(Params p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final SubscriptionKey subscriptionKey = new SubscriptionKey(p0.PlaceComponentResult);
        this.KClassImpl$Data$declaredNonStaticMembers$2.lock();
        GCState gCState = this.MyBillsEntityDataFactory.get(subscriptionKey);
        Observable<ContactResult> observable = gCState != null ? gCState.BuiltInFictitiousFunctionClassFactory : null;
        if (observable != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.unlock();
            return observable;
        }
        ReplaySubject BuiltInFictitiousFunctionClassFactory = ReplaySubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Observable<ContactResult> doOnDispose = BuiltInFictitiousFunctionClassFactory.doOnSubscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, subscriptionKey);
            }
        }).doOnDispose(new Action() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Action
            public final void run() {
                GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(GetContactsUseCase.this, subscriptionKey);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "");
        this.MyBillsEntityDataFactory.put(subscriptionKey, new GCState(doOnDispose, BuiltInFictitiousFunctionClassFactory, p0));
        this.KClassImpl$Data$declaredNonStaticMembers$2.unlock();
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" from ");
        sb.append(subscriptionKey.getAuthRequestContext);
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        Observable zip = Observable.zip(this.PlaceComponentResult.getAuthRequestContext(SyncContactType.Local), this.PlaceComponentResult.getAuthRequestContext("device"), this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("local"), this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2("device"), new Function4() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                return GetContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(GetContactsUseCase.this, (Long) obj, (UserContact) obj2, (Integer) obj3, (Integer) obj4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        Disposable subscribe = zip.subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(GetContactsUseCase.this, subscriptionKey, (SyncContactAction) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(GetContactsUseCase.this, subscriptionKey, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        collect(subscribe);
        return doOnDispose;
    }

    private final void BuiltInFictitiousFunctionClassFactory(final int p0, final int p1, final SubscriptionKey p2) {
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" Changes actionChangesContact limit ");
        sb.append(p0);
        sb.append(", offset ");
        sb.append(p1);
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        Disposable subscribe = Observable.zip(this.PlaceComponentResult.PlaceComponentResult("local", p0, p1), this.PlaceComponentResult.PlaceComponentResult("device", p0, p1), new BiFunction() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return GetContactsUseCase.BuiltInFictitiousFunctionClassFactory((List) obj, (List) obj2);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).flatMap(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(GetContactsUseCase.this, (Pair) obj);
            }
        }).map(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetContactsUseCase.MyBillsEntityDataFactory((Triple) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, (Triple) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetContactsUseCase.getAuthRequestContext(GetContactsUseCase.this, (Pair) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                List list = (List) obj;
                GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, p0, p1, p2);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.getAuthRequestContext(GetContactsUseCase.this, p2, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        collect(subscribe);
    }

    private static boolean MyBillsEntityDataFactory(UserType p0, UserContact p1) {
        int i = WhenMappings.MyBillsEntityDataFactory[p0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return Intrinsics.areEqual(p1.BuiltInFictitiousFunctionClassFactory, Boolean.FALSE);
                }
                throw new NoWhenBranchMatchedException();
            }
            return Intrinsics.areEqual(p1.BuiltInFictitiousFunctionClassFactory, Boolean.TRUE);
        }
        return true;
    }

    private final void BuiltInFictitiousFunctionClassFactory(final int p0, final int p1, final Function0<Unit> p2, final Function1<? super Throwable, Unit> p3) {
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" insertAllContact() : limit : ");
        sb.append(p0);
        sb.append(", offset: ");
        sb.append(p1);
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        Disposable subscribe = this.PlaceComponentResult.PlaceComponentResult("device", p0, p1).subscribeOn(Schedulers.MyBillsEntityDataFactory()).flatMap(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, (List) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.MyBillsEntityDataFactory(GetContactsUseCase.this, p0, p1, p2, p3, (Boolean) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(Function1.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        collect(subscribe);
    }

    private final Observable<List<UserContact>> PlaceComponentResult(UserType p0, int p1, int p2, int p3) {
        int i = WhenMappings.MyBillsEntityDataFactory[p0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return this.PlaceComponentResult.getAuthRequestContext("local", p1, p2, Boolean.FALSE, p3);
                }
                throw new NoWhenBranchMatchedException();
            }
            return this.PlaceComponentResult.getAuthRequestContext("local", p1, p2, Boolean.TRUE, p3);
        }
        return this.PlaceComponentResult.PlaceComponentResult("local", p1, p2);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(SubscriptionKey p0, Function0<Unit> p1) {
        Params params;
        GCState gCState = this.MyBillsEntityDataFactory.get(p0);
        boolean z = false;
        if (gCState != null && (params = gCState.MyBillsEntityDataFactory) != null && !params.getBuiltInFictitiousFunctionClassFactory()) {
            z = true;
        }
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(1000, 0, 0, p0, p1);
        } else {
            p1.invoke();
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(final int p0, final int p1, final int p2, final SubscriptionKey p3, final Function0<Unit> p4) {
        Params params;
        UserType userType;
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" selectAllContactLocal() : limit : ");
        sb.append(p0);
        sb.append(", offset: ");
        sb.append(p1);
        sb.append(", counter ");
        sb.append(p2);
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        GCState gCState = this.MyBillsEntityDataFactory.get(p3);
        if (gCState == null || (params = gCState.MyBillsEntityDataFactory) == null || (userType = params.getAuthRequestContext) == null) {
            return;
        }
        Disposable subscribe = PlaceComponentResult(userType, p0, p1, p2).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(p2, this, p3, p0, p1, p4, (List) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, p3, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        collect(subscribe);
    }

    private final void BuiltInFictitiousFunctionClassFactory(SubscriptionKey p0) {
        Params params;
        GCState gCState = this.MyBillsEntityDataFactory.get(p0);
        if ((gCState == null || (params = gCState.MyBillsEntityDataFactory) == null || params.getBuiltInFictitiousFunctionClassFactory()) ? false : true) {
            BuiltInFictitiousFunctionClassFactory(1000, 0, 0, p0);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(final int p0, final int p1, final int p2, final SubscriptionKey p3) {
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" selectAllContactDevice() : limit : ");
        sb.append(p0);
        sb.append(", offset: ");
        sb.append(p1);
        sb.append(", counter ");
        sb.append(p2);
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        Disposable subscribe = this.PlaceComponentResult.PlaceComponentResult("device", p0, p1).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(p2, this, p3, p0, p1, (List) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(GetContactsUseCase.this, p3, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        collect(subscribe);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(SubscriptionKey p0, ContactResult p1) {
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            GCState gCState = this.MyBillsEntityDataFactory.get(p0);
            ReplaySubject<ContactResult> replaySubject = gCState != null ? gCState.PlaceComponentResult : null;
            if (replaySubject != null) {
                replaySubject.onNext(p1);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private static Triple<List<UserContact>, List<UserContact>, List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(final List<UserContact> p0, final List<UserContact> p1) {
        final List mutableList = CollectionsKt.toMutableList((Collection) p0);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        try {
            MyersDiff.BuiltInFictitiousFunctionClassFactory(p0.size(), p1.size(), new Function2<Integer, Integer, Boolean>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$doDiff$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Boolean invoke(Integer num, Integer num2) {
                    return invoke(num.intValue(), num2.intValue());
                }

                public final Boolean invoke(int i, int i2) {
                    UserContact userContact = p0.get(i);
                    UserContact userContact2 = p1.get(i2);
                    return Boolean.valueOf(Intrinsics.areEqual(userContact.scheduleImpl, userContact2.scheduleImpl) && Intrinsics.areEqual(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0, userContact2.NetworkUserEntityData$$ExternalSyntheticLambda0));
                }
            }).PlaceComponentResult(new Function1<MyersDiff.Change, Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$doDiff$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MyersDiff.Change change) {
                    invoke2(change);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MyersDiff.Change change) {
                    Intrinsics.checkNotNullParameter(change, "");
                    if (change instanceof MyersDiff.Change.Insert) {
                        MyersDiff.Change.Insert insert = (MyersDiff.Change.Insert) change;
                        int i = insert.KClassImpl$Data$declaredNonStaticMembers$2;
                        int i2 = insert.BuiltInFictitiousFunctionClassFactory;
                        while (i < insert.KClassImpl$Data$declaredNonStaticMembers$2 + insert.MyBillsEntityDataFactory) {
                            arrayList.add(p1.get(i2));
                            mutableList.add(i, p1.get(i2));
                            i++;
                            i2++;
                        }
                    } else if (change instanceof MyersDiff.Change.Remove) {
                        MyersDiff.Change.Remove remove = (MyersDiff.Change.Remove) change;
                        int i3 = (remove.MyBillsEntityDataFactory + remove.BuiltInFictitiousFunctionClassFactory) - 1;
                        for (int i4 = remove.BuiltInFictitiousFunctionClassFactory; i4 > 0; i4--) {
                            arrayList2.add(mutableList.get(i3));
                            mutableList.remove(i3);
                            i3--;
                        }
                    }
                }
            });
        } catch (Exception e) {
            Exception exc = e;
            try {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("2.15.1 MYERS_DIFF EXCEPTION", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "2.15.1 MYERS_DIFF EXCEPTION");
                Intrinsics.checkNotNullParameter(exc, "");
                authRequestContext.getAuthRequestContext.recordException(exc);
            } catch (Exception unused) {
            }
        }
        return new Triple<>(arrayList, arrayList2, mutableList);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u000e\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\f\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0012X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0015X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0017X\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "PlaceComponentResult", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "Lid/dana/sync_engine/domain/model/SyncType;", "Lid/dana/sync_engine/domain/model/SyncType;", "Lid/dana/sync_engine/domain/model/UserType;", "Lid/dana/sync_engine/domain/model/UserType;", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/sync_engine/domain/model/SyncForFeature;Lid/dana/sync_engine/domain/model/UserType;Lid/dana/sync_engine/domain/model/SyncType;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final UserType getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final SyncType MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;
        final SyncForFeature PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return this.PlaceComponentResult == params.PlaceComponentResult && this.getAuthRequestContext == params.getAuthRequestContext && this.MyBillsEntityDataFactory == params.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == params.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == params.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.PlaceComponentResult.hashCode();
            int hashCode2 = this.getAuthRequestContext.hashCode();
            int hashCode3 = this.MyBillsEntityDataFactory.hashCode();
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + (z2 ? 1 : z2 ? 1 : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            return sb.toString();
        }

        public Params(SyncForFeature syncForFeature, UserType userType, SyncType syncType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(syncForFeature, "");
            Intrinsics.checkNotNullParameter(userType, "");
            Intrinsics.checkNotNullParameter(syncType, "");
            this.PlaceComponentResult = syncForFeature;
            this.getAuthRequestContext = userType;
            this.MyBillsEntityDataFactory = syncType;
            this.BuiltInFictitiousFunctionClassFactory = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        }

        public /* synthetic */ Params(SyncForFeature syncForFeature, UserType userType, SyncType syncType, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(syncForFeature, (i & 2) != 0 ? UserType.All : userType, (i & 4) != 0 ? SyncType.Server : syncType, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0011\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0014\u001a\u00020\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0012\u0010\u000e\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$GCState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/subjects/ReplaySubject;", "Lid/dana/sync_engine/domain/model/ContactResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/ReplaySubject;", "PlaceComponentResult", "getAuthRequestContext", "Z", "Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;", "I", "p1", "p2", "p3", "p4", "<init>", "(Lio/reactivex/Observable;Lio/reactivex/subjects/ReplaySubject;Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class GCState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        ReplaySubject<ContactResult> PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        Observable<ContactResult> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        Params MyBillsEntityDataFactory;
        public boolean getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof GCState) {
                GCState gCState = (GCState) p0;
                return this.KClassImpl$Data$declaredNonStaticMembers$2 == gCState.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, gCState.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, gCState.PlaceComponentResult) && this.getAuthRequestContext == gCState.getAuthRequestContext && Intrinsics.areEqual(this.MyBillsEntityDataFactory, gCState.MyBillsEntityDataFactory);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            int hashCode2 = this.PlaceComponentResult.hashCode();
            boolean z = this.getAuthRequestContext;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return (((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + i2) * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("GCState(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        public GCState(Observable<ContactResult> observable, ReplaySubject<ContactResult> replaySubject, Params params) {
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(replaySubject, "");
            Intrinsics.checkNotNullParameter(params, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.BuiltInFictitiousFunctionClassFactory = observable;
            this.PlaceComponentResult = replaySubject;
            this.getAuthRequestContext = false;
            this.MyBillsEntityDataFactory = params;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$SubscriptionKey;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "getAuthRequestContext", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "<init>", "(Lid/dana/sync_engine/domain/model/SyncForFeature;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SubscriptionKey {
        final SyncForFeature getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof SubscriptionKey) && this.getAuthRequestContext == ((SubscriptionKey) p0).getAuthRequestContext;
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SubscriptionKey(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public SubscriptionKey(SyncForFeature syncForFeature) {
            Intrinsics.checkNotNullParameter(syncForFeature, "");
            this.getAuthRequestContext = syncForFeature;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Companion;", "", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/sync_engine/domain/interactor/GetContactsUseCase$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Params BuiltInFictitiousFunctionClassFactory() {
            return new Params(SyncForFeature.Referral, UserType.All, null, false, false, 28, null);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (th instanceof SQLiteException) {
            Intrinsics.checkNotNullExpressionValue(th, "");
            try {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("2.15.0 SQLLITE EXCEPTION", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "2.15.0 SQLLITE EXCEPTION");
                Intrinsics.checkNotNullParameter(th, "");
                authRequestContext.getAuthRequestContext.recordException(th);
            } catch (Exception unused) {
            }
            getContactsUseCase.BuiltInFictitiousFunctionClassFactory(subscriptionKey);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(th, "");
        getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Error(th));
    }

    public static /* synthetic */ void PlaceComponentResult(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        ReentrantLock reentrantLock = getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            GCState gCState = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
            int i = gCState != null ? gCState.KClassImpl$Data$declaredNonStaticMembers$2 : 0;
            GCState gCState2 = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
            if (gCState2 != null) {
                gCState2.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getContactsUseCase.hashCode());
            sb.append(" addObserver refCount : ");
            GCState gCState3 = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
            sb.append(gCState3 != null ? Integer.valueOf(gCState3.KClassImpl$Data$declaredNonStaticMembers$2) : null);
            DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Error(th));
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(GetContactsUseCase getContactsUseCase, List list) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(list, "");
        StringBuilder sb = new StringBuilder();
        sb.append(getContactsUseCase.hashCode());
        sb.append(" Changes removeContacts-db size : ");
        sb.append(list.size());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        return getContactsUseCase.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(list);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(GetContactsUseCase getContactsUseCase, Pair pair) {
        Observable just;
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(pair, "");
        List<UserContact> list = (List) pair.component1();
        final List list2 = (List) pair.component2();
        StringBuilder sb = new StringBuilder();
        sb.append(getContactsUseCase.hashCode());
        sb.append(" Changes addContacts : ");
        sb.append(list.size());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        if ((!list.isEmpty()) != false) {
            just = getContactsUseCase.PlaceComponentResult.PlaceComponentResult(list).map(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(list2, (Unit) obj);
                }
            });
        } else {
            just = Observable.just(list2);
        }
        return just;
    }

    public static /* synthetic */ SyncContactAction KClassImpl$Data$declaredNonStaticMembers$2(GetContactsUseCase getContactsUseCase, Long l, UserContact userContact, Integer num, Integer num2) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(l, "");
        Intrinsics.checkNotNullParameter(userContact, "");
        Intrinsics.checkNotNullParameter(num, "");
        Intrinsics.checkNotNullParameter(num2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(getContactsUseCase.hashCode());
        sb.append(" getSyncContactAction lastSyncTimestamp ");
        sb.append(l.longValue());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getContactsUseCase.hashCode());
        sb2.append(" getSyncContactAction latestContact ");
        sb2.append(userContact.PlaceComponentResult);
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getContactsUseCase.hashCode());
        sb3.append(" getSyncContactAction localSize ");
        sb3.append(num.intValue());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(getContactsUseCase.hashCode());
        sb4.append(" getSyncContactAction deviceSize ");
        sb4.append(num2.intValue());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb4.toString());
        String str = userContact.PlaceComponentResult;
        long longValue = (str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? -1L : longOrNull.longValue();
        boolean z = l.longValue() > 0 && longValue > 0 && longValue >= l.longValue() && longValue - l.longValue() > TimeUnit.SECONDS.toMillis(30L);
        if (num.intValue() == 0) {
            return SyncContactAction.InsertAll.INSTANCE;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (z) {
                return SyncContactAction.Changes.INSTANCE;
            }
            return SyncContactAction.SelectAll.INSTANCE;
        }
        return SyncContactAction.Changes.INSTANCE;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(int i, GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, int i2, int i3, Function0 function0, List list) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (i > 0) {
            Intrinsics.checkNotNullExpressionValue(list, "");
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Next(list));
        } else {
            Intrinsics.checkNotNullExpressionValue(list, "");
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Initial(list));
        }
        if ((!list.isEmpty()) != false) {
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(i2, i3 + i2, i + 1, subscriptionKey, function0);
        } else {
            function0.invoke();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        ReentrantLock reentrantLock = getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            GCState gCState = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
            int i = gCState != null ? gCState.KClassImpl$Data$declaredNonStaticMembers$2 : 1;
            GCState gCState2 = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
            if (gCState2 != null) {
                gCState2.KClassImpl$Data$declaredNonStaticMembers$2 = i - 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getContactsUseCase.hashCode());
            sb.append(" removeObserver refCount : ");
            GCState gCState3 = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
            sb.append(gCState3 != null ? Integer.valueOf(gCState3.KClassImpl$Data$declaredNonStaticMembers$2) : null);
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            if (i == 1) {
                getContactsUseCase.dispose();
                getContactsUseCase.MyBillsEntityDataFactory.remove(subscriptionKey);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(GetContactsUseCase getContactsUseCase, Pair pair) {
        Observable just;
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(pair, "");
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        StringBuilder sb = new StringBuilder();
        sb.append(getContactsUseCase.hashCode());
        sb.append(" Changes local : ");
        sb.append(list.size());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getContactsUseCase.hashCode());
        sb2.append(" Changes device : ");
        sb2.append(list2.size());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb2.toString());
        Intrinsics.checkNotNullExpressionValue(list, "");
        if ((!list.isEmpty()) == false) {
            Intrinsics.checkNotNullExpressionValue(list2, "");
            if ((!list2.isEmpty()) == false) {
                just = Observable.error(SyncEngineException.NoContactLeft.INSTANCE);
                return just;
            }
        }
        Intrinsics.checkNotNullExpressionValue(list2, "");
        just = Observable.just(KClassImpl$Data$declaredNonStaticMembers$2(list, list2));
        return just;
    }

    public static /* synthetic */ Pair MyBillsEntityDataFactory(List list, List list2, List list3) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        return TuplesKt.to(list, list2);
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "");
        return Boolean.TRUE;
    }

    public static /* synthetic */ Triple MyBillsEntityDataFactory(Triple triple) {
        Object obj;
        Intrinsics.checkNotNullParameter(triple, "");
        List list = (List) triple.component1();
        List<UserContact> list2 = (List) triple.component2();
        List list3 = (List) triple.component3();
        List mutableList = CollectionsKt.toMutableList((Collection) list2);
        List mutableList2 = CollectionsKt.toMutableList((Collection) list);
        for (UserContact userContact : list2) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                UserContact userContact2 = (UserContact) obj;
                if (Intrinsics.areEqual(userContact2.scheduleImpl, userContact.scheduleImpl) && Intrinsics.areEqual(userContact2.lookAheadTest, userContact.lookAheadTest)) {
                    break;
                }
            }
            UserContact userContact3 = (UserContact) obj;
            if (userContact3 != null) {
                mutableList.remove(userContact);
                mutableList2.remove(userContact3);
            }
        }
        return new Triple(mutableList2, mutableList, list3);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Error(th));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GetContactsUseCase getContactsUseCase, int i, int i2, Function0 function0, Function1 function1, Boolean bool) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            getContactsUseCase.BuiltInFictitiousFunctionClassFactory(i, i2 + i, function0, function1);
        } else {
            function0.invoke();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(GetContactsUseCase getContactsUseCase, int i, int i2, SubscriptionKey subscriptionKey) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        getContactsUseCase.BuiltInFictitiousFunctionClassFactory(i, i2 + i, subscriptionKey);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(int i, GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, int i2, int i3, List list) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (i > 0) {
            Intrinsics.checkNotNullExpressionValue(list, "");
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Next(list));
        } else {
            Intrinsics.checkNotNullExpressionValue(list, "");
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Initial(list));
        }
        if ((!list.isEmpty()) == true) {
            getContactsUseCase.BuiltInFictitiousFunctionClassFactory(i2, i3 + i2, i + 1, subscriptionKey);
        }
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list, Unit unit) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return list;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetContactsUseCase getContactsUseCase, List list) {
        Observable just;
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(list, "");
        if ((!list.isEmpty()) != false) {
            just = getContactsUseCase.PlaceComponentResult.PlaceComponentResult(list).map(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetContactsUseCase.MyBillsEntityDataFactory((Unit) obj);
                }
            });
        } else {
            just = Observable.just(Boolean.FALSE);
        }
        return just;
    }

    public static /* synthetic */ Pair BuiltInFictitiousFunctionClassFactory(List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        return TuplesKt.to(list, list2);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, ContactResult.Finished.INSTANCE);
    }

    public static /* synthetic */ void PlaceComponentResult(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Error(th));
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(final GetContactsUseCase getContactsUseCase, Triple triple) {
        Observable just;
        Observable BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(triple, "");
        final List list = (List) triple.component1();
        List list2 = (List) triple.component2();
        final List list3 = (List) triple.component3();
        StringBuilder sb = new StringBuilder();
        sb.append(getContactsUseCase.hashCode());
        sb.append(" Changes removeContacts-init : ");
        sb.append(list2.size());
        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
        if ((!list2.isEmpty()) != false) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int i2 = 100;
            while (true) {
                int size = list2.size();
                if (i > size) {
                    i = size;
                }
                int size2 = list2.size();
                if (i2 <= size2) {
                    size2 = i2;
                }
                List subList = list2.subList(i, size2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getContactsUseCase.hashCode());
                sb2.append(" Changes removeContacts-sublist size : ");
                sb2.append(subList.size());
                sb2.append(", safetyFromIndex : ");
                sb2.append(i);
                sb2.append(", safetyToIndex : ");
                sb2.append(size2);
                DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb2.toString());
                List list4 = subList;
                if ((!list4.isEmpty()) != false) {
                    arrayList.add(subList);
                }
                if ((!list4.isEmpty()) != true) {
                    break;
                }
                int i3 = i2;
                i2 += 100;
                i = i3;
            }
            Single list5 = Observable.fromIterable(arrayList).flatMap(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda16
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetContactsUseCase.BuiltInFictitiousFunctionClassFactory(GetContactsUseCase.this, (List) obj);
                }
            }).toList();
            if (list5 instanceof FuseToObservable) {
                BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list5).getAuthRequestContext();
            } else {
                BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list5));
            }
            just = BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda17
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return GetContactsUseCase.MyBillsEntityDataFactory(list, list3, (List) obj);
                }
            });
        } else {
            just = Observable.just(TuplesKt.to(list, list3));
        }
        return just;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        function1.invoke(th);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final GetContactsUseCase getContactsUseCase, final SubscriptionKey subscriptionKey, SyncContactAction syncContactAction) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (!(syncContactAction instanceof SyncContactAction.InsertAll)) {
            if (syncContactAction instanceof SyncContactAction.SelectAll) {
                getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$buildUseCase$2$2

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    /* loaded from: classes5.dex */
                    public final /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

                        static {
                            int[] iArr = new int[SyncType.values().length];
                            iArr[SyncType.Server.ordinal()] = 1;
                            iArr[SyncType.Local.ordinal()] = 2;
                            BuiltInFictitiousFunctionClassFactory = iArr;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        GetContactsUseCase.Params params;
                        StringBuilder sb = new StringBuilder();
                        sb.append(GetContactsUseCase.this.hashCode());
                        sb.append(" SelectAll");
                        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
                        GetContactsUseCase.GCState gCState = GetContactsUseCase.this.MyBillsEntityDataFactory.get(subscriptionKey);
                        SyncType syncType = (gCState == null || (params = gCState.MyBillsEntityDataFactory) == null) ? null : params.MyBillsEntityDataFactory;
                        int i = syncType == null ? -1 : WhenMappings.BuiltInFictitiousFunctionClassFactory[syncType.ordinal()];
                        if (i == 1) {
                            GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, SyncContactEngineState.Continue, subscriptionKey);
                        } else if (i == 2) {
                            GetContactsUseCase.this.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, ContactResult.Finished.INSTANCE);
                        }
                    }
                });
                return;
            } else if (syncContactAction instanceof SyncContactAction.Changes) {
                StringBuilder sb = new StringBuilder();
                sb.append(getContactsUseCase.hashCode());
                sb.append(" Changes start");
                DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
                getContactsUseCase.BuiltInFictitiousFunctionClassFactory(1000, 0, subscriptionKey);
                return;
            } else {
                return;
            }
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$buildUseCase$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(GetContactsUseCase.this.hashCode());
                sb2.append(" InsertAll");
                DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb2.toString());
                GetContactsUseCase getContactsUseCase2 = GetContactsUseCase.this;
                GetContactsUseCase.SubscriptionKey subscriptionKey2 = subscriptionKey;
                final GetContactsUseCase getContactsUseCase3 = GetContactsUseCase.this;
                final GetContactsUseCase.SubscriptionKey subscriptionKey3 = subscriptionKey;
                getContactsUseCase2.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey2, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$buildUseCase$2$1.1

                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    /* renamed from: id.dana.sync_engine.domain.interactor.GetContactsUseCase$buildUseCase$2$1$1$WhenMappings */
                    /* loaded from: classes5.dex */
                    public final /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

                        static {
                            int[] iArr = new int[SyncType.values().length];
                            iArr[SyncType.Server.ordinal()] = 1;
                            iArr[SyncType.Local.ordinal()] = 2;
                            MyBillsEntityDataFactory = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        GetContactsUseCase.Params params;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(GetContactsUseCase.this.hashCode());
                        sb3.append(" SelectAll");
                        DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb3.toString());
                        GetContactsUseCase.GCState gCState = GetContactsUseCase.this.MyBillsEntityDataFactory.get(subscriptionKey3);
                        SyncType syncType = (gCState == null || (params = gCState.MyBillsEntityDataFactory) == null) ? null : params.MyBillsEntityDataFactory;
                        int i = syncType == null ? -1 : WhenMappings.MyBillsEntityDataFactory[syncType.ordinal()];
                        if (i == 1) {
                            GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, SyncContactEngineState.Initial, subscriptionKey3);
                        } else if (i == 2) {
                            GetContactsUseCase.this.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey3, ContactResult.Finished.INSTANCE);
                        }
                    }
                });
            }
        };
        getContactsUseCase.BuiltInFictitiousFunctionClassFactory(1000, 0, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$insertAllContact$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GetContactsUseCase.this.PlaceComponentResult.PlaceComponentResult(SyncContactType.Local, System.currentTimeMillis());
                function0.invoke();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$insertAllContact$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                GetContactsUseCase.this.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Error(th));
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(final GetContactsUseCase getContactsUseCase, final SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (th instanceof SQLiteException) {
            Intrinsics.checkNotNullExpressionValue(th, "");
            try {
                Crashlytics.Companion companion = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                Intrinsics.checkNotNullParameter("case", "");
                Intrinsics.checkNotNullParameter("2.15.0 SQLLITE EXCEPTION", "");
                authRequestContext.getAuthRequestContext.setCustomKey("case", "2.15.0 SQLLITE EXCEPTION");
                Intrinsics.checkNotNullParameter(th, "");
                authRequestContext.getAuthRequestContext.recordException(th);
            } catch (Exception unused) {
            }
            getContactsUseCase.BuiltInFictitiousFunctionClassFactory(subscriptionKey);
        } else if (th instanceof SyncEngineException.NoContactLeft) {
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$actionChangesContact$7$1

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* loaded from: classes5.dex */
                public final /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

                    static {
                        int[] iArr = new int[SyncType.values().length];
                        iArr[SyncType.Server.ordinal()] = 1;
                        iArr[SyncType.Local.ordinal()] = 2;
                        BuiltInFictitiousFunctionClassFactory = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GetContactsUseCase.Params params;
                    StringBuilder sb = new StringBuilder();
                    sb.append(GetContactsUseCase.this.hashCode());
                    sb.append(" Changes NoContactLeft");
                    DanaLog.MyBillsEntityDataFactory("GetContactsUseCase", sb.toString());
                    GetContactsUseCase.this.PlaceComponentResult.PlaceComponentResult(SyncContactType.Local, System.currentTimeMillis());
                    GetContactsUseCase.GCState gCState = GetContactsUseCase.this.MyBillsEntityDataFactory.get(subscriptionKey);
                    SyncType syncType = (gCState == null || (params = gCState.MyBillsEntityDataFactory) == null) ? null : params.MyBillsEntityDataFactory;
                    int i = syncType == null ? -1 : WhenMappings.BuiltInFictitiousFunctionClassFactory[syncType.ordinal()];
                    if (i == 1) {
                        GetContactsUseCase.PlaceComponentResult(GetContactsUseCase.this, SyncContactEngineState.Continue, subscriptionKey);
                    } else if (i == 2) {
                        GetContactsUseCase.this.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, ContactResult.Finished.INSTANCE);
                    }
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue(th, "");
            getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Error(th));
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GetContactsUseCase getContactsUseCase, SubscriptionKey subscriptionKey, GCState gCState, List list) {
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullExpressionValue(list, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (MyBillsEntityDataFactory(gCState.MyBillsEntityDataFactory.getAuthRequestContext, (UserContact) obj)) {
                arrayList.add(obj);
            }
        }
        getContactsUseCase.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, new ContactResult.Update(arrayList));
    }

    public static final /* synthetic */ void PlaceComponentResult(final GetContactsUseCase getContactsUseCase, SyncContactEngineState syncContactEngineState, final SubscriptionKey subscriptionKey) {
        Params params;
        SyncForFeature syncForFeature;
        Observable MyBillsEntityDataFactory;
        final GCState gCState = getContactsUseCase.MyBillsEntityDataFactory.get(subscriptionKey);
        if (gCState == null || (params = gCState.MyBillsEntityDataFactory) == null || (syncForFeature = params.PlaceComponentResult) == null) {
            return;
        }
        MyBillsEntityDataFactory = getContactsUseCase.getAuthRequestContext.MyBillsEntityDataFactory(syncContactEngineState, syncForFeature, gCState.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2(), new SyncContactEngine.SubscriptionKey("DEFAULT_KEY_SUB_SYNC_CONTACT"));
        Disposable subscribe = MyBillsEntityDataFactory.subscribeOn(UseCaseSchedulers.getJobScheduler()).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.MyBillsEntityDataFactory(GetContactsUseCase.this, subscriptionKey, gCState, (List) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetContactsUseCase.MyBillsEntityDataFactory(GetContactsUseCase.this, subscriptionKey, (Throwable) obj);
            }
        }, new Action() { // from class: id.dana.sync_engine.domain.interactor.GetContactsUseCase$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Action
            public final void run() {
                GetContactsUseCase.MyBillsEntityDataFactory(GetContactsUseCase.this, subscriptionKey);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        getContactsUseCase.collect(subscribe);
    }
}
