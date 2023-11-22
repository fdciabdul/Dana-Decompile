package id.dana.explore.data.userpersonalization.source.local;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.userpersonalization.source.local.UserPersonalizationPreferences;
import id.dana.explore.data.userpersonalization.UserPersonalizationEntityData;
import id.dana.explore.data.userpersonalization.source.network.request.CreateUserPersonalizationRequest;
import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionListEntity;
import id.dana.explore.data.userpersonalization.source.network.result.UserPreferenceResultEntity;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\nJ+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\fH\u0016¢\u0006\u0004\b\u0006\u0010\u0012J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/local/LocalUserPersonalizationEntityData;", "Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityData;", "Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;)Lio/reactivex/Observable;", "Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/explore/data/userpersonalization/source/network/result/UserPreferenceResultEntity;", "MyBillsEntityDataFactory", "", "p1", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "", "Lid/dana/data/userpersonalization/source/local/UserPersonalizationPreferences;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/userpersonalization/source/local/UserPersonalizationPreferences;", "getAuthRequestContext", "<init>", "(Lid/dana/data/userpersonalization/source/local/UserPersonalizationPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalUserPersonalizationEntityData implements UserPersonalizationEntityData {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final UserPersonalizationPreferences getAuthRequestContext;

    @Inject
    public LocalUserPersonalizationEntityData(UserPersonalizationPreferences userPersonalizationPreferences) {
        Intrinsics.checkNotNullParameter(userPersonalizationPreferences, "");
        this.getAuthRequestContext = userPersonalizationPreferences;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<PreferenceOptionListEntity> PlaceComponentResult() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<UserPreferenceResultEntity> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<Boolean> MyBillsEntityDataFactory() {
        Observable<Boolean> just = Observable.just(this.getAuthRequestContext.getAuthRequestContext.getBoolean("explore_personalization_shown"));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory() {
        this.getAuthRequestContext.getAuthRequestContext.saveData("explore_personalization_shown", Boolean.TRUE);
        Observable<Unit> just = Observable.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(CreateUserPersonalizationRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<List<String>> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        UserPersonalizationPreferences userPersonalizationPreferences = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = userPersonalizationPreferences.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_hasFillForm");
        List list = (List) preferenceFacade.getObject(sb.toString(), List.class);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Observable<List<String>> just = Observable.just(list);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        UserPersonalizationPreferences userPersonalizationPreferences = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = userPersonalizationPreferences.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_hasFillForm");
        preferenceFacade.saveData(sb.toString(), (String) p1);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
