package o;

import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
public final class getErrorConfigVersion extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public getErrorConfigVersion(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        OAuthResult oAuthResult = (OAuthResult) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (oAuthResult != oAuthResult.authCode) {
            j.PlaceComponentResult(jsonWriter, 172);
            jsonWriter.value(oAuthResult.authCode);
        }
        if (oAuthResult != oAuthResult.authErrorScopes) {
            j.PlaceComponentResult(jsonWriter, 417);
            BuiltInFictitiousFunctionClassFactory builtInFictitiousFunctionClassFactory = new BuiltInFictitiousFunctionClassFactory();
            Map<String, String> map = oAuthResult.authErrorScopes;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, builtInFictitiousFunctionClassFactory, map).write(jsonWriter, map);
        }
        if (oAuthResult != oAuthResult.authRedirectUrl) {
            j.PlaceComponentResult(jsonWriter, 342);
            jsonWriter.value(oAuthResult.authRedirectUrl);
        }
        if (oAuthResult != oAuthResult.authState) {
            j.PlaceComponentResult(jsonWriter, 226);
            jsonWriter.value(oAuthResult.authState);
        }
        if (oAuthResult != oAuthResult.authSuccessScopes) {
            j.PlaceComponentResult(jsonWriter, 506);
            String[] strArr = oAuthResult.authSuccessScopes;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, String[].class, strArr).write(jsonWriter, strArr);
        }
        oAuthResult.PlaceComponentResult(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        OAuthResult oAuthResult = new OAuthResult();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 138) {
                if (authRequestContext != 279) {
                    if (authRequestContext != 317) {
                        if (authRequestContext != 429) {
                            if (authRequestContext != 442) {
                                oAuthResult.MyBillsEntityDataFactory(gson, jsonReader, authRequestContext);
                            } else if (z) {
                                oAuthResult.authCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                oAuthResult.authCode = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            oAuthResult.authRedirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            oAuthResult.authRedirectUrl = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        oAuthResult.authErrorScopes = (Map) gson.getAdapter(new BuiltInFictitiousFunctionClassFactory()).read2(jsonReader);
                    } else {
                        oAuthResult.authErrorScopes = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    oAuthResult.authState = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    oAuthResult.authState = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                oAuthResult.authSuccessScopes = (String[]) gson.getAdapter(String[].class).read2(jsonReader);
            } else {
                oAuthResult.authSuccessScopes = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return oAuthResult;
    }
}
