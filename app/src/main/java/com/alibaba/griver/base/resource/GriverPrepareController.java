package com.alibaba.griver.base.resource;

import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepCreator;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.griver.api.common.config.GriverAppConfig;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.constants.GriverErrors;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.base.R;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.MonitorUtils;
import com.alibaba.griver.base.resource.interceptor.GriverPrepareInterceptor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GriverPrepareController extends BasePrepareController {
    public static final String BIZ_APP_CONTROLLER = "GriverMsg_App_Controller";
    public static final int SERVER_MSG_FINISH = 1;
    public static final int SERVER_MSG_RELOAD = 0;
    public static final long STATUS_FINAL_LOAD_FAILED = 0;
    public static final long STATUS_FINAL_LOAD_SUCCESS = 1;

    /* renamed from: a */
    private PrepareException f6344a;
    private int b = 0;
    private boolean c = true;
    private GriverStageMonitor d;

    public GriverPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        prepareContext.setTimeout(GriverAppConfig.getInstance().getExpireTime() * 1000);
        bindContext(prepareContext, prepareCallback);
        GriverStageMonitorManager griverStageMonitorManager = GriverStageMonitorManager.getInstance();
        String appId = prepareContext.getAppId();
        StringBuilder sb = new StringBuilder();
        sb.append(prepareContext.getStartToken());
        this.d = griverStageMonitorManager.getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(appId, sb.toString()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GriverPrepareInterceptor());
        setInterceptors(arrayList);
        ClientMsgReceiver clientMsgReceiver = ClientMsgReceiver.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prepareContext.getStartToken());
        sb2.append(BIZ_APP_CONTROLLER);
        clientMsgReceiver.registerBizHandler(sb2.toString(), new IpcMessageHandler() { // from class: com.alibaba.griver.base.resource.GriverPrepareController.1
            {
                GriverPrepareController.this = this;
            }

            @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
            public void handleMessage(IpcMessage ipcMessage) {
                int i = ipcMessage.bizMsg.what;
                if (i == 0) {
                    GriverPrepareController.this.reload();
                } else if (i == 1) {
                    GriverPrepareController.this.finish();
                }
            }
        });
        GriverStageMonitor griverStageMonitor = this.d;
        if (griverStageMonitor != null) {
            griverStageMonitor.addParam(GriverMonitorConstants.KEY_RELOAD_COUNT, Integer.valueOf(this.b));
            this.d.addParam(GriverMonitorConstants.KEY_FINAL_LOAD_STATUS, 1L);
        }
    }

    public void reload() {
        if (this.f6344a != null) {
            this.f6344a = null;
            GriverStageMonitor griverStageMonitor = this.d;
            if (griverStageMonitor != null) {
                int i = this.b + 1;
                this.b = i;
                griverStageMonitor.addParam(GriverMonitorConstants.KEY_RELOAD_COUNT, Integer.valueOf(i));
                this.d.addParam(GriverMonitorConstants.KEY_FINAL_LOAD_STATUS, 1L);
            }
            b();
            this.status = PrepareController.Status.INIT;
            moveToNext();
        }
    }

    private void a() {
        this.steps.clear();
    }

    private StepCreator b() {
        StepCreator generateStepCreator = generateStepCreator();
        this.steps.add(generateStepCreator.createStep(StepType.SETUP));
        this.steps.add(generateStepCreator.createStep(StepType.UPDATE));
        this.steps.add(generateStepCreator.createStep(StepType.OFFLINE));
        this.steps.add(generateStepCreator.createStep(StepType.START));
        return generateStepCreator;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.griver.base.resource.BasePrepareController, com.alibaba.ariver.resource.api.prepare.PrepareController
    public void moveToError(PrepareException prepareException) {
        char c;
        a();
        String code = prepareException.getCode();
        code.hashCode();
        switch (code.hashCode()) {
            case 48:
                if (code.equals("0")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 49:
                if (code.equals("1")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 50:
                if (code.equals("2")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 51:
                if (code.equals("3")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 52:
                if (code.equals("4")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 53:
                if (code.equals("5")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 54:
                if (code.equals("6")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                prepareException = new PrepareException("10000", GriverEnv.getResources().getString(R.string.griver_prepare_unknown_error));
                break;
            case 1:
            case 6:
                prepareException = new PrepareException("10001", GriverEnv.getResources().getString(R.string.griver_app_id_exception));
                break;
            case 2:
                prepareException = new PrepareException("10003", GriverEnv.getResources().getString(R.string.griver_prepare_no_app_info));
                break;
            case 3:
                prepareException = new PrepareException(GriverErrors.ERROR_PREPARE_TIMEOUT, GriverEnv.getResources().getString(R.string.griver_prepare_timeout));
                break;
            case 4:
                prepareException = new PrepareException(GriverErrors.ERROR_DOWNLOAD_FAILED, GriverEnv.getResources().getString(R.string.griver_prepare_download_failed));
                break;
            case 5:
                prepareException = new PrepareException("10002", GriverEnv.getResources().getString(R.string.griver_prepare_unzip_failed));
                break;
        }
        super.moveToError(prepareException);
        GriverStageMonitor griverStageMonitor = this.d;
        if (griverStageMonitor != null) {
            griverStageMonitor.addParam(GriverMonitorConstants.KEY_FINAL_LOAD_STATUS, 0L);
        }
        this.f6344a = prepareException;
        if (this.c) {
            GriverStageMonitor griverStageMonitor2 = this.d;
            if (griverStageMonitor2 != null) {
                griverStageMonitor2.transitToError(prepareException.getCode());
            }
            this.c = false;
        }
        if (this.callback != null) {
            this.callback.prepareFail(this.context.getPrepareData(), prepareException);
        }
        saveRecords(prepareException);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void saveRecords(PrepareException prepareException) {
        char c;
        String code = prepareException.getCode();
        code.hashCode();
        switch (code.hashCode()) {
            case 1507424:
                if (code.equals("1001")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1507425:
                if (code.equals("1002")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 46730162:
                if (code.equals("10001")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 46730163:
                if (code.equals("10002")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 46730164:
                if (code.equals("10003")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 46730167:
                if (code.equals(GriverErrors.ERROR_VERIFY_APP)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 46730170:
                if (code.equals(GriverErrors.ERROR_DOWNLOAD_FAILED)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 46730192:
                if (code.equals(GriverErrors.ERROR_PREPARE_TIMEOUT)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 46730196:
                if (code.equals(GriverErrors.ERROR_APP_PACKAGE_URL_EMPTY)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 46730197:
                if (code.equals(GriverErrors.ERROR_APP_EMBEDDED_URL_EMPTY)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 46730254:
                if (code.equals(GriverErrors.ERROR_DYNAMIC_RESOURCE_LOAD_FAILED)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_REMOVED_CODE).append("appId", this.context.getAppId()).build());
                return;
            case 1:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_APP_SUSPENDED).append("appId", this.context.getAppId()).build());
                return;
            case 2:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_APPID_EXCEPTION).append("appId", this.context.getAppId()).build());
                return;
            case 3:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder("204").append("appId", this.context.getAppId()).build());
                return;
            case 4:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_NO_APP_INFO).append("appId", this.context.getAppId()).append(RecordError.KEY_NETWORK_ERRCODE, prepareException.getCode()).append(RecordError.KEY_NETWORK_ERRMSG, prepareException.getMessage()).build());
                return;
            case 5:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_VERIFY_APP).append("appId", this.context.getAppId()).build());
                return;
            case 6:
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_DOWNLOAD_FAILED).append("appId", this.context.getAppId()).append(RecordError.KEY_NETWORK_ERRCODE, prepareException.getCode()).append(RecordError.KEY_NETWORK_ERRMSG, prepareException.getMessage()).build());
                return;
            case 7:
            case '\n':
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_PREPARE_TIMEOUT).append("appId", this.context.getAppId()).build());
                return;
            case '\b':
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_APP_PACKAGE_URL_EMPTY).append("appId", this.context.getAppId()).build());
                return;
            case '\t':
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_APP_EMBEDDED_URL_EMPTY).append("appId", this.context.getAppId()).build());
                return;
            default:
                return;
        }
    }

    @Override // com.alibaba.griver.base.resource.BasePrepareController, com.alibaba.ariver.resource.api.prepare.PrepareController
    public void finish() {
        super.finish();
        ClientMsgReceiver clientMsgReceiver = ClientMsgReceiver.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(this.context.getStartToken());
        sb.append(BIZ_APP_CONTROLLER);
        clientMsgReceiver.unRegisterBizHandler(sb.toString());
        if (this.f6344a != null) {
            GriverMonitor.error(GriverMonitorConstants.ERROR_PREPARE_APP_EXCEPTION, "GriverAppContainer", new MonitorMap.Builder().appId(this.context.getAppId()).version(this.context.getAppModel()).exception(this.f6344a).message(GriverMonitorConstants.MESSAGE_PREPARE_APP_ERROR).code(this.f6344a.getCode()).needAsynAppType(true).build());
        }
        GriverMonitor.event(GriverMonitorConstants.EVENT_START_APP, "GriverAppContainer", new MonitorMap.Builder().appId(this.context.getAppId()).version(this.context.getAppModel()).url(BundleUtils.getString(this.context.getStartParams(), "url")).needAsynAppType(true).append("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(this.context.getStartParams())).build());
    }
}
