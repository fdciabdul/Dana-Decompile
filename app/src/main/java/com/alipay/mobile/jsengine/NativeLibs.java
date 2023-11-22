package com.alipay.mobile.jsengine;

import android.content.Context;
import android.os.Build;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class NativeLibs {
    public static final String CLASS_DALVIK_SYSTEM_BASE_DEX_CLASS_LOADER = "dalvik.system.BaseDexClassLoader";
    public static final String FIELD_LIBRARY_PATH_ELEMENTS = "libraryPathElements";
    public static final String FIELD_NATIVE_LIBRARY_DIRECTORIES = "nativeLibraryDirectories";
    public static final String FIELD_NATIVE_LIBRARY_PATH_ELEMENTS = "nativeLibraryPathElements";
    public static final String FIELD_PATH_LIST = "pathList";
    public static final String METHOD_MAKE_PATH_ELEMENTS = "makePathElements";
    public static final String METHOD_SPLIT_PATHS = "splitPaths";
    private static final String PLUGINS_LIB = "plugins_lib";
    public static final String TAG = "NativeLibs";

    public static void addExtraNativeLibraryDirectories(Delegate delegate, Context context, ClassLoader classLoader) {
        try {
            File dir = context.getDir(PLUGINS_LIB, 0);
            if (Build.VERSION.SDK_INT >= 14) {
                Object field = ReflectUtils.getField(Class.forName("dalvik.system.BaseDexClassLoader"), "pathList", classLoader);
                Class<?> cls = field.getClass();
                Object field2 = ReflectUtils.getField(cls, "nativeLibraryDirectories", field);
                if (Build.VERSION.SDK_INT >= 23) {
                    List<File> list = (List) field2;
                    for (File file : list) {
                        if (file.getAbsolutePath().contains(PLUGINS_LIB)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(file.getAbsolutePath());
                            sb.append(" already contains: ");
                            sb.append(PLUGINS_LIB);
                            delegate.w(TAG, sb.toString());
                            return;
                        }
                    }
                    list.add(0, dir);
                    List list2 = (List) ReflectUtils.invokeMethod(cls, METHOD_SPLIT_PATHS, new Class[]{String.class, Boolean.TYPE}, new Object[]{System.getProperty("java.library.path"), Boolean.TRUE});
                    ArrayList arrayList = new ArrayList();
                    list2.addAll(0, list);
                    Object invokeMethod = ReflectUtils.invokeMethod(cls, METHOD_MAKE_PATH_ELEMENTS, new Class[]{List.class, File.class, List.class}, new Object[]{list2, null, arrayList});
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            delegate.e(TAG, "suppressedException-", (IOException) it.next());
                        }
                        return;
                    }
                    setFieldValue(cls, field, FIELD_NATIVE_LIBRARY_PATH_ELEMENTS, invokeMethod);
                    return;
                }
                File[] fileArr = (File[]) field2;
                for (File file2 : fileArr) {
                    if (file2.getAbsolutePath().contains(PLUGINS_LIB)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(file2.getAbsolutePath());
                        sb2.append(" already contains: ");
                        sb2.append(PLUGINS_LIB);
                        delegate.w(TAG, sb2.toString());
                        return;
                    }
                }
                File[] fileArr2 = new File[fileArr.length + 1];
                fileArr2[0] = dir;
                System.arraycopy(fileArr, 0, fileArr2, 1, fileArr.length);
                setFieldValue(cls, field, "nativeLibraryDirectories", fileArr2);
                return;
            }
            List<String> list3 = (List) ReflectUtils.getField(classLoader.getClass(), FIELD_LIBRARY_PATH_ELEMENTS, classLoader);
            for (String str : list3) {
                if (str.contains(PLUGINS_LIB)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(" already contains: ");
                    sb3.append(PLUGINS_LIB);
                    delegate.w(TAG, sb3.toString());
                    return;
                }
            }
            list3.add(dir.getAbsolutePath());
        } catch (Throwable th) {
            delegate.e(TAG, "addExtraNativeLibraryDirectories", th);
        }
    }

    public static void setFieldValue(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        doGetField(cls.getName(), cls, str).set(obj, obj2);
    }

    private static Field doGetField(String str, Class<?> cls, String str2) throws NoSuchFieldException {
        do {
            try {
                Field declaredField = cls.getDeclaredField(str2);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        } while (cls != null);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        throw new NoSuchFieldException(sb.toString());
    }
}
