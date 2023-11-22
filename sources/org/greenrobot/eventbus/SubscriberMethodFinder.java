package org.greenrobot.eventbus;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
    private static final FindState[] FIND_STATE_POOL = new FindState[4];

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscriberMethodFinder(List<SubscriberInfoIndex> list, boolean z, boolean z2) {
        this.subscriberInfoIndexes = list;
        this.strictMethodVerification = z;
        this.ignoreGeneratedIndex = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SubscriberMethod> findSubscriberMethods(Class<?> cls) {
        List<SubscriberMethod> findUsingInfo;
        Map<Class<?>, List<SubscriberMethod>> map = METHOD_CACHE;
        List<SubscriberMethod> list = map.get(cls);
        if (list != null) {
            return list;
        }
        if (this.ignoreGeneratedIndex) {
            findUsingInfo = findUsingReflection(cls);
        } else {
            findUsingInfo = findUsingInfo(cls);
        }
        if (findUsingInfo.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Subscriber ");
            sb.append(cls);
            sb.append(" and its super classes have no public methods with the @Subscribe annotation");
            throw new EventBusException(sb.toString());
        }
        map.put(cls, findUsingInfo);
        return findUsingInfo;
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> cls) {
        FindState prepareFindState = prepareFindState();
        prepareFindState.initForSubscriber(cls);
        while (prepareFindState.clazz != null) {
            prepareFindState.subscriberInfo = getSubscriberInfo(prepareFindState);
            if (prepareFindState.subscriberInfo != null) {
                for (SubscriberMethod subscriberMethod : prepareFindState.subscriberInfo.getSubscriberMethods()) {
                    if (prepareFindState.checkAdd(subscriberMethod.method, subscriberMethod.eventType)) {
                        prepareFindState.subscriberMethods.add(subscriberMethod);
                    }
                }
            } else {
                findUsingReflectionInSingleClass(prepareFindState);
            }
            prepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(prepareFindState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        r3[r2] = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<org.greenrobot.eventbus.SubscriberMethod> getMethodsAndRelease(org.greenrobot.eventbus.SubscriberMethodFinder.FindState r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<org.greenrobot.eventbus.SubscriberMethod> r1 = r6.subscriberMethods
            r0.<init>(r1)
            r6.recycle()
            org.greenrobot.eventbus.SubscriberMethodFinder$FindState[] r1 = org.greenrobot.eventbus.SubscriberMethodFinder.FIND_STATE_POOL
            monitor-enter(r1)
            r2 = 0
        Le:
            r3 = 4
            if (r2 >= r3) goto L20
            org.greenrobot.eventbus.SubscriberMethodFinder$FindState[] r3 = org.greenrobot.eventbus.SubscriberMethodFinder.FIND_STATE_POOL     // Catch: java.lang.Throwable -> L1d
            r4 = r3[r2]     // Catch: java.lang.Throwable -> L1d
            if (r4 != 0) goto L1a
            r3[r2] = r6     // Catch: java.lang.Throwable -> L1d
            goto L20
        L1a:
            int r2 = r2 + 1
            goto Le
        L1d:
            r6 = move-exception
            monitor-exit(r1)
            throw r6
        L20:
            monitor-exit(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.SubscriberMethodFinder.getMethodsAndRelease(org.greenrobot.eventbus.SubscriberMethodFinder$FindState):java.util.List");
    }

    private FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            for (int i = 0; i < 4; i++) {
                FindState[] findStateArr = FIND_STATE_POOL;
                FindState findState = findStateArr[i];
                if (findState != null) {
                    findStateArr[i] = null;
                    return findState;
                }
            }
            return new FindState();
        }
    }

    private SubscriberInfo getSubscriberInfo(FindState findState) {
        if (findState.subscriberInfo != null && findState.subscriberInfo.getSuperSubscriberInfo() != null) {
            SubscriberInfo superSubscriberInfo = findState.subscriberInfo.getSuperSubscriberInfo();
            if (findState.clazz == superSubscriberInfo.getSubscriberClass()) {
                return superSubscriberInfo;
            }
        }
        List<SubscriberInfoIndex> list = this.subscriberInfoIndexes;
        if (list != null) {
            Iterator<SubscriberInfoIndex> it = list.iterator();
            while (it.hasNext()) {
                SubscriberInfo subscriberInfo = it.next().getSubscriberInfo(findState.clazz);
                if (subscriberInfo != null) {
                    return subscriberInfo;
                }
            }
            return null;
        }
        return null;
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> cls) {
        FindState prepareFindState = prepareFindState();
        prepareFindState.initForSubscriber(cls);
        while (prepareFindState.clazz != null) {
            findUsingReflectionInSingleClass(prepareFindState);
            prepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(prepareFindState);
    }

    private void findUsingReflectionInSingleClass(FindState findState) {
        String obj;
        Method[] methods;
        try {
            try {
                methods = findState.clazz.getDeclaredMethods();
            } catch (Throwable unused) {
                methods = findState.clazz.getMethods();
                findState.skipSuperClasses = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        Subscribe subscribe = (Subscribe) method.getAnnotation(Subscribe.class);
                        if (subscribe != null) {
                            Class<?> cls = parameterTypes[0];
                            if (findState.checkAdd(method, cls)) {
                                findState.subscriberMethods.add(new SubscriberMethod(method, cls, subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
                            }
                        }
                    } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(method.getDeclaringClass().getName());
                        sb.append(".");
                        sb.append(method.getName());
                        String obj2 = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("@Subscribe method ");
                        sb2.append(obj2);
                        sb2.append("must have exactly 1 parameter but has ");
                        sb2.append(parameterTypes.length);
                        throw new EventBusException(sb2.toString());
                    }
                } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(method.getDeclaringClass().getName());
                    sb3.append(".");
                    sb3.append(method.getName());
                    String obj3 = sb3.toString();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(obj3);
                    sb4.append(" is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                    throw new EventBusException(sb4.toString());
                }
            }
        } catch (LinkageError e) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Could not inspect methods of ");
            sb5.append(findState.clazz.getName());
            String obj4 = sb5.toString();
            if (this.ignoreGeneratedIndex) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(obj4);
                sb6.append(". Please consider using EventBus annotation processor to avoid reflection.");
                obj = sb6.toString();
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(obj4);
                sb7.append(". Please make this class visible to EventBus annotation processor to avoid reflection.");
                obj = sb7.toString();
            }
            throw new EventBusException(obj, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearCaches() {
        METHOD_CACHE.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class FindState {
        Class<?> clazz;
        boolean skipSuperClasses;
        Class<?> subscriberClass;
        SubscriberInfo subscriberInfo;
        final List<SubscriberMethod> subscriberMethods = new ArrayList();
        final Map<Class, Object> anyMethodByEventType = new HashMap();
        final Map<String, Class> subscriberClassByMethodKey = new HashMap();
        final StringBuilder methodKeyBuilder = new StringBuilder(128);

        FindState() {
        }

        void initForSubscriber(Class<?> cls) {
            this.clazz = cls;
            this.subscriberClass = cls;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        boolean checkAdd(Method method, Class<?> cls) {
            Object put = this.anyMethodByEventType.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!checkAddWithMethodSignature((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.anyMethodByEventType.put(cls, this);
            }
            return checkAddWithMethodSignature(method, cls);
        }

        private boolean checkAddWithMethodSignature(Method method, Class<?> cls) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            StringBuilder sb = this.methodKeyBuilder;
            sb.append(Typography.greater);
            sb.append(cls.getName());
            String obj = this.methodKeyBuilder.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.subscriberClassByMethodKey.put(obj, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(obj, put);
            return false;
        }

        void moveToSuperclass() {
            if (!this.skipSuperClasses) {
                Class<? super Object> superclass = this.clazz.getSuperclass();
                this.clazz = superclass;
                String name = superclass.getName();
                if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.") && !name.startsWith("androidx.")) {
                    return;
                }
            }
            this.clazz = null;
        }
    }
}
