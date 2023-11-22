package id.dana.data.senddigitalmoney.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData;
import id.dana.data.senddigitalmoney.repository.source.network.NetworkDigitalMoneyEntityData;
import id.dana.data.senddigitalmoney.repository.source.split.SplitSendDigitalMoneyEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/senddigitalmoney/repository/source/SendDigitalMoneyEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/senddigitalmoney/SendDigitalMoneyEntityData;", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/data/senddigitalmoney/SendDigitalMoneyEntityData;", "Lid/dana/data/senddigitalmoney/repository/source/network/NetworkDigitalMoneyEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/senddigitalmoney/repository/source/network/NetworkDigitalMoneyEntityData;", "Lid/dana/data/senddigitalmoney/repository/source/split/SplitSendDigitalMoneyEntityData;", "getAuthRequestContext", "Lid/dana/data/senddigitalmoney/repository/source/split/SplitSendDigitalMoneyEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Lid/dana/data/senddigitalmoney/repository/source/network/NetworkDigitalMoneyEntityData;Lid/dana/data/senddigitalmoney/repository/source/split/SplitSendDigitalMoneyEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendDigitalMoneyEntityDataFactory extends AbstractEntityDataFactory<SendDigitalMoneyEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final NetworkDigitalMoneyEntityData MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SplitSendDigitalMoneyEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SendDigitalMoneyEntityDataFactory(NetworkDigitalMoneyEntityData networkDigitalMoneyEntityData, SplitSendDigitalMoneyEntityData splitSendDigitalMoneyEntityData) {
        Intrinsics.checkNotNullParameter(networkDigitalMoneyEntityData, "");
        Intrinsics.checkNotNullParameter(splitSendDigitalMoneyEntityData, "");
        this.MyBillsEntityDataFactory = networkDigitalMoneyEntityData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = splitSendDigitalMoneyEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final SendDigitalMoneyEntityData createData2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return Intrinsics.areEqual(p0, "split") ? this.KClassImpl$Data$declaredNonStaticMembers$2 : this.MyBillsEntityDataFactory;
    }
}
