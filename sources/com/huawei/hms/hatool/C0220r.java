package com.huawei.hms.hatool;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import o.E;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.r  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0220r implements s {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = -956812108;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
    private static long getErrorConfigVersion = 4360990799332652212L;
    private static int lookAheadTest = 0;
    private static char scheduleImpl = 20889;
    public s BuiltInFictitiousFunctionClassFactory;
    public p KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory = "";
    public List<q> PlaceComponentResult;
    public o getAuthRequestContext;
    public String moveToNextValue;

    public C0220r(String str) {
        this.moveToNextValue = str;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = lookAheadTest + 89;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        Object[] objArr = null;
        if (i % 2 == 0) {
            objArr.hashCode();
            if (!(str != null)) {
                return;
            }
        } else {
            if (str == null) {
                return;
            }
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 91;
        lookAheadTest = i2 % 128;
        if (i2 % 2 != 0) {
            this.MyBillsEntityDataFactory = str;
            int length = objArr.length;
            return;
        }
        try {
            this.MyBillsEntityDataFactory = str;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<q> list) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 7;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        this.PlaceComponentResult = list;
        if (!z) {
            return;
        }
        int i2 = 32 / 0;
    }

    public final void MyBillsEntityDataFactory(o oVar) {
        int i = lookAheadTest + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if (i % 2 != 0) {
            this.getAuthRequestContext = oVar;
            return;
        }
        try {
            this.getAuthRequestContext = oVar;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.huawei.hms.hatool.s
    public final JSONObject PlaceComponentResult() {
        String str;
        int i;
        List<q> list = this.PlaceComponentResult;
        if ((list != null) && list.size() != 0) {
            if ((this.getAuthRequestContext != null ? (char) 22 : ']') != 22 || this.KClassImpl$Data$declaredNonStaticMembers$2 == null || this.BuiltInFictitiousFunctionClassFactory == null) {
                str = "model in wrong format";
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(InvoiceConstant.HEADER, this.getAuthRequestContext.PlaceComponentResult());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                PlaceComponentResult.put("properties", this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
                try {
                    PlaceComponentResult.put("events_global_properties", new JSONObject(this.MyBillsEntityDataFactory));
                } catch (JSONException unused) {
                    PlaceComponentResult.put("events_global_properties", this.MyBillsEntityDataFactory);
                }
                jSONObject2.put("events_common", PlaceComponentResult);
                JSONArray jSONArray = new JSONArray();
                Iterator<q> it = this.PlaceComponentResult.iterator();
                while (true) {
                    if ((it.hasNext() ? 'T' : (char) 25) == 25) {
                        break;
                    }
                    JSONObject PlaceComponentResult2 = it.next().PlaceComponentResult();
                    if (PlaceComponentResult2 != null) {
                        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 51;
                        lookAheadTest = i2 % 128;
                        int i3 = i2 % 2;
                        jSONArray.put(PlaceComponentResult2);
                        i = lookAheadTest + 91;
                        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                    } else {
                        y.PlaceComponentResult("hmsSdk", "custom event is empty,delete this event");
                        i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 25;
                        lookAheadTest = i % 128;
                    }
                    int i4 = i % 2;
                }
                jSONObject2.put("events", jSONArray);
                String jSONObject3 = jSONObject2.toString();
                try {
                    Object[] objArr = new Object[1];
                    a(new char[]{8201, 48944, 9009, 20181, 5640}, new char[]{22617, 12939, 20715, 16512}, (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 32848), new char[]{0, 0, 0, 0}, Color.argb(0, 0, 0, 0) - 349009064, objArr);
                    String BuiltInFictitiousFunctionClassFactory = d.BuiltInFictitiousFunctionClassFactory(t0.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject3.getBytes(((String) objArr[0]).intern())), this.moveToNextValue);
                    if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
                        y.PlaceComponentResult("hmsSdk", "eventInfo encrypt failed,report over!");
                        return null;
                    }
                    jSONObject.put("event", BuiltInFictitiousFunctionClassFactory);
                    return jSONObject;
                } catch (UnsupportedEncodingException unused2) {
                    str = "getBitZip(): Unsupported coding : utf-8";
                }
            }
        } else {
            str = "Not have actionEvent to send";
        }
        y.PlaceComponentResult("hmsSdk", str);
        return null;
    }

    public final void PlaceComponentResult(e1 e1Var) {
        int i = lookAheadTest + 13;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        Object[] objArr = null;
        if (!(i % 2 != 0)) {
            try {
                this.BuiltInFictitiousFunctionClassFactory = e1Var;
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.BuiltInFictitiousFunctionClassFactory = e1Var;
        }
        int i2 = lookAheadTest + 57;
        try {
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void PlaceComponentResult(p pVar) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 11;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        Object[] objArr = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pVar;
        if (z) {
            int length = objArr.length;
        }
        int i2 = lookAheadTest + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 25 : 'R') != 'R') {
            objArr.hashCode();
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $10 + 35;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? '9' : (char) 23) != '9') {
                objArr[0] = new String(cArr6);
                return;
            }
            int i4 = $10 + 9;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
            cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
            cArr4[i7] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getErrorConfigVersion ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4360990799332652212L))) ^ ((char) (scheduleImpl ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
    }
}
