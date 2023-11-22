package zipkin2.codec;

import java.util.List;
import zipkin2.DependencyLink;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.JsonEscaper;
import zipkin2.internal.WriteBuffer;

/* loaded from: classes9.dex */
public enum DependencyLinkBytesEncoder implements BytesEncoder<DependencyLink> {
    JSON_V1 { // from class: zipkin2.codec.DependencyLinkBytesEncoder.1
        @Override // zipkin2.codec.BytesEncoder
        public final Encoding encoding() {
            return Encoding.JSON;
        }

        public final int sizeInBytes(DependencyLink dependencyLink) {
            return WRITER.PlaceComponentResult(dependencyLink);
        }

        @Override // zipkin2.codec.BytesEncoder
        public final byte[] encode(DependencyLink dependencyLink) {
            return JsonCodec.KClassImpl$Data$declaredNonStaticMembers$2(WRITER, dependencyLink);
        }

        public final byte[] encodeList(List<DependencyLink> list) {
            return JsonCodec.MyBillsEntityDataFactory(WRITER, list);
        }
    };

    static final WriteBuffer.Writer<DependencyLink> WRITER = new WriteBuffer.Writer<DependencyLink>() { // from class: zipkin2.codec.DependencyLinkBytesEncoder.2
        public String toString() {
            return "DependencyLink";
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DependencyLink dependencyLink, WriteBuffer writeBuffer) {
            DependencyLink dependencyLink2 = dependencyLink;
            for (int i = 0; i < 11; i++) {
                int charAt = "{\"parent\":\"".charAt(i) & 255;
                byte[] bArr = writeBuffer.PlaceComponentResult;
                int i2 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i2 + 1;
                bArr[i2] = (byte) (charAt & 255);
            }
            writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(dependencyLink2.parent()));
            for (int i3 = 0; i3 < 11; i3++) {
                int charAt2 = "\",\"child\":\"".charAt(i3) & 255;
                byte[] bArr2 = writeBuffer.PlaceComponentResult;
                int i4 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i4 + 1;
                bArr2[i4] = (byte) (charAt2 & 255);
            }
            writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(dependencyLink2.child()));
            for (int i5 = 0; i5 < 14; i5++) {
                int charAt3 = "\",\"callCount\":".charAt(i5) & 255;
                byte[] bArr3 = writeBuffer.PlaceComponentResult;
                int i6 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i6 + 1;
                bArr3[i6] = (byte) (charAt3 & 255);
            }
            writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(dependencyLink2.callCount());
            if (dependencyLink2.errorCount() > 0) {
                for (int i7 = 0; i7 < 14; i7++) {
                    int charAt4 = ",\"errorCount\":".charAt(i7) & 255;
                    byte[] bArr4 = writeBuffer.PlaceComponentResult;
                    int i8 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i8 + 1;
                    bArr4[i8] = (byte) (charAt4 & 255);
                }
                writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(dependencyLink2.errorCount());
            }
            byte[] bArr5 = writeBuffer.PlaceComponentResult;
            int i9 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i9 + 1;
            bArr5[i9] = 125;
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public final /* synthetic */ int PlaceComponentResult(DependencyLink dependencyLink) {
            DependencyLink dependencyLink2 = dependencyLink;
            int authRequestContext = JsonEscaper.getAuthRequestContext(dependencyLink2.parent()) + 37 + JsonEscaper.getAuthRequestContext(dependencyLink2.child()) + WriteBuffer.BuiltInFictitiousFunctionClassFactory(dependencyLink2.callCount());
            return dependencyLink2.errorCount() > 0 ? authRequestContext + 14 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(dependencyLink2.errorCount()) : authRequestContext;
        }
    };
}
