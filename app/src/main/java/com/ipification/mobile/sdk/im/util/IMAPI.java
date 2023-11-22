package com.ipification.mobile.sdk.im.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Observer;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import com.ipification.mobile.sdk.im.di.RepositoryModule;
import com.ipification.mobile.sdk.im.listener.RedirectDataCallback;
import com.ipification.mobile.sdk.im.util.IMAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/ipification/mobile/sdk/im/util/IMAPI;", "", "<init>", "()V", "Factory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IMAPI {

    /* renamed from: Factory  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String getAuthRequestContext = "IMAPI";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\u0011"}, d2 = {"Lcom/ipification/mobile/sdk/im/util/IMAPI$Factory;", "", "Landroid/app/Activity;", "p0", "", "p1", "", "PlaceComponentResult", "(Landroid/app/Activity;Ljava/lang/String;)V", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/ipification/mobile/sdk/im/listener/RedirectDataCallback;", "p2", "getAuthRequestContext", "(Ljava/lang/String;Landroidx/appcompat/app/AppCompatActivity;Lcom/ipification/mobile/sdk/im/listener/RedirectDataCallback;)V", "Landroidx/fragment/app/FragmentActivity;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;Lcom/ipification/mobile/sdk/im/listener/RedirectDataCallback;)V", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.ipification.mobile.sdk.im.util.IMAPI$Factory  reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void PlaceComponentResult(RedirectDataCallback redirectDataCallback, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(redirectDataCallback, "");
            Intrinsics.checkParameterIsNotNull(str, "");
            String unused = IMAPI.getAuthRequestContext;
            Intrinsics.stringPlus("getRedirectLink dest url: ", str2);
            if (str2 == null || str2.length() == 0) {
                redirectDataCallback.PlaceComponentResult(str);
            } else {
                redirectDataCallback.PlaceComponentResult(str2);
            }
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(RedirectDataCallback redirectDataCallback, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(redirectDataCallback, "");
            Intrinsics.checkParameterIsNotNull(str, "");
            String unused = IMAPI.getAuthRequestContext;
            Intrinsics.stringPlus("getRedirectLink dest url: ", str2);
            if (str2 == null || str2.length() == 0) {
                redirectDataCallback.PlaceComponentResult(str);
            } else {
                redirectDataCallback.PlaceComponentResult(str2);
            }
        }

        public static void PlaceComponentResult(Activity p0, String p1) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            try {
                IPConstant.Companion companion = IPConstant.INSTANCE;
                IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
                StringBuilder sb = new StringBuilder();
                sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
                sb.append("openLink: ");
                sb.append(p1);
                sb.append(" \n");
                String obj = sb.toString();
                Intrinsics.checkParameterIsNotNull(obj, "");
                PlaceComponentResult.DatabaseTableConfigUtil = obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(p1));
                String unused = IMAPI.getAuthRequestContext;
                Intrinsics.stringPlus("openLink ", p1);
                p0.startActivity(intent);
            } catch (Exception e) {
                IPConstant.Companion companion2 = IPConstant.INSTANCE;
                IPConstant PlaceComponentResult2 = IPConstant.Companion.PlaceComponentResult();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PlaceComponentResult2.DatabaseTableConfigUtil);
                sb2.append("error : ");
                sb2.append((Object) e.getMessage());
                sb2.append(" \n");
                String obj2 = sb2.toString();
                Intrinsics.checkParameterIsNotNull(obj2, "");
                PlaceComponentResult2.DatabaseTableConfigUtil = obj2;
            }
        }

        public static void getAuthRequestContext(final String p0, AppCompatActivity p1, final RedirectDataCallback p2) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(p2, "");
            IPConstant.Companion companion = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
            sb.append("startGetRedirect url ");
            sb.append(p0);
            sb.append(" \n");
            String obj = sb.toString();
            Intrinsics.checkParameterIsNotNull(obj, "");
            PlaceComponentResult.DatabaseTableConfigUtil = obj;
            RepositoryModule.Companion companion2 = RepositoryModule.INSTANCE;
            RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().PlaceComponentResult(p1, p0).PlaceComponentResult(p1, new Observer() { // from class: com.ipification.mobile.sdk.im.util.IMAPI$Factory$$ExternalSyntheticLambda0
                @Override // androidx.view.Observer
                public final void onChanged(Object obj2) {
                    IMAPI.Companion.PlaceComponentResult(RedirectDataCallback.this, p0, (String) obj2);
                }
            });
        }

        public static void BuiltInFictitiousFunctionClassFactory(final String p0, FragmentActivity p1, final RedirectDataCallback p2) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(p2, "");
            IPConstant.Companion companion = IPConstant.INSTANCE;
            IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult.DatabaseTableConfigUtil);
            sb.append("startGetRedirect url ");
            sb.append(p0);
            sb.append(" \n");
            String obj = sb.toString();
            Intrinsics.checkParameterIsNotNull(obj, "");
            PlaceComponentResult.DatabaseTableConfigUtil = obj;
            RepositoryModule.Companion companion2 = RepositoryModule.INSTANCE;
            RepositoryModule.Companion.getAuthRequestContext().MyBillsEntityDataFactory().PlaceComponentResult(p1, p0).PlaceComponentResult(p1, new Observer() { // from class: com.ipification.mobile.sdk.im.util.IMAPI$Factory$$ExternalSyntheticLambda1
                @Override // androidx.view.Observer
                public final void onChanged(Object obj2) {
                    IMAPI.Companion.BuiltInFictitiousFunctionClassFactory(RedirectDataCallback.this, p0, (String) obj2);
                }
            });
        }
    }
}
