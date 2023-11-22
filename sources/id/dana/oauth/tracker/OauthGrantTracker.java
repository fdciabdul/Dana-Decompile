package id.dana.oauth.tracker;

import id.dana.data.constant.BranchLinkConstant;
import id.dana.oauth.model.OauthInitModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J2\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lid/dana/oauth/tracker/OauthGrantTracker;", "", "trackError", "", "throwable", "", "bindingType", "", BranchLinkConstant.ActionTarget.QR_BIND, "", "googleMerchant", "trackGnMerchantAccountBind", "merchantSiteName", "success", "failedReason", "verificationMethods", "", "trackGnMerchantLoadingState", "trackGnMerchantRequestOpen", "oauthInitModel", "Lid/dana/oauth/model/OauthInitModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OauthGrantTracker {
    void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, String str, boolean z, boolean z2);

    void MyBillsEntityDataFactory(String str);

    void PlaceComponentResult(String str, boolean z, String str2, List<String> list);

    void getAuthRequestContext(OauthInitModel oauthInitModel);

    /* renamed from: id.dana.oauth.tracker.OauthGrantTracker$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
    }
}
