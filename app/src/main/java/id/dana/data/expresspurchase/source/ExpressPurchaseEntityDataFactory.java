package id.dana.data.expresspurchase.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.expresspurchase.source.config.split.SplitExpressPurchaseConfigEntityData;
import id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData;
import id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "Lid/dana/data/expresspurchase/source/local/LocalExpressPurchaseEntityData;", "localExpressPurchaseEntityData", "Lid/dana/data/expresspurchase/source/local/LocalExpressPurchaseEntityData;", "Lid/dana/data/expresspurchase/source/network/NetworkExpressPurchaseEntityData;", "networkExpressPurchaseEntityData", "Lid/dana/data/expresspurchase/source/network/NetworkExpressPurchaseEntityData;", "Lid/dana/data/expresspurchase/source/config/split/SplitExpressPurchaseConfigEntityData;", "splitExpressPurchaseConfigEntityData", "Lid/dana/data/expresspurchase/source/config/split/SplitExpressPurchaseConfigEntityData;", "<init>", "(Lid/dana/data/expresspurchase/source/network/NetworkExpressPurchaseEntityData;Lid/dana/data/expresspurchase/source/local/LocalExpressPurchaseEntityData;Lid/dana/data/expresspurchase/source/config/split/SplitExpressPurchaseConfigEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpressPurchaseEntityDataFactory extends AbstractEntityDataFactory<ExpressPurchaseEntityData> {
    private final LocalExpressPurchaseEntityData localExpressPurchaseEntityData;
    private final NetworkExpressPurchaseEntityData networkExpressPurchaseEntityData;
    private final SplitExpressPurchaseConfigEntityData splitExpressPurchaseConfigEntityData;

    @Inject
    public ExpressPurchaseEntityDataFactory(NetworkExpressPurchaseEntityData networkExpressPurchaseEntityData, LocalExpressPurchaseEntityData localExpressPurchaseEntityData, SplitExpressPurchaseConfigEntityData splitExpressPurchaseConfigEntityData) {
        Intrinsics.checkNotNullParameter(networkExpressPurchaseEntityData, "");
        Intrinsics.checkNotNullParameter(localExpressPurchaseEntityData, "");
        Intrinsics.checkNotNullParameter(splitExpressPurchaseConfigEntityData, "");
        this.networkExpressPurchaseEntityData = networkExpressPurchaseEntityData;
        this.localExpressPurchaseEntityData = localExpressPurchaseEntityData;
        this.splitExpressPurchaseConfigEntityData = splitExpressPurchaseConfigEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final ExpressPurchaseEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        int hashCode = source.hashCode();
        if (hashCode != 103145323) {
            if (hashCode != 109648666) {
                if (hashCode == 1843485230 && source.equals("network")) {
                    return this.networkExpressPurchaseEntityData;
                }
            } else if (source.equals("split")) {
                return this.splitExpressPurchaseConfigEntityData;
            }
        } else if (source.equals("local")) {
            return this.localExpressPurchaseEntityData;
        }
        throw new UnsupportedOperationException();
    }
}
