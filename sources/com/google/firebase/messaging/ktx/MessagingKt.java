package com.google.firebase.messaging.ktx;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u001b\b\u0004\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\r*\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"", LoginTrackingConstants.LoginParam.TO, "Lkotlin/Function1;", "Lcom/google/firebase/messaging/RemoteMessage$Builder;", "", "Lkotlin/ExtensionFunctionType;", IAPSyncCommand.COMMAND_INIT, "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/google/firebase/messaging/RemoteMessage;", "LIBRARY_NAME", "Ljava/lang/String;", "Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/messaging/FirebaseMessaging;", "getMessaging", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/messaging/FirebaseMessaging;", "messaging"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class MessagingKt {
    public static final String LIBRARY_NAME = "fire-fcm-ktx";

    @JvmName(name = "getMessaging")
    public static final FirebaseMessaging getMessaging(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseMessaging, "");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(String str, Function1<? super RemoteMessage.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(str);
        function1.invoke(builder);
        RemoteMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return build;
    }
}
