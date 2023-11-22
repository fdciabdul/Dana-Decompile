package id.dana.kyb.view;

import android.content.Context;
import android.content.Intent;
import com.alibaba.ariver.kernel.RVEvents;
import com.google.common.base.Ascii;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.model.TncSummaryEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$getTncSummaryModule$1;", "Lid/dana/tncsummary/TncSummaryContract$View;", "", "dismissProgress", "()V", "", "p0", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "", "PlaceComponentResult", "(Z)V", "showProgress"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessFragment$getTncSummaryModule$1 implements TncSummaryContract.View {
    public static final byte[] $$a = {96, 83, 72, -80, -3, -52, 56, -1, 15, -11, -49, 72, -4, -9, 18, 4, -6, 2, -10, 19, 9, -73, 40, Ascii.FS, -9, -14, 36, -6, 2, -10, 19, 9, -54, 36, 19, -9, 15, -11, 13, 7};
    public static final int $$b = 173;
    final /* synthetic */ MyBusinessFragment BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 2
            int r9 = 37 - r9
            int r7 = r7 * 3
            int r7 = r7 + 105
            int r8 = r8 + 4
            byte[] r0 = id.dana.kyb.view.MyBusinessFragment$getTncSummaryModule$1.$$a
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r8 = r8 + r9
            int r8 = r8 + (-2)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.view.MyBusinessFragment$getTncSummaryModule$1.a(byte, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.tncsummary.TncSummaryContract.View
    public final void PlaceComponentResult(boolean p0) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
    }

    public MyBusinessFragment$getTncSummaryModule$1(MyBusinessFragment myBusinessFragment) {
        this.BuiltInFictitiousFunctionClassFactory = myBusinessFragment;
    }

    @Override // id.dana.tncsummary.TncSummaryContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final List<AgreementInfo> p0) {
        if (p0 != null) {
            MyBusinessFragment myBusinessFragment = this.BuiltInFictitiousFunctionClassFactory;
            Context context = myBusinessFragment.getContext();
            byte[] bArr = $$a;
            byte b = (byte) (bArr[7] + 1);
            byte b2 = bArr[7];
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr);
            myBusinessFragment.startActivity(new Intent(context, Class.forName((String) objArr[0])).putExtra("tnc_summary_variant", 1));
            this.BuiltInFictitiousFunctionClassFactory.addDisposable(Observable.timer(1L, TimeUnit.SECONDS).subscribeOn(Schedulers.getAuthRequestContext()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.kyb.view.MyBusinessFragment$getTncSummaryModule$1$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Long l = (Long) obj;
                    MyBusinessFragment$getTncSummaryModule$1.getAuthRequestContext(p0);
                }
            }));
        }
    }

    public static /* synthetic */ void getAuthRequestContext(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        EventBus.getDefault().post(new TncSummaryEvent(list));
    }
}
