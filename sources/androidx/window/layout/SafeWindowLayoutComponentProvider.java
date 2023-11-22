package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import j$.util.function.Consumer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0002J \u0010\u001a\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u001b\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u001c\u001a\u0012\u0012\u0002\b\u0003 \u0012*\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001d\u001a\u00020\n*\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u0018\u0010\u001d\u001a\u00020\n*\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f¨\u0006 "}, d2 = {"Landroidx/window/layout/SafeWindowLayoutComponentProvider;", "", "()V", "windowLayoutComponent", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "getWindowLayoutComponent", "()Landroidx/window/extensions/layout/WindowLayoutComponent;", "windowLayoutComponent$delegate", "Lkotlin/Lazy;", "isPublic", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)Z", "canUseWindowLayoutComponent", "classLoader", "Ljava/lang/ClassLoader;", "foldingFeatureClass", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "isFoldingFeatureValid", "isWindowExtensionsValid", "isWindowLayoutComponentValid", "isWindowLayoutProviderValid", HummerConstants.HUMMER_VALIDATE, "block", "Lkotlin/Function0;", "windowExtensionsClass", "windowExtensionsProviderClass", "windowLayoutComponentClass", "doesReturn", "clazz", "Lkotlin/reflect/KClass;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider MyBillsEntityDataFactory = new SafeWindowLayoutComponentProvider();
    private static final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<WindowLayoutComponent>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$windowLayoutComponent$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WindowLayoutComponent invoke() {
            boolean BuiltInFictitiousFunctionClassFactory;
            ClassLoader classLoader = SafeWindowLayoutComponentProvider.class.getClassLoader();
            if (classLoader != null) {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                BuiltInFictitiousFunctionClassFactory = SafeWindowLayoutComponentProvider.BuiltInFictitiousFunctionClassFactory(classLoader);
                if (BuiltInFictitiousFunctionClassFactory) {
                    try {
                        return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
                    } catch (UnsupportedOperationException unused) {
                    }
                }
            }
            return null;
        }
    });

    private SafeWindowLayoutComponentProvider() {
    }

    public static WindowLayoutComponent BuiltInFictitiousFunctionClassFactory() {
        return (WindowLayoutComponent) getAuthRequestContext.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean BuiltInFictitiousFunctionClassFactory(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && moveToNextValue(classLoader) && NetworkUserEntityData$$ExternalSyntheticLambda0(classLoader) && scheduleImpl(classLoader) && lookAheadTest(classLoader);
    }

    private static boolean moveToNextValue(final ClassLoader classLoader) {
        return MyBillsEntityDataFactory(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class loadClass;
                Class loadClass2;
                boolean authRequestContext;
                boolean PlaceComponentResult;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                loadClass = classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                boolean z = false;
                Method declaredMethod = loadClass.getDeclaredMethod("getWindowExtensions", new Class[0]);
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                loadClass2 = classLoader.loadClass("androidx.window.extensions.WindowExtensions");
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(declaredMethod, "");
                Intrinsics.checkNotNullExpressionValue(loadClass2, "");
                authRequestContext = SafeWindowLayoutComponentProvider.getAuthRequestContext(declaredMethod, loadClass2);
                if (authRequestContext) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider4 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                    PlaceComponentResult = SafeWindowLayoutComponentProvider.PlaceComponentResult(declaredMethod);
                    if (PlaceComponentResult) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0(final ClassLoader classLoader) {
        return MyBillsEntityDataFactory(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class loadClass;
                Class loadClass2;
                boolean PlaceComponentResult;
                boolean authRequestContext;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                loadClass = classLoader.loadClass("androidx.window.extensions.WindowExtensions");
                boolean z = false;
                Method method = loadClass.getMethod("getWindowLayoutComponent", new Class[0]);
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                loadClass2 = classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(method, "");
                PlaceComponentResult = SafeWindowLayoutComponentProvider.PlaceComponentResult(method);
                if (PlaceComponentResult) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider4 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(loadClass2, "");
                    authRequestContext = SafeWindowLayoutComponentProvider.getAuthRequestContext(method, loadClass2);
                    if (authRequestContext) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private static boolean lookAheadTest(final ClassLoader classLoader) {
        return MyBillsEntityDataFactory(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class loadClass;
                boolean BuiltInFictitiousFunctionClassFactory;
                boolean PlaceComponentResult;
                boolean BuiltInFictitiousFunctionClassFactory2;
                boolean PlaceComponentResult2;
                boolean BuiltInFictitiousFunctionClassFactory3;
                boolean PlaceComponentResult3;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                loadClass = classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
                boolean z = false;
                Method method = loadClass.getMethod("getBounds", new Class[0]);
                Method method2 = loadClass.getMethod("getType", new Class[0]);
                Method method3 = loadClass.getMethod("getState", new Class[0]);
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(method, "");
                BuiltInFictitiousFunctionClassFactory = SafeWindowLayoutComponentProvider.BuiltInFictitiousFunctionClassFactory(method, Reflection.getOrCreateKotlinClass(Rect.class));
                if (BuiltInFictitiousFunctionClassFactory) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                    PlaceComponentResult = SafeWindowLayoutComponentProvider.PlaceComponentResult(method);
                    if (PlaceComponentResult) {
                        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider4 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                        Intrinsics.checkNotNullExpressionValue(method2, "");
                        BuiltInFictitiousFunctionClassFactory2 = SafeWindowLayoutComponentProvider.BuiltInFictitiousFunctionClassFactory(method2, Reflection.getOrCreateKotlinClass(Integer.TYPE));
                        if (BuiltInFictitiousFunctionClassFactory2) {
                            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider5 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                            PlaceComponentResult2 = SafeWindowLayoutComponentProvider.PlaceComponentResult(method2);
                            if (PlaceComponentResult2) {
                                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider6 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                                Intrinsics.checkNotNullExpressionValue(method3, "");
                                BuiltInFictitiousFunctionClassFactory3 = SafeWindowLayoutComponentProvider.BuiltInFictitiousFunctionClassFactory(method3, Reflection.getOrCreateKotlinClass(Integer.TYPE));
                                if (BuiltInFictitiousFunctionClassFactory3) {
                                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider7 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                                    PlaceComponentResult3 = SafeWindowLayoutComponentProvider.PlaceComponentResult(method3);
                                    if (PlaceComponentResult3) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private static boolean scheduleImpl(final ClassLoader classLoader) {
        return MyBillsEntityDataFactory(new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Class loadClass;
                boolean PlaceComponentResult;
                boolean PlaceComponentResult2;
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                loadClass = classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                boolean z = false;
                Method method = loadClass.getMethod("addWindowLayoutInfoListener", Activity.class, Consumer.class);
                Method method2 = loadClass.getMethod("removeWindowLayoutInfoListener", Consumer.class);
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(method, "");
                PlaceComponentResult = SafeWindowLayoutComponentProvider.PlaceComponentResult(method);
                if (PlaceComponentResult) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(method2, "");
                    PlaceComponentResult2 = SafeWindowLayoutComponentProvider.PlaceComponentResult(method2);
                    if (PlaceComponentResult2) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private static boolean MyBillsEntityDataFactory(Function0<Boolean> function0) {
        try {
            return function0.invoke().booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean BuiltInFictitiousFunctionClassFactory(Method method, KClass<?> kClass) {
        return getAuthRequestContext(method, JvmClassMappingKt.getJavaClass((KClass) kClass));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getAuthRequestContext(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
