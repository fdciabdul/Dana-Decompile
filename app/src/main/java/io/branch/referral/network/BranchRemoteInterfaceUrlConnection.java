package io.branch.referral.network;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.framework.common.ContainerUtils;
import io.branch.referral.PrefHelper;
import io.branch.referral.network.BranchRemoteInterface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class BranchRemoteInterfaceUrlConnection extends BranchRemoteInterface {
    private PrefHelper BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BranchRemoteInterfaceUrlConnection(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
    }

    @Override // io.branch.referral.network.BranchRemoteInterface
    public final BranchRemoteInterface.BranchResponse MyBillsEntityDataFactory(String str) throws BranchRemoteInterface.BranchRemoteException {
        return MyBillsEntityDataFactory(str, 0);
    }

    @Override // io.branch.referral.network.BranchRemoteInterface
    public final BranchRemoteInterface.BranchResponse BuiltInFictitiousFunctionClassFactory(String str, JSONObject jSONObject) throws BranchRemoteInterface.BranchRemoteException {
        return PlaceComponentResult(str, jSONObject, 0);
    }

    private static String getAuthRequestContext(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new BufferedReader(new InputStreamReader(inputStream)).readLine();
            } catch (IOException unused) {
            }
        }
        return null;
    }

    private BranchRemoteInterface.BranchResponse MyBillsEntityDataFactory(String str, int i) throws BranchRemoteInterface.BranchRemoteException {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                int i2 = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_timeout", 5500);
                if (i2 <= 0) {
                    i2 = 3000;
                }
                String str2 = str.contains("?") ? ContainerUtils.FIELD_DELIMITER : "?";
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str2);
                sb.append("retryNumber");
                sb.append("=");
                sb.append(i);
                httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(sb.toString()).openConnection())));
                try {
                    httpsURLConnection.setConnectTimeout(i2);
                    httpsURLConnection.setReadTimeout(i2);
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 500 && i < PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_retry_count", 3)) {
                        try {
                            Thread.sleep(PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_retry_interval", 1000));
                        } catch (InterruptedException unused) {
                        }
                        BranchRemoteInterface.BranchResponse MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, i + 1);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        return MyBillsEntityDataFactory;
                    }
                    if (responseCode != 200) {
                        try {
                            if (httpsURLConnection.getErrorStream() != null) {
                                BranchRemoteInterface.BranchResponse branchResponse = new BranchRemoteInterface.BranchResponse(getAuthRequestContext(httpsURLConnection.getErrorStream()), responseCode);
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                return branchResponse;
                            }
                        } catch (FileNotFoundException unused2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("A resource conflict occurred with this request ");
                            sb2.append(str);
                            PrefHelper.MyBillsEntityDataFactory(sb2.toString());
                            BranchRemoteInterface.BranchResponse branchResponse2 = new BranchRemoteInterface.BranchResponse(null, responseCode);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            return branchResponse2;
                        }
                    }
                    BranchRemoteInterface.BranchResponse branchResponse3 = new BranchRemoteInterface.BranchResponse(getAuthRequestContext(httpsURLConnection.getInputStream()), responseCode);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    return branchResponse3;
                } catch (SocketException e) {
                    e = e;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Http connect exception: ");
                    sb3.append(e.getMessage());
                    PrefHelper.MyBillsEntityDataFactory(sb3.toString());
                    throw new BranchRemoteInterface.BranchRemoteException(-113);
                } catch (SocketTimeoutException unused3) {
                    httpsURLConnection2 = httpsURLConnection;
                    if (i < PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_retry_count", 3)) {
                        try {
                            Thread.sleep(PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_retry_interval", 1000));
                        } catch (InterruptedException unused4) {
                        }
                        BranchRemoteInterface.BranchResponse MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(str, i + 1);
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        return MyBillsEntityDataFactory2;
                    }
                    throw new BranchRemoteInterface.BranchRemoteException(-111);
                } catch (IOException e2) {
                    e = e2;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Branch connect exception: ");
                    sb4.append(e.getMessage());
                    PrefHelper.MyBillsEntityDataFactory(sb4.toString());
                    throw new BranchRemoteInterface.BranchRemoteException(-113);
                } catch (Throwable th) {
                    th = th;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (SocketException e3) {
                e = e3;
            } catch (SocketTimeoutException unused5) {
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            httpsURLConnection = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.branch.referral.network.BranchRemoteInterface.BranchResponse PlaceComponentResult(java.lang.String r13, org.json.JSONObject r14, int r15) throws io.branch.referral.network.BranchRemoteInterface.BranchRemoteException {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterfaceUrlConnection.PlaceComponentResult(java.lang.String, org.json.JSONObject, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse");
    }
}
