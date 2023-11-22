package id.dana.explore.data.userpersonalization;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.explore.data.userpersonalization.source.network.request.CreateUserPersonalizationRequest;
import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionListEntity;
import id.dana.explore.data.userpersonalization.source.network.result.UserPreferenceResultEntity;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\u0006\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H&¢\u0006\u0004\b\u000f\u0010\nJ+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\fH&¢\u0006\u0004\b\u0006\u0010\u0012J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004H&¢\u0006\u0004\b\u0006\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityData;", "", "Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;)Lio/reactivex/Observable;", "Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/explore/data/userpersonalization/source/network/result/UserPreferenceResultEntity;", "MyBillsEntityDataFactory", "", "p1", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UserPersonalizationEntityData {
    Observable<Unit> BuiltInFictitiousFunctionClassFactory();

    Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(CreateUserPersonalizationRequest p0);

    Observable<List<String>> BuiltInFictitiousFunctionClassFactory(String p0);

    Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0, List<String> p1);

    Observable<Boolean> MyBillsEntityDataFactory();

    Observable<UserPreferenceResultEntity> MyBillsEntityDataFactory(String p0);

    Observable<PreferenceOptionListEntity> PlaceComponentResult();
}
