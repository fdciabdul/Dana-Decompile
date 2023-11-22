package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Cpu;
import java.io.IOException;

/* renamed from: o.$r8$lambda$7v3KT-aJFlJz89NRM-Iclzm3mWc  reason: invalid class name */
/* loaded from: classes5.dex */
public final class C$r8$lambda$7v3KTaJFlJz89NRMIclzm3mWc extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public C$r8$lambda$7v3KTaJFlJz89NRMIclzm3mWc(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Cpu cpu = (Cpu) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = cpu.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 492);
        jsonWriter.value(cpu.PlaceComponentResult);
        String str2 = cpu.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 14);
        jsonWriter.value(cpu.KClassImpl$Data$declaredNonStaticMembers$2);
        String str3 = cpu.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 101);
        jsonWriter.value(cpu.BuiltInFictitiousFunctionClassFactory);
        Integer num = cpu.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, 356);
        Integer num2 = cpu.getAuthRequestContext;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        Integer num3 = cpu.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 350);
        Integer num4 = cpu.MyBillsEntityDataFactory;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        Integer num5 = cpu.scheduleImpl;
        j.PlaceComponentResult(jsonWriter, 164);
        Integer num6 = cpu.scheduleImpl;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num6).write(jsonWriter, num6);
        String str4 = cpu.moveToNextValue;
        j.PlaceComponentResult(jsonWriter, 108);
        jsonWriter.value(cpu.moveToNextValue);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Cpu cpu = new Cpu();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 26) {
                if (authRequestContext != 90) {
                    if (authRequestContext != 112) {
                        if (authRequestContext != 416) {
                            if (authRequestContext != 551) {
                                if (authRequestContext != 582) {
                                    if (authRequestContext != 612) {
                                        jsonReader.skipValue();
                                    } else if (z) {
                                        cpu.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        cpu.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    cpu.MyBillsEntityDataFactory = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                                } else {
                                    cpu.MyBillsEntityDataFactory = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                cpu.getAuthRequestContext = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                            } else {
                                cpu.getAuthRequestContext = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            cpu.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            cpu.PlaceComponentResult = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        cpu.scheduleImpl = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                    } else {
                        cpu.scheduleImpl = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    cpu.BuiltInFictitiousFunctionClassFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    cpu.BuiltInFictitiousFunctionClassFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                cpu.moveToNextValue = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                cpu.moveToNextValue = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return cpu;
    }
}
