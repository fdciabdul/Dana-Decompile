package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.notification.NotificationActivity;
import id.dana.utils.showcase.Utils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureAppNeedUpdate;", "", "Landroid/app/Activity;", "p0", "<init>", "(Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureAppNeedUpdate {
    public FeatureAppNeedUpdate(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        if (activity instanceof FragmentActivity) {
            DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(activity);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_warning;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.app_update_deeplink_fail_title);
            builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.app_update_deeplink_fail_description);
            String string = activity.getString(R.string.later);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            String str = upperCase;
            Intrinsics.checkNotNullParameter(str, "");
            builder.initRecordTimeStamp = str;
            String string2 = activity.getString(R.string.update);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String upperCase2 = string2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
            String str2 = upperCase2;
            Intrinsics.checkNotNullParameter(str2, "");
            builder.PrepareContext = str2;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.contract.deeplink.path.FeatureAppNeedUpdate$dialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Utils.getAuthRequestContext(activity);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.newProxyInstance = function0;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = new Function0<Unit>() { // from class: id.dana.contract.deeplink.path.FeatureAppNeedUpdate$dialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity activity2 = activity;
                    if (activity2 instanceof NotificationActivity) {
                        FeatureAppNeedUpdate.MyBillsEntityDataFactory(activity2);
                    }
                }
            };
            builder.lookAheadTest = Boolean.FALSE;
            DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            Intrinsics.checkNotNullParameter(supportFragmentManager, "");
            BuiltInFictitiousFunctionClassFactory.show(supportFragmentManager, "DanaAlertDialog");
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(Activity activity) {
        if (activity.isTaskRoot()) {
            Intent intent = new Intent(activity, HomeTabActivity.class);
            intent.setFlags(268468224);
            activity.startActivity(intent);
        }
        activity.finish();
    }
}
