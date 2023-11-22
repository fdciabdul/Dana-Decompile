package id.dana.playstorereview;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.model.AppReviewInfoModel;

/* loaded from: classes3.dex */
public class PlayStoreReviewContractView implements PlayStoreReviewContract.View {
    public static final byte[] $$a = {8, 83, -102, TarHeader.LF_SYMLINK, -2, -51, 57, 0, 16, -10, -48, 69, -1, -8, Ascii.ESC, -3, 4, -2, 6, -10, 16, -10, Ascii.DC4, -10, -1, Ascii.NAK, -70, 37, Ascii.US, -8, Ascii.ESC, -35, 36, -2, 6, -10, -16, 22, Ascii.DC4, -10, -1, Ascii.NAK, -51, 37, Ascii.DC4, -8, 16, -10, 14, 8};
    public static final int $$b = 120;
    private final Activity PlaceComponentResult;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 105 - r8
            byte[] r0 = id.dana.playstorereview.PlayStoreReviewContractView.$$a
            int r6 = r6 * 3
            int r6 = r6 + 47
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r6 = r6 + r3
            int r6 = r6 + (-3)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.playstorereview.PlayStoreReviewContractView.a(short, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    public PlayStoreReviewContractView(Activity activity) {
        this.PlaceComponentResult = activity;
    }

    @Override // id.dana.playstorereview.PlayStoreReviewContract.View
    public void BuiltInFictitiousFunctionClassFactory(AppReviewInfoModel appReviewInfoModel) {
        if (MyBillsEntityDataFactory(appReviewInfoModel)) {
            Activity activity = this.PlaceComponentResult;
            Activity activity2 = this.PlaceComponentResult;
            byte[] bArr = $$a;
            Object[] objArr = new Object[1];
            a(bArr[7], bArr[12], bArr[7], objArr);
            activity.startActivity(new Intent(activity2, Class.forName((String) objArr[0])).putExtra("in_app_review", appReviewInfoModel.getKClassImpl$Data$declaredNonStaticMembers$2()));
        }
    }

    @Override // id.dana.playstorereview.PlayStoreReviewContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.finish();
    }

    private boolean MyBillsEntityDataFactory(AppReviewInfoModel appReviewInfoModel) {
        return (appReviewInfoModel == null || !appReviewInfoModel.getMyBillsEntityDataFactory() || this.PlaceComponentResult == null) ? false : true;
    }
}
