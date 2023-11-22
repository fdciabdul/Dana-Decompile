package id.dana.domain.services.model;

import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public class ThirdPartyCategoryService {
    private CategoryServicesModel categoryServicesModel;
    private String key;
    private List<ThirdPartyServiceResponse> thirdPartyServices;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public List<ThirdPartyServiceResponse> getThirdPartyServices() {
        return this.thirdPartyServices;
    }

    public void setThirdPartyServices(List<ThirdPartyServiceResponse> list) {
        this.thirdPartyServices = list;
    }

    public CategoryServicesModel getCategoryServicesModel() {
        return this.categoryServicesModel;
    }

    public void setCategoryServicesModel(CategoryServicesModel categoryServicesModel) {
        this.categoryServicesModel = categoryServicesModel;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThirdPartyCategoryService{key='");
        sb.append(this.key);
        sb.append('\'');
        sb.append(", thirdPartyServices=");
        sb.append(this.thirdPartyServices);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThirdPartyCategoryService thirdPartyCategoryService = (ThirdPartyCategoryService) obj;
        return Objects.equals(this.key, thirdPartyCategoryService.key) && Objects.equals(this.categoryServicesModel, thirdPartyCategoryService.categoryServicesModel) && Objects.equals(this.thirdPartyServices, thirdPartyCategoryService.thirdPartyServices);
    }

    public int hashCode() {
        return Objects.hash(this.key, this.categoryServicesModel, this.thirdPartyServices);
    }
}
