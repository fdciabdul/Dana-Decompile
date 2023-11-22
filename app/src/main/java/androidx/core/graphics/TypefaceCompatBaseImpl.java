package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TypefaceCompatBaseImpl {
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> BuiltInFictitiousFunctionClassFactory = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface StyleExtractor<T> {
        int PlaceComponentResult(T t);

        boolean getAuthRequestContext(T t);
    }

    private static <T> T PlaceComponentResult(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        return (T) MyBillsEntityDataFactory(tArr, (i & 1) == 0 ? 400 : 700, (i & 2) != 0, styleExtractor);
    }

    private static <T> T MyBillsEntityDataFactory(T[] tArr, int i, boolean z, StyleExtractor<T> styleExtractor) {
        T t = null;
        int i2 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.PlaceComponentResult(t2) - i) * 2) + (styleExtractor.getAuthRequestContext(t2) == z ? 0 : 1);
            if (t == null || i2 > abs) {
                t = t2;
                i2 = abs;
            }
        }
        return t;
    }

    private static long KClassImpl$Data$declaredNonStaticMembers$2(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            InstrumentInjector.log_e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            InstrumentInjector.log_e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FontsContractCompat.FontInfo BuiltInFictitiousFunctionClassFactory(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (FontsContractCompat.FontInfo) PlaceComponentResult(fontInfoArr, i, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.1
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int PlaceComponentResult(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getAuthRequestContext();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
            public boolean getAuthRequestContext(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.MyBillsEntityDataFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface BuiltInFictitiousFunctionClassFactory(Context context, InputStream inputStream) {
        File BuiltInFictitiousFunctionClassFactory = TypefaceCompatUtil.BuiltInFictitiousFunctionClassFactory(context);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, inputStream)) {
                return Typeface.createFromFile(BuiltInFictitiousFunctionClassFactory.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            BuiltInFictitiousFunctionClassFactory.delete();
        }
    }

    public Typeface PlaceComponentResult(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length <= 0) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(BuiltInFictitiousFunctionClassFactory(fontInfoArr, i).PlaceComponentResult());
            try {
                Typeface BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context, inputStream);
                TypefaceCompatUtil.MyBillsEntityDataFactory(inputStream);
                return BuiltInFictitiousFunctionClassFactory;
            } catch (IOException unused) {
                TypefaceCompatUtil.MyBillsEntityDataFactory(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.MyBillsEntityDataFactory(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry MyBillsEntityDataFactory(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontResourcesParserCompat.FontFileResourceEntry) PlaceComponentResult(fontFamilyFilesResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2(), i, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.2
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
            public int PlaceComponentResult(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.MyBillsEntityDataFactory();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* renamed from: PlaceComponentResult  reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean getAuthRequestContext(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.moveToNextValue();
            }
        });
    }

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public int PlaceComponentResult(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.MyBillsEntityDataFactory();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public boolean getAuthRequestContext(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.moveToNextValue();
        }
    }

    public Typeface KClassImpl$Data$declaredNonStaticMembers$2(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry MyBillsEntityDataFactory = MyBillsEntityDataFactory(fontFamilyFilesResourceEntry, i);
        if (MyBillsEntityDataFactory == null) {
            return null;
        }
        Typeface PlaceComponentResult = TypefaceCompat.PlaceComponentResult(context, resources, MyBillsEntityDataFactory.getAuthRequestContext(), MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(), 0, i);
        KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, fontFamilyFilesResourceEntry);
        return PlaceComponentResult;
    }

    public Typeface MyBillsEntityDataFactory(Context context, Resources resources, int i, String str, int i2) {
        File BuiltInFictitiousFunctionClassFactory = TypefaceCompatUtil.BuiltInFictitiousFunctionClassFactory(context);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, resources, i)) {
                return Typeface.createFromFile(BuiltInFictitiousFunctionClassFactory.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            BuiltInFictitiousFunctionClassFactory.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry MyBillsEntityDataFactory(Typeface typeface) {
        long KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(typeface);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            return null;
        }
        return this.BuiltInFictitiousFunctionClassFactory.get(Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2));
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(typeface);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            this.BuiltInFictitiousFunctionClassFactory.put(Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2), fontFamilyFilesResourceEntry);
        }
    }
}
