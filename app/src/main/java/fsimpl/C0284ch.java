package fsimpl;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.myprofile.SubtitleType;

/* renamed from: fsimpl.ch  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284ch {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f7908a = {"NONE", "TEXT", SubtitleType.EMAIL, "URL", "PASSWORD", "DATETIME", SecurityConstants.KEY_DISPLAY_TYPE_NUMBER, "TEL"};

    public static String a(int i) {
        return f7908a[i];
    }
}
