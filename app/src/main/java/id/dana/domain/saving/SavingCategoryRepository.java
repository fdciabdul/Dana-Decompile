package id.dana.domain.saving;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import id.dana.domain.saving.model.SavingCategory;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\f0\u0002H&¢\u0006\u0004\b\r\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/saving/SavingCategoryRepository;", "", "Lio/reactivex/Observable;", "", "Lid/dana/domain/saving/model/SavingCategory;", "getSavingCategories", "()Lio/reactivex/Observable;", "", "", UserMetadata.KEYDATA_FILENAME, "getSavingCategoriesByKeys", "([Ljava/lang/String;)Lio/reactivex/Observable;", "", "getSavingCategoriesMap"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SavingCategoryRepository {
    Observable<List<SavingCategory>> getSavingCategories();

    Observable<List<SavingCategory>> getSavingCategoriesByKeys(String[] keys);

    Observable<Map<String, SavingCategory>> getSavingCategoriesMap();
}
