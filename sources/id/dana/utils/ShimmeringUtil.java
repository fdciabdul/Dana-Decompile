package id.dana.utils;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ShimmeringUtil {
    private ShimmeringUtil() {
    }

    public static List<ViewSkeletonScreen> MyBillsEntityDataFactory(Map<View, Integer> map, int i) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<View, Integer> entry : map.entrySet()) {
            if (i != 0) {
                View key = entry.getKey();
                int intValue = entry.getValue().intValue();
                ViewSkeletonScreen.Builder builder = new ViewSkeletonScreen.Builder(key);
                builder.getAuthRequestContext = intValue;
                builder.PlaceComponentResult = 1500;
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                builder.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(builder.lookAheadTest.getContext(), i);
                builder.BuiltInFictitiousFunctionClassFactory = 0;
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(builder, (byte) 0);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                arrayList.add(viewSkeletonScreen);
            } else {
                arrayList.add(PlaceComponentResult(entry.getKey(), entry.getValue().intValue()));
            }
        }
        return arrayList;
    }

    public static ViewSkeletonScreen PlaceComponentResult(View view, int i) {
        ViewSkeletonScreen.Builder builder = new ViewSkeletonScreen.Builder(view);
        builder.getAuthRequestContext = i;
        builder.PlaceComponentResult = 1500;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        builder.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(builder.lookAheadTest.getContext(), id.dana.R.color.f27082131100491);
        builder.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(builder, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        return viewSkeletonScreen;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(List<SkeletonScreen> list) {
        if (list != null) {
            Iterator<SkeletonScreen> it = list.iterator();
            while (it.hasNext()) {
                it.next().MyBillsEntityDataFactory();
            }
        }
    }

    public static void getAuthRequestContext(List<SkeletonScreen> list) {
        if (list != null) {
            Iterator<SkeletonScreen> it = list.iterator();
            while (it.hasNext()) {
                it.next().PlaceComponentResult();
            }
        }
    }
}
