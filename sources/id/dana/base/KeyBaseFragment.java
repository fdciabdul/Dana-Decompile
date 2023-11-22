package id.dana.base;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import id.dana.base.BaseKey;
import id.dana.base.KeyBaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\b\u0012\u0004\u0012\u00028\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/base/KeyBaseFragment;", "Lid/dana/base/KeyBaseActivity;", "T", "Lid/dana/base/BaseKey;", DiskFormatter.KB, "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/base/viewbinding/ViewBindingFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class KeyBaseFragment<T extends KeyBaseActivity<?, ?>, K extends BaseKey, V extends ViewBinding> extends ViewBindingFragment<V> {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public void _$_clearFindViewByIdCache() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
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

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
