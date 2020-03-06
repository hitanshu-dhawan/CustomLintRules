package com.hitanshudhawan.lint_rules.registry

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.hitanshudhawan.lint_rules.MyLogDetector
import com.hitanshudhawan.lint_rules.MyTextViewDetector

class IssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            MyLogDetector.ISSUE,
            MyTextViewDetector.ISSUE
        )

    override val api: Int = CURRENT_API

}
