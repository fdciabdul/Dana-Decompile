package retrofit2.adapter.rxjava2;

import io.reactivex.Scheduler;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

/* loaded from: classes6.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final boolean PlaceComponentResult;
    private final boolean getAuthRequestContext;
    private final Type getErrorConfigVersion;
    @Nullable
    private final Scheduler lookAheadTest;
    private final boolean scheduleImpl;

    public RxJava2CallAdapter(Type type, @Nullable Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.getErrorConfigVersion = type;
        this.lookAheadTest = scheduler;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.scheduleImpl = z2;
        this.BuiltInFictitiousFunctionClassFactory = z3;
        this.PlaceComponentResult = z4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z5;
        this.MyBillsEntityDataFactory = z6;
        this.getAuthRequestContext = z7;
    }

    @Override // retrofit2.CallAdapter
    public final Type getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0037  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(retrofit2.Call<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto La
            retrofit2.adapter.rxjava2.CallEnqueueObservable r0 = new retrofit2.adapter.rxjava2.CallEnqueueObservable
            r0.<init>(r2)
            goto Lf
        La:
            retrofit2.adapter.rxjava2.CallExecuteObservable r0 = new retrofit2.adapter.rxjava2.CallExecuteObservable
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.scheduleImpl
            if (r2 == 0) goto L1a
            retrofit2.adapter.rxjava2.ResultObservable r2 = new retrofit2.adapter.rxjava2.ResultObservable
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.BuiltInFictitiousFunctionClassFactory
            if (r2 == 0) goto L24
            retrofit2.adapter.rxjava2.BodyObservable r2 = new retrofit2.adapter.rxjava2.BodyObservable
            r2.<init>(r0)
            goto L18
        L24:
            io.reactivex.Scheduler r2 = r1.lookAheadTest
            if (r2 == 0) goto L2c
            io.reactivex.Observable r0 = r0.subscribeOn(r2)
        L2c:
            boolean r2 = r1.PlaceComponentResult
            if (r2 == 0) goto L37
            io.reactivex.BackpressureStrategy r2 = io.reactivex.BackpressureStrategy.LATEST
            io.reactivex.Flowable r2 = r0.toFlowable(r2)
            return r2
        L37:
            boolean r2 = r1.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r2 == 0) goto L40
            io.reactivex.Single r2 = r0.singleOrError()
            return r2
        L40:
            boolean r2 = r1.MyBillsEntityDataFactory
            if (r2 == 0) goto L49
            io.reactivex.Maybe r2 = r0.singleElement()
            return r2
        L49:
            boolean r2 = r1.getAuthRequestContext
            if (r2 == 0) goto L52
            io.reactivex.Completable r2 = r0.ignoreElements()
            return r2
        L52:
            io.reactivex.Observable r2 = io.reactivex.plugins.RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava2.RxJava2CallAdapter.KClassImpl$Data$declaredNonStaticMembers$2(retrofit2.Call):java.lang.Object");
    }
}
