package id.dana.cardbinding.data.repository.source;

import id.dana.cardbinding.data.model.BindingCardAddResult;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/data/repository/source/CardBindingEntityData;", "", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cardbinding/data/model/BindingCardAddResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/flow/Flow;", "", "", "PlaceComponentResult", "Lid/dana/cardbinding/data/model/SupportedCardsConfigEntity;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CardBindingEntityData {
    Flow<SupportedCardsConfigEntity> BuiltInFictitiousFunctionClassFactory();

    Flow<BindingCardAddResult> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<List<String>> PlaceComponentResult();

    Flow<Boolean> getAuthRequestContext();
}
