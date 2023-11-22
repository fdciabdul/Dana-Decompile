package io.branch.referral.network;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BranchRemoteInterface {
    public abstract BranchResponse BuiltInFictitiousFunctionClassFactory(String str, JSONObject jSONObject) throws BranchRemoteException;

    public abstract BranchResponse MyBillsEntityDataFactory(String str) throws BranchRemoteException;

    public final ServerResponse PlaceComponentResult(String str, JSONObject jSONObject, String str2, String str3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(KClassImpl$Data$declaredNonStaticMembers$2(jSONObject));
            String obj = sb.toString();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getting ");
            sb2.append(obj);
            PrefHelper.MyBillsEntityDataFactory(sb2.toString());
            try {
                try {
                    BranchResponse MyBillsEntityDataFactory = MyBillsEntityDataFactory(obj);
                    ServerResponse KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, str2);
                    if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                        int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        Branch BuiltInFictitiousFunctionClassFactory = Branch.BuiltInFictitiousFunctionClassFactory();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append("-");
                        sb3.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion.put(sb3.toString(), String.valueOf(currentTimeMillis2));
                    }
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                } catch (BranchRemoteException e) {
                    if (e.branchErrorCode == -111) {
                        ServerResponse serverResponse = new ServerResponse(str2, -111);
                        if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                            int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                            Branch BuiltInFictitiousFunctionClassFactory2 = Branch.BuiltInFictitiousFunctionClassFactory();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str2);
                            sb4.append("-");
                            sb4.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                            BuiltInFictitiousFunctionClassFactory2.getErrorConfigVersion.put(sb4.toString(), String.valueOf(currentTimeMillis3));
                        }
                        return serverResponse;
                    }
                    ServerResponse serverResponse2 = new ServerResponse(str2, -113);
                    if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                        int currentTimeMillis4 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        Branch BuiltInFictitiousFunctionClassFactory3 = Branch.BuiltInFictitiousFunctionClassFactory();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        sb5.append("-");
                        sb5.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                        BuiltInFictitiousFunctionClassFactory3.getErrorConfigVersion.put(sb5.toString(), String.valueOf(currentTimeMillis4));
                    }
                    return serverResponse2;
                }
            } catch (Throwable th) {
                if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                    int currentTimeMillis5 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    Branch BuiltInFictitiousFunctionClassFactory4 = Branch.BuiltInFictitiousFunctionClassFactory();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str2);
                    sb6.append("-");
                    sb6.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                    BuiltInFictitiousFunctionClassFactory4.getErrorConfigVersion.put(sb6.toString(), String.valueOf(currentTimeMillis5));
                }
                throw th;
            }
        }
        return new ServerResponse(str2, -114);
    }

    public final ServerResponse MyBillsEntityDataFactory(JSONObject jSONObject, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("posting to ");
            sb.append(str);
            PrefHelper.MyBillsEntityDataFactory(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Post value = ");
            sb2.append(jSONObject.toString());
            PrefHelper.MyBillsEntityDataFactory(sb2.toString());
            try {
                try {
                    BranchResponse BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str, jSONObject);
                    ServerResponse KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, str2);
                    if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                        int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        Branch BuiltInFictitiousFunctionClassFactory2 = Branch.BuiltInFictitiousFunctionClassFactory();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str2);
                        sb3.append("-");
                        sb3.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                        BuiltInFictitiousFunctionClassFactory2.getErrorConfigVersion.put(sb3.toString(), String.valueOf(currentTimeMillis2));
                    }
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                } catch (BranchRemoteException e) {
                    if (e.branchErrorCode == -111) {
                        ServerResponse serverResponse = new ServerResponse(str2, -111);
                        if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                            int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                            Branch BuiltInFictitiousFunctionClassFactory3 = Branch.BuiltInFictitiousFunctionClassFactory();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str2);
                            sb4.append("-");
                            sb4.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                            BuiltInFictitiousFunctionClassFactory3.getErrorConfigVersion.put(sb4.toString(), String.valueOf(currentTimeMillis3));
                        }
                        return serverResponse;
                    }
                    ServerResponse serverResponse2 = new ServerResponse(str2, -113);
                    if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                        int currentTimeMillis4 = (int) (System.currentTimeMillis() - currentTimeMillis);
                        Branch BuiltInFictitiousFunctionClassFactory4 = Branch.BuiltInFictitiousFunctionClassFactory();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        sb5.append("-");
                        sb5.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                        BuiltInFictitiousFunctionClassFactory4.getErrorConfigVersion.put(sb5.toString(), String.valueOf(currentTimeMillis4));
                    }
                    return serverResponse2;
                }
            } catch (Throwable th) {
                if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                    int currentTimeMillis5 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    Branch BuiltInFictitiousFunctionClassFactory5 = Branch.BuiltInFictitiousFunctionClassFactory();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str2);
                    sb6.append("-");
                    sb6.append(Defines.Jsonkey.Branch_Round_Trip_Time.getKey());
                    BuiltInFictitiousFunctionClassFactory5.getErrorConfigVersion.put(sb6.toString(), String.valueOf(currentTimeMillis5));
                }
                throw th;
            }
        }
        return new ServerResponse(str2, -114);
    }

    public static final BranchRemoteInterface getAuthRequestContext(Context context) {
        return new BranchRemoteInterfaceUrlConnection(context);
    }

    private static ServerResponse KClassImpl$Data$declaredNonStaticMembers$2(String str, int i, String str2) {
        ServerResponse serverResponse = new ServerResponse(str2, i);
        StringBuilder sb = new StringBuilder();
        sb.append("returned ");
        sb.append(str);
        PrefHelper.MyBillsEntityDataFactory(sb.toString());
        if (str != null) {
            try {
                try {
                    serverResponse.PlaceComponentResult = new JSONObject(str);
                } catch (JSONException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("JSON exception: ");
                    sb2.append(e.getMessage());
                    PrefHelper.MyBillsEntityDataFactory(sb2.toString());
                }
            } catch (JSONException unused) {
                serverResponse.PlaceComponentResult = new JSONArray(str);
            }
        }
        return serverResponse;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(Defines.Jsonkey.UserData.getKey())) {
                jSONObject.put(Defines.Jsonkey.SDK.getKey(), "android4.1.0");
            }
            if (str.equals("bnc_no_value")) {
                return false;
            }
            jSONObject.put(Defines.Jsonkey.BranchKey.getKey(), str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
        JSONArray names;
        StringBuilder sb = new StringBuilder();
        if (jSONObject != null && (names = jSONObject.names()) != null) {
            int length = names.length();
            boolean z = true;
            for (int i = 0; i < length; i++) {
                try {
                    String string = names.getString(i);
                    if (z) {
                        sb.append("?");
                        z = false;
                    } else {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    String string2 = jSONObject.getString(string);
                    sb.append(string);
                    sb.append("=");
                    sb.append(string2);
                } catch (JSONException unused) {
                    return null;
                }
            }
        }
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static class BranchResponse {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final String getAuthRequestContext;

        public BranchResponse(String str, int i) {
            this.getAuthRequestContext = str;
            this.BuiltInFictitiousFunctionClassFactory = i;
        }
    }

    /* loaded from: classes6.dex */
    public static class BranchRemoteException extends Exception {
        private int branchErrorCode;

        public BranchRemoteException(int i) {
            this.branchErrorCode = i;
        }
    }
}
