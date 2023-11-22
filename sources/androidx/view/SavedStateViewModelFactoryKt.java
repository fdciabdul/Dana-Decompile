package androidx.view;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a=\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aK\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\u0000*\u0004\u0018\u00010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\"\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e\"\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"T", "Ljava/lang/Class;", "p0", "", "p1", "Ljava/lang/reflect/Constructor;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/ViewModel;", "", "", "p2", "getAuthRequestContext", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "Ljava/util/List;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SavedStateViewModelFactoryKt {
    private static final List<Class<?>> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.listOf((Object[]) new Class[]{Application.class, SavedStateHandle.class});
    private static final List<Class<?>> getAuthRequestContext = CollectionsKt.listOf(SavedStateHandle.class);

    public static final <T extends ViewModel> T getAuthRequestContext(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(constructor, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to access ");
            sb.append(cls);
            throw new RuntimeException(sb.toString(), e);
        } catch (InstantiationException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("A ");
            sb2.append(cls);
            sb2.append(" cannot be instantiated.");
            throw new RuntimeException(sb2.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("An exception happened in constructor of ");
            sb3.append(cls);
            throw new RuntimeException(sb3.toString(), e3.getCause());
        }
    }

    public static final <T> Constructor<T> KClassImpl$Data$declaredNonStaticMembers$2(Class<T> cls, List<? extends Class<?>> list) {
        Intrinsics.checkNotNullParameter(cls, "");
        Intrinsics.checkNotNullParameter(list, "");
        Constructor<?>[] constructors = cls.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "");
        for (Constructor<?> constructor : constructors) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "");
            List list2 = ArraysKt.toList(parameterTypes);
            if (Intrinsics.areEqual(list, list2)) {
                if (constructor2 != null) {
                    return constructor2;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
            } else if (list.size() == list2.size() && list2.containsAll(list)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Class ");
                sb.append(cls.getSimpleName());
                sb.append(" must have parameters in the proper order: ");
                sb.append(list);
                throw new UnsupportedOperationException(sb.toString());
            }
        }
        return null;
    }
}
