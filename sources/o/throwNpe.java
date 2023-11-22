package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.SysFeature;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class throwNpe extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public throwNpe(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        SysFeature sysFeature = (SysFeature) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATRUE_INVALID_INPUT);
        jsonWriter.value(sysFeature.PlaceComponentResult);
        j.PlaceComponentResult(jsonWriter, 245);
        jsonWriter.value(sysFeature.KClassImpl$Data$declaredNonStaticMembers$2);
        j.PlaceComponentResult(jsonWriter, 524);
        jsonWriter.value(sysFeature.BuiltInFictitiousFunctionClassFactory);
        j.PlaceComponentResult(jsonWriter, 336);
        jsonWriter.value(sysFeature.getAuthRequestContext);
        j.PlaceComponentResult(jsonWriter, 228);
        jsonWriter.value(sysFeature.MyBillsEntityDataFactory);
        j.PlaceComponentResult(jsonWriter, 169);
        jsonWriter.value(sysFeature.getErrorConfigVersion);
        j.PlaceComponentResult(jsonWriter, 339);
        jsonWriter.value(sysFeature.NetworkUserEntityData$$ExternalSyntheticLambda0);
        j.PlaceComponentResult(jsonWriter, 536);
        jsonWriter.value(sysFeature.scheduleImpl);
        j.PlaceComponentResult(jsonWriter, 44);
        jsonWriter.value(sysFeature.moveToNextValue);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SysFeature sysFeature = new SysFeature();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 62) {
                if (authRequestContext != 115) {
                    if (authRequestContext != 199) {
                        if (authRequestContext != 230) {
                            if (authRequestContext != 258) {
                                if (authRequestContext != 411) {
                                    if (authRequestContext != 503) {
                                        if (authRequestContext != 528) {
                                            if (authRequestContext != 549) {
                                                jsonReader.skipValue();
                                            } else if (z) {
                                                sysFeature.BuiltInFictitiousFunctionClassFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                            } else {
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            sysFeature.MyBillsEntityDataFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                        } else {
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        sysFeature.getErrorConfigVersion = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                    } else {
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    sysFeature.PlaceComponentResult = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                } else {
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                sysFeature.getAuthRequestContext = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            sysFeature.NetworkUserEntityData$$ExternalSyntheticLambda0 = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        sysFeature.KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    sysFeature.moveToNextValue = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                sysFeature.scheduleImpl = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return sysFeature;
    }
}
