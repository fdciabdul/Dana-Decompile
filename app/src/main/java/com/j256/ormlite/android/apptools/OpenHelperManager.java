package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes8.dex */
public class OpenHelperManager {
    private static final String HELPER_CLASS_RESOURCE_NAME = "open_helper_classname";
    public static final byte[] MyBillsEntityDataFactory = {75, -23, 102, -23, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 67;
    private static Logger logger = LoggerFactory.getLogger(OpenHelperManager.class);
    private static Class<? extends OrmLiteSqliteOpenHelper> helperClass = null;
    private static volatile OrmLiteSqliteOpenHelper helper = null;
    private static boolean wasClosed = false;
    private static int instanceCount = 0;

    public static void setOpenHelperClass(Class<? extends OrmLiteSqliteOpenHelper> cls) {
        synchronized (OpenHelperManager.class) {
            if (cls == null) {
                helperClass = null;
            } else {
                innerSetHelperClass(cls);
            }
        }
    }

    public static void setHelper(OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper) {
        synchronized (OpenHelperManager.class) {
            helper = ormLiteSqliteOpenHelper;
        }
    }

    public static <T extends OrmLiteSqliteOpenHelper> T getHelper(Context context, Class<T> cls) {
        T t;
        synchronized (OpenHelperManager.class) {
            if (cls == null) {
                throw new IllegalArgumentException("openHelperClass argument is null");
            }
            innerSetHelperClass(cls);
            t = (T) loadHelper(context, cls);
        }
        return t;
    }

    @Deprecated
    public static OrmLiteSqliteOpenHelper getHelper(Context context) {
        OrmLiteSqliteOpenHelper loadHelper;
        synchronized (OpenHelperManager.class) {
            if (helperClass == null) {
                if (context == null) {
                    throw new IllegalArgumentException("context argument is null");
                }
                innerSetHelperClass(lookupHelperClass(context.getApplicationContext(), context.getClass()));
            }
            loadHelper = loadHelper(context, helperClass);
        }
        return loadHelper;
    }

    public static void releaseHelper() {
        synchronized (OpenHelperManager.class) {
            instanceCount--;
            logger.trace("releasing helper {}, instance count = {}", helper, Integer.valueOf(instanceCount));
            if (instanceCount <= 0) {
                if (helper != null) {
                    logger.trace("zero instances, closing helper {}", helper);
                    helper.close();
                    helper = null;
                    wasClosed = true;
                }
                int i = instanceCount;
                if (i < 0) {
                    logger.error("too many calls to release helper, instance count = {}", Integer.valueOf(i));
                }
            }
        }
    }

    private static void innerSetHelperClass(Class<? extends OrmLiteSqliteOpenHelper> cls) {
        if (cls == null) {
            throw new IllegalStateException("Helper class was trying to be reset to null");
        }
        Class<? extends OrmLiteSqliteOpenHelper> cls2 = helperClass;
        if (cls2 == null) {
            helperClass = cls;
        } else if (cls2 == cls) {
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Helper class was ");
            sb.append(helperClass);
            sb.append(" but is trying to be reset to ");
            sb.append(cls);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static <T extends OrmLiteSqliteOpenHelper> T loadHelper(Context context, Class<T> cls) {
        if (helper == null) {
            if (wasClosed) {
                logger.info("helper was already closed and is being re-opened");
            }
            if (context == null) {
                throw new IllegalArgumentException("context argument is null");
            }
            helper = constructHelper(context.getApplicationContext(), cls);
            logger.trace("zero instances, created helper {}", helper);
            BaseDaoImpl.clearAllInternalObjectCaches();
            DaoManager.clearDaoCache();
            instanceCount = 0;
        }
        instanceCount++;
        logger.trace("returning helper {}, instance count = {} ", helper, Integer.valueOf(instanceCount));
        return (T) helper;
    }

    private static Class<? extends OrmLiteSqliteOpenHelper> lookupHelperClass(Context context, Class<?> cls) {
        Type[] actualTypeArguments;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(HELPER_CLASS_RESOURCE_NAME, "string", context.getPackageName());
        if (identifier != 0) {
            String string = resources.getString(identifier);
            try {
                return Class.forName(string);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not create helper instance for class ");
                sb.append(string);
                throw new IllegalStateException(sb.toString(), e);
            }
        }
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            Type genericSuperclass = cls2.getGenericSuperclass();
            if (genericSuperclass != null && (genericSuperclass instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) != null && actualTypeArguments.length != 0) {
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        Class<? extends OrmLiteSqliteOpenHelper> cls3 = (Class) type;
                        if (OrmLiteSqliteOpenHelper.class.isAssignableFrom(cls3)) {
                            return cls3;
                        }
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not find OpenHelperClass because none of the generic parameters of class ");
        sb2.append(cls);
        sb2.append(" extends OrmLiteSqliteOpenHelper.  You should use getHelper(Context, Class) instead.");
        throw new IllegalStateException(sb2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #1 {Exception -> 0x0065, blocks: (B:3:0x0001, B:7:0x001f, B:9:0x0025, B:16:0x0059), top: B:25:0x0001 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:18:0x005f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper constructHelper(android.content.Context r11, java.lang.Class<? extends com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper> r12) {
        /*
            r0 = 1
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L65
            r2 = 97
            r3 = -1
            byte[] r4 = com.j256.ormlite.android.apptools.OpenHelperManager.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L65
            r5 = 23
            byte[] r5 = new byte[r5]     // Catch: java.lang.Exception -> L65
            r6 = 22
            r7 = 3
            r2 = r1
            if (r4 != 0) goto L19
            r8 = r5
            r3 = 22
            r9 = 3
            r5 = r4
            r4 = -1
            goto L5f
        L19:
            r7 = r5
            r3 = 97
            r8 = 3
            r5 = r4
            r4 = -1
        L1f:
            int r4 = r4 + r0
            byte r9 = (byte) r3     // Catch: java.lang.Exception -> L65
            r7[r4] = r9     // Catch: java.lang.Exception -> L65
            if (r4 != r6) goto L58
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Exception -> L65
            r4 = 0
            r3.<init>(r7, r4)     // Catch: java.lang.Exception -> L65
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L65
            r1[r4] = r3     // Catch: java.lang.Exception -> L65
            java.lang.reflect.Constructor r1 = r12.getConstructor(r2)     // Catch: java.lang.Exception -> L65
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L40
            r0[r4] = r11     // Catch: java.lang.Exception -> L40
            java.lang.Object r11 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L40
            com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper r11 = (com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper) r11     // Catch: java.lang.Exception -> L40
            return r11
        L40:
            r11 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Could not construct instance of helper class "
            r0.append(r1)
            r0.append(r12)
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r12.<init>(r0, r11)
            throw r12
        L58:
            int r8 = r8 + r0
            r9 = r5[r8]     // Catch: java.lang.Exception -> L65
            r10 = r8
            r8 = r7
            r7 = r9
            r9 = r10
        L5f:
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r7 = r8
            r8 = r9
            goto L1f
        L65:
            r11 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Could not find public constructor that has a single (Context) argument for helper class "
            r0.append(r1)
            r0.append(r12)
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r12.<init>(r0, r11)
            goto L7e
        L7d:
            throw r12
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OpenHelperManager.constructHelper(android.content.Context, java.lang.Class):com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper");
    }
}
