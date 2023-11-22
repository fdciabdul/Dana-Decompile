package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class MultiDex {
    public static final byte[] PlaceComponentResult = {114, -124, TarHeader.LF_CONTIG, 72, 15, -8, 16, -1, -4, -3, -52, TarHeader.LF_CONTIG, 14, 1, 8, -13, 11, 8, -68, Ascii.ETB, 46, 1, 8, -13, Ascii.NAK, -2, -2, 8, -1, -13, 4, -31, 39, 11, 0, 17, -49, TarHeader.LF_LINK, 2, -2, -1, -4, 0, Ascii.NAK, -9, 8, 1, -35, 39, -6, 11, 15, -8, 16, -1, -4, -3, -52, TarHeader.LF_CONTIG, 14, 1, 8, -13, 11, 8, -68, 68, -1, -61, Ascii.NAK, TarHeader.LF_LINK, 2, -2, -1, -4, 0, Ascii.NAK, -9, 8, 1, -35, 39, -6, 11};
    public static final int BuiltInFictitiousFunctionClassFactory = 186;
    private static final Set<File> KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet();
    private static final boolean MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory(System.getProperty("java.vm.version"));

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = 34 - r9
            int r8 = 51 - r8
            byte[] r0 = androidx.multidex.MultiDex.PlaceComponentResult
            int r7 = r7 * 6
            int r7 = 115 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L16:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r8 = r8 + r9
            int r7 = r7 + 1
            int r8 = r8 + (-2)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.a(int, int, short, java.lang.Object[]):void");
    }

    private MultiDex() {
    }

    public static void getAuthRequestContext(Context context) {
        InstrumentInjector.log_i("MultiDex", "Installing application");
        if (MyBillsEntityDataFactory) {
            InstrumentInjector.log_i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (Build.VERSION.SDK_INT < 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("MultiDex installation failed. SDK ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append(" is unsupported. Min SDK version is ");
            sb.append(4);
            sb.append(".");
            throw new RuntimeException(sb.toString());
        } else {
            try {
                ApplicationInfo KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(context);
                if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                    InstrumentInjector.log_i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                byte b = (byte) (-PlaceComponentResult[9]);
                byte b2 = PlaceComponentResult[34];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = PlaceComponentResult[34];
                byte b4 = (byte) (b3 | Ascii.EM);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                KClassImpl$Data$declaredNonStaticMembers$2(context, new File((String) cls.getField((String) objArr2[0]).get(KClassImpl$Data$declaredNonStaticMembers$22)), new File(KClassImpl$Data$declaredNonStaticMembers$22.dataDir), "secondary-dexes", "");
                InstrumentInjector.log_i("MultiDex", "install done");
            } catch (Exception e) {
                InstrumentInjector.log_e("MultiDex", "MultiDex installation failure", e);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MultiDex installation failed (");
                sb2.append(e.getMessage());
                sb2.append(").");
                throw new RuntimeException(sb2.toString());
            }
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, File file, File file2, String str, String str2) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Set<File> set = KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            if (Build.VERSION.SDK_INT > 20) {
                StringBuilder sb = new StringBuilder();
                sb.append("MultiDex is not guaranteed to work in SDK version ");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(": SDK version higher than ");
                sb.append(20);
                sb.append(" should be backed by ");
                sb.append("runtime with built-in multidex capabilty but it's not the ");
                sb.append("case here: java.vm.version=\"");
                sb.append(System.getProperty("java.vm.version"));
                sb.append("\"");
                InstrumentInjector.log_w("MultiDex", sb.toString());
            }
            ClassLoader MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context);
            if (MyBillsEntityDataFactory2 == null) {
                return;
            }
            try {
                File file3 = new File(context.getFilesDir(), "secondary-dexes");
                if (file3.isDirectory()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Clearing old secondary dex dir (");
                    sb2.append(file3.getPath());
                    sb2.append(").");
                    InstrumentInjector.log_i("MultiDex", sb2.toString());
                    File[] listFiles = file3.listFiles();
                    if (listFiles == null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to list secondary dex dir content (");
                        sb3.append(file3.getPath());
                        sb3.append(").");
                        InstrumentInjector.log_w("MultiDex", sb3.toString());
                    } else {
                        for (File file4 : listFiles) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Trying to delete old file ");
                            sb4.append(file4.getPath());
                            sb4.append(" of size ");
                            sb4.append(file4.length());
                            InstrumentInjector.log_i("MultiDex", sb4.toString());
                            if (!file4.delete()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Failed to delete old file ");
                                sb5.append(file4.getPath());
                                InstrumentInjector.log_w("MultiDex", sb5.toString());
                            } else {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("Deleted old file ");
                                sb6.append(file4.getPath());
                                InstrumentInjector.log_i("MultiDex", sb6.toString());
                            }
                        }
                        if (!file3.delete()) {
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("Failed to delete secondary dex dir ");
                            sb7.append(file3.getPath());
                            InstrumentInjector.log_w("MultiDex", sb7.toString());
                        } else {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("Deleted old secondary dex dir ");
                            sb8.append(file3.getPath());
                            InstrumentInjector.log_i("MultiDex", sb8.toString());
                        }
                    }
                }
            } catch (Throwable th) {
                InstrumentInjector.log_w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
            }
            File KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(context, file2, str);
            MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, KClassImpl$Data$declaredNonStaticMembers$22);
            try {
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2, KClassImpl$Data$declaredNonStaticMembers$22, multiDexExtractor.KClassImpl$Data$declaredNonStaticMembers$2(context, str2, false));
                } catch (IOException e) {
                    InstrumentInjector.log_w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e);
                    KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2, KClassImpl$Data$declaredNonStaticMembers$22, multiDexExtractor.KClassImpl$Data$declaredNonStaticMembers$2(context, str2, true));
                }
                try {
                    e = null;
                } catch (IOException e2) {
                    e = e2;
                }
                if (e != null) {
                    throw e;
                }
            } finally {
                try {
                    multiDexExtractor.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    private static ClassLoader MyBillsEntityDataFactory(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (Build.VERSION.SDK_INT >= 14) {
                if (classLoader instanceof BaseDexClassLoader) {
                    return classLoader;
                }
            } else if ((classLoader instanceof DexClassLoader) || (classLoader instanceof PathClassLoader)) {
                return classLoader;
            }
            InstrumentInjector.log_e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e) {
            InstrumentInjector.log_w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    private static ApplicationInfo KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        try {
            byte b = (byte) (-PlaceComponentResult[9]);
            Object[] objArr = new Object[1];
            a(b, (byte) (b | 44), PlaceComponentResult[16], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(PlaceComponentResult[38], PlaceComponentResult[35], PlaceComponentResult[6], objArr2);
            return (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null);
        } catch (Throwable th) {
            try {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            } catch (RuntimeException e) {
                InstrumentInjector.log_w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
                return null;
            }
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        boolean z = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (nextToken != null && nextToken2 != null) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(nextToken2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        InstrumentInjector.log_i("MultiDex", sb.toString());
        return z;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (list.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            V19.BuiltInFictitiousFunctionClassFactory(classLoader, list, file);
        } else if (Build.VERSION.SDK_INT >= 14) {
            V14.KClassImpl$Data$declaredNonStaticMembers$2(classLoader, list);
        } else {
            V4.MyBillsEntityDataFactory(classLoader, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field getAuthRequestContext(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field ");
        sb.append(str);
        sb.append(" not found in ");
        sb.append(obj.getClass());
        throw new NoSuchFieldException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getAuthRequestContext(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(str);
        sb.append(" with parameters ");
        sb.append(Arrays.asList(clsArr));
        sb.append(" not found in ");
        sb.append(obj.getClass());
        throw new NoSuchMethodException(sb.toString());
    }

    private static File KClassImpl$Data$declaredNonStaticMembers$2(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            BuiltInFictitiousFunctionClassFactory(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            BuiltInFictitiousFunctionClassFactory(file2);
        }
        File file3 = new File(file2, str);
        BuiltInFictitiousFunctionClassFactory(file3);
        return file3;
    }

    private static void BuiltInFictitiousFunctionClassFactory(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to create dir ");
            sb.append(file.getPath());
            sb.append(". Parent file is null.");
            InstrumentInjector.log_e("MultiDex", sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to create dir ");
            sb2.append(file.getPath());
            sb2.append(". parent file is a dir ");
            sb2.append(parentFile.isDirectory());
            sb2.append(", a file ");
            sb2.append(parentFile.isFile());
            sb2.append(", exists ");
            sb2.append(parentFile.exists());
            sb2.append(", readable ");
            sb2.append(parentFile.canRead());
            sb2.append(", writable ");
            sb2.append(parentFile.canWrite());
            InstrumentInjector.log_e("MultiDex", sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Failed to create directory ");
        sb3.append(file.getPath());
        throw new IOException(sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class V19 {
        private V19() {
        }

        static void BuiltInFictitiousFunctionClassFactory(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.getAuthRequestContext(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.getAuthRequestContext(obj, "dexElements", getAuthRequestContext(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    InstrumentInjector.log_w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field authRequestContext = MultiDex.getAuthRequestContext(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) authRequestContext.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                authRequestContext.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] getAuthRequestContext(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) MultiDex.getAuthRequestContext(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class V14 {
        private static final int KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        private final ElementConstructor getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface ElementConstructor {
            Object MyBillsEntityDataFactory(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        /* loaded from: classes.dex */
        static class ICSElementConstructor implements ElementConstructor {
            private final Constructor<?> PlaceComponentResult;

            ICSElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.PlaceComponentResult = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object MyBillsEntityDataFactory(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.PlaceComponentResult.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        /* loaded from: classes.dex */
        static class JBMR11ElementConstructor implements ElementConstructor {
            private final Constructor<?> PlaceComponentResult;

            JBMR11ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.PlaceComponentResult = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object MyBillsEntityDataFactory(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.PlaceComponentResult.newInstance(file, file, dexFile);
            }
        }

        /* loaded from: classes.dex */
        static class JBMR2ElementConstructor implements ElementConstructor {
            private final Constructor<?> getAuthRequestContext;

            JBMR2ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.getAuthRequestContext = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object MyBillsEntityDataFactory(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.getAuthRequestContext.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        static void KClassImpl$Data$declaredNonStaticMembers$2(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object obj = MultiDex.getAuthRequestContext(classLoader, "pathList").get(classLoader);
            V14 v14 = new V14();
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                File file = list.get(i);
                ElementConstructor elementConstructor = v14.getAuthRequestContext;
                String path = file.getPath();
                File parentFile = file.getParentFile();
                String name = file.getName();
                StringBuilder sb = new StringBuilder();
                sb.append(name.substring(0, name.length() - KClassImpl$Data$declaredNonStaticMembers$2));
                sb.append(".dex");
                objArr[i] = elementConstructor.MyBillsEntityDataFactory(file, DexFile.loadDex(path, new File(parentFile, sb.toString()).getPath(), 0));
            }
            try {
                MultiDex.getAuthRequestContext(obj, "dexElements", objArr);
            } catch (NoSuchFieldException e) {
                InstrumentInjector.log_w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                MultiDex.getAuthRequestContext(obj, "pathElements", objArr);
            }
        }

        private V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            ElementConstructor jBMR2ElementConstructor;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    jBMR2ElementConstructor = new ICSElementConstructor(cls);
                } catch (NoSuchMethodException unused) {
                    jBMR2ElementConstructor = new JBMR2ElementConstructor(cls);
                }
            } catch (NoSuchMethodException unused2) {
                jBMR2ElementConstructor = new JBMR11ElementConstructor(cls);
            }
            this.getAuthRequestContext = jBMR2ElementConstructor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class V4 {
        private V4() {
        }

        static void MyBillsEntityDataFactory(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field authRequestContext = MultiDex.getAuthRequestContext(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) authRequestContext.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath);
                sb2.append(".dex");
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, sb2.toString(), 0);
            }
            authRequestContext.set(classLoader, sb.toString());
            MultiDex.getAuthRequestContext(classLoader, "mPaths", strArr);
            MultiDex.getAuthRequestContext(classLoader, "mFiles", fileArr);
            MultiDex.getAuthRequestContext(classLoader, "mZips", zipFileArr);
            MultiDex.getAuthRequestContext(classLoader, "mDexs", dexFileArr);
        }
    }

    static /* synthetic */ void getAuthRequestContext(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field authRequestContext = getAuthRequestContext(obj, str);
        Object[] objArr2 = (Object[]) authRequestContext.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        authRequestContext.set(obj, objArr3);
    }
}
