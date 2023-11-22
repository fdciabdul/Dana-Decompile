package id.dana.data.errorconfig;

import id.dana.data.model.ErrorConfigAmcsResult;

/* loaded from: classes2.dex */
public interface ErrorConfigEntityData {
    ErrorConfigAmcsResult getErrorConfigAmcs();

    String getErrorMessageByKey(String str, ErrorConfigAmcsResult errorConfigAmcsResult);
}
