package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class BundleCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class BeforeApi18Impl {
        private static boolean BuiltInFictitiousFunctionClassFactory;
        private static Method KClassImpl$Data$declaredNonStaticMembers$2;
        private static boolean MyBillsEntityDataFactory;
        private static Method PlaceComponentResult;

        private BeforeApi18Impl() {
        }

        public static IBinder KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle, String str) {
            if (!BuiltInFictitiousFunctionClassFactory) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    KClassImpl$Data$declaredNonStaticMembers$2 = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    InstrumentInjector.log_i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                BuiltInFictitiousFunctionClassFactory = true;
            }
            Method method2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    InstrumentInjector.log_i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
            }
            return null;
        }

        public static void BuiltInFictitiousFunctionClassFactory(Bundle bundle, String str, IBinder iBinder) {
            if (!MyBillsEntityDataFactory) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    PlaceComponentResult = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    InstrumentInjector.log_i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                MyBillsEntityDataFactory = true;
            }
            Method method2 = PlaceComponentResult;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    InstrumentInjector.log_i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    PlaceComponentResult = null;
                }
            }
        }
    }

    private BundleCompat() {
    }

    public static IBinder BuiltInFictitiousFunctionClassFactory(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.BuiltInFictitiousFunctionClassFactory(bundle, str);
        }
        return BeforeApi18Impl.KClassImpl$Data$declaredNonStaticMembers$2(bundle, str);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.MyBillsEntityDataFactory(bundle, str, iBinder);
        } else {
            BeforeApi18Impl.BuiltInFictitiousFunctionClassFactory(bundle, str, iBinder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api18Impl {
        private Api18Impl() {
        }

        static IBinder BuiltInFictitiousFunctionClassFactory(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        static void MyBillsEntityDataFactory(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }
}
