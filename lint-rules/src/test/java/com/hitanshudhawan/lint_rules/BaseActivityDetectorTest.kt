package com.hitanshudhawan.lint_rules

//import com.android.tools.lint.checks.infrastructure.LintDetectorTest.java
import com.android.tools.lint.checks.infrastructure.LintDetectorTest.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class BaseActivityDetectorTest {

//    @Test
//    fun `test AppCompatActivity for Java`() {
//
//        lint()
//            .files(
//                java(
//                    """
//                        import android.util.Log;
//                        public class SomeJavaClass {
//                            private void function() {
//                                Log.d("TAG", "message");
//                                Log.i("TAG", "message");
//                            }
//                        }
//                    """
//                ).indented()
//            )
//            .issues(MyLogDetector.ISSUE)
//            .run()
//            .expect(
//                """
//                    src/SomeJavaClass.java:4: Warning: Usage of android Log is prohibited [LogUsageWarning]
//                            Log.d("TAG", "message");
//                            ~~~~~~~~~~~~~~~~~~~~~~~
//                    src/SomeJavaClass.java:5: Warning: Usage of android Log is prohibited [LogUsageWarning]
//                            Log.i("TAG", "message");
//                            ~~~~~~~~~~~~~~~~~~~~~~~
//                    0 errors, 2 warnings
//                """
//            )
//            .expectFixDiffs(
//                """
//                    Fix for src/SomeJavaClass.java line 4: Use MyLog.d():
//                    @@ -4 +4
//                    -         Log.d("TAG", "message");
//                    +         com.hitanshudhawan.library.MyLog.d("TAG", "message");
//                    Fix for src/SomeJavaClass.java line 5: Use MyLog.i():
//                    @@ -5 +5
//                    -         Log.i("TAG", "message");
//                    +         com.hitanshudhawan.library.MyLog.i("TAG", "message");
//                """
//            )
//
//    }

    @Test
    fun `test AppCompatActivity for Kotlin`() {

        lint()
            .files(
                kotlin(
                    """
                        package androidx.appcompat.app
                        
                        class AppCompatActivity
                    """
                ).indented(),
                kotlin(
                    """
                        package test

                        import androidx.appcompat.app.AppCompatActivity
                        
                        class MainActivity : AppCompatActivity()
                    """
                ).indented()
            )
            .issues(BaseActivityDetector.ISSUE)
            .run()
            .expect("")

    }

//    @Test
//    fun `test BaseActivity for Java`() {
//
//        lint()
//            .files(
//                java(
//                    """
//                        import com.hitanshudhawan.library.MyLog;
//                        public class SomeJavaClass {
//                            private void function() {
//                                MyLog.d("TAG", "message");
//                            }
//                        }
//                    """
//                ).indented()
//            )
//            .issues(MyLogDetector.ISSUE)
//            .run()
//            .expectClean()
//
//    }

//    @Test
//    fun `test BaseActivity for Kotlin`() {
//
//        lint()
//            .files(
//                kotlin(
//                    """
//                        import com.hitanshudhawan.library.MyLog
//                        fun function() {
//                            MyLog.d("TAG", "message")
//                        }
//                    """
//                ).indented()
//            )
//            .issues(MyLogDetector.ISSUE)
//            .run()
//            .expectClean()
//
//    }

}
