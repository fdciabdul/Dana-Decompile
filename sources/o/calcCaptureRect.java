package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.sendmoney.domain.globalsend.model.sender.SenderDetail;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class calcCaptureRect extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public calcCaptureRect(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SenderDetail senderDetail = (SenderDetail) obj;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        String str = senderDetail.address;
        j.PlaceComponentResult(jsonWriter, 570);
        jsonWriter.value(senderDetail.address);
        String str2 = senderDetail.email;
        j.PlaceComponentResult(jsonWriter, 314);
        jsonWriter.value(senderDetail.email);
        j.PlaceComponentResult(jsonWriter, 346);
        jsonWriter.value(senderDetail.hasShown);
        String str3 = senderDetail.ktpId;
        j.PlaceComponentResult(jsonWriter, 244);
        jsonWriter.value(senderDetail.ktpId);
        String str4 = senderDetail.ktpName;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_OPEN_PAGE);
        jsonWriter.value(senderDetail.ktpName);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SenderDetail senderDetail = new SenderDetail();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 0) {
                if (authRequestContext != 22) {
                    if (authRequestContext != 38) {
                        if (authRequestContext != 297) {
                            if (authRequestContext != 420) {
                                jsonReader.skipValue();
                            } else if (z) {
                                senderDetail.email = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                senderDetail.email = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            senderDetail.address = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            senderDetail.address = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        senderDetail.hasShown = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    senderDetail.ktpId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    senderDetail.ktpId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                senderDetail.ktpName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                senderDetail.ktpName = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return senderDetail;
    }
}
