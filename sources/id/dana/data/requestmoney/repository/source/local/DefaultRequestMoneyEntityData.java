package id.dana.data.requestmoney.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.requestmoney.repository.RequestMoneyEntityData;
import id.dana.data.requestmoney.repository.model.NameCheckConfigEntity;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005R\u0017\u0010\n\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/requestmoney/repository/source/local/DefaultRequestMoneyEntityData;", "Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/requestmoney/repository/model/NameCheckConfigEntity;", "getNameCheckConfig", "()Lio/reactivex/Observable;", "", "", "getTopFeatureBanks", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultRequestMoneyEntityData implements RequestMoneyEntityData {
    public static final String JSON_PATH_TOP_FEATURED_BANKS = "json/amcs-featured-banks.json";
    public static final int NAME_CHECK_CONFIG_FREEZE_TIME_DEFAULT = 300;
    public static final int NAME_CHECK_CONFIG_RESET_TIME_DEFAULT = 7200;
    public static final int NAME_CHECK_CONFIG_RETRY_LIMIT_DEFAULT = 10;
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultRequestMoneyEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyEntityData
    public final Observable<List<String>> getTopFeatureBanks() {
        Observable<List<String>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.requestmoney.repository.source.local.DefaultRequestMoneyEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1838getTopFeatureBanks$lambda0;
                m1838getTopFeatureBanks$lambda0 = DefaultRequestMoneyEntityData.m1838getTopFeatureBanks$lambda0(DefaultRequestMoneyEntityData.this);
                return m1838getTopFeatureBanks$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getTopFeatureBanks$lambda-0  reason: not valid java name */
    public static final List m1838getTopFeatureBanks$lambda0(DefaultRequestMoneyEntityData defaultRequestMoneyEntityData) {
        Intrinsics.checkNotNullParameter(defaultRequestMoneyEntityData, "");
        List<String> deserializeList = defaultRequestMoneyEntityData.serializer.deserializeList(JsonUtil.PlaceComponentResult(defaultRequestMoneyEntityData.context, JSON_PATH_TOP_FEATURED_BANKS));
        return deserializeList == null ? CollectionsKt.emptyList() : deserializeList;
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyEntityData
    public final Observable<NameCheckConfigEntity> getNameCheckConfig() {
        Observable<NameCheckConfigEntity> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.requestmoney.repository.source.local.DefaultRequestMoneyEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                NameCheckConfigEntity m1837getNameCheckConfig$lambda1;
                m1837getNameCheckConfig$lambda1 = DefaultRequestMoneyEntityData.m1837getNameCheckConfig$lambda1();
                return m1837getNameCheckConfig$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getNameCheckConfig$lambda-1  reason: not valid java name */
    public static final NameCheckConfigEntity m1837getNameCheckConfig$lambda1() {
        return new NameCheckConfigEntity(10, 300, NAME_CHECK_CONFIG_RESET_TIME_DEFAULT);
    }
}
