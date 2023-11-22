package id.dana.cardbinding.domain;

import id.dana.cardbinding.domain.model.BindingCardAddInfo;
import id.dana.cardbinding.domain.model.SupportedCardsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/domain/CardBindingRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cardbinding/domain/model/BindingCardAddInfo;", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/Flow;", "", "BuiltInFictitiousFunctionClassFactory", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cardbinding/domain/model/SupportedCardsConfig;", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CardBindingRepository {
    Flow<Boolean> BuiltInFictitiousFunctionClassFactory();

    Flow<List<String>> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<SupportedCardsConfig> MyBillsEntityDataFactory();

    Flow<BindingCardAddInfo> getAuthRequestContext();
}
