package id.dana.base;

import android.app.Activity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.dana.base.BaseButterKnife;
import id.dana.base.extension.UnbinderKtx;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(level = DeprecationLevel.WARNING, message = "Delete after butter knife migrate to view binding")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/base/BaseButterKnife;", "", "unbinder", "Lbutterknife/Unbinder;", "getUnbinder", "()Lbutterknife/Unbinder;", "setUnbinder", "(Lbutterknife/Unbinder;)V", "bind", "", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "any", "view", "Landroid/view/View;", "isViewBinded", "", "tryUnbind", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface BaseButterKnife {
    Unbinder getUnbinder();

    void setUnbinder(Unbinder unbinder);

    /* renamed from: id.dana.base.BaseButterKnife$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static void BuiltInFictitiousFunctionClassFactory(final BaseButterKnife baseButterKnife) {
            if (baseButterKnife.getUnbinder() != null) {
                UnbinderKtx.getAuthRequestContext(baseButterKnife.getUnbinder(), new Runnable() { // from class: id.dana.base.BaseButterKnife$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseButterKnife.CC.MyBillsEntityDataFactory(BaseButterKnife.this);
                    }
                });
            }
        }

        public static void MyBillsEntityDataFactory(BaseButterKnife baseButterKnife) {
            Intrinsics.checkNotNullParameter(baseButterKnife, "");
            baseButterKnife.setUnbinder(null);
        }

        public static void MyBillsEntityDataFactory(BaseButterKnife baseButterKnife, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "");
            baseButterKnife.setUnbinder(ButterKnife.MyBillsEntityDataFactory(activity));
        }

        public static void BuiltInFictitiousFunctionClassFactory(BaseButterKnife baseButterKnife, Object obj, View view) {
            Intrinsics.checkNotNullParameter(obj, "");
            Intrinsics.checkNotNullParameter(view, "");
            baseButterKnife.setUnbinder(ButterKnife.BuiltInFictitiousFunctionClassFactory(obj, view));
        }

        public static boolean PlaceComponentResult(BaseButterKnife baseButterKnife) {
            return baseButterKnife.getUnbinder() != null;
        }
    }
}
