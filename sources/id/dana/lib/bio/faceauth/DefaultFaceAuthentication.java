package id.dana.lib.bio.faceauth;

import android.content.Context;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipay.mobile.verifyidentity.framework.engine.VIAction;
import com.alipay.mobile.verifyidentity.framework.engine.VIEngine;
import com.alipay.mobile.verifyidentity.framework.engine.VIResult;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ?\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJO\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\tj\u0002`\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0016J9\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u000fH\u0002¢\u0006\u0004\b\r\u0010\u0018"}, d2 = {"Lid/dana/lib/bio/faceauth/DefaultFaceAuthentication;", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Landroid/content/Context;", "p0", "", "p1", "", "", "p2", "Lid/dana/lib/bio/faceauth/FaceAuthenticationCallback;", "Lid/dana/lib/bio/faceauth/EnrollmentFaceAuthentication;", "p3", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;Lid/dana/lib/bio/faceauth/FaceAuthenticationCallback;)V", "Lkotlin/Function1;", "Lcom/alipay/mobile/verifyidentity/framework/engine/VIResult;", "Lid/dana/lib/bio/faceauth/exception/DanaBioException$FaceAuthenticationException;", "p4", "PlaceComponentResult", "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lid/dana/lib/bio/faceauth/VerifyFaceAuthentication;", "(Landroid/content/Context;Ljava/lang/String;Lid/dana/lib/bio/faceauth/FaceAuthenticationCallback;)V", "Lkotlin/Function0;", "(Lcom/alipay/mobile/verifyidentity/framework/engine/VIResult;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultFaceAuthentication implements FaceAuthentication {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DefaultFaceAuthentication MyBillsEntityDataFactory;

    public /* synthetic */ DefaultFaceAuthentication(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DefaultFaceAuthentication() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/lib/bio/faceauth/DefaultFaceAuthentication$Companion;", "", "Lid/dana/lib/bio/faceauth/FaceAuthentication;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/lib/bio/faceauth/FaceAuthentication;", "Lid/dana/lib/bio/faceauth/DefaultFaceAuthentication;", "MyBillsEntityDataFactory", "Lid/dana/lib/bio/faceauth/DefaultFaceAuthentication;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FaceAuthentication KClassImpl$Data$declaredNonStaticMembers$2() {
            DefaultFaceAuthentication defaultFaceAuthentication;
            synchronized (DefaultFaceAuthentication.class) {
                if (DefaultFaceAuthentication.MyBillsEntityDataFactory == null) {
                    Companion companion = DefaultFaceAuthentication.INSTANCE;
                    DefaultFaceAuthentication.MyBillsEntityDataFactory = new DefaultFaceAuthentication(null);
                }
                defaultFaceAuthentication = DefaultFaceAuthentication.MyBillsEntityDataFactory;
                Intrinsics.checkNotNull(defaultFaceAuthentication);
            }
            return defaultFaceAuthentication;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x006f, code lost:
    
        if (r7 == null) goto L55;
     */
    @Override // id.dana.lib.bio.faceauth.FaceAuthentication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(final android.content.Context r7, final java.lang.String r8, java.util.Map<java.lang.String, ? extends java.lang.Object> r9, final id.dana.lib.bio.faceauth.FaceAuthenticationCallback r10) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1
            r1 = 0
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$enrollFaceAuth$onError$1 r2 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$enrollFaceAuth$onError$1     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r2.<init>()     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$enrollFaceAuth$verifyResult$1 r3 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$enrollFaceAuth$verifyResult$1     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r3.<init>()     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$enrollFaceAuth$startVerify$1 r4 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$enrollFaceAuth$startVerify$1     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r4.<init>()     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            int r5 = r3.length()     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            if (r5 != 0) goto L30
            r5 = 1
            goto L31
        L30:
            r5 = 0
        L31:
            if (r5 != 0) goto L4f
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            if (r3 != 0) goto L4f
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$setUserId$1 r3 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$setUserId$1     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r3.<init>()     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface r3 = (com.alipay.mobile.verifyidentity.business.activity.SecVIVerifyInterface) r3     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            com.alipay.mobile.verifyidentity.business.activity.SecVIVerify.setSecVIVerifyInterface(r3)     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$queryEnrollment$1 r8 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$queryEnrollment$1     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r8.<init>()     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            com.alipay.mobile.verifyidentity.framework.engine.QueryStateInterface r8 = (com.alipay.mobile.verifyidentity.framework.engine.QueryStateInterface) r8     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            r2 = 3
            com.alipay.mobile.verifyidentity.framework.engine.SecVIEngine.queryAuthenticationStatusWithOption(r7, r2, r9, r8)     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            return
        L4f:
            id.dana.lib.bio.faceauth.exception.DanaBioException$FaceAuthenticationException r7 = new id.dana.lib.bio.faceauth.exception.DanaBioException$FaceAuthenticationException     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            java.lang.String r8 = "Face enroll User Id is empty or blank"
            r9 = 100001(0x186a1, float:1.40131E-40)
            r7.<init>(r8, r9)     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
            throw r7     // Catch: java.lang.Exception -> L5a id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L7f
        L5a:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            if (r7 == 0) goto L71
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 <= 0) goto L6b
            goto L6c
        L6b:
            r0 = 0
        L6c:
            if (r0 != 0) goto L6f
            r7 = 0
        L6f:
            if (r7 != 0) goto L73
        L71:
            java.lang.String r7 = "Unknown Error"
        L73:
            id.dana.lib.bio.faceauth.exception.DanaBioException$FaceAuthenticationException r8 = new id.dana.lib.bio.faceauth.exception.DanaBioException$FaceAuthenticationException
            r9 = 999999(0xf423f, float:1.401297E-39)
            r8.<init>(r7, r9)
            r10.onFailed(r8)
            return
        L7f:
            r7 = move-exception
            r10.onFailed(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.bio.faceauth.DefaultFaceAuthentication.MyBillsEntityDataFactory(android.content.Context, java.lang.String, java.util.Map, id.dana.lib.bio.faceauth.FaceAuthenticationCallback):void");
    }

    public static void PlaceComponentResult(final String p0, Context p1, final String p2, final Function1<? super VIResult, Unit> p3, final Function1<? super DanaBioException.FaceAuthenticationException, Unit> p4) {
        VIEngine.startVerify(p1, RequestConstants.VerifyProductVerify, MapsKt.mapOf(TuplesKt.to("verifyId", p2), TuplesKt.to("verifyType", "1")), null, new VIEngine.VIListener() { // from class: id.dana.lib.bio.faceauth.DefaultFaceAuthentication$startVerify$1
            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
            public final void onVerifyAction(VIAction p02) {
            }

            @Override // com.alipay.mobile.verifyidentity.framework.engine.VIEngine.VIListener
            public final void onVerifyResult(VIResult p02) {
                if (p02 != null) {
                    if (Intrinsics.areEqual(p0, "FACE_ENROLLMENT")) {
                        p3.invoke(p02);
                    } else if (Intrinsics.areEqual(p0, "FACE_AUTHENTICATION") && !StringsKt.contains((CharSequence) p2, (CharSequence) "componentVerify", true)) {
                        p3.invoke(p02);
                    } else {
                        p4.invoke(new DanaBioException.FaceAuthenticationException("Face auth verify result security id contains componentVerify", 200003));
                    }
                } else if (Intrinsics.areEqual(p0, "FACE_ENROLLMENT")) {
                    p4.invoke(new DanaBioException.FaceAuthenticationException("Face enroll verify result is empty", 100006));
                } else {
                    p4.invoke(new DanaBioException.FaceAuthenticationException("Face auth verify result is empty", 200002));
                }
            }
        }, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0035, code lost:
    
        if (r4 == null) goto L38;
     */
    @Override // id.dana.lib.bio.faceauth.FaceAuthentication
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(android.content.Context r4, java.lang.String r5, final id.dana.lib.bio.faceauth.FaceAuthenticationCallback r6) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$verifyFaceAuth$onError$1 r0 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$verifyFaceAuth$onError$1     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            r0.<init>()     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            id.dana.lib.bio.faceauth.DefaultFaceAuthentication$verifyFaceAuth$verifyResult$1 r1 = new id.dana.lib.bio.faceauth.DefaultFaceAuthentication$verifyFaceAuth$verifyResult$1     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            r1.<init>()     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            java.lang.String r2 = "FACE_AUTHENTICATION"
            PlaceComponentResult(r2, r4, r5, r1, r0)     // Catch: java.lang.Exception -> L1f id.dana.lib.bio.faceauth.exception.DanaBioException.FaceAuthenticationException -> L45
            return
        L1f:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            if (r4 == 0) goto L37
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L31
            r5 = 1
            goto L32
        L31:
            r5 = 0
        L32:
            if (r5 != 0) goto L35
            r4 = 0
        L35:
            if (r4 != 0) goto L39
        L37:
            java.lang.String r4 = "Unknown Error"
        L39:
            id.dana.lib.bio.faceauth.exception.DanaBioException$FaceAuthenticationException r5 = new id.dana.lib.bio.faceauth.exception.DanaBioException$FaceAuthenticationException
            r0 = 999999(0xf423f, float:1.401297E-39)
            r5.<init>(r4, r0)
            r6.onFailed(r5)
            return
        L45:
            r4 = move-exception
            r6.onFailed(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.bio.faceauth.DefaultFaceAuthentication.PlaceComponentResult(android.content.Context, java.lang.String, id.dana.lib.bio.faceauth.FaceAuthenticationCallback):void");
    }

    private static void MyBillsEntityDataFactory(VIResult p0, Function0<Unit> p1, Function1<? super DanaBioException.FaceAuthenticationException, Unit> p2) {
        int result = p0.getResult();
        if (result == 1001) {
            p2.invoke(new DanaBioException.FaceAuthenticationException("Failed", 1001));
        } else if (result == 3000) {
            p2.invoke(new DanaBioException.FaceAuthenticationException("Account Lock", 3000));
        } else if (result == 2005) {
            p2.invoke(new DanaBioException.FaceAuthenticationException("Verify need outer", 2005));
        } else if (result != 2006) {
            switch (result) {
                case 1003:
                    p1.invoke();
                    return;
                case 1004:
                    p2.invoke(new DanaBioException.FaceAuthenticationException("Force Close", 1004));
                    return;
                case 1005:
                    p2.invoke(new DanaBioException.FaceAuthenticationException("Timeout", 1005));
                    return;
                case 1006:
                    p2.invoke(new DanaBioException.FaceAuthenticationException("Invalid Params", 1006));
                    return;
                case 1007:
                    p2.invoke(new DanaBioException.FaceAuthenticationException("Next Step Exit", 1007));
                    return;
                case 1008:
                    p2.invoke(new DanaBioException.FaceAuthenticationException("No Product", 1008));
                    return;
                default:
                    switch (result) {
                        case 2000:
                            p2.invoke(new DanaBioException.FaceAuthenticationException("Vid Empty", 2000));
                            return;
                        case 2001:
                            p2.invoke(new DanaBioException.FaceAuthenticationException("Container Empty", 2001));
                            return;
                        case 2002:
                            p2.invoke(new DanaBioException.FaceAuthenticationException("Module Data Empty", 2002));
                            return;
                        case 2003:
                            p2.invoke(new DanaBioException.FaceAuthenticationException("Invalid verify type", 2003));
                            return;
                        default:
                            p2.invoke(new DanaBioException.FaceAuthenticationException(PersonalPresenter.UNKNOWN_ERROR, p0.getResult()));
                            return;
                    }
            }
        } else {
            p2.invoke(new DanaBioException.FaceAuthenticationException("Verify fail", 2006));
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(VIResult vIResult, Function0 function0, Function1 function1, Function1 function12) {
        if (vIResult.getResult() == 1000) {
            String message = vIResult.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "");
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) "busy", false, 2, (Object) null)) {
                function12.invoke(new DanaBioException.FaceAuthenticationException("Face auth is system busy", 200004));
                return;
            }
            String verifyId = vIResult.getVerifyId();
            Intrinsics.checkNotNullExpressionValue(verifyId, "");
            function1.invoke(verifyId);
            return;
        }
        MyBillsEntityDataFactory(vIResult, function0, function12);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(VIResult vIResult, Function0 function0, Function1 function1, Function1 function12) {
        if (vIResult.getResult() == 1000) {
            String verifyId = vIResult.getVerifyId();
            Intrinsics.checkNotNullExpressionValue(verifyId, "");
            if (!(verifyId.length() == 0)) {
                String verifyId2 = vIResult.getVerifyId();
                Intrinsics.checkNotNullExpressionValue(verifyId2, "");
                if (!StringsKt.isBlank(verifyId2)) {
                    String verifyId3 = vIResult.getVerifyId();
                    Intrinsics.checkNotNullExpressionValue(verifyId3, "");
                    function1.invoke(verifyId3);
                    return;
                }
            }
            function12.invoke(new DanaBioException.FaceAuthenticationException("Face enroll verify id is empty", 100005));
            return;
        }
        MyBillsEntityDataFactory(vIResult, function0, function12);
    }
}
