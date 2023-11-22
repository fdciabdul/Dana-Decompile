package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.config.source.amcs.result.RepeatedBackgroundJobsResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getSavingConfigPresenter extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J getAuthRequestContext;

    public getSavingConfigPresenter(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ContactSyncConfigResult contactSyncConfigResult = (ContactSyncConfigResult) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 100);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(contactSyncConfigResult.intervalTimeInMillis);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, 401);
        jsonWriter.value(Integer.valueOf(contactSyncConfigResult.maxContactSyncBatchSize));
        if (contactSyncConfigResult != contactSyncConfigResult.repeatedBackgroundJobsResult) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA);
            RepeatedBackgroundJobsResult repeatedBackgroundJobsResult = contactSyncConfigResult.repeatedBackgroundJobsResult;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, RepeatedBackgroundJobsResult.class, repeatedBackgroundJobsResult).write(jsonWriter, repeatedBackgroundJobsResult);
        }
        j.PlaceComponentResult(jsonWriter, 315);
        jsonWriter.value(contactSyncConfigResult.synchronizeContact);
        j.PlaceComponentResult(jsonWriter, 457);
        jsonWriter.value(Integer.valueOf(contactSyncConfigResult.version));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ContactSyncConfigResult contactSyncConfigResult = new ContactSyncConfigResult();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 120) {
                if (authRequestContext != 168) {
                    if (authRequestContext != 198) {
                        if (authRequestContext != 278) {
                            if (authRequestContext != 494) {
                                jsonReader.skipValue();
                            } else if (z) {
                                try {
                                    contactSyncConfigResult.version = jsonReader.nextInt();
                                } catch (NumberFormatException e) {
                                    throw new JsonSyntaxException(e);
                                }
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            contactSyncConfigResult.synchronizeContact = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        contactSyncConfigResult.repeatedBackgroundJobsResult = (RepeatedBackgroundJobsResult) gson.getAdapter(RepeatedBackgroundJobsResult.class).read2(jsonReader);
                    } else {
                        contactSyncConfigResult.repeatedBackgroundJobsResult = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    contactSyncConfigResult.intervalTimeInMillis = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    contactSyncConfigResult.maxContactSyncBatchSize = jsonReader.nextInt();
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return contactSyncConfigResult;
    }
}
