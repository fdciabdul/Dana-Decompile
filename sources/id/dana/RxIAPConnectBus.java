package id.dana;

import id.dana.iapconnectutil.IapConnectState;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/RxIAPConnectBus;", "", "Lio/reactivex/subjects/BehaviorSubject;", "Lid/dana/iapconnectutil/IapConnectState;", "getAuthRequestContext", "()Lio/reactivex/subjects/BehaviorSubject;", "MyBillsEntityDataFactory", "Lio/reactivex/subjects/BehaviorSubject;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RxIAPConnectBus {
    public static final RxIAPConnectBus INSTANCE = new RxIAPConnectBus();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final BehaviorSubject<IapConnectState> KClassImpl$Data$declaredNonStaticMembers$2;

    private RxIAPConnectBus() {
    }

    static {
        BehaviorSubject<IapConnectState> BuiltInFictitiousFunctionClassFactory = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.onNext(IapConnectState.Error.INSTANCE);
    }

    @JvmStatic
    public static final BehaviorSubject<IapConnectState> getAuthRequestContext() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
