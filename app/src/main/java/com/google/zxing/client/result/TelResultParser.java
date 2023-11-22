package com.google.zxing.client.result;

import com.google.zxing.Result;

/* loaded from: classes7.dex */
public final class TelResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public final TelParsedResult parse(Result result) {
        String str;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("tel:") || massagedText.startsWith("TEL:")) {
            if (massagedText.startsWith("TEL:")) {
                StringBuilder sb = new StringBuilder("tel:");
                sb.append(massagedText.substring(4));
                str = sb.toString();
            } else {
                str = massagedText;
            }
            int indexOf = massagedText.indexOf(63, 4);
            return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
        }
        return null;
    }
}
