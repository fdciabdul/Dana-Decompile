package androidx.view.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Landroidx/lifecycle/viewmodel/InitializerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "Landroidx/lifecycle/viewmodel/CreationExtras;", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "PlaceComponentResult", "[Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "getAuthRequestContext", "<init>", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ViewModelInitializer<?>[] getAuthRequestContext;

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel BuiltInFictitiousFunctionClassFactory(Class cls) {
        return ViewModelProvider.Factory.CC.getAuthRequestContext(cls);
    }

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        Intrinsics.checkNotNullParameter(viewModelInitializerArr, "");
        this.getAuthRequestContext = viewModelInitializerArr;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final <T extends ViewModel> T MyBillsEntityDataFactory(Class<T> p0, CreationExtras p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        T t = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.getAuthRequestContext) {
            if (Intrinsics.areEqual(viewModelInitializer.KClassImpl$Data$declaredNonStaticMembers$2, p0)) {
                Object invoke = viewModelInitializer.MyBillsEntityDataFactory.invoke(p1);
                t = invoke instanceof ViewModel ? (T) invoke : null;
            }
        }
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No initializer set for given class ");
        sb.append(p0.getName());
        throw new IllegalArgumentException(sb.toString());
    }
}
