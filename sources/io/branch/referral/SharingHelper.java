package io.branch.referral;

import id.dana.richview.socialshare.AppPackageName;

/* loaded from: classes9.dex */
public class SharingHelper {

    /* loaded from: classes9.dex */
    public enum SHARE_WITH {
        FACEBOOK(AppPackageName.FACEBOOK),
        FACEBOOK_MESSENGER(AppPackageName.MESSENGER),
        TWITTER("com.twitter.android"),
        MESSAGE(".mms"),
        EMAIL("com.google.android.email"),
        FLICKR("com.yahoo.mobile.client.android.flickr"),
        GOOGLE_DOC("com.google.android.apps.docs"),
        WHATS_APP("com.whatsapp"),
        PINTEREST("com.pinterest"),
        HANGOUT("com.google.android.talk"),
        INSTAGRAM(AppPackageName.INSTAGRAM),
        WECHAT("jom.tencent.mm"),
        SNAPCHAT("com.snapchat.android"),
        GMAIL("com.google.android.gm");

        private String name;

        SHARE_WITH(String str) {
            this.name = str;
        }

        public final String getAppName() {
            return this.name;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.name;
        }
    }
}
