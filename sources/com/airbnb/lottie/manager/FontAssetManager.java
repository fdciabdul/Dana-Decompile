package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class FontAssetManager {
    public FontAssetDelegate PlaceComponentResult;
    public final AssetManager getAuthRequestContext;
    public final MutablePair<String> scheduleImpl = new MutablePair<>();
    public final Map<MutablePair<String>, Typeface> BuiltInFictitiousFunctionClassFactory = new HashMap();
    public final Map<String, Typeface> MyBillsEntityDataFactory = new HashMap();
    public String KClassImpl$Data$declaredNonStaticMembers$2 = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        this.PlaceComponentResult = fontAssetDelegate;
        if (!(callback instanceof View)) {
            Logger.getAuthRequestContext("LottieDrawable must be inside of a view for images to work.");
            this.getAuthRequestContext = null;
            return;
        }
        this.getAuthRequestContext = ((View) callback).getContext().getAssets();
    }

    public static Typeface getAuthRequestContext(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : InstrumentInjector.typefaceCreateDerived(typeface, i);
    }
}
