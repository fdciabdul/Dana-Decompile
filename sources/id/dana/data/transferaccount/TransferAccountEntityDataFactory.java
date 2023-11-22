package id.dana.data.transferaccount;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.transferaccount.source.network.NetworkTransferAccountEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/transferaccount/TransferAccountEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/transferaccount/TransferAccountEntityData;", "Lid/dana/data/transferaccount/source/network/NetworkTransferAccountEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/transferaccount/source/network/NetworkTransferAccountEntityData;", "p0", "<init>", "(Lid/dana/data/transferaccount/source/network/NetworkTransferAccountEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferAccountEntityDataFactory extends AbstractEntityDataFactory<TransferAccountEntityData> {
    final NetworkTransferAccountEntityData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public TransferAccountEntityDataFactory(NetworkTransferAccountEntityData networkTransferAccountEntityData) {
        Intrinsics.checkNotNullParameter(networkTransferAccountEntityData, "");
        this.BuiltInFictitiousFunctionClassFactory = networkTransferAccountEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ TransferAccountEntityData createData2(String str) {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
