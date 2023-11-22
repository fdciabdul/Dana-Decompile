package id.dana.crash;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import id.dana.analytics.firebase.Crashlytics;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/crash/AppExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/Throwable;)Z", "p1", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Thread;", "", "uncaughtException", "(Ljava/lang/Thread;Ljava/lang/Throwable;)V", "Landroid/app/Activity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/app/Activity;", "", "I", "MyBillsEntityDataFactory", "Ljava/lang/Thread$UncaughtExceptionHandler;", "Landroid/app/Application;", "<init>", "(Ljava/lang/Thread$UncaughtExceptionHandler;Landroid/app/Application;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Activity PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Thread.UncaughtExceptionHandler KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    public AppExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Application application) {
        Intrinsics.checkNotNullParameter(uncaughtExceptionHandler, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uncaughtExceptionHandler;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: id.dana.crash.AppExceptionHandler.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity p0, Bundle p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity p0, Bundle p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                }

                {
                    AppExceptionHandler.this = this;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    AppExceptionHandler.this.MyBillsEntityDataFactory++;
                    AppExceptionHandler.this.PlaceComponentResult = p0;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    AppExceptionHandler appExceptionHandler = AppExceptionHandler.this;
                    appExceptionHandler.MyBillsEntityDataFactory--;
                    if (AppExceptionHandler.this.MyBillsEntityDataFactory <= 0) {
                        AppExceptionHandler.this.PlaceComponentResult = null;
                    }
                }
            });
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(final Thread p0, final Throwable p1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final Activity activity = this.PlaceComponentResult;
        if (activity != null) {
            boolean booleanExtra = activity.getIntent().getBooleanExtra("appExceptionHandler_restarted", false);
            Throwable th = (Throwable) activity.getIntent().getSerializableExtra("appExceptionHandler_lastException");
            if (!booleanExtra || !PlaceComponentResult(p1, th)) {
                if (getAuthRequestContext(p1)) {
                    new Function0<Unit>() { // from class: id.dana.crash.AppExceptionHandler$uncaughtException$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Crashlytics.Companion companion = Crashlytics.INSTANCE;
                            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                            Throwable th2 = p1;
                            Intrinsics.checkNotNullParameter(th2, "");
                            authRequestContext.getAuthRequestContext.recordException(th2);
                            Intent addFlags = activity.getIntent().putExtra("appExceptionHandler_restarted", true).putExtra("appExceptionHandler_lastException", p1).addFlags(268468224);
                            Intrinsics.checkNotNullExpressionValue(addFlags, "");
                            Activity activity2 = activity;
                            activity2.finish();
                            activity2.startActivity(addFlags);
                        }
                    }.invoke();
                    Process.killProcess(Process.myPid());
                    System.exit(10);
                } else {
                    new Function0<Unit>() { // from class: id.dana.crash.AppExceptionHandler$uncaughtException$1$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
                            uncaughtExceptionHandler = AppExceptionHandler.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            uncaughtExceptionHandler.uncaughtException(p0, p1);
                        }
                    }.invoke();
                    Process.killProcess(Process.myPid());
                    System.exit(10);
                }
            } else {
                new Function0<Unit>() { // from class: id.dana.crash.AppExceptionHandler$uncaughtException$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
                        uncaughtExceptionHandler = AppExceptionHandler.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        uncaughtExceptionHandler.uncaughtException(p0, p1);
                    }
                }.invoke();
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            new Function0<Unit>() { // from class: id.dana.crash.AppExceptionHandler$uncaughtException$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
                    uncaughtExceptionHandler = AppExceptionHandler.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    uncaughtExceptionHandler.uncaughtException(p0, p1);
                }
            }.invoke();
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }

    private static boolean PlaceComponentResult(Throwable p0, Throwable p1) {
        return p1 != null && Intrinsics.areEqual(p0.getClass(), p1.getClass()) && Intrinsics.areEqual(p0.getStackTrace()[0], p1.getStackTrace()[0]) && Intrinsics.areEqual(p0.getMessage(), p1.getMessage());
    }

    private static boolean getAuthRequestContext(Throwable p0) {
        return (p0 instanceof RuntimeException) && (PlaceComponentResult(p0) || BuiltInFictitiousFunctionClassFactory(p0));
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        if (p0 instanceof IllegalStateException) {
            String message = p0.getMessage();
            if (message != null ? StringsKt.contains((CharSequence) message, (CharSequence) "JobScheduler 100 job limit exceeded", true) : false) {
                return true;
            }
        }
        return false;
    }

    private static boolean PlaceComponentResult(Throwable p0) {
        if (p0.getCause() instanceof SecurityException) {
            return true;
        }
        String simpleName = Reflection.getOrCreateKotlinClass(p0.getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = "";
        }
        return StringsKt.contains((CharSequence) simpleName, (CharSequence) "CursorWindowAllocationException", true);
    }
}
