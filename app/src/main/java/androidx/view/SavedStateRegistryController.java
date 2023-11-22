package androidx.view;

import android.os.Bundle;
import androidx.view.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u0003\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u000b\u0010\u0011"}, d2 = {"Landroidx/savedstate/SavedStateRegistryController;", "", "", "getAuthRequestContext", "()V", "Landroid/os/Bundle;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)V", "", "Z", "BuiltInFictitiousFunctionClassFactory", "Landroidx/savedstate/SavedStateRegistryOwner;", "PlaceComponentResult", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/savedstate/SavedStateRegistry;", "Landroidx/savedstate/SavedStateRegistry;", "()Landroidx/savedstate/SavedStateRegistry;", "MyBillsEntityDataFactory", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateRegistryController {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SavedStateRegistryOwner getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SavedStateRegistry MyBillsEntityDataFactory;

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(savedStateRegistryOwner);
    }

    @JvmStatic
    public static final SavedStateRegistryController BuiltInFictitiousFunctionClassFactory(SavedStateRegistryOwner savedStateRegistryOwner) {
        return Companion.BuiltInFictitiousFunctionClassFactory(savedStateRegistryOwner);
    }

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.getAuthRequestContext = savedStateRegistryOwner;
        this.MyBillsEntityDataFactory = new SavedStateRegistry();
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final SavedStateRegistry getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public final void getAuthRequestContext() {
        Lifecycle lifecycle = this.getAuthRequestContext.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        if (!(lifecycle.PlaceComponentResult() == Lifecycle.State.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.BuiltInFictitiousFunctionClassFactory(new Recreator(this.getAuthRequestContext));
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(lifecycle);
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            getAuthRequestContext();
        }
        Lifecycle lifecycle = this.getAuthRequestContext.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        if ((!lifecycle.PlaceComponentResult().isAtLeast(Lifecycle.State.STARTED)) == false) {
            StringBuilder sb = new StringBuilder();
            sb.append("performRestore cannot be called when owner is ");
            sb.append(lifecycle.PlaceComponentResult());
            throw new IllegalStateException(sb.toString().toString());
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext(p0);
    }

    public final void getAuthRequestContext(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/savedstate/SavedStateRegistryController$Companion;", "", "Landroidx/savedstate/SavedStateRegistryOwner;", "p0", "Landroidx/savedstate/SavedStateRegistryController;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/savedstate/SavedStateRegistryController;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static SavedStateRegistryController BuiltInFictitiousFunctionClassFactory(SavedStateRegistryOwner p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new SavedStateRegistryController(p0, null);
        }
    }
}
