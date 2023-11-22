package id.dana.biometric.data.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.biometric.data.source.RiskTrackerConfigEntityData;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/biometric/data/source/local/DefaultRiskTrackerConfigEntityData;", "Lid/dana/biometric/data/source/RiskTrackerConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/biometric/data/source/local/RiskTrackerConfigEntity;", "getRiskTrackerConfig", "()Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultRiskTrackerConfigEntityData implements RiskTrackerConfigEntityData {
    private final Context context;

    @Inject
    public DefaultRiskTrackerConfigEntityData(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerConfigEntityData
    public final Observable<RiskTrackerConfigEntity> getRiskTrackerConfig() {
        Observable<RiskTrackerConfigEntity> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.source.local.DefaultRiskTrackerConfigEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                RiskTrackerConfigEntity m465getRiskTrackerConfig$lambda1;
                m465getRiskTrackerConfig$lambda1 = DefaultRiskTrackerConfigEntityData.m465getRiskTrackerConfig$lambda1(DefaultRiskTrackerConfigEntityData.this);
                return m465getRiskTrackerConfig$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRiskTrackerConfig$lambda-1  reason: not valid java name */
    public static final RiskTrackerConfigEntity m465getRiskTrackerConfig$lambda1(DefaultRiskTrackerConfigEntityData defaultRiskTrackerConfigEntityData) {
        Intrinsics.checkNotNullParameter(defaultRiskTrackerConfigEntityData, "");
        String PlaceComponentResult = JsonUtil.PlaceComponentResult(defaultRiskTrackerConfigEntityData.context, DefaultJsonPath.DEFAULT_FEATURE_DEVICE_SIGNATURE_TRACKER_CONFIG);
        if (PlaceComponentResult != null) {
            Object obj = null;
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, null), (Class<Object>) RiskTrackerConfigEntity.class);
            } catch (Exception unused) {
            }
            RiskTrackerConfigEntity riskTrackerConfigEntity = (RiskTrackerConfigEntity) obj;
            if (riskTrackerConfigEntity != null) {
                return riskTrackerConfigEntity;
            }
        }
        throw new CallableReturnNullError("DefaultRiskTrackerConfigEntityData#getRiskTrackerConfig");
    }
}
