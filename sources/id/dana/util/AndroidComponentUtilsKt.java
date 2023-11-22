package id.dana.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.work.ListenableWorker;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import id.dana.DanaApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\t¢\u0006\u0004\b\u0007\u0010\n\u001a#\u0010\u0002\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0002\u0010\u0011"}, d2 = {"Landroid/app/Activity;", "Lid/dana/DanaApplication;", "MyBillsEntityDataFactory", "(Landroid/app/Activity;)Lid/dana/DanaApplication;", "Landroid/view/View;", "(Landroid/view/View;)Lid/dana/DanaApplication;", "Landroidx/fragment/app/Fragment;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/fragment/app/Fragment;)Lid/dana/DanaApplication;", "Landroidx/work/ListenableWorker;", "(Landroidx/work/ListenableWorker;)Lid/dana/DanaApplication;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroidx/fragment/app/FragmentManager;", "p0", "", "p1", "", "(Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidComponentUtilsKt {
    public static final void MyBillsEntityDataFactory(BottomSheetDialogFragment bottomSheetDialogFragment, FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "");
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        if (bottomSheetDialogFragment.isAdded() || fragmentManager.findFragmentByTag(str) != null) {
            return;
        }
        bottomSheetDialogFragment.show(fragmentManager, str);
    }

    public static final DanaApplication MyBillsEntityDataFactory(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        Context applicationContext = view.getContext().getApplicationContext();
        if (applicationContext instanceof DanaApplication) {
            return (DanaApplication) applicationContext;
        }
        return null;
    }

    public static final DanaApplication BuiltInFictitiousFunctionClassFactory(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        Context context = fragment.getContext();
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext instanceof DanaApplication) {
            return (DanaApplication) applicationContext;
        }
        return null;
    }

    public static final DanaApplication MyBillsEntityDataFactory(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        Context applicationContext = activity.getApplicationContext();
        if (applicationContext instanceof DanaApplication) {
            return (DanaApplication) applicationContext;
        }
        return null;
    }

    public static final DanaApplication BuiltInFictitiousFunctionClassFactory(ListenableWorker listenableWorker) {
        Intrinsics.checkNotNullParameter(listenableWorker, "");
        Context applicationContext = listenableWorker.getApplicationContext();
        if (applicationContext instanceof DanaApplication) {
            return (DanaApplication) applicationContext;
        }
        return null;
    }
}
