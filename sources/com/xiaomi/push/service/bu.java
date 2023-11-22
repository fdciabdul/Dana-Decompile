package com.xiaomi.push.service;

import com.xiaomi.push.cz;

/* loaded from: classes8.dex */
/* synthetic */ class bu {
    static final /* synthetic */ int[] getAuthRequestContext;

    static {
        int[] iArr = new int[cz.values().length];
        getAuthRequestContext = iArr;
        try {
            iArr[cz.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            getAuthRequestContext[cz.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            getAuthRequestContext[cz.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            getAuthRequestContext[cz.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            getAuthRequestContext[cz.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            getAuthRequestContext[cz.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            getAuthRequestContext[cz.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            getAuthRequestContext[cz.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            getAuthRequestContext[cz.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            getAuthRequestContext[cz.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
