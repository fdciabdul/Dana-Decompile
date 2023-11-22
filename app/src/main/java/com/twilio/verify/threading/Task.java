package com.twilio.verify.threading;

import android.os.Handler;
import java.lang.Exception;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\f\b\u0001\u0010\u0004*\u00060\u0002j\u0002`\u00032\u00020\u0005B\u0093\u0001\u0012V\u0010\u0017\u001aR\u0012#\u0012!\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b¢\u0006\u0002\b\f\u0012#\u0012!\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001`\r¢\u0006\u0002\b\f\u0012\u0004\u0012\u00020\u00060\t\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\n\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bRd\u0010\u0010\u001aR\u0012#\u0012!\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b¢\u0006\u0002\b\f\u0012#\u0012!\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001`\r¢\u0006\u0002\b\f\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011"}, d2 = {"Lcom/twilio/verify/threading/Task;", "T", "Ljava/lang/Exception;", "Lkotlin/Exception;", "E", "Ljava/lang/Runnable;", "", "run", "()V", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lcom/twilio/verify/threading/SafeSuccessResult;", "Lkotlin/ParameterName;", "Lcom/twilio/verify/threading/SafeError;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function2;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Handler;", "MyBillsEntityDataFactory", "Landroid/os/Handler;", "getAuthRequestContext", "p0", "p1", "p2", "p3", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroid/os/Handler;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class Task<T, E extends Exception> implements Runnable {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<E, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Handler PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function2<Function1<? super T, Unit>, Function1<? super E, Unit>, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function1<T, Unit> MyBillsEntityDataFactory;

    /* JADX WARN: Multi-variable type inference failed */
    private Task(Function2<? super Function1<? super T, Unit>, ? super Function1<? super E, Unit>, Unit> function2, Function1<? super T, Unit> function1, Function1<? super E, Unit> function12, Handler handler) {
        Intrinsics.checkParameterIsNotNull(function2, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        Intrinsics.checkParameterIsNotNull(function12, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function2;
        this.MyBillsEntityDataFactory = function1;
        this.BuiltInFictitiousFunctionClassFactory = function12;
        this.PlaceComponentResult = handler;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Task(kotlin.jvm.functions.Function2 r1, kotlin.jvm.functions.Function1 r2, kotlin.jvm.functions.Function1 r3, android.os.Handler r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            r6 = 0
            if (r5 == 0) goto L20
            android.os.Looper r4 = android.os.Looper.myLooper()
            if (r4 == 0) goto L1f
            android.os.Looper r5 = android.os.Looper.getMainLooper()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r5 != 0) goto L16
            r4 = r6
        L16:
            if (r4 == 0) goto L1f
            android.os.Handler r5 = new android.os.Handler
            r5.<init>(r4)
            r4 = r5
            goto L20
        L1f:
            r4 = r6
        L20:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.threading.Task.<init>(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, android.os.Handler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(new Task$run$1(this), new Task$run$2(this));
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final Task task, final Exception exc) {
        Handler handler = task.PlaceComponentResult;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.twilio.verify.threading.Task$safeError$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function1 function1;
                    function1 = Task.this.BuiltInFictitiousFunctionClassFactory;
                    function1.invoke(exc);
                }
            });
        } else {
            task.BuiltInFictitiousFunctionClassFactory.invoke(exc);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final Task task, final Object obj) {
        Handler handler = task.PlaceComponentResult;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.twilio.verify.threading.Task$safeSuccess$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    Function1 function1;
                    function1 = Task.this.MyBillsEntityDataFactory;
                    function1.invoke(obj);
                }
            });
        } else {
            task.MyBillsEntityDataFactory.invoke(obj);
        }
    }
}
