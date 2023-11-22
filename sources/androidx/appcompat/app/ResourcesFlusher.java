package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.LongSparseArray;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
class ResourcesFlusher {
    private static Field BuiltInFictitiousFunctionClassFactory;
    private static Field KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;
    private static Class<?> getAuthRequestContext;
    private static boolean getErrorConfigVersion;
    private static Field lookAheadTest;
    private static boolean scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Resources resources) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        Map map = null;
        r3 = null;
        r3 = null;
        Object obj2 = null;
        Object obj3 = null;
        if (Build.VERSION.SDK_INT < 24) {
            if (Build.VERSION.SDK_INT < 23) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (!PlaceComponentResult) {
                        try {
                            Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                            KClassImpl$Data$declaredNonStaticMembers$2 = declaredField;
                            declaredField.setAccessible(true);
                        } catch (NoSuchFieldException e) {
                            InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
                        }
                        PlaceComponentResult = true;
                    }
                    Field field = KClassImpl$Data$declaredNonStaticMembers$2;
                    if (field != null) {
                        try {
                            map = (Map) field.get(resources);
                        } catch (IllegalAccessException e2) {
                            InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                        }
                        if (map != null) {
                            map.clear();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (!PlaceComponentResult) {
                try {
                    Field declaredField2 = Resources.class.getDeclaredField("mDrawableCache");
                    KClassImpl$Data$declaredNonStaticMembers$2 = declaredField2;
                    declaredField2.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e3);
                }
                PlaceComponentResult = true;
            }
            Field field2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (field2 != null) {
                try {
                    obj3 = field2.get(resources);
                } catch (IllegalAccessException e4) {
                    InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e4);
                }
            }
            if (obj3 != null) {
                BuiltInFictitiousFunctionClassFactory(obj3);
                return;
            }
            return;
        }
        if (!MyBillsEntityDataFactory) {
            try {
                Field declaredField3 = Resources.class.getDeclaredField("mResourcesImpl");
                BuiltInFictitiousFunctionClassFactory = declaredField3;
                declaredField3.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e5);
            }
            MyBillsEntityDataFactory = true;
        }
        Field field3 = BuiltInFictitiousFunctionClassFactory;
        if (field3 != null) {
            try {
                obj = field3.get(resources);
            } catch (IllegalAccessException e6) {
                InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e6);
                obj = null;
            }
            if (obj != null) {
                if (!PlaceComponentResult) {
                    try {
                        Field declaredField4 = obj.getClass().getDeclaredField("mDrawableCache");
                        KClassImpl$Data$declaredNonStaticMembers$2 = declaredField4;
                        declaredField4.setAccessible(true);
                    } catch (NoSuchFieldException e7) {
                        InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e7);
                    }
                    PlaceComponentResult = true;
                }
                Field field4 = KClassImpl$Data$declaredNonStaticMembers$2;
                if (field4 != null) {
                    try {
                        obj2 = field4.get(obj);
                    } catch (IllegalAccessException e8) {
                        InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e8);
                    }
                }
                if (obj2 != null) {
                    BuiltInFictitiousFunctionClassFactory(obj2);
                }
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(Object obj) {
        LongSparseArray longSparseArray;
        if (!scheduleImpl) {
            try {
                getAuthRequestContext = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                InstrumentInjector.log_e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            scheduleImpl = true;
        }
        Class<?> cls = getAuthRequestContext;
        if (cls == null) {
            return;
        }
        if (!getErrorConfigVersion) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                lookAheadTest = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            getErrorConfigVersion = true;
        }
        Field field = lookAheadTest;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e3) {
            InstrumentInjector.log_e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            Api16Impl.BuiltInFictitiousFunctionClassFactory(longSparseArray);
        }
    }

    private ResourcesFlusher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }
}
