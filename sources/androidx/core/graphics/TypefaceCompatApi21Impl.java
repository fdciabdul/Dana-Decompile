package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.constant.BranchLinkConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static Class<?> BuiltInFictitiousFunctionClassFactory;
    private static Constructor<?> KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static Method PlaceComponentResult;
    private static Method getAuthRequestContext;

    private static void KClassImpl$Data$declaredNonStaticMembers$2() {
        Method method;
        Class<?> cls;
        Method method2;
        if (MyBillsEntityDataFactory) {
            return;
        }
        MyBillsEntityDataFactory = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            InstrumentInjector.log_e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = constructor;
        BuiltInFictitiousFunctionClassFactory = cls;
        PlaceComponentResult = method2;
        getAuthRequestContext = method;
    }

    private File KClassImpl$Data$declaredNonStaticMembers$2(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/self/fd/");
            sb.append(parcelFileDescriptor.getFd());
            String readlink = Os.readlink(sb.toString());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException unused) {
            return null;
        }
    }

    private static Object MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface BuiltInFictitiousFunctionClassFactory(Object obj) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        try {
            Object newInstance = Array.newInstance(BuiltInFictitiousFunctionClassFactory, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) getAuthRequestContext.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, int i, boolean z) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        try {
            return ((Boolean) PlaceComponentResult.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface PlaceComponentResult(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        if (fontInfoArr.length <= 0) {
            return null;
        }
        FontsContractCompat.FontInfo BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(fontInfoArr, i);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult(), BranchLinkConstant.PayloadKey.REFERRAL, cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(openFileDescriptor);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null && KClassImpl$Data$declaredNonStaticMembers$22.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(KClassImpl$Data$declaredNonStaticMembers$22);
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface BuiltInFictitiousFunctionClassFactory3 = super.BuiltInFictitiousFunctionClassFactory(context, fileInputStream);
                    fileInputStream.close();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return BuiltInFictitiousFunctionClassFactory3;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface KClassImpl$Data$declaredNonStaticMembers$2(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2()) {
            File BuiltInFictitiousFunctionClassFactory2 = TypefaceCompatUtil.BuiltInFictitiousFunctionClassFactory(context);
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, resources, fontFileResourceEntry.getAuthRequestContext())) {
                    return null;
                }
                if (!KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2, BuiltInFictitiousFunctionClassFactory2.getPath(), fontFileResourceEntry.MyBillsEntityDataFactory(), fontFileResourceEntry.moveToNextValue())) {
                    return null;
                }
                BuiltInFictitiousFunctionClassFactory2.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                BuiltInFictitiousFunctionClassFactory2.delete();
            }
        }
        return BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
    }
}
