package id.dana.eventbus.models;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000b\u0010\u000e"}, d2 = {"Lid/dana/eventbus/models/TimerEvent;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAuthRequestContext", "Ljava/util/HashMap;", "MyBillsEntityDataFactory", "Lid/dana/eventbus/models/TimerEventKey;", "PlaceComponentResult", "Lid/dana/eventbus/models/TimerEventKey;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "<init>", "(Lid/dana/eventbus/models/TimerEventKey;Ljava/util/HashMap;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimerEvent {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final TimerEventKey KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final HashMap<String, String> MyBillsEntityDataFactory;

    public TimerEvent(TimerEventKey timerEventKey, HashMap<String, String> hashMap, boolean z) {
        Intrinsics.checkNotNullParameter(timerEventKey, "");
        Intrinsics.checkNotNullParameter(hashMap, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = timerEventKey;
        this.MyBillsEntityDataFactory = hashMap;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
