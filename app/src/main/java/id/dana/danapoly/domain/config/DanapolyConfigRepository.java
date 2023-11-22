package id.dana.danapoly.domain.config;

import id.dana.danapoly.domain.config.model.DanapolyEvent;
import id.dana.danapoly.domain.config.model.PlayBoard;
import id.dana.danapoly.domain.config.model.PlayerInfo;
import id.dana.danapoly.ui.model.BackgroundColorType;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H&¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\u0006\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/domain/config/DanapolyConfigRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "", "MyBillsEntityDataFactory", "()Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/domain/config/model/DanapolyEvent;", "PlaceComponentResult", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "getAuthRequestContext", "Lid/dana/danapoly/domain/config/model/PlayBoard;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/domain/config/model/PlayerInfo;", "BuiltInFictitiousFunctionClassFactory", "", "scheduleImpl", "p0", "(Lid/dana/danapoly/ui/model/BackgroundColorType;)Lkotlinx/coroutines/flow/Flow;", "", "moveToNextValue", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyConfigRepository {
    Flow<PlayerInfo> BuiltInFictitiousFunctionClassFactory();

    Flow<PlayBoard> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<String> MyBillsEntityDataFactory();

    Flow<DanapolyEvent> PlaceComponentResult();

    Flow<BackgroundColorType> getAuthRequestContext();

    Flow<Boolean> getAuthRequestContext(BackgroundColorType p0);

    void moveToNextValue();

    Flow<Boolean> scheduleImpl();
}
