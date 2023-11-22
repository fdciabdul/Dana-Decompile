package com.google.zxing.client.result;

import com.google.zxing.Result;
import id.dana.cashier.view.InputCardNumberView;

/* loaded from: classes7.dex */
public final class AddressBookDoCoMoResultParser extends AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public final AddressBookParsedResult parse(Result result) {
        String[] matchDoCoMoPrefixedField;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("MECARD:") && (matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("N:", massagedText, true)) != null) {
            String parseName = parseName(matchDoCoMoPrefixedField[0]);
            String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("SOUND:", massagedText, true);
            String[] matchDoCoMoPrefixedField2 = matchDoCoMoPrefixedField("TEL:", massagedText, true);
            String[] matchDoCoMoPrefixedField3 = matchDoCoMoPrefixedField("EMAIL:", massagedText, true);
            String matchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("NOTE:", massagedText, false);
            String[] matchDoCoMoPrefixedField4 = matchDoCoMoPrefixedField("ADR:", massagedText, true);
            String matchSingleDoCoMoPrefixedField3 = matchSingleDoCoMoPrefixedField("BDAY:", massagedText, true);
            return new AddressBookParsedResult(maybeWrap(parseName), null, matchSingleDoCoMoPrefixedField, matchDoCoMoPrefixedField2, null, matchDoCoMoPrefixedField3, null, null, matchSingleDoCoMoPrefixedField2, matchDoCoMoPrefixedField4, null, matchSingleDoCoMoPrefixedField("ORG:", massagedText, true), !isStringOfDigits(matchSingleDoCoMoPrefixedField3, 8) ? null : matchSingleDoCoMoPrefixedField3, null, matchDoCoMoPrefixedField("URL:", massagedText, true), null);
        }
        return null;
    }

    private static String parseName(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(indexOf + 1));
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(str.substring(0, indexOf));
            return sb.toString();
        }
        return str;
    }
}
