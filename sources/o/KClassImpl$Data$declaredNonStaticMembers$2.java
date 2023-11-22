package o;

import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class KClassImpl$Data$declaredNonStaticMembers$2 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;

    public KClassImpl$Data$declaredNonStaticMembers$2(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(jsonWriter, obj == OAuthCodeFlowType.ALIPAY_CONNECT ? 130 : obj == OAuthCodeFlowType.LOCAL_MINI_PROGRAM ? 196 : obj == OAuthCodeFlowType.STANDARD ? 156 : -1);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        int MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(jsonReader);
        if (MyBillsEntityDataFactory != 74) {
            if (MyBillsEntityDataFactory != 487) {
                if (MyBillsEntityDataFactory != 495) {
                    return null;
                }
                return OAuthCodeFlowType.ALIPAY_CONNECT;
            }
            return OAuthCodeFlowType.LOCAL_MINI_PROGRAM;
        }
        return OAuthCodeFlowType.STANDARD;
    }
}
