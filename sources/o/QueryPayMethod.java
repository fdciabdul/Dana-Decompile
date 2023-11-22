package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.profilemenu.model.SettingEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class QueryPayMethod extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public QueryPayMethod(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SettingEntity settingEntity = (SettingEntity) obj;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        if (settingEntity != settingEntity.action) {
            j.PlaceComponentResult(jsonWriter, 438);
            jsonWriter.value(settingEntity.action);
        }
        if (settingEntity != settingEntity.collection) {
            j.PlaceComponentResult(jsonWriter, 68);
            jsonWriter.value(settingEntity.collection);
        }
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(settingEntity.enable);
        j.PlaceComponentResult(jsonWriter, 37);
        jsonWriter.value(settingEntity.hasReddot);
        if (settingEntity != settingEntity.iconUrl) {
            j.PlaceComponentResult(jsonWriter, 454);
            jsonWriter.value(settingEntity.iconUrl);
        }
        j.PlaceComponentResult(jsonWriter, 337);
        jsonWriter.value(settingEntity.nullObject);
        j.PlaceComponentResult(jsonWriter, 251);
        jsonWriter.value(Integer.valueOf(settingEntity.reddotInterval));
        if (settingEntity != settingEntity.redirectUrl) {
            j.PlaceComponentResult(jsonWriter, 467);
            jsonWriter.value(settingEntity.redirectUrl);
        }
        if (settingEntity != settingEntity.subtitle) {
            j.PlaceComponentResult(jsonWriter, 347);
            jsonWriter.value(settingEntity.subtitle);
        }
        if (settingEntity != settingEntity.subtitleColor) {
            j.PlaceComponentResult(jsonWriter, 209);
            jsonWriter.value(settingEntity.subtitleColor);
        }
        if (settingEntity != settingEntity.subtitleEn) {
            j.PlaceComponentResult(jsonWriter, 548);
            jsonWriter.value(settingEntity.subtitleEn);
        }
        j.PlaceComponentResult(jsonWriter, 465);
        jsonWriter.value(settingEntity.subtitleIsBelow);
        if (settingEntity != settingEntity.subtitleType) {
            j.PlaceComponentResult(jsonWriter, 447);
            jsonWriter.value(settingEntity.subtitleType);
        }
        if (settingEntity != settingEntity.title) {
            j.PlaceComponentResult(jsonWriter, 403);
            jsonWriter.value(settingEntity.title);
        }
        if (settingEntity != settingEntity.titleEn) {
            j.PlaceComponentResult(jsonWriter, 280);
            jsonWriter.value(settingEntity.titleEn);
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
        SettingEntity settingEntity = new SettingEntity();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 80:
                    if (!z) {
                        settingEntity.subtitleColor = null;
                        break;
                    } else {
                        settingEntity.subtitleColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 134:
                    if (!z) {
                        settingEntity.subtitleType = null;
                        break;
                    } else {
                        settingEntity.subtitleType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 135:
                    if (!z) {
                        break;
                    } else {
                        settingEntity.subtitleIsBelow = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 175:
                    if (!z) {
                        break;
                    } else {
                        settingEntity.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 190:
                    if (!z) {
                        settingEntity.title = null;
                        break;
                    } else {
                        settingEntity.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /* 212 */:
                    if (!z) {
                        settingEntity.action = null;
                        break;
                    } else {
                        settingEntity.action = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 244:
                    if (!z) {
                        settingEntity.titleEn = null;
                        break;
                    } else {
                        settingEntity.titleEn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case DeepRecoverARiverProxy.TYPE_ENTITY_APP /* 257 */:
                    if (!z) {
                        settingEntity.iconUrl = null;
                        break;
                    } else {
                        settingEntity.iconUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                    if (!z) {
                        settingEntity.redirectUrl = null;
                        break;
                    } else {
                        settingEntity.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 462:
                    if (!z) {
                        settingEntity.collection = null;
                        break;
                    } else {
                        settingEntity.collection = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 518:
                    if (!z) {
                        settingEntity.subtitle = null;
                        break;
                    } else {
                        settingEntity.subtitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 584:
                    if (!z) {
                        settingEntity.subtitleEn = null;
                        break;
                    } else {
                        settingEntity.subtitleEn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 590:
                    if (!z) {
                        break;
                    } else {
                        settingEntity.hasReddot = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 596:
                    if (!z) {
                        break;
                    } else {
                        try {
                            settingEntity.reddotInterval = jsonReader.nextInt();
                            continue;
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE /* 609 */:
                    if (!z) {
                        break;
                    } else {
                        settingEntity.nullObject = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return settingEntity;
    }
}
