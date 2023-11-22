package zipkin2.internal;

import com.alibaba.exthub.BuildConfig;
import io.split.android.client.service.ServiceConstants;
import java.io.IOException;
import java.util.Collection;
import java.util.Locale;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.JsonCodec;
import zipkin2.v1.V1Span;
import zipkin2.v1.V1SpanConverter;

/* loaded from: classes9.dex */
public final class V1JsonSpanReader implements JsonCodec.JsonReaderAdapter<V1Span> {
    V1Span.Builder BuiltInFictitiousFunctionClassFactory;

    public final String toString() {
        return "Span";
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        V1SpanConverter PlaceComponentResult = V1SpanConverter.PlaceComponentResult();
        JsonCodec.JsonReader jsonReader = new JsonCodec.JsonReader(readBuffer);
        try {
            jsonReader.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            if (jsonReader.getAuthRequestContext()) {
                while (jsonReader.getAuthRequestContext()) {
                    V1Span KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(jsonReader);
                    PlaceComponentResult.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2);
                    PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
                    PlaceComponentResult.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                    PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(collection);
                }
                jsonReader.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                return true;
            }
            return false;
        } catch (Exception e) {
            throw JsonCodec.getAuthRequestContext("List<Span>", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public V1Span KClassImpl$Data$declaredNonStaticMembers$2(JsonCodec.JsonReader jsonReader) throws IOException {
        V1Span.Builder builder = this.BuiltInFictitiousFunctionClassFactory;
        if (builder == null) {
            this.BuiltInFictitiousFunctionClassFactory = V1Span.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        while (jsonReader.getAuthRequestContext()) {
            String errorConfigVersion = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
            if (errorConfigVersion.equals("traceId")) {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
            } else if (errorConfigVersion.equals("id")) {
                V1Span.Builder builder2 = this.BuiltInFictitiousFunctionClassFactory;
                String initRecordTimeStamp = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                if (initRecordTimeStamp == null) {
                    throw new NullPointerException("id == null");
                }
                builder2.KClassImpl$Data$declaredNonStaticMembers$2 = HexCodec.BuiltInFictitiousFunctionClassFactory(initRecordTimeStamp);
            } else if (!jsonReader.MyBillsEntityDataFactory()) {
                if (errorConfigVersion.equals("name")) {
                    V1Span.Builder builder3 = this.BuiltInFictitiousFunctionClassFactory;
                    String initRecordTimeStamp2 = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                    builder3.scheduleImpl = (initRecordTimeStamp2 == null || initRecordTimeStamp2.isEmpty()) ? null : initRecordTimeStamp2.toLowerCase(Locale.ROOT);
                } else if (errorConfigVersion.equals("parentId")) {
                    V1Span.Builder builder4 = this.BuiltInFictitiousFunctionClassFactory;
                    String initRecordTimeStamp3 = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                    builder4.NetworkUserEntityData$$ExternalSyntheticLambda0 = initRecordTimeStamp3 != null ? HexCodec.BuiltInFictitiousFunctionClassFactory(initRecordTimeStamp3) : 0L;
                } else if (!errorConfigVersion.equals("timestamp")) {
                    if (!errorConfigVersion.equals("duration")) {
                        if (!errorConfigVersion.equals("annotations")) {
                            if (!errorConfigVersion.equals("binaryAnnotations")) {
                                if (errorConfigVersion.equals(BuildConfig.BUILD_TYPE)) {
                                    if (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = Boolean.TRUE;
                                    }
                                } else {
                                    jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                                }
                            } else {
                                jsonReader.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                                while (jsonReader.getAuthRequestContext()) {
                                    MyBillsEntityDataFactory(jsonReader);
                                }
                                jsonReader.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                            }
                        } else {
                            jsonReader.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                            while (jsonReader.getAuthRequestContext()) {
                                PlaceComponentResult(jsonReader);
                            }
                            jsonReader.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                        }
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                    }
                } else {
                    this.BuiltInFictitiousFunctionClassFactory.moveToNextValue = jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            } else {
                jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
            }
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        return new V1Span(this.BuiltInFictitiousFunctionClassFactory);
    }

    private void PlaceComponentResult(JsonCodec.JsonReader jsonReader) throws IOException {
        jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        Long l = null;
        String str = null;
        Endpoint endpoint = null;
        while (jsonReader.getAuthRequestContext()) {
            String errorConfigVersion = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
            if (errorConfigVersion.equals("timestamp")) {
                l = Long.valueOf(jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
            } else if (!errorConfigVersion.equals("value")) {
                if (errorConfigVersion.equals(ServiceConstants.WORKER_PARAM_ENDPOINT) && !jsonReader.MyBillsEntityDataFactory()) {
                    endpoint = V2SpanReader.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader);
                } else {
                    jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                }
            } else {
                str = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
            }
        }
        if (l == null || str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Incomplete annotation at ");
            sb.append(jsonReader.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
            throw new IllegalArgumentException(sb.toString());
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(l.longValue(), str, endpoint);
    }

    private void MyBillsEntityDataFactory(JsonCodec.JsonReader jsonReader) throws IOException {
        jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        String str = null;
        String str2 = null;
        Boolean bool = null;
        Endpoint endpoint = null;
        while (jsonReader.getAuthRequestContext()) {
            String errorConfigVersion = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
            if (!jsonReader.MyBillsEntityDataFactory()) {
                if (!errorConfigVersion.equals("key")) {
                    if (errorConfigVersion.equals("value")) {
                        if (!jsonReader.BuiltInFictitiousFunctionClassFactory()) {
                            if (jsonReader.PlaceComponentResult()) {
                                bool = Boolean.valueOf(jsonReader.KClassImpl$Data$declaredNonStaticMembers$2());
                            } else {
                                jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                            }
                        } else {
                            str2 = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                        }
                    } else if (errorConfigVersion.equals(ServiceConstants.WORKER_PARAM_ENDPOINT)) {
                        endpoint = V2SpanReader.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader);
                    } else {
                        jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                    }
                } else {
                    str = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                }
            } else {
                jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
            }
        }
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No key at ");
            sb.append(jsonReader.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
            throw new IllegalArgumentException(sb.toString());
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        if (str2 != null) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(str, str2, endpoint);
        } else if (bool == null || !bool.booleanValue() || endpoint == null) {
        } else {
            if (str.equals("sa") || str.equals("ca") || str.equals("ma")) {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(str, endpoint);
            }
        }
    }
}
