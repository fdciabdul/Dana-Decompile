package androidx.view;

import android.os.Bundle;
import androidx.view.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\t\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f"}, d2 = {"Landroidx/navigation/NavArgsLazy;", "Landroidx/navigation/NavArgs;", "Args", "Lkotlin/Lazy;", "", "isInitialized", "()Z", "Lkotlin/Function0;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Landroidx/navigation/NavArgs;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClass;", "PlaceComponentResult", "p0", "p1", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavArgsLazy<Args extends NavArgs> implements Lazy<Args> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final KClass<Args> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function0<Bundle> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Args KClassImpl$Data$declaredNonStaticMembers$2;

    public NavArgsLazy(KClass<Args> kClass, Function0<Bundle> function0) {
        Intrinsics.checkNotNullParameter(kClass, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = kClass;
        this.BuiltInFictitiousFunctionClassFactory = function0;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != null;
    }

    @Override // kotlin.Lazy
    public final /* synthetic */ Object getValue() {
        Args args = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (args == null) {
            Bundle invoke = this.BuiltInFictitiousFunctionClassFactory.invoke();
            Method method = NavArgsLazyKt.getAuthRequestContext().get(this.PlaceComponentResult);
            if (method == null) {
                Class javaClass = JvmClassMappingKt.getJavaClass((KClass) this.PlaceComponentResult);
                Class<Bundle>[] BuiltInFictitiousFunctionClassFactory = NavArgsLazyKt.BuiltInFictitiousFunctionClassFactory();
                method = javaClass.getMethod("fromBundle", (Class[]) Arrays.copyOf(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.length));
                NavArgsLazyKt.getAuthRequestContext().put(this.PlaceComponentResult, method);
                Intrinsics.checkNotNullExpressionValue(method, "");
            }
            Object invoke2 = method.invoke(null, invoke);
            if (invoke2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
            }
            Args args2 = (Args) invoke2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = args2;
            return args2;
        }
        return args;
    }
}
