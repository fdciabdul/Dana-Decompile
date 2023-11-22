package id.dana.data.saving.repository.source.local;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.saving.model.SavingCategoryEntity;
import id.dana.data.saving.repository.SavingCategoryEntityData;
import id.dana.domain.saving.constant.SavingConstant;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r\"\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r\"\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0011J\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n*\b\u0012\u0004\u0012\u00020\n0\t0\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/saving/repository/source/local/NetworkConfigSavingCategoryEntityData;", "Lid/dana/data/saving/repository/SavingCategoryEntityData;", "", "key", "", "removePrefix", "getKey", "(Ljava/lang/String;Z)Ljava/lang/String;", "Lio/reactivex/Observable;", "", "Lid/dana/data/saving/model/SavingCategoryEntity;", "getSavingCategories", "()Lio/reactivex/Observable;", "", UserMetadata.KEYDATA_FILENAME, "getSavingCategoriesByKeys", "([Ljava/lang/String;)Lio/reactivex/Observable;", "(Z[Ljava/lang/String;)Lio/reactivex/Observable;", "getSavingCategoriesFromSplit", "()Ljava/util/List;", "(Ljava/lang/String;Z)Lid/dana/data/saving/model/SavingCategoryEntity;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "splitConfigEntityData", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "<init>", "(Lid/dana/data/config/source/split/SplitConfigEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkConfigSavingCategoryEntityData implements SavingCategoryEntityData {
    private final SplitConfigEntityData splitConfigEntityData;

    @Inject
    public NetworkConfigSavingCategoryEntityData(SplitConfigEntityData splitConfigEntityData) {
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        this.splitConfigEntityData = splitConfigEntityData;
    }

    @Override // id.dana.data.saving.repository.SavingCategoryEntityData
    public final Observable<List<SavingCategoryEntity>> getSavingCategories() {
        Observable<List<SavingCategoryEntity>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.saving.repository.source.local.NetworkConfigSavingCategoryEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1871getSavingCategories$lambda0;
                m1871getSavingCategories$lambda0 = NetworkConfigSavingCategoryEntityData.m1871getSavingCategories$lambda0(NetworkConfigSavingCategoryEntityData.this);
                return m1871getSavingCategories$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategories$lambda-0  reason: not valid java name */
    public static final List m1871getSavingCategories$lambda0(NetworkConfigSavingCategoryEntityData networkConfigSavingCategoryEntityData) {
        Intrinsics.checkNotNullParameter(networkConfigSavingCategoryEntityData, "");
        List<SavingCategoryEntity> savingCategoriesFromSplit = networkConfigSavingCategoryEntityData.getSavingCategoriesFromSplit();
        if (savingCategoriesFromSplit != null) {
            return savingCategoriesFromSplit;
        }
        throw new CallableReturnNullError("NetworkConfigSavingCategoryEntityData#getSavingCategories");
    }

    @Override // id.dana.data.saving.repository.SavingCategoryEntityData
    public final Observable<List<SavingCategoryEntity>> getSavingCategoriesByKeys(String... keys) {
        Intrinsics.checkNotNullParameter(keys, "");
        return getSavingCategoriesByKeys(false, (String[]) Arrays.copyOf(keys, keys.length));
    }

    public final Observable<List<SavingCategoryEntity>> getSavingCategoriesByKeys(final boolean removePrefix, final String... keys) {
        Intrinsics.checkNotNullParameter(keys, "");
        Observable<List<SavingCategoryEntity>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.saving.repository.source.local.NetworkConfigSavingCategoryEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List m1872getSavingCategoriesByKeys$lambda2;
                m1872getSavingCategoriesByKeys$lambda2 = NetworkConfigSavingCategoryEntityData.m1872getSavingCategoriesByKeys$lambda2(keys, this, removePrefix);
                return m1872getSavingCategoriesByKeys$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategoriesByKeys$lambda-2  reason: not valid java name */
    public static final List m1872getSavingCategoriesByKeys$lambda2(String[] strArr, NetworkConfigSavingCategoryEntityData networkConfigSavingCategoryEntityData, boolean z) {
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(networkConfigSavingCategoryEntityData, "");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            SavingCategoryEntity savingCategoriesFromSplit = networkConfigSavingCategoryEntityData.getSavingCategoriesFromSplit(str, z);
            if (savingCategoriesFromSplit != null) {
                arrayList.add(savingCategoriesFromSplit);
            }
        }
        return arrayList;
    }

    private final SavingCategoryEntity getSavingCategoriesFromSplit(final String key, final boolean removePrefix) {
        try {
            return (SavingCategoryEntity) this.splitConfigEntityData.getSavingCategoriesByKey(getKey(key, removePrefix)).map(new Function() { // from class: id.dana.data.saving.repository.source.local.NetworkConfigSavingCategoryEntityData$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    SavingCategoryEntity m1873getSavingCategoriesFromSplit$lambda4;
                    m1873getSavingCategoriesFromSplit$lambda4 = NetworkConfigSavingCategoryEntityData.m1873getSavingCategoriesFromSplit$lambda4(removePrefix, key, (SavingCategoryEntity) obj);
                    return m1873getSavingCategoriesFromSplit$lambda4;
                }
            }).blockingFirst();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategoriesFromSplit$lambda-4  reason: not valid java name */
    public static final SavingCategoryEntity m1873getSavingCategoriesFromSplit$lambda4(boolean z, String str, SavingCategoryEntity savingCategoryEntity) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(savingCategoryEntity, "");
        if (z) {
            str = StringsKt.removePrefix(str, (CharSequence) SavingConstant.SAVING_CATEGORY_KEY_PREFIX);
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        savingCategoryEntity.setCategoryCode(upperCase);
        return savingCategoryEntity;
    }

    private final String getKey(String key, boolean removePrefix) {
        if (removePrefix) {
            return key;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SavingConstant.SAVING_CATEGORY_KEY_PREFIX);
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = key.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        sb.append(lowerCase);
        return sb.toString();
    }

    private final List<SavingCategoryEntity> getSavingCategoriesFromSplit() {
        return (List) this.splitConfigEntityData.getSavingCategories().flatMap(new Function() { // from class: id.dana.data.saving.repository.source.local.NetworkConfigSavingCategoryEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1874getSavingCategoriesFromSplit$lambda5;
                m1874getSavingCategoriesFromSplit$lambda5 = NetworkConfigSavingCategoryEntityData.m1874getSavingCategoriesFromSplit$lambda5(NetworkConfigSavingCategoryEntityData.this, (List) obj);
                return m1874getSavingCategoriesFromSplit$lambda5;
            }
        }).blockingFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getSavingCategoriesFromSplit$lambda-5  reason: not valid java name */
    public static final ObservableSource m1874getSavingCategoriesFromSplit$lambda5(NetworkConfigSavingCategoryEntityData networkConfigSavingCategoryEntityData, List list) {
        Intrinsics.checkNotNullParameter(networkConfigSavingCategoryEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        Object[] array = list.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            return networkConfigSavingCategoryEntityData.getSavingCategoriesByKeys(true, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
