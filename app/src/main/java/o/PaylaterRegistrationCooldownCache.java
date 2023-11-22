package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.StartupConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class PaylaterRegistrationCooldownCache extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public PaylaterRegistrationCooldownCache(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        StartupConfig startupConfig = (StartupConfig) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (startupConfig != startupConfig.certificates) {
            j.PlaceComponentResult(jsonWriter, 75);
            SokalSneathDissimilarity sokalSneathDissimilarity = new SokalSneathDissimilarity();
            List<String> list = startupConfig.certificates;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, sokalSneathDissimilarity, list).write(jsonWriter, list);
        }
        Boolean bool = startupConfig.enableNonBlockingSplash;
        j.PlaceComponentResult(jsonWriter, 321);
        jsonWriter.value(startupConfig.enableNonBlockingSplash);
        Boolean bool2 = startupConfig.enableSimpleGetUserId;
        j.PlaceComponentResult(jsonWriter, 431);
        jsonWriter.value(startupConfig.enableSimpleGetUserId);
        Boolean bool3 = startupConfig.featureDexguardHookCheck;
        j.PlaceComponentResult(jsonWriter, 148);
        jsonWriter.value(startupConfig.featureDexguardHookCheck);
        Boolean bool4 = startupConfig.featureDexguardRootCheck;
        j.PlaceComponentResult(jsonWriter, 292);
        jsonWriter.value(startupConfig.featureDexguardRootCheck);
        Boolean bool5 = startupConfig.featureDexguardTamperCheck;
        j.PlaceComponentResult(jsonWriter, 459);
        jsonWriter.value(startupConfig.featureDexguardTamperCheck);
        Boolean bool6 = startupConfig.featureWarmstartTracking;
        j.PlaceComponentResult(jsonWriter, 254);
        jsonWriter.value(startupConfig.featureWarmstartTracking);
        Integer num = startupConfig.pinningMode;
        j.PlaceComponentResult(jsonWriter, 123);
        Integer num2 = startupConfig.pinningMode;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        if (startupConfig != startupConfig.sslCertificateWhitelistHost) {
            j.PlaceComponentResult(jsonWriter, 387);
            GroupRecipientPermissionHelper groupRecipientPermissionHelper = new GroupRecipientPermissionHelper();
            List<String> list2 = startupConfig.sslCertificateWhitelistHost;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, groupRecipientPermissionHelper, list2).write(jsonWriter, list2);
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
        StartupConfig startupConfig = new StartupConfig();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 67) {
                if (authRequestContext != 180) {
                    if (authRequestContext != 195) {
                        if (authRequestContext != 218) {
                            if (authRequestContext != 291) {
                                if (authRequestContext != 519) {
                                    if (authRequestContext != 546) {
                                        if (authRequestContext != 525) {
                                            if (authRequestContext != 526) {
                                                jsonReader.skipValue();
                                            } else if (z) {
                                                startupConfig.sslCertificateWhitelistHost = (List) gson.getAdapter(new GroupRecipientPermissionHelper()).read2(jsonReader);
                                            } else {
                                                startupConfig.sslCertificateWhitelistHost = null;
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            startupConfig.pinningMode = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                                        } else {
                                            startupConfig.pinningMode = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        startupConfig.enableNonBlockingSplash = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                    } else {
                                        startupConfig.enableNonBlockingSplash = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    startupConfig.featureDexguardTamperCheck = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                } else {
                                    startupConfig.featureDexguardTamperCheck = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                startupConfig.featureDexguardRootCheck = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                            } else {
                                startupConfig.featureDexguardRootCheck = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            startupConfig.featureWarmstartTracking = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        } else {
                            startupConfig.featureWarmstartTracking = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        startupConfig.certificates = (List) gson.getAdapter(new SokalSneathDissimilarity()).read2(jsonReader);
                    } else {
                        startupConfig.certificates = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    startupConfig.enableSimpleGetUserId = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    startupConfig.enableSimpleGetUserId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                startupConfig.featureDexguardHookCheck = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
            } else {
                startupConfig.featureDexguardHookCheck = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return startupConfig;
    }
}
