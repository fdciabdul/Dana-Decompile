package id.dana.playstorereview;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fB!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b"}, d2 = {"Lid/dana/playstorereview/AppReviewManager;", "", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "Landroid/app/Activity;", "MyBillsEntityDataFactory", "Lid/dana/playstorereview/AppReviewManager$AppReviewListener;", "PlaceComponentResult", "Lid/dana/playstorereview/AppReviewManager$AppReviewListener;", "getAuthRequestContext", "Lcom/google/android/play/core/review/ReviewManager;", "Lcom/google/android/play/core/review/ReviewManager;", "p0", "p1", "<init>", "(Landroid/app/Activity;Lid/dana/playstorereview/AppReviewManager$AppReviewListener;)V", "p2", "(Landroid/app/Activity;Lid/dana/playstorereview/AppReviewManager$AppReviewListener;Lcom/google/android/play/core/review/ReviewManager;)V", "AppReviewListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AppReviewManager {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Activity MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final ReviewManager BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AppReviewListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/playstorereview/AppReviewManager$AppReviewListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface AppReviewListener {
    }

    private AppReviewManager(Activity activity, AppReviewListener appReviewListener, ReviewManager reviewManager) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(appReviewListener, "");
        Intrinsics.checkNotNullParameter(reviewManager, "");
        this.MyBillsEntityDataFactory = activity;
        this.getAuthRequestContext = appReviewListener;
        this.BuiltInFictitiousFunctionClassFactory = reviewManager;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppReviewManager(android.app.Activity r3, id.dana.playstorereview.AppReviewManager.AppReviewListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1
            com.google.android.play.core.review.ReviewManager r1 = com.google.android.play.core.review.ReviewManagerFactory.create(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2.<init>(r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.AppReviewManager.<init>(android.app.Activity, id.dana.playstorereview.AppReviewManager$AppReviewListener):void");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AppReviewManager appReviewManager, Task task) {
        Intrinsics.checkNotNullParameter(appReviewManager, "");
        Intrinsics.checkNotNullParameter(task, "");
        if (task.isSuccessful()) {
            AppReviewListener appReviewListener = appReviewManager.getAuthRequestContext;
        } else {
            AppReviewListener appReviewListener2 = appReviewManager.getAuthRequestContext;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final AppReviewManager appReviewManager, Task task) {
        Intrinsics.checkNotNullParameter(appReviewManager, "");
        Intrinsics.checkNotNullParameter(task, "");
        if (task.isSuccessful()) {
            Object result = task.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "");
            appReviewManager.BuiltInFictitiousFunctionClassFactory.launchReviewFlow(appReviewManager.MyBillsEntityDataFactory, (ReviewInfo) result).addOnCompleteListener(new OnCompleteListener() { // from class: id.dana.playstorereview.AppReviewManager$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    AppReviewManager.KClassImpl$Data$declaredNonStaticMembers$2(AppReviewManager.this, task2);
                }
            });
            return;
        }
        AppReviewListener appReviewListener = appReviewManager.getAuthRequestContext;
    }
}
