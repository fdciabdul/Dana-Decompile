package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.domain.statement.StatementType;
import id.dana.statement.StatementActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureStatement;", "", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "Landroid/app/Activity;", "", "", "PlaceComponentResult", "Ljava/util/Map;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Landroid/app/Activity;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureStatement {
    private final Activity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;

    public FeatureStatement(Activity activity, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.BuiltInFictitiousFunctionClassFactory = activity;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
        Intent intent = new Intent(this.BuiltInFictitiousFunctionClassFactory, StatementActivity.class);
        intent.putExtra("EXTRA_SOURCE", this.KClassImpl$Data$declaredNonStaticMembers$2.get("source"));
        intent.putExtra(StatementActivity.TAB_MENU_SELECTED, StatementType.EXPENSE.name());
        this.BuiltInFictitiousFunctionClassFactory.startActivity(intent);
    }
}
