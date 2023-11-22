package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.version.Version;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class access$setGoToMyLocationVisibility extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public access$setGoToMyLocationVisibility(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        Version version = (Version) obj;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = version.latestMajorVersion;
        j.PlaceComponentResult(jsonWriter, 161);
        jsonWriter.value(version.latestMajorVersion);
        String str2 = version.latestMinorVersion;
        j.PlaceComponentResult(jsonWriter, 276);
        jsonWriter.value(version.latestMinorVersion);
        String str3 = version.latestPatchVersion;
        j.PlaceComponentResult(jsonWriter, 91);
        jsonWriter.value(version.latestPatchVersion);
        String str4 = version.validMajorVersion;
        j.PlaceComponentResult(jsonWriter, 153);
        jsonWriter.value(version.validMajorVersion);
        String str5 = version.validMinorVersion;
        j.PlaceComponentResult(jsonWriter, 42);
        jsonWriter.value(version.validMinorVersion);
        String str6 = version.validPatchVersion;
        j.PlaceComponentResult(jsonWriter, 470);
        jsonWriter.value(version.validPatchVersion);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Version version = new Version();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 20) {
                if (authRequestContext != 33) {
                    if (authRequestContext != 196) {
                        if (authRequestContext != 222) {
                            if (authRequestContext != 252) {
                                if (authRequestContext != 501) {
                                    jsonReader.skipValue();
                                } else if (z) {
                                    version.latestMajorVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                } else {
                                    version.latestMajorVersion = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                version.validPatchVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                version.validPatchVersion = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            version.validMajorVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            version.validMajorVersion = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        version.latestPatchVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        version.latestPatchVersion = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    version.validMinorVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    version.validMinorVersion = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                version.latestMinorVersion = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                version.latestMinorVersion = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return version;
    }
}
