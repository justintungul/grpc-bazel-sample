load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_proto",
    sha256 = "602e7161d9195e50246177e7c55b2f39950a9cf7366f74ed5f22fd45750cd208",
    strip_prefix = "rules_proto-97d8af4dc474595af3900dd85cb3a29ad28cc313",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

#git_repository(
#    name = "io_grpc_grpc_java",
#    remote = "https://github.com/grpc/grpc-java.git",
#    tag = "v1.23.0",
#)

git_repository(
    name = "io_grpc_grpc_java",
    remote = "https://github.com/grpc/grpc-java.git",
    tag = "v1.24.0",
)

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")

maven_jar(
    name = "com_google_api_grpc_cloud_pubsub_v1",
    artifact = "com.google.api.grpc:grpc-google-cloud-pubsub-v1:0.1.24",
    sha1 = "601d8be0fd0cc0e050b1af3b88f191ada9a2f4e5",
)

maven_jar(
    name = "com_google_api_grpc_proto_cloud_pubsub_v1",
    artifact = "com.google.api.grpc:proto-google-cloud-pubsub-v1:0.1.24",
    sha1 = "e6dd66635f674b4e380dfd3de252ae019a51a67e",
)

grpc_java_repositories()
