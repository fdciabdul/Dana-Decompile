package id.dana.data.saving.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.saving.model.SavingCategoryEntity;
import id.dana.data.saving.repository.SavingCategoryEntityData;
import id.dana.data.storage.Serializer;
import id.dana.domain.saving.constant.SavingConstant;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/saving/repository/source/local/DefaultConfigSavingCategoryEntityData;", "Lid/dana/data/saving/repository/SavingCategoryEntityData;", "Lio/reactivex/Observable;", "", "Lid/dana/data/saving/model/SavingCategoryEntity;", "getSavingCategories", "()Lio/reactivex/Observable;", "", "", UserMetadata.KEYDATA_FILENAME, "getSavingCategoriesByKeys", "([Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultConfigSavingCategoryEntityData implements SavingCategoryEntityData {
    private static final String DEFAULT_SAVING_CATEGORIES_JSON = "split/default-saving-categories-default.json";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultConfigSavingCategoryEntityData(Context context, Serializer serializer) {
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

    @Override // id.dana.data.saving.repository.SavingCategoryEntityData
    public final Observable<List<SavingCategoryEntity>> getSavingCategories() {
        Observable<List<SavingCategoryEntity>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.saving.repository.source.local.DefaultConfigSavingCategoryEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1864getSavingCategories$lambda4;
                m1864getSavingCategories$lambda4 = DefaultConfigSavingCategoryEntityData.m1864getSavingCategories$lambda4(DefaultConfigSavingCategoryEntityData.this);
                return m1864getSavingCategories$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategories$lambda-4  reason: not valid java name */
    public static final List m1864getSavingCategories$lambda4(DefaultConfigSavingCategoryEntityData defaultConfigSavingCategoryEntityData) {
        Intrinsics.checkNotNullParameter(defaultConfigSavingCategoryEntityData, "");
        String PlaceComponentResult = JsonUtil.PlaceComponentResult(defaultConfigSavingCategoryEntityData.context, DEFAULT_SAVING_CATEGORIES_JSON);
        if (PlaceComponentResult != null) {
            Map<String, String> deserializeMap = defaultConfigSavingCategoryEntityData.serializer.deserializeMap(PlaceComponentResult);
            Intrinsics.checkNotNullExpressionValue(deserializeMap, "");
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : deserializeMap.entrySet()) {
                SavingCategoryEntity savingCategoryEntity = (SavingCategoryEntity) defaultConfigSavingCategoryEntityData.serializer.deserialize(entry.getValue(), SavingCategoryEntity.class);
                if (savingCategoryEntity != null) {
                    Intrinsics.checkNotNullExpressionValue(savingCategoryEntity, "");
                    String key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "");
                    String removePrefix = StringsKt.removePrefix(key, (CharSequence) SavingConstant.SAVING_CATEGORY_KEY_PREFIX);
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String upperCase = removePrefix.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "");
                    savingCategoryEntity.setCategoryCode(upperCase);
                } else {
                    savingCategoryEntity = null;
                }
                if (savingCategoryEntity != null) {
                    arrayList.add(savingCategoryEntity);
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    @Override // id.dana.data.saving.repository.SavingCategoryEntityData
    public final Observable<List<SavingCategoryEntity>> getSavingCategoriesByKeys(final String... keys) {
        Intrinsics.checkNotNullParameter(keys, "");
        Observable<List<SavingCategoryEntity>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.saving.repository.source.local.DefaultConfigSavingCategoryEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1865getSavingCategoriesByKeys$lambda10;
                m1865getSavingCategoriesByKeys$lambda10 = DefaultConfigSavingCategoryEntityData.m1865getSavingCategoriesByKeys$lambda10(DefaultConfigSavingCategoryEntityData.this, keys);
                return m1865getSavingCategoriesByKeys$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategoriesByKeys$lambda-10  reason: not valid java name */
    public static final List m1865getSavingCategoriesByKeys$lambda10(DefaultConfigSavingCategoryEntityData defaultConfigSavingCategoryEntityData, String[] strArr) {
        SavingCategoryEntity savingCategoryEntity;
        Intrinsics.checkNotNullParameter(defaultConfigSavingCategoryEntityData, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        String PlaceComponentResult = JsonUtil.PlaceComponentResult(defaultConfigSavingCategoryEntityData.context, DEFAULT_SAVING_CATEGORIES_JSON);
        if (PlaceComponentResult != null) {
            Map<String, String> deserializeMap = defaultConfigSavingCategoryEntityData.serializer.deserializeMap(PlaceComponentResult);
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                StringBuilder sb = new StringBuilder();
                sb.append(SavingConstant.SAVING_CATEGORY_KEY_PREFIX);
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "");
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                sb.append(lowerCase);
                String str2 = deserializeMap.get(sb.toString());
                SavingCategoryEntity savingCategoryEntity2 = null;
                if (str2 != null && (savingCategoryEntity = (SavingCategoryEntity) defaultConfigSavingCategoryEntityData.serializer.deserialize(str2, SavingCategoryEntity.class)) != null) {
                    savingCategoryEntity.setCategoryCode(str);
                    savingCategoryEntity2 = savingCategoryEntity;
                }
                if (savingCategoryEntity2 != null) {
                    arrayList.add(savingCategoryEntity2);
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
