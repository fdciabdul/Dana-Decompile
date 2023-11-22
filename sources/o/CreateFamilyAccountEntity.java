package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import id.dana.utils.holdlogin.v2.model.HoldLoginErrorCodesEntity;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class CreateFamilyAccountEntity extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public CreateFamilyAccountEntity(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        FeatureHoldLoginConfig featureHoldLoginConfig = (FeatureHoldLoginConfig) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(featureHoldLoginConfig.MyBillsEntityDataFactory);
        j.PlaceComponentResult(jsonWriter, 242);
        jsonWriter.value(featureHoldLoginConfig.BuiltInFictitiousFunctionClassFactory);
        j.PlaceComponentResult(jsonWriter, 383);
        jsonWriter.value(featureHoldLoginConfig.KClassImpl$Data$declaredNonStaticMembers$2);
        HoldLoginErrorCodesEntity holdLoginErrorCodesEntity = featureHoldLoginConfig.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 25);
        HoldLoginErrorCodesEntity holdLoginErrorCodesEntity2 = featureHoldLoginConfig.PlaceComponentResult;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, HoldLoginErrorCodesEntity.class, holdLoginErrorCodesEntity2).write(jsonWriter, holdLoginErrorCodesEntity2);
        j.PlaceComponentResult(jsonWriter, 24);
        jsonWriter.value(featureHoldLoginConfig.getAuthRequestContext);
        j.PlaceComponentResult(jsonWriter, 102);
        jsonWriter.value(Integer.valueOf(featureHoldLoginConfig.scheduleImpl));
        Long l = featureHoldLoginConfig.lookAheadTest;
        j.PlaceComponentResult(jsonWriter, 348);
        Long l2 = featureHoldLoginConfig.lookAheadTest;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Long.class, l2).write(jsonWriter, l2);
        j.PlaceComponentResult(jsonWriter, 616);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(featureHoldLoginConfig.getErrorConfigVersion);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, 553);
        Class cls2 = Long.TYPE;
        Long valueOf2 = Long.valueOf(featureHoldLoginConfig.moveToNextValue);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls2, valueOf2).write(jsonWriter, valueOf2);
        j.PlaceComponentResult(jsonWriter, 457);
        jsonWriter.value(Integer.valueOf(featureHoldLoginConfig.NetworkUserEntityData$$ExternalSyntheticLambda0));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        FeatureHoldLoginConfig featureHoldLoginConfig = new FeatureHoldLoginConfig();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 46) {
                if (authRequestContext != 132) {
                    if (authRequestContext != 259) {
                        if (authRequestContext != 264) {
                            if (authRequestContext != 319) {
                                if (authRequestContext != 399) {
                                    if (authRequestContext != 494) {
                                        if (authRequestContext != 559) {
                                            if (authRequestContext != 175) {
                                                if (authRequestContext != 176) {
                                                    jsonReader.skipValue();
                                                } else if (z) {
                                                    featureHoldLoginConfig.moveToNextValue = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                                                } else {
                                                    jsonReader.nextNull();
                                                }
                                            } else if (z) {
                                                featureHoldLoginConfig.MyBillsEntityDataFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                            } else {
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            featureHoldLoginConfig.KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                        } else {
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        try {
                                            featureHoldLoginConfig.NetworkUserEntityData$$ExternalSyntheticLambda0 = jsonReader.nextInt();
                                        } catch (NumberFormatException e) {
                                            throw new JsonSyntaxException(e);
                                        }
                                    } else {
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    featureHoldLoginConfig.PlaceComponentResult = (HoldLoginErrorCodesEntity) gson.getAdapter(HoldLoginErrorCodesEntity.class).read2(jsonReader);
                                } else {
                                    featureHoldLoginConfig.PlaceComponentResult = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                featureHoldLoginConfig.lookAheadTest = (Long) gson.getAdapter(Long.class).read2(jsonReader);
                            } else {
                                featureHoldLoginConfig.lookAheadTest = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            featureHoldLoginConfig.BuiltInFictitiousFunctionClassFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        try {
                            featureHoldLoginConfig.scheduleImpl = jsonReader.nextInt();
                        } catch (NumberFormatException e2) {
                            throw new JsonSyntaxException(e2);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    featureHoldLoginConfig.getErrorConfigVersion = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                featureHoldLoginConfig.getAuthRequestContext = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return featureHoldLoginConfig;
    }
}
