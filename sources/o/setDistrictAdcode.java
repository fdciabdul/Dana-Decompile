package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.LinkInfo;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setDistrictAdcode extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public setDistrictAdcode(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        LinkInfo linkInfo = (LinkInfo) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = linkInfo.closedTagHyperlink;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_UNKNOWN_ERROR);
        jsonWriter.value(linkInfo.closedTagHyperlink);
        String str2 = linkInfo.enHyperlink;
        j.PlaceComponentResult(jsonWriter, 600);
        jsonWriter.value(linkInfo.enHyperlink);
        String str3 = linkInfo.idHyperlink;
        j.PlaceComponentResult(jsonWriter, 126);
        jsonWriter.value(linkInfo.idHyperlink);
        String str4 = linkInfo.link;
        j.PlaceComponentResult(jsonWriter, 395);
        jsonWriter.value(linkInfo.link);
        String str5 = linkInfo.openTagHyperlink;
        j.PlaceComponentResult(jsonWriter, 486);
        jsonWriter.value(linkInfo.openTagHyperlink);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        LinkInfo linkInfo = new LinkInfo();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 361) {
                if (authRequestContext != 465) {
                    if (authRequestContext != 595) {
                        if (authRequestContext != 605) {
                            if (authRequestContext != 607) {
                                jsonReader.skipValue();
                            } else if (z) {
                                linkInfo.link = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                linkInfo.link = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            linkInfo.openTagHyperlink = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            linkInfo.openTagHyperlink = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        linkInfo.closedTagHyperlink = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        linkInfo.closedTagHyperlink = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    linkInfo.enHyperlink = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    linkInfo.enHyperlink = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                linkInfo.idHyperlink = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                linkInfo.idHyperlink = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return linkInfo;
    }
}
