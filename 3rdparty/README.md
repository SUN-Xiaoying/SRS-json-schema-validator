# Test fixtures

These fixtures are required by `DownloaderMock` and the JSON Schema validation suites. Keep them in the repository so tests can run without downloading schemas or contacting a remote server.

- `JSON-Schema-Test-Suite/tests/draft2019-09`, `tests/draft2020-12`, and `remotes` come from [JSON-Schema-Test-Suite](https://github.com/json-schema-org/JSON-Schema-Test-Suite) at commit `3731ed32a5f083d2d75942cf60a05b56ac822bca`. Its license is included in `JSON-Schema-Test-Suite/LICENSE`.
- `schema/2019-09` and `schema/2020-12` contain the metaschemas expected by the tests, copied from [rc-circe-json-schema](https://github.com/reactivecore/rc-circe-json-schema) at commit `0f87a77a2c92b8bc81492fa558cdd9cf5c3d2eb5`. The upstream license is included in `schema/LICENSE`.

The test-suite revision matches the upstream validator's pinned submodule. Only the two supported draft test directories and the shared remote fixtures are included.
