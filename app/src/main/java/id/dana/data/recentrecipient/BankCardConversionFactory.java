package id.dana.data.recentrecipient;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.recentrecipient.source.BankCardConversionEntityData;
import id.dana.data.recentrecipient.source.mock.MockBankCardConversionEntityData;
import id.dana.data.recentrecipient.source.network.NetworkBankCardConversionEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/recentrecipient/BankCardConversionFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/recentrecipient/source/BankCardConversionEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/recentrecipient/source/BankCardConversionEntityData;", "Lid/dana/data/recentrecipient/source/network/NetworkBankCardConversionEntityData;", "networkBankCardConversionEntityData", "Lid/dana/data/recentrecipient/source/network/NetworkBankCardConversionEntityData;", "<init>", "(Lid/dana/data/recentrecipient/source/network/NetworkBankCardConversionEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BankCardConversionFactory extends AbstractEntityDataFactory<BankCardConversionEntityData> {
    private final NetworkBankCardConversionEntityData networkBankCardConversionEntityData;

    @Inject
    public BankCardConversionFactory(NetworkBankCardConversionEntityData networkBankCardConversionEntityData) {
        Intrinsics.checkNotNullParameter(networkBankCardConversionEntityData, "");
        this.networkBankCardConversionEntityData = networkBankCardConversionEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final BankCardConversionEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        return Intrinsics.areEqual(source, "mock") ? new MockBankCardConversionEntityData() : this.networkBankCardConversionEntityData;
    }
}
