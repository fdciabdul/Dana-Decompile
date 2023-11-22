package id.dana.data.home.repository.source.presistence;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.home.repository.source.presistence.entity.SingleBalanceDaoEntity;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/home/repository/source/presistence/SingleBalanceProcessing;", "", "Lio/reactivex/Observable;", "Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;)V", "Ljava/util/concurrent/locks/ReentrantLock;", "PlaceComponentResult", "Ljava/util/concurrent/locks/ReentrantLock;", "", "", "Lid/dana/data/home/repository/source/presistence/SingleBalanceProcessing$State;", "getAuthRequestContext", "Ljava/util/Map;", "<init>", "()V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SingleBalanceProcessing {
    public static final SingleBalanceProcessing INSTANCE = new SingleBalanceProcessing();
    private static final Map<String, State> getAuthRequestContext = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final ReentrantLock BuiltInFictitiousFunctionClassFactory = new ReentrantLock();

    private SingleBalanceProcessing() {
    }

    @JvmStatic
    public static final Observable<SingleBalanceDaoEntity> BuiltInFictitiousFunctionClassFactory() {
        ReentrantLock reentrantLock = BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        Map<String, State> map = getAuthRequestContext;
        final SingleBalanceProcessing singleBalanceProcessing = INSTANCE;
        State state = map.get("SingleBalance");
        Observable<SingleBalanceDaoEntity> observable = state != null ? state.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (observable != null) {
            reentrantLock.unlock();
            return observable;
        }
        BehaviorSubject BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        Observable<SingleBalanceDaoEntity> doOnDispose = BuiltInFictitiousFunctionClassFactory2.doOnSubscribe(new Consumer() { // from class: id.dana.data.home.repository.source.presistence.SingleBalanceProcessing$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                SingleBalanceProcessing.getAuthRequestContext(SingleBalanceProcessing.this);
            }
        }).doOnDispose(new Action() { // from class: id.dana.data.home.repository.source.presistence.SingleBalanceProcessing$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() {
                SingleBalanceProcessing.KClassImpl$Data$declaredNonStaticMembers$2(SingleBalanceProcessing.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "");
        map.put("SingleBalance", new State(doOnDispose, BuiltInFictitiousFunctionClassFactory2));
        reentrantLock.unlock();
        return doOnDispose;
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(SingleBalanceDaoEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            Iterator<Map.Entry<String, State>> it = getAuthRequestContext.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().getAuthRequestContext.onNext(p0);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/home/repository/source/presistence/SingleBalanceProcessing$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/BehaviorSubject;", "getAuthRequestContext", "Lio/reactivex/Observable;", "Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(Lio/reactivex/Observable;Lio/reactivex/subjects/BehaviorSubject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class State {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        BehaviorSubject<SingleBalanceDaoEntity> getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        Observable<SingleBalanceDaoEntity> KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof State) {
                State state = (State) p0;
                return this.BuiltInFictitiousFunctionClassFactory == state.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, state.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, state.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.BuiltInFictitiousFunctionClassFactory * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public State(Observable<SingleBalanceDaoEntity> observable, BehaviorSubject<SingleBalanceDaoEntity> behaviorSubject) {
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(behaviorSubject, "");
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observable;
            this.getAuthRequestContext = behaviorSubject;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(SingleBalanceProcessing singleBalanceProcessing) {
        Intrinsics.checkNotNullParameter(singleBalanceProcessing, "");
        ReentrantLock reentrantLock = BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            Map<String, State> map = getAuthRequestContext;
            State state = map.get("SingleBalance");
            int i = state != null ? state.BuiltInFictitiousFunctionClassFactory : 0;
            State state2 = map.get("SingleBalance");
            if (state2 != null) {
                state2.BuiltInFictitiousFunctionClassFactory = i + 1;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SingleBalanceProcessing singleBalanceProcessing) {
        Intrinsics.checkNotNullParameter(singleBalanceProcessing, "");
        ReentrantLock reentrantLock = BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            Map<String, State> map = getAuthRequestContext;
            State state = map.get("SingleBalance");
            int i = state != null ? state.BuiltInFictitiousFunctionClassFactory : 1;
            State state2 = map.get("SingleBalance");
            if (state2 != null) {
                state2.BuiltInFictitiousFunctionClassFactory = i - 1;
            }
            if (i == 1) {
                map.remove("SingleBalance");
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
