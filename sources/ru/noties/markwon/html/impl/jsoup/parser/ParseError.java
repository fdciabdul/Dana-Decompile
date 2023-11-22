package ru.noties.markwon.html.impl.jsoup.parser;

/* loaded from: classes6.dex */
public class ParseError {
    private String PlaceComponentResult;
    private int getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseError(int i, String str) {
        this.getAuthRequestContext = i;
        this.PlaceComponentResult = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseError(int i, String str, Object... objArr) {
        this.PlaceComponentResult = String.format(str, objArr);
        this.getAuthRequestContext = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAuthRequestContext);
        sb.append(": ");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }
}
