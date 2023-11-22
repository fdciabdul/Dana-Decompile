package id.dana.cardbinding.data.repository.source.local;

import id.dana.cardbinding.data.model.BindingCardAddResult;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import id.dana.cardbinding.data.repository.source.CardBindingEntityData;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005"}, d2 = {"Lid/dana/cardbinding/data/repository/source/local/MLKitCardBindingEntityData;", "Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cardbinding/data/model/BindingCardAddResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/flow/Flow;", "", "", "PlaceComponentResult", "Lid/dana/cardbinding/data/model/SupportedCardsConfigEntity;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MLKitCardBindingEntityData implements CardBindingEntityData {
    @Inject
    public MLKitCardBindingEntityData() {
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<List<String>> PlaceComponentResult() {
        return FlowKt.callbackFlow(new MLKitCardBindingEntityData$getOCRResult$1(null));
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<BindingCardAddResult> KClassImpl$Data$declaredNonStaticMembers$2() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<Boolean> getAuthRequestContext() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.cardbinding.data.repository.source.CardBindingEntityData
    public final Flow<SupportedCardsConfigEntity> BuiltInFictitiousFunctionClassFactory() {
        throw new UnsupportedOperationException();
    }
}
