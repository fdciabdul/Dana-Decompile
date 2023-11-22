package org.commonmark.renderer.text;

import java.io.IOException;

/* loaded from: classes9.dex */
public class TextContentWriter {
    public final Appendable BuiltInFictitiousFunctionClassFactory;
    public char KClassImpl$Data$declaredNonStaticMembers$2;

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            this.BuiltInFictitiousFunctionClassFactory.append(str);
            int length = str.length();
            if (length != 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = str.charAt(length - 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
