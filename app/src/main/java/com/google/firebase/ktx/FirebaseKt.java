package com.google.firebase.ktx;

import android.content.Context;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\f\u001a)\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u000b\u001a\u00020\n*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/google/firebase/ktx/Firebase;", "", "name", "Lcom/google/firebase/FirebaseApp;", GriverOnPreloadExtension.PARAMS_APP, "(Lcom/google/firebase/ktx/Firebase;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "Landroid/content/Context;", HummerConstants.CONTEXT, "initialize", "(Lcom/google/firebase/ktx/Firebase;Landroid/content/Context;)Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/FirebaseOptions;", SecurityConstants.KEY_OPTIONS, "(Lcom/google/firebase/ktx/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;)Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/ktx/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "LIBRARY_NAME", "Ljava/lang/String;", "getApp", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseApp;", "getOptions", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseOptions;"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class FirebaseKt {
    public static final String LIBRARY_NAME = "fire-core-ktx";

    @JvmName(name = "getApp")
    public static final FirebaseApp getApp(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "");
        return firebaseApp;
    }

    public static final FirebaseApp app(Firebase firebase2, String str) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        Intrinsics.checkNotNullParameter(str, "");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(str);
        Intrinsics.checkNotNullExpressionValue(firebaseApp, "");
        return firebaseApp;
    }

    public static final FirebaseApp initialize(Firebase firebase2, Context context) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        Intrinsics.checkNotNullParameter(context, "");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase2, Context context, FirebaseOptions firebaseOptions) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(firebaseOptions, "");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase2, Context context, FirebaseOptions firebaseOptions, String str) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(firebaseOptions, "");
        Intrinsics.checkNotNullParameter(str, "");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "");
        return initializeApp;
    }

    @JvmName(name = "getOptions")
    public static final FirebaseOptions getOptions(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        Intrinsics.checkNotNullExpressionValue(options, "");
        return options;
    }
}
