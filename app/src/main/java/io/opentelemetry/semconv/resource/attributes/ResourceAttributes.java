package io.opentelemetry.semconv.resource.attributes;

import io.opentelemetry.api.common.AttributeKey;
import java.util.List;

/* loaded from: classes.dex */
public final class ResourceAttributes {
    public static final String SCHEMA_URL = "https://opentelemetry.io/schemas/1.13.0";
    public static final AttributeKey<List<String>> BROWSER_BRANDS = AttributeKey.CC.stringArrayKey("browser.brands");
    public static final AttributeKey<String> BROWSER_PLATFORM = AttributeKey.CC.stringKey("browser.platform");
    public static final AttributeKey<String> BROWSER_USER_AGENT = AttributeKey.CC.stringKey("browser.user_agent");
    public static final AttributeKey<String> CLOUD_PROVIDER = AttributeKey.CC.stringKey("cloud.provider");
    public static final AttributeKey<String> CLOUD_ACCOUNT_ID = AttributeKey.CC.stringKey("cloud.account.id");
    public static final AttributeKey<String> CLOUD_REGION = AttributeKey.CC.stringKey("cloud.region");
    public static final AttributeKey<String> CLOUD_AVAILABILITY_ZONE = AttributeKey.CC.stringKey("cloud.availability_zone");
    public static final AttributeKey<String> CLOUD_PLATFORM = AttributeKey.CC.stringKey("cloud.platform");
    public static final AttributeKey<String> AWS_ECS_CONTAINER_ARN = AttributeKey.CC.stringKey("aws.ecs.container.arn");
    public static final AttributeKey<String> AWS_ECS_CLUSTER_ARN = AttributeKey.CC.stringKey("aws.ecs.cluster.arn");
    public static final AttributeKey<String> AWS_ECS_LAUNCHTYPE = AttributeKey.CC.stringKey("aws.ecs.launchtype");
    public static final AttributeKey<String> AWS_ECS_TASK_ARN = AttributeKey.CC.stringKey("aws.ecs.task.arn");
    public static final AttributeKey<String> AWS_ECS_TASK_FAMILY = AttributeKey.CC.stringKey("aws.ecs.task.family");
    public static final AttributeKey<String> AWS_ECS_TASK_REVISION = AttributeKey.CC.stringKey("aws.ecs.task.revision");
    public static final AttributeKey<String> AWS_EKS_CLUSTER_ARN = AttributeKey.CC.stringKey("aws.eks.cluster.arn");
    public static final AttributeKey<List<String>> AWS_LOG_GROUP_NAMES = AttributeKey.CC.stringArrayKey("aws.log.group.names");
    public static final AttributeKey<List<String>> AWS_LOG_GROUP_ARNS = AttributeKey.CC.stringArrayKey("aws.log.group.arns");
    public static final AttributeKey<List<String>> AWS_LOG_STREAM_NAMES = AttributeKey.CC.stringArrayKey("aws.log.stream.names");
    public static final AttributeKey<List<String>> AWS_LOG_STREAM_ARNS = AttributeKey.CC.stringArrayKey("aws.log.stream.arns");
    public static final AttributeKey<String> CONTAINER_NAME = AttributeKey.CC.stringKey("container.name");
    public static final AttributeKey<String> CONTAINER_ID = AttributeKey.CC.stringKey("container.id");
    public static final AttributeKey<String> CONTAINER_RUNTIME = AttributeKey.CC.stringKey("container.runtime");
    public static final AttributeKey<String> CONTAINER_IMAGE_NAME = AttributeKey.CC.stringKey("container.image.name");
    public static final AttributeKey<String> CONTAINER_IMAGE_TAG = AttributeKey.CC.stringKey("container.image.tag");
    public static final AttributeKey<String> DEPLOYMENT_ENVIRONMENT = AttributeKey.CC.stringKey("deployment.environment");
    public static final AttributeKey<String> DEVICE_ID = AttributeKey.CC.stringKey("device.id");
    public static final AttributeKey<String> DEVICE_MODEL_IDENTIFIER = AttributeKey.CC.stringKey("device.model.identifier");
    public static final AttributeKey<String> DEVICE_MODEL_NAME = AttributeKey.CC.stringKey("device.model.name");
    public static final AttributeKey<String> DEVICE_MANUFACTURER = AttributeKey.CC.stringKey("device.manufacturer");
    public static final AttributeKey<String> FAAS_NAME = AttributeKey.CC.stringKey("faas.name");
    public static final AttributeKey<String> FAAS_ID = AttributeKey.CC.stringKey("faas.id");
    public static final AttributeKey<String> FAAS_VERSION = AttributeKey.CC.stringKey("faas.version");
    public static final AttributeKey<String> FAAS_INSTANCE = AttributeKey.CC.stringKey("faas.instance");
    public static final AttributeKey<Long> FAAS_MAX_MEMORY = AttributeKey.CC.longKey("faas.max_memory");
    public static final AttributeKey<String> HOST_ID = AttributeKey.CC.stringKey("host.id");
    public static final AttributeKey<String> HOST_NAME = AttributeKey.CC.stringKey("host.name");
    public static final AttributeKey<String> HOST_TYPE = AttributeKey.CC.stringKey("host.type");
    public static final AttributeKey<String> HOST_ARCH = AttributeKey.CC.stringKey("host.arch");
    public static final AttributeKey<String> HOST_IMAGE_NAME = AttributeKey.CC.stringKey("host.image.name");
    public static final AttributeKey<String> HOST_IMAGE_ID = AttributeKey.CC.stringKey("host.image.id");
    public static final AttributeKey<String> HOST_IMAGE_VERSION = AttributeKey.CC.stringKey("host.image.version");
    public static final AttributeKey<String> K8S_CLUSTER_NAME = AttributeKey.CC.stringKey("k8s.cluster.name");
    public static final AttributeKey<String> K8S_NODE_NAME = AttributeKey.CC.stringKey("k8s.node.name");
    public static final AttributeKey<String> K8S_NODE_UID = AttributeKey.CC.stringKey("k8s.node.uid");
    public static final AttributeKey<String> K8S_NAMESPACE_NAME = AttributeKey.CC.stringKey("k8s.namespace.name");
    public static final AttributeKey<String> K8S_POD_UID = AttributeKey.CC.stringKey("k8s.pod.uid");
    public static final AttributeKey<String> K8S_POD_NAME = AttributeKey.CC.stringKey("k8s.pod.name");
    public static final AttributeKey<String> K8S_CONTAINER_NAME = AttributeKey.CC.stringKey("k8s.container.name");
    public static final AttributeKey<Long> K8S_CONTAINER_RESTART_COUNT = AttributeKey.CC.longKey("k8s.container.restart_count");
    public static final AttributeKey<String> K8S_REPLICASET_UID = AttributeKey.CC.stringKey("k8s.replicaset.uid");
    public static final AttributeKey<String> K8S_REPLICASET_NAME = AttributeKey.CC.stringKey("k8s.replicaset.name");
    public static final AttributeKey<String> K8S_DEPLOYMENT_UID = AttributeKey.CC.stringKey("k8s.deployment.uid");
    public static final AttributeKey<String> K8S_DEPLOYMENT_NAME = AttributeKey.CC.stringKey("k8s.deployment.name");
    public static final AttributeKey<String> K8S_STATEFULSET_UID = AttributeKey.CC.stringKey("k8s.statefulset.uid");
    public static final AttributeKey<String> K8S_STATEFULSET_NAME = AttributeKey.CC.stringKey("k8s.statefulset.name");
    public static final AttributeKey<String> K8S_DAEMONSET_UID = AttributeKey.CC.stringKey("k8s.daemonset.uid");
    public static final AttributeKey<String> K8S_DAEMONSET_NAME = AttributeKey.CC.stringKey("k8s.daemonset.name");
    public static final AttributeKey<String> K8S_JOB_UID = AttributeKey.CC.stringKey("k8s.job.uid");
    public static final AttributeKey<String> K8S_JOB_NAME = AttributeKey.CC.stringKey("k8s.job.name");
    public static final AttributeKey<String> K8S_CRONJOB_UID = AttributeKey.CC.stringKey("k8s.cronjob.uid");
    public static final AttributeKey<String> K8S_CRONJOB_NAME = AttributeKey.CC.stringKey("k8s.cronjob.name");
    public static final AttributeKey<String> OS_TYPE = AttributeKey.CC.stringKey("os.type");
    public static final AttributeKey<String> OS_DESCRIPTION = AttributeKey.CC.stringKey("os.description");
    public static final AttributeKey<String> OS_NAME = AttributeKey.CC.stringKey("os.name");
    public static final AttributeKey<String> OS_VERSION = AttributeKey.CC.stringKey("os.version");
    public static final AttributeKey<Long> PROCESS_PID = AttributeKey.CC.longKey("process.pid");
    public static final AttributeKey<Long> PROCESS_PARENT_PID = AttributeKey.CC.longKey("process.parent_pid");
    public static final AttributeKey<String> PROCESS_EXECUTABLE_NAME = AttributeKey.CC.stringKey("process.executable.name");
    public static final AttributeKey<String> PROCESS_EXECUTABLE_PATH = AttributeKey.CC.stringKey("process.executable.path");
    public static final AttributeKey<String> PROCESS_COMMAND = AttributeKey.CC.stringKey("process.command");
    public static final AttributeKey<String> PROCESS_COMMAND_LINE = AttributeKey.CC.stringKey("process.command_line");
    public static final AttributeKey<List<String>> PROCESS_COMMAND_ARGS = AttributeKey.CC.stringArrayKey("process.command_args");
    public static final AttributeKey<String> PROCESS_OWNER = AttributeKey.CC.stringKey("process.owner");
    public static final AttributeKey<String> PROCESS_RUNTIME_NAME = AttributeKey.CC.stringKey("process.runtime.name");
    public static final AttributeKey<String> PROCESS_RUNTIME_VERSION = AttributeKey.CC.stringKey("process.runtime.version");
    public static final AttributeKey<String> PROCESS_RUNTIME_DESCRIPTION = AttributeKey.CC.stringKey("process.runtime.description");
    public static final AttributeKey<String> SERVICE_NAME = AttributeKey.CC.stringKey("service.name");
    public static final AttributeKey<String> SERVICE_NAMESPACE = AttributeKey.CC.stringKey("service.namespace");
    public static final AttributeKey<String> SERVICE_INSTANCE_ID = AttributeKey.CC.stringKey("service.instance.id");
    public static final AttributeKey<String> SERVICE_VERSION = AttributeKey.CC.stringKey("service.version");
    public static final AttributeKey<String> TELEMETRY_SDK_NAME = AttributeKey.CC.stringKey("telemetry.sdk.name");
    public static final AttributeKey<String> TELEMETRY_SDK_LANGUAGE = AttributeKey.CC.stringKey("telemetry.sdk.language");
    public static final AttributeKey<String> TELEMETRY_SDK_VERSION = AttributeKey.CC.stringKey("telemetry.sdk.version");
    public static final AttributeKey<String> TELEMETRY_AUTO_VERSION = AttributeKey.CC.stringKey("telemetry.auto.version");
    public static final AttributeKey<String> WEBENGINE_NAME = AttributeKey.CC.stringKey("webengine.name");
    public static final AttributeKey<String> WEBENGINE_VERSION = AttributeKey.CC.stringKey("webengine.version");
    public static final AttributeKey<String> WEBENGINE_DESCRIPTION = AttributeKey.CC.stringKey("webengine.description");

    /* loaded from: classes2.dex */
    public static final class CloudProviderValues {
        public static final String ALIBABA_CLOUD = "alibaba_cloud";
        public static final String AWS = "aws";
        public static final String AZURE = "azure";
        public static final String GCP = "gcp";
        public static final String TENCENT_CLOUD = "tencent_cloud";

        private CloudProviderValues() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class CloudPlatformValues {
        public static final String ALIBABA_CLOUD_ECS = "alibaba_cloud_ecs";
        public static final String ALIBABA_CLOUD_FC = "alibaba_cloud_fc";
        public static final String AWS_APP_RUNNER = "aws_app_runner";
        public static final String AWS_EC2 = "aws_ec2";
        public static final String AWS_ECS = "aws_ecs";
        public static final String AWS_EKS = "aws_eks";
        public static final String AWS_ELASTIC_BEANSTALK = "aws_elastic_beanstalk";
        public static final String AWS_LAMBDA = "aws_lambda";
        public static final String AZURE_AKS = "azure_aks";
        public static final String AZURE_APP_SERVICE = "azure_app_service";
        public static final String AZURE_CONTAINER_INSTANCES = "azure_container_instances";
        public static final String AZURE_FUNCTIONS = "azure_functions";
        public static final String AZURE_VM = "azure_vm";
        public static final String GCP_APP_ENGINE = "gcp_app_engine";
        public static final String GCP_CLOUD_FUNCTIONS = "gcp_cloud_functions";
        public static final String GCP_CLOUD_RUN = "gcp_cloud_run";
        public static final String GCP_COMPUTE_ENGINE = "gcp_compute_engine";
        public static final String GCP_KUBERNETES_ENGINE = "gcp_kubernetes_engine";
        public static final String TENCENT_CLOUD_CVM = "tencent_cloud_cvm";
        public static final String TENCENT_CLOUD_EKS = "tencent_cloud_eks";
        public static final String TENCENT_CLOUD_SCF = "tencent_cloud_scf";

        private CloudPlatformValues() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class AwsEcsLaunchtypeValues {
        public static final String EC2 = "ec2";
        public static final String FARGATE = "fargate";

        private AwsEcsLaunchtypeValues() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class HostArchValues {
        public static final String AMD64 = "amd64";
        public static final String ARM32 = "arm32";
        public static final String ARM64 = "arm64";
        public static final String IA64 = "ia64";
        public static final String PPC32 = "ppc32";
        public static final String PPC64 = "ppc64";
        public static final String S390X = "s390x";
        public static final String X86 = "x86";

        private HostArchValues() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class OsTypeValues {
        public static final String AIX = "aix";
        public static final String DARWIN = "darwin";
        public static final String DRAGONFLYBSD = "dragonflybsd";
        public static final String FREEBSD = "freebsd";
        public static final String HPUX = "hpux";
        public static final String LINUX = "linux";
        public static final String NETBSD = "netbsd";
        public static final String OPENBSD = "openbsd";
        public static final String SOLARIS = "solaris";
        public static final String WINDOWS = "windows";
        public static final String Z_OS = "z_os";

        private OsTypeValues() {
        }
    }

    /* loaded from: classes2.dex */
    public static final class TelemetrySdkLanguageValues {
        public static final String CPP = "cpp";
        public static final String DOTNET = "dotnet";
        public static final String ERLANG = "erlang";
        public static final String GO = "go";
        public static final String JAVA = "java";
        public static final String NODEJS = "nodejs";
        public static final String PHP = "php";
        public static final String PYTHON = "python";
        public static final String RUBY = "ruby";
        public static final String SWIFT = "swift";
        public static final String WEBJS = "webjs";

        private TelemetrySdkLanguageValues() {
        }
    }

    private ResourceAttributes() {
    }
}
