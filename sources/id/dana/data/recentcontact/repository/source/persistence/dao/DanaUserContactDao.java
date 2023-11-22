package id.dana.data.recentcontact.repository.source.persistence.dao;

import id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity;
import java.util.List;

/* loaded from: classes4.dex */
public interface DanaUserContactDao {
    DanaUserContactEntity getDanaUserContactEntity(String str);

    List<String> getDanaUserPhoneNumber();

    Long insertDanaUserContact(DanaUserContactEntity danaUserContactEntity);

    int updateDanaUserContact(DanaUserContactEntity danaUserContactEntity);
}
