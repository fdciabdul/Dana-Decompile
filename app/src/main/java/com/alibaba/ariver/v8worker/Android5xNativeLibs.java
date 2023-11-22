package com.alibaba.ariver.v8worker;

import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.ReflectUtils;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: classes6.dex */
public class Android5xNativeLibs {
    public static final String CLASS_DALVIK_SYSTEM_BASE_DEX_CLASS_LOADER = "dalvik.system.BaseDexClassLoader";
    public static final String FIELD_NATIVE_LIBRARY_DIRECTORIES = "nativeLibraryDirectories";
    public static final String FIELD_PATH_LIST = "pathList";
    public static final String TAG = "Android5xNativeLibs";

    public static void addExtraNativeLibraryDirectories(Context context, String str) {
        try {
            Object field = ReflectUtils.getField(Class.forName("dalvik.system.BaseDexClassLoader"), "pathList", Android5xNativeLibs.class.getClassLoader());
            Class<?> cls = field.getClass();
            File[] fileArr = (File[]) ReflectUtils.getField(cls, "nativeLibraryDirectories", field);
            for (File file : fileArr) {
                if (file.getAbsolutePath().contains(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getAbsolutePath());
                    sb.append(" already contains: ");
                    sb.append(str);
                    RVLogger.w(TAG, sb.toString());
                    return;
                }
            }
            File[] fileArr2 = new File[fileArr.length + 1];
            fileArr2[0] = new File(str);
            System.arraycopy(fileArr, 0, fileArr2, 1, fileArr.length);
            setFieldValue(cls, field, "nativeLibraryDirectories", fileArr2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("successfully addExtraNativeLibraryDirectories ");
            sb2.append(str);
            RVLogger.w(TAG, sb2.toString());
        } catch (Throwable th) {
            RVLogger.e(TAG, "addExtraNativeLibraryDirectories", th);
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
