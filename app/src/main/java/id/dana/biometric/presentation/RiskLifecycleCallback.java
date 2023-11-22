package id.dana.biometric.presentation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\nR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/biometric/presentation/RiskLifecycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "p0", "Landroid/os/Bundle;", "p1", "", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "PlaceComponentResult", "Landroid/app/Activity;", "p2", "p3", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RiskLifecycleCallback implements Application.ActivityLifecycleCallbacks {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<Unit> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function0<Unit> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Activity MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    public RiskLifecycleCallback(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Activity activity) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function03, "");
        this.getAuthRequestContext = function0;
        this.PlaceComponentResult = function02;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function03;
        this.MyBillsEntityDataFactory = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity p0) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(p0, "");
        Activity activity = this.MyBillsEntityDataFactory;
        if (Intrinsics.areEqual((activity == null || (cls = activity.getClass()) == null) ? null : cls.getSimpleName(), p0.getClass().getSimpleName())) {
            this.getAuthRequestContext.invoke();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity p0) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(p0, "");
        Activity activity = this.MyBillsEntityDataFactory;
        if (Intrinsics.areEqual((activity == null || (cls = activity.getClass()) == null) ? null : cls.getSimpleName(), p0.getClass().getSimpleName())) {
            this.PlaceComponentResult.invoke();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity p0) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(p0, "");
        Activity activity = this.MyBillsEntityDataFactory;
        if (Intrinsics.areEqual((activity == null || (cls = activity.getClass()) == null) ? null : cls.getSimpleName(), p0.getClass().getSimpleName())) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
        }
    }
}
