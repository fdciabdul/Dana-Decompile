package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Device;
import id.dana.utils.config.model.TimeLocation;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class GetFriendsFeedWithInitFeedAndFeatureCheck extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public GetFriendsFeedWithInitFeedAndFeatureCheck(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Device device = (Device) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = device.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 559);
        jsonWriter.value(device.MyBillsEntityDataFactory);
        String str2 = device.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, 61);
        jsonWriter.value(device.getAuthRequestContext);
        String str3 = device.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 380);
        jsonWriter.value(device.KClassImpl$Data$declaredNonStaticMembers$2);
        String str4 = device.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 247);
        jsonWriter.value(device.PlaceComponentResult);
        String str5 = device.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 340);
        jsonWriter.value(device.BuiltInFictitiousFunctionClassFactory);
        String str6 = device.scheduleImpl;
        j.PlaceComponentResult(jsonWriter, 539);
        jsonWriter.value(device.scheduleImpl);
        String str7 = device.lookAheadTest;
        j.PlaceComponentResult(jsonWriter, 84);
        jsonWriter.value(device.lookAheadTest);
        String str8 = device.getErrorConfigVersion;
        j.PlaceComponentResult(jsonWriter, 578);
        jsonWriter.value(device.getErrorConfigVersion);
        String str9 = device.NetworkUserEntityData$$ExternalSyntheticLambda0;
        j.PlaceComponentResult(jsonWriter, 396);
        jsonWriter.value(device.NetworkUserEntityData$$ExternalSyntheticLambda0);
        String str10 = device.moveToNextValue;
        j.PlaceComponentResult(jsonWriter, 72);
        jsonWriter.value(device.moveToNextValue);
        String str11 = device.DatabaseTableConfigUtil;
        j.PlaceComponentResult(jsonWriter, 173);
        jsonWriter.value(device.DatabaseTableConfigUtil);
        j.PlaceComponentResult(jsonWriter, 334);
        jsonWriter.value(device.NetworkUserEntityData$$ExternalSyntheticLambda1);
        j.PlaceComponentResult(jsonWriter, 58);
        jsonWriter.value(device.initRecordTimeStamp);
        String str12 = device.NetworkUserEntityData$$ExternalSyntheticLambda2;
        j.PlaceComponentResult(jsonWriter, 577);
        jsonWriter.value(device.NetworkUserEntityData$$ExternalSyntheticLambda2);
        String str13 = device.GetContactSyncConfig;
        j.PlaceComponentResult(jsonWriter, 293);
        jsonWriter.value(device.GetContactSyncConfig);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_NO_MEM);
        jsonWriter.value(Integer.valueOf(device.newProxyInstance));
        TimeLocation timeLocation = device.NetworkUserEntityData$$ExternalSyntheticLambda8;
        j.PlaceComponentResult(jsonWriter, 210);
        TimeLocation timeLocation2 = device.NetworkUserEntityData$$ExternalSyntheticLambda8;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, TimeLocation.class, timeLocation2).write(jsonWriter, timeLocation2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Device device = new Device();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 6:
                    if (!z) {
                        break;
                    } else {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda1 = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 24:
                    if (!z) {
                        device.scheduleImpl = null;
                        break;
                    } else {
                        device.scheduleImpl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 28:
                    if (!z) {
                        device.getAuthRequestContext = null;
                        break;
                    } else {
                        device.getAuthRequestContext = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 106:
                    if (!z) {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                        break;
                    } else {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 109:
                    if (!z) {
                        device.DatabaseTableConfigUtil = null;
                        break;
                    } else {
                        device.DatabaseTableConfigUtil = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 118:
                    if (!z) {
                        break;
                    } else {
                        device.initRecordTimeStamp = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 128:
                    if (!z) {
                        device.lookAheadTest = null;
                        break;
                    } else {
                        device.lookAheadTest = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case TarHeader.USTAR_FILENAME_PREFIX /* 155 */:
                    if (!z) {
                        device.GetContactSyncConfig = null;
                        break;
                    } else {
                        device.GetContactSyncConfig = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 194:
                    if (!z) {
                        device.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                        break;
                    } else {
                        device.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 250:
                    if (!z) {
                        device.PlaceComponentResult = null;
                        break;
                    } else {
                        device.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 432:
                    if (!z) {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
                        break;
                    } else {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda8 = (TimeLocation) gson.getAdapter(TimeLocation.class).read2(jsonReader);
                        continue;
                    }
                case 451:
                    if (!z) {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                        break;
                    } else {
                        device.NetworkUserEntityData$$ExternalSyntheticLambda0 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 466:
                    if (!z) {
                        device.getErrorConfigVersion = null;
                        break;
                    } else {
                        device.getErrorConfigVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 471:
                    if (!z) {
                        device.MyBillsEntityDataFactory = null;
                        break;
                    } else {
                        device.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_APP /* 514 */:
                    if (!z) {
                        device.moveToNextValue = null;
                        break;
                    } else {
                        device.moveToNextValue = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 558:
                    if (!z) {
                        device.BuiltInFictitiousFunctionClassFactory = null;
                        break;
                    } else {
                        device.BuiltInFictitiousFunctionClassFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 560:
                    if (!z) {
                        break;
                    } else {
                        try {
                            device.newProxyInstance = jsonReader.nextInt();
                            continue;
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return device;
    }
}
