package id.dana.riskChallenges.data.verifypassword.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityData;", "Lid/dana/riskChallenges/data/verifypassword/source/network/NetworkVerifyPasswordEntityData;", "PlaceComponentResult", "Lid/dana/riskChallenges/data/verifypassword/source/network/NetworkVerifyPasswordEntityData;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/riskChallenges/data/verifypassword/source/network/NetworkVerifyPasswordEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPasswordEntityDataFactory extends AbstractEntityDataFactory<VerifyPasswordEntityData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final NetworkVerifyPasswordEntityData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public VerifyPasswordEntityDataFactory(NetworkVerifyPasswordEntityData networkVerifyPasswordEntityData) {
        Intrinsics.checkNotNullParameter(networkVerifyPasswordEntityData, "");
        this.BuiltInFictitiousFunctionClassFactory = networkVerifyPasswordEntityData;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ VerifyPasswordEntityData createData2(String str) {
        if (Intrinsics.areEqual(str, "network")) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }
}
