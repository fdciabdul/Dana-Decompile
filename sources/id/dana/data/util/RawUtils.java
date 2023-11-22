package id.dana.data.util;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public class RawUtils {
    private RawUtils() {
    }

    public static String jsonRawToString(Context context, int i) {
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, StandardCharsets.UTF_8));
                try {
                    StringWriter stringWriter = new StringWriter();
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    String obj = stringWriter.toString();
                    bufferedReader.close();
                    if (openRawResource != null) {
                        openRawResource.close();
                    }
                    return obj;
                } finally {
                }
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
