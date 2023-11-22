package zipkin2.internal;

import com.alibaba.ariver.kernel.common.log.PageLog;
import com.alibaba.exthub.BuildConfig;
import java.io.IOException;
import java.util.Locale;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.JsonCodec;

/* loaded from: classes9.dex */
public final class V2SpanReader implements JsonCodec.JsonReaderAdapter<Span> {
    static final JsonCodec.JsonReaderAdapter<Endpoint> PlaceComponentResult = new JsonCodec.JsonReaderAdapter<Endpoint>() { // from class: zipkin2.internal.V2SpanReader.1
        public String toString() {
            return "Endpoint";
        }

        @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
        public final /* synthetic */ Endpoint KClassImpl$Data$declaredNonStaticMembers$2(JsonCodec.JsonReader jsonReader) throws IOException {
            Endpoint.Builder newBuilder = Endpoint.newBuilder();
            jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            boolean z = false;
            while (true) {
                String str = null;
                if (!jsonReader.getAuthRequestContext()) {
                    break;
                }
                String errorConfigVersion = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
                if (!jsonReader.MyBillsEntityDataFactory()) {
                    if (!errorConfigVersion.equals("serviceName")) {
                        if (errorConfigVersion.equals("ipv4") || errorConfigVersion.equals("ipv6")) {
                            newBuilder.BuiltInFictitiousFunctionClassFactory(jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
                        } else if (errorConfigVersion.equals("port")) {
                            newBuilder.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader.BuiltInFictitiousFunctionClassFactory.scheduleImpl());
                        } else {
                            jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                        }
                    } else {
                        String initRecordTimeStamp = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                        if (initRecordTimeStamp != null && !initRecordTimeStamp.isEmpty()) {
                            str = initRecordTimeStamp.toLowerCase(Locale.ROOT);
                        }
                        newBuilder.lookAheadTest = str;
                    }
                    z = true;
                } else {
                    jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                }
            }
            jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            if (z) {
                return new Endpoint(newBuilder);
            }
            return null;
        }
    };
    Span.Builder BuiltInFictitiousFunctionClassFactory;

    public final String toString() {
        return "Span";
    }

    @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
    public final /* synthetic */ Span KClassImpl$Data$declaredNonStaticMembers$2(JsonCodec.JsonReader jsonReader) throws IOException {
        Span.Builder builder = this.BuiltInFictitiousFunctionClassFactory;
        if (builder == null) {
            this.BuiltInFictitiousFunctionClassFactory = Span.newBuilder();
        } else {
            builder.PlaceComponentResult();
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        while (jsonReader.getAuthRequestContext()) {
            String errorConfigVersion = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
            if (!errorConfigVersion.equals("traceId")) {
                if (errorConfigVersion.equals("id")) {
                    this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
                } else if (!jsonReader.MyBillsEntityDataFactory()) {
                    if (errorConfigVersion.equals("parentId")) {
                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
                    } else if (!errorConfigVersion.equals("kind")) {
                        String str = null;
                        str = null;
                        if (errorConfigVersion.equals("name")) {
                            Span.Builder builder2 = this.BuiltInFictitiousFunctionClassFactory;
                            String initRecordTimeStamp = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                            if (initRecordTimeStamp != null && !initRecordTimeStamp.isEmpty()) {
                                str = initRecordTimeStamp.toLowerCase(Locale.ROOT);
                            }
                            builder2.scheduleImpl = str;
                        } else {
                            if (errorConfigVersion.equals("timestamp")) {
                                Span.Builder builder3 = this.BuiltInFictitiousFunctionClassFactory;
                                long NetworkUserEntityData$$ExternalSyntheticLambda0 = jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                                builder3.NetworkUserEntityData$$ExternalSyntheticLambda1 = NetworkUserEntityData$$ExternalSyntheticLambda0 >= 0 ? NetworkUserEntityData$$ExternalSyntheticLambda0 : 0L;
                            } else if (errorConfigVersion.equals("duration")) {
                                Span.Builder builder4 = this.BuiltInFictitiousFunctionClassFactory;
                                long NetworkUserEntityData$$ExternalSyntheticLambda02 = jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                                builder4.getAuthRequestContext = NetworkUserEntityData$$ExternalSyntheticLambda02 >= 0 ? NetworkUserEntityData$$ExternalSyntheticLambda02 : 0L;
                            } else if (errorConfigVersion.equals("localEndpoint")) {
                                Span.Builder builder5 = this.BuiltInFictitiousFunctionClassFactory;
                                Endpoint KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader);
                                builder5.getErrorConfigVersion = Span.EMPTY_ENDPOINT.equals(KClassImpl$Data$declaredNonStaticMembers$2) ? null : KClassImpl$Data$declaredNonStaticMembers$2;
                            } else if (errorConfigVersion.equals("remoteEndpoint")) {
                                Span.Builder builder6 = this.BuiltInFictitiousFunctionClassFactory;
                                Endpoint KClassImpl$Data$declaredNonStaticMembers$22 = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader);
                                builder6.NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(KClassImpl$Data$declaredNonStaticMembers$22) ? null : KClassImpl$Data$declaredNonStaticMembers$22;
                            } else if (!errorConfigVersion.equals("annotations")) {
                                if (!errorConfigVersion.equals(PageLog.PAGE_LOG_TAGS)) {
                                    if (errorConfigVersion.equals(BuildConfig.BUILD_TYPE)) {
                                        if (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(true);
                                        }
                                    } else if (errorConfigVersion.equals("shared")) {
                                        if (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                            Span.Builder builder7 = this.BuiltInFictitiousFunctionClassFactory;
                                            int i = builder7.BuiltInFictitiousFunctionClassFactory | 16;
                                            builder7.BuiltInFictitiousFunctionClassFactory = i;
                                            builder7.BuiltInFictitiousFunctionClassFactory = i | 8;
                                        }
                                    } else {
                                        jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                                    }
                                } else {
                                    jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
                                    while (jsonReader.getAuthRequestContext()) {
                                        String errorConfigVersion2 = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
                                        if (jsonReader.MyBillsEntityDataFactory()) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("No value at ");
                                            sb.append(jsonReader.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
                                            throw new IllegalArgumentException(sb.toString());
                                        }
                                        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(errorConfigVersion2, jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
                                    }
                                    jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                                }
                            } else {
                                jsonReader.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                                while (jsonReader.getAuthRequestContext()) {
                                    jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
                                    Long l = null;
                                    String str2 = null;
                                    while (jsonReader.getAuthRequestContext()) {
                                        String errorConfigVersion3 = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
                                        if (errorConfigVersion3.equals("timestamp")) {
                                            l = Long.valueOf(jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0());
                                        } else if (errorConfigVersion3.equals("value")) {
                                            str2 = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                                        } else {
                                            jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                                        }
                                    }
                                    if (l == null || str2 == null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Incomplete annotation at ");
                                        sb2.append(jsonReader.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult());
                                        throw new IllegalArgumentException(sb2.toString());
                                    }
                                    jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                                    this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(l.longValue(), str2);
                                }
                                jsonReader.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                            }
                        }
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.valueOf(jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
                    }
                } else {
                    jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                }
            } else {
                this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = Span.normalizeTraceId(jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp());
            }
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
    }
}
