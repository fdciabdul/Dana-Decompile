package ru.noties.markwon.html.impl;

import ru.noties.markwon.html.api.HtmlTag;

/* loaded from: classes6.dex */
public class HtmlEmptyTagReplacement {
    public static HtmlEmptyTagReplacement getAuthRequestContext() {
        return new HtmlEmptyTagReplacement();
    }

    public static String MyBillsEntityDataFactory(HtmlTag htmlTag) {
        String errorConfigVersion = htmlTag.getErrorConfigVersion();
        if ("br".equals(errorConfigVersion)) {
            return "\n";
        }
        if ("img".equals(errorConfigVersion)) {
            String str = htmlTag.BuiltInFictitiousFunctionClassFactory().get("alt");
            return (str == null || str.length() == 0) ? "￼" : str;
        }
        return null;
    }
}
