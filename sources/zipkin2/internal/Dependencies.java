package zipkin2.internal;

import java.util.List;
import zipkin2.DependencyLink;
import zipkin2.internal.WriteBuffer;

/* loaded from: classes9.dex */
public final class Dependencies {
    final List<DependencyLink> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final long PlaceComponentResult;
    final long getErrorConfigVersion;
    static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 10, 1);
    static final ThriftField MyBillsEntityDataFactory = new ThriftField((byte) 10, 2);
    static final ThriftField BuiltInFictitiousFunctionClassFactory = new ThriftField((byte) 15, 3);
    static final DependencyLinkAdapter getAuthRequestContext = new DependencyLinkAdapter();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Dependencies) {
            Dependencies dependencies = (Dependencies) obj;
            return this.getErrorConfigVersion == dependencies.getErrorConfigVersion && this.PlaceComponentResult == dependencies.PlaceComponentResult && this.NetworkUserEntityData$$ExternalSyntheticLambda0.equals(dependencies.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        return false;
    }

    public final int hashCode() {
        long j = this.getErrorConfigVersion;
        int i = (((int) ((j ^ (j >>> 32)) ^ 1000003)) ^ 1000003) * 1000003;
        long j2 = this.PlaceComponentResult;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode() ^ ((i ^ ((int) (i ^ (j2 ^ (j2 >>> 32))))) * 1000003);
    }

    /* loaded from: classes9.dex */
    static final class DependencyLinkAdapter implements WriteBuffer.Writer<DependencyLink> {
        static final ThriftField MyBillsEntityDataFactory = new ThriftField((byte) 11, 1);
        static final ThriftField getAuthRequestContext = new ThriftField((byte) 11, 2);
        static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 10, 4);
        static final ThriftField BuiltInFictitiousFunctionClassFactory = new ThriftField((byte) 10, 5);

        DependencyLinkAdapter() {
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DependencyLink dependencyLink, WriteBuffer writeBuffer) {
            DependencyLink dependencyLink2 = dependencyLink;
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.MyBillsEntityDataFactory(writeBuffer, dependencyLink2.parent());
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.MyBillsEntityDataFactory(writeBuffer, dependencyLink2.child());
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.PlaceComponentResult(writeBuffer, dependencyLink2.callCount());
            if (dependencyLink2.errorCount() > 0) {
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
                ThriftCodec.PlaceComponentResult(writeBuffer, dependencyLink2.errorCount());
            }
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i + 1;
            bArr[i] = 0;
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public final /* synthetic */ int PlaceComponentResult(DependencyLink dependencyLink) {
            DependencyLink dependencyLink2 = dependencyLink;
            int BuiltInFictitiousFunctionClassFactory2 = WriteBuffer.BuiltInFictitiousFunctionClassFactory(dependencyLink2.parent()) + 7 + 0 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(dependencyLink2.child()) + 7 + 11;
            if (dependencyLink2.errorCount() > 0) {
                BuiltInFictitiousFunctionClassFactory2 += 11;
            }
            return BuiltInFictitiousFunctionClassFactory2 + 1;
        }
    }
}
