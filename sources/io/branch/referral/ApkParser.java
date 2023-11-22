package io.branch.referral;

import com.alipay.mobile.security.bio.api.BioDetector;
import com.google.common.base.Ascii;
import id.dana.data.socialshare.ShareAppKey;
import io.branch.referral.Defines;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ApkParser {
    public static JSONObject getAuthRequestContext(byte[] bArr) {
        int i;
        JSONObject jSONObject;
        String obj;
        String obj2;
        String BuiltInFictitiousFunctionClassFactory;
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        int authRequestContext = (getAuthRequestContext(bArr, 16) * 4) + 36;
        int authRequestContext2 = getAuthRequestContext(bArr, 12);
        int i2 = authRequestContext2;
        while (true) {
            i = 1048834;
            if (i2 >= bArr.length - 4) {
                break;
            } else if (getAuthRequestContext(bArr, i2) == 1048834) {
                authRequestContext2 = i2;
                break;
            } else {
                i2 += 4;
            }
        }
        String str = "";
        while (true) {
            try {
                if (authRequestContext2 >= bArr.length) {
                    jSONObject = jSONObject3;
                    break;
                }
                int authRequestContext3 = getAuthRequestContext(bArr, authRequestContext2);
                if (authRequestContext3 != i) {
                    jSONObject = jSONObject3;
                    if (authRequestContext3 != 1048835) {
                        break;
                    }
                    authRequestContext2 += 24;
                    jSONObject3 = jSONObject;
                    i = 1048834;
                } else {
                    int authRequestContext4 = getAuthRequestContext(bArr, authRequestContext2 + 28);
                    authRequestContext2 += 36;
                    int i3 = 0;
                    while (i3 < authRequestContext4) {
                        int authRequestContext5 = getAuthRequestContext(bArr, authRequestContext2 + 4);
                        int authRequestContext6 = getAuthRequestContext(bArr, authRequestContext2 + 8);
                        int authRequestContext7 = getAuthRequestContext(bArr, authRequestContext2 + 16);
                        String BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(bArr, authRequestContext, authRequestContext5);
                        int i4 = authRequestContext4;
                        jSONObject = jSONObject3;
                        if ("scheme".equals(BuiltInFictitiousFunctionClassFactory2)) {
                            if (authRequestContext6 != -1) {
                                try {
                                    BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(bArr, authRequestContext, authRequestContext6);
                                } catch (JSONException unused) {
                                    return jSONObject;
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("resourceID 0x");
                                sb.append(Integer.toHexString(authRequestContext7));
                                BuiltInFictitiousFunctionClassFactory = sb.toString();
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory)) {
                                if (!jSONObject2.has(BuiltInFictitiousFunctionClassFactory)) {
                                    jSONObject2.put(BuiltInFictitiousFunctionClassFactory, new JSONArray());
                                } else if (jSONObject2.has("0")) {
                                    jSONObject2.put(BuiltInFictitiousFunctionClassFactory, (JSONArray) jSONObject2.get("0"));
                                    jSONObject2.remove("0");
                                }
                                str = BuiltInFictitiousFunctionClassFactory;
                            }
                            if (SemanticAttributes.FaasTriggerValues.HTTP.equals(BuiltInFictitiousFunctionClassFactory) || "https".equals(BuiltInFictitiousFunctionClassFactory)) {
                                str = BuiltInFictitiousFunctionClassFactory;
                            }
                        } else if ("host".equals(BuiltInFictitiousFunctionClassFactory2)) {
                            if (authRequestContext6 != -1) {
                                obj2 = BuiltInFictitiousFunctionClassFactory(bArr, authRequestContext, authRequestContext6);
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("resourceID 0x");
                                sb2.append(Integer.toHexString(authRequestContext7));
                                obj2 = sb2.toString();
                            }
                            if (jSONObject2.has(str) && str != null && !"https".equals(str) && !SemanticAttributes.FaasTriggerValues.HTTP.equals(str)) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray(str);
                                jSONArray2.put(obj2);
                                jSONObject2.put(str, jSONArray2);
                            } else {
                                if (!"https".equals(str) && !SemanticAttributes.FaasTriggerValues.HTTP.equals(str)) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    jSONArray3.put(obj2);
                                    jSONObject2.put("0", jSONArray3);
                                }
                                jSONArray.put(obj2);
                            }
                        } else if ("name".equals(BuiltInFictitiousFunctionClassFactory2)) {
                            if (authRequestContext6 != -1) {
                                obj = BuiltInFictitiousFunctionClassFactory(bArr, authRequestContext, authRequestContext6);
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("resourceID 0x");
                                sb3.append(Integer.toHexString(authRequestContext7));
                                obj = sb3.toString();
                            }
                            if ("android.intent.action.VIEW".equals(obj)) {
                                str = null;
                            }
                        }
                        i3++;
                        authRequestContext2 += 20;
                        authRequestContext4 = i4;
                        jSONObject3 = jSONObject;
                        i = 1048834;
                    }
                }
            } catch (JSONException unused2) {
                return jSONObject3;
            }
        }
        jSONObject2.remove("0");
        jSONObject3 = jSONObject;
        jSONObject3.put(Defines.Jsonkey.URIScheme.getKey(), jSONObject2);
        jSONObject3.put(Defines.Jsonkey.AppLinks.getKey(), jSONArray);
        return jSONObject3;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return (str == null || SemanticAttributes.FaasTriggerValues.HTTP.equals(str) || str.equals("https") || str.equals(BioDetector.EXT_KEY_GEO) || str.equals("*") || str.equals("package") || str.equals(ShareAppKey.SMS) || str.equals("smsto") || str.equals("mms") || str.equals("mmsto") || str.equals("tel") || str.equals("voicemail") || str.equals("file") || str.equals("content") || str.equals("mailto")) ? false : true;
    }

    private static String BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            return null;
        }
        int authRequestContext = i + getAuthRequestContext(bArr, (i2 * 4) + 36);
        int i3 = ((bArr[authRequestContext + 1] << 8) & 65280) | (bArr[authRequestContext] & 255);
        byte[] bArr2 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr2[i4] = bArr[authRequestContext + 2 + (i4 * 2)];
        }
        return new String(bArr2);
    }

    private static int getAuthRequestContext(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 3] << Ascii.CAN) & (-16777216)) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 1] << 8) & 65280);
    }
}
