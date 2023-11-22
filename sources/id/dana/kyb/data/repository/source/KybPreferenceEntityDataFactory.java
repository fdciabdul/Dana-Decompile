package id.dana.kyb.data.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.kyb.data.KybPreferenceEntityData;
import id.dana.kyb.data.repository.source.local.LocalKybPreferenceEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/kyb/data/repository/source/KybPreferenceEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/kyb/data/KybPreferenceEntityData;", "Lid/dana/kyb/data/repository/source/local/LocalKybPreferenceEntityData;", "MyBillsEntityDataFactory", "Lid/dana/kyb/data/repository/source/local/LocalKybPreferenceEntityData;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/kyb/data/repository/source/local/LocalKybPreferenceEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KybPreferenceEntityDataFactory extends AbstractEntityDataFactory<KybPreferenceEntityData> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final LocalKybPreferenceEntityData BuiltInFictitiousFunctionClassFactory;

    @Inject
    public KybPreferenceEntityDataFactory(LocalKybPreferenceEntityData localKybPreferenceEntityData) {
        Intrinsics.checkNotNullParameter(localKybPreferenceEntityData, "");
        this.BuiltInFictitiousFunctionClassFactory = localKybPreferenceEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ KybPreferenceEntityData createData2(String str) {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
