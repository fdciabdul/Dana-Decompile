package id.dana.utils.rpc.quake;

import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/utils/rpc/quake/RpcQuakeObserver;", "", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/utils/rpc/quake/RpcQuakeState;", "PlaceComponentResult", "Lio/reactivex/subjects/BehaviorSubject;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RpcQuakeObserver {
    public static final RpcQuakeObserver INSTANCE = new RpcQuakeObserver();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final BehaviorSubject<RpcQuakeState> KClassImpl$Data$declaredNonStaticMembers$2;

    private RpcQuakeObserver() {
    }

    static {
        BehaviorSubject<RpcQuakeState> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.onNext(RpcQuakeState.ERROR);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("onError ");
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        sb.append(message);
        DanaLog.BuiltInFictitiousFunctionClassFactory("RpcQuakeObserver", sb.toString());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0, RpcQuakeState rpcQuakeState) {
        Intrinsics.checkNotNullParameter(function0, "");
        if (rpcQuakeState == RpcQuakeState.FINISH) {
            function0.invoke();
        }
    }
}
