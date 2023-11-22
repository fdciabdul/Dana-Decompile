package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes7.dex */
final class zae implements zai<Boolean> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Boolean zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        boolean zay;
        zay = fastParser.zay(bufferedReader, false);
        return Boolean.valueOf(zay);
    }
}
