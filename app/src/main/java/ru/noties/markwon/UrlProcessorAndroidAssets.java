package ru.noties.markwon;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes9.dex */
public class UrlProcessorAndroidAssets implements UrlProcessor {
    private final UrlProcessor BuiltInFictitiousFunctionClassFactory;
    private final UrlProcessorRelativeToAbsolute getAuthRequestContext;

    public UrlProcessorAndroidAssets() {
        this((byte) 0);
    }

    private UrlProcessorAndroidAssets(byte b) {
        this.getAuthRequestContext = new UrlProcessorRelativeToAbsolute("https://android.asset/");
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    @Override // ru.noties.markwon.UrlProcessor
    public final String PlaceComponentResult(String str) {
        if (TextUtils.isEmpty(Uri.parse(str).getScheme())) {
            return this.getAuthRequestContext.PlaceComponentResult(str).replace("https://android.asset/", "file:///android_asset/");
        }
        UrlProcessor urlProcessor = this.BuiltInFictitiousFunctionClassFactory;
        return urlProcessor != null ? urlProcessor.PlaceComponentResult(str) : str;
    }
}
