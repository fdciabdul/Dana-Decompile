package id.dana.data.saving.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.saving.model.SavingEmptyStateEntity;
import id.dana.data.saving.model.SavingLimitEntity;
import id.dana.data.saving.repository.SavingConfigEntityData;
import id.dana.data.storage.Serializer;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/saving/repository/source/local/DefaultSavingConfigEntityData;", "Lid/dana/data/saving/repository/SavingConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/saving/model/SavingEmptyStateEntity;", "getSavingEmptyState", "()Lio/reactivex/Observable;", "Lid/dana/data/saving/model/SavingLimitEntity;", "getSavingLimit", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultSavingConfigEntityData implements SavingConfigEntityData {
    private static final String DEFAULT_SAVING_CONFIG = "split/default-saving-empty-state.json";
    private static final String DEFAULT_SAVING_LIMIT = "split/default-saving-limit.json";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultSavingConfigEntityData(Context context, Serializer serializer) {
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

    @Override // id.dana.data.saving.repository.SavingConfigEntityData
    public final Observable<SavingEmptyStateEntity> getSavingEmptyState() {
        Observable<SavingEmptyStateEntity> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.saving.repository.source.local.DefaultSavingConfigEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SavingEmptyStateEntity m1866getSavingEmptyState$lambda1;
                m1866getSavingEmptyState$lambda1 = DefaultSavingConfigEntityData.m1866getSavingEmptyState$lambda1(DefaultSavingConfigEntityData.this);
                return m1866getSavingEmptyState$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingEmptyState$lambda-1  reason: not valid java name */
    public static final SavingEmptyStateEntity m1866getSavingEmptyState$lambda1(DefaultSavingConfigEntityData defaultSavingConfigEntityData) {
        Intrinsics.checkNotNullParameter(defaultSavingConfigEntityData, "");
        String PlaceComponentResult = JsonUtil.PlaceComponentResult(defaultSavingConfigEntityData.context, "split/default-saving-empty-state.json");
        if (PlaceComponentResult != null) {
            Object obj = null;
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, null), (Class<Object>) SavingEmptyStateEntity.class);
            } catch (Exception unused) {
            }
            SavingEmptyStateEntity savingEmptyStateEntity = (SavingEmptyStateEntity) obj;
            if (savingEmptyStateEntity != null) {
                return savingEmptyStateEntity;
            }
        }
        throw new CallableReturnNullError("DefaultSavingConfigEntityData#getSavingEmptyState");
    }

    @Override // id.dana.data.saving.repository.SavingConfigEntityData
    public final Observable<SavingLimitEntity> getSavingLimit() {
        Observable<SavingLimitEntity> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.saving.repository.source.local.DefaultSavingConfigEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SavingLimitEntity m1867getSavingLimit$lambda3;
                m1867getSavingLimit$lambda3 = DefaultSavingConfigEntityData.m1867getSavingLimit$lambda3(DefaultSavingConfigEntityData.this);
                return m1867getSavingLimit$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingLimit$lambda-3  reason: not valid java name */
    public static final SavingLimitEntity m1867getSavingLimit$lambda3(DefaultSavingConfigEntityData defaultSavingConfigEntityData) {
        Intrinsics.checkNotNullParameter(defaultSavingConfigEntityData, "");
        String PlaceComponentResult = JsonUtil.PlaceComponentResult(defaultSavingConfigEntityData.context, DEFAULT_SAVING_LIMIT);
        if (PlaceComponentResult != null) {
            Object obj = null;
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, null), (Class<Object>) SavingLimitEntity.class);
            } catch (Exception unused) {
            }
            SavingLimitEntity savingLimitEntity = (SavingLimitEntity) obj;
            if (savingLimitEntity != null) {
                return savingLimitEntity;
            }
        }
        throw new CallableReturnNullError("DefaultSavingConfigEntityData#getSavingLimit");
    }
}
