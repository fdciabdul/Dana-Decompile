package com.alipayplus.mobile.component.common.facade.base;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import o.AppCompatEmojiTextHelper;
import o.J;

/* loaded from: classes3.dex */
public class MobileEnvLocationInfo implements Serializable {
    public String latitude;
    public String longitude;
    public String status;
    public String type;
    public long updateTime = 0;

    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Gson gson, JsonWriter jsonWriter, J j) {
        if (this != this.latitude) {
            j.PlaceComponentResult(jsonWriter, 503);
            jsonWriter.value(this.latitude);
        }
        if (this != this.longitude) {
            j.PlaceComponentResult(jsonWriter, 583);
            jsonWriter.value(this.longitude);
        }
        if (this != this.status) {
            j.PlaceComponentResult(jsonWriter, 95);
            jsonWriter.value(this.status);
        }
        if (this != this.type) {
            j.PlaceComponentResult(jsonWriter, 237);
            jsonWriter.value(this.type);
        }
        j.PlaceComponentResult(jsonWriter, 541);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(this.updateTime);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
    }

    public final /* synthetic */ void MyBillsEntityDataFactory(Gson gson, JsonReader jsonReader, int i) {
        boolean z = jsonReader.peek() != JsonToken.NULL;
        if (i == 253) {
            if (!z) {
                this.longitude = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.longitude = jsonReader.nextString();
            } else {
                this.longitude = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 283) {
            if (!z) {
                this.type = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.type = jsonReader.nextString();
            } else {
                this.type = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 412) {
            if (!z) {
                this.latitude = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.latitude = jsonReader.nextString();
            } else {
                this.latitude = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 594) {
            if (z) {
                this.updateTime = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
            } else {
                jsonReader.nextNull();
            }
        } else if (i != 613) {
            jsonReader.skipValue();
        } else if (!z) {
            this.status = null;
            jsonReader.nextNull();
        } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
            this.status = jsonReader.nextString();
        } else {
            this.status = Boolean.toString(jsonReader.nextBoolean());
        }
    }
}
