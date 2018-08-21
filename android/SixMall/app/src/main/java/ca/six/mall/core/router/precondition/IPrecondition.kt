package ca.six.mall.core.router.precondition

interface IPrecondition {
    fun isMatching(): FilterResult
}