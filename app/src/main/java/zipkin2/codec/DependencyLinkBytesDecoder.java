package zipkin2.codec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import zipkin2.DependencyLink;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.ReadBuffer;

/* loaded from: classes9.dex */
public enum DependencyLinkBytesDecoder implements BytesDecoder<DependencyLink> {
    JSON_V1 { // from class: zipkin2.codec.DependencyLinkBytesDecoder.1
        public final Encoding encoding() {
            return Encoding.JSON;
        }

        public final boolean decode(byte[] bArr, Collection<DependencyLink> collection) {
            return JsonCodec.MyBillsEntityDataFactory(READER, ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public final DependencyLink decodeOne(byte[] bArr) {
            return (DependencyLink) JsonCodec.PlaceComponentResult(READER, ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        }

        @Override // zipkin2.codec.BytesDecoder
        public final boolean decodeList(byte[] bArr, Collection<DependencyLink> collection) {
            return JsonCodec.getAuthRequestContext(READER, ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        public final List<DependencyLink> decodeList(byte[] bArr) {
            ArrayList arrayList = new ArrayList();
            decodeList(bArr, arrayList);
            return arrayList;
        }
    };

    static final JsonCodec.JsonReaderAdapter<DependencyLink> READER = new JsonCodec.JsonReaderAdapter<DependencyLink>() { // from class: zipkin2.codec.DependencyLinkBytesDecoder.2
        public String toString() {
            return "DependencyLink";
        }

        @Override // zipkin2.internal.JsonCodec.JsonReaderAdapter
        public final /* synthetic */ DependencyLink KClassImpl$Data$declaredNonStaticMembers$2(JsonCodec.JsonReader jsonReader) throws IOException {
            String str;
            DependencyLink.Builder newBuilder = DependencyLink.newBuilder();
            jsonReader.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            while (jsonReader.getAuthRequestContext()) {
                String errorConfigVersion = jsonReader.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
                if (!errorConfigVersion.equals("parent")) {
                    if (!errorConfigVersion.equals("child")) {
                        if (!errorConfigVersion.equals("callCount")) {
                            if (errorConfigVersion.equals("errorCount")) {
                                newBuilder.getAuthRequestContext = jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                            } else {
                                jsonReader.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil();
                            }
                        } else {
                            newBuilder.BuiltInFictitiousFunctionClassFactory = jsonReader.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        }
                    } else {
                        String initRecordTimeStamp = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                        if (initRecordTimeStamp == null) {
                            throw new NullPointerException("child == null");
                        }
                        newBuilder.MyBillsEntityDataFactory = initRecordTimeStamp.toLowerCase(Locale.ROOT);
                    }
                } else {
                    String initRecordTimeStamp2 = jsonReader.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp();
                    if (initRecordTimeStamp2 == null) {
                        throw new NullPointerException("parent == null");
                    }
                    newBuilder.KClassImpl$Data$declaredNonStaticMembers$2 = initRecordTimeStamp2.toLowerCase(Locale.ROOT);
                }
            }
            jsonReader.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            if (newBuilder.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" parent");
                str = sb.toString();
            } else {
                str = "";
            }
            if (newBuilder.MyBillsEntityDataFactory == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" child");
                str = sb2.toString();
            }
            if (!"".equals(str)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Missing :");
                sb3.append(str);
                throw new IllegalStateException(sb3.toString());
            }
            return new DependencyLink(newBuilder);
        }
    };
}
