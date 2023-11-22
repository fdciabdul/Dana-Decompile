package id.dana.nearbyme.merchantreview.extension;

import android.content.Context;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.extension.WorkManagerFailure;
import id.dana.nearbyme.merchantreview.CreateReviewWorker;
import id.dana.nearbyme.merchantreview.UploadImageWorker;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\t\u001a\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroid/content/Context;", "Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;)V", "", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/util/List;Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewExtKt {
    public static final void BuiltInFictitiousFunctionClassFactory(Context context, List<String> list, CreateReviewWorker.Param param) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(param, "");
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            UploadImageWorker.Companion companion = UploadImageWorker.INSTANCE;
            WorkContinuation authRequestContext = PlaceComponentResult.getAuthRequestContext(UploadImageWorker.Companion.PlaceComponentResult(list));
            CreateReviewWorker.Companion companion2 = CreateReviewWorker.INSTANCE;
            authRequestContext.PlaceComponentResult(Collections.singletonList(CreateReviewWorker.Companion.KClassImpl$Data$declaredNonStaticMembers$2(param))).KClassImpl$Data$declaredNonStaticMembers$2();
        } catch (Exception e) {
            try {
                Crashlytics.Companion companion3 = Crashlytics.INSTANCE;
                Crashlytics authRequestContext2 = Crashlytics.Companion.getAuthRequestContext();
                WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                Intrinsics.checkNotNullParameter(workManagerFailure, "");
                authRequestContext2.getAuthRequestContext.recordException(workManagerFailure);
            } catch (Exception unused) {
            }
        }
    }

    public static final void getAuthRequestContext(Context context, CreateReviewWorker.Param param) {
        WorkManager PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(param, "");
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            CreateReviewWorker.Companion companion = CreateReviewWorker.INSTANCE;
            PlaceComponentResult.getAuthRequestContext(Collections.singletonList(CreateReviewWorker.Companion.KClassImpl$Data$declaredNonStaticMembers$2(param))).KClassImpl$Data$declaredNonStaticMembers$2();
        } catch (Exception e) {
            try {
                Crashlytics.Companion companion2 = Crashlytics.INSTANCE;
                Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
                WorkManagerFailure workManagerFailure = new WorkManagerFailure(e);
                Intrinsics.checkNotNullParameter(workManagerFailure, "");
                authRequestContext.getAuthRequestContext.recordException(workManagerFailure);
            } catch (Exception unused) {
            }
        }
    }
}
