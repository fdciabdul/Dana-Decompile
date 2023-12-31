package com.google.zxing.client.result;

/* loaded from: classes7.dex */
public final class TextParsedResult extends ParsedResult {
    private final String language;
    private final String text;

    public TextParsedResult(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.text = str;
        this.language = str2;
    }

    public final String getText() {
        return this.text;
    }

    public final String getLanguage() {
        return this.language;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public final String getDisplayResult() {
        return this.text;
    }
}
