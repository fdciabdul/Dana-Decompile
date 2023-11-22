package io.split.android.client.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import io.split.android.client.utils.logger.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class FileUtils {
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int getAuthRequestContext;

    public String loadFileContent(String str, Context context) throws IOException {
        String convertStreamToString;
        int i = BuiltInFictitiousFunctionClassFactory + 33;
        getAuthRequestContext = i % 128;
        Object[] objArr = null;
        try {
            if ((i % 2 != 0 ? 'b' : 'V') != 'b') {
                try {
                    Object[] objArr2 = {context.getAssets(), str};
                    Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj == null) {
                        obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - ((Process.getThreadPriority(0) + 20) >> 6)), 1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 50 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                    }
                    InputStream inputStream = (InputStream) ((Method) obj).invoke(null, objArr2);
                    convertStreamToString = convertStreamToString(inputStream);
                    inputStream.close();
                    int i2 = getAuthRequestContext + 49;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    int i3 = i2 % 2;
                    return convertStreamToString;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            try {
                Object[] objArr3 = {context.getAssets(), str};
                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj2 == null) {
                    obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (Color.blue(0) + 58133), View.resolveSizeAndState(0, 0, 0), ExpandableListView.getPackedPositionChild(0L) + 50)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                }
                InputStream inputStream2 = (InputStream) ((Method) obj2).invoke(null, objArr3);
                convertStreamToString = convertStreamToString(inputStream2);
                inputStream2.close();
                int length = objArr.length;
                int i22 = getAuthRequestContext + 49;
                BuiltInFictitiousFunctionClassFactory = i22 % 128;
                int i32 = i22 % 2;
                return convertStreamToString;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } catch (FileNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("An error has ocurred: Could not find file ");
            sb.append(str);
            Logger.e(sb.toString());
            throw e;
        } catch (IOException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("An error has ocurred: Could not open file ");
            sb2.append(str);
            Logger.e(sb2.toString());
            throw e2;
        }
    }

    private String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append("\n");
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public boolean fileExists(String str, Context context) {
        String str2;
        try {
            str2 = loadFileContent(str, context);
        } catch (IOException unused) {
            str2 = null;
        }
        return str2 != null;
    }

    public boolean isPropertiesFileName(String str) {
        if (10 < str.length()) {
            return str.substring(str.length() - 10).equals("properties");
        }
        return false;
    }
}
