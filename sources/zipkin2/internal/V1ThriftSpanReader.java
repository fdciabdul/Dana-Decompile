package zipkin2.internal;

import java.util.Locale;
import zipkin2.Endpoint;
import zipkin2.v1.V1Span;

/* loaded from: classes9.dex */
public final class V1ThriftSpanReader {
    static final String MyBillsEntityDataFactory = Character.toString(1);
    V1Span.Builder getAuthRequestContext = V1Span.KClassImpl$Data$declaredNonStaticMembers$2();

    public final V1Span getAuthRequestContext(ReadBuffer readBuffer) {
        V1Span.Builder builder = this.getAuthRequestContext;
        if (builder == null) {
            this.getAuthRequestContext = V1Span.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        while (true) {
            ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = ThriftField.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
            if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult != 0) {
                if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                    if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.scheduleImpl)) {
                        if (KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.getErrorConfigVersion)) {
                            V1Span.Builder builder2 = this.getAuthRequestContext;
                            String MyBillsEntityDataFactory2 = readBuffer.MyBillsEntityDataFactory(readBuffer.getAuthRequestContext());
                            builder2.scheduleImpl = (MyBillsEntityDataFactory2 == null || MyBillsEntityDataFactory2.isEmpty()) ? null : MyBillsEntityDataFactory2.toLowerCase(Locale.ROOT);
                        } else if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.lookAheadTest)) {
                            if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                                if (KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.PlaceComponentResult)) {
                                    int KClassImpl$Data$declaredNonStaticMembers$22 = ThriftCodec.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
                                    for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$22; i++) {
                                        AnnotationReader.BuiltInFictitiousFunctionClassFactory(readBuffer, this.getAuthRequestContext);
                                    }
                                } else if (KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.getAuthRequestContext)) {
                                    int KClassImpl$Data$declaredNonStaticMembers$23 = ThriftCodec.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
                                    for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$23; i2++) {
                                        BinaryAnnotationReader.MyBillsEntityDataFactory(readBuffer, this.getAuthRequestContext);
                                    }
                                } else if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.KClassImpl$Data$declaredNonStaticMembers$2)) {
                                    if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.moveToNextValue)) {
                                        if (!KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(V1ThriftSpanWriter.MyBillsEntityDataFactory)) {
                                            ThriftCodec.BuiltInFictitiousFunctionClassFactory(readBuffer, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
                                        } else {
                                            this.getAuthRequestContext.MyBillsEntityDataFactory = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                                        }
                                    } else {
                                        this.getAuthRequestContext.moveToNextValue = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                                    }
                                } else {
                                    this.getAuthRequestContext.PlaceComponentResult = Boolean.valueOf(readBuffer.MyBillsEntityDataFactory() == 1);
                                }
                            } else {
                                this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                            }
                        } else {
                            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    } else {
                        this.getAuthRequestContext.getErrorConfigVersion = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                } else {
                    this.getAuthRequestContext.lookAheadTest = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            } else {
                return new V1Span(this.getAuthRequestContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AnnotationReader {
        static final ThriftField getAuthRequestContext = new ThriftField((byte) 10, 1);
        static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 11, 2);
        static final ThriftField PlaceComponentResult = new ThriftField((byte) 12, 3);

        AnnotationReader() {
        }

        static void BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer, V1Span.Builder builder) {
            String str = null;
            long j = 0;
            Endpoint endpoint = null;
            while (true) {
                ThriftField KClassImpl$Data$declaredNonStaticMembers$22 = ThriftField.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
                if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult == 0) {
                    break;
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext)) {
                    j = readBuffer.KClassImpl$Data$declaredNonStaticMembers$2();
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    str = readBuffer.MyBillsEntityDataFactory(readBuffer.getAuthRequestContext());
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult)) {
                    endpoint = ThriftEndpointCodec.BuiltInFictitiousFunctionClassFactory(readBuffer);
                } else {
                    ThriftCodec.BuiltInFictitiousFunctionClassFactory(readBuffer, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult);
                }
            }
            if (j == 0 || str == null) {
                return;
            }
            builder.MyBillsEntityDataFactory(j, str, endpoint);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class BinaryAnnotationReader {
        static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 11, 1);
        static final ThriftField MyBillsEntityDataFactory = new ThriftField((byte) 11, 2);
        static final ThriftField getAuthRequestContext = new ThriftField((byte) 8, 3);
        static final ThriftField BuiltInFictitiousFunctionClassFactory = new ThriftField((byte) 12, 4);

        BinaryAnnotationReader() {
        }

        static void MyBillsEntityDataFactory(ReadBuffer readBuffer, V1Span.Builder builder) {
            boolean z = false;
            String str = null;
            String str2 = null;
            Endpoint endpoint = null;
            boolean z2 = false;
            while (true) {
                ThriftField KClassImpl$Data$declaredNonStaticMembers$22 = ThriftField.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
                if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult == 0) {
                    break;
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    str = readBuffer.MyBillsEntityDataFactory(readBuffer.getAuthRequestContext());
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory)) {
                    str2 = readBuffer.MyBillsEntityDataFactory(readBuffer.getAuthRequestContext());
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext)) {
                    int authRequestContext = readBuffer.getAuthRequestContext();
                    if (authRequestContext == 0) {
                        z2 = true;
                    } else if (authRequestContext == 6) {
                        z = true;
                    }
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory)) {
                    endpoint = ThriftEndpointCodec.BuiltInFictitiousFunctionClassFactory(readBuffer);
                } else {
                    ThriftCodec.BuiltInFictitiousFunctionClassFactory(readBuffer, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult);
                }
            }
            if (str == null || str2 == null) {
                return;
            }
            if (z) {
                builder.getAuthRequestContext(str, str2, endpoint);
            } else if (z2 && V1ThriftSpanReader.MyBillsEntityDataFactory.equals(str2) && endpoint != null) {
                if (str.equals("sa") || str.equals("ca") || str.equals("ma")) {
                    builder.KClassImpl$Data$declaredNonStaticMembers$2(str, endpoint);
                }
            }
        }
    }
}
