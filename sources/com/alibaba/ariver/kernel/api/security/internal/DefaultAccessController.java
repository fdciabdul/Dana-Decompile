package com.alibaba.ariver.kernel.api.security.internal;

import com.alibaba.ariver.kernel.api.security.AccessControlException;
import com.alibaba.ariver.kernel.api.security.AccessControlManagement;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.kernel.api.security.Accessor;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.api.security.DefaultGroup;
import com.alibaba.ariver.kernel.api.security.Group;
import com.alibaba.ariver.kernel.api.security.Guard;
import com.alibaba.ariver.kernel.api.security.Inquirer;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class DefaultAccessController implements AccessController {

    /* renamed from: a  reason: collision with root package name */
    private AccessControlManagement f6106a;

    @Override // com.alibaba.ariver.kernel.api.security.AccessController
    public void setAccessControlManagement(AccessControlManagement accessControlManagement) {
        this.f6106a = accessControlManagement;
    }

    @Override // com.alibaba.ariver.kernel.api.security.AccessController
    public boolean check(Accessor accessor, List<? extends Guard> list, AccessController.ApplyCallback applyCallback) throws AccessControlException {
        String obj;
        Group group = accessor.getGroup();
        AccessControlManagement accessControlManagement = this.f6106a;
        boolean z = false;
        if (accessControlManagement != null && !accessControlManagement.needPermissionCheck(accessor, list)) {
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("not need check permission");
                sb.append(list.size());
                RVLogger.d("AriverKernel:Permission", sb.toString());
                for (Guard guard : list) {
                    if (guard != null && guard.permit() != null) {
                        z = this.f6106a.asyncInterceptJsapi(guard.permit(), accessor);
                    }
                }
            }
            return z;
        }
        AccessControlManagement accessControlManagement2 = this.f6106a;
        if (accessControlManagement2 != null) {
            group = accessControlManagement2.manageAccessorGroup(accessor);
        }
        ArrayList arrayList = new ArrayList();
        for (Guard guard2 : list) {
            Permission permit = guard2.permit();
            if (permit != null) {
                if (group == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("the ");
                    sb2.append(accessor);
                    sb2.append(" not in any group.");
                    throw new AccessControlException(sb2.toString());
                } else if (a(permit, group)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("access");
                    sb3.append(accessor.hashCode());
                    sb3.append(" has group permission [");
                    sb3.append(permit.authority());
                    sb3.append("] ,group is [");
                    sb3.append(group.groupName());
                    sb3.append("]");
                    RVLogger.d("AriverKernel:Permission", sb3.toString());
                } else {
                    ApiPermissionCheckResult permissionCheck = this.f6106a.permissionCheck(permit, accessor);
                    if (ApiPermissionCheckResult.IGNORE == permissionCheck || ApiPermissionCheckResult.ALLOW == permissionCheck) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("access");
                        sb4.append(accessor.hashCode());
                        sb4.append(" has single permission [");
                        sb4.append(permit.authority());
                        sb4.append("]");
                        RVLogger.d("AriverKernel:Permission", sb4.toString());
                        if (this.f6106a.asyncPermissionCheck(permit, accessor)) {
                            arrayList.add(permit);
                        }
                    } else {
                        AccessControlManagement accessControlManagement3 = this.f6106a;
                        if (accessControlManagement3 != null && accessControlManagement3.bizPermissionCheck(permit, accessor)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("access");
                            sb5.append(accessor.hashCode());
                            sb5.append(" has custom permission [");
                            sb5.append(permit.authority());
                            sb5.append("]");
                            RVLogger.d("AriverKernel:Permission", sb5.toString());
                        } else if (permit instanceof Inquirer) {
                            arrayList.add(permit);
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("access");
                            sb6.append(accessor.hashCode());
                            sb6.append(" no permission:");
                            sb6.append(permit.authority());
                            sb6.append(" when access ");
                            sb6.append(guard2);
                            RVLogger.d("AriverKernel:Permission", sb6.toString());
                            if (permissionCheck == null || !permissionCheck.hasSignature()) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(accessor);
                                sb7.append(" no permission:");
                                sb7.append(permit.authority());
                                sb7.append(" when access ");
                                sb7.append(guard2);
                                obj = sb7.toString();
                            } else {
                                obj = permissionCheck.getSignature();
                            }
                            throw new AccessControlException(obj);
                        }
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        a(accessor, arrayList, applyCallback);
        return true;
    }

    private boolean a(Permission permission, Group group) {
        if (group.groupName().equalsIgnoreCase(DefaultGroup.INTERNAL.groupName())) {
            return true;
        }
        Map<String, ? extends Permission> permissions = group.permissions();
        return permissions != null && permissions.containsKey(permission.authority());
    }

    private void a(Accessor accessor, List<Permission> list, final AccessController.ApplyCallback applyCallback) {
        accessor.inquiry(list, new Accessor.InquiryCallback() { // from class: com.alibaba.ariver.kernel.api.security.internal.DefaultAccessController.1
            @Override // com.alibaba.ariver.kernel.api.security.Accessor.InquiryCallback
            public void onComplete(List<? extends Permission> list2, List<? extends Permission> list3) {
                if (applyCallback != null) {
                    if (list3 != null && list3.size() >= 0) {
                        applyCallback.onFailure(list3);
                    } else {
                        applyCallback.onSuccess();
                    }
                }
            }
        });
    }
}
