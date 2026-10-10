# SRS JSON Schema Validator

A Scala library for validating JSON documents against JSON Schema definitions. The schema implementation lives in the `schema` subproject, and the root project contains a small runnable demo.

## Requirements

- Java 17 (the pinned sbt 1.7.2 uses an older Scala compiler that fails with Java 21)
- [sbt](https://www.scala-sbt.org/)

## Build

Compile the project with:

```sh
sbt compile
```

The schema library is configured for Scala 2.12, 2.13, and 3. Run its test suite with:

```sh
sbt schema/test
```

The required JSON Schema test fixtures are included in `3rdparty`; see `3rdparty/README.md` for their sources and versions.

If your default Java is newer, use the Homebrew Java 17 installation for this command only:

```sh
JAVA_HOME=/opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk/Contents/Home \
PATH=/opt/homebrew/opt/openjdk@17/bin:$PATH \
sbt schema/test
```

You can replace `schema/test` with `compile` or `run` in this command. It does not change your global Java selection.

## Run the demo

```sh
sbt run
```

The demo creates a schema for numbers between 5 and 10, then validates several JSON values against it.

## Use the validator

The schema module uses [Circe](https://circe.github.io/circe/) JSON values. A basic example:

```scala
import io.circe.Json
import net.reactivecore.cjs.Loader

val schemaJson = """
  |{
  |  "type": "number",
  |  "minimum": 5,
  |  "maximum": 10
  |}
  |""".stripMargin

val validator = Loader.empty.fromJson(schemaJson).right.get
val result = validator.validate(Json.fromInt(7))
```

The returned validation result indicates whether the document satisfies the schema. See `src/main/scala/Demo.scala` for a complete runnable example.
