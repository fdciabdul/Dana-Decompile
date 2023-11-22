package id.dana.component.formcomponent;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.content.res.ResourcesCompat;
import id.dana.component.R;
import id.dana.component.utils.SizeUtil;

/* loaded from: classes4.dex */
public class DanaRadioButtonView extends AppCompatRadioButton {
    public DanaRadioButtonView(Context context) {
        super(context);
        BuiltInFictitiousFunctionClassFactory();
    }

    public DanaRadioButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        BuiltInFictitiousFunctionClassFactory();
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), R.font.MyBillsEntityDataFactory));
        setTextColor(getResources().getColor(R.color.KClassImpl$Data$declaredNonStaticMembers$2));
        setTextSize(16.0f);
        setButtonDrawable(R.drawable.res_0x7f080d7f_networkuserentitydata_externalsyntheticlambda8);
        setGravity(48);
        setPadding(SizeUtil.PlaceComponentResult(8), 0, 0, SizeUtil.PlaceComponentResult(0));
    }
}
