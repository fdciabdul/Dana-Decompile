package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes3.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {
    private final HttpURLConnection PlaceComponentResult;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.PlaceComponentResult = httpURLConnection;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult.getResponseCode() / 100 == 2;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public final InputStream KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        return this.PlaceComponentResult.getInputStream();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public final String BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.getContentType();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public final String PlaceComponentResult() {
        try {
            if (getAuthRequestContext()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to fetch ");
            sb.append(this.PlaceComponentResult.getURL());
            sb.append(". Failed with ");
            sb.append(this.PlaceComponentResult.getResponseCode());
            sb.append("\n");
            sb.append(MyBillsEntityDataFactory(this.PlaceComponentResult));
            return sb.toString();
        } catch (IOException e) {
            Logger.getAuthRequestContext("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.PlaceComponentResult.disconnect();
    }

    private static String MyBillsEntityDataFactory(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
