package com.twilio.security.storage;

import android.util.Base64;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class EncryptedPreferencesKt {
    public static final String getAuthRequestContext(String str) {
        Intrinsics.checkParameterIsNotNull(str, "");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Debug;
        StringBuilder sb = new StringBuilder();
        sb.append("Generating key digest for ");
        sb.append(str);
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "");
        String encodeToString = Base64.encodeToString(messageDigest.digest(bytes), 0);
        Logger logger2 = Logger.PlaceComponentResult;
        Level level2 = Level.Debug;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Generated key digest for ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(encodeToString);
        Logger.MyBillsEntityDataFactory(level2, sb2.toString());
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "");
        return encodeToString;
    }
}
