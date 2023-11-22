package id.dana.utils.holdlogin.v2.interceptor;

import id.dana.analytics.tracker.TrackerKey;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Starting;", "", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "()Lio/reactivex/Observable;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Starting$State;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Map;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HoldLoginV2Starting {
    public static final HoldLoginV2Starting INSTANCE = new HoldLoginV2Starting();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static final Map<String, State> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final ReentrantLock getAuthRequestContext = new ReentrantLock();

    private HoldLoginV2Starting() {
    }

    @JvmStatic
    public static final Observable<String> getAuthRequestContext() {
        ReentrantLock reentrantLock = getAuthRequestContext;
        reentrantLock.lock();
        Map<String, State> map = KClassImpl$Data$declaredNonStaticMembers$2;
        HoldLoginV2Starting holdLoginV2Starting = INSTANCE;
        State state = map.get("HoldLoginV2Starting");
        Observable<String> observable = state != null ? state.getAuthRequestContext : null;
        if (observable != null) {
            reentrantLock.unlock();
            return observable;
        }
        ReplaySubject BuiltInFictitiousFunctionClassFactory = ReplaySubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Observable<String> doOnDispose = BuiltInFictitiousFunctionClassFactory.doOnSubscribe(new Consumer() { // from class: id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Starting$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                HoldLoginV2Starting.PlaceComponentResult(HoldLoginV2Starting.this);
            }
        }).doOnDispose(new Action() { // from class: id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Starting$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() {
                HoldLoginV2Starting.BuiltInFictitiousFunctionClassFactory(HoldLoginV2Starting.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "");
        map.put("HoldLoginV2Starting", new State(doOnDispose, BuiltInFictitiousFunctionClassFactory));
        reentrantLock.unlock();
        return doOnDispose;
    }

    @JvmStatic
    public static final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = getAuthRequestContext;
        reentrantLock.lock();
        try {
            Iterator<Map.Entry<String, State>> it = KClassImpl$Data$declaredNonStaticMembers$2.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().PlaceComponentResult.onNext(p0);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Starting$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/subjects/ReplaySubject;", "PlaceComponentResult", "Lio/reactivex/subjects/ReplaySubject;", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/Observable;", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(Lio/reactivex/Observable;Lio/reactivex/subjects/ReplaySubject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class State {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        Observable<String> getAuthRequestContext;
        ReplaySubject<String> PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        int BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof State) {
                State state = (State) p0;
                return this.BuiltInFictitiousFunctionClassFactory == state.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.getAuthRequestContext, state.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, state.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.BuiltInFictitiousFunctionClassFactory * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        public State(Observable<String> observable, ReplaySubject<String> replaySubject) {
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(replaySubject, "");
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.getAuthRequestContext = observable;
            this.PlaceComponentResult = replaySubject;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HoldLoginV2Starting holdLoginV2Starting) {
        Intrinsics.checkNotNullParameter(holdLoginV2Starting, "");
        ReentrantLock reentrantLock = getAuthRequestContext;
        reentrantLock.lock();
        try {
            Map<String, State> map = KClassImpl$Data$declaredNonStaticMembers$2;
            State state = map.get("HoldLoginV2Starting");
            int i = state != null ? state.BuiltInFictitiousFunctionClassFactory : 1;
            State state2 = map.get("HoldLoginV2Starting");
            if (state2 != null) {
                state2.BuiltInFictitiousFunctionClassFactory = i - 1;
            }
            if (i == 1) {
                map.remove("HoldLoginV2Starting");
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(HoldLoginV2Starting holdLoginV2Starting) {
        Intrinsics.checkNotNullParameter(holdLoginV2Starting, "");
        ReentrantLock reentrantLock = getAuthRequestContext;
        reentrantLock.lock();
        try {
            Map<String, State> map = KClassImpl$Data$declaredNonStaticMembers$2;
            State state = map.get("HoldLoginV2Starting");
            int i = state != null ? state.BuiltInFictitiousFunctionClassFactory : 0;
            State state2 = map.get("HoldLoginV2Starting");
            if (state2 != null) {
                state2.BuiltInFictitiousFunctionClassFactory = i + 1;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
