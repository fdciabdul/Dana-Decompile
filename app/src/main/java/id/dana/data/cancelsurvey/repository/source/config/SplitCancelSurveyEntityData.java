package id.dana.data.cancelsurvey.repository.source.config;

import id.dana.data.cancelsurvey.model.CancellationSurveyConfigModel;
import id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.util.CashierDefaultConfigGenerator;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/config/SplitCancelSurveyEntityData;", "Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityData;", "", "suffixKey", "Lio/reactivex/Observable;", "Lid/dana/data/cancelsurvey/model/CancellationSurveyConfigModel;", "fetchCancelSurveyReasonConfig", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitCancelSurveyEntityData implements CancelSurveyEntityData {
    private final SplitFacade splitFacade;

    @Override // id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData
    public final /* synthetic */ Observable consultCancelSurvey(String str, String str2, String str3) {
        return CancelSurveyEntityData.CC.$default$consultCancelSurvey(this, str, str2, str3);
    }

    @Override // id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData
    public final /* synthetic */ Observable submitCancelSurvey(String str, String str2, String str3) {
        return CancelSurveyEntityData.CC.$default$submitCancelSurvey(this, str, str2, str3);
    }

    @Inject
    public SplitCancelSurveyEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData
    public final Observable<CancellationSurveyConfigModel> fetchCancelSurveyReasonConfig(final String suffixKey) {
        Intrinsics.checkNotNullParameter(suffixKey, "");
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.cancelsurvey.repository.source.config.SplitCancelSurveyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CancellationSurveyConfigModel m819fetchCancelSurveyReasonConfig$lambda0;
                m819fetchCancelSurveyReasonConfig$lambda0 = SplitCancelSurveyEntityData.m819fetchCancelSurveyReasonConfig$lambda0(suffixKey, (BaseTrafficType) obj);
                return m819fetchCancelSurveyReasonConfig$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: fetchCancelSurveyReasonConfig$lambda-0  reason: not valid java name */
    public static final CancellationSurveyConfigModel m819fetchCancelSurveyReasonConfig$lambda0(String str, BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        StringBuilder sb = new StringBuilder();
        sb.append("config_cancellation_survey_");
        sb.append(str);
        String obj = sb.toString();
        Object createCancellationSurveyConfig = CashierDefaultConfigGenerator.INSTANCE.createCancellationSurveyConfig();
        String authRequestContext = baseTrafficType.getAuthRequestContext(obj, false);
        if (CancellationSurveyConfigModel.class.isAssignableFrom(JSONArray.class)) {
            createCancellationSurveyConfig = (CancellationSurveyConfigModel) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else if (authRequestContext != null) {
            Object obj2 = null;
            try {
                obj2 = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) CancellationSurveyConfigModel.class);
            } catch (Exception unused) {
            }
            if (obj2 != null) {
                createCancellationSurveyConfig = obj2;
            }
        }
        return (CancellationSurveyConfigModel) createCancellationSurveyConfig;
    }
}
