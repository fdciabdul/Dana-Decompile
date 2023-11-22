package androidx.paging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\t\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR$\u0010\t\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00108\u0001@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0007\u0010\u0012R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016"}, d2 = {"Landroidx/paging/InvalidateCallbackTracker;", "T", "", "", "getAuthRequestContext", "()V", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)V", "MyBillsEntityDataFactory", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/util/List;", "PlaceComponentResult", "", "Z", "()Z", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class InvalidateCallbackTracker<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final List<T> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ReentrantLock KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function0<Boolean> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<T, Unit> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidateCallbackTracker(Function1<? super T, Unit> function1, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.getAuthRequestContext = function0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ReentrantLock();
        this.PlaceComponentResult = new ArrayList();
    }

    public /* synthetic */ InvalidateCallbackTracker(Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : function0);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(T p0) {
        Function0<Boolean> function0 = this.getAuthRequestContext;
        boolean z = false;
        if (function0 != null && function0.invoke().booleanValue()) {
            getAuthRequestContext();
        }
        if (this.MyBillsEntityDataFactory) {
            this.BuiltInFictitiousFunctionClassFactory.invoke(p0);
            return;
        }
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            if (getMyBillsEntityDataFactory()) {
                Unit unit = Unit.INSTANCE;
                z = true;
            } else {
                this.PlaceComponentResult.add(p0);
            }
            if (z) {
                this.BuiltInFictitiousFunctionClassFactory.invoke(p0);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void MyBillsEntityDataFactory(T p0) {
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            this.PlaceComponentResult.remove(p0);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void getAuthRequestContext() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            if (getMyBillsEntityDataFactory()) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            List list = CollectionsKt.toList(this.PlaceComponentResult);
            this.PlaceComponentResult.clear();
            Unit unit = Unit.INSTANCE;
            if (list != null) {
                Function1<T, Unit> function1 = this.BuiltInFictitiousFunctionClassFactory;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    function1.invoke(it.next());
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
