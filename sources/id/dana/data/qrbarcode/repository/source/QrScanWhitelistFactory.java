package id.dana.data.qrbarcode.repository.source;

import dagger.Lazy;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.qrbarcode.repository.source.mock.MockQrScanWhitelistEntityData;
import id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0005\u001a\u0006*\u00020\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/QrScanWhitelistFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/qrbarcode/repository/source/QrScanWhitelistEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/qrbarcode/repository/source/QrScanWhitelistEntityData;", "Ldagger/Lazy;", "Lid/dana/data/qrbarcode/repository/source/mock/MockQrScanWhitelistEntityData;", "mockQrScanWhitelistEntityData", "Ldagger/Lazy;", "Lid/dana/data/qrbarcode/repository/source/network/SplitQrScanWhitelistConfig;", "splitQrScanWhitelistConfig", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QrScanWhitelistFactory extends AbstractEntityDataFactory<QrScanWhitelistEntityData> {
    private final Lazy<MockQrScanWhitelistEntityData> mockQrScanWhitelistEntityData;
    private final Lazy<SplitQrScanWhitelistConfig> splitQrScanWhitelistConfig;

    @Inject
    public QrScanWhitelistFactory(Lazy<SplitQrScanWhitelistConfig> lazy, Lazy<MockQrScanWhitelistEntityData> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.splitQrScanWhitelistConfig = lazy;
        this.mockQrScanWhitelistEntityData = lazy2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final QrScanWhitelistEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return Intrinsics.areEqual(source, "split") ? this.splitQrScanWhitelistConfig.get() : this.mockQrScanWhitelistEntityData.get();
    }
}
