package id.dana.sendmoney.recipient.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.util.NumberUtil;
import id.dana.data.util.NumberUtils;
import id.dana.richview.CircleImageSelectionView;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.utils.MaskedTextUtil;
import java.util.List;

/* loaded from: classes5.dex */
public class ContactRichView extends BaseRichView {
    private ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    private ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    private CircleImageSelectionView MyBillsEntityDataFactory;
    private ImageView PlaceComponentResult;
    private boolean getAuthRequestContext;
    private RecipientViewModel lookAheadTest;
    private TextView moveToNextValue;
    private TextView scheduleImpl;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_contact;
    }

    public ContactRichView(Context context) {
        super(context);
    }

    public ContactRichView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactRichView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ContactRichView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.scheduleImpl = (TextView) findViewById(R.id.tv_phone_number);
        this.moveToNextValue = (TextView) findViewById(R.id.f4388tv_display_name);
        this.PlaceComponentResult = (ImageView) findViewById(R.id.iv_dana_user_logo);
        this.MyBillsEntityDataFactory = (CircleImageSelectionView) findViewById(R.id.cisv_display_photo);
        this.BuiltInFictitiousFunctionClassFactory = (ConstraintLayout) findViewById(R.id.cl_invite_user);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (ImageView) findViewById(R.id.CustomPopMenuExtension);
    }

    public void init(RecipientViewModel recipientViewModel, List<String> list) {
        String PlaceComponentResult;
        this.lookAheadTest = recipientViewModel;
        String PlaceComponentResult2 = recipientViewModel.PlaceComponentResult();
        String str = recipientViewModel.getErrorConfigVersion;
        if (PlaceComponentResult2 != null && str != null) {
            TextView textView = this.moveToNextValue;
            if (NumberUtils.isValidIndoPhoneNumberPrefix(PlaceComponentResult2) || PlaceComponentResult2.equals("-")) {
                PlaceComponentResult = MaskedTextUtil.PlaceComponentResult(NumberUtils.replaceIndoPhoneNumberPrefixWithZero(str));
            } else {
                PlaceComponentResult = MaskedTextUtil.PlaceComponentResult(PlaceComponentResult2);
            }
            textView.setText(PlaceComponentResult);
            TextView textView2 = this.scheduleImpl;
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            textView2.setText(NumberUtil.MyBillsEntityDataFactory((NumberUtils.isValidIndoPhoneNumberPrefix(PlaceComponentResult2) || PlaceComponentResult2.equals("-")) ? "" : MaskedTextUtil.PlaceComponentResult(str)));
            this.scheduleImpl.setVisibility(BuiltInFictitiousFunctionClassFactory() ? 8 : 0);
        }
        this.MyBillsEntityDataFactory.loadImage(recipientViewModel.BuiltInFictitiousFunctionClassFactory());
        if (list != null) {
            this.PlaceComponentResult.setVisibility(MyBillsEntityDataFactory(list) ? 0 : 8);
            this.BuiltInFictitiousFunctionClassFactory.setVisibility((MyBillsEntityDataFactory(list) || !this.getAuthRequestContext) ? 8 : 0);
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        String PlaceComponentResult = this.lookAheadTest.PlaceComponentResult();
        return ((NumberUtils.isValidIndoPhoneNumberPrefix(PlaceComponentResult) || PlaceComponentResult.equals("-")) ? "" : MaskedTextUtil.PlaceComponentResult(this.lookAheadTest.getErrorConfigVersion)).equals("");
    }

    private boolean MyBillsEntityDataFactory(List<String> list) {
        if (!this.lookAheadTest.scheduleImpl()) {
            for (String str : list) {
                if (KClassImpl$Data$declaredNonStaticMembers$2(NumberUtils.getClearPhoneNumber(this.lookAheadTest.getErrorConfigVersion), str) || KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest.getErrorConfigVersion, str)) {
                    this.lookAheadTest.GetContactSyncConfig = true;
                    return true;
                }
            }
            return false;
        }
        this.lookAheadTest.GetContactSyncConfig = true;
        return true;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        return str != null && str.equals(str2);
    }

    public void enableInvite() {
        this.getAuthRequestContext = true;
    }

    public void enableArrow() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.PlaceComponentResult.getLayoutParams();
        layoutParams.setMargins(0, 0, 4, 0);
        this.PlaceComponentResult.setLayoutParams(layoutParams);
    }

    public void setSelectedState(List<String> list) {
        String indoPhoneNumber = NumberUtils.getIndoPhoneNumber(this.lookAheadTest.getErrorConfigVersion);
        if (list != null && !list.isEmpty() && list.contains(indoPhoneNumber)) {
            this.MyBillsEntityDataFactory.setSelectedState();
        } else {
            this.MyBillsEntityDataFactory.setUnselectedState();
        }
    }

    public RecipientModel getSelectedRecipient() {
        String str;
        RecipientModel.Builder builder = new RecipientModel.Builder("contact");
        if (this.lookAheadTest.getErrorConfigVersion.contains("*")) {
            str = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            str = this.lookAheadTest.getErrorConfigVersion;
        }
        builder.scheduleImpl = str;
        builder.PrepareContext = this.lookAheadTest.getErrorConfigVersion.contains("*") ? "userid" : "phonenumber";
        builder.initRecordTimeStamp = this.lookAheadTest.PlaceComponentResult();
        builder.GetContactSyncConfig = this.lookAheadTest.getErrorConfigVersion;
        builder.getErrorConfigVersion = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda7 = this.lookAheadTest.moveToNextValue();
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
