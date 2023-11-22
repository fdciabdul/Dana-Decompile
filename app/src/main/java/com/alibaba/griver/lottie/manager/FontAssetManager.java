package com.alibaba.griver.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.lottie.FontAssetDelegate;
import com.alibaba.griver.lottie.model.Font;
import com.alibaba.griver.lottie.model.MutablePair;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.zebra.data.TextData;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class FontAssetManager {
    private static final String TAG = "FontAssetManager";
    private final AssetManager assetManager;
    private String defaultFontFileExtension;
    private FontAssetDelegate delegate;
    private final Map<String, Integer> weightMap;
    private final MutablePair<String> tempPair = new MutablePair<>();
    private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    private final Map<String, Typeface> fontNames = new HashMap();

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        HashMap hashMap = new HashMap();
        this.weightMap = hashMap;
        this.defaultFontFileExtension = ".ttf";
        this.delegate = fontAssetDelegate;
        if (!(callback instanceof View)) {
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
        hashMap.put("thin", 100);
        hashMap.put("extralight", 200);
        hashMap.put("ultralight", 200);
        hashMap.put("light", 300);
        hashMap.put("normal", 400);
        hashMap.put("regular", 400);
        hashMap.put("medium", 500);
        hashMap.put("semibold", 600);
        hashMap.put("demibold", 600);
        hashMap.put(TextData.FONT_WEIGHT_BOLD, 700);
        hashMap.put("extrabold", 800);
        hashMap.put("ultrabold", 800);
        hashMap.put("black", Integer.valueOf((int) SecExceptionCode.SEC_ERROR_UMID_VALID));
        hashMap.put("heavy", Integer.valueOf((int) SecExceptionCode.SEC_ERROR_UMID_VALID));
    }

    public void setDelegate(FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }

    public void setDefaultFontFileExtension(String str) {
        this.defaultFontFileExtension = str;
    }

    public Typeface getTypeface(String str, String str2, String str3) {
        this.tempPair.set(str2, str3);
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        try {
            Typeface font = getFont(str, str2);
            if (Build.VERSION.SDK_INT >= 28) {
                typeface = typefaceForStyleNew(font, str3);
            } else {
                typeface = typefaceForStyle(font, str3);
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("typefaceForStyle exception:");
            sb.append(th);
            GriverLogger.e(TAG, sb.toString());
        }
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        this.fontMap.put(this.tempPair, typeface);
        return typeface;
    }

    private Typeface getFont(String str, String str2) {
        String fontPath;
        Typeface typeface = this.fontNames.get(str2);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate fontAssetDelegate = this.delegate;
        Typeface fetchFont = fontAssetDelegate != null ? fontAssetDelegate.fetchFont(str2) : null;
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        if (fontAssetDelegate2 != null && fetchFont == null && (fontPath = fontAssetDelegate2.getFontPath(str2)) != null) {
            fetchFont = InstrumentInjector.typefaceCreateFromAsset(this.assetManager, fontPath);
        }
        if (fetchFont == null) {
            if (Font.FONT_DEFAULT.equals(str) && Font.FONT_DEFAULT.equals(str2)) {
                fetchFont = Typeface.DEFAULT;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("fonts/");
                sb.append(str);
                sb.append(this.defaultFontFileExtension);
                try {
                    fetchFont = InstrumentInjector.typefaceCreateFromAsset(this.assetManager, sb.toString());
                } catch (RuntimeException e) {
                    InstrumentInjector.log_w("Lottie", "获取字体异常：", e);
                    fetchFont = Typeface.DEFAULT;
                }
            }
        }
        this.fontNames.put(str2, fetchFont);
        return fetchFont;
    }

    private Typeface typefaceForStyleNew(Typeface typeface, String str) {
        String lowerCase = str.toLowerCase();
        boolean contains = lowerCase.contains("italic");
        Integer num = this.weightMap.get(lowerCase.replace("italic", "").replace("-", "").replace(" ", ""));
        return Typeface.create(typeface, num != null ? num.intValue() : 400, contains);
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        String lowerCase = str.toLowerCase();
        boolean contains = lowerCase.contains("italic");
        boolean contains2 = lowerCase.contains(TextData.FONT_WEIGHT_BOLD);
        int i = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : InstrumentInjector.typefaceCreateDerived(typeface, i);
    }
}
