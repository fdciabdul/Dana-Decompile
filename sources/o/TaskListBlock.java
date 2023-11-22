package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanWhitelist;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class TaskListBlock extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public TaskListBlock(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        LoanWhitelist loanWhitelist = (LoanWhitelist) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 484);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(loanWhitelist.lastFetchTime);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        if (loanWhitelist != loanWhitelist.loanInfo) {
            j.PlaceComponentResult(jsonWriter, 88);
            SwitchFaceAuthContract switchFaceAuthContract = new SwitchFaceAuthContract();
            List<LoanInfo> list = loanWhitelist.loanInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, switchFaceAuthContract, list).write(jsonWriter, list);
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
        LoanWhitelist loanWhitelist = new LoanWhitelist();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 246) {
                if (authRequestContext != 251) {
                    jsonReader.skipValue();
                } else if (z) {
                    loanWhitelist.lastFetchTime = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                loanWhitelist.loanInfo = (List) gson.getAdapter(new SwitchFaceAuthContract()).read2(jsonReader);
            } else {
                loanWhitelist.loanInfo = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return loanWhitelist;
    }
}
