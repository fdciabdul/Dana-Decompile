package id.dana.dialog;

import android.content.Intent;
import android.view.View;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.tncagreement.TermsAndConditionsActivity;

/* loaded from: classes8.dex */
public final /* synthetic */ class DialogTncInformation$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ DialogTncInformation BuiltInFictitiousFunctionClassFactory;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogTncInformation dialogTncInformation = this.BuiltInFictitiousFunctionClassFactory;
        dialogTncInformation.MyBillsEntityDataFactory.startActivity(new Intent(dialogTncInformation.MyBillsEntityDataFactory, TermsAndConditionsActivity.class).addFlags(AntDetector.SCENE_ID_LOGIN_REGIST));
        dialogTncInformation.getAuthRequestContext();
    }
}
