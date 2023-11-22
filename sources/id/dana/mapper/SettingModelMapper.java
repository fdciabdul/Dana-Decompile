package id.dana.mapper;

import id.dana.data.profilemenu.MyProfileMenuCategories;
import id.dana.domain.profilemenu.model.SettingModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/mapper/SettingModelMapper;", "", "", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "", "p1", "", "PlaceComponentResult", "(Ljava/util/List;Z)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SettingModelMapper {
    public static final SettingModelMapper INSTANCE = new SettingModelMapper();

    private SettingModelMapper() {
    }

    @JvmStatic
    public static final List<SettingModel> PlaceComponentResult(List<? extends SettingModel> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < p0.size()) {
            String parent = p0.get(i).getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            if ((parent.length() == 0) || Intrinsics.areEqual(p0.get(i).getName(), MyProfileMenuCategories.PROFILE_USER_SERVICE)) {
                SettingModel settingModel = p0.get(i);
                String name = settingModel.getName();
                Intrinsics.checkNotNullExpressionValue(name, "");
                ArrayList arrayList2 = new ArrayList();
                int i2 = i;
                while (true) {
                    i2++;
                    if (i2 >= p0.size() || !p0.get(i2).getParent().equals(name)) {
                        break;
                    }
                    if (!p1) {
                        String name2 = p0.get(i2).getName();
                        if (Intrinsics.areEqual(name2, "setting_referral")) {
                            p0.get(i2).setViewType(25);
                        } else if (Intrinsics.areEqual(name2, "setting_chatbot")) {
                            p0.get(i2).setViewType(27);
                        } else {
                            p0.get(i2).setViewType(21);
                        }
                    }
                    arrayList2.add(p0.get(i2));
                }
                settingModel.setViewType(Intrinsics.areEqual(p0.get(i).getName(), MyProfileMenuCategories.PROFILE_USER_SERVICE) ? 22 : 19);
                settingModel.setSettingChilds(arrayList2);
                arrayList.add(settingModel);
                i += arrayList2.size() + 1;
            } else {
                arrayList.add(p0.get(i));
                i++;
            }
        }
        return arrayList;
    }
}
