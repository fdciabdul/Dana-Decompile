package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.CitcallPermissionConfig;
import id.dana.data.config.model.Permission;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class FamilyDashboardPresenter_Factory extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public FamilyDashboardPresenter_Factory(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CitcallPermissionConfig citcallPermissionConfig = (CitcallPermissionConfig) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        Permission permission = citcallPermissionConfig.permission;
        j.PlaceComponentResult(jsonWriter, 531);
        Permission permission2 = citcallPermissionConfig.permission;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Permission.class, permission2).write(jsonWriter, permission2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CitcallPermissionConfig citcallPermissionConfig = new CitcallPermissionConfig();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 159) {
                jsonReader.skipValue();
            } else if (z) {
                citcallPermissionConfig.permission = (Permission) gson.getAdapter(Permission.class).read2(jsonReader);
            } else {
                citcallPermissionConfig.permission = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return citcallPermissionConfig;
    }
}
