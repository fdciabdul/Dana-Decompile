package id.dana.riskChallenges.data.passkey.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityData;", "Lid/dana/riskChallenges/data/passkey/source/network/NetworkPasskeyEntityData;", "PlaceComponentResult", "Lid/dana/riskChallenges/data/passkey/source/network/NetworkPasskeyEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/riskChallenges/data/passkey/source/network/NetworkPasskeyEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PasskeyEntityDataFactory extends AbstractEntityDataFactory<PasskeyEntityData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final NetworkPasskeyEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public PasskeyEntityDataFactory(NetworkPasskeyEntityData networkPasskeyEntityData) {
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkPasskeyEntityData;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ PasskeyEntityData createData2(String str) {
        if (Intrinsics.areEqual(str, "network")) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }
}
