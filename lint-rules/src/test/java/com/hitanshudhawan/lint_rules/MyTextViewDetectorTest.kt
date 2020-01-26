package com.hitanshudhawan.lint_rules

import com.android.tools.lint.checks.infrastructure.LintDetectorTest.xml
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class MyTextViewDetectorTest {

    @Test
    fun `test TextView`() {

        lint()
            .files(
                xml(
                    "res/layout/layout.xml",
                    """
                        <merge xmlns:android="http://schemas.android.com/apk/res/android">
                            <TextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_gravity="center"
                                android:text="Hello World!" />
                        </merge>
                    """
                ).indented()
            )
            .issues(MyTextViewDetector.ISSUE)
            .run()
            .expectWarningCount(1)
            .verifyFixes()
            .checkFix(
                null,
                xml(
                    "res/layout/layout.xml",
                    """
                        <merge xmlns:android="http://schemas.android.com/apk/res/android">
                            <com.hitanshudhawan.library.MyTextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_gravity="center"
                                android:text="Hello World!" />
                        </merge>
                    """
                ).indented()
            )

    }

    @Test
    fun `test MyTextView`() {

        lint()
            .files(
                xml(
                    "res/layout/layout.xml",
                    """
                        <merge xmlns:android="http://schemas.android.com/apk/res/android">
                            <com.hitanshudhawan.library.MyTextView
                                android:layout_width="wrap_content"
                                android:layout_height="wrap_content"
                                android:layout_gravity="center"
                                android:text="Hello World!" />
                        </merge>
                    """
                ).indented()
            )
            .issues(MyTextViewDetector.ISSUE)
            .run()
            .expectClean()

    }

}
