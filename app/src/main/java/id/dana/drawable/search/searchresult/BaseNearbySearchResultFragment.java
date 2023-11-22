package id.dana.drawable.search.searchresult;

import android.view.View;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.base.BaseFragment;
import id.dana.drawable.search.NearbySearchResultListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u001c\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000e@BX\u0086\n¢\u0006\u0006\n\u0004\b\r\u0010\u000f"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/BaseNearbySearchResultFragment;", "Lid/dana/base/BaseFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "MyBillsEntityDataFactory", "", "p0", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "BuiltInFictitiousFunctionClassFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseNearbySearchResultFragment extends BaseFragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public NearbySearchResultListener BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2 = "";

    public void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.clear();
    }

    public View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public abstract int getLayout();

    @Override // id.dana.base.BaseFragment
    public abstract void init();

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        PlaceComponentResult();
    }

    public void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }
}
