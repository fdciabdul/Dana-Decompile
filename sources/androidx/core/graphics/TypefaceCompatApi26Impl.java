package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    protected final Class<?> BuiltInFictitiousFunctionClassFactory;
    protected final Method KClassImpl$Data$declaredNonStaticMembers$2;
    protected final Method MyBillsEntityDataFactory;
    protected final Method PlaceComponentResult;
    protected final Method getAuthRequestContext;
    protected final Constructor<?> lookAheadTest;
    protected final Method scheduleImpl;

    public TypefaceCompatApi26Impl() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            constructor = MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2);
            method2 = KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
            method3 = PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            method4 = scheduleImpl(KClassImpl$Data$declaredNonStaticMembers$2);
            method5 = getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
            method = BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
            cls = KClassImpl$Data$declaredNonStaticMembers$2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to collect necessary methods for class ");
            sb.append(e.getClass().getName());
            InstrumentInjector.log_e("TypefaceCompatApi26Impl", sb.toString(), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.BuiltInFictitiousFunctionClassFactory = cls;
        this.lookAheadTest = constructor;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = method2;
        this.PlaceComponentResult = method3;
        this.scheduleImpl = method4;
        this.MyBillsEntityDataFactory = method5;
        this.getAuthRequestContext = method;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            InstrumentInjector.log_w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != null;
    }

    private Object PlaceComponentResult() {
        try {
            return this.lookAheadTest.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean getAuthRequestContext(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.PlaceComponentResult.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    protected Typeface KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.BuiltInFictitiousFunctionClassFactory, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.getAuthRequestContext.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private boolean getAuthRequestContext(Object obj) {
        try {
            return ((Boolean) this.scheduleImpl.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void MyBillsEntityDataFactory(Object obj) {
        try {
            this.MyBillsEntityDataFactory.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface KClassImpl$Data$declaredNonStaticMembers$2(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!BuiltInFictitiousFunctionClassFactory()) {
            return super.KClassImpl$Data$declaredNonStaticMembers$2(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object PlaceComponentResult = PlaceComponentResult();
        if (PlaceComponentResult == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (!KClassImpl$Data$declaredNonStaticMembers$2(context, PlaceComponentResult, fontFileResourceEntry.BuiltInFictitiousFunctionClassFactory(), fontFileResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2(), fontFileResourceEntry.MyBillsEntityDataFactory(), fontFileResourceEntry.moveToNextValue() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.PlaceComponentResult()))) {
                MyBillsEntityDataFactory(PlaceComponentResult);
                return null;
            }
        }
        if (getAuthRequestContext(PlaceComponentResult)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        }
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface PlaceComponentResult(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        Typeface KClassImpl$Data$declaredNonStaticMembers$2;
        if (fontInfoArr.length <= 0) {
            return null;
        }
        if (!BuiltInFictitiousFunctionClassFactory()) {
            FontsContractCompat.FontInfo BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(fontInfoArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(), BranchLinkConstant.PayloadKey.REFERRAL, cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()).setItalic(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory()).build();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> authRequestContext = TypefaceCompatUtil.getAuthRequestContext(context, fontInfoArr, cancellationSignal);
        Object PlaceComponentResult = PlaceComponentResult();
        if (PlaceComponentResult == null) {
            return null;
        }
        boolean z = false;
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            ByteBuffer byteBuffer = authRequestContext.get(fontInfo.PlaceComponentResult());
            if (byteBuffer != null) {
                if (!getAuthRequestContext(PlaceComponentResult, byteBuffer, fontInfo.BuiltInFictitiousFunctionClassFactory(), fontInfo.getAuthRequestContext(), fontInfo.MyBillsEntityDataFactory() ? 1 : 0)) {
                    MyBillsEntityDataFactory(PlaceComponentResult);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            MyBillsEntityDataFactory(PlaceComponentResult);
            return null;
        } else if (getAuthRequestContext(PlaceComponentResult) && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult)) != null) {
            return InstrumentInjector.typefaceCreateDerived(KClassImpl$Data$declaredNonStaticMembers$2, i);
        } else {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface MyBillsEntityDataFactory(Context context, Resources resources, int i, String str, int i2) {
        if (!BuiltInFictitiousFunctionClassFactory()) {
            return super.MyBillsEntityDataFactory(context, resources, i, str, i2);
        }
        Object PlaceComponentResult = PlaceComponentResult();
        if (PlaceComponentResult == null) {
            return null;
        }
        if (!KClassImpl$Data$declaredNonStaticMembers$2(context, PlaceComponentResult, str, 0, -1, -1, null)) {
            MyBillsEntityDataFactory(PlaceComponentResult);
            return null;
        } else if (getAuthRequestContext(PlaceComponentResult)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
        } else {
            return null;
        }
    }

    protected Class<?> KClassImpl$Data$declaredNonStaticMembers$2() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> MyBillsEntityDataFactory(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method PlaceComponentResult(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method scheduleImpl(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method getAuthRequestContext(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method BuiltInFictitiousFunctionClassFactory(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
