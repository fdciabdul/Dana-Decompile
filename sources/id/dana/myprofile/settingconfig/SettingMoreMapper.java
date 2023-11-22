package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.profilemenu.MyProfileMenuCategories;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper;
import id.dana.utils.ResourceUtils;
import id.dana.utils.VersionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o.D;

/* loaded from: classes5.dex */
public class SettingMoreMapper implements RawSettingJsonMapper {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = -8404214575289044236L;
    private static int MyBillsEntityDataFactory = 1;
    private static int getAuthRequestContext;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetAvatarUrl PlaceComponentResult;

    /* loaded from: classes5.dex */
    public interface GetAvatarUrl {
        void MyBillsEntityDataFactory();
    }

    public SettingMoreMapper(Context context, GetAvatarUrl getAvatarUrl) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = getAvatarUrl;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper
    public List<SettingModel> apply(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry) {
        ArrayList arrayList = new ArrayList();
        if (!MyBillsEntityDataFactory(entry.getKey())) {
            try {
                int i = MyBillsEntityDataFactory + 83;
                getAuthRequestContext = i % 128;
                if (i % 2 == 0) {
                    PlaceComponentResult(arrayList, entry.getKey());
                } else {
                    PlaceComponentResult(arrayList, entry.getKey());
                    Object obj = null;
                    obj.hashCode();
                }
                int i2 = MyBillsEntityDataFactory + 115;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        Iterator<Map.Entry<String, SettingModel>> it = entry.getValue().entrySet().iterator();
        while (true) {
            if (!(it.hasNext())) {
                int i4 = MyBillsEntityDataFactory + 13;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
                return arrayList;
            }
            int i6 = MyBillsEntityDataFactory + 105;
            getAuthRequestContext = i6 % 128;
            int i7 = i6 % 2;
            try {
                SettingModel value = it.next().getValue();
                if (value.isEnable()) {
                    KClassImpl$Data$declaredNonStaticMembers$2(arrayList, value, entry.getKey());
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        boolean equals;
        int i = getAuthRequestContext + 47;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            equals = str.equals(MyProfileMenuCategories.PROFILE_USER_SERVICE);
            int i2 = 19 / 0;
        } else {
            equals = str.equals(MyProfileMenuCategories.PROFILE_USER_SERVICE);
        }
        int i3 = getAuthRequestContext + 43;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 17 : (char) 11) != 17) {
            return equals;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return equals;
    }

    private void PlaceComponentResult(List<SettingModel> list, String str) {
        SettingModel settingModel = new SettingModel();
        PlaceComponentResult(settingModel, str);
        settingModel.setName(str);
        list.add(settingModel);
        int i = MyBillsEntityDataFactory + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(List<SettingModel> list, SettingModel settingModel, String str) {
        int i = MyBillsEntityDataFactory + 29;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(settingModel);
        MyBillsEntityDataFactory(settingModel);
        list.add(settingModel);
        settingModel.setParent(str);
        int i3 = MyBillsEntityDataFactory + 23;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    private void PlaceComponentResult(SettingModel settingModel, String str) {
        int i = MyBillsEntityDataFactory + 7;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            settingModel.setTitle(ResourceUtils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, str, str.replace(MyProfileMenuCategories.SETTING_CATEGORY, "").replace("_", " ")).toUpperCase());
            settingModel.setViewType(1);
            return;
        }
        settingModel.setTitle(ResourceUtils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, str, str.replace(MyProfileMenuCategories.SETTING_CATEGORY, "").replace("_", " ")).toUpperCase());
        settingModel.setViewType(0);
    }

    private void MyBillsEntityDataFactory(SettingModel settingModel) {
        int i = getAuthRequestContext + 115;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        settingModel.setTitle(ResourceUtils.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, settingModel));
        int i3 = getAuthRequestContext + 55;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x015f, code lost:
    
        if (r3.equals(id.dana.data.profilemenu.MyProfileMenuAction.SETTING_LOCATION_PERMISSION) != false) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.profilemenu.model.SettingModel r17) {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.settingconfig.SettingMoreMapper.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    private void getAuthRequestContext(SettingModel settingModel) {
        int i = MyBillsEntityDataFactory + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((context != null ? ':' : '\t') == ':') {
            int i3 = MyBillsEntityDataFactory + 79;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            try {
                settingModel.setSubtitle(VersionUtil.BuiltInFictitiousFunctionClassFactory(context));
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = getAuthRequestContext + 33;
        MyBillsEntityDataFactory = i5 % 128;
        if ((i5 % 2 == 0 ? 'T' : '[') != 'T') {
            return;
        }
        int i6 = 61 / 0;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 99;
        $10 = i2 % 128;
        while (true) {
            int i3 = i2 % 2;
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? InputCardNumberView.DIVIDER : 'S') == 'S') {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                return;
            }
            int i4 = $10 + 87;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
            i2 = $11 + 9;
            $10 = i2 % 128;
        }
    }
}
