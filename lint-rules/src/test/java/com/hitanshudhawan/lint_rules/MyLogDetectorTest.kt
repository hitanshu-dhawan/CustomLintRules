package com.hitanshudhawan.lint_rules

import com.android.tools.lint.checks.infrastructure.LintDetectorTest.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class MyLogDetectorTest {

    @Test
    fun `test Log`() {

        lint()
            .files(
                kotlin(
                    """
                        import android.util.Log
                        fun function() {
                            Log.d("TAG", "message")
                        }
                    """
                ).indented()
            )
            .issues(MyLogDetector.ISSUE)
            .run()
            .expectWarningCount(1)
            .verifyFixes()
            .checkFix(
                null,
                kotlin(
                    """
                        import android.util.Log
                        fun function() {
                            MyLog.d("TAG", "message")
                        }
                    """
                ).indented()
            )

    }

    @Test
    fun `test MyLog`() {

        lint()
            .files(
                kotlin(
                    """
                        import com.hitanshudhawan.library.MyLog
                        fun function() {
                            Log.d("TAG", "message")
                        }
                    """
                ).indented()
            )
            .issues(MyLogDetector.ISSUE)
            .run()
            .expectClean()

    }

}
