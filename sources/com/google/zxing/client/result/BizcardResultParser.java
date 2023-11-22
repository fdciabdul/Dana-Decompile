package com.google.zxing.client.result;

import com.google.zxing.Result;
import id.dana.cashier.view.InputCardNumberView;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public final AddressBookParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("BIZCARD:")) {
            String buildName = buildName(matchSingleDoCoMoPrefixedField("N:", massagedText, true), matchSingleDoCoMoPrefixedField("X:", massagedText, true));
            String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("T:", massagedText, true);
            String matchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("C:", massagedText, true);
            return new AddressBookParsedResult(maybeWrap(buildName), null, null, buildPhoneNumbers(matchSingleDoCoMoPrefixedField("B:", massagedText, true), matchSingleDoCoMoPrefixedField("M:", massagedText, true), matchSingleDoCoMoPrefixedField("F:", massagedText, true)), null, maybeWrap(matchSingleDoCoMoPrefixedField("E:", massagedText, true)), null, null, null, matchDoCoMoPrefixedField("A:", massagedText, true), null, matchSingleDoCoMoPrefixedField2, null, matchSingleDoCoMoPrefixedField, null, null);
        }
        return null;
    }

    private static String[] buildPhoneNumbers(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String buildName(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(str2);
        return sb.toString();
    }
}
