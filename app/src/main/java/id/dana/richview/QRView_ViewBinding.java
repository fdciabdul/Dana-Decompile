package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;

/* loaded from: classes9.dex */
public class QRView_ViewBinding implements Unbinder {
    private QRView MyBillsEntityDataFactory;

    public QRView_ViewBinding(QRView qRView, View view) {
        this.MyBillsEntityDataFactory = qRView;
        qRView.imageViewUserProfile = (CircleImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.imageview_user_profile, "field 'imageViewUserProfile'", CircleImageView.class);
        qRView.ivKyc = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_kyc, "field 'ivKyc'", ImageView.class);
        qRView.ivQr = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_qr, "field 'ivQr'", ImageView.class);
        qRView.ivRefresh = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_refresh, "field 'ivRefresh'", ImageView.class);
        qRView.viewQrSkeleton = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.view_qr_skeleton, "field 'viewQrSkeleton'");
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        QRView qRView = this.MyBillsEntityDataFactory;
        if (qRView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        qRView.imageViewUserProfile = null;
        qRView.ivKyc = null;
        qRView.ivQr = null;
        qRView.ivRefresh = null;
        qRView.viewQrSkeleton = null;
    }
}
