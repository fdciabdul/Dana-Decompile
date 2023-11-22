package io.opentelemetry.semconv.trace.attributes;

import io.opentelemetry.api.common.AttributeKey;
import java.util.List;

/* loaded from: classes6.dex */
public final class SemanticAttributes {
    public static final String EXCEPTION_EVENT_NAME = "exception";
    public static final String SCHEMA_URL = "https://opentelemetry.io/schemas/1.13.0";
    public static final AttributeKey<String> AWS_LAMBDA_INVOKED_ARN = AttributeKey.CC.stringKey("aws.lambda.invoked_arn");
    public static final AttributeKey<String> CLOUDEVENTS_EVENT_ID = AttributeKey.CC.stringKey("cloudevents.event_id");
    public static final AttributeKey<String> CLOUDEVENTS_EVENT_SOURCE = AttributeKey.CC.stringKey("cloudevents.event_source");
    public static final AttributeKey<String> CLOUDEVENTS_EVENT_SPEC_VERSION = AttributeKey.CC.stringKey("cloudevents.event_spec_version");
    public static final AttributeKey<String> CLOUDEVENTS_EVENT_TYPE = AttributeKey.CC.stringKey("cloudevents.event_type");
    public static final AttributeKey<String> CLOUDEVENTS_EVENT_SUBJECT = AttributeKey.CC.stringKey("cloudevents.event_subject");
    public static final AttributeKey<String> OPENTRACING_REF_TYPE = AttributeKey.CC.stringKey("opentracing.ref_type");
    public static final AttributeKey<String> DB_SYSTEM = AttributeKey.CC.stringKey("db.system");
    public static final AttributeKey<String> DB_CONNECTION_STRING = AttributeKey.CC.stringKey("db.connection_string");
    public static final AttributeKey<String> DB_USER = AttributeKey.CC.stringKey("db.user");
    public static final AttributeKey<String> DB_JDBC_DRIVER_CLASSNAME = AttributeKey.CC.stringKey("db.jdbc.driver_classname");
    public static final AttributeKey<String> DB_NAME = AttributeKey.CC.stringKey("db.name");
    public static final AttributeKey<String> DB_STATEMENT = AttributeKey.CC.stringKey("db.statement");
    public static final AttributeKey<String> DB_OPERATION = AttributeKey.CC.stringKey("db.operation");
    public static final AttributeKey<String> DB_MSSQL_INSTANCE_NAME = AttributeKey.CC.stringKey("db.mssql.instance_name");
    public static final AttributeKey<Long> DB_CASSANDRA_PAGE_SIZE = AttributeKey.CC.longKey("db.cassandra.page_size");
    public static final AttributeKey<String> DB_CASSANDRA_CONSISTENCY_LEVEL = AttributeKey.CC.stringKey("db.cassandra.consistency_level");
    public static final AttributeKey<String> DB_CASSANDRA_TABLE = AttributeKey.CC.stringKey("db.cassandra.table");
    public static final AttributeKey<Boolean> DB_CASSANDRA_IDEMPOTENCE = AttributeKey.CC.booleanKey("db.cassandra.idempotence");
    public static final AttributeKey<Long> DB_CASSANDRA_SPECULATIVE_EXECUTION_COUNT = AttributeKey.CC.longKey("db.cassandra.speculative_execution_count");
    public static final AttributeKey<String> DB_CASSANDRA_COORDINATOR_ID = AttributeKey.CC.stringKey("db.cassandra.coordinator.id");
    public static final AttributeKey<String> DB_CASSANDRA_COORDINATOR_DC = AttributeKey.CC.stringKey("db.cassandra.coordinator.dc");
    public static final AttributeKey<Long> DB_REDIS_DATABASE_INDEX = AttributeKey.CC.longKey("db.redis.database_index");
    public static final AttributeKey<String> DB_MONGODB_COLLECTION = AttributeKey.CC.stringKey("db.mongodb.collection");
    public static final AttributeKey<String> DB_SQL_TABLE = AttributeKey.CC.stringKey("db.sql.table");
    public static final AttributeKey<String> EXCEPTION_TYPE = AttributeKey.CC.stringKey("exception.type");
    public static final AttributeKey<String> EXCEPTION_MESSAGE = AttributeKey.CC.stringKey("exception.message");
    public static final AttributeKey<String> EXCEPTION_STACKTRACE = AttributeKey.CC.stringKey("exception.stacktrace");
    public static final AttributeKey<Boolean> EXCEPTION_ESCAPED = AttributeKey.CC.booleanKey("exception.escaped");
    public static final AttributeKey<String> FAAS_TRIGGER = AttributeKey.CC.stringKey("faas.trigger");
    public static final AttributeKey<String> FAAS_EXECUTION = AttributeKey.CC.stringKey("faas.execution");
    public static final AttributeKey<String> FAAS_DOCUMENT_COLLECTION = AttributeKey.CC.stringKey("faas.document.collection");
    public static final AttributeKey<String> FAAS_DOCUMENT_OPERATION = AttributeKey.CC.stringKey("faas.document.operation");
    public static final AttributeKey<String> FAAS_DOCUMENT_TIME = AttributeKey.CC.stringKey("faas.document.time");
    public static final AttributeKey<String> FAAS_DOCUMENT_NAME = AttributeKey.CC.stringKey("faas.document.name");
    public static final AttributeKey<String> FAAS_TIME = AttributeKey.CC.stringKey("faas.time");
    public static final AttributeKey<String> FAAS_CRON = AttributeKey.CC.stringKey("faas.cron");
    public static final AttributeKey<Boolean> FAAS_COLDSTART = AttributeKey.CC.booleanKey("faas.coldstart");
    public static final AttributeKey<String> FAAS_INVOKED_NAME = AttributeKey.CC.stringKey("faas.invoked_name");
    public static final AttributeKey<String> FAAS_INVOKED_PROVIDER = AttributeKey.CC.stringKey("faas.invoked_provider");
    public static final AttributeKey<String> FAAS_INVOKED_REGION = AttributeKey.CC.stringKey("faas.invoked_region");
    public static final AttributeKey<String> NET_TRANSPORT = AttributeKey.CC.stringKey("net.transport");
    public static final AttributeKey<String> NET_APP_PROTOCOL_NAME = AttributeKey.CC.stringKey("net.app.protocol.name");
    public static final AttributeKey<String> NET_APP_PROTOCOL_VERSION = AttributeKey.CC.stringKey("net.app.protocol.version");
    public static final AttributeKey<String> NET_SOCK_PEER_NAME = AttributeKey.CC.stringKey("net.sock.peer.name");
    public static final AttributeKey<String> NET_SOCK_PEER_ADDR = AttributeKey.CC.stringKey("net.sock.peer.addr");
    public static final AttributeKey<Long> NET_SOCK_PEER_PORT = AttributeKey.CC.longKey("net.sock.peer.port");
    public static final AttributeKey<String> NET_SOCK_FAMILY = AttributeKey.CC.stringKey("net.sock.family");
    public static final AttributeKey<String> NET_PEER_NAME = AttributeKey.CC.stringKey("net.peer.name");
    public static final AttributeKey<Long> NET_PEER_PORT = AttributeKey.CC.longKey("net.peer.port");
    public static final AttributeKey<String> NET_HOST_NAME = AttributeKey.CC.stringKey("net.host.name");
    public static final AttributeKey<Long> NET_HOST_PORT = AttributeKey.CC.longKey("net.host.port");
    public static final AttributeKey<String> NET_SOCK_HOST_ADDR = AttributeKey.CC.stringKey("net.sock.host.addr");
    public static final AttributeKey<Long> NET_SOCK_HOST_PORT = AttributeKey.CC.longKey("net.sock.host.port");
    public static final AttributeKey<String> NET_HOST_CONNECTION_TYPE = AttributeKey.CC.stringKey("net.host.connection.type");
    public static final AttributeKey<String> NET_HOST_CONNECTION_SUBTYPE = AttributeKey.CC.stringKey("net.host.connection.subtype");
    public static final AttributeKey<String> NET_HOST_CARRIER_NAME = AttributeKey.CC.stringKey("net.host.carrier.name");
    public static final AttributeKey<String> NET_HOST_CARRIER_MCC = AttributeKey.CC.stringKey("net.host.carrier.mcc");
    public static final AttributeKey<String> NET_HOST_CARRIER_MNC = AttributeKey.CC.stringKey("net.host.carrier.mnc");
    public static final AttributeKey<String> NET_HOST_CARRIER_ICC = AttributeKey.CC.stringKey("net.host.carrier.icc");
    public static final AttributeKey<String> PEER_SERVICE = AttributeKey.CC.stringKey("peer.service");
    public static final AttributeKey<String> ENDUSER_ID = AttributeKey.CC.stringKey("enduser.id");
    public static final AttributeKey<String> ENDUSER_ROLE = AttributeKey.CC.stringKey("enduser.role");
    public static final AttributeKey<String> ENDUSER_SCOPE = AttributeKey.CC.stringKey("enduser.scope");
    public static final AttributeKey<Long> THREAD_ID = AttributeKey.CC.longKey("thread.id");
    public static final AttributeKey<String> THREAD_NAME = AttributeKey.CC.stringKey("thread.name");
    public static final AttributeKey<String> CODE_FUNCTION = AttributeKey.CC.stringKey("code.function");
    public static final AttributeKey<String> CODE_NAMESPACE = AttributeKey.CC.stringKey("code.namespace");
    public static final AttributeKey<String> CODE_FILEPATH = AttributeKey.CC.stringKey("code.filepath");
    public static final AttributeKey<Long> CODE_LINENO = AttributeKey.CC.longKey("code.lineno");
    public static final AttributeKey<String> HTTP_METHOD = AttributeKey.CC.stringKey("http.method");
    public static final AttributeKey<Long> HTTP_STATUS_CODE = AttributeKey.CC.longKey("http.status_code");
    public static final AttributeKey<String> HTTP_FLAVOR = AttributeKey.CC.stringKey("http.flavor");
    public static final AttributeKey<String> HTTP_USER_AGENT = AttributeKey.CC.stringKey("http.user_agent");
    public static final AttributeKey<Long> HTTP_REQUEST_CONTENT_LENGTH = AttributeKey.CC.longKey("http.request_content_length");
    public static final AttributeKey<Long> HTTP_RESPONSE_CONTENT_LENGTH = AttributeKey.CC.longKey("http.response_content_length");
    public static final AttributeKey<String> HTTP_URL = AttributeKey.CC.stringKey("http.url");
    public static final AttributeKey<Long> HTTP_RETRY_COUNT = AttributeKey.CC.longKey("http.retry_count");
    public static final AttributeKey<String> HTTP_SCHEME = AttributeKey.CC.stringKey("http.scheme");
    public static final AttributeKey<String> HTTP_TARGET = AttributeKey.CC.stringKey("http.target");
    public static final AttributeKey<String> HTTP_ROUTE = AttributeKey.CC.stringKey("http.route");
    public static final AttributeKey<String> HTTP_CLIENT_IP = AttributeKey.CC.stringKey("http.client_ip");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_TABLE_NAMES = AttributeKey.CC.stringArrayKey("aws.dynamodb.table_names");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_CONSUMED_CAPACITY = AttributeKey.CC.stringArrayKey("aws.dynamodb.consumed_capacity");
    public static final AttributeKey<String> AWS_DYNAMODB_ITEM_COLLECTION_METRICS = AttributeKey.CC.stringKey("aws.dynamodb.item_collection_metrics");
    public static final AttributeKey<Double> AWS_DYNAMODB_PROVISIONED_READ_CAPACITY = AttributeKey.CC.doubleKey("aws.dynamodb.provisioned_read_capacity");
    public static final AttributeKey<Double> AWS_DYNAMODB_PROVISIONED_WRITE_CAPACITY = AttributeKey.CC.doubleKey("aws.dynamodb.provisioned_write_capacity");
    public static final AttributeKey<Boolean> AWS_DYNAMODB_CONSISTENT_READ = AttributeKey.CC.booleanKey("aws.dynamodb.consistent_read");
    public static final AttributeKey<String> AWS_DYNAMODB_PROJECTION = AttributeKey.CC.stringKey("aws.dynamodb.projection");
    public static final AttributeKey<Long> AWS_DYNAMODB_LIMIT = AttributeKey.CC.longKey("aws.dynamodb.limit");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_ATTRIBUTES_TO_GET = AttributeKey.CC.stringArrayKey("aws.dynamodb.attributes_to_get");
    public static final AttributeKey<String> AWS_DYNAMODB_INDEX_NAME = AttributeKey.CC.stringKey("aws.dynamodb.index_name");
    public static final AttributeKey<String> AWS_DYNAMODB_SELECT = AttributeKey.CC.stringKey("aws.dynamodb.select");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_GLOBAL_SECONDARY_INDEXES = AttributeKey.CC.stringArrayKey("aws.dynamodb.global_secondary_indexes");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_LOCAL_SECONDARY_INDEXES = AttributeKey.CC.stringArrayKey("aws.dynamodb.local_secondary_indexes");
    public static final AttributeKey<String> AWS_DYNAMODB_EXCLUSIVE_START_TABLE = AttributeKey.CC.stringKey("aws.dynamodb.exclusive_start_table");
    public static final AttributeKey<Long> AWS_DYNAMODB_TABLE_COUNT = AttributeKey.CC.longKey("aws.dynamodb.table_count");
    public static final AttributeKey<Boolean> AWS_DYNAMODB_SCAN_FORWARD = AttributeKey.CC.booleanKey("aws.dynamodb.scan_forward");
    public static final AttributeKey<Long> AWS_DYNAMODB_SEGMENT = AttributeKey.CC.longKey("aws.dynamodb.segment");
    public static final AttributeKey<Long> AWS_DYNAMODB_TOTAL_SEGMENTS = AttributeKey.CC.longKey("aws.dynamodb.total_segments");
    public static final AttributeKey<Long> AWS_DYNAMODB_COUNT = AttributeKey.CC.longKey("aws.dynamodb.count");
    public static final AttributeKey<Long> AWS_DYNAMODB_SCANNED_COUNT = AttributeKey.CC.longKey("aws.dynamodb.scanned_count");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_ATTRIBUTE_DEFINITIONS = AttributeKey.CC.stringArrayKey("aws.dynamodb.attribute_definitions");
    public static final AttributeKey<List<String>> AWS_DYNAMODB_GLOBAL_SECONDARY_INDEX_UPDATES = AttributeKey.CC.stringArrayKey("aws.dynamodb.global_secondary_index_updates");
    public static final AttributeKey<String> GRAPHQL_OPERATION_NAME = AttributeKey.CC.stringKey("graphql.operation.name");
    public static final AttributeKey<String> GRAPHQL_OPERATION_TYPE = AttributeKey.CC.stringKey("graphql.operation.type");
    public static final AttributeKey<String> GRAPHQL_DOCUMENT = AttributeKey.CC.stringKey("graphql.document");
    public static final AttributeKey<String> MESSAGING_SYSTEM = AttributeKey.CC.stringKey("messaging.system");
    public static final AttributeKey<String> MESSAGING_DESTINATION = AttributeKey.CC.stringKey("messaging.destination");
    public static final AttributeKey<String> MESSAGING_DESTINATION_KIND = AttributeKey.CC.stringKey("messaging.destination_kind");
    public static final AttributeKey<Boolean> MESSAGING_TEMP_DESTINATION = AttributeKey.CC.booleanKey("messaging.temp_destination");
    public static final AttributeKey<String> MESSAGING_PROTOCOL = AttributeKey.CC.stringKey("messaging.protocol");
    public static final AttributeKey<String> MESSAGING_PROTOCOL_VERSION = AttributeKey.CC.stringKey("messaging.protocol_version");
    public static final AttributeKey<String> MESSAGING_URL = AttributeKey.CC.stringKey("messaging.url");
    public static final AttributeKey<String> MESSAGING_MESSAGE_ID = AttributeKey.CC.stringKey("messaging.message_id");
    public static final AttributeKey<String> MESSAGING_CONVERSATION_ID = AttributeKey.CC.stringKey("messaging.conversation_id");
    public static final AttributeKey<Long> MESSAGING_MESSAGE_PAYLOAD_SIZE_BYTES = AttributeKey.CC.longKey("messaging.message_payload_size_bytes");
    public static final AttributeKey<Long> MESSAGING_MESSAGE_PAYLOAD_COMPRESSED_SIZE_BYTES = AttributeKey.CC.longKey("messaging.message_payload_compressed_size_bytes");
    public static final AttributeKey<String> MESSAGING_OPERATION = AttributeKey.CC.stringKey("messaging.operation");
    public static final AttributeKey<String> MESSAGING_CONSUMER_ID = AttributeKey.CC.stringKey("messaging.consumer_id");
    public static final AttributeKey<String> MESSAGING_RABBITMQ_ROUTING_KEY = AttributeKey.CC.stringKey("messaging.rabbitmq.routing_key");
    public static final AttributeKey<String> MESSAGING_KAFKA_MESSAGE_KEY = AttributeKey.CC.stringKey("messaging.kafka.message_key");
    public static final AttributeKey<String> MESSAGING_KAFKA_CONSUMER_GROUP = AttributeKey.CC.stringKey("messaging.kafka.consumer_group");
    public static final AttributeKey<String> MESSAGING_KAFKA_CLIENT_ID = AttributeKey.CC.stringKey("messaging.kafka.client_id");
    public static final AttributeKey<Long> MESSAGING_KAFKA_PARTITION = AttributeKey.CC.longKey("messaging.kafka.partition");
    public static final AttributeKey<Boolean> MESSAGING_KAFKA_TOMBSTONE = AttributeKey.CC.booleanKey("messaging.kafka.tombstone");
    public static final AttributeKey<String> MESSAGING_ROCKETMQ_NAMESPACE = AttributeKey.CC.stringKey("messaging.rocketmq.namespace");
    public static final AttributeKey<String> MESSAGING_ROCKETMQ_CLIENT_GROUP = AttributeKey.CC.stringKey("messaging.rocketmq.client_group");
    public static final AttributeKey<String> MESSAGING_ROCKETMQ_CLIENT_ID = AttributeKey.CC.stringKey("messaging.rocketmq.client_id");
    public static final AttributeKey<String> MESSAGING_ROCKETMQ_MESSAGE_TYPE = AttributeKey.CC.stringKey("messaging.rocketmq.message_type");
    public static final AttributeKey<String> MESSAGING_ROCKETMQ_MESSAGE_TAG = AttributeKey.CC.stringKey("messaging.rocketmq.message_tag");
    public static final AttributeKey<List<String>> MESSAGING_ROCKETMQ_MESSAGE_KEYS = AttributeKey.CC.stringArrayKey("messaging.rocketmq.message_keys");
    public static final AttributeKey<String> MESSAGING_ROCKETMQ_CONSUMPTION_MODEL = AttributeKey.CC.stringKey("messaging.rocketmq.consumption_model");
    public static final AttributeKey<String> RPC_SYSTEM = AttributeKey.CC.stringKey("rpc.system");
    public static final AttributeKey<String> RPC_SERVICE = AttributeKey.CC.stringKey("rpc.service");
    public static final AttributeKey<String> RPC_METHOD = AttributeKey.CC.stringKey("rpc.method");
    public static final AttributeKey<Long> RPC_GRPC_STATUS_CODE = AttributeKey.CC.longKey("rpc.grpc.status_code");
    public static final AttributeKey<String> RPC_JSONRPC_VERSION = AttributeKey.CC.stringKey("rpc.jsonrpc.version");
    public static final AttributeKey<String> RPC_JSONRPC_REQUEST_ID = AttributeKey.CC.stringKey("rpc.jsonrpc.request_id");
    public static final AttributeKey<Long> RPC_JSONRPC_ERROR_CODE = AttributeKey.CC.longKey("rpc.jsonrpc.error_code");
    public static final AttributeKey<String> RPC_JSONRPC_ERROR_MESSAGE = AttributeKey.CC.stringKey("rpc.jsonrpc.error_message");
    public static final AttributeKey<String> MESSAGE_TYPE = AttributeKey.CC.stringKey("message.type");
    public static final AttributeKey<Long> MESSAGE_ID = AttributeKey.CC.longKey("message.id");
    public static final AttributeKey<Long> MESSAGE_COMPRESSED_SIZE = AttributeKey.CC.longKey("message.compressed_size");
    public static final AttributeKey<Long> MESSAGE_UNCOMPRESSED_SIZE = AttributeKey.CC.longKey("message.uncompressed_size");
    @Deprecated
    public static final AttributeKey<String> DB_CASSANDRA_KEYSPACE = AttributeKey.CC.stringKey("db.cassandra.keyspace");
    @Deprecated
    public static final AttributeKey<String> DB_HBASE_NAMESPACE = AttributeKey.CC.stringKey("db.hbase.namespace");
    @Deprecated
    public static final AttributeKey<Long> HTTP_REQUEST_CONTENT_LENGTH_UNCOMPRESSED = AttributeKey.CC.longKey("http.request_content_length_uncompressed");
    @Deprecated
    public static final AttributeKey<Long> HTTP_RESPONSE_CONTENT_LENGTH_UNCOMPRESSED = AttributeKey.CC.longKey("http.response_content_length_uncompressed");
    @Deprecated
    public static final AttributeKey<String> HTTP_SERVER_NAME = AttributeKey.CC.stringKey("http.server_name");
    @Deprecated
    public static final AttributeKey<String> HTTP_HOST = AttributeKey.CC.stringKey("http.host");
    @Deprecated
    public static final AttributeKey<String> NET_PEER_IP = AttributeKey.CC.stringKey("net.peer.ip");
    @Deprecated
    public static final AttributeKey<String> NET_HOST_IP = AttributeKey.CC.stringKey("net.host.ip");

    /* loaded from: classes9.dex */
    public static final class OpentracingRefTypeValues {
        public static final String CHILD_OF = "child_of";
        public static final String FOLLOWS_FROM = "follows_from";

        private OpentracingRefTypeValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class DbSystemValues {
        public static final String ADABAS = "adabas";
        public static final String CACHE = "cache";
        public static final String CASSANDRA = "cassandra";
        public static final String CLOUDSCAPE = "cloudscape";
        public static final String COCKROACHDB = "cockroachdb";
        public static final String COLDFUSION = "coldfusion";
        public static final String COSMOSDB = "cosmosdb";
        public static final String COUCHBASE = "couchbase";
        public static final String COUCHDB = "couchdb";
        public static final String DB2 = "db2";
        public static final String DERBY = "derby";
        public static final String DYNAMODB = "dynamodb";
        public static final String EDB = "edb";
        public static final String ELASTICSEARCH = "elasticsearch";
        public static final String FILEMAKER = "filemaker";
        public static final String FIREBIRD = "firebird";
        public static final String FIRSTSQL = "firstsql";
        public static final String GEODE = "geode";
        public static final String H2 = "h2";
        public static final String HANADB = "hanadb";
        public static final String HBASE = "hbase";
        public static final String HIVE = "hive";
        public static final String HSQLDB = "hsqldb";
        public static final String INFORMIX = "informix";
        public static final String INGRES = "ingres";
        public static final String INSTANTDB = "instantdb";
        public static final String INTERBASE = "interbase";
        public static final String MARIADB = "mariadb";
        public static final String MAXDB = "maxdb";
        public static final String MEMCACHED = "memcached";
        public static final String MONGODB = "mongodb";
        public static final String MSSQL = "mssql";
        public static final String MYSQL = "mysql";
        public static final String NEO4J = "neo4j";
        public static final String NETEZZA = "netezza";
        public static final String OPENSEARCH = "opensearch";
        public static final String ORACLE = "oracle";
        public static final String OTHER_SQL = "other_sql";
        public static final String PERVASIVE = "pervasive";
        public static final String POINTBASE = "pointbase";
        public static final String POSTGRESQL = "postgresql";
        public static final String PROGRESS = "progress";
        public static final String REDIS = "redis";
        public static final String REDSHIFT = "redshift";
        public static final String SQLITE = "sqlite";
        public static final String SYBASE = "sybase";
        public static final String TERADATA = "teradata";
        public static final String VERTICA = "vertica";

        private DbSystemValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class DbCassandraConsistencyLevelValues {
        public static final String ALL = "all";
        public static final String ANY = "any";
        public static final String EACH_QUORUM = "each_quorum";
        public static final String LOCAL_ONE = "local_one";
        public static final String LOCAL_QUORUM = "local_quorum";
        public static final String LOCAL_SERIAL = "local_serial";
        public static final String ONE = "one";
        public static final String QUORUM = "quorum";
        public static final String SERIAL = "serial";
        public static final String THREE = "three";
        public static final String TWO = "two";

        private DbCassandraConsistencyLevelValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class FaasTriggerValues {
        public static final String DATASOURCE = "datasource";
        public static final String HTTP = "http";
        public static final String OTHER = "other";
        public static final String PUBSUB = "pubsub";
        public static final String TIMER = "timer";

        private FaasTriggerValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class FaasDocumentOperationValues {
        public static final String DELETE = "delete";
        public static final String EDIT = "edit";
        public static final String INSERT = "insert";

        private FaasDocumentOperationValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class FaasInvokedProviderValues {
        public static final String ALIBABA_CLOUD = "alibaba_cloud";
        public static final String AWS = "aws";
        public static final String AZURE = "azure";
        public static final String GCP = "gcp";
        public static final String TENCENT_CLOUD = "tencent_cloud";

        private FaasInvokedProviderValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class NetTransportValues {
        public static final String INPROC = "inproc";
        @Deprecated
        public static final String IP = "ip";
        public static final String IP_TCP = "ip_tcp";
        public static final String IP_UDP = "ip_udp";
        public static final String OTHER = "other";
        public static final String PIPE = "pipe";
        @Deprecated
        public static final String UNIX = "unix";

        private NetTransportValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class NetSockFamilyValues {
        public static final String INET = "inet";
        public static final String INET6 = "inet6";
        public static final String UNIX = "unix";

        private NetSockFamilyValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class NetHostConnectionTypeValues {
        public static final String CELL = "cell";
        public static final String UNAVAILABLE = "unavailable";
        public static final String UNKNOWN = "unknown";
        public static final String WIFI = "wifi";
        public static final String WIRED = "wired";

        private NetHostConnectionTypeValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class NetHostConnectionSubtypeValues {
        public static final String CDMA = "cdma";
        public static final String CDMA2000_1XRTT = "cdma2000_1xrtt";
        public static final String EDGE = "edge";
        public static final String EHRPD = "ehrpd";
        public static final String EVDO_0 = "evdo_0";
        public static final String EVDO_A = "evdo_a";
        public static final String EVDO_B = "evdo_b";
        public static final String GPRS = "gprs";
        public static final String GSM = "gsm";
        public static final String HSDPA = "hsdpa";
        public static final String HSPA = "hspa";
        public static final String HSPAP = "hspap";
        public static final String HSUPA = "hsupa";
        public static final String IDEN = "iden";
        public static final String IWLAN = "iwlan";
        public static final String LTE = "lte";
        public static final String LTE_CA = "lte_ca";
        public static final String NR = "nr";
        public static final String NRNSA = "nrnsa";
        public static final String TD_SCDMA = "td_scdma";
        public static final String UMTS = "umts";

        private NetHostConnectionSubtypeValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class HttpFlavorValues {
        public static final String HTTP_1_0 = "1.0";
        public static final String HTTP_1_1 = "1.1";
        public static final String HTTP_2_0 = "2.0";
        public static final String HTTP_3_0 = "3.0";
        public static final String QUIC = "QUIC";
        public static final String SPDY = "SPDY";

        private HttpFlavorValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class GraphqlOperationTypeValues {
        public static final String MUTATION = "mutation";
        public static final String QUERY = "query";
        public static final String SUBSCRIPTION = "subscription";

        private GraphqlOperationTypeValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class MessagingDestinationKindValues {
        public static final String QUEUE = "queue";
        public static final String TOPIC = "topic";

        private MessagingDestinationKindValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class MessagingOperationValues {
        public static final String PROCESS = "process";
        public static final String RECEIVE = "receive";

        private MessagingOperationValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class MessagingRocketmqMessageTypeValues {
        public static final String DELAY = "delay";
        public static final String FIFO = "fifo";
        public static final String NORMAL = "normal";
        public static final String TRANSACTION = "transaction";

        private MessagingRocketmqMessageTypeValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class MessagingRocketmqConsumptionModelValues {
        public static final String BROADCASTING = "broadcasting";
        public static final String CLUSTERING = "clustering";

        private MessagingRocketmqConsumptionModelValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class RpcSystemValues {
        public static final String APACHE_DUBBO = "apache_dubbo";
        public static final String DOTNET_WCF = "dotnet_wcf";
        public static final String GRPC = "grpc";
        public static final String JAVA_RMI = "java_rmi";

        private RpcSystemValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class RpcGrpcStatusCodeValues {
        public static final long ABORTED = 10;
        public static final long ALREADY_EXISTS = 6;
        public static final long CANCELLED = 1;
        public static final long DATA_LOSS = 15;
        public static final long DEADLINE_EXCEEDED = 4;
        public static final long FAILED_PRECONDITION = 9;
        public static final long INTERNAL = 13;
        public static final long INVALID_ARGUMENT = 3;
        public static final long NOT_FOUND = 5;
        public static final long OK = 0;
        public static final long OUT_OF_RANGE = 11;
        public static final long PERMISSION_DENIED = 7;
        public static final long RESOURCE_EXHAUSTED = 8;
        public static final long UNAUTHENTICATED = 16;
        public static final long UNAVAILABLE = 14;
        public static final long UNIMPLEMENTED = 12;
        public static final long UNKNOWN = 2;

        private RpcGrpcStatusCodeValues() {
        }
    }

    /* loaded from: classes9.dex */
    public static final class MessageTypeValues {
        public static final String RECEIVED = "RECEIVED";
        public static final String SENT = "SENT";

        private MessageTypeValues() {
        }
    }

    private SemanticAttributes() {
    }
}
