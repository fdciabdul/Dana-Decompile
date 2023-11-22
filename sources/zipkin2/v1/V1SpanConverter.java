package zipkin2.v1;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.websocket.WSConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.Nullable;
import zipkin2.internal.RecyclableBuffers;

/* loaded from: classes9.dex */
public final class V1SpanConverter {
    V1Annotation BuiltInFictitiousFunctionClassFactory;
    V1Annotation KClassImpl$Data$declaredNonStaticMembers$2;
    V1Annotation MyBillsEntityDataFactory;
    V1Annotation NetworkUserEntityData$$ExternalSyntheticLambda0;
    V1Annotation PlaceComponentResult;
    V1Annotation getErrorConfigVersion;
    V1Annotation lookAheadTest;
    V1Annotation scheduleImpl;
    final Span.Builder getAuthRequestContext = Span.newBuilder();
    final List<Span.Builder> moveToNextValue = new ArrayList();

    public static V1SpanConverter PlaceComponentResult() {
        return new V1SpanConverter();
    }

    public final void MyBillsEntityDataFactory(V1Span v1Span) {
        this.getAuthRequestContext.PlaceComponentResult();
        this.moveToNextValue.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.scheduleImpl = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getErrorConfigVersion = null;
        this.lookAheadTest = null;
        this.PlaceComponentResult = null;
        MyBillsEntityDataFactory(this.getAuthRequestContext, v1Span);
    }

    public final void BuiltInFictitiousFunctionClassFactory(V1Span v1Span) {
        V1Annotation v1Annotation;
        V1Annotation v1Annotation2;
        Span.Builder BuiltInFictitiousFunctionClassFactory;
        Span.Builder BuiltInFictitiousFunctionClassFactory2;
        int size = v1Span.getAuthRequestContext.size();
        for (int i = 0; i < size; i++) {
            V1Annotation v1Annotation3 = v1Span.getAuthRequestContext.get(i);
            Span.Builder BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation3.KClassImpl$Data$declaredNonStaticMembers$2);
            if (v1Annotation3.PlaceComponentResult.length() == 2 && v1Annotation3.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                if (!v1Annotation3.PlaceComponentResult.equals("cs")) {
                    if (!v1Annotation3.PlaceComponentResult.equals(RVParams.SHOW_REPORT_BTN)) {
                        if (!v1Annotation3.PlaceComponentResult.equals("ss")) {
                            if (!v1Annotation3.PlaceComponentResult.equals("cr")) {
                                if (!v1Annotation3.PlaceComponentResult.equals("ms")) {
                                    if (!v1Annotation3.PlaceComponentResult.equals("mr")) {
                                        if (v1Annotation3.PlaceComponentResult.equals(WSConstant.SCHEME_WS)) {
                                            this.scheduleImpl = v1Annotation3;
                                        } else if (v1Annotation3.PlaceComponentResult.equals("wr")) {
                                            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = v1Annotation3;
                                        } else {
                                            BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2(v1Annotation3.getAuthRequestContext, v1Annotation3.PlaceComponentResult);
                                        }
                                    } else {
                                        BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.CONSUMER;
                                        this.KClassImpl$Data$declaredNonStaticMembers$2 = v1Annotation3;
                                    }
                                } else {
                                    BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.PRODUCER;
                                    this.MyBillsEntityDataFactory = v1Annotation3;
                                }
                            } else {
                                BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.CLIENT;
                                this.BuiltInFictitiousFunctionClassFactory = v1Annotation3;
                            }
                        } else {
                            BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.SERVER;
                            this.getErrorConfigVersion = v1Annotation3;
                        }
                    } else {
                        BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.SERVER;
                        this.lookAheadTest = v1Annotation3;
                    }
                } else {
                    BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.CLIENT;
                    this.PlaceComponentResult = v1Annotation3;
                }
            } else {
                BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2(v1Annotation3.getAuthRequestContext, v1Annotation3.PlaceComponentResult);
            }
        }
        if (this.PlaceComponentResult == null && getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, v1Span)) {
            this.PlaceComponentResult = V1Annotation.getAuthRequestContext(v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0, "cs", this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (this.lookAheadTest == null && getAuthRequestContext(this.getErrorConfigVersion, v1Span)) {
            this.lookAheadTest = V1Annotation.getAuthRequestContext(v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0, RVParams.SHOW_REPORT_BTN, this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        V1Annotation v1Annotation4 = this.PlaceComponentResult;
        if (v1Annotation4 != null && this.lookAheadTest != null) {
            PlaceComponentResult(v1Span, v1Annotation4, this.BuiltInFictitiousFunctionClassFactory);
            Span.Builder BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(v1Span, this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
            if (!getAuthRequestContext(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2)) {
                BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(v1Span, this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                BuiltInFictitiousFunctionClassFactory4.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.CLIENT;
                BuiltInFictitiousFunctionClassFactory2 = KClassImpl$Data$declaredNonStaticMembers$2(v1Span, this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2);
                BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.SERVER;
            }
            int i2 = BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory | 16;
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = i2;
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = i2 | 8;
            long j = this.lookAheadTest.getAuthRequestContext;
            if (j < 0) {
                j = 0;
            }
            BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda1 = j;
            V1Annotation v1Annotation5 = this.getErrorConfigVersion;
            if (v1Annotation5 != null) {
                long j2 = v1Annotation5.getAuthRequestContext - this.lookAheadTest.getAuthRequestContext;
                if (j2 < 0) {
                    j2 = 0;
                }
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext = j2;
            }
            if (this.BuiltInFictitiousFunctionClassFactory == null && v1Span.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                Long l = 0L;
                BuiltInFictitiousFunctionClassFactory4.getAuthRequestContext = l.longValue();
            }
        } else if (v1Annotation4 != null && (v1Annotation2 = this.BuiltInFictitiousFunctionClassFactory) != null) {
            PlaceComponentResult(v1Span, v1Annotation4, v1Annotation2);
        } else {
            V1Annotation v1Annotation6 = this.lookAheadTest;
            if (v1Annotation6 != null && (v1Annotation = this.getErrorConfigVersion) != null) {
                PlaceComponentResult(v1Span, v1Annotation6, v1Annotation);
            } else {
                getAuthRequestContext(v1Span);
            }
        }
        if (this.PlaceComponentResult == null && this.lookAheadTest != null && (v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0 || (this.getErrorConfigVersion != null && v1Span.KClassImpl$Data$declaredNonStaticMembers$2 == 0))) {
            Span.Builder BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(v1Span, this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2);
            int i3 = BuiltInFictitiousFunctionClassFactory5.BuiltInFictitiousFunctionClassFactory | 16;
            BuiltInFictitiousFunctionClassFactory5.BuiltInFictitiousFunctionClassFactory = i3;
            BuiltInFictitiousFunctionClassFactory5.BuiltInFictitiousFunctionClassFactory = i3 | 8;
        }
        V1Annotation v1Annotation7 = this.MyBillsEntityDataFactory;
        if (v1Annotation7 == null || this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            if (v1Annotation7 != null) {
                PlaceComponentResult(v1Span, v1Annotation7, this.scheduleImpl);
                return;
            }
            V1Annotation v1Annotation8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (v1Annotation8 != null) {
                V1Annotation v1Annotation9 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (v1Annotation9 != null) {
                    PlaceComponentResult(v1Span, v1Annotation9, v1Annotation8);
                    return;
                } else {
                    PlaceComponentResult(v1Span, v1Annotation8, null);
                    return;
                }
            }
            V1Annotation v1Annotation10 = this.scheduleImpl;
            if (v1Annotation10 != null) {
                BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation10.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2(this.scheduleImpl.getAuthRequestContext, this.scheduleImpl.PlaceComponentResult);
            }
            V1Annotation v1Annotation11 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (v1Annotation11 != null) {
                BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation11.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult);
                return;
            }
            return;
        }
        Span.Builder BuiltInFictitiousFunctionClassFactory6 = BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation7.KClassImpl$Data$declaredNonStaticMembers$2);
        if (!getAuthRequestContext(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2)) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(v1Span, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            BuiltInFictitiousFunctionClassFactory6.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.PRODUCER;
            BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(v1Span, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.CONSUMER;
        }
        int i4 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory | 16;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = i4;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = i4 | 8;
        V1Annotation v1Annotation12 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (v1Annotation12 != null) {
            long j3 = v1Annotation12.getAuthRequestContext;
            if (j3 < 0) {
                j3 = 0;
            }
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = j3;
            long j4 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext - this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
            if (j4 < 0) {
                j4 = 0;
            }
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = j4;
        } else {
            long j5 = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            if (j5 < 0) {
                j5 = 0;
            }
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = j5;
        }
        long j6 = this.MyBillsEntityDataFactory.getAuthRequestContext;
        if (j6 < 0) {
            j6 = 0;
        }
        BuiltInFictitiousFunctionClassFactory6.NetworkUserEntityData$$ExternalSyntheticLambda1 = j6;
        V1Annotation v1Annotation13 = this.scheduleImpl;
        Long valueOf = v1Annotation13 != null ? Long.valueOf(v1Annotation13.getAuthRequestContext - this.MyBillsEntityDataFactory.getAuthRequestContext) : null;
        if (valueOf == null || valueOf.longValue() < 0) {
            valueOf = 0L;
        }
        BuiltInFictitiousFunctionClassFactory6.getAuthRequestContext = valueOf.longValue();
    }

    private void getAuthRequestContext(V1Span v1Span) {
        getAuthRequestContext(this.getAuthRequestContext);
        int size = this.moveToNextValue.size();
        for (int i = 0; i < size; i++) {
            getAuthRequestContext(this.moveToNextValue.get(i));
        }
        if (v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
            Span.Builder builder = this.getAuthRequestContext;
            long j = v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (j < 0) {
                j = 0;
            }
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = j;
            long j2 = v1Span.KClassImpl$Data$declaredNonStaticMembers$2;
            builder.getAuthRequestContext = j2 >= 0 ? j2 : 0L;
        }
    }

    private void getAuthRequestContext(Span.Builder builder) {
        if (Span.Kind.CLIENT.equals(builder.KClassImpl$Data$declaredNonStaticMembers$2)) {
            V1Annotation v1Annotation = this.PlaceComponentResult;
            if (v1Annotation != null) {
                long j = v1Annotation.getAuthRequestContext;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = j >= 0 ? j : 0L;
            }
            V1Annotation v1Annotation2 = this.BuiltInFictitiousFunctionClassFactory;
            if (v1Annotation2 != null) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2(v1Annotation2.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
            }
        } else if (Span.Kind.SERVER.equals(builder.KClassImpl$Data$declaredNonStaticMembers$2)) {
            V1Annotation v1Annotation3 = this.lookAheadTest;
            if (v1Annotation3 != null) {
                long j2 = v1Annotation3.getAuthRequestContext;
                builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = j2 >= 0 ? j2 : 0L;
            }
            V1Annotation v1Annotation4 = this.getErrorConfigVersion;
            if (v1Annotation4 != null) {
                builder.KClassImpl$Data$declaredNonStaticMembers$2(v1Annotation4.getAuthRequestContext, this.getErrorConfigVersion.PlaceComponentResult);
            }
        }
    }

    private static boolean getAuthRequestContext(V1Annotation v1Annotation, V1Span v1Span) {
        return (v1Annotation == null || v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0 || v1Span.KClassImpl$Data$declaredNonStaticMembers$2 == 0 || v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + v1Span.KClassImpl$Data$declaredNonStaticMembers$2 != v1Annotation.getAuthRequestContext) ? false : true;
    }

    private void PlaceComponentResult(V1Span v1Span, V1Annotation v1Annotation, @Nullable V1Annotation v1Annotation2) {
        Span.Builder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2);
        if (v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0 && v1Span.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            long j = v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (j < 0) {
                j = 0;
            }
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = j;
            long j2 = v1Span.KClassImpl$Data$declaredNonStaticMembers$2;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = j2 >= 0 ? j2 : 0L;
            return;
        }
        long j3 = v1Annotation.getAuthRequestContext;
        if (j3 < 0) {
            j3 = 0;
        }
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = j3;
        if (v1Annotation2 != null) {
            long j4 = v1Annotation2.getAuthRequestContext - v1Annotation.getAuthRequestContext;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = j4 >= 0 ? j4 : 0L;
        }
    }

    public final void PlaceComponentResult(V1Span v1Span) {
        int size = v1Span.MyBillsEntityDataFactory.size();
        boolean z = false;
        Endpoint endpoint = null;
        Endpoint endpoint2 = null;
        Endpoint endpoint3 = null;
        for (int i = 0; i < size; i++) {
            V1BinaryAnnotation v1BinaryAnnotation = v1Span.MyBillsEntityDataFactory.get(i);
            if ("ca".equals(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory)) {
                endpoint = v1BinaryAnnotation.PlaceComponentResult;
            } else if ("sa".equals(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory)) {
                endpoint2 = v1BinaryAnnotation.PlaceComponentResult;
            } else if ("ma".equals(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory)) {
                endpoint3 = v1BinaryAnnotation.PlaceComponentResult;
            } else {
                Span.Builder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(v1Span, v1BinaryAnnotation.PlaceComponentResult);
                if (!"lc".equals(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory) || !v1BinaryAnnotation.getAuthRequestContext.isEmpty()) {
                    BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory, v1BinaryAnnotation.getAuthRequestContext);
                }
            }
        }
        if (this.PlaceComponentResult == null && this.BuiltInFictitiousFunctionClassFactory == null && this.getErrorConfigVersion == null && this.lookAheadTest == null) {
            z = true;
        }
        if (z && (endpoint != null || endpoint2 != null)) {
            if (endpoint != null && endpoint2 != null) {
                BuiltInFictitiousFunctionClassFactory(v1Span, endpoint).NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(endpoint2) ? null : endpoint2;
                return;
            } else if (endpoint2 == null) {
                Span.Builder BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(v1Span, null);
                BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.SERVER;
                BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(endpoint) ? null : endpoint;
                return;
            } else {
                BuiltInFictitiousFunctionClassFactory(v1Span, null).NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(endpoint2) ? null : endpoint2;
                return;
            }
        }
        V1Annotation v1Annotation = this.lookAheadTest;
        if (v1Annotation == null) {
            v1Annotation = this.getErrorConfigVersion;
        }
        if (endpoint != null && v1Annotation != null && !endpoint.equals(v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2)) {
            if (getAuthRequestContext(endpoint, v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2)) {
                Endpoint.Builder builder = endpoint.toBuilder();
                builder.lookAheadTest = null;
                endpoint = new Endpoint(builder);
            }
            Span.Builder BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2);
            if (Span.EMPTY_ENDPOINT.equals(endpoint)) {
                endpoint = null;
            }
            BuiltInFictitiousFunctionClassFactory3.NetworkUserEntityData$$ExternalSyntheticLambda0 = endpoint;
        }
        if (endpoint2 != null) {
            V1Annotation v1Annotation2 = this.PlaceComponentResult;
            if (v1Annotation2 != null) {
                Span.Builder BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation2.KClassImpl$Data$declaredNonStaticMembers$2);
                if (Span.EMPTY_ENDPOINT.equals(endpoint2)) {
                    endpoint2 = null;
                }
                BuiltInFictitiousFunctionClassFactory4.NetworkUserEntityData$$ExternalSyntheticLambda0 = endpoint2;
            } else {
                V1Annotation v1Annotation3 = this.BuiltInFictitiousFunctionClassFactory;
                if (v1Annotation3 != null) {
                    Span.Builder BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation3.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (Span.EMPTY_ENDPOINT.equals(endpoint2)) {
                        endpoint2 = null;
                    }
                    BuiltInFictitiousFunctionClassFactory5.NetworkUserEntityData$$ExternalSyntheticLambda0 = endpoint2;
                }
            }
        }
        if (endpoint3 != null) {
            V1Annotation v1Annotation4 = this.MyBillsEntityDataFactory;
            if (v1Annotation4 != null) {
                BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation4.KClassImpl$Data$declaredNonStaticMembers$2).NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(endpoint3) ? null : endpoint3;
            }
            V1Annotation v1Annotation5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (v1Annotation5 != null) {
                BuiltInFictitiousFunctionClassFactory(v1Span, v1Annotation5.KClassImpl$Data$declaredNonStaticMembers$2).NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(endpoint3) ? null : endpoint3;
            }
        }
    }

    private Span.Builder BuiltInFictitiousFunctionClassFactory(V1Span v1Span, @Nullable Endpoint endpoint) {
        if (endpoint == null) {
            return this.getAuthRequestContext;
        }
        if (getAuthRequestContext(this.getAuthRequestContext, endpoint)) {
            return this.getAuthRequestContext;
        }
        int size = this.moveToNextValue.size();
        for (int i = 0; i < size; i++) {
            Span.Builder builder = this.moveToNextValue.get(i);
            if (getAuthRequestContext(builder, endpoint)) {
                return builder;
            }
        }
        Span.Builder MyBillsEntityDataFactory = MyBillsEntityDataFactory(Span.newBuilder(), v1Span);
        if (Span.EMPTY_ENDPOINT.equals(endpoint)) {
            endpoint = null;
        }
        MyBillsEntityDataFactory.getErrorConfigVersion = endpoint;
        this.moveToNextValue.add(MyBillsEntityDataFactory);
        return MyBillsEntityDataFactory;
    }

    private Span.Builder KClassImpl$Data$declaredNonStaticMembers$2(V1Span v1Span, Endpoint endpoint) {
        Span.Builder MyBillsEntityDataFactory = MyBillsEntityDataFactory(Span.newBuilder(), v1Span);
        if (Span.EMPTY_ENDPOINT.equals(endpoint)) {
            endpoint = null;
        }
        MyBillsEntityDataFactory.getErrorConfigVersion = endpoint;
        this.moveToNextValue.add(MyBillsEntityDataFactory);
        return MyBillsEntityDataFactory;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Collection<Span> collection) {
        collection.add(this.getAuthRequestContext.getAuthRequestContext());
        int size = this.moveToNextValue.size();
        for (int i = 0; i < size; i++) {
            collection.add(this.moveToNextValue.get(i).getAuthRequestContext());
        }
    }

    private static boolean getAuthRequestContext(Endpoint endpoint, @Nullable Endpoint endpoint2) {
        return MyBillsEntityDataFactory(endpoint.serviceName(), endpoint2.serviceName());
    }

    private static boolean MyBillsEntityDataFactory(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static Span.Builder MyBillsEntityDataFactory(Span.Builder builder, V1Span v1Span) {
        int i;
        long j = v1Span.GetContactSyncConfig;
        long j2 = v1Span.scheduleImpl;
        if (j == 0 && j2 == 0) {
            throw new IllegalArgumentException("empty trace ID");
        }
        char[] BuiltInFictitiousFunctionClassFactory = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
        if (j != 0) {
            Span.writeHexLong(BuiltInFictitiousFunctionClassFactory, 0, j);
            i = 16;
        } else {
            i = 0;
        }
        Span.writeHexLong(BuiltInFictitiousFunctionClassFactory, i, j2);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = new String(BuiltInFictitiousFunctionClassFactory, 0, j != 0 ? 32 : 16);
        long j3 = v1Span.getErrorConfigVersion;
        String str = null;
        builder.moveToNextValue = j3 != 0 ? Span.toLowerHex(j3) : null;
        long j4 = v1Span.moveToNextValue;
        if (j4 == 0) {
            throw new IllegalArgumentException("empty id");
        }
        builder.PlaceComponentResult = Span.toLowerHex(j4);
        String str2 = v1Span.lookAheadTest;
        if (str2 != null && !str2.isEmpty()) {
            str = str2.toLowerCase(Locale.ROOT);
        }
        builder.scheduleImpl = str;
        Boolean bool = v1Span.PlaceComponentResult;
        if (bool != null) {
            return builder.getAuthRequestContext(bool.booleanValue());
        }
        builder.BuiltInFictitiousFunctionClassFactory &= -7;
        return builder;
    }

    V1SpanConverter() {
    }

    private static boolean getAuthRequestContext(Span.Builder builder, Endpoint endpoint) {
        Endpoint endpoint2 = builder.getErrorConfigVersion;
        if (endpoint2 != null) {
            return getAuthRequestContext(endpoint2, endpoint);
        }
        if (Span.EMPTY_ENDPOINT.equals(endpoint)) {
            endpoint = null;
        }
        builder.getErrorConfigVersion = endpoint;
        return true;
    }
}
