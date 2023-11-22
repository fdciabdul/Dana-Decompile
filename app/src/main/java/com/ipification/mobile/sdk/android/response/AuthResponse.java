package com.ipification.mobile.sdk.android.response;

import android.net.Uri;
import com.ipification.mobile.sdk.android.model.IMSession;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.socialshare.ShareAppKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010"}, d2 = {"Lcom/ipification/mobile/sdk/android/response/AuthResponse;", "Lcom/ipification/mobile/sdk/android/response/CellularResponse;", "", "getAuthRequestContext", "()Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lcom/ipification/mobile/sdk/android/model/IMSession;", "BuiltInFictitiousFunctionClassFactory", "()Lcom/ipification/mobile/sdk/android/model/IMSession;", "moveToNextValue", "", "lookAheadTest", "()Z", "Lokhttp3/Headers;", "Lokhttp3/Headers;", "", "p0", "p1", "p2", "<init>", "(ILjava/lang/String;Lokhttp3/Headers;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthResponse extends CellularResponse {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Headers PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthResponse(int i, String str, Headers headers) {
        super(i, str);
        Intrinsics.checkParameterIsNotNull(str, "");
        this.PlaceComponentResult = headers;
    }

    public final String getAuthRequestContext() {
        try {
            Uri parse = Uri.parse(this.getAuthRequestContext);
            if (!parse.isHierarchical() || parse.getQueryParameter("code") == null) {
                return null;
            }
            return parse.getQueryParameter("code");
        } catch (Exception unused) {
            return null;
        }
    }

    public final String PlaceComponentResult() {
        try {
            Uri parse = Uri.parse(this.getAuthRequestContext);
            if (parse.isHierarchical()) {
                String queryParameter = parse.getQueryParameter("error");
                if (queryParameter != null) {
                    return queryParameter;
                }
            }
            return "";
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception: ");
            sb.append((Object) e.getLocalizedMessage());
            sb.append(" - ");
            sb.append(this.getAuthRequestContext);
            return sb.toString();
        }
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            Uri parse = Uri.parse(this.getAuthRequestContext);
            if (parse.isHierarchical()) {
                String queryParameter = parse.getQueryParameter("error_description");
                if (queryParameter != null) {
                    return queryParameter;
                }
            }
            return "";
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception: ");
            sb.append((Object) e.getLocalizedMessage());
            sb.append(" - ");
            sb.append(this.getAuthRequestContext);
            return sb.toString();
        }
    }

    public final String MyBillsEntityDataFactory() {
        try {
            Uri parse = Uri.parse(this.getAuthRequestContext);
            if (parse.isHierarchical()) {
                String queryParameter = parse.getQueryParameter("error");
                String queryParameter2 = parse.getQueryParameter("error_description");
                if (queryParameter == null || queryParameter2 == null) {
                    return queryParameter2 == null ? queryParameter == null ? this.getAuthRequestContext : queryParameter : queryParameter2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((Object) queryParameter);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append((Object) queryParameter2);
                return sb.toString();
            }
            return "";
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exception: ");
            sb2.append((Object) e.getLocalizedMessage());
            sb2.append(" - ");
            sb2.append(this.getAuthRequestContext);
            return sb2.toString();
        }
    }

    public final IMSession BuiltInFictitiousFunctionClassFactory() {
        Headers headers = this.PlaceComponentResult;
        if (headers != null) {
            IPConstant.Companion companion = IPConstant.INSTANCE;
            if (headers.get(IPConstant.Companion.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory) != null) {
                try {
                    IMSession iMSession = new IMSession(null, null, null, null, null, 31, null);
                    iMSession.getAuthRequestContext = this.PlaceComponentResult.get(IPConstant.Companion.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory);
                    iMSession.PlaceComponentResult = this.PlaceComponentResult.get(IPConstant.Companion.PlaceComponentResult().lookAheadTest);
                    iMSession.KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.get(IPConstant.Companion.PlaceComponentResult().moveToNextValue);
                    iMSession.MyBillsEntityDataFactory = this.PlaceComponentResult.get(IPConstant.Companion.PlaceComponentResult().NetworkUserEntityData$$ExternalSyntheticLambda0);
                    if (iMSession.PlaceComponentResult == null && iMSession.KClassImpl$Data$declaredNonStaticMembers$2 == null && iMSession.MyBillsEntityDataFactory == null && (this.PlaceComponentResult.get("location") != null || this.PlaceComponentResult.get("Location") != null)) {
                        String str = this.PlaceComponentResult.get("location");
                        if (str == null) {
                            str = this.PlaceComponentResult.get("Location");
                        }
                        boolean z = true;
                        if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "wa", false, 2, (Object) null)) {
                            iMSession.PlaceComponentResult = str;
                        } else {
                            if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "viber", false, 2, (Object) null)) {
                                iMSession.MyBillsEntityDataFactory = str;
                            } else {
                                if (str == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) ShareAppKey.TELEGRAM, false, 2, (Object) null)) {
                                    z = false;
                                }
                                if (z) {
                                    iMSession.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                                }
                            }
                        }
                    }
                    iMSession.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.get(IPConstant.Companion.PlaceComponentResult().MyBillsEntityDataFactory);
                    return iMSession;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public final String moveToNextValue() {
        try {
            Uri parse = Uri.parse(this.getAuthRequestContext);
            if (!parse.isHierarchical() || parse.getQueryParameter("state") == null) {
                return null;
            }
            return parse.getQueryParameter("state");
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean lookAheadTest() {
        Headers headers = this.PlaceComponentResult;
        if (headers != null) {
            IPConstant.Companion companion = IPConstant.INSTANCE;
            return headers.get(IPConstant.Companion.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory) != null;
        }
        return false;
    }
}
