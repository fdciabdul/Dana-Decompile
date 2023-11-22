package ru.noties.markwon;

import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes9.dex */
public class UrlProcessorRelativeToAbsolute implements UrlProcessor {
    private final URL BuiltInFictitiousFunctionClassFactory;

    public UrlProcessorRelativeToAbsolute(String str) {
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory(str);
    }

    @Override // ru.noties.markwon.UrlProcessor
    public final String PlaceComponentResult(String str) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            try {
                return new URL(this.BuiltInFictitiousFunctionClassFactory, str).toString();
            } catch (MalformedURLException unused) {
                return str;
            }
        }
        return str;
    }

    private static URL MyBillsEntityDataFactory(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
