package id.dana.kyb.data;

import id.dana.kyb.data.model.KybServiceResult;
import id.dana.kyb.data.model.KybStartupConfigResult;
import id.dana.kyb.data.model.KybUrlsConfigWrapperResult;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H&¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/kyb/data/KybConfigEntityData;", "", "Lio/reactivex/Observable;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "getAuthRequestContext", "p0", "Lid/dana/kyb/data/model/KybServiceResult;", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/kyb/data/model/KybStartupConfigResult;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/data/model/KybUrlsConfigWrapperResult;", "MyBillsEntityDataFactory", "", "getErrorConfigVersion", "scheduleImpl", "p1", "Lio/reactivex/Completable;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Completable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KybConfigEntityData {
    Observable<List<String>> BuiltInFictitiousFunctionClassFactory();

    Completable KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1);

    Observable<List<String>> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<KybUrlsConfigWrapperResult> MyBillsEntityDataFactory();

    Observable<KybStartupConfigResult> PlaceComponentResult();

    Observable<KybCompressQrConfig> getAuthRequestContext();

    Observable<KybServiceResult> getAuthRequestContext(String p0);

    Observable<Boolean> getErrorConfigVersion();

    Observable<Boolean> scheduleImpl();
}
