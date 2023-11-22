package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.StartupConfigEntity;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class glVertexAttrib1fv extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private J getAuthRequestContext;

    public glVertexAttrib1fv(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        StartupConfigEntity startupConfigEntity = (StartupConfigEntity) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        if (startupConfigEntity != startupConfigEntity.certificates) {
            j.PlaceComponentResult(jsonWriter, 75);
            removeFloat removefloat = new removeFloat();
            List<String> list = startupConfigEntity.certificates;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, removefloat, list).write(jsonWriter, list);
        }
        Boolean bool = startupConfigEntity.enableNonBlockingSplash;
        j.PlaceComponentResult(jsonWriter, 321);
        jsonWriter.value(startupConfigEntity.enableNonBlockingSplash);
        Boolean bool2 = startupConfigEntity.enableSimpleGetUserId;
        j.PlaceComponentResult(jsonWriter, 431);
        jsonWriter.value(startupConfigEntity.enableSimpleGetUserId);
        Boolean bool3 = startupConfigEntity.featureDexguardHookCheck;
        j.PlaceComponentResult(jsonWriter, 148);
        jsonWriter.value(startupConfigEntity.featureDexguardHookCheck);
        Boolean bool4 = startupConfigEntity.featureDexguardRootCheck;
        j.PlaceComponentResult(jsonWriter, 292);
        jsonWriter.value(startupConfigEntity.featureDexguardRootCheck);
        Boolean bool5 = startupConfigEntity.featureDexguardTamperCheck;
        j.PlaceComponentResult(jsonWriter, 459);
        jsonWriter.value(startupConfigEntity.featureDexguardTamperCheck);
        Boolean bool6 = startupConfigEntity.featureWarmstartTracking;
        j.PlaceComponentResult(jsonWriter, 254);
        jsonWriter.value(startupConfigEntity.featureWarmstartTracking);
        Integer num = startupConfigEntity.pinningMode;
        j.PlaceComponentResult(jsonWriter, 123);
        Integer num2 = startupConfigEntity.pinningMode;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        if (startupConfigEntity != startupConfigEntity.sslCertificateWhitelistHost) {
            j.PlaceComponentResult(jsonWriter, 387);
            GetTopUpUserConsult getTopUpUserConsult = new GetTopUpUserConsult();
            List<String> list2 = startupConfigEntity.sslCertificateWhitelistHost;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getTopUpUserConsult, list2).write(jsonWriter, list2);
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
        StartupConfigEntity startupConfigEntity = new StartupConfigEntity();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 67) {
                if (authRequestContext != 180) {
                    if (authRequestContext != 195) {
                        if (authRequestContext != 218) {
                            if (authRequestContext != 291) {
                                if (authRequestContext != 519) {
                                    if (authRequestContext != 546) {
                                        if (authRequestContext != 525) {
                                            if (authRequestContext != 526) {
                                                jsonReader.skipValue();
                                            } else if (z) {
                                                startupConfigEntity.sslCertificateWhitelistHost = (List) gson.getAdapter(new GetTopUpUserConsult()).read2(jsonReader);
                                            } else {
                                                startupConfigEntity.sslCertificateWhitelistHost = null;
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            startupConfigEntity.pinningMode = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                                        } else {
                                            startupConfigEntity.pinningMode = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        startupConfigEntity.enableNonBlockingSplash = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                    } else {
                                        startupConfigEntity.enableNonBlockingSplash = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    startupConfigEntity.featureDexguardTamperCheck = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                } else {
                                    startupConfigEntity.featureDexguardTamperCheck = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                startupConfigEntity.featureDexguardRootCheck = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                            } else {
                                startupConfigEntity.featureDexguardRootCheck = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            startupConfigEntity.featureWarmstartTracking = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        } else {
                            startupConfigEntity.featureWarmstartTracking = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        startupConfigEntity.certificates = (List) gson.getAdapter(new removeFloat()).read2(jsonReader);
                    } else {
                        startupConfigEntity.certificates = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    startupConfigEntity.enableSimpleGetUserId = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    startupConfigEntity.enableSimpleGetUserId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                startupConfigEntity.featureDexguardHookCheck = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
            } else {
                startupConfigEntity.featureDexguardHookCheck = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return startupConfigEntity;
    }
}
