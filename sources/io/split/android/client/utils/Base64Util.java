package io.split.android.client.utils;

import android.util.Base64;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class Base64Util {
    public static String decode(String str) {
        byte[] bytesDecode = bytesDecode(str);
        if (bytesDecode != null) {
            return StringHelper.stringFromBytes(bytesDecode);
        }
        return null;
    }

    public static byte[] bytesDecode(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Received bytes didn't correspond to a valid Base64 encoded string.");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return null;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("An unknown error has ocurred ");
            sb2.append(e2.getLocalizedMessage());
            Logger.e(sb2.toString());
            return null;
        }
    }

    public static String encode(String str) {
        try {
            return StringHelper.stringFromBytes(Base64.encode(str.getBytes(StringHelper.defaultCharset()), 0));
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Received bytes didn't correspond to a valid Base64 encoded string.");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return null;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("An unknown error has ocurred ");
            sb2.append(e2.getLocalizedMessage());
            Logger.e(sb2.toString());
            return null;
        }
    }

    public static String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }
}
