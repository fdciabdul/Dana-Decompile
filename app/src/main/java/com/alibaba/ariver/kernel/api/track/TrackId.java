package com.alibaba.ariver.kernel.api.track;

/* loaded from: classes6.dex */
public class TrackId {
    public static final String ATTR_HIGHEST_VERSION = "highestVer";
    public static final String ATTR_MAIN_DOC_SIZE = "mainDocSize";
    public static final String ATTR_START_WITH_SUBPACKAGE = "startWithSubpackage";
    public static final String Attr_isPreCreatePage = "isPreCreatePage";
    public static final String Cost_CCDN_Prepare = "ccdn_prepare_cost";
    public static final String Cost_NXView_Create = "NXViewCreate";
    public static final String Cost_ProcessPipelineWait = "ProcessPipelineWait";
    public static final String Cost_Resource_Download = "res_dl_cost";
    public static final String Cost_Resource_Rpc = "res_rpc_cost";
    public static final String Cost_Resource_Setup = "res_setup_cost";
    public static final String Cost_Resource_UnZip = "res_zip_cost";
    public static final String ERROR_APPX_ERROR = "appxError";
    public static final String ERROR_INTERCEPT_LOAD_URL = "pageUnauthorized";
    public static final String ERROR_JSAPI_CALL = "jsapiError";
    public static final String ERROR_JS_ERROR = "jsError";
    public static final String ERROR_NETWORK_ERROR = "networkError";
    public static final String ERROR_NETWORK_UNFINISH = "networkUnfinish";
    public static final String ERROR_PAGE_FAIL = "pageFailed";
    public static final String ERROR_WHITE_SCREEN = "whiteScreen";
    public static final String Error_AppxNgDegrade = "AppxNgDegrade";
    public static final String Error_CreateFromRecover = "CreateFromRecover";
    public static final String Error_EngineInitFail = "EngineInitFail";
    public static final String Error_LoadingError = "LoadingError";
    public static final String Error_Resource_DownloadFail = "ResDownloadFail";
    public static final String Error_Resource_FallBackFail = "ResFallBackFail";
    public static final String Error_Resource_PrepareFail = "ResPrepareFail";
    public static final String Error_Resource_SQLFail = "ResSQLFail";
    public static final String Error_Resource_SubPackageFail = "ResSubPackageFail";
    public static final String Error_Resource_UnzipFail = "ResUnzipFail";
    public static final String Error_Resource_VerifyFail = "ResVerifyFail";
    public static final String Error_SceneParamReadException = "SceneParamReadException";
    public static final String Error_WebEngine = "WebEngineError";
    public static final String PREPARE_STEP_DYNAMIC_PLUGIN_DOWNLOAD = "prepareStepDynamicPluginDownload";
    public static final String PREPARE_STEP_DYNAMIC_PLUGIN_DOWNLOAD_COST = "prepareStepDynamicPluginDownloadCost";
    public static final String PREPARE_STEP_DYNAMIC_PLUGIN_RPC = "prepareStepDynamicPluginRpc";
    public static final String PREPARE_STEP_STATIC_PLUGIN_DOWNLOAD = "prepareStepStaticPluginDownload";
    public static final String Stub_API_CALL = "apicall";
    public static final String Stub_APP_DESTROY = "AppDestroy";
    public static final String Stub_Activity_AttachContext = "nbx_attachContext";
    public static final String Stub_Activity_OnCreated = "nbx_activityCreated";
    public static final String Stub_Activity_OnResume = "nbx_activityResume";
    public static final String Stub_AppInit = "AppInit";
    public static final String Stub_AppStart = "AppStart";
    public static final String Stub_AvailableTime = "AvailableTime";
    public static final String Stub_BACK_PRESSED = "BackBtn";
    public static final String Stub_CCDN_PREPARE_END = "ccdnPrePareEnd";
    public static final String Stub_CCDN_PREPARE_FAIL = "ccdnPrePareFail";
    public static final String Stub_CCDN_PREPARE_START = "ccdnPrePareStart";
    public static final String Stub_CLOSE_PRESSED = "CloseBtn";
    public static final String Stub_DomReady = "DomReady";
    public static final String Stub_EngineInit = "EngineInit";
    public static final String Stub_EngineSetup = "EngineSetup";
    public static final String Stub_EngineSetupStart = "EngineSetupStart";
    public static final String Stub_Engine_FirstElement = "FirstElement";
    public static final String Stub_Engine_FirstScreen = "FirstScreen";
    public static final String Stub_FWAppCreate = "FWAppCreate";
    public static final String Stub_FWAppCreateSystemTime = "FWAppCreateSystemTime";
    public static final String Stub_FWAppStart = "FWAppStart";
    public static final String Stub_FirstByte = "FirstByte";
    public static final String Stub_FirstRequest = "FirstRequest";
    public static final String Stub_FirstRequestSend = "FirstRequestSend";
    public static final String Stub_FragmentOnViewCreated = "FragmentOnViewCreated";
    public static final String Stub_IPCReady = "nbx_IPCReady";
    public static final String Stub_JS_AppContextCreated = "js_appContextCreated";
    public static final String Stub_JS_AppLoaded = "js_appLoaded";
    public static final String Stub_JS_PageLoaded = "js_pageLoaded";
    public static final String Stub_JS_RenderFrameworkLoaded = "js_renderFrameworkLoaded";
    public static final String Stub_JS_RenderFrameworkLoadedCost = "js_renderFrameworkLoaded_cost";
    public static final String Stub_JS_RenderFrameworkStart = "js_renderFrameworkStart";
    public static final String Stub_JS_WorkerFrameworkLoaded = "js_workerFrameworkLoaded";
    public static final String Stub_JS_WorkerFrameworkLoadedCost = "js_workerFrameworkLoaded_cost";
    public static final String Stub_JS_WorkerFrameworkStart = "js_workerFrameworkStart";
    public static final String Stub_Legacy_openApp = "OpenApp";
    public static final String Stub_LoadMainResource_Begin = "LoadMainResourceBegin";
    public static final String Stub_LoadMainResource_End = "LoadMainResourceEnd";
    public static final String Stub_LoadUrl = "LoadUrl";
    public static final String Stub_LoadingEnd = "LoadingEnd";
    public static final String Stub_LoadingStart = "LoadingStart";
    public static final String Stub_NavigationStart = "NavigationStart";
    public static final String Stub_PAGE_DESTROY = "PageDestroy";
    public static final String Stub_PAGE_EXIT = "PageExit";
    public static final String Stub_PAGE_HIDE = "PageHide";
    public static final String Stub_PAGE_LOAD = "PageLoad";
    public static final String Stub_PageCreate = "PageCreate";
    public static final String Stub_PageCreated = "PageCreated";
    public static final String Stub_PageEnter = "PageStart";
    public static final String Stub_PageInit = "PageInit";
    public static final String Stub_PageLoad = "flt_pageEnd_h5Ready";
    public static final String Stub_PageShow = "PageShow";
    public static final String Stub_Page_Biz_Ready = "flt_pageEnd_bizReady";
    public static final String Stub_PkgLoad = "PkgLoad";
    public static final String Stub_PkgParse = "PkgParse";
    public static final String Stub_PrepareIPCFinish = "nbx_PrepareIPCFinish";
    public static final String Stub_Resource_Fallback = "ResFallback";
    public static final String Stub_Resource_MainDoc_Offline = "ResMainDocOffline";
    public static final String Stub_Resource_PrepareFinish = "PrepareFinish";
    public static final String Stub_Resource_PrepareStart = "PrepareStart";
    public static final String Stub_Resource_SubRes_Offline = "ResSubResOffline";
    public static final String Stub_Rpc_End = "RpcEnd";
    public static final String Stub_Rpc_Start = "RpcStart";
    public static final String Stub_SetupEnd = "SetupEnd";
    public static final String Stub_SetupStart = "SetupStart";
    public static final String Stub_StartNebulaActivity = "nbx_startNebulaActivity";
    public static final String Stub_UC_T1 = "UC_T1";
    public static final String Stub_UC_T2 = "UC_T2";
    public static final String Stub_USER_CLIENT_LEAVE_HINT = "ClientLeavehint";
    public static final String Stub_Use_Snapshot = "UseSnapShot";
    public static final String Stub_Visit = "VisitStart";
    public static final String Stub_WEB_PageFinish = "WEB_PageFinish";
    public static final String Stub_WEB_PageRender = "WEB_PageRender";
    public static final String Stub_WEB_PageStart = "WEB_PageStart";
}
