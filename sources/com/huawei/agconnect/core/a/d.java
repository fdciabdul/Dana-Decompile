package com.huawei.agconnect.core.a;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public final class d {
    private Map<Class<?>, Service> getAuthRequestContext = new HashMap();
    private Map<Class<?>, Object> getErrorConfigVersion = new HashMap();
    public static final byte[] PlaceComponentResult = {119, -93, -18, -42, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 235;
    private static Map<Class<?>, Service> BuiltInFictitiousFunctionClassFactory = new HashMap();
    private static Map<Class<?>, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<Service> list, Context context) {
        BuiltInFictitiousFunctionClassFactory(list, context);
    }

    private static void BuiltInFictitiousFunctionClassFactory(String str, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Instantiate shared service ");
        sb.append(str);
        sb.append(exc.getLocalizedMessage());
        InstrumentInjector.log_e("ServiceRepository", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cause message:");
        sb2.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        InstrumentInjector.log_e("ServiceRepository", sb2.toString());
    }

    private static Constructor MyBillsEntityDataFactory(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[0] == clsArr[0];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r9) {
        /*
            byte[] r0 = com.huawei.agconnect.core.a.d.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 97
            r4 = 3
            r5 = 0
            if (r0 != 0) goto Lf
            r6 = 3
            r7 = 0
            goto L27
        Lf:
            r6 = 0
        L10:
            byte r7 = (byte) r3
            int r4 = r4 + 1
            r2[r6] = r7
            int r6 = r6 + 1
            if (r6 != r1) goto L21
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2, r5)
            r9[r5] = r0
            return
        L21:
            r7 = r0[r4]
            r8 = r6
            r6 = r4
            r4 = r7
            r7 = r8
        L27:
            int r4 = -r4
            int r3 = r3 + r4
            int r3 = r3 + (-8)
            r4 = r6
            r6 = r7
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.a(java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c A[Catch: InvocationTargetException -> 0x0073, InstantiationException -> 0x0077, IllegalAccessException -> 0x007b, TryCatch #2 {IllegalAccessException -> 0x007b, InstantiationException -> 0x0077, InvocationTargetException -> 0x0073, blocks: (B:20:0x0041, B:22:0x005c, B:24:0x006b, B:23:0x0065), top: B:34:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: InvocationTargetException -> 0x0073, InstantiationException -> 0x0077, IllegalAccessException -> 0x007b, TryCatch #2 {IllegalAccessException -> 0x007b, InstantiationException -> 0x0077, InvocationTargetException -> 0x0073, blocks: (B:20:0x0041, B:22:0x005c, B:24:0x006b, B:23:0x0065), top: B:34:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(java.util.List<com.huawei.agconnect.core.Service> r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L3
            return
        L3:
            java.util.Iterator r7 = r7.iterator()
        L7:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L82
            java.lang.Object r0 = r7.next()
            com.huawei.agconnect.core.Service r0 = (com.huawei.agconnect.core.Service) r0
            boolean r1 = r0.PlaceComponentResult()
            if (r1 == 0) goto L26
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = com.huawei.agconnect.core.a.d.BuiltInFictitiousFunctionClassFactory
            java.lang.Class<?> r2 = r0.getAuthRequestContext
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L2d
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = com.huawei.agconnect.core.a.d.BuiltInFictitiousFunctionClassFactory
            goto L28
        L26:
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = r6.getAuthRequestContext
        L28:
            java.lang.Class<?> r2 = r0.getAuthRequestContext
            r1.put(r2, r0)
        L2d:
            boolean r1 = r0.MyBillsEntityDataFactory()
            if (r1 == 0) goto L7
            java.lang.Class<?> r1 = r0.MyBillsEntityDataFactory
            if (r1 == 0) goto L7
            java.util.Map<java.lang.Class<?>, java.lang.Object> r1 = com.huawei.agconnect.core.a.d.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Class<?> r2 = r0.getAuthRequestContext
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L7
            java.lang.Class<?> r1 = r0.MyBillsEntityDataFactory     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            a(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            r3[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.reflect.Constructor r1 = MyBillsEntityDataFactory(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            if (r1 == 0) goto L65
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            r2[r5] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.Object r1 = r1.newInstance(r2)     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            goto L6b
        L65:
            java.lang.Class<?> r1 = r0.MyBillsEntityDataFactory     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
        L6b:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = com.huawei.agconnect.core.a.d.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            java.lang.Class<?> r0 = r0.getAuthRequestContext     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            r2.put(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L73 java.lang.InstantiationException -> L77 java.lang.IllegalAccessException -> L7b
            goto L7
        L73:
            r0 = move-exception
            java.lang.String r1 = "TargetException"
            goto L7e
        L77:
            r0 = move-exception
            java.lang.String r1 = "InstantiationException"
            goto L7e
        L7b:
            r0 = move-exception
            java.lang.String r1 = "AccessException"
        L7e:
            BuiltInFictitiousFunctionClassFactory(r1, r0)
            goto L7
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.BuiltInFictitiousFunctionClassFactory(java.util.List, android.content.Context):void");
    }
}
