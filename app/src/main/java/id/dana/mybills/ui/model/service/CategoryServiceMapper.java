package id.dana.mybills.ui.model.service;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.util.ResourceUtil;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/mybills/ui/model/service/CategoryServiceMapper;", "", "", "chipKey", "defaultValue", "getChipTitle", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "getCleanCategory", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/mybills/ui/model/service/CategoryServiceModel;", "getDefaultCategory", "()Lid/dana/mybills/ui/model/service/CategoryServiceModel;", "", "categories", "transform", "(Ljava/util/List;)Ljava/util/List;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryServiceMapper {
    private final Context context;

    @Inject
    public CategoryServiceMapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
    }

    public final List<CategoryServiceModel> transform(List<String> categories) {
        if (categories == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getDefaultCategory());
        for (String str : categories) {
            CategoryServiceModel categoryServiceModel = new CategoryServiceModel();
            categoryServiceModel.setId(str);
            categoryServiceModel.setName(getCleanCategory(str));
            categoryServiceModel.setChipName(getChipTitle(StringsKt.replaceFirst$default(str, "category", "chip", false, 4, (Object) null), categoryServiceModel.getName()));
            categoryServiceModel.setViewType(1);
            arrayList.add(categoryServiceModel);
        }
        return arrayList;
    }

    public final String getCleanCategory(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        ResourceUtil resourceUtil = ResourceUtil.INSTANCE;
        int KClassImpl$Data$declaredNonStaticMembers$2 = ResourceUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.context, key);
        if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            String string = this.context.getString(KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        return StringsKt.capitalize(new Regex("_").replace(new Regex("category_").replaceFirst(key, ""), " "));
    }

    private final String getChipTitle(String chipKey, String defaultValue) {
        ResourceUtil resourceUtil = ResourceUtil.INSTANCE;
        int KClassImpl$Data$declaredNonStaticMembers$2 = ResourceUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.context, chipKey);
        return KClassImpl$Data$declaredNonStaticMembers$2 > 0 ? this.context.getString(KClassImpl$Data$declaredNonStaticMembers$2) : defaultValue;
    }

    private final CategoryServiceModel getDefaultCategory() {
        CategoryServiceModel categoryServiceModel = new CategoryServiceModel();
        categoryServiceModel.setName("Category All");
        categoryServiceModel.setViewType(1);
        categoryServiceModel.setSelected(true);
        return categoryServiceModel;
    }
}
