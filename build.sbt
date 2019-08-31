import Dependencies._

lazy val baseSettings: Seq[Setting[_]] = Seq(
  scalaVersion := "2.13.0",
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding",
    "UTF-8",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:existentials",
    "-language:postfixOps",
    "-unchecked",
    "-Ywarn-value-discard"
  ),
  addCompilerPlugin(kindProjector),
  libraryDependencies ++= Seq(
    cats,
    catsFree,
    catsEffect,
    refined,
    typesafeConfig,
    circe,
    scalacheck,
    discipline,
    disciplineTest % Test
  )
)

lazy val exercises = project
  .settings(moduleName := "foundation-exercises")
  .settings(baseSettings: _*)

addCommandAlias("testAnswers", "testOnly *AnswersTest")

addCommandAlias("testExercises1", "testOnly function.*ExercisesTest")
addCommandAlias("testExercises2", "testOnly sideeffect.*ExercisesTest")
addCommandAlias("testExercises3", "testOnly types.*ExercisesTest")
addCommandAlias("testExercises4", "testOnly errorhandling.*ExercisesTest")
addCommandAlias("testExercises6", "testOnly typeclass.*ExercisesTest")
addCommandAlias("testExercises7", "testOnly functors.*ExercisesTest")
