package com.alibaba.ariver.permission.api;

import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Permission;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public enum RVGroup implements Group {
    LEVEL_HIGH("level_high", "level_high"),
    LEVEL_ABOVE_MEDIUM("level_abovemedium", "level_abovemedium"),
    LEVEL_MEDIUM("level_medium", "level_medium"),
    LEVEL_LOW("level_low", "level_low"),
    LEVEL_NONE("level_none", "level_none"),
    LEVEL_APP_DEFAULT("level_app_default", "level_app_default"),
    LEVEL_EMPTY("level_empty", "level_empty");

    private String desc;
    private String level;
    private Map<String, Permission> permissions;

    RVGroup(String str, String str2) {
        this.level = str;
        this.desc = str2;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final String groupName() {
        return this.level;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final String description() {
        return this.desc;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final void assignPermissions(Map<String, ? extends Permission> map) {
        if (this.permissions == null) {
            this.permissions = new HashMap();
        }
        this.permissions.putAll(map);
    }

    public final void clearPermissions() {
        Map<String, Permission> map = this.permissions;
        if (map != null) {
            map.clear();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.security.Group
    public final Map<String, ? extends Permission> permissions() {
        return this.permissions;
    }
}
