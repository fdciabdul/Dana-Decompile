package kotlinx.coroutines.internal;

import android.view.ViewConfiguration;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import id.dana.data.constant.BranchLinkConstant;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0011\u0010\rJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "S", "", "name", "Ljava/lang/ClassLoader;", "loader", "Ljava/lang/Class;", "service", "getProviderInstance", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "", "load", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "loadMainDispatcherFactory$kotlinx_coroutines_core", "()Ljava/util/List;", "loadProviders$kotlinx_coroutines_core", "Ljava/net/URL;", "url", "parse", "(Ljava/net/URL;)Ljava/util/List;", "Ljava/io/BufferedReader;", BranchLinkConstant.PayloadKey.REFERRAL, "parseFile", "(Ljava/io/BufferedReader;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FastServiceLoader {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final FastServiceLoader INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int PlaceComponentResult = 1;
    private static long getAuthRequestContext;

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new FastServiceLoader();
        try {
            int i = PlaceComponentResult + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void MyBillsEntityDataFactory() {
        getAuthRequestContext = 690927801413188030L;
    }

    private FastServiceLoader() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if ((!kotlinx.coroutines.internal.FastServiceLoaderKt.getANDROID_DETECTED() ? 'H' : '*') != 'H') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if ((!kotlinx.coroutines.internal.FastServiceLoaderKt.getANDROID_DETECTED() ? 17 : 'D') != 17) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        r0 = new java.util.ArrayList(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r5 = (kotlinx.coroutines.internal.MainDispatcherFactory) kotlinx.coroutines.internal.MainDispatcherFactory.class.cast(java.lang.Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
    
        return load(kotlinx.coroutines.internal.MainDispatcherFactory.class, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ac, code lost:
    
        return load(kotlinx.coroutines.internal.MainDispatcherFactory.class, kotlinx.coroutines.internal.MainDispatcherFactory.class.getClassLoader());
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084 A[Catch: all -> 0x0093, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0093, blocks: (B:21:0x0031, B:23:0x0038, B:27:0x005c, B:28:0x005f, B:32:0x0084, B:34:0x0090), top: B:46:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<kotlinx.coroutines.internal.MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        /*
            r8 = this;
            int r0 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 3
            int r1 = r0 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            if (r0 != 0) goto L22
            boolean r0 = kotlinx.coroutines.internal.FastServiceLoaderKt.getANDROID_DETECTED()     // Catch: java.lang.Exception -> Lad
            r3 = 97
            int r3 = r3 / r2
            r3 = 72
            if (r0 != 0) goto L1b
            r0 = 72
            goto L1d
        L1b:
            r0 = 42
        L1d:
            if (r0 == r3) goto La0
            goto L31
        L20:
            r0 = move-exception
            throw r0
        L22:
            boolean r0 = kotlinx.coroutines.internal.FastServiceLoaderKt.getANDROID_DETECTED()     // Catch: java.lang.Exception -> Lad
            r3 = 17
            if (r0 != 0) goto L2d
            r0 = 17
            goto L2f
        L2d:
            r0 = 68
        L2f:
            if (r0 == r3) goto La0
        L31:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L93
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L93
            r3 = 0
            r4 = 1
            java.lang.String r5 = "kotlinx.coroutines.android.AndroidDispatcherFactory"
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r6 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            java.lang.Class r5 = java.lang.Class.forName(r5, r4, r6)     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r7 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.reflect.Constructor r5 = r5.getDeclaredConstructor(r6)     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            java.lang.Object r5 = r5.newInstance(r6)     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            java.lang.Object r5 = r7.cast(r5)     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            kotlinx.coroutines.internal.MainDispatcherFactory r5 = (kotlinx.coroutines.internal.MainDispatcherFactory) r5     // Catch: java.lang.ClassNotFoundException -> L59 java.lang.Throwable -> L93
            goto L5a
        L59:
            r5 = r3
        L5a:
            if (r5 == 0) goto L5f
            r0.add(r5)     // Catch: java.lang.Throwable -> L93
        L5f:
            java.lang.String r5 = "kotlinx.coroutines.test.internal.TestMainDispatcherFactory"
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r6 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            java.lang.Class r4 = java.lang.Class.forName(r5, r4, r6)     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r6 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r5)     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            java.lang.Object r2 = r4.newInstance(r2)     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            java.lang.Object r2 = r6.cast(r2)     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            kotlinx.coroutines.internal.MainDispatcherFactory r2 = (kotlinx.coroutines.internal.MainDispatcherFactory) r2     // Catch: java.lang.ClassNotFoundException -> L81 java.lang.Throwable -> L93
            r3 = r2
            goto L82
        L81:
        L82:
            if (r3 == 0) goto L90
            r0.add(r3)     // Catch: java.lang.Throwable -> L93
            int r2 = kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult
            int r2 = r2 + 105
            int r3 = r2 % 128
            kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % r1
        L90:
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L93
            goto L9f
        L93:
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r0 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r1 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.util.List r0 = r8.load(r0, r1)
        L9f:
            return r0
        La0:
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r0 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r1 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.util.List r0 = r8.load(r0, r1)
            return r0
        Lad:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.loadMainDispatcherFactory$kotlinx_coroutines_core():java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Class, java.lang.Class<S>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List<S>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    private final <S> List<S> load(Class<S> service, ClassLoader loader) {
        int i = PlaceComponentResult + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        try {
            if ((i % 2 != 0 ? 'F' : '\b') != '\b') {
                List<S> loadProviders$kotlinx_coroutines_core = loadProviders$kotlinx_coroutines_core(service, loader);
                ?? r4 = 0;
                int length = r4.length;
                service = loadProviders$kotlinx_coroutines_core;
            } else {
                service = loadProviders$kotlinx_coroutines_core(service, loader);
            }
            int i2 = PlaceComponentResult + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            loader = i2 % 2;
            return (List<S>) service;
        } catch (Throwable unused) {
            return CollectionsKt.toList(ServiceLoader.load(service, loader));
        }
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> service, ClassLoader loader) {
        Object[] objArr;
        StringBuilder sb = new StringBuilder();
        sb.append("META-INF/services/");
        sb.append(service.getName());
        ArrayList list = Collections.list(loader.getResources(sb.toString()));
        Intrinsics.checkNotNullExpressionValue(list, "");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            try {
                objArr = null;
                if (!it.hasNext()) {
                    break;
                }
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 61;
                try {
                    PlaceComponentResult = i % 128;
                    if (i % 2 == 0) {
                        CollectionsKt.addAll(arrayList, INSTANCE.parse((URL) it.next()));
                        int length = objArr.length;
                    } else {
                        CollectionsKt.addAll(arrayList, INSTANCE.parse((URL) it.next()));
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        if ((!set.isEmpty()) == true) {
            Set set2 = set;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
            Iterator it2 = set2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(INSTANCE.getProviderInstance((String) it2.next(), loader, service));
            }
            ArrayList arrayList3 = arrayList2;
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 39;
            PlaceComponentResult = i2 % 128;
            if (i2 % 2 == 0) {
                int length2 = objArr.length;
                return arrayList3;
            }
            return arrayList3;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if ((!r6.isAssignableFrom(r4)) != true) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r4 = r6.cast(r4.getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]));
        r5 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if ((r5 % 2) != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        r5 = 89 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        r5 = new java.lang.StringBuilder();
        r5.append("Expected service of class ");
        r5.append(r6);
        r5.append(", but found ");
        r5.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        throw new java.lang.IllegalArgumentException(r5.toString().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if ((r6.isAssignableFrom(r4)) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <S> S getProviderInstance(java.lang.String r4, java.lang.ClassLoader r5, java.lang.Class<S> r6) {
        /*
            r3 = this;
            int r0 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 != 0) goto L1c
            java.lang.Class r4 = java.lang.Class.forName(r4, r1, r5)
            boolean r5 = r6.isAssignableFrom(r4)
            if (r5 == 0) goto L18
            goto L19
        L18:
            r1 = 0
        L19:
            if (r1 == 0) goto L4e
            goto L2b
        L1c:
            java.lang.Class r4 = java.lang.Class.forName(r4, r2, r5)
            boolean r5 = r6.isAssignableFrom(r4)
            if (r5 == 0) goto L28
            r5 = 0
            goto L29
        L28:
            r5 = 1
        L29:
            if (r5 == r1) goto L4e
        L2b:
            java.lang.Class[] r5 = new java.lang.Class[r2]
            java.lang.reflect.Constructor r4 = r4.getDeclaredConstructor(r5)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.Object r4 = r4.newInstance(r5)
            java.lang.Object r4 = r6.cast(r4)
            int r5 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 103
            int r6 = r5 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L4d
            r5 = 89
            int r5 = r5 / r2
            return r4
        L4b:
            r4 = move-exception
            throw r4
        L4d:
            return r4
        L4e:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Expected service of class "
            r5.append(r0)
            r5.append(r6)
            java.lang.String r6 = ", but found "
            r5.append(r6)
            r5.append(r4)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.getProviderInstance(java.lang.String, java.lang.ClassLoader, java.lang.Class):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if ((r6 != ' ' ? 29 : 'V') != 'V') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        if ((r6 != '.' ? 18 : '?') != '?') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        if (java.lang.Character.isJavaIdentifierPart(r6) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        r6 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r6 % 128;
        r6 = r6 % 2;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        if (r6 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        r5 = kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult + 95;
        kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<java.lang.String> parseFile(java.io.BufferedReader r11) {
        /*
            r10 = this;
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Set r0 = (java.util.Set) r0
            int r1 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lc2
            int r1 = r1 + 35
            int r2 = r1 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r2     // Catch: java.lang.Exception -> Lc2
            r2 = 2
            int r1 = r1 % r2
        L11:
            java.lang.String r1 = r11.readLine()     // Catch: java.lang.Exception -> Lc2
            if (r1 != 0) goto L1e
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch: java.lang.Exception -> Lc2
            java.util.List r11 = kotlin.collections.CollectionsKt.toList(r0)     // Catch: java.lang.Exception -> Lc2
            return r11
        L1e:
            r3 = 0
            java.lang.String r4 = "#"
            java.lang.String r1 = kotlin.text.StringsKt.substringBefore$default(r1, r4, r3, r2, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 0
        L34:
            int r6 = r3.length()
            r7 = 1
            if (r5 >= r6) goto L96
            int r6 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 115
            int r8 = r6 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r8
            int r6 = r6 % r2
            if (r6 != 0) goto L58
            char r6 = r3.charAt(r5)
            r8 = 32
            r9 = 86
            if (r6 == r8) goto L53
            r8 = 29
            goto L55
        L53:
            r8 = 86
        L55:
            if (r8 == r9) goto L7c
            goto L69
        L58:
            char r6 = r3.charAt(r5)
            r8 = 46
            r9 = 63
            if (r6 == r8) goto L65
            r8 = 18
            goto L67
        L65:
            r8 = 63
        L67:
            if (r8 == r9) goto L7c
        L69:
            boolean r6 = java.lang.Character.isJavaIdentifierPart(r6)     // Catch: java.lang.Exception -> L7a
            if (r6 != 0) goto L7c
            int r6 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 121
            int r8 = r6 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r8
            int r6 = r6 % r2
            r6 = 0
            goto L7d
        L7a:
            r11 = move-exception
            throw r11
        L7c:
            r6 = 1
        L7d:
            if (r6 != 0) goto L8a
            int r5 = kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult
            int r5 = r5 + 95
            int r6 = r5 % 128
            kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % r2
            r5 = 0
            goto L97
        L8a:
            int r5 = r5 + 1
            int r6 = kotlinx.coroutines.internal.FastServiceLoader.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 79
            int r7 = r6 % 128
            kotlinx.coroutines.internal.FastServiceLoader.PlaceComponentResult = r7
            int r6 = r6 % r2
            goto L34
        L96:
            r5 = 1
        L97:
            if (r5 == 0) goto La7
            int r3 = r3.length()
            if (r3 <= 0) goto La0
            r4 = 1
        La0:
            if (r4 == 0) goto L11
            r0.add(r1)
            goto L11
        La7:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Illegal service provider class name: "
            r11.append(r0)
            r11.append(r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r11 = r11.toString()
            java.lang.String r11 = r11.toString()
            r0.<init>(r11)
            throw r0
        Lc2:
            r11 = move-exception
            goto Lc5
        Lc4:
            throw r11
        Lc5:
            goto Lc4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.parseFile(java.io.BufferedReader):java.util.List");
    }

    private final List<String> parse(URL url) {
        BufferedReader bufferedReader;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        String obj = url.toString();
        if (!StringsKt.startsWith$default(obj, "jar", false, 2, (Object) null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(FirebasePerfUrlConnection.openStream(url)));
            try {
                List<String> parseFile = INSTANCE.parseFile(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                int i3 = PlaceComponentResult + 3;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return parseFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        String substringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(obj, "jar:file:", (String) null, 2, (Object) null), '!', (String) null, 2, (Object) null);
        String substringAfter$default = StringsKt.substringAfter$default(obj, "!/", (String) null, 2, (Object) null);
        JarFile jarFile = new JarFile(substringBefore$default, false);
        try {
            InputStream inputStream = jarFile.getInputStream(new ZipEntry(substringAfter$default));
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getDoubleTapTimeout() >> 16) + 30293, new char[]{26792, 7932, 33809, 2607, 45457}, objArr);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, ((String) objArr[0]).intern()));
            try {
                List<String> parseFile2 = INSTANCE.parseFile(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                jarFile.close();
                return parseFile2;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th2, th4);
                    throw th2;
                }
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        try {
            int i2 = $10 + 17;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '\n' : Typography.amp) == '&') {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            }
            char[] cArr2 = new char[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i4 = $10 + 61;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                try {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
