package id.dana.sync_engine.domain.engine;

import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.engine.SyncContactEngine;
import id.dana.sync_engine.domain.model.SyncContactEngineState;
import id.dana.sync_engine.domain.model.SyncForFeature;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.sync_engine.domain.model.UserContactKt;
import id.dana.sync_engine.domain.tracker.SyncContactMixpanelTracker;
import id.dana.sync_engine.domain.tracker.SyncEngineTrackerFactory;
import id.dana.sync_engine.exception.SyncEngineException;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 32\u00020\u0001:\u00043456B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020$\u0012\u0006\u0010\u0005\u001a\u00020.¢\u0006\u0004\b1\u00102JI\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ%\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u000f\u0010\u0012J5\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0002¢\u0006\u0004\b\u0014\u0010\u0019J/\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u000f\u0010\u001bJ;\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\n2\u0006\u0010\u0004\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u001eJ/\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u001fJ%\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0010J=\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u000b\u0010!J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u0006*\u00020\"H\u0002¢\u0006\u0004\b\u000f\u0010#R\u0014\u0010\u000f\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0016\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0014\u0010\u000b\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010*R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,0+X\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010-R\u0014\u0010%\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/sync_engine/domain/engine/SyncContactEngine;", "Lid/dana/sync_engine/domain/engine/DefaultSyncContactEngine;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "p1", "", "p2", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;", "p3", "Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Ljava/util/List;ZLid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;)Lio/reactivex/Observable;", "", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;)V", "MyBillsEntityDataFactory", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;Ljava/util/List;)V", "", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;Ljava/lang/Throwable;)V", "Lkotlin/Pair;", "PlaceComponentResult", "(Ljava/util/List;)Lkotlin/Pair;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;)Z", "Lkotlin/Function0;", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "(IILid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;I)V", "Lid/dana/sync_engine/domain/model/SyncContactEngineState;", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "(Lid/dana/sync_engine/domain/model/SyncContactEngineState;Lid/dana/sync_engine/domain/model/SyncForFeature;ZLid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;)Lio/reactivex/Observable;", "(IIILid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;)V", "p4", "(Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;IIILjava/util/List;)V", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;)Z", "Lid/dana/sync_engine/domain/ContactRepository;", "getAuthRequestContext", "Lid/dana/sync_engine/domain/ContactRepository;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$SCState;", "Ljava/util/Map;", "Lid/dana/sync_engine/domain/tracker/SyncEngineTrackerFactory;", "scheduleImpl", "Lid/dana/sync_engine/domain/tracker/SyncEngineTrackerFactory;", "<init>", "(Lid/dana/sync_engine/domain/ContactRepository;Lid/dana/sync_engine/domain/tracker/SyncEngineTrackerFactory;)V", "Companion", "Params", "SCState", "SubscriptionKey"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SyncContactEngine implements DefaultSyncContactEngine {
    private static final long MyBillsEntityDataFactory = TimeUnit.DAYS.toMillis(1);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ReentrantLock BuiltInFictitiousFunctionClassFactory;
    public final Map<SubscriptionKey, SCState> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ContactRepository MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final SyncEngineTrackerFactory getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[SyncForFeature.values().length];
            iArr[SyncForFeature.Feed.ordinal()] = 1;
            iArr[SyncForFeature.Referral.ordinal()] = 2;
            iArr[SyncForFeature.SendMoney.ordinal()] = 3;
            iArr[SyncForFeature.MobileRecharge.ordinal()] = 4;
            iArr[SyncForFeature.BackgroundJob.ordinal()] = 5;
            PlaceComponentResult = iArr;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    public static /* synthetic */ void getAuthRequestContext() {
    }

    @Inject
    public SyncContactEngine(ContactRepository contactRepository, SyncEngineTrackerFactory syncEngineTrackerFactory) {
        Intrinsics.checkNotNullParameter(contactRepository, "");
        Intrinsics.checkNotNullParameter(syncEngineTrackerFactory, "");
        this.MyBillsEntityDataFactory = contactRepository;
        this.getAuthRequestContext = syncEngineTrackerFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();
        this.PlaceComponentResult = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = new ReentrantLock();
    }

    @Override // id.dana.sync_engine.domain.engine.DefaultSyncContactEngine
    public final Observable<List<UserContact>> MyBillsEntityDataFactory(SyncContactEngineState p0, SyncForFeature p1, boolean p2, SubscriptionKey p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" : from feature ");
        sb.append(p1);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        Params params = new Params(p0, p1, p2, p3);
        final SubscriptionKey subscriptionKey = params.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory.lock();
        SCState sCState = this.PlaceComponentResult.get(subscriptionKey);
        Observable<List<UserContact>> observable = sCState != null ? sCState.getAuthRequestContext : null;
        if (observable != null) {
            this.BuiltInFictitiousFunctionClassFactory.unlock();
            return observable;
        }
        ReplaySubject BuiltInFictitiousFunctionClassFactory = ReplaySubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Observable<List<UserContact>> doOnDispose = BuiltInFictitiousFunctionClassFactory.doOnSubscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                SyncContactEngine.PlaceComponentResult(SyncContactEngine.this, subscriptionKey);
            }
        }).doOnDispose(new Action() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() {
                SyncContactEngine.BuiltInFictitiousFunctionClassFactory(SyncContactEngine.this, subscriptionKey);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "");
        this.PlaceComponentResult.put(subscriptionKey, new SCState(0, doOnDispose, BuiltInFictitiousFunctionClassFactory, new ArrayList(), false, params, null, null, 0, 192, null));
        this.BuiltInFictitiousFunctionClassFactory.unlock();
        Observable flatMap = Observable.zip(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0(), this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(), this.MyBillsEntityDataFactory.lookAheadTest(), new Function3() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return SyncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2((Boolean) obj, (ContactSyncConfig) obj2, (SyncContactSplitConfigModel) obj3);
            }
        }).flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, (Pair) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        Disposable subscribe = flatMap.flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.MyBillsEntityDataFactory(SyncContactEngine.this, (Triple) obj);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.PlaceComponentResult(SyncContactEngine.this, subscriptionKey, (Triple) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.MyBillsEntityDataFactory(SyncContactEngine.this, subscriptionKey, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        MyBillsEntityDataFactory(subscribe);
        return doOnDispose;
    }

    public final void MyBillsEntityDataFactory(final int p0, final int p1, final int p2, final SubscriptionKey p3) {
        Disposable subscribe = this.MyBillsEntityDataFactory.getAuthRequestContext("local", p0, p1, null, p2).flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, p3, p2, (List) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, (List) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.MyBillsEntityDataFactory(SyncContactEngine.this, p3, p0, p1, p2, (List) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, p3, p1, p0, p2, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        MyBillsEntityDataFactory(subscribe);
    }

    private final void PlaceComponentResult(SubscriptionKey p0, Function0<Unit> p1, Function0<Unit> p2) {
        SCState sCState = this.PlaceComponentResult.get(p0);
        int i = sCState != null ? sCState.getErrorConfigVersion : -1;
        boolean z = false;
        if (i >= 0 && i < 3) {
            z = true;
        }
        if (z) {
            SCState sCState2 = this.PlaceComponentResult.get(p0);
            if (sCState2 != null) {
                sCState2.getErrorConfigVersion = i + 1;
            }
            p1.invoke();
            return;
        }
        p2.invoke();
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(SubscriptionKey p0) {
        Params params;
        Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair;
        SCState sCState = this.PlaceComponentResult.get(p0);
        Boolean bool = null;
        SyncContactSplitConfigModel second = (sCState == null || (pair = sCState.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : pair.getSecond();
        SCState sCState2 = this.PlaceComponentResult.get(p0);
        SyncForFeature syncForFeature = (sCState2 == null || (params = sCState2.BuiltInFictitiousFunctionClassFactory) == null) ? null : params.BuiltInFictitiousFunctionClassFactory;
        int i = syncForFeature == null ? -1 : WhenMappings.PlaceComponentResult[syncForFeature.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            bool = Boolean.FALSE;
                        } else if (second != null) {
                            bool = Boolean.valueOf(second.getBackgroundJobSync());
                        }
                    } else if (second != null) {
                        bool = Boolean.valueOf(second.getMobileRechargeSync());
                    }
                } else if (second != null) {
                    bool = Boolean.valueOf(second.getSendMoneySync());
                }
            } else if (second != null) {
                bool = Boolean.valueOf(second.getReferralSync());
            }
        } else if (second != null) {
            bool = Boolean.valueOf(second.getFeedSync());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static Pair<List<UserContact>, List<UserContact>> PlaceComponentResult(List<UserContact> p0) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UserContact userContact : p0) {
            if (StringsKt.startsWith$default(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0, "62-", false, 2, (Object) null)) {
                arrayList.add(userContact);
            } else {
                arrayList2.add(userContact);
            }
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    public final void MyBillsEntityDataFactory(final int p0, final int p1, final SubscriptionKey p2, final int p3) {
        Disposable subscribe = this.MyBillsEntityDataFactory.getAuthRequestContext("local", p0, p1, Boolean.FALSE, p3).flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.PlaceComponentResult(SyncContactEngine.this, p2, (List) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.PlaceComponentResult(SyncContactEngine.this, p2, p1, p0, p3, (List) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.PlaceComponentResult(SyncContactEngine.this, p2, p1, p0, p3, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        MyBillsEntityDataFactory(subscribe);
    }

    private final void MyBillsEntityDataFactory(SubscriptionKey p0, List<UserContact> p1) {
        ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            SCState sCState = this.PlaceComponentResult.get(p0);
            ReplaySubject<List<UserContact>> replaySubject = sCState != null ? sCState.PlaceComponentResult : null;
            if (replaySubject != null) {
                replaySubject.onNext(p1);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void PlaceComponentResult(SubscriptionKey p0) {
        ContactSyncConfig first;
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append(" : updateNonDanaContacts ");
        sb.append(p0);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        SCState sCState = this.PlaceComponentResult.get(p0);
        if (sCState != null) {
            SCState authRequestContext = SCState.getAuthRequestContext(sCState);
            List<UserContact> list = authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            int maxContactSyncBatchSize = (pair == null || (first = pair.getFirst()) == null) ? 50 : first.getMaxContactSyncBatchSize();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(hashCode());
            sb2.append(" : updateNonDanaContacts ");
            sb2.append(list != null ? Integer.valueOf(list.size()) : null);
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb2.toString());
            boolean z = false;
            if (list != null && (!list.isEmpty()) == true) {
                z = true;
            }
            if (z) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(hashCode());
                sb3.append(" : updateContact fromIndex : 0, toIndex: ");
                sb3.append(maxContactSyncBatchSize);
                sb3.append(", step ");
                sb3.append(maxContactSyncBatchSize);
                DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb3.toString());
                BuiltInFictitiousFunctionClassFactory(p0, 0, maxContactSyncBatchSize, maxContactSyncBatchSize, list);
                return;
            }
            BuiltInFictitiousFunctionClassFactory(p0);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(final SubscriptionKey p0, int p1, final int p2, final int p3, final List<UserContact> p4) {
        int size = p4.size();
        if (p1 > size) {
            p1 = size;
        }
        int size2 = p4.size();
        if (p2 <= size2) {
            size2 = p2;
        }
        List<UserContact> subList = p4.subList(p1, size2);
        if ((!subList.isEmpty()) != false) {
            Disposable subscribe = this.MyBillsEntityDataFactory.getAuthRequestContext(subList).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda26
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Long l = (Long) obj;
                    SyncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2(SyncContactEngine.this, p2, p3, p0, p4);
                }
            }, new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Throwable th = (Throwable) obj;
                    SyncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "");
            MyBillsEntityDataFactory(subscribe);
            return;
        }
        BuiltInFictitiousFunctionClassFactory(p0);
    }

    private final void BuiltInFictitiousFunctionClassFactory(SubscriptionKey p0) {
        ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(hashCode());
            sb.append(" : dispatchComplete");
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            SCState sCState = this.PlaceComponentResult.get(p0);
            ReplaySubject<List<UserContact>> replaySubject = sCState != null ? sCState.PlaceComponentResult : null;
            if (replaySubject != null) {
                replaySubject.onComplete();
            }
            this.PlaceComponentResult.remove(p0);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void MyBillsEntityDataFactory(SubscriptionKey p0, Throwable p1) {
        ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            DanaLog.BuiltInFictitiousFunctionClassFactory("SyncContactEngine", p1.getMessage());
            SCState sCState = this.PlaceComponentResult.get(p0);
            ReplaySubject<List<UserContact>> replaySubject = sCState != null ? sCState.PlaceComponentResult : null;
            if (replaySubject != null) {
                if (!sCState.getMyBillsEntityDataFactory()) {
                    replaySubject.onError(p1);
                    this.PlaceComponentResult.remove(p0);
                }
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(SubscriptionKey p0, List<UserContact> p1) {
        Params params;
        ArrayList arrayList = new ArrayList();
        for (Object obj : p1) {
            if (Intrinsics.areEqual(((UserContact) obj).BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        SCState sCState = this.PlaceComponentResult.get(p0);
        if (((sCState == null || (params = sCState.BuiltInFictitiousFunctionClassFactory) == null || !params.getKClassImpl$Data$declaredNonStaticMembers$2()) ? false : true) && (!arrayList2.isEmpty()) == true) {
            Disposable subscribe = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(arrayList2).onErrorResumeNext(Observable.just(Boolean.FALSE)).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda13
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    Boolean bool = (Boolean) obj2;
                    SyncContactEngine.BuiltInFictitiousFunctionClassFactory();
                }
            }, new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda14
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    Throwable th = (Throwable) obj2;
                    SyncContactEngine.getAuthRequestContext();
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "");
            MyBillsEntityDataFactory(subscribe);
        }
    }

    private final Observable<List<UserContact>> BuiltInFictitiousFunctionClassFactory(final List<UserContact> p0, List<UserContact> p1, boolean p2, final SubscriptionKey p3) {
        Observable<List<String>> just;
        final List plus = CollectionsKt.plus((Collection) p0, (Iterable) p1);
        if ((!r0.isEmpty()) != false) {
            just = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(p0, p2);
        } else {
            just = Observable.just(CollectionsKt.emptyList());
        }
        Observable map = just.map(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, p3, plus, p0, (List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private final boolean MyBillsEntityDataFactory(Disposable disposable) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(disposable);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\f\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0013X\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u0016X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017"}, d2 = {"Lid/dana/sync_engine/domain/engine/SyncContactEngine$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;", "getAuthRequestContext", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;", "Lid/dana/sync_engine/domain/model/SyncContactEngineState;", "MyBillsEntityDataFactory", "Lid/dana/sync_engine/domain/model/SyncContactEngineState;", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "Lid/dana/sync_engine/domain/model/SyncForFeature;", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "p3", "<init>", "(Lid/dana/sync_engine/domain/model/SyncContactEngineState;Lid/dana/sync_engine/domain/model/SyncForFeature;ZLid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final SyncForFeature BuiltInFictitiousFunctionClassFactory;
        public final SyncContactEngineState MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final SubscriptionKey PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return this.MyBillsEntityDataFactory == params.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == params.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == params.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.PlaceComponentResult, params.PlaceComponentResult);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        public Params(SyncContactEngineState syncContactEngineState, SyncForFeature syncForFeature, boolean z, SubscriptionKey subscriptionKey) {
            Intrinsics.checkNotNullParameter(syncContactEngineState, "");
            Intrinsics.checkNotNullParameter(syncForFeature, "");
            Intrinsics.checkNotNullParameter(subscriptionKey, "");
            this.MyBillsEntityDataFactory = syncContactEngineState;
            this.BuiltInFictitiousFunctionClassFactory = syncForFeature;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.PlaceComponentResult = subscriptionKey;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0012\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001c\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010#\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u001e\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010&\u0012\u0006\u00100\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001cX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0012\u0010\u001a\u001a\u00020\u001eX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001fR\u0012\u0010!\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010 R\u0012\u0010\"\u001a\u00020\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\"\u0010 R\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010#X\u0087\u0002¢\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010&X\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010'"}, d2 = {"Lid/dana/sync_engine/domain/engine/SyncContactEngine$SCState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/Pair;", "Lid/dana/domain/synccontact/model/ContactSyncConfig;", "Lid/dana/domain/synccontact/model/SyncContactSplitConfigModel;", "MyBillsEntityDataFactory", "Lkotlin/Pair;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/ReplaySubject;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "getAuthRequestContext", "Lio/reactivex/subjects/ReplaySubject;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "Lio/reactivex/Observable;", "Lio/reactivex/Observable;", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$Params;", "Lid/dana/sync_engine/domain/engine/SyncContactEngine$Params;", "I", "moveToNextValue", "getErrorConfigVersion", "", "lookAheadTest", "Ljava/util/List;", "", "Ljava/util/Map;", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(ILio/reactivex/Observable;Lio/reactivex/subjects/ReplaySubject;Ljava/util/List;ZLid/dana/sync_engine/domain/engine/SyncContactEngine$Params;Lkotlin/Pair;Ljava/util/Map;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SCState {
        Params BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        int moveToNextValue;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        private boolean MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        Observable<List<UserContact>> getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        ReplaySubject<List<UserContact>> PlaceComponentResult;
        int getErrorConfigVersion;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        List<UserContact> NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        Map<String, Object> scheduleImpl;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof SCState) {
                SCState sCState = (SCState) p0;
                return this.moveToNextValue == sCState.moveToNextValue && Intrinsics.areEqual(this.getAuthRequestContext, sCState.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, sCState.PlaceComponentResult) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, sCState.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.MyBillsEntityDataFactory == sCState.MyBillsEntityDataFactory && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, sCState.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, sCState.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.scheduleImpl, sCState.scheduleImpl) && this.getErrorConfigVersion == sCState.getErrorConfigVersion;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int i = this.moveToNextValue;
            int hashCode = this.getAuthRequestContext.hashCode();
            int hashCode2 = this.PlaceComponentResult.hashCode();
            List<UserContact> list = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int hashCode3 = list == null ? 0 : list.hashCode();
            boolean z = this.MyBillsEntityDataFactory;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int hashCode4 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (((((((((((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + i2) * 31) + hashCode4) * 31) + (pair != null ? pair.hashCode() : 0)) * 31) + this.scheduleImpl.hashCode()) * 31) + this.getErrorConfigVersion;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SCState(moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(')');
            return sb.toString();
        }

        private SCState(int i, Observable<List<UserContact>> observable, ReplaySubject<List<UserContact>> replaySubject, List<UserContact> list, boolean z, Params params, Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair, Map<String, Object> map, int i2) {
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(replaySubject, "");
            Intrinsics.checkNotNullParameter(params, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.moveToNextValue = i;
            this.getAuthRequestContext = observable;
            this.PlaceComponentResult = replaySubject;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = list;
            this.MyBillsEntityDataFactory = z;
            this.BuiltInFictitiousFunctionClassFactory = params;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = pair;
            this.scheduleImpl = map;
            this.getErrorConfigVersion = i2;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        public /* synthetic */ SCState(int i, Observable observable, ReplaySubject replaySubject, List list, boolean z, Params params, Pair pair, Map map, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, observable, replaySubject, list, z, params, (i3 & 64) != 0 ? null : pair, (i3 & 128) != 0 ? new LinkedHashMap() : map, i2);
        }

        public static /* synthetic */ SCState getAuthRequestContext(SCState sCState) {
            int i = sCState.moveToNextValue;
            Observable<List<UserContact>> observable = sCState.getAuthRequestContext;
            ReplaySubject<List<UserContact>> replaySubject = sCState.PlaceComponentResult;
            List<UserContact> list = sCState.NetworkUserEntityData$$ExternalSyntheticLambda0;
            boolean z = sCState.MyBillsEntityDataFactory;
            Params params = sCState.BuiltInFictitiousFunctionClassFactory;
            Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair = sCState.KClassImpl$Data$declaredNonStaticMembers$2;
            Map<String, Object> map = sCState.scheduleImpl;
            int i2 = sCState.getErrorConfigVersion;
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(replaySubject, "");
            Intrinsics.checkNotNullParameter(params, "");
            Intrinsics.checkNotNullParameter(map, "");
            return new SCState(i, observable, replaySubject, list, z, params, pair, map, i2);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/sync_engine/domain/engine/SyncContactEngine$SubscriptionKey;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SubscriptionKey {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof SubscriptionKey) && Intrinsics.areEqual(this.getAuthRequestContext, ((SubscriptionKey) p0).getAuthRequestContext);
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

        public SubscriptionKey(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, List list) {
        Observable<List<UserContact>> error;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullParameter(list, "");
        if ((!list.isEmpty()) != false) {
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = syncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey);
            Pair<List<UserContact>, List<UserContact>> PlaceComponentResult = PlaceComponentResult(list);
            error = syncContactEngine.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult.component1(), PlaceComponentResult.component2(), KClassImpl$Data$declaredNonStaticMembers$2, null);
        } else {
            error = Observable.error(SyncEngineException.NoContactLeft.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, Pair pair) {
        Observable error;
        Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair2;
        ContactSyncConfig first;
        Pair<? extends ContactSyncConfig, SyncContactSplitConfigModel> pair3;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullParameter(pair, "");
        Long l = (Long) pair.component1();
        Integer num = (Integer) pair.component2();
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = l.longValue();
        SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        ContactSyncConfig first2 = (sCState == null || (pair3 = sCState.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : pair3.getFirst();
        long intervalTimeInMillis = first2 != null ? first2.getIntervalTimeInMillis() : 0L;
        if (intervalTimeInMillis <= 0) {
            intervalTimeInMillis = MyBillsEntityDataFactory;
        }
        if (currentTimeMillis >= longValue + intervalTimeInMillis) {
            SCState sCState2 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            int maxContactSyncBatchSize = (sCState2 == null || (pair2 = sCState2.KClassImpl$Data$declaredNonStaticMembers$2) == null || (first = pair2.getFirst()) == null) ? 0 : first.getMaxContactSyncBatchSize();
            StringBuilder sb = new StringBuilder();
            sb.append(syncContactEngine.hashCode());
            sb.append(" : lastOffset ");
            sb.append(num.intValue());
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            Intrinsics.checkNotNullExpressionValue(num, "");
            error = Observable.just(TuplesKt.to(Integer.valueOf(maxContactSyncBatchSize), Integer.valueOf(num.intValue() > 0 ? num.intValue() : 0)));
        } else {
            error = Observable.error(SyncEngineException.NoAllowReSyncContact.INSTANCE);
        }
        return error;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        ReentrantLock reentrantLock = syncContactEngine.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            int i = sCState != null ? sCState.moveToNextValue : 1;
            SCState sCState2 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            if (sCState2 != null) {
                sCState2.moveToNextValue = i - 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(syncContactEngine.hashCode());
            sb.append(" removeObserver refCount : ");
            SCState sCState3 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            sb.append(sCState3 != null ? Integer.valueOf(sCState3.moveToNextValue) : null);
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            if (i == 1) {
                syncContactEngine.PlaceComponentResult(subscriptionKey);
                Unit unit = Unit.INSTANCE;
                syncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                syncContactEngine.PlaceComponentResult.remove(subscriptionKey);
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, Pair pair) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append(syncContactEngine.hashCode());
        sb.append(" : reSyncForNonDanaUser limit : ");
        sb.append(intValue);
        sb.append(", offset : ");
        sb.append(intValue2);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        syncContactEngine.MyBillsEntityDataFactory(intValue, intValue2, subscriptionKey, 0);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, int i, int i2, int i3, List list) {
        Map<String, ? extends Object> map;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState != null) {
            sCState.getErrorConfigVersion = 0;
        }
        Intrinsics.checkNotNullExpressionValue(list, "");
        syncContactEngine.MyBillsEntityDataFactory(subscriptionKey, list);
        syncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, list);
        StringBuilder sb = new StringBuilder();
        sb.append(syncContactEngine.hashCode());
        sb.append(" : nextSyncForNeverSync limit : ");
        sb.append(i);
        sb.append(" offset : ");
        sb.append(i2);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        SCState sCState2 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState2 != null && (map = sCState2.scheduleImpl) != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(syncContactEngine.hashCode());
            sb2.append(" : trackMixPanel : ");
            sb2.append(map);
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb2.toString());
            SyncEngineTrackerFactory syncEngineTrackerFactory = syncContactEngine.getAuthRequestContext;
            Intrinsics.checkNotNullParameter("MIXPANEL", "");
            SyncContactMixpanelTracker syncContactMixpanelTracker = Intrinsics.areEqual("MIXPANEL", "MIXPANEL") ? syncEngineTrackerFactory.getAuthRequestContext : null;
            if (syncContactMixpanelTracker != null) {
                syncContactMixpanelTracker.PlaceComponentResult(TrackerDataKey.Event.SYNC_CONTACT, map);
            }
            Object obj = map.get(TrackerDataKey.Property.UPLOADED_CONTACT);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            if (num != null) {
                syncContactEngine.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(num.intValue());
            }
        }
        syncContactEngine.MyBillsEntityDataFactory(i, i2, i3 + 1, subscriptionKey);
    }

    public static /* synthetic */ Pair KClassImpl$Data$declaredNonStaticMembers$2(Boolean bool, ContactSyncConfig contactSyncConfig, SyncContactSplitConfigModel syncContactSplitConfigModel) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(contactSyncConfig, "");
        Intrinsics.checkNotNullParameter(syncContactSplitConfigModel, "");
        return TuplesKt.to(contactSyncConfig, syncContactSplitConfigModel);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactEngine syncContactEngine, int i, int i2, SubscriptionKey subscriptionKey, List list) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullParameter(list, "");
        StringBuilder sb = new StringBuilder();
        sb.append(syncContactEngine.hashCode());
        sb.append(" : next updateContact toIndex: ");
        sb.append(i);
        sb.append(", step ");
        sb.append(i2);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        syncContactEngine.BuiltInFictitiousFunctionClassFactory(subscriptionKey, i, i + i2, i2, list);
    }

    public static /* synthetic */ void PlaceComponentResult(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        ReentrantLock reentrantLock = syncContactEngine.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            int i = sCState != null ? sCState.moveToNextValue : 0;
            SCState sCState2 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            if (sCState2 != null) {
                sCState2.moveToNextValue = i + 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(syncContactEngine.hashCode());
            sb.append(" addObserver refCount : ");
            SCState sCState3 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
            sb.append(sCState3 != null ? Integer.valueOf(sCState3.moveToNextValue) : null);
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ Pair getAuthRequestContext(Long l, Integer num) {
        Intrinsics.checkNotNullParameter(l, "");
        Intrinsics.checkNotNullParameter(num, "");
        return TuplesKt.to(l, num);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullExpressionValue(th, "");
        syncContactEngine.MyBillsEntityDataFactory(subscriptionKey, th);
    }

    public static /* synthetic */ Triple PlaceComponentResult(Triple triple, Unit unit) {
        Intrinsics.checkNotNullParameter(triple, "");
        Intrinsics.checkNotNullParameter(unit, "");
        return triple;
    }

    public static /* synthetic */ Triple PlaceComponentResult(ContactSyncConfig contactSyncConfig, SyncContactSplitConfigModel syncContactSplitConfigModel, Integer num) {
        Intrinsics.checkNotNullParameter(contactSyncConfig, "");
        Intrinsics.checkNotNullParameter(syncContactSplitConfigModel, "");
        Intrinsics.checkNotNullParameter(num, "");
        return new Triple(contactSyncConfig, syncContactSplitConfigModel, num);
    }

    public static /* synthetic */ List getAuthRequestContext(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, List list, List list2, List list3) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(list3, "");
        SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState != null && (map = sCState.scheduleImpl) != null) {
            int size = list2.size();
            Object obj = map.get(TrackerDataKey.Property.UPLOADED_CONTACT);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            map.put(TrackerDataKey.Property.UPLOADED_CONTACT, Integer.valueOf((num != null ? num.intValue() : 0) + size));
            map.put(TrackerDataKey.Property.UPLOADING_CONTACT, Integer.valueOf(size));
        }
        return UserContactKt.MyBillsEntityDataFactory(list, list3);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(SyncContactEngine syncContactEngine, Pair pair) {
        Observable error;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(pair, "");
        final ContactSyncConfig contactSyncConfig = (ContactSyncConfig) pair.component1();
        final SyncContactSplitConfigModel syncContactSplitConfigModel = (SyncContactSplitConfigModel) pair.component2();
        if (contactSyncConfig.isSynchronizeContactEnable()) {
            error = syncContactEngine.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("local").map(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SyncContactEngine.PlaceComponentResult(ContactSyncConfig.this, syncContactSplitConfigModel, (Integer) obj);
                }
            });
        } else {
            error = Observable.error(SyncEngineException.SyncContactDisable.INSTANCE);
        }
        return error;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(SyncContactEngine syncContactEngine, Boolean bool) {
        Observable<Unit> just;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(syncContactEngine.hashCode());
            sb.append(" : Reset Process Sync");
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            just = syncContactEngine.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2();
        } else {
            just = Observable.just(Unit.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ void PlaceComponentResult(final SyncContactEngine syncContactEngine, final SubscriptionKey subscriptionKey, final int i, final int i2, final int i3, final Throwable th) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (!(th instanceof SyncEngineException.NoContactLeft)) {
            syncContactEngine.PlaceComponentResult(subscriptionKey, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$reSyncForNonDanaUser$3$1
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
                    int i4 = i;
                    int i5 = i2;
                    syncContactEngine.MyBillsEntityDataFactory(i5, i4 + i5, subscriptionKey, i3 + 1);
                }
            }, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$reSyncForNonDanaUser$3$2
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
                    SyncContactEngine syncContactEngine2 = SyncContactEngine.this;
                    SyncContactEngine.SubscriptionKey subscriptionKey2 = subscriptionKey;
                    Throwable th2 = th;
                    Intrinsics.checkNotNullExpressionValue(th2, "");
                    syncContactEngine2.MyBillsEntityDataFactory(subscriptionKey2, th2);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(syncContactEngine.hashCode());
        sb.append(" : NoContactLeft");
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        syncContactEngine.MyBillsEntityDataFactory.PlaceComponentResult(-1);
        syncContactEngine.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType.Local, System.currentTimeMillis());
        syncContactEngine.PlaceComponentResult(subscriptionKey);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final SyncContactEngine syncContactEngine, final Triple triple) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(triple, "");
        Observable<R> flatMap = syncContactEngine.MyBillsEntityDataFactory.getErrorConfigVersion().flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap.map(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.PlaceComponentResult(Triple.this, (Unit) obj);
            }
        });
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(SyncContactEngine syncContactEngine, final List list) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(list, "");
        ObservableSource map = syncContactEngine.MyBillsEntityDataFactory.getAuthRequestContext(list).map(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.BuiltInFictitiousFunctionClassFactory(list, (Long) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    public static /* synthetic */ void PlaceComponentResult(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, int i, int i2, int i3, List list) {
        List<UserContact> list2;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullExpressionValue(list, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((UserContact) obj).BuiltInFictitiousFunctionClassFactory, Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        StringBuilder sb = new StringBuilder();
        sb.append(syncContactEngine.hashCode());
        sb.append(" : saveValue : ");
        sb.append(arrayList2);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState != null) {
            sCState.getErrorConfigVersion = 0;
        }
        SCState sCState2 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState2 != null && (list2 = sCState2.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            list2.addAll(arrayList2);
        }
        int i4 = i + i2;
        syncContactEngine.MyBillsEntityDataFactory.PlaceComponentResult(i4);
        syncContactEngine.MyBillsEntityDataFactory(subscriptionKey, arrayList2);
        syncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey, list);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(syncContactEngine.hashCode());
        sb2.append(" : next reSyncForNonDanaUser limit : ");
        sb2.append(i2);
        sb2.append(", offset : ");
        sb2.append(i4);
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb2.toString());
        syncContactEngine.MyBillsEntityDataFactory(i2, i4, subscriptionKey, i3 + 1);
    }

    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list, Long l) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(l, "");
        return list;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, Throwable th) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (th instanceof SyncEngineException.NoAllowReSyncContact) {
            syncContactEngine.BuiltInFictitiousFunctionClassFactory(subscriptionKey);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(th, "");
        syncContactEngine.MyBillsEntityDataFactory(subscriptionKey, th);
    }

    public static /* synthetic */ void getAuthRequestContext(final SyncContactEngine syncContactEngine, final SubscriptionKey subscriptionKey, final int i, final int i2, final int i3, final Throwable th) {
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        if (!(th instanceof SyncEngineException.CompleteBatchSync)) {
            syncContactEngine.PlaceComponentResult(subscriptionKey, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$syncForNeverSync$4$1
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
                    int i4 = i;
                    int i5 = i2;
                    syncContactEngine.MyBillsEntityDataFactory(i5, i4 + i5, i3 + 1, subscriptionKey);
                }
            }, new Function0<Unit>() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$syncForNeverSync$4$2
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
                    SyncContactEngine syncContactEngine2 = SyncContactEngine.this;
                    SyncContactEngine.SubscriptionKey subscriptionKey2 = subscriptionKey;
                    Throwable th2 = th;
                    Intrinsics.checkNotNullExpressionValue(th2, "");
                    syncContactEngine2.MyBillsEntityDataFactory(subscriptionKey2, th2);
                }
            });
            return;
        }
        Intrinsics.checkNotNullExpressionValue(th, "");
        SyncEngineException.CompleteBatchSync completeBatchSync = (SyncEngineException.CompleteBatchSync) th;
        if (completeBatchSync.getCount() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(syncContactEngine.hashCode());
            sb.append(" : saveStartCountReSyncTimeStamp timemillis : ");
            sb.append(System.currentTimeMillis());
            DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
            syncContactEngine.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(SyncContactType.Local, System.currentTimeMillis());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(syncContactEngine.hashCode());
        sb2.append(" : getLastIndexReSyncForNonDanaUser count : ");
        sb2.append(completeBatchSync.getCount());
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb2.toString());
        Disposable subscribe = Observable.zip(syncContactEngine.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(SyncContactType.Local), syncContactEngine.MyBillsEntityDataFactory.PlaceComponentResult(), new BiFunction() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return SyncContactEngine.getAuthRequestContext((Long) obj, (Integer) obj2);
            }
        }).flatMap(new Function() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SyncContactEngine.getAuthRequestContext(SyncContactEngine.this, subscriptionKey, (Pair) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.MyBillsEntityDataFactory(SyncContactEngine.this, subscriptionKey, (Pair) obj);
            }
        }, new Consumer() { // from class: id.dana.sync_engine.domain.engine.SyncContactEngine$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2(SyncContactEngine.this, subscriptionKey, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        syncContactEngine.MyBillsEntityDataFactory(subscribe);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, int i, List list) {
        Observable<List<UserContact>> error;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        Intrinsics.checkNotNullParameter(list, "");
        if ((!list.isEmpty()) != false) {
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = syncContactEngine.KClassImpl$Data$declaredNonStaticMembers$2(subscriptionKey);
            Pair<List<UserContact>, List<UserContact>> PlaceComponentResult = PlaceComponentResult(list);
            error = syncContactEngine.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult.component1(), PlaceComponentResult.component2(), KClassImpl$Data$declaredNonStaticMembers$2, subscriptionKey);
        } else {
            error = Observable.error(new SyncEngineException.CompleteBatchSync(i));
            Intrinsics.checkNotNullExpressionValue(error, "");
        }
        return error;
    }

    public static /* synthetic */ void PlaceComponentResult(SyncContactEngine syncContactEngine, SubscriptionKey subscriptionKey, Triple triple) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(syncContactEngine, "");
        Intrinsics.checkNotNullParameter(subscriptionKey, "");
        ContactSyncConfig contactSyncConfig = (ContactSyncConfig) triple.component1();
        SyncContactSplitConfigModel syncContactSplitConfigModel = (SyncContactSplitConfigModel) triple.component2();
        int intValue = ((Number) triple.component3()).intValue();
        SCState sCState = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState != null) {
            sCState.KClassImpl$Data$declaredNonStaticMembers$2 = TuplesKt.to(contactSyncConfig, syncContactSplitConfigModel);
        }
        SCState sCState2 = syncContactEngine.PlaceComponentResult.get(subscriptionKey);
        if (sCState2 != null && (map = sCState2.scheduleImpl) != null) {
            int moveToNextValue = syncContactEngine.MyBillsEntityDataFactory.moveToNextValue() >= 0 ? syncContactEngine.MyBillsEntityDataFactory.moveToNextValue() : 0;
            map.put(TrackerDataKey.Property.TOTAL_CONTACT_SIZE, Integer.valueOf(intValue));
            map.put(TrackerDataKey.Property.UPLOADED_CONTACT, Integer.valueOf(moveToNextValue));
            map.put(TrackerDataKey.Property.UPLOADING_CONTACT, 0);
            map.put(TrackerDataKey.Property.SYNC_CONTACT_VERSION, Integer.valueOf(contactSyncConfig.getVersion()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(syncContactEngine.hashCode());
        sb.append(" : syncForNeverSync limit : ");
        sb.append(contactSyncConfig.getMaxContactSyncBatchSize());
        sb.append(" offset : 0");
        DanaLog.MyBillsEntityDataFactory("SyncContactEngine", sb.toString());
        syncContactEngine.MyBillsEntityDataFactory(contactSyncConfig.getMaxContactSyncBatchSize(), 0, 0, subscriptionKey);
    }
}
