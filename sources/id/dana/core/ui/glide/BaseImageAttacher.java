package id.dana.core.ui.glide;

import com.bumptech.glide.request.RequestOptions;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public abstract class BaseImageAttacher implements ImageAttacherStrategy {
    private RequestOptions KClassImpl$Data$declaredNonStaticMembers$2;
    private int PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseImageAttacher(AdditionalData additionalData) {
        if (additionalData != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = additionalData.KClassImpl$Data$declaredNonStaticMembers$2;
            this.PlaceComponentResult = additionalData.PlaceComponentResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RequestOptions getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int PlaceComponentResult() {
        int i = this.PlaceComponentResult;
        return i <= 0 ? R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7 : i;
    }

    /* loaded from: classes4.dex */
    public static class AdditionalData {
        public RequestOptions KClassImpl$Data$declaredNonStaticMembers$2;
        public int PlaceComponentResult;
    }
}
