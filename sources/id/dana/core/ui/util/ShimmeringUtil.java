package id.dana.core.ui.util;

import android.view.View;
import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.core.ui.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u000b\u001a\u00020\u000e2\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u000f\u0010\u0012"}, d2 = {"Lid/dana/core/ui/util/ShimmeringUtil;", "", "Landroid/view/View;", "p0", "", "p1", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "getAuthRequestContext", "(Landroid/view/View;I)Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "", "", "MyBillsEntityDataFactory", "(Ljava/util/Map;I)Ljava/util/List;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)V", "I", "()I", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShimmeringUtil {
    public static final ShimmeringUtil INSTANCE = new ShimmeringUtil();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static final int PlaceComponentResult = R.color.NetworkUserEntityData$$ExternalSyntheticLambda1;

    private ShimmeringUtil() {
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static int BuiltInFictitiousFunctionClassFactory() {
        return PlaceComponentResult;
    }

    public static List<ViewSkeletonScreen> MyBillsEntityDataFactory(Map<View, Integer> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<View, Integer> entry : p0.entrySet()) {
            if (p1 != 0) {
                View key = entry.getKey();
                int intValue = entry.getValue().intValue();
                ViewSkeletonScreen.Builder builder = new ViewSkeletonScreen.Builder(key);
                builder.getAuthRequestContext = intValue;
                builder.PlaceComponentResult = 1500;
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                builder.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(builder.lookAheadTest.getContext(), p1);
                builder.BuiltInFictitiousFunctionClassFactory = 0;
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(builder, (byte) 0);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
                arrayList.add(viewSkeletonScreen);
            } else {
                arrayList.add(getAuthRequestContext(entry.getKey(), entry.getValue().intValue()));
            }
        }
        return arrayList;
    }

    public static ViewSkeletonScreen getAuthRequestContext(View p0, int p1) {
        ViewSkeletonScreen.Builder builder = new ViewSkeletonScreen.Builder(p0);
        builder.getAuthRequestContext = p1;
        builder.PlaceComponentResult = 1500;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        builder.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(builder.lookAheadTest.getContext(), PlaceComponentResult);
        builder.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(builder, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
        return viewSkeletonScreen;
    }

    public static void MyBillsEntityDataFactory(List<? extends SkeletonScreen> p0) {
        if (p0 != null) {
            Iterator<? extends SkeletonScreen> it = p0.iterator();
            while (it.hasNext()) {
                it.next().MyBillsEntityDataFactory();
            }
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(List<? extends SkeletonScreen> p0) {
        if (p0 != null) {
            Iterator<? extends SkeletonScreen> it = p0.iterator();
            while (it.hasNext()) {
                it.next().PlaceComponentResult();
            }
        }
    }
}
