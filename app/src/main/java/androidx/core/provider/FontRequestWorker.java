package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class FontRequestWorker {
    static final LruCache<String, Typeface> BuiltInFictitiousFunctionClassFactory = new LruCache<>(16);
    private static final ExecutorService KClassImpl$Data$declaredNonStaticMembers$2 = RequestExecutor.BuiltInFictitiousFunctionClassFactory("fonts-androidx");
    static final Object PlaceComponentResult = new Object();
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> MyBillsEntityDataFactory = new SimpleArrayMap<>();

    private FontRequestWorker() {
    }

    public static Typeface MyBillsEntityDataFactory(final Context context, final FontRequest fontRequest, CallbackWithHandler callbackWithHandler, final int i, int i2) {
        final String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(fontRequest, i);
        Typeface typeface = BuiltInFictitiousFunctionClassFactory.get(BuiltInFictitiousFunctionClassFactory2);
        if (typeface != null) {
            callbackWithHandler.getAuthRequestContext(new TypefaceResult(typeface));
            return typeface;
        } else if (i2 == -1) {
            TypefaceResult KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, context, fontRequest, i);
            callbackWithHandler.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22);
            return KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1
                    @Override // java.util.concurrent.Callable
                    public /* synthetic */ TypefaceResult call() throws Exception {
                        return FontRequestWorker.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, context, fontRequest, i);
                    }
                }, i2);
                callbackWithHandler.getAuthRequestContext(typefaceResult);
                return typefaceResult.PlaceComponentResult;
            } catch (InterruptedException unused) {
                callbackWithHandler.getAuthRequestContext(new TypefaceResult(-3));
                return null;
            }
        }
    }

    public static Typeface KClassImpl$Data$declaredNonStaticMembers$2(final Context context, final FontRequest fontRequest, final int i, final CallbackWithHandler callbackWithHandler) {
        final String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(fontRequest, i);
        Typeface typeface = BuiltInFictitiousFunctionClassFactory.get(BuiltInFictitiousFunctionClassFactory2);
        if (typeface != null) {
            callbackWithHandler.getAuthRequestContext(new TypefaceResult(typeface));
            return typeface;
        }
        Consumer<TypefaceResult> consumer = new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
            @Override // androidx.core.util.Consumer
            public /* synthetic */ void accept(TypefaceResult typefaceResult) {
                TypefaceResult typefaceResult2 = typefaceResult;
                if (typefaceResult2 == null) {
                    typefaceResult2 = new TypefaceResult(-3);
                }
                callbackWithHandler.getAuthRequestContext(typefaceResult2);
            }
        };
        synchronized (PlaceComponentResult) {
            SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = MyBillsEntityDataFactory;
            ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(BuiltInFictitiousFunctionClassFactory2);
            if (arrayList != null) {
                arrayList.add(consumer);
                return null;
            }
            ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
            arrayList2.add(consumer);
            simpleArrayMap.put(BuiltInFictitiousFunctionClassFactory2, arrayList2);
            RequestExecutor.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.3
                @Override // java.util.concurrent.Callable
                /* renamed from: MyBillsEntityDataFactory */
                public TypefaceResult call() {
                    try {
                        return FontRequestWorker.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, context, fontRequest, i);
                    } catch (Throwable unused) {
                        return new TypefaceResult(-3);
                    }
                }
            }, new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4
                @Override // androidx.core.util.Consumer
                public /* synthetic */ void accept(TypefaceResult typefaceResult) {
                    TypefaceResult typefaceResult2 = typefaceResult;
                    synchronized (FontRequestWorker.PlaceComponentResult) {
                        ArrayList<Consumer<TypefaceResult>> arrayList3 = FontRequestWorker.MyBillsEntityDataFactory.get(BuiltInFictitiousFunctionClassFactory2);
                        if (arrayList3 == null) {
                            return;
                        }
                        FontRequestWorker.MyBillsEntityDataFactory.remove(BuiltInFictitiousFunctionClassFactory2);
                        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                            arrayList3.get(i2).accept(typefaceResult2);
                        }
                    }
                }
            });
            return null;
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory(FontRequest fontRequest, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(fontRequest.MyBillsEntityDataFactory);
        sb.append("-");
        sb.append(i);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.core.provider.FontRequestWorker.TypefaceResult KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r8, android.content.Context r9, androidx.core.provider.FontRequest r10, int r11) {
        /*
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r0 = androidx.core.provider.FontRequestWorker.BuiltInFictitiousFunctionClassFactory
            java.lang.Object r1 = r0.get(r8)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            androidx.core.provider.FontRequestWorker$TypefaceResult r8 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r8.<init>(r1)
            return r8
        L10:
            r1 = 0
            androidx.core.provider.FontsContractCompat$FontFamilyResult r10 = androidx.core.provider.FontProvider.BuiltInFictitiousFunctionClassFactory(r9, r10, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L69
            int r2 = r10.BuiltInFictitiousFunctionClassFactory()
            r3 = -3
            r4 = 1
            if (r2 == 0) goto L27
            int r2 = r10.BuiltInFictitiousFunctionClassFactory()
            if (r2 == r4) goto L25
        L23:
            r2 = -3
            goto L48
        L25:
            r2 = -2
            goto L48
        L27:
            androidx.core.provider.FontsContractCompat$FontInfo[] r2 = r10.getAuthRequestContext()
            r5 = 0
            if (r2 == 0) goto L47
            int r6 = r2.length
            if (r6 != 0) goto L32
            goto L47
        L32:
            int r4 = r2.length
            r6 = 0
        L34:
            if (r6 >= r4) goto L46
            r7 = r2[r6]
            int r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2()
            if (r7 == 0) goto L43
            if (r7 >= 0) goto L41
            goto L23
        L41:
            r2 = r7
            goto L48
        L43:
            int r6 = r6 + 1
            goto L34
        L46:
            r4 = 0
        L47:
            r2 = r4
        L48:
            if (r2 == 0) goto L50
            androidx.core.provider.FontRequestWorker$TypefaceResult r8 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r8.<init>(r2)
            return r8
        L50:
            androidx.core.provider.FontsContractCompat$FontInfo[] r10 = r10.getAuthRequestContext()
            android.graphics.Typeface r9 = androidx.core.graphics.TypefaceCompat.MyBillsEntityDataFactory(r9, r1, r10, r11)
            if (r9 == 0) goto L63
            r0.put(r8, r9)
            androidx.core.provider.FontRequestWorker$TypefaceResult r8 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r8.<init>(r9)
            return r8
        L63:
            androidx.core.provider.FontRequestWorker$TypefaceResult r8 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r8.<init>(r3)
            return r8
        L69:
            androidx.core.provider.FontRequestWorker$TypefaceResult r8 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r9 = -1
            r8.<init>(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, android.content.Context, androidx.core.provider.FontRequest, int):androidx.core.provider.FontRequestWorker$TypefaceResult");
    }

    /* loaded from: classes.dex */
    public static final class TypefaceResult {
        final int BuiltInFictitiousFunctionClassFactory;
        final Typeface PlaceComponentResult;

        TypefaceResult(int i) {
            this.PlaceComponentResult = null;
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        TypefaceResult(Typeface typeface) {
            this.PlaceComponentResult = typeface;
            this.BuiltInFictitiousFunctionClassFactory = 0;
        }

        public final boolean MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory == 0;
        }
    }
}
