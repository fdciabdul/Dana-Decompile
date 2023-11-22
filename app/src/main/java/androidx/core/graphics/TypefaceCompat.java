package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class TypefaceCompat {
    private static final LruCache<String, Typeface> KClassImpl$Data$declaredNonStaticMembers$2;
    private static final TypefaceCompatBaseImpl MyBillsEntityDataFactory;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            MyBillsEntityDataFactory = new TypefaceCompatApi29Impl();
        } else if (Build.VERSION.SDK_INT >= 28) {
            MyBillsEntityDataFactory = new TypefaceCompatApi28Impl();
        } else if (Build.VERSION.SDK_INT >= 26) {
            MyBillsEntityDataFactory = new TypefaceCompatApi26Impl();
        } else if (Build.VERSION.SDK_INT >= 24 && TypefaceCompatApi24Impl.getAuthRequestContext()) {
            MyBillsEntityDataFactory = new TypefaceCompatApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            MyBillsEntityDataFactory = new TypefaceCompatApi21Impl();
        } else {
            MyBillsEntityDataFactory = new TypefaceCompatBaseImpl();
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = new LruCache<>(16);
    }

    private TypefaceCompat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String PlaceComponentResult(Resources resources, int i, String str, int i2, int i3) {
        StringBuilder sb = new StringBuilder(resources.getResourcePackageName(i));
        sb.append('-');
        sb.append(str);
        sb.append('-');
        sb.append(i2);
        sb.append('-');
        sb.append(i);
        sb.append('-');
        sb.append(i3);
        return sb.toString();
    }

    private static Typeface getAuthRequestContext(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface typefaceCreateDerived = InstrumentInjector.typefaceCreateDerived(Typeface.DEFAULT, 0);
        if (create == null || create.equals(typefaceCreateDerived)) {
            return null;
        }
        return create;
    }

    public static Typeface BuiltInFictitiousFunctionClassFactory(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i, String str, int i2, int i3, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z) {
        Typeface KClassImpl$Data$declaredNonStaticMembers$22;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface authRequestContext = getAuthRequestContext(providerResourceEntry.getAuthRequestContext());
            if (authRequestContext != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(authRequestContext, handler);
                }
                return authRequestContext;
            }
            KClassImpl$Data$declaredNonStaticMembers$22 = FontsContractCompat.MyBillsEntityDataFactory(context, providerResourceEntry.BuiltInFictitiousFunctionClassFactory(), i3, !z ? fontCallback != null : providerResourceEntry.KClassImpl$Data$declaredNonStaticMembers$2() != 0, z ? providerResourceEntry.MyBillsEntityDataFactory() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback));
        } else {
            KClassImpl$Data$declaredNonStaticMembers$22 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i3);
            if (fontCallback != null) {
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    fontCallback.callbackSuccessAsync(KClassImpl$Data$declaredNonStaticMembers$22, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.put(PlaceComponentResult(resources, i, str, i2, i3), KClassImpl$Data$declaredNonStaticMembers$22);
        }
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    public static Typeface PlaceComponentResult(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(context, resources, i, str, i3);
        if (MyBillsEntityDataFactory2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.put(PlaceComponentResult(resources, i, str, i2, i3), MyBillsEntityDataFactory2);
        }
        return MyBillsEntityDataFactory2;
    }

    public static Typeface MyBillsEntityDataFactory(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return MyBillsEntityDataFactory.PlaceComponentResult(context, cancellationSignal, fontInfoArr, i);
    }

    private static Typeface MyBillsEntityDataFactory(Context context, Typeface typeface, int i) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = MyBillsEntityDataFactory;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry MyBillsEntityDataFactory2 = typefaceCompatBaseImpl.MyBillsEntityDataFactory(typeface);
        if (MyBillsEntityDataFactory2 == null) {
            return null;
        }
        return typefaceCompatBaseImpl.KClassImpl$Data$declaredNonStaticMembers$2(context, MyBillsEntityDataFactory2, context.getResources(), i);
    }

    public static Typeface getAuthRequestContext(Context context, Typeface typeface, int i) {
        Typeface MyBillsEntityDataFactory2;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context, typeface, i)) == null) ? InstrumentInjector.typefaceCreateDerived(typeface, i) : MyBillsEntityDataFactory2;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    /* loaded from: classes.dex */
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback getAuthRequestContext;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.getAuthRequestContext = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void MyBillsEntityDataFactory(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.getAuthRequestContext;
            if (fontCallback != null) {
                fontCallback.m8x46c88379(typeface);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void BuiltInFictitiousFunctionClassFactory(int i) {
            ResourcesCompat.FontCallback fontCallback = this.getAuthRequestContext;
            if (fontCallback != null) {
                fontCallback.m7xb24343b7(i);
            }
        }
    }
}
