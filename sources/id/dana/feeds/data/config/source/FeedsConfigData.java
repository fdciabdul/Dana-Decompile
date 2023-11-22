package id.dana.feeds.data.config.source;

import com.alibaba.fastjson.JSONObject;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.config.model.ProfileCtaConfigResponse;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H&¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H&¢\u0006\u0004\b\u0013\u0010\u0005J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H&¢\u0006\u0004\b\u0014\u0010\u0005ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/config/source/FeedsConfigData;", "", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Lcom/alibaba/fastjson/JSONObject;", "BuiltInFictitiousFunctionClassFactory", "", "", "PlaceComponentResult", "Lid/dana/feeds/data/config/model/ProfileCtaConfigResponse;", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "lookAheadTest", "()Ljava/lang/Object;", "moveToNextValue", "getErrorConfigVersion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsConfigData {
    Observable<JSONObject> BuiltInFictitiousFunctionClassFactory();

    Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<List<ProfileCtaConfigResponse>> MyBillsEntityDataFactory();

    Observable<List<JSONObject>> NetworkUserEntityData$$ExternalSyntheticLambda0();

    Observable<List<String>> PlaceComponentResult();

    Observable<FeedConfigResult> getAuthRequestContext();

    Observable<Boolean> getErrorConfigVersion();

    Object lookAheadTest();

    Observable<Boolean> moveToNextValue();
}
