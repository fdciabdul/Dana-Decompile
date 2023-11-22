package id.dana.miniprogram;

import android.app.Application;
import android.content.Intent;
import com.alibaba.griver.base.common.env.GriverEnv;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.miniprogram.tnc.EmailNotVerifiedDialogActivity;
import id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aO\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/authcode/interactor/GetAuthCode$MissingRequiredUserInfoException;", "", "p0", "p1", "p2", "p3", "p4", "p5", "", "p6", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/authcode/interactor/GetAuthCode$MissingRequiredUserInfoException;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtensionsKt {
    public static final void BuiltInFictitiousFunctionClassFactory(GetAuthCode.MissingRequiredUserInfoException missingRequiredUserInfoException, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intent intent;
        Intrinsics.checkNotNullParameter(missingRequiredUserInfoException, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Application applicationContext = GriverEnv.getApplicationContext();
        if (missingRequiredUserInfoException.getUserDataStatus() == GetEmptyUserInfo.Status.EMAIL_UNVERIFIED) {
            intent = new Intent(applicationContext, EmailNotVerifiedDialogActivity.class);
        } else {
            Intent putExtra = new Intent(applicationContext, MissingRequiredUserInfoDialogActivity.class).putExtra("startParams", new MissingRequiredUserInfoDialogActivity.StartParams(str, str2, str3, str4, str5, str6, z, null, 128, null));
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            intent = putExtra;
        }
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        applicationContext.startActivity(intent);
    }
}
