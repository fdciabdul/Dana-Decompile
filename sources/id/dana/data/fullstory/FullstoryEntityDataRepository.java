package id.dana.data.fullstory;

import id.dana.data.config.mapper.FullstoryConfigModelMapperKt;
import id.dana.data.config.model.FullstoryConfigModel;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.fullstory.FullstoryRepository;
import id.dana.domain.fullstory.model.FullstoryConfig;
import id.dana.domain.fullstory.model.FullstoryPreferenceConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/fullstory/FullstoryEntityDataRepository;", "Lid/dana/domain/fullstory/FullstoryRepository;", "Lio/reactivex/Observable;", "Lid/dana/domain/fullstory/model/FullstoryConfig;", "getFullstoryConfig", "()Lio/reactivex/Observable;", "Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "getSessionCounterFromPreference", "()Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "p0", "", "setSessionCounterToPreference", "(Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;)V", "Lid/dana/data/storage/PreferenceFacade;", "PlaceComponentResult", "Lid/dana/data/storage/PreferenceFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/data/config/source/split/SplitConfigEntityData;Lid/dana/data/storage/PreferenceFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FullstoryEntityDataRepository implements FullstoryRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final SplitConfigEntityData getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FullstoryEntityDataRepository(SplitConfigEntityData splitConfigEntityData, @Named("fullstory_session") PreferenceFacade preferenceFacade) {
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        this.getAuthRequestContext = splitConfigEntityData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = preferenceFacade;
    }

    @Override // id.dana.domain.fullstory.FullstoryRepository
    public final Observable<FullstoryConfig> getFullstoryConfig() {
        Observable map = this.getAuthRequestContext.getFullstoryConfig().map(new Function() { // from class: id.dana.data.fullstory.FullstoryEntityDataRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FullstoryEntityDataRepository.KClassImpl$Data$declaredNonStaticMembers$2((FullstoryConfigModel) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.fullstory.FullstoryRepository
    public final FullstoryPreferenceConfig getSessionCounterFromPreference() {
        return (FullstoryPreferenceConfig) this.KClassImpl$Data$declaredNonStaticMembers$2.getObject("fullstorySession", FullstoryPreferenceConfig.class);
    }

    @Override // id.dana.domain.fullstory.FullstoryRepository
    public final void setSessionCounterToPreference(FullstoryPreferenceConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.saveData("fullstorySession", (String) p0);
    }

    public static /* synthetic */ FullstoryConfig KClassImpl$Data$declaredNonStaticMembers$2(FullstoryConfigModel fullstoryConfigModel) {
        Intrinsics.checkNotNullParameter(fullstoryConfigModel, "");
        return FullstoryConfigModelMapperKt.toFullstoryConfig(fullstoryConfigModel);
    }
}
