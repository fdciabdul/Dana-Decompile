package androidx.view.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0019\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000b\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000eR\u001e\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Landroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder;", "", "Landroidx/lifecycle/ViewModel;", "T", "Lkotlin/reflect/KClass;", "p0", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/ExtensionFunctionType;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "PlaceComponentResult", "Ljava/util/List;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ViewModelFactoryDsl
/* loaded from: classes.dex */
public final class InitializerViewModelFactoryBuilder {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<ViewModelInitializer<?>> MyBillsEntityDataFactory = new ArrayList();

    public final <T extends ViewModel> void BuiltInFictitiousFunctionClassFactory(KClass<T> p0, Function1<? super CreationExtras, ? extends T> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.add(new ViewModelInitializer<>(JvmClassMappingKt.getJavaClass((KClass) p0), p1));
    }

    public final ViewModelProvider.Factory BuiltInFictitiousFunctionClassFactory() {
        Object[] array = this.MyBillsEntityDataFactory.toArray(new ViewModelInitializer[0]);
        if (array != null) {
            ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) array;
            return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
