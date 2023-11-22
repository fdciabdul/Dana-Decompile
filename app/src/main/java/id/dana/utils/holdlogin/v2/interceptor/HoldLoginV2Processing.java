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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Processing;", "", "", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;)V", "(Z)V", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Processing$State;", "PlaceComponentResult", "Ljava/util/Map;", "<init>", "()V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HoldLoginV2Processing {
    public static final HoldLoginV2Processing INSTANCE = new HoldLoginV2Processing();
    private static final Map<String, State> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static final ReentrantLock KClassImpl$Data$declaredNonStaticMembers$2 = new ReentrantLock();

    private HoldLoginV2Processing() {
    }

    @JvmStatic
    public static final Observable<Boolean> getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        Map<String, State> map = PlaceComponentResult;
        State state = map.get(p0);
        Observable<Boolean> observable = state != null ? state.MyBillsEntityDataFactory : null;
        if (observable != null) {
            reentrantLock.unlock();
            return observable;
        }
        ReplaySubject BuiltInFictitiousFunctionClassFactory = ReplaySubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        HoldLoginV2Processing holdLoginV2Processing = INSTANCE;
        Observable<Boolean> doOnDispose = BuiltInFictitiousFunctionClassFactory.doOnSubscribe(new Consumer() { // from class: id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Processing$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                HoldLoginV2Processing.getAuthRequestContext(HoldLoginV2Processing.this, p0);
            }
        }).doOnDispose(new Action() { // from class: id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Processing$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() {
                HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(HoldLoginV2Processing.this, p0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "");
        map.put(p0, new State(doOnDispose, BuiltInFictitiousFunctionClassFactory));
        reentrantLock.unlock();
        return doOnDispose;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ReentrantLock reentrantLock = KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            Iterator<Map.Entry<String, State>> it = PlaceComponentResult.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().BuiltInFictitiousFunctionClassFactory.onNext(Boolean.valueOf(p0));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            Iterator<Map.Entry<String, State>> it = PlaceComponentResult.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().BuiltInFictitiousFunctionClassFactory.onError(p0);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0011\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Processing$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/reactivex/subjects/ReplaySubject;", "getAuthRequestContext", "Lio/reactivex/subjects/ReplaySubject;", "BuiltInFictitiousFunctionClassFactory", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "PlaceComponentResult", "I", "p1", "p2", "<init>", "(Lio/reactivex/Observable;Lio/reactivex/subjects/ReplaySubject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class State {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        Observable<Boolean> MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        ReplaySubject<Boolean> BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof State) {
                State state = (State) p0;
                return this.KClassImpl$Data$declaredNonStaticMembers$2 == state.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.MyBillsEntityDataFactory, state.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, state.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.KClassImpl$Data$declaredNonStaticMembers$2 * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public State(Observable<Boolean> observable, ReplaySubject<Boolean> replaySubject) {
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(replaySubject, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.MyBillsEntityDataFactory = observable;
            this.BuiltInFictitiousFunctionClassFactory = replaySubject;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(HoldLoginV2Processing holdLoginV2Processing, String str) {
        Intrinsics.checkNotNullParameter(holdLoginV2Processing, "");
        Intrinsics.checkNotNullParameter(str, "");
        ReentrantLock reentrantLock = KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            Map<String, State> map = PlaceComponentResult;
            State state = map.get(str);
            int i = state != null ? state.KClassImpl$Data$declaredNonStaticMembers$2 : 0;
            State state2 = map.get(str);
            if (state2 != null) {
                state2.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HoldLoginV2Processing holdLoginV2Processing, String str) {
        Intrinsics.checkNotNullParameter(holdLoginV2Processing, "");
        Intrinsics.checkNotNullParameter(str, "");
        ReentrantLock reentrantLock = KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            Map<String, State> map = PlaceComponentResult;
            State state = map.get(str);
            int i = state != null ? state.KClassImpl$Data$declaredNonStaticMembers$2 : 1;
            State state2 = map.get(str);
            if (state2 != null) {
                state2.KClassImpl$Data$declaredNonStaticMembers$2 = i - 1;
            }
            if (i == 1) {
                map.remove(str);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
