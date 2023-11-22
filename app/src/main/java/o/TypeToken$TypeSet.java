package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.cashier.data.repository.source.network.result.CashierHighlightConfigResult;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class TypeToken$TypeSet extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public TypeToken$TypeSet(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CashierHighlightConfigResult cashierHighlightConfigResult = (CashierHighlightConfigResult) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (cashierHighlightConfigResult != cashierHighlightConfigResult.desc) {
            j.PlaceComponentResult(jsonWriter, 283);
            onTooManyRedirects ontoomanyredirects = new onTooManyRedirects();
            List<String> list = cashierHighlightConfigResult.desc;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, ontoomanyredirects, list).write(jsonWriter, list);
        }
        String str = cashierHighlightConfigResult.instId;
        j.PlaceComponentResult(jsonWriter, 332);
        jsonWriter.value(cashierHighlightConfigResult.instId);
        String str2 = cashierHighlightConfigResult.mode;
        j.PlaceComponentResult(jsonWriter, 397);
        jsonWriter.value(cashierHighlightConfigResult.mode);
        if (cashierHighlightConfigResult != cashierHighlightConfigResult.subtitle) {
            j.PlaceComponentResult(jsonWriter, 347);
            createJavaMethod createjavamethod = new createJavaMethod();
            List<String> list2 = cashierHighlightConfigResult.subtitle;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, createjavamethod, list2).write(jsonWriter, list2);
        }
        Integer num = cashierHighlightConfigResult.timeShowInDays;
        j.PlaceComponentResult(jsonWriter, 591);
        Integer num2 = cashierHighlightConfigResult.timeShowInDays;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        if (cashierHighlightConfigResult != cashierHighlightConfigResult.title) {
            j.PlaceComponentResult(jsonWriter, 403);
            checkParameterIsNotNull checkparameterisnotnull = new checkParameterIsNotNull();
            List<String> list3 = cashierHighlightConfigResult.title;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, checkparameterisnotnull, list3).write(jsonWriter, list3);
        }
        Integer num3 = cashierHighlightConfigResult.version;
        j.PlaceComponentResult(jsonWriter, 457);
        Integer num4 = cashierHighlightConfigResult.version;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CashierHighlightConfigResult cashierHighlightConfigResult = new CashierHighlightConfigResult();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 53) {
                if (authRequestContext != 130) {
                    if (authRequestContext != 178) {
                        if (authRequestContext != 190) {
                            if (authRequestContext != 255) {
                                if (authRequestContext != 494) {
                                    if (authRequestContext != 518) {
                                        jsonReader.skipValue();
                                    } else if (z) {
                                        cashierHighlightConfigResult.subtitle = (List) gson.getAdapter(new createJavaMethod()).read2(jsonReader);
                                    } else {
                                        cashierHighlightConfigResult.subtitle = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    cashierHighlightConfigResult.version = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                                } else {
                                    cashierHighlightConfigResult.version = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                cashierHighlightConfigResult.instId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                cashierHighlightConfigResult.instId = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            cashierHighlightConfigResult.title = (List) gson.getAdapter(new checkParameterIsNotNull()).read2(jsonReader);
                        } else {
                            cashierHighlightConfigResult.title = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        cashierHighlightConfigResult.timeShowInDays = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                    } else {
                        cashierHighlightConfigResult.timeShowInDays = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    cashierHighlightConfigResult.desc = (List) gson.getAdapter(new onTooManyRedirects()).read2(jsonReader);
                } else {
                    cashierHighlightConfigResult.desc = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                cashierHighlightConfigResult.mode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                cashierHighlightConfigResult.mode = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return cashierHighlightConfigResult;
    }
}
