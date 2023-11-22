package com.iap.ac.config.lite.d;

import android.text.TextUtils;
import com.iap.ac.config.lite.ConfigMerger;
import com.iap.ac.config.lite.listener.ConfigChangeType;
import com.iap.ac.config.lite.listener.sectionconfig.ChangedDetails;
import java.util.Set;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final ChangedDetails f7629a = new ChangedDetails();
    public String b;
    public boolean c;

    public a(String str) {
        this.b = str;
        this.c = !ConfigMerger.isCommonConfigSection(str);
    }

    public boolean a(ConfigChangeType configChangeType, String str) {
        Set<String> set;
        if (configChangeType == ConfigChangeType.ADDED) {
            set = this.f7629a.addedKeys;
        } else if (configChangeType == ConfigChangeType.MODIFIED) {
            set = this.f7629a.modifiedKeys;
        } else {
            set = configChangeType == ConfigChangeType.DELETED ? this.f7629a.deletedKeys : null;
        }
        if (set == null || set.contains(str)) {
            return false;
        }
        set.add(str);
        return true;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.b, str);
    }
}
