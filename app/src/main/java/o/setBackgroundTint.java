package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class setBackgroundTint extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public setBackgroundTint(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel = (DanaProtectionHomeWidgetInfoModel) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 381);
        jsonWriter.value(Integer.valueOf(danaProtectionHomeWidgetInfoModel.protectedActivity));
        j.PlaceComponentResult(jsonWriter, 469);
        jsonWriter.value(Integer.valueOf(danaProtectionHomeWidgetInfoModel.recommendationCount));
        j.PlaceComponentResult(jsonWriter, 474);
        jsonWriter.value(Integer.valueOf(danaProtectionHomeWidgetInfoModel.suspiciousActivity));
        j.PlaceComponentResult(jsonWriter, 46);
        jsonWriter.value(Integer.valueOf(danaProtectionHomeWidgetInfoModel.timeRange));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel = new DanaProtectionHomeWidgetInfoModel();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 32) {
                if (authRequestContext != 156) {
                    if (authRequestContext != 223) {
                        if (authRequestContext != 392) {
                            jsonReader.skipValue();
                        } else if (z) {
                            try {
                                danaProtectionHomeWidgetInfoModel.timeRange = jsonReader.nextInt();
                            } catch (NumberFormatException e) {
                                throw new JsonSyntaxException(e);
                            }
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        try {
                            danaProtectionHomeWidgetInfoModel.recommendationCount = jsonReader.nextInt();
                        } catch (NumberFormatException e2) {
                            throw new JsonSyntaxException(e2);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        danaProtectionHomeWidgetInfoModel.suspiciousActivity = jsonReader.nextInt();
                    } catch (NumberFormatException e3) {
                        throw new JsonSyntaxException(e3);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    danaProtectionHomeWidgetInfoModel.protectedActivity = jsonReader.nextInt();
                } catch (NumberFormatException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return danaProtectionHomeWidgetInfoModel;
    }
}
