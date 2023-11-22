package com.alibaba.ariver.permission.openauth.model.result;

import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class AuthSkipResultModel {
    private List<String> alreadyAuthedScopeNicks;
    private AuthContentResultModel authContentResult;
    private AuthExecuteResultModel authExecuteResult;
    private Boolean canSkipAuth;
    private byte[] data;
    private String errorCode;
    private String errorMsg;
    private H5AuthParamsModel h5AuthParams;
    private Boolean isSuccess;
    private List<String> requestScopeNicks;
    private Map<String, String> scopeTypeMap;
    private String showType;

    public final Boolean getSuccess() {
        return this.isSuccess;
    }

    public final void setSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public final Boolean getCanSkipAuth() {
        return this.canSkipAuth;
    }

    public final void setCanSkipAuth(Boolean bool) {
        this.canSkipAuth = bool;
    }

    public final AuthExecuteResultModel getAuthExecuteResult() {
        return this.authExecuteResult;
    }

    public final void setAuthExecuteResult(AuthExecuteResultModel authExecuteResultModel) {
        this.authExecuteResult = authExecuteResultModel;
    }

    public final AuthContentResultModel getAuthContentResult() {
        return this.authContentResult;
    }

    public final void setAuthContentResult(AuthContentResultModel authContentResultModel) {
        this.authContentResult = authContentResultModel;
    }

    public final String getShowType() {
        return this.showType;
    }

    public final void setShowType(String str) {
        this.showType = str;
    }

    public final H5AuthParamsModel getH5AuthParams() {
        return this.h5AuthParams;
    }

    public final void setH5AuthParams(H5AuthParamsModel h5AuthParamsModel) {
        this.h5AuthParams = h5AuthParamsModel;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final void setData(byte[] bArr) {
        this.data = bArr;
    }

    public final void setScopeTypeMap(Map<String, String> map) {
        this.scopeTypeMap = map;
    }

    public final void setRequestScopeNicks(List<String> list) {
        this.requestScopeNicks = list;
    }

    public final void setAlreadyAuthedScopeNicks(List<String> list) {
        this.alreadyAuthedScopeNicks = list;
    }

    public final Map<String, String> getScopeTypeMap() {
        return this.scopeTypeMap;
    }

    public final List<String> getRequestScopeNicks() {
        return this.requestScopeNicks;
    }

    public final List<String> getAlreadyAuthedScopeNicks() {
        return this.alreadyAuthedScopeNicks;
    }

    public final String getValidAccessToken() {
        if (getAuthExecuteResult() == null || getAuthExecuteResult().getExtInfo() == null) {
            return null;
        }
        return getAuthExecuteResult().getExtInfo().get("accessToken");
    }
}
