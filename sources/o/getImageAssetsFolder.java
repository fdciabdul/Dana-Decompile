package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getImageAssetsFolder extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private J getAuthRequestContext;

    public getImageAssetsFolder(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        UploadFilesEntity uploadFilesEntity = (UploadFilesEntity) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = uploadFilesEntity.contentType;
        j.PlaceComponentResult(jsonWriter, 11);
        jsonWriter.value(uploadFilesEntity.contentType);
        String str2 = uploadFilesEntity.contentUrl;
        j.PlaceComponentResult(jsonWriter, 414);
        jsonWriter.value(uploadFilesEntity.contentUrl);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_UNKNOWN_ERROR);
        byte[] bArr = uploadFilesEntity.file;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, byte[].class, bArr).write(jsonWriter, bArr);
        String str3 = uploadFilesEntity.fileName;
        j.PlaceComponentResult(jsonWriter, 594);
        jsonWriter.value(uploadFilesEntity.fileName);
        j.PlaceComponentResult(jsonWriter, 243);
        jsonWriter.value(uploadFilesEntity.isHeic);
        String str4 = uploadFilesEntity.size;
        j.PlaceComponentResult(jsonWriter, 452);
        jsonWriter.value(uploadFilesEntity.size);
        String str5 = uploadFilesEntity.uri;
        j.PlaceComponentResult(jsonWriter, 47);
        jsonWriter.value(uploadFilesEntity.uri);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        UploadFilesEntity uploadFilesEntity = new UploadFilesEntity();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 73) {
                if (authRequestContext != 149) {
                    if (authRequestContext != 256) {
                        if (authRequestContext != 414) {
                            if (authRequestContext != 422) {
                                if (authRequestContext != 550) {
                                    if (authRequestContext != 563) {
                                        jsonReader.skipValue();
                                    } else if (z) {
                                        uploadFilesEntity.size = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        uploadFilesEntity.size = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    uploadFilesEntity.uri = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                } else {
                                    uploadFilesEntity.uri = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                uploadFilesEntity.isHeic = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            uploadFilesEntity.file = (byte[]) gson.getAdapter(byte[].class).read2(jsonReader);
                        } else {
                            uploadFilesEntity.file = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        uploadFilesEntity.fileName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        uploadFilesEntity.fileName = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    uploadFilesEntity.contentType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    uploadFilesEntity.contentType = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                uploadFilesEntity.contentUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                uploadFilesEntity.contentUrl = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return uploadFilesEntity;
    }
}
