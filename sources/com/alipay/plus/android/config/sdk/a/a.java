package com.alipay.plus.android.config.sdk.a;

import android.text.TextUtils;
import com.alipay.plus.android.config.sdk.ConfigMerger;
import com.alipay.plus.android.config.sdk.listener.ConfigChangeType;
import com.alipay.plus.android.config.sdk.listener.sectionconfig.ChangedDetails;
import java.util.Set;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f7360a;
    public boolean b;
    public final ChangedDetails c = new ChangedDetails();

    public a(String str) {
        this.f7360a = str;
        this.b = !ConfigMerger.isCommonConfigSection(str);
    }

    public boolean a(ConfigChangeType configChangeType, String str) {
        Set<String> set = configChangeType == ConfigChangeType.Added ? this.c.addedKeys : configChangeType == ConfigChangeType.Modified ? this.c.modifiedKeys : configChangeType == ConfigChangeType.Deleted ? this.c.deletedKeys : null;
        if (set == null || set.contains(str)) {
            return false;
        }
        set.add(str);
        return true;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.f7360a, str);
    }
}
