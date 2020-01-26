package com.hitanshudhawan.lint_rules

import com.android.tools.lint.detector.api.*
import org.w3c.dom.Element

class MyTextViewDetector : Detector(), XmlScanner {

    override fun getApplicableElements(): Collection<String> {
        return listOf("TextView")
    }

    override fun visitElement(context: XmlContext, element: Element) {

        val quickfixData = LintFix.create()
            .name("Use MyTextView")
            .replace()
            .text("TextView")
            .with("com.hitanshudhawan.library.MyTextView")
            .robot(true)
            .independent(true)
            .build()

        context.report(
            issue = ISSUE,
            location = context.getNameLocation(element),
            message = "Usage of android TextView is prohibited",
            quickfixData = quickfixData
        )
    }

    companion object {
        val ISSUE = Issue.create(
            id = "TextViewUsageWarning",
            briefDescription = "The android TextView should not be used",
            explanation = "The android TextView should not be used, use MyTextView instead.",
            category = Category.CORRECTNESS,
            priority = 3,
            severity = Severity.WARNING,
            implementation = Implementation(MyTextViewDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        ).setAndroidSpecific(true)
    }

}
