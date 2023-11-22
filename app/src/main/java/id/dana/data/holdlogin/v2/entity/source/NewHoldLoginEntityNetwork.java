package id.dana.data.holdlogin.v2.entity.source;

import android.content.Context;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.holdlogin.HoldLoginFailTrackerModel;
import id.dana.data.holdlogin.HoldLoginSuccessTrackerModel;
import id.dana.data.holdlogin.v2.entity.HoldLoginEntityData;
import id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork;
import id.dana.data.holdlogin.v2.entity.source.SharedHoldLoginNetwork;
import id.dana.data.holdlogin.v2.exception.HoldLoginExceptionParserSingle;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.data.login.source.network.LoginRpcFacade;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.data.login.source.network.model.LoginType;
import id.dana.data.login.source.network.request.LoginRpcRequest;
import id.dana.network.base.DeserializeExceptionParser;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.util.BaseNetworkUtils;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import id.dana.utils.extension.StringExtKt;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00012B1\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001e\u0012\u0006\u0010\b\u001a\u00020\u001c\u0012\u0006\u0010\t\u001a\u00020+\u0012\u0006\u0010\f\u001a\u00020%\u0012\u0006\u0010/\u001a\u00020 ¢\u0006\u0004\b0\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0004\u0010\rJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0018J\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u0019H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001a\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001fR\u0014\u0010\u0004\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010!R\u0014\u0010\u0015\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0011\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020(0'X\u0000¢\u0006\u0006\n\u0004\b\u0004\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/source/NewHoldLoginEntityNetwork;", "Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityData;", "Lid/dana/data/holdlogin/v2/entity/source/SharedHoldLoginNetwork;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "p1", "p2", "Lkotlin/Function0;", "Lid/dana/network/response/login/LoginRpcResult;", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/Observable;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "", "", "", "PlaceComponentResult", "(Ljava/lang/Throwable;Ljava/util/List;)Z", "Lio/reactivex/subjects/ReplaySubject;", "(Lio/reactivex/subjects/ReplaySubject;Ljava/lang/String;)Lio/reactivex/Observable;", "Lio/reactivex/disposables/Disposable;", "MyBillsEntityDataFactory", "(Lio/reactivex/disposables/Disposable;)Z", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Ljava/util/concurrent/locks/ReentrantLock;", "moveToNextValue", "Ljava/util/concurrent/locks/ReentrantLock;", "Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;", "Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;", "", "Lid/dana/data/holdlogin/v2/entity/source/NewHoldLoginEntityNetwork$State;", "Ljava/util/Map;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/utils/concurrent/ThreadExecutor;", "scheduleImpl", "Lid/dana/utils/concurrent/ThreadExecutor;", "getErrorConfigVersion", "p4", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;)V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewHoldLoginEntityNetwork implements HoldLoginEntityData, SharedHoldLoginNetwork {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ApSecurityFacade MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Map<String, State> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final ImplSharedHoldLoginNetwork BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ReentrantLock PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ThreadExecutor getErrorConfigVersion;

    private boolean MyBillsEntityDataFactory(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "");
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(disposable);
    }

    public final boolean PlaceComponentResult(Throwable p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return ImplSharedHoldLoginNetwork.getAuthRequestContext(p0, p1);
    }

    @Inject
    public NewHoldLoginEntityNetwork(Context context, ApSecurityFacade apSecurityFacade, ThreadExecutor threadExecutor, ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork, HoldLoginConfig holdLoginConfig) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(implSharedHoldLoginNetwork, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = apSecurityFacade;
        this.getErrorConfigVersion = threadExecutor;
        this.BuiltInFictitiousFunctionClassFactory = implSharedHoldLoginNetwork;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginConfig;
        this.PlaceComponentResult = new ReentrantLock();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashMap();
    }

    @Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u001b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0016\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0012\u0010\u000f\u001a\u00020\u001bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u001f"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/source/NewHoldLoginEntityNetwork$State;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "p0", "", "equals", "(Ljava/lang/Object;)Z", "moveToNextValue", "I", "MyBillsEntityDataFactory", "scheduleImpl", "BuiltInFictitiousFunctionClassFactory", "Lio/reactivex/Observable;", "Lid/dana/network/response/login/LoginRpcResult;", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/ReplaySubject;", "PlaceComponentResult", "Lio/reactivex/subjects/ReplaySubject;", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "", "J", "Lj$/util/Optional;", "Lj$/util/Optional;", "Lid/dana/network/response/login/LoginRpcResult;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(IILio/reactivex/Observable;Lio/reactivex/subjects/ReplaySubject;Ljava/lang/String;JLj$/util/Optional;Lid/dana/network/response/login/LoginRpcResult;)V"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final /* data */ class State {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        Observable<LoginRpcResult> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        Optional<Long> moveToNextValue;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        long scheduleImpl;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public String PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        ReplaySubject<LoginRpcResult> getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        LoginRpcResult NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        int MyBillsEntityDataFactory;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        int BuiltInFictitiousFunctionClassFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof State) {
                State state = (State) p0;
                return this.MyBillsEntityDataFactory == state.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == state.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, state.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, state.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, state.PlaceComponentResult) && this.scheduleImpl == state.scheduleImpl && Intrinsics.areEqual(this.moveToNextValue, state.moveToNextValue) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, state.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            return false;
        }

        public final int hashCode() {
            int i = this.MyBillsEntityDataFactory;
            int i2 = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            int hashCode2 = this.getAuthRequestContext.hashCode();
            int hashCode3 = this.PlaceComponentResult.hashCode();
            int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.scheduleImpl);
            int hashCode4 = this.moveToNextValue.hashCode();
            LoginRpcResult loginRpcResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            return (((((((((((((i * 31) + i2) * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + m) * 31) + hashCode4) * 31) + (loginRpcResult == null ? 0 : loginRpcResult.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("State(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(')');
            return sb.toString();
        }

        private State(int i, int i2, Observable<LoginRpcResult> observable, ReplaySubject<LoginRpcResult> replaySubject, String str, long j, Optional<Long> optional, LoginRpcResult loginRpcResult) {
            Intrinsics.checkNotNullParameter(observable, "");
            Intrinsics.checkNotNullParameter(replaySubject, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(optional, "");
            this.MyBillsEntityDataFactory = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observable;
            this.getAuthRequestContext = replaySubject;
            this.PlaceComponentResult = str;
            this.scheduleImpl = j;
            this.moveToNextValue = optional;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = loginRpcResult;
        }

        public /* synthetic */ State(int i, int i2, Observable observable, ReplaySubject replaySubject, String str, long j, Optional optional, LoginRpcResult loginRpcResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, observable, replaySubject, str, j, optional, (i3 & 128) != 0 ? null : loginRpcResult);
        }
    }

    @Override // id.dana.data.holdlogin.v2.entity.HoldLoginEntityData
    public final Observable<LoginRpcResult> getAuthRequestContext(final String p0, final String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.PlaceComponentResult.lock();
        State state = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(p0);
        Observable<LoginRpcResult> observable = state != null ? state.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (observable != null) {
            if (state.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2()) {
                Object obj = state.moveToNextValue.PlaceComponentResult;
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    if (((Number) obj).longValue() < System.currentTimeMillis()) {
                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.MyBillsEntityDataFactory();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(p0);
                    }
                } else {
                    throw new NoSuchElementException("No value present");
                }
            }
            this.PlaceComponentResult.unlock();
            return observable;
        }
        ReplaySubject<LoginRpcResult> BuiltInFictitiousFunctionClassFactory = ReplaySubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Observable<LoginRpcResult> PlaceComponentResult = PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, p0);
        Map<String, State> map = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Optional MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory();
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        map.put(p0, new State(0, 0, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory, p2, currentTimeMillis, MyBillsEntityDataFactory, null, 128, null));
        KClassImpl$Data$declaredNonStaticMembers$2(p0, "alipayplus.mobilewallet.user.login", p2, new Function0<LoginRpcResult>() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$holdLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoginRpcResult invoke() {
                ApSecurityFacade apSecurityFacade;
                Context context;
                ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = NewHoldLoginEntityNetwork.this.BuiltInFictitiousFunctionClassFactory;
                Object interfaceProxy = RPCProxyHost.getInterfaceProxy(LoginRpcFacade.class);
                Intrinsics.checkNotNullExpressionValue(interfaceProxy, "");
                LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
                String str = p1;
                NewHoldLoginEntityNetwork newHoldLoginEntityNetwork = NewHoldLoginEntityNetwork.this;
                String str2 = p0;
                loginRpcRequest.credentials = str;
                apSecurityFacade = newHoldLoginEntityNetwork.MyBillsEntityDataFactory;
                context = newHoldLoginEntityNetwork.getAuthRequestContext;
                loginRpcRequest.envInfo = BaseNetworkUtils.generateMobileEnvInfo(apSecurityFacade, context);
                loginRpcRequest.loginId = str2;
                loginRpcRequest.loginIdType = LoginIdType.MOBILE_NO;
                loginRpcRequest.loginType = LoginType.HOLD_LOGIN;
                return ((LoginRpcFacade) interfaceProxy).login(loginRpcRequest);
            }
        });
        this.PlaceComponentResult.unlock();
        return PlaceComponentResult;
    }

    @Override // id.dana.data.holdlogin.v2.entity.HoldLoginEntityData
    public final Observable<LoginRpcResult> BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.PlaceComponentResult.lock();
        State state = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(p0);
        Observable<LoginRpcResult> observable = state != null ? state.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (observable != null) {
            if (state.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2()) {
                Object obj = state.moveToNextValue.PlaceComponentResult;
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    if (((Number) obj).longValue() < System.currentTimeMillis()) {
                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.MyBillsEntityDataFactory();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(p0);
                    }
                } else {
                    throw new NoSuchElementException("No value present");
                }
            }
            this.PlaceComponentResult.unlock();
            return observable;
        }
        ReplaySubject<LoginRpcResult> BuiltInFictitiousFunctionClassFactory = ReplaySubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Observable<LoginRpcResult> PlaceComponentResult = PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, p0);
        Map<String, State> map = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Optional MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory();
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        map.put(p0, new State(0, 0, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory, p2, currentTimeMillis, MyBillsEntityDataFactory, null, 128, null));
        KClassImpl$Data$declaredNonStaticMembers$2(p0, "id.dana.userprod.user.hold.login", p2, new Function0<LoginRpcResult>() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$holdLoginNewAPI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoginRpcResult invoke() {
                ApSecurityFacade apSecurityFacade;
                Context context;
                ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = NewHoldLoginEntityNetwork.this.BuiltInFictitiousFunctionClassFactory;
                Object interfaceProxy = RPCProxyHost.getInterfaceProxy(LoginRpcFacade.class);
                Intrinsics.checkNotNullExpressionValue(interfaceProxy, "");
                LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
                String str = p1;
                String str2 = p0;
                NewHoldLoginEntityNetwork newHoldLoginEntityNetwork = NewHoldLoginEntityNetwork.this;
                loginRpcRequest.credentials = str;
                loginRpcRequest.loginId = str2;
                loginRpcRequest.loginIdType = "ROLE";
                apSecurityFacade = newHoldLoginEntityNetwork.MyBillsEntityDataFactory;
                context = newHoldLoginEntityNetwork.getAuthRequestContext;
                loginRpcRequest.envInfo = BaseNetworkUtils.generateMobileEnvInfo(apSecurityFacade, context);
                return ((LoginRpcFacade) interfaceProxy).holdLogin(loginRpcRequest);
            }
        });
        this.PlaceComponentResult.unlock();
        return PlaceComponentResult;
    }

    private final Observable<LoginRpcResult> PlaceComponentResult(ReplaySubject<LoginRpcResult> p0, final String p1) {
        Observable<LoginRpcResult> doOnDispose = p0.doOnSubscribe(new Consumer() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                NewHoldLoginEntityNetwork.getAuthRequestContext(NewHoldLoginEntityNetwork.this, p1);
            }
        }).doOnDispose(new Action() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Action
            public final void run() {
                NewHoldLoginEntityNetwork.PlaceComponentResult(NewHoldLoginEntityNetwork.this, p1);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "");
        return doOnDispose;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1, final String p2, final Function0<LoginRpcResult> p3) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        this.PlaceComponentResult.lock();
        final FeatureHoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$22 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
        final HoldLoginExceptionParserSingle holdLoginExceptionParserSingle = new HoldLoginExceptionParserSingle(KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult.getAuthRequestContext);
        List<String> BuiltInFictitiousFunctionClassFactory = CookieUtil.BuiltInFictitiousFunctionClassFactory("https://mgs-gw.m.dana.id/mgw.htm", "ALIPAYJSESSIONID");
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        final List list = CollectionsKt.toList(BuiltInFictitiousFunctionClassFactory);
        holdLoginExceptionParserSingle.setContext(this.getAuthRequestContext);
        holdLoginExceptionParserSingle.setOperationType(p1);
        Single PlaceComponentResult = Single.PlaceComponentResult(new Callable() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NewHoldLoginEntityNetwork.getAuthRequestContext(Function0.this);
            }
        });
        Scheduler BuiltInFictitiousFunctionClassFactory2 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion);
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2));
        Scheduler BuiltInFictitiousFunctionClassFactory4 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion);
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory4, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory5 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4));
        Function function = new Function() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NewHoldLoginEntityNetwork.PlaceComponentResult((Throwable) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function, "resumeFunctionInCaseOfError is null");
        Single BuiltInFictitiousFunctionClassFactory6 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleResumeNext(BuiltInFictitiousFunctionClassFactory5, function));
        Function function2 = new Function() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HoldLoginExceptionParserSingle.this.apply((LoginRpcResult) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(function2, "mapper is null");
        Single BuiltInFictitiousFunctionClassFactory7 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(BuiltInFictitiousFunctionClassFactory6, function2));
        long j = KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory8 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(BuiltInFictitiousFunctionClassFactory7, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory8, "");
        Disposable MyBillsEntityDataFactory = RxExtensionKt.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory8, new Function1<Throwable, Boolean>() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$executeV2$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(NewHoldLoginEntityNetwork.this.PlaceComponentResult(th, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult.MyBillsEntityDataFactory));
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$executeV2$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                NewHoldLoginEntityNetwork.State state = NewHoldLoginEntityNetwork.this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(p0);
                if (state != null) {
                    state.BuiltInFictitiousFunctionClassFactory = i;
                }
            }
        }, KClassImpl$Data$declaredNonStaticMembers$22.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewHoldLoginEntityNetwork.PlaceComponentResult(NewHoldLoginEntityNetwork.this, p0, p1, p2, list, (LoginRpcResult) obj);
            }
        }, new Consumer() { // from class: id.dana.data.holdlogin.v2.entity.source.NewHoldLoginEntityNetwork$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewHoldLoginEntityNetwork.getAuthRequestContext(NewHoldLoginEntityNetwork.this, p0, p1, p2, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        MyBillsEntityDataFactory(MyBillsEntityDataFactory);
        this.PlaceComponentResult.unlock();
    }

    @Override // id.dana.data.holdlogin.v2.entity.HoldLoginEntityData
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void getAuthRequestContext(NewHoldLoginEntityNetwork newHoldLoginEntityNetwork, String str, String str2, String str3, Throwable th) {
        ReentrantLock reentrantLock;
        Integer valueOf;
        Long valueOf2;
        long currentTimeMillis;
        Intrinsics.checkNotNullParameter(newHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        ReentrantLock reentrantLock2 = newHoldLoginEntityNetwork.PlaceComponentResult;
        reentrantLock2.lock();
        try {
            State state = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            valueOf = state != null ? Integer.valueOf(state.BuiltInFictitiousFunctionClassFactory) : null;
            State state2 = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            valueOf2 = state2 != null ? Long.valueOf(state2.scheduleImpl) : null;
            Intrinsics.checkNotNullExpressionValue(th, "");
            reentrantLock = reentrantLock2;
        } catch (Throwable th2) {
            th = th2;
            reentrantLock = reentrantLock2;
        }
        try {
            HoldLoginFailTrackerModel holdLoginFailTrackerModel = new HoldLoginFailTrackerModel(str, TrackerDataKey.LoginType.HOLD_LOGIN, str2, str3, th, valueOf != null ? valueOf.intValue() : -1, valueOf2 != null ? System.currentTimeMillis() - valueOf2.longValue() : -1L, false, newHoldLoginEntityNetwork.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().getKClassImpl$Data$declaredNonStaticMembers$2());
            Intrinsics.checkNotNullParameter(holdLoginFailTrackerModel, "");
            newHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(holdLoginFailTrackerModel);
            State state3 = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            if (state3 != null) {
                if (!(th instanceof HoldLoginException)) {
                    currentTimeMillis = System.currentTimeMillis();
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = newHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory;
                    currentTimeMillis = currentTimeMillis2 + SharedHoldLoginNetwork.CC.MyBillsEntityDataFactory();
                }
                Optional<Long> MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory(Long.valueOf(currentTimeMillis));
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
                state3.moveToNextValue = MyBillsEntityDataFactory;
                state3.getAuthRequestContext.onError(th);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th3) {
            th = th3;
            reentrantLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ LoginRpcResult getAuthRequestContext(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return (LoginRpcResult) function0.invoke();
    }

    public static /* synthetic */ void PlaceComponentResult(NewHoldLoginEntityNetwork newHoldLoginEntityNetwork, String str) {
        Intrinsics.checkNotNullParameter(newHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(str, "");
        ReentrantLock reentrantLock = newHoldLoginEntityNetwork.PlaceComponentResult;
        reentrantLock.lock();
        try {
            State state = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            int i = state != null ? state.MyBillsEntityDataFactory : 1;
            State state2 = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            if (state2 != null) {
                state2.MyBillsEntityDataFactory = i - 1;
            }
            if (i <= 1) {
                newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(str);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(NewHoldLoginEntityNetwork newHoldLoginEntityNetwork, String str, String str2, String str3, List list, LoginRpcResult loginRpcResult) {
        Intrinsics.checkNotNullParameter(newHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        ReentrantLock reentrantLock = newHoldLoginEntityNetwork.PlaceComponentResult;
        reentrantLock.lock();
        try {
            String str4 = loginRpcResult.sessionId;
            if (str4 == null) {
                str4 = "";
            }
            State state = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            Integer valueOf = state != null ? Integer.valueOf(state.BuiltInFictitiousFunctionClassFactory) : null;
            State state2 = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            Long valueOf2 = state2 != null ? Long.valueOf(state2.scheduleImpl) : null;
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.take(StringExtKt.PlaceComponentResult((String) it.next()), 20));
            }
            ArrayList arrayList2 = arrayList;
            String take = StringsKt.take(StringExtKt.PlaceComponentResult(str4), 20);
            List<String> BuiltInFictitiousFunctionClassFactory = CookieUtil.BuiltInFictitiousFunctionClassFactory("https://mgs-gw.m.dana.id/mgw.htm", "ALIPAYJSESSIONID");
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            List<String> list3 = BuiltInFictitiousFunctionClassFactory;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (String str5 : list3) {
                Intrinsics.checkNotNullExpressionValue(str5, "");
                arrayList3.add(StringsKt.take(StringExtKt.PlaceComponentResult(str5), 20));
            }
            HoldLoginSuccessTrackerModel holdLoginSuccessTrackerModel = new HoldLoginSuccessTrackerModel(str, TrackerDataKey.LoginType.HOLD_LOGIN, 2, true, str2, str3, valueOf != null ? valueOf.intValue() : -1, valueOf2 != null ? System.currentTimeMillis() - valueOf2.longValue() : -1L, arrayList2, take, arrayList3, false, newHoldLoginEntityNetwork.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2().getKClassImpl$Data$declaredNonStaticMembers$2());
            Intrinsics.checkNotNullParameter(holdLoginSuccessTrackerModel, "");
            newHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(holdLoginSuccessTrackerModel);
            Intrinsics.checkNotNullExpressionValue(loginRpcResult, "");
            State state3 = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            if (state3 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = newHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory;
                Optional<Long> MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory(Long.valueOf(currentTimeMillis + SharedHoldLoginNetwork.CC.MyBillsEntityDataFactory()));
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
                state3.moveToNextValue = MyBillsEntityDataFactory;
                state3.NetworkUserEntityData$$ExternalSyntheticLambda0 = loginRpcResult;
                state3.getAuthRequestContext.onNext(loginRpcResult);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(NewHoldLoginEntityNetwork newHoldLoginEntityNetwork, String str) {
        Intrinsics.checkNotNullParameter(newHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(str, "");
        ReentrantLock reentrantLock = newHoldLoginEntityNetwork.PlaceComponentResult;
        reentrantLock.lock();
        try {
            State state = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            int i = state != null ? state.MyBillsEntityDataFactory : 0;
            State state2 = newHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str);
            if (state2 != null) {
                state2.MyBillsEntityDataFactory = i + 1;
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static /* synthetic */ SingleSource PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new DeserializeExceptionParser(LoginRpcResult.class).apply(th);
    }
}
