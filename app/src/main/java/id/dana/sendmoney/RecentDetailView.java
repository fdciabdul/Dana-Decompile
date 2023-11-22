package id.dana.sendmoney;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import id.dana.base.BaseRichView;
import id.dana.data.util.NumberUtils;
import id.dana.richview.CircleImageSelectionView;
import java.util.List;

/* loaded from: classes5.dex */
public class RecentDetailView extends BaseRichView {
    private TextView BuiltInFictitiousFunctionClassFactory;
    private CircleImageSelectionView PlaceComponentResult;
    private TextView getAuthRequestContext;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return id.dana.R.layout.view_recent_detail;
    }

    public RecentDetailView(Context context) {
        super(context);
    }

    public RecentDetailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecentDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public RecentDetailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.PlaceComponentResult = (CircleImageSelectionView) findViewById(id.dana.R.id.cisv_display_photo);
        this.getAuthRequestContext = (TextView) findViewById(id.dana.R.id.tv_detail);
        this.BuiltInFictitiousFunctionClassFactory = (TextView) findViewById(id.dana.R.id.tv_name);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setView(String str, String str2, String str3, String str4) {
        char c;
        switch (str4.hashCode()) {
            case -567451565:
                if (str4.equals("contacts")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3016252:
                if (str4.equals("bank")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3321850:
                if (str4.equals("link")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1910961662:
                if (str4.equals("scanner")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2017195305:
                if (str4.equals(RecentDetailType.CASHOUT_AGENTS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        int i = c != 0 ? c != 1 ? c != 2 ? c != 3 ? id.dana.R.drawable.ic_avatar_grey_default : id.dana.R.drawable.ic_bank_placeholder : id.dana.R.drawable.ic_p2c : id.dana.R.drawable.ic_send_via_link : id.dana.R.drawable.ic_send_via_qr;
        setName(str);
        setDetail(str2);
        if (this.PlaceComponentResult != null) {
            if (str3 == null || str3.isEmpty()) {
                str3 = "";
            }
            this.PlaceComponentResult.loadImage(str3, i);
        }
    }

    public void setView(String str, String str2, String str3, boolean z) {
        setView(str, (String) null, str2, str3);
        this.PlaceComponentResult.useRemoveIcon(z);
    }

    public void setView(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        setView(str, str2, str3, str4);
        this.PlaceComponentResult.useRemoveIcon(z);
        this.PlaceComponentResult.setPhotoCircleDisplay(z2);
    }

    public void setName(String str) {
        TextView textView = this.BuiltInFictitiousFunctionClassFactory;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setDetail(String str) {
        TextView textView = this.getAuthRequestContext;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
        this.getAuthRequestContext.setVisibility(0);
    }

    public void setOnClickCrossIconListener(CircleImageSelectionView.Listener listener) {
        this.PlaceComponentResult.setListener(listener);
    }

    public void setSelectedState(List<String> list, String str) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(list, str)) {
            this.PlaceComponentResult.setSelectedState();
        } else {
            this.PlaceComponentResult.setUnselectedState();
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<String> list, String str) {
        String indoPhoneNumber = NumberUtils.getIndoPhoneNumber(str);
        return (list == null || list.isEmpty() || indoPhoneNumber == null || !list.contains(indoPhoneNumber)) ? false : true;
    }
}
