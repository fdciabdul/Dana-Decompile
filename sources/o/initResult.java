package o;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class initResult extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public initResult(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SendMoneyScenarioEntity sendMoneyScenarioEntity = (SendMoneyScenarioEntity) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.action) {
            j.PlaceComponentResult(jsonWriter, 438);
            jsonWriter.value(sendMoneyScenarioEntity.action);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.clientId) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED);
            jsonWriter.value(sendMoneyScenarioEntity.clientId);
        }
        j.PlaceComponentResult(jsonWriter, 494);
        jsonWriter.value(sendMoneyScenarioEntity.hasRedDot);
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.httpMethod) {
            j.PlaceComponentResult(jsonWriter, 493);
            jsonWriter.value(sendMoneyScenarioEntity.httpMethod);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.icon) {
            j.PlaceComponentResult(jsonWriter, 418);
            jsonWriter.value(sendMoneyScenarioEntity.icon);
        }
        j.PlaceComponentResult(jsonWriter, 369);
        jsonWriter.value(sendMoneyScenarioEntity.isNew);
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.key) {
            j.PlaceComponentResult(jsonWriter, 318);
            jsonWriter.value(sendMoneyScenarioEntity.key);
        }
        j.PlaceComponentResult(jsonWriter, 590);
        jsonWriter.value(sendMoneyScenarioEntity.promoActive);
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.promoDesc) {
            j.PlaceComponentResult(jsonWriter, 446);
            jsonWriter.value(sendMoneyScenarioEntity.promoDesc);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.promoTitle) {
            j.PlaceComponentResult(jsonWriter, 588);
            jsonWriter.value(sendMoneyScenarioEntity.promoTitle);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.redirectUrl) {
            j.PlaceComponentResult(jsonWriter, 467);
            jsonWriter.value(sendMoneyScenarioEntity.redirectUrl);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.scopes) {
            j.PlaceComponentResult(jsonWriter, 392);
            jsonWriter.value(sendMoneyScenarioEntity.scopes);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.subTitle) {
            j.PlaceComponentResult(jsonWriter, 96);
            jsonWriter.value(sendMoneyScenarioEntity.subTitle);
        }
        if (sendMoneyScenarioEntity != sendMoneyScenarioEntity.title) {
            j.PlaceComponentResult(jsonWriter, 403);
            jsonWriter.value(sendMoneyScenarioEntity.title);
        }
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SendMoneyScenarioEntity sendMoneyScenarioEntity = new SendMoneyScenarioEntity();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 72:
                    if (!z) {
                        sendMoneyScenarioEntity.key = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.key = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 125:
                    if (!z) {
                        sendMoneyScenarioEntity.scopes = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.scopes = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 143:
                    if (!z) {
                        sendMoneyScenarioEntity.promoDesc = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.promoDesc = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 190:
                    if (!z) {
                        sendMoneyScenarioEntity.title = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 207:
                    if (!z) {
                        break;
                    } else {
                        sendMoneyScenarioEntity.promoActive = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /* 212 */:
                    if (!z) {
                        sendMoneyScenarioEntity.action = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.action = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 265:
                    if (!z) {
                        sendMoneyScenarioEntity.promoTitle = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.promoTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED /* 306 */:
                    if (!z) {
                        sendMoneyScenarioEntity.clientId = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.clientId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 313:
                    if (!z) {
                        sendMoneyScenarioEntity.subTitle = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.subTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 340:
                    if (!z) {
                        break;
                    } else {
                        sendMoneyScenarioEntity.isNew = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                    if (!z) {
                        sendMoneyScenarioEntity.redirectUrl = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 397:
                    if (!z) {
                        break;
                    } else {
                        sendMoneyScenarioEntity.hasRedDot = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 524:
                    if (!z) {
                        sendMoneyScenarioEntity.icon = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.icon = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 531:
                    if (!z) {
                        sendMoneyScenarioEntity.httpMethod = null;
                        break;
                    } else {
                        sendMoneyScenarioEntity.httpMethod = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return sendMoneyScenarioEntity;
    }
}
