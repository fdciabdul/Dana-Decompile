package com.akamai.botman;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.akamai.botman.CYFMonitor;
import com.cyberfend.cyfsecurity.CCADialogActivity;
import com.cyberfend.cyfsecurity.R;

/* loaded from: classes.dex */
public class a {
    private static final a KClassImpl$Data$declaredNonStaticMembers$2 = new a();
    private static final String getAuthRequestContext = "a";
    public String BuiltInFictitiousFunctionClassFactory = "";
    public InterfaceC0012a MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public float PlaceComponentResult;
    private CYFMonitor.ChallengeActionCallback lookAheadTest;

    /* renamed from: com.akamai.botman.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0012a {
        void KClassImpl$Data$declaredNonStaticMembers$2(float f);

        void MyBillsEntityDataFactory();
    }

    static /* synthetic */ int PlaceComponentResult(a aVar) {
        aVar.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        return 0;
    }

    public static a getAuthRequestContext() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean PlaceComponentResult(Context context, String str, String str2, String str3, CYFMonitor.ChallengeActionCallback challengeActionCallback, String str4) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 1 || challengeActionCallback == null) {
            return false;
        }
        this.lookAheadTest = challengeActionCallback;
        if (x.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory == null || x.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.equals("")) {
            this.lookAheadTest.BuiltInFictitiousFunctionClassFactory("CCA is not configured");
            return false;
        }
        this.BuiltInFictitiousFunctionClassFactory = str4;
        Intent intent = new Intent(context, CCADialogActivity.class);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.getAuthRequestContext});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        intent.putExtra("CCA Title", str);
        intent.putExtra("CCA Message", str2);
        intent.putExtra("CCA Cancel Button", str3);
        intent.putExtra("Theme Color", color);
        context.startActivity(intent);
        synchronized (this) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        }
        return true;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        x KClassImpl$Data$declaredNonStaticMembers$22 = x.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult != 1) {
            if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult == 3) {
                synchronized (KClassImpl$Data$declaredNonStaticMembers$22) {
                    KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = 0;
                }
                return;
            }
            return;
        }
        synchronized (KClassImpl$Data$declaredNonStaticMembers$22) {
            KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult = 2;
        }
    }
}
