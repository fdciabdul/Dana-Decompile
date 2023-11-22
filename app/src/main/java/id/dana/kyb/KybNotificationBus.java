package id.dana.kyb;

import id.dana.domain.core.usecase.NoParams;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/kyb/KybNotificationBus;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/core/usecase/NoParams;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "getAuthRequestContext", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class KybNotificationBus {
    public static final KybNotificationBus INSTANCE = new KybNotificationBus();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private static final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<PublishSubject<NoParams>>() { // from class: id.dana.kyb.KybNotificationBus$newTransactionNotifier$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PublishSubject<NoParams> invoke() {
            return PublishSubject.PlaceComponentResult();
        }
    });

    private KybNotificationBus() {
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory() {
        Object value = getAuthRequestContext.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        ((PublishSubject) value).onNext(NoParams.INSTANCE);
    }
}
