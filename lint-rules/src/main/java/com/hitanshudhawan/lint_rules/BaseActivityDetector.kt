package com.hitanshudhawan.lint_rules

import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass

class BaseActivityDetector : Detector(), SourceCodeScanner {

    override fun applicableSuperClasses(): List<String> {
        return listOf("androidx.appcompat.app.AppCompatActivity")
    }

    override fun visitClass(context: JavaContext, declaration: UClass) {
        val evaluator = context.evaluator
        if (evaluator.getQualifiedName(declaration) == "androidx.appcompat.app.AppCompatActivity")
            return
        if (evaluator.getQualifiedName(declaration) == "com.hitanshudhawan.customlintrules.BaseActivity")
            return

        context.report(
            issue = ISSUE,
            location = context.getNameLocation(declaration),
            message = "Usage of AppCompatActivity is prohibited"
        )
    }

    companion object {
        val ISSUE = Issue.create(
            id = "AppCompatActivityUsageError",
            briefDescription = "The AppCompatActivity should not be used",
            explanation = "The AppCompatActivity should not be used, use BaseActivity instead.",
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.ERROR,
            implementation = Implementation(BaseActivityDetector::class.java, Scope.JAVA_FILE_SCOPE)
        ).setAndroidSpecific(true)
    }

}
