package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Bluetooth;
import id.dana.utils.config.model.Cpu;
import id.dana.utils.config.model.Device;
import id.dana.utils.config.model.DeviceInfo;
import id.dana.utils.config.model.Display;
import id.dana.utils.config.model.ExternalStorage;
import id.dana.utils.config.model.Gps;
import id.dana.utils.config.model.IP;
import id.dana.utils.config.model.Memory;
import id.dana.utils.config.model.SysFeature;
import id.dana.utils.config.model.Wifi;
import java.io.IOException;
import java.util.List;

/* renamed from: o.$r8$lambda$TGidIAE-3L8As7QVHBZ6_rXBA0k  reason: invalid class name */
/* loaded from: classes5.dex */
public final class C$r8$lambda$TGidIAE3L8As7QVHBZ6_rXBA0k extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public C$r8$lambda$TGidIAE3L8As7QVHBZ6_rXBA0k(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        if (deviceInfo != deviceInfo.PlaceComponentResult) {
            j.PlaceComponentResult(jsonWriter, 174);
            getInWholeMillisecondsimpl getinwholemillisecondsimpl = new getInWholeMillisecondsimpl();
            List<Bluetooth> list = deviceInfo.PlaceComponentResult;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getinwholemillisecondsimpl, list).write(jsonWriter, list);
        }
        Cpu cpu = deviceInfo.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_BASE64_DECODE_FAILED);
        Cpu cpu2 = deviceInfo.BuiltInFictitiousFunctionClassFactory;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Cpu.class, cpu2).write(jsonWriter, cpu2);
        Device device = deviceInfo.getAuthRequestContext;
        j.PlaceComponentResult(jsonWriter, 281);
        Device device2 = deviceInfo.getAuthRequestContext;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Device.class, device2).write(jsonWriter, device2);
        Display display = deviceInfo.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 76);
        Display display2 = deviceInfo.MyBillsEntityDataFactory;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Display.class, display2).write(jsonWriter, display2);
        ExternalStorage externalStorage = deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 398);
        ExternalStorage externalStorage2 = deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, ExternalStorage.class, externalStorage2).write(jsonWriter, externalStorage2);
        Gps gps = deviceInfo.scheduleImpl;
        j.PlaceComponentResult(jsonWriter, 65);
        Gps gps2 = deviceInfo.scheduleImpl;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Gps.class, gps2).write(jsonWriter, gps2);
        IP ip = deviceInfo.getErrorConfigVersion;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
        IP ip2 = deviceInfo.getErrorConfigVersion;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, IP.class, ip2).write(jsonWriter, ip2);
        Memory memory = deviceInfo.lookAheadTest;
        j.PlaceComponentResult(jsonWriter, 138);
        Memory memory2 = deviceInfo.lookAheadTest;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Memory.class, memory2).write(jsonWriter, memory2);
        SysFeature sysFeature = deviceInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
        j.PlaceComponentResult(jsonWriter, 119);
        SysFeature sysFeature2 = deviceInfo.NetworkUserEntityData$$ExternalSyntheticLambda0;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, SysFeature.class, sysFeature2).write(jsonWriter, sysFeature2);
        if (deviceInfo != deviceInfo.moveToNextValue) {
            j.PlaceComponentResult(jsonWriter, 536);
            ReduceOps$8ReducingSink reduceOps$8ReducingSink = new ReduceOps$8ReducingSink();
            List<Wifi> list2 = deviceInfo.moveToNextValue;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, reduceOps$8ReducingSink, list2).write(jsonWriter, list2);
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
        DeviceInfo deviceInfo = new DeviceInfo();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 62) {
                if (authRequestContext != 169) {
                    if (authRequestContext != 187) {
                        if (authRequestContext != 191) {
                            if (authRequestContext != 214) {
                                if (authRequestContext != 284) {
                                    if (authRequestContext != 393) {
                                        if (authRequestContext != 433) {
                                            if (authRequestContext != 502) {
                                                if (authRequestContext != 535) {
                                                    jsonReader.skipValue();
                                                } else if (z) {
                                                    deviceInfo.PlaceComponentResult = (List) gson.getAdapter(new getInWholeMillisecondsimpl()).read2(jsonReader);
                                                } else {
                                                    deviceInfo.PlaceComponentResult = null;
                                                    jsonReader.nextNull();
                                                }
                                            } else if (z) {
                                                deviceInfo.getAuthRequestContext = (Device) gson.getAdapter(Device.class).read2(jsonReader);
                                            } else {
                                                deviceInfo.getAuthRequestContext = null;
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            deviceInfo.scheduleImpl = (Gps) gson.getAdapter(Gps.class).read2(jsonReader);
                                        } else {
                                            deviceInfo.scheduleImpl = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        deviceInfo.NetworkUserEntityData$$ExternalSyntheticLambda0 = (SysFeature) gson.getAdapter(SysFeature.class).read2(jsonReader);
                                    } else {
                                        deviceInfo.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    deviceInfo.BuiltInFictitiousFunctionClassFactory = (Cpu) gson.getAdapter(Cpu.class).read2(jsonReader);
                                } else {
                                    deviceInfo.BuiltInFictitiousFunctionClassFactory = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                deviceInfo.lookAheadTest = (Memory) gson.getAdapter(Memory.class).read2(jsonReader);
                            } else {
                                deviceInfo.lookAheadTest = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            deviceInfo.MyBillsEntityDataFactory = (Display) gson.getAdapter(Display.class).read2(jsonReader);
                        } else {
                            deviceInfo.MyBillsEntityDataFactory = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        deviceInfo.getErrorConfigVersion = (IP) gson.getAdapter(IP.class).read2(jsonReader);
                    } else {
                        deviceInfo.getErrorConfigVersion = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2 = (ExternalStorage) gson.getAdapter(ExternalStorage.class).read2(jsonReader);
                } else {
                    deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                deviceInfo.moveToNextValue = (List) gson.getAdapter(new ReduceOps$8ReducingSink()).read2(jsonReader);
            } else {
                deviceInfo.moveToNextValue = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return deviceInfo;
    }
}
