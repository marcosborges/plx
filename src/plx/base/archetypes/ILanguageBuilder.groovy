package plx.base.archetypes

interface ILanguageBuilder {
    String name = ""
    String dockerfile = null
    Map args = [:]
    Map env = [:]
}