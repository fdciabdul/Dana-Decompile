package id.dana.electronicmoney;

import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b"}, d2 = {"Lid/dana/electronicmoney/RxEmoneyBus;", "", "Lio/reactivex/subjects/BehaviorSubject;", "", "PlaceComponentResult", "()Lio/reactivex/subjects/BehaviorSubject;", "", "getAuthRequestContext", "Lio/reactivex/subjects/BehaviorSubject;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RxEmoneyBus {
    public static final RxEmoneyBus INSTANCE = new RxEmoneyBus();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private static final BehaviorSubject<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private static final BehaviorSubject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2;

    private RxEmoneyBus() {
    }

    static {
        BehaviorSubject<Boolean> BuiltInFictitiousFunctionClassFactory2 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
        BehaviorSubject<String> BuiltInFictitiousFunctionClassFactory3 = BehaviorSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
        BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory3;
    }

    @JvmStatic
    public static final BehaviorSubject<Boolean> PlaceComponentResult() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmStatic
    public static final BehaviorSubject<String> getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory;
    }
}
